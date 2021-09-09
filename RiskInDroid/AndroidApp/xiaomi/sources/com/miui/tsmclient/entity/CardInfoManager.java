package com.miui.tsmclient.entity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.miui.tsmclient.database.a;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.BaseModel;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.BaseTransitCardModel;
import com.miui.tsmclient.model.a.b;
import com.miui.tsmclient.model.d;
import com.miui.tsmclient.model.g;
import com.miui.tsmclient.model.i;
import com.miui.tsmclient.model.j;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ObjectUtils;
import com.miui.tsmclient.util.PrefUtils;
import com.miui.tsmclient.util.SettingKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CardInfoManager {
    private static final Object mContent = new Object();
    private static volatile CardInfoManager sInstance;
    private b mBankCardOperation;
    private d mCacheModel;
    private Context mContext;
    public int mDiskWritesInFlight = 0;
    private Executor mExecutor;
    public Handler mHandler;
    public List<CardInfo> mList;
    public final WeakHashMap<OnCardChangedListener, Object> mListeners = new WeakHashMap<>();
    private boolean mLoaded;
    private BaseTransitCardModel mTransitCardModel;
    public final Object mWritingToDiskLock = new Object();

    public interface CacheLauncher {
        void startBuildingCache();
    }

    final class Editor {
        private boolean mClear;
        private final Map<CardInfo, Object> mModified;

        private Editor() {
            this.mModified = new ModifiedMap();
            this.mClear = false;
        }

        private MemoryCommitResult commitToMemory() {
            MemoryCommitResult memoryCommitResult = new MemoryCommitResult();
            synchronized (CardInfoManager.this) {
                CardInfoManager.this.mList = new ArrayList(CardInfoManager.this.mList);
                CardInfoManager.this.mDiskWritesInFlight++;
                memoryCommitResult.mMapToWriteToDisk = new ModifiedMap();
                synchronized (this) {
                    if (this.mClear) {
                        if (!CardInfoManager.this.mList.isEmpty()) {
                            memoryCommitResult.mChangesMade = true;
                            for (CardInfo put : CardInfoManager.this.mList) {
                                memoryCommitResult.mMapToWriteToDisk.put(put, null);
                            }
                            CardInfoManager.this.mList.clear();
                        }
                        this.mClear = false;
                    }
                    for (Map.Entry next : this.mModified.entrySet()) {
                        CardInfo cardInfo = (CardInfo) next.getKey();
                        Object value = next.getValue();
                        if (value == null) {
                            if (CardInfoManager.this.mList.contains(cardInfo)) {
                                memoryCommitResult.mMapToWriteToDisk.put(cardInfo, null);
                                CardInfoManager.this.mList.remove(cardInfo);
                            }
                        } else if (cardInfo.mCardType == null || !cardInfo.mCardType.startsWith("DUMMY")) {
                            memoryCommitResult.mMapToWriteToDisk.put(cardInfo, value);
                            int indexOf = CardInfoManager.this.mList.indexOf(cardInfo);
                            if (indexOf >= 0) {
                                CardInfoManager.this.mList.set(indexOf, cardInfo);
                            } else {
                                CardInfoManager.this.mList.add(cardInfo);
                            }
                        } else if ((value instanceof String) && !CardInfoManager.this.mList.isEmpty()) {
                            String str = (String) value;
                            Iterator<CardInfo> it = CardInfoManager.this.mList.iterator();
                            while (it.hasNext()) {
                                CardInfo next2 = it.next();
                                if (str.equals(next2.mCardType)) {
                                    memoryCommitResult.mMapToWriteToDisk.put(next2, null);
                                    it.remove();
                                }
                            }
                        }
                        memoryCommitResult.mChangesMade = true;
                    }
                    this.mModified.clear();
                }
            }
            return memoryCommitResult;
        }

        public final void apply() {
            final MemoryCommitResult commitToMemory = commitToMemory();
            CardInfoManager.this.enqueueDiskWrite(commitToMemory, new Runnable() {
                /* class com.miui.tsmclient.entity.CardInfoManager.Editor.AnonymousClass1 */

                public void run() {
                    try {
                        commitToMemory.mWrittenToDiskLatch.await();
                    } catch (InterruptedException unused) {
                    }
                }
            });
            notifyListeners(commitToMemory);
        }

        public final Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        public final boolean commit() {
            MemoryCommitResult commitToMemory = commitToMemory();
            CardInfoManager.this.enqueueDiskWrite(commitToMemory, null);
            try {
                commitToMemory.mWrittenToDiskLatch.await();
                notifyListeners(commitToMemory);
                return commitToMemory.mWriteToDiskResult;
            } catch (InterruptedException unused) {
                return false;
            }
        }

        public final void notifyListeners(final MemoryCommitResult memoryCommitResult) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                CardInfoManager.this.initSecureSettings();
                Set<OnCardChangedListener> keySet = CardInfoManager.this.mListeners.keySet();
                if (!keySet.isEmpty() && !memoryCommitResult.mMapToWriteToDisk.isEmpty()) {
                    for (Map.Entry next : memoryCommitResult.mMapToWriteToDisk.entrySet()) {
                        for (OnCardChangedListener next2 : keySet) {
                            if (next2 != null) {
                                CardInfo cardInfo = (CardInfo) next.getKey();
                                if (next.getValue() == null) {
                                    next2.onCardUpdated(cardInfo);
                                } else {
                                    next2.onCardRemoved(cardInfo);
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            }
            CardInfoManager.this.mHandler.post(new Runnable() {
                /* class com.miui.tsmclient.entity.CardInfoManager.Editor.AnonymousClass2 */

                public void run() {
                    Editor.this.notifyListeners(memoryCommitResult);
                }
            });
        }

        public final Editor put(CardInfo cardInfo) {
            synchronized (this) {
                if (CardGroupType.TRANSCARD.getId() == cardInfo.mCardGroupId) {
                    this.mModified.put(cardInfo, cardInfo);
                } else {
                    List<CardInfo> list = CardInfoManager.this.parseList(CardInfoManager.this.mList).get(CardGroupType.newInstance(cardInfo.mCardGroupId));
                    list.remove(cardInfo);
                    list.add(cardInfo);
                    for (CardInfo cardInfo2 : list) {
                        this.mModified.put(cardInfo2, cardInfo2);
                    }
                }
            }
            return this;
        }

        public final Editor put(List<? extends CardInfo> list) {
            if (ObjectUtils.isCollectionEmpty(list)) {
                return this;
            }
            synchronized (this) {
                for (CardInfo cardInfo : list) {
                    this.mModified.put(cardInfo, cardInfo);
                }
            }
            return this;
        }

        public final Editor remove(CardInfo cardInfo) {
            synchronized (this) {
                this.mModified.put(cardInfo, null);
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(new CardInfo("DUMMY".concat(String.valueOf(str))), str);
            }
            return this;
        }
    }

    static class MemoryCommitResult {
        boolean mChangesMade;
        Map<CardInfo, Object> mMapToWriteToDisk;
        volatile boolean mWriteToDiskResult;
        final CountDownLatch mWrittenToDiskLatch;

        private MemoryCommitResult() {
            this.mWriteToDiskResult = false;
            this.mWrittenToDiskLatch = new CountDownLatch(1);
        }

        /* access modifiers changed from: package-private */
        public void setDiskWriteResult(boolean z) {
            this.mWriteToDiskResult = z;
            this.mWrittenToDiskLatch.countDown();
        }
    }

    class ModifiedMap extends LinkedHashMap<CardInfo, Object> {
        private ModifiedMap() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.HashMap.put(java.lang.Object, java.lang.Object):V}
         arg types: [com.miui.tsmclient.entity.CardInfo, java.lang.Object]
         candidates:
          com.miui.tsmclient.entity.CardInfoManager.ModifiedMap.put(com.miui.tsmclient.entity.CardInfo, java.lang.Object):java.lang.Object
          ClspMth{java.util.HashMap.put(java.lang.Object, java.lang.Object):V} */
        public Object put(CardInfo cardInfo, Object obj) {
            remove(cardInfo);
            return super.put((Object) cardInfo, obj);
        }
    }

    public interface OnCardChangedListener {
        void onCardRemoved(CardInfo cardInfo);

        void onCardUpdated(CardInfo cardInfo);
    }

    private CardInfoManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLoaded = false;
        this.mList = null;
        this.mCacheModel = (d) BaseModel.create(this.mContext, d.class);
        this.mTransitCardModel = (BaseTransitCardModel) BaseModel.create(this.mContext, BaseTransitCardModel.class);
        this.mBankCardOperation = new b();
        startLoadFromDisk();
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void checkNotMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("Can't call it on main thread");
        }
    }

    private Editor edit() {
        synchronized (this) {
            awaitLoadedLocked();
        }
        return new Editor();
    }

    public static CardInfoManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CardInfoManager.class) {
                if (sInstance == null) {
                    sInstance = new CardInfoManager(context);
                }
            }
        }
        return sInstance;
    }

    private BaseResponse getResponseAndRemove(CardInfo cardInfo, BaseResponse baseResponse) {
        if (baseResponse == null) {
            baseResponse = new BaseResponse(-2, new Object[0]);
        }
        if (baseResponse.isSuccess()) {
            edit().remove(cardInfo).commit();
        }
        return baseResponse;
    }

    private BaseResponse getResponseAndUpdate(CardInfo cardInfo, BaseResponse baseResponse) {
        if (baseResponse == null) {
            baseResponse = new BaseResponse(-2, new Object[0]);
        }
        if (baseResponse.isSuccess()) {
            updateCards(cardInfo);
        }
        return baseResponse;
    }

    private boolean lazyLoad(CacheLauncher cacheLauncher, boolean z) {
        if (cacheLauncher == null || z) {
            return false;
        }
        cacheLauncher.startBuildingCache();
        return true;
    }

    private void saveKeepActivatedCards() {
        List<CardInfo> keepActivatedCards = getKeepActivatedCards();
        StringBuilder sb = new StringBuilder();
        for (CardInfo cardInfo : keepActivatedCards) {
            sb.append(cardInfo.mAid);
            sb.append("|");
        }
        SettingKeys.putSecureString(this.mContext, "keep_activated_card_aids", sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "");
    }

    private void saveTotalCount() {
        SettingKeys.putSecureInt(this.mContext, "issued_card_count", getIssuedTransCardsCount() + getBankCardsCount() + getQRBankCardsCount() + getMifareCardsCount() + getEidCardsCount());
    }

    private void sendCardChangedBroadcast(String str, String str2) {
        if (this.mContext != null) {
            Intent intent = new Intent("com.miui.tsmclient.action.CARD_CHANGED");
            intent.setPackage("com.miui.tsmclient");
            intent.putExtra("operation", str2);
            intent.putExtra("aid", str);
            this.mContext.sendBroadcast(intent, "com.miui.tsmclient.permission.TSM_GROUP");
        }
    }

    private void startLoadFromDisk() {
        LogUtils.d("startLoadFromDisk");
        synchronized (this) {
            this.mLoaded = false;
        }
        new Thread("CardManager startLoadFromLocal") {
            /* class com.miui.tsmclient.entity.CardInfoManager.AnonymousClass1 */

            public void run() {
                CardInfoManager.this.loadFromDisk();
            }
        }.start();
    }

    private BaseResponse updateTransCard(CardInfo cardInfo) {
        checkNotMainThread();
        CardInfo transCard = getTransCard(null, cardInfo);
        try {
            List<CardInfo> cardsFromNetwork = this.mTransitCardModel.getCardsFromNetwork(cardInfo);
            if (!cardsFromNetwork.isEmpty()) {
                transCard = cardsFromNetwork.get(0);
            }
        } catch (AuthApiException e) {
            LogUtils.e("failed to update card info from network, code = " + e.mErrorCode + ", msg = " + e.mErrorMsg, e);
        }
        if (transCard != null) {
            transCard.updateInfo(cardInfo);
            cardInfo.parse(transCard.serialize());
        }
        BaseResponse updateTransCardFormSe = updateTransCardFormSe(cardInfo);
        if (updateTransCardFormSe.isSuccess() || updateTransCardFormSe.isNotExist()) {
            edit().put(cardInfo).commit();
            saveTotalCount();
        }
        return updateTransCardFormSe;
    }

    private BaseResponse updateTransCardFormSe(CardInfo cardInfo) {
        if (!cardInfo.mHasIssue) {
            LogUtils.d("skip updating card:" + cardInfo.mCardType);
            return new BaseResponse(2003, new Object[0]);
        }
        BaseResponse a2 = g.a(cardInfo.mCardType).a(this.mContext, cardInfo, null);
        cardInfo.mDataSource = CardInfo.DataSource.SE;
        LogUtils.d("after read ese, got card " + cardInfo.mCardName + ", aid:" + cardInfo.mAid + ", status:" + cardInfo.mStatus + ", isReadSECorrectly:" + cardInfo.mIsReadSECorrectly + ", pid:" + Thread.currentThread().getId() + ", response:" + a2.mResultCode);
        return a2;
    }

    private BaseResponse updateTransCards() {
        checkNotMainThread();
        try {
            List<CardInfo> cardsFromNetwork = this.mTransitCardModel.getCardsFromNetwork(null);
            if (cardsFromNetwork == null || cardsFromNetwork.isEmpty()) {
                return new BaseResponse(0, new Object[0]);
            }
            for (CardInfo next : cardsFromNetwork) {
                if (Thread.currentThread().isInterrupted()) {
                    return new BaseResponse(11, new Object[0]);
                }
                updateTransCardFormSe(next);
            }
            edit().put(cardsFromNetwork).commit();
            return new BaseResponse(0, new Object[0]);
        } catch (AuthApiException e) {
            LogUtils.e("failed to get cards from network, code = " + e.mErrorCode + ", msg = " + e.mErrorMsg, e);
            return new BaseResponse(e.mErrorCode, e.mErrorMsg, new Object[0]);
        }
    }

    public void clear() {
        edit().clear().commit();
    }

    public BaseResponse deleteBankCards() {
        checkNotMainThread();
        BaseResponse a2 = this.mBankCardOperation.a(this.mContext);
        if (a2 == null) {
            a2 = new BaseResponse(-2, new Object[0]);
        }
        if (a2.isSuccess()) {
            edit().remove("BANKCARD").commit();
        }
        return a2;
    }

    public BaseResponse deleteCard(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        BaseResponse c = g.a(cardInfo.mCardType).c(this.mContext, cardInfo, bundle);
        if (c != null && c.isSuccess()) {
            sendCardChangedBroadcast(cardInfo.mAid, "delete");
        }
        return getResponseAndRemove(cardInfo, c);
    }

    public void enqueueDiskWrite(final MemoryCommitResult memoryCommitResult, final Runnable runnable) {
        AnonymousClass2 r0 = new Runnable() {
            /* class com.miui.tsmclient.entity.CardInfoManager.AnonymousClass2 */

            public void run() {
                synchronized (CardInfoManager.this.mWritingToDiskLock) {
                    CardInfoManager.this.writeToFile(memoryCommitResult);
                }
                synchronized (this) {
                    CardInfoManager cardInfoManager = CardInfoManager.this;
                    cardInfoManager.mDiskWritesInFlight--;
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        };
        boolean z = false;
        if (runnable == null) {
            synchronized (this) {
                if (this.mDiskWritesInFlight == 1) {
                    z = true;
                }
            }
            if (z) {
                r0.run();
                return;
            }
        }
        this.mExecutor.execute(r0);
    }

    public List<CardInfo> getAll(CacheLauncher cacheLauncher) {
        ArrayList arrayList;
        synchronized (this) {
            awaitLoadedLocked();
            arrayList = new ArrayList();
            if (cacheLauncher == null || isSanity(cacheLauncher)) {
                for (CardInfo copy : new ArrayList(this.mList)) {
                    arrayList.add(copy.copy());
                }
            }
        }
        return arrayList;
    }

    public List<CardInfo> getBankCards(CacheLauncher cacheLauncher) {
        return parseList(getAll(cacheLauncher)).get(CardGroupType.BANKCARD);
    }

    public int getBankCardsCount() {
        return getBankCards(null).size();
    }

    public CardInfo getCardInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<CardInfo> issuedTransCards = getIssuedTransCards(null);
        issuedTransCards.addAll(getMifareCards(null));
        issuedTransCards.addAll(getBankCards(null));
        for (CardInfo next : issuedTransCards) {
            if (next.isAid(str)) {
                return next;
            }
        }
        return null;
    }

    public List<CardInfo> getEidCards(CacheLauncher cacheLauncher) {
        return parseList(getAll(cacheLauncher)).get(CardGroupType.EIDCARD);
    }

    public int getEidCardsCount() {
        return getEidCards(null).size();
    }

    public int getIssuedCardCount() {
        if (this.mCacheModel.a()) {
            return getIssuedTransCardsCount() + getBankCardsCount() + getQRBankCardsCount() + getMifareCardsCount() + getEidCardsCount();
        }
        try {
            return SettingKeys.getSecureInt(this.mContext, "issued_card_count");
        } catch (Settings.SettingNotFoundException unused) {
            return 0;
        }
    }

    public List<CardInfo> getIssuedTransCards(CacheLauncher cacheLauncher) {
        List<CardInfo> transCards = getTransCards(cacheLauncher);
        ArrayList arrayList = new ArrayList();
        for (CardInfo next : transCards) {
            if (next.mHasIssue) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getIssuedTransCardsCount() {
        return getIssuedTransCards(null).size();
    }

    public List<CardInfo> getKeepActivatedCards() {
        ArrayList arrayList = new ArrayList();
        for (CardInfo next : getMifareCards(null)) {
            if (next.isKeepActivated()) {
                arrayList.add(next);
            }
        }
        if (ObjectUtils.isCollectionEmpty(arrayList)) {
            String secureString = SettingKeys.getSecureString(this.mContext, "keep_activated_card_aids");
            if (!TextUtils.isEmpty(secureString)) {
                for (String str : secureString.split("\\|")) {
                    CardInfo cardInfo = new CardInfo("DUMMY");
                    cardInfo.mAid = str;
                    cardInfo.setKeepActivated(true);
                    arrayList.add(cardInfo);
                }
            }
        }
        return arrayList;
    }

    public List<CardInfo> getMifareCards(CacheLauncher cacheLauncher) {
        return parseList(getAll(cacheLauncher)).get(CardGroupType.MIFARECARD);
    }

    public int getMifareCardsCount() {
        return getMifareCards(null).size();
    }

    public int getQRBankCardsCount() {
        return getQrBankCards(null).size();
    }

    public List<CardInfo> getQrBankCards(CacheLauncher cacheLauncher) {
        return parseList(getAll(cacheLauncher)).get(CardGroupType.QRBANKCARD);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    public CardInfo getTransCard(CacheLauncher cacheLauncher, CardInfo cardInfo) {
        if (cardInfo == null) {
            return null;
        }
        for (CardInfo cardInfo2 : parseList(getAll(cacheLauncher)).get(CardGroupType.TRANSCARD)) {
            if (TextUtils.equals(cardInfo.mCardType, cardInfo2.mCardType) || TextUtils.equals(cardInfo.mAid, cardInfo2.mAid)) {
                return cardInfo2;
            }
            while (r5.hasNext()) {
            }
        }
        return null;
    }

    public CardInfo getTransCard(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (CardInfo next : getTransCards(null)) {
            if (TextUtils.equals(next.mCardType, str)) {
                return next;
            }
        }
        return null;
    }

    public List<CardInfo> getTransCards(CacheLauncher cacheLauncher) {
        return parseList(getAll(cacheLauncher)).get(CardGroupType.TRANSCARD);
    }

    public boolean hasCard() {
        return getIssuedTransCardsCount() > 0 || getBankCardsCount() > 0 || getMifareCardsCount() > 0 || getEidCardsCount() > 0 || getQRBankCardsCount() > 0;
    }

    public void initSecureSettings() {
        if (!getQrBankCards(null).isEmpty() || !getBankCards(null).isEmpty() || !getMifareCards(null).isEmpty() || !getEidCards(null).isEmpty()) {
            PrefUtils.putSecureSettings(this.mContext, "key_bank_card_in_ese", 1);
        } else {
            PrefUtils.putSecureSettings(this.mContext, "key_bank_card_in_ese", 0);
        }
        PrefUtils.putSecureSettings(this.mContext, "key_trans_card_in_ese", getIssuedTransCards(null).isEmpty() ^ true ? 1 : 0);
    }

    public boolean isSanity(CacheLauncher cacheLauncher) {
        boolean a2 = this.mCacheModel.a();
        lazyLoad(cacheLauncher, a2);
        return a2;
    }

    public BaseResponse issue(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        BaseResponse b = g.a(cardInfo.mCardType).b(this.mContext, cardInfo, bundle);
        if (b != null && b.isSuccess()) {
            sendCardChangedBroadcast(cardInfo.mAid, "add");
        }
        return getResponseAndUpdate(cardInfo, b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3.mLoaded = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r1 == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        r3.mList = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        r3.mList = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        initSecureSettings();
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0008, code lost:
        r1 = null;
        r0 = com.miui.tsmclient.database.a.a(r3.mContext, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (com.miui.tsmclient.util.ObjectUtils.isCollectionEmpty(r0) != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r1 = new java.util.ArrayList(r0);
     */
    public void loadFromDisk() {
        synchronized (this) {
            if (this.mLoaded) {
            }
        }
    }

    public Map<CardGroupType, List<CardInfo>> parseList(List<CardInfo> list) {
        HashMap hashMap = new HashMap();
        for (CardGroupType put : CardGroupType.values()) {
            hashMap.put(put, new ArrayList());
        }
        if (list == null) {
            return hashMap;
        }
        for (CardInfo next : list) {
            CardGroupType[] values = CardGroupType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                CardGroupType cardGroupType = values[i];
                if (cardGroupType.getId() == next.mCardGroupId) {
                    ((List) hashMap.get(cardGroupType)).add(next);
                    break;
                }
                i++;
            }
        }
        return hashMap;
    }

    public BaseResponse processCard(CardInfo cardInfo) {
        checkNotMainThread();
        BaseResponse a2 = g.a(cardInfo.mCardType).a(this.mContext, cardInfo);
        cardInfo.mDataSource = CardInfo.DataSource.SE;
        if (a2 == null) {
            a2 = new BaseResponse(-2, new Object[0]);
        }
        edit().put(cardInfo).commit();
        return a2;
    }

    public void put(CardInfo cardInfo) {
        edit().put(cardInfo).apply();
    }

    public void put(List<? extends CardInfo> list) {
        edit().put(list).apply();
    }

    public BaseResponse recharge(CardInfo cardInfo) {
        return recharge(cardInfo, null);
    }

    public BaseResponse recharge(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        boolean z = true;
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        if (!(cardInfo instanceof PayableCardInfo)) {
            return new BaseResponse(1, new Object[0]);
        }
        PayableCardInfo payableCardInfo = (PayableCardInfo) cardInfo;
        OrderInfo rechargeOrder = payableCardInfo.getRechargeOrder();
        if (bundle == null || !bundle.getBoolean("out_operation")) {
            z = false;
        }
        if (rechargeOrder == null && !z) {
            return new BaseResponse(0, new Object[0]);
        }
        i a2 = g.a(cardInfo.mCardType);
        BaseResponse baseResponse = null;
        if (a2 instanceof j) {
            baseResponse = ((j) a2).a(this.mContext, payableCardInfo, rechargeOrder, null, bundle);
        }
        return getResponseAndUpdate(cardInfo, baseResponse);
    }

    public void registerOnCardChangedListener(OnCardChangedListener onCardChangedListener) {
        synchronized (this) {
            this.mListeners.put(onCardChangedListener, mContent);
        }
    }

    public void remove(CardInfo cardInfo) {
        edit().remove(cardInfo).apply();
    }

    public void remove(String str) {
        edit().remove(str).apply();
    }

    public BaseResponse returnCard(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        if (cardInfo instanceof PayableCardInfo) {
            ((PayableCardInfo) cardInfo).setHasUncompletedBusiness(true);
            put(cardInfo);
        }
        BaseResponse f = g.a(cardInfo.mCardType).f(this.mContext, cardInfo, bundle);
        if (f != null && f.isSuccess()) {
            sendCardChangedBroadcast(cardInfo.mAid, "delete");
        }
        return getResponseAndRemove(cardInfo, f);
    }

    public BaseResponse transferIn(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        BaseResponse g = g.a(cardInfo.mCardType).g(this.mContext, cardInfo, bundle);
        if (g != null && g.isSuccess()) {
            sendCardChangedBroadcast(cardInfo.mAid, "add");
        }
        return getResponseAndUpdate(cardInfo, g);
    }

    public BaseResponse transferOut(CardInfo cardInfo, Bundle bundle) {
        checkNotMainThread();
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        if (cardInfo instanceof PayableCardInfo) {
            ((PayableCardInfo) cardInfo).setHasUncompletedBusiness(true);
            put(cardInfo);
        }
        BaseResponse e = g.a(cardInfo.mCardType).e(this.mContext, cardInfo, bundle);
        if (e != null && e.isSuccess()) {
            sendCardChangedBroadcast(cardInfo.mAid, "delete");
        }
        return getResponseAndRemove(cardInfo, e);
    }

    public void unregisterOnCardChangedListener(OnCardChangedListener onCardChangedListener) {
        synchronized (this) {
            this.mListeners.remove(onCardChangedListener);
        }
    }

    public BaseResponse updateCards(CardGroupType cardGroupType) {
        checkNotMainThread();
        if (CardGroupType.TRANSCARD == cardGroupType) {
            return updateTransCards();
        }
        CardInfo bankCardInfo = new BankCardInfo();
        if (CardGroupType.QRBANKCARD == cardGroupType) {
            bankCardInfo = new QrBankCardInfo();
        }
        if (CardGroupType.MIFARECARD == cardGroupType) {
            bankCardInfo = new MifareCardInfo();
        }
        if (CardGroupType.EIDCARD == cardGroupType) {
            bankCardInfo = new EidCardInfo();
        }
        return updateCards(bankCardInfo);
    }

    public BaseResponse updateCards(CardInfo cardInfo) {
        checkNotMainThread();
        boolean isEmpty = TextUtils.isEmpty(cardInfo.mAid);
        LogUtils.d("updateCards: " + cardInfo.mCardType + ", isUpdateAll=" + isEmpty);
        if (cardInfo.isTransCard()) {
            return updateTransCard(cardInfo);
        }
        BaseResponse a2 = g.a(cardInfo.mCardType).a(this.mContext, cardInfo);
        if (a2 == null) {
            a2 = new BaseResponse(-2, new Object[0]);
        }
        if (a2.isSuccess()) {
            Editor edit = edit();
            if (a2.mDatas == null || a2.mDatas.length <= 0) {
                edit.put(cardInfo);
            } else {
                List list = (List) a2.mDatas[0];
                if (isEmpty) {
                    edit.remove(cardInfo.mCardType);
                }
                if (!ObjectUtils.isCollectionEmpty(list)) {
                    edit.put(list);
                }
            }
            edit.commit();
            saveTotalCount();
            saveKeepActivatedCards();
        }
        return a2;
    }

    public void writeToFile(MemoryCommitResult memoryCommitResult) {
        if (!memoryCommitResult.mChangesMade) {
            memoryCommitResult.setDiskWriteResult(true);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : memoryCommitResult.mMapToWriteToDisk.entrySet()) {
            CardInfo cardInfo = (CardInfo) next.getKey();
            if (cardInfo != null) {
                if (next.getValue() == null) {
                    a.b(this.mContext, cardInfo);
                } else {
                    arrayList.add(cardInfo);
                }
            }
        }
        Map<CardGroupType, List<CardInfo>> parseList = parseList(arrayList);
        for (Map.Entry<CardGroupType, List<CardInfo>> key : parseList.entrySet()) {
            CardGroupType cardGroupType = (CardGroupType) key.getKey();
            List<CardInfo> list = parseList.get(cardGroupType);
            if (!ObjectUtils.isCollectionEmpty(list)) {
                if (cardGroupType == CardGroupType.TRANSCARD) {
                    for (CardInfo a2 : list) {
                        a.a(this.mContext, a2);
                    }
                } else {
                    a.a(this.mContext, list, ((CardInfo) list.get(0)).mCardType);
                }
            }
        }
        memoryCommitResult.setDiskWriteResult(true);
    }
}

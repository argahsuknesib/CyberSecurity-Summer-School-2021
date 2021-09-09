package com.miui.tsmclient.sesdk;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.g;
import com.miui.tsmclient.model.i;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.a;
import com.tsmclient.smartcard.model.TradeLog;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SeCard {
    private String mAid;
    protected String mCardFace;
    public CardInfo mCardInfo;
    protected String mCardName;
    protected i mCardOperation;
    private String mCardType;
    protected String mChannel;
    protected String mCityId;
    protected Bundle mExtras;
    protected boolean mIsIssued;
    private IOnlineProperties mOnlineProperties;
    protected String mProductId;
    protected SeData mSeData;
    protected TSMAuthManager mTSMAuthManager;

    public interface IOnlineProperties {
        String getDescription();

        String getDescriptions();

        String getLabel();

        String getServiceStatus();

        String getTips();

        boolean isServiceAvailable();
    }

    public static class OnlineProperties implements IOnlineProperties {
        private IOnlineProperties mOnlinePropertiesImpl;

        private OnlineProperties(IOnlineProperties iOnlineProperties) {
            this.mOnlinePropertiesImpl = iOnlineProperties;
        }

        public String getDescription() {
            return this.mOnlinePropertiesImpl.getDescription();
        }

        public String getDescriptions() {
            return this.mOnlinePropertiesImpl.getDescriptions();
        }

        public String getLabel() {
            return this.mOnlinePropertiesImpl.getLabel();
        }

        public String getServiceStatus() {
            return this.mOnlinePropertiesImpl.getServiceStatus();
        }

        public String getTips() {
            return this.mOnlinePropertiesImpl.getTips();
        }

        public boolean isServiceAvailable() {
            return this.mOnlinePropertiesImpl.isServiceAvailable();
        }
    }

    public static class SeData {
        public final int balance;
        public final String cardNumber;
        private final boolean isIssued;
        public final String logicalCardNumber;
        private final CardInfo.Status mStatus;
        private int mVcStatus;
        public final List<TradeLog> tradeLogs;
        public final String validEndDate;
        public final String validStartDate;

        public SeData(CardInfo cardInfo) {
            this(cardInfo, -1);
        }

        public SeData(CardInfo cardInfo, int i) {
            int i2 = 0;
            this.isIssued = cardInfo != null && cardInfo.mHasIssue;
            CardInfo.Status status = null;
            this.cardNumber = cardInfo != null ? cardInfo.mCardNo : null;
            this.logicalCardNumber = cardInfo != null ? cardInfo.mRealCardNo : null;
            this.validStartDate = cardInfo != null ? cardInfo.mStartDate : null;
            this.validEndDate = cardInfo != null ? cardInfo.mEndDate : null;
            this.balance = cardInfo != null ? cardInfo.mCardBalance : i2;
            this.tradeLogs = cardInfo != null ? cardInfo.mTradeLogs : null;
            this.mStatus = cardInfo != null ? cardInfo.mStatus : status;
            this.mVcStatus = i;
        }

        public int getBalance() {
            return this.balance;
        }

        public String getCardNumber() {
            return this.cardNumber;
        }

        public String getLogicalCardNumber() {
            return this.logicalCardNumber;
        }

        public SeCardStatus getStatus() {
            if (this.isIssued) {
                int i = this.mVcStatus;
                if (i != -1) {
                    return i > SeCardStatus.values().length - 1 ? SeCardStatus.NEGATIVE : SeCardStatus.values()[this.mVcStatus];
                }
                if (this.mStatus == CardInfo.Status.LOCKED) {
                    return SeCardStatus.LOCKED;
                }
                if (this.mStatus == CardInfo.Status.IN_BLACKLIST) {
                    return SeCardStatus.IN_BLACKLIST;
                }
                if (this.mStatus == CardInfo.Status.DATA_ILLEGAL) {
                    return SeCardStatus.DATA_ILLEGAL;
                }
                if (this.mStatus == CardInfo.Status.INVALID) {
                    return SeCardStatus.INVALID;
                }
                if (this.mStatus == CardInfo.Status.NEGATIVE) {
                    return SeCardStatus.INVALID;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
                Date date = new Date();
                if (!TextUtils.isEmpty(this.validStartDate)) {
                    try {
                        if (date.before(simpleDateFormat.parse(this.validStartDate))) {
                            return SeCardStatus.START_DATE_INVALID;
                        }
                    } catch (ParseException e) {
                        LogUtils.e("parse start date failed.", e);
                    }
                }
                if (!TextUtils.isEmpty(this.validEndDate)) {
                    try {
                        Date parse = simpleDateFormat.parse(this.validEndDate);
                        Calendar instance = Calendar.getInstance();
                        instance.setTime(parse);
                        instance.add(5, 1);
                        if (date.after(instance.getTime())) {
                            return SeCardStatus.END_DATE_INVALID;
                        }
                    } catch (ParseException e2) {
                        LogUtils.e("parse end date failed.", e2);
                    }
                }
                return SeCardStatus.ACTIVE;
            }
            throw new IllegalStateException("not exist");
        }

        public List<TradeLog> getTradeLogs() {
            return this.tradeLogs;
        }

        public String getValidEndDate() {
            return this.validEndDate;
        }

        public String getValidStartDate() {
            return this.validStartDate;
        }
    }

    protected SeCard(CardInfo cardInfo) {
        this(cardInfo, false);
    }

    protected SeCard(CardInfo cardInfo, boolean z) {
        this.mTSMAuthManager = new TSMAuthManager();
        this.mExtras = new Bundle();
        this.mIsIssued = z;
        this.mChannel = EnvironmentConfig.getContext().getPackageName();
        this.mCardInfo = cardInfo;
        cloneCard(cardInfo);
        this.mCardOperation = g.a(this.mCardType);
    }

    public BaseResponse activate(String str) {
        throw new NotSupportedException();
    }

    public boolean activate() {
        return a.b(EnvironmentConfig.getContext(), this.mCardInfo);
    }

    public void addExtras(Bundle bundle) {
        this.mExtras.putAll(bundle);
    }

    /* access modifiers changed from: protected */
    public Bundle buildExtras(String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.mProductId)) {
            bundle.putString("extra_door_card_product_id", this.mProductId);
        }
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            LogUtils.v("param is a token");
        }
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object obj = jSONObject.get(next);
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(next, ((Integer) obj).intValue());
                    } else {
                        bundle.putString(next, obj.toString());
                    }
                } catch (JSONException unused2) {
                }
            }
        } else {
            bundle.putString("authentication_code", str);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void cloneCard(CardInfo cardInfo) {
        this.mAid = cardInfo.mAid;
        this.mCardType = cardInfo.mCardType;
        if (!TextUtils.isEmpty(this.mCardType)) {
            this.mCardName = cardInfo.mCardName;
            cloneExtraCardInfo();
            return;
        }
        throw new InvalidParameterException("card type can't be empty");
    }

    /* access modifiers changed from: protected */
    public abstract void cloneExtraCardInfo();

    /* access modifiers changed from: protected */
    public abstract IOnlineProperties createOnlineProperties();

    public boolean deactivate() {
        return a.c(EnvironmentConfig.getContext(), this.mCardInfo);
    }

    public BaseResponse delete(String str) {
        throw new NotSupportedException();
    }

    /* access modifiers changed from: protected */
    public void ensureNotOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to anr");
        }
    }

    public String getAid() {
        return this.mAid;
    }

    public String getCardFace() {
        return this.mCardFace;
    }

    public List<SeCard> getCardList() throws AuthApiException {
        throw new NotSupportedException();
    }

    public abstract CardCategory getCategory();

    public SeData getContent() {
        throw new NotSupportedException();
    }

    public String getDetail() {
        throw new NotSupportedException();
    }

    public int getExtraFlag() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return !TextUtils.isEmpty(this.mProductId) ? this.mProductId : this.mCardType;
    }

    public String getName() {
        return this.mCardName;
    }

    public OnlineProperties getOnlineProperties() {
        if (this.mOnlineProperties == null) {
            this.mOnlineProperties = createOnlineProperties();
        }
        return new OnlineProperties(this.mOnlineProperties);
    }

    public OrderData getOrderData() {
        throw new NotSupportedException();
    }

    public ServiceProtocolData getServiceProtocolData() throws IOException {
        throw new NotSupportedException();
    }

    public boolean isGroup() {
        return false;
    }

    public boolean isIssued() {
        return this.mIsIssued;
    }

    public boolean isSupportReturnCard() {
        throw new NotSupportedException();
    }

    public boolean isSupportTransferOut() {
        throw new NotSupportedException();
    }

    public BaseResponse issue(String str) {
        throw new NotSupportedException();
    }

    public BaseResponse prepare() {
        throw new NotSupportedException();
    }

    public BaseResponse queryPan(String str) {
        throw new NotSupportedException();
    }

    public BaseResponse recharge(String str) {
        throw new NotSupportedException();
    }

    public BaseResponse requestAuthCode() {
        throw new NotSupportedException();
    }

    public BaseResponse returnCard(String str) {
        throw new NotSupportedException();
    }

    /* access modifiers changed from: package-private */
    public void setCardFace(String str) {
        this.mCardFace = str;
    }

    public void setCardName(String str) {
        throw new NotSupportedException();
    }

    public void setCityId(String str) {
        this.mCityId = str;
    }

    public String toString() {
        return "id:" + getId() + ", name:" + getName();
    }

    public BaseResponse transferIn(String str) {
        throw new NotSupportedException();
    }

    public BaseResponse transferOut() {
        throw new NotSupportedException();
    }

    public void updateContent() throws IOException {
        throw new NotSupportedException();
    }
}

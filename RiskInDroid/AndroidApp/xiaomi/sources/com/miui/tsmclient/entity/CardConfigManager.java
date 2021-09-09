package com.miui.tsmclient.entity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.net.request.ConfigListRequest;
import com.miui.tsmclient.net.request.ConfigRulesRequest;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.IOUtils;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ObjectUtils;
import com.miui.tsmclient.util.PrefUtils;
import com.tsmclient.smartcard.model.ConfigRules;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CardConfigManager {
    public static final boolean STAGING = EnvironmentConfig.isStaging();
    private static volatile CardConfigManager sInstance;
    private Context mContext;
    private int mFetchConfigCount;
    private ReentrantLock mLock = new ReentrantLock();
    private Map<String, CardConfig> mSupportedTransCardMap;

    private CardConfigManager(Context context) {
        this.mContext = context;
    }

    public static CardConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (CardConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new CardConfigManager(EnvironmentConfig.getContext());
                }
            }
        }
        return sInstance;
    }

    public List<String> getSupportedTransCardAids() {
        ArrayList arrayList = new ArrayList(getSupportedTransCardMap().keySet());
        LogUtils.d("getSupportedTransCardAids:" + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }

    public List<String> getSupportedTransCardTypes() {
        Map<String, CardConfig> supportedTransCardMap = getSupportedTransCardMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, CardConfig> value : supportedTransCardMap.entrySet()) {
            String str = ((CardConfig) value.getValue()).mCardType;
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        LogUtils.d("getSupportedTransCardTypes:" + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }

    public Map<String, CardConfig> getSupportedTransCardMap() {
        return getSupportedTransCardMap(false);
    }

    public Map<String, CardConfig> getSupportedTransCardMap(boolean z) {
        boolean isMainThread = isMainThread();
        if (!isMainThread) {
            this.mLock.lock();
        }
        try {
            Map<String, CardConfig> map = this.mSupportedTransCardMap;
            if (z || ObjectUtils.isCollectionEmpty(map)) {
                map = fetchCardConfig();
            }
            if (map == null) {
                return Collections.emptyMap();
            }
            if (!isMainThread) {
                this.mSupportedTransCardMap = map;
            }
            if (!isMainThread) {
                this.mLock.unlock();
            }
            return map;
        } finally {
            if (!isMainThread) {
                this.mLock.unlock();
            }
        }
    }

    public String getCardType(String str) {
        CardConfig cardConfig = getCardConfig(str);
        if (cardConfig == null) {
            return null;
        }
        return cardConfig.getCardType();
    }

    public CardConfig.OperationType getOperationType(String str) {
        CardConfig.OperationType operationType;
        CardConfig cardConfigByType = getCardConfigByType(str);
        StringBuilder sb = new StringBuilder("getOperationType cardType:");
        sb.append(str);
        sb.append(", operationType:");
        if (cardConfigByType == null) {
            operationType = null;
        } else {
            operationType = cardConfigByType.mOperationType;
        }
        sb.append(operationType);
        LogUtils.i(sb.toString());
        if (cardConfigByType == null) {
            return null;
        }
        return cardConfigByType.mOperationType;
    }

    public CardConfig getCardConfigByType(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry next : getSupportedTransCardMap().entrySet()) {
                if (str.equals(((CardConfig) next.getValue()).mCardType)) {
                    return (CardConfig) next.getValue();
                }
            }
        }
        return null;
    }

    public CardConfig getCardConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, CardConfig> supportedTransCardMap = getSupportedTransCardMap();
        CardConfig cardConfig = supportedTransCardMap.get(str);
        if (cardConfig != null) {
            return cardConfig;
        }
        for (Map.Entry<String, CardConfig> value : supportedTransCardMap.entrySet()) {
            CardConfig cardConfig2 = (CardConfig) value.getValue();
            if (cardConfig2.isMemberAid(str)) {
                return cardConfig2;
            }
        }
        return cardConfig;
    }

    public void parseCardRulesToBundle(String str, Bundle bundle) {
        ConfigRules localConfigRules;
        if (bundle == null) {
            throw new IllegalArgumentException("readCardOption can't be null");
        } else if (!STAGING || (localConfigRules = getLocalConfigRules(str)) == null) {
            CardConfig cardConfigByType = getCardConfigByType(str);
            if (cardConfigByType != null && !TextUtils.isEmpty(cardConfigByType.mCardRulesUrl)) {
                try {
                    ConfigRules configRules = (ConfigRules) HttpClient.getInstance(this.mContext).execute(new ConfigRulesRequest(cardConfigByType.mCardRulesUrl)).getResult();
                    if (configRules != null) {
                        bundle.putParcelable("KEY_READ_CARD_OPTION_RULES", configRules);
                    }
                    StringBuilder sb = new StringBuilder("cardType:");
                    sb.append(str);
                    sb.append(", configRules version:");
                    sb.append(configRules == null ? "Unknown" : configRules.mVersion);
                    LogUtils.i(sb.toString());
                } catch (IOException e) {
                    LogUtils.e("parseCardRulesToBundle:" + str + " Exception occurred.", e);
                }
            }
        } else {
            bundle.putParcelable("KEY_READ_CARD_OPTION_RULES", localConfigRules);
            LogUtils.w("cardType:" + str + " using local configRules version:" + localConfigRules.mVersion);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
     arg types: [java.io.FileReader, java.lang.Class]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T */
    private ConfigRules getLocalConfigRules(String str) {
        File[] listFiles;
        FileReader fileReader;
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FilenameFilter() {
            /* class com.miui.tsmclient.entity.CardConfigManager.AnonymousClass1 */

            public boolean accept(File file, String str) {
                return str.endsWith("json");
            }
        })) != null && listFiles.length > 0) {
            Gson gson = new Gson();
            try {
                fileReader = new FileReader(listFiles[0]);
                try {
                    return (ConfigRules) gson.fromJson((Reader) fileReader, ConfigRules.class);
                } catch (Exception e) {
                    e = e;
                    LogUtils.e("getLocalConfigRules failed", e);
                    IOUtils.closeQuietly((Reader) fileReader);
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                fileReader = null;
                LogUtils.e("getLocalConfigRules failed", e);
                IOUtils.closeQuietly((Reader) fileReader);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.miui.tsmclient.entity.GroupConfigInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
    private Map<String, CardConfig> fetchCardConfig() {
        GroupConfigInfo groupConfigInfo;
        boolean isMainThread = isMainThread();
        StringBuilder sb = new StringBuilder("fetchCardConfig count:");
        int i = this.mFetchConfigCount + 1;
        this.mFetchConfigCount = i;
        sb.append(i);
        sb.append(isMainThread ? " on main thread" : "");
        LogUtils.i(sb.toString());
        HashMap hashMap = null;
        if (!isMainThread) {
            ConfigListRequest configListRequest = new ConfigListRequest(null, "CARD_CONFIG", null);
            try {
                groupConfigInfo = (GroupConfigInfo) HttpClient.getInstance(this.mContext).execute(configListRequest).getResult();
                try {
                    if (configListRequest.isSuccess()) {
                        PrefUtils.putString(this.mContext, "key_card_config", new Gson().toJson(groupConfigInfo));
                    }
                } catch (IOException e) {
                    e = e;
                    LogUtils.e("ConfigListSyncRequest Exception occurred", e);
                    if (groupConfigInfo == null) {
                    }
                    if (groupConfigInfo != null) {
                    }
                    return hashMap;
                }
            } catch (IOException e2) {
                e = e2;
                groupConfigInfo = null;
                LogUtils.e("ConfigListSyncRequest Exception occurred", e);
                if (groupConfigInfo == null) {
                }
                if (groupConfigInfo != null) {
                }
                return hashMap;
            }
        } else {
            groupConfigInfo = null;
        }
        if (groupConfigInfo == null) {
            String string = PrefUtils.getString(this.mContext, "key_card_config", null);
            if (!TextUtils.isEmpty(string)) {
                groupConfigInfo = new Gson().fromJson(string, GroupConfigInfo.class);
            }
        }
        if (groupConfigInfo != null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(CardConfig.OperationType.class, new CardConfig.OperationTypeDeserializer());
            List<CardConfig> infoList = groupConfigInfo.getInfoList("CARD_CONFIG", CardConfig.class, gsonBuilder.create());
            hashMap = new HashMap();
            for (CardConfig cardConfig : infoList) {
                hashMap.put(cardConfig.mCardAid, cardConfig);
            }
        }
        return hashMap;
    }

    private boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static class CardConfig {
        @SerializedName("cardAid")
        public String mCardAid;
        @SerializedName("cardIconUrl")
        private String mCardIconUrl;
        @SerializedName("cardName")
        private String mCardName;
        @SerializedName("cardRulesUrl")
        public String mCardRulesUrl;
        @SerializedName("cardType")
        public String mCardType;
        @SerializedName("hciRule")
        private HCIRule mHCIRule;
        @SerializedName("hciTLVRule")
        private HciTLVRule mHciTLVRule;
        @SerializedName("judgeOverdrawIllegal")
        private boolean mJudgeOverdrawIllegal;
        @SerializedName("memberAids")
        private List<String> mMemberAidList;
        @SerializedName("memberHciList")
        private List<MemberHci> mMemberHciList;
        @SerializedName("needExtraInfo")
        private boolean mNeedExtraInfo;
        @SerializedName("operationType")
        public OperationType mOperationType = OperationType.SYNC;
        @SerializedName("supportCityUHci")
        private boolean mSupportCityUHci;
        @SerializedName("supportRechargeOnInvalidDate")
        private boolean mSupportRechargeOnInvalidDate;
        @SerializedName("tips")
        private String mTips;

        public OperationType getOperationType() {
            return this.mOperationType;
        }

        public String getCardAid() {
            return this.mCardAid;
        }

        public String getCardType() {
            return this.mCardType;
        }

        public String getCardRulesUrl() {
            return this.mCardRulesUrl;
        }

        public String getCardIconUrl() {
            return this.mCardIconUrl;
        }

        public String getCardName() {
            return this.mCardName;
        }

        public boolean isSupportCityUHci(String str) {
            if (TextUtils.equals(this.mCardAid, str)) {
                return this.mSupportCityUHci;
            }
            MemberHci memberHci = getMemberHci(str);
            return memberHci != null && memberHci.mSupportCityUHci;
        }

        public boolean isNeedExtraInfo() {
            return this.mNeedExtraInfo;
        }

        public HCIRule getHCIRule(String str) {
            if (TextUtils.equals(this.mCardAid, str)) {
                return this.mHCIRule;
            }
            MemberHci memberHci = getMemberHci(str);
            if (memberHci == null) {
                return null;
            }
            return memberHci.mHCIRule;
        }

        public HciTLVRule getHciTLVRule(String str) {
            if (TextUtils.equals(this.mCardAid, str)) {
                return this.mHciTLVRule;
            }
            MemberHci memberHci = getMemberHci(str);
            if (memberHci == null) {
                return null;
            }
            return memberHci.mHciTLVRule;
        }

        public String getTips() {
            return this.mTips;
        }

        public boolean isJudgeOverdrawIllegal() {
            return this.mJudgeOverdrawIllegal;
        }

        public boolean isSupportRechargeOnInvalidDate() {
            return this.mSupportRechargeOnInvalidDate;
        }

        public enum OperationType {
            SYNC(0),
            ASYNC(1);
            
            private int mValue;

            private OperationType(int i) {
                this.mValue = i;
            }

            public static OperationType getOperationType(int i) {
                for (OperationType operationType : values()) {
                    if (operationType.mValue == i) {
                        return operationType;
                    }
                }
                return SYNC;
            }
        }

        public boolean isMemberAid(String str) {
            List<String> list = this.mMemberAidList;
            return list != null && list.contains(str);
        }

        private MemberHci getMemberHci(String str) {
            List<MemberHci> list = this.mMemberHciList;
            if (list == null) {
                return null;
            }
            for (MemberHci next : list) {
                if (TextUtils.equals(next.mAid, str)) {
                    return next;
                }
            }
            return null;
        }

        static class OperationTypeDeserializer implements JsonDeserializer<OperationType> {
            private OperationTypeDeserializer() {
            }

            public OperationType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return OperationType.getOperationType(jsonElement.getAsInt());
            }
        }
    }

    public static class HCIRule {
        @SerializedName("balancetOffset")
        private int mBalanceOffset;
        @SerializedName("dataLength")
        private int mDataLength;
        @SerializedName("terminalNo")
        private int mTerminalNo;
        @SerializedName("tradeAmountOffset")
        private int mTradeAmountOffset;

        public int getDataLength() {
            return this.mDataLength;
        }

        public int getTradeAmountOffset() {
            return this.mTradeAmountOffset;
        }

        public int getBalanceOffset() {
            return this.mBalanceOffset;
        }

        public int getTerminalNo() {
            return this.mTerminalNo;
        }
    }

    public static class HciTLVRule {
        @SerializedName("balanceOffset")
        private int mBalanceOffset = -1;
        @SerializedName("balanceTags")
        private String[] mBalanceTags;
        @SerializedName("hciPrefix")
        private String mHciPrefix;
        @SerializedName("tlvDataOffset")
        private int mTLVDataOffset;
        @SerializedName("terminalNoOffset")
        private int mTerminalNoOffset = -1;
        @SerializedName("terminalNoTags")
        private String[] mTerminalNoTags;
        @SerializedName("tradeAmountOffset")
        private int mTradeAmountOffset = -1;
        @SerializedName("tradeAmountTags")
        private String[] mTradeAmountTags;

        public String getHciPrefix() {
            return this.mHciPrefix;
        }

        public int getTLVDataOffset() {
            return this.mTLVDataOffset;
        }

        public String[] getTradeAmountTags() {
            return this.mTradeAmountTags;
        }

        public int getTradeAmountOffset() {
            return this.mTradeAmountOffset;
        }

        public String[] getBalanceTags() {
            return this.mBalanceTags;
        }

        public int getBalanceOffset() {
            return this.mBalanceOffset;
        }

        public String[] getTerminalNoTags() {
            return this.mTerminalNoTags;
        }

        public int getTerminalNoOffset() {
            return this.mTerminalNoOffset;
        }
    }

    static class MemberHci {
        @SerializedName("aid")
        public String mAid;
        @SerializedName("hciRule")
        public HCIRule mHCIRule;
        @SerializedName("hciTLVRule")
        public HciTLVRule mHciTLVRule;
        @SerializedName("supportCityUHci")
        public boolean mSupportCityUHci;

        private MemberHci() {
        }
    }
}

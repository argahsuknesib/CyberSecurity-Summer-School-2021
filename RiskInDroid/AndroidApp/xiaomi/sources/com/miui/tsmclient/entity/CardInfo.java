package com.miui.tsmclient.entity;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.net.request.PersonalCardFaceRequest;
import com.miui.tsmclient.util.CardEnvironmentConfig;
import com.miui.tsmclient.util.IDeviceInfo;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.ReflectUtil;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CardInfo implements Parcelable, JSONSerializable, ObjectParser<CardInfo> {
    public static final Parcelable.Creator<CardInfo> CREATOR = new Parcelable.Creator<CardInfo>() {
        /* class com.miui.tsmclient.entity.CardInfo.AnonymousClass1 */

        public final CardInfo createFromParcel(Parcel parcel) {
            return new CardInfo(parcel);
        }

        public final CardInfo[] newArray(int i) {
            return new CardInfo[i];
        }
    };
    public static final Set<String> SPTC_TYPE_SET;
    private static final Map<String, IDeviceInfo> sDeviceInfoMap = new HashMap();
    public String mAid;
    public String mAreaCode;
    public int mCardBalance;
    protected String mCardDevice;
    public int mCardGroupId;
    public String mCardName;
    public String mCardNo;
    public String mCardSubName;
    public String mCardType;
    public CardUIInfo mCardUIInfo;
    public DataSource mDataSource;
    public String mEndDate;
    private String mExtra;
    public String mGroupName;
    public int mGroupType;
    private boolean mHasChildren;
    public boolean mHasIssue;
    public boolean mIsDefault;
    private boolean mIsKeepActivated;
    public boolean mIsPack;
    public boolean mIsReadSECorrectly;
    protected boolean mIsSecure;
    public int mIssueFee;
    private String mIssueStatusDesc;
    public String mIssuerName;
    public String mRealCardNo;
    private RechargeStatus mRechargeStatus;
    private String mRechargeStatusDesc;
    private String mServiceFeeDesc;
    private String mServiceFeeDetailDesc;
    public ServiceStatus mServiceStatus;
    private String mServiceStatusDesc;
    public String mStartDate;
    public Status mStatus;
    public boolean mSupportMoveCardReturnCard;
    public boolean mSupportPhoneReturnCard;
    public boolean mSupportWearableReturnCard;
    public List<TradeLog> mTradeLogs;

    public enum DataSource {
        Unknown,
        DB,
        Network,
        SE
    }

    public enum Status {
        ACTIVE,
        IN_BLACKLIST,
        NEGATIVE,
        DATA_ILLEGAL,
        START_DATE_INVALID,
        END_DATE_INVALID,
        LOCKED,
        INVALID
    }

    public boolean canTransferIn() {
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public String getUpdateArtContent() {
        return "";
    }

    public boolean hasIssueOrder() {
        return false;
    }

    public boolean hasQRProperty() {
        return false;
    }

    public boolean hasQRToken() {
        return false;
    }

    public boolean hasRechargeOrder() {
        return false;
    }

    public boolean hasTransferInOrder() {
        return false;
    }

    public boolean isBankCard() {
        return false;
    }

    public boolean isCanSwipe() {
        return true;
    }

    public boolean isMiFareCard() {
        return false;
    }

    public boolean isQrBankCard() {
        return false;
    }

    public boolean isTransCard() {
        return false;
    }

    public void parseCardFromJson(JSONObject jSONObject) {
    }

    public boolean showBalance() {
        return false;
    }

    static {
        HashSet hashSet = new HashSet();
        SPTC_TYPE_SET = hashSet;
        hashSet.add("SPTC");
        SPTC_TYPE_SET.add("SPTC_NEW");
    }

    public enum ServiceStatus {
        unknown(-1),
        active(0),
        negative(1),
        no_stock(2);
        
        private int mId;

        private ServiceStatus(int i) {
            this.mId = i;
        }

        public final int getId() {
            return this.mId;
        }

        public static ServiceStatus getInstance(int i) {
            for (ServiceStatus serviceStatus : values()) {
                if (serviceStatus.mId == i) {
                    return serviceStatus;
                }
            }
            return unknown;
        }
    }

    public enum RechargeStatus {
        unknown(-1),
        available(0),
        unavailable(4);
        
        private int mId;

        private RechargeStatus(int i) {
            this.mId = i;
        }

        public final int getId() {
            return this.mId;
        }

        public static RechargeStatus getInstance(int i) {
            for (RechargeStatus rechargeStatus : values()) {
                if (rechargeStatus.mId == i) {
                    return rechargeStatus;
                }
            }
            return unknown;
        }
    }

    private CardInfo(Parcel parcel) {
        this.mIsPack = false;
        this.mStatus = null;
        this.mDataSource = DataSource.Unknown;
        this.mIsSecure = false;
        readFromParcel(parcel);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.entity.CardInfo.<init>(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.miui.tsmclient.entity.CardInfo.<init>(android.os.Parcel, com.miui.tsmclient.entity.CardInfo$1):void
      com.miui.tsmclient.entity.CardInfo.<init>(java.lang.String, boolean):void */
    public CardInfo(String str) {
        this(str, false);
    }

    public CardInfo(String str, boolean z) {
        this.mIsPack = false;
        this.mStatus = null;
        this.mDataSource = DataSource.Unknown;
        this.mIsSecure = false;
        this.mCardType = str;
        this.mIsSecure = z;
        this.mCardDevice = CardEnvironmentConfig.getDefaultDevice();
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.mCardName);
            jSONObject.put("card_no", this.mCardNo);
            jSONObject.put("has_issue", this.mHasIssue);
            jSONObject.put("is_default", this.mIsDefault);
            jSONObject.put("card_balance", this.mCardBalance);
            if (this.mCardType != null) {
                jSONObject.put("cardName", this.mCardType.toString());
            }
            jSONObject.put("issuerName", this.mIssuerName);
            jSONObject.put("card_sub_name", this.mCardSubName);
            jSONObject.put("issueFee", this.mIssueFee);
            jSONObject.put("aid", this.mAid);
            if (this.mServiceStatus != null) {
                jSONObject.put("status", this.mServiceStatus.getId());
            }
            jSONObject.put("statusDesc", this.mServiceStatusDesc);
            if (this.mRechargeStatus != null) {
                jSONObject.put("rechargeStatus", this.mRechargeStatus.getId());
            }
            jSONObject.put("rechargeStatusDesc", this.mRechargeStatusDesc);
            jSONObject.put("issueStatusDesc", this.mIssueStatusDesc);
            if (this.mCardUIInfo != null) {
                jSONObject.put("card_ui_info", this.mCardUIInfo.serialize());
            }
            if (this.mStatus != null) {
                jSONObject.put("card_status", this.mStatus.toString());
            }
            if (this.mStartDate != null) {
                jSONObject.put("card_start_date", this.mStartDate);
            }
            if (this.mEndDate != null) {
                jSONObject.put("card_end_date", this.mEndDate);
            }
            if (this.mRealCardNo != null) {
                jSONObject.put("real_card_no", this.mRealCardNo);
            }
            jSONObject.put("secure", this.mIsSecure);
            jSONObject.put("read_se_correctly", this.mIsReadSECorrectly);
            jSONObject.put("cardGroup", this.mGroupType);
            jSONObject.put("groupName", this.mGroupName);
            jSONObject.put("groupId", this.mCardGroupId);
            if (this.mCardDevice != null) {
                jSONObject.put("cardDevice", this.mCardDevice);
            }
            jSONObject.put("serviceFeeDesc", this.mServiceFeeDesc);
            jSONObject.put("issueFeeDetailDesc", this.mServiceFeeDetailDesc);
            if (!TextUtils.isEmpty(this.mAreaCode)) {
                jSONObject.put("areaCode", this.mAreaCode);
            }
            if (!TextUtils.isEmpty(this.mExtra)) {
                jSONObject.put("extra", this.mExtra);
            }
            jSONObject.put("keepActivated", this.mIsKeepActivated);
            jSONObject.put("hasChildren", this.mHasChildren);
        } catch (JSONException e) {
            LogUtils.e("serialize cardInfo to JSONObject failed!", e);
        }
        return jSONObject;
    }

    public CardInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mCardName = jSONObject.optString("title");
            if (jSONObject.has("card_no")) {
                this.mCardNo = jSONObject.optString("card_no");
            }
            if (jSONObject.has("has_issue")) {
                this.mHasIssue = jSONObject.optBoolean("has_issue");
            }
            this.mIsDefault = jSONObject.optBoolean("is_default");
            if (jSONObject.has("card_balance")) {
                this.mCardBalance = jSONObject.optInt("card_balance");
            }
            if (jSONObject.has("cardName")) {
                this.mCardType = jSONObject.optString("cardName");
            }
            if (jSONObject.has("issuerName")) {
                this.mIssuerName = jSONObject.optString("issuerName");
            }
            if (jSONObject.has("card_sub_name")) {
                this.mCardSubName = jSONObject.optString("card_sub_name");
            }
            this.mIssueFee = jSONObject.optInt("issueFee");
            this.mAid = jSONObject.optString("aid");
            this.mServiceStatus = ServiceStatus.getInstance(jSONObject.optInt("status", -1));
            this.mServiceStatusDesc = jSONObject.optString("statusDesc");
            this.mRechargeStatus = RechargeStatus.getInstance(jSONObject.optInt("rechargeStatus"));
            this.mRechargeStatusDesc = jSONObject.optString("rechargeStatusDesc");
            this.mIssueStatusDesc = jSONObject.optString("issueStatusDesc");
            this.mCardUIInfo = new CardUIInfo();
            this.mCardUIInfo.parse(jSONObject);
            if (jSONObject.has("card_status")) {
                this.mStatus = Status.valueOf(jSONObject.optString("card_status"));
            }
            if (jSONObject.has("card_start_date")) {
                this.mStartDate = jSONObject.optString("card_start_date");
            }
            if (jSONObject.has("card_end_date")) {
                this.mEndDate = jSONObject.optString("card_end_date");
            }
            if (jSONObject.has("real_card_no")) {
                this.mRealCardNo = jSONObject.optString("real_card_no");
            }
            this.mIsSecure = jSONObject.optBoolean("secure");
            this.mIsReadSECorrectly = jSONObject.optBoolean("read_se_correctly");
            this.mGroupType = jSONObject.optInt("cardGroup", -1);
            this.mGroupName = jSONObject.optString("groupName");
            if (jSONObject.has("groupId")) {
                this.mCardGroupId = jSONObject.optInt("groupId");
            }
            if (jSONObject.has("cardDevice")) {
                this.mCardDevice = jSONObject.optString("cardDevice");
            }
            if (jSONObject.has("areaCode")) {
                this.mAreaCode = jSONObject.optString("areaCode");
            }
            if (jSONObject.has("serviceFeeDesc")) {
                this.mServiceFeeDesc = jSONObject.optString("serviceFeeDesc");
            }
            if (jSONObject.has("issueFeeDetailDesc")) {
                this.mServiceFeeDetailDesc = jSONObject.optString("issueFeeDetailDesc");
            }
            if (jSONObject.has("extra")) {
                this.mExtra = jSONObject.optString("extra");
                updateCardFromExtra();
            }
            this.mIsKeepActivated = jSONObject.optBoolean("keepActivated");
            this.mHasChildren = jSONObject.optBoolean("hasChildren");
        }
        return this;
    }

    public int hashCode() {
        return this.mCardType.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInfo)) {
            return false;
        }
        CardInfo cardInfo = (CardInfo) obj;
        return TextUtils.equals(this.mAid, cardInfo.mAid) && TextUtils.equals(this.mCardDevice, cardInfo.mCardDevice);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardName);
        parcel.writeString(this.mCardNo);
        parcel.writeByte(this.mHasIssue ? (byte) 1 : 0);
        parcel.writeByte(this.mIsDefault ? (byte) 1 : 0);
        parcel.writeInt(this.mCardBalance);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mIssuerName);
        parcel.writeValue(this.mServiceStatus);
        parcel.writeString(this.mServiceStatusDesc);
        parcel.writeValue(this.mRechargeStatus);
        parcel.writeString(this.mRechargeStatusDesc);
        parcel.writeString(this.mIssueStatusDesc);
        parcel.writeByte(this.mIsPack ? (byte) 1 : 0);
        parcel.writeString(this.mCardSubName);
        parcel.writeParcelable(this.mCardUIInfo, i);
        parcel.writeInt(this.mIssueFee);
        parcel.writeString(this.mAid);
        parcel.writeList(this.mTradeLogs);
        Status status = this.mStatus;
        parcel.writeString(status == null ? "" : status.name());
        parcel.writeString(this.mStartDate);
        parcel.writeString(this.mEndDate);
        parcel.writeString(this.mRealCardNo);
        parcel.writeValue(this.mDataSource);
        parcel.writeByte(this.mIsSecure ? (byte) 1 : 0);
        parcel.writeByte(this.mIsReadSECorrectly ? (byte) 1 : 0);
        parcel.writeInt(this.mGroupType);
        parcel.writeString(this.mGroupName);
        parcel.writeInt(this.mCardGroupId);
        parcel.writeString(this.mCardDevice);
        parcel.writeString(this.mAreaCode);
        parcel.writeString(this.mServiceFeeDesc);
        parcel.writeString(this.mServiceFeeDetailDesc);
        parcel.writeString(this.mExtra);
        parcel.writeByte(this.mSupportMoveCardReturnCard ? (byte) 1 : 0);
        parcel.writeByte(this.mSupportPhoneReturnCard ? (byte) 1 : 0);
        parcel.writeByte(this.mSupportWearableReturnCard ? (byte) 1 : 0);
        parcel.writeByte(this.mIsKeepActivated ? (byte) 1 : 0);
        parcel.writeByte(this.mHasChildren ? (byte) 1 : 0);
    }

    public void readFromParcel(Parcel parcel) {
        this.mCardName = parcel.readString();
        this.mCardNo = parcel.readString();
        boolean z = false;
        this.mHasIssue = parcel.readByte() == 1;
        this.mIsDefault = parcel.readByte() == 1;
        this.mCardBalance = parcel.readInt();
        this.mCardType = parcel.readString();
        this.mIssuerName = parcel.readString();
        this.mServiceStatus = (ServiceStatus) parcel.readValue(ServiceStatus.class.getClassLoader());
        this.mServiceStatusDesc = parcel.readString();
        this.mRechargeStatus = (RechargeStatus) parcel.readValue(RechargeStatus.class.getClassLoader());
        this.mRechargeStatusDesc = parcel.readString();
        this.mIssueStatusDesc = parcel.readString();
        this.mIsPack = parcel.readByte() == 1;
        this.mCardSubName = parcel.readString();
        this.mCardUIInfo = (CardUIInfo) parcel.readParcelable(CardUIInfo.class.getClassLoader());
        this.mIssueFee = parcel.readInt();
        this.mAid = parcel.readString();
        this.mTradeLogs = parcel.readArrayList(TradeLog.class.getClassLoader());
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            this.mStatus = Status.valueOf(readString);
        }
        this.mStartDate = parcel.readString();
        this.mEndDate = parcel.readString();
        this.mRealCardNo = parcel.readString();
        this.mDataSource = (DataSource) parcel.readValue(DataSource.class.getClassLoader());
        this.mIsSecure = parcel.readByte() == 1;
        this.mIsReadSECorrectly = parcel.readByte() == 1;
        this.mGroupType = parcel.readInt();
        this.mGroupName = parcel.readString();
        this.mCardGroupId = parcel.readInt();
        this.mCardDevice = parcel.readString();
        this.mAreaCode = parcel.readString();
        this.mServiceFeeDesc = parcel.readString();
        this.mServiceFeeDetailDesc = parcel.readString();
        this.mExtra = parcel.readString();
        this.mSupportMoveCardReturnCard = parcel.readByte() == 1;
        this.mSupportPhoneReturnCard = parcel.readByte() == 1;
        this.mSupportWearableReturnCard = parcel.readByte() == 1;
        this.mIsKeepActivated = parcel.readByte() == 1;
        if (parcel.readByte() == 1) {
            z = true;
        }
        this.mHasChildren = z;
    }

    public void updateInfo(CardInfo cardInfo) {
        this.mCardNo = cardInfo.mCardNo;
        this.mIsDefault = cardInfo.mIsDefault;
        this.mCardBalance = cardInfo.mCardBalance;
        this.mCardSubName = cardInfo.mCardSubName;
        this.mStartDate = cardInfo.mStartDate;
        this.mEndDate = cardInfo.mEndDate;
        this.mRealCardNo = cardInfo.mRealCardNo;
        this.mStatus = cardInfo.mStatus;
        this.mIsReadSECorrectly = cardInfo.mIsReadSECorrectly;
    }

    public String mapAid() {
        return this.mAid;
    }

    public IScTerminal getTerminal() {
        try {
            return (IScTerminal) ReflectUtil.callObjectMethod(ReflectUtil.newInstance("com.miui.tsmclient.entity.CardExtra", (Class<?>[]) null, new Object[0]), "getTerminal", new Class[]{CardInfo.class}, this);
        } catch (Exception e) {
            LogUtils.e("getTerminal", e);
            throw new RuntimeException("get Terminal failed");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.miui.tsmclient.util.IDeviceInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    public IDeviceInfo getDeviceInfo() {
        String str;
        IDeviceInfo deviceInfo = CardEnvironmentConfig.getDeviceInfo();
        if (deviceInfo != null) {
            return deviceInfo;
        }
        if (!TextUtils.isEmpty(this.mCardDevice)) {
            str = this.mCardDevice + ".mitsmsdk.DeviceInfoImpl";
        } else {
            str = "com.miui.tsmclient.mitsmsdk.DeviceInfoImpl";
        }
        IDeviceInfo iDeviceInfo = sDeviceInfoMap.get(str);
        if (iDeviceInfo == null) {
            Object newInstance = ReflectUtil.newInstance(str, (Class<?>[]) null, new Object[0]);
            if (newInstance instanceof IDeviceInfo) {
                iDeviceInfo = newInstance;
                sDeviceInfoMap.put(str, iDeviceInfo);
            }
        }
        if (iDeviceInfo != null) {
            return iDeviceInfo;
        }
        throw new IllegalStateException("device info can not be found!");
    }

    public void updateExtraInfo(Context context) {
        try {
            ReflectUtil.callObjectMethod(ReflectUtil.newInstance("com.miui.tsmclient.entity.CardExtra", (Class<?>[]) null, new Object[0]), "updateExtraInfo", new Class[]{Context.class, CardInfo.class}, context, this);
        } catch (Exception e) {
            LogUtils.e("updateExtraInfo", e);
        }
    }

    public boolean isServiceAvailable() {
        return this.mServiceStatus == ServiceStatus.active;
    }

    public String getServiceStatusDesc() {
        return this.mServiceStatusDesc;
    }

    public boolean isRechargeServiceAvailable() {
        return this.mRechargeStatus == RechargeStatus.available;
    }

    public String getRechargeStatusDesc() {
        return this.mRechargeStatusDesc;
    }

    public String getIssueStatusDesc() {
        return this.mIssueStatusDesc;
    }

    public String getCardType() {
        if ("DUMMY".equals(this.mCardType)) {
            String cardType = CardConfigManager.getInstance().getCardType(this.mAid);
            if (!TextUtils.isEmpty(cardType)) {
                return cardType;
            }
        }
        return this.mCardType;
    }

    public boolean isSecure() {
        return this.mIsSecure;
    }

    public boolean isAid(String str) {
        return !TextUtils.isEmpty(this.mAid) && TextUtils.equals(str, this.mAid);
    }

    public CardInfo copy() {
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(this.mCardType, serialize());
        makeCardInfo.mTradeLogs = this.mTradeLogs;
        return makeCardInfo;
    }

    public String getServiceFeeDesc() {
        return this.mServiceFeeDesc;
    }

    public int getIssueFee() {
        return this.mIssueFee;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public boolean isCardActive() {
        return this.mStatus == Status.ACTIVE;
    }

    public Status getCardStatus() {
        return this.mStatus;
    }

    public boolean isBalanceValid() {
        return this.mCardBalance != -999;
    }

    public String getLabel() {
        try {
            if (!TextUtils.isEmpty(getExtra())) {
                return new JSONObject(getExtra()).optString("cardSubScript");
            }
            return "";
        } catch (JSONException e) {
            LogUtils.e("parse card sub script failed", e);
            return "";
        }
    }

    private boolean updateCardFromExtra() {
        if (!TextUtils.isEmpty(this.mExtra)) {
            try {
                LogUtils.v(this.mCardType + " updateCardFromExtra：" + this.mExtra);
                JSONObject jSONObject = new JSONObject(this.mExtra);
                this.mHasIssue = jSONObject.optBoolean("issued", false);
                if (!this.mHasIssue) {
                    this.mStatus = null;
                    this.mCardBalance = 0;
                    this.mCardNo = null;
                    this.mRealCardNo = null;
                    this.mIsReadSECorrectly = true;
                }
                this.mSupportMoveCardReturnCard = (jSONObject.optInt("cardConfigs", 0) & 2) == 2;
                this.mSupportPhoneReturnCard = (jSONObject.optInt("cardConfigs", 0) & 64) == 64;
                this.mSupportWearableReturnCard = (jSONObject.optInt("cardConfigs", 0) & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
                return true;
            } catch (JSONException e) {
                LogUtils.e("updateCardFromExtra error occurred", e);
            }
        }
        return false;
    }

    public Boolean updateBackground(Context context) {
        try {
            PersonalCardFaceRequest personalCardFaceRequest = new PersonalCardFaceRequest(this);
            PersonalCardFaceRequest.PersonalCardFaceResponseInfo personalCardFaceResponseInfo = (PersonalCardFaceRequest.PersonalCardFaceResponseInfo) HttpClient.getInstance(context).execute(personalCardFaceRequest).getResult();
            if (personalCardFaceRequest.isSuccess()) {
                this.mCardUIInfo.mPersonalCardFace = personalCardFaceResponseInfo.getPresonalCardFace().getCardFace();
                return Boolean.TRUE;
            }
            if (personalCardFaceResponseInfo != null) {
                LogUtils.d("PersonalCardFaceRequest onFailed, errorCode:" + personalCardFaceResponseInfo.getErrorCode() + ", errorMsg:" + personalCardFaceResponseInfo.getErrorDesc());
            }
            return Boolean.FALSE;
        } catch (IOException e) {
            LogUtils.e("PersonalCardFaceRequest error occurred", e);
        }
    }

    public boolean isKeepActivated() {
        return this.mIsKeepActivated;
    }

    public void setKeepActivated(boolean z) {
        this.mIsKeepActivated = z;
    }

    public String getContentDescription(Map<Class<? extends CardInfo>, String> map) {
        return this.mCardName;
    }

    public String getIssueFeeDetailDesc() {
        return this.mServiceFeeDetailDesc;
    }

    public boolean isHasChildren() {
        return this.mHasChildren;
    }
}

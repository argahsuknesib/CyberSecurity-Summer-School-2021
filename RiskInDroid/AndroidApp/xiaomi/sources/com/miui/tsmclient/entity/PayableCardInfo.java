package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.FeeInfo;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PayableCardInfo extends CardInfo implements Parcelable {
    public static final Parcelable.Creator<PayableCardInfo> CREATOR = new Parcelable.Creator<PayableCardInfo>() {
        /* class com.miui.tsmclient.entity.PayableCardInfo.AnonymousClass1 */

        public final PayableCardInfo createFromParcel(Parcel parcel) {
            PayableCardInfo payableCardInfo = new PayableCardInfo(null);
            payableCardInfo.readFromParcel(parcel);
            return payableCardInfo;
        }

        public final PayableCardInfo[] newArray(int i) {
            return new PayableCardInfo[i];
        }
    };
    protected Map<FeeInfo.ActionType, List<FeeInfo>> mActionType2FeeInfoListMap = new HashMap();
    protected List<FeeInfo> mActiveFeeInfos;
    private CustomFeeInfo mCustomFeeInfo;
    private CustomInfo mCustomInfo;
    private boolean mHasUncompletedBusiness;
    private String mPhoneNumber;
    private UncompletedBusiness mUncompletedBusiness;
    public List<OrderInfo> mUnfinishOrderInfos = new CopyOnWriteArrayList();
    private TransferOutOrderInfo mUnfinishTransferOutInfo;

    public boolean isTransCard() {
        return true;
    }

    public TransferOutOrderInfo getUnfinishTransferOutInfo() {
        return this.mUnfinishTransferOutInfo;
    }

    public void setUnfinishTransferOutInfo(TransferOutOrderInfo transferOutOrderInfo) {
        this.mUnfinishTransferOutInfo = transferOutOrderInfo;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.mPhoneNumber = str;
    }

    public CustomFeeInfo getCustomFeeInfo() {
        return this.mCustomFeeInfo;
    }

    public PayableCardInfo(String str) {
        super(str);
        this.mCardGroupId = CardGroupType.TRANSCARD.getId();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        Map<FeeInfo.ActionType, List<FeeInfo>> map = this.mActionType2FeeInfoListMap;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map.size());
            for (FeeInfo.ActionType next : this.mActionType2FeeInfoListMap.keySet()) {
                parcel.writeString(next.name());
                parcel.writeList(this.mActionType2FeeInfoListMap.get(next));
            }
        }
        parcel.writeList(this.mUnfinishOrderInfos);
        parcel.writeString(this.mPhoneNumber);
        parcel.writeParcelable(this.mCustomFeeInfo, i);
        parcel.writeParcelable(this.mCustomInfo, i);
        parcel.writeParcelable(this.mUncompletedBusiness, i);
        parcel.writeByte(this.mHasUncompletedBusiness ? (byte) 1 : 0);
        if (supportTransferOutOrderInfoParcel()) {
            parcel.writeParcelable(this.mUnfinishTransferOutInfo, i);
        }
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        int readInt = parcel.readInt();
        boolean z = false;
        for (int i = 0; i < readInt; i++) {
            this.mActionType2FeeInfoListMap.put(FeeInfo.ActionType.valueOf(parcel.readString()), parcel.readArrayList(FeeInfo.class.getClassLoader()));
        }
        this.mUnfinishOrderInfos = new CopyOnWriteArrayList();
        this.mUnfinishOrderInfos.addAll(parcel.readArrayList(OrderInfo.class.getClassLoader()));
        this.mPhoneNumber = parcel.readString();
        this.mCustomFeeInfo = (CustomFeeInfo) parcel.readParcelable(CustomFeeInfo.class.getClassLoader());
        this.mCustomInfo = (CustomInfo) parcel.readParcelable(CustomInfo.class.getClassLoader());
        this.mUncompletedBusiness = (UncompletedBusiness) parcel.readParcelable(UncompletedBusiness.class.getClassLoader());
        if (parcel.readByte() == 1) {
            z = true;
        }
        this.mHasUncompletedBusiness = z;
        if (supportTransferOutOrderInfoParcel()) {
            this.mUnfinishTransferOutInfo = (TransferOutOrderInfo) parcel.readParcelable(TransferOutOrderInfo.class.getClassLoader());
        }
    }

    public JSONObject serialize() {
        JSONObject serialize = super.serialize();
        if (serialize != null) {
            try {
                if (this.mActionType2FeeInfoListMap != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (FeeInfo.ActionType actionType : this.mActionType2FeeInfoListMap.keySet()) {
                        for (FeeInfo serialize2 : this.mActionType2FeeInfoListMap.get(actionType)) {
                            jSONArray.put(serialize2.serialize());
                        }
                    }
                    serialize.put("fees", jSONArray);
                    if (this.mCustomInfo != null) {
                        serialize.put("customInfo", this.mCustomInfo.serialize());
                    }
                }
                serialize.put("hasUncompletedBusiness", this.mHasUncompletedBusiness);
            } catch (JSONException e) {
                LogUtils.e("serialize fee info list failed.", e);
            }
        }
        return serialize;
    }

    public CardInfo parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject == null) {
            return this;
        }
        if (jSONObject.has("fees")) {
            try {
                if (this.mActionType2FeeInfoListMap != null) {
                    this.mActionType2FeeInfoListMap.clear();
                }
                JSONArray jSONArray = jSONObject.getJSONArray("fees");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    FeeInfo feeInfo = new FeeInfo();
                    feeInfo.parse(jSONObject2);
                    if (this.mActionType2FeeInfoListMap.get(feeInfo.mActionType) == null) {
                        this.mActionType2FeeInfoListMap.put(feeInfo.mActionType, new ArrayList());
                    }
                    this.mActionType2FeeInfoListMap.get(feeInfo.mActionType).add(feeInfo);
                }
            } catch (JSONException e) {
                LogUtils.e("parse fee info list failed. parse object:" + jSONObject.toString(), e);
            }
        }
        if (jSONObject.has("customInfo")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("customInfo");
                this.mCustomInfo = new CustomInfo();
                this.mCustomInfo.parse(jSONObject3);
                if (jSONObject.has("configId")) {
                    this.mCustomInfo.setCustomConfigId(jSONObject.optLong("configId"));
                }
                this.mCustomFeeInfo = new CustomFeeInfo(this.mCustomInfo);
            } catch (JSONException e2) {
                LogUtils.e("parse customInfo info list failed. parse object:" + jSONObject.toString(), e2);
            }
        }
        this.mHasUncompletedBusiness = jSONObject.optBoolean("hasUncompletedBusiness");
        return this;
    }

    public boolean showBalance() {
        return this.mCardBalance != -999;
    }

    public List<FeeInfo> getActiveFeeInfoList() {
        CustomFeeInfo customFeeInfo;
        if (this.mHasIssue) {
            this.mActiveFeeInfos = this.mActionType2FeeInfoListMap.get(FeeInfo.ActionType.recharge);
        } else {
            this.mActiveFeeInfos = this.mActionType2FeeInfoListMap.get(FeeInfo.ActionType.issue);
            if (this.mActiveFeeInfos == null) {
                this.mActiveFeeInfos = this.mActionType2FeeInfoListMap.get(FeeInfo.ActionType.issueAndRecharge);
            }
        }
        if (this.mActiveFeeInfos != null && (customFeeInfo = this.mCustomFeeInfo) != null && customFeeInfo.isValid() && !this.mActiveFeeInfos.contains(this.mCustomFeeInfo)) {
            this.mActiveFeeInfos.add(this.mCustomFeeInfo);
        }
        return this.mActiveFeeInfos;
    }

    public FeeInfo getWithdrawFeeInfo() {
        List<FeeInfo> list;
        if (canTransferIn() && (list = this.mActionType2FeeInfoListMap.get(FeeInfo.ActionType.withdraw)) != null && !list.isEmpty()) {
            for (FeeInfo feeInfo : list) {
                if (feeInfo.mActionType == FeeInfo.ActionType.withdraw) {
                    return feeInfo;
                }
            }
        }
        return null;
    }

    public boolean canTransferIn() {
        if (this.mHasIssue || !this.mIsReadSECorrectly) {
            return false;
        }
        return hasTransferInOrder();
    }

    public boolean hasTransferInOrder() {
        OrderInfo orderInfo;
        List<OrderInfo> list = this.mUnfinishOrderInfos;
        if (!(list == null || list.isEmpty() || (orderInfo = this.mUnfinishOrderInfos.get(0)) == null || orderInfo.mActionTokens == null)) {
            for (ActionToken actionToken : orderInfo.mActionTokens) {
                if (actionToken.mType == ActionToken.TokenType.withdraw) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasIssueOrder() {
        List<OrderInfo> list = this.mUnfinishOrderInfos;
        if (list == null) {
            return false;
        }
        for (OrderInfo isIssueOrder : list) {
            if (isIssueOrder.isIssueOrder()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRechargeOrder() {
        List<OrderInfo> list = this.mUnfinishOrderInfos;
        if (list == null) {
            return false;
        }
        for (OrderInfo isRechargeOrder : list) {
            if (isRechargeOrder.isRechargeOrder()) {
                return true;
            }
        }
        return false;
    }

    public OrderInfo getTransferInOrder() {
        if (canTransferIn()) {
            return this.mUnfinishOrderInfos.get(0);
        }
        return null;
    }

    public int getTransferOutBalance() {
        List<ActionToken> list;
        if (canTransferIn() && (list = this.mUnfinishOrderInfos.get(0).mActionTokens) != null && !list.isEmpty()) {
            for (ActionToken next : list) {
                if (next.mType == ActionToken.TokenType.withdraw) {
                    return next.mRechargeAmount;
                }
            }
        }
        return 0;
    }

    public PayableCardInfo updateOrderInfo(OrderInfo orderInfo) {
        if (orderInfo != null && orderInfo.isPaid()) {
            List<OrderInfo> list = this.mUnfinishOrderInfos;
            if (list != null) {
                list.clear();
            } else {
                this.mUnfinishOrderInfos = new CopyOnWriteArrayList();
            }
            this.mUnfinishOrderInfos.add(orderInfo);
        }
        return this;
    }

    public boolean hasUnfinishedOrder() {
        List<OrderInfo> list = this.mUnfinishOrderInfos;
        return (list != null && !list.isEmpty()) || this.mUnfinishTransferOutInfo != null;
    }

    public OrderInfo getRechargeOrder() {
        List<OrderInfo> list = this.mUnfinishOrderInfos;
        if (list != null && !list.isEmpty()) {
            for (OrderInfo next : list) {
                if (next.isRechargeOrder()) {
                    return next;
                }
            }
        }
        return null;
    }

    public int hashCode() {
        return this.mCardType.hashCode();
    }

    public void updateCustomFeeInfo(CustomFeeInfo customFeeInfo) {
        List<FeeInfo> list;
        int indexOf;
        if (customFeeInfo != null && (list = this.mActiveFeeInfos) != null && (indexOf = list.indexOf(customFeeInfo)) >= 0) {
            this.mActiveFeeInfos.set(indexOf, customFeeInfo);
        }
    }

    public FeeInfo getFeeInfo(int i) {
        if (getActiveFeeInfoList() == null || getActiveFeeInfoList().size() <= i) {
            return null;
        }
        return getActiveFeeInfoList().get(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInfo)) {
            return false;
        }
        CardInfo cardInfo = (CardInfo) obj;
        return TextUtils.equals(this.mCardType, cardInfo.mCardType) && TextUtils.equals(this.mCardDevice, cardInfo.mCardDevice);
    }

    private boolean supportTransferOutOrderInfoParcel() {
        if (EnvironmentConfig.getContext() != null && DeviceUtils.getAppVersionCode(EnvironmentConfig.getContext(), "com.miui.tsmclient") >= 47) {
            return true;
        }
        return false;
    }

    public String getContentDescription(Map<Class<? extends CardInfo>, String> map) {
        String str;
        if (map == null || (str = map.get(getClass())) == null) {
            return super.getContentDescription(null);
        }
        return String.format(str, this.mCardName, Float.valueOf(((float) this.mCardBalance) / 100.0f));
    }

    public List<String> getPaymentChannels() {
        ArrayList arrayList = new ArrayList();
        String extra = getExtra();
        if (TextUtils.isEmpty(extra)) {
            return Collections.emptyList();
        }
        try {
            JSONArray optJSONArray = new JSONObject(extra).optJSONArray("paymentChannels");
            if (optJSONArray == null) {
                return Collections.emptyList();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException unused) {
            LogUtils.d("parse paymentChannels failed");
            return Collections.emptyList();
        }
    }

    public void setUncompletedBusiness(UncompletedBusiness uncompletedBusiness) {
        setHasUncompletedBusiness(uncompletedBusiness != null);
        if (uncompletedBusiness != null) {
            this.mUncompletedBusiness = uncompletedBusiness;
            OrderInfo orderInfo = this.mUncompletedBusiness.getOrderInfo();
            if (orderInfo != null) {
                updateOrderInfo(orderInfo);
            }
            TransferOutOrderInfo transferOutOrderInfo = this.mUncompletedBusiness.getTransferOutOrderInfo();
            if (transferOutOrderInfo != null) {
                setUnfinishTransferOutInfo(transferOutOrderInfo);
            }
        }
    }

    public UncompletedBusiness getUncompletedBusiness() {
        return this.mUncompletedBusiness;
    }

    public void setHasUncompletedBusiness(boolean z) {
        this.mHasUncompletedBusiness = z;
    }

    public boolean isHasUncompletedBusiness() {
        return this.mHasUncompletedBusiness;
    }

    public boolean isCanSwipe() {
        return !isHasUncompletedBusiness();
    }
}

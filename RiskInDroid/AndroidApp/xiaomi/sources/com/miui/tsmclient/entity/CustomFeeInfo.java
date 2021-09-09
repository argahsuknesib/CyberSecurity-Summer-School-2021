package com.miui.tsmclient.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomFeeInfo extends FeeInfo {
    public static final Parcelable.Creator<CustomFeeInfo> CREATOR = new Parcelable.Creator<CustomFeeInfo>() {
        /* class com.miui.tsmclient.entity.CustomFeeInfo.AnonymousClass1 */

        public final CustomFeeInfo createFromParcel(Parcel parcel) {
            return new CustomFeeInfo(parcel);
        }

        public final CustomFeeInfo[] newArray(int i) {
            return new CustomFeeInfo[i];
        }
    };
    private int mCustomFee;
    private CustomInfo mCustomInfo;

    public boolean isCustomFee() {
        return true;
    }

    public CustomFeeInfo(CustomInfo customInfo) {
        this.mCustomFee = Integer.MIN_VALUE;
        this.mCustomInfo = customInfo;
    }

    public int getPayFee() {
        int issueFee = getIssueFee();
        return isValidRechargeFee() ? issueFee + getRechargeFee() : issueFee;
    }

    public int getIssueFee() {
        return this.mCustomInfo.getCustomIssueFee();
    }

    public int getRechargeFee() {
        return this.mCustomFee;
    }

    public boolean isValidRechargeFee() {
        return isValidSection(this.mCustomFee);
    }

    public void setRechargeFee(int i) {
        if (isValidSection(i)) {
            this.mCustomFee = i;
        }
    }

    public boolean isValidSection(int i) {
        return i >= this.mCustomInfo.getMinFee() && i <= this.mCustomInfo.getMaxFee();
    }

    public boolean isLessValidSection(int i) {
        return i < this.mCustomInfo.getMinFee();
    }

    public void restoreRechargeFee() {
        this.mCustomFee = Integer.MIN_VALUE;
    }

    public void restoreIssueFee() {
        this.mCustomInfo.restoreCustomIssueFee();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public Bundle getCustomFeeExtra(PayableCardInfo payableCardInfo) {
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("configId", this.mCustomInfo.getCustomConfigId());
            jSONObject.put("useCustomFee", true);
            jSONObject.put("customIssueFee", getIssueFee());
            jSONObject.put("customRechargeFee", getRechargeFee());
            jSONObject.put("actionType", (payableCardInfo.mHasIssue ? CardActionType.RECHARGE : CardActionType.ISSUE).name());
            bundle.putString("extraCustomFee", jSONObject.toString());
        } catch (JSONException e) {
            LogUtils.e("getCustomFeeExtra called, but occur a error.", e);
        }
        return bundle;
    }

    public int getMinFee() {
        return this.mCustomInfo.getMinFee();
    }

    public int getMaxFee() {
        return this.mCustomInfo.getMaxFee();
    }

    public boolean isValid() {
        return this.mCustomInfo != null;
    }

    private CustomFeeInfo(Parcel parcel) {
        this.mCustomFee = Integer.MIN_VALUE;
        readFromParcel(parcel);
    }

    public int describeContents() {
        return super.describeContents();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mCustomInfo, i);
        parcel.writeInt(this.mCustomFee);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mCustomInfo = (CustomInfo) parcel.readParcelable(CustomInfo.class.getClassLoader());
        this.mCustomFee = parcel.readInt();
    }

    public JSONObject serialize() {
        return new JSONObject();
    }
}

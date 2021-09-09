package com.miui.tsmclient.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FeeInfo implements Parcelable, JSONSerializable, ObjectParser<FeeInfo> {
    public static final Parcelable.Creator<FeeInfo> CREATOR = new Parcelable.Creator<FeeInfo>() {
        /* class com.miui.tsmclient.entity.FeeInfo.AnonymousClass1 */

        public final FeeInfo createFromParcel(Parcel parcel) {
            return new FeeInfo(parcel);
        }

        public final FeeInfo[] newArray(int i) {
            return new FeeInfo[i];
        }
    };
    public ActionType mActionType;
    private CouponInfo mCouponInfo;
    public int mDisplayFee;
    private String mExtra;
    private boolean mHasCoupon;
    public int mId;
    private boolean mIsRecommend;
    public String mMsg;
    public int mPayFee;
    public int mQuantity;
    public int mRechargeFee;
    private boolean mSuggested;

    public int describeContents() {
        return 0;
    }

    public boolean isCustomFee() {
        return false;
    }

    public void restoreIssueFee() {
    }

    public void restoreRechargeFee() {
    }

    public enum ActionType {
        unknown(0),
        issue(1),
        recharge(2),
        withdraw(3),
        issueAndRecharge(12);
        
        private int mId;

        private ActionType(int i) {
            this.mId = i;
        }

        public final int getId() {
            return this.mId;
        }

        public static ActionType newInstance(int i) {
            for (ActionType actionType : values()) {
                if (actionType.mId == i) {
                    return actionType;
                }
            }
            return unknown;
        }
    }

    public FeeInfo() {
    }

    private FeeInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mDisplayFee);
        parcel.writeInt(this.mPayFee);
        parcel.writeInt(this.mRechargeFee);
        parcel.writeInt(this.mQuantity);
        parcel.writeString(this.mMsg);
        parcel.writeValue(this.mActionType);
        parcel.writeByte(this.mSuggested ? (byte) 1 : 0);
        parcel.writeByte(this.mHasCoupon ? (byte) 1 : 0);
        parcel.writeByte(this.mIsRecommend ? (byte) 1 : 0);
        parcel.writeString(this.mExtra);
    }

    public void readFromParcel(Parcel parcel) {
        this.mId = parcel.readInt();
        this.mDisplayFee = parcel.readInt();
        this.mPayFee = parcel.readInt();
        this.mRechargeFee = parcel.readInt();
        this.mQuantity = parcel.readInt();
        this.mMsg = parcel.readString();
        this.mActionType = (ActionType) parcel.readValue(ActionType.class.getClassLoader());
        boolean z = true;
        this.mSuggested = parcel.readByte() != 0;
        this.mHasCoupon = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.mIsRecommend = z;
        this.mExtra = parcel.readString();
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feeId", this.mId);
            jSONObject.put("displayFee", this.mDisplayFee);
            jSONObject.put("payFee", this.mPayFee);
            jSONObject.put("rechargeFee", this.mRechargeFee);
            jSONObject.put("amount", this.mQuantity);
            jSONObject.put("msg", this.mMsg);
            jSONObject.put("actionType", this.mActionType.getId());
            jSONObject.put("suggested", this.mSuggested);
            jSONObject.put("useCoupon", this.mHasCoupon);
            jSONObject.put("recommend", this.mIsRecommend);
            if (!TextUtils.isEmpty(this.mExtra)) {
                jSONObject.put("extra", this.mExtra);
            }
        } catch (JSONException e) {
            LogUtils.e("serialize fee info failed.", e);
        }
        return jSONObject;
    }

    public FeeInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optInt("feeId");
            this.mDisplayFee = jSONObject.optInt("displayFee");
            this.mPayFee = jSONObject.optInt("payFee");
            this.mRechargeFee = jSONObject.optInt("rechargeFee");
            this.mQuantity = jSONObject.optInt("amount");
            this.mMsg = jSONObject.optString("msg");
            this.mActionType = ActionType.newInstance(jSONObject.optInt("actionType"));
            this.mSuggested = jSONObject.optBoolean("suggested");
            this.mHasCoupon = jSONObject.optBoolean("useCoupon");
            this.mIsRecommend = jSONObject.optBoolean("recommend");
            if (jSONObject.has("extra")) {
                this.mExtra = jSONObject.optString("extra");
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FeeInfo) && ((FeeInfo) obj).mId == this.mId;
    }

    public int hashCode() {
        return this.mId;
    }

    public boolean isValidRechargeFee() {
        return this.mRechargeFee >= 0;
    }

    public boolean isSuggested() {
        return this.mSuggested;
    }

    public boolean hasCoupon() {
        return this.mHasCoupon;
    }

    public boolean isRecommend() {
        return this.mIsRecommend;
    }

    public int getPayFee() {
        return this.mPayFee;
    }

    public int getIssueFee() {
        return getPayFee() - getRechargeFee();
    }

    public CouponInfo getCouponInfo() {
        return this.mCouponInfo;
    }

    public void setCouponInfo(CouponInfo couponInfo) {
        this.mCouponInfo = couponInfo;
    }

    public int getDiscountIssueFee() {
        CouponInfo couponInfo = this.mCouponInfo;
        if (couponInfo != null) {
            return couponInfo.getIssuePayFee();
        }
        return getIssueFee();
    }

    public int getRechargeFee() {
        return this.mRechargeFee;
    }

    public void setRechargeFee(int i) {
        this.mRechargeFee = i;
    }

    public boolean hasDiscountIssueFee(int i) {
        return i != getIssueFee();
    }

    public int getDiscountPayFee() {
        CouponInfo couponInfo = this.mCouponInfo;
        if (couponInfo != null) {
            return couponInfo.getTotalPayFee();
        }
        return getPayFee();
    }

    public int getDiscountPayFee(CardInfo cardInfo) {
        CouponInfo couponInfo = this.mCouponInfo;
        if (couponInfo != null) {
            return couponInfo.getTotalPayFee();
        }
        return getPayFee();
    }

    public Bundle getCustomFeeExtra(PayableCardInfo payableCardInfo) {
        return Bundle.EMPTY;
    }

    public String getExtra() {
        return this.mExtra;
    }
}

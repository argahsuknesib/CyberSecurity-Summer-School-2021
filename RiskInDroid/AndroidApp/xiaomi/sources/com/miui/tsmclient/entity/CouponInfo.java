package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CouponInfo implements Parcelable {
    public static final Parcelable.Creator<CouponInfo> CREATOR = new Parcelable.Creator<CouponInfo>() {
        /* class com.miui.tsmclient.entity.CouponInfo.AnonymousClass1 */

        public final CouponInfo createFromParcel(Parcel parcel) {
            return new CouponInfo(parcel);
        }

        public final CouponInfo[] newArray(int i) {
            return new CouponInfo[0];
        }
    };
    @SerializedName("couponId")
    private long mCouponId;
    @SerializedName("name")
    private String mCouponName;
    @SerializedName("desc")
    private String mDesc;
    @SerializedName("extra")
    private String mExtra;
    @SerializedName("issueDiscount")
    private int mIssueDiscount;
    @SerializedName("issuePayFee")
    private int mIssuePayFee;
    @SerializedName("rechargeDiscount")
    private int mRechargeDiscount;
    @SerializedName("rechargePayFee")
    private int mRechargePayFee;
    @SerializedName("totalDiscount")
    private int mTotalDiscount;
    @SerializedName("totalPayFee")
    private int mTotalPayFee;
    @SerializedName("valid")
    private boolean mValid;

    public int describeContents() {
        return 0;
    }

    public CouponInfo() {
    }

    private CouponInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mCouponId);
        parcel.writeString(this.mCouponName);
        parcel.writeInt(this.mIssueDiscount);
        parcel.writeInt(this.mRechargeDiscount);
        parcel.writeInt(this.mTotalDiscount);
        parcel.writeInt(this.mIssuePayFee);
        parcel.writeInt(this.mRechargePayFee);
        parcel.writeInt(this.mTotalPayFee);
        parcel.writeByte(this.mValid ? (byte) 1 : 0);
        parcel.writeString(this.mDesc);
        parcel.writeString(this.mExtra);
    }

    /* access modifiers changed from: protected */
    public void readFromParcel(Parcel parcel) {
        this.mCouponId = parcel.readLong();
        this.mCouponName = parcel.readString();
        this.mIssueDiscount = parcel.readInt();
        this.mRechargeDiscount = parcel.readInt();
        this.mTotalDiscount = parcel.readInt();
        this.mIssuePayFee = parcel.readInt();
        this.mRechargePayFee = parcel.readInt();
        this.mTotalPayFee = parcel.readInt();
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.mValid = z;
        this.mDesc = parcel.readString();
        this.mExtra = parcel.readString();
    }

    public void setValid(boolean z) {
        this.mValid = z;
    }

    public boolean isValid() {
        return this.mValid;
    }

    public long getCouponId() {
        return this.mCouponId;
    }

    public void setCouponName(String str) {
        this.mCouponName = str;
    }

    public String getCouponName() {
        return this.mCouponName;
    }

    public int getIssueDiscount() {
        return this.mIssueDiscount;
    }

    public int getRechargeDiscount() {
        return this.mRechargeDiscount;
    }

    public int getTotalDiscount() {
        return this.mTotalDiscount;
    }

    public int getIssuePayFee() {
        return this.mIssuePayFee;
    }

    public int getRechargePayFee() {
        return this.mRechargePayFee;
    }

    public int getTotalPayFee() {
        return this.mTotalPayFee;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}

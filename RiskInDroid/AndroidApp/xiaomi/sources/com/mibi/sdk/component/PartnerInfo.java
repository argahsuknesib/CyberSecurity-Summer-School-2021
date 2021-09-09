package com.mibi.sdk.component;

import android.os.Parcel;
import android.os.Parcelable;

public class PartnerInfo implements Parcelable {
    public static final Parcelable.Creator<PartnerInfo> CREATOR = new Parcelable.Creator<PartnerInfo>() {
        /* class com.mibi.sdk.component.PartnerInfo.AnonymousClass1 */

        public final PartnerInfo createFromParcel(Parcel parcel) {
            return new PartnerInfo(parcel);
        }

        public final PartnerInfo[] newArray(int i) {
            return new PartnerInfo[i];
        }
    };
    private String accountType;
    private long marketType;
    private long rechargePrice;
    private String token;
    private String userId;

    public int describeContents() {
        return 0;
    }

    public PartnerInfo() {
    }

    public PartnerInfo(String str) {
        this.userId = str;
    }

    public PartnerInfo(String str, String str2) {
        this.userId = str;
        this.accountType = str2;
    }

    public PartnerInfo(String str, String str2, long j) {
        this.userId = str;
        this.accountType = str2;
        this.marketType = j;
    }

    private PartnerInfo(Parcel parcel) {
        this.userId = parcel.readString();
        this.accountType = parcel.readString();
        this.marketType = parcel.readLong();
        this.rechargePrice = parcel.readLong();
        this.token = parcel.readString();
    }

    public long getMarketType() {
        return this.marketType;
    }

    public void setMarketType(long j) {
        this.marketType = j;
    }

    public long getRechargePrice() {
        return this.rechargePrice;
    }

    public void setRechargePrice(long j) {
        this.rechargePrice = j;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getToken() {
        return this.token;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.accountType);
        parcel.writeLong(this.marketType);
        parcel.writeLong(this.rechargePrice);
        parcel.writeString(this.token);
    }
}

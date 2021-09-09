package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

public class InAppPromotionData implements Parcelable {
    public static final Parcelable.Creator<InAppPromotionData> CREATOR = new Parcelable.Creator<InAppPromotionData>() {
        /* class com.miui.tsmclient.entity.InAppPromotionData.AnonymousClass1 */

        public final InAppPromotionData createFromParcel(Parcel parcel) {
            return new InAppPromotionData(parcel);
        }

        public final InAppPromotionData[] newArray(int i) {
            return new InAppPromotionData[i];
        }
    };
    @SerializedName("discount_value")
    private long mPromotionAmount;
    @SerializedName("available")
    private String mPromotionAvailable;
    @SerializedName("value")
    private String mPromotionId;
    @SerializedName("label")
    private String mPromotionTitle;
    @SerializedName("rel_value")
    private long mRealPayAmount;

    public int describeContents() {
        return 0;
    }

    protected InAppPromotionData(Parcel parcel) {
        this.mPromotionTitle = parcel.readString();
        this.mPromotionId = parcel.readString();
        this.mPromotionAvailable = parcel.readString();
        this.mRealPayAmount = parcel.readLong();
        this.mPromotionAmount = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPromotionTitle);
        parcel.writeString(this.mPromotionId);
        parcel.writeString(this.mPromotionAvailable);
        parcel.writeLong(this.mRealPayAmount);
        parcel.writeLong(this.mPromotionAmount);
    }

    public String getPromotionTitle() {
        return this.mPromotionTitle;
    }

    public String getPromotionId() {
        return this.mPromotionId;
    }

    public boolean isPromotionAvailable() {
        return TextUtils.equals(this.mPromotionAvailable, "0");
    }

    public long getRealPayAmount() {
        return this.mRealPayAmount;
    }

    public long getPromotionAmount() {
        return this.mPromotionAmount;
    }
}

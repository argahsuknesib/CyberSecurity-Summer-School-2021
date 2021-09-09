package com.mi.global.shop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class UserCentralTip implements Parcelable {
    public static final Parcelable.Creator<UserCentralTip> CREATOR = new Parcelable.Creator<UserCentralTip>() {
        /* class com.mi.global.shop.model.UserCentralTip.AnonymousClass1 */

        public final UserCentralTip createFromParcel(Parcel parcel) {
            return new UserCentralTip(parcel);
        }

        public final UserCentralTip[] newArray(int i) {
            return new UserCentralTip[i];
        }
    };
    @SerializedName("img")
    public String mBgImageUrl;
    @SerializedName("tips")
    public String mChickenSoup;
    @SerializedName("greeting")
    public String mTimeGreetings;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBgImageUrl);
        parcel.writeString(this.mTimeGreetings);
        parcel.writeString(this.mChickenSoup);
    }

    public UserCentralTip() {
    }

    private UserCentralTip(Parcel parcel) {
        this.mBgImageUrl = parcel.readString();
        this.mTimeGreetings = parcel.readString();
        this.mChickenSoup = parcel.readString();
    }

    public String toString() {
        return "UserCentralTip{mBgImageUrl='" + this.mBgImageUrl + '\'' + ", mTimeGreetings='" + this.mTimeGreetings + '\'' + ", mChickenSoup='" + this.mChickenSoup + '\'' + '}';
    }
}

package com.miui.whetstone;

import android.os.Parcel;
import android.os.Parcelable;

public class WhetstoneResult implements Parcelable {
    public static final Parcelable.Creator<WhetstoneResult> CREATOR = new Parcelable.Creator<WhetstoneResult>() {
        /* class com.miui.whetstone.WhetstoneResult.AnonymousClass1 */

        public final WhetstoneResult createFromParcel(Parcel parcel) {
            return new WhetstoneResult(parcel);
        }

        public final WhetstoneResult[] newArray(int i) {
            return new WhetstoneResult[i];
        }
    };
    private int mCode;

    public int describeContents() {
        return 0;
    }

    public WhetstoneResult(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCode);
    }

    public void readFromParcel(Parcel parcel) {
        this.mCode = parcel.readInt();
    }

    private WhetstoneResult(Parcel parcel) {
        readFromParcel(parcel);
    }
}

package com.xiaomi.youpin.common.base;

import android.os.Parcel;
import android.os.Parcelable;

public class YouPinError extends Error implements Parcelable {
    public static final Parcelable.Creator<YouPinError> CREATOR = new Parcelable.Creator<YouPinError>() {
        /* class com.xiaomi.youpin.common.base.YouPinError.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new YouPinError[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new YouPinError(parcel);
        }
    };
    private int mCode;
    private String mDetail;

    public int describeContents() {
        return 0;
    }

    public YouPinError(int i, String str) {
        this.mCode = i;
        this.mDetail = str;
    }

    protected YouPinError(Parcel parcel) {
        this.mCode = parcel.readInt();
        this.mDetail = parcel.readString();
    }

    public final int getCode() {
        return this.mCode;
    }

    public final String getDetail() {
        return this.mDetail;
    }

    public String toString() {
        return "YouPinError{code=" + this.mCode + ", detail='" + this.mDetail + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCode);
        parcel.writeString(this.mDetail);
    }
}

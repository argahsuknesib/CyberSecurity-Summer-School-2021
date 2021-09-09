package com.ximalaya.ting.android.opensdk.model.advertis;

import android.os.Parcel;
import android.os.Parcelable;

public class AdShareDataForOpenSDK implements Parcelable {
    public static final Parcelable.Creator<AdShareDataForOpenSDK> CREATOR = new Parcelable.Creator<AdShareDataForOpenSDK>() {
        /* class com.ximalaya.ting.android.opensdk.model.advertis.AdShareDataForOpenSDK.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AdShareDataForOpenSDK[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AdShareDataForOpenSDK(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f12167O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private boolean O00000oO;

    public int describeContents() {
        return 0;
    }

    public AdShareDataForOpenSDK() {
    }

    protected AdShareDataForOpenSDK(Parcel parcel) {
        this.f12167O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12167O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeByte(this.O00000oO ? (byte) 1 : 0);
    }
}

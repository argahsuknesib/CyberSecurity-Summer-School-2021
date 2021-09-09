package com.xiaomi.smarthome.ad.api;

import android.os.Parcel;
import android.os.Parcelable;

public class AdExt implements Parcelable {
    public static final Parcelable.Creator<AdExt> CREATOR = new Parcelable.Creator<AdExt>() {
        /* class com.xiaomi.smarthome.ad.api.AdExt.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AdExt[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AdExt(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f4147O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;

    public int describeContents() {
        return 0;
    }

    protected AdExt(Parcel parcel) {
        this.f4147O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
    }

    public AdExt() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4147O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
    }

    public String toString() {
        return "AdExt{title='" + this.f4147O000000o + '\'' + ", msg='" + this.O00000Oo + '\'' + ", left='" + this.O00000o0 + '\'' + ", right='" + this.O00000o + '\'' + '}';
    }
}

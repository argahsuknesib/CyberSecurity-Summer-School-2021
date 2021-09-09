package com.xiaomi.smarthome.newui.amappoi;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationBean implements Parcelable {
    public static final Parcelable.Creator<LocationBean> CREATOR = new Parcelable.Creator<LocationBean>() {
        /* class com.xiaomi.smarthome.newui.amappoi.LocationBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LocationBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public double f10197O000000o;
    public double O00000Oo;
    String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public LocationBean(double d, double d2, String str, String str2) {
        this.f10197O000000o = d;
        this.O00000Oo = d2;
        this.O00000o0 = str;
        this.O00000o = str2;
    }

    public LocationBean(double d, double d2, String str, String str2, String str3, String str4, String str5) {
        this.f10197O000000o = d;
        this.O00000Oo = d2;
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = str3;
        this.O00000oo = str4;
        this.O0000O0o = str5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f10197O000000o);
        parcel.writeDouble(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }

    protected LocationBean(Parcel parcel) {
        this.f10197O000000o = parcel.readDouble();
        this.O00000Oo = parcel.readDouble();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
    }
}

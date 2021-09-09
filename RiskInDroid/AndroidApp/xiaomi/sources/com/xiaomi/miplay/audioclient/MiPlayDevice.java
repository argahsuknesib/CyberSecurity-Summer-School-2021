package com.xiaomi.miplay.audioclient;

import android.os.Parcel;
import android.os.Parcelable;

public class MiPlayDevice implements Parcelable {
    public static final Parcelable.Creator<MiPlayDevice> CREATOR = new Parcelable.Creator<MiPlayDevice>() {
        /* class com.xiaomi.miplay.audioclient.MiPlayDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiPlayDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiPlayDevice(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6039O000000o;
    public String O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo;
    private float O0000o = 0.0f;
    public int O0000o0;
    public int O0000o00;
    public int O0000o0O;
    private float O0000o0o = 0.0f;
    private int O0000oO0 = 0;

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MiPlayDevice) || ((MiPlayDevice) obj).f6039O000000o != this.f6039O000000o) {
            return false;
        }
        return true;
    }

    public MiPlayDevice() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6039O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeFloat(this.O0000o0o);
        parcel.writeFloat(this.O0000o);
        parcel.writeInt(this.O0000oO0);
    }

    protected MiPlayDevice(Parcel parcel) {
        this.f6039O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000oO = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readInt();
        this.O0000o0 = parcel.readInt();
        this.O0000o0O = parcel.readInt();
        this.O0000o0o = parcel.readFloat();
        this.O0000o = parcel.readFloat();
        this.O0000oO0 = parcel.readInt();
    }
}

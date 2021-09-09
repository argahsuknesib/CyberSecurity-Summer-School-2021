package com.mijia.camera.nas;

import android.os.Parcel;
import android.os.Parcelable;

public class NASMakeDirInfo implements Parcelable {
    public static final Parcelable.Creator<NASMakeDirInfo> CREATOR = new Parcelable.Creator<NASMakeDirInfo>() {
        /* class com.mijia.camera.nas.NASMakeDirInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NASMakeDirInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NASMakeDirInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5187O000000o;
    public String O00000Oo;
    public String O00000o;
    public long O00000o0;
    public String O00000oO = "";
    public String O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public NASMakeDirInfo() {
    }

    protected NASMakeDirInfo(Parcel parcel) {
        this.f5187O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readLong();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5187O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }
}

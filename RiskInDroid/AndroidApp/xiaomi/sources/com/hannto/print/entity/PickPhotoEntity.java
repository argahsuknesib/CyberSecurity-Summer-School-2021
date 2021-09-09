package com.hannto.print.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class PickPhotoEntity implements Parcelable {
    public static final Parcelable.Creator<PickPhotoEntity> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f4346O000000o;
    public int O00000Oo;
    public boolean O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;

    public static class O000000o implements Parcelable.Creator<PickPhotoEntity> {
        public final Object createFromParcel(Parcel parcel) {
            return new PickPhotoEntity(parcel);
        }

        public final Object[] newArray(int i) {
            return new PickPhotoEntity[i];
        }
    }

    public PickPhotoEntity(int i, int i2, int i3, boolean z, boolean z2, String str, int i4, int i5, int i6, int i7) {
        this.f4346O000000o = 9;
        this.O00000Oo = 960;
        this.O00000o0 = 960;
        this.O00000o = false;
        this.O00000oO = true;
        this.O0000O0o = 0;
        this.O0000OOo = 2400;
        this.O0000Oo0 = 3600;
        this.O0000Oo = 10240;
        this.f4346O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = z;
        this.O00000oO = z2;
        this.O00000oo = str;
        this.O0000O0o = i4;
        this.O0000OOo = i5;
        this.O0000Oo0 = i6;
        this.O0000Oo = i7;
    }

    public PickPhotoEntity(Parcel parcel) {
        this.f4346O000000o = 9;
        this.O00000Oo = 960;
        this.O00000o0 = 960;
        boolean z = false;
        this.O00000o = false;
        this.O00000oO = true;
        this.O0000O0o = 0;
        this.O0000OOo = 2400;
        this.O0000Oo0 = 3600;
        this.O0000Oo = 10240;
        this.f4346O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readByte() != 0;
        this.O00000oO = parcel.readByte() != 0 ? true : z;
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
    }

    public final String O000000o() {
        String str = this.O00000oo;
        return str == null ? "" : str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4346O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000oO ? (byte) 1 : 0);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
    }
}

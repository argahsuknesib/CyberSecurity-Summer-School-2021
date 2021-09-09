package com.xiaomi.smarthome.library.file;

import android.os.Parcel;
import android.os.Parcelable;

public class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>() {
        /* class com.xiaomi.smarthome.library.file.FileInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FileInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            FileInfo fileInfo = new FileInfo();
            boolean z = true;
            fileInfo.f9340O000000o = parcel.readByte() != 0;
            fileInfo.O00000Oo = parcel.readByte() != 0;
            fileInfo.O00000o0 = parcel.readInt();
            fileInfo.O00000o = parcel.readString();
            fileInfo.O00000oO = parcel.readString();
            fileInfo.O00000oo = parcel.readLong();
            fileInfo.O0000O0o = parcel.readLong();
            fileInfo.O0000OOo = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            fileInfo.O0000Oo0 = z;
            fileInfo.O0000Oo = parcel.readString();
            return fileInfo;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9340O000000o;
    public boolean O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public long O00000oo;
    public long O0000O0o;
    public boolean O0000OOo;
    public String O0000Oo;
    public boolean O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f9340O000000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeLong(this.O0000O0o);
        parcel.writeByte(this.O0000OOo ? (byte) 1 : 0);
        parcel.writeByte(this.O0000Oo0 ? (byte) 1 : 0);
        parcel.writeString(this.O0000Oo);
    }
}

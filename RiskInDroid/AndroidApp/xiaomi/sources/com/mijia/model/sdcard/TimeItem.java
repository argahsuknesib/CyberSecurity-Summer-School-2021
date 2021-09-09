package com.mijia.model.sdcard;

import _m_j.cin;
import android.os.Parcel;
import android.os.Parcelable;
import com.mijia.model.CameraImageLoader;
import com.tutk.IOTC.Packet;

public class TimeItem implements Parcelable, Comparable<TimeItem> {
    public static final Parcelable.Creator<TimeItem> CREATOR = new Parcelable.Creator<TimeItem>() {
        /* class com.mijia.model.sdcard.TimeItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimeItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TimeItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f5243O000000o;
    public long O00000Oo;
    public int O00000o;
    public long O00000o0;
    public int O00000oO;
    public boolean O00000oo = false;

    public static int O000000o() {
        return 8;
    }

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return (int) (this.f5243O000000o - ((TimeItem) obj).f5243O000000o);
    }

    private TimeItem(long j, long j2, int i, boolean z) {
        this.f5243O000000o = j;
        this.O00000Oo = j2;
        this.O00000o0 = j + j2;
        this.O00000oO = i;
        this.O00000oo = z;
    }

    protected TimeItem(Parcel parcel) {
        this.f5243O000000o = parcel.readLong();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readLong();
        this.O00000oO = parcel.readInt();
    }

    public final String O000000o(String str) {
        return CameraImageLoader.f5226O000000o + str + CameraImageLoader.O00000Oo + String.valueOf(this.f5243O000000o);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5243O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
        parcel.writeInt(this.O00000oO);
    }

    public static TimeItem O000000o(byte[] bArr, int i, boolean z) {
        long byteArrayToInt = ((long) Packet.byteArrayToInt(bArr, i, z)) * 1000;
        long j = ((long) (bArr[i + 4] & 255)) * 1000;
        byte b = bArr[i + 5] & 255;
        byte b2 = bArr[i + 6] & 255;
        if ((bArr[i + 7] & 255) != 0) {
            byteArrayToInt = 0;
        }
        return new TimeItem(byteArrayToInt, j, b2, b == 1);
    }

    public static TimeItem O000000o(String str, byte[] bArr, int i, boolean z) {
        long byteArrayToInt = ((long) Packet.byteArrayToInt(bArr, i, z)) * 1000;
        long j = ((long) (bArr[i + 4] & 255)) * 1000;
        byte b = bArr[i + 5] & 255;
        byte b2 = bArr[i + 6] & 255;
        int i2 = i + 7;
        byte b3 = bArr[i2] & 255;
        if (cin.O00000oO(str)) {
            b3 = bArr[i2] & 1;
        }
        if (b3 != 0) {
            byteArrayToInt = 0;
        }
        return new TimeItem(byteArrayToInt, j, b2, b == 1);
    }

    public int hashCode() {
        return (int) (this.f5243O000000o / 1000);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TimeItem) || this.f5243O000000o != ((TimeItem) obj).f5243O000000o) {
            return false;
        }
        return true;
    }
}

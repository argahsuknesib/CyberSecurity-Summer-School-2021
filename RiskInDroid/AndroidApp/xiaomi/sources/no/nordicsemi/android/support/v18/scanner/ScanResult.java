package no.nordicsemi.android.support.v18.scanner;

import _m_j.jar;
import _m_j.jau;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class ScanResult implements Parcelable {
    public static final Parcelable.Creator<ScanResult> CREATOR = new Parcelable.Creator<ScanResult>() {
        /* class no.nordicsemi.android.support.v18.scanner.ScanResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ScanResult(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public BluetoothDevice f15416O000000o;
    public jau O00000Oo;
    public long O00000o;
    public int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ ScanResult(Parcel parcel, byte b) {
        this(parcel);
    }

    public ScanResult(BluetoothDevice bluetoothDevice, jau jau, int i, long j) {
        this.f15416O000000o = bluetoothDevice;
        this.O00000Oo = jau;
        this.O00000o0 = i;
        this.O00000o = j;
        this.O00000oO = 17;
        this.O00000oo = 1;
        this.O0000O0o = 0;
        this.O0000OOo = 255;
        this.O0000Oo0 = 127;
        this.O0000Oo = 0;
    }

    public ScanResult(BluetoothDevice bluetoothDevice, int i, int i2, int i3, int i4, int i5, int i6, int i7, jau jau, long j) {
        this.f15416O000000o = bluetoothDevice;
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000O0o = i3;
        this.O0000OOo = i4;
        this.O0000Oo0 = i5;
        this.O00000o0 = i6;
        this.O0000Oo = i7;
        this.O00000Oo = jau;
        this.O00000o = j;
    }

    private ScanResult(Parcel parcel) {
        this.f15416O000000o = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        if (parcel.readInt() == 1) {
            this.O00000Oo = jau.O000000o(parcel.createByteArray());
        }
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readLong();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        this.f15416O000000o.writeToParcel(parcel, i);
        if (this.O00000Oo != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.O00000Oo.O00000o0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.O00000o0);
        parcel.writeLong(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f15416O000000o, Integer.valueOf(this.O00000o0), this.O00000Oo, Long.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Integer.valueOf(this.O0000OOo), Integer.valueOf(this.O0000Oo0), Integer.valueOf(this.O0000Oo)});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScanResult scanResult = (ScanResult) obj;
            return jar.O00000Oo(this.f15416O000000o, scanResult.f15416O000000o) && this.O00000o0 == scanResult.O00000o0 && jar.O00000Oo(this.O00000Oo, scanResult.O00000Oo) && this.O00000o == scanResult.O00000o && this.O00000oO == scanResult.O00000oO && this.O00000oo == scanResult.O00000oo && this.O0000O0o == scanResult.O0000O0o && this.O0000OOo == scanResult.O0000OOo && this.O0000Oo0 == scanResult.O0000Oo0 && this.O0000Oo == scanResult.O0000Oo;
        }
    }

    public final String toString() {
        return "ScanResult{device=" + this.f15416O000000o + ", scanRecord=" + jar.O000000o(this.O00000Oo) + ", rssi=" + this.O00000o0 + ", timestampNanos=" + this.O00000o + ", eventType=" + this.O00000oO + ", primaryPhy=" + this.O00000oo + ", secondaryPhy=" + this.O0000O0o + ", advertisingSid=" + this.O0000OOo + ", txPower=" + this.O0000Oo0 + ", periodicAdvertisingInterval=" + this.O0000Oo + '}';
    }
}

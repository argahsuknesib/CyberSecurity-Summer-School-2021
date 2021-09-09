package com.xiaomi.smarthome.library.bluetooth.search;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

public class BluetoothSearchResult implements Parcelable {
    public static final Parcelable.Creator<BluetoothSearchResult> CREATOR = new Parcelable.Creator<BluetoothSearchResult>() {
        /* class com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BluetoothSearchResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BluetoothSearchResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public BluetoothDevice f9076O000000o;
    public int O00000Oo;
    public int O00000o;
    public byte[] O00000o0;
    public String O00000oO;

    public int describeContents() {
        return 0;
    }

    public BluetoothSearchResult() {
    }

    public BluetoothSearchResult(BluetoothDevice bluetoothDevice) {
        this.f9076O000000o = bluetoothDevice;
    }

    public BluetoothSearchResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.f9076O000000o = bluetoothDevice;
        this.O00000Oo = i;
        this.O00000o0 = bArr;
    }

    public final String O000000o() {
        BluetoothDevice bluetoothDevice = this.f9076O000000o;
        return bluetoothDevice != null ? bluetoothDevice.getAddress() : "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = " + this.O00000oO);
        sb.append(", mac = " + this.f9076O000000o.getAddress());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9076O000000o, 0);
        parcel.writeInt(this.O00000Oo);
        parcel.writeByteArray(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    public BluetoothSearchResult(Parcel parcel) {
        this.f9076O000000o = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.createByteArray();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readString();
    }
}

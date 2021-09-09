package com.inuker.bluetooth.library.search;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class SearchResult implements Parcelable {
    public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
        /* class com.inuker.bluetooth.library.search.SearchResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public BluetoothDevice f4495O000000o;
    public int O00000Oo;
    public byte[] O00000o;
    public String O00000o0;

    public int describeContents() {
        return 0;
    }

    public SearchResult(BluetoothDevice bluetoothDevice) {
        this(bluetoothDevice, 0, null);
    }

    public SearchResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.f4495O000000o = bluetoothDevice;
        this.O00000Oo = i;
        this.O00000o = bArr;
        this.O00000o0 = bluetoothDevice.getName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", mac = " + this.f4495O000000o.getAddress());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4495O000000o, 0);
        parcel.writeInt(this.O00000Oo);
        parcel.writeByteArray(this.O00000o);
        parcel.writeString(TextUtils.isEmpty(this.O00000o0) ? "NULL" : this.O00000o0);
    }

    public SearchResult(Parcel parcel) {
        this.f4495O000000o = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.O00000Oo = parcel.readInt();
        this.O00000o = parcel.createByteArray();
        this.O00000o0 = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4495O000000o.equals(((SearchResult) obj).f4495O000000o);
    }

    public int hashCode() {
        return this.f4495O000000o.hashCode();
    }
}

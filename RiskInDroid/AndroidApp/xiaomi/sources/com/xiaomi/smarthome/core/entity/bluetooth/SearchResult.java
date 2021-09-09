package com.xiaomi.smarthome.core.entity.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;

public class SearchResult implements Parcelable {
    public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
        /* class com.xiaomi.smarthome.core.entity.bluetooth.SearchResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SearchResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SearchResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public BluetoothDevice f6724O000000o;
    public int O00000Oo;
    public int O00000o;
    public byte[] O00000o0;
    public String O00000oO;

    public int describeContents() {
        return 0;
    }

    public SearchResult() {
    }

    public SearchResult(BluetoothSearchResult bluetoothSearchResult) {
        this.f6724O000000o = bluetoothSearchResult.f9076O000000o;
        this.O00000Oo = bluetoothSearchResult.O00000Oo;
        this.O00000o0 = bluetoothSearchResult.O00000o0;
        this.O00000o = bluetoothSearchResult.O00000o;
        this.O00000oO = bluetoothSearchResult.O00000oO;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = " + this.O00000oO);
        sb.append(", mac = " + this.f6724O000000o.getAddress());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6724O000000o, 0);
        parcel.writeInt(this.O00000Oo);
        parcel.writeByteArray(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
    }

    public SearchResult(Parcel parcel) {
        this.f6724O000000o = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.createByteArray();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readString();
    }
}

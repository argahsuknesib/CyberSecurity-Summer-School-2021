package com.inuker.bluetooth.library.connect.options;

import android.os.Parcel;
import android.os.Parcelable;

public class BleConnectOptions implements Parcelable {
    public static final Parcelable.Creator<BleConnectOptions> CREATOR = new Parcelable.Creator<BleConnectOptions>() {
        /* class com.inuker.bluetooth.library.connect.options.BleConnectOptions.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleConnectOptions[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleConnectOptions(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f4487O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f4488O000000o = 0;
        public int O00000Oo = 0;
        public int O00000o = 30000;
        public int O00000o0 = 30000;
    }

    public int describeContents() {
        return 0;
    }

    public BleConnectOptions(O000000o o000000o) {
        this.f4487O000000o = o000000o.f4488O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
    }

    protected BleConnectOptions(Parcel parcel) {
        this.f4487O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4487O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
    }

    public String toString() {
        return "BleConnectOptions{connectRetry=" + this.f4487O000000o + ", serviceDiscoverRetry=" + this.O00000Oo + ", connectTimeout=" + this.O00000o0 + ", serviceDiscoverTimeout=" + this.O00000o + '}';
    }
}

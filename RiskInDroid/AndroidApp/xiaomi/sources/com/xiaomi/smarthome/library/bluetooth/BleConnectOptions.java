package com.xiaomi.smarthome.library.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;

public class BleConnectOptions implements Parcelable {
    public static final Parcelable.Creator<BleConnectOptions> CREATOR = new Parcelable.Creator<BleConnectOptions>() {
        /* class com.xiaomi.smarthome.library.bluetooth.BleConnectOptions.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleConnectOptions[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleConnectOptions(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9072O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public String O00000oO = "";
    public BleComboWifiConfig O00000oo;

    public int describeContents() {
        return 0;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f9073O000000o = 0;
        public int O00000Oo = 1;
        public int O00000o = 30000;
        public int O00000o0 = 30000;

        public final BleConnectOptions O000000o() {
            return new BleConnectOptions(this);
        }
    }

    public BleConnectOptions(O000000o o000000o) {
        this.f9072O000000o = o000000o.f9073O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
    }

    protected BleConnectOptions(Parcel parcel) {
        this.f9072O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readString();
        this.O00000oo = (BleComboWifiConfig) parcel.readParcelable(BleConnectOptions.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9072O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeParcelable(this.O00000oo, i);
    }

    public String toString() {
        return "BleConnectOptions{connectRetry=" + this.f9072O000000o + ", serviceDiscoverRetry=" + this.O00000Oo + ", connectTimeout=" + this.O00000o0 + ", serviceDiscoverTimeout=" + this.O00000o + '}';
    }
}

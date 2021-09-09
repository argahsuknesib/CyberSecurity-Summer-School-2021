package com.xiaomi.smarthome.core.server.internal.bluetooth.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;

public class SecureConnectOptions implements Parcelable {
    public static final Parcelable.Creator<SecureConnectOptions> CREATOR = new Parcelable.Creator<SecureConnectOptions>() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SecureConnectOptions[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SecureConnectOptions(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    BleConnectOptions f6883O000000o;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SecureConnectOptions(byte b) {
        this();
    }

    private SecureConnectOptions() {
    }

    protected SecureConnectOptions(Parcel parcel) {
        this.f6883O000000o = (BleConnectOptions) parcel.readParcelable(BleConnectOptions.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6883O000000o, i);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public BleConnectOptions f6884O000000o;

        public final SecureConnectOptions O000000o() {
            SecureConnectOptions secureConnectOptions = new SecureConnectOptions((byte) 0);
            secureConnectOptions.f6883O000000o = this.f6884O000000o;
            return secureConnectOptions;
        }
    }
}

package com.xiaomi.smarthome.core.server.internal.bluetooth.blecore;

import android.os.Parcel;
import android.os.Parcelable;

public class BleKeyValuePair implements Parcelable {
    public static final Parcelable.Creator<BleKeyValuePair> CREATOR = new Parcelable.Creator<BleKeyValuePair>() {
        /* class com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BleKeyValuePair[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BleKeyValuePair(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6797O000000o;
    public final String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public BleKeyValuePair(String str, String str2) {
        this.f6797O000000o = str;
        this.O00000Oo = str2;
    }

    protected BleKeyValuePair(Parcel parcel) {
        this.f6797O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6797O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public String toString() {
        return this.f6797O000000o + ":" + this.O00000Oo;
    }
}

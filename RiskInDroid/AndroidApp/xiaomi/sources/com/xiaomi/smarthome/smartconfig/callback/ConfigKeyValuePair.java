package com.xiaomi.smarthome.smartconfig.callback;

import android.os.Parcel;
import android.os.Parcelable;

public class ConfigKeyValuePair implements Parcelable {
    public static final Parcelable.Creator<ConfigKeyValuePair> CREATOR = new Parcelable.Creator<ConfigKeyValuePair>() {
        /* class com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ConfigKeyValuePair[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ConfigKeyValuePair(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f11487O000000o;
    public final String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public ConfigKeyValuePair(String str, String str2) {
        this.f11487O000000o = str;
        this.O00000Oo = str2;
    }

    protected ConfigKeyValuePair(Parcel parcel) {
        this.f11487O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11487O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public String toString() {
        return this.f11487O000000o + ":" + this.O00000Oo;
    }
}

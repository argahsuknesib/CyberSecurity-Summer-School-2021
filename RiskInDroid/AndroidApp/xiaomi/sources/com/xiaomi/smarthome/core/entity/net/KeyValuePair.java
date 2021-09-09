package com.xiaomi.smarthome.core.entity.net;

import android.os.Parcel;
import android.os.Parcelable;

public class KeyValuePair implements Parcelable {
    public static final Parcelable.Creator<KeyValuePair> CREATOR = new Parcelable.Creator<KeyValuePair>() {
        /* class com.xiaomi.smarthome.core.entity.net.KeyValuePair.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KeyValuePair[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KeyValuePair(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f6728O000000o;
    public final String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public KeyValuePair(String str, String str2) {
        if (str != null) {
            this.f6728O000000o = str;
            this.O00000Oo = str2;
            return;
        }
        throw new IllegalArgumentException("Key may not be null");
    }

    protected KeyValuePair(Parcel parcel) {
        this.f6728O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6728O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public String toString() {
        return this.f6728O000000o + ":" + this.O00000Oo;
    }
}

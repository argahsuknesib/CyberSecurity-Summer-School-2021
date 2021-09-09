package com.xiaomi.youpin.core.net;

import android.os.Parcel;
import android.os.Parcelable;

public class KeyValuePair implements Parcelable {
    public static final Parcelable.Creator<KeyValuePair> CREATOR = new Parcelable.Creator<KeyValuePair>() {
        /* class com.xiaomi.youpin.core.net.KeyValuePair.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KeyValuePair[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KeyValuePair(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f12061O000000o;
    private final String O00000Oo;
    private final String O00000o0;

    public int describeContents() {
        return 0;
    }

    protected KeyValuePair(Parcel parcel) {
        this.f12061O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12061O000000o);
        parcel.writeString(this.O00000Oo);
        String str = this.O00000o0;
        if (str != null) {
            parcel.writeString(str);
        }
    }

    public String toString() {
        return this.f12061O000000o + ":" + this.O00000Oo + ":" + this.O00000o0;
    }
}

package com.xiaomi.youpin.login.other.http;

import android.os.Parcel;
import android.os.Parcelable;

public class KeyValuePair implements Parcelable {
    public static final Parcelable.Creator<KeyValuePair> CREATOR = new Parcelable.Creator<KeyValuePair>() {
        /* class com.xiaomi.youpin.login.other.http.KeyValuePair.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KeyValuePair[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KeyValuePair(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12090O000000o;
    public final String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public KeyValuePair(String str, String str2) {
        this.f12090O000000o = str;
        this.O00000Oo = str2;
    }

    protected KeyValuePair(Parcel parcel) {
        this.f12090O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12090O000000o);
        parcel.writeString(this.O00000Oo);
    }

    public String toString() {
        return "KeyValuePair{key='" + this.f12090O000000o + '\'' + ", value='" + this.O00000Oo + '\'' + '}';
    }
}

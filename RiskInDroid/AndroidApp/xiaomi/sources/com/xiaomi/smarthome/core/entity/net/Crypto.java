package com.xiaomi.smarthome.core.entity.net;

import android.os.Parcel;
import android.os.Parcelable;

public enum Crypto implements Parcelable {
    NONE,
    AES,
    RC4,
    HTTPS;
    
    public static final Parcelable.Creator<Crypto> CREATOR = new Parcelable.Creator<Crypto>() {
        /* class com.xiaomi.smarthome.core.entity.net.Crypto.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Crypto[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return Crypto.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}

package com.xiaomi.youpin.core.net;

import android.os.Parcel;
import android.os.Parcelable;

public enum ReqType implements Parcelable {
    AUTH,
    OPEN,
    OPEN_ST;
    
    public static final Parcelable.Creator<ReqType> CREATOR = new Parcelable.Creator<ReqType>() {
        /* class com.xiaomi.youpin.core.net.ReqType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReqType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ReqType.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}

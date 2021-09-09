package com.xiaomi.youpin.core.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.youpin.core.Error;

public class NetError extends Error {
    public static final Parcelable.Creator<NetError> CREATOR = new Parcelable.Creator<NetError>() {
        /* class com.xiaomi.youpin.core.net.NetError.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NetError[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NetError(parcel);
        }
    };

    public int describeContents() {
        return 0;
    }

    protected NetError(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}

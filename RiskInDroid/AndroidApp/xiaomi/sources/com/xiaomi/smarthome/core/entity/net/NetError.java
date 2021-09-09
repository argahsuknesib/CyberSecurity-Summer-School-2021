package com.xiaomi.smarthome.core.entity.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.core.entity.Error;

public class NetError extends Error {
    public static final Parcelable.Creator<NetError> CREATOR = new Parcelable.Creator<NetError>() {
        /* class com.xiaomi.smarthome.core.entity.net.NetError.AnonymousClass1 */

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

    public NetError(int i, String str) {
        super(i, str);
    }

    public NetError(int i, String str, String str2) {
        super(i, str, str2);
    }

    protected NetError(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}

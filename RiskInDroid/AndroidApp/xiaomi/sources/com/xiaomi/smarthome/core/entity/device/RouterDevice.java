package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;

public class RouterDevice extends MiioDevice {
    public static final Parcelable.Creator<RouterDevice> CREATOR = new Parcelable.Creator<RouterDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.RouterDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RouterDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RouterDevice(parcel);
        }
    };

    protected RouterDevice(Parcel parcel) {
        super(parcel);
    }

    public RouterDevice() {
    }
}

package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;

public class MiTVDevice extends MiioDevice {
    public static final Parcelable.Creator<MiTVDevice> CREATOR = new Parcelable.Creator<MiTVDevice>() {
        /* class com.xiaomi.smarthome.core.entity.device.MiTVDevice.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiTVDevice[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiTVDevice(parcel);
        }
    };
    private boolean mIsLocalSearchDevice;

    protected MiTVDevice(Parcel parcel) {
        super(parcel);
    }

    public MiTVDevice() {
    }

    public final synchronized void O000000o() {
        this.mIsLocalSearchDevice = true;
    }

    public void setShared(boolean z) {
        if (z) {
            setPermitLevel(getPermitLevel() | 4);
        } else {
            setPermitLevel(getPermitLevel() & -5);
        }
    }
}

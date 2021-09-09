package com.xiaomi.smarthome.config.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceRoomConfig implements Parcelable {
    public static final Parcelable.Creator<DeviceRoomConfig> CREATOR = new Parcelable.Creator<DeviceRoomConfig>() {
        /* class com.xiaomi.smarthome.config.model.DeviceRoomConfig.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceRoomConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceRoomConfig(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f6716O000000o;
    private final int O00000Oo;

    public int describeContents() {
        return 0;
    }

    public DeviceRoomConfig(int i, int i2) {
        this.f6716O000000o = i;
        this.O00000Oo = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6716O000000o);
        parcel.writeInt(this.O00000Oo);
    }

    protected DeviceRoomConfig(Parcel parcel) {
        this.f6716O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
    }
}

package com.xiaomi.miot;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public class DeviceInfo2 extends DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo2> CREATOR = new Parcelable.Creator<DeviceInfo2>() {
        /* class com.xiaomi.miot.DeviceInfo2.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceInfo2[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceInfo2(parcel);
        }
    };
    public boolean O0000Oo;

    public int describeContents() {
        return 0;
    }

    public DeviceInfo2() {
    }

    protected DeviceInfo2(Parcel parcel) {
        super(parcel);
        this.O0000Oo = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.O0000Oo ? (byte) 1 : 0);
    }
}

package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;

public enum ScanType implements Parcelable {
    ALL,
    BLUETOOTH;
    
    public static final Parcelable.Creator<ScanType> CREATOR = new Parcelable.Creator<ScanType>() {
        /* class com.xiaomi.smarthome.core.entity.device.ScanType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ScanType.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}

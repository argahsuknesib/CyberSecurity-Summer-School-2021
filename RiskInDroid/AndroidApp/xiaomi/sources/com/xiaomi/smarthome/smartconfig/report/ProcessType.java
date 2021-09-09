package com.xiaomi.smarthome.smartconfig.report;

import android.os.Parcel;
import android.os.Parcelable;

public enum ProcessType implements Parcelable {
    AP,
    COMBO,
    BLE,
    CAMERA;
    
    public static final Parcelable.Creator<ProcessType> CREATOR = new Parcelable.Creator<ProcessType>() {
        /* class com.xiaomi.smarthome.smartconfig.report.ProcessType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProcessType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ProcessType.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}

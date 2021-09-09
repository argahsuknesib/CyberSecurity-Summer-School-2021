package com.xiaomi.smarthome.core.entity.device;

import android.os.Parcel;
import android.os.Parcelable;

public enum ScanState implements Parcelable {
    START_SUCCESS,
    LOAD_CACHE_SUCCESS,
    SYNC_SERVER_SUCCESS,
    SYNC_SERVER_FAILED,
    SCAN_LOCAL_SUCCESS;
    
    public static final Parcelable.Creator<ScanState> CREATOR = new Parcelable.Creator<ScanState>() {
        /* class com.xiaomi.smarthome.core.entity.device.ScanState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ScanState.values()[parcel.readInt()];
        }
    };

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
    }
}

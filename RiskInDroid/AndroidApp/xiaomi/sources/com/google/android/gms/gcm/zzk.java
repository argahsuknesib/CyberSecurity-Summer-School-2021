package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

final class zzk implements Parcelable.Creator<PeriodicTask> {
    zzk() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PeriodicTask(parcel, (zzk) null);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PeriodicTask[i];
    }
}

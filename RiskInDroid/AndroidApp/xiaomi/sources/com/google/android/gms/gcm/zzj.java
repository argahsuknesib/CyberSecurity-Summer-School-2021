package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

final class zzj implements Parcelable.Creator<PendingCallback> {
    zzj() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PendingCallback(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PendingCallback[i];
    }
}

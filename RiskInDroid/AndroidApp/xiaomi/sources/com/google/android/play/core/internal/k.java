package com.google.android.play.core.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class k {
    static {
        k.class.getClassLoader();
    }

    private k() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return (Parcelable) creator.createFromParcel(parcel);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.IInterface, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void a(Parcel parcel, IInterface r1) {
        parcel.writeStrongBinder(r1);
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}

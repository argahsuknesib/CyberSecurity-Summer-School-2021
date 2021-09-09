package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class v extends j implements w {
    public v() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.IInterface] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        y yVar = null;
        if (i == 2) {
            Bundle bundle = (Bundle) k.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                ? queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                yVar = queryLocalInterface instanceof y ? queryLocalInterface : new x(readStrongBinder);
            }
            a(bundle, yVar);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            k.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                ? queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                yVar = queryLocalInterface2 instanceof y ? queryLocalInterface2 : new x(readStrongBinder2);
            }
            a(yVar);
            return true;
        }
    }
}

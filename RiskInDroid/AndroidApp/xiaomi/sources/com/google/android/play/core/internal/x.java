package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class x extends i implements y {
    x(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        k.a(a2, bundle);
        a(3, a2);
    }

    public final void a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a2 = a();
        k.a(a2, bundle);
        k.a(a2, bundle2);
        a(2, a2);
    }

    public final void b(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        k.a(a2, bundle);
        a(4, a2);
    }
}

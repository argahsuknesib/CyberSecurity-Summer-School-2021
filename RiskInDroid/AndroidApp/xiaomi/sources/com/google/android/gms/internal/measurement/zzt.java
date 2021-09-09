package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzt extends zzn implements zzr {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, bundle);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        Bundle bundle2 = (Bundle) zzp.zza(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        return bundle2;
    }
}

package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;

public final class zzo extends zza implements zzn {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    public final void zza(zzl zzl, zze zze) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzl);
        zzc.zza(obtainAndWriteInterfaceToken, zze);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }
}

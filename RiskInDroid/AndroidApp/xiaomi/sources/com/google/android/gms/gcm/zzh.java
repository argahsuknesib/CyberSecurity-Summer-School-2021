package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gcm.zzd;

public final class zzh extends zzd implements zzg {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
    }

    public final void zzf(int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
    }
}

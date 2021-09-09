package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzq extends zza implements zzp {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final zzt[] zza(IObjectWrapper iObjectWrapper, zzk zzk, zzv zzv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzb.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzb.zza(obtainAndWriteInterfaceToken, zzk);
        zzb.zza(obtainAndWriteInterfaceToken, zzv);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        zzt[] zztArr = (zzt[]) transactAndReadException.createTypedArray(zzt.CREATOR);
        transactAndReadException.recycle();
        return zztArr;
    }

    public final void zzi() throws RemoteException {
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken());
    }
}

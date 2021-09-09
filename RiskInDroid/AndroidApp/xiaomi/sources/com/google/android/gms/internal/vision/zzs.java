package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzs extends zza implements zzr {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zzp zza(IObjectWrapper iObjectWrapper, zzaa zzaa) throws RemoteException {
        zzp zzp;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzb.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzb.zza(obtainAndWriteInterfaceToken, zzaa);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzp = null;
        } else {
            ? queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            zzp = queryLocalInterface instanceof zzp ? queryLocalInterface : new zzq(readStrongBinder);
        }
        transactAndReadException.recycle();
        return zzp;
    }
}

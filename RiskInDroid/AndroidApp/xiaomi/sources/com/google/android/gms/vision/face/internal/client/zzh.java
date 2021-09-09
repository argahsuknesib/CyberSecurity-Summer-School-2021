package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzb;

public final class zzh extends zza implements zzg {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zze zza(IObjectWrapper iObjectWrapper, zzc zzc) throws RemoteException {
        zze zze;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzb.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzb.zza(obtainAndWriteInterfaceToken, zzc);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zze = null;
        } else {
            ? queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            zze = queryLocalInterface instanceof zze ? queryLocalInterface : new zzf(readStrongBinder);
        }
        transactAndReadException.recycle();
        return zze;
    }
}

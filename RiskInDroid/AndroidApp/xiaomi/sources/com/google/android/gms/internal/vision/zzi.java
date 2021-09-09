package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzi extends zza implements zzh {
    zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zzf zza(IObjectWrapper iObjectWrapper, zzc zzc) throws RemoteException {
        zzf zzf;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzb.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzb.zza(obtainAndWriteInterfaceToken, zzc);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzf = null;
        } else {
            ? queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            zzf = queryLocalInterface instanceof zzf ? queryLocalInterface : new zzg(readStrongBinder);
        }
        transactAndReadException.recycle();
        return zzf;
    }
}

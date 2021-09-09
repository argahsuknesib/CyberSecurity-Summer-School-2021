package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzk;

public final class zzf extends zza implements zze {
    zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzb.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzb.zza(obtainAndWriteInterfaceToken, zzk);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        FaceParcel[] faceParcelArr = (FaceParcel[]) transactAndReadException.createTypedArray(FaceParcel.CREATOR);
        transactAndReadException.recycle();
        return faceParcelArr;
    }

    public final boolean zzd(int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        boolean zza = zzb.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zzf() throws RemoteException {
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken());
    }
}

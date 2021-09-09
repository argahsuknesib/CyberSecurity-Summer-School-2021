package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzfa extends zzn implements zzey {
    zzfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzjx> zza(zzdz zzdz, boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    public final List<zzed> zza(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzed.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzed zzed, zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzed);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzeu zzeu, zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzeu zzeu, String str, String str2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzjx zzjx, zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzjx);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
    }

    public final byte[] zza(zzeu zzeu, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        byte[] createByteArray = transactAndReadException.createByteArray();
        transactAndReadException.recycle();
        return createByteArray;
    }

    public final void zzb(zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzed zzed) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzed);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
    }

    public final String zzc(zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    public final void zzd(zzdz zzdz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(18, obtainAndWriteInterfaceToken);
    }

    public final List<zzed> zze(String str, String str2, String str3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzed.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }
}

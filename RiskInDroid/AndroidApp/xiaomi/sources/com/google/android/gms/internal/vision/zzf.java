package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

public interface zzf extends IInterface {
    Barcode[] zza(IObjectWrapper iObjectWrapper, zzk zzk) throws RemoteException;

    Barcode[] zzb(IObjectWrapper iObjectWrapper, zzk zzk) throws RemoteException;

    void zzf() throws RemoteException;
}

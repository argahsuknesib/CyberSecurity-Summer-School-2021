package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzk;

public interface zze extends IInterface {
    FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzk zzk) throws RemoteException;

    boolean zzd(int i) throws RemoteException;

    void zzf() throws RemoteException;
}

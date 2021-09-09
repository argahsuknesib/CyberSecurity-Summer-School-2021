package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface zzey extends IInterface {
    List<zzjx> zza(zzdz zzdz, boolean z) throws RemoteException;

    List<zzed> zza(String str, String str2, zzdz zzdz) throws RemoteException;

    List<zzjx> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzdz zzdz) throws RemoteException;

    void zza(zzed zzed, zzdz zzdz) throws RemoteException;

    void zza(zzeu zzeu, zzdz zzdz) throws RemoteException;

    void zza(zzeu zzeu, String str, String str2) throws RemoteException;

    void zza(zzjx zzjx, zzdz zzdz) throws RemoteException;

    byte[] zza(zzeu zzeu, String str) throws RemoteException;

    void zzb(zzdz zzdz) throws RemoteException;

    void zzb(zzed zzed) throws RemoteException;

    String zzc(zzdz zzdz) throws RemoteException;

    void zzd(zzdz zzdz) throws RemoteException;

    List<zzed> zze(String str, String str2, String str3) throws RemoteException;
}

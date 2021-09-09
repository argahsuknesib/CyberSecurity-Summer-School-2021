package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface IGmsCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements IGmsCallbacks {

        public static class Proxy extends zza implements IGmsCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
            }

            public void onAccountValidationComplete(int i, Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, bundle);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
            }

            public void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, bundle);
                transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
            }

            public void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, connectionInfo);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public static IGmsCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                onAccountValidationComplete(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
            } else if (i != 3) {
                return false;
            } else {
                onPostInitCompleteWithConnectionInfo(parcel.readInt(), parcel.readStrongBinder(), (ConnectionInfo) zzc.zza(parcel, ConnectionInfo.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onAccountValidationComplete(int i, Bundle bundle) throws RemoteException;

    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) throws RemoteException;
}

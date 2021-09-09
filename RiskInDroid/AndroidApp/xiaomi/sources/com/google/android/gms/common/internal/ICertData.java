package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface ICertData extends IInterface {

    public static abstract class Stub extends zzb implements ICertData {

        public static class Proxy extends zza implements ICertData {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICertData");
            }

            public IObjectWrapper getBytesWrapped() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public int getHashCode() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICertData");
        }

        public static ICertData asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
            return queryLocalInterface instanceof ICertData ? (ICertData) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                IObjectWrapper bytesWrapped = getBytesWrapped();
                parcel2.writeNoException();
                zzc.zza(parcel2, bytesWrapped);
            } else if (i != 2) {
                return false;
            } else {
                int hashCode = getHashCode();
                parcel2.writeNoException();
                parcel2.writeInt(hashCode);
            }
            return true;
        }
    }

    IObjectWrapper getBytesWrapped() throws RemoteException;

    int getHashCode() throws RemoteException;
}

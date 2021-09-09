package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface IDynamiteLoaderV2 extends IInterface {

    public static abstract class Stub extends zzb implements IDynamiteLoaderV2 {

        public static class Proxy extends zza implements IDynamiteLoaderV2 {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
            }

            public IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        }

        public static IDynamiteLoaderV2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            return queryLocalInterface instanceof IDynamiteLoaderV2 ? (IDynamiteLoaderV2) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IObjectWrapper iObjectWrapper;
            if (i == 1) {
                iObjectWrapper = loadModule(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
            } else if (i != 2) {
                return false;
            } else {
                iObjectWrapper = loadModule2(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            zzc.zza(parcel2, iObjectWrapper);
            return true;
        }
    }

    IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr) throws RemoteException;

    IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException;
}

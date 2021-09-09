package com.xiaomi.smarthome.core.client;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IClientCallback extends IInterface {
    void onFailure(Bundle bundle) throws RemoteException;

    void onSuccess(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IClientCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.client.IClientCallback");
        }

        public static IClientCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.client.IClientCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IClientCallback)) {
                return new Proxy(iBinder);
            }
            return (IClientCallback) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientCallback");
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onSuccess(bundle);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientCallback");
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onFailure(bundle);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.client.IClientCallback");
                return true;
            }
        }

        static class Proxy implements IClientCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.client.IClientCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSuccess(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onFailure(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

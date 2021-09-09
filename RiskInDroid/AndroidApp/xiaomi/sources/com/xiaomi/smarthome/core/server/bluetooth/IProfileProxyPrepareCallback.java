package com.xiaomi.smarthome.core.server.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IProfileProxyPrepareCallback extends IInterface {
    void onServiceConnected(int i) throws RemoteException;

    void onServiceDisconnected(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IProfileProxyPrepareCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
        }

        public static IProfileProxyPrepareCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IProfileProxyPrepareCallback)) {
                return new Proxy(iBinder);
            }
            return (IProfileProxyPrepareCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
                onServiceConnected(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
                onServiceDisconnected(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
                return true;
            }
        }

        static class Proxy implements IProfileProxyPrepareCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onServiceConnected(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onServiceDisconnected(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback");
                    obtain.writeInt(i);
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

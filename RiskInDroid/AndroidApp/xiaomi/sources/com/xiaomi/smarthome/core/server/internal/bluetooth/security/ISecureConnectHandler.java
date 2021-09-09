package com.xiaomi.smarthome.core.server.internal.bluetooth.security;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISecureConnectHandler extends IInterface {
    void cancel() throws RemoteException;

    public static abstract class Stub extends Binder implements ISecureConnectHandler {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler");
        }

        public static ISecureConnectHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISecureConnectHandler)) {
                return new Proxy(iBinder);
            }
            return (ISecureConnectHandler) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler");
                cancel();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler");
                return true;
            }
        }

        static class Proxy implements ISecureConnectHandler {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

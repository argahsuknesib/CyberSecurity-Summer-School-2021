package com.xiaomi.smarthome.core.server.internal.bluetooth.security;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISecureConnectResponse extends IInterface {
    void onAuthResponse(int i, Bundle bundle) throws RemoteException;

    void onBindResponse(int i, Bundle bundle) throws RemoteException;

    void onConnectResponse(int i, Bundle bundle) throws RemoteException;

    void onLastResponse(int i, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ISecureConnectResponse {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
        }

        public static ISecureConnectResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISecureConnectResponse)) {
                return new Proxy(iBinder);
            }
            return (ISecureConnectResponse) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onConnectResponse(readInt, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onAuthResponse(readInt2, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                int readInt3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onBindResponse(readInt3, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                int readInt4 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                onLastResponse(readInt4, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                return true;
            }
        }

        static class Proxy implements ISecureConnectResponse {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onConnectResponse(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                    obtain.writeInt(i);
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

            public void onAuthResponse(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                    obtain.writeInt(i);
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

            public void onBindResponse(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLastResponse(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

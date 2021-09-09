package com.xiaomi.smarthome.frame.plugin;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.BridgeError;

public interface IBridgeCallback extends IInterface {
    void onFailure(BridgeError bridgeError) throws RemoteException;

    void onHandle(boolean z) throws RemoteException;

    void onMessageFailure(BridgeError bridgeError) throws RemoteException;

    void onMessageSuccess(Bundle bundle) throws RemoteException;

    void onSendSuccess(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IBridgeCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
        }

        public static IBridgeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBridgeCallback)) {
                return new Proxy(iBinder);
            }
            return (IBridgeCallback) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.xiaomi.smarthome.frame.plugin.runtime.bridge.BridgeError} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.xiaomi.smarthome.frame.plugin.runtime.bridge.BridgeError} */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r0 = 0;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                if (parcel.readInt() != 0) {
                    r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onSendSuccess(r0);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                onHandle(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                if (parcel.readInt() != 0) {
                    r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                onMessageSuccess(r0);
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                if (parcel.readInt() != 0) {
                    r0 = BridgeError.CREATOR.createFromParcel(parcel);
                }
                onMessageFailure(r0);
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                if (parcel.readInt() != 0) {
                    r0 = BridgeError.CREATOR.createFromParcel(parcel);
                }
                onFailure(r0);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                return true;
            }
        }

        static class Proxy implements IBridgeCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.frame.plugin.IBridgeCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSendSuccess(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
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

            public void onHandle(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMessageSuccess(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
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

            public void onMessageFailure(BridgeError bridgeError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                    if (bridgeError != null) {
                        obtain.writeInt(1);
                        bridgeError.writeToParcel(obtain, 0);
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

            public void onFailure(BridgeError bridgeError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeCallback");
                    if (bridgeError != null) {
                        obtain.writeInt(1);
                        bridgeError.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

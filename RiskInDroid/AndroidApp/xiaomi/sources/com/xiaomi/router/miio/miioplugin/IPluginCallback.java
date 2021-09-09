package com.xiaomi.router.miio.miioplugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPluginCallback extends IInterface {
    void onRequestFailed(int i, String str) throws RemoteException;

    void onRequestSuccess(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IPluginCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.router.miio.miioplugin.IPluginCallback");
        }

        public static IPluginCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.router.miio.miioplugin.IPluginCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPluginCallback)) {
                return new Proxy(iBinder);
            }
            return (IPluginCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IPluginCallback");
                onRequestSuccess(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IPluginCallback");
                onRequestFailed(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.router.miio.miioplugin.IPluginCallback");
                return true;
            }
        }

        static class Proxy implements IPluginCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.router.miio.miioplugin.IPluginCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onRequestSuccess(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginCallback");
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestFailed(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
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

package com.xiaomi.router.miio.miioplugin;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMessageCallback extends IInterface {
    void onFailure(int i, String str) throws RemoteException;

    void onHandle(int i) throws RemoteException;

    void onSuccess(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IMessageCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.router.miio.miioplugin.IMessageCallback");
        }

        public static IMessageCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.router.miio.miioplugin.IMessageCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMessageCallback)) {
                return new Proxy(iBinder);
            }
            return (IMessageCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                onHandle(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                onSuccess(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                onFailure(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                return true;
            }
        }

        static class Proxy implements IMessageCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.router.miio.miioplugin.IMessageCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onHandle(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IMessageCallback");
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

            public void onFailure(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IMessageCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

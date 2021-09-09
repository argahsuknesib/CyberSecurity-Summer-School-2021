package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXmCustomDataCallBack extends IInterface {
    void onError(String str) throws RemoteException;

    void onSuccess(String str, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmCustomDataCallBack {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
        }

        public static IXmCustomDataCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmCustomDataCallBack)) {
                return new Proxy(iBinder);
            }
            return (IXmCustomDataCallBack) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
                onSuccess(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
                onError(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
                return true;
            }
        }

        static class Proxy implements IXmCustomDataCallBack {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSuccess(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmCustomDataCallBack");
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

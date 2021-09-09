package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXmTokenInvalidForSDKCallBack extends IInterface {
    void tokenInvalid() throws RemoteException;

    public static abstract class Stub extends Binder implements IXmTokenInvalidForSDKCallBack {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack");
        }

        public static IXmTokenInvalidForSDKCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmTokenInvalidForSDKCallBack)) {
                return new Proxy(iBinder);
            }
            return (IXmTokenInvalidForSDKCallBack) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack");
                tokenInvalid();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack");
                return true;
            }
        }

        static class Proxy implements IXmTokenInvalidForSDKCallBack {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void tokenInvalid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack");
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

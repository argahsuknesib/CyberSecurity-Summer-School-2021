package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXmPlayHistoryListener extends IInterface {
    void onPlayHistoryChanged() throws RemoteException;

    public static abstract class Stub extends Binder implements IXmPlayHistoryListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener");
        }

        public static IXmPlayHistoryListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmPlayHistoryListener)) {
                return new Proxy(iBinder);
            }
            return (IXmPlayHistoryListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener");
                onPlayHistoryChanged();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener");
                return true;
            }
        }

        static class Proxy implements IXmPlayHistoryListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onPlayHistoryChanged() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayHistoryListener");
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

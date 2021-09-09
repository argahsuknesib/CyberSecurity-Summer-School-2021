package com.mi.global.shop.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDownloadService extends IInterface {
    void startDownload() throws RemoteException;

    public static abstract class Stub extends Binder implements IDownloadService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.mi.global.shop.service.IDownloadService");
        }

        public static IDownloadService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mi.global.shop.service.IDownloadService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadService)) {
                return new Proxy(iBinder);
            }
            return (IDownloadService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.mi.global.shop.service.IDownloadService");
                startDownload();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.mi.global.shop.service.IDownloadService");
                return true;
            }
        }

        static class Proxy implements IDownloadService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.mi.global.shop.service.IDownloadService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void startDownload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mi.global.shop.service.IDownloadService");
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

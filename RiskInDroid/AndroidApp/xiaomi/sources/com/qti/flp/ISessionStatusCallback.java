package com.qti.flp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISessionStatusCallback extends IInterface {

    public static class Default implements ISessionStatusCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onBatchingStatusCb(int i) throws RemoteException {
        }
    }

    void onBatchingStatusCb(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ISessionStatusCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.flp.ISessionStatusCallback");
        }

        public static ISessionStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.flp.ISessionStatusCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISessionStatusCallback)) {
                return new Proxy(iBinder);
            }
            return (ISessionStatusCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.flp.ISessionStatusCallback");
                onBatchingStatusCb(parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.flp.ISessionStatusCallback");
                return true;
            }
        }

        static class Proxy implements ISessionStatusCallback {
            public static ISessionStatusCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.flp.ISessionStatusCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onBatchingStatusCb(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.ISessionStatusCallback");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onBatchingStatusCb(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISessionStatusCallback iSessionStatusCallback) {
            if (Proxy.sDefaultImpl != null || iSessionStatusCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iSessionStatusCallback;
            return true;
        }

        public static ISessionStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

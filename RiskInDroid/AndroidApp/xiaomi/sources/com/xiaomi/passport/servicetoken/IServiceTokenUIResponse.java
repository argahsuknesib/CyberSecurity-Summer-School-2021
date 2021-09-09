package com.xiaomi.passport.servicetoken;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IServiceTokenUIResponse extends IInterface {

    public static class Default implements IServiceTokenUIResponse {
        public IBinder asBinder() {
            return null;
        }

        public void onError(int i, String str) throws RemoteException {
        }

        public void onRequestContinued() throws RemoteException {
        }

        public void onResult(Bundle bundle) throws RemoteException {
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onRequestContinued() throws RemoteException;

    void onResult(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceTokenUIResponse {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
        }

        public static IServiceTokenUIResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IServiceTokenUIResponse)) {
                return new Proxy(iBinder);
            }
            return (IServiceTokenUIResponse) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                onRequestContinued();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                return true;
            }
        }

        static class Proxy implements IServiceTokenUIResponse {
            public static IServiceTokenUIResponse sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.servicetoken.IServiceTokenUIResponse";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onResult(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResult(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestContinued() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onRequestContinued();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.servicetoken.IServiceTokenUIResponse");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(i, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IServiceTokenUIResponse iServiceTokenUIResponse) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iServiceTokenUIResponse == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iServiceTokenUIResponse;
                return true;
            }
        }

        public static IServiceTokenUIResponse getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

package com.xiaomi.udevid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUDevIdService extends IInterface {

    public static class Default implements IUDevIdService {
        public IBinder asBinder() {
            return null;
        }

        public Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IUDevIdService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.udevid.IUDevIdService");
        }

        public static IUDevIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.udevid.IUDevIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IUDevIdService)) {
                return new Proxy(iBinder);
            }
            return (IUDevIdService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.udevid.IUDevIdService");
                Bundle uDevIdFromSystemAccount = getUDevIdFromSystemAccount(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (uDevIdFromSystemAccount != null) {
                    parcel2.writeInt(1);
                    uDevIdFromSystemAccount.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.udevid.IUDevIdService");
                return true;
            }
        }

        static class Proxy implements IUDevIdService {
            public static IUDevIdService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.udevid.IUDevIdService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public Bundle getUDevIdFromSystemAccount(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.udevid.IUDevIdService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUDevIdFromSystemAccount(bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUDevIdService iUDevIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iUDevIdService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iUDevIdService;
                return true;
            }
        }

        public static IUDevIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

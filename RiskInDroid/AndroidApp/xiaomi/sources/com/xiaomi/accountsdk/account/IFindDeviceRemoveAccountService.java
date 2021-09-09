package com.xiaomi.accountsdk.account;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IFindDeviceRemoveAccountService extends IInterface {

    public static class Default implements IFindDeviceRemoveAccountService {
        public IBinder asBinder() {
            return null;
        }

        public boolean removeAccount() throws RemoteException {
            return false;
        }
    }

    boolean removeAccount() throws RemoteException;

    public static abstract class Stub extends Binder implements IFindDeviceRemoveAccountService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService");
        }

        public static IFindDeviceRemoveAccountService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IFindDeviceRemoveAccountService)) {
                return new Proxy(iBinder);
            }
            return (IFindDeviceRemoveAccountService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService");
                boolean removeAccount = removeAccount();
                parcel2.writeNoException();
                parcel2.writeInt(removeAccount ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService");
                return true;
            }
        }

        static class Proxy implements IFindDeviceRemoveAccountService {
            public static IFindDeviceRemoveAccountService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean removeAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IFindDeviceRemoveAccountService");
                    boolean z = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeAccount();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFindDeviceRemoveAccountService iFindDeviceRemoveAccountService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iFindDeviceRemoveAccountService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iFindDeviceRemoveAccountService;
                return true;
            }
        }

        public static IFindDeviceRemoveAccountService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

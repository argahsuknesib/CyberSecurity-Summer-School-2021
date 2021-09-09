package com.xiaomi.accounts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAccountAuthenticatorResponse extends IInterface {
    void onError(int i, String str) throws RemoteException;

    void onRequestContinued() throws RemoteException;

    void onResult(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IAccountAuthenticatorResponse {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.accounts.IAccountAuthenticatorResponse");
        }

        public static IAccountAuthenticatorResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.accounts.IAccountAuthenticatorResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountAuthenticatorResponse)) {
                return new Proxy(iBinder);
            }
            return (IAccountAuthenticatorResponse) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                onRequestContinued();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                onError(parcel.readInt(), parcel.readString());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                return true;
            }
        }

        static class Proxy implements IAccountAuthenticatorResponse {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.accounts.IAccountAuthenticatorResponse";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onResult(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onRequestContinued() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticatorResponse");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

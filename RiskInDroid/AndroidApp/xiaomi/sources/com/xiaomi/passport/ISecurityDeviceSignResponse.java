package com.xiaomi.passport;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISecurityDeviceSignResponse extends IInterface {

    public static class Default implements ISecurityDeviceSignResponse {
        public IBinder asBinder() {
            return null;
        }

        public void onResult(Bundle bundle) throws RemoteException {
        }
    }

    void onResult(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ISecurityDeviceSignResponse {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.ISecurityDeviceSignResponse");
        }

        public static ISecurityDeviceSignResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.ISecurityDeviceSignResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISecurityDeviceSignResponse)) {
                return new Proxy(iBinder);
            }
            return (ISecurityDeviceSignResponse) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.passport.ISecurityDeviceSignResponse");
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.passport.ISecurityDeviceSignResponse");
                return true;
            }
        }

        static class Proxy implements ISecurityDeviceSignResponse {
            public static ISecurityDeviceSignResponse sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.ISecurityDeviceSignResponse";
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
                    obtain.writeInterfaceToken("com.xiaomi.passport.ISecurityDeviceSignResponse");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onResult(bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISecurityDeviceSignResponse iSecurityDeviceSignResponse) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iSecurityDeviceSignResponse == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSecurityDeviceSignResponse;
                return true;
            }
        }

        public static ISecurityDeviceSignResponse getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

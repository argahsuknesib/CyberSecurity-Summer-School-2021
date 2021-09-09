package com.xiaomi.passport;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.passport.ISecurityDeviceSignResponse;

public interface ISecurityDeviceSignService extends IInterface {

    public static class Default implements ISecurityDeviceSignService {
        public IBinder asBinder() {
            return null;
        }

        public void sign(ISecurityDeviceSignResponse iSecurityDeviceSignResponse, String str, String str2, Bundle bundle) throws RemoteException {
        }
    }

    void sign(ISecurityDeviceSignResponse iSecurityDeviceSignResponse, String str, String str2, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ISecurityDeviceSignService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.ISecurityDeviceSignService");
        }

        public static ISecurityDeviceSignService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.ISecurityDeviceSignService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISecurityDeviceSignService)) {
                return new Proxy(iBinder);
            }
            return (ISecurityDeviceSignService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.passport.ISecurityDeviceSignService");
                sign(ISecurityDeviceSignResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.passport.ISecurityDeviceSignService");
                return true;
            }
        }

        static class Proxy implements ISecurityDeviceSignService {
            public static ISecurityDeviceSignService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.ISecurityDeviceSignService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void sign(ISecurityDeviceSignResponse iSecurityDeviceSignResponse, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.ISecurityDeviceSignService");
                    obtain.writeStrongBinder(iSecurityDeviceSignResponse != null ? iSecurityDeviceSignResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().sign(iSecurityDeviceSignResponse, str, str2, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISecurityDeviceSignService iSecurityDeviceSignService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iSecurityDeviceSignService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSecurityDeviceSignService;
                return true;
            }
        }

        public static ISecurityDeviceSignService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

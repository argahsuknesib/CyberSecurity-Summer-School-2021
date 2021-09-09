package com.qti.gnssconfig;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGnssConfigCallback extends IInterface {

    public static class Default implements IGnssConfigCallback {
        public IBinder asBinder() {
            return null;
        }

        public void getGnssSvTypeConfigCb(int[] iArr) throws RemoteException {
        }
    }

    void getGnssSvTypeConfigCb(int[] iArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IGnssConfigCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.gnssconfig.IGnssConfigCallback");
        }

        public static IGnssConfigCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.gnssconfig.IGnssConfigCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGnssConfigCallback)) {
                return new Proxy(iBinder);
            }
            return (IGnssConfigCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.gnssconfig.IGnssConfigCallback");
                getGnssSvTypeConfigCb(parcel.createIntArray());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.gnssconfig.IGnssConfigCallback");
                return true;
            }
        }

        static class Proxy implements IGnssConfigCallback {
            public static IGnssConfigCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.gnssconfig.IGnssConfigCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void getGnssSvTypeConfigCb(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.gnssconfig.IGnssConfigCallback");
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().getGnssSvTypeConfigCb(iArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGnssConfigCallback iGnssConfigCallback) {
            if (Proxy.sDefaultImpl != null || iGnssConfigCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGnssConfigCallback;
            return true;
        }

        public static IGnssConfigCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

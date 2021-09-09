package com.qti.gnssconfig;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qti.gnssconfig.IGnssConfigCallback;

public interface IGnssConfigService extends IInterface {

    public static class Default implements IGnssConfigService {
        public IBinder asBinder() {
            return null;
        }

        public void getGnssSvTypeConfig() throws RemoteException {
        }

        public void registerCallback(IGnssConfigCallback iGnssConfigCallback) throws RemoteException {
        }

        public void resetGnssSvTypeConfig() throws RemoteException {
        }

        public void setGnssSvTypeConfig(int[] iArr) throws RemoteException {
        }
    }

    void getGnssSvTypeConfig() throws RemoteException;

    void registerCallback(IGnssConfigCallback iGnssConfigCallback) throws RemoteException;

    void resetGnssSvTypeConfig() throws RemoteException;

    void setGnssSvTypeConfig(int[] iArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IGnssConfigService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.gnssconfig.IGnssConfigService");
        }

        public static IGnssConfigService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.gnssconfig.IGnssConfigService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGnssConfigService)) {
                return new Proxy(iBinder);
            }
            return (IGnssConfigService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.gnssconfig.IGnssConfigService");
                registerCallback(IGnssConfigCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.gnssconfig.IGnssConfigService");
                getGnssSvTypeConfig();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.gnssconfig.IGnssConfigService");
                setGnssSvTypeConfig(parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.qti.gnssconfig.IGnssConfigService");
                resetGnssSvTypeConfig();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.gnssconfig.IGnssConfigService");
                return true;
            }
        }

        static class Proxy implements IGnssConfigService {
            public static IGnssConfigService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.gnssconfig.IGnssConfigService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerCallback(IGnssConfigCallback iGnssConfigCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.gnssconfig.IGnssConfigService");
                    obtain.writeStrongBinder(iGnssConfigCallback != null ? iGnssConfigCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback(iGnssConfigCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getGnssSvTypeConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.gnssconfig.IGnssConfigService");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getGnssSvTypeConfig();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setGnssSvTypeConfig(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.gnssconfig.IGnssConfigService");
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setGnssSvTypeConfig(iArr);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resetGnssSvTypeConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.gnssconfig.IGnssConfigService");
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resetGnssSvTypeConfig();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGnssConfigService iGnssConfigService) {
            if (Proxy.sDefaultImpl != null || iGnssConfigService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGnssConfigService;
            return true;
        }

        public static IGnssConfigService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

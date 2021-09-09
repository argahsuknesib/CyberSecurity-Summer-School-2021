package com.qti.wifidbprovider;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qti.wifidbprovider.IWiFiDBProviderResponseListener;

public interface IWiFiDBProvider extends IInterface {

    public static class Default implements IWiFiDBProvider {
        public IBinder asBinder() {
            return null;
        }

        public boolean registerResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException {
            return false;
        }

        public void removeResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener) throws RemoteException {
        }

        public int requestAPObsLocData() throws RemoteException {
            return 0;
        }
    }

    boolean registerResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException;

    void removeResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener) throws RemoteException;

    int requestAPObsLocData() throws RemoteException;

    public static abstract class Stub extends Binder implements IWiFiDBProvider {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wifidbprovider.IWiFiDBProvider");
        }

        public static IWiFiDBProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wifidbprovider.IWiFiDBProvider");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWiFiDBProvider)) {
                return new Proxy(iBinder);
            }
            return (IWiFiDBProvider) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wifidbprovider.IWiFiDBProvider");
                boolean registerResponseListener = registerResponseListener(IWiFiDBProviderResponseListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(registerResponseListener ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wifidbprovider.IWiFiDBProvider");
                int requestAPObsLocData = requestAPObsLocData();
                parcel2.writeNoException();
                parcel2.writeInt(requestAPObsLocData);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.wifidbprovider.IWiFiDBProvider");
                removeResponseListener(IWiFiDBProviderResponseListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wifidbprovider.IWiFiDBProvider");
                return true;
            }
        }

        static class Proxy implements IWiFiDBProvider {
            public static IWiFiDBProvider sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wifidbprovider.IWiFiDBProvider";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean registerResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbprovider.IWiFiDBProvider");
                    obtain.writeStrongBinder(iWiFiDBProviderResponseListener != null ? iWiFiDBProviderResponseListener.asBinder() : null);
                    boolean z = true;
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerResponseListener(iWiFiDBProviderResponseListener, pendingIntent);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int requestAPObsLocData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbprovider.IWiFiDBProvider");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestAPObsLocData();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeResponseListener(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbprovider.IWiFiDBProvider");
                    obtain.writeStrongBinder(iWiFiDBProviderResponseListener != null ? iWiFiDBProviderResponseListener.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeResponseListener(iWiFiDBProviderResponseListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWiFiDBProvider iWiFiDBProvider) {
            if (Proxy.sDefaultImpl != null || iWiFiDBProvider == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWiFiDBProvider;
            return true;
        }

        public static IWiFiDBProvider getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

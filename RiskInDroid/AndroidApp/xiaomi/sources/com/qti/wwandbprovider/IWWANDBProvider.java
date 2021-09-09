package com.qti.wwandbprovider;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qti.wwandbprovider.IWWANDBProviderResponseListener;

public interface IWWANDBProvider extends IInterface {

    public static class Default implements IWWANDBProvider {
        public IBinder asBinder() {
            return null;
        }

        public boolean registerResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException {
            return false;
        }

        public void removeResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener) throws RemoteException {
        }

        public int requestBSObsLocData() throws RemoteException {
            return 0;
        }
    }

    boolean registerResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException;

    void removeResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener) throws RemoteException;

    int requestBSObsLocData() throws RemoteException;

    public static abstract class Stub extends Binder implements IWWANDBProvider {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wwandbprovider.IWWANDBProvider");
        }

        public static IWWANDBProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wwandbprovider.IWWANDBProvider");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWWANDBProvider)) {
                return new Proxy(iBinder);
            }
            return (IWWANDBProvider) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wwandbprovider.IWWANDBProvider");
                boolean registerResponseListener = registerResponseListener(IWWANDBProviderResponseListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(registerResponseListener ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wwandbprovider.IWWANDBProvider");
                int requestBSObsLocData = requestBSObsLocData();
                parcel2.writeNoException();
                parcel2.writeInt(requestBSObsLocData);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.wwandbprovider.IWWANDBProvider");
                removeResponseListener(IWWANDBProviderResponseListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wwandbprovider.IWWANDBProvider");
                return true;
            }
        }

        static class Proxy implements IWWANDBProvider {
            public static IWWANDBProvider sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wwandbprovider.IWWANDBProvider";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean registerResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbprovider.IWWANDBProvider");
                    obtain.writeStrongBinder(iWWANDBProviderResponseListener != null ? iWWANDBProviderResponseListener.asBinder() : null);
                    boolean z = true;
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerResponseListener(iWWANDBProviderResponseListener, pendingIntent);
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

            public int requestBSObsLocData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbprovider.IWWANDBProvider");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestBSObsLocData();
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

            public void removeResponseListener(IWWANDBProviderResponseListener iWWANDBProviderResponseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbprovider.IWWANDBProvider");
                    obtain.writeStrongBinder(iWWANDBProviderResponseListener != null ? iWWANDBProviderResponseListener.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeResponseListener(iWWANDBProviderResponseListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWWANDBProvider iWWANDBProvider) {
            if (Proxy.sDefaultImpl != null || iWWANDBProvider == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWWANDBProvider;
            return true;
        }

        public static IWWANDBProvider getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

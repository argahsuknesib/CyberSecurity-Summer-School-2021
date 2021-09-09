package com.qti.wwandbprovider;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IWWANDBProviderResponseListener extends IInterface {

    public static class Default implements IWWANDBProviderResponseListener {
        public IBinder asBinder() {
            return null;
        }

        public void onBsObsLocDataAvailable(List<BSObsLocationData> list, int i) throws RemoteException {
        }

        public void onServiceRequest() throws RemoteException {
        }
    }

    void onBsObsLocDataAvailable(List<BSObsLocationData> list, int i) throws RemoteException;

    void onServiceRequest() throws RemoteException;

    public static abstract class Stub extends Binder implements IWWANDBProviderResponseListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wwandbprovider.IWWANDBProviderResponseListener");
        }

        public static IWWANDBProviderResponseListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWWANDBProviderResponseListener)) {
                return new Proxy(iBinder);
            }
            return (IWWANDBProviderResponseListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
                onBsObsLocDataAvailable(parcel.createTypedArrayList(BSObsLocationData.CREATOR), parcel.readInt());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
                onServiceRequest();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
                return true;
            }
        }

        static class Proxy implements IWWANDBProviderResponseListener {
            public static IWWANDBProviderResponseListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wwandbprovider.IWWANDBProviderResponseListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onBsObsLocDataAvailable(List<BSObsLocationData> list, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
                    obtain.writeTypedList(list);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onBsObsLocDataAvailable(list, i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onServiceRequest() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbprovider.IWWANDBProviderResponseListener");
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onServiceRequest();
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWWANDBProviderResponseListener iWWANDBProviderResponseListener) {
            if (Proxy.sDefaultImpl != null || iWWANDBProviderResponseListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWWANDBProviderResponseListener;
            return true;
        }

        public static IWWANDBProviderResponseListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

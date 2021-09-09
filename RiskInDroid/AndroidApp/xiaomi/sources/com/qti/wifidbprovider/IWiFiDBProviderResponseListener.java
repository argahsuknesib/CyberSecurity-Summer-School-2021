package com.qti.wifidbprovider;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IWiFiDBProviderResponseListener extends IInterface {

    public static class Default implements IWiFiDBProviderResponseListener {
        public IBinder asBinder() {
            return null;
        }

        public void onApObsLocDataAvailable(List<APObsLocData> list, int i) throws RemoteException {
        }

        public void onServiceRequest() throws RemoteException {
        }
    }

    void onApObsLocDataAvailable(List<APObsLocData> list, int i) throws RemoteException;

    void onServiceRequest() throws RemoteException;

    public static abstract class Stub extends Binder implements IWiFiDBProviderResponseListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
        }

        public static IWiFiDBProviderResponseListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWiFiDBProviderResponseListener)) {
                return new Proxy(iBinder);
            }
            return (IWiFiDBProviderResponseListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
                onApObsLocDataAvailable(parcel.createTypedArrayList(APObsLocData.CREATOR), parcel.readInt());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
                onServiceRequest();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
                return true;
            }
        }

        static class Proxy implements IWiFiDBProviderResponseListener {
            public static IWiFiDBProviderResponseListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wifidbprovider.IWiFiDBProviderResponseListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onApObsLocDataAvailable(List<APObsLocData> list, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
                    obtain.writeTypedList(list);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onApObsLocDataAvailable(list, i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onServiceRequest() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbprovider.IWiFiDBProviderResponseListener");
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

        public static boolean setDefaultImpl(IWiFiDBProviderResponseListener iWiFiDBProviderResponseListener) {
            if (Proxy.sDefaultImpl != null || iWiFiDBProviderResponseListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWiFiDBProviderResponseListener;
            return true;
        }

        public static IWiFiDBProviderResponseListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

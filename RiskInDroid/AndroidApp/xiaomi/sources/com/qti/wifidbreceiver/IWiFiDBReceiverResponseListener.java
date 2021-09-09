package com.qti.wifidbreceiver;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IWiFiDBReceiverResponseListener extends IInterface {

    public static class Default implements IWiFiDBReceiverResponseListener {
        public IBinder asBinder() {
            return null;
        }

        public void onAPListAvailable(List<APInfo> list) throws RemoteException {
        }

        public void onAPListAvailableExt(List<APInfoExt> list, int i, Location location) throws RemoteException {
        }

        public void onLookupRequest(List<APInfoExt> list, Location location) throws RemoteException {
        }

        public void onServiceRequest() throws RemoteException {
        }

        public void onStatusUpdate(boolean z, String str) throws RemoteException {
        }
    }

    void onAPListAvailable(List<APInfo> list) throws RemoteException;

    void onAPListAvailableExt(List<APInfoExt> list, int i, Location location) throws RemoteException;

    void onLookupRequest(List<APInfoExt> list, Location location) throws RemoteException;

    void onServiceRequest() throws RemoteException;

    void onStatusUpdate(boolean z, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IWiFiDBReceiverResponseListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
        }

        public static IWiFiDBReceiverResponseListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWiFiDBReceiverResponseListener)) {
                return new Proxy(iBinder);
            }
            return (IWiFiDBReceiverResponseListener) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.location.Location} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                onAPListAvailable(parcel.createTypedArrayList(APInfo.CREATOR));
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                onStatusUpdate(parcel.readInt() != 0, parcel.readString());
                return true;
            } else if (i != 3) {
                Location location = null;
                if (i == 4) {
                    parcel.enforceInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    ArrayList createTypedArrayList = parcel.createTypedArrayList(APInfoExt.CREATOR);
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        location = Location.CREATOR.createFromParcel(parcel);
                    }
                    onAPListAvailableExt(createTypedArrayList, readInt, location);
                    return true;
                } else if (i == 5) {
                    parcel.enforceInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    ArrayList createTypedArrayList2 = parcel.createTypedArrayList(APInfoExt.CREATOR);
                    if (parcel.readInt() != 0) {
                        location = Location.CREATOR.createFromParcel(parcel);
                    }
                    onLookupRequest(createTypedArrayList2, location);
                    return true;
                } else if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel2.writeString("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    return true;
                }
            } else {
                parcel.enforceInterface("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                onServiceRequest();
                return true;
            }
        }

        static class Proxy implements IWiFiDBReceiverResponseListener {
            public static IWiFiDBReceiverResponseListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onAPListAvailable(List<APInfo> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAPListAvailable(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onStatusUpdate(boolean z, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onStatusUpdate(z, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onServiceRequest() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onServiceRequest();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onAPListAvailableExt(List<APInfoExt> list, int i, Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    obtain.writeTypedList(list);
                    obtain.writeInt(i);
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onAPListAvailableExt(list, i, location);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onLookupRequest(List<APInfoExt> list, Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wifidbreceiver.IWiFiDBReceiverResponseListener");
                    obtain.writeTypedList(list);
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onLookupRequest(list, location);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWiFiDBReceiverResponseListener iWiFiDBReceiverResponseListener) {
            if (Proxy.sDefaultImpl != null || iWiFiDBReceiverResponseListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWiFiDBReceiverResponseListener;
            return true;
        }

        public static IWiFiDBReceiverResponseListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

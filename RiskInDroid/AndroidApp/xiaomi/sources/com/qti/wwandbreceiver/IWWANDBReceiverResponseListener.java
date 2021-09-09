package com.qti.wwandbreceiver;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IWWANDBReceiverResponseListener extends IInterface {

    public static class Default implements IWWANDBReceiverResponseListener {
        public IBinder asBinder() {
            return null;
        }

        public void onBSListAvailable(List<BSInfo> list) throws RemoteException {
        }

        public void onBSListAvailableExt(List<BSInfo> list, int i, Location location) throws RemoteException {
        }

        public void onServiceRequest() throws RemoteException {
        }

        public void onStatusUpdate(boolean z, String str) throws RemoteException {
        }
    }

    void onBSListAvailable(List<BSInfo> list) throws RemoteException;

    void onBSListAvailableExt(List<BSInfo> list, int i, Location location) throws RemoteException;

    void onServiceRequest() throws RemoteException;

    void onStatusUpdate(boolean z, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IWWANDBReceiverResponseListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
        }

        public static IWWANDBReceiverResponseListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWWANDBReceiverResponseListener)) {
                return new Proxy(iBinder);
            }
            return (IWWANDBReceiverResponseListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                onBSListAvailable(parcel.createTypedArrayList(BSInfo.CREATOR));
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                onStatusUpdate(parcel.readInt() != 0, parcel.readString());
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                onServiceRequest();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                onBSListAvailableExt(parcel.createTypedArrayList(BSInfo.CREATOR), parcel.readInt(), parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                return true;
            }
        }

        static class Proxy implements IWWANDBReceiverResponseListener {
            public static IWWANDBReceiverResponseListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wwandbreceiver.IWWANDBReceiverResponseListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onBSListAvailable(List<BSInfo> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onBSListAvailable(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onStatusUpdate(boolean z, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
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
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onServiceRequest();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onBSListAvailableExt(List<BSInfo> list, int i, Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiverResponseListener");
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
                        Stub.getDefaultImpl().onBSListAvailableExt(list, i, location);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) {
            if (Proxy.sDefaultImpl != null || iWWANDBReceiverResponseListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWWANDBReceiverResponseListener;
            return true;
        }

        public static IWWANDBReceiverResponseListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

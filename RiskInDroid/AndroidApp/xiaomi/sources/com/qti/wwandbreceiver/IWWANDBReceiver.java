package com.qti.wwandbreceiver;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qti.wwandbreceiver.IWWANDBReceiverResponseListener;
import java.util.List;

public interface IWWANDBReceiver extends IInterface {

    public static class Default implements IWWANDBReceiver {
        public IBinder asBinder() {
            return null;
        }

        public int pushWWANDB(List<BSLocationData> list, List<BSSpecialInfo> list2, int i) throws RemoteException {
            return 0;
        }

        public boolean registerResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException {
            return false;
        }

        public boolean registerResponseListenerExt(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener, PendingIntent pendingIntent) throws RemoteException {
            return false;
        }

        public void removeResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException {
        }

        public int requestBSList(int i) throws RemoteException {
            return 0;
        }
    }

    int pushWWANDB(List<BSLocationData> list, List<BSSpecialInfo> list2, int i) throws RemoteException;

    boolean registerResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException;

    boolean registerResponseListenerExt(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener, PendingIntent pendingIntent) throws RemoteException;

    void removeResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException;

    int requestBSList(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IWWANDBReceiver {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.wwandbreceiver.IWWANDBReceiver");
        }

        public static IWWANDBReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWWANDBReceiver)) {
                return new Proxy(iBinder);
            }
            return (IWWANDBReceiver) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
                boolean registerResponseListener = registerResponseListener(IWWANDBReceiverResponseListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(registerResponseListener ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
                int requestBSList = requestBSList(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(requestBSList);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
                int pushWWANDB = pushWWANDB(parcel.createTypedArrayList(BSLocationData.CREATOR), parcel.createTypedArrayList(BSSpecialInfo.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(pushWWANDB);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
                removeResponseListener(IWWANDBReceiverResponseListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.qti.wwandbreceiver.IWWANDBReceiver");
                boolean registerResponseListenerExt = registerResponseListenerExt(IWWANDBReceiverResponseListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(registerResponseListenerExt ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.wwandbreceiver.IWWANDBReceiver");
                return true;
            }
        }

        static class Proxy implements IWWANDBReceiver {
            public static IWWANDBReceiver sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.wwandbreceiver.IWWANDBReceiver";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean registerResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiver");
                    obtain.writeStrongBinder(iWWANDBReceiverResponseListener != null ? iWWANDBReceiverResponseListener.asBinder() : null);
                    boolean z = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerResponseListener(iWWANDBReceiverResponseListener);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int requestBSList(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiver");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestBSList(i);
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

            public int pushWWANDB(List<BSLocationData> list, List<BSSpecialInfo> list2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiver");
                    obtain.writeTypedList(list);
                    obtain.writeTypedList(list2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pushWWANDB(list, list2, i);
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

            public void removeResponseListener(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiver");
                    obtain.writeStrongBinder(iWWANDBReceiverResponseListener != null ? iWWANDBReceiverResponseListener.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeResponseListener(iWWANDBReceiverResponseListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean registerResponseListenerExt(IWWANDBReceiverResponseListener iWWANDBReceiverResponseListener, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.wwandbreceiver.IWWANDBReceiver");
                    obtain.writeStrongBinder(iWWANDBReceiverResponseListener != null ? iWWANDBReceiverResponseListener.asBinder() : null);
                    boolean z = true;
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerResponseListenerExt(iWWANDBReceiverResponseListener, pendingIntent);
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
        }

        public static boolean setDefaultImpl(IWWANDBReceiver iWWANDBReceiver) {
            if (Proxy.sDefaultImpl != null || iWWANDBReceiver == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWWANDBReceiver;
            return true;
        }

        public static IWWANDBReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

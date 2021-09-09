package com.qti.flp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMaxPowerAllocatedCallback extends IInterface {

    public static class Default implements IMaxPowerAllocatedCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onMaxPowerAllocatedChanged(double d) throws RemoteException {
        }
    }

    void onMaxPowerAllocatedChanged(double d) throws RemoteException;

    public static abstract class Stub extends Binder implements IMaxPowerAllocatedCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.flp.IMaxPowerAllocatedCallback");
        }

        public static IMaxPowerAllocatedCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.flp.IMaxPowerAllocatedCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMaxPowerAllocatedCallback)) {
                return new Proxy(iBinder);
            }
            return (IMaxPowerAllocatedCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.flp.IMaxPowerAllocatedCallback");
                onMaxPowerAllocatedChanged(parcel.readDouble());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.flp.IMaxPowerAllocatedCallback");
                return true;
            }
        }

        static class Proxy implements IMaxPowerAllocatedCallback {
            public static IMaxPowerAllocatedCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.flp.IMaxPowerAllocatedCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onMaxPowerAllocatedChanged(double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IMaxPowerAllocatedCallback");
                    obtain.writeDouble(d);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onMaxPowerAllocatedChanged(d);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMaxPowerAllocatedCallback iMaxPowerAllocatedCallback) {
            if (Proxy.sDefaultImpl != null || iMaxPowerAllocatedCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMaxPowerAllocatedCallback;
            return true;
        }

        public static IMaxPowerAllocatedCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

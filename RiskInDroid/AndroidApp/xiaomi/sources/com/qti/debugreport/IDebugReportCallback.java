package com.qti.debugreport;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDebugReportCallback extends IInterface {

    public static class Default implements IDebugReportCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onDebugDataAvailable(Bundle bundle) throws RemoteException {
        }
    }

    void onDebugDataAvailable(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IDebugReportCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.debugreport.IDebugReportCallback");
        }

        public static IDebugReportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.debugreport.IDebugReportCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDebugReportCallback)) {
                return new Proxy(iBinder);
            }
            return (IDebugReportCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportCallback");
                onDebugDataAvailable(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.debugreport.IDebugReportCallback");
                return true;
            }
        }

        static class Proxy implements IDebugReportCallback {
            public static IDebugReportCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.debugreport.IDebugReportCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onDebugDataAvailable(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onDebugDataAvailable(bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDebugReportCallback iDebugReportCallback) {
            if (Proxy.sDefaultImpl != null || iDebugReportCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDebugReportCallback;
            return true;
        }

        public static IDebugReportCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

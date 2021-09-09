package com.qti.debugreport;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qti.debugreport.IDebugReportCallback;

public interface IDebugReportService extends IInterface {

    public static class Default implements IDebugReportService {
        public IBinder asBinder() {
            return null;
        }

        public Bundle getDebugReport() throws RemoteException {
            return null;
        }

        public void registerForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException {
        }

        public void startReporting() throws RemoteException {
        }

        public void stopReporting() throws RemoteException {
        }

        public void unregisterForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException {
        }
    }

    Bundle getDebugReport() throws RemoteException;

    void registerForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException;

    void startReporting() throws RemoteException;

    void stopReporting() throws RemoteException;

    void unregisterForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IDebugReportService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.debugreport.IDebugReportService");
        }

        public static IDebugReportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.debugreport.IDebugReportService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDebugReportService)) {
                return new Proxy(iBinder);
            }
            return (IDebugReportService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportService");
                registerForDebugReporting(IDebugReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportService");
                unregisterForDebugReporting(IDebugReportCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportService");
                startReporting();
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportService");
                stopReporting();
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.qti.debugreport.IDebugReportService");
                Bundle debugReport = getDebugReport();
                parcel2.writeNoException();
                if (debugReport != null) {
                    parcel2.writeInt(1);
                    debugReport.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.debugreport.IDebugReportService");
                return true;
            }
        }

        static class Proxy implements IDebugReportService {
            public static IDebugReportService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.debugreport.IDebugReportService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportService");
                    obtain.writeStrongBinder(iDebugReportCallback != null ? iDebugReportCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerForDebugReporting(iDebugReportCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterForDebugReporting(IDebugReportCallback iDebugReportCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportService");
                    obtain.writeStrongBinder(iDebugReportCallback != null ? iDebugReportCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterForDebugReporting(iDebugReportCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startReporting() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportService");
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startReporting();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopReporting() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportService");
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().stopReporting();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getDebugReport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.debugreport.IDebugReportService");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDebugReport();
                    }
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDebugReportService iDebugReportService) {
            if (Proxy.sDefaultImpl != null || iDebugReportService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDebugReportService;
            return true;
        }

        public static IDebugReportService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

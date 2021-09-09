package com.qti.izat;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.qti.debugreport.IDebugReportService;
import com.qti.flp.IFlpService;
import com.qti.flp.ITestService;
import com.qti.geofence.IGeofenceService;
import com.qti.gnssconfig.IGnssConfigService;
import com.qti.wifidbprovider.IWiFiDBProvider;
import com.qti.wifidbreceiver.IWiFiDBReceiver;
import com.qti.wwandbprovider.IWWANDBProvider;
import com.qti.wwandbreceiver.IWWANDBReceiver;

public interface IIzatService extends IInterface {

    public static class Default implements IIzatService {
        public IBinder asBinder() {
            return null;
        }

        public IDebugReportService getDebugReportService() throws RemoteException {
            return null;
        }

        public IFlpService getFlpService() throws RemoteException {
            return null;
        }

        public IGeofenceService getGeofenceService() throws RemoteException {
            return null;
        }

        public IGnssConfigService getGnssConfigService() throws RemoteException {
            return null;
        }

        public ITestService getTestService() throws RemoteException {
            return null;
        }

        public String getVersion() throws RemoteException {
            return null;
        }

        public IWWANDBProvider getWWANDBProvider() throws RemoteException {
            return null;
        }

        public IWWANDBReceiver getWWANDBReceiver() throws RemoteException {
            return null;
        }

        public IWiFiDBProvider getWiFiDBProvider() throws RemoteException {
            return null;
        }

        public IWiFiDBReceiver getWiFiDBReceiver() throws RemoteException {
            return null;
        }
    }

    IDebugReportService getDebugReportService() throws RemoteException;

    IFlpService getFlpService() throws RemoteException;

    IGeofenceService getGeofenceService() throws RemoteException;

    IGnssConfigService getGnssConfigService() throws RemoteException;

    ITestService getTestService() throws RemoteException;

    String getVersion() throws RemoteException;

    IWWANDBProvider getWWANDBProvider() throws RemoteException;

    IWWANDBReceiver getWWANDBReceiver() throws RemoteException;

    IWiFiDBProvider getWiFiDBProvider() throws RemoteException;

    IWiFiDBReceiver getWiFiDBReceiver() throws RemoteException;

    public static abstract class Stub extends Binder implements IIzatService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.izat.IIzatService");
        }

        public static IIzatService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.izat.IIzatService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IIzatService)) {
                return new Proxy(iBinder);
            }
            return (IIzatService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                IBinder iBinder = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IFlpService flpService = getFlpService();
                        parcel2.writeNoException();
                        if (flpService != null) {
                            iBinder = flpService.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        ITestService testService = getTestService();
                        parcel2.writeNoException();
                        if (testService != null) {
                            iBinder = testService.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IGeofenceService geofenceService = getGeofenceService();
                        parcel2.writeNoException();
                        if (geofenceService != null) {
                            iBinder = geofenceService.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        String version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(version);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IDebugReportService debugReportService = getDebugReportService();
                        parcel2.writeNoException();
                        if (debugReportService != null) {
                            iBinder = debugReportService.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IWiFiDBReceiver wiFiDBReceiver = getWiFiDBReceiver();
                        parcel2.writeNoException();
                        if (wiFiDBReceiver != null) {
                            iBinder = wiFiDBReceiver.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IWWANDBReceiver wWANDBReceiver = getWWANDBReceiver();
                        parcel2.writeNoException();
                        if (wWANDBReceiver != null) {
                            iBinder = wWANDBReceiver.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IGnssConfigService gnssConfigService = getGnssConfigService();
                        parcel2.writeNoException();
                        if (gnssConfigService != null) {
                            iBinder = gnssConfigService.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IWiFiDBProvider wiFiDBProvider = getWiFiDBProvider();
                        parcel2.writeNoException();
                        if (wiFiDBProvider != null) {
                            iBinder = wiFiDBProvider.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.qti.izat.IIzatService");
                        IWWANDBProvider wWANDBProvider = getWWANDBProvider();
                        parcel2.writeNoException();
                        if (wWANDBProvider != null) {
                            iBinder = wWANDBProvider.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.qti.izat.IIzatService");
                return true;
            }
        }

        static class Proxy implements IIzatService {
            public static IIzatService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.izat.IIzatService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public IFlpService getFlpService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFlpService();
                    }
                    obtain2.readException();
                    IFlpService asInterface = IFlpService.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ITestService getTestService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTestService();
                    }
                    obtain2.readException();
                    ITestService asInterface = ITestService.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IGeofenceService getGeofenceService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGeofenceService();
                    }
                    obtain2.readException();
                    IGeofenceService asInterface = IGeofenceService.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVersion();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IDebugReportService getDebugReportService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDebugReportService();
                    }
                    obtain2.readException();
                    IDebugReportService asInterface = IDebugReportService.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IWiFiDBReceiver getWiFiDBReceiver() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiDBReceiver();
                    }
                    obtain2.readException();
                    IWiFiDBReceiver asInterface = IWiFiDBReceiver.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IWWANDBReceiver getWWANDBReceiver() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWWANDBReceiver();
                    }
                    obtain2.readException();
                    IWWANDBReceiver asInterface = IWWANDBReceiver.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IGnssConfigService getGnssConfigService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGnssConfigService();
                    }
                    obtain2.readException();
                    IGnssConfigService asInterface = IGnssConfigService.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IWiFiDBProvider getWiFiDBProvider() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWiFiDBProvider();
                    }
                    obtain2.readException();
                    IWiFiDBProvider asInterface = IWiFiDBProvider.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IWWANDBProvider getWWANDBProvider() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.izat.IIzatService");
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWWANDBProvider();
                    }
                    obtain2.readException();
                    IWWANDBProvider asInterface = IWWANDBProvider.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IIzatService iIzatService) {
            if (Proxy.sDefaultImpl != null || iIzatService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iIzatService;
            return true;
        }

        public static IIzatService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

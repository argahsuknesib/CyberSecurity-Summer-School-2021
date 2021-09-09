package com.qti.geofence;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGeofenceCallback extends IInterface {

    public static class Default implements IGeofenceCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onEngineReportStatus(int i, Location location) throws RemoteException {
        }

        public void onRequestResultReturned(int i, int i2, int i3) throws RemoteException {
        }

        public void onTransitionEvent(int i, int i2, Location location) throws RemoteException {
        }
    }

    void onEngineReportStatus(int i, Location location) throws RemoteException;

    void onRequestResultReturned(int i, int i2, int i3) throws RemoteException;

    void onTransitionEvent(int i, int i2, Location location) throws RemoteException;

    public static abstract class Stub extends Binder implements IGeofenceCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.geofence.IGeofenceCallback");
        }

        public static IGeofenceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.geofence.IGeofenceCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGeofenceCallback)) {
                return new Proxy(iBinder);
            }
            return (IGeofenceCallback) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.location.Location} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Location location = null;
            if (i == 1) {
                parcel.enforceInterface("com.qti.geofence.IGeofenceCallback");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    location = Location.CREATOR.createFromParcel(parcel);
                }
                onTransitionEvent(readInt, readInt2, location);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.qti.geofence.IGeofenceCallback");
                onRequestResultReturned(parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.qti.geofence.IGeofenceCallback");
                int readInt3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    location = Location.CREATOR.createFromParcel(parcel);
                }
                onEngineReportStatus(readInt3, location);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.qti.geofence.IGeofenceCallback");
                return true;
            }
        }

        static class Proxy implements IGeofenceCallback {
            public static IGeofenceCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.geofence.IGeofenceCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onTransitionEvent(int i, int i2, Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onTransitionEvent(i, i2, location);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onRequestResultReturned(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onRequestResultReturned(i, i2, i3);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onEngineReportStatus(int i, Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceCallback");
                    obtain.writeInt(i);
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onEngineReportStatus(i, location);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGeofenceCallback iGeofenceCallback) {
            if (Proxy.sDefaultImpl != null || iGeofenceCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGeofenceCallback;
            return true;
        }

        public static IGeofenceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

package com.xiaomi.metok.geofencing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IGeoFencing extends IInterface {
    String getDeviceLocation() throws RemoteException;

    List<String> getLocationSsids(String str) throws RemoteException;

    void setLocationListener(List<String> list, String str) throws RemoteException;

    void unsetLocationListener(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IGeoFencing {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.metok.geofencing.IGeoFencing");
        }

        public static IGeoFencing asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.metok.geofencing.IGeoFencing");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGeoFencing)) {
                return new Proxy(iBinder);
            }
            return (IGeoFencing) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                setLocationListener(parcel.createStringArrayList(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                unsetLocationListener(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                String deviceLocation = getDeviceLocation();
                parcel2.writeNoException();
                parcel2.writeString(deviceLocation);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
                List<String> locationSsids = getLocationSsids(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStringList(locationSsids);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.metok.geofencing.IGeoFencing");
                return true;
            }
        }

        static class Proxy implements IGeoFencing {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.metok.geofencing.IGeoFencing";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void setLocationListener(List<String> list, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unsetLocationListener(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDeviceLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> getLocationSsids(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

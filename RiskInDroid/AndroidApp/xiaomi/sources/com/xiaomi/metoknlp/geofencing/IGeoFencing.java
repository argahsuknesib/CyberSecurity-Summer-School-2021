package com.xiaomi.metoknlp.geofencing;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import java.util.List;

public interface IGeoFencing extends IInterface {
    String getDeviceLocation() throws RemoteException;

    List<String> getLocationSsids(String str) throws RemoteException;

    int getVersion() throws RemoteException;

    void registerFenceListener(double d, double d2, float f, long j, String str, String str2, String str3) throws RemoteException;

    void registerFenceListenerByIntent(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2) throws RemoteException;

    void setLocationListener(List<String> list, String str) throws RemoteException;

    void unregisterFenceListener(String str, String str2) throws RemoteException;

    void unregisterFenceListenerByIntent(PendingIntent pendingIntent) throws RemoteException;

    void unsetLocationListener(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IGeoFencing {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.metoknlp.geofencing.IGeoFencing");
        }

        public static IGeoFencing asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGeoFencing)) {
                return new Proxy(iBinder);
            }
            return (IGeoFencing) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                PendingIntent pendingIntent = null;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        setLocationListener(parcel.createStringArrayList(), parcel.readString());
                        return true;
                    case 2:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        unsetLocationListener(parcel.readString());
                        return true;
                    case 3:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        String deviceLocation = getDeviceLocation();
                        parcel2.writeNoException();
                        parcel4.writeString(deviceLocation);
                        return true;
                    case 4:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        List<String> locationSsids = getLocationSsids(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeStringList(locationSsids);
                        return true;
                    case 5:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel4.writeInt(version);
                        return true;
                    case 6:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        registerFenceListener(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                        return true;
                    case 7:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        registerFenceListenerByIntent(parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readLong(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel3) : null, parcel.readString(), parcel.readString());
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        unregisterFenceListener(parcel.readString(), parcel.readString());
                        return true;
                    case 9:
                        parcel3.enforceInterface("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                        if (parcel.readInt() != 0) {
                            pendingIntent = PendingIntent.CREATOR.createFromParcel(parcel3);
                        }
                        unregisterFenceListenerByIntent(pendingIntent);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                return true;
            }
        }

        static class Proxy implements IGeoFencing {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.metoknlp.geofencing.IGeoFencing";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void setLocationListener(List<String> list, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeStringList(list);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unsetLocationListener(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getDeviceLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
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
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerFenceListener(double d, double d2, float f, long j, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void registerFenceListenerByIntent(double d, double d2, float f, long j, PendingIntent pendingIntent, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeFloat(f);
                    obtain.writeLong(j);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unregisterFenceListener(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unregisterFenceListenerByIntent(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.metoknlp.geofencing.IGeoFencing");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

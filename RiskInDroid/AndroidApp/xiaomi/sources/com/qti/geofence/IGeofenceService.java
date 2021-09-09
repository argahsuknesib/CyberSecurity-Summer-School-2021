package com.qti.geofence;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.qti.geofence.IGeofenceCallback;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IGeofenceService extends IInterface {

    public static class Default implements IGeofenceService {
        public int addGeofence(double d, double d2, double d3, int i, int i2, int i3, int i4, int i5) throws RemoteException {
            return 0;
        }

        public int addGeofenceObj(GeofenceData geofenceData) throws RemoteException {
            return 0;
        }

        public int addGeofenceObjWithFlag(GeofenceData geofenceData, int i) throws RemoteException {
            return 0;
        }

        public IBinder asBinder() {
            return null;
        }

        public void pauseGeofence(int i) throws RemoteException {
        }

        public void recoverGeofences(List<GeofenceData> list) throws RemoteException {
        }

        public void registerCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException {
        }

        public void registerComponent(ComponentName componentName) throws RemoteException {
        }

        public void registerPendingIntent(PendingIntent pendingIntent) throws RemoteException {
        }

        public void removeGeofence(int i) throws RemoteException {
        }

        public void resumeGeofence(int i) throws RemoteException {
        }

        public void unregisterCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException {
        }

        public void unregisterComponent() throws RemoteException {
        }

        public void unregisterPendingIntent(PendingIntent pendingIntent) throws RemoteException {
        }

        public void updateGeofence(int i, int i2, int i3) throws RemoteException {
        }

        public void updateGeofenceData(int i, double d, double d2, double d3, int i2, int i3, int i4, int i5, int i6, int i7) throws RemoteException {
        }
    }

    int addGeofence(double d, double d2, double d3, int i, int i2, int i3, int i4, int i5) throws RemoteException;

    int addGeofenceObj(GeofenceData geofenceData) throws RemoteException;

    int addGeofenceObjWithFlag(GeofenceData geofenceData, int i) throws RemoteException;

    void pauseGeofence(int i) throws RemoteException;

    void recoverGeofences(List<GeofenceData> list) throws RemoteException;

    void registerCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException;

    void registerComponent(ComponentName componentName) throws RemoteException;

    void registerPendingIntent(PendingIntent pendingIntent) throws RemoteException;

    void removeGeofence(int i) throws RemoteException;

    void resumeGeofence(int i) throws RemoteException;

    void unregisterCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException;

    void unregisterComponent() throws RemoteException;

    void unregisterPendingIntent(PendingIntent pendingIntent) throws RemoteException;

    void updateGeofence(int i, int i2, int i3) throws RemoteException;

    void updateGeofenceData(int i, double d, double d2, double d3, int i2, int i3, int i4, int i5, int i6, int i7) throws RemoteException;

    public static abstract class Stub extends Binder implements IGeofenceService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.geofence.IGeofenceService");
        }

        public static IGeofenceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.geofence.IGeofenceService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGeofenceService)) {
                return new Proxy(iBinder);
            }
            return (IGeofenceService) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.qti.geofence.GeofenceData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: android.content.ComponentName} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: com.qti.geofence.GeofenceData} */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                ? r2 = 0;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        registerCallback(IGeofenceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        unregisterCallback(IGeofenceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        int addGeofence = addGeofence(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(addGeofence);
                        return true;
                    case 4:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        removeGeofence(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        updateGeofence(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        pauseGeofence(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        resumeGeofence(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        if (parcel.readInt() != 0) {
                            r2 = GeofenceData.CREATOR.createFromParcel(parcel3);
                        }
                        int addGeofenceObj = addGeofenceObj(r2);
                        parcel2.writeNoException();
                        parcel4.writeInt(addGeofenceObj);
                        return true;
                    case 9:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        if (parcel.readInt() != 0) {
                            r2 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel3);
                        }
                        registerPendingIntent(r2);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        if (parcel.readInt() != 0) {
                            r2 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel3);
                        }
                        unregisterPendingIntent(r2);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        ArrayList createTypedArrayList = parcel3.createTypedArrayList(GeofenceData.CREATOR);
                        recoverGeofences(createTypedArrayList);
                        parcel2.writeNoException();
                        parcel4.writeTypedList(createTypedArrayList);
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        updateGeofenceData(parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        if (parcel.readInt() != 0) {
                            r2 = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel3);
                        }
                        registerComponent(r2);
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        unregisterComponent();
                        parcel2.writeNoException();
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel3.enforceInterface("com.qti.geofence.IGeofenceService");
                        if (parcel.readInt() != 0) {
                            r2 = GeofenceData.CREATOR.createFromParcel(parcel3);
                        }
                        int addGeofenceObjWithFlag = addGeofenceObjWithFlag(r2, parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(addGeofenceObjWithFlag);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString("com.qti.geofence.IGeofenceService");
                return true;
            }
        }

        static class Proxy implements IGeofenceService {
            public static IGeofenceService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.geofence.IGeofenceService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeStrongBinder(iGeofenceCallback != null ? iGeofenceCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback(iGeofenceCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallback(IGeofenceCallback iGeofenceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeStrongBinder(iGeofenceCallback != null ? iGeofenceCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallback(iGeofenceCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addGeofence(double d, double d2, double d3, int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    try {
                        if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            int readInt = obtain2.readInt();
                            obtain2.recycle();
                            obtain.recycle();
                            return readInt;
                        }
                        int addGeofence = Stub.getDefaultImpl().addGeofence(d, d2, d3, i, i2, i3, i4, i5);
                        obtain2.recycle();
                        obtain.recycle();
                        return addGeofence;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void removeGeofence(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeGeofence(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateGeofence(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateGeofence(i, i2, i3);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pauseGeofence(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseGeofence(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resumeGeofence(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resumeGeofence(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addGeofenceObj(GeofenceData geofenceData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (geofenceData != null) {
                        obtain.writeInt(1);
                        geofenceData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().addGeofenceObj(geofenceData);
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

            public void registerPendingIntent(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerPendingIntent(pendingIntent);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterPendingIntent(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterPendingIntent(pendingIntent);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recoverGeofences(List<GeofenceData> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.readTypedList(list, GeofenceData.CREATOR);
                    } else {
                        Stub.getDefaultImpl().recoverGeofences(list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateGeofenceData(int i, double d, double d2, double d3, int i2, int i3, int i4, int i5, int i6, int i7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    obtain.writeInt(i);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateGeofenceData(i, d, d2, d3, i2, i3, i4, i5, i6, i7);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerComponent(ComponentName componentName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerComponent(componentName);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterComponent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterComponent();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addGeofenceObjWithFlag(GeofenceData geofenceData, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.geofence.IGeofenceService");
                    if (geofenceData != null) {
                        obtain.writeInt(1);
                        geofenceData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().addGeofenceObjWithFlag(geofenceData, i);
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
        }

        public static boolean setDefaultImpl(IGeofenceService iGeofenceService) {
            if (Proxy.sDefaultImpl != null || iGeofenceService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGeofenceService;
            return true;
        }

        public static IGeofenceService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

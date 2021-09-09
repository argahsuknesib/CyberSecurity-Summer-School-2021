package com.xiaomi.smarthome.bluetooth;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeViewer;

public interface IBleUpgradeController extends IInterface {
    void attachUpgradeCaller(IBleUpgradeViewer iBleUpgradeViewer) throws RemoteException;

    void detachUpgradeCaller() throws RemoteException;

    String getCurrentVersion() throws RemoteException;

    String getLatestVersion() throws RemoteException;

    String getUpgradeDescription() throws RemoteException;

    void onActivityCreated(Bundle bundle) throws RemoteException;

    boolean onPreEnterActivity(Bundle bundle) throws RemoteException;

    void startUpgrade() throws RemoteException;

    public static abstract class Stub extends Binder implements IBleUpgradeController {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
        }

        public static IBleUpgradeController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBleUpgradeController)) {
                return new Proxy(iBinder);
            }
            return (IBleUpgradeController) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        String currentVersion = getCurrentVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(currentVersion);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        String latestVersion = getLatestVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(latestVersion);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        String upgradeDescription = getUpgradeDescription();
                        parcel2.writeNoException();
                        parcel2.writeString(upgradeDescription);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        startUpgrade();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onActivityCreated(bundle);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        attachUpgradeCaller(IBleUpgradeViewer.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        detachUpgradeCaller();
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean onPreEnterActivity = onPreEnterActivity(bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(onPreEnterActivity);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                return true;
            }
        }

        static class Proxy implements IBleUpgradeController {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.bluetooth.IBleUpgradeController";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getCurrentVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLatestVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getUpgradeDescription() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startUpgrade() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onActivityCreated(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void attachUpgradeCaller(IBleUpgradeViewer iBleUpgradeViewer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    obtain.writeStrongBinder(iBleUpgradeViewer != null ? iBleUpgradeViewer.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void detachUpgradeCaller() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean onPreEnterActivity(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.IBleUpgradeController");
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

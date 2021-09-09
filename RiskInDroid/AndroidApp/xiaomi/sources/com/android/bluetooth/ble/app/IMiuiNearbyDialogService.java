package com.android.bluetooth.ble.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMiuiNearbyDialogService extends IInterface {
    int addOrRemoveBonedDevice(String str, String str2, boolean z) throws RemoteException;

    String getDeviceExitTimeStamp(String str) throws RemoteException;

    boolean getDeviceIgnoreState(String str) throws RemoteException;

    String getWifiPassword(String str) throws RemoteException;

    int setDeviceExitTimeStamp(String str, String str2) throws RemoteException;

    int setDialogState(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiuiNearbyDialogService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
        }

        public static IMiuiNearbyDialogService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiuiNearbyDialogService)) {
                return new Proxy(iBinder);
            }
            return (IMiuiNearbyDialogService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int dialogState = setDialogState(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(dialogState);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int addOrRemoveBonedDevice = addOrRemoveBonedDevice(readString, readString2, z);
                        parcel2.writeNoException();
                        parcel2.writeInt(addOrRemoveBonedDevice);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        int deviceExitTimeStamp = setDeviceExitTimeStamp(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceExitTimeStamp);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        String deviceExitTimeStamp2 = getDeviceExitTimeStamp(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(deviceExitTimeStamp2);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        boolean deviceIgnoreState = getDeviceIgnoreState(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceIgnoreState ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                        String wifiPassword = getWifiPassword(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(wifiPassword);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                return true;
            }
        }

        static class Proxy implements IMiuiNearbyDialogService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.android.bluetooth.ble.app.IMiuiNearbyDialogService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int setDialogState(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addOrRemoveBonedDevice(String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setDeviceExitTimeStamp(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDeviceExitTimeStamp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getDeviceIgnoreState(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWifiPassword(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyDialogService");
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

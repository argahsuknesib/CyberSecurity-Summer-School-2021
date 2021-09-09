package com.android.bluetooth.ble.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.bluetooth.ble.app.IMiuiNearbyScanCallback;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IMiuiNearbyApiService extends IInterface {
    int addBonedDevice(String str) throws RemoteException;

    boolean clearNearbyConnectionConfig() throws RemoteException;

    boolean clearNearbyScanConfig() throws RemoteException;

    boolean createBondWithoutDialog(String str, int i) throws RemoteException;

    String getDeviceExitTimeStamp(String str) throws RemoteException;

    boolean getMiuiIgnoreDeviceList(String str) throws RemoteException;

    boolean getWifiMacIgnore(String str) throws RemoteException;

    String getWifiMacIgnoreTime(String str) throws RemoteException;

    String getWifiPassword(String str) throws RemoteException;

    int removeBonedDevice(String str) throws RemoteException;

    int setDeviceExitTimeStamp(String str, String str2) throws RemoteException;

    int setDialogState(boolean z) throws RemoteException;

    boolean setDialogSwitchOnOff(boolean z) throws RemoteException;

    int setNearbyConnectionListenerConfig(String str, String str2) throws RemoteException;

    int setNearbyScanConfig(IMiuiNearbyScanCallback iMiuiNearbyScanCallback, String str, String str2) throws RemoteException;

    int setWifiMacIgnore(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiuiNearbyApiService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.android.bluetooth.ble.app.IMiuiNearbyApiService");
        }

        public static IMiuiNearbyApiService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiuiNearbyApiService)) {
                return new Proxy(iBinder);
            }
            return (IMiuiNearbyApiService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int nearbyScanConfig = setNearbyScanConfig(IMiuiNearbyScanCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(nearbyScanConfig);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int nearbyConnectionListenerConfig = setNearbyConnectionListenerConfig(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(nearbyConnectionListenerConfig);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        boolean clearNearbyScanConfig = clearNearbyScanConfig();
                        parcel2.writeNoException();
                        parcel2.writeInt(clearNearbyScanConfig ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        boolean clearNearbyConnectionConfig = clearNearbyConnectionConfig();
                        parcel2.writeNoException();
                        parcel2.writeInt(clearNearbyConnectionConfig ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int dialogState = setDialogState(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(dialogState);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        String wifiPassword = getWifiPassword(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(wifiPassword);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        boolean createBondWithoutDialog = createBondWithoutDialog(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(createBondWithoutDialog ? 1 : 0);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean dialogSwitchOnOff = setDialogSwitchOnOff(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(dialogSwitchOnOff ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int addBonedDevice = addBonedDevice(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(addBonedDevice);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int removeBonedDevice = removeBonedDevice(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeBonedDevice);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int deviceExitTimeStamp = setDeviceExitTimeStamp(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceExitTimeStamp);
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        String deviceExitTimeStamp2 = getDeviceExitTimeStamp(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(deviceExitTimeStamp2);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        boolean miuiIgnoreDeviceList = getMiuiIgnoreDeviceList(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(miuiIgnoreDeviceList ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        boolean wifiMacIgnore = getWifiMacIgnore(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(wifiMacIgnore ? 1 : 0);
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        String wifiMacIgnoreTime = getWifiMacIgnoreTime(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(wifiMacIgnoreTime);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                        int wifiMacIgnore2 = setWifiMacIgnore(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(wifiMacIgnore2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                return true;
            }
        }

        static class Proxy implements IMiuiNearbyApiService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.android.bluetooth.ble.app.IMiuiNearbyApiService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int setNearbyScanConfig(IMiuiNearbyScanCallback iMiuiNearbyScanCallback, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeStrongBinder(iMiuiNearbyScanCallback != null ? iMiuiNearbyScanCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setNearbyConnectionListenerConfig(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean clearNearbyScanConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public boolean clearNearbyConnectionConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
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

            public int setDialogState(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWifiPassword(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean createBondWithoutDialog(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(7, obtain, obtain2, 0);
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

            public boolean setDialogSwitchOnOff(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addBonedDevice(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int removeBonedDevice(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getMiuiIgnoreDeviceList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(13, obtain, obtain2, 0);
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

            public boolean getWifiMacIgnore(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(14, obtain, obtain2, 0);
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

            public String getWifiMacIgnoreTime(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setWifiMacIgnore(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyApiService");
                    obtain.writeString(str);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

package miui.bluetooth.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.List;
import java.util.Map;
import miui.bluetooth.ble.IBleEventCallback;
import miui.bluetooth.ble.IScanDeviceCallback;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IMiBleDeviceManager extends IInterface {
    boolean deleteSettings(String str) throws RemoteException;

    List<String> getBoundDevices() throws RemoteException;

    Map getDeviceSettings(String str) throws RemoteException;

    int getDeviceType(String str) throws RemoteException;

    String getRegisterAppForBleEvent(String str, int i) throws RemoteException;

    ScanResult getScanResult(String str) throws RemoteException;

    int getServiceVersion() throws RemoteException;

    int getSettingInteger(String str, String str2) throws RemoteException;

    String getSettingString(String str, String str2) throws RemoteException;

    boolean registerAppForBleEvent(String str, int i) throws RemoteException;

    boolean registerBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) throws RemoteException;

    boolean setSettingInteger(String str, String str2, int i) throws RemoteException;

    boolean setSettingString(String str, String str2, String str3) throws RemoteException;

    boolean setToken(String str, byte[] bArr) throws RemoteException;

    boolean startScanDevice(IBinder iBinder, ParcelUuid parcelUuid, int i, IScanDeviceCallback iScanDeviceCallback) throws RemoteException;

    void stopScanDevice(ParcelUuid parcelUuid) throws RemoteException;

    boolean unregisterAppForBleEvent(String str, int i) throws RemoteException;

    boolean unregisterBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiBleDeviceManager {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IMiBleDeviceManager");
        }

        public static IMiBleDeviceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IMiBleDeviceManager");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiBleDeviceManager)) {
                return new Proxy(iBinder);
            }
            return (IMiBleDeviceManager) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.ParcelUuid} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ParcelUuid parcelUuid = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean settingString = setSettingString(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(settingString);
                        return true;
                    case 2:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        String settingString2 = getSettingString(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(settingString2);
                        return true;
                    case 3:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean settingInteger = setSettingInteger(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(settingInteger);
                        return true;
                    case 4:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        int settingInteger2 = getSettingInteger(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(settingInteger2);
                        return true;
                    case 5:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        Map deviceSettings = getDeviceSettings(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeMap(deviceSettings);
                        return true;
                    case 6:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean deleteSettings = deleteSettings(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deleteSettings);
                        return true;
                    case 7:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        int deviceType = getDeviceType(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceType);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        IBinder readStrongBinder = parcel.readStrongBinder();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean startScanDevice = startScanDevice(readStrongBinder, parcelUuid, parcel.readInt(), IScanDeviceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startScanDevice);
                        return true;
                    case 9:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        stopScanDevice(parcelUuid);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean registerBleEventListener = registerBleEventListener(parcel.readString(), parcel.readInt(), IBleEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(registerBleEventListener);
                        return true;
                    case 11:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean unregisterBleEventListener = unregisterBleEventListener(parcel.readString(), parcel.readInt(), IBleEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(unregisterBleEventListener);
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        int serviceVersion = getServiceVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(serviceVersion);
                        return true;
                    case 13:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        List<String> boundDevices = getBoundDevices();
                        parcel2.writeNoException();
                        parcel2.writeStringList(boundDevices);
                        return true;
                    case 14:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean registerAppForBleEvent = registerAppForBleEvent(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(registerAppForBleEvent);
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean unregisterAppForBleEvent = unregisterAppForBleEvent(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(unregisterAppForBleEvent);
                        return true;
                    case 16:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        String registerAppForBleEvent2 = getRegisterAppForBleEvent(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(registerAppForBleEvent2);
                        return true;
                    case 17:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        ScanResult scanResult = getScanResult(parcel.readString());
                        parcel2.writeNoException();
                        if (scanResult != null) {
                            parcel2.writeInt(1);
                            scanResult.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 18:
                        parcel.enforceInterface("miui.bluetooth.ble.IMiBleDeviceManager");
                        boolean token = setToken(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(token);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("miui.bluetooth.ble.IMiBleDeviceManager");
                return true;
            }
        }

        static class Proxy implements IMiBleDeviceManager {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IMiBleDeviceManager";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean setSettingString(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

            public String getSettingString(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setSettingInteger(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
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

            public int getSettingInteger(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map getDeviceSettings(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean deleteSettings(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
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

            public int getDeviceType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean startScanDevice(IBinder iBinder, ParcelUuid parcelUuid, int i, IScanDeviceCallback iScanDeviceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeStrongBinder(iBinder);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iScanDeviceCallback != null ? iScanDeviceCallback.asBinder() : null);
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

            public void stopScanDevice(ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean registerBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBleEventCallback != null ? iBleEventCallback.asBinder() : null);
                    boolean z = false;
                    this.mRemote.transact(10, obtain, obtain2, 0);
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

            public boolean unregisterBleEventListener(String str, int i, IBleEventCallback iBleEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBleEventCallback != null ? iBleEventCallback.asBinder() : null);
                    boolean z = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
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

            public int getServiceVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> getBoundDevices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean registerAppForBleEvent(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
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

            public boolean unregisterAppForBleEvent(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(15, obtain, obtain2, 0);
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

            public String getRegisterAppForBleEvent(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ScanResult getScanResult(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ScanResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setToken(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    boolean z = false;
                    this.mRemote.transact(18, obtain, obtain2, 0);
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
        }
    }
}

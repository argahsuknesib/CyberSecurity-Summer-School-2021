package miui.bluetooth.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.List;
import miui.bluetooth.ble.IBluetoothMiBleCallback;
import miui.bluetooth.ble.IBluetoothMiBlePropertyCallback;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IBluetoothMiBle extends IInterface {
    boolean authenticate(String str, ParcelUuid parcelUuid) throws RemoteException;

    boolean authorize(String str, ParcelUuid parcelUuid, String str2) throws RemoteException;

    void connect(String str, ParcelUuid parcelUuid) throws RemoteException;

    void disconnect(String str, ParcelUuid parcelUuid) throws RemoteException;

    byte[] encrypt(String str, ParcelUuid parcelUuid, byte[] bArr) throws RemoteException;

    List<BluetoothDevice> getConnectedDevices() throws RemoteException;

    byte[] getProperty(String str, ParcelUuid parcelUuid, int i) throws RemoteException;

    int getRssi(String str, ParcelUuid parcelUuid) throws RemoteException;

    int getServiceVersion() throws RemoteException;

    boolean isConnected(String str) throws RemoteException;

    void registerClient(IBinder iBinder, String str, ParcelUuid parcelUuid, IBluetoothMiBleCallback iBluetoothMiBleCallback) throws RemoteException;

    boolean registerPropertyCallback(String str, ParcelUuid parcelUuid, int i, IBluetoothMiBlePropertyCallback iBluetoothMiBlePropertyCallback) throws RemoteException;

    boolean setEncryptionKey(String str, ParcelUuid parcelUuid, byte[] bArr) throws RemoteException;

    boolean setProperty(String str, ParcelUuid parcelUuid, int i, byte[] bArr) throws RemoteException;

    boolean setRssiThreshold(String str, ParcelUuid parcelUuid, int i) throws RemoteException;

    boolean supportProperty(String str, int i) throws RemoteException;

    void unregisterClient(IBinder iBinder, String str, ParcelUuid parcelUuid) throws RemoteException;

    boolean unregisterPropertyCallback(String str, ParcelUuid parcelUuid, int i, IBluetoothMiBlePropertyCallback iBluetoothMiBlePropertyCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IBluetoothMiBle {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IBluetoothMiBle");
        }

        public static IBluetoothMiBle asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IBluetoothMiBle");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothMiBle)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothMiBle) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: android.os.ParcelUuid} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: android.os.ParcelUuid} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ParcelUuid parcelUuid = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        IBinder readStrongBinder = parcel.readStrongBinder();
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        registerClient(readStrongBinder, readString, parcelUuid, IBluetoothMiBleCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        IBinder readStrongBinder2 = parcel.readStrongBinder();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        unregisterClient(readStrongBinder2, readString2, parcelUuid);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        boolean isConnected = isConnected(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isConnected);
                        return true;
                    case 4:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        connect(readString3, parcelUuid);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        disconnect(readString4, parcelUuid);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        List<BluetoothDevice> connectedDevices = getConnectedDevices();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(connectedDevices);
                        return true;
                    case 7:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString5 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        int rssi = getRssi(readString5, parcelUuid);
                        parcel2.writeNoException();
                        parcel2.writeInt(rssi);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        boolean supportProperty = supportProperty(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(supportProperty);
                        return true;
                    case 9:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString6 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean registerPropertyCallback = registerPropertyCallback(readString6, parcelUuid, parcel.readInt(), IBluetoothMiBlePropertyCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(registerPropertyCallback);
                        return true;
                    case 10:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString7 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean unregisterPropertyCallback = unregisterPropertyCallback(readString7, parcelUuid, parcel.readInt(), IBluetoothMiBlePropertyCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(unregisterPropertyCallback);
                        return true;
                    case 11:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString8 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean property = setProperty(readString8, parcelUuid, parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(property);
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString9 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        byte[] property2 = getProperty(readString9, parcelUuid, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(property2);
                        return true;
                    case 13:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString10 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean authorize = authorize(readString10, parcelUuid, parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(authorize);
                        return true;
                    case 14:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString11 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean rssiThreshold = setRssiThreshold(readString11, parcelUuid, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(rssiThreshold);
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString12 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean authenticate = authenticate(readString12, parcelUuid);
                        parcel2.writeNoException();
                        parcel2.writeInt(authenticate);
                        return true;
                    case 16:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString13 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        boolean encryptionKey = setEncryptionKey(readString13, parcelUuid, parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(encryptionKey);
                        return true;
                    case 17:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        String readString14 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            parcelUuid = ParcelUuid.CREATOR.createFromParcel(parcel);
                        }
                        byte[] encrypt = encrypt(readString14, parcelUuid, parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(encrypt);
                        return true;
                    case 18:
                        parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBle");
                        int serviceVersion = getServiceVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(serviceVersion);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("miui.bluetooth.ble.IBluetoothMiBle");
                return true;
            }
        }

        static class Proxy implements IBluetoothMiBle {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IBluetoothMiBle";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerClient(IBinder iBinder, String str, ParcelUuid parcelUuid, IBluetoothMiBleCallback iBluetoothMiBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBluetoothMiBleCallback != null ? iBluetoothMiBleCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterClient(IBinder iBinder, String str, ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isConnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
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

            public void connect(String str, ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void disconnect(String str, ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
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

            public List<BluetoothDevice> getConnectedDevices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(BluetoothDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getRssi(String str, ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean supportProperty(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(8, obtain, obtain2, 0);
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

            public boolean registerPropertyCallback(String str, ParcelUuid parcelUuid, int i, IBluetoothMiBlePropertyCallback iBluetoothMiBlePropertyCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBluetoothMiBlePropertyCallback != null ? iBluetoothMiBlePropertyCallback.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
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

            public boolean unregisterPropertyCallback(String str, ParcelUuid parcelUuid, int i, IBluetoothMiBlePropertyCallback iBluetoothMiBlePropertyCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBluetoothMiBlePropertyCallback != null ? iBluetoothMiBlePropertyCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
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

            public boolean setProperty(String str, ParcelUuid parcelUuid, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(11, obtain, obtain2, 0);
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

            public byte[] getProperty(String str, ParcelUuid parcelUuid, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean authorize(String str, ParcelUuid parcelUuid, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.mRemote.transact(13, obtain, obtain2, 0);
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

            public boolean setRssiThreshold(String str, ParcelUuid parcelUuid, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(14, obtain, obtain2, 0);
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

            public boolean authenticate(String str, ParcelUuid parcelUuid) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(15, obtain, obtain2, 0);
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

            public boolean setEncryptionKey(String str, ParcelUuid parcelUuid, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    boolean z = true;
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(16, obtain, obtain2, 0);
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

            public byte[] encrypt(String str, ParcelUuid parcelUuid, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    obtain.writeString(str);
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getServiceVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
                    this.mRemote.transact(18, obtain, obtain2, 0);
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

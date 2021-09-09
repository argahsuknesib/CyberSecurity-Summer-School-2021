package com.xiaomi.smarthome.core.server.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.core.server.bluetooth.IProfileProxyPrepareCallback;

public interface IClassicBtRequest extends IInterface {
    boolean connectBluetoothProfile(String str, int i) throws RemoteException;

    boolean connectClassicBTSocket(String str, String str2) throws RemoteException;

    void createClassicBTService() throws RemoteException;

    void destroy() throws RemoteException;

    boolean disconnectBluetoothProfile(String str, int i) throws RemoteException;

    void disconnectClassicBtSocket() throws RemoteException;

    int getBluetoothProfileState(String str, int i) throws RemoteException;

    void prepareBluetoothProfile(int i, IProfileProxyPrepareCallback iProfileProxyPrepareCallback) throws RemoteException;

    boolean write(byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IClassicBtRequest {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
        }

        public static IClassicBtRequest asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IClassicBtRequest)) {
                return new Proxy(iBinder);
            }
            return (IClassicBtRequest) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        createClassicBTService();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        boolean connectClassicBTSocket = connectClassicBTSocket(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(connectClassicBTSocket ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        disconnectClassicBtSocket();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        boolean write = write(parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(write ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        prepareBluetoothProfile(parcel.readInt(), IProfileProxyPrepareCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        boolean connectBluetoothProfile = connectBluetoothProfile(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(connectBluetoothProfile ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        boolean disconnectBluetoothProfile = disconnectBluetoothProfile(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(disconnectBluetoothProfile ? 1 : 0);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        int bluetoothProfileState = getBluetoothProfileState(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bluetoothProfileState);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                return true;
            }
        }

        static class Proxy implements IClassicBtRequest {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void createClassicBTService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean connectClassicBTSocket(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            public void disconnectClassicBtSocket() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean write(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    obtain.writeByteArray(bArr);
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

            public void prepareBluetoothProfile(int i, IProfileProxyPrepareCallback iProfileProxyPrepareCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iProfileProxyPrepareCallback != null ? iProfileProxyPrepareCallback.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean connectBluetoothProfile(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
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

            public boolean disconnectBluetoothProfile(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
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

            public int getBluetoothProfileState(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

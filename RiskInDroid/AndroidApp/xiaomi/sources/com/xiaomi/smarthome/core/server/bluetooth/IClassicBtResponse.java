package com.xiaomi.smarthome.core.server.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IClassicBtResponse extends IInterface {
    void onBondStateChange(String str, int i) throws RemoteException;

    void onConnectionStateChanged(String str, int i) throws RemoteException;

    void onReceiveData(String str, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IClassicBtResponse {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
        }

        public static IClassicBtResponse asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IClassicBtResponse)) {
                return new Proxy(iBinder);
            }
            return (IClassicBtResponse) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                onBondStateChange(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                onConnectionStateChanged(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                onReceiveData(parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                return true;
            }
        }

        static class Proxy implements IClassicBtResponse {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onBondStateChange(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onConnectionStateChanged(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onReceiveData(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IClassicBtResponse");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

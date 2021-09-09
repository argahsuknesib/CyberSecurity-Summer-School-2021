package com.android.bluetooth.ble.app;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMiuiNearbyScanCallback extends IInterface {
    void onDeviceFound(BluetoothDevice bluetoothDevice, int i, byte[] bArr) throws RemoteException;

    void onScanStart() throws RemoteException;

    void onScanStop() throws RemoteException;

    public static abstract class Stub extends Binder implements IMiuiNearbyScanCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
        }

        public static IMiuiNearbyScanCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiuiNearbyScanCallback)) {
                return new Proxy(iBinder);
            }
            return (IMiuiNearbyScanCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                onScanStart();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                onScanStop();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                onDeviceFound(parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.createByteArray());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                return true;
            }
        }

        static class Proxy implements IMiuiNearbyScanCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.android.bluetooth.ble.app.IMiuiNearbyScanCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onScanStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onScanStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onDeviceFound(BluetoothDevice bluetoothDevice, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.bluetooth.ble.app.IMiuiNearbyScanCallback");
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

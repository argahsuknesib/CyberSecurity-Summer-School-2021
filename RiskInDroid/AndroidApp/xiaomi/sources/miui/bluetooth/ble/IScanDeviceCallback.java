package miui.bluetooth.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IScanDeviceCallback extends IInterface {
    void onScanDevice(int i, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IScanDeviceCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IScanDeviceCallback");
        }

        public static IScanDeviceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IScanDeviceCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IScanDeviceCallback)) {
                return new Proxy(iBinder);
            }
            return (IScanDeviceCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("miui.bluetooth.ble.IScanDeviceCallback");
                onScanDevice(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("miui.bluetooth.ble.IScanDeviceCallback");
                return true;
            }
        }

        static class Proxy implements IScanDeviceCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IScanDeviceCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onScanDevice(int i, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IScanDeviceCallback");
                    obtain.writeInt(i);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

package miui.bluetooth.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.RemoteException;

public interface IBluetoothMiBlePropertyCallback extends IInterface {
    void notifyProperty(ParcelUuid parcelUuid, int i, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IBluetoothMiBlePropertyCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
        }

        public static IBluetoothMiBlePropertyCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothMiBlePropertyCallback)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothMiBlePropertyCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
                notifyProperty(parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
                return true;
            }
        }

        static class Proxy implements IBluetoothMiBlePropertyCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IBluetoothMiBlePropertyCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void notifyProperty(ParcelUuid parcelUuid, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
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

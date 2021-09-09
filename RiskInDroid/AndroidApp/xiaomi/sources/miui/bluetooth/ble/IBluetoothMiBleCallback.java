package miui.bluetooth.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.RemoteException;

public interface IBluetoothMiBleCallback extends IInterface {
    void onConnectionState(ParcelUuid parcelUuid, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IBluetoothMiBleCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IBluetoothMiBleCallback");
        }

        public static IBluetoothMiBleCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IBluetoothMiBleCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothMiBleCallback)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothMiBleCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("miui.bluetooth.ble.IBluetoothMiBleCallback");
                onConnectionState(parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("miui.bluetooth.ble.IBluetoothMiBleCallback");
                return true;
            }
        }

        static class Proxy implements IBluetoothMiBleCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IBluetoothMiBleCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onConnectionState(ParcelUuid parcelUuid, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBleCallback");
                    if (parcelUuid != null) {
                        obtain.writeInt(1);
                        parcelUuid.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
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

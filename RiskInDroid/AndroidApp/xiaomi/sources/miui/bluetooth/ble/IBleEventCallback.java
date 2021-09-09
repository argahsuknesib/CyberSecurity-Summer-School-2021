package miui.bluetooth.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBleEventCallback extends IInterface {
    boolean onEvent(String str, int i, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IBleEventCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "miui.bluetooth.ble.IBleEventCallback");
        }

        public static IBleEventCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("miui.bluetooth.ble.IBleEventCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBleEventCallback)) {
                return new Proxy(iBinder);
            }
            return (IBleEventCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("miui.bluetooth.ble.IBleEventCallback");
                boolean onEvent = onEvent(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(onEvent ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("miui.bluetooth.ble.IBleEventCallback");
                return true;
            }
        }

        static class Proxy implements IBleEventCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "miui.bluetooth.ble.IBleEventCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean onEvent(String str, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("miui.bluetooth.ble.IBleEventCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
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
        }
    }
}

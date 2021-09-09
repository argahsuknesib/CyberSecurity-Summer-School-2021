package com.inuker.bluetooth.library;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.inuker.bluetooth.library.IResponse;

public interface IBluetoothService extends IInterface {
    void callBluetoothApi(int i, Bundle bundle, IResponse iResponse) throws RemoteException;

    public static abstract class Stub extends Binder implements IBluetoothService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.inuker.bluetooth.library.IBluetoothService");
        }

        public static IBluetoothService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.inuker.bluetooth.library.IBluetoothService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothService)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.inuker.bluetooth.library.IBluetoothService");
                int readInt = parcel.readInt();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                callBluetoothApi(readInt, bundle, IResponse.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.inuker.bluetooth.library.IBluetoothService");
                return true;
            }
        }

        static class Proxy implements IBluetoothService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.inuker.bluetooth.library.IBluetoothService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void callBluetoothApi(int i, Bundle bundle, IResponse iResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.inuker.bluetooth.library.IBluetoothService");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iResponse != null ? iResponse.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

package com.xiaomi.idm.uwb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMiCloseRangeCallback extends IInterface {
    void onTransportChannelCommand(byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiCloseRangeCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.idm.uwb.IMiCloseRangeCallback");
        }

        public static IMiCloseRangeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.idm.uwb.IMiCloseRangeCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiCloseRangeCallback)) {
                return new Proxy(iBinder);
            }
            return (IMiCloseRangeCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRangeCallback");
                onTransportChannelCommand(parcel.createByteArray());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.idm.uwb.IMiCloseRangeCallback");
                return true;
            }
        }

        static class Proxy implements IMiCloseRangeCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.idm.uwb.IMiCloseRangeCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onTransportChannelCommand(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRangeCallback");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

package com.xiaomi.smarthome.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface SyncConfigCallback extends IInterface {
    void onResponse(int i, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements SyncConfigCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.sdk.SyncConfigCallback");
        }

        public static SyncConfigCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.sdk.SyncConfigCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof SyncConfigCallback)) {
                return new Proxy(iBinder);
            }
            return (SyncConfigCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.sdk.SyncConfigCallback");
                onResponse(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.sdk.SyncConfigCallback");
                return true;
            }
        }

        static class Proxy implements SyncConfigCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.sdk.SyncConfigCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onResponse(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.sdk.SyncConfigCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
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

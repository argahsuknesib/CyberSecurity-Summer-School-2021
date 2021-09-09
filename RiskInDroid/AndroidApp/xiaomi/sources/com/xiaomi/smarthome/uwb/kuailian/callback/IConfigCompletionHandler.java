package com.xiaomi.smarthome.uwb.kuailian.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IConfigCompletionHandler extends IInterface {
    void onFailed(int i, String str) throws RemoteException;

    void onSucceed(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IConfigCompletionHandler {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
        }

        public static IConfigCompletionHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IConfigCompletionHandler)) {
                return new Proxy(iBinder);
            }
            return (IConfigCompletionHandler) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
                onSucceed(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
                onFailed(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
                return true;
            }
        }

        static class Proxy implements IConfigCompletionHandler {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSucceed(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onFailed(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

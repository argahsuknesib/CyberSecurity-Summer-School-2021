package com.xiaomi.smarthome.device.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ISceneCallback extends IInterface {
    void onSceneLoadFinished(List<SceneInfo> list) throws RemoteException;

    public static abstract class Stub extends Binder implements ISceneCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.device.api.ISceneCallback");
        }

        public static ISceneCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.device.api.ISceneCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISceneCallback)) {
                return new Proxy(iBinder);
            }
            return (ISceneCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.device.api.ISceneCallback");
                onSceneLoadFinished(parcel.createTypedArrayList(SceneInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.device.api.ISceneCallback");
                return true;
            }
        }

        static class Proxy implements ISceneCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.device.api.ISceneCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSceneLoadFinished(List<SceneInfo> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.device.api.ISceneCallback");
                    obtain.writeTypedList(list);
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

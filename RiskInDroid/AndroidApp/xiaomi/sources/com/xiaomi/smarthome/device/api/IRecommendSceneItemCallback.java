package com.xiaomi.smarthome.device.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IRecommendSceneItemCallback extends IInterface {
    void onRequestFailed(int i, String str) throws RemoteException;

    void onRequestSuccess(List<RecommendSceneItem> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IRecommendSceneItemCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
        }

        public static IRecommendSceneItemCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRecommendSceneItemCallback)) {
                return new Proxy(iBinder);
            }
            return (IRecommendSceneItemCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
                onRequestSuccess(parcel.createTypedArrayList(RecommendSceneItem.CREATOR));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
                onRequestFailed(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
                return true;
            }
        }

        static class Proxy implements IRecommendSceneItemCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onRequestSuccess(List<RecommendSceneItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
                    obtain.writeTypedList(list);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestFailed(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback");
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

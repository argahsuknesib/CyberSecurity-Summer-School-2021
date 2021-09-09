package com.xiaomi.smarthome.miio.camera;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IQueryCameraThumbService extends IInterface {
    Bitmap queryCameraThumb(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IQueryCameraThumbService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService");
        }

        public static IQueryCameraThumbService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IQueryCameraThumbService)) {
                return new Proxy(iBinder);
            }
            return (IQueryCameraThumbService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService");
                Bitmap queryCameraThumb = queryCameraThumb(parcel.readString());
                parcel2.writeNoException();
                if (queryCameraThumb != null) {
                    parcel2.writeInt(1);
                    queryCameraThumb.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService");
                return true;
            }
        }

        static class Proxy implements IQueryCameraThumbService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public Bitmap queryCameraThumb(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.miio.camera.IQueryCameraThumbService");
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

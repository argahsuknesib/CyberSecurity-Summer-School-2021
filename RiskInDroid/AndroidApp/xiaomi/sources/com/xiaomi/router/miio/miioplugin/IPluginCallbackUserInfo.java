package com.xiaomi.router.miio.miioplugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.device.api.UserInfo;

public interface IPluginCallbackUserInfo extends IInterface {
    void onRequestFailed(int i, String str) throws RemoteException;

    void onRequestSuccess(UserInfo userInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements IPluginCallbackUserInfo {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
        }

        public static IPluginCallbackUserInfo asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPluginCallbackUserInfo)) {
                return new Proxy(iBinder);
            }
            return (IPluginCallbackUserInfo) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
                onRequestSuccess(parcel.readInt() != 0 ? UserInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
                onRequestFailed(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
                return true;
            }
        }

        static class Proxy implements IPluginCallbackUserInfo {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onRequestSuccess(UserInfo userInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
                    if (userInfo != null) {
                        obtain.writeInt(1);
                        userInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
                    obtain.writeInterfaceToken("com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo");
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

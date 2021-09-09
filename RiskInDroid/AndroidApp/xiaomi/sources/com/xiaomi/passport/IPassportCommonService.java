package com.xiaomi.passport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.accountsdk.service.DeviceInfoResult;

public interface IPassportCommonService extends IInterface {

    public static class Default implements IPassportCommonService {
        public IBinder asBinder() {
            return null;
        }

        public DeviceInfoResult getDeviceInfo(String str, int i) throws RemoteException {
            return null;
        }
    }

    DeviceInfoResult getDeviceInfo(String str, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IPassportCommonService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.IPassportCommonService");
        }

        public static IPassportCommonService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.IPassportCommonService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPassportCommonService)) {
                return new Proxy(iBinder);
            }
            return (IPassportCommonService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.passport.IPassportCommonService");
                DeviceInfoResult deviceInfo = getDeviceInfo(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                if (deviceInfo != null) {
                    parcel2.writeInt(1);
                    deviceInfo.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.passport.IPassportCommonService");
                return true;
            }
        }

        static class Proxy implements IPassportCommonService {
            public static IPassportCommonService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.IPassportCommonService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public DeviceInfoResult getDeviceInfo(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportCommonService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDeviceInfo(str, i);
                    }
                    obtain2.readException();
                    DeviceInfoResult createFromParcel = obtain2.readInt() != 0 ? DeviceInfoResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPassportCommonService iPassportCommonService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iPassportCommonService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iPassportCommonService;
                return true;
            }
        }

        public static IPassportCommonService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

package com.miui.tsmclient.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.tsmclient.smartcard.terminal.SmartMxError;

public interface INfcConfigService extends IInterface {
    boolean setConfig(String str, SmartMxError smartMxError) throws RemoteException;

    boolean setConfigByUrl(String str, SmartMxError smartMxError) throws RemoteException;

    public static abstract class Stub extends Binder implements INfcConfigService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclient.service.INfcConfigService");
        }

        public static INfcConfigService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclient.service.INfcConfigService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof INfcConfigService)) {
                return new Proxy(iBinder);
            }
            return (INfcConfigService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.tsmclient.service.INfcConfigService");
                String readString = parcel.readString();
                SmartMxError smartMxError = new SmartMxError();
                boolean config = setConfig(readString, smartMxError);
                parcel2.writeNoException();
                parcel2.writeInt(config ? 1 : 0);
                parcel2.writeInt(1);
                smartMxError.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.miui.tsmclient.service.INfcConfigService");
                String readString2 = parcel.readString();
                SmartMxError smartMxError2 = new SmartMxError();
                boolean configByUrl = setConfigByUrl(readString2, smartMxError2);
                parcel2.writeNoException();
                parcel2.writeInt(configByUrl ? 1 : 0);
                parcel2.writeInt(1);
                smartMxError2.writeToParcel(parcel2, 1);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.miui.tsmclient.service.INfcConfigService");
                return true;
            }
        }

        static class Proxy implements INfcConfigService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclient.service.INfcConfigService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean setConfig(String str, SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.INfcConfigService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setConfigByUrl(String str, SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.INfcConfigService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
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

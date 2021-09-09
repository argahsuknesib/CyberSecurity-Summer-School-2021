package com.miui.tsmclientsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMiTsmStatusService extends IInterface {
    int getPhoneStatus() throws RemoteException;

    public static abstract class Stub extends Binder implements IMiTsmStatusService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclientsdk.IMiTsmStatusService");
        }

        public static IMiTsmStatusService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclientsdk.IMiTsmStatusService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiTsmStatusService)) {
                return new Proxy(iBinder);
            }
            return (IMiTsmStatusService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmStatusService");
                int phoneStatus = getPhoneStatus();
                parcel2.writeNoException();
                parcel2.writeInt(phoneStatus);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.miui.tsmclientsdk.IMiTsmStatusService");
                return true;
            }
        }

        static class Proxy implements IMiTsmStatusService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclientsdk.IMiTsmStatusService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int getPhoneStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmStatusService");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

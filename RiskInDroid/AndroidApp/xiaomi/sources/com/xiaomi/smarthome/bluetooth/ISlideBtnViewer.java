package com.xiaomi.smarthome.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISlideBtnViewer extends IInterface {
    void setChecked(String str, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements ISlideBtnViewer {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.bluetooth.ISlideBtnViewer");
        }

        public static ISlideBtnViewer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnViewer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISlideBtnViewer)) {
                return new Proxy(iBinder);
            }
            return (ISlideBtnViewer) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnViewer");
                setChecked(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.bluetooth.ISlideBtnViewer");
                return true;
            }
        }

        static class Proxy implements ISlideBtnViewer {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.bluetooth.ISlideBtnViewer";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void setChecked(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.ISlideBtnViewer");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
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

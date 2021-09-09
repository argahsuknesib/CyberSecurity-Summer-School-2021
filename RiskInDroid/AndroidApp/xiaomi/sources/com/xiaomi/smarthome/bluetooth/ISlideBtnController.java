package com.xiaomi.smarthome.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.ISlideBtnViewer;

public interface ISlideBtnController extends IInterface {
    void attachSlideBtnViewer(ISlideBtnViewer iSlideBtnViewer) throws RemoteException;

    void detachSlideBtnViewer() throws RemoteException;

    void onCheckedChanged(String str, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements ISlideBtnController {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.bluetooth.ISlideBtnController");
        }

        public static ISlideBtnController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISlideBtnController)) {
                return new Proxy(iBinder);
            }
            return (ISlideBtnController) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                onCheckedChanged(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                attachSlideBtnViewer(ISlideBtnViewer.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                detachSlideBtnViewer();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                return true;
            }
        }

        static class Proxy implements ISlideBtnController {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.bluetooth.ISlideBtnController";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onCheckedChanged(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void attachSlideBtnViewer(ISlideBtnViewer iSlideBtnViewer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                    obtain.writeStrongBinder(iSlideBtnViewer != null ? iSlideBtnViewer.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void detachSlideBtnViewer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.bluetooth.ISlideBtnController");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

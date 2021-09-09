package net.sqlcipher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IContentObserver extends IInterface {
    void onChange(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IContentObserver {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "net.sqlcipher.IContentObserver");
        }

        public static IContentObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("net.sqlcipher.IContentObserver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IContentObserver)) {
                return new Proxy(iBinder);
            }
            return (IContentObserver) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("net.sqlcipher.IContentObserver");
                onChange(parcel.readInt() != 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("net.sqlcipher.IContentObserver");
                return true;
            }
        }

        static class Proxy implements IContentObserver {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "net.sqlcipher.IContentObserver";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onChange(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("net.sqlcipher.IContentObserver");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

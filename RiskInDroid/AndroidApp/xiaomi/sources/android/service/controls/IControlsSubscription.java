package android.service.controls;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IControlsSubscription extends IInterface {

    public static class Default implements IControlsSubscription {
        public IBinder asBinder() {
            return null;
        }

        public void cancel() throws RemoteException {
        }

        public void request(long j) throws RemoteException {
        }
    }

    void cancel() throws RemoteException;

    void request(long j) throws RemoteException;

    public static abstract class Stub extends Binder implements IControlsSubscription {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.service.controls.IControlsSubscription");
        }

        public static IControlsSubscription asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.service.controls.IControlsSubscription");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IControlsSubscription)) {
                return new Proxy(iBinder);
            }
            return (IControlsSubscription) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.service.controls.IControlsSubscription");
                request(parcel.readLong());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("android.service.controls.IControlsSubscription");
                cancel();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.service.controls.IControlsSubscription");
                return true;
            }
        }

        static class Proxy implements IControlsSubscription {
            public static IControlsSubscription sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.service.controls.IControlsSubscription";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void request(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscription");
                    obtain.writeLong(j);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().request(j);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscription");
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancel();
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IControlsSubscription iControlsSubscription) {
            if (Proxy.sDefaultImpl != null || iControlsSubscription == null) {
                return false;
            }
            Proxy.sDefaultImpl = iControlsSubscription;
            return true;
        }

        public static IControlsSubscription getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

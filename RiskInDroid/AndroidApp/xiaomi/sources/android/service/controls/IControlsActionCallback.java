package android.service.controls;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IControlsActionCallback extends IInterface {

    public static class Default implements IControlsActionCallback {
        public void accept(IBinder iBinder, String str, int i) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    void accept(IBinder iBinder, String str, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IControlsActionCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.service.controls.IControlsActionCallback");
        }

        public static IControlsActionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.service.controls.IControlsActionCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IControlsActionCallback)) {
                return new Proxy(iBinder);
            }
            return (IControlsActionCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.service.controls.IControlsActionCallback");
                accept(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.service.controls.IControlsActionCallback");
                return true;
            }
        }

        static class Proxy implements IControlsActionCallback {
            public static IControlsActionCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.service.controls.IControlsActionCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void accept(IBinder iBinder, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsActionCallback");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().accept(iBinder, str, i);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IControlsActionCallback iControlsActionCallback) {
            if (Proxy.sDefaultImpl != null || iControlsActionCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iControlsActionCallback;
            return true;
        }

        public static IControlsActionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

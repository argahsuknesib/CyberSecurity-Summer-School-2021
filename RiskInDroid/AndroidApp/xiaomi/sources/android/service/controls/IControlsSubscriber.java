package android.service.controls;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.controls.IControlsSubscription;

public interface IControlsSubscriber extends IInterface {

    public static class Default implements IControlsSubscriber {
        public IBinder asBinder() {
            return null;
        }

        public void onComplete(IBinder iBinder) throws RemoteException {
        }

        public void onError(IBinder iBinder, String str) throws RemoteException {
        }

        public void onNext(IBinder iBinder, Control control) throws RemoteException {
        }

        public void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException {
        }
    }

    void onComplete(IBinder iBinder) throws RemoteException;

    void onError(IBinder iBinder, String str) throws RemoteException;

    void onNext(IBinder iBinder, Control control) throws RemoteException;

    void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException;

    public static abstract class Stub extends Binder implements IControlsSubscriber {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.service.controls.IControlsSubscriber");
        }

        public static IControlsSubscriber asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.service.controls.IControlsSubscriber");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IControlsSubscriber)) {
                return new Proxy(iBinder);
            }
            return (IControlsSubscriber) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.service.controls.IControlsSubscriber");
                onSubscribe(parcel.readStrongBinder(), IControlsSubscription.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("android.service.controls.IControlsSubscriber");
                onNext(parcel.readStrongBinder(), parcel.readInt() != 0 ? Control.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("android.service.controls.IControlsSubscriber");
                onError(parcel.readStrongBinder(), parcel.readString());
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("android.service.controls.IControlsSubscriber");
                onComplete(parcel.readStrongBinder());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.service.controls.IControlsSubscriber");
                return true;
            }
        }

        static class Proxy implements IControlsSubscriber {
            public static IControlsSubscriber sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.service.controls.IControlsSubscriber";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSubscribe(IBinder iBinder, IControlsSubscription iControlsSubscription) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscriber");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeStrongBinder(iControlsSubscription != null ? iControlsSubscription.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSubscribe(iBinder, iControlsSubscription);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onNext(IBinder iBinder, Control control) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscriber");
                    obtain.writeStrongBinder(iBinder);
                    if (control != null) {
                        obtain.writeInt(1);
                        control.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onNext(iBinder, control);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(IBinder iBinder, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscriber");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onError(iBinder, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onComplete(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsSubscriber");
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onComplete(iBinder);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IControlsSubscriber iControlsSubscriber) {
            if (Proxy.sDefaultImpl != null || iControlsSubscriber == null) {
                return false;
            }
            Proxy.sDefaultImpl = iControlsSubscriber;
            return true;
        }

        public static IControlsSubscriber getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

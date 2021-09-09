package android.service.controls;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.controls.IControlsActionCallback;
import android.service.controls.IControlsSubscriber;
import android.service.controls.actions.ControlActionWrapper;
import java.util.List;

public interface IControlsProvider extends IInterface {

    public static class Default implements IControlsProvider {
        public void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void load(IControlsSubscriber iControlsSubscriber) throws RemoteException {
        }

        public void loadSuggested(IControlsSubscriber iControlsSubscriber) throws RemoteException {
        }

        public void subscribe(List<String> list, IControlsSubscriber iControlsSubscriber) throws RemoteException {
        }
    }

    void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException;

    void load(IControlsSubscriber iControlsSubscriber) throws RemoteException;

    void loadSuggested(IControlsSubscriber iControlsSubscriber) throws RemoteException;

    void subscribe(List<String> list, IControlsSubscriber iControlsSubscriber) throws RemoteException;

    public static abstract class Stub extends Binder implements IControlsProvider {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.service.controls.IControlsProvider");
        }

        public static IControlsProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.service.controls.IControlsProvider");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IControlsProvider)) {
                return new Proxy(iBinder);
            }
            return (IControlsProvider) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.service.controls.IControlsProvider");
                load(IControlsSubscriber.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("android.service.controls.IControlsProvider");
                loadSuggested(IControlsSubscriber.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("android.service.controls.IControlsProvider");
                subscribe(parcel.createStringArrayList(), IControlsSubscriber.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("android.service.controls.IControlsProvider");
                action(parcel.readString(), parcel.readInt() != 0 ? ControlActionWrapper.CREATOR.createFromParcel(parcel) : null, IControlsActionCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.service.controls.IControlsProvider");
                return true;
            }
        }

        static class Proxy implements IControlsProvider {
            public static IControlsProvider sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.service.controls.IControlsProvider";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void load(IControlsSubscriber iControlsSubscriber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsProvider");
                    obtain.writeStrongBinder(iControlsSubscriber != null ? iControlsSubscriber.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().load(iControlsSubscriber);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void loadSuggested(IControlsSubscriber iControlsSubscriber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsProvider");
                    obtain.writeStrongBinder(iControlsSubscriber != null ? iControlsSubscriber.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().loadSuggested(iControlsSubscriber);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void subscribe(List<String> list, IControlsSubscriber iControlsSubscriber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsProvider");
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(iControlsSubscriber != null ? iControlsSubscriber.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().subscribe(list, iControlsSubscriber);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void action(String str, ControlActionWrapper controlActionWrapper, IControlsActionCallback iControlsActionCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.service.controls.IControlsProvider");
                    obtain.writeString(str);
                    if (controlActionWrapper != null) {
                        obtain.writeInt(1);
                        controlActionWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iControlsActionCallback != null ? iControlsActionCallback.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().action(str, controlActionWrapper, iControlsActionCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IControlsProvider iControlsProvider) {
            if (Proxy.sDefaultImpl != null || iControlsProvider == null) {
                return false;
            }
            Proxy.sDefaultImpl = iControlsProvider;
            return true;
        }

        public static IControlsProvider getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

package com.xiaomi.simactivate;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISimActivateService extends IInterface {

    public static class Default implements ISimActivateService {
        public IBinder asBinder() {
            return null;
        }

        public Bundle invoke(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        public int isSupported(String str, Bundle bundle) throws RemoteException {
            return 0;
        }
    }

    Bundle invoke(String str, Bundle bundle) throws RemoteException;

    int isSupported(String str, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ISimActivateService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.simactivate.ISimActivateService");
        }

        public static ISimActivateService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.simactivate.ISimActivateService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISimActivateService)) {
                return new Proxy(iBinder);
            }
            return (ISimActivateService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.simactivate.ISimActivateService");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                int isSupported = isSupported(readString, bundle);
                parcel2.writeNoException();
                parcel2.writeInt(isSupported);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.simactivate.ISimActivateService");
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                Bundle invoke = invoke(readString2, bundle);
                parcel2.writeNoException();
                if (invoke != null) {
                    parcel2.writeInt(1);
                    invoke.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.simactivate.ISimActivateService");
                return true;
            }
        }

        static class Proxy implements ISimActivateService {
            public static ISimActivateService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.simactivate.ISimActivateService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int isSupported(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.simactivate.ISimActivateService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupported(str, bundle);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle invoke(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.simactivate.ISimActivateService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().invoke(str, bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ISimActivateService iSimActivateService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iSimActivateService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSimActivateService;
                return true;
            }
        }

        public static ISimActivateService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

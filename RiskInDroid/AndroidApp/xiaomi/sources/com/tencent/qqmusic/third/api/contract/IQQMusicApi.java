package com.tencent.qqmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qqmusic.third.api.contract.IQQMusicApiCallback;
import com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener;
import java.util.List;

public interface IQQMusicApi extends IInterface {
    Bundle execute(String str, Bundle bundle) throws RemoteException;

    void executeAsync(String str, Bundle bundle, IQQMusicApiCallback iQQMusicApiCallback) throws RemoteException;

    Bundle registerEventListener(List<String> list, IQQMusicApiEventListener iQQMusicApiEventListener) throws RemoteException;

    Bundle unregisterEventListener(List<String> list, IQQMusicApiEventListener iQQMusicApiEventListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IQQMusicApi {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.tencent.qqmusic.third.api.contract.IQQMusicApi");
        }

        public static IQQMusicApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IQQMusicApi)) {
                return new Proxy(iBinder);
            }
            return (IQQMusicApi) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            if (i == 1) {
                parcel.enforceInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                Bundle execute = execute(readString, bundle);
                parcel2.writeNoException();
                if (execute != null) {
                    parcel2.writeInt(1);
                    execute.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = Bundle.CREATOR.createFromParcel(parcel);
                }
                executeAsync(readString2, bundle, IQQMusicApiCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                Bundle registerEventListener = registerEventListener(parcel.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (registerEventListener != null) {
                    parcel2.writeInt(1);
                    registerEventListener.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                Bundle unregisterEventListener = unregisterEventListener(parcel.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (unregisterEventListener != null) {
                    parcel2.writeInt(1);
                    unregisterEventListener.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                return true;
            }
        }

        static class Proxy implements IQQMusicApi {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.tencent.qqmusic.third.api.contract.IQQMusicApi";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public Bundle execute(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void executeAsync(String str, Bundle bundle, IQQMusicApiCallback iQQMusicApiCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iQQMusicApiCallback != null ? iQQMusicApiCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public Bundle registerEventListener(List<String> list, IQQMusicApiEventListener iQQMusicApiEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                    obtain.writeStringList(list);
                    Bundle bundle = null;
                    obtain.writeStrongBinder(iQQMusicApiEventListener != null ? iQQMusicApiEventListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle unregisterEventListener(List<String> list, IQQMusicApiEventListener iQQMusicApiEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.qqmusic.third.api.contract.IQQMusicApi");
                    obtain.writeStringList(list);
                    Bundle bundle = null;
                    obtain.writeStrongBinder(iQQMusicApiEventListener != null ? iQQMusicApiEventListener.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

package com.xiaomi.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.account.IXiaomiAuthResponse;

public interface IXiaomiAuthService extends IInterface {
    void getAccessTokenInResponse(IXiaomiAuthResponse iXiaomiAuthResponse, Bundle bundle, int i, int i2) throws RemoteException;

    Bundle getMiCloudAccessToken(Account account, Bundle bundle) throws RemoteException;

    Bundle getMiCloudUserInfo(Account account, Bundle bundle) throws RemoteException;

    Bundle getSnsAccessToken(Account account, Bundle bundle) throws RemoteException;

    int getVersionNum() throws RemoteException;

    void invalidateAccessToken(Account account, Bundle bundle) throws RemoteException;

    boolean isSupport(String str) throws RemoteException;

    boolean supportResponseWay() throws RemoteException;

    public static abstract class Stub extends Binder implements IXiaomiAuthService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.account.IXiaomiAuthService");
        }

        public static IXiaomiAuthService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.account.IXiaomiAuthService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXiaomiAuthService)) {
                return new Proxy(iBinder);
            }
            return (IXiaomiAuthService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        Account account = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle miCloudUserInfo = getMiCloudUserInfo(account, bundle);
                        parcel2.writeNoException();
                        if (miCloudUserInfo != null) {
                            parcel2.writeInt(1);
                            miCloudUserInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        Account account2 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle miCloudAccessToken = getMiCloudAccessToken(account2, bundle);
                        parcel2.writeNoException();
                        if (miCloudAccessToken != null) {
                            parcel2.writeInt(1);
                            miCloudAccessToken.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        Account account3 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle snsAccessToken = getSnsAccessToken(account3, bundle);
                        parcel2.writeNoException();
                        if (snsAccessToken != null) {
                            parcel2.writeInt(1);
                            snsAccessToken.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        Account account4 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        invalidateAccessToken(account4, bundle);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        boolean supportResponseWay = supportResponseWay();
                        parcel2.writeNoException();
                        parcel2.writeInt(supportResponseWay);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        IXiaomiAuthResponse asInterface = IXiaomiAuthResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getAccessTokenInResponse(asInterface, bundle, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        int versionNum = getVersionNum();
                        parcel2.writeNoException();
                        parcel2.writeInt(versionNum);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
                        boolean isSupport = isSupport(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupport);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.account.IXiaomiAuthService");
                return true;
            }
        }

        static class Proxy implements IXiaomiAuthService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.account.IXiaomiAuthService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public Bundle getMiCloudUserInfo(Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public Bundle getMiCloudAccessToken(Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSnsAccessToken(Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void invalidateAccessToken(Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean supportResponseWay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAccessTokenInResponse(IXiaomiAuthResponse iXiaomiAuthResponse, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    obtain.writeStrongBinder(iXiaomiAuthResponse != null ? iXiaomiAuthResponse.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getVersionNum() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isSupport(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

package com.xiaomi.accountsdk.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;

public interface IXiaomiAccountService extends IInterface {

    public static class Default implements IXiaomiAccountService {
        public IBinder asBinder() {
            return null;
        }

        public String getAccessToken(Account account, String str, String str2, boolean z) throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getAvatarFd(Account account) throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getAvatarFdByFileName(String str) throws RemoteException {
            return null;
        }

        public String getEmail(Account account) throws RemoteException {
            return null;
        }

        public String getEncryptedUserId(Account account) throws RemoteException {
            return null;
        }

        public String getNickName(Account account) throws RemoteException {
            return null;
        }

        public String getPhone(Account account) throws RemoteException {
            return null;
        }

        public String getSnsAccessToken(String str) throws RemoteException {
            return null;
        }

        public String getUserName(Account account) throws RemoteException {
            return null;
        }

        public XiaomiAccount getXiaomiAccount(boolean z, Account account) throws RemoteException {
            return null;
        }

        public boolean invalidateSnsAccessToken(String str, String str2) throws RemoteException {
            return false;
        }
    }

    String getAccessToken(Account account, String str, String str2, boolean z) throws RemoteException;

    ParcelFileDescriptor getAvatarFd(Account account) throws RemoteException;

    ParcelFileDescriptor getAvatarFdByFileName(String str) throws RemoteException;

    String getEmail(Account account) throws RemoteException;

    String getEncryptedUserId(Account account) throws RemoteException;

    String getNickName(Account account) throws RemoteException;

    String getPhone(Account account) throws RemoteException;

    String getSnsAccessToken(String str) throws RemoteException;

    String getUserName(Account account) throws RemoteException;

    XiaomiAccount getXiaomiAccount(boolean z, Account account) throws RemoteException;

    boolean invalidateSnsAccessToken(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IXiaomiAccountService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.accountsdk.account.IXiaomiAccountService");
        }

        public static IXiaomiAccountService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXiaomiAccountService)) {
                return new Proxy(iBinder);
            }
            return (IXiaomiAccountService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: android.accounts.Account} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                Account account = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String userName = getUserName(account);
                        parcel2.writeNoException();
                        parcel2.writeString(userName);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String nickName = getNickName(account);
                        parcel2.writeNoException();
                        parcel2.writeString(nickName);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String email = getEmail(account);
                        parcel2.writeNoException();
                        parcel2.writeString(email);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String encryptedUserId = getEncryptedUserId(account);
                        parcel2.writeNoException();
                        parcel2.writeString(encryptedUserId);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String phone = getPhone(account);
                        parcel2.writeNoException();
                        parcel2.writeString(phone);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        ParcelFileDescriptor avatarFd = getAvatarFd(account);
                        parcel2.writeNoException();
                        if (avatarFd != null) {
                            parcel2.writeInt(1);
                            avatarFd.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        boolean z2 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        XiaomiAccount xiaomiAccount = getXiaomiAccount(z2, account);
                        parcel2.writeNoException();
                        if (xiaomiAccount != null) {
                            parcel2.writeInt(1);
                            xiaomiAccount.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        ParcelFileDescriptor avatarFdByFileName = getAvatarFdByFileName(parcel.readString());
                        parcel2.writeNoException();
                        if (avatarFdByFileName != null) {
                            parcel2.writeInt(1);
                            avatarFdByFileName.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        if (parcel.readInt() != 0) {
                            account = Account.CREATOR.createFromParcel(parcel);
                        }
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        String accessToken = getAccessToken(account, readString, readString2, z);
                        parcel2.writeNoException();
                        parcel2.writeString(accessToken);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        String snsAccessToken = getSnsAccessToken(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(snsAccessToken);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                        boolean invalidateSnsAccessToken = invalidateSnsAccessToken(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(invalidateSnsAccessToken);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                return true;
            }
        }

        static class Proxy implements IXiaomiAccountService {
            public static IXiaomiAccountService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.accountsdk.account.IXiaomiAccountService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getUserName(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserName(account);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getNickName(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNickName(account);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getEmail(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEmail(account);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getEncryptedUserId(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEncryptedUserId(account);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPhone(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPhone(account);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor getAvatarFd(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAvatarFd(account);
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public XiaomiAccount getXiaomiAccount(boolean z, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    obtain.writeInt(z ? 1 : 0);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getXiaomiAccount(z, account);
                    }
                    obtain2.readException();
                    XiaomiAccount createFromParcel = obtain2.readInt() != 0 ? XiaomiAccount.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor getAvatarFdByFileName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAvatarFdByFileName(str);
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccessToken(Account account, String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    int i = 1;
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAccessToken(account, str, str2, z);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSnsAccessToken(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSnsAccessToken(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean invalidateSnsAccessToken(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accountsdk.account.IXiaomiAccountService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().invalidateSnsAccessToken(str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IXiaomiAccountService iXiaomiAccountService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iXiaomiAccountService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iXiaomiAccountService;
                return true;
            }
        }

        public static IXiaomiAccountService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}

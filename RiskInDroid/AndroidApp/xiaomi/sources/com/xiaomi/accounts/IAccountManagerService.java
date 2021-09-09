package com.xiaomi.accounts;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.accounts.IAccountManagerResponse;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IAccountManagerService extends IInterface {
    boolean addAccount(Account account, String str, Bundle bundle) throws RemoteException;

    void addAcount(IAccountManagerResponse iAccountManagerResponse, String str, String str2, String[] strArr, boolean z, Bundle bundle) throws RemoteException;

    void clearPassword(Account account) throws RemoteException;

    void confirmCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, Bundle bundle, boolean z) throws RemoteException;

    void editProperties(IAccountManagerResponse iAccountManagerResponse, String str, boolean z) throws RemoteException;

    Account[] getAccounts(String str) throws RemoteException;

    void getAccountsByFeatures(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) throws RemoteException;

    void getAuthToken(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) throws RemoteException;

    void getAuthTokenLabel(IAccountManagerResponse iAccountManagerResponse, String str, String str2) throws RemoteException;

    String getPassword(Account account) throws RemoteException;

    String getUserData(Account account, String str) throws RemoteException;

    void hasFeatures(IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) throws RemoteException;

    void invalidateAuthToken(String str, String str2) throws RemoteException;

    String peekAuthToken(Account account, String str) throws RemoteException;

    void removeAccount(IAccountManagerResponse iAccountManagerResponse, Account account) throws RemoteException;

    void setAuthToken(Account account, String str, String str2) throws RemoteException;

    void setPassword(Account account, String str) throws RemoteException;

    void setUserData(Account account, String str, String str2) throws RemoteException;

    void updateAppPermission(Account account, String str, int i, boolean z) throws RemoteException;

    void updateCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IAccountManagerService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.accounts.IAccountManagerService");
        }

        public static IAccountManagerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.accounts.IAccountManagerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountManagerService)) {
                return new Proxy(iBinder);
            }
            return (IAccountManagerService) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v4, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v10, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r3v13, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v16, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v19, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v22, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v25, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v28, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v31, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v37 */
        /* JADX WARN: Type inference failed for: r3v40 */
        /* JADX WARN: Type inference failed for: r3v43, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r3v46 */
        /* JADX WARN: Type inference failed for: r3v47 */
        /* JADX WARN: Type inference failed for: r3v48 */
        /* JADX WARN: Type inference failed for: r3v49 */
        /* JADX WARN: Type inference failed for: r3v50 */
        /* JADX WARN: Type inference failed for: r3v51 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Type inference failed for: r3v53 */
        /* JADX WARN: Type inference failed for: r3v54 */
        /* JADX WARN: Type inference failed for: r3v55 */
        /* JADX WARN: Type inference failed for: r3v56 */
        /* JADX WARN: Type inference failed for: r3v57 */
        /* JADX WARN: Type inference failed for: r3v58 */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v60 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                ? r3 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        String password = getPassword(r3);
                        parcel2.writeNoException();
                        parcel2.writeString(password);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        String userData = getUserData(r3, parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(userData);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        Account[] accounts = getAccounts(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedArray(accounts, 1);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        hasFeatures(asInterface, r3, parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        getAccountsByFeatures(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        Account account = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean addAccount = addAccount(account, readString, r3);
                        parcel2.writeNoException();
                        parcel2.writeInt(addAccount);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface2 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        removeAccount(asInterface2, r3);
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        invalidateAuthToken(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        String peekAuthToken = peekAuthToken(r3, parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(peekAuthToken);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        setAuthToken(r3, parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        setPassword(r3, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        clearPassword(r3);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        setUserData(r3, parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        if (parcel.readInt() != 0) {
                            r3 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        String readString2 = parcel.readString();
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        updateAppPermission(r3, readString2, readInt, z);
                        parcel2.writeNoException();
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface3 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account2 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        String readString3 = parcel.readString();
                        boolean z2 = parcel.readInt() != 0;
                        boolean z3 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getAuthToken(asInterface3, account2, readString3, z2, z3, r3);
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface4 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        String readString4 = parcel.readString();
                        String readString5 = parcel.readString();
                        String[] createStringArray = parcel.createStringArray();
                        boolean z4 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        addAcount(asInterface4, readString4, readString5, createStringArray, z4, r3);
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface5 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account3 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        String readString6 = parcel.readString();
                        boolean z5 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        updateCredentials(asInterface5, account3, readString6, z5, r3);
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface6 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        String readString7 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        editProperties(asInterface6, readString7, z);
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        IAccountManagerResponse asInterface7 = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account4 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        confirmCredentials(asInterface7, account4, r3, z);
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountManagerService");
                        getAuthTokenLabel(IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.accounts.IAccountManagerService");
                return true;
            }
        }

        static class Proxy implements IAccountManagerService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.accounts.IAccountManagerService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getPassword(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getUserData(Account account, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Account[] getAccounts(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Account[]) obtain2.createTypedArray(Account.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void hasFeatures(IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAccountsByFeatures(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean addAccount(Account account, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    boolean z = true;
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeAccount(IAccountManagerResponse iAccountManagerResponse, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void invalidateAuthToken(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String peekAuthToken(Account account, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAuthToken(Account account, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPassword(Account account, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPassword(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserData(Account account, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateAppPermission(Account account, String str, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    int i2 = 1;
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAuthToken(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addAcount(IAccountManagerResponse iAccountManagerResponse, String str, String str2, String[] strArr, boolean z, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void editProperties(IAccountManagerResponse iAccountManagerResponse, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void confirmCredentials(IAccountManagerResponse iAccountManagerResponse, Account account, Bundle bundle, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    int i = 1;
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
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAuthTokenLabel(IAccountManagerResponse iAccountManagerResponse, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountManagerService");
                    obtain.writeStrongBinder(iAccountManagerResponse != null ? iAccountManagerResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

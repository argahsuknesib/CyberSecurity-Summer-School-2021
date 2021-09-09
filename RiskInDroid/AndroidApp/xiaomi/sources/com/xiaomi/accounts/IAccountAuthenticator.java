package com.xiaomi.accounts;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.accounts.IAccountAuthenticatorResponse;

public interface IAccountAuthenticator extends IInterface {
    void addAccount(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    void confirmCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, Bundle bundle) throws RemoteException;

    void editProperties(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException;

    void getAccountRemovalAllowed(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account) throws RemoteException;

    void getAuthToken(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException;

    void getAuthTokenLabel(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException;

    void hasFeatures(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String[] strArr) throws RemoteException;

    void updateCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IAccountAuthenticator {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.accounts.IAccountAuthenticator");
        }

        public static IAccountAuthenticator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.accounts.IAccountAuthenticator");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountAuthenticator)) {
                return new Proxy(iBinder);
            }
            return (IAccountAuthenticator) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v8, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v12, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r0v16, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r0v19, types: [android.accounts.Account] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ? r0 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        String[] createStringArray = parcel.createStringArray();
                        if (parcel.readInt() != 0) {
                            r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        addAccount(asInterface, readString, readString2, createStringArray, r0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface2 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        confirmCredentials(asInterface2, account, r0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface3 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account2 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getAuthToken(asInterface3, account2, readString3, r0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        getAuthTokenLabel(IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface4 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        Account account3 = parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null;
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            r0 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        updateCredentials(asInterface4, account3, readString4, r0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        editProperties(IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface5 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            r0 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        hasFeatures(asInterface5, r0, parcel.createStringArray());
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.accounts.IAccountAuthenticator");
                        IAccountAuthenticatorResponse asInterface6 = IAccountAuthenticatorResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            r0 = (Account) Account.CREATOR.createFromParcel(parcel);
                        }
                        getAccountRemovalAllowed(asInterface6, r0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.accounts.IAccountAuthenticator");
                return true;
            }
        }

        static class Proxy implements IAccountAuthenticator {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.accounts.IAccountAuthenticator";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void addAccount(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void confirmCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
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
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void getAuthToken(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
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
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void getAuthTokenLabel(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void updateCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
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
                    this.mRemote.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void editProperties(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void hasFeatures(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void getAccountRemovalAllowed(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.accounts.IAccountAuthenticator");
                    obtain.writeStrongBinder(iAccountAuthenticatorResponse != null ? iAccountAuthenticatorResponse.asBinder() : null);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}

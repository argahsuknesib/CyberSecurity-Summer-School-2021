package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends zzb implements IAccountAccessor {

        public static class Proxy extends zza implements IAccountAccessor {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public Account getAccount() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                Account account = (Account) zzc.zza(transactAndReadException, Account.CREATOR);
                transactAndReadException.recycle();
                return account;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        public static IAccountAccessor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            Account account = getAccount();
            parcel2.writeNoException();
            zzc.zzb(parcel2, account);
            return true;
        }
    }

    Account getAccount() throws RemoteException;
}

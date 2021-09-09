package com.xiaomi.accounts;

import _m_j.dtz;
import _m_j.dua;
import _m_j.eku;
import android.accounts.Account;
import android.accounts.AuthenticatorDescription;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.xiaomi.accounts.AccountAuthenticatorCache;
import com.xiaomi.accounts.IAccountAuthenticator;
import com.xiaomi.accounts.IAccountAuthenticatorResponse;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

public class AccountManagerService {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ExecutorService f5963O000000o = Executors.newCachedThreadPool();
    private static final Intent O0000OOo = new Intent("com.xiaomi.accounts.LOGIN_ACCOUNTS_CHANGED");
    private static final String[] O0000Oo = {"key", "value"};
    private static final String[] O0000Oo0 = {"type", "authtoken"};
    private static AtomicReference<AccountManagerService> O0000Ooo = new AtomicReference<>();
    private static final Account[] O0000o00 = new Account[0];
    public final Context O00000Oo;
    public final AccountAuthenticatorCache O00000o;
    public final O00000Oo O00000o0;
    public final LinkedHashMap<String, Session> O00000oO;
    private final PackageManager O00000oo;
    private HandlerThread O0000O0o;
    private final SparseArray<O00000o0> O0000OoO;

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f5966O000000o;
        public final O000000o O00000Oo;
        public final HashMap<String, Account[]> O00000o = new LinkedHashMap();
        public final Object O00000o0 = new Object();
        public HashMap<Account, HashMap<String, String>> O00000oO = new HashMap<>();
        public HashMap<Account, HashMap<String, String>> O00000oo = new HashMap<>();

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.accounts.AccountManagerService.O000000o(android.content.Context, int, boolean):java.io.File
         arg types: [android.content.Context, int, int]
         candidates:
          com.xiaomi.accounts.AccountManagerService.O000000o(net.sqlcipher.database.SQLiteDatabase, long, java.lang.String):long
          com.xiaomi.accounts.AccountManagerService.O000000o(com.xiaomi.accounts.AccountManagerService$O00000o0, android.accounts.Account, java.lang.String):void
          com.xiaomi.accounts.AccountManagerService.O000000o(com.xiaomi.accounts.IAccountManagerResponse, java.lang.String, java.lang.String[]):void
          com.xiaomi.accounts.AccountManagerService.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle):boolean
          com.xiaomi.accounts.AccountManagerService.O000000o(android.content.Context, int, boolean):java.io.File */
        O00000o0(Context context, int i) {
            this.f5966O000000o = i;
            synchronized (this.O00000o0) {
                File O000000o2 = AccountManagerService.O000000o(context, i, false);
                File O000000o3 = AccountManagerService.O000000o(context, i, true);
                String O000000o4 = new dua().O000000o(context);
                boolean O000000o5 = dtz.O000000o(context, O000000o2, O000000o3, O000000o4);
                String O00000Oo2 = AccountManagerService.O00000Oo(context, i, O000000o5);
                if (!O000000o5) {
                    O000000o4 = null;
                }
                this.O00000Oo = new O000000o(context, O00000Oo2, O000000o4);
                O000000o o000000o = this.O00000Oo;
                if (O000000o3.exists()) {
                    try {
                        o000000o.O000000o();
                    } catch (SQLiteException e) {
                        AccountLog.e("SQLCipherManager", "open database failed, maybe corrupted, keystore changed or wrong password");
                        o000000o.close();
                        if (!eku.O000000o(context)) {
                            AccountLog.d("SQLCipherManager", "delete old database file result: ".concat(String.valueOf(O000000o3.delete())));
                        } else {
                            AccountLog.e("SQLCipherManager", "you need take some works to fix it.");
                            throw e;
                        }
                    }
                }
            }
        }
    }

    public AccountManagerService(Context context) {
        this(context, context.getPackageManager(), new AccountAuthenticatorCache(context));
    }

    private AccountManagerService(Context context, PackageManager packageManager, AccountAuthenticatorCache accountAuthenticatorCache) {
        this.O00000oO = new LinkedHashMap<>();
        this.O0000OoO = new SparseArray<>();
        this.O00000Oo = context;
        this.O00000oo = packageManager;
        this.O0000O0o = new HandlerThread("AccountManagerService");
        this.O0000O0o.start();
        this.O00000o0 = new O00000Oo(this.O0000O0o.getLooper());
        this.O00000o = accountAuthenticatorCache;
        O0000Ooo.set(this);
        O00000Oo(0);
    }

    private O00000o0 O00000Oo(int i) {
        O00000o0 o00000o0;
        synchronized (this.O0000OoO) {
            Context context = this.O00000Oo;
            AccountLog.i("SQLCipherManager", "SQLiteDatabase.loadLibs()");
            SQLiteDatabase.loadLibs(context);
            o00000o0 = this.O0000OoO.get(i);
            if (o00000o0 == null) {
                o00000o0 = new O00000o0(this.O00000Oo, i);
                this.O0000OoO.append(i, o00000o0);
                synchronized (o00000o0.O00000o0) {
                    SQLiteDatabase O000000o2 = o00000o0.O00000Oo.O000000o();
                    Cursor query = O000000o2.query("grants", new String[]{"uid"}, null, null, "uid", null, null);
                    while (query.moveToNext()) {
                        try {
                            int i2 = query.getInt(0);
                            if (!(this.O00000oo.getPackagesForUid(i2) != null)) {
                                AccountLog.d("AccountManagerService", "deleting grants for UID " + i2 + " because its package is no longer installed");
                                O000000o2.delete("grants", "uid=?", new String[]{Integer.toString(i2)});
                            }
                        } finally {
                            query.close();
                        }
                    }
                }
                O000000o(o00000o0);
            }
        }
        return o00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fd A[Catch:{ all -> 0x00f4 }] */
    private void O000000o(O00000o0 o00000o0) {
        boolean z;
        synchronized (o00000o0.O00000o0) {
            SQLiteDatabase O000000o2 = o00000o0.O00000Oo.O000000o();
            Cursor query = O000000o2.query("accounts", new String[]{"_id", "type", "name"}, null, null, null, null, null);
            try {
                o00000o0.O00000o.clear();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                z = false;
                while (query.moveToNext()) {
                    try {
                        long j = query.getLong(0);
                        String string = query.getString(1);
                        String string2 = query.getString(2);
                        if (this.O00000o.O000000o(AuthenticatorDescription.newKey(string)) == null) {
                            AccountLog.d("AccountManagerService", "deleting account " + string2 + " because type " + string + " no longer has a registered authenticator");
                            O000000o2.delete("accounts", "_id=".concat(String.valueOf(j)), null);
                            try {
                                Account account = new Account(string2, string);
                                o00000o0.O00000oO.remove(account);
                                o00000o0.O00000oo.remove(account);
                                z = true;
                            } catch (Throwable th) {
                                th = th;
                                z = true;
                                query.close();
                                if (z) {
                                }
                                throw th;
                            }
                        } else {
                            ArrayList arrayList = (ArrayList) linkedHashMap.get(string);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                linkedHashMap.put(string, arrayList);
                            }
                            arrayList.add(string2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        query.close();
                        if (z) {
                            O00000Oo();
                        }
                        throw th;
                    }
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    ArrayList arrayList2 = (ArrayList) entry.getValue();
                    Account[] accountArr = new Account[arrayList2.size()];
                    Iterator it = arrayList2.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        accountArr[i] = new Account((String) it.next(), str);
                        i++;
                    }
                    o00000o0.O00000o.put(str, accountArr);
                }
                query.close();
                if (z) {
                    O00000Oo();
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                query.close();
                if (z) {
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public O00000o0 O000000o(int i) {
        O00000o0 o00000o0;
        synchronized (this.O0000OoO) {
            o00000o0 = this.O0000OoO.get(i);
            if (o00000o0 == null) {
                o00000o0 = O00000Oo(i);
                this.O0000OoO.append(i, o00000o0);
            }
        }
        return o00000o0;
    }

    public final String O000000o(Account account) {
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "getPassword: " + account + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (account != null) {
            return O000000o(O000000o(), account);
        }
        throw new IllegalArgumentException("account is null");
    }

    private static String O000000o(O00000o0 o00000o0, Account account) {
        if (account == null) {
            return null;
        }
        synchronized (o00000o0.O00000o0) {
            Cursor query = o00000o0.O00000Oo.O00000Oo().query("accounts", new String[]{"password"}, "name=? AND type=?", new String[]{account.name, account.type}, null, null, null);
            try {
                if (query.moveToNext()) {
                    String string = query.getString(0);
                    return string;
                }
                query.close();
                return null;
            } finally {
                query.close();
            }
        }
    }

    public final String O000000o(Account account, String str) {
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "getUserData: " + account + ", key " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            return O00000o0(O000000o(), account, str);
        } else {
            throw new IllegalArgumentException("key is null");
        }
    }

    public final boolean O000000o(Account account, String str, Bundle bundle) {
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "addAccount: " + account + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (account != null) {
            return O000000o(O000000o(), account, str, bundle);
        }
        throw new IllegalArgumentException("account is null");
    }

    private boolean O000000o(O00000o0 o00000o0, Account account, String str, Bundle bundle) {
        O00000o0 o00000o02 = o00000o0;
        Account account2 = account;
        Bundle bundle2 = bundle;
        if (account2 == null) {
            return false;
        }
        synchronized (o00000o02.O00000o0) {
            SQLiteDatabase O000000o2 = o00000o02.O00000Oo.O000000o();
            O000000o2.beginTransaction();
            try {
                if (DatabaseUtils.longForQuery(O000000o2, "select count(*) from accounts WHERE name=? AND type=?", new String[]{account2.name, account2.type}) > 0) {
                    AccountLog.w("AccountManagerService", "insertAccountIntoDatabase: " + account2 + ", skipping since the account already exists");
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", account2.name);
                contentValues.put("type", account2.type);
                contentValues.put("password", str);
                long insert = O000000o2.insert("accounts", "name", contentValues);
                if (insert < 0) {
                    AccountLog.w("AccountManagerService", "insertAccountIntoDatabase: " + account2 + ", skipping the DB insert failed");
                    O000000o2.endTransaction();
                    return false;
                }
                if (bundle2 != null) {
                    for (String next : bundle.keySet()) {
                        if (O000000o(O000000o2, insert, next, bundle2.getString(next)) < 0) {
                            AccountLog.w("AccountManagerService", "insertAccountIntoDatabase: " + account2 + ", skipping since insertExtra failed for key " + next);
                            O000000o2.endTransaction();
                            return false;
                        }
                    }
                }
                O000000o2.setTransactionSuccessful();
                Account[] accountArr = o00000o02.O00000o.get(account2.type);
                int length = accountArr != null ? accountArr.length : 0;
                Account[] accountArr2 = new Account[(length + 1)];
                if (accountArr != null) {
                    System.arraycopy(accountArr, 0, accountArr2, 0, length);
                }
                accountArr2[length] = account2;
                o00000o02.O00000o.put(account2.type, accountArr2);
                O000000o2.endTransaction();
                O00000Oo();
                return true;
            } finally {
                O000000o2.endTransaction();
            }
        }
    }

    public static long O000000o(SQLiteDatabase sQLiteDatabase, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("accounts_id", Long.valueOf(j));
        contentValues.put("value", str2);
        return sQLiteDatabase.insert("extras", "key", contentValues);
    }

    class TestFeaturesSession extends Session {
        private final Account mAccount;
        private final String[] mFeatures;

        public TestFeaturesSession(O00000o0 o00000o0, IAccountManagerResponse iAccountManagerResponse, Account account, String[] strArr) {
            super(o00000o0, iAccountManagerResponse, account.type, false, true);
            this.mFeatures = strArr;
            this.mAccount = account;
        }

        public void run() throws RemoteException {
            try {
                this.mAuthenticator.hasFeatures(this, this.mAccount, this.mFeatures);
            } catch (RemoteException unused) {
                onError(1, "remote exception");
            }
        }

        public void onResult(Bundle bundle) {
            IAccountManagerResponse responseAndClose = getResponseAndClose();
            if (responseAndClose == null) {
                return;
            }
            if (bundle == null) {
                try {
                    responseAndClose.onError(5, "null bundle");
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "failure while notifying response", e);
                    }
                }
            } else {
                if (Log.isLoggable("AccountManagerService", 2)) {
                    AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onResult() on response " + responseAndClose);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("booleanResult", bundle.getBoolean("booleanResult", false));
                responseAndClose.onResult(bundle2);
            }
        }

        /* access modifiers changed from: protected */
        public String toDebugString(long j) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toDebugString(j));
            sb.append(", hasFeatures, ");
            sb.append(this.mAccount);
            sb.append(", ");
            String[] strArr = this.mFeatures;
            sb.append(strArr != null ? TextUtils.join(",", strArr) : null);
            return sb.toString();
        }
    }

    class RemoveAccountSession extends Session {
        final Account mAccount;

        public RemoveAccountSession(O00000o0 o00000o0, IAccountManagerResponse iAccountManagerResponse, Account account) {
            super(o00000o0, iAccountManagerResponse, account.type, false, true);
            this.mAccount = account;
        }

        /* access modifiers changed from: protected */
        public String toDebugString(long j) {
            return super.toDebugString(j) + ", removeAccount, account " + this.mAccount;
        }

        public void run() throws RemoteException {
            this.mAuthenticator.getAccountRemovalAllowed(this, this.mAccount);
        }

        public void onResult(Bundle bundle) {
            if (bundle != null && bundle.containsKey("booleanResult") && !bundle.containsKey("intent")) {
                boolean z = bundle.getBoolean("booleanResult");
                if (z) {
                    AccountManagerService accountManagerService = AccountManagerService.this;
                    O00000o0 o00000o0 = this.mAccounts;
                    Account account = this.mAccount;
                    synchronized (o00000o0.O00000o0) {
                        o00000o0.O00000Oo.O000000o().delete("accounts", "name=? AND type=?", new String[]{account.name, account.type});
                        Account[] accountArr = o00000o0.O00000o.get(account.type);
                        if (accountArr != null) {
                            ArrayList arrayList = new ArrayList();
                            for (Account account2 : accountArr) {
                                if (!account2.equals(account)) {
                                    arrayList.add(account2);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                o00000o0.O00000o.remove(account.type);
                            } else {
                                o00000o0.O00000o.put(account.type, (Account[]) arrayList.toArray(new Account[arrayList.size()]));
                            }
                        }
                        o00000o0.O00000oO.remove(account);
                        o00000o0.O00000oo.remove(account);
                        accountManagerService.O00000Oo();
                    }
                }
                IAccountManagerResponse responseAndClose = getResponseAndClose();
                if (responseAndClose != null) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onResult() on response " + responseAndClose);
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("booleanResult", z);
                    try {
                        responseAndClose.onResult(bundle2);
                    } catch (RemoteException unused) {
                    }
                }
            }
            super.onResult(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(O00000o0 o00000o0, SQLiteDatabase sQLiteDatabase, String str, String str2) {
        if (str2 != null && str != null) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT authtokens._id, accounts.name, authtokens.type FROM accounts JOIN authtokens ON accounts._id = accounts_id WHERE authtoken = ? AND accounts.type = ?", new String[]{str2, str});
            while (rawQuery.moveToNext()) {
                try {
                    long j = rawQuery.getLong(0);
                    String string = rawQuery.getString(1);
                    String string2 = rawQuery.getString(2);
                    sQLiteDatabase.delete("authtokens", "_id=".concat(String.valueOf(j)), null);
                    O00000Oo(o00000o0, sQLiteDatabase, new Account(string, str), string2, null);
                } finally {
                    rawQuery.close();
                }
            }
        }
    }

    public final boolean O000000o(O00000o0 o00000o0, Account account, String str, String str2) {
        if (account == null || str == null) {
            return false;
        }
        synchronized (o00000o0.O00000o0) {
            SQLiteDatabase O000000o2 = o00000o0.O00000Oo.O000000o();
            O000000o2.beginTransaction();
            try {
                long O000000o3 = O000000o(O000000o2, account);
                if (O000000o3 < 0) {
                    return false;
                }
                O000000o2.delete("authtokens", "accounts_id=" + O000000o3 + " AND type=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("accounts_id", Long.valueOf(O000000o3));
                contentValues.put("type", str);
                contentValues.put("authtoken", str2);
                if (O000000o2.insert("authtokens", "authtoken", contentValues) >= 0) {
                    O000000o2.setTransactionSuccessful();
                    O00000Oo(o00000o0, O000000o2, account, str, str2);
                    O000000o2.endTransaction();
                    return true;
                }
                O000000o2.endTransaction();
                return false;
            } finally {
                O000000o2.endTransaction();
            }
        }
    }

    public final String O00000Oo(Account account, String str) {
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "peekAuthToken: " + account + ", authTokenType " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            return O00000Oo(O000000o(), account, str);
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    /* JADX INFO: finally extract failed */
    public final void O000000o(O00000o0 o00000o0, Account account, String str) {
        if (account != null) {
            synchronized (o00000o0.O00000o0) {
                SQLiteDatabase O000000o2 = o00000o0.O00000Oo.O000000o();
                O000000o2.beginTransaction();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("password", str);
                    long O000000o3 = O000000o(O000000o2, account);
                    if (O000000o3 >= 0) {
                        String[] strArr = {String.valueOf(O000000o3)};
                        O000000o2.update("accounts", contentValues, "_id=?", strArr);
                        O000000o2.delete("authtokens", "accounts_id=?", strArr);
                        o00000o0.O00000oo.remove(account);
                        O000000o2.setTransactionSuccessful();
                    }
                    O000000o2.endTransaction();
                    O00000Oo();
                } catch (Throwable th) {
                    O000000o2.endTransaction();
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        AccountLog.i("AccountManagerService", "the accounts changed, sending broadcast of " + O0000OOo.getAction());
        O0000OOo.setPackage(this.O00000Oo.getPackageName());
        this.O00000Oo.sendBroadcast(O0000OOo);
    }

    private void O000000o(IAccountManagerResponse iAccountManagerResponse, Bundle bundle) {
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onResult() on response " + iAccountManagerResponse);
        }
        try {
            iAccountManagerResponse.onResult(bundle);
        } catch (RemoteException e) {
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "failure while notifying response", e);
            }
        }
    }

    public final void O000000o(IAccountManagerResponse iAccountManagerResponse, Account account, String str, boolean z, boolean z2, Bundle bundle) {
        IAccountManagerResponse iAccountManagerResponse2 = iAccountManagerResponse;
        Account account2 = account;
        String str2 = str;
        boolean z3 = z;
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "getAuthToken: " + account2 + ", response " + iAccountManagerResponse + ", authTokenType " + str2 + ", notifyOnAuthFailure " + z3 + ", expectActivityLaunch " + z2 + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (iAccountManagerResponse2 == null) {
            throw new IllegalArgumentException("response is null");
        } else if (account2 == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str2 != null) {
            O00000o0 O000000o2 = O000000o();
            this.O00000o.O000000o(AuthenticatorDescription.newKey(account2.type));
            int callingUid = Binder.getCallingUid();
            final Bundle bundle2 = bundle == null ? new Bundle() : bundle;
            bundle2.putInt("callerUid", callingUid);
            bundle2.putInt("callerPid", Binder.getCallingPid());
            if (z3) {
                bundle2.putBoolean("notifyOnAuthFailure", true);
            }
            String O00000Oo2 = O00000Oo(O000000o2, account2, str2);
            if (O00000Oo2 != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("authtoken", O00000Oo2);
                bundle3.putString("authAccount", account2.name);
                bundle3.putString("accountType", account2.type);
                O000000o(iAccountManagerResponse, bundle3);
                return;
            }
            final Account account3 = account;
            final String str3 = str;
            final boolean z4 = z;
            new Session(O000000o2, iAccountManagerResponse, account2.type, z2, false) {
                /* class com.xiaomi.accounts.AccountManagerService.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public String toDebugString(long j) {
                    Bundle bundle = bundle2;
                    if (bundle != null) {
                        bundle.keySet();
                    }
                    return super.toDebugString(j) + ", getAuthToken, " + account3 + ", authTokenType " + str3 + ", loginOptions " + bundle2 + ", notifyOnAuthFailure " + z4;
                }

                public void run() throws RemoteException {
                    this.mAuthenticator.getAuthToken(this, account3, str3, bundle2);
                }

                public void onResult(Bundle bundle) {
                    String string;
                    if (!(bundle == null || (string = bundle.getString("authtoken")) == null)) {
                        String string2 = bundle.getString("authAccount");
                        String string3 = bundle.getString("accountType");
                        if (TextUtils.isEmpty(string3) || TextUtils.isEmpty(string2)) {
                            onError(5, "the type and name should not be empty");
                            return;
                        }
                        AccountManagerService.this.O000000o(this.mAccounts, new Account(string2, string3), str3, string);
                    }
                    super.onResult(bundle);
                }
            }.bind();
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    class GetAccountsByTypeAndFeatureSession extends Session {
        private volatile Account[] mAccountsOfType = null;
        private volatile ArrayList<Account> mAccountsWithFeatures = null;
        private volatile int mCurrentAccount = 0;
        private final String[] mFeatures;

        public GetAccountsByTypeAndFeatureSession(O00000o0 o00000o0, IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) {
            super(o00000o0, iAccountManagerResponse, str, false, true);
            this.mFeatures = strArr;
        }

        public void run() throws RemoteException {
            synchronized (this.mAccounts.O00000o0) {
                this.mAccountsOfType = AccountManagerService.this.O000000o(this.mAccounts, this.mAccountType);
            }
            this.mAccountsWithFeatures = new ArrayList<>(this.mAccountsOfType.length);
            this.mCurrentAccount = 0;
            checkAccount();
        }

        public void checkAccount() {
            if (this.mCurrentAccount >= this.mAccountsOfType.length) {
                sendResult();
                return;
            }
            IAccountAuthenticator iAccountAuthenticator = this.mAuthenticator;
            if (iAccountAuthenticator != null) {
                try {
                    iAccountAuthenticator.hasFeatures(this, this.mAccountsOfType[this.mCurrentAccount], this.mFeatures);
                } catch (RemoteException unused) {
                    onError(1, "remote exception");
                }
            } else if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "checkAccount: aborting session since we are no longer connected to the authenticator, " + toDebugString());
            }
        }

        public void onResult(Bundle bundle) {
            this.mNumResults++;
            if (bundle == null) {
                onError(5, "null bundle");
                return;
            }
            if (bundle.getBoolean("booleanResult", false)) {
                this.mAccountsWithFeatures.add(this.mAccountsOfType[this.mCurrentAccount]);
            }
            this.mCurrentAccount++;
            checkAccount();
        }

        public void sendResult() {
            IAccountManagerResponse responseAndClose = getResponseAndClose();
            if (responseAndClose != null) {
                try {
                    Account[] accountArr = new Account[this.mAccountsWithFeatures.size()];
                    for (int i = 0; i < accountArr.length; i++) {
                        accountArr[i] = this.mAccountsWithFeatures.get(i);
                    }
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onResult() on response " + responseAndClose);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArray("accounts", accountArr);
                    responseAndClose.onResult(bundle);
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "failure while notifying response", e);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public String toDebugString(long j) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toDebugString(j));
            sb.append(", getAccountsByTypeAndFeatures, ");
            String[] strArr = this.mFeatures;
            sb.append(strArr != null ? TextUtils.join(",", strArr) : null);
            return sb.toString();
        }
    }

    public final Account[] O000000o(String str) {
        Account[] O000000o2;
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "getAccounts: accountType " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        O00000o0 O000000o3 = O000000o();
        synchronized (O000000o3.O00000o0) {
            O000000o2 = O000000o(O000000o3, str);
        }
        return O000000o2;
    }

    public final void O000000o(IAccountManagerResponse iAccountManagerResponse, String str, String[] strArr) {
        Account[] O000000o2;
        if (Log.isLoggable("AccountManagerService", 2)) {
            AccountLog.v("AccountManagerService", "getAccounts: accountType " + str + ", response " + iAccountManagerResponse + ", features " + O000000o(strArr) + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
        }
        if (iAccountManagerResponse == null) {
            throw new IllegalArgumentException("response is null");
        } else if (str != null) {
            O00000o0 O000000o3 = O000000o();
            if (strArr != null) {
                if (strArr.length != 0) {
                    new GetAccountsByTypeAndFeatureSession(O000000o3, iAccountManagerResponse, str, strArr).bind();
                    return;
                }
            }
            synchronized (O000000o3.O00000o0) {
                O000000o2 = O000000o(O000000o3, str);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("accounts", O000000o2);
            O000000o(iAccountManagerResponse, bundle);
        } else {
            throw new IllegalArgumentException("accountType is null");
        }
    }

    public static long O000000o(SQLiteDatabase sQLiteDatabase, Account account) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("accounts", new String[]{"_id"}, "name=? AND type=?", new String[]{account.name, account.type}, null, null, null);
        try {
            if (query.moveToNext()) {
                return query.getLong(0);
            }
            query.close();
            return -1;
        } finally {
            query.close();
        }
    }

    public static long O000000o(SQLiteDatabase sQLiteDatabase, long j, String str) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("extras", new String[]{"_id"}, "accounts_id=" + j + " AND key=?", new String[]{str}, null, null, null);
        try {
            if (query.moveToNext()) {
                return query.getLong(0);
            }
            query.close();
            return -1;
        } finally {
            query.close();
        }
    }

    abstract class Session extends IAccountAuthenticatorResponse.Stub implements ServiceConnection, IBinder.DeathRecipient {
        final String mAccountType;
        protected final O00000o0 mAccounts;
        IAccountAuthenticator mAuthenticator = null;
        final long mCreationTime;
        final boolean mExpectActivityLaunch;
        private int mNumErrors = 0;
        private int mNumRequestContinued = 0;
        public int mNumResults = 0;
        IAccountManagerResponse mResponse;
        private final boolean mStripAuthTokenFromResult;

        public abstract void run() throws RemoteException;

        public Session(O00000o0 o00000o0, IAccountManagerResponse iAccountManagerResponse, String str, boolean z, boolean z2) {
            if (iAccountManagerResponse == null) {
                throw new IllegalArgumentException("response is null");
            } else if (str != null) {
                this.mAccounts = o00000o0;
                this.mStripAuthTokenFromResult = z2;
                this.mResponse = iAccountManagerResponse;
                this.mAccountType = str;
                this.mExpectActivityLaunch = z;
                this.mCreationTime = SystemClock.elapsedRealtime();
                synchronized (AccountManagerService.this.O00000oO) {
                    AccountManagerService.this.O00000oO.put(toString(), this);
                }
                try {
                    iAccountManagerResponse.asBinder().linkToDeath(this, 0);
                } catch (RemoteException unused) {
                    this.mResponse = null;
                    binderDied();
                }
            } else {
                throw new IllegalArgumentException("accountType is null");
            }
        }

        /* access modifiers changed from: package-private */
        public IAccountManagerResponse getResponseAndClose() {
            IAccountManagerResponse iAccountManagerResponse = this.mResponse;
            if (iAccountManagerResponse == null) {
                return null;
            }
            close();
            return iAccountManagerResponse;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r0.asBinder().unlinkToDeath(r3, 0);
            r3.mResponse = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            cancelTimeout();
            unbind();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
            r0 = r3.mResponse;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            if (r0 == null) goto L_0x0025;
         */
        private void close() {
            synchronized (AccountManagerService.this.O00000oO) {
                if (AccountManagerService.this.O00000oO.remove(toString()) == null) {
                }
            }
        }

        public void binderDied() {
            this.mResponse = null;
            close();
        }

        /* access modifiers changed from: protected */
        public String toDebugString() {
            return toDebugString(SystemClock.elapsedRealtime());
        }

        /* access modifiers changed from: protected */
        public String toDebugString(long j) {
            StringBuilder sb = new StringBuilder("Session: expectLaunch ");
            sb.append(this.mExpectActivityLaunch);
            sb.append(", connected ");
            sb.append(this.mAuthenticator != null);
            sb.append(", stats (");
            sb.append(this.mNumResults);
            sb.append("/");
            sb.append(this.mNumRequestContinued);
            sb.append("/");
            sb.append(this.mNumErrors);
            sb.append("), lifetime ");
            double d = (double) (j - this.mCreationTime);
            Double.isNaN(d);
            sb.append(d / 1000.0d);
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void bind() {
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "initiating bind to authenticator type " + this.mAccountType);
            }
            if (!bindToAuthenticator(this.mAccountType)) {
                AccountLog.d("AccountManagerService", "bind attempt failed for " + toDebugString());
                onError(1, "bind failure");
            }
        }

        private void unbind() {
            if (this.mAuthenticator != null) {
                this.mAuthenticator = null;
                AccountManagerService.this.O00000Oo.unbindService(this);
            }
        }

        public void scheduleTimeout() {
            AccountManagerService.this.O00000o0.sendMessageDelayed(AccountManagerService.this.O00000o0.obtainMessage(3, this), 60000);
        }

        public void cancelTimeout() {
            AccountManagerService.this.O00000o0.removeMessages(3, this);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.mAuthenticator = IAccountAuthenticator.Stub.asInterface(iBinder);
            AccountManagerService.f5963O000000o.execute(new Runnable() {
                /* class com.xiaomi.accounts.AccountManagerService.Session.AnonymousClass1 */

                public final void run() {
                    try {
                        Session.this.run();
                    } catch (RemoteException unused) {
                        Session.this.onError(1, "remote exception");
                    }
                }
            });
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.mAuthenticator = null;
            IAccountManagerResponse responseAndClose = getResponseAndClose();
            if (responseAndClose != null) {
                try {
                    responseAndClose.onError(1, "disconnected");
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "Session.onServiceDisconnected: caught RemoteException while responding", e);
                    }
                }
            }
        }

        public void onTimedOut() {
            IAccountManagerResponse responseAndClose = getResponseAndClose();
            if (responseAndClose != null) {
                try {
                    responseAndClose.onError(1, "timeout");
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "Session.onTimedOut: caught RemoteException while responding", e);
                    }
                }
            }
        }

        public void onResult(Bundle bundle) {
            IAccountManagerResponse iAccountManagerResponse;
            this.mNumResults++;
            if (!this.mExpectActivityLaunch || bundle == null || !bundle.containsKey("intent")) {
                iAccountManagerResponse = getResponseAndClose();
            } else {
                iAccountManagerResponse = this.mResponse;
            }
            if (iAccountManagerResponse == null) {
                return;
            }
            if (bundle == null) {
                try {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onError() on response " + iAccountManagerResponse);
                    }
                    iAccountManagerResponse.onError(5, "null bundle returned");
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "failure while notifying response", e);
                    }
                }
            } else {
                if (this.mStripAuthTokenFromResult) {
                    bundle.remove("authtoken");
                }
                if (Log.isLoggable("AccountManagerService", 2)) {
                    AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onResult() on response " + iAccountManagerResponse);
                }
                iAccountManagerResponse.onResult(bundle);
            }
        }

        public void onRequestContinued() {
            this.mNumRequestContinued++;
        }

        public void onError(int i, String str) {
            this.mNumErrors++;
            IAccountManagerResponse responseAndClose = getResponseAndClose();
            if (responseAndClose != null) {
                if (Log.isLoggable("AccountManagerService", 2)) {
                    AccountLog.v("AccountManagerService", getClass().getSimpleName() + " calling onError() on response " + responseAndClose);
                }
                try {
                    responseAndClose.onError(i, str);
                } catch (RemoteException e) {
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "Session.onError: caught RemoteException while responding", e);
                    }
                }
            } else if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "Session.onError: already closed");
            }
        }

        private boolean bindToAuthenticator(String str) {
            AccountAuthenticatorCache.O000000o<AuthenticatorDescription> O000000o2 = AccountManagerService.this.O00000o.O000000o(AuthenticatorDescription.newKey(str));
            if (O000000o2 == null) {
                if (Log.isLoggable("AccountManagerService", 2)) {
                    AccountLog.v("AccountManagerService", "there is no authenticator for " + str + ", bailing out");
                }
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.accounts.AccountAuthenticator");
            intent.setComponent(O000000o2.O00000Oo);
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "performing bindService to " + O000000o2.O00000Oo);
            }
            if (AccountManagerService.this.O00000Oo.bindService(intent, this, 1)) {
                return true;
            }
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "bindService to " + O000000o2.O00000Oo + " failed");
            }
            return false;
        }
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                ((Session) message.obj).onTimedOut();
                return;
            }
            throw new IllegalStateException("unhandled message: " + message.what);
        }
    }

    public static File O000000o(Context context, int i, boolean z) {
        File file = new File(context.getFilesDir(), "users/".concat(String.valueOf(i)));
        file.mkdirs();
        return new File(file, z ? "sec_accounts.db" : "accounts.db");
    }

    public static String O00000Oo(Context context, int i, boolean z) {
        return O000000o(context, i, z).getPath();
    }

    public static class O000000o extends SQLiteOpenHelper {

        /* renamed from: O000000o  reason: collision with root package name */
        private final String f5964O000000o;

        public O000000o(Context context, String str, String str2) {
            super(context, str, null, 4);
            this.f5964O000000o = str2;
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE accounts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, password TEXT, UNIQUE(name,type))");
            sQLiteDatabase.execSQL("CREATE TABLE authtokens (  _id INTEGER PRIMARY KEY AUTOINCREMENT,  accounts_id INTEGER NOT NULL, type TEXT NOT NULL,  authtoken TEXT,  UNIQUE (accounts_id,type))");
            sQLiteDatabase.execSQL("CREATE TABLE grants (  accounts_id INTEGER NOT NULL, auth_token_type STRING NOT NULL,  uid INTEGER NOT NULL,  UNIQUE (accounts_id,auth_token_type,uid))");
            sQLiteDatabase.execSQL("CREATE TABLE extras ( _id INTEGER PRIMARY KEY AUTOINCREMENT, accounts_id INTEGER, key TEXT NOT NULL, value TEXT, UNIQUE(accounts_id,key))");
            sQLiteDatabase.execSQL("CREATE TABLE meta ( key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            sQLiteDatabase.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM authtokens     WHERE accounts_id=OLD._id ;   DELETE FROM extras     WHERE accounts_id=OLD._id ;   DELETE FROM grants     WHERE accounts_id=OLD._id ; END");
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            AccountLog.e("AccountManagerService", "upgrade from version " + i + " to version " + i2);
            if (i == 1) {
                i++;
            }
            if (i == 2) {
                sQLiteDatabase.execSQL("CREATE TABLE grants (  accounts_id INTEGER NOT NULL, auth_token_type STRING NOT NULL,  uid INTEGER NOT NULL,  UNIQUE (accounts_id,auth_token_type,uid))");
                sQLiteDatabase.execSQL("DROP TRIGGER accountsDelete");
                sQLiteDatabase.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM authtokens     WHERE accounts_id=OLD._id ;   DELETE FROM extras     WHERE accounts_id=OLD._id ;   DELETE FROM grants     WHERE accounts_id=OLD._id ; END");
                i++;
            }
            if (i == 3) {
                sQLiteDatabase.execSQL("UPDATE accounts SET type = 'com.google' WHERE type == 'com.google.GAIA'");
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "opened database " + getDatabaseName());
            }
        }

        public final SQLiteDatabase O000000o() {
            return getWritableDatabase(this.f5964O000000o);
        }

        /* access modifiers changed from: package-private */
        public final SQLiteDatabase O00000Oo() {
            return getReadableDatabase(this.f5964O000000o);
        }
    }

    static final String O000000o(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return "[" + TextUtils.join(",", strArr) + "]";
    }

    /* access modifiers changed from: protected */
    public final Account[] O000000o(O00000o0 o00000o0, String str) {
        O000000o(o00000o0);
        if (str != null) {
            Account[] accountArr = o00000o0.O00000o.get(str);
            if (accountArr == null) {
                return O0000o00;
            }
            return (Account[]) Arrays.copyOf(accountArr, accountArr.length);
        }
        int i = 0;
        for (Account[] length : o00000o0.O00000o.values()) {
            i += length.length;
        }
        if (i == 0) {
            return O0000o00;
        }
        Account[] accountArr2 = new Account[i];
        int i2 = 0;
        for (Account[] next : o00000o0.O00000o.values()) {
            System.arraycopy(next, 0, accountArr2, i2, next.length);
            i2 += next.length;
        }
        return accountArr2;
    }

    public static void O000000o(O00000o0 o00000o0, SQLiteDatabase sQLiteDatabase, Account account, String str, String str2) {
        HashMap<String, String> hashMap = o00000o0.O00000oO.get(account);
        if (hashMap == null) {
            hashMap = O00000Oo(sQLiteDatabase, account);
            o00000o0.O00000oO.put(account, hashMap);
        }
        if (str2 == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, str2);
        }
    }

    private static void O00000Oo(O00000o0 o00000o0, SQLiteDatabase sQLiteDatabase, Account account, String str, String str2) {
        HashMap<String, String> hashMap = o00000o0.O00000oo.get(account);
        if (hashMap == null) {
            hashMap = O00000o0(sQLiteDatabase, account);
            o00000o0.O00000oo.put(account, hashMap);
        }
        if (str2 == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, str2);
        }
    }

    private static String O00000Oo(O00000o0 o00000o0, Account account, String str) {
        String str2;
        synchronized (o00000o0.O00000o0) {
            HashMap<String, String> hashMap = o00000o0.O00000oo.get(account);
            if (hashMap == null) {
                hashMap = O00000o0(o00000o0.O00000Oo.O00000Oo(), account);
                o00000o0.O00000oo.put(account, hashMap);
            }
            str2 = hashMap.get(str);
        }
        return str2;
    }

    private static String O00000o0(O00000o0 o00000o0, Account account, String str) {
        String str2;
        synchronized (o00000o0.O00000o0) {
            HashMap<String, String> hashMap = o00000o0.O00000oO.get(account);
            if (hashMap == null || TextUtils.isEmpty(hashMap.get(str))) {
                hashMap = O00000Oo(o00000o0.O00000Oo.O00000Oo(), account);
                o00000o0.O00000oO.put(account, hashMap);
            }
            str2 = hashMap.get(str);
        }
        return str2;
    }

    private static HashMap<String, String> O00000Oo(SQLiteDatabase sQLiteDatabase, Account account) {
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor query = sQLiteDatabase.query("extras", O0000Oo, "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)", new String[]{account.name, account.type}, null, null, null);
        while (query.moveToNext()) {
            try {
                hashMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    private static HashMap<String, String> O00000o0(SQLiteDatabase sQLiteDatabase, Account account) {
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor query = sQLiteDatabase.query("authtokens", O0000Oo0, "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)", new String[]{account.name, account.type}, null, null, null);
        while (query.moveToNext()) {
            try {
                hashMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    public final O00000o0 O000000o() {
        return O000000o(Binder.getCallingUid() / 100000);
    }
}

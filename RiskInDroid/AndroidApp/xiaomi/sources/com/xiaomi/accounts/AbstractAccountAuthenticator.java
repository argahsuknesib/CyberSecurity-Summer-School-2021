package com.xiaomi.accounts;

import android.accounts.Account;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.accounts.IAccountAuthenticator;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.util.Arrays;

public abstract class AbstractAccountAuthenticator {

    /* renamed from: O000000o  reason: collision with root package name */
    public Transport f5952O000000o = new Transport();
    private final Context O00000Oo;

    public abstract Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException;

    public abstract Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException;

    public abstract Bundle O000000o(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, Bundle bundle) throws NetworkErrorException;

    public abstract Bundle O00000Oo() throws NetworkErrorException;

    public AbstractAccountAuthenticator(Context context) {
        this.O00000Oo = context;
    }

    public class Transport extends IAccountAuthenticator.Stub {
        private Transport() {
        }

        public void addAccount(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException {
            String str3;
            if (Log.isLoggable("AccountAuthenticator", 2)) {
                StringBuilder sb = new StringBuilder("addAccount: accountType ");
                sb.append(str);
                sb.append(", authTokenType ");
                sb.append(str2);
                sb.append(", features ");
                if (strArr == null) {
                    str3 = "[]";
                } else {
                    str3 = Arrays.toString(strArr);
                }
                sb.append(str3);
                AccountLog.v("AccountAuthenticator", sb.toString());
            }
            AbstractAccountAuthenticator.this.O000000o();
            try {
                Bundle O000000o2 = AbstractAccountAuthenticator.this.O000000o(new AccountAuthenticatorResponse(iAccountAuthenticatorResponse), str2, bundle);
                if (Log.isLoggable("AccountAuthenticator", 2)) {
                    O000000o2.keySet();
                    AccountLog.v("AccountAuthenticator", "addAccount: result " + AccountManager.O000000o(O000000o2));
                }
                iAccountAuthenticatorResponse.onResult(O000000o2);
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "addAccount", str, e);
            }
        }

        public void confirmCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, Bundle bundle) throws RemoteException {
            if (Log.isLoggable("AccountAuthenticator", 2)) {
                AccountLog.v("AccountAuthenticator", "confirmCredentials: ".concat(String.valueOf(account)));
            }
            AbstractAccountAuthenticator.this.O000000o();
            try {
                Bundle O000000o2 = AbstractAccountAuthenticator.this.O000000o(new AccountAuthenticatorResponse(iAccountAuthenticatorResponse), account, bundle);
                if (Log.isLoggable("AccountAuthenticator", 2)) {
                    O000000o2.keySet();
                    AccountLog.v("AccountAuthenticator", "confirmCredentials: result " + AccountManager.O000000o(O000000o2));
                }
                iAccountAuthenticatorResponse.onResult(O000000o2);
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "confirmCredentials", account.toString(), e);
            }
        }

        public void getAuthTokenLabel(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException {
            if (Log.isLoggable("AccountAuthenticator", 2)) {
                AccountLog.v("AccountAuthenticator", "getAuthTokenLabel: authTokenType ".concat(String.valueOf(str)));
            }
            AbstractAccountAuthenticator.this.O000000o();
            try {
                Bundle bundle = new Bundle();
                bundle.putString("authTokenLabelKey", null);
                if (Log.isLoggable("AccountAuthenticator", 2)) {
                    bundle.keySet();
                    AccountLog.v("AccountAuthenticator", "getAuthTokenLabel: result " + AccountManager.O000000o(bundle));
                }
                iAccountAuthenticatorResponse.onResult(bundle);
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "getAuthTokenLabel", str, e);
            }
        }

        public void getAuthToken(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException {
            if (Log.isLoggable("AccountAuthenticator", 2)) {
                AccountLog.v("AccountAuthenticator", "getAuthToken: " + account + ", authTokenType " + str);
            }
            AbstractAccountAuthenticator.this.O000000o();
            try {
                Bundle O000000o2 = AbstractAccountAuthenticator.this.O000000o(new AccountAuthenticatorResponse(iAccountAuthenticatorResponse), account, str, bundle);
                if (Log.isLoggable("AccountAuthenticator", 2)) {
                    O000000o2.keySet();
                    AccountLog.v("AccountAuthenticator", "getAuthToken: result " + AccountManager.O000000o(O000000o2));
                }
                if (O000000o2 != null) {
                    iAccountAuthenticatorResponse.onResult(O000000o2);
                }
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "getAuthToken", account.toString() + "," + str, e);
            }
        }

        public void updateCredentials(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String str, Bundle bundle) throws RemoteException {
            if (Log.isLoggable("AccountAuthenticator", 2)) {
                AccountLog.v("AccountAuthenticator", "updateCredentials: " + account + ", authTokenType " + str);
            }
            AbstractAccountAuthenticator.this.O000000o();
            try {
                AbstractAccountAuthenticator abstractAccountAuthenticator = AbstractAccountAuthenticator.this;
                new AccountAuthenticatorResponse(iAccountAuthenticatorResponse);
                Bundle O00000Oo = abstractAccountAuthenticator.O00000Oo();
                if (Log.isLoggable("AccountAuthenticator", 2)) {
                    O00000Oo.keySet();
                    AccountLog.v("AccountAuthenticator", "updateCredentials: result " + AccountManager.O000000o(O00000Oo));
                }
                if (O00000Oo != null) {
                    iAccountAuthenticatorResponse.onResult(O00000Oo);
                }
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "updateCredentials", account.toString() + "," + str, e);
            }
        }

        public void editProperties(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str) throws RemoteException {
            AbstractAccountAuthenticator.this.O000000o();
            try {
                new AccountAuthenticatorResponse(iAccountAuthenticatorResponse);
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "editProperties", str, e);
            }
        }

        public void hasFeatures(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account, String[] strArr) throws RemoteException {
            AbstractAccountAuthenticator.this.O000000o();
            try {
                new AccountAuthenticatorResponse(iAccountAuthenticatorResponse);
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "hasFeatures", account.toString(), e);
            }
        }

        public void getAccountRemovalAllowed(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, Account account) throws RemoteException {
            AbstractAccountAuthenticator.this.O000000o();
            try {
                AbstractAccountAuthenticator abstractAccountAuthenticator = AbstractAccountAuthenticator.this;
                new AccountAuthenticatorResponse(iAccountAuthenticatorResponse);
                iAccountAuthenticatorResponse.onResult(abstractAccountAuthenticator.O00000o0());
            } catch (Exception e) {
                AbstractAccountAuthenticator.O000000o(iAccountAuthenticatorResponse, "getAccountRemovalAllowed", account.toString(), e);
            }
        }
    }

    public static void O000000o(IAccountAuthenticatorResponse iAccountAuthenticatorResponse, String str, String str2, Exception exc) throws RemoteException {
        if (exc instanceof NetworkErrorException) {
            AccountLog.w("AccountAuthenticator", str + "(" + str2 + ")", exc);
            iAccountAuthenticatorResponse.onError(3, exc.getMessage());
        } else if (exc instanceof UnsupportedOperationException) {
            AccountLog.w("AccountAuthenticator", str + "(" + str2 + ")", exc);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not supported");
            iAccountAuthenticatorResponse.onError(6, sb.toString());
        } else if (exc instanceof IllegalArgumentException) {
            AccountLog.w("AccountAuthenticator", str + "(" + str2 + ")", exc);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" not supported");
            iAccountAuthenticatorResponse.onError(7, sb2.toString());
        } else {
            AccountLog.w("AccountAuthenticator", str + "(" + str2 + ")", exc);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(" failed");
            iAccountAuthenticatorResponse.onError(1, sb3.toString());
        }
    }

    public final void O000000o() {
        int callingUid = Binder.getCallingUid();
        if (this.O00000Oo.getApplicationInfo().uid != callingUid && this.O00000Oo.checkCallingOrSelfPermission("android.permission.ACCOUNT_MANAGER") != 0) {
            throw new SecurityException("caller uid " + callingUid + " lacks android.permission.ACCOUNT_MANAGER");
        }
    }

    public Bundle O00000o0() throws NetworkErrorException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", true);
        return bundle;
    }
}

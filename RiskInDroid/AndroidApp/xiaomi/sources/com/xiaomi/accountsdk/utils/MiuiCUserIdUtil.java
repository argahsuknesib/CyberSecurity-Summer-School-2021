package com.xiaomi.accountsdk.utils;

import _m_j.efh;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.xiaomi.accountsdk.account.IXiaomiAccountService;
import com.xiaomi.accountsdk.futureservice.ServerServiceConnector;
import com.xiaomi.accountsdk.futureservice.SimpleClientFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.util.concurrent.ExecutionException;

public final class MiuiCUserIdUtil {
    public final Account mAccount;
    private final Context mContext;

    public MiuiCUserIdUtil(Context context, Account account) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mAccount = account;
            return;
        }
        throw new IllegalArgumentException("context == null");
    }

    public final String getCUserId() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                return getFromXiaomiAccountService();
            } catch (SecurityException unused) {
                return getFromServiceTokenUtil();
            }
        } else {
            throw new IllegalStateException("MiuiCUserIdUtil#getCUserId() should NOT be called on main thread!");
        }
    }

    private String getFromServiceTokenUtil() {
        efh.O000000o();
        ServiceTokenResult serviceTokenResult = efh.O00000Oo().O00000Oo(this.mContext, "passportapi").get();
        if (serviceTokenResult != null) {
            return serviceTokenResult.O0000Oo;
        }
        return null;
    }

    private String getFromXiaomiAccountService() {
        String str = "com.xiaomi.account.action.BIND_XIAOMI_ACCOUNT_SERVICE";
        if (this.mContext.getPackageManager().resolveService(new Intent(str), 0) == null) {
            str = "android.intent.action.BIND_XIAOMI_ACCOUNT_SERVICE";
        }
        SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
        new ServerServiceConnector<IXiaomiAccountService, String, String>(this.mContext, str, "com.xiaomi.account", simpleClientFuture) {
            /* class com.xiaomi.accountsdk.utils.MiuiCUserIdUtil.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public String callServiceWork() throws RemoteException {
                return ((IXiaomiAccountService) getIService()).getEncryptedUserId(MiuiCUserIdUtil.this.mAccount);
            }

            /* access modifiers changed from: protected */
            public IXiaomiAccountService binderToServiceType(IBinder iBinder) {
                return IXiaomiAccountService.Stub.asInterface(iBinder);
            }
        }.bind();
        try {
            return (String) simpleClientFuture.get();
        } catch (InterruptedException e) {
            AccountLog.e("MiuiCUserIdUtil", "getCUserId", e);
            return null;
        } catch (ExecutionException e2) {
            AccountLog.e("MiuiCUserIdUtil", "getCUserId", e2);
            return null;
        }
    }
}

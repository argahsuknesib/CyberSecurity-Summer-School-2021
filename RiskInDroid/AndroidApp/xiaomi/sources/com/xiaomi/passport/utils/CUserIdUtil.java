package com.xiaomi.passport.utils;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.MiuiCUserIdUtil;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public class CUserIdUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f6347O000000o;

    public CUserIdUtil(Context context) {
        if (context != null) {
            this.f6347O000000o = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context == null");
    }

    public final String O000000o() {
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            MiAccountManager O00000Oo = MiAccountManager.O00000Oo(this.f6347O000000o);
            Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
            if (O000000o2.length == 0) {
                return null;
            }
            try {
                return O00000Oo.O000000o(O000000o2[0], "encrypted_user_id");
            } catch (SecurityException unused) {
                AccountLog.d("CUserIdUtil", "failed to getUserData");
                if (O00000Oo.O00000Oo()) {
                    return new MiuiCUserIdUtil(this.f6347O000000o, O000000o2[0]).getCUserId();
                }
                throw new IllegalStateException("not supposed to be here");
            }
        } else {
            throw new IllegalStateException("CUserIdUtil#getCUserId() should NOT be called on main thread!");
        }
    }
}

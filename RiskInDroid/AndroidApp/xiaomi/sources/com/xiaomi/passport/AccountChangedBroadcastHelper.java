package com.xiaomi.passport;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public final class AccountChangedBroadcastHelper {

    public enum UpdateType {
        PRE_ADD,
        POST_ADD,
        POST_REFRESH,
        PRE_REMOVE,
        POST_REMOVE
    }

    private static String O000000o(Context context) {
        return MiAccountManager.O00000Oo(context).O00000Oo() ? "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED" : "com.xiaomi.accounts.LOGIN_ACCOUNTS_PRE_CHANGED";
    }

    private static String O00000Oo(Context context) {
        return MiAccountManager.O00000Oo(context).O00000Oo() ? "android.accounts.LOGIN_ACCOUNTS_POST_CHANGED" : "com.xiaomi.accounts.LOGIN_ACCOUNTS_POST_CHANGED";
    }

    /* renamed from: com.xiaomi.passport.AccountChangedBroadcastHelper$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6181O000000o = new int[UpdateType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f6181O000000o[UpdateType.PRE_ADD.ordinal()] = 1;
            f6181O000000o[UpdateType.POST_ADD.ordinal()] = 2;
            f6181O000000o[UpdateType.POST_REFRESH.ordinal()] = 3;
            f6181O000000o[UpdateType.PRE_REMOVE.ordinal()] = 4;
            f6181O000000o[UpdateType.POST_REMOVE.ordinal()] = 5;
        }
    }

    public static void O000000o(Context context, Account account, UpdateType updateType) {
        String str;
        if (context == null || updateType == null) {
            throw new IllegalArgumentException();
        }
        int i = AnonymousClass1.f6181O000000o[updateType.ordinal()];
        int i2 = 2;
        if (i == 1) {
            str = O000000o(context);
        } else if (i == 2) {
            str = O00000Oo(context);
        } else if (i != 3) {
            if (i == 4) {
                str = O000000o(context);
            } else if (i == 5) {
                str = O00000Oo(context);
            } else {
                throw new IllegalStateException("this should not be happen");
            }
            i2 = 1;
        } else {
            str = O00000Oo(context);
            i2 = 3;
        }
        Intent intent = new Intent(str);
        intent.putExtra("extra_account", account);
        intent.putExtra("extra_update_type", i2);
        if (!MiAccountManager.O00000Oo(context).O00000Oo()) {
            intent.setPackage(context.getPackageName());
        }
        context.sendBroadcast(intent);
    }
}

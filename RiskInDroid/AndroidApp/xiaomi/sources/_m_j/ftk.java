package _m_j;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class ftk {
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023 A[RETURN] */
    public static boolean O000000o() {
        String str;
        AccountManager accountManager = AccountManager.get(ServiceApplication.getAppContext());
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType("com.xiaomi");
            if (accountsByType.length > 0) {
                str = accountsByType[0].name;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                return false;
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
        }
    }

    public static String O00000Oo() {
        AccountManager accountManager = AccountManager.get(ServiceApplication.getAppContext());
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType("com.xiaomi");
            if (accountsByType.length > 0) {
                return accountsByType[0].name;
            }
        }
        return "";
    }
}

package com.xiaomi.passport.utils;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.accountsdk.utils.SharedPreferencesUtil;
import java.util.concurrent.TimeUnit;

public class AMPassTokenUpdateUtil {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final long f6346O000000o = TimeUnit.DAYS.toMillis(1);
    private final SharedPreferencesUtil O00000Oo;

    public AMPassTokenUpdateUtil(Context context) {
        this.O00000Oo = new SharedPreferencesUtil(context, "passport_passtoken_update_util");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    public final boolean O000000o(String str, AccountInfo accountInfo) {
        boolean z;
        if (accountInfo == null) {
            return false;
        }
        String rePassToken = accountInfo.getRePassToken();
        if (TextUtils.isEmpty(rePassToken)) {
            return false;
        }
        synchronized (AMPassTokenUpdateUtil.class) {
            String md5DigestUpperCase = CloudCoder.getMd5DigestUpperCase(str);
            String passToken = accountInfo.getPassToken();
            String upperCase = rePassToken.toUpperCase();
            if (!TextUtils.equals(passToken, str) && TextUtils.equals(upperCase, md5DigestUpperCase)) {
                if (O000000o() == System.currentTimeMillis() / f6346O000000o) {
                    if (O00000Oo() >= 100) {
                        z = false;
                        if (z) {
                            if (O000000o() == System.currentTimeMillis() / f6346O000000o) {
                                O000000o(O00000Oo() + 1);
                            } else {
                                this.O00000Oo.saveLong("date", System.currentTimeMillis() / f6346O000000o);
                                O000000o(1);
                            }
                            AccountLog.d("AMPassTokenUpdateUtil", "need to update password in AM");
                            return true;
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
        }
    }

    private long O000000o() {
        return this.O00000Oo.getLong("date", 0);
    }

    private int O00000Oo() {
        return this.O00000Oo.getInt("frequency", 0);
    }

    private void O000000o(int i) {
        this.O00000Oo.saveInt("frequency", i);
    }
}

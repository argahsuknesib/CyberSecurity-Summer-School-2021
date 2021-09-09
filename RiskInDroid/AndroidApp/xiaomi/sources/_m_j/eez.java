package _m_j;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.utils.CUserIdUtil;

public final class eez extends PassportInfo {
    private eez(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
    }

    public static eez O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "passportapi";
        }
        String str2 = str;
        Context applicationContext = context.getApplicationContext();
        MiAccountManager O00000Oo = MiAccountManager.O00000Oo(applicationContext);
        Account O00000oo = O00000Oo.O00000oo();
        if (O00000oo == null) {
            AccountLog.i("XMPassportInfo", "no xiaomi account");
            return null;
        }
        ServiceTokenResult serviceTokenResult = O00000Oo.O000000o(applicationContext, str2).get();
        if (serviceTokenResult == null) {
            AccountLog.e("XMPassportInfo", "service token result is null");
            return null;
        } else if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_NONE) {
            AccountLog.e("XMPassportInfo", "service token result error code = " + serviceTokenResult.O00000o + " error msg: " + serviceTokenResult.O00000oO);
            return null;
        } else {
            String str3 = serviceTokenResult.O0000Oo;
            return new eez(O00000oo.name, TextUtils.isEmpty(str3) ? new CUserIdUtil(applicationContext).O000000o() : str3, str2, serviceTokenResult.O00000Oo, serviceTokenResult.O00000o0);
        }
    }

    public final void O000000o(Context context) {
        Context applicationContext = context.getApplicationContext();
        MiAccountManager O00000Oo = MiAccountManager.O00000Oo(applicationContext);
        if (O00000Oo.O00000oo() == null) {
            AccountLog.i("XMPassportInfo", "no xiaomi account");
            return;
        }
        O00000Oo.O000000o(context, new ServiceTokenResult.O000000o(getServiceId()).O000000o(getServiceToken()).O00000Oo(getSecurity()).O000000o()).get();
        ServiceTokenResult serviceTokenResult = O00000Oo.O000000o(applicationContext, getServiceId()).get();
        if (serviceTokenResult == null) {
            AccountLog.e("XMPassportInfo", "service token result is null");
        } else if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_NONE) {
            AccountLog.e("XMPassportInfo", "service token result error code = " + serviceTokenResult.O00000o);
        } else {
            setServiceToken(serviceTokenResult.O00000Oo);
            setSecurity(serviceTokenResult.O00000o0);
        }
    }
}

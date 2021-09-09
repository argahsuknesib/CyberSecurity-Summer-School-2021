package _m_j;

import android.accounts.Account;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.accountsdk.utils.Coder;
import com.xiaomi.passport.servicetoken.AMAuthTokenConverter;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import java.io.IOException;

public final class efg extends efi {
    private final efd O00000Oo;

    public final boolean O00000Oo(Context context) {
        return true;
    }

    public final /* bridge */ /* synthetic */ MiAccountManagerFuture O00000o0(Context context) {
        return super.O00000o0(context);
    }

    public efg(efd efd) {
        if (efd != null) {
            this.O00000Oo = efd;
            return;
        }
        throw new IllegalArgumentException("amUtil == null");
    }

    /* access modifiers changed from: protected */
    public final ServiceTokenResult O00000Oo(Context context, ServiceTokenResult serviceTokenResult) {
        if (this.O00000Oo.O000000o(context) == null) {
            return O000000o(serviceTokenResult.f6200O000000o);
        }
        this.O00000Oo.O000000o(context, AMAuthTokenConverter.O00000o0(serviceTokenResult));
        return new ServiceTokenResult.O000000o(serviceTokenResult.f6200O000000o).O000000o();
    }

    public final ServiceTokenResult O000000o(Context context, String str) {
        ServiceTokenResult.ErrorCode errorCode;
        Account O000000o2 = this.O00000Oo.O000000o(context);
        if (O000000o2 == null) {
            return O000000o(str);
        }
        String O000000o3 = this.O00000Oo.O000000o(context, str, O000000o2);
        if (!TextUtils.isEmpty(O000000o3)) {
            return O000000o(context, O000000o2, AMAuthTokenConverter.O000000o(str, O000000o3, true));
        }
        try {
            return O000000o(context, O000000o2, AMAuthTokenConverter.O000000o(this.O00000Oo.O000000o(context, str, O000000o2, null).getResult(), str));
        } catch (Exception e) {
            if (e instanceof OperationCanceledException) {
                errorCode = ServiceTokenResult.ErrorCode.ERROR_CANCELLED;
            } else if (e instanceof IOException) {
                errorCode = ServiceTokenResult.ErrorCode.ERROR_IOERROR;
            } else if (e instanceof AuthenticatorException) {
                errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
            } else if (e instanceof SecurityException) {
                errorCode = ServiceTokenResult.ErrorCode.ERROR_OLD_MIUI_ACCOUNT_MANAGER_PERMISSION_ISSUE;
            } else {
                errorCode = ServiceTokenResult.ErrorCode.ERROR_UNKNOWN;
            }
            ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(str);
            o000000o.O00000oo = errorCode;
            o000000o.O00000o = "error#" + e.getMessage();
            o000000o.O00000oO = Log.getStackTraceString(e);
            return o000000o.O000000o();
        }
    }

    public final ServiceTokenResult O00000o0(Context context, String str) {
        return O000000o(context, str);
    }

    /* access modifiers changed from: protected */
    public final XmAccountVisibility O000000o(Context context) {
        Account O000000o2 = this.O00000Oo.O000000o(context);
        if (O000000o2 == null) {
            return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_NO_ACCOUNT, null).O000000o();
        }
        return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_NONE, null).O000000o(O000000o2).O000000o();
    }

    private static ServiceTokenResult O000000o(String str) {
        ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(str);
        o000000o.O00000oo = ServiceTokenResult.ErrorCode.ERROR_NO_ACCOUNT;
        return o000000o.O000000o();
    }

    private ServiceTokenResult O000000o(Context context, Account account, ServiceTokenResult serviceTokenResult) {
        if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_NONE || TextUtils.isEmpty(serviceTokenResult.f6200O000000o) || TextUtils.isEmpty(serviceTokenResult.O00000Oo)) {
            return serviceTokenResult;
        }
        String md5DigestUpperCase = Coder.getMd5DigestUpperCase(serviceTokenResult.O00000Oo);
        String O000000o2 = this.O00000Oo.O000000o(context, account);
        String O000000o3 = O000000o(md5DigestUpperCase, this.O00000Oo.O00000Oo(context, serviceTokenResult.f6200O000000o, account));
        String O000000o4 = O000000o(md5DigestUpperCase, this.O00000Oo.O00000o0(context, serviceTokenResult.f6200O000000o, account));
        ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(serviceTokenResult.f6200O000000o);
        o000000o.O00000Oo = serviceTokenResult.O00000Oo;
        o000000o.O00000o0 = serviceTokenResult.O00000o0;
        o000000o.O00000oo = serviceTokenResult.O00000o;
        o000000o.O00000o = serviceTokenResult.O00000oO;
        o000000o.O00000oO = serviceTokenResult.O00000oo;
        o000000o.O0000OoO = serviceTokenResult.O0000OoO;
        o000000o.O0000Oo = O000000o2;
        o000000o.O0000OOo = O000000o3;
        o000000o.O0000Oo0 = O000000o4;
        o000000o.O0000o00 = account.name;
        return o000000o.O000000o();
    }

    private static String O000000o(String str, String str2) {
        if (!(str == null || str2 == null)) {
            String[] split = str2.split(",");
            if (split.length == 2 && str.equalsIgnoreCase(split[0])) {
                return split[1];
            }
        }
        return null;
    }
}

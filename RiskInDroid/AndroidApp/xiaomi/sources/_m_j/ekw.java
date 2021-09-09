package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.net.MalformedURLException;
import java.net.URL;

public final class ekw {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f15587O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    private final O00000Oo O00000oo;

    public interface O00000Oo {
        boolean O000000o();
    }

    /* synthetic */ ekw(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private ekw(O000000o o000000o) {
        this.f15587O000000o = o000000o.f15588O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
    }

    public static String O000000o(String str, String str2, String str3, String str4) {
        return String.format("%s=%s; domain=%s; path=%s", str2, str3, str, str4);
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f15588O000000o;
        public String O00000Oo;
        public String O00000o = "/";
        public String O00000o0;
        public String O00000oO;
        public O00000Oo O00000oo;

        public final ekw O000000o() {
            O000000o(this.f15588O000000o, "context");
            O000000o(this.O00000Oo, "sid");
            O000000o(this.O00000o0, "url");
            O000000o(this.O00000o, "cookiePath");
            if (this.O00000oO == null) {
                try {
                    this.O00000oO = new URL(this.O00000o0).getHost();
                } catch (MalformedURLException e) {
                    AccountLog.w("WebSsoCookieUtils", "bad url", e);
                }
            }
            O000000o(this.O00000oO, "cookieDomain");
            return new ekw(this, (byte) 0);
        }

        private static void O000000o(Object obj, String str) {
            if (obj == null) {
                throw new IllegalArgumentException(str + " is null");
            }
        }
    }

    public final ServiceTokenResult O000000o(boolean z) {
        ServiceTokenResult serviceTokenResult = MiAccountManager.O00000Oo(this.f15587O000000o).O000000o(this.f15587O000000o, this.O00000Oo).get();
        if (TextUtils.isEmpty(serviceTokenResult.O00000Oo)) {
            AccountLog.w("WebSsoCookieUtils", String.format("setCookie error: no serviceToken for sid %s", this.O00000Oo));
            return null;
        } else if (TextUtils.isEmpty(serviceTokenResult.O0000Oo)) {
            AccountLog.w("WebSsoCookieUtils", "setCookie error: no cUserId");
            return null;
        } else if (TextUtils.isEmpty(serviceTokenResult.O0000OOo)) {
            AccountLog.w("WebSsoCookieUtils", String.format("setCookie error: no %s_slh", this.O00000Oo));
            if (z) {
                return O000000o(serviceTokenResult);
            }
            return null;
        } else if (TextUtils.isEmpty(serviceTokenResult.O0000Oo0)) {
            AccountLog.w("WebSsoCookieUtils", String.format("setCookie error: no %s_ph", this.O00000Oo));
            if (z) {
                return O000000o(serviceTokenResult);
            }
            return null;
        } else {
            O00000Oo o00000Oo = this.O00000oo;
            if (!(z && serviceTokenResult.O0000OoO && o00000Oo != null && !o00000Oo.O000000o())) {
                return serviceTokenResult;
            }
            AccountLog.w("WebSsoCookieUtils", String.format("serviceToken for sid %s is invalid. Re-get again.", this.O00000Oo));
            return O000000o(serviceTokenResult);
        }
    }

    private ServiceTokenResult O000000o(ServiceTokenResult serviceTokenResult) {
        MiAccountManager.O00000Oo(this.f15587O000000o).O000000o(this.f15587O000000o, serviceTokenResult);
        return O000000o(false);
    }
}

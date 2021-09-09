package _m_j;

import android.text.TextUtils;
import java.net.CookieManager;
import java.net.HttpCookie;

public final class icp {
    public static HttpCookie O000000o(CookieManager cookieManager, String str, String str2) {
        return O000000o(cookieManager, str, str2, "");
    }

    private static HttpCookie O000000o(CookieManager cookieManager, String str, String str2, String str3) {
        if (cookieManager != null && !TextUtils.isEmpty(str)) {
            for (HttpCookie next : cookieManager.getCookieStore().getCookies()) {
                boolean z = false;
                boolean z2 = TextUtils.isEmpty(str2) || str2.equals(next.getDomain());
                if (TextUtils.isEmpty(str3) || str3.equals(next.getPath())) {
                    z = true;
                }
                if (str.equals(next.getName()) && z2 && z) {
                    return next;
                }
            }
        }
        return null;
    }
}

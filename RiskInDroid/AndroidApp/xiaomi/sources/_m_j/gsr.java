package _m_j;

import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;

public final class gsr {
    public static void O000000o(CookieManager cookieManager, String str, String str2, String str3, String str4, String str5) {
        if (cookieManager != null) {
            HttpCookie httpCookie = new HttpCookie(str2, str3);
            httpCookie.setDomain(str4);
            httpCookie.setPath(str5);
            try {
                cookieManager.getCookieStore().add(new URI(str), httpCookie);
            } catch (URISyntaxException unused) {
            }
        }
    }

    public static void O000000o(CookieManager cookieManager) {
        if (cookieManager != null) {
            cookieManager.getCookieStore().removeAll();
        }
    }

    public static void O00000Oo(CookieManager cookieManager, String str, String str2, String str3, String str4, String str5) {
        try {
            HttpCookie httpCookie = new HttpCookie(str2, "");
            httpCookie.setPath(str5);
            httpCookie.setDomain(str4);
            cookieManager.getCookieStore().remove(new URI(str), httpCookie);
        } catch (URISyntaxException unused) {
        }
        O000000o(cookieManager, str, str2, str3, str4, str5);
    }
}

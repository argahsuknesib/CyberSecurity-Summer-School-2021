package _m_j;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil;
import java.util.Locale;
import java.util.Map;

public final class efm {
    public static void O000000o(WebView webView, Map<String, String> map) {
        String str;
        if (!map.isEmpty()) {
            CookieSyncManager.createInstance(webView.getContext());
            CookieManager instance = CookieManager.getInstance();
            for (Map.Entry next : map.entrySet()) {
                String str2 = (String) next.getKey();
                String str3 = (String) next.getValue();
                if (instance != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str2.equals("passToken")) {
                        str = String.format("%s=%s;HttpOnly;", str2, str3);
                    } else {
                        str = String.format("%s=%s;Secure;", str2, str3);
                    }
                    instance.setCookie(AbstractAccountWebViewSingleCookieUtil.DOMAIN_URL_SET_COOKIE, str);
                }
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    public static String O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (String str3 : str.split(";")) {
                if (str3.contains(str2) && str3.split("=")[0].trim().equals(str2)) {
                    return str3.substring(str3.indexOf("=") + 1);
                }
            }
        }
        return null;
    }

    public static String O000000o() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }
}

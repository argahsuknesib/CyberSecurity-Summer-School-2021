package _m_j;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;

public final class hlq {
    public static void O000000o(Context context) {
        O00000Oo(context);
        O00000o0(context);
        O000000o();
    }

    private static void O00000Oo(Context context) {
        try {
            CookieManager instance = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT >= 21) {
                instance.removeAllCookies(null);
                return;
            }
            CookieSyncManager.createInstance(context);
            instance.removeAllCookie();
        } catch (Exception unused) {
        }
    }

    private static void O000000o() {
        try {
            WebStorage.getInstance().deleteAllData();
        } catch (Exception unused) {
        }
    }

    private static void O00000o0(Context context) {
        try {
            WebViewDatabase instance = WebViewDatabase.getInstance(context);
            instance.clearFormData();
            instance.clearHttpAuthUsernamePassword();
        } catch (Exception unused) {
        }
    }
}

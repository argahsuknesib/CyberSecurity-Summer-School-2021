package com.xiaomi.mico.common.util;

import _m_j.jdj;
import _m_j.jdn;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.ArrayList;

public class WebViewUtils {
    public static void callWebViewMethod(WebView webView, String str, Object... objArr) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (objArr == null || objArr.length <= 0) {
                str2 = "";
            } else {
                ArrayList arrayList = new ArrayList(objArr.length);
                for (Object obj : objArr) {
                    arrayList.add(jdn.f1779O000000o + jdj.O000000o(obj.toString()) + jdn.f1779O000000o);
                }
                str2 = TextUtils.join(", ", arrayList);
            }
            String format = String.format("javascript:%s(%s)", str, str2);
            Object[] objArr2 = {"try to load url %s", format};
            webView.loadUrl(format);
        }
    }

    public static void destroyWebView(WebView webView, boolean z, boolean z2) {
        webView.removeAllViews();
        webView.clearHistory();
        if (z) {
            webView.clearCache(true);
        }
        if (z2) {
            clearCookie();
        }
        webView.destroy();
    }

    public static void clearCookie() {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(new ValueCallback<Boolean>() {
                /* class com.xiaomi.mico.common.util.WebViewUtils.AnonymousClass1 */

                public final void onReceiveValue(Boolean bool) {
                    Object[] objArr = {"Cookie deleted %s", bool.toString()};
                }
            });
        } else {
            CookieManager.getInstance().removeAllCookie();
        }
    }
}

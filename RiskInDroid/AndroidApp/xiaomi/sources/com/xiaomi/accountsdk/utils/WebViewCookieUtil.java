package com.xiaomi.accountsdk.utils;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import java.util.Map;

public class WebViewCookieUtil extends AbstractAccountWebViewSingleCookieUtil {
    /* access modifiers changed from: protected */
    public String getCookieName() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String getCookieValue() {
        return "";
    }

    public void setupCookiesForAccountWeb(WebView webView, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            CookieSyncManager.createInstance(webView.getContext());
            CookieManager instance = CookieManager.getInstance();
            for (Map.Entry next : map.entrySet()) {
                setAccountCookie(instance, (String) next.getKey(), (String) next.getValue());
            }
            CookieSyncManager.getInstance().sync();
        }
    }
}

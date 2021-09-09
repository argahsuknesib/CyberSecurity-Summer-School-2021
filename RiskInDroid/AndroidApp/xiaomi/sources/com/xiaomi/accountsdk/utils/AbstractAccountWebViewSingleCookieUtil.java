package com.xiaomi.accountsdk.utils;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.xiaomi.accountsdk.account.XMPassport;

public abstract class AbstractAccountWebViewSingleCookieUtil {
    public static final String DOMAIN_URL_SET_COOKIE = (XMPassport.USE_PREVIEW ? "http://.account.preview.n.xiaomi.net" : "https://.account.xiaomi.com");

    /* access modifiers changed from: protected */
    public abstract String getCookieName();

    /* access modifiers changed from: protected */
    public abstract String getCookieValue();

    public final void setupNonNullCookieForAccountWeb(WebView webView) {
        if (webView != null && !TextUtils.isEmpty(getCookieValue())) {
            CookieSyncManager.createInstance(webView.getContext());
            setAccountCookie(CookieManager.getInstance(), getCookieName(), getCookieValue());
            CookieSyncManager.getInstance().sync();
        }
    }

    /* access modifiers changed from: protected */
    public final void setAccountCookie(CookieManager cookieManager, String str) {
        setAccountCookie(cookieManager, getCookieName(), str);
    }

    protected static void setAccountCookie(CookieManager cookieManager, String str, String str2) {
        if (cookieManager != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            cookieManager.setCookie(DOMAIN_URL_SET_COOKIE, String.format("%s=%s;", str, str2));
        }
    }
}

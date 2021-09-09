package com.xiaomi.accountsdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebView;

public final class WebViewUserSpaceIdUtil extends AbstractAccountWebViewSingleCookieUtil {
    /* access modifiers changed from: protected */
    public final String getCookieName() {
        return "userSpaceId";
    }

    public final void setupUserSpaceIdForAccountWeb(WebView webView) {
        super.setupNonNullCookieForAccountWeb(webView);
    }

    public final void setupUserSpaceIdCookie(String str, CookieManager cookieManager) {
        super.setAccountCookie(cookieManager, str);
    }

    /* access modifiers changed from: protected */
    public final String getCookieValue() {
        return UserSpaceIdUtil.getNullableUserSpaceIdCookie();
    }
}

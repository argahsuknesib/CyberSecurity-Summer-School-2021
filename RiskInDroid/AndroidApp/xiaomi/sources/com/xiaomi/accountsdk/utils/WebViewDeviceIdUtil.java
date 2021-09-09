package com.xiaomi.accountsdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebView;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;

public final class WebViewDeviceIdUtil extends AbstractAccountWebViewSingleCookieUtil {
    /* access modifiers changed from: protected */
    public final String getCookieName() {
        return "deviceId";
    }

    public final void setupDeviceIdForAccountWeb(WebView webView) {
        super.setupNonNullCookieForAccountWeb(webView);
    }

    public final void setDeviceIdCookie(String str, CookieManager cookieManager) {
        super.setAccountCookie(cookieManager, str);
    }

    /* access modifiers changed from: protected */
    public final String getCookieValue() {
        return new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow();
    }
}

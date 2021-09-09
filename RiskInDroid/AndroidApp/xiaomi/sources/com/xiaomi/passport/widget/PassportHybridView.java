package com.xiaomi.passport.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;
import com.xiaomi.accountsdk.utils.VersionUtils;
import com.xiaomi.accountsdk.utils.WebViewCookieUtil;
import com.xiaomi.accountsdk.utils.WebViewDeviceIdUtil;
import com.xiaomi.accountsdk.utils.WebViewFidNonceUtil;
import com.xiaomi.accountsdk.utils.WebViewNativeUserAgentUtil;
import com.xiaomi.accountsdk.utils.WebViewUserSpaceIdUtil;
import com.xiaomi.accountsdk.utils.XMPassportUtil;

public class PassportHybridView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    String f6352O000000o;
    private final ServerTimeUtil.ServerTimeAlignedListener O00000Oo = new WebViewFidNonceUtil.ServerTimeAlignedListenerImpl(this);

    public PassportHybridView(Context context) {
        super(context);
    }

    public void loadUrl(String str) {
        this.f6352O000000o = str;
        String buildUrlWithLocaleQueryParam = XMPassportUtil.buildUrlWithLocaleQueryParam(this.f6352O000000o);
        CookieSyncManager.createInstance(getContext());
        CookieManager.getInstance().removeAllCookie();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        String userAgentString = settings.getUserAgentString();
        if (!TextUtils.isEmpty(userAgentString)) {
            settings.setUserAgentString(String.format("%s PassportSDK/PassportHybridView/%s XiaoMi/HybridView/", userAgentString, VersionUtils.getVersion()));
        }
        new WebViewDeviceIdUtil().setupDeviceIdForAccountWeb(this);
        new WebViewFidNonceUtil().setupFidNonceForAccountWeb(this);
        new WebViewUserSpaceIdUtil().setupUserSpaceIdForAccountWeb(this);
        new WebViewNativeUserAgentUtil().setupUserAgentForAccountWeb(this);
        new WebViewCookieUtil().setupCookiesForAccountWeb(this, null);
        setWebViewClient(new O000000o(this));
        super.loadUrl(buildUrlWithLocaleQueryParam);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ServerTimeUtil.addServerTimeChangedListener(this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ServerTimeUtil.removeServerTimeChangedListener(this.O00000Oo);
        super.onDetachedFromWindow();
    }

    public static class O000000o extends WebViewClient {

        /* renamed from: O000000o  reason: collision with root package name */
        private final PassportHybridView f6353O000000o;

        public O000000o(PassportHybridView passportHybridView) {
            this.f6353O000000o = passportHybridView;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String cookie = CookieManager.getInstance().getCookie(this.f6353O000000o.f6352O000000o);
            if (TextUtils.isEmpty(cookie) || !cookie.contains("passInfo")) {
                return false;
            }
            cookie.contains("need-relogin");
            if (cookie.contains("login-end")) {
                XMPassportUtil.extractPasstokenFromNotificationLoginEndCookie(cookie);
                XMPassportUtil.extractUserIdFromNotificationLoginEndCookie(cookie);
            }
            cookie.contains("auth-end");
            cookie.contains("bindph-end");
            return false;
        }
    }
}

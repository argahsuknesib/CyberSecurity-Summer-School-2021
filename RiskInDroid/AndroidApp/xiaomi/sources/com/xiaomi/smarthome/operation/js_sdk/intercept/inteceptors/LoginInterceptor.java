package com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors;

import _m_j.hkw;
import android.content.Context;
import android.webkit.WebView;
import com.xiaomi.smarthome.WebViewRouterFactory;

public class LoginInterceptor extends hkw {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f10515O000000o;

    public LoginInterceptor(Context context) {
        this.f10515O000000o = context;
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewRouterFactory.getWebViewHelpManager().onReceivedLoginRequest(this.f10515O000000o, webView, str, str2, str3);
    }
}

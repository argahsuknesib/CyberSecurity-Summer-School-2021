package com.xiaomi.smarthome;

import _m_j.eyf;
import _m_j.fbs;
import androidx.annotation.Keep;

@Keep
public class WebViewRouterFactory {
    public static void selfCheck() {
        if (getWebViewHelpManager() == null) {
            throw new RuntimeException("IWebViewHelper does not implement classes");
        }
    }

    public static eyf getWebViewHelpManager() {
        return (eyf) fbs.O000000o(eyf.class, "key.com.xiaomi.smarthome.webview.helper.router");
    }
}

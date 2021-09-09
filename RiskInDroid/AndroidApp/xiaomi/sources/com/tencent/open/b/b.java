package com.tencent.open.b;

import _m_j.diz;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

public class b extends WebView {
    public b(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            diz.O00000o0("openSDK_LOG.OpenWebView", "removeJSInterface");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            try {
                Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
                if (method != null) {
                    method.invoke(this, "searchBoxJavaBridge_");
                    method.invoke(this, "accessibility");
                    method.invoke(this, "accessibilityTraversal");
                    diz.O00000o0("openSDK_LOG.OpenWebView", "remove js interface");
                }
            } catch (Exception e) {
                diz.O00000oO("openSDK_LOG.OpenWebView", "remove js interface.e:" + e.toString());
            }
        }
    }

    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
            setVisibility(8);
            diz.O00000o0("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
        } catch (Exception e) {
            diz.O00000Oo("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e);
        }
        super.destroy();
    }
}

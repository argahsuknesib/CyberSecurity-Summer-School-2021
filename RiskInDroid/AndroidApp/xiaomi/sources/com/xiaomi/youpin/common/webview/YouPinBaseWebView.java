package com.xiaomi.youpin.common.webview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YouPinBaseWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<Object> f12058O000000o = new ArrayList<>();
    Map<String, Object> O00000Oo = new HashMap();
    public long O00000o = 0;
    Map<String, Object> O00000o0 = new HashMap();
    private O000000o O00000oO = new O000000o(this, (byte) 0);

    public YouPinBaseWebView(Context context) {
        super(context);
        O000000o();
    }

    public YouPinBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public YouPinBaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        String str = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCachePath(str);
        settings.setUseWideViewPort(true);
        addJavascriptInterface(this.O00000oO, "WebViewJavascriptBridgeInterface");
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Map<String, Object> f12059O000000o;

        private O000000o() {
            this.f12059O000000o = new HashMap();
        }

        /* synthetic */ O000000o(YouPinBaseWebView youPinBaseWebView, byte b) {
            this();
        }

        @JavascriptInterface
        public final void onResultForScript(String str, String str2) {
            this.f12059O000000o.remove(str);
        }
    }
}

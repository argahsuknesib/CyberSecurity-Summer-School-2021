package com.xiaomi.smarthome.framework.webview;

import _m_j.flk;
import _m_j.fln;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfp;
import _m_j.gfr;
import _m_j.gku;
import _m_j.gsy;
import _m_j.gty;
import _m_j.hkd;
import _m_j.hte;
import _m_j.ibh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Locale;

public class SmartHomeWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f8798O000000o;
    private boolean O00000Oo = false;
    private String O00000o;
    private String O00000o0 = "";

    public O00000Oo getWebViewClient() {
        return this.f8798O000000o;
    }

    public SmartHomeWebView(Context context) {
        super(context);
        O000000o(context);
    }

    public SmartHomeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public SmartHomeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void O000000o(Context context) {
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        if (this.O00000o == null) {
            this.O00000o = settings.getUserAgentString() + " " + fln.O000000o(context) + " XiaoMi/MiuiBrowser/4.3 XiaoMi/HybridView/";
        }
        settings.setUserAgentString(this.O00000o);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(context.getApplicationContext().getDir("cache", 0).getPath());
        settings.setAllowFileAccess(false);
        settings.setSupportZoom(true);
        settings.setTextZoom(100);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        addJavascriptInterface(new O000000o(), "DarkModeInterface");
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 17) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        setWebChromeClient(new SmartHomeWebChromeClient());
        this.f8798O000000o = new O00000Oo();
        setWebViewClient(this.f8798O000000o);
        setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.AnonymousClass1 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!TextUtils.isEmpty(str)) {
                    SmartHomeWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        });
        O000000o();
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(gfr.O0000OOo);
        }
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        if (gku.O000000o(getContext())) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof gfp) {
            super.setWebViewClient(webViewClient);
        }
        super.setWebViewClient(new gfp(webViewClient));
    }

    public void setExtraWebViewClient(WebViewClient webViewClient) {
        O00000Oo o00000Oo = this.f8798O000000o;
        if (o00000Oo != null) {
            o00000Oo.f8802O000000o = new WeakReference<>(webViewClient);
        }
    }

    public final void O000000o() {
        CookieSyncManager.createInstance(getContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            instance.setAcceptThirdPartyCookies(this, true);
        }
        if (CoreApi.O000000o().O0000Ooo()) {
            try {
                MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaomiio");
                if (O000000o2 != null) {
                    O000000o(instance, "serviceToken", URLEncoder.encode(O000000o2.O00000o0, "UTF-8"), ".io.mi.com");
                    O000000o(instance, "yetAnotherServiceToken", URLEncoder.encode(O000000o2.O00000o0, "UTF-8"), ".home.mi.com");
                }
                MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaomihome");
                if (O000000o3 != null) {
                    O000000o(instance, "serviceToken", URLEncoder.encode(O000000o3.O00000o0, "UTF-8"), ".home.mi.com");
                }
                hkd.O000000o(instance, ".home.mi.com");
            } catch (Exception unused) {
            }
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        O000000o(instance, "locale", flk.O000000o(O00oOooo), ".io.mi.com");
        O000000o(instance, "locale", flk.O000000o(O00oOooo), ".home.mi.com");
        O000000o(instance, "channel", gfr.O0000o0O, ".home.mi.com");
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
        O000000o(instance, "xiaomihome", ".home.mi.com");
    }

    private void O000000o(final CookieManager cookieManager, String str, final String str2) {
        gty.O000000o().refreshServiceToken(str, new ibh<MiServiceTokenInfo, Error>() {
            /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.AnonymousClass2 */

            public final void onFailure(Error error) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                try {
                    SmartHomeWebView.O000000o(cookieManager, "serviceToken", URLEncoder.encode(miServiceTokenInfo.O00000o0, "UTF-8"), str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        CookieManager.getInstance().flush();
                    }
                } catch (Exception unused) {
                }
                CoreApi.O000000o().O000000o(miServiceTokenInfo, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        });
    }

    public static void O000000o(CookieManager cookieManager, String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            cookieManager.setCookie(str3, str + "=" + str2 + ";path=/;domain=" + str3);
            gsy.O00000Oo("SmartHomeWebView", "setCookie: domain: " + str3 + " ;name: " + str + " ;value: " + str2);
        }
    }

    public static class O00000Oo extends WebViewClient {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<WebViewClient> f8802O000000o;
        private O000000o O00000Oo;

        public interface O000000o {
            boolean O000000o();
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient;
            WeakReference<WebViewClient> weakReference = this.f8802O000000o;
            if (!(weakReference == null || (webViewClient = weakReference.get()) == null || Build.VERSION.SDK_INT < 24)) {
                webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TextUtils.isEmpty(str);
        }

        public final void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient;
            WeakReference<WebViewClient> weakReference = this.f8802O000000o;
            if (!(weakReference == null || (webViewClient = weakReference.get()) == null)) {
                webViewClient.onPageFinished(webView, str);
            }
            TextUtils.isEmpty(str);
            super.onPageFinished(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient;
            WeakReference<WebViewClient> weakReference = this.f8802O000000o;
            if (!(weakReference == null || (webViewClient = weakReference.get()) == null || Build.VERSION.SDK_INT < 24)) {
                webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient;
            WeakReference<WebViewClient> weakReference = this.f8802O000000o;
            if (!(weakReference == null || (webViewClient = weakReference.get()) == null || Build.VERSION.SDK_INT < 24)) {
                webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient;
            WeakReference<WebViewClient> weakReference = this.f8802O000000o;
            if (!(weakReference == null || (webViewClient = weakReference.get()) == null)) {
                webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient;
            Context context = webView.getContext();
            if (str.startsWith("tel") || str.startsWith("mailto")) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (str.contains("home.mi.com/shop/shexiangyun")) {
                gsy.O00000Oo("SmartHomeWebView", "buy url:".concat(String.valueOf(str)));
                WebViewRouterFactory.getWebViewHelpManager().openUrl(str);
                return true;
            } else {
                O000000o o000000o = this.O00000Oo;
                if (o000000o != null && o000000o.O000000o()) {
                    return true;
                }
                WeakReference<WebViewClient> weakReference = this.f8802O000000o;
                if (!(weakReference == null || (webViewClient = weakReference.get()) == null)) {
                    webViewClient.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }
    }

    public static class SmartHomeWebChromeClient extends WebChromeClient {
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(webView.getContext());
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.SmartHomeWebChromeClient.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(webView.getContext());
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.SmartHomeWebChromeClient.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebView.SmartHomeWebChromeClient.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            hte.O000000o(webView.getContext(), str2);
            return true;
        }
    }

    public static class O000000o {
        @JavascriptInterface
        public final boolean needInvertColor() {
            return Build.VERSION.SDK_INT < 29 && gku.O000000o(CommonApplication.getAppContext());
        }
    }
}

package com.xiaomi.smarthome.operation.js_sdk.base;

import _m_j.fjz;
import _m_j.gsy;
import _m_j.hkh;
import _m_j.hki;
import _m_j.hkm;
import _m_j.hkv;
import _m_j.hky;
import _m_j.hlb;
import _m_j.hlh;
import _m_j.hlk;
import _m_j.hlm;
import _m_j.hlp;
import _m_j.izb;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.MibiInterceptor;

public class CommonWebView extends BaseWebView {

    /* renamed from: O000000o  reason: collision with root package name */
    public hlk f10512O000000o;
    public hky O00000Oo;
    public String O00000o = "";
    public boolean O00000o0 = false;
    public String O00000oO;
    public boolean O00000oo = false;
    public String O0000O0o;
    private hlh O0000OOo;
    private String O0000Oo;
    private boolean O0000Oo0 = true;
    private MibiInterceptor O0000OoO;
    private boolean O0000Ooo = false;
    private final WebViewClient O0000o = new WebViewClient() {
        /* class com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView.AnonymousClass2 */

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            CommonWebView.this.O00000Oo.f19027O000000o.onPageStarted(webView, str, bitmap);
            gsy.O000000o(3, "CommonWebView", "onPageStarted url: ".concat(String.valueOf(str)));
            if (CommonWebView.this.O00000o0) {
                if (CommonWebView.this.O00000o.equals(CommonWebView.this.O00000oO)) {
                    gsy.O000000o(3, "CommonWebView", "onPageStarted url finish:" + CommonWebView.this.O00000oO);
                    ((Activity) CommonWebView.this.getContext()).finish();
                    return;
                } else if (str.startsWith("https://account.xiaomi.com/pass/serviceLogin")) {
                    CommonWebView commonWebView = CommonWebView.this;
                    commonWebView.O00000o0 = false;
                    if (commonWebView.canGoBack()) {
                        CommonWebView.this.goBack();
                        return;
                    }
                    return;
                }
            }
            super.onPageStarted(webView, str, bitmap);
            CommonWebView.this.O00000o0 = false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            gsy.O000000o(3, "CommonWebView", "shouldOverrideUrlLoading url: ".concat(String.valueOf(str)));
            CommonWebView commonWebView = CommonWebView.this;
            commonWebView.O00000o0 = false;
            if (commonWebView.O00000Oo.f19027O000000o.shouldOverrideUrlLoading(webView, str) || super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            CommonWebView commonWebView = CommonWebView.this;
            commonWebView.O00000o0 = false;
            if (commonWebView.O00000Oo.f19027O000000o.shouldOverrideUrlLoading(webView, webResourceRequest) || super.shouldOverrideUrlLoading(webView, webResourceRequest)) {
                return true;
            }
            return false;
        }

        public final void onPageFinished(WebView webView, String str) {
            gsy.O000000o(3, "CommonWebView", "onPageFinished url: ".concat(String.valueOf(str)));
            CommonWebView.this.O00000o = BaseWebView.O000000o(str);
            CommonWebView commonWebView = CommonWebView.this;
            commonWebView.O00000o0 = false;
            commonWebView.O00000Oo.f19027O000000o.onPageFinished(webView, str);
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            CommonWebView.this.O00000Oo.f19027O000000o.onReceivedLoginRequest(webView, str, str2, str3);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            CommonWebView.this.O00000Oo.f19027O000000o.onReceivedError(webView, i, str, str2);
        }
    };
    private hlb O0000o0;
    private int O0000o00 = 1;
    private hlm O0000o0O;
    private final WebChromeClient O0000o0o = new WebChromeClient() {
        /* class com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView.AnonymousClass1 */

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            hlm titleBarImpl = CommonWebView.this.getTitleBarImpl();
            if (titleBarImpl != null) {
                if (TextUtils.equals("http://".concat(String.valueOf(str)), CommonWebView.this.O0000O0o) || TextUtils.equals("https://".concat(String.valueOf(str)), CommonWebView.this.O0000O0o)) {
                    str = " ";
                }
                BaseWebView.O000000o(new Runnable(str) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$tSmDd5wbKedm70HGRqvFkm0SWUQ */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.O000000o(this.f$1);
                    }
                });
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            hlm titleBarImpl = CommonWebView.this.getTitleBarImpl();
            if (titleBarImpl != null) {
                BaseWebView.O000000o(new Runnable(i) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$6lkxh7hmXw_CtjKFO8Ho4EUEvCs */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.O000000o(this.f$1);
                    }
                });
            }
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(CommonWebView.this.getContext());
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(jsResult) {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$MFAcygiitTOsPrZu7bxeurF_F14 */
                private final /* synthetic */ JsResult f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.confirm();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(CommonWebView.this.getContext());
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(jsResult) {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$RPBxE0IcnXgV9cNfs8GsR6hTv0 */
                private final /* synthetic */ JsResult f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.confirm();
                }
            });
            builder.O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener(jsResult) {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$JCIhM0fVakCcBd1oe6so5ltpSQc */
                private final /* synthetic */ JsResult f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.cancel();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            izb.O000000o(CommonWebView.this.getContext(), str2, 0).show();
            return true;
        }

        public void onHideCustomView() {
            hlb webPageActionImpl = CommonWebView.this.getWebPageActionImpl();
            if (webPageActionImpl != null) {
                webPageActionImpl.getClass();
                BaseWebView.O000000o(new Runnable() {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$5q_KORlM9j1rdSgbCllYa1KDVU */

                    public final void run() {
                        hlb.this.O000000o();
                    }
                });
            }
            super.onHideCustomView();
            CommonWebView.this.O00000oo = false;
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            hlb webPageActionImpl = CommonWebView.this.getWebPageActionImpl();
            if (webPageActionImpl != null) {
                BaseWebView.O000000o(new Runnable(view, customViewCallback) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$EUHuZoIL4OP8tR_p_4mfgVa4OFI */
                    private final /* synthetic */ View f$1;
                    private final /* synthetic */ WebChromeClient.CustomViewCallback f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        hlb.this.O000000o(this.f$1, this.f$2);
                    }
                });
            }
            super.onShowCustomView(view, customViewCallback);
            CommonWebView.this.O00000oo = true;
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            hlb webPageActionImpl = CommonWebView.this.getWebPageActionImpl();
            if (webPageActionImpl == null) {
                return true;
            }
            BaseWebView.O000000o(new Runnable(webView, valueCallback, fileChooserParams) {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$MNG6TRVUHRgyN5dAUL1chONQ4DM */
                private final /* synthetic */ WebView f$1;
                private final /* synthetic */ ValueCallback f$2;
                private final /* synthetic */ WebChromeClient.FileChooserParams f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    hlb.this.O000000o(this.f$2, this.f$3);
                }
            });
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            hlb webPageActionImpl = CommonWebView.this.getWebPageActionImpl();
            if (webPageActionImpl != null) {
                BaseWebView.O000000o(new Runnable(valueCallback, str, str2) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$1$1XPjvlgXMl7A_QGOZ72VJ1Yac44 */
                    private final /* synthetic */ ValueCallback f$1;
                    private final /* synthetic */ String f$2;
                    private final /* synthetic */ String f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        hlb.this.O000000o(this.f$1, this.f$2);
                    }
                });
            }
        }
    };

    public CommonWebView(Context context) {
        super(context);
        O000000o(context);
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.O0000OOo = new hlh(this);
        this.O00000Oo = new hky();
        this.f10512O000000o = new hlk(this, context);
        this.O00000Oo.O000000o(context);
        this.O00000Oo.f19027O000000o.O000000o(hlk.class.getSimpleName(), this.f10512O000000o);
        this.O00000Oo.f19027O000000o.O000000o(hkm.class.getSimpleName(), new hkm(this));
        this.O0000OoO = (MibiInterceptor) this.O00000Oo.f19027O000000o.O000000o(MibiInterceptor.class);
        O00000o0();
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void O00000o0() {
        setWebViewClient(this.O0000o);
        setWebChromeClient(this.O0000o0o);
        addJavascriptInterface(new hkh((Activity) getContext(), this), "_cloud_video_interface");
        addJavascriptInterface(new hki((Activity) getContext(), this), "_native_interface");
    }

    public final void O000000o(String str, hkv hkv) {
        this.O00000Oo.f19027O000000o.O000000o(str, hkv);
    }

    public void loadUrl(String str) {
        this.O0000O0o = str;
        Uri parse = Uri.parse(str);
        if (parse != null) {
            this.O0000Ooo = parse.getBooleanQueryParameter("fullscreen", false);
        }
        super.loadUrl(str);
        if (this.O0000Oo0) {
            this.O0000Oo0 = false;
            this.O00000oO = O000000o(str);
        }
    }

    public void onResume() {
        super.onResume();
        this.O00000Oo.f19027O000000o.onResume();
    }

    public void destroy() {
        super.destroy();
        fjz.O000000o().O00000Oo(this.O0000OOo.f19034O000000o.f10521O000000o);
        this.O00000Oo.f19027O000000o.onDestroy();
    }

    public final boolean O00000Oo() {
        if (!canGoBack()) {
            return false;
        }
        this.O00000o0 = true;
        goBack();
        return true;
    }

    public void setWebPageActionImpl(hlb hlb) {
        this.O0000o0 = hlb;
    }

    public hlb getWebPageActionImpl() {
        return this.O0000o0;
    }

    public void setTitleBarImpl(hlm hlm) {
        this.O0000o0O = hlm;
    }

    public hlm getTitleBarImpl() {
        return this.O0000o0O;
    }

    public hlh getNetworkHelper() {
        return this.O0000OOo;
    }

    public String getDid() {
        return this.O0000Oo;
    }

    public void setDid(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O0000Oo = str;
            MibiInterceptor mibiInterceptor = this.O0000OoO;
            if (mibiInterceptor != null) {
                mibiInterceptor.f10516O000000o = this.O0000Oo;
            }
            CookieSyncManager.createInstance(getContext());
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            O000000o(instance, "did", str, ".mi.com");
        }
    }

    public boolean getFullScreenStatus() {
        return this.O0000Ooo || this.O00000oo;
    }

    public void setOrientation(int i) {
        this.O0000o00 = i;
        hlb webPageActionImpl = getWebPageActionImpl();
        if (webPageActionImpl != null) {
            hlp.O000000o(new Runnable(i) {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$CommonWebView$nCpot_rZA_AT8GxxG2LIorS0wI0 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hlb.this.O000000o(this.f$1);
                }
            });
        }
    }

    public int getScreenOrientation() {
        return this.O0000o00;
    }
}

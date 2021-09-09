package com.xiaomi.youpin.login.ui.web;

import _m_j.gku;
import _m_j.ico;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.xiaomi.accountsdk.utils.WebViewDeviceIdUtil;
import com.xiaomi.smarthome.R;
import com.xiaomi.youpin.login.ui.baseui.BaseActivity;
import com.xiaomi.youpin.login.view.LoginCommonTitleBar;

public class LoginWebActivity extends BaseActivity {
    protected String O0000OOo;
    protected LoginCommonTitleBar O0000Oo;
    protected String O0000Oo0;
    protected WebView O0000OoO;
    protected ProgressBar O0000Ooo;
    protected LoginCustomWebChromeClient O0000o00;

    /* access modifiers changed from: protected */
    public void O00000o0() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mj_login_common_web_activity);
        if (!O000000o(getIntent())) {
            O00000o0();
            finish();
            return;
        }
        this.O0000Oo = (LoginCommonTitleBar) findViewById(R.id.title_bar);
        ico.O000000o(this.O0000Oo);
        this.O0000Oo.setOnBackClickListener(new View.OnClickListener() {
            /* class com.xiaomi.youpin.login.ui.web.LoginWebActivity.AnonymousClass1 */

            public final void onClick(View view) {
                LoginWebActivity.this.O00000o0();
                LoginWebActivity.this.finish();
            }
        });
        this.O0000Oo.setCenterText(this.O0000OOo);
        this.O0000OoO = (WebView) findViewById(R.id.common_web_view);
        this.O0000Ooo = (ProgressBar) findViewById(R.id.common_web_loading);
        O000000o(this.O0000OoO.getSettings());
        this.O0000OoO.setWebViewClient(O000000o());
        new WebViewDeviceIdUtil().setupDeviceIdForAccountWeb(this.O0000OoO);
        this.O0000o00 = new LoginCustomWebChromeClient(this) {
            /* class com.xiaomi.youpin.login.ui.web.LoginWebActivity.AnonymousClass2 */

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (!TextUtils.isEmpty(str)) {
                    LoginWebActivity.this.O0000Oo.setCenterText(str);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                LoginWebActivity.this.O0000Ooo.setProgress(i);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
        };
        this.O0000OoO.setWebChromeClient(this.O0000o00);
        this.O0000OoO.setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.youpin.login.ui.web.LoginWebActivity.AnonymousClass3 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!TextUtils.isEmpty(str)) {
                    LoginWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        });
        this.O0000OoO.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.O0000OoO.loadUrl(this.O0000Oo0);
    }

    public void onBackPressed() {
        WebView webView = this.O0000OoO;
        if (webView == null || !webView.canGoBack()) {
            O00000o0();
            finish();
            return;
        }
        this.O0000OoO.goBack();
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.O0000Oo0 = intent.getStringExtra("common_web_url");
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            return false;
        }
        this.O0000OOo = intent.getStringExtra("common_web_title");
        return true;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void O000000o(WebSettings webSettings) {
        webSettings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < 19) {
            webSettings.setDatabasePath(getFilesDir().getPath() + this.O0000OoO.getContext().getPackageName() + "/databases/");
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setBlockNetworkImage(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        if (gku.O000000o(this)) {
            webSettings.setForceDark(2);
        } else {
            webSettings.setForceDark(0);
        }
    }

    /* access modifiers changed from: protected */
    public WebViewClient O000000o() {
        return new WebViewClient() {
            /* class com.xiaomi.youpin.login.ui.web.LoginWebActivity.AnonymousClass4 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            @TargetApi(24)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        LoginCustomWebChromeClient loginCustomWebChromeClient = this.O0000o00;
        if (loginCustomWebChromeClient == null || 1001 != i || i != 1001) {
            return;
        }
        if (loginCustomWebChromeClient.f12103O000000o != null || loginCustomWebChromeClient.O00000Oo != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (loginCustomWebChromeClient.O00000Oo != null) {
                if (i == 1001 && loginCustomWebChromeClient.O00000Oo != null) {
                    if (i2 != -1 || intent == null) {
                        uriArr = null;
                    } else {
                        String dataString = intent.getDataString();
                        ClipData clipData = intent.getClipData();
                        if (clipData != null) {
                            uriArr2 = new Uri[clipData.getItemCount()];
                            for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                                uriArr2[i3] = clipData.getItemAt(i3).getUri();
                            }
                        } else {
                            uriArr2 = null;
                        }
                        uriArr = dataString != null ? new Uri[]{Uri.parse(dataString)} : uriArr2;
                    }
                    loginCustomWebChromeClient.O00000Oo.onReceiveValue(uriArr);
                    loginCustomWebChromeClient.O00000Oo = null;
                }
            } else if (loginCustomWebChromeClient.f12103O000000o != null) {
                loginCustomWebChromeClient.f12103O000000o.onReceiveValue(data);
                loginCustomWebChromeClient.f12103O000000o = null;
            }
        }
    }
}

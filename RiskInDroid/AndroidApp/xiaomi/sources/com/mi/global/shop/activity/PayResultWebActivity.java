package com.mi.global.shop.activity;

import _m_j.cec;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.mi.global.shop.webview.WebViewHelper;
import com.mi.global.shop.widget.BaseWebView;
import com.xiaomi.smarthome.R;

public class PayResultWebActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ProgressBar f4656O000000o;
    private BaseWebView O00000Oo;
    private ProgressDialog O00000o;
    private int O00000o0 = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.shop_mobikwik_web_activity);
            String stringExtra = getIntent().getStringExtra("htmlString");
            String stringExtra2 = getIntent().getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.O00000o0 = 1;
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.O00000o0 = 2;
            }
            if (this.O00000o0 == 0) {
                finish();
            }
            initView();
            initProgressDialog();
            if (this.O00000o0 == 1) {
                this.O00000Oo.loadDataWithBaseURL("about:blank", stringExtra, "text/html", "utf-8", null);
            }
            if (this.O00000o0 == 2) {
                this.O00000Oo.loadUrl(stringExtra2);
            }
        } catch (Exception e) {
            if (e.getMessage() == null || !e.getMessage().contains("MissingWebViewPackageException")) {
                cec.O000000o(this, getResources().getString(R.string.loading_error), 0);
            } else {
                cec.O000000o(this, getResources().getString(R.string.webview_tips_uploaing), 0);
            }
            finish();
        }
    }

    public void initView() {
        this.O00000Oo = (BaseWebView) findViewById(R.id.browser);
        this.f4656O000000o = (ProgressBar) findViewById(R.id.browser_progress_bar);
        this.O00000Oo.setWebViewClient(new O000000o(this, (byte) 0));
        this.O00000Oo.setWebChromeClient(new InnerWebChromeClient(this, (byte) 0));
        WebViewHelper.O000000o(this.O00000Oo);
        if (this.O00000o0 == 1) {
            BaseWebView baseWebView = this.O00000Oo;
            baseWebView.addJavascriptInterface(new MobWebEvent(baseWebView), "Mobikwik");
        }
        if (this.O00000o0 == 2) {
            BaseWebView baseWebView2 = this.O00000Oo;
            baseWebView2.addJavascriptInterface(new MobWebEvent(baseWebView2), "PayU");
        }
    }

    static class MobWebEvent {
        WebView mWebView;

        MobWebEvent(WebView webView) {
            this.mWebView = webView;
        }

        @JavascriptInterface
        public void onSuccess() {
            onSuccess("");
        }

        @JavascriptInterface
        public void onSuccess(final String str) {
            ((Activity) this.mWebView.getContext()).runOnUiThread(new Runnable() {
                /* class com.mi.global.shop.activity.PayResultWebActivity.MobWebEvent.AnonymousClass1 */

                public final void run() {
                    Intent intent = new Intent();
                    intent.putExtra("result", str);
                    ((Activity) MobWebEvent.this.mWebView.getContext()).setResult(-1, intent);
                    ((Activity) MobWebEvent.this.mWebView.getContext()).finish();
                }
            });
        }

        @JavascriptInterface
        public void onFailure() {
            onFailure("");
        }

        @JavascriptInterface
        public void onFailure(final String str) {
            ((Activity) this.mWebView.getContext()).runOnUiThread(new Runnable() {
                /* class com.mi.global.shop.activity.PayResultWebActivity.MobWebEvent.AnonymousClass2 */

                public final void run() {
                    Intent intent = new Intent();
                    intent.putExtra("result", str);
                    ((Activity) MobWebEvent.this.mWebView.getContext()).setResult(0, intent);
                    ((Activity) MobWebEvent.this.mWebView.getContext()).finish();
                }
            });
        }
    }

    class O000000o extends WebViewClient {
        private O000000o() {
        }

        /* synthetic */ O000000o(PayResultWebActivity payResultWebActivity, byte b) {
            this();
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            PayResultWebActivity.this.showLoading();
            PayResultWebActivity.this.f4656O000000o.setVisibility(0);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    class InnerWebChromeClient extends WebChromeClient {
        private InnerWebChromeClient() {
        }

        /* synthetic */ InnerWebChromeClient(PayResultWebActivity payResultWebActivity, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            if (PayResultWebActivity.this.f4656O000000o != null) {
                PayResultWebActivity.this.f4656O000000o.setProgress(i);
                if (i == 100) {
                    PayResultWebActivity.this.hideLoading();
                    PayResultWebActivity.this.f4656O000000o.setVisibility(4);
                }
            }
        }
    }

    public void initProgressDialog() {
        this.O00000o = new ProgressDialog(this);
        this.O00000o.setMessage(getString(R.string.please_wait));
        this.O00000o.setIndeterminate(true);
        this.O00000o.setCancelable(false);
        this.O00000o.setCanceledOnTouchOutside(false);
    }

    public void showLoading() {
        if (BaseActivity.isActivityAlive(this)) {
            ProgressDialog progressDialog = this.O00000o;
            if (progressDialog != null) {
                progressDialog.show();
                return;
            }
            initProgressDialog();
            this.O00000o.show();
        }
    }

    public void hideLoading() {
        ProgressDialog progressDialog;
        if (BaseActivity.isActivityAlive(this) && (progressDialog = this.O00000o) != null && progressDialog.isShowing()) {
            this.O00000o.dismiss();
        }
    }
}

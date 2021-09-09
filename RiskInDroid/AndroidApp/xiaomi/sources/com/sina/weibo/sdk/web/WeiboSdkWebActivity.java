package com.sina.weibo.sdk.web;

import _m_j.dbt;
import _m_j.dbv;
import _m_j.dbx;
import _m_j.dcb;
import _m_j.dcd;
import _m_j.dce;
import _m_j.dcf;
import _m_j.dcg;
import _m_j.dch;
import _m_j.dci;
import _m_j.dcj;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;
import com.sina.weibo.sdk.web.view.LoadingBar;

public class WeiboSdkWebActivity extends Activity implements dcb {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f5612O000000o;
    private Button O00000Oo;
    private LinearLayout O00000o;
    private TextView O00000o0;
    public dci baseParam;
    public LoadingBar loadingBar;
    public int pageStatus = 0;
    public TextView titleText;
    public WebView webView;
    public dce webViewClient;

    public void onPageStartedCallBack(WebView webView2, String str, Bitmap bitmap) {
    }

    public boolean shouldOverrideUrlLoadingCallBack(WebView webView2, String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        dbt.O00000Oo("Share", "startWebActivity");
        requestWindowFeature(1);
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        this.f5612O000000o = new TextView(this);
        this.f5612O000000o.setTextSize(17.0f);
        this.f5612O000000o.setTextColor(dbv.O000000o());
        this.f5612O000000o.setText(dbv.O000000o("Close", "关闭", "关闭"));
        this.f5612O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.sina.weibo.sdk.web.WeiboSdkWebActivity.AnonymousClass2 */

            public final void onClick(View view) {
                WeiboSdkWebActivity.this.webViewClient.O000000o();
                WeiboSdkWebActivity.this.closeActivity();
            }
        });
        this.titleText = new TextView(this);
        this.titleText.setTextSize(18.0f);
        this.titleText.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.f5612O000000o.setPadding(dbx.O000000o(10, this), 0, dbx.O000000o(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.f5612O000000o, layoutParams);
        relativeLayout2.addView(this.titleText, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, dbx.O000000o(55, this)));
        this.webView = new WebView(getApplicationContext());
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setAllowFileAccess(false);
        this.webView.getSettings().setAllowContentAccess(false);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = dbx.O000000o(55, this);
        relativeLayout.addView(this.webView, layoutParams3);
        this.loadingBar = new LoadingBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, dbx.O000000o(3, this));
        layoutParams4.topMargin = dbx.O000000o(55, this);
        relativeLayout.addView(this.loadingBar, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, dbx.O000000o(3, this));
        layoutParams5.topMargin = dbx.O000000o(55, this);
        relativeLayout.addView(view, layoutParams5);
        this.O00000o = new LinearLayout(this);
        this.O00000o.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.O00000o.addView(imageView);
        this.O00000o0 = new TextView(this);
        this.O00000o0.setTextSize(14.0f);
        this.O00000o0.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = dbx.O000000o(18, this);
        layoutParams6.bottomMargin = dbx.O000000o(20, this);
        this.O00000o.addView(this.O00000o0, layoutParams6);
        this.O00000Oo = new Button(this);
        this.O00000Oo.setTextSize(16.0f);
        this.O00000Oo.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(dbx.O000000o(142, this), dbx.O000000o(46, this));
        layoutParams7.gravity = 17;
        this.O00000o.addView(this.O00000Oo, layoutParams7);
        this.O00000Oo.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.O00000o, layoutParams8);
        this.O00000o.setVisibility(8);
        this.webView.setWebChromeClient(new MyChromeClient(this, (byte) 0));
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.sina.weibo.sdk.web.WeiboSdkWebActivity.AnonymousClass3 */

            public final void onClick(View view) {
                WeiboSdkWebActivity weiboSdkWebActivity = WeiboSdkWebActivity.this;
                weiboSdkWebActivity.pageStatus = 0;
                weiboSdkWebActivity.showDefaultPage();
                WeiboSdkWebActivity.this.webView.reload();
            }
        });
        this.O00000o0.setText(dbv.O000000o("A network error occurs, please tap the button to reload", "网络出错啦，请点击按钮重新加载", "網路出錯啦，請點擊按鈕重新載入"));
        this.O00000Oo.setText(dbv.O000000o("channel_data_error", "重新加载", "重新載入"));
        setContentView(relativeLayout);
        dbt.O00000Oo("Share", "WebActivity.initLoad().start");
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int i = extras.getInt("type", -1);
        if (i == -1) {
            finish();
            return;
        }
        if (i == 0) {
            this.baseParam = new dcj();
            this.webViewClient = new dcf(this, this.baseParam);
        } else if (i == 1) {
            this.baseParam = new ShareWebViewRequestParam(this);
            this.webViewClient = new dcg(this, this, this.baseParam);
        } else if (i == 2) {
            this.baseParam = new dch();
            this.webViewClient = new dcd(this, this, this.baseParam);
        }
        this.webView.setWebViewClient(this.webViewClient);
        this.baseParam.O00000o(extras);
        if (!TextUtils.isEmpty(this.baseParam.f14467O000000o.specifyTitle)) {
            this.titleText.setText(this.baseParam.f14467O000000o.specifyTitle);
        }
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setSavePassword(false);
        WebSettings settings = this.webView.getSettings();
        this.baseParam.f14467O000000o.authInfo.getAppKey();
        settings.setUserAgentString(Build.MANUFACTURER + "-" + Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + "weibosdk" + "_" + "0041005000" + "_android");
        this.webView.requestFocus();
        this.webView.setScrollBarStyle(0);
        removeJavascriptInterface(this.webView, "searchBoxJavaBridge_");
        removeJavascriptInterface(this.webView, "accessibility");
        removeJavascriptInterface(this.webView, "accessibilityTraversal");
        if (Build.VERSION.SDK_INT >= 21) {
            this.webView.getSettings().setMixedContentMode(2);
        }
        if (this.baseParam.O000000o()) {
            this.baseParam.O000000o(new dci.O000000o() {
                /* class com.sina.weibo.sdk.web.WeiboSdkWebActivity.AnonymousClass1 */

                public final void O000000o() {
                    dbt.O00000Oo("Share", "WebActivity.sharePic.onComplete()");
                    WeiboSdkWebActivity weiboSdkWebActivity = WeiboSdkWebActivity.this;
                    if (weiboSdkWebActivity.checkRequestUrl(weiboSdkWebActivity.baseParam.O00000Oo())) {
                        WeiboSdkWebActivity.this.webView.loadUrl(WeiboSdkWebActivity.this.baseParam.O00000Oo());
                    }
                }

                public final void O00000Oo() {
                    dbt.O00000Oo("Share", "WebActivity.sharePic.onException()");
                    WeiboSdkWebActivity.this.webViewClient.O000000o(WeiboSdkWebActivity.this, "pic upload error");
                    WeiboSdkWebActivity.this.finish();
                }
            });
        } else {
            String O00000Oo2 = this.baseParam.O00000Oo();
            if (checkRequestUrl(O00000Oo2)) {
                this.webView.loadUrl(O00000Oo2);
            }
        }
        dbt.O00000Oo("Share", "WebActivity.initLoad().end");
    }

    public boolean checkRequestUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("https://service.weibo.com/share/mobilesdk.php") || str.startsWith("https://open.weibo.cn/oauth2/authorize?");
        }
        return false;
    }

    public static void removeJavascriptInterface(WebView webView2, String str) {
        try {
            WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeActivity() {
        finish();
    }

    class MyChromeClient extends WebChromeClient {
        private MyChromeClient() {
        }

        /* synthetic */ MyChromeClient(WeiboSdkWebActivity weiboSdkWebActivity, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            WeiboSdkWebActivity.this.loadingBar.drawProgress(i);
            if (i == 100) {
                WeiboSdkWebActivity.this.loadingBar.setVisibility(4);
            } else {
                WeiboSdkWebActivity.this.loadingBar.setVisibility(0);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(WeiboSdkWebActivity.this.baseParam.f14467O000000o.specifyTitle)) {
                WeiboSdkWebActivity.this.titleText.setText(str);
            }
        }
    }

    public void showDefaultPage() {
        this.O00000o.setVisibility(8);
        this.webView.setVisibility(0);
    }

    public void onPageFinishedCallBack(WebView webView2, String str) {
        if (this.pageStatus == -1) {
            this.O00000o.setVisibility(0);
            this.webView.setVisibility(8);
            return;
        }
        showDefaultPage();
    }

    public void onReceivedErrorCallBack(WebView webView2, int i, String str, String str2) {
        String url = webView2.getUrl();
        try {
            if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(str2)) {
                Uri parse = Uri.parse(url);
                Uri parse2 = Uri.parse(str2);
                if (parse.getHost().equals(parse2.getHost()) && parse.getScheme().equals(parse2.getScheme())) {
                    this.pageStatus = -1;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onReceivedSslErrorCallBack(WebView webView2, final SslErrorHandler sslErrorHandler, SslError sslError) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("你访问的连接可能存在隐患，是否继续访问");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            /* class com.sina.weibo.sdk.web.WeiboSdkWebActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            /* class com.sina.weibo.sdk.web.WeiboSdkWebActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
            }
        });
        builder.create().show();
    }

    public void closePage() {
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.webViewClient.O00000Oo()) {
                return true;
            }
            if (this.webView.canGoBack()) {
                this.webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}

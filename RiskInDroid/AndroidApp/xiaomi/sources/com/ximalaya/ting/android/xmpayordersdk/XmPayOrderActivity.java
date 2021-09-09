package com.ximalaya.ting.android.xmpayordersdk;

import _m_j.iik;
import _m_j.iil;
import _m_j.iim;
import _m_j.iit;
import _m_j.iiw;
import _m_j.iju;
import _m_j.ilp;
import _m_j.imy;
import _m_j.imz;
import _m_j.ina;
import _m_j.inb;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.view.LoadingBar;
import java.util.ArrayList;
import java.util.HashMap;

public class XmPayOrderActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f12238O000000o;
    private Button O00000Oo;
    private WebView O00000o;
    private TextView O00000o0;
    private LinearLayout O00000oO;
    private String O00000oo;
    private String O0000O0o;
    public boolean isErrorPage;
    public boolean isLoading;
    public imy listener;
    public String mHtmlTitle;
    public LoadingBar mProgressBar;
    public String mUrl = "";
    public String orderNoByService;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        ina.O00000Oo = this;
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
        requestWindowFeature(1);
        this.mUrl = getIntent().getStringExtra("ORDER_URL");
        this.O0000O0o = getIntent().getStringExtra("ORDER_NUM");
        this.orderNoByService = getIntent().getStringExtra("PAY_ORDER_NO");
        ArrayList<String> O00000oO2 = ilp.O000000o(this).O00000oO("PAY_ORDER_NO");
        O00000oO2.add(this.orderNoByService);
        ilp.O000000o(this).O000000o("share_pay_order_no", O00000oO2);
        inb O000000o2 = inb.O000000o();
        this.listener = O000000o2.f1491O000000o.get(this.O0000O0o);
        if (TextUtils.isEmpty(this.mUrl) || TextUtils.isEmpty(this.O0000O0o) || this.listener == null) {
            finish();
            return;
        }
        this.O00000oo = "确认订单";
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(this);
        if (Build.VERSION.SDK_INT < 17) {
            i = iim.O000000o();
        } else {
            i = View.generateViewId();
        }
        linearLayout.setId(i);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, iil.O000000o(this, 50)));
        this.f12238O000000o = new TextView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = iil.O000000o(this, 10);
        layoutParams.rightMargin = iil.O000000o(this, 10);
        this.f12238O000000o.setLayoutParams(layoutParams);
        this.f12238O000000o.setClickable(true);
        this.f12238O000000o.setText("关闭");
        this.f12238O000000o.setTextSize(2, 17.0f);
        this.f12238O000000o.setTextColor(iil.O000000o());
        this.O00000o0 = new TextView(this);
        this.O00000o0.setTextSize(2, 18.0f);
        this.O00000o0.setTextColor(-13421773);
        this.O00000o0.setEllipsize(TextUtils.TruncateAt.END);
        this.O00000o0.setSingleLine(true);
        this.O00000o0.setGravity(17);
        this.O00000o0.setMaxWidth(iil.O000000o(this, 160));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.O00000o0.setLayoutParams(layoutParams2);
        View view = new View(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, iil.O000000o(this, 1));
        layoutParams3.addRule(12);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(-1513240);
        relativeLayout2.addView(this.f12238O000000o);
        relativeLayout2.addView(this.O00000o0);
        relativeLayout2.addView(view);
        this.mProgressBar = new LoadingBar(this);
        this.mProgressBar.setBackgroundColor(0);
        this.mProgressBar.a(0);
        this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, iil.O000000o(this, 3)));
        linearLayout.addView(relativeLayout2);
        linearLayout.addView(this.mProgressBar);
        this.O00000o = new WebView(this);
        this.O00000o.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, i);
        this.O00000o.setLayoutParams(layoutParams4);
        this.O00000oO = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, i);
        this.O00000oO.setLayoutParams(layoutParams5);
        this.O00000oO.setVisibility(8);
        this.O00000oO.setGravity(17);
        this.O00000oO.setOrientation(1);
        this.O00000oO.setBackgroundColor(-657931);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(iil.O000000o(this, "xmly_auth_sdk_empty_failed.png"));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        int O000000o3 = iil.O000000o(this, 8);
        layoutParams6.bottomMargin = O000000o3;
        layoutParams6.rightMargin = O000000o3;
        layoutParams6.topMargin = O000000o3;
        layoutParams6.leftMargin = O000000o3;
        imageView.setLayoutParams(layoutParams6);
        this.O00000oO.addView(imageView);
        this.O00000Oo = new Button(this);
        this.O00000Oo.setGravity(17);
        this.O00000Oo.setTextColor(-6710887);
        this.O00000Oo.setTextSize(2, 16.0f);
        this.O00000Oo.setText("重新加载");
        this.O00000Oo.setBackgroundDrawable(iil.O000000o(this, "xmly_auth_sdk_common_button_alpha.9.png", "xmly_auth_sdk_common_button_alpha_highlighted.9.png"));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(iil.O000000o(this, 142), iil.O000000o(this, 46));
        layoutParams7.topMargin = iil.O000000o(this, 10);
        this.O00000Oo.setLayoutParams(layoutParams7);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.ximalaya.ting.android.xmpayordersdk.XmPayOrderActivity.AnonymousClass1 */

            public final void onClick(View view) {
                XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
                xmPayOrderActivity.openUrl(xmPayOrderActivity.mUrl);
                XmPayOrderActivity.this.isErrorPage = false;
            }
        });
        this.O00000oO.addView(this.O00000Oo);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.O00000o);
        relativeLayout.addView(this.O00000oO);
        setContentView(relativeLayout);
        this.O00000o0.setText(this.O00000oo);
        this.f12238O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.ximalaya.ting.android.xmpayordersdk.XmPayOrderActivity.AnonymousClass2 */

            public final void onClick(View view) {
                XmPayOrderActivity.this.showDialogToUse();
            }
        });
        if (iik.O000000o(this)) {
            this.O00000o.setVisibility(0);
            this.O00000oO.setVisibility(8);
        } else {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(0);
        }
        this.O00000o.getSettings().setJavaScriptEnabled(true);
        this.O00000o.getSettings().setSavePassword(false);
        this.O00000o.setWebViewClient(new O000000o(this, (byte) 0));
        this.O00000o.setWebChromeClient(new b(this, (byte) 0));
        this.O00000o.requestFocus();
        this.O00000o.setScrollBarStyle(0);
        openUrl(this.mUrl);
    }

    public void showDialogToUse() {
        new AlertDialog.Builder(this).setMessage("确定取消购买?").setNegativeButton("确定", new DialogInterface.OnClickListener() {
            /* class com.ximalaya.ting.android.xmpayordersdk.XmPayOrderActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (XmPayOrderActivity.this.listener != null) {
                    imz.O000000o(2);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("xima_order_no", XmPayOrderActivity.this.orderNoByService);
                iit.O0000o0O(hashMap, new iiw<iju>() {
                    /* class com.ximalaya.ting.android.xmpayordersdk.XmPayOrderActivity.AnonymousClass3.AnonymousClass1 */

                    public final void O000000o(int i, String str) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        ina.O000000o(XmPayOrderActivity.this, XmPayOrderActivity.this.orderNoByService);
                    }
                });
                XmPayOrderActivity.this.finish();
            }
        }).setNeutralButton("取消", (DialogInterface.OnClickListener) null).create().show();
    }

    public void openUrl(String str) {
        this.O00000o.loadUrl(str);
    }

    class O000000o extends WebViewClient {
        private O000000o() {
        }

        /* synthetic */ O000000o(XmPayOrderActivity xmPayOrderActivity, byte b) {
            this();
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse.getQueryParameterNames().contains("openPaySdkCode")) {
                    int i = 500;
                    try {
                        i = Integer.valueOf(parse.getQueryParameter("openPaySdkCode")).intValue();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (i == 200) {
                        XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
                        ina.O000000o(xmPayOrderActivity, xmPayOrderActivity.orderNoByService);
                    }
                    imz.O000000o(i);
                    XmPayOrderActivity.this.finish();
                    return false;
                }
                try {
                    if (str.startsWith("alipays://platformapi")) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        XmPayOrderActivity.this.startActivity(intent);
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
            xmPayOrderActivity.mUrl = str;
            if (!xmPayOrderActivity.isXmlyCustomScheme(str)) {
                XmPayOrderActivity.this.mHtmlTitle = "";
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            if (XmPayOrderActivity.this.isErrorPage) {
                XmPayOrderActivity.this.promptError();
            } else {
                XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
                xmPayOrderActivity.isErrorPage = false;
                xmPayOrderActivity.hiddenErrorPrompt();
            }
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            XmPayOrderActivity.this.handleReceivedError(webView, i, str, str2);
        }
    }

    class b extends WebChromeClient {
        /* synthetic */ b(XmPayOrderActivity xmPayOrderActivity, byte b) {
            this();
        }

        private b() {
        }

        public final void onProgressChanged(WebView webView, int i) {
            XmPayOrderActivity.this.mProgressBar.setVisibility(0);
            XmPayOrderActivity.this.mProgressBar.a(i * 100);
            if (i == 100) {
                XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
                xmPayOrderActivity.isLoading = false;
                xmPayOrderActivity.O000000o();
            } else if (!XmPayOrderActivity.this.isLoading) {
                XmPayOrderActivity xmPayOrderActivity2 = XmPayOrderActivity.this;
                xmPayOrderActivity2.isLoading = true;
                xmPayOrderActivity2.O000000o();
            }
        }

        public final void onReceivedTitle(WebView webView, String str) {
            XmPayOrderActivity xmPayOrderActivity = XmPayOrderActivity.this;
            if (!xmPayOrderActivity.isXmlyCustomScheme(xmPayOrderActivity.mUrl)) {
                XmPayOrderActivity xmPayOrderActivity2 = XmPayOrderActivity.this;
                xmPayOrderActivity2.mHtmlTitle = str;
                xmPayOrderActivity2.updateTitleName();
            }
        }
    }

    public boolean isXmlyCustomScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "xmly".equalsIgnoreCase(Uri.parse(str).getAuthority());
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        if (this.isLoading) {
            this.O00000o0.setText("加载中....");
            this.mProgressBar.setVisibility(0);
            return;
        }
        updateTitleName();
        this.mProgressBar.setVisibility(8);
    }

    public void handleReceivedError(WebView webView, int i, String str, String str2) {
        if (!str2.startsWith("xmly")) {
            this.isErrorPage = true;
            promptError();
        }
    }

    public void promptError() {
        this.O00000oO.setVisibility(0);
        this.O00000o.setVisibility(8);
    }

    public void hiddenErrorPrompt() {
        this.O00000oO.setVisibility(8);
        this.O00000o.setVisibility(0);
    }

    public void updateTitleName() {
        String str;
        if (!TextUtils.isEmpty(this.mHtmlTitle)) {
            str = this.mHtmlTitle;
        } else {
            str = !TextUtils.isEmpty(this.O00000oo) ? this.O00000oo : "";
        }
        this.O00000o0.setText(str);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        WebView webView = this.O00000o;
        if (webView == null || !webView.canGoBack()) {
            showDialogToUse();
            return true;
        }
        this.O00000o.goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ina.O00000Oo = null;
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (ina.O00000o0 != null) {
            ina.O000000o o000000o = ina.O00000o0;
        }
    }
}

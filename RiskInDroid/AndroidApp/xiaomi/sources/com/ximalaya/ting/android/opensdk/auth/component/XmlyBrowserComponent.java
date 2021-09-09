package com.ximalaya.ting.android.opensdk.auth.component;

import _m_j.ihx;
import _m_j.ihy;
import _m_j.ihz;
import _m_j.iia;
import _m_j.iib;
import _m_j.iic;
import _m_j.iie;
import _m_j.iif;
import _m_j.iig;
import _m_j.iih;
import _m_j.iii;
import _m_j.iik;
import _m_j.iil;
import _m_j.iim;
import _m_j.iin;
import _m_j.iiw;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyAuthException;
import com.ximalaya.ting.android.opensdk.auth.view.LoadingBar;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class XmlyBrowserComponent extends Activity implements iia {
    public static final String TAG = "XmlyBrowserComponent";
    public static ihx mSimpleLogin;

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f12151O000000o;
    private ImageView O00000Oo;
    private TextView O00000o;
    private Button O00000o0;
    private LinearLayout O00000oO;
    private iic O00000oo;
    private String O0000O0o = "";
    public boolean isErrorPage;
    public boolean isLoading;
    public iif mAuthInfo;
    public ihy mAuthListener;
    public String mAuthListenerKey;
    public String mHtmlTitle;
    public String mObtainAuthType = "";
    public LoadingBar mProgressBar;
    public d mRequestParam;
    public String mUrl = "";
    public WebView mWebView;

    public static void closeBrowser(Activity activity, String str) {
        iib O000000o2 = iib.O000000o(activity.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            O000000o2.O00000Oo(str);
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        boolean z = true;
        requestWindowFeature(1);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mAuthInfo = iif.O000000o(this, extras.getBundle("key_auth_info"));
        }
        iif iif = this.mAuthInfo;
        if (iif == null) {
            this.mAuthInfo = new iif(this, "", "", "");
        } else {
            this.mObtainAuthType = iif.O0000O0o;
        }
        c cVar = new c(this);
        cVar.O00000Oo(extras);
        this.mAuthListener = cVar.O00000Oo;
        this.mAuthListenerKey = cVar.O00000o0;
        this.O00000oo = new ihz(this, cVar);
        this.O00000oo.O000000o(this);
        this.mRequestParam = cVar;
        d dVar = this.mRequestParam;
        if (dVar != null) {
            this.mUrl = dVar.O000000o();
            this.O0000O0o = this.mRequestParam.O00000Oo();
        } else {
            String string = extras.getString("key_url");
            String string2 = extras.getString("key_specify_title");
            if (!TextUtils.isEmpty(string) && string.startsWith("http")) {
                this.mUrl = string;
                this.O0000O0o = string2;
            }
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            z = false;
        } else {
            String str = TAG;
            iii.O000000o(str, "LOAD URL : " + this.mUrl);
        }
        if (!z) {
            finish();
        } else {
            O00000Oo();
            O00000oO();
            openUrl(this.mUrl);
        }
        O00000Oo();
        O00000oO();
        openUrl(this.mUrl);
    }

    private void O00000Oo() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(this);
        int O00000o2 = O00000o();
        linearLayout.setId(O00000o2);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, iil.O000000o(this, 50)));
        this.f12151O000000o = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = iil.O000000o(this, 10);
        layoutParams.rightMargin = iil.O000000o(this, 10);
        this.f12151O000000o.setLayoutParams(layoutParams);
        this.f12151O000000o.setClickable(true);
        this.f12151O000000o.setImageDrawable(iil.O000000o(this, "xmly_auth_sdk_back.png"));
        this.O00000Oo = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = iil.O000000o(this, 45);
        layoutParams2.rightMargin = iil.O000000o(this, 10);
        this.O00000Oo.setLayoutParams(layoutParams2);
        this.O00000Oo.setClickable(true);
        this.O00000Oo.setImageDrawable(iil.O000000o(this, "xmly_auth_sdk_close.png"));
        this.O00000Oo.setVisibility(8);
        this.O00000o = new TextView(this);
        this.O00000o.setTextSize(2, 18.0f);
        this.O00000o.setTextColor(-13421773);
        this.O00000o.setEllipsize(TextUtils.TruncateAt.END);
        this.O00000o.setSingleLine(true);
        this.O00000o.setGravity(17);
        this.O00000o.setMaxWidth(iil.O000000o(this, 160));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.O00000o.setLayoutParams(layoutParams3);
        View view = new View(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, iil.O000000o(this, 1));
        layoutParams4.addRule(12);
        view.setLayoutParams(layoutParams4);
        view.setBackgroundColor(-1513240);
        relativeLayout2.addView(this.f12151O000000o);
        relativeLayout2.addView(this.O00000Oo);
        relativeLayout2.addView(this.O00000o);
        relativeLayout2.addView(view);
        this.mProgressBar = new LoadingBar(this);
        this.mProgressBar.setBackgroundColor(0);
        this.mProgressBar.a(0);
        this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, iil.O000000o(this, 3)));
        linearLayout.addView(relativeLayout2);
        linearLayout.addView(this.mProgressBar);
        this.mWebView = new WebView(this);
        this.mWebView.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, O00000o2);
        this.mWebView.setLayoutParams(layoutParams5);
        this.O00000oO = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(3, O00000o2);
        this.O00000oO.setLayoutParams(layoutParams6);
        this.O00000oO.setVisibility(8);
        this.O00000oO.setGravity(17);
        this.O00000oO.setOrientation(1);
        this.O00000oO.setBackgroundColor(-657931);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(iil.O000000o(this, "xmly_auth_sdk_empty_failed.png"));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        int O000000o2 = iil.O000000o(this, 8);
        layoutParams7.bottomMargin = O000000o2;
        layoutParams7.rightMargin = O000000o2;
        layoutParams7.topMargin = O000000o2;
        layoutParams7.leftMargin = O000000o2;
        imageView.setLayoutParams(layoutParams7);
        this.O00000oO.addView(imageView);
        this.O00000o0 = new Button(this);
        this.O00000o0.setGravity(17);
        this.O00000o0.setTextColor(-6710887);
        this.O00000o0.setTextSize(2, 16.0f);
        this.O00000o0.setText("重新加载");
        this.O00000o0.setBackgroundDrawable(iil.O000000o(this, "xmly_auth_sdk_common_button_alpha.9.png", "xmly_auth_sdk_common_button_alpha_highlighted.9.png"));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(iil.O000000o(this, 142), iil.O000000o(this, 46));
        layoutParams8.topMargin = iil.O000000o(this, 10);
        this.O00000o0.setLayoutParams(layoutParams8);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass1 */

            public final void onClick(View view) {
                XmlyBrowserComponent xmlyBrowserComponent = XmlyBrowserComponent.this;
                xmlyBrowserComponent.openUrl(xmlyBrowserComponent.mUrl);
                XmlyBrowserComponent.this.isErrorPage = false;
            }
        });
        this.O00000oO.addView(this.O00000o0);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.mWebView);
        relativeLayout.addView(this.O00000oO);
        setContentView(relativeLayout);
        O00000o0();
        if (iik.O000000o(this)) {
            this.mWebView.setVisibility(0);
            this.O00000oO.setVisibility(8);
            return;
        }
        this.mWebView.setVisibility(8);
        this.O00000oO.setVisibility(0);
    }

    private void O00000o0() {
        this.O00000o.setText(this.O0000O0o);
        this.f12151O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass2 */

            public final void onClick(View view) {
                if (XmlyBrowserComponent.this.mWebView == null || !XmlyBrowserComponent.this.mWebView.canGoBack()) {
                    if (XmlyBrowserComponent.this.mRequestParam != null) {
                        XmlyBrowserComponent.this.mRequestParam.O000000o(XmlyBrowserComponent.this);
                    }
                    XmlyBrowserComponent.this.finish();
                    return;
                }
                XmlyBrowserComponent.this.mWebView.goBack();
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass3 */

            public final void onClick(View view) {
                if (XmlyBrowserComponent.this.mRequestParam != null) {
                    XmlyBrowserComponent.this.mRequestParam.O000000o(XmlyBrowserComponent.this);
                }
                XmlyBrowserComponent.this.finish();
            }
        });
    }

    private static int O00000o() {
        if (Build.VERSION.SDK_INT < 17) {
            return iim.O000000o();
        }
        return View.generateViewId();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void O00000oO() {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.addJavascriptInterface(new O000000o(), "jscall");
        this.mWebView.getSettings().setSavePassword(false);
        this.mWebView.setWebViewClient(this.O00000oo);
        this.mWebView.setWebChromeClient(new b(this, (byte) 0));
        this.mWebView.requestFocus();
        this.mWebView.setScrollBarStyle(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            O000000o(this.mWebView);
        }
    }

    public void openUrl(String str) {
        this.mWebView.loadUrl(str);
    }

    private static void O000000o(WebView webView) {
        if (Build.VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception e) {
                iii.O00000o0(TAG, e.toString());
            }
        }
    }

    public void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap) {
        iii.O000000o(TAG, "onPageStarted URL: ".concat(String.valueOf(str)));
        this.mUrl = str;
        if (!isXmlyCustomScheme(str)) {
            this.mHtmlTitle = "";
        }
    }

    public boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str) {
        iii.O00000Oo(TAG, "shouldOverrideUrlLoading URL: ".concat(String.valueOf(str)));
        return false;
    }

    public void onPageFinishedCallBack(WebView webView, String str) {
        if (!(webView == null || this.O00000Oo == null)) {
            if (webView.canGoBack()) {
                this.O00000Oo.setVisibility(0);
            } else {
                this.O00000Oo.setVisibility(8);
            }
        }
        iii.O000000o(TAG, "onPageFinished URL: ".concat(String.valueOf(str)));
        if (this.isErrorPage) {
            O00000oo();
        } else {
            this.isErrorPage = false;
            this.O00000oO.setVisibility(8);
            this.mWebView.setVisibility(0);
        }
        this.mWebView.loadUrl("javascript:window.jscall.handleErrorInfo(document.getElementsByTagName('body')[0].innerText);");
    }

    public void onReceivedErrorCallBack(WebView webView, int i, String str, String str2) {
        String str3 = TAG;
        iii.O000000o(str3, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
        if (!str2.startsWith("xmly")) {
            this.isErrorPage = true;
            O00000oo();
        }
    }

    public void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        iii.O000000o(TAG, "onReceivedSslErrorCallBack.........");
    }

    class b extends WebChromeClient {
        /* synthetic */ b(XmlyBrowserComponent xmlyBrowserComponent, byte b) {
            this();
        }

        private b() {
        }

        public final void onProgressChanged(WebView webView, int i) {
            XmlyBrowserComponent.this.mProgressBar.setVisibility(0);
            XmlyBrowserComponent.this.mProgressBar.a(i * 100);
            if (i == 100) {
                XmlyBrowserComponent xmlyBrowserComponent = XmlyBrowserComponent.this;
                xmlyBrowserComponent.isLoading = false;
                xmlyBrowserComponent.O000000o();
            } else if (!XmlyBrowserComponent.this.isLoading) {
                XmlyBrowserComponent xmlyBrowserComponent2 = XmlyBrowserComponent.this;
                xmlyBrowserComponent2.isLoading = true;
                xmlyBrowserComponent2.O000000o();
            }
        }

        public final void onReceivedTitle(WebView webView, String str) {
            XmlyBrowserComponent xmlyBrowserComponent = XmlyBrowserComponent.this;
            if (!xmlyBrowserComponent.isXmlyCustomScheme(xmlyBrowserComponent.mUrl)) {
                XmlyBrowserComponent xmlyBrowserComponent2 = XmlyBrowserComponent.this;
                xmlyBrowserComponent2.mHtmlTitle = str;
                xmlyBrowserComponent2.updateTitleName();
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
            setViewLoading();
            return;
        }
        updateTitleName();
        this.mProgressBar.setVisibility(8);
    }

    private void O00000oo() {
        this.O00000oO.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void setViewLoading() {
        this.O00000o.setText("加载中....");
        this.mProgressBar.setVisibility(0);
    }

    public void updateTitleName() {
        String str;
        if (!TextUtils.isEmpty(this.mHtmlTitle)) {
            str = this.mHtmlTitle;
        } else {
            str = !TextUtils.isEmpty(this.O0000O0o) ? this.O0000O0o : "";
        }
        this.O00000o.setText(str);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        d dVar = this.mRequestParam;
        if (dVar != null) {
            dVar.O000000o(this);
        }
        finish();
        return true;
    }

    final class O000000o {
        O000000o() {
        }

        @JavascriptInterface
        public final void handleErrorInfo(String str) {
            iig O000000o2;
            if (!TextUtils.isEmpty(str) && (O000000o2 = iig.O000000o(str.trim())) != null) {
                if (XmlyBrowserComponent.this.mAuthListener != null) {
                    new XmlyAuthException(O000000o2.f1314O000000o, O000000o2.O00000Oo, O000000o2.O00000o0);
                }
                iii.O000000o(XmlyBrowserComponent.TAG, "Failed to receive access token by Web");
                XmlyBrowserComponent xmlyBrowserComponent = XmlyBrowserComponent.this;
                XmlyBrowserComponent.closeBrowser(xmlyBrowserComponent, xmlyBrowserComponent.mAuthListenerKey);
            }
        }

        @JavascriptInterface
        public final void authorize(String str) {
            String str2;
            if (XmlyBrowserComponent.this.mProgressBar.getVisibility() != 0) {
                XmlyBrowserComponent.this.runOnUiThread(new Runnable() {
                    /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.O000000o.AnonymousClass1 */

                    public final void run() {
                        XmlyBrowserComponent.this.setViewLoading();
                        XmlyBrowserComponent.this.mProgressBar.a(99);
                    }
                });
                String str3 = "";
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        str2 = jSONObject.optString("ssoCode");
                        try {
                            str3 = jSONObject.optString("scope");
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            XmlyBrowserComponent.this.startAuth(str2, str3);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        str2 = str3;
                        e.printStackTrace();
                        XmlyBrowserComponent.this.startAuth(str2, str3);
                    }
                } else {
                    str2 = str3;
                }
                XmlyBrowserComponent.this.startAuth(str2, str3);
            }
        }
    }

    public void startAuth(final String str, String str2) {
        if (mSimpleLogin != null) {
            new HashMap<String, String>() {
                /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass4 */

                {
                    put("sso_code", str);
                    put("redirect_uri", XmlyBrowserComponent.this.mAuthInfo.O00000Oo);
                }
            };
            new iiw<String>() {
                /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    XmlyBrowserComponent.this.authorizeCodeSuccessfully(iin.O000000o((String) obj));
                }

                public final void O000000o(int i, String str) {
                    PrintStream printStream = System.out;
                    printStream.println("XmlyBrowserComponent.onError  " + i + "   " + str);
                }
            };
            return;
        }
        OkHttpClient build = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build();
        FormBody formBody = null;
        try {
            FormBody.Builder builder = new FormBody.Builder();
            if (!TextUtils.isEmpty(this.mAuthInfo.f1313O000000o)) {
                builder.add("client_id", this.mAuthInfo.f1313O000000o);
            }
            builder.add("response_type", "code");
            if (!TextUtils.isEmpty(this.mAuthInfo.O00000Oo)) {
                builder.addEncoded("redirect_uri", URLEncoder.encode(this.mAuthInfo.O00000Oo, "UTF-8"));
            }
            if (!TextUtils.isEmpty(str)) {
                builder.add("sso_code", str);
            }
            if (!TextUtils.isEmpty(this.mAuthInfo.O00000o)) {
                builder.add("device_id", this.mAuthInfo.O00000o);
            }
            builder.add("client_os_type", "2");
            if (!TextUtils.isEmpty(this.mAuthInfo.O00000oO)) {
                builder.add("pack_id", this.mAuthInfo.O00000oO);
            }
            if (!TextUtils.isEmpty(this.mAuthInfo.O00000o0)) {
                builder.add("state", this.mAuthInfo.O00000o0);
            }
            if (!TextUtils.isEmpty(str2)) {
                builder.add("scope", str2);
            }
            formBody = builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
            str2 = str;
        }
        if (formBody != null) {
            String str3 = TAG;
            iii.O000000o(str3, "authorize, request: method = post, url = https://api.ximalaya.com/oauth2/v2/authorize?, body:client_id = " + this.mAuthInfo.f1313O000000o + ", response_type = code, redirect_uri = " + this.mAuthInfo.O00000Oo + ", sso_code = " + str + ", device_id = " + this.mAuthInfo.O00000o + ", client_os_type = " + this.mAuthInfo.O00000oo + ", pack_id = " + this.mAuthInfo.O00000oO + ", state = " + this.mAuthInfo.O00000o0 + ", scope = " + str2);
            build.newCall(new Request.Builder().url("https://api.ximalaya.com/oauth2/v2/authorize?").post(formBody).build()).enqueue(new Callback() {
                /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass6 */

                public final void onFailure(Call call, IOException iOException) {
                    XmlyBrowserComponent.this.handleErrorInfo(iOException.getMessage(), null);
                    iOException.printStackTrace();
                    String str = XmlyBrowserComponent.TAG;
                    iii.O000000o(str, "authorize, request failed, error message = " + iOException.getMessage());
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    String str;
                    int code = response.code();
                    String string = response.body().string();
                    if (code == 302) {
                        str = response.headers().get("Location");
                        if (!TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(XmlyBrowserComponent.this.mObtainAuthType) || !XmlyBrowserComponent.this.mObtainAuthType.equalsIgnoreCase("code")) {
                                XmlyBrowserComponent.this.redirectRequestAccessTokenInfo(str);
                            } else {
                                XmlyBrowserComponent.this.authorizeCodeSuccessfully(iin.O000000o(str));
                            }
                        }
                    } else {
                        XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                        str = "";
                    }
                    String str2 = XmlyBrowserComponent.TAG;
                    iii.O000000o(str2, "authorize, request success, status code = " + code + ", body = " + string + ", redirectUrl" + str);
                }
            });
        }
    }

    public void authorizeCodeSuccessfully(Bundle bundle) {
        closeBrowser(this, this.mAuthListenerKey);
    }

    public void redirectRequestAccessTokenInfo(final String str) {
        iii.O000000o(TAG, "redirectRequestAccessTokenInfo, request: method = get, url = ".concat(String.valueOf(str)));
        new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build().newCall(new Request.Builder().url(str).build()).enqueue(new Callback() {
            /* class com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent.AnonymousClass7 */

            public final void onFailure(Call call, IOException iOException) {
                XmlyBrowserComponent.this.handleErrorInfo(iOException.getMessage(), null);
                iOException.printStackTrace();
                String str = XmlyBrowserComponent.TAG;
                iii.O000000o(str, "redirectRequestAccessTokenInfo, request failed, error message = " + iOException.getMessage());
            }

            public final void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                String string = response.body().string();
                if (!response.isSuccessful()) {
                    XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                } else if (!TextUtils.isEmpty(string)) {
                    try {
                        int optInt = new JSONObject(string).optInt("expires_in", 0);
                        iie O000000o2 = iie.O000000o(string);
                        if (O000000o2 == null || !O000000o2.O000000o()) {
                            XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                        } else {
                            String str = XmlyBrowserComponent.TAG;
                            iii.O000000o(str, "Login Success! " + O000000o2.toString());
                            iih.O000000o(XmlyBrowserComponent.this);
                            iih.O000000o(XmlyBrowserComponent.this, O000000o2);
                            O000000o2.O00000o = (long) optInt;
                            if (XmlyBrowserComponent.this.mAuthListener != null) {
                                O000000o2.O00000Oo();
                            }
                            XmlyBrowserComponent.closeBrowser(XmlyBrowserComponent.this, XmlyBrowserComponent.this.mAuthListenerKey);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        XmlyBrowserComponent.this.handleErrorInfo(e.getMessage(), null);
                    }
                }
                String str2 = XmlyBrowserComponent.TAG;
                iii.O000000o(str2, "redirectRequestAccessTokenInfo, request success, status code = " + code + ", body = " + string + ", redirectUrl" + str);
            }
        });
    }

    public void handleErrorInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            iig O000000o2 = str2.indexOf("{") >= 0 ? iig.O000000o(str2) : null;
            if (O000000o2 != null) {
                new XmlyAuthException(O000000o2.f1314O000000o, O000000o2.O00000Oo, O000000o2.O00000o0);
            } else {
                new XmlyAuthException(str, str2, null);
            }
        } else {
            new XmlyAuthException(str, str2, null);
        }
        iii.O000000o(TAG, "Failed to receive access token by Web");
        closeBrowser(this, this.mAuthListenerKey);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
        super.onDestroy();
    }
}

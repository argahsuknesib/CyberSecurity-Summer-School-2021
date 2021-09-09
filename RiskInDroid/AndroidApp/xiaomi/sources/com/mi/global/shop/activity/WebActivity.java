package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.bzu;
import _m_j.bzy;
import _m_j.cad;
import _m_j.cav;
import _m_j.caw;
import _m_j.cbc;
import _m_j.cbd;
import _m_j.cbe;
import _m_j.cbl;
import _m_j.cbm;
import _m_j.cbv;
import _m_j.cbw;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.cec;
import _m_j.cem;
import _m_j.cpf;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.Sharer;
import com.facebook.share.widget.ShareDialog;
import com.google.android.exoplayer2.C;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.webview.BaseWebChromeClient;
import com.mi.global.shop.webview.WebViewHelper;
import com.mi.global.shop.widget.BaseWebView;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.dialog.CustomCloseDialog;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@Route(path = "/globalShop/webActivity")
public class WebActivity extends BaseActivity implements ccn.O000000o, View.OnClickListener, FacebookCallback<Sharer.Result> {
    public static String currentUrl = "";
    public static boolean needReload = false;

    /* renamed from: O000000o  reason: collision with root package name */
    protected ProgressBar f4717O000000o;
    private boolean O00000Oo = false;
    private DownloadManagerReceiver O00000o;
    private boolean O00000o0 = false;
    private String O00000oO;
    public CallbackManager callbackManager;
    public boolean clearHistory = false;
    public Boolean fromCart = Boolean.FALSE;
    public boolean isNetworkConnected = cbm.O00000Oo.O000000o(byl.O00000oO());
    public View mCloseBtn;
    public ImageView mImageView;
    public EmptyLoadingViewPlus mLoading;
    public View mRefreshBtn;
    public CommonButton mRetryBtn;
    public LinearLayout mRetryContainer;
    public CustomTextView mTextView;
    public FrameLayout mWebViewContainer;
    public String orderId;
    public ShareDialog shareDialog;
    public ValueCallback<Uri> uploadMessage;
    public ValueCallback<Uri[]> uploadMessageAboveL;
    public String urlPrefix;
    public BaseWebView webView;

    public boolean gotoRN(String str) {
        return false;
    }

    public void jumpToPayment(String str, String str2) {
    }

    public void onCancel() {
    }

    public void onCreate(Bundle bundle) {
        final String str;
        super.onCreate(bundle);
        try {
            O000000o((int) R.layout.shop_web_activity);
            Intent intent = getIntent();
            if (!(intent == null || intent.getExtras() == null)) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("url");
                if (gotoRN(string)) {
                    this.O00000o0 = true;
                    finish();
                }
                this.fromCart = Boolean.valueOf(extras.getBoolean("cart_webview", false));
                ccr.O00000Oo("WebActivity", "get url from bundle:".concat(String.valueOf(string)));
                try {
                    if (Uri.parse(string).getQueryParameter("needLocation").equals("1") && !TextUtils.isEmpty(cbc.O000000o())) {
                        string = string + "&location=" + cbc.O000000o();
                    }
                } catch (Exception unused) {
                }
                String O000000o2 = O000000o(string);
                if (O000000o2 != null) {
                    str = cav.O0000OOo(O000000o2);
                } else {
                    str = cav.O0000OOo(string);
                }
                ccr.O00000Oo("WebActivity", "processing url:".concat(String.valueOf(str)));
                this.mCartView.setOnClickListener(this);
                this.mBackView.setOnClickListener(this);
                this.mBackView.setVisibility(0);
                this.mCloseBtn = findViewById(R.id.title_bar_close_btn);
                this.mCloseBtn.setOnClickListener(this);
                this.mCloseBtn.setVisibility(0);
                this.mRefreshBtn = findViewById(R.id.title_bar_refresh_btn);
                this.mRefreshBtn.setOnClickListener(this);
                this.mRefreshBtn.setVisibility(0);
                this.f4717O000000o = (ProgressBar) findViewById(R.id.browser_progress_bar);
                this.mLoading = (EmptyLoadingViewPlus) findViewById(R.id.background_loading);
                this.mLoading.setVisibility(0);
                this.mLoading.O000000o(false);
                this.mWebViewContainer = (FrameLayout) findViewById(R.id.web_view_container);
                this.mRetryContainer = (LinearLayout) findViewById(R.id.retry_container);
                this.mTextView = (CustomTextView) findViewById(R.id.net_access_text);
                this.mImageView = (ImageView) findViewById(R.id.net_unaccess_img);
                this.mRetryBtn = (CommonButton) findViewById(R.id.retry_btn);
                this.mRetryBtn.setText((int) R.string.shop_retry);
                this.mRetryBtn.setOnClickListener(this);
                if (TextUtils.isEmpty(str) || ((!str.startsWith("http://sg.support.kefu.mi.com") && !str.startsWith("https://sg.support.kefu.mi.com")) || !ccn.O0000o00().O0000o0O() || !ccn.O0000o00().O00000o() || !TextUtils.isEmpty(ccn.O0000o00().O0000oo()))) {
                    initWebView(str);
                } else {
                    new AsyncTask<String, String, String>() {
                        /* class com.mi.global.shop.activity.WebActivity.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ void onPostExecute(Object obj) {
                            WebActivity.this.initWebView(str);
                        }
                    }.execute(new String[0]);
                }
            }
            try {
                FacebookSdk.sdkInitialize(getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.callbackManager = CallbackManager.Factory.create();
            this.shareDialog = new ShareDialog(this);
            this.shareDialog.registerCallback(this.callbackManager, this);
            ccr.O00000Oo("WebActivity", "on create end");
            if (getIntent().getStringExtra("debug_cookie") != null && TextUtils.isEmpty(getIntent().getStringExtra("debug_cookie"))) {
                setDebugCookies(getIntent().getStringExtra("debug_cookie"));
            }
            if (getIntent().getIntExtra("debug_model", 0) != 0 && Build.VERSION.SDK_INT >= 19 && this.webView != null) {
                BaseWebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Exception e2) {
            if (e2.getMessage() == null || !e2.getMessage().contains("MissingWebViewPackageException")) {
                cec.O000000o(this, getResources().getString(R.string.loading_error), 0);
            } else {
                cec.O000000o(this, getResources().getString(R.string.webview_tips_uploaing), 0);
            }
            finish();
        }
    }

    public void initWebView(String str) {
        this.webView = (BaseWebView) findViewById(R.id.browser);
        BaseWebView baseWebView = this.webView;
        if (baseWebView == null) {
            finish();
            return;
        }
        baseWebView.setWebViewClient(new O000000o(this, (byte) 0));
        this.webView.setWebChromeClient(new InnerWebChromeClient(this, (byte) 0));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setDownloadListener(new DownloadListener() {
            /* class com.mi.global.shop.activity.WebActivity.AnonymousClass2 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String str5;
                if (!cem.O000000o(WebActivity.this.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    cec.O000000o(WebActivity.this.getApplicationContext(), (int) R.string.storage_permission_error, 1);
                    return;
                }
                WebActivity.this.addDownloadListener();
                Context applicationContext = WebActivity.this.getApplicationContext();
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                String cookie = CookieManager.getInstance().getCookie(cav.O0000oO);
                ccn O0000o00 = ccn.O0000o00();
                if (O0000o00.O0000o0O()) {
                    O0000o00.O00000Oo();
                    caw.O000000o.O00000oO();
                    if (O0000o00.O000000o(caw.O000000o.O00000o0()) == null) {
                        str5 = null;
                    } else {
                        caw.O000000o.O00000oO();
                        str5 = O0000o00.O000000o(caw.O000000o.O00000o0()).authToken;
                    }
                    cookie = cbw.O000000o("serviceToken", str5, caw.O00000Oo.f13572O000000o, "/" + cav.O0000oo0, (String) null) + cookie;
                }
                cpf.O000000o((Object) cookie);
                request.addRequestHeader("Cookie", cookie);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                if (Build.VERSION.SDK_INT >= 16) {
                    request.setAllowedOverMetered(false);
                }
                request.setVisibleInDownloadsUi(true);
                request.setAllowedOverRoaming(true);
                request.setAllowedNetworkTypes(2);
                String guessFileName = URLUtil.guessFileName(str, str3, str4);
                cpf.O000000o((Object) "fileName:".concat(String.valueOf(guessFileName)));
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
                ((DownloadManager) applicationContext.getSystemService("download")).enqueue(request);
            }
        });
        if (Build.VERSION.SDK_INT >= 19 && byl.O0000O0o()) {
            BaseWebView.setWebContentsDebuggingEnabled(true);
        }
        enableHardAccelerateMode(str);
        WebViewHelper.O000000o(this.webView);
        WebViewHelper.f4936O000000o = str;
        if (str.contains(cav.O0000Oo0) || str.contains(cav.O0000Oo)) {
            str = cbl.O00000o(str);
        }
        setCookies(this);
        this.O00000oO = str;
        this.webView.loadUrl(cav.O0000Oo0(str));
        handleWebViewVisiable(true);
    }

    public void addDownloadListener() {
        if (this.O00000o == null) {
            this.O00000o = new DownloadManagerReceiver();
            registerReceiver(this.O00000o, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    public void enableHardAccelerateMode(String str) {
        if (!cav.O000000o(str)) {
            this.webView.setLayerType(1, null);
        }
        if (getIntent().getIntExtra("needPlayVideo", 0) == 1) {
            this.webView.setLayerType(2, null);
        }
        if (SyncModel.hardwareAccelerateModel) {
            this.webView.setLayerType(2, null);
            if (!TextUtils.isEmpty(str) && SyncModel.inSoftWareUrls != null) {
                for (String contains : SyncModel.inSoftWareUrls) {
                    if (str.contains(contains)) {
                        this.webView.setLayerType(1, null);
                        return;
                    }
                }
            }
        }
    }

    public void handleWebViewVisiable(boolean z) {
        if (z) {
            this.mWebViewContainer.setVisibility(0);
            this.mRetryContainer.setVisibility(8);
            return;
        }
        this.mWebViewContainer.setVisibility(8);
        this.mRetryContainer.setVisibility(0);
    }

    public void startCartActivity() {
        if (!cad.O00000o()) {
            this.mLoading.setVisibility(0);
            this.mLoading.O000000o(false);
            BaseWebView baseWebView = this.webView;
            if (baseWebView != null) {
                baseWebView.loadUrl(cav.O0000Oo0(cav.O000OOo()));
            }
        } else if (this.fromCart.booleanValue()) {
            setResult(-1);
            finish();
        } else {
            startActivityForResult(new Intent(this, ShoppingCartActivity.class), 22);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_cart_view) {
            cbe.O000000o("title_cart", getPageId());
            startCartActivity();
        } else if (view.getId() == R.id.title_bar_back) {
            cbe.O000000o("title_back", getPageId());
            onBackPressed();
        } else if (view.getId() == R.id.title_bar_close_btn) {
            cbe.O000000o("title_close", getPageId());
            finish();
        } else if (view.getId() == R.id.title_bar_refresh_btn) {
            cbe.O000000o("title_refresh", getPageId());
            handleWebViewVisiable(true);
            this.mLoading.setVisibility(0);
            this.mLoading.O000000o(false);
            this.webView.reload();
        } else if (view.getId() == R.id.retry_btn) {
            handleWebViewVisiable(true);
            ccr.O00000Oo("WebActivity", "webView reloading, lastUrl:" + this.webView.getLastUrl() + ",currentUrl:" + this.webView.getCurrentUrl());
            this.mLoading.setVisibility(0);
            this.mLoading.O000000o(false);
            this.webView.reload();
        }
    }

    public String getPageId() {
        String url = this.webView.getUrl();
        return TextUtils.isEmpty(url) ? currentUrl : url;
    }

    public void onLogin(String str, String str2, String str3) {
        ccr.O00000Oo("WebActivity", "on login success");
        super.onLogin(str, str2, str3);
        cbw.O000000o(this, str, str2);
        if (this.webView != null) {
            ccr.O00000Oo("WebActivity", "on login success reload:");
            this.webView.post(new Runnable() {
                /* class com.mi.global.shop.activity.WebActivity.AnonymousClass3 */

                public final void run() {
                    WebActivity.this.webView.reload();
                }
            });
        }
    }

    public void onUserInfoUpdate(String str, String str2, String str3, int i, String str4) {
        ccr.O00000Oo("WebActivity", String.format("BaseActivity-userinfoupdate:%s, %s, %s,%d", str, str2, str3, Integer.valueOf(i)));
        super.onUserInfoUpdate(str, str2, str3, i, str4);
        if (str4 != null && !str4.equals("")) {
            cbw.O000000o(this, str4);
        }
    }

    public void onLogout() {
        super.onLogout();
    }

    public void onResume() {
        super.onResume();
        ccr.O00000Oo("WebActivity", "on resume");
        BaseWebView baseWebView = this.webView;
        if (baseWebView != null) {
            baseWebView.onResume();
        }
        new SetCookiesTask(this).execute(new Void[0]);
    }

    public static void setCookies(Context context) {
        cbw.O000000o();
        cbw.O00000o(context);
        String O00000Oo2 = cbm.O00000o0.O00000Oo(context, "pref_key_zip_code", "");
        String O00000Oo3 = cbm.O00000o0.O00000Oo(context, "pref_key_city_name", "");
        String O00000Oo4 = cbm.O00000o0.O00000Oo(context, "pref_key_state_id", "");
        String O00000Oo5 = cbm.O00000o0.O00000Oo(context, "pref_key_warehouse_id", "");
        if (!TextUtils.isEmpty(O00000Oo3) && !TextUtils.isEmpty(O00000Oo4) && !TextUtils.isEmpty(O00000Oo5) && !TextUtils.isEmpty(O00000Oo2)) {
            String str = caw.O00000Oo.f13572O000000o;
            cbw.O000000o(context, "XM_pincode_in", O00000Oo2, str, "/" + cav.O0000oo0);
            String str2 = caw.O00000Oo.f13572O000000o;
            cbw.O000000o(context, "WH_cityName", O00000Oo3, str2, "/" + cav.O0000oo0);
            String str3 = caw.O00000Oo.f13572O000000o;
            cbw.O000000o(context, "WH_stateId", O00000Oo4, str3, "/" + cav.O0000oo0);
            String str4 = caw.O00000Oo.f13572O000000o;
            cbw.O000000o(context, "WH_warehouse", O00000Oo5, str4, "/" + cav.O0000oo0);
        }
        cbw.O00000o0(context);
        int i = BaseActivity.shoppingCartNum;
        if (i != -1) {
            String valueOf = String.valueOf(i);
            String str5 = caw.O00000Oo.f13572O000000o;
            cbw.O000000o(context, "xm_user_in_num", valueOf, str5, "/" + cav.O0000oo0);
        }
        String cookie = CookieManager.getInstance().getCookie(cav.O0000oO);
        if (cookie == null) {
            ccr.O00000Oo("WebViewCookieManager", "cookie is null");
        } else {
            ccr.O00000Oo("WebViewCookieManager", "all cookie:".concat(String.valueOf(cookie)));
        }
    }

    public void setDebugCookies(String str) {
        try {
            for (String str2 : str.split("#")) {
                cbw.O000000o(this, str2.split(":")[0], str2.split(":")[1], caw.O00000Oo.f13572O000000o, "/" + cav.O0000oo0);
            }
        } catch (Exception unused) {
            cec.O000000o(this, "invalid cookie", 3000);
        }
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            handleWebViewVisiable(true);
            this.webView.goBack();
            String currentTitle = this.webView.getCurrentTitle();
            if (currentTitle != null) {
                currentTitle = currentTitle.trim();
            }
            setTitle(currentTitle);
            updateCartBadgeViewVisble(currentTitle);
            return;
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ccr.O00000Oo("WebActivity", "onKeyDown keycoder:" + i + " Key Event:" + keyEvent.toString());
        return super.onKeyDown(i, keyEvent);
    }

    private String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            ccr.O00000Oo("WebActivity", "uberAppLink is empty");
            return null;
        }
        ccr.O00000Oo("WebActivity", "uberAppLink:".concat(String.valueOf(str)));
        if (str.trim().indexOf("uber://") == 0) {
            PackageManager packageManager = byl.O00000oO().getPackageManager();
            try {
                if (str.contains("&noapp=")) {
                    String substring = str.substring(str.indexOf("&noapp=") + 7);
                    str = str.replace("&noapp=" + substring, "");
                    ccr.O00000Oo("WebActivity", "uberAppLink get noappUrl:".concat(String.valueOf(URLDecoder.decode(substring, "utf-8"))));
                }
                ccr.O00000Oo("WebActivity", "uberAppLink get uberUrl:".concat(String.valueOf(str)));
                packageManager.getPackageInfo("com.ubercab", 1);
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                finish();
            } catch (Exception unused) {
                return "https://m.uber.com/";
            }
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    class O000000o extends cbv {
        private AppEventsLogger O00000Oo;
        private boolean O00000o0;

        private O000000o() {
            this.O00000o0 = true;
        }

        /* synthetic */ O000000o(WebActivity webActivity, byte b) {
            this();
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            ccr.O00000Oo("WebActivity", "Resource Request URL:".concat(String.valueOf(str)));
            if (str.contains("/cart/add/?id=")) {
                ccr.O00000Oo("WebActivity", "recordCartEvent : url".concat(String.valueOf(str)));
                if (str.contains("/cart/add/?id=") && str.contains("&")) {
                    if (this.O00000Oo == null) {
                        this.O00000Oo = AppEventsLogger.newLogger(WebActivity.this);
                    }
                    try {
                        String substring = str.substring(str.indexOf("/cart/add/?id=") + 14, str.indexOf(38));
                        Bundle bundle = new Bundle();
                        bundle.putString("fb_content_id", substring);
                        this.O00000Oo.logEvent("fb_mobile_add_to_cart", 1.0d, bundle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            WebActivity.this.loadExchangeCouponList(str);
            String[] O000000o2 = bzu.O000000o(str, !WebActivity.this.isNetworkConnected);
            if (O000000o2 != null) {
                return O000000o("WebActivity", webView, str, O000000o2);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean z;
            String O0000OOo = cav.O0000OOo(str);
            WebViewHelper.f4936O000000o = str;
            ccr.O00000Oo("WebActivity", "shouldOverrideUrlLoading newUrl:".concat(String.valueOf(O0000OOo)));
            if (O0000OOo != null && O0000OOo.startsWith("intent://view/pmobpay")) {
                return true;
            }
            if (cad.O0000OoO() && Build.VERSION.SDK_INT >= 26 && O0000OOo != null && O0000OOo.startsWith("https://payments353.paysecure.ru/")) {
                return false;
            }
            if (cad.O0000o0() && O0000OOo != null && O0000OOo.startsWith("https://payments.worldpay.com/app/hpp/integration/wpg/corporate")) {
                return false;
            }
            try {
                z = Uri.parse(str).getQueryParameter("needClose").equals("1");
            } catch (Exception unused) {
                z = false;
            }
            if (O000000o(WebActivity.this, str) || WebActivity.this.gotoRN(str)) {
                return true;
            }
            if (!cad.O00000o() || !cav.O00000oo(str).booleanValue()) {
                if (!TextUtils.isEmpty(str) && str.contains("/in/user/orderview?order_id=")) {
                    String substring = str.substring(str.indexOf("/in/user/orderview?order_id=") + 28);
                    if (substring.indexOf(38) >= 0) {
                        substring = substring.substring(0, substring.indexOf(38));
                    }
                    Intent intent = new Intent(WebActivity.this, OrderViewActivity.class);
                    intent.putExtra("orderview_orderid", substring);
                    WebActivity.this.startActivity(intent);
                    return true;
                } else if (O00000o0(WebActivity.this, str)) {
                    if (WebActivity.this.mLoading != null && WebActivity.this.mLoading.getVisibility() == 0) {
                        WebActivity.this.mLoading.setVisibility(8);
                    }
                    return true;
                } else if (O0000OOo.equalsIgnoreCase(cav.O000O0oo())) {
                    WebActivity.this.finish();
                    return true;
                } else if (O0000OOo.equalsIgnoreCase(cav.O000OOOo())) {
                    Intent intent2 = new Intent(WebActivity.this, MainTabActivity.class);
                    intent2.putExtra("go_usercentral", 1);
                    intent2.setFlags(67108864);
                    WebActivity.this.startActivity(intent2);
                    WebActivity.this.finish();
                    return true;
                } else if (cad.O00000o() && str.indexOf("/buy/checkoutoneclick/") >= 0) {
                    Intent intent3 = new Intent(WebActivity.this, CheckoutActivity.class);
                    if (cav.O0000O0o(str).booleanValue()) {
                        intent3.putExtra("one_click_extra", 1);
                    }
                    intent3.putExtra("originalUrl", str);
                    WebActivity.this.startActivity(intent3);
                    if (z) {
                        WebActivity.this.finish();
                    }
                    return true;
                } else if (cad.O00000o() && str.indexOf("/buy/checkout/") >= 0) {
                    WebActivity.this.startActivityForResult(new Intent(WebActivity.this, CheckoutActivity.class), 16);
                    return true;
                } else if (str.indexOf("/in/buy/confirm?id=") >= 0) {
                    String substring2 = str.substring(str.indexOf("/in/buy/confirm?id=") + 19);
                    if (substring2.indexOf(38) >= 0) {
                        substring2 = substring2.substring(0, substring2.indexOf(38));
                    }
                    WebActivity webActivity = WebActivity.this;
                    webActivity.orderId = substring2;
                    webActivity.urlPrefix = str.substring(0, str.indexOf("/in/buy/confirm?id="));
                    Intent intent4 = new Intent(WebActivity.this, ConfirmActivity.class);
                    intent4.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", WebActivity.this.orderId);
                    WebActivity.this.startActivityForResult(intent4, 100);
                    WebActivity.this.updateShoppingCart(0);
                    return true;
                } else if (cad.O00000o() && !TextUtils.isEmpty(str) && str.contains("in/miexchange/diagnosetool")) {
                    WebActivity.this.startActivity(new Intent(WebActivity.this, OTExActivity.class));
                    return true;
                } else if (!cav.O00000Oo(str)) {
                    WebActivity.this.mLoading.setVisibility(0);
                    WebActivity.this.mLoading.O000000o(false);
                    if (cav.O00000o0(str)) {
                        O0000OOo = cav.O0000Oo0(O0000OOo);
                    }
                    webView.loadUrl(O0000OOo);
                    return true;
                } else {
                    try {
                        WebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        if (TextUtils.isEmpty(WebActivity.this.webView.getCurrentUrl())) {
                            WebActivity.this.finish();
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else if (WebActivity.this.fromCart.booleanValue()) {
                WebActivity.this.setResult(-1);
                WebActivity.this.finish();
                return false;
            } else {
                WebActivity.this.startActivityForResult(new Intent(WebActivity.this, ShoppingCartActivity.class), 22);
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            if (!webView.getSettings().getLoadsImagesAutomatically()) {
                webView.getSettings().setLoadsImagesAutomatically(true);
            }
            if (WebActivity.this.clearHistory) {
                WebActivity webActivity = WebActivity.this;
                webActivity.clearHistory = false;
                webActivity.webView.clearHistory();
            }
            super.onPageFinished(webView, str);
            ccr.O00000Oo("InnerWebViewClient", "onPageFinished");
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebActivity.this.f4717O000000o.setVisibility(0);
            WebActivity.currentUrl = str;
            if (this.O00000o0) {
                this.O00000o0 = false;
            } else {
                cbe.O000000o();
            }
            cbe.O00000Oo(str);
            ccr.O00000Oo("InnerWebViewClient", "onPageStarted".concat(String.valueOf(str)));
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            ccr.O00000Oo("WebActivity", "errorCode:" + i + ", description:" + str + ", failingUrl:" + str2);
            ccr.O00000Oo("onReceivedError", "errorCode:" + i + ", description:" + str + ", failingUrl:" + str2);
            if (i != -1 || !TextUtils.equals(str, "net::ERR_CACHE_MISS")) {
                webView.loadUrl("javascript:document.body.innerHTML=\"\"");
                WebActivity.this.handleWebViewVisiable(false);
                WebActivity.this.mLoading.setVisibility(8);
                if (i == -1 && str2.contains("/buy/paygo")) {
                    WebActivity.this.onBackPressed();
                }
            } else if (webView.canGoBackOrForward(-1)) {
                webView.goBackOrForward(-1);
            }
        }

        @TargetApi(23)
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            ccr.O00000Oo("WebActivity", "onReceivedError Target 23");
            ccr.O00000Oo("onReceivedError", webResourceError.getDescription().toString() + webResourceRequest.getUrl().toString());
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }

        @TargetApi(23)
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase().toString(), webResourceRequest.getUrl().toString());
            }
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (byl.O0000OOo()) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    class InnerWebChromeClient extends BaseWebChromeClient {
        private InnerWebChromeClient() {
        }

        /* synthetic */ InnerWebChromeClient(WebActivity webActivity, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            if (WebActivity.this.f4717O000000o != null) {
                WebActivity.this.f4717O000000o.setProgress(i);
                if (i == 100) {
                    WebActivity.this.f4717O000000o.setVisibility(4);
                    WebActivity.this.mLoading.setVisibility(8);
                }
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            ccr.O00000Oo("WebActivity", "onReceivedTitle : ".concat(String.valueOf(str)));
            super.onReceivedTitle(webView, str);
            WebActivity.this.mLoading.setVisibility(8);
            if (WebActivity.this.clearHistory) {
                WebActivity webActivity = WebActivity.this;
                webActivity.clearHistory = false;
                webActivity.webView.clearHistory();
            }
            if (str != null) {
                str = str.trim();
            }
            ((WebActivity) webView.getContext()).setTitle(str);
            WebActivity.this.updateCartBadgeViewVisble(str);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            cpf.O000000o((Object) "openFileChooser < 3.0");
            WebActivity webActivity = WebActivity.this;
            webActivity.uploadMessage = valueCallback;
            webActivity.openImageChooserActivity();
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            cpf.O000000o((Object) "openFileChooser 3.0");
            WebActivity webActivity = WebActivity.this;
            webActivity.uploadMessage = valueCallback;
            webActivity.openImageChooserActivity();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            cpf.O000000o((Object) "openFileChooser 4.1");
            WebActivity webActivity = WebActivity.this;
            webActivity.uploadMessage = valueCallback;
            webActivity.openImageChooserActivity();
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            cpf.O000000o((Object) "openFileChooser 5.0");
            WebActivity webActivity = WebActivity.this;
            webActivity.uploadMessageAboveL = valueCallback;
            webActivity.openImageChooserActivity();
            return true;
        }
    }

    public void openImageChooserActivity() {
        bzy.O000000o().f13504O000000o = true;
        bzy.O00000o.O00000Oo = 1;
        bzy.O00000o.O000000o(1).O000000o(this, C.MSG_CUSTOM_BASE);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        cbe.O00000Oo(this.webView.getUrl());
    }

    public void onPause() {
        super.onPause();
        EmptyLoadingViewPlus emptyLoadingViewPlus = this.mLoading;
        if (emptyLoadingViewPlus != null && emptyLoadingViewPlus.getVisibility() == 0) {
            this.mLoading.setVisibility(8);
        }
        BaseWebView baseWebView = this.webView;
        if (baseWebView != null) {
            baseWebView.onPause();
        }
        ccr.O00000Oo("WebActivity", "onPause");
    }

    public void onSaveInstanceState(Bundle bundle) {
        ccr.O00000Oo("WebActivity", "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        BaseWebView baseWebView = this.webView;
        if (baseWebView != null) {
            ViewParent parent = baseWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.webView);
            }
            ccr.O00000Oo("WebActivity", "onDestory");
            this.webView.stopLoading();
            this.webView.removeAllViews();
            this.webView.destroy();
        }
        DownloadManagerReceiver downloadManagerReceiver = this.O00000o;
        if (downloadManagerReceiver != null) {
            unregisterReceiver(downloadManagerReceiver);
            this.O00000o = null;
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        Uri[] uriArr;
        ArrayList<String> stringArrayListExtra;
        Uri uri2;
        Uri uri3;
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        new SetCookiesTask(this).execute(new Void[0]);
        if (i3 == CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode()) {
            super.onActivityResult(i, i2, intent);
            this.callbackManager.onActivityResult(i3, i4, intent2);
        } else if (i3 != 16) {
            int i5 = 1;
            if (i3 == 10000) {
                if (this.uploadMessage != null || this.uploadMessageAboveL != null) {
                    ValueCallback<Uri[]> valueCallback = this.uploadMessageAboveL;
                    if (valueCallback != null) {
                        if (valueCallback != null) {
                            if (i4 != -1 || intent2 == null || (stringArrayListExtra = intent2.getStringArrayListExtra("select_result")) == null || stringArrayListExtra.size() <= 0) {
                                uriArr = null;
                            } else {
                                uriArr = new Uri[stringArrayListExtra.size()];
                                int i6 = 0;
                                while (i6 < stringArrayListExtra.size()) {
                                    File file = new File(stringArrayListExtra.get(i6));
                                    cpf.O000000o((Object) ("get uri picker:" + stringArrayListExtra.get(i6)));
                                    if (file.exists()) {
                                        uri2 = Uri.fromFile(file);
                                    } else {
                                        String str = stringArrayListExtra.get(i6);
                                        if (TextUtils.isEmpty(str)) {
                                            uri2 = null;
                                        } else if (cbd.O000000o(str)) {
                                            uri2 = Uri.parse(str);
                                        } else {
                                            Uri uri4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                            String[] strArr = new String[i5];
                                            strArr[0] = str;
                                            String str2 = "_id";
                                            Cursor query = getContentResolver().query(uri4, new String[]{"_id"}, "_data=? ", strArr, null);
                                            if (query == null || !query.moveToFirst()) {
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put("_data", str);
                                                uri3 = getContentResolver().insert(uri4, contentValues);
                                            } else {
                                                uri3 = ContentUris.withAppendedId(uri4, query.getLong(query.getColumnIndex(str2)));
                                            }
                                            if (query != null) {
                                                query.close();
                                            }
                                            uri2 = uri3;
                                        }
                                    }
                                    uriArr[i6] = uri2;
                                    i6++;
                                    i5 = 1;
                                }
                            }
                            cpf.O000000o((Object) ("Image picker:" + Arrays.toString(uriArr)));
                            this.uploadMessageAboveL.onReceiveValue(uriArr);
                            this.uploadMessageAboveL = null;
                        }
                    } else if (intent2 != null) {
                        ArrayList<String> stringArrayListExtra2 = intent2.getStringArrayListExtra("select_result");
                        if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                            String str3 = stringArrayListExtra2.get(0);
                            if (cbd.O000000o(str3)) {
                                uri = Uri.parse(str3);
                            } else {
                                File file2 = new File(str3);
                                if (file2.exists()) {
                                    uri = Uri.fromFile(file2);
                                }
                            }
                            cpf.O000000o((Object) "Image picker:".concat(String.valueOf(uri)));
                            this.uploadMessage.onReceiveValue(uri);
                            this.uploadMessage = null;
                        }
                        uri = null;
                        cpf.O000000o((Object) "Image picker:".concat(String.valueOf(uri)));
                        this.uploadMessage.onReceiveValue(uri);
                        this.uploadMessage = null;
                    }
                } else if (TextUtils.isEmpty(this.webView.getUrl()) || !this.webView.getUrl().contains(cav.O00oOooo)) {
                    cec.O000000o(this, (int) R.string.webview_tips_upload_data_lost_custom, 1);
                } else {
                    CustomCloseDialog.Builder builder = new CustomCloseDialog.Builder(this);
                    builder.O00000Oo = getString(R.string.webview_tips_upload_data_lost);
                    builder.O000000o(Boolean.TRUE).O000000o().show();
                }
            } else if (intent2 != null && intent2.hasExtra("result")) {
                String stringExtra = intent2.getStringExtra("result");
                ccr.O00000Oo("WebActivity", "------ webActivity onActivityResult ".concat(String.valueOf(stringExtra)));
                try {
                    String obj = new JSONObject(stringExtra).get("url").toString();
                    if (obj != null && !obj.equals("")) {
                        String O0000Oo0 = cav.O0000Oo0(obj);
                        cpf.O000000o((Object) "--------- url:".concat(String.valueOf(O0000Oo0)));
                        this.webView.loadUrl(O0000Oo0);
                        this.webView.clearHistory();
                        this.clearHistory = true;
                    }
                } catch (JSONException unused) {
                }
            } else if (intent2 == null && this.urlPrefix != null) {
                this.webView.loadUrl(cav.O0000Oo0(this.urlPrefix + "/in/user/orderview?order_id=" + this.orderId));
            }
        }
    }

    public void onSuccess(Sharer.Result result) {
        cec.O000000o(this, (int) R.string.facebook_sharing_success, 0);
    }

    public void onError(FacebookException facebookException) {
        cec.O000000o(this, (int) R.string.facebook_sharing_fail, 0);
    }

    public void hideLoadingView() {
        this.mLoading.setVisibility(8);
        this.f4717O000000o.setVisibility(8);
    }

    public class DownloadManagerReceiver extends BroadcastReceiver {
        public DownloadManagerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                WebActivity.this.hideLoadingView();
                long longExtra = intent.getLongExtra("extra_download_id", -1);
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(longExtra);
                Cursor query2 = ((DownloadManager) context.getSystemService("download")).query(query);
                if (!query2.moveToFirst()) {
                    query2.close();
                    i = -1;
                } else {
                    int i2 = query2.getInt(query2.getColumnIndex("status"));
                    query2.close();
                    i = i2;
                }
                if (i == 16) {
                    ccr.O000000o("download failed!!!");
                    cec.O000000o(context, (int) R.string.webview_tips_download_failed, 1);
                } else if (i == 8) {
                    cpf.O000000o((Object) "download success");
                    cec.O000000o(context, (int) R.string.webview_tips_download_success, 1);
                }
            }
        }
    }

    public void loadExchangeCouponList(final String str) {
        if (!TextUtils.isEmpty(str) && cad.O00000o()) {
            runOnUiThread(new Runnable() {
                /* class com.mi.global.shop.activity.WebActivity.AnonymousClass4 */

                public final void run() {
                    if (str.contains("/in/user/miexchange")) {
                        WebActivity.this.mCartView.setVisibility(8);
                        WebActivity.this.mCloseBtn.setVisibility(8);
                        WebActivity.this.mRefreshBtn.setVisibility(8);
                        WebActivity.this.mForgetPwd.setVisibility(0);
                        WebActivity.this.mForgetPwd.setTextColor(WebActivity.this.getResources().getColor(R.color.orange_red));
                        WebActivity.this.mForgetPwd.setText(WebActivity.this.getResources().getString(R.string.user_exchange_coupon_record));
                        WebActivity.this.mForgetPwd.setOnClickListener(new View.OnClickListener() {
                            /* class com.mi.global.shop.activity.WebActivity.AnonymousClass4.AnonymousClass1 */

                            public final void onClick(View view) {
                                WebActivity.this.webView.loadUrl(cav.O0000Oo0(cav.O000o0o()));
                            }
                        });
                    } else if (str.contains("in/exchange/couponlist")) {
                    } else {
                        if (str.contains(cav.O0000Oo) || str.contains(cav.O0000Oo0)) {
                            WebActivity.this.mCartView.setVisibility(0);
                            WebActivity.this.mCloseBtn.setVisibility(0);
                            WebActivity.this.mRefreshBtn.setVisibility(0);
                            WebActivity.this.mForgetPwd.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    static class SetCookiesTask extends AsyncTask<Void, Void, Void> {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<Context> f4726O000000o;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
        }

        public SetCookiesTask(Context context) {
            this.f4726O000000o = new WeakReference<>(context);
        }

        /* access modifiers changed from: protected */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            Context context = this.f4726O000000o.get();
            if (context == null) {
                return null;
            }
            WebActivity.setCookies(context);
            return null;
        }
    }
}

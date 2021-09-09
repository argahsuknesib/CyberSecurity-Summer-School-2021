package com.xiaomi.smarthome.framework.webview;

import _m_j.cmc;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fju;
import _m_j.fln;
import _m_j.gpi;
import _m_j.gqg;
import _m_j.grr;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hkd;
import _m_j.hry;
import _m_j.hte;
import _m_j.hzf;
import _m_j.izb;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.CommonWebViewActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.ThirdSchemeDialogHelper;
import com.xiaomi.smarthome.screenshot.Screenshot;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

@RouterService
public class CommonWebViewActivity extends BaseActivity {
    static String sUserAgent;
    @BindView(5249)
    ImageView mActionBarBack;
    Context mContext;
    String mCurrentUrl;
    public boolean mFromOperation;
    private boolean mIsFirstEnter = true;
    boolean mIsGoBack = false;
    private boolean mIsNativeShareEnable = false;
    private boolean mIsTitleEnabled = true;
    String mLastBackPath = "";
    int mPreProgress;
    @BindView(5183)
    ProgressBar mProgressBar;
    public Runnable mScreenShotRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass7 */

        public final void run() {
            if (CommonWebViewActivity.this.isValid()) {
                CommonWebViewActivity.this.startScreenShot();
            }
        }
    };
    public ImageView mShareBtn;
    private String mShareDesc = "";
    private String mShareImg = "";
    private String mShareTitle = "";
    private String mShareUrl;
    String mStartPath;
    public final ThirdSchemeDialogHelper mThirdSchemeDialogHelper = new ThirdSchemeDialogHelper(this);
    @BindView(5248)
    ImageView mTitleClose;
    String mTitleText;
    @BindView(5253)
    TextView mTitleView;
    String mUrl;
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass2 */

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (CommonWebViewActivity.this.mFromOperation) {
                if (TextUtils.isEmpty(CommonWebViewActivity.this.mTitleText)) {
                    CommonWebViewActivity.this.mTitleView.setText(str);
                    return;
                }
            } else if (!TextUtils.isEmpty(str)) {
                CommonWebViewActivity.this.mTitleView.setText(str);
                return;
            }
            CommonWebViewActivity.this.mTitleView.setText(CommonWebViewActivity.this.mTitleText);
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i >= CommonWebViewActivity.this.mPreProgress) {
                CommonWebViewActivity.this.mProgressBar.setVisibility(0);
                if (CommonWebViewActivity.this.mHandler != null) {
                    CommonWebViewActivity.this.mHandler.removeMessages(1);
                    if (i >= CommonWebViewActivity.this.mProgressBar.getProgress()) {
                        double d = (double) i;
                        Double.isNaN(d);
                        int i2 = (int) (d * 1.1d);
                        if (i2 <= 99) {
                            CommonWebViewActivity.this.mProgressBar.setProgress(i2);
                            CommonWebViewActivity.this.mProgressBar.postInvalidate();
                        }
                    }
                }
            }
            if (i >= 90 && CommonWebViewActivity.this.mHandler != null) {
                CommonWebViewActivity.this.mHandler.removeMessages(1);
                CommonWebViewActivity.this.mProgressBar.setVisibility(8);
            }
        }

        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(CommonWebViewActivity.this.mContext);
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass2.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(CommonWebViewActivity.this.mContext);
            builder.O00000Oo(str2);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass2.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass2.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            builder.O000000o(false);
            builder.O00000o().show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            izb.O000000o(CommonWebViewActivity.this.mContext, str2, 0).show();
            return true;
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }
    };
    @BindView(5717)
    SmartHomeWebView mWebView;
    private WebViewClient mWebViewClient = new WebViewClient() {
        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass1 */

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            gsy.O000000o(LogType.WEBVIEW, "CommonWebViewActivity", "onPageStarted url: ".concat(String.valueOf(str)));
            if (CommonWebViewActivity.this.mIsGoBack) {
                if (CommonWebViewActivity.this.mLastBackPath.equals(CommonWebViewActivity.this.mStartPath)) {
                    LogType logType = LogType.WEBVIEW;
                    gsy.O000000o(logType, "CommonWebViewActivity", "onPageStarted url finish:" + CommonWebViewActivity.this.mStartPath);
                    CommonWebViewActivity.this.finish();
                    return;
                } else if (str.startsWith("https://account.xiaomi.com/pass/serviceLogin")) {
                    CommonWebViewActivity commonWebViewActivity = CommonWebViewActivity.this;
                    commonWebViewActivity.mIsGoBack = false;
                    if (commonWebViewActivity.mWebView != null && CommonWebViewActivity.this.mWebView.canGoBack()) {
                        CommonWebViewActivity.this.mWebView.goBack();
                        return;
                    }
                    return;
                }
            }
            super.onPageStarted(webView, str, bitmap);
            CommonWebViewActivity.this.mIsGoBack = false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            gsy.O000000o(LogType.WEBVIEW, "CommonWebViewActivity", "shouldOverrideUrlLoading url: ".concat(String.valueOf(str)));
            CommonWebViewActivity.this.mIsGoBack = false;
            if (intercept(webView, str) || super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return false;
        }

        public final boolean intercept(WebView webView, String str) {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || scheme.equals("https") || scheme.equals("http")) {
                if (scheme == null || !WebViewRouterFactory.getWebViewHelpManager().isYoupinHost(str)) {
                    return false;
                }
                return WebViewRouterFactory.getWebViewHelpManager().dispatchToShop(str, "");
            } else if (scheme.equals("tel") || scheme.equals("mailto")) {
                if (CommonWebViewActivity.this.mContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                    CommonWebViewActivity.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
                return true;
            } else if (scheme.equals("mihome") || scheme.equals("mijia")) {
                return true;
            } else {
                if (CommonWebViewActivity.this.mThirdSchemeDialogHelper.O00000Oo()) {
                    return false;
                }
                if (CommonWebViewActivity.this.mContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                    CommonWebViewActivity.this.mThirdSchemeDialogHelper.O000000o(new Runnable(str) {
                        /* class com.xiaomi.smarthome.framework.webview.$$Lambda$CommonWebViewActivity$1$ASb79_n7zxcpK6rxUaDN7Boy1b0 */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CommonWebViewActivity.AnonymousClass1.this.O000000o(this.f$1);
                        }
                    });
                }
                return true;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(String str) {
            try {
                CommonWebViewActivity.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
                hte.O000000o(CommonWebViewActivity.this.mContext, (int) R.string.ble_mesh_toast_failed);
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            CommonWebViewActivity.this.mIsGoBack = false;
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public final void onPageFinished(WebView webView, String str) {
            gsy.O000000o(LogType.WEBVIEW, "CommonWebViewActivity", "onPageFinished url: ".concat(String.valueOf(str)));
            CommonWebViewActivity commonWebViewActivity = CommonWebViewActivity.this;
            commonWebViewActivity.mLastBackPath = commonWebViewActivity.getPath(str);
            CommonWebViewActivity commonWebViewActivity2 = CommonWebViewActivity.this;
            commonWebViewActivity2.mIsGoBack = false;
            if (commonWebViewActivity2.mShareBtn != null) {
                CommonWebViewActivity.this.mShareBtn.setEnabled(true);
            }
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if ("com.xiaomi".equals(str)) {
                try {
                    MiAccountManager O00000Oo = MiAccountManager.O00000Oo(CommonWebViewActivity.this.getApplicationContext());
                    Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                    if (O000000o2.length != 0) {
                        O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, CommonWebViewActivity.this, new AccountManagerCallback<Bundle>() {
                            /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass1.AnonymousClass1 */

                            public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                String str = null;
                                if (accountManagerFuture != null) {
                                    try {
                                        Bundle result = accountManagerFuture.getResult();
                                        if (result != null) {
                                            str = result.getString("authtoken");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (str == null) {
                                    gsy.O000000o(LogType.WEBVIEW, "CommonWebViewActivity", "web sso failed.");
                                    return;
                                }
                                if (CommonWebViewActivity.this.mWebView != null) {
                                    CommonWebViewActivity.this.mWebView.loadUrl(str);
                                }
                                gsy.O000000o(LogType.WEBVIEW, "CommonWebViewActivity", "web sso succeed.");
                            }
                        }, (Handler) null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private Screenshot screenshot;

    public void handleMessage(Message message) {
        if (message.what == 1 && this.mProgressBar.getProgress() < this.mPreProgress) {
            ProgressBar progressBar = this.mProgressBar;
            progressBar.setProgress(progressBar.getProgress() + 1);
            this.mProgressBar.postInvalidate();
            this.mHandler.sendEmptyMessageDelayed(1, (long) ((((int) (Math.random() * 5.0d)) + 2) * 50));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.comm_web_activity);
        ButterKnife.bind(this);
        this.mContext = this;
        this.mProgressBar.setIndeterminateDrawable(null);
        this.mActionBarBack.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass3 */

            public final void onClick(View view) {
                CommonWebViewActivity.this.onBackPressed();
            }
        });
        this.mTitleText = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.mTitleText)) {
            this.mTitleView.setText(this.mTitleText);
        }
        boolean booleanExtra = getIntent().getBooleanExtra("nav_close", false);
        ImageView imageView = this.mTitleClose;
        if (imageView != null && booleanExtra) {
            imageView.setVisibility(0);
            this.mTitleClose.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    CommonWebViewActivity.this.finish();
                }
            });
        }
        this.mFromOperation = getIntent().getBooleanExtra("from_operation", false);
        this.mIsTitleEnabled = true;
        Intent intent = getIntent();
        if (intent.hasExtra("title_enable")) {
            Object obj = intent.getExtras().get("title_enable");
            if (obj instanceof String) {
                this.mIsTitleEnabled = TextUtils.equals("true", ((String) obj).toLowerCase());
            } else if (obj instanceof Boolean) {
                this.mIsTitleEnabled = ((Boolean) obj).booleanValue();
            }
        }
        this.mUrl = getIntent().getStringExtra("url");
        try {
            if (TextUtils.isEmpty(Uri.parse(this.mUrl).getHost())) {
                finish();
            } else if (TextUtils.isEmpty(this.mUrl)) {
                finish();
            } else {
                if (this.mIsTitleEnabled) {
                    findViewById(R.id.title_bar).setVisibility(0);
                } else {
                    findViewById(R.id.title_bar).setVisibility(8);
                }
                this.mIsNativeShareEnable = getIntent().getBooleanExtra("nav_enable", false);
                this.mShareBtn = (ImageView) findViewById(R.id.module_a_3_right_iv_setting_btn);
                if (this.mIsNativeShareEnable) {
                    this.mShareBtn.setVisibility(0);
                    this.mShareBtn.setImageResource(R.drawable.smartgroup_share_icon);
                    this.mShareBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass5 */

                        public final void onClick(View view) {
                            CommonWebViewActivity.this.doShare();
                        }
                    });
                } else {
                    this.mShareBtn.setVisibility(4);
                }
                this.mShareBtn.setEnabled(false);
                if (this.mIsNativeShareEnable) {
                    this.mShareTitle = getIntent().getStringExtra("share_title");
                    this.mShareImg = getIntent().getStringExtra("share_img");
                    this.mShareDesc = getIntent().getStringExtra("share_desc");
                    this.mShareUrl = getIntent().getStringExtra("share_url");
                }
                initWebView();
                if (!TextUtils.isEmpty(this.mUrl)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.mWebView.getSettings().setMixedContentMode(0);
                    }
                    this.mWebView.loadUrl(this.mUrl);
                    this.mStartPath = getPath(this.mUrl);
                    this.mCurrentUrl = this.mUrl;
                    LogType logType = LogType.WEBVIEW;
                    gsy.O000000o(logType, "CommonWebViewActivity", "onPageStarted url oncreate: " + this.mStartPath);
                    return;
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    public void doShare() {
        if (this.mIsNativeShareEnable) {
            fbt fbt = new fbt(this, "CommonShareActivity");
            fbt.O000000o("ShareTitle", this.mShareTitle);
            if (!TextUtils.isEmpty(this.mShareDesc)) {
                fbt.O000000o("ShareContent", this.mShareDesc);
            }
            if (!TextUtils.isEmpty(this.mShareImg)) {
                if (this.mShareImg.endsWith(".zip")) {
                    fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", this.mShareImg);
                } else {
                    fbt.O000000o("ShareImageUrlNotZip", this.mShareImg);
                }
            }
            fbt.O000000o("ShareUrl", this.mShareUrl);
            fbs.O000000o(fbt);
        }
    }

    /* access modifiers changed from: package-private */
    public String getPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public void onResume() {
        super.onResume();
        this.mActionBarBack.requestFocus();
        SmartHomeWebView smartHomeWebView = this.mWebView;
        if (smartHomeWebView != null) {
            smartHomeWebView.onResume();
        }
        if (!this.mIsFirstEnter) {
            this.mThirdSchemeDialogHelper.O000000o();
        }
        this.mIsFirstEnter = false;
    }

    public void onPause() {
        super.onPause();
        SmartHomeWebView smartHomeWebView = this.mWebView;
        if (smartHomeWebView != null) {
            smartHomeWebView.onPause();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.mWebView, null);
            this.mWebView.loadUrl("");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ViewParent parent = this.mWebView.getParent();
        this.mWebView.removeAllViews();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.mWebView);
        }
        this.mWebView.destroy();
        this.mWebView = null;
        this.mThirdSchemeDialogHelper.O000000o();
    }

    public void onBackPressed() {
        try {
            if (this.mWebView == null || !this.mWebView.canGoBack()) {
                super.onBackPressed();
                return;
            }
            this.mIsGoBack = true;
            this.mWebView.goBack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void doGoBack() {
        onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public void doFinishPage() {
        finish();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"AddJavascriptInterface"})
    public void initWebView() {
        WebSettings settings = this.mWebView.getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setUserAgentString(getUserAgent(settings.getUserAgentString()));
        settings.setAllowFileAccess(false);
        this.mWebView.setWebViewClient(this.mWebViewClient);
        this.mWebView.setWebChromeClient(this.mWebChromeClient);
        this.mWebView.setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass6 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!TextUtils.isEmpty(str)) {
                    CommonWebViewActivity.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        });
        this.mWebView.requestFocus();
        this.mWebView.addJavascriptInterface(new O000000o(this), "_native_interface");
        setWebviewCookies();
    }

    public void setWebviewCookies() {
        CookieSyncManager.createInstance(getContext());
        CookieManager instance = CookieManager.getInstance();
        if (CoreApi.O000000o().O0000Ooo()) {
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (!TextUtils.isEmpty(O0000oO)) {
                setCookie(instance, "passToken", O0000oO, ".account.xiaomi.com");
            }
            hkd.O000000o(instance, ".account.xiaomi.com");
            hkd.O000000o(instance, ".home.mi.com");
            hkd.O000000o(this.mWebView);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<CommonWebViewActivity> f8789O000000o = null;
        String O00000Oo = "{}";

        public O000000o(CommonWebViewActivity commonWebViewActivity) {
            this.f8789O000000o = new WeakReference<>(commonWebViewActivity);
            grr.O000000o();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("os_name", "android");
                jSONObject.put("app_version", grr.O00000o0(commonWebViewActivity));
                jSONObject.put("os_version", grr.O0000Oo0());
                jSONObject.put("sdk_version", grr.O0000OOo());
                this.O00000Oo = jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public final boolean isLogin() {
            return CoreApi.O000000o().O0000Ooo();
        }

        @JavascriptInterface
        public final void startLogin() {
            final CommonWebViewActivity commonWebViewActivity = this.f8789O000000o.get();
            if (commonWebViewActivity != null && commonWebViewActivity.isValid()) {
                if (isLogin()) {
                    commonWebViewActivity.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.O000000o.AnonymousClass1 */

                        public final void run() {
                            if (commonWebViewActivity.isValid()) {
                                commonWebViewActivity.setWebviewCookies();
                                SmartHomeWebView smartHomeWebView = commonWebViewActivity.mWebView;
                                if (smartHomeWebView != null) {
                                    smartHomeWebView.O000000o();
                                    smartHomeWebView.reload();
                                }
                            }
                        }
                    }, 200);
                } else {
                    gty.O000000o().startLogin(commonWebViewActivity, 1, new gtx.O000000o() {
                        /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.O000000o.AnonymousClass2 */

                        public final void O000000o() {
                            commonWebViewActivity.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.O000000o.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    if (commonWebViewActivity.isValid()) {
                                        commonWebViewActivity.setWebviewCookies();
                                        SmartHomeWebView smartHomeWebView = commonWebViewActivity.mWebView;
                                        if (smartHomeWebView != null) {
                                            smartHomeWebView.O000000o();
                                            smartHomeWebView.reload();
                                        }
                                    }
                                }
                            }, 200);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public final void screenshot() {
            CommonWebViewActivity commonWebViewActivity = this.f8789O000000o.get();
            if (commonWebViewActivity != null && commonWebViewActivity.isValid()) {
                commonWebViewActivity.mHandler.removeCallbacks(commonWebViewActivity.mScreenShotRunnable);
                commonWebViewActivity.mHandler.postDelayed(commonWebViewActivity.mScreenShotRunnable, 500);
            }
        }

        @JavascriptInterface
        public final boolean openYoupinPage(final String str) {
            CommonWebViewActivity commonWebViewActivity;
            if (TextUtils.isEmpty(str) || (commonWebViewActivity = this.f8789O000000o.get()) == null || !commonWebViewActivity.isValid()) {
                return false;
            }
            commonWebViewActivity.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.O000000o.AnonymousClass3 */

                public final void run() {
                    try {
                        cmc.O000000o(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }

        @JavascriptInterface
        public final void onBackPressed(final boolean z) {
            CommonWebViewActivity commonWebViewActivity = this.f8789O000000o.get();
            if (commonWebViewActivity != null && commonWebViewActivity.isValid()) {
                commonWebViewActivity.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.O000000o.AnonymousClass4 */

                    public final void run() {
                        CommonWebViewActivity commonWebViewActivity = O000000o.this.f8789O000000o.get();
                        if (commonWebViewActivity != null && commonWebViewActivity.isValid()) {
                            if (z) {
                                commonWebViewActivity.forceBack();
                            } else {
                                commonWebViewActivity.onBackPressed();
                            }
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public final String getSettings() {
            return this.O00000Oo;
        }

        @JavascriptInterface
        public final boolean onShare(String str, String str2, String str3, String str4) {
            CommonWebViewActivity commonWebViewActivity = this.f8789O000000o.get();
            if (commonWebViewActivity == null || !commonWebViewActivity.isValid() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            CoreApi.O000000o().O0000o0();
            fbt fbt = new fbt(commonWebViewActivity, "CommonShareActivity");
            fbt.O000000o("ShareTitle", str);
            if (!TextUtils.isEmpty(str3)) {
                fbt.O000000o("ShareContent", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                if (str4.endsWith(".zip")) {
                    fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", str4);
                } else {
                    fbt.O000000o("ShareImageUrlNotZip", str4);
                }
            }
            fbt.O000000o("ShareUrl", str2);
            fbs.O000000o(fbt);
            return true;
        }

        @JavascriptInterface
        public final String getLocale() {
            Locale O0000O0o = fju.O000000o().O0000O0o();
            if (O0000O0o == null) {
                O0000O0o = Locale.getDefault();
            }
            return O0000O0o.toString();
        }

        @JavascriptInterface
        public final int getTitleBarPadding() {
            return hzf.O000000o(CommonApplication.getAppContext());
        }
    }

    /* access modifiers changed from: protected */
    public void forceBack() {
        try {
            super.onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCookie(CookieManager cookieManager, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            cookieManager.setCookie(str3, str + "=" + str2 + "; domain=" + str3);
        }
    }

    public String getAppVersion() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception unused) {
            gsy.O000000o(5, "CommonWebViewActivity", "Get Version Name failed. return 1.0.0");
            return "1.0.0";
        }
    }

    private String getUserAgent(String str) {
        if (sUserAgent == null) {
            sUserAgent = str + fln.O000000o(this) + " XiaoMi/HybridView/";
        }
        return sUserAgent;
    }

    public void startScreenShot() {
        final File file = new File(gpi.O00000Oo, "screenshot.jpg");
        Screenshot.Builder builder = new Screenshot.Builder(this);
        builder.O00000Oo = this.mWebView;
        builder.O00000o = true;
        builder.O00000o0 = file.getAbsolutePath();
        builder.O00000oO = new hry() {
            /* class com.xiaomi.smarthome.framework.webview.CommonWebViewActivity.AnonymousClass8 */

            public final void O000000o(Bitmap bitmap) {
                gsy.O000000o(6, "CommonWebViewActivity", "onSuccess");
                gqg.O000000o(CommonWebViewActivity.this.getContext().getString(R.string.image_saved) + gpi.f18123O000000o + CommonWebViewActivity.this.getContext().getString(R.string.file_directory), 1);
                try {
                    gpi.O000000o(file);
                    CommonWebViewActivity.this.mWebView.loadUrl("javascript:_hideImgDownloader()");
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void O000000o(String str) {
                gsy.O000000o(6, "CommonWebViewActivity", "onFail = ".concat(String.valueOf(str)));
                gqg.O00000Oo((int) R.string.save_fail);
            }

            public final void O000000o() {
                gsy.O000000o(6, "CommonWebViewActivity", "onPreStart");
            }
        };
        this.screenshot = builder.O000000o();
        this.screenshot.O000000o();
    }
}

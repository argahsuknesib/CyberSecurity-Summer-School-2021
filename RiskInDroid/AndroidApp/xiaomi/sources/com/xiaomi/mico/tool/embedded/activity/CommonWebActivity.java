package com.xiaomi.mico.tool.embedded.activity;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.gwg;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.exception.NeedUserInteractionException;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.AndroidBug5497Workaround;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.util.WebViewUtils;
import com.xiaomi.mico.common.widget.CustomWebView;
import com.xiaomi.mico.common.widget.OnScrollChangeCallback;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;
import com.xiaomi.mico.tool.embedded.activity.bridge.MicoBridge;
import com.xiaomi.mico.tool.embedded.activity.webviewaction.WebViewAction;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.ThirdSchemeDialogHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class CommonWebActivity extends MicoBaseActivity {
    private final String JS_OBJECT = "micoJsBridge";
    private boolean isDarkMode;
    ahg loggerNew = new ahg();
    public List<WebViewAction> mActions = new ArrayList();
    public String mDefaultTitle;
    private boolean mIsFullScreen;
    public boolean mShouldShowTitle = true;
    public final ThirdSchemeDialogHelper mThirdSchemeDialogHelper = new ThirdSchemeDialogHelper(this);
    protected String mTitle;
    protected TitleBar mTitleBar;
    public int mTitleColor;
    public String mUrl;
    ProgressBar mWebLoading;
    protected CustomWebView mWebView;
    protected MicoBridge micoBridge;

    /* access modifiers changed from: protected */
    public int customLayoutId() {
        return 0;
    }

    public CommonWebActivity() {
        new ahh();
    }

    public static Intent buildIntent(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, CommonWebActivity.class);
        intent.putExtra("common_web_title", str);
        intent.putExtra("common_web_url", str2);
        intent.putExtra("fullscreen", z);
        return intent;
    }

    public boolean isDarkMode() {
        return this.isDarkMode;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void onCreate(Bundle bundle) {
        this.isDarkMode = getIntent().getBooleanExtra("darkmode", false);
        super.onCreate(bundle);
        this.mIsFullScreen = getIntent().getBooleanExtra("fullscreen", false);
        int customLayoutId = customLayoutId();
        if (customLayoutId != 0) {
            setContentView(customLayoutId);
        } else if (this.mIsFullScreen) {
            setContentView((int) R.layout.activity_common_web);
        } else {
            setContentView((int) R.layout.activity_common_web_normal);
        }
        ButterKnife.bind(this);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mWebView = (CustomWebView) findViewById(R.id.common_web_view);
        this.mWebLoading = (ProgressBar) findViewById(R.id.common_web_loading);
        this.mUrl = getIntent().getStringExtra("common_web_url");
        if (TextUtils.isEmpty(this.mUrl)) {
            finish();
            return;
        }
        this.mTitleColor = getIntent().getIntExtra("title_color", -1);
        int i = this.mTitleColor;
        if (i != -1) {
            this.mTitleBar.setBackgroundColor(i);
        }
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$wua9hcPlt5pQrGvesKXnyXj4gFU */

            public final void onLeftIconClick() {
                CommonWebActivity.this.onBackPressed();
            }
        }).setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$BfTGaD3VEJ8AT4NTcKjEidWUpTg */

            public final void onRightButtonClick() {
                CommonWebActivity.this.finish();
            }
        });
        setupWebView(this.mWebView);
        if (this.mIsFullScreen) {
            this.mShouldShowTitle = false;
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWebView.getLayoutParams();
            layoutParams.topMargin = dimensionPixelSize;
            this.mWebView.setLayoutParams(layoutParams);
            this.mWebView.setScrollChangeCallback(new OnScrollChangeCallback() {
                /* class com.xiaomi.mico.tool.embedded.activity.CommonWebActivity.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
                 arg types: [android.app.Activity, int]
                 candidates:
                  com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
                  com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    int dip2px = DisplayUtils.dip2px(CommonWebActivity.this.getContext(), 150.0f);
                    int i5 = dip2px - i2;
                    boolean z = false;
                    double max = (double) Math.max(i5, 0);
                    Double.isNaN(max);
                    double d = (double) dip2px;
                    Double.isNaN(d);
                    int i6 = (int) ((1.0d - ((max * 1.0d) / d)) * 255.0d);
                    CommonWebActivity commonWebActivity = CommonWebActivity.this;
                    if (i6 > 50) {
                        z = true;
                    }
                    commonWebActivity.mShouldShowTitle = z;
                    CommonWebActivity.this.mTitleBar.setTitle(CommonWebActivity.this.mShouldShowTitle ? CommonWebActivity.this.mTitle : "");
                    if (CommonWebActivity.this.mTitleColor == -1) {
                        Drawable drawable = CommonWebActivity.this.getResources().getDrawable(R.drawable.bg_title_bar);
                        drawable.setAlpha(i6);
                        CommonWebActivity.this.mTitleBar.setBackground(drawable);
                        return;
                    }
                    int i7 = (CommonWebActivity.this.mTitleColor >> 3) & 255;
                    CommonWebActivity.this.mTitleBar.setBackgroundColor(((i6 / 255) * i7) << ((i7 & 16777215) + 3));
                }
            });
            this.mTitleBar.setVisibility(8);
        } else {
            this.mShouldShowTitle = true;
        }
        this.mDefaultTitle = getIntent().getStringExtra("common_web_title");
        if (TextUtils.isEmpty(this.mDefaultTitle)) {
            this.mTitleBar.setTitleVisibility(false);
        }
        setTitle(this.mDefaultTitle);
        AndroidBug5497Workaround.assistActivity(this);
        if (TextUtils.isEmpty(getUrl())) {
            finish();
            return;
        }
        if (getIntent().getBooleanExtra("auth", false)) {
            CookieManager instance = CookieManager.getInstance();
            String userId = LoginManager.getInstance().getPassportInfo().getUserId();
            String serviceToken = LoginManager.getInstance().getServiceInfo(ApiConstants.getMicoSid()).getServiceToken();
            ApiConstants.ServiceConfig[] officeServices = ApiConstants.getOfficeServices();
            for (ApiConstants.ServiceConfig serviceConfig : officeServices) {
                instance.setCookie(serviceConfig.getBaseUrl(), formatCookie("userId", userId));
                instance.setCookie(serviceConfig.getBaseUrl(), formatCookie("serviceToken", serviceToken));
                instance.setCookie(serviceConfig.getBaseUrl(), formatCookie("deviceId", MicoManager.getInstance().getCurrentMicoID()));
            }
        }
        if (getIntent().getBooleanExtra("device_id", false)) {
            CookieManager.getInstance().setCookie(getUrl(), formatCookie("device_id", MicoManager.getInstance().getCurrentMicoID()));
        }
        HashMap hashMap = null;
        ? serializableExtra = getIntent().getSerializableExtra("header");
        if (serializableExtra instanceof HashMap) {
            hashMap = serializableExtra;
        }
        if (hashMap != null) {
            loadUrl(this.mWebView, getUrl(), hashMap);
        } else {
            loadUrl(this.mWebView, getUrl());
        }
        addJavascriptInterface();
        gwg.O00000o0(this);
    }

    private void addJavascriptInterface() {
        if (needAddJavascriptInterface()) {
            try {
                String host = new URL(getUrl()).getHost();
                if (host != null && host.endsWith(".mi.com")) {
                    this.micoBridge = createMicoBridge();
                    this.mWebView.addJavascriptInterface(this.micoBridge, "micoJsBridge");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public MicoBridge createMicoBridge() {
        return new MicoBridge(this.mWebView, this, this.mTitleBar);
    }

    private boolean needAddJavascriptInterface() {
        getUrl();
        return true;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTitle = charSequence.toString();
            if (this.mShouldShowTitle) {
                this.mTitleBar.setTitleVisibility(true);
                this.mTitleBar.setTitle(this.mTitle);
            }
        }
    }

    public String getStartUrl() {
        return this.mUrl;
    }

    /* access modifiers changed from: protected */
    public void setupWebView(WebView webView) {
        webView.setWebViewClient(getWebViewClient());
        webView.setWebChromeClient(getWebChromeClient());
        webView.setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.CommonWebActivity.AnonymousClass2 */

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                CommonWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.mWebView.onResume();
        this.mWebView.resumeTimers();
    }

    public void onPause() {
        super.onPause();
        this.mWebView.onPause();
        this.mWebView.pauseTimers();
    }

    public void onDestroy() {
        super.onDestroy();
        List<WebViewAction> list = this.mActions;
        if (list != null) {
            for (WebViewAction clear : list) {
                clear.clear();
            }
        }
        MicoBridge micoBridge2 = this.micoBridge;
        if (micoBridge2 != null) {
            micoBridge2.recycle();
            this.micoBridge = null;
            this.mWebView.removeJavascriptInterface("micoJsBridge");
        }
        WebViewUtils.destroyWebView(this.mWebView, false, false);
        this.mWebView = null;
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        return this.mUrl;
    }

    public void registerAction(WebViewAction webViewAction) {
        this.mActions.add(webViewAction);
    }

    /* access modifiers changed from: protected */
    public void loadUrl(WebView webView, String str) {
        webView.loadUrl(str);
    }

    /* access modifiers changed from: protected */
    public void loadUrl(WebView webView, String str, HashMap<String, String> hashMap) {
        webView.loadUrl(str, hashMap);
    }

    /* access modifiers changed from: protected */
    public WebViewClient getWebViewClient() {
        return new CommonWebViewClient();
    }

    private String formatCookie(String str, String str2) {
        return String.format("%s=%s; path=/", str, str2);
    }

    /* access modifiers changed from: protected */
    public WebChromeClient getWebChromeClient() {
        return new WebChromeClient() {
            /* class com.xiaomi.mico.tool.embedded.activity.CommonWebActivity.AnonymousClass3 */

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (TextUtils.isEmpty(CommonWebActivity.this.mDefaultTitle) && !TextUtils.isEmpty(str)) {
                    CommonWebActivity.this.setTitle(str);
                }
            }

            public Bitmap getDefaultVideoPoster() {
                return BitmapFactory.decodeResource(CommonWebActivity.this.getContext().getResources(), R.drawable.video_poster);
            }

            public void onProgressChanged(WebView webView, int i) {
                CommonWebActivity.this.mWebLoading.setProgress(i);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                ahg.O00000Oo("onJsAlert %s, %s", str, str2);
                if (CommonWebActivity.this.isDestroyed()) {
                    return true;
                }
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                ahg.O00000Oo("onJsConfirm %s, %s", str, str2);
                if (CommonWebActivity.this.isDestroyed()) {
                    return true;
                }
                return super.onJsConfirm(webView, str, str2, jsResult);
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                ahg.O00000Oo("onJsPrompt %s, %s", str, str2);
                if (CommonWebActivity.this.isDestroyed()) {
                    return true;
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
        };
    }

    public class CommonWebViewClient extends WebViewClient implements CustomWebView.CustomWebViewClient {
        private String mFinalUrl;

        public CommonWebViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ahg.O00000Oo("onPageStarted: %s", str);
            CommonWebActivity.this.mWebLoading.setVisibility(0);
            this.mFinalUrl = null;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ahg.O00000Oo("onPageFinished: %s", str);
            CommonWebActivity.this.mWebLoading.setVisibility(8);
            this.mFinalUrl = str;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ahg.O00000Oo("shouldOverrideUrlLoading: %s", str);
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null && (scheme.equalsIgnoreCase("mico") || scheme.equalsIgnoreCase("mishop"))) {
                for (WebViewAction next : CommonWebActivity.this.mActions) {
                    String authority = parse.getAuthority();
                    if (authority != null && authority.equals(next.getSchema())) {
                        next.call(CommonWebActivity.this.getContext(), CommonWebActivity.this.mWebView, parse);
                        return true;
                    }
                }
                if (SchemaManager.get().canHandle(str)) {
                    SchemaManager.handleSchema(CommonWebActivity.this.getContext(), str);
                    return true;
                }
            }
            return intercept(webView, str) || super.shouldOverrideUrlLoading(webView, str);
        }

        public boolean intercept(WebView webView, String str) {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || scheme.equals("https") || scheme.equals("http")) {
                if (scheme == null || !WebViewRouterFactory.getWebViewHelpManager().isYoupinHost(str)) {
                    return false;
                }
                return WebViewRouterFactory.getWebViewHelpManager().dispatchToShop(str, "");
            } else if (scheme.equals("tel") || scheme.equals("mailto")) {
                if (CommonWebActivity.this.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                    CommonWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
                return true;
            } else if (scheme.equals("mihome") || scheme.equals("mijia")) {
                return true;
            } else {
                if (CommonWebActivity.this.mThirdSchemeDialogHelper.O00000Oo()) {
                    return false;
                }
                if (CommonWebActivity.this.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                    CommonWebActivity.this.mThirdSchemeDialogHelper.O000000o(new Runnable(str) {
                        /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$CommonWebActivity$CommonWebViewClient$P4truN7o0RVfQUzHWu4O9QRZKlA */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CommonWebActivity.CommonWebViewClient.this.lambda$intercept$0$CommonWebActivity$CommonWebViewClient(this.f$1);
                        }
                    });
                }
                return true;
            }
        }

        public /* synthetic */ void lambda$intercept$0$CommonWebActivity$CommonWebViewClient(String str) {
            try {
                CommonWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                CommonWebActivity.this.mWebView.postDelayed(new Runnable() {
                    /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$wOI1h8IVOQCBq6uYOCCL0wYEk9U */

                    public final void run() {
                        CommonWebActivity.this.finish();
                    }
                }, 500);
            } catch (Exception unused) {
                ToastUtil.showToast((int) R.string.failed);
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if ("com.xiaomi".equals(str)) {
                ApiManager.getInstance().getLoginManager().webLogin(CommonWebActivity.this, str3).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                    /* class com.xiaomi.mico.tool.embedded.activity.CommonWebActivity.CommonWebViewClient.AnonymousClass1 */

                    public void call(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            CommonWebActivity.this.loadUrl(CommonWebActivity.this.mWebView, str);
                        }
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.tool.embedded.activity.CommonWebActivity.CommonWebViewClient.AnonymousClass2 */

                    public void call(Throwable th) {
                        if (th instanceof NeedUserInteractionException) {
                            CommonWebActivity.this.startActivity(((NeedUserInteractionException) th).getIntent());
                            CommonWebActivity.this.finish();
                            return;
                        }
                        ahh.O000000o(th);
                    }
                });
            }
        }

        public String getFinalUrl() {
            return this.mFinalUrl;
        }
    }
}

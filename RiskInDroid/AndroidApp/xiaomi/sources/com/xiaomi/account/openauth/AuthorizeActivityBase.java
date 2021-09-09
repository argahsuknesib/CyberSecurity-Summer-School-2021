package com.xiaomi.account.openauth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.XiaomiOAuthResponse;
import com.xiaomi.account.openauth.internal.HashedDeviceIdUtil;
import com.xiaomi.account.utils.OAuthUrlPaser;
import com.xiaomi.account.utils.ParcelableAttackGuardian;

public abstract class AuthorizeActivityBase extends Activity {
    public static int RESULT_CANCEL = 0;
    public static int RESULT_FAIL = 1;
    public static int RESULT_SUCCESS = -1;
    private boolean mKeepCookies = false;
    private boolean mMiddleActivityMode = false;
    private XiaomiOAuthResponse mResponse;
    private WebSettings mSettings;
    private String mUrl;
    private WebView mWebView;

    /* access modifiers changed from: protected */
    public abstract void onHideErrorUI();

    /* access modifiers changed from: protected */
    public abstract void onHideProgress();

    /* access modifiers changed from: protected */
    public abstract void onShowErrorUI();

    /* access modifiers changed from: protected */
    public abstract void onShowProgress();

    /* access modifiers changed from: protected */
    public abstract void onUpdateProgress(int i);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra("extra_my_bundle");
        if (bundleExtra != null) {
            setResultAndFinish(intent.getIntExtra("extra_result_code", -1), bundleExtra);
            return;
        }
        this.mResponse = (XiaomiOAuthResponse) intent.getParcelableExtra("extra_response");
        Intent intent2 = (Intent) intent.getParcelableExtra("extra_my_intent");
        if (intent2 != null) {
            startActivityForResult(intent2, 1001);
            this.mMiddleActivityMode = true;
            return;
        }
        this.mKeepCookies = intent.getBooleanExtra("extra_keep_cookies ", false);
        this.mWebView = new WebView(this);
        this.mSettings = this.mWebView.getSettings();
        this.mSettings.setJavaScriptEnabled(true);
        this.mSettings.setSavePassword(false);
        this.mSettings.setSaveFormData(false);
        this.mUrl = intent.getStringExtra("url");
        if (bundle == null) {
            removeCookiesIfNeeded();
        }
        appendPassportUserAgent();
        this.mWebView.setWebViewClient(new AuthorizeWebViewClient(intent.getStringExtra("redirect_uri")));
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            /* class com.xiaomi.account.openauth.AuthorizeActivityBase.AnonymousClass1 */

            public void onProgressChanged(WebView webView, int i) {
                AuthorizeActivityBase.this.onUpdateProgress(i);
            }
        });
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        String stringExtra = intent.getStringExtra("userid");
        String stringExtra2 = intent.getStringExtra("serviceToken");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra);
            instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("activatorToken");
        String stringExtra4 = intent.getStringExtra("hash");
        String stringExtra5 = intent.getStringExtra("operator");
        String stringExtra6 = intent.getStringExtra("operatorLink");
        String hashedDeviceIdNoThrow = new HashedDeviceIdUtil(this).getHashedDeviceIdNoThrow();
        instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra4);
        instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra3);
        instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra5);
        instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, stringExtra6);
        instance.setCookie(XiaomiOAuthConstants.OAUTH2_HOST, "deviceId=".concat(String.valueOf(hashedDeviceIdNoThrow)));
        CookieSyncManager.getInstance().sync();
        refreshWebView(false);
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            setResultAndFinish(RESULT_CANCEL, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            setResultAndFinish(i2, intent != null ? intent.getExtras() : null);
        }
    }

    /* access modifiers changed from: protected */
    public final WebView getWebView() {
        return this.mWebView;
    }

    /* access modifiers changed from: package-private */
    public void setResultAndFinish(int i, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(i, intent);
        XiaomiOAuthResponse xiaomiOAuthResponse = this.mResponse;
        if (xiaomiOAuthResponse != null) {
            if (i == 0) {
                xiaomiOAuthResponse.onCancel();
            } else {
                xiaomiOAuthResponse.onResult(bundle);
            }
        }
        removeCookiesIfNeeded();
        finish();
    }

    private void removeCookiesIfNeeded() {
        if (!this.mKeepCookies) {
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    public static Intent asMiddleActivity(Context context, Intent intent, IXiaomiAuthResponse iXiaomiAuthResponse, Class<? extends AuthorizeActivityBase> cls) {
        Intent intent2 = new Intent(context, cls);
        intent2.putExtra("extra_my_intent", intent);
        intent2.putExtra("extra_response", new XiaomiOAuthResponse(iXiaomiAuthResponse));
        return intent2;
    }

    public static Intent asMiddleActivity(Context context, int i, Bundle bundle, Class<? extends AuthorizeActivityBase> cls) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("extra_my_bundle", bundle);
        intent.putExtra("extra_result_code", i);
        return intent;
    }

    class AuthorizeWebViewClient extends WebViewClient {
        private final String mRedirectUrlOf3rdPartyApp;

        AuthorizeWebViewClient(String str) {
            this.mRedirectUrlOf3rdPartyApp = str;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AuthorizeActivityBase.this.onShowErrorUI();
            super.onReceivedError(webView, i, str, str2);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AuthorizeActivityBase.this.onShowErrorUI();
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthorizeActivityBase.this.onShowProgress();
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            AuthorizeActivityBase.this.onHideProgress();
            super.onPageFinished(webView, str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.mRedirectUrlOf3rdPartyApp != null && !str.toLowerCase().startsWith(this.mRedirectUrlOf3rdPartyApp.toLowerCase())) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            Bundle parse = OAuthUrlPaser.parse(str);
            if (parse == null) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            AuthorizeActivityBase.this.setResultAndFinish(AuthorizeActivityBase.RESULT_SUCCESS, parse);
            return true;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private void appendPassportUserAgent() {
        String userAgentString = this.mSettings.getUserAgentString();
        if (!TextUtils.isEmpty(userAgentString)) {
            this.mSettings.setUserAgentString((userAgentString + " Passport/OAuthSDK/1.8.2") + " mi/OAuthSDK/VersionCode/82");
        }
    }

    /* access modifiers changed from: protected */
    public final void refreshWebView() {
        refreshWebView(true);
    }

    /* access modifiers changed from: protected */
    public final void refreshWebView(boolean z) {
        this.mWebView.loadUrl(this.mUrl);
        if (z) {
            onHideErrorUI();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.account.openauth.AuthorizeActivityBase.AnonymousClass2 */

                public void run() {
                    AuthorizeActivityBase.this.onHideErrorUI();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isMiddleActivityMode() {
        return this.mMiddleActivityMode;
    }
}

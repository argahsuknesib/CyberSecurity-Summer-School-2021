package com.xiaomi.account.openid.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.account.openid.OauthAccount;
import com.xiaomi.account.openid.OauthAccountManager;
import com.xiaomi.account.openid.ui.OAuthContacts;
import java.util.Map;

public class OAuthActivity extends Activity implements OAuthContacts.View {
    OAuthPresenter mOAuthPresenter = new OAuthPresenter(OauthAccountManager.getOauthAccount(), this);
    WebView mWebView;
    ProgressDialog progressDialog;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWebView();
        setContentView(this.mWebView);
        this.mOAuthPresenter.onStart(getIntent());
    }

    private void initWebView() {
        this.mWebView = new WebView(this);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        appendPassportUserAgent(" app/" + getPackageName());
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.account.openid.ui.OAuthActivity.AnonymousClass1 */

            public void onPageFinished(WebView webView, String str) {
                if (OAuthActivity.this.progressDialog != null && OAuthActivity.this.progressDialog.isShowing()) {
                    OAuthActivity.this.progressDialog.dismiss();
                    OAuthActivity.this.progressDialog = null;
                }
                super.onPageFinished(webView, str);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (OAuthActivity.this.mOAuthPresenter.shouldOverrideUrlLoading(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    public void login(OauthAccount oauthAccount) {
        oauthAccount.login(this, new OauthAccount.LoginFinishedListener() {
            /* class com.xiaomi.account.openid.ui.OAuthActivity.AnonymousClass2 */

            public void onSuccess() {
                OAuthActivity.this.mOAuthPresenter.onLoginSuccess();
            }

            public void canceled() {
                OAuthActivity.this.mOAuthPresenter.onLoginCanceled();
            }
        });
    }

    public void showProgress() {
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.show();
    }

    private void removeCookiesIfNeeded() {
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
    }

    public void setCookie(Map<String, String> map) {
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeSessionCookie();
        for (Map.Entry next : map.entrySet()) {
            String str = XiaomiOAuthConstants.OAUTH2_HOST;
            instance.setCookie(str, ((String) next.getKey()) + "=" + ((String) next.getValue()));
        }
        CookieSyncManager.getInstance().sync();
    }

    private void appendPassportUserAgent(String str) {
        WebSettings settings = this.mWebView.getSettings();
        String userAgentString = settings.getUserAgentString();
        if (!TextUtils.isEmpty(userAgentString)) {
            userAgentString = userAgentString + " " + str;
        }
        settings.setUserAgentString(userAgentString);
    }

    public void loadUrl(String str) {
        this.mWebView.loadUrl(str);
    }

    public void onBackPressed() {
        this.mOAuthPresenter.onBackPressed();
    }

    public void setResultAndFinish(int i, Bundle bundle) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(i, intent);
        finish();
    }
}

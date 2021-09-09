package com.xiaomi.account.openid.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.ValueCallback;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.XiaomiOAuthResponse;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.account.openid.OauthAccount;
import com.xiaomi.account.openid.ui.OAuthContacts;
import com.xiaomi.account.utils.OAuthUrlPaser;
import java.util.HashMap;

public class OAuthPresenter {
    public static final String AUTHORIZE_PATH = (XiaomiOAuthConstants.OAUTH2_HOST + "/oauth2/authorize");
    public OauthAccount mOauthAccount;
    private XiaomiOAuthResponse mResponse;
    private String redirectUrl;
    public String urlQueryParams;
    public OAuthContacts.View view;

    OAuthPresenter(OauthAccount oauthAccount, OAuthContacts.View view2) {
        this.mOauthAccount = oauthAccount;
        this.view = view2;
    }

    /* access modifiers changed from: package-private */
    public void onStart(Intent intent) {
        if (intent == null) {
            onOAuthCanceled();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            onOAuthCanceled();
            return;
        }
        this.urlQueryParams = extras.getString("urlQueryParams");
        this.redirectUrl = extras.getString("redirectUrl");
        this.mResponse = (XiaomiOAuthResponse) extras.getParcelable("extra_response");
        if (this.urlQueryParams == null || this.redirectUrl == null || this.mResponse == null) {
            onOAuthCanceled();
            return;
        }
        OauthAccount oauthAccount = this.mOauthAccount;
        if (oauthAccount == null) {
            Log.w("OAuthPresenter", "mOauthAccount is null :Please setOauthAccount when applicaiton init");
            startOAuth();
            return;
        }
        oauthAccount.getLoginStatus(new ValueCallback<Boolean>() {
            /* class com.xiaomi.account.openid.ui.OAuthPresenter.AnonymousClass1 */

            public void onReceiveValue(Boolean bool) {
                if (bool.booleanValue()) {
                    OAuthPresenter.this.startOAuth();
                } else {
                    OAuthPresenter.this.view.login(OAuthPresenter.this.mOauthAccount);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onLoginSuccess() {
        startOAuth();
    }

    /* access modifiers changed from: package-private */
    public void onLoginCanceled() {
        onOAuthCanceled();
    }

    /* access modifiers changed from: package-private */
    public void onBackPressed() {
        onOAuthCanceled();
    }

    public void startOAuth() {
        this.view.showProgress();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            /* class com.xiaomi.account.openid.ui.OAuthPresenter.AnonymousClass2 */

            public void run() {
                if (OAuthPresenter.this.mOauthAccount != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("userId", OAuthPresenter.this.mOauthAccount.getUserId());
                    hashMap.put("serviceToken", OAuthPresenter.this.mOauthAccount.getServiceToken());
                    OAuthPresenter.this.view.setCookie(hashMap);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.xiaomi.account.openid.ui.OAuthPresenter.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        OAuthContacts.View view = OAuthPresenter.this.view;
                        view.loadUrl(OAuthPresenter.AUTHORIZE_PATH + "?" + OAuthPresenter.this.urlQueryParams);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean shouldOverrideUrlLoading(String str) {
        Bundle parse;
        if (!str.startsWith(this.redirectUrl) || (parse = OAuthUrlPaser.parse(str)) == null) {
            return false;
        }
        onOAuthSuccess(parse);
        return true;
    }

    private void onOAuthSuccess(Bundle bundle) {
        this.mResponse.onResult(bundle);
        this.view.setResultAndFinish(-1, bundle);
    }

    private void onOAuthCanceled() {
        XiaomiOAuthResponse xiaomiOAuthResponse = this.mResponse;
        if (xiaomiOAuthResponse != null) {
            xiaomiOAuthResponse.onCancel();
        }
        this.view.setResultAndFinish(0, null);
    }

    public static Intent makeOAuthIntent(Context context, String str, String str2, IXiaomiAuthResponse iXiaomiAuthResponse) {
        Intent intent = new Intent(context, OAuthActivity.class);
        intent.putExtra("redirectUrl", str);
        intent.putExtra("urlQueryParams", str2);
        intent.putExtra("extra_response", new XiaomiOAuthResponse(iXiaomiAuthResponse));
        return intent;
    }
}

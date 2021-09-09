package com.xiaomi.youpin.login.ui.web;

import _m_j.ibi;
import _m_j.ibm;
import _m_j.ics;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.util.concurrent.Executors;

public class LoginAutoLoginBaseActivity extends LoginWebActivity {
    protected Handler O00000Oo;
    protected WebView O00000o;
    protected Context O00000o0;
    protected String O00000oO;
    protected String O00000oo;
    protected String O0000O0o;
    private boolean O0000o0 = false;

    interface O000000o {
        void O000000o(ServiceTokenResult serviceTokenResult);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000o0 = this;
        this.O00000Oo = new Handler(Looper.getMainLooper());
    }

    public void onDestroy() {
        this.O00000Oo.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(WebSettings webSettings) {
        super.O000000o(webSettings);
        String userAgentString = webSettings.getUserAgentString();
        String O00000o02 = ibm.f1156O000000o.O0000OoO.O00000o0();
        if (TextUtils.isEmpty(O00000o02)) {
            webSettings.setUserAgentString(userAgentString + " XiaoMi/MiuiBrowser/4.3");
        } else {
            webSettings.setUserAgentString(O00000o02);
        }
        webSettings.setUserAgentString(webSettings.getUserAgentString() + " MIOT");
        webSettings.setCacheMode(-1);
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 17) {
            this.O0000OoO.removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }

    /* access modifiers changed from: protected */
    public final WebViewClient O000000o() {
        return new WebViewClient() {
            /* class com.xiaomi.youpin.login.ui.web.LoginAutoLoginBaseActivity.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @TargetApi(24)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
            }

            public final void onReceivedLoginRequest(final WebView webView, String str, String str2, String str3) {
                LoginAutoLoginBaseActivity loginAutoLoginBaseActivity = LoginAutoLoginBaseActivity.this;
                loginAutoLoginBaseActivity.O00000o = webView;
                loginAutoLoginBaseActivity.O00000oO = str;
                loginAutoLoginBaseActivity.O00000oo = str2;
                loginAutoLoginBaseActivity.O0000O0o = str3;
                if ("com.xiaomi".equals(str)) {
                    String concat = "weblogin:".concat(String.valueOf(str3));
                    if (MiAccountManager.O00000Oo(LoginAutoLoginBaseActivity.this).O00000oo() != null) {
                        LoginAutoLoginBaseActivity loginAutoLoginBaseActivity2 = LoginAutoLoginBaseActivity.this;
                        loginAutoLoginBaseActivity2.getSsoLoginUrl(loginAutoLoginBaseActivity2, concat, new O000000o() {
                            /* class com.xiaomi.youpin.login.ui.web.LoginAutoLoginBaseActivity.AnonymousClass1.AnonymousClass1 */

                            public final void O000000o(ServiceTokenResult serviceTokenResult) {
                                if (serviceTokenResult == null) {
                                    AccountLog.e("LoginAutoLoginBaseActivity", "service token result is null");
                                } else if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_NONE) {
                                    AccountLog.e("LoginAutoLoginBaseActivity", "service token result error code = " + serviceTokenResult.O00000o + " error msg: " + serviceTokenResult.O00000oO);
                                } else {
                                    webView.clearHistory();
                                    webView.loadUrl(serviceTokenResult.O00000Oo);
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    public void getSsoLoginUrl(final Context context, final String str, final O000000o o000000o) {
        new AsyncTask<Void, Void, ServiceTokenResult>() {
            /* class com.xiaomi.youpin.login.ui.web.LoginAutoLoginBaseActivity.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                o000000o.O000000o((ServiceTokenResult) obj);
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return MiAccountManager.O00000Oo(context).O000000o(context, str).get();
            }
        }.executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ibi ibi;
        super.onActivityResult(i, i2, intent);
        if (i != 1000) {
            return;
        }
        if (i2 == -1) {
            ics.O000000o(this).O000000o("申请权限成功");
            if (!this.O0000o0 && (ibi = ibm.f1156O000000o.O0000OoO) != null) {
                ibi.O000000o(this.O00000o, this.O00000oO, this.O0000O0o, new ibi.O000000o() {
                    /* class com.xiaomi.youpin.login.ui.web.LoginAutoLoginBaseActivity.AnonymousClass3 */
                });
                this.O0000o0 = true;
            }
        } else if (i2 == 0) {
            ics.O000000o(this).O000000o("取消申请权限，请手动输入小米帐号密码");
        } else {
            ics.O000000o(this).O000000o("申请权限失败，请手动输入小米帐号密码");
        }
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.O00000o;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        WebView webView = this.O00000o;
        if (webView != null) {
            webView.onPause();
        }
    }
}

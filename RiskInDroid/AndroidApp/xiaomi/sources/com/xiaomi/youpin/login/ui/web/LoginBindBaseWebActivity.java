package com.xiaomi.youpin.login.ui.web;

import _m_j.ft;
import _m_j.ibi;
import _m_j.ibm;
import _m_j.ics;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.os.OperationCanceledException;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class LoginBindBaseWebActivity extends LoginWebActivity {
    private Context O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private boolean O0000O0o = false;
    public String mAccountName;
    public String mArgs;
    public Handler mHandler;
    public String mRealm;
    public WebView mWebView;

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    private void O000000o(String str, String str2) {
        String cookie = CookieManager.getInstance().getCookie(str2);
        if (!TextUtils.isEmpty(cookie)) {
            String[] split = cookie.split(";");
            if (split.length > 0) {
                for (String trim : split) {
                    String[] split2 = trim.trim().split("=");
                    if (split2.length > 0 && !TextUtils.isEmpty(split2[0]) && split2[0].equals(str)) {
                        String str3 = split2[0] + "=EXPIRED; domain=" + str2 + "; expires=Thu, 01-Dec-1994 16:00:00 GMT";
                        if (Build.VERSION.SDK_INT < 21) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str2);
                            arrayList.add(str3);
                            new O000000o(CookieManager.getInstance()).execute(arrayList);
                        } else {
                            CookieManager.getInstance().setCookie(str2, str3, null);
                        }
                    }
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = this;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void O000000o(boolean z, String str, String str2, String str3) {
        ft O000000o2 = ft.O000000o(this.O00000Oo.getApplicationContext());
        Intent intent = new Intent(O00000Oo());
        intent.putExtra("bind_success", z);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("userId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("cUserId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("passToken", str3);
        }
        O000000o2.O000000o(intent);
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Intent intent) {
        if (!super.O000000o(intent)) {
            return false;
        }
        this.O00000o0 = intent.getStringExtra("args_openid");
        this.O00000o = intent.getStringExtra("args_source");
        this.O00000oO = intent.getStringExtra("args_passtoken");
        this.O00000oo = intent.getStringExtra("args_userid");
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(WebSettings webSettings) {
        super.O000000o(webSettings);
        String userAgentString = webSettings.getUserAgentString();
        webSettings.setUserAgentString(userAgentString + " XiaoMi/MiuiBrowser/4.3");
        webSettings.setCacheMode(-1);
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 17) {
            this.O0000OoO.removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }

    /* access modifiers changed from: protected */
    public final WebViewClient O000000o() {
        return new WebViewClient() {
            /* class com.xiaomi.youpin.login.ui.web.LoginBindBaseWebActivity.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                LoginBindBaseWebActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.youpin.login.ui.web.LoginBindBaseWebActivity.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        LoginBindBaseWebActivity.this.checkCookie();
                    }
                });
                return true;
            }

            @TargetApi(24)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
            }

            public final void onReceivedLoginRequest(final WebView webView, String str, String str2, String str3) {
                LoginBindBaseWebActivity loginBindBaseWebActivity = LoginBindBaseWebActivity.this;
                loginBindBaseWebActivity.mWebView = webView;
                loginBindBaseWebActivity.mRealm = str;
                loginBindBaseWebActivity.mAccountName = str2;
                loginBindBaseWebActivity.mArgs = str3;
                ibi ibi = ibm.f1156O000000o.O0000OoO;
                if (ibi != null) {
                    ibi.O000000o(webView, str, str3, new ibi.O000000o() {
                        /* class com.xiaomi.youpin.login.ui.web.LoginBindBaseWebActivity.AnonymousClass1.AnonymousClass3 */
                    });
                } else if ("com.xiaomi".equals(str)) {
                    MiAccountManager O00000Oo = MiAccountManager.O00000Oo(LoginBindBaseWebActivity.this);
                    Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                    if (O000000o2.length != 0) {
                        O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, LoginBindBaseWebActivity.this, new AccountManagerCallback<Bundle>() {
                            /* class com.xiaomi.youpin.login.ui.web.LoginBindBaseWebActivity.AnonymousClass1.AnonymousClass2 */

                            /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
                            /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                            public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                String str;
                                try {
                                    str = accountManagerFuture.getResult().getString("authtoken");
                                } catch (OperationCanceledException e) {
                                    e.printStackTrace();
                                    str = null;
                                    if (str != null) {
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    str = null;
                                    if (str != null) {
                                    }
                                } catch (AuthenticatorException e3) {
                                    e3.printStackTrace();
                                    str = null;
                                    if (str != null) {
                                    }
                                } catch (android.accounts.OperationCanceledException unused) {
                                    str = null;
                                    if (str != null) {
                                    }
                                }
                                if (str != null) {
                                    webView.loadUrl(str);
                                }
                            }
                        }, (Handler) null);
                    }
                }
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ibi ibi;
        super.onActivityResult(i, i2, intent);
        if (i != 1000) {
            return;
        }
        if (i2 == -1) {
            ics.O000000o(this).O000000o("申请权限成功");
            if (!this.O0000O0o && (ibi = ibm.f1156O000000o.O0000OoO) != null) {
                ibi.O000000o(this.mWebView, this.mRealm, this.mArgs, new ibi.O000000o() {
                    /* class com.xiaomi.youpin.login.ui.web.LoginBindBaseWebActivity.AnonymousClass2 */
                });
                this.O0000O0o = true;
            }
        } else if (i2 == 0) {
            ics.O000000o(this).O000000o("取消申请权限，请手动输入小米帐号密码");
        } else {
            ics.O000000o(this).O000000o("申请权限失败，请手动输入小米帐号密码");
        }
    }

    static class O000000o extends AsyncTask<List<String>, Void, Void> {

        /* renamed from: O000000o  reason: collision with root package name */
        private CookieManager f12102O000000o;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            List list = ((List[]) objArr)[0];
            String str = (String) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                this.f12102O000000o.setCookie(str, (String) list.get(i));
            }
            return null;
        }

        public O000000o(CookieManager cookieManager) {
            this.f12102O000000o = cookieManager;
        }
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void checkCookie() {
        HashMap hashMap;
        String cookie = CookieManager.getInstance().getCookie("https://account.xiaomi.com");
        if (TextUtils.isEmpty(cookie)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 1) {
                    hashMap.put(split2[0].trim(), split2[1].trim());
                }
            }
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            String str = (String) hashMap.get("sns-bind-step");
            if ("bind-finish".equalsIgnoreCase(str)) {
                String str2 = (String) hashMap.get("userId");
                String str3 = (String) hashMap.get("cUserId");
                String str4 = (String) hashMap.get("passToken");
                O000000o("sns-bind-step", "https://account.xiaomi.com");
                if (this.O00000o.equalsIgnoreCase("login")) {
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                        O000000o(false, null, null, null);
                        finish();
                        return;
                    }
                    O000000o(true, str2, "", str4);
                    finish();
                } else if (!this.O00000o.equalsIgnoreCase("bind")) {
                } else {
                    if (TextUtils.isEmpty(str3)) {
                        O000000o(false, null, null, null);
                        finish();
                        return;
                    }
                    O000000o(true, "", str3, "");
                    finish();
                }
            } else if ("bind-cancel".equalsIgnoreCase(str)) {
                O000000o("sns-bind-step", "https://account.xiaomi.com");
                finish();
                O000000o(false, null, null, null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        O000000o(false, null, null, null);
        finish();
    }
}

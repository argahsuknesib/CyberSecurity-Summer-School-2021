package com.xiaomi.smarthome.framework.login.ui;

import _m_j.efk;
import _m_j.efm;
import _m_j.flk;
import _m_j.frn;
import _m_j.fro;
import _m_j.frp;
import _m_j.gfr;
import _m_j.gqg;
import _m_j.ibm;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class BindFbActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    WebViewClient f7565O000000o = new WebViewClient() {
        /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass6 */

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String path = Uri.parse(efk.O00000Oo).getPath();
            String path2 = Uri.parse(efk.O00000o0).getPath();
            String path3 = Uri.parse(str).getPath();
            boolean equals = path2.equals(path3);
            boolean equals2 = path.equals(path3);
            if (equals) {
                BindFbActivity.this.setResult(-1);
                BindFbActivity.this.finish();
                return true;
            } else if (!equals2) {
                return false;
            } else {
                BindFbActivity.this.setResult(0);
                BindFbActivity.this.finish();
                return true;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if ("com.xiaomi".equals(str)) {
                MiAccountManager O00000Oo = MiAccountManager.O00000Oo(BindFbActivity.this);
                Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                if (O000000o2.length != 0) {
                    O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, BindFbActivity.this, new AccountManagerCallback<Bundle>() {
                        /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass6.AnonymousClass1 */

                        /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
                        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                        public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                            String str;
                            try {
                                str = accountManagerFuture.getResult().getString("authtoken");
                            } catch (OperationCanceledException e) {
                                e.printStackTrace();
                                str = null;
                                if (str == null) {
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                str = null;
                                if (str == null) {
                                }
                            } catch (AuthenticatorException e3) {
                                e3.printStackTrace();
                                str = null;
                                if (str == null) {
                                }
                            }
                            if (str == null) {
                                BindFbActivity.this.mWebView.loadUrl(str);
                            }
                        }
                    }, (Handler) null);
                }
            }
        }
    };
    private boolean O00000Oo = true;
    private Handler O00000o;
    private boolean O00000o0 = false;
    public XQProgressDialog fbProgressDialog;
    public SmartHomeWebView mWebView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_binwx_acitivity);
        this.O00000o0 = getIntent().getBooleanExtra("bindwx_jump_mj", true);
        this.O00000o = new Handler();
        this.mWebView = (SmartHomeWebView) findViewById(R.id.webview);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass1 */

            public final void onClick(View view) {
                BindFbActivity.this.finish();
            }
        });
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        this.fbProgressDialog = new XQProgressDialog(this);
        this.fbProgressDialog.setCancelable(true);
        this.fbProgressDialog.setMessage(getString(R.string.account_binding_waiting));
        this.fbProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                BindFbActivity.this.finish();
            }
        });
        if (!isFinishing()) {
            this.fbProgressDialog.show();
        }
        this.O00000o.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass3 */

            public final void run() {
                BindFbActivity.this.fbProgressDialog.dismiss();
            }
        }, 3000);
        frp O000000o2 = fro.O000000o();
        if (O000000o2 != null) {
            O000000o2.bindFb(this, new frn<String, String>() {
                /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass4 */

                public final /* synthetic */ void O000000o(Object obj, Object obj2) {
                    BindFbActivity.this.loginRequestedSid((String) obj, (String) obj2);
                }

                public final void O000000o() {
                    BindFbActivity.this.finish();
                }

                public final void O00000Oo() {
                    BindFbActivity.this.finish();
                    gqg.O00000Oo((int) R.string.failed);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        SmartHomeWebView smartHomeWebView = this.mWebView;
        if (smartHomeWebView != null) {
            smartHomeWebView.onResume();
        }
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
        if (this.O00000Oo) {
            this.O00000Oo = false;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XQProgressDialog xQProgressDialog = this.fbProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.fbProgressDialog.dismiss();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        frp O000000o2 = fro.O000000o();
        if (O000000o2 != null) {
            O000000o2.onActivityResult(i, i2, intent);
        }
    }

    public void loginRequestedSid(String str, String str2) {
        String str3;
        ExtendedAuthToken parse;
        efk efk = new efk(this);
        SNSLoginParameter.O000000o o000000o = new SNSLoginParameter.O000000o();
        o000000o.O00000Oo = ibm.f1156O000000o.O0000OOo;
        o000000o.O00000o = ibm.f1156O000000o.O00000oo;
        o000000o.O00000oo = str;
        o000000o.O0000O0o = str2;
        SNSLoginParameter O000000o2 = o000000o.O000000o();
        LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
        if (O0000oOo == null) {
            str3 = "";
        } else {
            str3 = O0000oOo.O00000o0();
        }
        if (TextUtils.isEmpty(str3)) {
            Context appContext = ServiceApplication.getAppContext();
            String O000000o3 = MiAccountManager.O00000Oo(appContext).O000000o(MiAccountManager.O00000Oo(appContext).O00000oo());
            if (TextUtils.isEmpty(O000000o3) || (parse = ExtendedAuthToken.parse(O000000o3)) == null) {
                str3 = null;
            } else {
                str3 = parse.authToken;
            }
        }
        final AccountInfo build = new AccountInfo.Builder().userId(CoreApi.O000000o().O0000o0()).encryptedUserId(CoreApi.O000000o().O0000o()).passToken(str3).build();
        efk.O000000o(O000000o2, build, new efk.O000000o() {
            /* class com.xiaomi.smarthome.framework.login.ui.BindFbActivity.AnonymousClass5 */

            public final void O000000o(int i, String str) {
                if (gfr.O0000OOo) {
                    gqg.O000000o("2132672604," + i + "," + str, 0);
                } else {
                    gqg.O00000Oo(R.string.account_bind_failed, 0);
                }
                BindFbActivity.this.setResult(0);
                BindFbActivity.this.finish();
            }

            public final void O000000o() {
                gqg.O00000Oo(R.string.status_error_cable_not_plugin_body, 0);
                BindFbActivity.this.setResult(0);
                BindFbActivity.this.finish();
            }

            public final void O000000o(SNSBindParameter sNSBindParameter) {
                BindFbActivity.this.mWebView.setWebViewClient(BindFbActivity.this.f7565O000000o);
                BindFbActivity bindFbActivity = BindFbActivity.this;
                String userAgent = bindFbActivity.getUserAgent(bindFbActivity);
                WebSettings settings = BindFbActivity.this.mWebView.getSettings();
                settings.setUserAgentString(userAgent + " AndroidSnsSDK/" + gfr.O00000oo + " XiaoMi/MiuiBrowser/4.3");
                BindFbActivity.this.mWebView.getSettings().setJavaScriptEnabled(true);
                BindFbActivity.this.mWebView.getSettings().setAllowFileAccess(false);
                HashMap hashMap = new HashMap();
                hashMap.put("userId", build.userId);
                hashMap.put("cUserId", build.encryptedUserId);
                hashMap.put("sns_token_ph", sNSBindParameter.f6205O000000o);
                hashMap.put("sns_weixin_openId", sNSBindParameter.O00000Oo);
                efm.O000000o(BindFbActivity.this.mWebView, hashMap);
                BindFbActivity.this.mWebView.loadUrl(sNSBindParameter.O00000o0);
                String localeString = BindFbActivity.this.getLocaleString(flk.O000000o());
                SmartHomeWebView smartHomeWebView = BindFbActivity.this.mWebView;
                smartHomeWebView.loadUrl(sNSBindParameter.O00000o0 + "&_locale=" + localeString);
            }
        });
    }

    public String getLocaleString(Locale locale) {
        if (locale == null) {
            return "zh_CN";
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }

    public String getUserAgent(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return this.mWebView.getSettings().getUserAgentString();
        }
        return WebSettings.getDefaultUserAgent(context);
    }
}

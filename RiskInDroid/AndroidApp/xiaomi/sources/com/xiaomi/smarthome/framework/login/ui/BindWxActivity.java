package com.xiaomi.smarthome.framework.login.ui;

import _m_j.efk;
import _m_j.efm;
import _m_j.flk;
import _m_j.ft;
import _m_j.fta;
import _m_j.gfr;
import _m_j.ibh;
import _m_j.ibl;
import _m_j.ibm;
import _m_j.ibz;
import _m_j.ice;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class BindWxActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    final BroadcastReceiver f7573O000000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            final String O0000o0 = CoreApi.O000000o().O0000o0();
            final String O0000o = CoreApi.O000000o().O0000o();
            final String str = ibm.f1156O000000o.O00000o;
            if (BindWxActivity.this.needRemove) {
                ft.O000000o(BindWxActivity.this.mAppContext).O000000o(this);
                BindWxActivity.this.needRemove = false;
            }
            boolean booleanExtra = intent.getBooleanExtra("login_success", false);
            String stringExtra = intent.getStringExtra("auth_code");
            if (booleanExtra) {
                BindWxActivity.this.showBindLoading();
                ice.O000000o(stringExtra, new ibh<ibz, Error>("xiaomiio") {
                    /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        String str;
                        ibz ibz = (ibz) obj;
                        String str2 = ibz.O00000Oo;
                        LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
                        if (O0000oOo == null) {
                            str = "";
                        } else {
                            str = O0000oOo.O00000o0();
                        }
                        efk efk = new efk(BindWxActivity.this);
                        if (TextUtils.isEmpty(str)) {
                            str = BindWxActivity.this.getPassToken(ServiceApplication.getAppContext());
                        }
                        if (!TextUtils.isEmpty(str)) {
                            SNSLoginParameter.O000000o o000000o = new SNSLoginParameter.O000000o();
                            o000000o.O00000Oo = "xiaomiio";
                            o000000o.O00000o = str;
                            o000000o.O00000oO = ibz.f1169O000000o;
                            o000000o.O0000O0o = String.valueOf(ibz.O00000o0);
                            o000000o.O0000OOo = str2;
                            SNSLoginParameter O000000o2 = o000000o.O000000o();
                            final AccountInfo build = new AccountInfo.Builder().userId(O0000o0).encryptedUserId(O0000o).passToken(str).build();
                            efk.O000000o(O000000o2, build, new efk.O000000o() {
                                /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void O000000o(int i, String str) {
                                    if (BindWxActivity.this.mHandler != null) {
                                        BindWxActivity.this.mHandler.sendEmptyMessage(101);
                                    }
                                }

                                public final void O000000o() {
                                    if (BindWxActivity.this.mHandler != null) {
                                        BindWxActivity.this.mHandler.sendEmptyMessage(101);
                                    }
                                }

                                public final void O000000o(SNSBindParameter sNSBindParameter) {
                                    BindWxActivity.this.mWebView.setWebViewClient(BindWxActivity.this.O00000Oo);
                                    String userAgent = BindWxActivity.this.getUserAgent(BindWxActivity.this);
                                    WebSettings settings = BindWxActivity.this.mWebView.getSettings();
                                    settings.setUserAgentString(userAgent + " AndroidSnsSDK/" + gfr.O00000oo + " XiaoMi/MiuiBrowser/4.3");
                                    BindWxActivity.this.mWebView.getSettings().setJavaScriptEnabled(true);
                                    BindWxActivity.this.mWebView.getSettings().setAllowFileAccess(false);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("userId", build.userId);
                                    hashMap.put("cUserId", build.encryptedUserId);
                                    hashMap.put("sns_token_ph", sNSBindParameter.f6205O000000o);
                                    hashMap.put("sns_weixin_openId", sNSBindParameter.O00000Oo);
                                    efm.O000000o(BindWxActivity.this.mWebView, hashMap);
                                    BindWxActivity.this.mWebView.loadUrl(sNSBindParameter.O00000o0);
                                    String localeString = BindWxActivity.this.getLocaleString(flk.O000000o());
                                    WebView webView = BindWxActivity.this.mWebView;
                                    webView.loadUrl(sNSBindParameter.O00000o0 + "&_locale=" + localeString);
                                }
                            });
                        } else if (BindWxActivity.this.mHandler != null) {
                            BindWxActivity.this.mHandler.sendEmptyMessage(101);
                        }
                    }

                    public final void onFailure(Error error) {
                        if (BindWxActivity.this.mHandler != null) {
                            BindWxActivity.this.mHandler.sendEmptyMessage(101);
                        }
                    }
                });
            } else if (BindWxActivity.this.mHandler != null) {
                BindWxActivity.this.mHandler.sendEmptyMessage(101);
            }
        }
    };
    WebViewClient O00000Oo = new WebViewClient() {
        /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass3 */

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (BindWxActivity.this.mHandler != null) {
                BindWxActivity.this.mHandler.sendEmptyMessage(104);
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String path = Uri.parse(efk.O00000Oo).getPath();
            String path2 = Uri.parse(efk.O00000o0).getPath();
            String path3 = Uri.parse(str).getPath();
            boolean equals = path2.equals(path3);
            boolean equals2 = path.equals(path3);
            if (equals) {
                if (BindWxActivity.this.mHandler != null) {
                    BindWxActivity.this.mHandler.sendEmptyMessage(102);
                }
                return true;
            } else if (!equals2) {
                return false;
            } else {
                if (BindWxActivity.this.mHandler != null) {
                    BindWxActivity.this.mHandler.sendEmptyMessage(103);
                }
                return true;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if ("com.xiaomi".equals(str)) {
                MiAccountManager O00000Oo = MiAccountManager.O00000Oo(BindWxActivity.this);
                Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                if (O000000o2.length != 0) {
                    O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, BindWxActivity.this, new AccountManagerCallback<Bundle>() {
                        /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass3.AnonymousClass1 */

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
                                BindWxActivity.this.mWebView.loadUrl(str);
                            }
                        }
                    }, (Handler) null);
                }
            }
        }
    };
    private final int O00000o = 101;
    private IWXAPI O00000o0;
    private final int O00000oO = 102;
    private final int O00000oo = 103;
    private final int O0000O0o = 104;
    private XQProgressDialog O0000OOo = null;
    public Context mAppContext;
    public WebView mWebView;
    public boolean needRemove = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_binwx_acitivity);
        this.mWebView = (WebView) findViewById(R.id.webview);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.login.ui.BindWxActivity.AnonymousClass1 */

            public final void onClick(View view) {
                BindWxActivity.this.finish();
            }
        });
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        this.mAppContext = ServiceApplication.getAppContext();
        ibl ibl = ibm.f1156O000000o;
        this.O00000o0 = ibl.O00000oO == null ? null : ibl.O00000oO.O000000o();
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "smarthome_" + System.currentTimeMillis();
        this.O00000o0.sendReq(req);
        if (!this.O00000o0.isWXAppInstalled()) {
            fta fta = fta.O000000o.f17086O000000o;
            fta.O000000o((int) R.string.mj_wx_not_installed);
            finish();
            return;
        }
        ft.O000000o(this.mAppContext).O000000o(this.f7573O000000o, new IntentFilter("action.wx.login.complete"));
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 101:
                fta fta = fta.O000000o.f17086O000000o;
                fta.O000000o((int) R.string.account_bind_failed);
                break;
            case 102:
                setResult(-1);
                break;
            case 103:
                break;
            case 104:
                O000000o();
                return;
            default:
                return;
        }
        finish();
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

    public String getPassToken(Context context) {
        ExtendedAuthToken parse;
        try {
            String O000000o2 = MiAccountManager.O00000Oo(context).O000000o(MiAccountManager.O00000Oo(context).O00000oo());
            if (!TextUtils.isEmpty(O000000o2) && (parse = ExtendedAuthToken.parse(O000000o2)) != null) {
                return parse.authToken;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void showBindLoading() {
        this.O0000OOo = new XQProgressDialog(this);
        this.O0000OOo.setCancelable(true);
        this.O0000OOo.setMessage(getString(R.string.account_binding_waiting));
        if (!isFinishing()) {
            this.O0000OOo.show();
        }
    }

    private void O000000o() {
        XQProgressDialog xQProgressDialog = this.O0000OOo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O0000OOo.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.needRemove) {
            ft.O000000o(this.mAppContext).O000000o(this.f7573O000000o);
            this.needRemove = false;
        }
        O000000o();
        this.mHandler = null;
    }
}

package com.xiaomi.smarthome.auth.bindaccount;

import _m_j.fal;
import _m_j.fln;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hkd;
import _m_j.hxi;
import _m_j.hxt;
import _m_j.hyg;
import _m_j.izb;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ThirdAccountAuthWebActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f4279O000000o;
    Context O00000Oo;
    int O00000o;
    String O00000o0;
    String O00000oO;
    String O00000oo;
    String O0000O0o;
    String O0000OOo;
    private String O0000Oo;
    boolean O0000Oo0;
    private String O0000OoO;
    private WebViewClient O0000Ooo;
    private WebChromeClient O0000o00;
    @BindView(5445)
    ImageView mActionBarBack;
    public String mGroupId;
    public XQProgressDialog mProcessDialog;
    @BindView(5364)
    ProgressBar mProgressBar;
    public String mResultUrl;
    public boolean mSyncCanceled = false;
    @BindView(5449)
    TextView mTitleView;
    @BindView(5999)
    WebView mWebView;

    public ThirdAccountAuthWebActivity() {
        String str;
        String str2;
        String str3 = "https://st-oauth-redirect-home.io.mi.com/o/";
        if (TextUtils.equals("preview", CoreApi.O000000o().O00oOooO())) {
            str = "https://pv-oauth-redirect-home.io.mi.com/o/";
        } else {
            str = ftn.O0000Oo0(CoreApi.O000000o().O0000ooO()) ? str3 : "https://oauth-redirect.api.home.mi.com/o/";
        }
        this.O0000Oo = str;
        if (TextUtils.equals("preview", CoreApi.O000000o().O00oOooO())) {
            str3 = "https://pv-oauth-redirect-home.io.mi.com/o/";
        } else if (!ftn.O0000Oo0(CoreApi.O000000o().O0000ooO())) {
            str3 = "https://oauth-redirect.api.home.mi.com/o/";
        }
        this.O00000o0 = str3;
        if (TextUtils.equals("preview", CoreApi.O000000o().O00oOooO())) {
            str2 = "https://pv-oauth-redirect-home.io.mi.com/result/";
        } else {
            str2 = ftn.O0000Oo0(CoreApi.O000000o().O0000ooO()) ? "https://st-oauth-redirect-home.io.mi.com/result/" : "https://oauth-redirect.api.home.mi.com/result/";
        }
        this.mResultUrl = str2;
        this.O0000OOo = "";
        this.O0000Oo0 = false;
        this.O0000Ooo = new WebViewClient() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass1 */

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                gsy.O000000o(LogType.GENERAL, "ThirdAccountAuthActivit", "onPageStarted url: ".concat(String.valueOf(str)));
                if (ThirdAccountAuthWebActivity.this.O0000Oo0) {
                    if (ThirdAccountAuthWebActivity.this.O0000OOo.equals(ThirdAccountAuthWebActivity.this.O0000O0o)) {
                        LogType logType = LogType.GENERAL;
                        gsy.O000000o(logType, "ThirdAccountAuthActivit", "onPageStarted url finish:" + ThirdAccountAuthWebActivity.this.O0000O0o);
                        ThirdAccountAuthWebActivity.this.finish();
                        return;
                    } else if (str.startsWith("https://account.xiaomi.com/pass/serviceLogin")) {
                        ThirdAccountAuthWebActivity thirdAccountAuthWebActivity = ThirdAccountAuthWebActivity.this;
                        thirdAccountAuthWebActivity.O0000Oo0 = false;
                        if (thirdAccountAuthWebActivity.mWebView != null && ThirdAccountAuthWebActivity.this.mWebView.canGoBack()) {
                            ThirdAccountAuthWebActivity.this.mWebView.goBack();
                            return;
                        }
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
                ThirdAccountAuthWebActivity.this.O0000Oo0 = false;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                gsy.O000000o(LogType.GENERAL, "ThirdAccountAuthActivit", "shouldOverrideUrlLoading url: ".concat(String.valueOf(str)));
                ThirdAccountAuthWebActivity.this.O0000Oo0 = false;
                if (!O000000o(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return true;
            }

            private boolean O000000o(String str) {
                if (!TextUtils.isEmpty(str) && str.startsWith(ThirdAccountAuthWebActivity.this.mResultUrl)) {
                    try {
                        Uri parse = Uri.parse(str);
                        gsy.O00000Oo("ThirdAccountAuthActivit", "url=".concat(String.valueOf(str)));
                        String queryParameter = parse.getQueryParameter("data");
                        if (TextUtils.isEmpty(queryParameter)) {
                            gqg.O00000Oo((int) R.string.failed);
                            gsy.O00000Oo(20000, "20000.1.1", "");
                            ThirdAccountAuthWebActivity.this.finish();
                            return true;
                        }
                        JSONObject jSONObject = new JSONObject(queryParameter);
                        gsy.O00000Oo("ThirdAccountAuthActivit", "url=" + jSONObject.toString());
                        if (jSONObject.isNull("code")) {
                            gqg.O00000Oo((int) R.string.failed);
                            gsy.O00000Oo(20000, "20000.1.1", "");
                            ThirdAccountAuthWebActivity.this.finish();
                            return true;
                        } else if (jSONObject.optInt("code") != 0) {
                            gqg.O00000Oo((int) R.string.failed);
                            gsy.O00000Oo(20000, "20000.1.1", "");
                            ThirdAccountAuthWebActivity.this.finish();
                            return true;
                        } else {
                            ThirdAccountAuthWebActivity.this.setResult(-1);
                            ThirdAccountAuthWebActivity.this.startUpdateThirdCloudData();
                            return true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                ThirdAccountAuthWebActivity.this.O0000Oo0 = false;
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            public final void onPageFinished(WebView webView, String str) {
                gsy.O000000o(LogType.GENERAL, "ThirdAccountAuthActivit", "onPageFinished url: ".concat(String.valueOf(str)));
                ThirdAccountAuthWebActivity.this.O0000OOo = ThirdAccountAuthWebActivity.O000000o(str);
                ThirdAccountAuthWebActivity.this.O0000Oo0 = false;
            }

            public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
                if ("com.xiaomi".equals(str)) {
                    try {
                        MiAccountManager O00000Oo = MiAccountManager.O00000Oo(ThirdAccountAuthWebActivity.this.getApplicationContext());
                        Account[] O000000o2 = O00000Oo.O000000o("com.xiaomi");
                        if (O000000o2.length != 0) {
                            O00000Oo.O000000o(O000000o2[0], "weblogin:".concat(String.valueOf(str3)), (Bundle) null, ThirdAccountAuthWebActivity.this, new AccountManagerCallback<Bundle>() {
                                /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass1.AnonymousClass1 */

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
                                        gsy.O000000o(LogType.GENERAL, "ThirdAccountAuthActivit", "web sso failed.");
                                        return;
                                    }
                                    if (ThirdAccountAuthWebActivity.this.mWebView != null) {
                                        ThirdAccountAuthWebActivity.this.mWebView.loadUrl(str);
                                    }
                                    gsy.O000000o(LogType.GENERAL, "ThirdAccountAuthActivit", "web sso succeed.");
                                }
                            }, (Handler) null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.O0000o00 = new WebChromeClient() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass2 */

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (!TextUtils.isEmpty(str)) {
                    ThirdAccountAuthWebActivity.this.mTitleView.setText(str);
                } else {
                    ThirdAccountAuthWebActivity.this.mTitleView.setText(ThirdAccountAuthWebActivity.this.O00000oO);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                if (i >= ThirdAccountAuthWebActivity.this.O00000o) {
                    ThirdAccountAuthWebActivity.this.mProgressBar.setVisibility(0);
                    if (ThirdAccountAuthWebActivity.this.mHandler != null) {
                        ThirdAccountAuthWebActivity.this.mHandler.removeMessages(1);
                        if (i >= ThirdAccountAuthWebActivity.this.mProgressBar.getProgress()) {
                            double d = (double) i;
                            Double.isNaN(d);
                            int i2 = (int) (d * 1.1d);
                            if (i2 <= 99) {
                                ThirdAccountAuthWebActivity.this.mProgressBar.setProgress(i2);
                                ThirdAccountAuthWebActivity.this.mProgressBar.postInvalidate();
                            }
                        }
                    }
                }
                if (i >= 90 && ThirdAccountAuthWebActivity.this.mHandler != null) {
                    ThirdAccountAuthWebActivity.this.mHandler.removeMessages(1);
                    ThirdAccountAuthWebActivity.this.mProgressBar.setVisibility(8);
                }
            }

            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(ThirdAccountAuthWebActivity.this.O00000Oo);
                builder.O00000Oo(str2);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                builder.O000000o(false);
                builder.O00000o().show();
                return true;
            }

            public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(ThirdAccountAuthWebActivity.this.O00000Oo);
                builder.O00000Oo(str2);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass2.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass2.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                });
                builder.O000000o(false);
                builder.O00000o().show();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                izb.O000000o(ThirdAccountAuthWebActivity.this.O00000Oo, str2, 0).show();
                return true;
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        };
    }

    public void handleMessage(Message message) {
        if (message.what == 1 && this.mProgressBar.getProgress() < this.O00000o) {
            ProgressBar progressBar = this.mProgressBar;
            progressBar.setProgress(progressBar.getProgress() + 1);
            this.mProgressBar.postInvalidate();
            this.mHandler.sendEmptyMessageDelayed(1, (long) ((((int) (Math.random() * 5.0d)) + 2) * 50));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mGroupId = intent.getStringExtra("account_id");
        if (TextUtils.isEmpty(this.mGroupId)) {
            finish();
            return;
        }
        setContentView((int) R.layout.comm_web_activity);
        ButterKnife.bind(this);
        this.O00000Oo = this;
        this.mProgressBar.setIndeterminateDrawable(null);
        this.mActionBarBack.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ThirdAccountAuthWebActivity.this.onBackPressed();
            }
        });
        this.O00000oO = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.O00000oO)) {
            this.mTitleView.setText(this.O00000oO);
        }
        WebSettings settings = this.mWebView.getSettings();
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        String userAgentString = settings.getUserAgentString();
        if (f4279O000000o == null) {
            f4279O000000o = userAgentString + fln.O000000o(this) + " XiaoMi/HybridView/";
        }
        settings.setUserAgentString(f4279O000000o);
        this.mWebView.setWebViewClient(this.O0000Ooo);
        this.mWebView.setWebChromeClient(this.O0000o00);
        this.mWebView.setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass4 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!TextUtils.isEmpty(str)) {
                    ThirdAccountAuthWebActivity.this.O00000Oo.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        });
        this.mWebView.requestFocus();
        CookieSyncManager.createInstance(getContext());
        CookieManager instance = CookieManager.getInstance();
        if (CoreApi.O000000o().O0000Ooo() && !CoreApi.O000000o().O0000oO0()) {
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (!TextUtils.isEmpty(O0000oO) && O0000oO != null) {
                instance.setCookie(".account.xiaomi.com", "passToken" + "=" + O0000oO + "; domain=" + ".account.xiaomi.com");
            }
            hkd.O000000o(instance, ".account.xiaomi.com");
            hkd.O000000o(this.mWebView);
        }
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProcessDialog.dismiss();
        }
        this.mSyncCanceled = false;
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(getResources().getString(R.string.loading_share_info));
        this.mProcessDialog.show();
        this.mProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass7 */

            public final void onDismiss(DialogInterface dialogInterface) {
                ThirdAccountAuthWebActivity.this.mSyncCanceled = true;
            }
        });
        fru.O000000o().O00000o(new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (ThirdAccountAuthWebActivity.this.isValid()) {
                    ThirdAccountAuthWebActivity.this.startOauth(jSONObject);
                    if (ThirdAccountAuthWebActivity.this.mProcessDialog != null && ThirdAccountAuthWebActivity.this.mProcessDialog.isShowing()) {
                        ThirdAccountAuthWebActivity.this.mProcessDialog.dismiss();
                    }
                }
            }

            public final void onFailure(fso fso) {
                if (ThirdAccountAuthWebActivity.this.isValid()) {
                    gsy.O00000Oo(20000, "20000.1.1", "");
                    gqg.O00000Oo((int) R.string.third_account_auth_failed);
                    if (ThirdAccountAuthWebActivity.this.mProcessDialog != null && ThirdAccountAuthWebActivity.this.mProcessDialog.isShowing()) {
                        ThirdAccountAuthWebActivity.this.mProcessDialog.dismiss();
                    }
                    ThirdAccountAuthWebActivity.this.finish();
                }
            }
        });
    }

    static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public void onResume() {
        super.onResume();
        this.mActionBarBack.requestFocus();
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

    public void onDestroy() {
        super.onDestroy();
        try {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.mWebView, null);
            this.mWebView.loadUrl("");
        } catch (Exception unused) {
        }
        WebView webView = this.mWebView;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            this.mWebView.removeAllViews();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.mWebView);
            }
            this.mWebView.destroy();
        }
    }

    public void onBackPressed() {
        try {
            if (this.mWebView == null || !this.mWebView.canGoBack()) {
                super.onBackPressed();
                return;
            }
            this.O0000Oo0 = true;
            this.mWebView.goBack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startUpdateThirdCloudData() {
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProcessDialog.dismiss();
        }
        this.mSyncCanceled = false;
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(getResources().getString(R.string.loading_share_info));
        this.mProcessDialog.show();
        this.mProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass5 */

            public final void onDismiss(DialogInterface dialogInterface) {
                ThirdAccountAuthWebActivity.this.mSyncCanceled = true;
            }
        });
        fal.getInstance().O000000o(new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountAuthWebActivity.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final void onFailure(fso fso) {
                if (ThirdAccountAuthWebActivity.this.isValid()) {
                    gsy.O00000Oo(20000, "20000.3.2", "");
                    ThirdAccountAuthWebActivity.this.mProcessDialog.dismiss();
                    ThirdAccountAuthWebActivity.this.finishHistory();
                    Intent intent = new Intent(CommonApplication.getAppContext(), ThirdAccountDeviceListActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("account_id", ThirdAccountAuthWebActivity.this.mGroupId);
                    intent.putExtra("sync_on_start", true);
                    ThirdAccountAuthWebActivity.this.startActivity(intent);
                    ThirdAccountAuthWebActivity.this.finish();
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final /* synthetic */ void onSuccess(Object obj) {
                if (ThirdAccountAuthWebActivity.this.isValid()) {
                    ThirdAccountAuthWebActivity.this.mProcessDialog.dismiss();
                    ThirdAccountAuthWebActivity.this.finishHistory();
                    Intent intent = new Intent(CommonApplication.getAppContext(), ThirdAccountDeviceListActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("account_id", ThirdAccountAuthWebActivity.this.mGroupId);
                    intent.putExtra("sync_on_start", true);
                    ThirdAccountAuthWebActivity.this.startActivity(intent);
                    ThirdAccountAuthWebActivity.this.finish();
                    hxt hxt = hxi.O0000Oo;
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    hyg hyg = hxt.f960O000000o;
                    Object[] objArr = new Object[2];
                    objArr[0] = "uid";
                    if (O0000o0 == null) {
                        O0000o0 = "null";
                    }
                    objArr[1] = O0000o0;
                    hyg.O000000o("ctoc_login", objArr);
                }
            }
        });
    }

    public void startOauth(JSONObject jSONObject) {
        String str = "";
        this.O0000OoO = jSONObject == null ? str : jSONObject.optString("result", str);
        if (jSONObject != null) {
            str = jSONObject.toString();
        }
        gsy.O00000Oo("ThirdAccountAuthActivit", str);
        if (TextUtils.isEmpty(this.O0000OoO)) {
            gqg.O00000Oo((int) R.string.third_account_auth_failed);
            finish();
            return;
        }
        this.O00000o0 = this.O0000Oo + this.mGroupId + "?state=" + this.O0000OoO;
        StringBuilder sb = new StringBuilder("mUrl=");
        sb.append(this.O00000o0);
        gsy.O00000Oo("ThirdAccountAuthActivit", sb.toString());
        if (!TextUtils.isEmpty(this.O00000o0)) {
            this.mWebView.loadUrl(this.O00000o0);
            this.O0000O0o = O000000o(this.O00000o0);
            this.O00000oo = this.O00000o0;
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "ThirdAccountAuthActivit", "onPageStarted url oncreate: " + this.O0000O0o);
        }
    }

    public void finishHistory() {
        Activity activity;
        try {
            Object[] array = mActivityStack.values().toArray();
            if (array == null) {
                return;
            }
            if (array.length != 0) {
                for (int length = array.length - 1; length >= 0; length--) {
                    WeakReference weakReference = (WeakReference) array[length];
                    if (!(weakReference == null || (activity = (Activity) weakReference.get()) == null || !TextUtils.equals(activity.getClass().getCanonicalName(), ThirdAccountDetailActivity.class.getCanonicalName()))) {
                        activity.finish();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

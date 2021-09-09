package com.xiaomi.smarthome.framework.webview;

import _m_j.eyk;
import _m_j.ezk;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fvd;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Collections;
import org.json.JSONObject;

public class WebShellActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f8806O000000o;
    TextView O00000Oo;
    String O00000o;
    WebView O00000o0;
    boolean O00000oO = false;
    String O00000oo;
    private WebViewClient O0000O0o = new WebViewClient() {
        /* class com.xiaomi.smarthome.framework.webview.WebShellActivity.AnonymousClass1 */

        public final void onPageFinished(WebView webView, String str) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebShellActivity.this.O00000Oo.setText((int) R.string.web_shell_loading);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                Uri parse = Uri.parse(str);
                if (fvd.O000000o(parse) && ezk.O000000o().shopLauncherResolve(WebShellActivity.this.f8806O000000o, str, true)) {
                    return true;
                }
                if (str.startsWith("tel") || str.startsWith("mailto")) {
                    WebShellActivity.this.f8806O000000o.startActivity(new Intent("android.intent.action.VIEW", parse));
                    return true;
                }
                if (str.startsWith("xmbbsapp://bbs.xiaomi.cn")) {
                    eyk.O000000o(WebShellActivity.this.f8806O000000o, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            } else if (WebShellActivity.this.mCurrentUrl == null || str == null || !str.equals(WebShellActivity.this.mCurrentUrl)) {
                webView.loadUrl(str);
                WebShellActivity.this.mCurrentUrl = str;
                return true;
            } else {
                WebShellActivity.this.O00000o0.goBack();
                return true;
            }
        }
    };
    private WebChromeClient O0000OOo = new WebChromeClient() {
        /* class com.xiaomi.smarthome.framework.webview.WebShellActivity.AnonymousClass2 */

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(WebShellActivity.this.O00000oo)) {
                WebShellActivity.this.O00000Oo.setText(str);
            } else {
                WebShellActivity.this.O00000Oo.setText(WebShellActivity.this.O00000oo);
            }
        }
    };
    private Disposable O0000Oo0;
    public String mCurrentUrl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8806O000000o = this;
        setContentView((int) R.layout.web_shell_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.webview.WebShellActivity.AnonymousClass3 */

            public final void onClick(View view) {
                WebShellActivity.this.onBackPressed();
            }
        });
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0 = (WebView) findViewById(R.id.webview);
        this.O00000o = getIntent().getStringExtra("url");
        this.O00000oO = getIntent().getBooleanExtra("show_feedback", false);
        int intExtra = getIntent().getIntExtra("title_id", -1);
        if (intExtra != -1) {
            this.O00000oo = getString(intExtra);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            this.O00000o0.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        this.O00000o0.getSettings().setJavaScriptEnabled(true);
        this.O00000o0.getSettings().setAllowFileAccess(false);
        this.O00000o0.getSettings().setDomStorageEnabled(true);
        this.O00000o0.setFocusable(true);
        this.O00000o0.setFocusableInTouchMode(true);
        this.O00000o0.requestFocusFromTouch();
        this.O00000o0.requestFocus();
        this.O00000o0.setVisibility(0);
        this.O00000o0.setWebViewClient(this.O0000O0o);
        this.O00000o0.setWebChromeClient(this.O0000OOo);
        this.O00000o0.setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.smarthome.framework.webview.WebShellActivity.AnonymousClass4 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                try {
                    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    WebShellActivity.this.f8806O000000o.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (!TextUtils.isEmpty(this.O00000o)) {
            this.O00000o0.loadUrl(this.O00000o);
        } else {
            finish();
        }
        View findViewById = findViewById(R.id.feedback_btn);
        if (this.O00000oO) {
            this.O0000Oo0 = Single.create(new SingleOnSubscribe<Boolean>("device_search_feedback_grey") {
                /* class _m_j.fmf.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f16607O000000o;

                {
                    this.f16607O000000o = r1;
                }

                public final void subscribe(final SingleEmitter<Boolean> singleEmitter) throws Exception {
                    fmf.O000000o(Collections.singletonList(this.f16607O000000o), new fsm<JSONObject, fso>() {
                        /* class _m_j.fmf.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (!singleEmitter.isDisposed()) {
                                try {
                                    singleEmitter.onSuccess(Boolean.valueOf(jSONObject.getJSONObject("key_result").getBoolean(AnonymousClass1.this.f16607O000000o)));
                                } catch (Exception e) {
                                    singleEmitter.onError(e);
                                }
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (!singleEmitter.isDisposed()) {
                                singleEmitter.onError(new Exception(fso.O00000Oo));
                            }
                        }
                    });
                }
            }).onErrorReturnItem(Boolean.FALSE).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(findViewById) {
                /* class com.xiaomi.smarthome.framework.webview.$$Lambda$WebShellActivity$vA9C3TKKNnuS2EXNgQDTZ9vUEms */
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    WebShellActivity.this.O000000o(this.f$1, (Boolean) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view, Boolean bool) throws Exception {
        view.setVisibility(bool.booleanValue() ? 0 : 8);
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.webview.$$Lambda$WebShellActivity$k0pacSLe8cI5x_vwJuNTMRL8k */

            public final void onClick(View view) {
                WebShellActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        fbt fbt = new fbt(this, "/userCenter/FeedbackActivity");
        fbt.O000000o("extra_device_model", "exp");
        fbt.O000000o("extra_source", 0);
        fbs.O000000o(fbt);
        finish();
    }

    public String getActivityName() {
        return getClass().getName() + "(" + this.O00000o + ")";
    }

    public void onResume() {
        super.onResume();
        this.O00000o0.onResume();
    }

    public void onPause() {
        super.onPause();
        this.O00000o0.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000o0.destroy();
        Disposable disposable = this.O0000Oo0;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onBackPressed() {
        WebView webView = this.O00000o0;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.O00000o0.goBack();
        }
    }
}

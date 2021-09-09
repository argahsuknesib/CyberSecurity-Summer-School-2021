package com.tencent.open;

import _m_j.dij;
import _m_j.dit;
import _m_j.diy;
import _m_j.diz;
import _m_j.djm;
import _m_j.djp;
import _m_j.djx;
import _m_j.djz;
import _m_j.dkb;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.b.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class TDialog extends b {

    /* renamed from: O000000o  reason: collision with root package name */
    static final FrameLayout.LayoutParams f5865O000000o = new FrameLayout.LayoutParams(-1, -1);
    static Toast O00000Oo = null;
    private static WeakReference<ProgressDialog> O00000oo;
    /* access modifiers changed from: private */
    public WeakReference<Context> O00000oO;
    private String O0000O0o;
    /* access modifiers changed from: private */
    public OnTimeListener O0000OOo;
    private FrameLayout O0000Oo;
    private djz O0000Oo0;
    /* access modifiers changed from: private */
    public b O0000OoO;
    /* access modifiers changed from: private */
    public Handler O0000Ooo;
    private dij O0000o0 = null;
    private boolean O0000o00 = false;

    class THandler extends Handler {
        private OnTimeListener b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.b = onTimeListener;
        }

        public void handleMessage(Message message) {
            diz.O00000Oo("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i != 3) {
                if (i != 4 && i == 5 && TDialog.this.O00000oO != null && TDialog.this.O00000oO.get() != null) {
                    TDialog.O00000Oo((Context) TDialog.this.O00000oO.get(), (String) message.obj);
                }
            } else if (TDialog.this.O00000oO != null && TDialog.this.O00000oO.get() != null) {
                TDialog.O000000o((Context) TDialog.this.O00000oO.get(), (String) message.obj);
            }
        }
    }

    static class OnTimeListener extends djx {

        /* renamed from: a  reason: collision with root package name */
        String f5869a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private djz e;

        public OnTimeListener(Context context, String str, String str2, String str3, djz djz) {
            this.c = new WeakReference<>(context);
            this.d = str;
            this.f5869a = str2;
            this.b = str3;
            this.e = djz;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(djp.O00000o(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new dkb(-4, "服务器返回数据格式有误!", str));
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            diy O000000o2 = diy.O000000o();
            O000000o2.O000000o(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt("ret", -6), this.f5869a);
            djz djz = this.e;
            if (djz != null) {
                djz.onComplete(jSONObject);
                this.e = null;
            }
        }

        public void onError(dkb dkb) {
            String str;
            if (dkb.O00000Oo != null) {
                str = dkb.O00000Oo + this.f5869a;
            } else {
                str = this.f5869a;
            }
            diy O000000o2 = diy.O000000o();
            O000000o2.O000000o(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, dkb.f14735O000000o, str);
            djz djz = this.e;
            if (djz != null) {
                djz.onError(dkb);
                this.e = null;
            }
        }

        public void onCancel() {
            djz djz = this.e;
            if (djz != null) {
                djz.onCancel();
                this.e = null;
            }
        }
    }

    public TDialog(Context context, String str, String str2, djz djz, dij dij) {
        super(context);
        this.O00000oO = new WeakReference<>(context);
        this.O0000O0o = str2;
        this.O0000OOo = new OnTimeListener(context, str, str2, dij.f14674O000000o, djz);
        this.O0000Ooo = new THandler(this.O0000OOo, context.getMainLooper());
        this.O0000Oo0 = djz;
        this.O0000o0 = dij;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        new TextView(this.O00000oO.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.O0000OoO = new b(this.O00000oO.get());
        this.O0000OoO.setLayoutParams(layoutParams);
        this.O0000Oo = new FrameLayout(this.O00000oO.get());
        layoutParams.gravity = 17;
        this.O0000Oo.setLayoutParams(layoutParams);
        this.O0000Oo.addView(this.O0000OoO);
        setContentView(this.O0000Oo);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.open.TDialog.AnonymousClass1 */

            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window != null && (decorView = window.getDecorView()) != null && (childAt = ((ViewGroup) decorView).getChildAt(0)) != null) {
                    childAt.setPadding(0, 0, 0, 0);
                }
            }
        });
        this.O0000OoO.setVerticalScrollBarEnabled(false);
        this.O0000OoO.setHorizontalScrollBarEnabled(false);
        this.O0000OoO.setWebViewClient(new FbWebViewClient());
        this.O0000OoO.setWebChromeClient(this.O00000o);
        this.O0000OoO.clearFormData();
        WebSettings settings = this.O0000OoO.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            WeakReference<Context> weakReference = this.O00000oO;
            if (!(weakReference == null || weakReference.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.O00000oO.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.O00000o0.O000000o(new JsListener(), "sdk_js_if");
            this.O0000OoO.loadUrl(this.O0000O0o);
            this.O0000OoO.setLayoutParams(f5865O000000o);
            this.O0000OoO.setVisibility(4);
            this.O0000OoO.getSettings().setSavePassword(false);
        }
    }

    public final void onBackPressed() {
        OnTimeListener onTimeListener = this.O0000OOo;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        diz.O00000Oo("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.O00000o0.O000000o(this.O0000OoO, str);
        } catch (Exception unused) {
        }
    }

    class JsListener extends dit.O00000Oo {
        private JsListener() {
        }

        public void onAddShare(String str) {
            diz.O00000Oo("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onCancelAddShare(String str) {
            diz.O00000oO("openSDK_LOG.TDialog", "JsListener onCancelAddShare".concat(String.valueOf(str)));
            onCancel("cancel");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onCancelInvite() {
            diz.O00000oO("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.O0000Ooo.obtainMessage(1, str).sendToTarget();
            diz.O00000oO("openSDK_LOG.TDialog", "JsListener onComplete".concat(String.valueOf(str)));
            TDialog.this.dismiss();
        }

        public void onCancel(String str) {
            diz.O00000oO("openSDK_LOG.TDialog", "JsListener onCancel --msg = ".concat(String.valueOf(str)));
            TDialog.this.O0000Ooo.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void showMsg(String str) {
            TDialog.this.O0000Ooo.obtainMessage(3, str).sendToTarget();
        }

        public void onLoad(String str) {
            TDialog.this.O0000Ooo.obtainMessage(4, str).sendToTarget();
        }
    }

    class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri;
            diz.O000000o("openSDK_LOG.TDialog", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(djm.O000000o().O000000o((Context) TDialog.this.O00000oO.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.O0000OOo.onComplete(djp.O00000o0(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://cancel")) {
                TDialog.this.O0000OOo.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://close")) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("download://") || str.endsWith(".apk")) {
                try {
                    if (str.startsWith("download://")) {
                        uri = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        uri = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    if (!(TDialog.this.O00000oO == null || TDialog.this.O00000oO.get() == null)) {
                        ((Context) TDialog.this.O00000oO.get()).startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                return true;
            } else {
                return false;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.O0000OOo.onError(new dkb(i, str, str2));
            if (!(TDialog.this.O00000oO == null || TDialog.this.O00000oO.get() == null)) {
                Toast.makeText((Context) TDialog.this.O00000oO.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            diz.O000000o("openSDK_LOG.TDialog", "Webview loading URL: ".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.O0000OoO.setVisibility(0);
        }
    }

    static /* synthetic */ void O000000o(Context context, String str) {
        try {
            JSONObject O00000o = djp.O00000o(str);
            int i = O00000o.getInt("type");
            String string = O00000o.getString("msg");
            if (i == 0) {
                if (O00000Oo == null) {
                    O00000Oo = Toast.makeText(context, string, 0);
                } else {
                    Toast toast = O00000Oo;
                    toast.setView(toast.getView());
                    O00000Oo.setText(string);
                    O00000Oo.setDuration(0);
                }
                O00000Oo.show();
            } else if (i == 1) {
                if (O00000Oo == null) {
                    O00000Oo = Toast.makeText(context, string, 1);
                } else {
                    Toast toast2 = O00000Oo;
                    toast2.setView(toast2.getView());
                    O00000Oo.setText(string);
                    O00000Oo.setDuration(1);
                }
                O00000Oo.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void O00000Oo(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject O00000o = djp.O00000o(str);
                int i = O00000o.getInt("action");
                String string = O00000o.getString("msg");
                if (i == 1) {
                    if (O00000oo != null) {
                        if (O00000oo.get() != null) {
                            O00000oo.get().setMessage(string);
                            if (!O00000oo.get().isShowing()) {
                                O00000oo.get().show();
                                return;
                            }
                            return;
                        }
                    }
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    O00000oo = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else if (i == 0 && O00000oo != null && O00000oo.get() != null && O00000oo.get().isShowing()) {
                    O00000oo.get().dismiss();
                    O00000oo = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

package _m_j;

import _m_j.dil;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.tencent.open.b.c;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.security.JniInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class dik extends Dialog {
    /* access modifiers changed from: package-private */

    /* renamed from: O000000o  reason: collision with root package name */
    public c f14675O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;
    private djz O00000o;
    /* access modifiers changed from: private */
    public O00000Oo O00000o0;
    /* access modifiers changed from: private */
    public Handler O00000oO;
    private FrameLayout O00000oo;
    private LinearLayout O0000O0o;
    /* access modifiers changed from: private */
    public FrameLayout O0000OOo;
    private Button O0000Oo;
    private ProgressBar O0000Oo0;
    private String O0000OoO;
    /* access modifiers changed from: private */
    public Context O0000Ooo;
    /* access modifiers changed from: private */
    public String O0000o;
    /* access modifiers changed from: private */
    public boolean O0000o0 = false;
    /* access modifiers changed from: private */
    public dju O0000o00;
    /* access modifiers changed from: private */
    public int O0000o0O;
    /* access modifiers changed from: private */
    public String O0000o0o;
    /* access modifiers changed from: private */
    public long O0000oO = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    /* access modifiers changed from: private */
    public long O0000oO0 = 0;
    /* access modifiers changed from: private */
    public HashMap<String, Runnable> O0000oOO;

    static /* synthetic */ int O0000o00(dik dik) {
        int i = dik.O0000o0O;
        dik.O0000o0O = i + 1;
        return i;
    }

    public dik(Context context, String str, String str2, djz djz, dij dij) {
        super(context, 16973840);
        this.O0000Ooo = context;
        this.O00000Oo = str2;
        this.O00000o0 = new O00000Oo(str, str2, dij.f14674O000000o, djz);
        this.O00000oO = new O00000o0(this.O00000o0, context.getMainLooper());
        this.O00000o = djz;
        this.O0000OoO = str;
        this.O0000o00 = new dju();
        getWindow().setSoftInputMode(32);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        TextView textView;
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 16) {
                decorView.setSystemUiVisibility(1280);
            }
        }
        this.O0000Oo0 = new ProgressBar(this.O0000Ooo);
        this.O0000Oo0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.O0000O0o = new LinearLayout(this.O0000Ooo);
        if (this.O0000OoO.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.O0000Ooo);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.O0000O0o.setLayoutParams(layoutParams2);
        this.O0000O0o.addView(this.O0000Oo0);
        if (textView != null) {
            this.O0000O0o.addView(textView);
        }
        this.O0000OOo = new FrameLayout(this.O0000Ooo);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.O0000OOo.setLayoutParams(layoutParams3);
        this.O0000OOo.setBackgroundColor(Color.parseColor("#B3000000"));
        this.O0000OOo.addView(this.O0000O0o);
        this.O0000Oo = new Button(this.O0000Ooo);
        this.O0000Oo.setBackgroundDrawable(djp.O000000o("h5_qr_back.png", this.O0000Ooo));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = din.O000000o(this.O0000Ooo, 20.0f);
        layoutParams4.topMargin = din.O000000o(this.O0000Ooo, 10.0f);
        this.O0000Oo.setLayoutParams(layoutParams4);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.dik.AnonymousClass1 */

            public final void onClick(View view) {
                dik.this.dismiss();
                if (!dik.this.O0000o0 && dik.this.O00000o0 != null) {
                    dik.this.O00000o0.onCancel();
                }
            }
        });
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -1);
        this.f14675O000000o = new c(this.O0000Ooo);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f14675O000000o.setLayerType(1, null);
        }
        this.f14675O000000o.setLayoutParams(layoutParams5);
        this.O00000oo = new FrameLayout(this.O0000Ooo);
        layoutParams5.gravity = 17;
        this.O00000oo.setLayoutParams(layoutParams5);
        this.O00000oo.addView(this.f14675O000000o);
        this.O00000oo.addView(this.O0000OOo);
        String string = djp.O00000Oo(this.O00000Oo).getString("style");
        if (string != null && "qr".equals(string)) {
            this.O00000oo.addView(this.O0000Oo);
        }
        setContentView(this.O00000oo);
        this.f14675O000000o.setVerticalScrollBarEnabled(false);
        this.f14675O000000o.setHorizontalScrollBarEnabled(false);
        this.f14675O000000o.setWebViewClient(new O000000o(this, (byte) 0));
        this.f14675O000000o.setWebChromeClient(new WebChromeClient());
        this.f14675O000000o.clearFormData();
        this.f14675O000000o.clearSslPreferences();
        this.f14675O000000o.setOnLongClickListener(new View.OnLongClickListener() {
            /* class _m_j.dik.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                return true;
            }
        });
        this.f14675O000000o.setOnTouchListener(new View.OnTouchListener() {
            /* class _m_j.dik.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f14675O000000o.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.O0000Ooo.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        diz.O000000o("openSDK_LOG.AuthDialog", "-->mUrl : " + this.O00000Oo);
        String str = this.O00000Oo;
        this.O0000o0o = str;
        this.f14675O000000o.loadUrl(str);
        this.f14675O000000o.setVisibility(4);
        this.f14675O000000o.getSettings().setSavePassword(false);
        this.O0000o00.O000000o(new djs(), "SecureJsInterface");
        djs.f14730O000000o = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class _m_j.dik.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.f5882O000000o) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
        this.O0000oOO = new HashMap<>();
    }

    public final void onBackPressed() {
        if (!this.O0000o0) {
            this.O00000o0.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        super.onStop();
    }

    class O00000o0 extends Handler {
        private O00000Oo O00000Oo;

        public O00000o0(O00000Oo o00000Oo, Looper looper) {
            super(looper);
            this.O00000Oo = o00000Oo;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                O00000Oo o00000Oo = this.O00000Oo;
                String str = (String) message.obj;
                try {
                    o00000Oo.onComplete(djp.O00000o(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    o00000Oo.onError(new dkb(-4, "服务器返回数据格式有误!", str));
                }
            } else if (i == 2) {
                this.O00000Oo.onCancel();
            } else if (i == 3) {
                dik.O000000o(dik.this.O0000Ooo, (String) message.obj);
            }
        }
    }

    class O00000Oo extends djx {

        /* renamed from: O000000o  reason: collision with root package name */
        String f14684O000000o;
        String O00000Oo;
        private String O00000o;
        private djz O00000oO;

        public O00000Oo(String str, String str2, String str3, djz djz) {
            this.O00000o = str;
            this.f14684O000000o = str2;
            this.O00000Oo = str3;
            this.O00000oO = djz;
        }

        public final void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            diy O000000o2 = diy.O000000o();
            O000000o2.O000000o(this.O00000o + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt("ret", -6), this.f14684O000000o);
            djz djz = this.O00000oO;
            if (djz != null) {
                djz.onComplete(jSONObject);
                this.O00000oO = null;
            }
        }

        public final void onError(dkb dkb) {
            String str;
            if (dkb.O00000Oo != null) {
                str = dkb.O00000Oo + this.f14684O000000o;
            } else {
                str = this.f14684O000000o;
            }
            diy.O000000o().O000000o(this.O00000o + "_H5", SystemClock.elapsedRealtime(), 0, 0, dkb.f14735O000000o, str);
            dik.O000000o(dik.this, str);
            djz djz = this.O00000oO;
            if (djz != null) {
                djz.onError(dkb);
                this.O00000oO = null;
            }
        }

        public final void onCancel() {
            djz djz = this.O00000oO;
            if (djz != null) {
                djz.onCancel();
                this.O00000oO = null;
            }
        }
    }

    class O000000o extends WebViewClient {
        private O000000o() {
        }

        /* synthetic */ O000000o(dik dik, byte b) {
            this();
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri;
            diz.O000000o("openSDK_LOG.AuthDialog", "-->Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith("auth://browser")) {
                JSONObject O00000o0 = djp.O00000o0(str);
                dik dik = dik.this;
                boolean unused = dik.O0000o0 = dik.O00000Oo(dik);
                if (!dik.this.O0000o0) {
                    if (O00000o0.optString("fail_cb", null) != null) {
                        dik dik2 = dik.this;
                        String optString = O00000o0.optString("fail_cb");
                        dik2.f14675O000000o.loadUrl("javascript:" + optString + "(" + "" + ");void(" + System.currentTimeMillis() + ");");
                    } else if (O00000o0.optInt("fall_to_wv") == 1) {
                        dik dik3 = dik.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(dik.this.O00000Oo);
                        String str2 = "?";
                        if (dik.this.O00000Oo.indexOf(str2) >= 0) {
                            str2 = "&";
                        }
                        sb.append(str2);
                        String unused2 = dik3.O00000Oo = sb.toString();
                        dik dik4 = dik.this;
                        String unused3 = dik4.O00000Oo = dik.this.O00000Oo + "browser_error=1";
                        dik.this.f14675O000000o.loadUrl(dik.this.O00000Oo);
                    } else {
                        String optString2 = O00000o0.optString("redir", null);
                        if (optString2 != null) {
                            dik.this.f14675O000000o.loadUrl(optString2);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                dik.this.O00000o0.onComplete(djp.O00000o0(str));
                dik.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                dik.this.O00000o0.onCancel();
                dik.this.dismiss();
                return true;
            } else if (str.startsWith("auth://close")) {
                dik.this.dismiss();
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
                    dik.this.O0000Ooo.startActivity(intent);
                } catch (Exception e) {
                    diz.O00000Oo("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                try {
                    List<String> pathSegments = Uri.parse(str).getPathSegments();
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        dik.this.O0000OOo.setVisibility(8);
                        dik.this.f14675O000000o.setVisibility(0);
                    } else if (intValue == 1) {
                        dik.this.O0000OOo.setVisibility(0);
                    }
                    return true;
                } catch (Exception unused4) {
                }
            } else if (str.startsWith("auth://onLoginSubmit")) {
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (!pathSegments2.isEmpty()) {
                        String unused5 = dik.this.O0000o = pathSegments2.get(0);
                    }
                } catch (Exception unused6) {
                }
                return true;
            } else if (dik.this.O0000o00.O000000o(dik.this.f14675O000000o, str)) {
                return true;
            } else {
                diz.O00000o0("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            diz.O00000o0("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!djp.O000000o(dik.this.O0000Ooo)) {
                dik.this.O00000o0.onError(new dkb(9001, "当前网络不可用，请稍后重试！", str2));
                dik.this.dismiss();
            } else if (!dik.this.O0000o0o.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - dik.this.O0000oO0;
                if (dik.this.O0000o0O > 0 || elapsedRealtime >= dik.this.O0000oO) {
                    dik.this.f14675O000000o.loadUrl(dik.O0000o0O(dik.this));
                    return;
                }
                dik.O0000o00(dik.this);
                dik.this.O00000oO.postDelayed(new Runnable() {
                    /* class _m_j.dik.O000000o.AnonymousClass1 */

                    public final void run() {
                        dik.this.f14675O000000o.loadUrl(dik.this.O0000o0o);
                    }
                }, 500);
            } else {
                dik.this.O00000o0.onError(new dkb(i, str, str2));
                dik.this.dismiss();
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            diz.O000000o("openSDK_LOG.AuthDialog", "-->onPageStarted, url: ".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
            dik.this.O0000OOo.setVisibility(0);
            long unused = dik.this.O0000oO0 = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(dik.this.O0000o0o)) {
                dik.this.O00000oO.removeCallbacks((Runnable) dik.this.O0000oOO.remove(dik.this.O0000o0o));
            }
            String unused2 = dik.this.O0000o0o = str;
            dik dik = dik.this;
            O00000o o00000o = new O00000o(dik.O0000o0o);
            dik.this.O0000oOO.put(str, o00000o);
            dik.this.O00000oO.postDelayed(o00000o, 120000);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            diz.O000000o("openSDK_LOG.AuthDialog", "-->onPageFinished, url: ".concat(String.valueOf(str)));
            dik.this.O0000OOo.setVisibility(8);
            if (dik.this.f14675O000000o != null) {
                dik.this.f14675O000000o.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                dik.this.O00000oO.removeCallbacks((Runnable) dik.this.O0000oOO.remove(str));
            }
        }

        @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
        public final void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            diz.O00000oO("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str2 = "ssl证书无效，是否继续访问？";
                str = "是";
                str3 = "否";
            } else {
                str2 = "The SSL certificate is invalid,do you countinue?";
                str = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(dik.this.O0000Ooo);
            builder.setMessage(str2);
            builder.setPositiveButton(str, new DialogInterface.OnClickListener() {
                /* class _m_j.dik.O000000o.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new DialogInterface.OnClickListener() {
                /* class _m_j.dik.O000000o.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    dik.this.dismiss();
                }
            });
            builder.create().show();
        }
    }

    class O00000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        String f14685O000000o = "";

        public O00000o(String str) {
            this.f14685O000000o = str;
        }

        public final void run() {
            diz.O000000o("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f14685O000000o + " | mRetryUrl: " + dik.this.O0000o0o);
            if (this.f14685O000000o.equals(dik.this.O0000o0o)) {
                dik.this.O00000o0.onError(new dkb(9002, "请求页面超时，请稍后重试！", dik.this.O0000o0o));
                dik.this.dismiss();
            }
        }
    }

    public final void dismiss() {
        this.O0000oOO.clear();
        this.O00000oO.removeCallbacksAndMessages(null);
        try {
            if ((this.O0000Ooo instanceof Activity) && !((Activity) this.O0000Ooo).isFinishing() && isShowing()) {
                super.dismiss();
                diz.O00000o0("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e) {
            diz.O00000Oo("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        c cVar = this.f14675O000000o;
        if (cVar != null) {
            cVar.destroy();
            this.f14675O000000o = null;
        }
    }

    static /* synthetic */ void O000000o(Context context, String str) {
        try {
            JSONObject O00000o2 = djp.O00000o(str);
            int i = O00000o2.getInt("type");
            Toast.makeText(context.getApplicationContext(), O00000o2.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ String O000000o(dik dik, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(dik.O0000o) && dik.O0000o.length() >= 4) {
            String str2 = dik.O0000o;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    static /* synthetic */ boolean O00000Oo(dik dik) {
        dil O000000o2 = dil.O000000o();
        String O00000Oo2 = dil.O00000Oo();
        dil.O000000o o000000o = new dil.O000000o();
        o000000o.f14688O000000o = dik.O00000o;
        o000000o.O00000Oo = dik;
        o000000o.O00000o0 = O00000Oo2;
        String O000000o3 = O000000o2.O000000o(o000000o);
        String str = dik.O00000Oo;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle O00000Oo3 = djp.O00000Oo(dik.O00000Oo);
        O00000Oo3.putString("token_key", O00000Oo2);
        O00000Oo3.putString("serial", O000000o3);
        O00000Oo3.putString("browser", "1");
        dik.O00000Oo = substring + "?" + HttpUtils.O000000o(O00000Oo3);
        return djp.O000000o(dik.O0000Ooo, dik.O00000Oo);
    }

    static /* synthetic */ String O0000o0O(dik dik) {
        String str = dik.O00000Oo;
        String concat = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?".concat(String.valueOf(str.substring(str.indexOf("?") + 1)));
        diz.O00000o0("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return concat;
    }
}

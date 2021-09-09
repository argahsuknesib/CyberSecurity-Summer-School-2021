package _m_j;

import _m_j.iar;
import _m_j.iav;
import _m_j.iax;
import _m_j.iaz;
import _m_j.ibb;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.passport.SecurityDeviceSignManager;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import com.xiaomi.smarthome.R;
import com.xiaomi.verificationsdk.VerificationManager$11;
import com.xiaomi.verificationsdk.VerificationManager$3$1;
import com.xiaomi.verificationsdk.internal.EnvEncryptUtils;
import com.xiaomi.verificationsdk.internal.ErrorInfo;
import com.xiaomi.verificationsdk.internal.SensorHelper;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class iar {
    private static final ExecutorService O00oOooO = Executors.newCachedThreadPool();

    /* renamed from: O000000o  reason: collision with root package name */
    public SensorHelper f1116O000000o;
    public O00000Oo O00000Oo;
    public LinearLayout O00000o;
    public WebView O00000o0;
    public AlertDialog O00000oO;
    public Handler O00000oo;
    public String O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public boolean O0000OoO;
    public String O0000Ooo;
    public boolean O0000o;
    public String O0000o0;
    public String O0000o00;
    public String O0000o0O;
    public String O0000o0o;
    public int O0000oO;
    public int O0000oO0;
    public iay O0000oOO;
    public boolean O0000oOo = true;
    public final AtomicBoolean O0000oo = new AtomicBoolean(false);
    public View O0000oo0;
    public DialogInterface.OnKeyListener O0000ooO = new DialogInterface.OnKeyListener() {
        /* class _m_j.iar.AnonymousClass1 */

        public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            iar iar = iar.this;
            if (iar.O00000oO != null) {
                iar.O00000oO.hide();
            }
            if (iar.this.O00000Oo == null) {
                return true;
            }
            iar.this.O00000oo.post(new Runnable() {
                /* class _m_j.iar.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    iar.this.O00000Oo.O000000o();
                    iar.O000000o(iar.this.O0000oo);
                }
            });
            return true;
        }
    };
    public DialogInterface.OnDismissListener O0000ooo = new DialogInterface.OnDismissListener() {
        /* class _m_j.iar.AnonymousClass3 */

        public final void onDismiss(DialogInterface dialogInterface) {
            if (iar.this.O0000oOo && iar.this.O00000Oo != null) {
                iar.this.O00000oo.post(new Runnable() {
                    /* class _m_j.iar.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        iar.this.O00000Oo.O000000o();
                        iar.O000000o(iar.this.O0000oo);
                    }
                });
            }
        }
    };
    private WeakReference<Activity> O000O00o;
    private SimpleFutureTask<iau> O00oOooo;

    public interface O000000o {
        void O000000o(iaz iaz);

        void O000000o(ibb ibb);

        void O000000o(String str);
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(iaz iaz);

        void O000000o(ibb ibb);
    }

    public iar(Activity activity) {
        if (activity != null) {
            this.O00000oo = new Handler(Looper.getMainLooper());
            this.O000O00o = new WeakReference<>(activity);
            this.f1116O000000o = new SensorHelper(activity.getApplicationContext());
            this.O0000oOO = new iay(activity, "VerificationConfig");
            return;
        }
        throw new IllegalArgumentException("activity  should not be null");
    }

    public final void O000000o() {
        O00000oo();
    }

    public final void O00000Oo() {
        SensorHelper sensorHelper = this.f1116O000000o;
        sensorHelper.O0000OoO = "";
        sensorHelper.O00000oo = new JSONArray();
        sensorHelper.O0000O0o = new JSONArray();
        sensorHelper.O0000OOo = new JSONArray();
        sensorHelper.O0000Oo0 = new JSONArray();
        sensorHelper.O0000Oo = new JSONArray();
        O00000oo();
    }

    private void O00000oo() {
        this.O0000oO0 = this.O0000oOO.O000000o("maxduration", 5000);
        this.O0000oO = this.O0000oOO.O000000o("frequency", 50);
        this.f1116O000000o.O000000o(this.O0000oO, this.O0000oO0);
        if (Math.abs(System.currentTimeMillis() - this.O0000oOO.O000000o("lastDownloadTime")) > 86400000) {
            AccountLog.i("VerificationManager", "get config from server");
            O00000o(iav.O000000o(this.O0000o0O, "/captcha/v2/config"));
        }
    }

    public final void O00000o0() {
        if (this.O0000oo.compareAndSet(false, true)) {
            if (TextUtils.isEmpty(this.O0000Ooo)) {
                throw new IllegalArgumentException("key is null");
            } else if (!TextUtils.isEmpty(this.O0000o00)) {
                this.O0000oOo = true;
                if (this.O00000Oo != null) {
                    this.O0000Oo0 = false;
                    O00oOooO.execute(new Runnable() {
                        /* class _m_j.iar.AnonymousClass7 */

                        public final void run() {
                            int i = 1;
                            if (TextUtils.isEmpty(iar.this.f1116O000000o.O0000OoO)) {
                                SensorHelper sensorHelper = iar.this.f1116O000000o;
                                if (sensorHelper.O00000oO == 0) {
                                    Log.i("SensorHelper", "Collected Data not start");
                                } else {
                                    CountDownLatch countDownLatch = new CountDownLatch(1);
                                    sensorHelper.O000000o();
                                    sensorHelper.f12046O000000o.post(new Runnable(System.currentTimeMillis(), countDownLatch) {
                                        /* class com.xiaomi.verificationsdk.internal.SensorHelper.AnonymousClass1 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ long f12047O000000o;
                                        final /* synthetic */ CountDownLatch O00000Oo;

                                        {
                                            this.f12047O000000o = r2;
                                            this.O00000Oo = r4;
                                        }

                                        public final void run() {
                                            SensorHelper sensorHelper = SensorHelper.this;
                                            sensorHelper.O0000OoO = sensorHelper.O000000o(sensorHelper.O00000oO, this.f12047O000000o);
                                            this.O00000Oo.countDown();
                                        }
                                    });
                                    try {
                                        countDownLatch.await();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(iar.this.f1116O000000o.O0000OoO);
                                JSONObject jSONObject2 = jSONObject.getJSONObject("env");
                                if (!iar.this.O0000Oo) {
                                    i = 0;
                                }
                                jSONObject2.put("voiceover", i);
                                jSONObject.put("env", jSONObject2);
                                jSONObject.put("force", iar.this.O0000OoO);
                                jSONObject.put("uid", iar.this.O0000o0);
                                jSONObject.put("version", "2.0");
                                jSONObject.put("scene", iar.this.O0000o00);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("r", new SecureRandom().nextLong());
                                jSONObject3.put("t", System.currentTimeMillis() / 1000);
                                jSONObject.put("nonce", jSONObject3);
                                iar.this.f1116O000000o.O0000OoO = jSONObject.toString();
                                SensorHelper sensorHelper2 = iar.this.f1116O000000o;
                                String str = iar.this.f1116O000000o.O0000OoO;
                                String str2 = iar.this.O0000Ooo;
                                String str3 = iar.this.O0000o00;
                                Boolean valueOf = Boolean.valueOf(iar.this.O0000OOo);
                                String str4 = iar.this.O0000o0o;
                                String str5 = iar.this.O0000o0O;
                                Boolean valueOf2 = Boolean.valueOf(iar.this.O0000o);
                                AnonymousClass1 r3 = new O000000o() {
                                    /* class _m_j.iar.AnonymousClass7.AnonymousClass1 */

                                    public final void O000000o(final ibb ibb) {
                                        iar.this.O00000Oo();
                                        iar.this.O00000oo.post(new Runnable() {
                                            /* class _m_j.iar.AnonymousClass7.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                iar.this.O00000Oo.O000000o(ibb);
                                                iar.O000000o(iar.this.O0000oo);
                                            }
                                        });
                                    }

                                    public final void O000000o(final iaz iaz) {
                                        iar.this.O000000o(iaz.f1143O000000o, iaz.O00000Oo);
                                        iar.this.O00000oo.post(new Runnable() {
                                            /* class _m_j.iar.AnonymousClass7.AnonymousClass1.AnonymousClass2 */

                                            public final void run() {
                                                iar.this.O00000Oo.O000000o(iaz);
                                            }
                                        });
                                    }

                                    public final void O000000o(final String str) {
                                        iar.this.O0000O0o = str;
                                        iar.this.O0000OOo = false;
                                        iar.this.O00000oo.post(new Runnable() {
                                            /* class _m_j.iar.AnonymousClass7.AnonymousClass1.AnonymousClass3 */

                                            public final void run() {
                                                NetworkInfo[] allNetworkInfo;
                                                iar iar = iar.this;
                                                String str = str;
                                                Activity O00000oO = iar.O00000oO();
                                                if (O00000oO != null) {
                                                    ConnectivityManager connectivityManager = (ConnectivityManager) O00000oO.getSystemService("connectivity");
                                                    boolean z = false;
                                                    if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                                                        int i = 0;
                                                        while (true) {
                                                            if (i >= allNetworkInfo.length) {
                                                                break;
                                                            } else if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                                                                z = true;
                                                                break;
                                                            } else {
                                                                i++;
                                                            }
                                                        }
                                                    }
                                                    if (!z) {
                                                        iar.O000000o(ErrorInfo.ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION.getCode(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION));
                                                        iar.O00000oo.post(new Runnable(iar.O000000o(ErrorInfo.ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION.getCode(), "network disconnected")) {
                                                            /* class _m_j.iar.AnonymousClass8 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ iaz f1137O000000o;

                                                            {
                                                                this.f1137O000000o = r2;
                                                            }

                                                            public final void run() {
                                                                iar.this.O00000Oo.O000000o(this.f1137O000000o);
                                                                iar.O000000o(iar.this.O0000oo);
                                                            }
                                                        });
                                                    } else if (iar.O00000oO() != null) {
                                                        iar.O00000oo.post(new Runnable(str) {
                                                            /* class _m_j.iar.AnonymousClass4 */

                                                            /* renamed from: O000000o  reason: collision with root package name */
                                                            final /* synthetic */ String f1122O000000o;

                                                            {
                                                                this.f1122O000000o = r2;
                                                            }

                                                            public final void run() {
                                                                AlertDialog.Builder builder;
                                                                String str;
                                                                Activity O00000oO = iar.this.O00000oO();
                                                                if (O00000oO != null) {
                                                                    if (iar.this.O0000oo0 == null) {
                                                                        iar.this.O0000oo0 = O00000oO.getLayoutInflater().inflate((int) R.layout.verify_dialog, (ViewGroup) null);
                                                                        iar.this.O0000oo0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                                                                    }
                                                                    if (iar.this.O00000o0 == null) {
                                                                        iar iar = iar.this;
                                                                        iar.O00000o0 = (WebView) iar.O0000oo0.findViewById(R.id.verify_webView);
                                                                    }
                                                                    if (iar.this.O00000o == null) {
                                                                        iar iar2 = iar.this;
                                                                        iar2.O00000o = (LinearLayout) iar2.O0000oo0.findViewById(R.id.verify_ProgressBar);
                                                                    }
                                                                    if (iar.this.O00000o != null && iar.this.O00000o.getVisibility() == 0) {
                                                                        iar.this.O00000o.setVisibility(8);
                                                                    }
                                                                    if (iar.this.O00000oO != null) {
                                                                        iar.this.O00000oO.dismiss();
                                                                        iar.this.O00000oO = null;
                                                                    }
                                                                    if (!TextUtils.isEmpty(this.f1122O000000o)) {
                                                                        if (Build.VERSION.SDK_INT >= 21) {
                                                                            builder = new AlertDialog.Builder(O00000oO, 16974394);
                                                                        } else {
                                                                            iar.this.O00000o0.setLayerType(1, null);
                                                                            builder = new AlertDialog.Builder(O00000oO);
                                                                        }
                                                                        if (Build.VERSION.SDK_INT >= 19 && (O00000oO.getApplicationInfo().flags & 2) != 0) {
                                                                            WebView.setWebContentsDebuggingEnabled(true);
                                                                        }
                                                                        WebSettings settings = iar.this.O00000o0.getSettings();
                                                                        settings.setSupportMultipleWindows(true);
                                                                        settings.setJavaScriptEnabled(true);
                                                                        settings.setUseWideViewPort(true);
                                                                        iar iar3 = iar.this;
                                                                        if (Build.VERSION.SDK_INT < 19) {
                                                                            str = iar3.O00000o0.getSettings().getUserAgentString();
                                                                        } else {
                                                                            str = WebSettings.getDefaultUserAgent(O00000oO);
                                                                        }
                                                                        settings.setUserAgentString(str + " androidVerifySDK/3.1.8 androidVerifySDK/VersionCode/31800" + " AppPackageName/" + O00000oO.getPackageName());
                                                                        iar.this.O00000o0.setWebChromeClient(new VerificationManager$3$1(this));
                                                                        iar.this.O00000o0.setWebViewClient(new WebViewClient() {
                                                                            /* class _m_j.iar.AnonymousClass4.AnonymousClass1 */

                                                                            public final void onPageFinished(WebView webView, String str) {
                                                                                iar.this.O00000o.setVisibility(8);
                                                                                if (iar.this.O00000o0.getVisibility() == 4) {
                                                                                    iar.this.O00000o0.setVisibility(0);
                                                                                }
                                                                                super.onPageFinished(webView, str);
                                                                            }

                                                                            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
                                                                            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                                                                                Bundle bundle;
                                                                                if (str.contains("/captcha/status")) {
                                                                                    String str2 = new String(str);
                                                                                    int indexOf = str2.indexOf(63);
                                                                                    if (indexOf > 0) {
                                                                                        String substring = str2.substring(indexOf + 1);
                                                                                        if (substring.startsWith("code=") || substring.startsWith("errorCode=") || substring.startsWith("errorStatus=")) {
                                                                                            bundle = iaw.O000000o(str2);
                                                                                            if (bundle != null) {
                                                                                                int parseInt = Integer.parseInt(bundle.getString("code"));
                                                                                                String string = bundle.getString("errorCode");
                                                                                                String string2 = bundle.getString("errorStatus");
                                                                                                String string3 = bundle.getString("flag");
                                                                                                AccountLog.i("VerificationManager", "code=" + parseInt + ";errorCode=" + string + ";errorStatus=" + string2);
                                                                                                if (parseInt == 0) {
                                                                                                    iar.this.O00000Oo();
                                                                                                    iar.this.O0000oOo = false;
                                                                                                    iar.this.O00000o();
                                                                                                    iar.this.O0000O0o = "";
                                                                                                    iar.this.O0000OOo = false;
                                                                                                    ibb.O000000o o000000o = new ibb.O000000o();
                                                                                                    o000000o.f1146O000000o = string3;
                                                                                                    o000000o.O00000Oo = null;
                                                                                                    final ibb O000000o2 = o000000o.O000000o();
                                                                                                    iar.this.O00000oo.post(new Runnable() {
                                                                                                        /* class _m_j.iar.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                                                                                        public final void run() {
                                                                                                            iar.this.O00000Oo.O000000o(O000000o2);
                                                                                                            iar.O000000o(iar.this.O0000oo);
                                                                                                        }
                                                                                                    });
                                                                                                    return true;
                                                                                                } else if (parseInt == 1) {
                                                                                                    iar.this.O0000oOo = false;
                                                                                                    iar.this.O0000Oo0 = true;
                                                                                                    iar.this.O00000o();
                                                                                                    iar.this.O00000oo.post(new Runnable() {
                                                                                                        /* class _m_j.iar.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                                                                                                        public final void run() {
                                                                                                            iar.this.O00000Oo.O000000o();
                                                                                                            iar.O000000o(iar.this.O0000oo);
                                                                                                        }
                                                                                                    });
                                                                                                } else if (parseInt == 2) {
                                                                                                    iar.this.O0000oOo = false;
                                                                                                    iar.this.O00000o();
                                                                                                    iar.this.O0000OOo = true;
                                                                                                    final iaz O000000o3 = iar.O000000o(ErrorInfo.ErrorCode.ERROR_EVENTID_EXPIRED.getCode(), "eventid expired");
                                                                                                    iar.this.O00000oo.post(new Runnable() {
                                                                                                        /* class _m_j.iar.AnonymousClass4.AnonymousClass1.AnonymousClass3 */

                                                                                                        public final void run() {
                                                                                                            iar.this.O00000Oo.O000000o(O000000o3);
                                                                                                            iar.O000000o(iar.this.O0000oo);
                                                                                                        }
                                                                                                    });
                                                                                                } else if (parseInt == 3) {
                                                                                                    iar.this.O0000oOo = false;
                                                                                                    iar.this.O00000o();
                                                                                                    iar.this.O0000O0o = "";
                                                                                                    iar.this.O0000OOo = false;
                                                                                                    ibb.O000000o o000000o2 = new ibb.O000000o();
                                                                                                    o000000o2.f1146O000000o = EnvEncryptUtils.O000000o();
                                                                                                    final ibb O000000o4 = o000000o2.O000000o();
                                                                                                    iar.this.O00000oo.post(new Runnable() {
                                                                                                        /* class _m_j.iar.AnonymousClass4.AnonymousClass1.AnonymousClass4 */

                                                                                                        public final void run() {
                                                                                                            iar.this.O00000Oo.O000000o(O000000o4);
                                                                                                            iar.O000000o(iar.this.O0000oo);
                                                                                                        }
                                                                                                    });
                                                                                                } else if (parseInt == 95008 || parseInt == 95009) {
                                                                                                    iar.this.O0000oOo = false;
                                                                                                    iar.this.O00000o();
                                                                                                    iar.this.O0000OOo = false;
                                                                                                    final iaz O000000o5 = iar.O000000o(ErrorInfo.ErrorCode.ERROR_VERIFY_SERVER.getCode(), "code=" + parseInt + ";errorCode=" + string + ";errorStatus=" + string2);
                                                                                                    iar.this.O00000oo.post(new Runnable() {
                                                                                                        /* class _m_j.iar.AnonymousClass4.AnonymousClass1.AnonymousClass5 */

                                                                                                        public final void run() {
                                                                                                            iar.this.O00000Oo.O000000o(O000000o5);
                                                                                                            iar.O000000o(iar.this.O0000oo);
                                                                                                        }
                                                                                                    });
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    bundle = null;
                                                                                    if (bundle != null) {
                                                                                    }
                                                                                }
                                                                                return false;
                                                                            }

                                                                            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                                                                                iar.this.O00000o.setVisibility(0);
                                                                                if (iar.this.O00000o0.getVisibility() == 0) {
                                                                                    iar.this.O00000o0.setVisibility(4);
                                                                                }
                                                                                super.onPageStarted(webView, str, bitmap);
                                                                            }
                                                                        });
                                                                        iar.this.O00000o0.loadUrl(this.f1122O000000o);
                                                                        ViewGroup viewGroup = (ViewGroup) iar.this.O0000oo0.getParent();
                                                                        if (viewGroup != null) {
                                                                            viewGroup.removeAllViews();
                                                                        }
                                                                        iar.this.O00000oO = builder.create();
                                                                        iar.this.O00000oO.setView(iar.this.O0000oo0);
                                                                        iar.this.O00000oO.setOnKeyListener(iar.this.O0000ooO);
                                                                        iar.this.O00000oO.setOnDismissListener(iar.this.O0000ooo);
                                                                        iar.this.O00000oO.show();
                                                                        iar.O000000o(iar.this.O00000oO.getWindow(), O00000oO.getWindowManager());
                                                                        return;
                                                                    }
                                                                    throw new IllegalArgumentException("showDialog:url should not be null");
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            }
                                        });
                                    }
                                };
                                iax.f1141O000000o = null;
                                sensorHelper2.f12046O000000o.post(new Runnable(r3, str, str2, str3, valueOf, str4, str5, valueOf2) {
                                    /* class com.xiaomi.verificationsdk.internal.SensorHelper.AnonymousClass2 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ iar.O000000o f12048O000000o;
                                    final /* synthetic */ String O00000Oo;
                                    final /* synthetic */ String O00000o;
                                    final /* synthetic */ String O00000o0;
                                    final /* synthetic */ Boolean O00000oO;
                                    final /* synthetic */ String O00000oo;
                                    final /* synthetic */ String O0000O0o;
                                    final /* synthetic */ Boolean O0000OOo;

                                    {
                                        this.f12048O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                        this.O00000o = r5;
                                        this.O00000oO = r6;
                                        this.O00000oo = r7;
                                        this.O0000O0o = r8;
                                        this.O0000OOo = r9;
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: com.xiaomi.accountsdk.request.SimpleRequest.postAsString(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, boolean, java.lang.Integer):com.xiaomi.accountsdk.request.SimpleRequest$StringContent
                                     arg types: [java.lang.String, com.xiaomi.accountsdk.utils.EasyMap, ?[OBJECT, ARRAY], com.xiaomi.accountsdk.utils.EasyMap, int, int]
                                     candidates:
                                      com.xiaomi.accountsdk.request.SimpleRequest.postAsString(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, boolean):com.xiaomi.accountsdk.request.SimpleRequest$StringContent
                                      com.xiaomi.accountsdk.request.SimpleRequest.postAsString(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, java.util.Map<java.lang.String, java.lang.String>, boolean, java.lang.Integer):com.xiaomi.accountsdk.request.SimpleRequest$StringContent */
                                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[SYNTHETIC, Splitter:B:24:0x0098] */
                                    /* JADX WARNING: Removed duplicated region for block: B:26:0x009f A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ed A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:44:0x0152 A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:46:0x016a A[Catch:{ JSONException -> 0x029e, EncryptException -> 0x0274, IOException -> 0x026d, AccessDeniedException -> 0x0243, AuthenticationFailureException -> 0x0219 }] */
                                    public final void run() {
                                        String str;
                                        String str2;
                                        SimpleRequest.StringContent postAsString;
                                        try {
                                            if (this.f12048O000000o != null) {
                                                EnvEncryptUtils.O000000o O000000o2 = EnvEncryptUtils.O000000o(this.O00000Oo);
                                                try {
                                                    Bundle bundle = SecurityDeviceSignManager.O000000o(SensorHelper.this.O00000Oo, this.O00000o0 + this.O00000o + O000000o2.O00000Oo + O000000o2.f12045O000000o, null).get(3000, TimeUnit.MILLISECONDS);
                                                    if (bundle != null) {
                                                        if (bundle.getBoolean("booleanResult")) {
                                                            str = bundle.getString("userData");
                                                            EasyMap easyMap = new EasyMap();
                                                            if (!this.O00000oO.booleanValue()) {
                                                                easyMap.easyPut("s", "");
                                                                easyMap.easyPut("d", "");
                                                            } else {
                                                                easyMap.easyPut("s", O000000o2.O00000Oo);
                                                                easyMap.easyPut("d", O000000o2.f12045O000000o);
                                                            }
                                                            if (!TextUtils.isEmpty(str)) {
                                                                easyMap.easyPut("t", str);
                                                            }
                                                            if (!TextUtils.isEmpty(this.O00000o)) {
                                                                easyMap.easyPut("a", this.O00000o);
                                                            }
                                                            String property = System.getProperty("http.agent");
                                                            EasyMap easyPut = new EasyMap().easyPut("User-Agent", property + " AndroidVerifySDK/3.1.8");
                                                            str2 = this.O00000oo;
                                                            if (TextUtils.isEmpty(str2)) {
                                                                Locale locale = Locale.getDefault();
                                                                if (locale == null) {
                                                                    str2 = null;
                                                                } else {
                                                                    String language = locale.getLanguage();
                                                                    String country = locale.getCountry();
                                                                    if (TextUtils.isEmpty(country)) {
                                                                        str2 = language;
                                                                    } else {
                                                                        str2 = String.format("%s_%s", language, country);
                                                                    }
                                                                }
                                                            }
                                                            postAsString = SimpleRequest.postAsString(iav.O000000o(this.O0000O0o, "/captcha/v2/data?") + "k=" + this.O00000o0 + "&locale=" + str2 + "&errorAction=" + this.O0000OOo, (Map<String, String>) easyMap, (Map<String, String>) null, (Map<String, String>) easyPut, true, (Integer) 3000);
                                                            if (postAsString != null) {
                                                                this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_NETWORK_EXCEPTION.getCode(), "uploadData:network exception", ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_NETWORK_EXCEPTION)));
                                                                return;
                                                            }
                                                            JSONObject jSONObject = new JSONObject(postAsString.getBody());
                                                            int optInt = jSONObject.optInt("code");
                                                            String optString = jSONObject.optString("msg");
                                                            if (optInt == 0) {
                                                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                                                boolean optBoolean = jSONObject2.optBoolean("result");
                                                                String optString2 = jSONObject2.optString("token");
                                                                String optString3 = jSONObject2.optString("url");
                                                                JSONObject optJSONObject = jSONObject2.optJSONObject("extra");
                                                                if (optJSONObject != null) {
                                                                    iax.f1141O000000o = optJSONObject.toString();
                                                                }
                                                                if (!TextUtils.isEmpty(optString3)) {
                                                                    this.f12048O000000o.O000000o(optString3);
                                                                    return;
                                                                } else if (optBoolean) {
                                                                    ibb.O000000o o000000o = new ibb.O000000o();
                                                                    o000000o.f1146O000000o = optString2;
                                                                    o000000o.O00000Oo = null;
                                                                    this.f12048O000000o.O000000o(o000000o.O000000o());
                                                                    return;
                                                                } else {
                                                                    this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_HUMANCOMPUTER_VERIFICATION_FAILED.getCode(), "uploadData:human computer verification failed", ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_HUMANCOMPUTER_VERIFICATION_FAILED)));
                                                                    return;
                                                                }
                                                            } else if (optInt == 500) {
                                                                ibb.O000000o o000000o2 = new ibb.O000000o();
                                                                o000000o2.f1146O000000o = EnvEncryptUtils.O000000o();
                                                                this.f12048O000000o.O000000o(o000000o2.O000000o());
                                                                return;
                                                            } else {
                                                                this.f12048O000000o.O000000o(SensorHelper.O000000o(optInt, "uploadData:".concat(String.valueOf(optString)), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_SERVER)));
                                                                return;
                                                            }
                                                        } else {
                                                            int i = bundle.getInt("errorCode");
                                                            String string = bundle.getString("errorMessage");
                                                            AccountLog.i("SensorHelper", "error code: ".concat(String.valueOf(i)));
                                                            AccountLog.i("SensorHelper", "error msg: ".concat(String.valueOf(string)));
                                                        }
                                                    }
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                } catch (ExecutionException e2) {
                                                    e2.printStackTrace();
                                                } catch (TimeoutException e3) {
                                                    e3.printStackTrace();
                                                }
                                                str = "";
                                                EasyMap easyMap2 = new EasyMap();
                                                if (!this.O00000oO.booleanValue()) {
                                                }
                                                if (!TextUtils.isEmpty(str)) {
                                                }
                                                if (!TextUtils.isEmpty(this.O00000o)) {
                                                }
                                                String property2 = System.getProperty("http.agent");
                                                EasyMap easyPut2 = new EasyMap().easyPut("User-Agent", property2 + " AndroidVerifySDK/3.1.8");
                                                str2 = this.O00000oo;
                                                if (TextUtils.isEmpty(str2)) {
                                                }
                                                postAsString = SimpleRequest.postAsString(iav.O000000o(this.O0000O0o, "/captcha/v2/data?") + "k=" + this.O00000o0 + "&locale=" + str2 + "&errorAction=" + this.O0000OOo, (Map<String, String>) easyMap2, (Map<String, String>) null, (Map<String, String>) easyPut2, true, (Integer) 3000);
                                                if (postAsString != null) {
                                                }
                                            } else {
                                                throw new IllegalArgumentException("uploadData :verifyCallback not be null");
                                            }
                                        } catch (JSONException e4) {
                                            AccountLog.e("SensorHelper", "fail to parse JSONObject", e4);
                                            this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_JSON_EXCEPTION.getCode(), "uploadData:" + e4.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_JSON_EXCEPTION)));
                                        } catch (EnvEncryptUtils.EncryptException e5) {
                                            AccountLog.e("SensorHelper", "", e5);
                                            this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_ENCRYPT_EXCEPTION.getCode(), "uploadData:" + e5.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_ENCRYPT_EXCEPTION)));
                                        } catch (IOException e6) {
                                            SensorHelper.O000000o(this.f12048O000000o, e6);
                                        } catch (AccessDeniedException e7) {
                                            AccountLog.e("SensorHelper", "", e7);
                                            this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_ACCESSDENIED_EXCEPTION.getCode(), "uploadData:" + e7.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_ACCESSDENIED_EXCEPTION)));
                                        } catch (AuthenticationFailureException e8) {
                                            AccountLog.e("SensorHelper", "", e8);
                                            this.f12048O000000o.O000000o(SensorHelper.O000000o(ErrorInfo.ErrorCode.ERROR_AUTHENTICATIONFAILURE_EXCEPTION.getCode(), "uploadData:" + e8.toString(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_AUTHENTICATIONFAILURE_EXCEPTION)));
                                        }
                                    }
                                });
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                iar.this.O000000o(ErrorInfo.ErrorCode.ERROR_JSON_EXCEPTION.getCode(), ErrorInfo.getMsgIdGivenErrorCode(ErrorInfo.ErrorCode.ERROR_JSON_EXCEPTION));
                                int code = ErrorInfo.ErrorCode.ERROR_JSON_EXCEPTION.getCode();
                                final iaz O000000o2 = iar.O000000o(code, "registere:" + e2.toString());
                                iar.this.O00000oo.post(new Runnable() {
                                    /* class _m_j.iar.AnonymousClass7.AnonymousClass2 */

                                    public final void run() {
                                        iar.this.O00000Oo.O000000o(O000000o2);
                                        iar.O000000o(iar.this.O0000oo);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("startVerify: mVerifyResultCallback should not be null");
            } else {
                throw new IllegalArgumentException("action is null");
            }
        }
    }

    static void O000000o(AtomicBoolean atomicBoolean) {
        atomicBoolean.getAndSet(false);
    }

    public final void O00000o() {
        AlertDialog alertDialog = this.O00000oO;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.O00000oO = null;
        }
    }

    public final void O000000o(final int i, final int i2) {
        if (O00000oO() != null) {
            this.O00000oo.post(new Runnable() {
                /* class _m_j.iar.AnonymousClass5 */

                public final void run() {
                    Activity O00000oO = iar.this.O00000oO();
                    if (O00000oO != null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(O00000oO, 16974394);
                        TextView textView = new TextView(O00000oO);
                        textView.setText(O00000oO.getResources().getString(i2) + "(" + i + ")");
                        textView.setPadding(0, 40, 0, 0);
                        textView.setGravity(17);
                        builder.setView(textView);
                        iar.this.O00000oO = builder.create();
                        iar.this.O00000oO.show();
                        iar.O000000o(iar.this.O00000oO.getWindow(), O00000oO.getWindowManager());
                    }
                }
            });
            this.O00000oo.postDelayed(new Runnable() {
                /* class _m_j.iar.AnonymousClass6 */

                public final void run() {
                    iar iar = iar.this;
                    iar.O0000oOo = false;
                    iar.O00000o();
                }
            }, 2000);
        }
    }

    private SimpleFutureTask<iau> O00000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00oOooo = new SimpleFutureTask<>(new VerificationManager$11(this, str), new SimpleFutureTask.O000000o<iau>() {
                /* class _m_j.iar.AnonymousClass2 */

                public final void O000000o(SimpleFutureTask<iau> simpleFutureTask) {
                    try {
                        iau iau = (iau) simpleFutureTask.get();
                        if (iau != null) {
                            iar.this.O0000oO = iau.O00000Oo;
                            iar.this.O0000oO0 = iau.f1139O000000o;
                            iay iay = iar.this.O0000oOO;
                            iay.f1142O000000o.edit().putLong("lastDownloadTime", System.currentTimeMillis()).commit();
                            iar.this.O0000oOO.O00000Oo("frequency", iar.this.O0000oO);
                            iar.this.O0000oOO.O00000Oo("maxduration", iar.this.O0000oO0);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            O00oOooO.submit(this.O00oOooo);
            return this.O00oOooo;
        }
        throw new IllegalArgumentException("getConfig: url is null");
    }

    public static iaz O000000o(int i, String str) {
        iaz.O000000o o000000o = new iaz.O000000o();
        o000000o.f1144O000000o = i;
        o000000o.O00000Oo = str;
        return o000000o.O000000o();
    }

    public final iar O000000o(String str) {
        this.O0000Ooo = str;
        return this;
    }

    public final iar O00000Oo(String str) {
        this.O0000o00 = str;
        return this;
    }

    public final iar O00000o0(String str) {
        this.O0000o0O = str;
        return this;
    }

    public final iar O000000o(Boolean bool) {
        this.O0000o = bool.booleanValue();
        return this;
    }

    public final iar O000000o(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
        return this;
    }

    public final Activity O00000oO() {
        WeakReference<Activity> weakReference = this.O000O00o;
        if (weakReference == null) {
            return null;
        }
        Activity activity = weakReference.get();
        if (activity != null && !activity.isFinishing()) {
            return activity;
        }
        Log.e("VerificationManager", "Activity is destroy");
        return null;
    }

    public static void O000000o(Window window, WindowManager windowManager) {
        window.clearFlags(131072);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.gravity = 81;
        window.setAttributes(attributes);
    }
}

package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.open.TDialog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class dii extends dio {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14666O000000o = "libwbsafeedit";
    public static String O00000Oo;
    djz O00000o0;
    private String O0000Oo;
    /* access modifiers changed from: private */
    public WeakReference<Activity> O0000OoO;

    static {
        O00000Oo = f14666O000000o + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            f14666O000000o = "libwbsafeedit";
            O00000Oo = f14666O000000o + ".so";
            diz.O00000o0("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            f14666O000000o = "libwbsafeedit_64";
            O00000Oo = f14666O000000o + ".so";
            diz.O00000o0("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            f14666O000000o = "libwbsafeedit_x86";
            O00000Oo = f14666O000000o + ".so";
            diz.O00000o0("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            f14666O000000o = "libwbsafeedit_x86_64";
            O00000Oo = f14666O000000o + ".so";
            diz.O00000o0("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            f14666O000000o = "libwbsafeedit";
            O00000Oo = f14666O000000o + ".so";
            diz.O00000o0("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public dii(dij dij) {
        super(dij, (byte) 0);
    }

    class O00000Oo extends djx {
        private final djz O00000Oo;
        private final Context O00000o;
        private final boolean O00000o0 = true;

        public O00000Oo(Context context, djz djz) {
            this.O00000o = context;
            this.O00000Oo = djz;
            diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        public final void onComplete(Object obj) {
            diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (!(string == null || dii.this.O00000oO == null || string3 == null)) {
                    dii.this.O00000oO.O000000o(string, string2);
                    dii.this.O00000oO.O00000o0 = string3;
                    dih.O00000Oo(this.O00000o, dii.this.O00000oO);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.O00000o.getSharedPreferences("pfStore", 0).edit().putString("pf", string4).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.O00000o0) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.O00000Oo.onComplete(jSONObject);
            dii.this.O00000o0 = null;
            diz.O000000o();
        }

        public final void onError(dkb dkb) {
            diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.O00000Oo.onError(dkb);
            diz.O000000o();
        }

        public final void onCancel() {
            diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.O00000Oo.onCancel();
            diz.O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dii.O000000o(boolean, _m_j.djz, boolean):int
     arg types: [int, _m_j.djz, boolean]
     candidates:
      _m_j.dio.O000000o(android.app.Activity, android.content.Intent, java.util.Map<java.lang.String, java.lang.Object>):void
      _m_j.dio.O000000o(androidx.fragment.app.Fragment, android.content.Intent, java.util.Map<java.lang.String, java.lang.Object>):void
      _m_j.dii.O000000o(boolean, _m_j.djz, boolean):int */
    public final int O000000o(Activity activity, String str, djz djz, boolean z, Fragment fragment, boolean z2, Map<String, Object> map) {
        this.O0000Oo = str;
        this.O0000OoO = new WeakReference<>(activity);
        this.O00000o0 = djz;
        Object[] objArr = new Object[2];
        if (activity.getIntent().getBooleanExtra("KEY_FORCE_QR_LOGIN", false) || djl.O000000o(activity, this.O00000oO.f14674O000000o).O00000Oo("C_LoginWeb") || !O000000o(activity, fragment, null, false, objArr)) {
            diw.O000000o();
            diw.O000000o(this.O00000oO.O00000o0, this.O00000oO.f14674O000000o, "2", "1", "5", "1", "0", "0");
            diz.O00000o("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            this.O00000o0 = new O000000o(this.O00000o0);
            return O000000o(false, this.O00000o0, z2);
        }
        diz.O00000o0("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
        diw.O000000o();
        diw.O000000o(this.O00000oO.O00000o0, this.O00000oO.f14674O000000o, "2", "1", "5", (String) objArr[0], "0", "0");
        return ((Integer) objArr[1]).intValue();
    }

    private int O000000o(boolean z, djz djz, boolean z2) {
        diz.O00000o0("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(djk.O000000o());
        Bundle O000000o2 = O000000o();
        if (z) {
            O000000o2.putString("isadd", "1");
        }
        O000000o2.putString("scope", this.O0000Oo);
        O000000o2.putString("client_id", this.O00000oO.f14674O000000o);
        if (O0000Oo0) {
            O000000o2.putString("pf", "desktop_m_qq-" + O0000O0o + "-android-" + O00000oo + "-" + O0000OOo);
        } else {
            O000000o2.putString("pf", "openmobile_android");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        String sb2 = sb.toString();
        O000000o2.putString("sign", djn.O00000Oo(djk.O000000o(), sb2));
        O000000o2.putString("time", sb2);
        O000000o2.putString("display", "mobile");
        O000000o2.putString("response_type", "token");
        O000000o2.putString("redirect_uri", "auth://tauth.qq.com/");
        O000000o2.putString("cancel_display", "1");
        O000000o2.putString("switch", "1");
        O000000o2.putString("compat_v", "1");
        if (z2) {
            O000000o2.putString("style", "qr");
        }
        final String str = djm.O000000o().O000000o(djk.O000000o(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.O000000o(O000000o2);
        final O00000Oo o00000Oo = new O00000Oo(djk.O000000o(), djz);
        diz.O00000Oo("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        j.O000000o(new Runnable() {
            /* class _m_j.dii.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
                r0 = (android.app.Activity) _m_j.dii.O00000oO(r2.O00000o0).get();
             */
            public final void run() {
                final Activity activity;
                djn.O00000Oo(dii.f14666O000000o, dii.O00000Oo);
                JniInterface.O000000o();
                if (dii.this.O0000OoO != null && activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        /* class _m_j.dii.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            if (JniInterface.f5882O000000o) {
                                dik dik = new dik(activity, "action_login", str, o00000Oo, dii.this.O00000oO);
                                if (!activity.isFinishing()) {
                                    dik.show();
                                    return;
                                }
                                return;
                            }
                            diz.O00000o("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                            TDialog tDialog = new TDialog(activity, "", dii.this.O000000o(""), o00000Oo, dii.this.O00000oO);
                            if (!activity.isFinishing()) {
                                tDialog.show();
                            }
                        }
                    });
                }
            }
        });
        diz.O00000o0("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    private boolean O000000o(Activity activity, Fragment fragment, Map<String, Object> map, boolean z, Object[] objArr) {
        diz.O00000o0("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent O00000Oo2 = O00000Oo("com.tencent.open.agent.AgentActivity");
        if (O00000Oo2 != null) {
            Bundle O000000o2 = O000000o();
            if (z) {
                O000000o2.putString("isadd", "1");
            }
            O000000o2.putString("scope", this.O0000Oo);
            O000000o2.putString("client_id", this.O00000oO.f14674O000000o);
            if (O0000Oo0) {
                O000000o2.putString("pf", "desktop_m_qq-" + O0000O0o + "-android-" + O00000oo + "-" + O0000OOo);
            } else {
                O000000o2.putString("pf", "openmobile_android");
            }
            O000000o2.putString("need_pay", "1");
            O000000o2.putString("oauth_app_name", djn.O000000o(djk.O000000o()));
            O00000Oo2.putExtra("key_action", "action_login");
            O00000Oo2.putExtra("key_params", O000000o2);
            O00000Oo2.putExtra("appid", this.O00000oO.f14674O000000o);
            O000000o2.putString("ppsts", djn.O000000o(activity, O000000o(O000000o2)));
            if (O000000o(O00000Oo2)) {
                this.O00000o0 = new O000000o(this.O00000o0);
                diq.O000000o().O000000o(this.O00000o0);
                if (fragment != null) {
                    diz.O00000Oo("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    O000000o(fragment, O00000Oo2, map);
                } else {
                    diz.O00000Oo("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    O000000o(activity, O00000Oo2, map);
                }
                diz.O00000o0("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                diw.O000000o();
                diw.O000000o(0, "LOGIN_CHECK_SDK", "1000", this.O00000oO.f14674O000000o, "", Long.valueOf(SystemClock.elapsedRealtime()), "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            }
        }
        diw.O000000o();
        diw.O000000o(1, "LOGIN_CHECK_SDK", "1000", this.O00000oO.f14674O000000o, "", Long.valueOf(SystemClock.elapsedRealtime()), "startActionActivity fail");
        diz.O00000o0("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    private static String O000000o(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString("sdkv");
        String string5 = bundle.getString("client_id");
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString("pf");
        diz.O00000Oo("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        StringBuilder sb = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    class O000000o extends djx {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<djz> f14669O000000o;
        private final String O00000o = "installwording";
        private final String O00000o0 = "sendinstall";
        private final String O00000oO = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        public O000000o(djz djz) {
            this.f14669O000000o = new WeakReference<>(djz);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0288  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x02bb  */
        public final void onComplete(Object obj) {
            JSONObject jSONObject;
            String str;
            boolean z;
            djz djz;
            boolean z2;
            String str2;
            PackageInfo packageInfo;
            final Object obj2 = obj;
            if (obj2 != null && (jSONObject = (JSONObject) obj2) != null) {
                try {
                    z = jSONObject.getInt("sendinstall") == 1;
                    try {
                        str = jSONObject.getString("installwording");
                    } catch (JSONException unused) {
                        diz.O00000o("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                        str = "";
                        String decode = URLDecoder.decode(str);
                        diz.O00000o0("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx,showConfirmDialog=" + z);
                        Drawable drawable = null;
                        if (z) {
                        }
                        String str3 = "openSDK_LOG.AuthAgent";
                        Object obj3 = obj2;
                        djz = this.f14669O000000o.get();
                        if (djz != null) {
                        }
                    }
                } catch (JSONException unused2) {
                    z = false;
                    diz.O00000o("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                    String decode2 = URLDecoder.decode(str);
                    diz.O00000o0("openSDK_LOG.AuthAgent", " WORDING = " + decode2 + "xx,showConfirmDialog=" + z);
                    Drawable drawable2 = null;
                    if (z) {
                    }
                    String str32 = "openSDK_LOG.AuthAgent";
                    Object obj32 = obj2;
                    djz = this.f14669O000000o.get();
                    if (djz != null) {
                    }
                }
                String decode22 = URLDecoder.decode(str);
                diz.O00000o0("openSDK_LOG.AuthAgent", " WORDING = " + decode22 + "xx,showConfirmDialog=" + z);
                Drawable drawable22 = null;
                if (z || TextUtils.isEmpty(decode22)) {
                    String str322 = "openSDK_LOG.AuthAgent";
                    Object obj322 = obj2;
                    djz = this.f14669O000000o.get();
                    if (djz != null) {
                        if (dii.this.O00000oO != null) {
                            z2 = dii.this.O00000oO.O000000o(jSONObject);
                            diz.O00000o0(str322, " saveSession saveSuccess=".concat(String.valueOf(z2)));
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            djz.onComplete(obj322);
                        } else {
                            djz.onError(new dkb(-6, "持久化失败!", null));
                        }
                    } else {
                        diz.O00000o0(str322, " userListener is null");
                    }
                } else {
                    final djz djz2 = this.f14669O000000o.get();
                    if (dii.this.O0000OoO == null) {
                        diz.O00000o0("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                    } else {
                        Activity activity = (Activity) dii.this.O0000OoO.get();
                        if (activity == null) {
                            diz.O00000o0("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                        } else {
                            Dialog dialog = new Dialog(activity);
                            dialog.requestWindowFeature(1);
                            PackageManager packageManager = activity.getPackageManager();
                            try {
                                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
                            } catch (PackageManager.NameNotFoundException e) {
                                diz.O00000oO("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                                packageInfo = null;
                            }
                            if (packageInfo != null) {
                                drawable22 = packageInfo.applicationInfo.loadIcon(packageManager);
                            }
                            AnonymousClass1 r0 = new C0100O000000o(dialog) {
                                /* class _m_j.dii.O000000o.AnonymousClass1 */

                                public final void onClick(View view) {
                                    Activity activity;
                                    O000000o o000000o = O000000o.this;
                                    Bundle O0000Oo = dii.O0000Oo(dii.this);
                                    if (!(dii.this.O0000OoO == null || (activity = (Activity) dii.this.O0000OoO.get()) == null)) {
                                        HttpUtils.O000000o(dii.this.O00000oO, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", O0000Oo, "POST", null);
                                    }
                                    if (this.O00000o != null && this.O00000o.isShowing()) {
                                        this.O00000o.dismiss();
                                    }
                                    djz djz = djz2;
                                    if (djz != null) {
                                        djz.onComplete(obj2);
                                    }
                                }
                            };
                            AnonymousClass2 r11 = new C0100O000000o(dialog) {
                                /* class _m_j.dii.O000000o.AnonymousClass2 */

                                public final void onClick(View view) {
                                    if (this.O00000o != null && this.O00000o.isShowing()) {
                                        this.O00000o.dismiss();
                                    }
                                    djz djz = djz2;
                                    if (djz != null) {
                                        djz.onComplete(obj2);
                                    }
                                }
                            };
                            ColorDrawable colorDrawable = new ColorDrawable();
                            colorDrawable.setAlpha(0);
                            dialog.getWindow().setBackgroundDrawable(colorDrawable);
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            float f = displayMetrics.density;
                            RelativeLayout relativeLayout = new RelativeLayout(activity);
                            ImageView imageView = new ImageView(activity);
                            imageView.setImageDrawable(drawable22);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setId(1);
                            int i = (int) (60.0f * f);
                            int i2 = (int) (f * 14.0f);
                            int i3 = (int) (f * 18.0f);
                            str2 = "openSDK_LOG.AuthAgent";
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
                            layoutParams.addRule(9);
                            layoutParams.setMargins(0, i3, (int) (f * 6.0f), i3);
                            relativeLayout.addView(imageView, layoutParams);
                            TextView textView = new TextView(activity);
                            textView.setText(decode22);
                            textView.setTextSize(14.0f);
                            textView.setGravity(3);
                            textView.setIncludeFontPadding(false);
                            textView.setPadding(0, 0, 0, 0);
                            textView.setLines(2);
                            textView.setId(5);
                            textView.setMinWidth((int) (185.0f * f));
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(1, 1);
                            layoutParams2.addRule(6, 1);
                            float f2 = 5.0f * f;
                            layoutParams2.setMargins(0, 0, (int) f2, 0);
                            relativeLayout.addView(textView, layoutParams2);
                            View view = new View(activity);
                            view.setBackgroundColor(Color.rgb(214, 214, 214));
                            view.setId(3);
                            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
                            layoutParams3.addRule(3, 1);
                            layoutParams3.addRule(5, 1);
                            layoutParams3.addRule(7, 5);
                            int i4 = (int) (f * 12.0f);
                            layoutParams3.setMargins(0, 0, 0, i4);
                            relativeLayout.addView(view, layoutParams3);
                            LinearLayout linearLayout = new LinearLayout(activity);
                            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams4.addRule(5, 1);
                            layoutParams4.addRule(7, 5);
                            layoutParams4.addRule(3, 3);
                            Button button = new Button(activity);
                            button.setText("跳过");
                            button.setBackgroundDrawable(O000000o("buttonNegt.png", activity));
                            button.setTextColor(Color.rgb(36, 97, 131));
                            button.setTextSize(20.0f);
                            button.setOnClickListener(r11);
                            button.setId(4);
                            int i5 = (int) (45.0f * f);
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i5);
                            layoutParams5.rightMargin = i2;
                            int i6 = (int) (4.0f * f);
                            layoutParams5.leftMargin = i6;
                            layoutParams5.weight = 1.0f;
                            linearLayout.addView(button, layoutParams5);
                            Button button2 = new Button(activity);
                            button2.setText("确定");
                            button2.setTextSize(20.0f);
                            button2.setTextColor(Color.rgb(255, 255, 255));
                            button2.setBackgroundDrawable(O000000o("buttonPost.png", activity));
                            button2.setOnClickListener(r0);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i5);
                            layoutParams6.weight = 1.0f;
                            layoutParams6.rightMargin = i6;
                            linearLayout.addView(button2, layoutParams6);
                            relativeLayout.addView(linearLayout, layoutParams4);
                            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
                            relativeLayout.setPadding(i2, 0, i4, i4);
                            relativeLayout.setLayoutParams(layoutParams7);
                            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
                            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
                            paintDrawable.setCornerRadius(f2);
                            relativeLayout.setBackgroundDrawable(paintDrawable);
                            dialog.setContentView(relativeLayout);
                            final Object obj4 = obj;
                            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                /* class _m_j.dii.O000000o.AnonymousClass3 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    djz djz = djz2;
                                    if (djz != null) {
                                        djz.onComplete(obj4);
                                    }
                                }
                            });
                            if (activity != null && !activity.isFinishing()) {
                                dialog.show();
                            }
                            diz.O00000o0(str2, " WORDING is not empty and return");
                        }
                    }
                    str2 = "openSDK_LOG.AuthAgent";
                    diz.O00000o0(str2, " WORDING is not empty and return");
                }
            }
        }

        /* renamed from: _m_j.dii$O000000o$O000000o  reason: collision with other inner class name */
        abstract class C0100O000000o implements View.OnClickListener {
            Dialog O00000o;

            C0100O000000o(Dialog dialog) {
                this.O00000o = dialog;
            }
        }

        private static Drawable O000000o(String str, Context context) {
            Bitmap bitmap;
            try {
                InputStream open = context.getApplicationContext().getAssets().open(str);
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
                }
                Drawable createFromStream = Drawable.createFromStream(open, str);
                open.close();
                return createFromStream;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public final void onError(dkb dkb) {
            if (this.f14669O000000o.get() != null) {
                this.f14669O000000o.get().onError(dkb);
            }
        }

        public final void onCancel() {
            if (this.f14669O000000o.get() != null) {
                this.f14669O000000o.get().onCancel();
            }
        }
    }

    static /* synthetic */ Bundle O0000Oo(dii dii) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", dii.O00000oO.f14674O000000o);
        if (dii.O00000oO.O000000o()) {
            bundle.putString("keystr", dii.O00000oO.O00000Oo);
            bundle.putString("keytype", "0x80");
        }
        String str = dii.O00000oO.O00000o0;
        if (str != null) {
            bundle.putString("hopenid", str);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = djk.O000000o().getSharedPreferences("pfStore", 0);
        if (dio.O0000Oo0) {
            bundle.putString("pf", "desktop_m_qq-" + dio.O0000O0o + "-android-" + dio.O00000oo + "-" + dio.O0000OOo);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "3.5.2.lite");
        bundle.putString("sdkp", "a");
        return bundle;
    }
}

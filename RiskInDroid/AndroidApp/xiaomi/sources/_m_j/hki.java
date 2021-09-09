package _m_j;

import _m_j.hki;
import _m_j.hlj;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.network.NetWorkObserver;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class hki extends hkf {
    private long O00000o = -1;
    private String O00000o0 = "{}";

    public hki(Activity activity, CommonWebView commonWebView) {
        super(activity, commonWebView);
        grr.O000000o();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os_name", "android");
            jSONObject.put("app_version", grr.O00000o0(activity.getApplicationContext()));
            jSONObject.put("os_version", grr.O0000Oo0());
            jSONObject.put("sdk_version", grr.O0000OOo());
            this.O00000o0 = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void onShareOptionsReady(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            gsy.O00000Oo("CommonJavaScriptInterfa", "onShareOptionsReady: ");
            hlp.O000000o(new Runnable(str) {
                /* class _m_j.$$Lambda$hki$1oxeu4UnrlJaQHE8wzYjf7sgh6k */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hki.O000000o(CommonWebView.this, this.f$1);
                }
            });
        }
    }

    @JavascriptInterface
    public final void setShareButtonEnable(boolean z) {
        hlm titleBarImpl;
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed() && Build.VERSION.SDK_INT >= 19 && (titleBarImpl = commonWebView.getTitleBarImpl()) != null) {
            hlp.O000000o(new Runnable(z) {
                /* class _m_j.$$Lambda$hki$ud8iaKQCMWFFAHJVlibhCbtGTy4 */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hlm.this.setShareButtonEnable(this.f$1);
                }
            });
        }
    }

    @JavascriptInterface
    public final boolean isLogin() {
        return ServiceApplication.getStateNotifier().f15923O000000o == 4;
    }

    @JavascriptInterface
    public final String getSettings() {
        return this.O00000o0;
    }

    @JavascriptInterface
    public final void startLogin() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            hlp.O00000Oo(new Runnable() {
                /* class _m_j.$$Lambda$hki$iD8XKye4suTFWs392khCtrNry3U */

                public final void run() {
                    hki.this.O00000Oo();
                }
            });
            return;
        }
        final Activity activity = (Activity) this.f19010O000000o.get();
        final CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            WebViewRouterFactory.getWebViewHelpManager().startLogin(activity, 1, new Runnable() {
                /* class _m_j.hki.AnonymousClass1 */

                public final void run() {
                    hlp.O00000Oo(new Runnable(activity, commonWebView) {
                        /* class _m_j.$$Lambda$hki$1$sJLxlrQxWzZquPCYg8v8TRjke0 */
                        private final /* synthetic */ Activity f$0;
                        private final /* synthetic */ CommonWebView f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            hki.AnonymousClass1.O000000o(this.f$0, this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O000000o(Activity activity, CommonWebView commonWebView) {
                    if (!activity.isDestroyed()) {
                        commonWebView.O000000o();
                        commonWebView.reload();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            commonWebView.O000000o();
            commonWebView.reload();
        }
    }

    @JavascriptInterface
    public final boolean openYoupinPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        hlp.O000000o(new Runnable(str) {
            /* class _m_j.$$Lambda$hki$86ZcLhPguMNx_j_FJ0pUS1IgEn4 */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                hki.O000000o(this.f$0);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(String str) {
        try {
            WebViewRouterFactory.getWebViewHelpManager().openUrl(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void onBackPressed(boolean z) {
        hlm titleBarImpl;
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed() && (titleBarImpl = commonWebView.getTitleBarImpl()) != null) {
            hlp.O000000o(new Runnable(z) {
                /* class _m_j.$$Lambda$hki$A9RkPrSueECnScLwn9vWmje8S0I */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hlm.this.O000000o(this.f$1);
                }
            });
        }
    }

    @JavascriptInterface
    public final void gotoFeedback() {
        Activity activity = (Activity) this.f19010O000000o.get();
        if (activity != null && !activity.isDestroyed()) {
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                WebViewRouterFactory.getWebViewHelpManager().startLogin(activity, 1, null);
                return;
            }
            fbt fbt = new fbt(activity, "/userCenter/FeedbackActivity");
            fbt.O000000o("extra_device_model", "choiceness");
            fbt.O000000o("extra_source", 0);
            fbs.O000000o(fbt);
        }
    }

    @JavascriptInterface
    public final String getLocale() {
        Locale O0000O0o = fju.O000000o().O0000O0o();
        if (O0000O0o == null) {
            O0000O0o = Locale.getDefault();
        }
        return O0000O0o.toString();
    }

    @JavascriptInterface
    public final void openNewWebView(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        if (activity != null && !activity.isDestroyed()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("title");
                if (!TextUtils.isEmpty(optString)) {
                    Intent intent = new Intent(activity, OperationCommonWebViewActivity.class);
                    intent.putExtra("url", optString);
                    intent.putExtra("title", optString2);
                    activity.startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public final void setOptionButton(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            hlm titleBarImpl = commonWebView.getTitleBarImpl();
            if (titleBarImpl != null) {
                hlp.O000000o(new Runnable(str) {
                    /* class _m_j.$$Lambda$hki$N9oaNbmnYqVJxJFkai4aHZdJT4k */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.setOptionButton(this.f$1);
                    }
                });
            }
            gsy.O000000o(3, "CommonJavaScriptInterfa", "setOptionButton: ".concat(String.valueOf(str)));
        }
    }

    @JavascriptInterface
    public final void setPopMenu(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            hlm titleBarImpl = commonWebView.getTitleBarImpl();
            if (titleBarImpl != null) {
                hlp.O000000o(new Runnable(str) {
                    /* class _m_j.$$Lambda$hki$54ZJOTt9Ul19XeDaOoIPSILZeFQ */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.setPopMenu(this.f$1);
                    }
                });
            }
            gsy.O000000o(3, "CommonJavaScriptInterfa", "setPopMenu: ".concat(String.valueOf(str)));
        }
    }

    @JavascriptInterface
    public final void setNavigationBar(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            hlm titleBarImpl = commonWebView.getTitleBarImpl();
            if (titleBarImpl != null) {
                hlp.O000000o(new Runnable(str) {
                    /* class _m_j.$$Lambda$hki$GXkXdPSzHrzskSuF_OTYdvCoVHA */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.setNavigationBar(this.f$1);
                    }
                });
            }
            gsy.O000000o(3, "CommonJavaScriptInterfa", "setNavigationBar: ".concat(String.valueOf(str)));
        }
    }

    @JavascriptInterface
    public final void setNavigationBarLoading(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            hlm titleBarImpl = commonWebView.getTitleBarImpl();
            if (titleBarImpl != null) {
                hlp.O000000o(new Runnable(str) {
                    /* class _m_j.$$Lambda$hki$lWQ6faM2HDMs7Px8Q3mqNOK07xQ */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hlm.this.setNavigationBarLoading(this.f$1);
                    }
                });
            }
            gsy.O000000o(3, "CommonJavaScriptInterfa", "showNavigationBarLoading: ");
        }
    }

    @JavascriptInterface
    public final void toNative(String str) {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity == null || commonWebView == null || activity.isDestroyed()) {
        }
    }

    @JavascriptInterface
    public final void popWindow(String str) {
        hlb webPageActionImpl;
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed() && (webPageActionImpl = commonWebView.getWebPageActionImpl()) != null) {
            hlp.O000000o(new Runnable(str) {
                /* class _m_j.$$Lambda$hki$pscbrNe7mWDRCiih9AYs61IGBiM */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hlb.this.O000000o(this.f$1);
                }
            });
        }
    }

    @JavascriptInterface
    public final void pushWindow(String str) {
        hlb webPageActionImpl;
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed() && (webPageActionImpl = commonWebView.getWebPageActionImpl()) != null) {
            hlp.O000000o(new Runnable(str) {
                /* class _m_j.$$Lambda$hki$NzISRK_EOS11_CmWgUK9ygvoA8U */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hlb.this.O00000Oo(this.f$1);
                }
            });
        }
    }

    @JavascriptInterface
    public final String getNetworkType() {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity == null || commonWebView == null || activity.isDestroyed()) {
            return hlg.f19033O000000o.O000000o().toString();
        }
        commonWebView.getNetworkHelper();
        return NetWorkObserver.O000000o().O000000o().toString();
    }

    @JavascriptInterface
    public final boolean onShare(String str, String str2, String str3, String str4) {
        Activity activity = (Activity) this.f19010O000000o.get();
        if (activity == null || activity.isDestroyed() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        fbt O000000o2 = new fbt(activity, "CommonShareActivity").O000000o("ShareTitle", str);
        if (!TextUtils.isEmpty(str3)) {
            O000000o2.O000000o("ShareContent", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            if (str4.endsWith(".zip")) {
                O000000o2.O000000o("SHARE_IMAGE_FILE_ZIP_URL", str4);
            } else {
                O000000o2.O000000o("ShareImageUrlNotZip", str4);
            }
        }
        O000000o2.O000000o("ShareUrl", str2);
        fbs.O000000o(O000000o2);
        return true;
    }

    @JavascriptInterface
    public final void screenshot() {
        Activity activity = (Activity) this.f19010O000000o.get();
        if (activity != null && !activity.isDestroyed() && System.currentTimeMillis() - this.O00000o > 500) {
            this.O00000o = System.currentTimeMillis();
            hlp.O000000o(new Runnable() {
                /* class _m_j.$$Lambda$hki$9bew4sqwKWFqTuc61igSj4TWjGQ */

                public final void run() {
                    hki.this.O000000o();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null && !activity.isDestroyed()) {
            WebViewRouterFactory.getWebViewHelpManager().startScreenShot(activity, commonWebView);
        }
    }

    @JavascriptInterface
    public final void getLocation(final String str) {
        this.O00000Oo.get();
        new StringBuilder("getLocationStart: ").append(new Date().toLocaleString());
        new hlj(this.O00000Oo, this.f19010O000000o) {
            /* class _m_j.hki.AnonymousClass2 */

            public final void O000000o(final hlj.O000000o o000000o) {
                WebViewRouterFactory.getWebViewHelpManager().getLocationRx(str, new hkk<String, String>() {
                    /* class _m_j.hki.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        AnonymousClass2.this.mWebViewRef.get();
                        new StringBuilder("getLocationFail: ").append(new Date().toLocaleString());
                        o000000o.O00000Oo((String) obj);
                    }

                    public final /* synthetic */ void O00000Oo(Object obj) {
                        AnonymousClass2.this.mWebViewRef.get();
                        new StringBuilder("getLocationSuccess: ").append(new Date().toLocaleString());
                        o000000o.O000000o((String) obj);
                    }
                });
            }

            public final List<String> getExtraParam() {
                return Collections.singletonList("getLocation");
            }
        }.then("smartHome.dispatchEvent", "smartHome.dispatchEvent");
    }

    @JavascriptInterface
    public final String webviewStatus(String str) {
        JSONObject jSONObject = new JSONObject();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (commonWebView == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put("isFullScreen", commonWebView.getFullScreenStatus());
            jSONObject.put("orientation", commonWebView.getScreenOrientation());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.O00000Oo.get();
        new StringBuilder("webviewStatus: ").append(jSONObject.toString());
        return jSONObject.toString();
    }

    @JavascriptInterface
    public final void setOrientation(String str) {
        this.O00000Oo.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (commonWebView != null) {
            int i = 1;
            try {
                i = new JSONObject(str).optInt("orientation");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            commonWebView.setOrientation(i);
        }
    }

    @JavascriptInterface
    public final int getTitleBarPadding() {
        return hzf.O000000o(CommonApplication.getAppContext());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(CommonWebView commonWebView, String str) {
        hlk hlk = commonWebView.f10512O000000o;
        if (hlk.O00000Oo.f10523O000000o) {
            gsy.O000000o(3, "ShareHelper", "onShareOptionsReady: 手动取消loading，不在分享");
            return;
        }
        hlk.O00000Oo.O00000Oo();
        hlk.O000000o(str);
    }
}

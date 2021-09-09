package com.xiaomi.smarthome.operation.js_sdk.base;

import _m_j.flk;
import _m_j.fln;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.gku;
import _m_j.gsy;
import _m_j.gty;
import _m_j.hkd;
import _m_j.hlp;
import _m_j.ibh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.net.URLEncoder;
import java.util.Locale;

public class BaseWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f10509O000000o;
    private boolean O00000Oo = false;

    public BaseWebView(Context context) {
        super(context);
        O00000Oo();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O00000Oo() {
        O00000o0();
        O000000o();
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void O00000o0() {
        WebViewRouterFactory.getWebViewHelpManager().removeWXPayCallback();
        WebSettings settings = getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(getContext().getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setCacheMode(-1);
        if (this.f10509O000000o == null) {
            this.f10509O000000o = settings.getUserAgentString() + " " + fln.O000000o(getContext()) + " XiaoMi/MiuiBrowser/4.3  XiaoMi/HybridView/";
        }
        settings.setUserAgentString(this.f10509O000000o);
        settings.setAllowFileAccess(false);
        setDownloadListener(new DownloadListener() {
            /* class com.xiaomi.smarthome.operation.js_sdk.base.$$Lambda$BaseWebView$qh6ZqJM39uHt0na3JZLa75n8cc */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                BaseWebView.this.O000000o(str, str2, str3, str4, j);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        if (gku.O000000o(getContext())) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str, String str2, String str3, String str4, long j) {
        if (!TextUtils.isEmpty(str)) {
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public final void O000000o() {
        gsy.O00000Oo("CommonWebView", "initCookie");
        CookieSyncManager.createInstance(getContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            instance.setAcceptThirdPartyCookies(this, true);
        }
        if (CoreApi.O000000o().O0000Ooo()) {
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (!TextUtils.isEmpty(O0000oO)) {
                O000000o(instance, "passToken", O0000oO, ".account.xiaomi.com");
            }
            hkd.O000000o(instance, "mi.com");
            hkd.O000000o(instance, ".account.xiaomi.com");
            hkd.O000000o(this);
            try {
                MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaomiio");
                if (O000000o2 != null) {
                    O000000o(instance, "serviceToken", URLEncoder.encode(O000000o2.O00000o0, "UTF-8"), ".io.mi.com");
                    O000000o(instance, "yetAnotherServiceToken", O000000o2.O00000o0, ".api.io.mi.com");
                    O000000o(instance, "yetAnotherServiceToken", URLEncoder.encode(O000000o2.O00000o0, "UTF-8"), ".home.mi.com");
                }
                MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaomihome");
                if (O000000o3 != null) {
                    O000000o(instance, "serviceToken", URLEncoder.encode(O000000o3.O00000o0, "UTF-8"), ".home.mi.com");
                }
                MiServiceTokenInfo O000000o4 = CoreApi.O000000o().O000000o("kfs_chat");
                if (O000000o4 != null) {
                    O000000o(instance, "serviceToken", URLEncoder.encode(O000000o4.O00000o0, "UTF-8"), ".chat.kefu.mi.com");
                }
            } catch (Exception unused) {
            }
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        O000000o(instance, "locale", flk.O000000o(O00oOooo), ".io.mi.com");
        O000000o(instance, "locale", flk.O000000o(O00oOooo), ".home.mi.com");
        O000000o(instance, "source", "web", ".api.io.mi.com");
        O000000o(instance, "region", O00oOooo.getCountry(), ".api.io.mi.com");
        O000000o(instance, "channel", gfr.O0000o0O, ".home.mi.com");
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
        O000000o(instance, "xiaomihome", ".home.mi.com");
    }

    private void O000000o(final CookieManager cookieManager, String str, final String str2) {
        gty.O000000o().refreshServiceToken(str, new ibh<MiServiceTokenInfo, Error>() {
            /* class com.xiaomi.smarthome.operation.js_sdk.base.BaseWebView.AnonymousClass1 */

            public final void onFailure(Error error) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                try {
                    BaseWebView.O000000o(cookieManager, "serviceToken", URLEncoder.encode(miServiceTokenInfo.O00000o0, "UTF-8"), str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        CookieManager.getInstance().flush();
                    }
                } catch (Exception unused) {
                }
                CoreApi.O000000o().O000000o(miServiceTokenInfo, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.operation.js_sdk.base.BaseWebView.AnonymousClass1.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        });
    }

    protected static void O000000o(CookieManager cookieManager, String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            cookieManager.setCookie(str3, str + "=" + str2 + ";path=/;domain=" + str3);
            gsy.O00000Oo("CommonWebView", "setCookie: domain: " + str3 + " ;name: " + str + " ;value: " + str2);
        }
    }

    protected static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    protected static void O000000o(Runnable runnable) {
        hlp.O000000o(runnable);
    }

    public void setFixHorizontalSwipe(boolean z) {
        this.O00000Oo = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent O000000o2;
        if (this.O00000Oo && motionEvent.getAction() == 0 && (O000000o2 = O000000o(this)) != null) {
            O000000o2.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        ViewParent O000000o2;
        if (this.O00000Oo && z && (O000000o2 = O000000o(this)) != null) {
            O000000o2.requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    private ViewParent O000000o(View view) {
        ViewParent parent;
        while (true) {
            parent = view.getParent();
            if (parent == null) {
                return null;
            }
            if ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
                return parent;
            }
            view = (View) parent;
        }
        return parent;
    }
}

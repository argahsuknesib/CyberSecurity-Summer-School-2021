package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

public abstract class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f3216a;
    private final String d;

    public abstract void a();

    public abstract void a(String str);

    public abstract boolean b();

    public c(Activity activity, String str) {
        super(activity);
        this.f3216a = activity;
        this.d = str;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(this.f3216a.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
    }

    public boolean c() {
        return "v1".equals(this.d);
    }

    static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }
}

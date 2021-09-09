package com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors;

import _m_j.hkw;
import _m_j.hte;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;

public class ThirdSchemeInterceptor extends hkw {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f10518O000000o;
    private final ThirdSchemeDialogHelper O00000Oo;
    private boolean O00000o0 = true;

    public ThirdSchemeInterceptor(Context context) {
        this.f10518O000000o = context;
        this.O00000Oo = new ThirdSchemeDialogHelper(context);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String scheme = Uri.parse(str).getScheme();
        if (scheme == null || scheme.equals("https") || scheme.equals("http")) {
            if (scheme == null || !WebViewRouterFactory.getWebViewHelpManager().isYoupinHost(str)) {
                return false;
            }
            return WebViewRouterFactory.getWebViewHelpManager().dispatchToShop(str, "");
        } else if (scheme.equals("tel") || scheme.equals("mailto")) {
            if (this.f10518O000000o.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                this.f10518O000000o.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
            return true;
        } else if (scheme.equals("mihome") || scheme.equals("mijia")) {
            return true;
        } else {
            if (this.O00000Oo.O00000Oo()) {
                return false;
            }
            if (this.f10518O000000o.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536).size() > 0) {
                this.O00000Oo.O000000o(new Runnable(str) {
                    /* class com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors.$$Lambda$ThirdSchemeInterceptor$oOYnLF5IVM0SPkJI0iTD3NJRkM4 */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ThirdSchemeInterceptor.this.O000000o(this.f$1);
                    }
                });
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str) {
        try {
            this.f10518O000000o.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception unused) {
            hte.O000000o(this.f10518O000000o, (int) R.string.ble_mesh_toast_failed);
        }
    }

    public void onResume() {
        if (!this.O00000o0) {
            this.O00000Oo.O000000o();
        }
        this.O00000o0 = false;
    }

    public void onDestroy() {
        this.O00000Oo.O000000o();
    }
}

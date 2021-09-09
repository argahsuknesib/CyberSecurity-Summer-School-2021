package _m_j;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public final class hgk {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f18899O000000o;
    private Context O00000Oo;
    private WebView O00000o0;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public hgk(Context context, WebView webView) {
        this.O00000Oo = context;
        this.O00000o0 = webView;
    }

    @JavascriptInterface
    public final void notifyPassportStatus(String str) {
        O000000o o000000o;
        gsy.O000000o(4, "UnregisterJsBridge", "notifyPassportStatus, processType=".concat(String.valueOf(str)));
        if (("unregisterSuccess".equals(str) || "delAccountSuccess".equals(str)) && (o000000o = this.f18899O000000o) != null) {
            o000000o.O000000o();
        }
    }

    @JavascriptInterface
    public final void endPassportProcess() {
        gsy.O000000o(4, "UnregisterJsBridge", "endPassportProcess: ");
        O000000o o000000o = this.f18899O000000o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }
}

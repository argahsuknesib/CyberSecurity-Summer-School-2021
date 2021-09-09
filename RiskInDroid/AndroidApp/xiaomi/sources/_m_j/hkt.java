package _m_j;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData;
import com.xiaomi.smarthome.operation.js_sdk.bridge.JsResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class hkt {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, hko> f19021O000000o = new HashMap();
    Map<String, hkr> O00000Oo = new HashMap();
    private long O00000o = 0;
    List<Object> O00000o0 = new ArrayList();
    private hkl O00000oO;
    private WebView O00000oo;

    public hkt(hkl hkl, WebView webView) {
        this.O00000oO = hkl;
        this.O00000oo = webView;
    }

    private void O00000Oo(Object obj) {
        if (!this.O00000oO.O00000Oo()) {
            this.O00000o0.add(obj);
        } else {
            O000000o(obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Object obj) {
        O000000o(String.format("javascript:window.MJApi._handleMessageFromNative('%s');", new Gson().toJson(obj).replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"").replaceAll("(?<=[^\\\\])(')", "\\\\'").replaceAll("%7B", URLEncoder.encode("%7B")).replaceAll("%7D", URLEncoder.encode("%7D")).replaceAll("%22", URLEncoder.encode("%22"))));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        hlp.O000000o(new Runnable(str) {
            /* class _m_j.$$Lambda$hkt$cy_H7484VzQE6g8m4RenG9TrvwY */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                hkt.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(String str) {
        hkl hkl = this.O00000oO;
        if (hkl != null && !hkl.O000000o()) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.O00000oo.evaluateJavascript(str, null);
            } else {
                this.O00000oo.loadUrl(str);
            }
        }
    }

    public final void O000000o(hkr hkr) {
        if (hkr != null && !TextUtils.isEmpty(hkr.O000000o())) {
            this.O00000Oo.put(hkr.O000000o(), hkr);
        }
    }

    public final void O000000o(CallBackData callBackData, String str) {
        if (!TextUtils.isEmpty(str)) {
            JsResponse jsResponse = new JsResponse();
            jsResponse.responseId = str;
            jsResponse.responseData = callBackData;
            O00000Oo(jsResponse);
        }
    }
}

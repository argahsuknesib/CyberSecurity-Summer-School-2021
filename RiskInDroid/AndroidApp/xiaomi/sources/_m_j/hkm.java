package _m_j;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData;
import com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackStatus;
import java.util.Map;

public class hkm extends hkw implements hkl {

    /* renamed from: O000000o  reason: collision with root package name */
    public hkt f19016O000000o;
    public boolean O00000Oo;
    private WebView O00000o;
    public boolean O00000o0 = false;

    public hkm(WebView webView) {
        this.O00000o = webView;
        this.O00000o.setOverScrollMode(2);
        this.f19016O000000o = new hkt(this, this.O00000o);
        this.O00000o.addJavascriptInterface(this, "MJApi");
        O000000o(new hkp() {
            /* class _m_j.hkm.AnonymousClass1 */

            public final String O000000o() {
                return "default";
            }

            public final void O00000Oo() {
            }

            public final void O000000o(String str, hko hko) {
                String O000000o2 = hkn.O000000o(str);
                if (!TextUtils.isEmpty(O000000o2) && O000000o2.equals("init")) {
                    hkm hkm = hkm.this;
                    hkm.O00000o0 = true;
                    hkt hkt = hkm.f19016O000000o;
                    if (!hkt.O00000o0.isEmpty()) {
                        for (Object O000000o3 : hkt.O00000o0) {
                            hkt.O000000o(O000000o3);
                        }
                        hkt.O00000o0.clear();
                    }
                }
            }
        });
        for (hkr O000000o2 : new hks(this.O00000o).O00000Oo) {
            O000000o(O000000o2);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.O00000o0 = false;
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.O00000Oo && !this.O00000o0) {
            hkt hkt = this.f19016O000000o;
            String O000000o2 = hkn.O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                StringBuilder sb = new StringBuilder(O000000o2);
                for (String next : hkt.O00000Oo.keySet()) {
                    sb.append(String.format("window.MJApi['%s'] = window.MJApi.createAPI('%s');", next, next));
                }
                sb.append(hkn.O00000Oo());
                hkt.O000000o("javascript:" + String.format("(function() { %s })();", sb.toString()));
            }
        }
    }

    public void onDestroy() {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            hkt hkt = this.f19016O000000o;
            if (!hkt.O00000Oo.isEmpty()) {
                for (Map.Entry<String, hkr> value : hkt.O00000Oo.entrySet()) {
                    hkr hkr = (hkr) value.getValue();
                    if (hkr != null) {
                        hkr.O00000Oo();
                    }
                }
            }
            if (hkt.O00000Oo != null) {
                hkt.O00000Oo.clear();
            }
            hkt.O00000Oo = null;
            hkt.f19021O000000o.clear();
            hkt.f19021O000000o = null;
            hkt.O00000o0.clear();
            hkt.O00000o0 = null;
            this.f19016O000000o = null;
        }
    }

    private void O000000o(hkr hkr) {
        if (!this.O00000Oo) {
            this.f19016O000000o.O000000o(hkr);
        }
    }

    @JavascriptInterface
    public void callJavaHandler(String str, String str2, String str3) {
        if (!this.O00000Oo) {
            hkt hkt = this.f19016O000000o;
            hkr hkr = hkt.O00000Oo.get(str);
            if (hkr != null) {
                hkr.O000000o(str2, new hko(str3) {
                    /* class _m_j.hkt.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f19022O000000o;

                    {
                        this.f19022O000000o = r2;
                    }

                    public final void O000000o(CallBackData callBackData) {
                        hkt.this.O000000o(callBackData, this.f19022O000000o);
                    }
                });
                return;
            }
            CallBackData callBackData = new CallBackData();
            callBackData.status = CallBackStatus.RESULT_CANCEL;
            hkt.O000000o(callBackData, str3);
        }
    }

    @JavascriptInterface
    public void callJavaResponse(String str, String str2) {
        if (!this.O00000Oo) {
            hkt hkt = this.f19016O000000o;
            if (!TextUtils.isEmpty(str2)) {
                hkt.f19021O000000o.get(str2).O000000o((CallBackData) new Gson().fromJson(str, CallBackData.class));
                hkt.f19021O000000o.remove(str2);
            }
        }
    }

    public final boolean O000000o() {
        return this.O00000Oo;
    }

    public final boolean O00000Oo() {
        return this.O00000o0;
    }
}

package _m_j;

import _m_j.dit;
import android.webkit.WebView;
import com.tencent.open.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class djv extends dit.O000000o {
    private String O00000o;

    public djv(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.O00000o = str2;
    }

    public final void O000000o() {
        diz.O000000o("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + ((Object) null));
    }

    public final void O00000Oo() {
        diz.O00000Oo("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    public final void O000000o(String str) {
        diz.O000000o("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: ".concat(String.valueOf(str)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !c.f5875O000000o ? -4 : 0);
            jSONObject.put("sn", this.O00000Oo);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        WebView webView = (WebView) this.f14699O000000o.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.O00000o);
            stringBuffer.append("){");
            stringBuffer.append(this.O00000o);
            stringBuffer.append("(");
            stringBuffer.append(jSONObject2);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            diz.O000000o("openSDK_LOG.SecureJsListener", "-->callback, callback: ".concat(String.valueOf(stringBuffer2)));
            webView.loadUrl(stringBuffer2);
        }
    }
}

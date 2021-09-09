package _m_j;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.operation.js_sdk.statistics.WebViewDurationStatManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/statistics/StatUrlInterceptorAdapter;", "Lcom/xiaomi/smarthome/operation/js_sdk/intercept/IUrlInterceptorAdapter;", "()V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hll extends hkw {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onPageFinished(WebView webView, String str) {
        Integer num;
        ixe.O00000o(webView, "view");
        ixe.O00000o(str, "url");
        WebViewDurationStatManager.O000000o o000000o = WebViewDurationStatManager.f10524O000000o;
        Context context = webView.getContext();
        String str2 = null;
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            WebViewDurationStatManager O000000o2 = WebViewDurationStatManager.O000000o.O000000o(fragmentActivity);
            ixe.O00000o(webView, "webview");
            ixe.O00000o(str, "url");
            WebViewDurationStatManager.O00000Oo o00000Oo = O000000o2.O00000o0;
            if (o00000Oo == null) {
                num = null;
            } else {
                num = Integer.valueOf(o00000Oo.f10525O000000o);
            }
            int hashCode = webView.hashCode();
            if (num != null && num.intValue() == hashCode) {
                WebViewDurationStatManager.O00000Oo o00000Oo2 = O000000o2.O00000o0;
                if (o00000Oo2 != null) {
                    str2 = o00000Oo2.O00000Oo;
                }
                if (ixe.O000000o((Object) str2, (Object) str)) {
                    return;
                }
            }
            gsy.O00000Oo("WebViewDurationStatMana", "changeTo: " + webView.hashCode() + " : url: " + str);
            WebViewDurationStatManager.O00000Oo o00000Oo3 = new WebViewDurationStatManager.O00000Oo(webView.hashCode(), str, System.currentTimeMillis());
            O000000o2.O00000o0 = o00000Oo3;
            if (O000000o2.O00000Oo.isEmpty()) {
                O000000o2.O00000Oo.push(o00000Oo3);
                return;
            }
            boolean z = true;
            boolean z2 = O000000o2.O00000Oo.peek().f10525O000000o == webView.hashCode();
            if (!z2 || !ixe.O000000o((Object) O000000o2.O00000Oo.peek().O00000Oo, (Object) str)) {
                z = false;
            }
            if (!z) {
                if (z2) {
                    O000000o2.O000000o();
                }
                O000000o2.O00000Oo.add(o00000Oo3);
            }
        }
    }
}

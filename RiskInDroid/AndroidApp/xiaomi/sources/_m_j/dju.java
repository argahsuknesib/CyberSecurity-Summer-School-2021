package _m_j;

import _m_j.dit;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dju extends dit {
    public final void O000000o(String str, String str2, List<String> list, dit.O000000o o000000o) {
        diz.O000000o("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        dit.O00000Oo o00000Oo = (dit.O00000Oo) this.f14698O000000o.get(str);
        if (o00000Oo != null) {
            diz.O00000Oo("openSDK_LOG.SecureJsBridge", "-->handler != null");
            o00000Oo.call(str2, list, o000000o);
            return;
        }
        diz.O00000oO("openSDK_LOG.SecureJsBridge", "-->handler == null objName: ".concat(String.valueOf(str)));
        o000000o.O00000Oo();
    }

    public final boolean O000000o(WebView webView, String str) {
        diz.O00000o0("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = ".concat(String.valueOf(str)));
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 7) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        String str4 = (String) arrayList.get(4);
        String str5 = (String) arrayList.get(5);
        diz.O00000o0("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            try {
                O000000o(str2, str3, arrayList.subList(6, arrayList.size() - 1), new djv(webView, Long.parseLong(str4), str, str5));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}

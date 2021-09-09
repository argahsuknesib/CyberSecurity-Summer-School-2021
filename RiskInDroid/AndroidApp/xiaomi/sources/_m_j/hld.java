package _m_j;

import _m_j.hle;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class hld {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hld f19031O000000o = new hld();

    private hld() {
    }

    public static hld O000000o() {
        return f19031O000000o;
    }

    public static boolean O000000o(Uri uri) {
        boolean z = false;
        if (uri != null && TextUtils.equals("mihome", uri.getScheme())) {
            hle.O000000o O000000o2 = hle.O000000o(uri.getHost());
            if (O000000o2 == null) {
                gsy.O000000o(6, "DeepLinkDelegate", "shouldOverrideUrlLoading: no jumper found for ignore");
                return false;
            }
            gsy.O00000Oo("DeepLinkDelegate", "process: uri: ".concat(String.valueOf(uri)));
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (!(queryParameterNames == null || queryParameterNames.size() == 0)) {
                if (!uri.getBooleanQueryParameter("requireLogin", false) || CoreApi.O000000o().O0000Ooo()) {
                    HashSet<String> hashSet = new HashSet<>(queryParameterNames);
                    hashSet.removeAll(Collections.singletonList("requireLogin"));
                    o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
                    for (String str : hashSet) {
                        String queryParameter = uri.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            o0o0ooo0.put(str, queryParameter);
                        }
                    }
                    try {
                        z = O000000o2.handle(uri, o0o0ooo0);
                    } catch (Exception e) {
                        gsy.O00000Oo("DeepLinkDelegate", "process: by target: " + Log.getStackTraceString(e));
                    }
                    gsy.O00000Oo("DeepLinkDelegate", "process: handled: ".concat(String.valueOf(z)));
                } else {
                    WebViewRouterFactory.getWebViewHelpManager().startLogin(ServiceApplication.getApplication(), 1, null);
                    return true;
                }
            }
        }
        return z;
    }
}

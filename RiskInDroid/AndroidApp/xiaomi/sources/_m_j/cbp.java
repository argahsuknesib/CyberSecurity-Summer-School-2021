package _m_j;

import _m_j.cbm;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public final class cbp implements CookieJar {
    public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (list != null) {
            for (Cookie next : list) {
                if ("xm_in_sid".equalsIgnoreCase(next.name())) {
                    cbm.O00000o0.O000000o(byl.O00000oO(), "xm_in_sid", next.value());
                }
            }
        }
    }

    public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList = new ArrayList(3);
        if (httpUrl == null) {
            return arrayList;
        }
        String O00000Oo = ccn.O0000o00().O00000Oo();
        String O00000o0 = ccn.O0000o00().O00000o0();
        String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "xm_in_sid", (String) null);
        if (!TextUtils.isEmpty(O00000o0)) {
            arrayList.add(new Cookie.Builder().name("serviceToken").value(O00000o0).domain(httpUrl.host()).build());
        }
        if (!TextUtils.isEmpty(O00000Oo)) {
            arrayList.add(new Cookie.Builder().name("mUserId").value(cei.O000000o(O00000Oo)).domain(httpUrl.host()).build());
            arrayList.add(new Cookie.Builder().name("cUserId").value(cei.O00000Oo(O00000Oo)).domain(httpUrl.host()).build());
        }
        if (!TextUtils.isEmpty(O00000Oo2)) {
            arrayList.add(new Cookie.Builder().name("xm_in_sid").value(O00000Oo2).domain(httpUrl.host()).build());
        }
        return arrayList;
    }
}

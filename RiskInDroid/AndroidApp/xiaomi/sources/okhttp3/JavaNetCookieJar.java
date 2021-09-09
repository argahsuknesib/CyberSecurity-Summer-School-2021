package okhttp3;

import _m_j.jdn;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.internal.Util;
import okhttp3.internal.annotations.EverythingIsNonNull;
import okhttp3.internal.platform.Platform;

@EverythingIsNonNull
public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler2) {
        this.cookieHandler = cookieHandler2;
    }

    public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.cookieHandler != null) {
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie : list) {
                arrayList.add(cookie.toString(true));
            }
            try {
                this.cookieHandler.put(httpUrl.uri(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (IOException e) {
                Platform platform = Platform.get();
                platform.log(5, "Saving cookies failed for " + httpUrl.resolve("/..."), e);
            }
        }
    }

    public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
        try {
            ArrayList arrayList = null;
            for (Map.Entry next : this.cookieHandler.get(httpUrl.uri(), Collections.emptyMap()).entrySet()) {
                String str = (String) next.getKey();
                if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) next.getValue()).isEmpty()) {
                    for (String str2 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException e) {
            Platform platform = Platform.get();
            platform.log(5, "Loading cookies failed for " + httpUrl.resolve("/..."), e);
            return Collections.emptyList();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: okhttp3.internal.Util.delimiterOffset(java.lang.String, int, int, char):int
     arg types: [java.lang.String, int, int, int]
     candidates:
      okhttp3.internal.Util.delimiterOffset(java.lang.String, int, int, java.lang.String):int
      okhttp3.internal.Util.delimiterOffset(java.lang.String, int, int, char):int */
    private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, i, length, ";,");
            int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith(jdn.f1779O000000o) && trimSubstring2.endsWith(jdn.f1779O000000o)) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }
}

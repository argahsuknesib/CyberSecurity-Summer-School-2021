package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser {
    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = "Date";
        if (map.get(str) == null) {
            str = "date";
        }
        String str2 = map.get(str);
        long j2 = 0;
        long parseDateAsEpoch = str2 != null ? parseDateAsEpoch(str2) : 0;
        String str3 = "Cache-Control";
        if (map.get(str3) == null) {
            str3 = "cache-control";
        }
        String str4 = map.get(str3);
        int i = 0;
        if (str4 != null) {
            String[] split = str4.split(",");
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    j = 0;
                }
                i++;
            }
            i = 1;
        } else {
            j = 0;
        }
        String str5 = "Expires";
        if (map.get(str5) == null) {
            str5 = "expires";
        }
        String str6 = map.get(str5);
        long parseDateAsEpoch2 = str6 != null ? parseDateAsEpoch(str6) : 0;
        String str7 = "ETag";
        if (map.get(str7) == null) {
            str7 = "etag";
        }
        String str8 = map.get(str7);
        if (str8 == null) {
            String str9 = "ETag2";
            if (map.get(str9) == null) {
                str9 = "etag2";
            }
            str8 = map.get(str9);
        }
        if (i != 0) {
            j2 = currentTimeMillis + (j * 1000);
        } else if (parseDateAsEpoch > 0 && parseDateAsEpoch2 >= parseDateAsEpoch) {
            j2 = currentTimeMillis + (parseDateAsEpoch2 - parseDateAsEpoch);
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str8;
        entry.softTtl = j2;
        entry.ttl = entry.softTtl;
        entry.serverDate = parseDateAsEpoch;
        entry.responseHeaders = map;
        return entry;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }

    public static String parseCharset(Map<String, String> map) {
        String str = "Content-Type";
        if (map.get(str) == null) {
            str = "content-type";
        }
        String str2 = map.get(str);
        if (str2 == null) {
            return "ISO-8859-1";
        }
        String[] split = str2.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}

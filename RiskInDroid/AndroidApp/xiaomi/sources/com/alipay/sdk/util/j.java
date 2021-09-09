package com.alipay.sdk.util;

import com.alipay.sdk.app.c;
import com.alipay.sdk.sys.a;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j {
    public static Map<String, String> a(a aVar, String str) {
        Map<String, String> a2 = a();
        try {
            return a(str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "FormatResultEx", th);
            return a2;
        }
    }

    private static Map<String, String> a() {
        c b = c.b(c.CANCELED.a());
        HashMap hashMap = new HashMap();
        hashMap.put("resultStatus", Integer.toString(b.a()));
        hashMap.put("memo", b.b());
        hashMap.put("result", "");
        return hashMap;
    }

    public static Map<String, String> a(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, b(str2, substring));
        }
        return hashMap;
    }

    private static String b(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return "?";
        } catch (Throwable th) {
            c.a(th);
            return "?";
        }
    }
}

package com.alipay.sdk.util;

import _m_j.jdn;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;

public class g {
    public static void a(a aVar, Context context, String str) {
        try {
            String a2 = a(str);
            c.a("mspl", "trade token: ".concat(String.valueOf(a2)));
            if (!TextUtils.isEmpty(a2)) {
                h.a(aVar, context, "pref_trade_token", a2);
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "SaveTradeTokenError", th);
            c.a(th);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        String str2 = null;
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith("result={") && split[i].endsWith("}")) {
                String[] split2 = split[i].substring(8, split[i].length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 < split2.length) {
                        if (split2[i2].startsWith("trade_token=\"") && split2[i2].endsWith(jdn.f1779O000000o)) {
                            str2 = split2[i2].substring(13, split2[i2].length() - 1);
                            break;
                        } else if (split2[i2].startsWith("trade_token=")) {
                            str2 = split2[i2].substring(12);
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(a aVar, Context context) {
        String b = h.b(aVar, context, "pref_trade_token", "");
        c.a("mspl", "get trade token: ".concat(String.valueOf(b)));
        return b;
    }
}

package com.alipay.sdk.packet;

import _m_j.jdn;
import android.text.TextUtils;

public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            return "";
        }
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        for (String str6 : split) {
            if (TextUtils.isEmpty(str2)) {
                str2 = b(str6);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = c(str6);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = d(str6);
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = f(str6);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append("biz_type=" + str2 + ";");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("biz_no=" + str3 + ";");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("trade_no=" + str4 + ";");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append("app_userid=" + str5 + ";");
        }
        String sb2 = sb.toString();
        return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    private static String b(String str) {
        if (!str.contains("biz_type")) {
            return null;
        }
        return e(str);
    }

    private static String c(String str) {
        if (!str.contains("biz_no")) {
            return null;
        }
        return e(str);
    }

    private static String d(String str) {
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
            return null;
        }
        return e(str);
    }

    private static String e(String str) {
        String[] split = str.split("=");
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[1];
        return str2.contains(jdn.f1779O000000o) ? str2.replaceAll(jdn.f1779O000000o, "") : str2;
    }

    private static String f(String str) {
        if (!str.contains("app_userid")) {
            return null;
        }
        return e(str);
    }
}

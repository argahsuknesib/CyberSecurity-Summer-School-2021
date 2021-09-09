package com.amap.api.services.a;

import _m_j.jdn;
import android.content.Context;
import com.amap.api.services.core.AMapException;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    static dn f3289a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 == null) {
                return;
            }
            if (a2.length() > 0) {
                if (f3289a == null) {
                    f3289a = new dn(context, "sea", "6.9.3", "O002");
                }
                f3289a.a(a2);
                Cdo.a(f3289a, context);
            }
        } catch (Throwable th) {
            s.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{" + "\"RequestPath\":\"" + str + jdn.f1779O000000o + "," + "\"ResponseTime\":" + j + "," + "\"Success\":" + z + "}";
        } catch (Throwable th) {
            s.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null && aMapException != null) {
            String errorType = aMapException.getErrorType();
            String a2 = a(aMapException);
            if (a2 != null && a2.length() > 0) {
                cl.a(r.a(true), str, errorType, str2, a2);
            }
        }
    }

    private static String a(AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() == 0) {
            int errorCode = aMapException.getErrorCode();
            if (errorCode == 0) {
                return "4";
            }
            int pow = (int) Math.pow(10.0d, Math.floor(Math.log10((double) errorCode)));
            return String.valueOf((errorCode % pow) + (pow * 4));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aMapException.getErrorCode());
        return sb.toString();
    }
}

package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.c.d;

public class UmidSdkWrapper {
    private static volatile String cachedUmidToken = "";
    private static volatile boolean initUmidFinished = false;

    private static String compatUmidBug(Context context, String str) {
        if (!a.a(str) && !a.a(str, "000000000000000000000000")) {
            return str;
        }
        String utdid = UtdidWrapper.getUtdid(context);
        if (utdid != null && utdid.contains("?")) {
            utdid = "";
        }
        return a.a(utdid) ? "" : utdid;
    }

    public static synchronized String getSecurityToken(Context context) {
        String str;
        synchronized (UmidSdkWrapper.class) {
            str = cachedUmidToken;
        }
        return str;
    }

    public static String startUmidTaskSync(Context context, int i) {
        return "";
    }

    private static synchronized void updateLocalUmidToken(Context context, String str) {
        synchronized (UmidSdkWrapper.class) {
            if (a.b(str)) {
                d.a(context, "xxxwww_v2", "umidtk", str);
                cachedUmidToken = str;
            }
        }
    }
}

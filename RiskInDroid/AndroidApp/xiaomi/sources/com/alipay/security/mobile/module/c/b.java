package com.alipay.security.mobile.module.c;

import com.alipay.security.mobile.module.a.a;
import java.io.File;

public final class b {
    public static String a(String str) {
        String str2;
        try {
            str2 = f.a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (!a.a(str2)) {
            return str2;
        }
        return c.a(".SystemConfig" + File.separator + str);
    }
}

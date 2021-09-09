package com.alipay.security.mobile.module.a.a;

import com.alipay.security.mobile.module.a.a;
import java.security.MessageDigest;

public final class b {
    public static String a(String str) {
        try {
            if (a.a(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

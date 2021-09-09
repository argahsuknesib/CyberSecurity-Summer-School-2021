package _m_j;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Pattern;

public final class eml {
    public static String O000000o(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(O00000o0(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String O000000o(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length < 3) {
            i = length / 3;
            if (i <= 1) {
                i = 1;
            }
            if (i > 3) {
                i = 3;
            }
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 % i == 0) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i2));
            }
            i2 = i3;
        }
        return sb.toString();
    }

    public static String O000000o(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return O000000o(collection.iterator(), str);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a A[SYNTHETIC] */
    private static java.lang.String O000000o(java.util.Iterator<?> r3, java.lang.String r4) {
        /*
            if (r3 != 0) goto L_0x0004
            r3 = 0
            return r3
        L_0x0004:
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x000d
            java.lang.String r3 = ""
            return r3
        L_0x000d:
            java.lang.Object r0 = r3.next()
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x001c
            java.lang.String r3 = r0.toString()
            return r3
        L_0x001c:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r2 = 256(0x100, float:3.59E-43)
            r1.<init>(r2)
            if (r0 == 0) goto L_0x0028
        L_0x0025:
            r1.append(r0)
        L_0x0028:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x003a
            if (r4 == 0) goto L_0x0033
            r1.append(r4)
        L_0x0033:
            java.lang.Object r0 = r3.next()
            if (r0 == 0) goto L_0x0028
            goto L_0x0025
        L_0x003a:
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.eml.O000000o(java.util.Iterator, java.lang.String):java.lang.String");
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(O00000o0(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static boolean O00000o(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static byte[] O00000o0(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static boolean O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches();
    }

    public static boolean O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != charAt) {
                return false;
            }
        }
        return true;
    }
}

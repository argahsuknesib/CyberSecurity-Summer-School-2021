package _m_j;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class pa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SimpleDateFormat f2380O000000o;
    private static String O00000Oo;

    public static int O000000o(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static long O000000o(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    public static synchronized String O000000o(long j, String str) {
        synchronized (pa.class) {
            if (TextUtils.isEmpty(null)) {
                str = "yyyy-MM-dd HH:mm:ss:SSS";
            }
            if (f2380O000000o == null) {
                try {
                    f2380O000000o = new SimpleDateFormat(str, Locale.CHINA);
                    O00000Oo = str;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!str.equals(O00000Oo)) {
                f2380O000000o.applyPattern(str);
                O00000Oo = str;
            }
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            if (f2380O000000o == null) {
                return "NULL";
            }
            String format = f2380O000000o.format(Long.valueOf(j));
            return format;
        }
    }

    public static String O000000o(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            if (str.length() > 0 && i < bArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static byte[] O000000o(long j) {
        byte[] bArr = new byte[6];
        for (int i = 0; i < 6; i++) {
            bArr[i] = (byte) ((int) ((j >> (((6 - i) - 1) * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] O000000o(String str, String str2, String str3) {
        int i;
        int i2;
        int i3;
        if (str2.length() > 0) {
            i = str2.length();
            i2 = i + 2;
        } else {
            i = 0;
            i2 = 2;
        }
        if (str3.length() > 0) {
            i3 = str3.length();
            i2 += i3;
        } else {
            i3 = 0;
        }
        if ((str.length() + i3) % i2 == 0) {
            int length = (str.length() + i3) / i2;
            byte[] bArr = new byte[length];
            int i4 = i;
            int i5 = 0;
            while (i4 < str.length()) {
                bArr[i5] = (byte) Integer.parseInt(str.substring(i4, i4 + 2), 16);
                i4 += i3 + 2 + i;
                i5++;
            }
            if (i5 >= length) {
                return bArr;
            }
            throw new IllegalArgumentException("str 是不满足在规则的, 这是不可能的");
        }
        throw new IllegalArgumentException("str 是不满足在规则的");
    }
}

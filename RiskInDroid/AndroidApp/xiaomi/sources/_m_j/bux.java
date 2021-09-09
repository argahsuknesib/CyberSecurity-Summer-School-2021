package _m_j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Pattern;

final class bux {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Pattern f13301O000000o = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");

    static String O000000o(String str) {
        return new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16);
    }

    static String O00000Oo(String str) {
        return new BigInteger(1, MessageDigest.getInstance("SHA1").digest(str.getBytes())).toString(16);
    }
}

package _m_j;

import android.text.TextUtils;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class fll {
    private static boolean O000000o(int i) {
        return i == 0 || i == 1;
    }

    private static SecretKeySpec O000000o(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), "AES");
    }

    private static String O000000o(String str, String str2) {
        try {
            SecretKeySpec O000000o2 = O000000o(str);
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(1, O000000o2, new IvParameterSpec(got.O000000o("7aa4c68c590d4031b980d98b41023800")));
            return got.O00000o0(instance.doFinal(got.O000000o(str2)));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private static String O00000Oo(String str, String str2) {
        try {
            SecretKeySpec O000000o2 = O000000o(str);
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, O000000o2, new IvParameterSpec(got.O000000o("7aa4c68c590d4031b980d98b41023800")));
            return got.O00000o0(instance.doFinal(got.O000000o(str2)));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String O000000o(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !O000000o(i) || i == 0 || i != 1) {
            return str2;
        }
        return O000000o(str, str2);
    }

    public static String O00000Oo(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !O000000o(i) || i == 0 || i != 1) {
            return str2;
        }
        return O00000Oo(str, str2);
    }
}

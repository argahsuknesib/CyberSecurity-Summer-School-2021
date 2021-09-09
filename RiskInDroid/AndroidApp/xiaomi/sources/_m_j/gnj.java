package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class gnj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f18045O000000o = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final String O00000Oo = O000000o((Object) "miotsdk").substring(0, 16);

    private static SecretKeySpec O00000Oo(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), "AES");
    }

    public static String O000000o(String str, String str2) throws Exception {
        SecretKeySpec O00000Oo2 = O00000Oo(str);
        byte[] bArr = f18045O000000o;
        byte[] bytes = str2.getBytes("UTF-8");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, O00000Oo2, new IvParameterSpec(bArr));
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }

    public static String O00000Oo(String str, String str2) throws Exception {
        SecretKeySpec O00000Oo2 = O00000Oo(str);
        byte[] decode = Base64.decode(str2, 2);
        byte[] bArr = f18045O000000o;
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, O00000Oo2, new IvParameterSpec(bArr));
        return new String(instance.doFinal(decode), "UTF-8");
    }

    private static String O000000o(Object obj) {
        String valueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals(valueOf, "0") && !TextUtils.equals(valueOf, "null")) {
            try {
                String O000000o2 = fku.O000000o(MessageDigest.getInstance("SHA-256").digest(valueOf.getBytes()));
                return O000000o2.substring(2, O000000o2.length() - 2);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return "";
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bArr = null;
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
            SecretKeySpec secretKeySpec = new SecretKeySpec(O00000Oo.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            bArr = instance.doFinal(str.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bArr != null) {
            return fku.O000000o(bArr);
        }
        return "";
    }

    public static String O00000o0(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            byte[] bArr = null;
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
                SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o((Object) str2).substring(0, 16).getBytes(), "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, secretKeySpec, ivParameterSpec);
                bArr = instance.doFinal(str.getBytes("utf-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bArr != null) {
                return fku.O000000o(bArr);
            }
        }
        return "";
    }
}

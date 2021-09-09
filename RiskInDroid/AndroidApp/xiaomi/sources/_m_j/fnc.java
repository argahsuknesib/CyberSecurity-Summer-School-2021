package _m_j;

import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class fnc {
    private static Cipher O000000o(String str) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
            return instance;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public static String O000000o(String str, String str2) {
        Cipher O000000o2 = O000000o(str);
        if (O000000o2 == null) {
            return null;
        }
        try {
            return Base64.encodeToString(O000000o2.doFinal(str2.getBytes("utf-8")), 2);
        } catch (Exception unused) {
            return null;
        }
    }
}

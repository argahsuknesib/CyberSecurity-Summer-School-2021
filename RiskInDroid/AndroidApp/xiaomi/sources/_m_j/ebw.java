package _m_j;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ebw {
    public static String O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + "1sjkd830)8&jfh^%$#d".getBytes().length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy("1sjkd830)8&jfh^%$#d".getBytes(), 0, bArr2, bArr.length, "1sjkd830)8&jfh^%$#d".getBytes().length);
        try {
            byte[] O00000o0 = O00000o0(bArr2);
            return (O00000o0 == null || O00000o0.length <= 0) ? "" : O00000Oo(O00000o0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String O00000Oo(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec("uiodj*7^5%$4)(!~".getBytes(), "AES"), new IvParameterSpec("mki*&^1dbriieye8".getBytes()));
            return new String(Base64.encode(instance.doFinal(bArr), 2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] O00000o0(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }
    }
}

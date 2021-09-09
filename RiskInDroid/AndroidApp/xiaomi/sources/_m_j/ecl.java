package _m_j;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ecl {
    private static AlgorithmParameterSpec O000000o() {
        try {
            return new IvParameterSpec("Gruj<tOv]Ok[Ad.T".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, O00000Oo(), O000000o());
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return bArr;
        }
    }

    private static Key O00000Oo() {
        try {
            return new SecretKeySpec("drUsh]ipt?es;Ith".getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

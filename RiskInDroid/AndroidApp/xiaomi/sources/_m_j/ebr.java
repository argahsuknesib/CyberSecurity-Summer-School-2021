package _m_j;

import android.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ebr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15154O000000o = "b92939a1a2724a44";
    private static String O00000Oo = "a92939b1b2723b33";

    public static byte[] O000000o(String str) {
        try {
            byte[] decode = Base64.decode(str, 2);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec("*7^%4)KIjh17sd98".getBytes(), "AES"), new IvParameterSpec(O00000Oo.getBytes()));
            return instance.doFinal(decode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec("*7^%4)KIjh17sd98".getBytes(), "AES"), new IvParameterSpec(O00000Oo.getBytes()));
            return Base64.encode(instance.doFinal(bArr), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 16; i++) {
                stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
            }
            f15154O000000o = stringBuffer.toString();
            instance.init(1, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(f15154O000000o.getBytes()));
            byte[] doFinal = instance.doFinal(bArr);
            byte[] bArr2 = new byte[(f15154O000000o.getBytes().length + doFinal.length)];
            System.arraycopy(f15154O000000o.getBytes(), 0, bArr2, 0, f15154O000000o.getBytes().length);
            System.arraycopy(doFinal, 0, bArr2, f15154O000000o.getBytes().length, doFinal.length);
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

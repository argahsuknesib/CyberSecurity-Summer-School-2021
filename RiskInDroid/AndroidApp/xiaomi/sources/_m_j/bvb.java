package _m_j;

import android.support.v4.app.NotificationCompat;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bvb {
    public static String O000000o(String str, String str2) {
        byte[] bArr;
        try {
            byte[] O000000o2 = O000000o(str.getBytes());
            byte[] bytes = str2.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            bArr = instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return O00000Oo(bArr);
        }
        return null;
    }

    private static byte[] O000000o(byte[] bArr) throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, instance2);
        return instance.generateKey().getEncoded();
    }

    public static String O00000Oo(String str, String str2) {
        try {
            byte[] O000000o2 = O000000o(str.getBytes());
            int length = str2.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            return new String(instance.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String O00000Oo(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}

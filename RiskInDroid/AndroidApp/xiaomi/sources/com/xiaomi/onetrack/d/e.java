package com.xiaomi.onetrack.d;

import android.os.Build;
import com.xiaomi.onetrack.h.q;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class e {
    public static byte[] a(byte[] bArr) throws Exception {
        try {
            RSAPublicKey a2 = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiH0r18h2G+lOzZz0mSZT9liZY\r6ibWUv/biAioduf0zuRbWUYGb3pHobyCOaw2LpVnlf8CeCYtbRJhxL9skOyoU1Qa\rwGtoJzvVR4GbCo1MBTmZ8XThMprr0unRfzsu9GNV4+twciOdS2cNJB7INcwAYBFQ\r9vKpgXFoEjWRhIgwMwIDAQAB\r");
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            instance.init(1, a2);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            q.b(q.a("RsaUtils"), "RsaUtils encrypt exception:", e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            RSAPublicKey b = b(bArr);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, b);
            return instance.doFinal(bArr2);
        } catch (Exception e) {
            q.b("RsaUtils", "RsaUtil encrypt exception:", e);
            return null;
        }
    }

    private static RSAPublicKey a(String str) throws Exception {
        KeyFactory keyFactory;
        if (Build.VERSION.SDK_INT >= 28) {
            keyFactory = KeyFactory.getInstance("RSA");
        } else {
            keyFactory = KeyFactory.getInstance("RSA", "BC");
        }
        return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(c.a(str)));
    }

    private static RSAPublicKey b(byte[] bArr) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }
}

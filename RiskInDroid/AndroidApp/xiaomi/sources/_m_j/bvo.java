package _m_j;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bvo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f13315O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] O00000Oo = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final IvParameterSpec O00000o0 = new IvParameterSpec(O00000Oo);

    public static String O000000o(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String O000000o2 = O000000o("SHA1", str);
                    return O000000o("MD5", O000000o2 + str);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static String O000000o(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            byte[] O000000o2 = brp.O000000o(str2.getBytes("UTF-8"), str);
            int length = O000000o2.length;
            StringBuilder sb = new StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                sb.append(f13315O000000o[(O000000o2[i] >> 4) & 15]);
                sb.append(f13315O000000o[O000000o2[i] & 15]);
            }
            return sb.toString();
        } catch (Throwable th) {
            bvz.O000000o(th, "Encrypt", "encode");
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        int i = 0;
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(brs.O00000o0()));
            return instance.doFinal(bArr3);
        } catch (Throwable th) {
            if (bArr != null) {
                i = bArr.length;
            }
            bvz.O000000o(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(i)));
            return null;
        }
    }

    public static synchronized byte[] O000000o(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (bvo.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bwx.O00000Oo(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 245 ? instance.doFinal(bArr, i, 245) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 245;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), O00000o0);
        return instance.doFinal(bArr2);
    }

    private static SecretKeySpec O00000Oo(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            bvz.O000000o(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static synchronized byte[] O00000Oo(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (bvo.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bwx.O00000Oo(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 256 ? instance.doFinal(bArr, i, 256) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 256;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    public static byte[] O00000o(byte[] bArr, String str) {
        try {
            SecretKeySpec O00000Oo2 = O00000Oo(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(brs.O00000o0());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, O00000Oo2, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            bvz.O000000o(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    public static byte[] O00000o0(byte[] bArr, String str) {
        try {
            SecretKeySpec O00000Oo2 = O00000Oo(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(brs.O00000o0());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, O00000Oo2, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            bvz.O000000o(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }
}

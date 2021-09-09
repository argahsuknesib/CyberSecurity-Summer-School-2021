package _m_j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ml {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f2185O000000o = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void O000000o(String str, String str2, String str3) {
        byte[] O00000Oo = O00000Oo(str);
        if (O00000Oo == null) {
            gsy.O000000o(6, "VideoDecryption", "read file error:".concat(String.valueOf(str)));
            return;
        }
        byte[] O000000o2 = O000000o(str2);
        if (O000000o2 == null) {
            gsy.O000000o(6, "VideoDecryption", "md5 error:".concat(String.valueOf(str2)));
            return;
        }
        byte[] O000000o3 = O000000o(O00000Oo, O000000o2);
        if (O000000o3 == null || O000000o3.length < 2) {
            gsy.O000000o(6, "VideoDecryption", "decryption error");
        } else if (chp.O00000Oo()) {
            byte b = O000000o3[O000000o3.length - 1];
            if (b <= 0 || b > 16) {
                O00000Oo(O000000o3, str3);
                return;
            }
            int length = O000000o3.length - b;
            byte[] bArr = new byte[length];
            System.arraycopy(O000000o3, 0, bArr, 0, length);
            O00000Oo(bArr, str3);
        } else {
            O00000Oo(O000000o3, str3);
        }
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        byte[] O000000o2 = O000000o(str);
        if (O000000o2 == null) {
            gsy.O000000o(6, "VideoDecryption", "md5 error:".concat(String.valueOf(str)));
            return null;
        }
        byte[] O000000o3 = O000000o(bArr, O000000o2);
        if (O000000o3 == null) {
            gsy.O000000o(6, "VideoDecryption", "decryption error");
        }
        return O000000o3;
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, secretKeySpec, new IvParameterSpec(f2185O000000o));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toLowerCase().getBytes();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static byte[] O00000Oo(String str) {
        byte[] bArr = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (FileNotFoundException | IOException unused) {
            return bArr;
        }
    }

    private static void O00000Oo(byte[] bArr, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

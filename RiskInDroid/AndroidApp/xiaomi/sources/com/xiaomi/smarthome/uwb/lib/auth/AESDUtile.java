package com.xiaomi.smarthome.uwb.lib.auth;

import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESDUtile {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return aes(bArr, bArr2, bArr3, 1);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return aes(bArr, bArr2, bArr3, 2);
    }

    private static byte[] aes(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decodeHex(char[] cArr) throws Exception {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                i = i3 + 1;
                bArr[i2] = (byte) (((toDigit(cArr[i], i) << 4) | toDigit(cArr[i3], i3)) & 255);
                i2++;
            }
            return bArr;
        }
        throw new Exception("Odd number of characters.");
    }

    public static byte[] decodeHex(String str) {
        try {
            return decodeHex(str.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int toDigit(char c, int i) throws Exception {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new Exception("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, DIGITS_LOWER);
    }

    public static byte[] generateAesKey(int i) throws Exception {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(i);
            return instance.generateKey().getEncoded();
        } catch (GeneralSecurityException e) {
            throw new Exception(e);
        }
    }

    public static void main() throws Exception {
        byte[] decodeHex = decodeHex("7985c4cc0cf22caccddb0b864f79e5dd");
        byte[] decodeHex2 = decodeHex("e3205234a872012af4f3ac5dbd9c810c");
        System.out.println(decodeHex);
        System.out.println(decodeHex2);
        byte[] encrypt = encrypt("各位辛苦了".getBytes("utf-8"), decodeHex, decodeHex2);
        PrintStream printStream = System.out;
        printStream.println("加密后的内容:" + Arrays.toString(encrypt));
        byte[] decrypt = decrypt(encrypt, decodeHex, decodeHex2);
        PrintStream printStream2 = System.out;
        printStream2.println("解密后的内容:" + Arrays.toString(decrypt));
        PrintStream printStream3 = System.out;
        printStream3.println("解密后的内容:" + new String(decrypt, "utf-8"));
    }
}

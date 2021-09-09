package com.miui.tsmclient.common.util;

import android.util.Base64;

public class Coder {
    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final String[] HEX_DIGITS_UPPERCASE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private Coder() {
    }

    public static String byteArrayToString(byte[] bArr) {
        return byteArrayToString(bArr, false);
    }

    public static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte byteToHexString : bArr) {
            sb.append(byteToHexString(byteToHexString, z));
        }
        return sb.toString();
    }

    public static String byteToHexString(byte b) {
        return byteToHexString(b, false);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:0:0x0000 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static String byteToHexString(byte b, boolean z) {
        if (b < 0) {
            b += 256;
        }
        int i = b / 16;
        int i2 = b % 16;
        if (z) {
            return HEX_DIGITS_UPPERCASE[i] + HEX_DIGITS_UPPERCASE[i2];
        }
        return HEX_DIGITS[i] + HEX_DIGITS[i2];
    }

    public static String stringToHexString(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = str2 + Integer.toHexString(str.charAt(i));
        }
        return str2;
    }

    public static final String encodeBase64NoWrap(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static final String encodeBase64NoWrap(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static final byte[] encodeBase64BytesNoWrap(String str) {
        return Base64.encode(str.getBytes(), 2);
    }

    public static final String decodeBase64(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static final byte[] decodeBase64Bytes(String str) {
        return Base64.decode(str, 0);
    }
}

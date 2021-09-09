package com.tsmclient.smartcard;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Coder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    public static byte toBytesLow(int i) {
        return (byte) (i & 255);
    }

    public static int sizeOfInt(int i) {
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > sizeTable[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    public static String to2Bytes(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    public static String to4Bytes(int i) {
        return String.format("%04d", Integer.valueOf(i));
    }

    public static String to10Bytes(int i) {
        return String.format("%010d", Integer.valueOf(i));
    }

    public static String to4HexBytes(int i) {
        return String.format("%04X", Integer.valueOf(i & 65535));
    }

    public static String bytesToHexString(byte b) {
        return bytesToHexString(new byte[]{b}, 0, 1);
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bytesToHexString(bArr, 0, bArr.length);
    }

    private static String bytesToHexString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[(i2 * 2)];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i3] = cArr2[(b >>> 4) & 15];
            i3 = i5 + 1;
            cArr[i5] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((toByte(str.charAt(i)) << 4) | toByte(str.charAt(i + 1)));
        }
        return bArr;
    }

    public static String decodeBase64Coder(String str) {
        return !TextUtils.isEmpty(str) ? new String(Base64.decode(str, 8)) : str;
    }

    public static byte[] decodeBase64ToByteArray(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Base64.decode(str, 8);
        }
        return null;
    }

    public static String encodeBase64Coder(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 8);
        }
        return null;
    }

    public static String hashDeviceInfo(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(str.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("failed to init SHA1 digest");
        }
    }

    public static String encodeMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return bytesToHexString(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String encodeMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return bytesToHexString(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static int toByte(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                throw new RuntimeException("Invalid hex char '" + c + "'");
            }
        }
        return (c - c2) + 10;
    }

    public static int bytesToInt(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 > bArr.length) {
            throw new IllegalArgumentException("argument is null");
        }
        byte b = 0;
        int i3 = i2 + i;
        while (i < i3) {
            b = (b << 8) | (bArr[i] & 255);
            i++;
        }
        return b;
    }

    public static int hexStringToInt(String str) {
        return bytesToInt(hexStringToBytes(str));
    }

    public static int bytesToInt(byte... bArr) {
        if (bArr != null) {
            byte b = 0;
            for (byte b2 : bArr) {
                b = (b << 8) | (b2 & 255);
            }
            return b;
        }
        throw new IllegalArgumentException("argument is null");
    }

    public static byte[] str2Bcd(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        if (str != null) {
            int length = str.length();
            if (length % 2 != 0) {
                str = "0".concat(String.valueOf(str));
                length = str.length();
            }
            if (length >= 2) {
                length /= 2;
            }
            byte[] bArr = new byte[length];
            byte[] bytes = str.getBytes();
            for (int i5 = 0; i5 < str.length() / 2; i5++) {
                int i6 = i5 * 2;
                if (bytes[i6] < 48 || bytes[i6] > 57) {
                    if (bytes[i6] < 97 || bytes[i6] > 122) {
                        i4 = bytes[i6] - 65;
                    } else {
                        i4 = bytes[i6] - 97;
                    }
                    i = i4 + 10;
                } else {
                    i = bytes[i6] - 48;
                }
                int i7 = i6 + 1;
                if (bytes[i7] < 48 || bytes[i7] > 57) {
                    if (bytes[i7] < 97 || bytes[i7] > 122) {
                        i3 = bytes[i7] - 65;
                    } else {
                        i3 = bytes[i7] - 97;
                    }
                    i2 = i3 + 10;
                } else {
                    i2 = bytes[i7] - 48;
                }
                bArr[i5] = (byte) ((i << 4) + i2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("argument is null");
    }

    public static byte[] shortToByte(short s) {
        return new byte[]{(byte) ((s >>> 8) & 255), (byte) (s & 255)};
    }
}

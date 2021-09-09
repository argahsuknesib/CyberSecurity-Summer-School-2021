package com.xiaomi.mico.common.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String MD5_32(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            instance.update(str.getBytes());
            for (byte byte2Hex : instance.digest()) {
                sb.append(byte2Hex(byte2Hex));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String MD5_16(String str) {
        String MD5_32 = MD5_32(str);
        return MD5_32 != null ? MD5_32.subSequence(8, 24).toString() : "";
    }

    private static String byte2Hex(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String file(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            Log.e("MD5", "Exception on closing MD5 input stream", e2);
                        }
                        throw th;
                    }
                }
                String replace = String.format("%32s", new BigInteger(1, instance.digest()).toString(16)).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    Log.e("MD5", "Exception on closing MD5 input stream", e3);
                }
                return replace;
            } catch (FileNotFoundException e4) {
                Log.e("MD5", "Exception while getting FileInputStream", e4);
                return null;
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}

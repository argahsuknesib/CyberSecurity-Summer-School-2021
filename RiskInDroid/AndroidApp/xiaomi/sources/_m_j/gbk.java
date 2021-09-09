package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class gbk {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O000000o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return String.format("%32s", new BigInteger(1, instance.digest()).toString(16)).replace(' ', '0');
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O000000o(RandomAccessFile randomAccessFile, int i, int i2) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            int i3 = i;
            int i4 = 0;
            int i5 = 0;
            int i6 = 4096;
            while (i4 != -1 && i5 < i2) {
                int i7 = i2 - i5;
                if (i7 < 4096) {
                    i6 = i7;
                }
                if (i6 <= 0) {
                    break;
                }
                byte[] bArr = new byte[i6];
                randomAccessFile.seek((long) i3);
                int read = randomAccessFile.read(bArr, 0, i6);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
                i5 += i6;
                int i8 = read;
                i3 = i + i5;
                i4 = i8;
            }
            return String.format("%32s", new BigInteger(1, instance.digest()).toString(16)).replace(' ', '0');
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                byte b = digest[i];
                int i2 = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 < 16 ? "0" : "");
                sb2.append(Integer.toHexString(i2).toLowerCase());
                sb.append(sb2.toString());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}

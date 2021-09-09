package _m_j;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

public final class gbx {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC, Splitter:B:20:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A[SYNTHETIC, Splitter:B:28:0x0038] */
    public static String O000000o(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4096];
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                int i = 0;
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                String O000000o2 = O000000o(instance.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return O000000o2;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static String O000000o(RandomAccessFile randomAccessFile, int i, int i2) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
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
            return O000000o(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String O000000o(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = str + Integer.toString((bArr[i] & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }
}

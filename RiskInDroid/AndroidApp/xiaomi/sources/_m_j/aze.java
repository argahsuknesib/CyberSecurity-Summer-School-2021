package _m_j;

import android.util.Log;
import java.io.FileInputStream;
import java.security.MessageDigest;

public final class aze {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052 A[SYNTHETIC, Splitter:B:31:0x0052] */
    public static String O000000o(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
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
            } catch (Exception e) {
                e = e;
                try {
                    Log.i("HanntoPrinterService", "fileToSHA1 " + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            Log.i("HanntoPrinterService", "fileToSHA1 " + e.getMessage());
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
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

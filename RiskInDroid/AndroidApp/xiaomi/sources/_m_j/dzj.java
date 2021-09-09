package _m_j;

import android.text.TextUtils;
import java.io.FileInputStream;

public final class dzj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15099O000000o;

    public static String O000000o() {
        if (TextUtils.isEmpty(f15099O000000o)) {
            f15099O000000o = O00000Oo();
        }
        return f15099O000000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        if (r2 != null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f A[Catch:{ Throwable -> 0x003a, all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0035 A[SYNTHETIC, Splitter:B:22:0x0035] */
    private static String O00000Oo() {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                byte[] bArr = new byte[256];
                int i = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read > 0 && i < 256) {
                        bArr[i] = (byte) read;
                        i++;
                    } else if (i > 0) {
                        String str = new String(bArr, 0, i, "UTF-8");
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return str;
                    }
                }
                if (i > 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused3) {
        }
        return null;
    }
}

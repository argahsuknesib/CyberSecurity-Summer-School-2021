package _m_j;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class ceg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f13686O000000o;
    private static final String O00000Oo;

    static {
        boolean z = cdz.f13673O000000o;
        f13686O000000o = z;
        O00000Oo = z ? "SignUtils" : ceg.class.getSimpleName();
    }

    private static String O000000o(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        char[] cArr2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC, Splitter:B:22:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC, Splitter:B:27:0x003f] */
    private static String O000000o(File file) {
        FileInputStream fileInputStream;
        String str = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str = O000000o(instance.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    public static boolean O000000o(String str, String str2) {
        File file = new File(str);
        if (!TextUtils.isEmpty(str2)) {
            String O000000o2 = O000000o(file);
            if (f13686O000000o) {
                Log.d(O00000Oo, String.format("file's md5=%s, real md5=%s", O000000o2, str2));
            }
            return str2.equals(O000000o2);
        }
        throw new RuntimeException("md5 cannot be empty");
    }
}

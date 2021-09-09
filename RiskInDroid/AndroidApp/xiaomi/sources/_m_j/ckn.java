package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ckn {
    public static File O000000o(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        return file;
    }

    public static boolean O00000Oo(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0043 A[Catch:{ all -> 0x005b }] */
    public static void O000000o(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        File O000000o2 = O000000o(str2);
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(O000000o2);
            } catch (Exception unused) {
                fileOutputStream = null;
                inputStream = open;
                try {
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    O000000o(inputStream);
                    O000000o(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    O000000o(inputStream);
                    O000000o(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = open;
                O000000o(inputStream);
                O000000o(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                O000000o(open);
            } catch (Exception unused2) {
                inputStream = open;
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str2);
                    if (file.exists() && !file.isDirectory()) {
                        file.delete();
                    }
                }
                O000000o(inputStream);
                O000000o(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                inputStream = open;
                O000000o(inputStream);
                O000000o(fileOutputStream);
                throw th;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
            if (!TextUtils.isEmpty(str2)) {
            }
            O000000o(inputStream);
            O000000o(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            O000000o(inputStream);
            O000000o(fileOutputStream);
            throw th;
        }
        O000000o(fileOutputStream);
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}

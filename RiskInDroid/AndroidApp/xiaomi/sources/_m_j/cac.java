package _m_j;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class cac {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public static File O000000o(Context context) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        if ("mounted".equals(str)) {
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                file = O00000Oo(context);
                if (file == null) {
                    file = context.getCacheDir();
                }
                if (file == null) {
                    return file;
                }
                return new File("/data/data/" + context.getPackageName() + "/cache/");
            }
        }
        file = null;
        if (file == null) {
        }
        if (file == null) {
        }
    }

    private static File O00000Oo(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
            }
        }
        return file;
    }
}

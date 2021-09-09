package _m_j;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class cow {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public static File O000000o(Context context, boolean z) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        if (z && "mounted".equals(str)) {
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                file = O000000o(context);
                if (file == null) {
                    file = context.getCacheDir();
                }
                if (file == null) {
                    return file;
                }
                String str2 = "/data/data/" + context.getPackageName() + "/cache/";
                cou.O00000o0("Can't define system cache directory! '%s' will be used.", str2);
                return new File(str2);
            }
        }
        file = null;
        if (file == null) {
        }
        if (file == null) {
        }
    }

    private static File O000000o(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                cou.O00000o0("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                cou.O00000Oo("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }
}

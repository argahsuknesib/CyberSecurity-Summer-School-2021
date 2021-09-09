package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;

public final class goa {
    @SuppressLint({"NewApi"})
    public static boolean O000000o() {
        return Build.VERSION.SDK_INT < 9 || Environment.isExternalStorageRemovable();
    }

    @SuppressLint({"NewApi"})
    public static File O000000o(Context context) {
        File externalCacheDir;
        if (O00000Oo() && (externalCacheDir = context.getExternalCacheDir()) != null) {
            return externalCacheDir;
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    private static boolean O00000Oo() {
        return Build.VERSION.SDK_INT >= 8;
    }
}

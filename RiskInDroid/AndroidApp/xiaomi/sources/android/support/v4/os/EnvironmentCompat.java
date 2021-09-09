package android.support.v4.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat {
    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EnvironmentCompatKitKat.getStorageState(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                return Environment.getExternalStorageState();
            }
            return "unknown";
        } catch (IOException e) {
            Log.w("EnvironmentCompat", "Failed to resolve canonical path: ".concat(String.valueOf(e)));
            return "unknown";
        }
    }

    private EnvironmentCompat() {
    }
}

package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public final class hgh {
    public static boolean O000000o(Context context) {
        ActivityManager activityManager;
        File externalFilesDir;
        try {
            if (TextUtils.equals(Environment.getExternalStorageState(), "mounted") && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                fws.O00000Oo(externalFilesDir.getParent());
            }
            fws.O00000Oo(new File("/data/data/" + context.getPackageName() + "/").getAbsolutePath());
            if (Build.VERSION.SDK_INT < 19 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
                return true;
            }
            activityManager.clearApplicationUserData();
            return true;
        } catch (Exception e) {
            gsy.O000000o(6, "AppDataCleanHelper", "clearAppData: " + Log.getStackTraceString(e));
            return false;
        }
    }
}

package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public final class cdw {
    public static boolean O000000o(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String O00000Oo(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

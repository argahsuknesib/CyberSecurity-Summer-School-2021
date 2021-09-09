package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

public final class iij {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f1316O000000o;

    public static String O000000o(Context context) {
        if (!TextUtils.isEmpty(f1316O000000o)) {
            return f1316O000000o;
        }
        if (TextUtils.isEmpty(f1316O000000o)) {
            try {
                f1316O000000o = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f1316O000000o;
    }

    public static String O000000o(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

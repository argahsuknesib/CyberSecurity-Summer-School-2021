package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public final class gwd {
    public static boolean O000000o(Context context, String str, String str2) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        if (TextUtils.isEmpty(null)) {
            izb.O000000o(context, str2, 0).show();
        }
        return false;
    }

    public static void O000000o(Intent intent) {
        intent.putExtra("source", "smarthome_launch");
    }
}

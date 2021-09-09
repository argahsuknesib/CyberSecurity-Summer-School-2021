package _m_j;

import android.app.AppOpsManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;

public final class gpu {
    public static boolean O000000o(Context context, int i) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Process.myUid()), context.getPackageName())).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("PermssionUtil", "not support", th);
            return false;
        }
    }

    public static void O000000o(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("pkg", context.getPackageName());
        bundle.putBoolean("status", z);
        try {
            context.getContentResolver().call(Uri.parse("content://com.miui.security.permission"), "setAutoStart", (String) null, bundle);
        } catch (Exception e) {
            Log.e("PermssionUtil", "not support", e);
        }
    }
}

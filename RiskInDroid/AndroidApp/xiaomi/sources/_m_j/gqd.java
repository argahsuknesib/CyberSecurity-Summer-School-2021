package _m_j;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

public final class gqd {
    public static boolean O000000o(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.getApplicationInfo().targetSdkVersion < 23) {
            if (g.O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Uri O000000o(int i) {
        return Uri.parse("res://" + gfr.O0000O0o + "/" + i);
    }

    public static boolean O000000o(Activity activity) {
        if (activity.isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080 A[RETURN] */
    public static boolean O000000o(Context context) {
        Method method;
        int i;
        if (Build.MANUFACTURER.toLowerCase().contains("vivo")) {
            if (context != null) {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (query != null) {
                    query.getColumnNames();
                    if (query.moveToFirst()) {
                        i = query.getInt(query.getColumnIndex("currentlmode"));
                        query.close();
                        return i == 0;
                    }
                    query.close();
                }
                Cursor query2 = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        int i2 = query2.getInt(query2.getColumnIndex("currentmode"));
                        query2.close();
                        i = i2;
                        if (i == 0) {
                        }
                    } else {
                        query2.close();
                    }
                }
                i = 1;
                if (i == 0) {
                }
            } else {
                throw new IllegalArgumentException("context is null");
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        } else {
            try {
                Object systemService = context.getApplicationContext().getSystemService("appops");
                if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                    return false;
                }
                return ((Integer) method.invoke(systemService, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception unused) {
            }
        }
    }
}

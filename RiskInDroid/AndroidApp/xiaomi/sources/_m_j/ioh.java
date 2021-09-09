package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public abstract class ioh {
    public abstract Context O000000o();

    public abstract void O000000o(Intent intent);

    public abstract void O000000o(Intent intent, int i);

    public final boolean O000000o(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        PackageManager packageManager = O000000o().getPackageManager();
        Class<?> cls = packageManager.getClass();
        try {
            oOOO00o0.O000000o((Activity) null, "");
            Method method = cls.getMethod("shouldShowRequestPermissionRationale", String.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, str)).booleanValue();
        } catch (Exception unused) {
            Context O000000o2 = O000000o();
            if (O000000o2 == null || !(O000000o2 instanceof Activity)) {
                return false;
            }
            return oOOO00o0.O000000o((Activity) O000000o2, str);
        }
    }
}

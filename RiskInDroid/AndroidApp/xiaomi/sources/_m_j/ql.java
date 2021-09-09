package _m_j;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import java.lang.reflect.Method;

public final class ql {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f2400O000000o;
    private static long O00000Oo;
    private static boolean O00000o0;

    public static String O000000o(Context context) {
        if (f2400O000000o == null) {
            f2400O000000o = context.getPackageName();
        }
        String O000000o2 = qp.O000000o(f2400O000000o);
        f2400O000000o = O000000o2;
        return O000000o2;
    }

    public static boolean O000000o(Location location) {
        if (location == null) {
            return false;
        }
        try {
            Method method = Location.class.getMethod("isFromMockProvider", null);
            if (method != null) {
                return ((Boolean) method.invoke(location, null)).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O00000Oo(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23) {
            return false;
        }
        if (O00000Oo > 0 && SystemClock.elapsedRealtime() - O00000Oo < 180000) {
            return O00000o0;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "mock_location");
            if (string != null && !string.equals("0")) {
                z = true;
            }
        } catch (SecurityException unused) {
        }
        O00000o0 = z;
        O00000Oo = SystemClock.elapsedRealtime();
        return z;
    }

    public static boolean O00000o0(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable unused) {
            return false;
        }
    }
}

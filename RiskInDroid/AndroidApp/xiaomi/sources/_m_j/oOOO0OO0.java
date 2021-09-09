package _m_j;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class oOOO0OO0 {

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static Method f2320O000000o;
        private static boolean O00000Oo;
        private static boolean O00000o;
        private static Method O00000o0;

        public static IBinder O000000o(Bundle bundle, String str) {
            if (!O00000Oo) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    f2320O000000o = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                O00000Oo = true;
            }
            Method method2 = f2320O000000o;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f2320O000000o = null;
                }
            }
            return null;
        }

        public static void O000000o(Bundle bundle, String str, IBinder iBinder) {
            if (!O00000o) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    O00000o0 = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                O00000o = true;
            }
            Method method2 = O00000o0;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    O00000o0 = null;
                }
            }
        }
    }

    public static IBinder O000000o(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return O000000o.O000000o(bundle, str);
    }

    public static void O000000o(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            O000000o.O000000o(bundle, str, iBinder);
        }
    }
}

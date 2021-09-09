package android.support.v4.app;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(9)
@RequiresApi(9)
class BundleCompatGingerbread {
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    BundleCompatGingerbread() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        if (!sGetIBinderMethodFetched) {
            try {
                Method method = Bundle.class.getMethod("getIBinder", String.class);
                sGetIBinderMethod = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve getIBinder method", e);
            }
            sGetIBinderMethodFetched = true;
        }
        Method method2 = sGetIBinderMethod;
        if (method2 != null) {
            try {
                return (IBinder) method2.invoke(bundle, str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatGingerbread", "Failed to invoke getIBinder via reflection", e2);
                sGetIBinderMethod = null;
            }
        }
        return null;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (!sPutIBinderMethodFetched) {
            try {
                Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                sPutIBinderMethod = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve putIBinder method", e);
            }
            sPutIBinderMethodFetched = true;
        }
        Method method2 = sPutIBinderMethod;
        if (method2 != null) {
            try {
                method2.invoke(bundle, str, iBinder);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatGingerbread", "Failed to invoke putIBinder via reflection", e2);
                sPutIBinderMethod = null;
            }
        }
    }
}

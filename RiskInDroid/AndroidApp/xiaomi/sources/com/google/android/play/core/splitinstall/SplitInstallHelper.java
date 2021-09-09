package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build;
import com.google.android.play.core.internal.aa;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SplitInstallHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3791a = new aa("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        synchronized (v.class) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                String mapLibraryName = System.mapLibraryName(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(mapLibraryName).length());
                sb.append(str2);
                sb.append("/");
                sb.append(mapLibraryName);
                String sb2 = sb.toString();
                if (new File(sb2).exists()) {
                    System.load(sb2);
                } else {
                    throw e;
                }
            }
        }
    }

    public static void updateAppInfo(Context context) {
        if (Build.VERSION.SDK_INT > 25 && Build.VERSION.SDK_INT < 28) {
            f3791a.c("Calling dispatchPackageBroadcast", new Object[0]);
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method method = cls.getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mAppThread");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                obj.getClass().getMethod("dispatchPackageBroadcast", Integer.TYPE, String[].class).invoke(obj, 3, new String[]{context.getPackageName()});
                f3791a.c("Called dispatchPackageBroadcast", new Object[0]);
            } catch (Exception e) {
                f3791a.a(e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
            }
        }
    }
}

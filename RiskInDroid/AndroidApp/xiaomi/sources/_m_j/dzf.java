package _m_j;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public final class dzf {
    public static boolean O000000o(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0 || runningTasks.get(0) == null || (componentName = runningTasks.get(0).topActivity) == null)) {
                String packageName = componentName.getPackageName();
                return !TextUtils.isEmpty(packageName) && packageName.equals(context.getPackageName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Activity O000000o() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object next : map.values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(next);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

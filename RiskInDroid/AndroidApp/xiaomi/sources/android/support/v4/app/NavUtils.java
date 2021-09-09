package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import android.util.Log;

public final class NavUtils {
    private static final NavUtilsImpl IMPL;

    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity activity);

        String getParentActivityName(Context context, ActivityInfo activityInfo);

        void navigateUpTo(Activity activity, Intent intent);

        boolean shouldUpRecreateTask(Activity activity, Intent intent);
    }

    static class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }

        public Intent getParentActivityIntent(Activity activity) {
            String parentActivityName = NavUtils.getParentActivityName(activity);
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, parentActivityName);
            try {
                if (NavUtils.getParentActivityName(activity, componentName) == null) {
                    return IntentCompat.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
                return null;
            }
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return action != null && !action.equals("android.intent.action.MAIN");
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            String string;
            if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
                return null;
            }
            if (string.charAt(0) != '.') {
                return string;
            }
            return context.getPackageName() + string;
        }
    }

    static class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
        }

        public Intent getParentActivityIntent(Activity activity) {
            Intent parentActivityIntent = NavUtilsJB.getParentActivityIntent(activity);
            return parentActivityIntent == null ? superGetParentActivityIntent(activity) : parentActivityIntent;
        }

        /* access modifiers changed from: package-private */
        public Intent superGetParentActivityIntent(Activity activity) {
            return super.getParentActivityIntent(activity);
        }

        public boolean shouldUpRecreateTask(Activity activity, Intent intent) {
            return NavUtilsJB.shouldUpRecreateTask(activity, intent);
        }

        public void navigateUpTo(Activity activity, Intent intent) {
            NavUtilsJB.navigateUpTo(activity, intent);
        }

        public String getParentActivityName(Context context, ActivityInfo activityInfo) {
            String parentActivityName = NavUtilsJB.getParentActivityName(activityInfo);
            return parentActivityName == null ? super.getParentActivityName(context, activityInfo) : parentActivityName;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new NavUtilsImplJB();
        } else {
            IMPL = new NavUtilsImplBase();
        }
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return IMPL.shouldUpRecreateTask(activity, intent);
    }

    public static void navigateUpFromSameTask(Activity activity) {
        Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent != null) {
            navigateUpTo(activity, parentActivityIntent);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        IMPL.navigateUpTo(activity, intent);
    }

    public static Intent getParentActivityIntent(Activity activity) {
        return IMPL.getParentActivityIntent(activity);
    }

    public static Intent getParentActivityIntent(Context context, Class<?> cls) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, new ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, parentActivityName);
        if (getParentActivityName(context, componentName) == null) {
            return IntentCompat.makeMainActivity(componentName);
        }
        return new Intent().setComponent(componentName);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (getParentActivityName(context, componentName2) == null) {
            return IntentCompat.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    @Nullable
    public static String getParentActivityName(Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return IMPL.getParentActivityName(context, context.getPackageManager().getActivityInfo(componentName, NotificationCompat.FLAG_HIGH_PRIORITY));
    }

    private NavUtils() {
    }
}

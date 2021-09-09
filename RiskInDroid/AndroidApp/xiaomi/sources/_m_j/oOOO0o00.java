package _m_j;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

public final class oOOO0o00 {
    public static Intent O000000o(Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        String O00000Oo = O00000Oo(activity);
        if (O00000Oo == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, O00000Oo);
        try {
            if (O00000Oo(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + O00000Oo + "' in manifest");
            return null;
        }
    }

    public static Intent O000000o(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String O00000Oo = O00000Oo(context, componentName);
        if (O00000Oo == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), O00000Oo);
        if (O00000Oo(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String O00000Oo(Activity activity) {
        try {
            return O00000Oo(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String O00000Oo(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i;
        String string;
        String str;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 29) {
            i = 269222528;
        } else {
            i = Build.VERSION.SDK_INT >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        if (Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }
}

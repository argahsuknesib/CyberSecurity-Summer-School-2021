package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

public class AppLaunchChecker {
    public static boolean hasStartedFromLauncher(Context context) {
        return context.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("android.support.AppLaunchChecker", 0);
        if (sharedPreferences.getBoolean("startedFromLauncher", false) || (intent = activity.getIntent()) == null || !"android.intent.action.MAIN".equals(intent.getAction())) {
            return;
        }
        if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory("android.intent.category.LEANBACK_LAUNCHER")) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(sharedPreferences.edit().putBoolean("startedFromLauncher", true));
        }
    }
}

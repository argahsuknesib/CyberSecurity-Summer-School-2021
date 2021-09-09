package com.miui.tsmclient.framework;

import android.content.Context;
import android.provider.MiuiSettings;

public class SettingUtils {
    public static boolean isOpenNavigation(Context context) {
        return MiuiSettings.Global.getBoolean(context.getContentResolver(), "force_fsg_nav_bar");
    }
}

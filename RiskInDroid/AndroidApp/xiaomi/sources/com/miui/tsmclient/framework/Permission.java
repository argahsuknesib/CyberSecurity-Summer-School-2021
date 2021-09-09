package com.miui.tsmclient.framework;

import android.content.pm.PackageManager;
import android.os.UserHandle;

public class Permission {
    public static void grantRuntime(PackageManager packageManager, String str, String str2) {
        packageManager.grantRuntimePermission(str, str2, new UserHandle(UserHandle.myUserId()));
    }
}

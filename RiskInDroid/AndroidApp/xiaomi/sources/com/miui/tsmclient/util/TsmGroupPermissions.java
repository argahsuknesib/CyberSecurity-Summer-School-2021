package com.miui.tsmclient.util;

import android.content.Context;

public class TsmGroupPermissions {
    public static void enforcePermissions(Context context) {
        context.enforceCallingOrSelfPermission("com.miui.tsmclient.permission.TSM_GROUP", "TSM_GROUP permission required");
    }
}

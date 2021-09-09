package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

public final class ipp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f1538O000000o = Build.MANUFACTURER.toLowerCase();
    public ipz O00000Oo;

    public ipp(ipz ipz) {
        this.O00000Oo = ipz;
    }

    public static Intent O000000o(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    public static Intent O00000Oo(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
        return intent;
    }

    public static Intent O00000o0(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setPackage("com.miui.securitycenter");
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        return intent;
    }

    public static Intent O00000o(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        return intent;
    }

    public static Intent O00000oO(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra("packagename", context.getPackageName());
        if (O000000o(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    public static Intent O00000oo(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static boolean O000000o(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}

package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

public final class ekh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15570O000000o = Build.MANUFACTURER.toLowerCase();

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1 A[SYNTHETIC, Splitter:B:31:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public static void O000000o(Activity activity) {
        Intent intent;
        if (f15570O000000o.contains("xiaomi")) {
            String O000000o2 = O000000o();
            if (O000000o2 != null && !O000000o2.contains("_global")) {
                intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                if (intent != null) {
                    try {
                        activity.startActivityForResult(intent, 2000);
                    } catch (ActivityNotFoundException | SecurityException unused) {
                        intent = null;
                    }
                }
                if (intent != null) {
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivityForResult(intent2, 2000);
                    return;
                }
                return;
            }
        } else if (f15570O000000o.contains("huawei")) {
            if (Build.VERSION.SDK_INT < 23) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
                if (intent != null) {
                }
                if (intent != null) {
                }
            }
        } else if (!f15570O000000o.contains("oppo")) {
            if (f15570O000000o.contains("vivo")) {
                intent = new Intent();
                intent.putExtra("packagename", activity.getPackageName());
                if (Build.VERSION.SDK_INT >= 25) {
                    intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
            } else if (!f15570O000000o.contains("samsung")) {
                if (!f15570O000000o.contains("meizu")) {
                    f15570O000000o.contains("smartisan");
                } else if (Build.VERSION.SDK_INT < 25) {
                    intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent.putExtra("packageName", activity.getPackageName());
                    intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                }
            }
            if (intent != null) {
            }
            if (intent != null) {
            }
        }
        intent = null;
        if (intent != null) {
        }
        if (intent != null) {
        }
    }

    @SuppressLint({"PrivateApi"})
    private static String O000000o() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.product.mod_device");
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}

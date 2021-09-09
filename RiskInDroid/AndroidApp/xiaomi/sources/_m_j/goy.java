package _m_j;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.accessibility.AccessibilityManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import miui.os.SystemProperties;

public abstract class goy {
    public static Bitmap O000000o(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            while ((i2 * i2) + (i3 * i3) > 2250000) {
                i++;
                i2 = options.outWidth / i;
                i3 = options.outHeight / i;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
            return null;
        }
    }

    public static float O000000o(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static boolean O000000o(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (Build.VERSION.SDK_INT < 21) {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.startsWith(packageName) && (next.importance == 100 || next.importance == 200)) {
                    gsy.O000000o(6, "CommonUtils", "Process:" + next.processName);
                    return true;
                }
            }
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.size() == 0 || activityManager.getRunningTasks(1).get(0) == null || runningAppProcesses2 == null)) {
            for (ActivityManager.RunningAppProcessInfo next2 : runningAppProcesses2) {
                if (next2.processName.equals("com.xiaomi.smarthome")) {
                    try {
                        if (((Integer) ActivityManager.RunningAppProcessInfo.class.getField("processState").get(next2)).intValue() == 6) {
                            return true;
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public static boolean O000000o(Activity activity) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
        return (runningTasks != null ? runningTasks.get(0).topActivity.getClassName() : "").equals(activity.getClass().getName());
    }

    public static boolean O000000o() {
        if (!grr.O00000oO()) {
            return false;
        }
        try {
            return SystemProperties.get("ro.product.mod_device", "").contains("_global");
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean O00000Oo() {
        if (!grr.O00000oO()) {
            return false;
        }
        try {
            String str = SystemProperties.get("ro.miui.ui.version.name", "");
            if (str.isEmpty() || str.length() < 2 || Integer.valueOf(str.substring(1)).intValue() < 10) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String O00000o0() {
        try {
            return SystemProperties.get("ro.miui.region", "CN");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean O00000o() {
        try {
            if (CommonApplication.getAppContext().getPackageManager().getPackageInfo("com.xiaomi.mihomemanager", 0) != null) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static int O00000oO() {
        if (grr.O00000oO()) {
            try {
                return Settings.Secure.getInt(CommonApplication.getAppContext().getContentResolver(), "upload_log_pref", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|(1:10)|(1:12)(1:16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r2 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        return "com.google.market";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (((java.lang.String) r5.getPackageInfo("com.google.market", 1).applicationInfo.loadLabel(r5)) != null) goto L_0x002a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
    public static String O00000Oo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        if (((String) packageManager.getPackageInfo("com.android.vending", 1).applicationInfo.loadLabel(packageManager)) != null) {
            z = true;
        }
        if (z) {
            return "com.android.vending";
        }
        return "";
    }

    public static boolean O000000o(List<? extends Object> list, List<? extends Object> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            for (int i = 0; i < list2.size(); i++) {
                Object obj = list2.get(i);
                if (obj != null && list.contains(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean O00000o0(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        try {
            boolean isEnabled = ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
            Intent intent = new Intent("android.accessibilityservice.AccessibilityService");
            intent.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null) {
                if (queryIntentServices.size() > 0) {
                    if (Build.VERSION.SDK_INT <= 15) {
                        ContentResolver contentResolver = context.getContentResolver();
                        Iterator<ResolveInfo> it = queryIntentServices.iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Cursor query = contentResolver.query(Uri.parse("content://" + it.next().serviceInfo.packageName + ".providers.StatusProvider"), null, null, null, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    i = query.getInt(0);
                                }
                                query.close();
                                if (i == 1) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 26) {
                        boolean z2 = false;
                        for (ResolveInfo next : queryIntentServices) {
                            z2 |= O000000o(context, next.serviceInfo.packageName + "/" + next.serviceInfo.name);
                        }
                        z = z2;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
                            arrayList.add(runningServiceInfo.service.getPackageName());
                        }
                        z = false;
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (arrayList.contains(resolveInfo.serviceInfo.packageName)) {
                                z |= true;
                            }
                        }
                    }
                    if (isEnabled || !z) {
                        return false;
                    }
                    return true;
                }
            }
            z = false;
            if (isEnabled) {
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean O000000o(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}

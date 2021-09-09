package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;

public final class dbo {
    public static String O000000o(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("WEIBO_APPKEY");
            if (obj != null) {
                dbt.O00000Oo("WBAgent", "APPKEY: " + String.valueOf(obj));
                return String.valueOf(obj);
            }
            dbt.O00000o0("WBAgent", "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Exception e) {
            dbt.O00000o0("WBAgent", "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.".concat(String.valueOf(e)));
            return null;
        }
    }

    public static String O00000Oo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("WEIBO_CHANNEL");
            if (string != null) {
                dbt.O00000Oo("WBAgent", "CHANNEL: " + string.trim());
                return string.trim();
            }
            dbt.O00000o0("WBAgent", "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (Exception e) {
            dbt.O00000o0("WBAgent", "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.".concat(String.valueOf(e)));
            return null;
        }
    }

    public static String O00000o0(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            dbt.O00000Oo("WBAgent", "versionName: " + packageInfo.versionName);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            dbt.O00000o0("WBAgent", "Could not read versionName from AndroidManifest.xml.".concat(String.valueOf(e)));
            return null;
        }
    }
}

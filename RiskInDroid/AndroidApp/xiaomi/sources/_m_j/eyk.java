package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class eyk {
    private static Set<String> O000000o(Context context) {
        HashSet hashSet = new HashSet();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            hashSet.add(queryIntentActivities.get(i).activityInfo.packageName);
        }
        return hashSet;
    }

    public static boolean O000000o(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(524288);
            intent.setData(Uri.parse(str));
            Set<String> O000000o2 = O000000o(context);
            if (O000000o2.contains("com.android.browser")) {
                intent.setPackage("com.android.browser");
                intent.addFlags(268435456);
                intent.putExtra("com.android.browser.application_id", "com.android.browser");
            } else if (O000000o2.contains("com.android.chrome")) {
                intent.setPackage("com.android.chrome");
                intent.addFlags(268435456);
                intent.putExtra("com.android.browser.application_id", "com.android.chrome");
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            gsy.O000000o(6, "OpenExternalBrowserComp", "open: " + Log.getStackTraceString(e));
            return false;
        }
    }
}

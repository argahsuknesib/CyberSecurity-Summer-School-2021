package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

final class on {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f2357O000000o = 0;
    private static String O00000Oo = "";
    private static String O00000o0 = "";

    public static String O000000o(Context context) {
        if (TextUtils.isEmpty(O00000o0)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                O00000Oo = packageInfo.versionName;
                f2357O000000o = packageInfo.versionCode;
            } catch (Exception e) {
                Log.e("VersionInfo", "Exception", e);
            }
            StringBuilder sb = new StringBuilder();
            if (f2357O000000o != 0) {
                sb.append("versionCode:" + f2357O000000o + "\n");
            }
            if (!TextUtils.isEmpty(O00000Oo)) {
                sb.append("versionName:" + O00000Oo + "\n");
            }
            sb.append("pid:" + Process.myPid() + "\n");
            sb.append("uid:" + Process.myUid() + "\n");
            sb.append("processName:" + ok.O00000oO() + "\n");
            sb.append("packageName:" + context.getPackageName() + "\n");
            sb.append("-----------------------------\n");
            O00000o0 = sb.toString();
        }
        return O00000o0;
    }
}

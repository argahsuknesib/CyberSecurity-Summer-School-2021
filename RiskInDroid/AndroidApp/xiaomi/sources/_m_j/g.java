package _m_j;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;

public final class g {
    public static int O000000o(Context context, String str, int i, int i2, String str2) {
        String str3;
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            str3 = AppOpsManager.permissionToOp(str);
        } else {
            str3 = null;
        }
        if (str3 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if ((Build.VERSION.SDK_INT >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str3, str2) : 1) != 0) {
            return -2;
        }
        return 0;
    }

    public static int O000000o(Context context, String str) {
        return O000000o(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int O00000Oo(Context context, String str) {
        return O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}

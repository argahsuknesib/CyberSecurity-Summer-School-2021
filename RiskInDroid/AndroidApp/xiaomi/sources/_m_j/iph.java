package _m_j;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class iph implements ipa {
    public final boolean O000000o(Context context, String... strArr) {
        List<String> asList = Arrays.asList(strArr);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        AppOpsManager appOpsManager = null;
        for (String str : asList) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                if (appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName()) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

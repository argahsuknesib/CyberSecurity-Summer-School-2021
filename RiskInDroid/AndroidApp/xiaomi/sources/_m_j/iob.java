package _m_j;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class iob implements inu {
    public final boolean O000000o(Context context, String... strArr) {
        List<String> asList = Arrays.asList(strArr);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : asList) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp) && ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(permissionToOp, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }
}

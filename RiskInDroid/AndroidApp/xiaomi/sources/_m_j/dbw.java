package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;

public final class dbw {
    public static boolean O000000o(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature byteArray : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(dbu.O000000o(byteArray.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

package com.xiaomi.mi_connect_service.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PackageUtil {
    public static int getPidByPackage(Context context, String str) {
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (str.equals(next.processName)) {
                return next.pid;
            }
        }
        return -1;
    }

    public static String getPackageByPid(Context context, int i) {
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == i) {
                return next.processName;
            }
        }
        return null;
    }

    public static int getUidByPackage(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String[] getPackagesByUid(Context context, int i) {
        return context.getPackageManager().getPackagesForUid(i);
    }

    public static String getUidSha1(Context context, int i) {
        String[] packagesByUid = getPackagesByUid(context, i);
        if (packagesByUid == null || packagesByUid.length <= 0) {
            return null;
        }
        return getPackageSha1(context, packagesByUid[0]);
    }

    public static String getPackageSha1(Context context, String str) {
        Signature[] signatureArr;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                signatureArr = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners();
            } else {
                signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] byteArray = signatureArr[0].toByteArray();
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            if (instance == null) {
                return null;
            }
            byte[] digest = instance.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e("PackkageUtil", "", e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            LogUtil.e("PackkageUtil", "", e2);
            return null;
        }
    }

    public static boolean checkPackageInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("PackkageUtil", e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static String getCallingPackage(Context context, int i, int i2) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length > 0) {
            return packagesForUid[0];
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == i2) {
                return next.processName;
            }
        }
        return null;
    }

    public static boolean checkAndroidPermission(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && context.getPackageManager().checkPermission(str2, str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkAllAndroidPermission(Context context, String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        if (strArr != null && strArr.length > 0) {
            for (String checkPermission : strArr) {
                if (packageManager.checkPermission(checkPermission, str) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean checkAnyAndroidPermission(Context context, String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        if (strArr != null && strArr.length > 0) {
            for (String checkPermission : strArr) {
                if (packageManager.checkPermission(checkPermission, str) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final String getForegroundApp(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        return (runningTasks == null || runningTasks.size() == 0) ? "" : activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
    }
}

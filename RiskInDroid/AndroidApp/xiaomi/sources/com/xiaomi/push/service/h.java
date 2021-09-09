package com.xiaomi.push.service;

import _m_j.duv;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import java.util.List;

public class h {
    public static ComponentName a(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                return new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, NotificationCompat.FLAG_HIGH_PRIORITY);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            duv.O000000o("checkService ".concat(String.valueOf(e)));
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            return queryIntentServices != null && !queryIntentServices.isEmpty();
        } catch (Exception e) {
            duv.O000000o("checkService action: " + str2 + ", " + e);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z;
        boolean z2 = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT < 19) {
                return true;
            }
            List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(null, 0, 8);
            if (queryContentProviders == null || queryContentProviders.isEmpty()) {
                return false;
            }
            for (ProviderInfo next : queryContentProviders) {
                try {
                    if (next.enabled && next.exported && next.authority.equals(str)) {
                        z2 = true;
                    }
                } catch (Exception e) {
                    e = e;
                    z = z2;
                    duv.O000000o("checkProvider ".concat(String.valueOf(e)));
                    return z;
                }
            }
            return z2;
        } catch (Exception e2) {
            e = e2;
            z = false;
            duv.O000000o("checkProvider ".concat(String.valueOf(e)));
            return z;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            duv.O000000o("checkActivity action: " + str2 + ", " + e);
            return false;
        }
    }
}

package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzk;

@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzq = false;
    private static zzk zzr;
    private static zzk zzs;

    private final synchronized zzk zzd(Context context, String str) {
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (zzs == null) {
                zzs = new zzk(context, str);
            }
            return zzs;
        }
        if (zzr == null) {
            zzr = new zzk(context, str);
        }
        return zzr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A[Catch:{ SecurityException -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3 A[Catch:{ SecurityException -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce A[Catch:{ SecurityException -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df A[Catch:{ SecurityException -> 0x00ea }] */
    private final void zzd(Context context, Intent intent) {
        ComponentName componentName;
        String str;
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            str = "Failed to resolve target intent service, skipping classname enforcement";
        } else {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String str2 = serviceInfo.packageName;
                String str3 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str2);
                sb.append("/");
                sb.append(str3);
                str = sb.toString();
            } else {
                String str4 = serviceInfo.name;
                if (str4.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(str4);
                    str4 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                if (Log.isLoggable("GcmReceiver", 3)) {
                    String valueOf3 = String.valueOf(str4);
                    Log.d("GcmReceiver", valueOf3.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf3) : new String("Restricting intent to a specific service: "));
                }
                intent.setClassName(context.getPackageName(), str4);
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    componentName = startWakefulService(context, intent);
                } else {
                    componentName = context.startService(intent);
                    Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
                }
                if (componentName != null) {
                    Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                    if (isOrderedBroadcast()) {
                        setResultCode(404);
                        return;
                    }
                    return;
                } else if (isOrderedBroadcast()) {
                    setResultCode(-1);
                    return;
                } else {
                    return;
                }
            }
        }
        Log.e("GcmReceiver", str);
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0) {
            }
            if (componentName != null) {
            }
        } catch (SecurityException e) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        if (z) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            zzd(context, intent.getAction()).zzd(intent, goAsync());
            return;
        }
        "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        zzd(context, intent);
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
    }
}

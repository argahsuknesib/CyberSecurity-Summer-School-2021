package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zze implements zzf {
    private zze() {
    }

    private static Bundle zzd(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
                return null;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
            return null;
        }
    }

    public final List<String> zzc(Context context) {
        Bundle zzd = zzd(context);
        if (zzd == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String next : zzd.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(zzd.get(next)) && next.startsWith("com.google.firebase.components:")) {
                arrayList.add(next.substring(31));
            }
        }
        return arrayList;
    }
}

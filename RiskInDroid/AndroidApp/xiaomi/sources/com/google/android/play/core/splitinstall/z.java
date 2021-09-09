package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.play.core.internal.aa;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3841a = new aa("SplitInstallInfoProvider");
    private final Context b;
    private final String c;

    public z(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    public static boolean a(String str) {
        return str.startsWith("config.");
    }

    public static boolean b(String str) {
        return a(str) || str.contains(".config.");
    }

    private final Set<String> d() {
        HashSet hashSet = new HashSet();
        Bundle e = e();
        if (e != null) {
            String string = e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f3841a.a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f3841a.d("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f3841a.a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f3841a.a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            x a2 = y.a();
            if (a2 != null) {
                hashSet.addAll(a2.a());
            }
        }
        return hashSet;
    }

    private final Bundle e() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.c, NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f3841a.a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f3841a.d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        for (String next : d()) {
            if (!b(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final Set<String> b() {
        f c2 = c();
        if (c2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = d();
        d.add("");
        Set<String> a2 = a();
        a2.add("");
        for (Map.Entry next : c2.a(a2).entrySet()) {
            if (d.containsAll((Collection) next.getValue())) {
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    public final f c() {
        Bundle e = e();
        if (e == null) {
            f3841a.d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = e.getInt("com.android.vending.splits");
        if (i == 0) {
            f3841a.d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            f a2 = new bb(this.b.getResources().getXml(i)).a();
            if (a2 == null) {
                f3841a.d("Can't parse languages metadata.", new Object[0]);
            }
            return a2;
        } catch (Resources.NotFoundException unused) {
            f3841a.d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}

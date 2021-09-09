package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.google.android.play.core.internal.aa;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

final class b implements MissingSplitsManager {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3774a = new aa("MissingSplitsManagerImpl");
    private final Context b;
    private final Runtime c;
    private final a d;
    private final AtomicReference<Boolean> e;

    b(Context context, Runtime runtime, a aVar, AtomicReference<Boolean> atomicReference) {
        this.b = context;
        this.c = runtime;
        this.d = aVar;
        this.e = atomicReference;
    }

    @TargetApi(21)
    private final boolean a() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            return (applicationInfo == null || applicationInfo.metaData == null || !Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required"))) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            f3774a.d("App '%s' is not found in the PackageManager", this.b.getPackageName());
            return false;
        }
    }

    private static boolean a(Set<String> set) {
        if (!set.isEmpty()) {
            return set.size() == 1 && set.contains("");
        }
        return true;
    }

    private final Set<String> b() {
        if (Build.VERSION.SDK_INT < 21) {
            return Collections.emptySet();
        }
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo == null || packageInfo.splitNames == null) {
                return hashSet;
            }
            Collections.addAll(hashSet, packageInfo.splitNames);
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            f3774a.d("App '%s' is not found in PackageManager", this.b.getPackageName());
            return Collections.emptySet();
        }
    }

    @TargetApi(21)
    private final List<ActivityManager.AppTask> c() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.b.getSystemService("activity")).getAppTasks();
        return appTasks == null ? Collections.emptyList() : appTasks;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.google.android.play.core.missingsplits.b.f3774a.d("App '%s' is not found in PackageManager", r8.b.getPackageName());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085 A[Catch:{ NameNotFoundException -> 0x0096 }] */
    public final boolean disableAppIfMissingRequiredSplits() {
        boolean booleanValue;
        boolean z;
        boolean z2;
        Set set;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        synchronized (this.e) {
            if (this.e.get() == null) {
                AtomicReference<Boolean> atomicReference = this.e;
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
                        if (!(applicationInfo == null || applicationInfo.metaData == null || !Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required")))) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
                                set = new HashSet();
                                if (!(packageInfo == null || packageInfo.splitNames == null)) {
                                    Collections.addAll(set, packageInfo.splitNames);
                                }
                                if (!set.isEmpty()) {
                                    if (set.size() == 1) {
                                        if (!set.contains("")) {
                                        }
                                    }
                                }
                                z2 = true;
                                atomicReference.set(Boolean.valueOf(z2));
                            }
                            set = Collections.emptySet();
                            if (!set.isEmpty()) {
                            }
                            z2 = true;
                            atomicReference.set(Boolean.valueOf(z2));
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        f3774a.d("App '%s' is not found in the PackageManager", this.b.getPackageName());
                    }
                }
                z2 = false;
                atomicReference.set(Boolean.valueOf(z2));
            }
            booleanValue = this.e.get().booleanValue();
        }
        if (booleanValue) {
            Iterator<ActivityManager.AppTask> it = c().iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.AppTask next = it.next();
                    if (!(next.getTaskInfo() == null || next.getTaskInfo().baseIntent == null || next.getTaskInfo().baseIntent.getComponent() == null)) {
                        if (PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName())) {
                            break;
                        }
                    }
                } else {
                    Iterator<ActivityManager.AppTask> it2 = c().iterator();
                    loop1:
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        ActivityManager.RecentTaskInfo taskInfo = it2.next().getTaskInfo();
                        if (!(taskInfo == null || taskInfo.baseIntent == null || taskInfo.baseIntent.getComponent() == null)) {
                            ComponentName component = taskInfo.baseIntent.getComponent();
                            String className = component.getClassName();
                            try {
                                Class<?> cls = Class.forName(className);
                                while (cls != null) {
                                    if (cls.equals(Activity.class)) {
                                        break loop1;
                                    }
                                    Class<? super Object> superclass = cls.getSuperclass();
                                    cls = superclass != cls ? superclass : null;
                                }
                                continue;
                            } catch (ClassNotFoundException unused2) {
                                f3774a.d("ClassNotFoundException when scanning class hierarchy of '%s'", className);
                                try {
                                    if (this.b.getPackageManager().getActivityInfo(component, 0) != null) {
                                        break;
                                    }
                                } catch (PackageManager.NameNotFoundException unused3) {
                                    continue;
                                }
                            }
                        }
                    }
                    z = true;
                    this.d.b();
                    for (ActivityManager.AppTask finishAndRemoveTask : c()) {
                        finishAndRemoveTask.finishAndRemoveTask();
                    }
                    if (z) {
                        this.b.getPackageManager().setComponentEnabledSetting(new ComponentName(this.b, PlayCoreMissingSplitsActivity.class), 1, 1);
                        this.b.startActivity(new Intent(this.b, PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                    }
                    this.c.exit(0);
                }
            }
            return true;
        }
        if (this.d.a()) {
            this.d.c();
            this.c.exit(0);
        }
        return false;
    }

    public final boolean isMissingRequiredSplits() {
        boolean booleanValue;
        synchronized (this.e) {
            if (this.e.get() == null) {
                AtomicReference<Boolean> atomicReference = this.e;
                boolean z = false;
                if (Build.VERSION.SDK_INT >= 21 && a()) {
                    if (a(b())) {
                        z = true;
                    }
                }
                atomicReference.set(Boolean.valueOf(z));
            }
            booleanValue = this.e.get().booleanValue();
        }
        return booleanValue;
    }
}

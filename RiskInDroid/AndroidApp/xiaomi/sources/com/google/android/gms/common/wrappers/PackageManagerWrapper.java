package com.google.android.gms.common.wrappers;

import _m_j.be;
import _m_j.g;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;

public class PackageManagerWrapper {
    private final Context zzjp;

    public PackageManagerWrapper(Context context) {
        this.zzjp = context;
    }

    public boolean allowApiAccess(String str, int i) {
        return true;
    }

    public void checkCallerIsNotInstantApp() {
        if (isCallerInstantApp()) {
            throw new SecurityException("This operation is not supported for instant apps.");
        }
    }

    public int checkCallingOrSelfPermission(String str) {
        return this.zzjp.checkCallingOrSelfPermission(str);
    }

    public int checkCallingOrSelfPermissionAndAppOps(String str) {
        return g.O00000Oo(this.zzjp, str);
    }

    public int checkCallingPermission(String str) {
        return this.zzjp.checkCallingPermission(str);
    }

    @Deprecated
    public int checkCallingPermission(String str, String str2) {
        return checkPermission(str, str2);
    }

    public void checkPackage(int i, String str) {
        if (!uidHasPackageName(i, str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Package ");
            sb.append(str);
            sb.append(" does not belong to ");
            sb.append(i);
            throw new SecurityException(sb.toString());
        }
    }

    public int checkPermission(String str, int i, int i2) {
        return this.zzjp.checkPermission(str, i, i2);
    }

    @Deprecated
    public int checkPermission(String str, int i, int i2, String str2) {
        return checkPermission(str, i, i2);
    }

    public int checkPermission(String str, String str2) {
        return this.zzjp.getPackageManager().checkPermission(str, str2);
    }

    public int checkPermissionAndAppOps(String str, int i, int i2, String str2) {
        return g.O000000o(this.zzjp, str, i, i2, str2);
    }

    public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.zzjp.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        return this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(str, 0));
    }

    public be<CharSequence, Drawable> getApplicationLabelAndIcon(String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, 0);
        return be.O000000o(this.zzjp.getPackageManager().getApplicationLabel(applicationInfo), this.zzjp.getPackageManager().getApplicationIcon(applicationInfo));
    }

    public ComponentName getCallingActivity(Activity activity) {
        return activity.getCallingActivity();
    }

    public String getCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return null;
        }
        String packageName = callingActivity.getPackageName();
        if (packageName != null) {
            return packageName;
        }
        String valueOf = String.valueOf(callingActivity);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 54);
        sb.append("getCallingPackage(): Couldn't get a package name from ");
        sb.append(valueOf);
        Log.e("PackageManagerWrapper", sb.toString());
        return null;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.zzjp;
    }

    public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.zzjp.getPackageManager().getPackageInfo(str, i);
    }

    public String[] getPackagesForUid(int i) {
        return this.zzjp.getPackageManager().getPackagesForUid(i);
    }

    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zzjp);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.zzjp.getPackageManager().isInstantApp(nameForUid);
    }

    public boolean isInstantAppUid(int i) {
        return false;
    }

    @TargetApi(19)
    public boolean uidHasPackageName(int i, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.zzjp.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public int checkCallingPermissionAndAppOps(String str, String str2) {
        Context context = this.zzjp;
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return g.O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }
}

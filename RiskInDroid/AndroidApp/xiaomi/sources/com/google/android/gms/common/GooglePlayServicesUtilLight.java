package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.GmsVersionParser;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.xiaomi.smarthome.R;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @VisibleForTesting
    public static boolean sIsTestMode = false;
    @VisibleForTesting
    public static boolean sTestIsUserBuild = false;
    private static boolean zzbr = false;
    @VisibleForTesting
    private static boolean zzbs = false;
    @VisibleForTesting
    static final AtomicBoolean zzbt = new AtomicBoolean();
    private static final AtomicBoolean zzbu = new AtomicBoolean();

    GooglePlayServicesUtilLight() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        if (!zzbt.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void enableUsingApkIndependentContext() {
        zzbu.set(true);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        ensurePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i) {
        return ConnectionResult.zza(i);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i, null);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream != null) {
                openInputStream.close();
            }
            return next;
        } catch (NoSuchElementException unused) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception unused2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(Context context) {
        return isTestKeysBuild(context) || !isUserBuildDevice();
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i) {
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzbu.get()) {
            int googlePlayServicesVersion = MetadataValueReader.getGooglePlayServicesVersion(context);
            if (googlePlayServicesVersion != 0) {
                int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                if (googlePlayServicesVersion != i2) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i2);
                    sb.append(" but found ");
                    sb.append(googlePlayServicesVersion);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return zza(context, !DeviceProperties.isWearableWithoutPlayStore(context) && !DeviceProperties.isIoT(context), i);
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        return UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return isUninstalledAppPossiblyUpdating(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        if (i == 9) {
            return isUninstalledAppPossiblyUpdating(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(Context context) {
        Bundle applicationRestrictions;
        return PlatformVersion.isAtLeastJellyBeanMR2() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    @VisibleForTesting
    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean
     arg types: [android.content.pm.PackageInfo, int]
     candidates:
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageManager, android.content.pm.PackageInfo):boolean
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean */
    public static boolean isTestKeysBuild(Context context) {
        if (!zzbs) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || instance.isGooglePublicSignedPackage(packageInfo, false) || !instance.isGooglePublicSignedPackage(packageInfo, true)) {
                    zzbr = false;
                } else {
                    zzbr = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } catch (Throwable th) {
                zzbs = true;
                throw th;
            }
            zzbs = true;
        }
        return zzbr;
    }

    @TargetApi(21)
    static boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            return equals ? applicationInfo.enabled : applicationInfo.enabled && !isRestrictedUserProfile(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    @Deprecated
    public static boolean isUserBuildDevice() {
        return DeviceProperties.isUserBuild();
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return UidVerifier.uidHasPackageName(context, i, str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean
     arg types: [android.content.pm.PackageInfo, int]
     candidates:
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageManager, android.content.pm.PackageInfo):boolean
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean */
    @VisibleForTesting
    private static int zza(Context context, boolean z, int i) {
        String str;
        Preconditions.checkArgument(i >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                str = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
            if (!instance.isGooglePublicSignedPackage(packageInfo2, true)) {
                str = "Google Play services signature invalid.";
            } else if (z && (!instance.isGooglePublicSignedPackage(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                str = "Google Play Store signature invalid.";
            } else if (GmsVersionParser.parseBuildVersion(packageInfo2.versionCode) < GmsVersionParser.parseBuildVersion(i)) {
                int i2 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i);
                sb.append(" but found ");
                sb.append(i2);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
            Log.w("GooglePlayServicesUtil", str);
            return 9;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }
}

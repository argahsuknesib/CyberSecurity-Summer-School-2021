package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.List;

public final class Validate {
    private static final String TAG = "com.facebook.internal.Validate";

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    public static <T> void notEmpty(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        notNull(collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static void containsNoNullOrEmpty(Collection<String> collection, String str) {
        notNull(collection, str);
        for (String next : collection) {
            if (next == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            } else if (next.length() == 0) {
                throw new IllegalArgumentException("Container '" + str + "' cannot contain empty values");
            }
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    public static void runningOnUiThread() {
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static void notNullOrEmpty(String str, String str2) {
        if (Utility.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
        }
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    return;
                }
            } else if (obj == null) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }

    public static void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    public static String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    public static void hasInternetPermissions(Context context) {
        hasInternetPermissions(context, true);
    }

    public static void hasInternetPermissions(Context context, boolean z) {
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (!z) {
            Log.w(TAG, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
            return;
        }
        throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }

    public static boolean hasWiFiPermission(Context context) {
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public static boolean hasChangeWifiStatePermission(Context context) {
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    public static boolean hasLocationPermission(Context context) {
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean hasBluetoothPermission(Context context) {
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void hasFacebookActivity(Context context) {
        hasFacebookActivity(context, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    public static void hasFacebookActivity(Context context, boolean z) {
        ActivityInfo activityInfo;
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (activityInfo == null) {
                return;
            }
            if (!z) {
                Log.w(TAG, "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
                return;
            }
            throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
        activityInfo = null;
        if (activityInfo == null) {
        }
    }

    public static void checkCustomTabRedirectActivity(Context context) {
        checkCustomTabRedirectActivity(context, true);
    }

    public static void checkCustomTabRedirectActivity(Context context, boolean z) {
        if (hasCustomTabRedirectActivity(context)) {
            return;
        }
        if (!z) {
            Log.w(TAG, "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
            return;
        }
        throw new IllegalStateException("FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }

    public static boolean hasCustomTabRedirectActivity(Context context) {
        List<ResolveInfo> list;
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        boolean z = false;
        for (ResolveInfo resolveInfo : list) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static void hasContentProvider(Context context) {
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String concat = "com.facebook.app.FacebookContentProvider".concat(String.valueOf(hasAppID));
            if (packageManager.resolveContentProvider(concat, 0) == null) {
                throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", concat));
            }
        }
    }
}

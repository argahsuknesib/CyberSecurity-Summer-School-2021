package com.mibi.sdk.common;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Utils {
    private static int sPendingIntentIndex = 1;

    public static class ValueDivided {
        public String mFractionalPart;
        public String mIntegerPart;
    }

    private Utils() {
    }

    public static String joinUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str + "/" + str2;
    }

    public static synchronized int getPendingIntentIndex() {
        int i;
        synchronized (Utils.class) {
            i = sPendingIntentIndex;
            sPendingIntentIndex = i + 1;
        }
        return i;
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    public static boolean isNetworkMetered(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.isActiveNetworkMetered();
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    public static String getSimplePrice(long j) {
        if (j % 100 == 0) {
            return String.format(Locale.US, "%d", Long.valueOf(j / 100));
        } else if (j % 10 == 0) {
            Locale locale = Locale.US;
            double d = (double) j;
            Double.isNaN(d);
            return String.format(locale, "%.1f", Double.valueOf(d / 100.0d));
        } else {
            Locale locale2 = Locale.US;
            double d2 = (double) j;
            Double.isNaN(d2);
            return String.format(locale2, "%.2f", Double.valueOf(d2 / 100.0d));
        }
    }

    public static String getFullPrice(long j) {
        Locale locale = Locale.US;
        double d = (double) j;
        Double.isNaN(d);
        return String.format(locale, "%.2f", Double.valueOf(d / 100.0d));
    }

    public static void showSoftInputMethod(Context context, View view, boolean z) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getApplicationContext().getSystemService("input_method");
            if (z) {
                inputMethodManager.showSoftInput(view, 1);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static ValueDivided getPriceIntegerAndFractionalPart(long j) {
        ValueDivided valueDivided = new ValueDivided();
        String simplePrice = getSimplePrice(j);
        int indexOf = simplePrice.indexOf(".");
        if (indexOf == -1) {
            valueDivided.mIntegerPart = simplePrice;
            valueDivided.mFractionalPart = "";
        } else {
            valueDivided.mIntegerPart = simplePrice.substring(0, indexOf);
            valueDivided.mFractionalPart = simplePrice.substring(indexOf + 1);
        }
        return valueDivided;
    }

    public static void collapseSoftInputMethod(Context context, View view) {
        if (view != null && context != null) {
            ((InputMethodManager) context.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean getBooleanPref(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static void setBooleanPref(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static String getStringPref(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static void setStringPref(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static long getLongPref(Context context, String str, long j) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static void setLongPref(Context context, String str, long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void removeAllPrefData(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.clear();
        edit.apply();
    }

    public static long[] LongArrayListTolongArray(List<Long> list) {
        long[] jArr = new long[list.size()];
        int i = 0;
        for (Long longValue : list) {
            jArr[i] = longValue.longValue();
            i++;
        }
        return jArr;
    }

    public static long[] LongSetTolongArray(Set<Long> set) {
        long[] jArr = new long[set.size()];
        int i = 0;
        for (Long longValue : set) {
            jArr[i] = longValue.longValue();
            i++;
        }
        return jArr;
    }

    public static boolean hasCamera(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        if (r5 != null) goto L_0x002b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0047 A[SYNTHETIC, Splitter:B:30:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0053 A[SYNTHETIC, Splitter:B:39:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0058 A[Catch:{ IOException -> 0x005b }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static boolean retrieveFileFromAssets(Context context, String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        ? r0 = 0;
        boolean z = false;
        try {
            inputStream = context.getAssets().open(str);
            try {
                File file = new File(str2);
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
                r0 = inputStream;
                try {
                    Log.e("Utils", "Utils retrieveFileFromAssets IOException ", e);
                    if (r0 != 0) {
                        r0.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = r0;
                    r0 = fileOutputStream;
                    if (inputStream != null) {
                    }
                    if (r0 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        throw th;
                    }
                }
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                z = true;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException e2) {
                e = e2;
                r0 = inputStream;
                Log.e("Utils", "Utils retrieveFileFromAssets IOException ", e);
                if (r0 != 0) {
                }
            } catch (Throwable th3) {
                th = th3;
                r0 = fileOutputStream;
                if (inputStream != null) {
                }
                if (r0 != 0) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            Log.e("Utils", "Utils retrieveFileFromAssets IOException ", e);
            if (r0 != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            if (inputStream != null) {
            }
            if (r0 != 0) {
            }
            throw th;
        }
        fileOutputStream.close();
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[SYNTHETIC, Splitter:B:26:0x003b] */
    public static String retrieveStringFromAssets(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                }
                scanner.close();
                String sb2 = sb.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return sb2;
            } catch (IOException unused2) {
                if (inputStream != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static boolean checkStrings(String... strArr) {
        for (String isEmpty : strArr) {
            if (TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static String join(CharSequence charSequence, Object... objArr) {
        return TextUtils.join(charSequence, objArr);
    }

    public static boolean isAppExists(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception e) {
            Log.e("Utils", "Utils isAppExists Exception ", e);
            return false;
        }
    }

    public static boolean launchApp(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                try {
                    if (!(context instanceof Activity)) {
                        launchIntentForPackage.setFlags(268435456);
                    }
                    context.startActivity(launchIntentForPackage);
                    return true;
                } catch (Exception e) {
                    Log.e("Utils", "Utils launchApp Exception ", e);
                }
            }
            return false;
        } catch (Exception e2) {
            Log.e("Utils", "Utils launchApp getLaunchIntentForPackage exception ", e2);
            return false;
        }
    }

    public static void showNotification(Context context, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        showNotification(context, str, str2, pendingIntent, pendingIntent2, null, getPendingIntentIndex(), 0);
    }

    public static void showNotification(Context context, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str3, int i, int i2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon((int) R.drawable.mibi_ic_milicenter_status_bar).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.mibi_ic_milicenter)).setTicker(str).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setAutoCancel(true);
            if (i2 == 2) {
                autoCancel.setOngoing(true);
            } else if (i2 == 8) {
                autoCancel.setOnlyAlertOnce(true);
            } else if (i2 == 16) {
                autoCancel.setAutoCancel(true);
            }
            ((NotificationManager) context.getApplicationContext().getSystemService("notification")).notify(str3, i, autoCancel.build());
        }
    }

    public static void cancelNotification(Context context, String str) {
        ((NotificationManager) context.getApplicationContext().getSystemService("notification")).cancel(str, 0);
    }

    public static boolean isDialable(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!PhoneNumberUtils.isDialable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInMultiWindowMode(Context context) {
        try {
            return ((Boolean) Class.forName("android.app.Activity").getMethod("isInMultiWindowMode", new Class[0]).invoke(context, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void dial(Activity activity, String str) {
        activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(str)))));
    }

    public static void dialService(Activity activity) {
        dial(activity, "400-100-3399");
    }

    public static boolean isInnerIntent(Context context, Intent intent) {
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 0);
        if (resolveActivityInfo == null) {
            return false;
        }
        return TextUtils.equals(context.getPackageName(), resolveActivityInfo.packageName);
    }

    public static Intent parseIntentUri(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Intent.parseUri(str, 1);
            } catch (URISyntaxException e) {
                Log.e("Utils", "Utils parseIntentUri URISyntaxException ", e);
            }
        }
        return null;
    }

    public static boolean openIntentUri(Context context, String str) {
        if (context == null) {
            return false;
        }
        Intent parseIntentUri = parseIntentUri(str);
        if (!isIntentAvailable(context, parseIntentUri)) {
            return false;
        }
        context.startActivity(parseIntentUri);
        return true;
    }

    public static void ensureOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("current thread is not main");
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public static boolean isPad() {
        return MiuiBuild.isTablet();
    }
}

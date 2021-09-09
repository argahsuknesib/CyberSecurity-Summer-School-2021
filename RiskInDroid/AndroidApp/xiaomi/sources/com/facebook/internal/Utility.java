package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static long availableExternalStorageGB = -1;
    private static String carrierName = "NoCarrier";
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public interface Mapper<T, K> {
        K apply(T t);
    }

    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x000e A[SYNTHETIC] */
    public static int[] intersectRanges(int[] iArr, int[] iArr2) {
        int i;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null) {
            return iArr;
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= iArr.length || i3 >= iArr2.length) {
                break;
            }
            int i5 = iArr[i2];
            int i6 = iArr2[i3];
            int i7 = i2 < iArr.length + -1 ? iArr[i2 + 1] : Integer.MAX_VALUE;
            if (i3 < iArr2.length - 1) {
                i = iArr2[i3 + 1];
            } else {
                i = Integer.MAX_VALUE;
            }
            if (i5 < i6) {
                if (i7 <= i6) {
                    i2 += 2;
                    i5 = Integer.MIN_VALUE;
                    i7 = Integer.MAX_VALUE;
                } else if (i7 <= i) {
                    i2 += 2;
                    i5 = i6;
                } else {
                    i5 = i6;
                }
                if (i5 != Integer.MIN_VALUE) {
                    int i8 = i4 + 1;
                    iArr3[i4] = i5;
                    if (i7 == Integer.MAX_VALUE) {
                        i4 = i8;
                        break;
                    }
                    i4 = i8 + 1;
                    iArr3[i8] = i7;
                }
            } else if (i <= i5) {
                i5 = Integer.MIN_VALUE;
                i = Integer.MAX_VALUE;
            } else if (i > i7) {
                i2 += 2;
                if (i5 != Integer.MIN_VALUE) {
                }
            }
            i3 += 2;
            i7 = i;
            if (i5 != Integer.MIN_VALUE) {
            }
        }
        return Arrays.copyOf(iArr3, i4);
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        if (collection2 == null || collection2.size() == 0) {
            return collection == null || collection.size() == 0;
        }
        HashSet hashSet = new HashSet(collection2);
        for (T contains : collection) {
            if (!hashSet.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T add : tArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static String md5hash(String str) {
        return hashWithAlgorithm("MD5", str);
    }

    public static String sha1hash(String str) {
        return hashWithAlgorithm("SHA-1", str);
    }

    public static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm("SHA-1", bArr);
    }

    public static String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return hashWithAlgorithm("SHA-256", str);
    }

    public static String sha256hash(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return hashWithAlgorithm("SHA-256", bArr);
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        return sb.toString();
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    builder.appendQueryParameter(next, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    logd("FacebookSDK", e);
                }
            }
        }
        return bundle;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, obj.toString());
            return true;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        FacebookSdk.sdkInitialize(context);
        return FacebookSdk.getApplicationId();
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                hashMap.put(string, obj);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    public static Map<String, String> convertJSONObjectToStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static List<String> convertJSONArrayToList(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    public static int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
                bufferedInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return true;
        }
        if (isEmpty || isEmpty2) {
            return false;
        }
        return str.equals(str2);
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    instance.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            instance.removeExpiredCookie();
        }
    }

    public static void clearFacebookCookies(Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void logd(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
        }
    }

    public static void logd(String str, String str2) {
        if (FacebookSdk.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void logd(String str, String str2, Throwable th) {
        if (FacebookSdk.isDebugEnabled() && !isNullOrEmpty(str)) {
            Log.d(str, str2, th);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T> boolean areObjectsEqual(T r0, T r1) {
        /*
            if (r0 != 0) goto L_0x0008
            if (r1 != 0) goto L_0x0006
            r0 = 1
            return r0
        L_0x0006:
            r0 = 0
            return r0
        L_0x0008:
            boolean r0 = r0.equals(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.areObjectsEqual(java.lang.Object, java.lang.Object):boolean");
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.has("id") && jSONObject2.has("id")) {
            if (jSONObject.equals(jSONObject2)) {
                return true;
            }
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject2.optString("id");
            if (!(optString == null || optString2 == null)) {
                return optString.equals(optString2);
            }
        }
        return false;
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static void clearCaches(Context context) {
        ImageDownloader.clearCache(context);
    }

    public static void deleteDirectory(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File deleteDirectory : listFiles) {
                    deleteDirectory(deleteDirectory);
                }
            }
            file.delete();
        }
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static String mapToJsonStr(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static Map<String, String> JsonStrToMap(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (!allHashedUserData.isEmpty()) {
                    jSONObject.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    public static String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079 A[Catch:{ Exception -> 0x008d }] */
    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        int i;
        String str;
        Locale locale;
        int i2;
        WindowManager windowManager;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i3 = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i = packageInfo.versionCode;
            try {
                str = packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            i = -1;
            str = "";
            jSONArray.put(packageName);
            jSONArray.put(i);
            jSONArray.put(str);
            jSONArray.put(Build.VERSION.RELEASE);
            jSONArray.put(Build.MODEL);
            locale = context.getResources().getConfiguration().locale;
            jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
            jSONArray.put(deviceTimezoneAbbreviation);
            jSONArray.put(carrierName);
            double d = 0.0d;
            windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
            }
            i2 = 0;
            jSONArray.put(i2);
            jSONArray.put(i3);
            jSONArray.put(new DecimalFormat("#.##").format(d));
            jSONArray.put(refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put("extinfo", jSONArray.toString());
        }
        jSONArray.put(packageName);
        jSONArray.put(i);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused3) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d2 = 0.0d;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                try {
                    i3 = displayMetrics.heightPixels;
                    d2 = (double) displayMetrics.density;
                } catch (Exception unused4) {
                }
                jSONArray.put(i2);
                jSONArray.put(i3);
                jSONArray.put(new DecimalFormat("#.##").format(d2));
                jSONArray.put(refreshBestGuessNumberOfCPUCores());
                jSONArray.put(totalExternalStorageGB);
                jSONArray.put(availableExternalStorageGB);
                jSONArray.put(deviceTimeZoneName);
                jSONObject.put("extinfo", jSONArray.toString());
            }
        } catch (Exception unused5) {
        }
        i2 = 0;
        jSONArray.put(i2);
        jSONArray.put(i3);
        jSONArray.put(new DecimalFormat("#.##").format(d2));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (predicate.apply(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static <T, K> List<K> map(List<T> list, Mapper<T, K> mapper) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T apply : list) {
            K apply2 = mapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static boolean isWebUri(Uri uri) {
        if (uri != null) {
            return "http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme());
        }
        return false;
    }

    public static boolean isContentUri(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isFileUri(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static long getContentSize(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                j = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (j == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (j * 1000));
    }

    public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.getCurrentAccessToken());
    }

    public static void getGraphMeRequestWithCacheAsync(final String str, final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        AnonymousClass1 r0 = new GraphRequest.Callback() {
            /* class com.facebook.internal.Utility.AnonymousClass1 */

            public final void onCompleted(GraphResponse graphResponse) {
                if (graphResponse.getError() != null) {
                    graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
                    return;
                }
                ProfileInformationCache.putProfileInformation(str, graphResponse.getJSONObject());
                graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJSONObject());
            }
        };
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(r0);
        graphMeRequestWithCache.executeAsync();
    }

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJSONObject();
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() {
                /* class com.facebook.internal.Utility.AnonymousClass2 */

                public final boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private static void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private static void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            deviceTimezoneAbbreviation = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            deviceTimeZoneName = timeZone.getID();
        } catch (AssertionError | Exception unused) {
        }
    }

    private static void refreshCarrierName(Context context) {
        if (carrierName.equals("NoCarrier")) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean externalStorageExists() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private static void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private static long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    public static class PermissionsLists {
        List<String> declinedPermissions;
        List<String> expiredPermissions;
        List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }
    }

    public static PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
        String optString;
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString("permission");
            if (!(optString2 == null || optString2.equals("installed") || (optString = optJSONObject.optString("status")) == null)) {
                if (optString.equals("granted")) {
                    arrayList.add(optString2);
                } else if (optString.equals("declined")) {
                    arrayList2.add(optString2);
                } else if (optString.equals("expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new PermissionsLists(arrayList, arrayList2, arrayList3);
    }

    public static String generateRandomString(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    public static boolean mustFixWindowParamsForAutofill(Context context) {
        return isAutofillAvailable(context);
    }

    public static boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean isChromeOS(Context context) {
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        return Build.DEVICE != null && Build.DEVICE.matches(".+_cheets|cheets_.+");
    }

    public static Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        return Locale.getDefault();
    }

    public static void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static String getAppName(Context context) {
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return context.getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("fb%s://applinks", FacebookSdk.getApplicationId())));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}

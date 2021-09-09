package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserDataStore {
    public static final String TAG = "UserDataStore";
    public static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    public static AtomicBoolean initialized = new AtomicBoolean(false);
    public static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    public static SharedPreferences sharedPreferences;

    static void initStore() {
        if (!initialized.get()) {
            initAndWait();
        }
    }

    public static void writeDataIntoCache(final String str, final String str2) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.UserDataStore.AnonymousClass1 */

            public final void run() {
                if (!UserDataStore.initialized.get()) {
                    UserDataStore.initAndWait();
                }
                UserDataStore.sharedPreferences.edit().putString(str, str2).apply();
            }
        });
    }

    static void setUserDataAndHash(final Bundle bundle) {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.UserDataStore.AnonymousClass2 */

            public final void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.updateHashUserData(bundle);
                UserDataStore.writeDataIntoCache("com.facebook.appevents.UserDataStore.userData", Utility.mapToJsonStr(UserDataStore.externalHashedUserData));
                UserDataStore.writeDataIntoCache("com.facebook.appevents.UserDataStore.internalUserData", Utility.mapToJsonStr(UserDataStore.internalHashedUserData));
            }
        });
    }

    static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("em", str);
        }
        if (str2 != null) {
            bundle.putString("fn", str2);
        }
        if (str3 != null) {
            bundle.putString("ln", str3);
        }
        if (str4 != null) {
            bundle.putString("ph", str4);
        }
        if (str5 != null) {
            bundle.putString("db", str5);
        }
        if (str6 != null) {
            bundle.putString("ge", str6);
        }
        if (str7 != null) {
            bundle.putString("ct", str7);
        }
        if (str8 != null) {
            bundle.putString("st", str8);
        }
        if (str9 != null) {
            bundle.putString("zp", str9);
        }
        if (str10 != null) {
            bundle.putString("country", str10);
        }
        setUserDataAndHash(bundle);
    }

    static void clear() {
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.UserDataStore.AnonymousClass3 */

            public final void run() {
                if (!UserDataStore.initialized.get()) {
                    Log.w(UserDataStore.TAG, "initStore should have been called before calling setUserData");
                    UserDataStore.initAndWait();
                }
                UserDataStore.externalHashedUserData.clear();
                UserDataStore.sharedPreferences.edit().putString("com.facebook.appevents.UserDataStore.userData", null).apply();
            }
        });
    }

    public static void removeRules(List<String> list) {
        if (!initialized.get()) {
            initAndWait();
        }
        for (String next : list) {
            if (internalHashedUserData.containsKey(next)) {
                internalHashedUserData.remove(next);
            }
        }
        writeDataIntoCache("com.facebook.appevents.UserDataStore.internalUserData", Utility.mapToJsonStr(internalHashedUserData));
    }

    static String getHashedUserData() {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        return Utility.mapToJsonStr(externalHashedUserData);
    }

    public static String getAllHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(externalHashedUserData);
        hashMap.putAll(internalHashedUserData);
        return Utility.mapToJsonStr(hashMap);
    }

    public static synchronized void initAndWait() {
        synchronized (UserDataStore.class) {
            if (!initialized.get()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                sharedPreferences = defaultSharedPreferences;
                String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
                String string2 = sharedPreferences.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
                externalHashedUserData.putAll(Utility.JsonStrToMap(string));
                internalHashedUserData.putAll(Utility.JsonStrToMap(string2));
                initialized.set(true);
            }
        }
    }

    public static Map<String, String> getInternalHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        return new HashMap(internalHashedUserData);
    }

    public static void updateHashUserData(Bundle bundle) {
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        externalHashedUserData.put(next, obj2.toLowerCase());
                    } else {
                        String sha256hash = Utility.sha256hash(normalizeData(next, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(next, sha256hash);
                        }
                    }
                }
            }
        }
    }

    static void setInternalUd(Map<String, String> map) {
        String[] strArr;
        if (!initialized.get()) {
            initAndWait();
        }
        for (Map.Entry<String, String> key : map.entrySet()) {
            String str = (String) key.getKey();
            String sha256hash = Utility.sha256hash(normalizeData(str, map.get(str).trim()));
            if (internalHashedUserData.containsKey(str)) {
                String str2 = internalHashedUserData.get(str);
                if (str2 != null) {
                    strArr = str2.split(",");
                } else {
                    strArr = new String[0];
                }
                HashSet hashSet = new HashSet(Arrays.asList(strArr));
                if (!hashSet.contains(sha256hash)) {
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(sha256hash);
                    } else if (strArr.length < 5) {
                        sb.append(str2);
                        sb.append(",");
                        sb.append(sha256hash);
                    } else {
                        for (int i = 1; i < 5; i++) {
                            sb.append(strArr[i]);
                            sb.append(",");
                        }
                        sb.append(sha256hash);
                        hashSet.remove(strArr[0]);
                    }
                    internalHashedUserData.put(str, sb.toString());
                } else {
                    return;
                }
            } else {
                internalHashedUserData.put(str, sha256hash);
            }
        }
        writeDataIntoCache("com.facebook.appevents.UserDataStore.internalUserData", Utility.mapToJsonStr(internalHashedUserData));
    }

    private static String normalizeData(String str, String str2) {
        String str3;
        String lowerCase = str2.trim().toLowerCase();
        if ("em".equals(str)) {
            if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                return lowerCase;
            }
            Log.e(TAG, "Setting email failure: this is not a valid email address");
            return "";
        } else if ("ph".equals(str)) {
            return lowerCase.replaceAll("[^0-9]", "");
        } else {
            if (!"ge".equals(str)) {
                return lowerCase;
            }
            if (lowerCase.length() > 0) {
                str3 = lowerCase.substring(0, 1);
            } else {
                str3 = "";
            }
            if ("f".equals(str3) || "m".equals(str3)) {
                return str3;
            }
            Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
            return "";
        }
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }
}

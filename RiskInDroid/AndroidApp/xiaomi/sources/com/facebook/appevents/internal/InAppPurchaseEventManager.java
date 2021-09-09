package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class InAppPurchaseEventManager {
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseEventManager";
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    InAppPurchaseEventManager() {
    }

    static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        HashMap hashMap = new HashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Object[] objArr = new Object[4];
            objArr[0] = 3;
            objArr[1] = PACKAGE_NAME;
            objArr[2] = z ? "subs" : "inapp";
            objArr[3] = bundle;
            Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
            if (invokeMethod != null) {
                Bundle bundle2 = (Bundle) invokeMethod;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            hashMap.put(arrayList.get(i), stringArrayList.get(i));
                        }
                    }
                    writeSkuDetailsToCache(hashMap);
                }
            }
        }
        return hashMap;
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = skuDetailSharedPrefs.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (Map.Entry next : map.entrySet()) {
            edit.putString((String) next.getKey(), currentTimeMillis + ";" + ((String) next.getValue()));
        }
        edit.apply();
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        if (obj == null) {
            return Boolean.FALSE;
        }
        boolean z = false;
        Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, PACKAGE_NAME, str});
        if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, "inapp"));
    }

    static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, "subs"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[EDGE_INSN: B:19:0x005c->B:17:0x005c ?: BREAK  , SYNTHETIC] */
    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj != null && isBillingSupported(context, obj, str).booleanValue()) {
            String str2 = null;
            int i = 0;
            do {
                Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", obj, new Object[]{3, PACKAGE_NAME, str, str2});
                if (invokeMethod != null) {
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt("RESPONSE_CODE") == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        if (stringArrayList == null) {
                            break;
                        }
                        i += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i >= 30) {
                            break;
                        }
                    }
                }
                str2 = null;
                if (i >= 30) {
                    break;
                    break;
                }
            } while (str2 != null);
        }
        return arrayList;
    }

    static boolean hasFreeTrialPeirod(String str) {
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString == null || optString.isEmpty()) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
        }
    }

    static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null || (cls = getClass(context, "com.android.vending.billing.IInAppBillingService")) == null || getMethod(cls, "getPurchaseHistory") == null) {
            return arrayList;
        }
        return filterPurchases(getPurchaseHistory(context, obj, "inapp"));
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            String str2 = null;
            int i = 0;
            boolean z = false;
            do {
                Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    z = true;
                                    break;
                                }
                                arrayList.add(next);
                                i++;
                            } catch (JSONException unused) {
                            }
                        }
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i >= 30 || str2 == null) {
                            break;
                        }
                    }
                }
                str2 = null;
            } while (!z);
        }
        return arrayList;
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 86400) {
                    if (!purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(next);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    private static Method getMethod(Class<?> cls, String str) {
        Method method = methodMap.get(str);
        if (method != null) {
            return method;
        }
        Class[] clsArr = null;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals("getPurchases")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals("isBillingSupported")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals("asInterface")) {
                        c = 0;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals("getPurchaseHistory")) {
                        c = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals("getSkuDetails")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (c == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (c == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (c == 3) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            } else if (c == 4) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            methodMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            return method;
        }
    }

    private static Class<?> getClass(Context context, String str) {
        Class<?> cls = classMap.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            classMap.put(str, cls);
            return cls;
        } catch (ClassNotFoundException unused) {
            return cls;
        }
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    static void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong("LAST_CLEARED_TIME", 0);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        } else if (currentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        }
    }
}

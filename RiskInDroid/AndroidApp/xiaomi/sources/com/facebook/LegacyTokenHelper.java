package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
    private static final String TAG = "LegacyTokenHelper";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String str) {
        Validate.notNull(context, "context");
        this.cacheKey = Utility.isNullOrEmpty(str) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        Context applicationContext = context.getApplicationContext();
        this.cache = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.cacheKey, 0);
    }

    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String next : this.cache.getAll().keySet()) {
            try {
                deserializeKey(next, bundle);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Logger.log(loggingBehavior, 5, str, "Error reading cached value for key: '" + next + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public final void save(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String next : bundle.keySet()) {
            try {
                serializeKey(next, bundle, edit);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Logger.log(loggingBehavior, 5, str, "Error processing value for key: '" + next + "' -- " + e);
                return;
            }
        }
        edit.apply();
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0) {
            return false;
        }
        return true;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, "value");
        bundle.putString("com.facebook.TokenCachingStrategy.Token", str);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", date);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", j);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(collection));
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(collection));
    }

    public static void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.ExpiredPermissions", new ArrayList(collection));
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", accessTokenSource);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", date);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", j);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    public static void putApplicationId(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        bundle.putString("com.facebook.TokenCachingStrategy.ApplicationId", str);
    }

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return new Date(j);
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    private void serializeKey(String str, Bundle bundle, SharedPreferences.Editor editor) throws JSONException {
        String str2;
        String str3;
        Object obj = bundle.get(str);
        if (obj != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = null;
            if (obj instanceof Byte) {
                jSONObject.put("value", ((Byte) obj).intValue());
                str2 = "byte";
            } else if (obj instanceof Short) {
                jSONObject.put("value", ((Short) obj).intValue());
                str2 = "short";
            } else if (obj instanceof Integer) {
                jSONObject.put("value", ((Integer) obj).intValue());
                str2 = "int";
            } else if (obj instanceof Long) {
                jSONObject.put("value", ((Long) obj).longValue());
                str2 = "long";
            } else if (obj instanceof Float) {
                jSONObject.put("value", ((Float) obj).doubleValue());
                str2 = "float";
            } else if (obj instanceof Double) {
                jSONObject.put("value", ((Double) obj).doubleValue());
                str2 = "double";
            } else if (obj instanceof Boolean) {
                jSONObject.put("value", ((Boolean) obj).booleanValue());
                str2 = "bool";
            } else if (obj instanceof Character) {
                jSONObject.put("value", obj.toString());
                str2 = "char";
            } else if (obj instanceof String) {
                jSONObject.put("value", (String) obj);
                str2 = "string";
            } else if (obj instanceof Enum) {
                jSONObject.put("value", obj.toString());
                jSONObject.put("enumType", obj.getClass().getName());
                str2 = "enum";
            } else {
                JSONArray jSONArray2 = new JSONArray();
                int i = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    while (i < length) {
                        jSONArray2.put((int) bArr[i]);
                        i++;
                    }
                    str3 = "byte[]";
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    int length2 = sArr.length;
                    while (i < length2) {
                        jSONArray2.put((int) sArr[i]);
                        i++;
                    }
                    str3 = "short[]";
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int length3 = iArr.length;
                    while (i < length3) {
                        jSONArray2.put(iArr[i]);
                        i++;
                    }
                    str3 = "int[]";
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    int length4 = jArr.length;
                    while (i < length4) {
                        jSONArray2.put(jArr[i]);
                        i++;
                    }
                    str3 = "long[]";
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    int length5 = fArr.length;
                    while (i < length5) {
                        jSONArray2.put((double) fArr[i]);
                        i++;
                    }
                    str3 = "float[]";
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    int length6 = dArr.length;
                    while (i < length6) {
                        jSONArray2.put(dArr[i]);
                        i++;
                    }
                    str3 = "double[]";
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    int length7 = zArr.length;
                    while (i < length7) {
                        jSONArray2.put(zArr[i]);
                        i++;
                    }
                    str3 = "bool[]";
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    int length8 = cArr.length;
                    while (i < length8) {
                        jSONArray2.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    str3 = "char[]";
                } else if (obj instanceof List) {
                    for (Object obj2 : (List) obj) {
                        if (obj2 == null) {
                            obj2 = JSONObject.NULL;
                        }
                        jSONArray2.put(obj2);
                    }
                    str3 = "stringList";
                } else {
                    str2 = null;
                }
                str2 = str3;
                jSONArray = jSONArray2;
            }
            if (str2 != null) {
                jSONObject.put("valueType", str2);
                if (jSONArray != null) {
                    jSONObject.putOpt("value", jSONArray);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    private void deserializeKey(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString("valueType");
        if (string.equals("bool")) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            return;
        }
        int i = 0;
        if (string.equals("bool[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < zArr.length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals("byte")) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
        } else if (string.equals("byte[]")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[jSONArray2.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) jSONArray2.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals("short")) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
        } else if (string.equals("short[]")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
            short[] sArr = new short[jSONArray3.length()];
            while (i < sArr.length) {
                sArr[i] = (short) jSONArray3.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals("int")) {
            bundle.putInt(str, jSONObject.getInt("value"));
        } else if (string.equals("int[]")) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
            int[] iArr = new int[jSONArray4.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray4.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals("long")) {
            bundle.putLong(str, jSONObject.getLong("value"));
        } else if (string.equals("long[]")) {
            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
            long[] jArr = new long[jSONArray5.length()];
            while (i < jArr.length) {
                jArr[i] = jSONArray5.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals("float")) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
        } else if (string.equals("float[]")) {
            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
            float[] fArr = new float[jSONArray6.length()];
            while (i < fArr.length) {
                fArr[i] = (float) jSONArray6.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals("double")) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
        } else if (string.equals("double[]")) {
            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
            double[] dArr = new double[jSONArray7.length()];
            while (i < dArr.length) {
                dArr[i] = jSONArray7.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals("char")) {
            String string2 = jSONObject.getString("value");
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
            }
        } else if (string.equals("char[]")) {
            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
            char[] cArr = new char[jSONArray8.length()];
            for (int i2 = 0; i2 < cArr.length; i2++) {
                String string3 = jSONArray8.getString(i2);
                if (string3 != null && string3.length() == 1) {
                    cArr[i2] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals("string")) {
            bundle.putString(str, jSONObject.getString("value"));
        } else if (string.equals("stringList")) {
            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
            int length = jSONArray9.length();
            ArrayList arrayList = new ArrayList(length);
            while (i < length) {
                Object obj = jSONArray9.get(i);
                arrayList.add(i, obj == JSONObject.NULL ? null : (String) obj);
                i++;
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals("enum")) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
            } catch (ClassNotFoundException | IllegalArgumentException unused) {
            }
        }
    }
}

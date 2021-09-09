package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

public final class gpy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<String, SharedPreferences> f18134O000000o;

    private static String O000000o(String str) {
        return str != null ? str : "";
    }

    public static SharedPreferences O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f18134O000000o == null) {
            f18134O000000o = new HashMap<>();
        }
        if (f18134O000000o.containsKey(str)) {
            return f18134O000000o.get(str);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        f18134O000000o.put(str, sharedPreferences);
        return sharedPreferences;
    }

    public static void O000000o(SharedPreferences sharedPreferences, String str, boolean z) {
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).commit();
        }
    }

    public static void O000000o(Context context, String str, String str2, boolean z) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putBoolean(str2, z).commit();
        }
    }

    public static void O00000Oo(Context context, String str, String str2, boolean z) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putBoolean(str2, z).apply();
        }
    }

    public static boolean O00000Oo(SharedPreferences sharedPreferences, String str, boolean z) {
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public static boolean O00000o0(Context context, String str, String str2, boolean z) {
        SharedPreferences O000000o2 = O000000o(context, str);
        return O000000o2 != null ? O000000o2.getBoolean(str2, z) : z;
    }

    public static void O000000o(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, O000000o(str2)).commit();
        }
    }

    public static void O000000o(Context context, String str, String str2, String str3) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putString(str2, str3).commit();
        }
    }

    public static void O00000Oo(Context context, String str, String str2, String str3) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putString(str2, str3).apply();
        }
    }

    public static String O00000Oo(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static String O00000o0(Context context, String str, String str2, String str3) {
        SharedPreferences O000000o2 = O000000o(context, str);
        return (O000000o2 == null || TextUtils.isEmpty(str2)) ? str3 : O000000o2.getString(str2, str3);
    }

    public static int O000000o(Context context, String str, String str2, int i) {
        SharedPreferences O000000o2 = O000000o(context, str);
        return O000000o2 != null ? O000000o2.getInt(str2, i) : i;
    }

    public static void O00000Oo(Context context, String str, String str2, int i) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putInt(str2, i).commit();
        }
    }

    public static long O000000o(Context context, String str, String str2) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            return O000000o2.getLong(str2, 0);
        }
        return 0;
    }

    public static float O000000o(Context context, String str, String str2, float f) {
        SharedPreferences O000000o2 = O000000o(context, str);
        return O000000o2 != null ? O000000o2.getFloat(str2, f) : f;
    }

    public static void O000000o(Context context, String str, String str2, long j) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putLong(str2, j).commit();
        }
    }

    public static void O00000Oo(Context context, String str, String str2, float f) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().putFloat(str2, f).commit();
        }
    }

    public static void O00000Oo(Context context, String str, String str2) {
        SharedPreferences O000000o2 = O000000o(context, str);
        if (O000000o2 != null) {
            O000000o2.edit().remove(str2).commit();
        }
    }
}

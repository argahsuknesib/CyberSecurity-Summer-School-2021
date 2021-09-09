package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;

public abstract class gpv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ArrayList<Object> f18131O000000o = new ArrayList<>();

    public static String O000000o(String str, String str2) {
        return O000000o(CommonApplication.getAppContext(), str, str2);
    }

    public static String O000000o(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static String O000000o(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public static void O00000Oo(String str, String str2) {
        O00000Oo(CommonApplication.getAppContext(), str, str2);
    }

    public static void O00000Oo(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public static void O00000o0(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public static void O00000Oo(Context context, String str, String str2) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).apply();
        }
    }

    public static boolean O000000o(String str, boolean z) {
        return O000000o(CommonApplication.getAppContext(), str, z);
    }

    public static boolean O000000o(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static boolean O000000o(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getBoolean(str, true);
    }

    public static void O00000Oo(String str, boolean z) {
        O00000Oo(CommonApplication.getAppContext(), str, z);
    }

    public static void O00000Oo(Context context, String str, boolean z) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
        }
    }

    public static void O00000o0(Context context, String str, boolean z) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
        }
    }

    public static void O000000o(SharedPreferences sharedPreferences, String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public static void O000000o(Context context, String str, int i) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(str, i).apply();
        }
    }

    public static int O000000o(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, 0);
    }

    public static void O000000o(Context context, String str, long j) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j).apply();
        }
    }

    public static long O00000Oo(Context context, String str, long j) {
        if (context == null) {
            return 0;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j);
    }

    public static void O00000Oo(Context context, String str) {
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
        }
    }
}

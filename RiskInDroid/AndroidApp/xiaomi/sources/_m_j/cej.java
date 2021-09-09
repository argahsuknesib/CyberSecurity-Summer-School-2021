package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

public final class cej {

    public static class O00000Oo {
        public static void O000000o(String str, Long l) {
            O000000o(bxp.f13383O000000o, str, l);
        }

        public static void O000000o(Context context, String str, Long l) {
            SharedPreferences defaultSharedPreferences;
            SharedPreferences.Editor edit;
            if (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                edit.putLong(str, l.longValue());
                edit.apply();
            }
        }

        public static long O000000o(Context context, String str) {
            SharedPreferences defaultSharedPreferences;
            if (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null) {
                return defaultSharedPreferences.getLong(str, 0);
            }
            return 0;
        }

        public static void O000000o(String str, String str2) {
            O000000o(bxp.f13383O000000o, str, str2);
        }

        public static void O000000o(Context context, String str, String str2) {
            SharedPreferences defaultSharedPreferences;
            SharedPreferences.Editor edit;
            if (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                edit.putString(str, str2);
                edit.apply();
            }
        }

        public static String O00000Oo(Context context, String str, String str2) {
            SharedPreferences defaultSharedPreferences;
            return (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null) ? defaultSharedPreferences.getString(str, str2) : str2;
        }

        public static int O000000o(Context context, String str, int i) {
            SharedPreferences defaultSharedPreferences;
            return (context == null || (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) == null) ? i : defaultSharedPreferences.getInt(str, i);
        }

        public static void O00000Oo(Context context, String str, int i) {
            SharedPreferences defaultSharedPreferences;
            SharedPreferences.Editor edit;
            if (context != null && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                edit.putInt(str, i);
                edit.apply();
            }
        }

        public static boolean O000000o(Context context, String str, boolean z) {
            SharedPreferences defaultSharedPreferences;
            return (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null) ? defaultSharedPreferences.getBoolean(str, z) : z;
        }

        public static void O00000Oo(Context context, String str, boolean z) {
            SharedPreferences defaultSharedPreferences;
            SharedPreferences.Editor edit;
            if (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                edit.putBoolean(str, z);
                edit.apply();
            }
        }

        public static void O00000Oo(Context context, String str) {
            SharedPreferences defaultSharedPreferences;
            SharedPreferences.Editor edit;
            if (!(context == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                edit.remove(str);
                edit.apply();
            }
        }
    }

    public static class O000000o {
        public static boolean O000000o(Context context) {
            NetworkInfo activeNetworkInfo;
            if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        }
    }
}

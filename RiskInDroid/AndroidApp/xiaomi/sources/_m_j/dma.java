package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class dma {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SharedPreferences f14779O000000o;

    public static int O000000o(Context context, String str, int i) {
        return O000000o(context).getInt(dlv.O000000o(context, "wxop_".concat(String.valueOf(str))), i);
    }

    public static long O000000o(Context context, String str) {
        return O000000o(context).getLong(dlv.O000000o(context, "wxop_".concat(String.valueOf(str))), 0);
    }

    private static synchronized SharedPreferences O000000o(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (dma.class) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(".mta-wxop", 0);
            f14779O000000o = sharedPreferences2;
            if (sharedPreferences2 == null) {
                f14779O000000o = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f14779O000000o;
        }
        return sharedPreferences;
    }

    public static String O000000o(Context context, String str, String str2) {
        return O000000o(context).getString(dlv.O000000o(context, "wxop_".concat(String.valueOf(str))), str2);
    }

    public static void O000000o(Context context, String str, long j) {
        String O000000o2 = dlv.O000000o(context, "wxop_".concat(String.valueOf(str)));
        SharedPreferences.Editor edit = O000000o(context).edit();
        edit.putLong(O000000o2, j);
        edit.commit();
    }

    public static void O00000Oo(Context context, String str, int i) {
        String O000000o2 = dlv.O000000o(context, "wxop_".concat(String.valueOf(str)));
        SharedPreferences.Editor edit = O000000o(context).edit();
        edit.putInt(O000000o2, i);
        edit.commit();
    }

    public static void O00000Oo(Context context, String str, String str2) {
        String O000000o2 = dlv.O000000o(context, "wxop_".concat(String.valueOf(str)));
        SharedPreferences.Editor edit = O000000o(context).edit();
        edit.putString(O000000o2, str2);
        edit.commit();
    }
}

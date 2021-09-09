package _m_j;

import android.content.Context;
import android.preference.PreferenceManager;

public final class dbe {
    public static String O000000o(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static void O00000Oo(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).apply();
    }
}

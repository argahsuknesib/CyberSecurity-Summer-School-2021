package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;

public final class fkz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ArrayList<Object> f16557O000000o = new ArrayList<>();

    public static void O000000o(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor edit;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str, str2).apply();
        }
    }

    public static boolean O000000o(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false);
    }

    public static void O00000Oo(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, true).apply();
    }
}

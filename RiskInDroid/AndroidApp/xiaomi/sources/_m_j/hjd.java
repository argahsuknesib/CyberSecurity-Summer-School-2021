package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public final class hjd {
    public static boolean O000000o(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit().clear().commit();
    }

    public static boolean O000000o(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            return edit.commit();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String O00000Oo(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception unused) {
            return "";
        }
    }
}

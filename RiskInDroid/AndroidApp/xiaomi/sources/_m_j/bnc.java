package _m_j;

import android.content.SharedPreferences;
import java.util.Set;

public final class bnc {
    public static void O000000o(SharedPreferences sharedPreferences, String str, int i) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void O000000o(SharedPreferences sharedPreferences, String str, long j) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void O000000o(SharedPreferences sharedPreferences, String str, Set<String> set) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }
}

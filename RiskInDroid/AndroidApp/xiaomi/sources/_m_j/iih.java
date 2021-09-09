package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public final class iih {
    public static void O000000o(Context context, iie iie) {
        if (context != null && iie != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("com_ximalaya_oauth_sdk_android", 32768).edit();
            edit.putString("uid", iie.f1312O000000o);
            edit.putString("access_token", iie.O00000Oo);
            edit.putString("refresh_token", iie.O00000o0);
            edit.putLong("expires_in", iie.O00000o);
            edit.putString("scope", iie.O00000oO);
            edit.putString("device_id", iie.O00000oo);
            edit.commit();
        }
    }

    public static void O000000o(Context context) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("com_ximalaya_oauth_sdk_android", 32768).edit();
            edit.clear();
            edit.apply();
        }
    }
}

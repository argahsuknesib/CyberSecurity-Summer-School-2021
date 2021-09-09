package com.alipay.security.mobile.module.c;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public final class e {
    public static String a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(Context context, String str, Map<String, String> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            for (String next : map.keySet()) {
                edit.putString(next, map.get(next));
            }
            edit.commit();
        }
    }
}

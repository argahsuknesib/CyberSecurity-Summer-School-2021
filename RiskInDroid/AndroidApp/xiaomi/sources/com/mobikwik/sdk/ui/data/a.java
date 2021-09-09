package com.mobikwik.sdk.ui.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.utils.Utils;

public class a {
    public static String a(Context context, User user) {
        if (user == null) {
            return null;
        }
        String str = "";
        String lowerCase = user.getEmail() != null ? user.getEmail().toLowerCase() : str;
        if (user.getCell() != null) {
            str = user.getCell().toLowerCase();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("SDKStorage", 0);
        return sharedPreferences.getString("token_" + lowerCase + "_" + str, null);
    }

    public static void a(Context context, User user, String str) {
        Utils.print("putToken  " + user + ", token " + str);
        if (user != null) {
            String str2 = "";
            String lowerCase = user.getEmail() != null ? user.getEmail().toLowerCase() : str2;
            if (user.getCell() != null) {
                str2 = user.getCell().toLowerCase();
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("SDKStorage", 0).edit();
            edit.putString("token_" + lowerCase + "_" + str2, str);
            edit.commit();
        }
    }
}

package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

public class ActivityExportSafetyGuardian {
    private static final ActivityExportSafetyGuardian INSTANCE = new ActivityExportSafetyGuardian();

    public static ActivityExportSafetyGuardian getInstance() {
        return INSTANCE;
    }

    public void sign(Context context, Intent intent) {
        if (context != null && intent != null) {
            String uuid = UUID.randomUUID().toString();
            intent.putExtra("UUID", uuid);
            getSp(context).edit().putBoolean(getSpKey(uuid), true).commit();
        }
    }

    public boolean checkSign(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            String stringExtra = intent.getStringExtra("UUID");
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            SharedPreferences sp = getSp(context);
            String spKey = getSpKey(stringExtra);
            if (sp.getBoolean(spKey, false)) {
                sp.edit().remove(spKey).commit();
                return true;
            }
        }
        return false;
    }

    private SharedPreferences getSp(Context context) {
        return context.getSharedPreferences("PassportNotificationGuardian", 4);
    }

    private String getSpKey(String str) {
        return "UUID_".concat(String.valueOf(str));
    }
}

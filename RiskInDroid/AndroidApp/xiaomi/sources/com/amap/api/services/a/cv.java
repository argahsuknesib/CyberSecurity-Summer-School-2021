package com.amap.api.services.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.activity.SPUtil;

public class cv {

    /* renamed from: a  reason: collision with root package name */
    private String f3378a;

    public cv(String str) {
        this.f3378a = bw.a(TextUtils.isDigitsOnly(str) ? SPUtil.TAG : str);
    }

    public void a(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f3378a, 0).edit();
            edit.putBoolean(str, z);
            a(edit);
        } catch (Throwable unused) {
        }
    }

    private void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }

    public boolean b(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        try {
            return context.getSharedPreferences(this.f3378a, 0).getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }
}

package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.activity.SPUtil;

public final class bsr {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13244O000000o;

    public bsr(String str) {
        this.f13244O000000o = brp.O000000o(TextUtils.isDigitsOnly(str) ? SPUtil.TAG : str);
    }

    public final void O000000o(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f13244O000000o, 0).edit();
            edit.putBoolean(str, z);
            if (edit == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean O000000o(Context context, String str) {
        if (context == null) {
            return true;
        }
        try {
            return context.getSharedPreferences(this.f13244O000000o, 0).getBoolean(str, true);
        } catch (Throwable unused) {
            return true;
        }
    }
}

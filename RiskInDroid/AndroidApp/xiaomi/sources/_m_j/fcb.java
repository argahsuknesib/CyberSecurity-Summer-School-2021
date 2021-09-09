package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Map;

public final class fcb {
    private static fcb O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f16072O000000o = CommonApplication.getAppContext();
    private SharedPreferences O00000Oo;

    public static fcb O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new fcb();
        }
        return O00000o0;
    }

    private fcb() {
        if (CoreApi.O000000o().O0000Ooo()) {
            SharedPreferences sharedPreferences = this.f16072O000000o.getSharedPreferences("SHConfig", 0);
            Context context = this.f16072O000000o;
            this.O00000Oo = context.getSharedPreferences("SHConfig_" + CoreApi.O000000o().O0000o0(), 0);
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null) {
                SharedPreferences.Editor edit = this.O00000Oo.edit();
                for (Map.Entry next : all.entrySet()) {
                    Object value = next.getValue();
                    if (value instanceof Integer) {
                        edit.putInt((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong((String) next.getKey(), ((Long) next.getValue()).longValue());
                    } else if (value instanceof String) {
                        edit.putString((String) next.getKey(), (String) next.getValue());
                    }
                }
                edit.commit();
            }
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.clear();
            edit2.commit();
            return;
        }
        this.O00000Oo = this.f16072O000000o.getSharedPreferences("SHConfig", 0);
    }

    public final int O000000o(String str) {
        return this.O00000Oo.getInt(str, -1);
    }

    public final long O00000Oo(String str) {
        return this.O00000Oo.getLong(str, -1);
    }

    public final void O00000o0(String str) {
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.remove(str);
        edit.putInt(str, -1);
        edit.apply();
    }

    public final void O000000o(String str, long j) {
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.remove(str);
        edit.putLong(str, j);
        edit.apply();
    }

    public final String O00000o(String str) {
        return this.O00000Oo.getString(str, "");
    }

    public final void O000000o(String str, String str2) {
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.remove(str);
        edit.putString(str, str2);
        edit.apply();
    }
}

package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Map;

public final class fix {
    private static fix O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f16428O000000o;
    private Context O00000Oo = CommonApplication.getAppContext();

    public static fix O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new fix();
        }
        return O00000o0;
    }

    private fix() {
        if (fcn.O000000o().O0000OOo()) {
            SharedPreferences sharedPreferences = this.O00000Oo.getSharedPreferences("SHConfig", 0);
            Context context = this.O00000Oo;
            this.f16428O000000o = context.getSharedPreferences("SHConfig_" + fcn.O000000o().O00000Oo(), 0);
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null) {
                SharedPreferences.Editor edit = this.f16428O000000o.edit();
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
        this.f16428O000000o = this.O00000Oo.getSharedPreferences("SHConfig", 0);
    }

    public final void O000000o(String str) {
        SharedPreferences.Editor edit = this.f16428O000000o.edit();
        edit.remove(str);
        edit.putInt(str, 0);
        edit.apply();
    }

    public final void O000000o(String str, long j) {
        SharedPreferences.Editor edit = this.f16428O000000o.edit();
        edit.remove(str);
        edit.putLong(str, j);
        edit.apply();
    }
}

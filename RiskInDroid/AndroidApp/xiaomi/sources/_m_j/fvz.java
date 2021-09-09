package _m_j;

import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;

public class fvz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fvz f17294O000000o;
    private SharedPreferences O00000Oo = CommonApplication.getApplication().getSharedPreferences("xiaomi.device.pincode", 0);

    private fvz() {
    }

    public static fvz O000000o() {
        if (f17294O000000o == null) {
            synchronized (fvz.class) {
                if (f17294O000000o == null) {
                    f17294O000000o = new fvz();
                }
            }
        }
        return f17294O000000o;
    }

    public final void O000000o(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.putLong(str, currentTimeMillis);
        edit.apply();
    }

    public final boolean O00000Oo(String str) {
        if (!this.O00000Oo.contains(str)) {
            return false;
        }
        if (System.currentTimeMillis() - this.O00000Oo.getLong(str, 0) < 300000) {
            return true;
        }
        SharedPreferences.Editor edit = this.O00000Oo.edit();
        edit.remove(str);
        edit.apply();
        return false;
    }
}

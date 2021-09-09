package _m_j;

import android.text.TextUtils;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public final class fre {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Object f16961O000000o = new Object();
    private static volatile fre O00000oo;
    public Random O00000Oo = new Random();
    public Map<String, frg> O00000o = new ConcurrentHashMap();
    public Map<String, frg> O00000o0 = new ConcurrentHashMap();
    public Map<String, Runnable> O00000oO = new ConcurrentHashMap();

    public static fre O000000o() {
        if (O00000oo == null) {
            synchronized (f16961O000000o) {
                if (O00000oo == null) {
                    O00000oo = new fre();
                }
            }
        }
        return O00000oo;
    }

    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.remove(str);
            this.O00000oO.remove(str);
        }
    }

    public final void O000000o(String str, String str2, String str3, JSONArray jSONArray) {
        frg frg;
        if (!TextUtils.isEmpty(str) && (frg = this.O00000o0.get(str)) != null) {
            frg.O000000o(str2, str3, jSONArray);
        }
    }

    public final void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o.remove(str);
        }
    }

    public final void O00000Oo(String str, String str2, String str3, JSONArray jSONArray) {
        frg frg;
        if (!TextUtils.isEmpty(str) && (frg = this.O00000o.get(str)) != null) {
            frg.O000000o(str2, str3, jSONArray);
        }
    }
}

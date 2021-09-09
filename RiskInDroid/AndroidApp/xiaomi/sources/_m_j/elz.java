package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.at;
import com.xiaomi.push.aw;
import com.xiaomi.push.az;
import com.xiaomi.push.bc;
import com.xiaomi.push.bg;
import java.util.Map;

public class elz implements elv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile elz f15619O000000o;
    private elv O00000Oo;
    private int O00000o0;

    public static elz O000000o(Context context) {
        if (f15619O000000o == null) {
            synchronized (elz.class) {
                if (f15619O000000o == null) {
                    f15619O000000o = new elz(context.getApplicationContext());
                }
            }
        }
        return f15619O000000o;
    }

    private static String O000000o(String str) {
        return str == null ? "" : str;
    }

    public final void O000000o(Map<String, String> map) {
        if (map != null) {
            String O00000Oo2 = O00000Oo();
            if (!TextUtils.isEmpty(O00000Oo2)) {
                map.put("udid", O00000Oo2);
            }
            String O00000o02 = O00000o0();
            if (!TextUtils.isEmpty(O00000o02)) {
                map.put("oaid", O00000o02);
            }
            String O00000o = O00000o();
            if (!TextUtils.isEmpty(O00000o)) {
                map.put("vaid", O00000o);
            }
            String O00000oO = O00000oO();
            if (!TextUtils.isEmpty(O00000oO)) {
                map.put("aaid", O00000oO);
            }
            map.put("oaid_type", String.valueOf(this.O00000o0));
        }
    }

    public final boolean O000000o() {
        return this.O00000Oo.O000000o();
    }

    public final String O00000Oo() {
        return O000000o(this.O00000Oo.O00000Oo());
    }

    public final String O00000o() {
        return O000000o(this.O00000Oo.O00000o());
    }

    public final String O00000o0() {
        return O000000o(this.O00000Oo.O00000o0());
    }

    public final String O00000oO() {
        return O000000o(this.O00000Oo.O00000oO());
    }

    private elz(Context context) {
        elv elv;
        if (az.O000000o(context)) {
            ely.f15618O000000o = 1;
            elv = new az(context);
        } else if (at.O000000o(context)) {
            ely.f15618O000000o = 2;
            elv = new at(context);
        } else if (bc.O000000o(context)) {
            ely.f15618O000000o = 4;
            elv = new bc(context);
        } else if (bg.O000000o(context)) {
            ely.f15618O000000o = 5;
            elv = new bg(context);
        } else if (elw.O000000o(context)) {
            ely.f15618O000000o = 3;
            elv = new aw(context);
        } else {
            ely.f15618O000000o = 0;
            elv = new emb();
        }
        this.O00000Oo = elv;
        this.O00000o0 = ely.f15618O000000o;
        duv.O000000o("create id manager is: " + this.O00000o0);
    }
}

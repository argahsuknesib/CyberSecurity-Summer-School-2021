package _m_j;

import android.content.Context;
import com.tencent.a.a.a.a.d;
import com.tencent.a.a.a.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dgh {
    private static dgh O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<Integer, dgg> f14602O000000o = null;
    private int O00000Oo = 0;
    private Context O00000o0 = null;

    private dgh(Context context) {
        this.O00000o0 = context.getApplicationContext();
        this.f14602O000000o = new HashMap(3);
        this.f14602O000000o.put(1, new e(context));
        this.f14602O000000o.put(2, new dge(context));
        this.f14602O000000o.put(4, new d(context));
    }

    private dgf O000000o(List<Integer> list) {
        dgf O00000o02;
        if (list.size() >= 0) {
            for (Integer num : list) {
                dgg dgg = this.f14602O000000o.get(num);
                if (dgg != null && (O00000o02 = dgg.O00000o0()) != null && dgi.O00000Oo(O00000o02.O00000o0)) {
                    return O00000o02;
                }
            }
        }
        return new dgf();
    }

    public static synchronized dgh O000000o(Context context) {
        dgh dgh;
        synchronized (dgh.class) {
            if (O00000o == null) {
                O00000o = new dgh(context);
            }
            dgh = O00000o;
        }
        return dgh;
    }

    public final dgf O000000o() {
        return O000000o(new ArrayList(Arrays.asList(1, 2, 4)));
    }

    public final void O000000o(String str) {
        dgf O000000o2 = O000000o();
        O000000o2.O00000o0 = str;
        if (!dgi.O000000o(O000000o2.f14600O000000o)) {
            O000000o2.f14600O000000o = dgi.O000000o(this.O00000o0);
        }
        if (!dgi.O000000o(O000000o2.O00000Oo)) {
            O000000o2.O00000Oo = dgi.O00000Oo(this.O00000o0);
        }
        O000000o2.O00000o = System.currentTimeMillis();
        for (Map.Entry<Integer, dgg> value : this.f14602O000000o.entrySet()) {
            ((dgg) value.getValue()).O000000o(O000000o2);
        }
    }
}

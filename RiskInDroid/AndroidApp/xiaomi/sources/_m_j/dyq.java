package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class dyq {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, dyp> f15074O000000o;
    public boolean O00000Oo;
    private final String O00000o;
    public boolean O00000o0;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static dyq f15075O000000o = new dyq((byte) 0);
    }

    /* synthetic */ dyq(byte b) {
        this();
    }

    private dyq() {
        this.O00000o = "TaskManager";
        this.O00000Oo = true;
        this.O00000o0 = false;
        this.f15074O000000o = new HashMap();
    }

    public final dyp O000000o(String str) {
        Map<String, dyp> map;
        if (!TextUtils.isEmpty(str) && (map = this.f15074O000000o) != null) {
            return map.get(str);
        }
        return null;
    }

    public final boolean O00000Oo(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.f15074O000000o.get(str) == null) {
                return false;
            }
            boolean O00000o02 = this.f15074O000000o.get(str).O00000o0();
            return O00000o02;
        }
    }

    public final void O000000o() {
        if (this.f15074O000000o != null) {
            O00000Oo();
            ArrayList<dyp> arrayList = new ArrayList<>();
            Map<String, dyp> map = this.f15074O000000o;
            if (map != null) {
                for (Map.Entry<String, dyp> value : map.entrySet()) {
                    arrayList.add(value.getValue());
                }
            }
            for (dyp dyp : arrayList) {
                if (dyp.O00000o0()) {
                    dyp.O000000o();
                }
            }
        }
    }

    public final void O00000Oo() {
        if (this.f15074O000000o.containsKey("activity") && this.f15074O000000o.get("activity").O00000o0() && !dyd.O00000Oo()) {
            dyd.O000000o();
        }
    }
}

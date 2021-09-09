package _m_j;

import java.util.HashMap;
import java.util.List;

public final class ger implements guu {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap<String, Boolean> f17602O000000o = new HashMap<>();

    public ger(List<String> list, boolean z) {
        for (String next : list) {
            this.f17602O000000o.put(next, Boolean.valueOf(z));
            ges.O000000o().O000000o(next, this);
        }
    }

    public final boolean O000000o(String str) {
        Boolean bool = this.f17602O000000o.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void O00000Oo(String str) {
        this.f17602O000000o.put(str, Boolean.FALSE);
    }

    public final void O000000o(boolean z) {
        for (String next : this.f17602O000000o.keySet()) {
            this.f17602O000000o.put(next, Boolean.valueOf(z));
            ges.O000000o().O00000Oo(next);
        }
    }

    public final void O000000o(String str, boolean z) {
        if (this.f17602O000000o.keySet().contains(str)) {
            this.f17602O000000o.put(str, Boolean.valueOf(z));
            ges.O000000o().O00000Oo(str);
        }
    }
}

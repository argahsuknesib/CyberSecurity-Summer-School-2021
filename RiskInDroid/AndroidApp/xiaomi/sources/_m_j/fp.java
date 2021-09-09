package _m_j;

import java.util.HashMap;

public final class fp {

    /* renamed from: O000000o  reason: collision with root package name */
    private final HashMap<String, fm> f16793O000000o = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, fm fmVar) {
        fm put = this.f16793O000000o.put(str, fmVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* access modifiers changed from: package-private */
    public final fm O000000o(String str) {
        return this.f16793O000000o.get(str);
    }

    public final void O000000o() {
        for (fm clear : this.f16793O000000o.values()) {
            clear.clear();
        }
        this.f16793O000000o.clear();
    }
}

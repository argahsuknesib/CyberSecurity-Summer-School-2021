package _m_j;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class ano implements Iterable<ann> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected LinkedHashMap<anx, ann> f12486O000000o;

    public final void O000000o(ann ann) {
        if (this.f12486O000000o == null) {
            this.f12486O000000o = new LinkedHashMap<>();
        }
        this.f12486O000000o.put(new anx(ann.O00000oo()), ann);
    }

    public final ann O000000o(Method method) {
        LinkedHashMap<anx, ann> linkedHashMap = this.f12486O000000o;
        if (linkedHashMap != null) {
            return linkedHashMap.remove(new anx(method));
        }
        return null;
    }

    public final boolean O000000o() {
        LinkedHashMap<anx, ann> linkedHashMap = this.f12486O000000o;
        return linkedHashMap == null || linkedHashMap.size() == 0;
    }

    public final ann O000000o(String str, Class<?>[] clsArr) {
        LinkedHashMap<anx, ann> linkedHashMap = this.f12486O000000o;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.get(new anx(str, clsArr));
    }

    public final ann O00000Oo(Method method) {
        LinkedHashMap<anx, ann> linkedHashMap = this.f12486O000000o;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.get(new anx(method));
    }

    public final Iterator<ann> iterator() {
        LinkedHashMap<anx, ann> linkedHashMap = this.f12486O000000o;
        if (linkedHashMap != null) {
            return linkedHashMap.values().iterator();
        }
        return Collections.emptyList().iterator();
    }
}

package _m_j;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class aot extends aoe {

    /* renamed from: O000000o  reason: collision with root package name */
    protected LinkedHashSet<aod> f12506O000000o;

    public final Collection<aod> O000000o(anm anm, akr<?> akr, AnnotationIntrospector annotationIntrospector) {
        HashMap hashMap = new HashMap();
        if (this.f12506O000000o != null) {
            Class<?> O00000o = anm.O00000o();
            Iterator<aod> it = this.f12506O000000o.iterator();
            while (it.hasNext()) {
                aod next = it.next();
                if (O00000o.isAssignableFrom(next.O000000o())) {
                    O000000o(anj.O00000Oo(next.O000000o(), annotationIntrospector, akr), next, akr, annotationIntrospector, hashMap);
                }
            }
        }
        List<aod> O00000o0 = annotationIntrospector.O00000o0((ani) anm);
        if (O00000o0 != null) {
            for (aod next2 : O00000o0) {
                O000000o(anj.O00000Oo(next2.O000000o(), annotationIntrospector, akr), next2, akr, annotationIntrospector, hashMap);
            }
        }
        O000000o(anj.O00000Oo(anm.O00000o(), annotationIntrospector, akr), new aod(anm.O00000o(), null), akr, annotationIntrospector, hashMap);
        return new ArrayList(hashMap.values());
    }

    public final Collection<aod> O000000o(anj anj, akr<?> akr, AnnotationIntrospector annotationIntrospector) {
        HashMap hashMap = new HashMap();
        if (this.f12506O000000o != null) {
            Class<?> O00000o = anj.O00000o();
            Iterator<aod> it = this.f12506O000000o.iterator();
            while (it.hasNext()) {
                aod next = it.next();
                if (O00000o.isAssignableFrom(next.O000000o())) {
                    O000000o(anj.O00000Oo(next.O000000o(), annotationIntrospector, akr), next, akr, annotationIntrospector, hashMap);
                }
            }
        }
        O000000o(anj, new aod(anj.O00000o(), null), akr, annotationIntrospector, hashMap);
        return new ArrayList(hashMap.values());
    }

    private void O000000o(anj anj, aod aod, akr<?> akr, AnnotationIntrospector annotationIntrospector, HashMap<aod, aod> hashMap) {
        String O00000oO;
        if (!aod.O00000o0() && (O00000oO = annotationIntrospector.O00000oO(anj)) != null) {
            aod = new aod(aod.O000000o(), O00000oO);
        }
        if (!hashMap.containsKey(aod)) {
            hashMap.put(aod, aod);
            List<aod> O00000o0 = annotationIntrospector.O00000o0((ani) anj);
            if (O00000o0 != null && !O00000o0.isEmpty()) {
                for (aod next : O00000o0) {
                    anj O00000Oo = anj.O00000Oo(next.O000000o(), annotationIntrospector, akr);
                    O000000o(O00000Oo, !next.O00000o0() ? new aod(next.O000000o(), annotationIntrospector.O00000oO(O00000Oo)) : next, akr, annotationIntrospector, hashMap);
                }
            }
        } else if (aod.O00000o0() && !hashMap.get(aod).O00000o0()) {
            hashMap.put(aod, aod);
        }
    }
}

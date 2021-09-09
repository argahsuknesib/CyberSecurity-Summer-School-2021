package _m_j;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class aoa {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final akr<?> f12494O000000o;
    protected final boolean O00000Oo;
    protected final anj O00000o;
    protected final ajv O00000o0;
    protected final aoc<?> O00000oO;
    protected final AnnotationIntrospector O00000oo;
    protected final String O0000O0o;
    protected final LinkedHashMap<String, aob> O0000OOo = new LinkedHashMap<>();
    protected LinkedList<anm> O0000Oo;
    protected LinkedList<aob> O0000Oo0;
    protected LinkedList<ann> O0000OoO;
    protected LinkedList<ann> O0000Ooo;
    protected LinkedHashMap<Object, anm> O0000o0;
    protected HashSet<String> O0000o00;

    protected aoa(akr<?> akr, boolean z, ajv ajv, anj anj, String str) {
        AnnotationIntrospector annotationIntrospector = null;
        this.O0000Oo0 = null;
        this.O0000Oo = null;
        this.O0000OoO = null;
        this.O0000Ooo = null;
        this.f12494O000000o = akr;
        this.O00000Oo = z;
        this.O00000o0 = ajv;
        this.O00000o = anj;
        this.O0000O0o = str == null ? "set" : str;
        this.O00000oo = akr.O0000O0o() ? this.f12494O000000o.O000000o() : annotationIntrospector;
        AnnotationIntrospector annotationIntrospector2 = this.O00000oo;
        if (annotationIntrospector2 == null) {
            this.O00000oO = this.f12494O000000o.O00000o0();
        } else {
            this.O00000oO = annotationIntrospector2.O000000o(anj, this.f12494O000000o.O00000o0());
        }
    }

    public final akr<?> O000000o() {
        return this.f12494O000000o;
    }

    public final ajv O00000Oo() {
        return this.O00000o0;
    }

    public final anj O00000o0() {
        return this.O00000o;
    }

    public final List<anu> O00000o() {
        return new ArrayList(this.O0000OOo.values());
    }

    public final Map<Object, anm> O00000oO() {
        return this.O0000o0;
    }

    public final ann O00000oo() {
        LinkedList<ann> linkedList = this.O0000Ooo;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O00000Oo("Multiple value properties defined (" + this.O0000Ooo.get(0) + " vs " + this.O0000Ooo.get(1) + ")");
        }
        return this.O0000Ooo.get(0);
    }

    public final anm O0000O0o() {
        LinkedList<anm> linkedList = this.O0000Oo;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O00000Oo("Multiple 'any-getters' defined (" + this.O0000Oo.get(0) + " vs " + this.O0000Oo.get(1) + ")");
        }
        return this.O0000Oo.getFirst();
    }

    public final ann O0000OOo() {
        LinkedList<ann> linkedList = this.O0000OoO;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O00000Oo("Multiple 'any-setters' defined (" + this.O0000OoO.get(0) + " vs " + this.O0000OoO.get(1) + ")");
        }
        return this.O0000OoO.getFirst();
    }

    public final Set<String> O0000Oo0() {
        return this.O0000o00;
    }

    public final anz O0000Oo() {
        AnnotationIntrospector annotationIntrospector = this.O00000oo;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.O000000o((ani) this.O00000o);
    }

    public final aoa O0000OoO() {
        boolean z;
        String str;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        boolean z4;
        this.O0000OOo.clear();
        AnnotationIntrospector annotationIntrospector = this.O00000oo;
        Iterator<anl> it = this.O00000o.O0000o00().iterator();
        while (true) {
            String str4 = null;
            boolean z5 = false;
            if (!it.hasNext()) {
                break;
            }
            anl next = it.next();
            String O00000Oo2 = next.O00000Oo();
            if (annotationIntrospector != null) {
                if (this.O00000Oo) {
                    str4 = annotationIntrospector.O000000o(next);
                } else {
                    str4 = annotationIntrospector.O00000Oo(next);
                }
            }
            if ("".equals(str4)) {
                str4 = O00000Oo2;
            }
            boolean z6 = str4 != null;
            if (!z6) {
                z6 = this.O00000oO.O000000o(next);
            }
            if (annotationIntrospector != null && annotationIntrospector.O00000o0((anm) next)) {
                z5 = true;
            }
            O00000o0(O00000Oo2).O000000o(next, str4, z6, z5);
        }
        AnnotationIntrospector annotationIntrospector2 = this.O00000oo;
        for (ann next2 : this.O00000o.O0000Ooo()) {
            int O0000OOo2 = next2.O0000OOo();
            if (O0000OOo2 == 0) {
                if (annotationIntrospector2 != null) {
                    if (annotationIntrospector2.O00000oO(next2)) {
                        if (this.O0000Oo == null) {
                            this.O0000Oo = new LinkedList<>();
                        }
                        this.O0000Oo.add(next2);
                    } else if (annotationIntrospector2.O00000Oo(next2)) {
                        if (this.O0000Ooo == null) {
                            this.O0000Ooo = new LinkedList<>();
                        }
                        this.O0000Ooo.add(next2);
                    }
                }
                if (annotationIntrospector2 == null) {
                    str2 = null;
                } else {
                    str2 = annotationIntrospector2.O000000o(next2);
                }
                if (str2 == null) {
                    str3 = asv.O000000o(next2, next2.O00000Oo());
                    if (str3 == null) {
                        str3 = asv.O00000Oo(next2, next2.O00000Oo());
                        if (str3 != null) {
                            z3 = this.O00000oO.O00000Oo(next2);
                        }
                    } else {
                        z3 = this.O00000oO.O000000o(next2);
                    }
                } else {
                    String O00000Oo3 = next2.O00000Oo();
                    String O00000Oo4 = asv.O00000Oo(next2, O00000Oo3);
                    if (O00000Oo4 == null) {
                        O00000Oo4 = asv.O000000o(next2, O00000Oo3);
                    }
                    str3 = O00000Oo4 == null ? next2.O00000Oo() : O00000Oo4;
                    if (str2.length() == 0) {
                        str2 = str3;
                    }
                    z3 = true;
                }
                if (annotationIntrospector2 == null) {
                    z4 = false;
                } else {
                    z4 = annotationIntrospector2.O00000o0((anm) next2);
                }
                O00000o0(str3).O000000o(next2, str2, z3, z4);
            } else if (O0000OOo2 == 1) {
                String O00000o02 = annotationIntrospector2 == null ? null : annotationIntrospector2.O00000o0(next2);
                if (O00000o02 == null) {
                    str = asv.O00000o0(next2, this.O0000O0o);
                    if (str != null) {
                        z = this.O00000oO.O00000o0(next2);
                    }
                } else {
                    str = asv.O00000o0(next2, this.O0000O0o);
                    if (str == null) {
                        str = next2.O00000Oo();
                    }
                    if (O00000o02.length() == 0) {
                        O00000o02 = str;
                    }
                    z = true;
                }
                if (annotationIntrospector2 == null) {
                    z2 = false;
                } else {
                    z2 = annotationIntrospector2.O00000o0((anm) next2);
                }
                O00000o0(str).O00000Oo(next2, O00000o02, z, z2);
            } else if (O0000OOo2 == 2 && annotationIntrospector2 != null && annotationIntrospector2.O00000o(next2)) {
                if (this.O0000OoO == null) {
                    this.O0000OoO = new LinkedList<>();
                }
                this.O0000OoO.add(next2);
            }
        }
        O0000o00();
        O0000o0();
        O0000o0O();
        O0000o0o();
        akd O0000OoO2 = this.f12494O000000o.O0000OoO();
        if (O0000OoO2 != null) {
            O000000o(O0000OoO2);
        }
        for (aob O0000oO : this.O0000OOo.values()) {
            O0000oO.O0000oO();
        }
        for (aob O000000o2 : this.O0000OOo.values()) {
            O000000o2.O000000o(this.O00000Oo);
        }
        O0000Ooo();
        return this;
    }

    private void O0000Ooo() {
        Boolean bool;
        boolean z;
        Map map;
        AnnotationIntrospector annotationIntrospector = this.O00000oo;
        String[] strArr = null;
        if (annotationIntrospector == null) {
            bool = null;
        } else {
            bool = annotationIntrospector.O0000O0o(this.O00000o);
        }
        if (bool == null) {
            z = this.f12494O000000o.O0000Oo0();
        } else {
            z = bool.booleanValue();
        }
        if (annotationIntrospector != null) {
            strArr = annotationIntrospector.O00000oo(this.O00000o);
        }
        if (z || this.O0000Oo0 != null || strArr != null) {
            int size = this.O0000OOo.size();
            if (z) {
                map = new TreeMap();
            } else {
                map = new LinkedHashMap(size + size);
            }
            for (aob next : this.O0000OOo.values()) {
                map.put(next.O000000o(), next);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (strArr != null) {
                for (String str : strArr) {
                    aob aob = (aob) map.get(str);
                    if (aob == null) {
                        Iterator<aob> it = this.O0000OOo.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            aob next2 = it.next();
                            if (str.equals(next2.O0000o0o())) {
                                str = next2.O000000o();
                                aob = next2;
                                break;
                            }
                        }
                    }
                    if (aob != null) {
                        linkedHashMap.put(str, aob);
                    }
                }
            }
            LinkedList<aob> linkedList = this.O0000Oo0;
            if (linkedList != null) {
                Iterator<aob> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    aob next3 = it2.next();
                    linkedHashMap.put(next3.O000000o(), next3);
                }
            }
            linkedHashMap.putAll(map);
            this.O0000OOo.clear();
            this.O0000OOo.putAll(linkedHashMap);
        }
    }

    private void O0000o00() {
        AnnotationIntrospector annotationIntrospector = this.O00000oo;
        if (annotationIntrospector != null) {
            Iterator<ank> it = this.O00000o.O0000Oo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ank next = it.next();
                if (this.O0000Oo0 == null) {
                    this.O0000Oo0 = new LinkedList<>();
                }
                int O0000O0o2 = next.O0000O0o();
                for (int i = 0; i < O0000O0o2; i++) {
                    anp O00000Oo2 = next.O00000Oo(i);
                    String O000000o2 = annotationIntrospector.O000000o(O00000Oo2);
                    if (O000000o2 != null) {
                        aob O00000o02 = O00000o0(O000000o2);
                        O00000o02.O000000o(O00000Oo2, O000000o2);
                        this.O0000Oo0.add(O00000o02);
                    }
                }
            }
            for (ann next2 : this.O00000o.O0000OoO()) {
                if (this.O0000Oo0 == null) {
                    this.O0000Oo0 = new LinkedList<>();
                }
                int O0000OOo2 = next2.O0000OOo();
                for (int i2 = 0; i2 < O0000OOo2; i2++) {
                    anp O00000Oo3 = next2.O00000Oo(i2);
                    String O000000o3 = annotationIntrospector.O000000o(O00000Oo3);
                    if (O000000o3 != null) {
                        aob O00000o03 = O00000o0(O000000o3);
                        O00000o03.O000000o(O00000Oo3, O000000o3);
                        this.O0000Oo0.add(O00000o03);
                    }
                }
            }
        }
    }

    private void O0000o0() {
        AnnotationIntrospector annotationIntrospector = this.O00000oo;
        if (annotationIntrospector != null) {
            for (anl next : this.O00000o.O0000o00()) {
                O000000o(annotationIntrospector.O00000o((anm) next), next);
            }
            for (ann next2 : this.O00000o.O0000Ooo()) {
                if (next2.O0000OOo() == 1) {
                    O000000o(annotationIntrospector.O00000o((anm) next2), next2);
                }
            }
        }
    }

    private void O000000o(Object obj, anm anm) {
        String str;
        if (obj != null) {
            if (this.O0000o0 == null) {
                this.O0000o0 = new LinkedHashMap<>();
            }
            if (this.O0000o0.put(obj, anm) != null) {
                if (obj == null) {
                    str = "[null]";
                } else {
                    str = obj.getClass().getName();
                }
                throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(obj) + "' (of type " + str + ")");
            }
        }
    }

    private void O0000o0O() {
        Iterator<Map.Entry<String, aob>> it = this.O0000OOo.entrySet().iterator();
        while (it.hasNext()) {
            aob aob = (aob) it.next().getValue();
            if (!aob.O0000oOO()) {
                it.remove();
            } else {
                if (aob.O0000oOo()) {
                    if (!aob.O00000Oo()) {
                        it.remove();
                        O000000o(aob.O000000o());
                    } else {
                        aob.O0000o();
                        if (!this.O00000Oo && !aob.O00000o0()) {
                            O000000o(aob.O000000o());
                        }
                    }
                }
                aob.O0000oO0();
            }
        }
    }

    private void O000000o(String str) {
        if (!this.O00000Oo) {
            if (this.O0000o00 == null) {
                this.O0000o00 = new HashSet<>();
            }
            this.O0000o00.add(str);
        }
    }

    private void O0000o0o() {
        Iterator<Map.Entry<String, aob>> it = this.O0000OOo.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            aob aob = (aob) it.next().getValue();
            String O0000oo0 = aob.O0000oo0();
            if (O0000oo0 != null) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(aob.O000000o(O0000oo0));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                aob aob2 = (aob) it2.next();
                String O000000o2 = aob2.O000000o();
                aob aob3 = this.O0000OOo.get(O000000o2);
                if (aob3 == null) {
                    this.O0000OOo.put(O000000o2, aob2);
                } else {
                    aob3.O000000o(aob2);
                }
            }
        }
    }

    private void O000000o(akd akd) {
        aob[] aobArr = (aob[]) this.O0000OOo.values().toArray(new aob[this.O0000OOo.size()]);
        this.O0000OOo.clear();
        for (aob aob : aobArr) {
            String O000000o2 = aob.O000000o();
            if (this.O00000Oo) {
                if (aob.O00000o()) {
                    aob.O0000OOo();
                    O000000o2 = akd.O00000Oo(O000000o2);
                } else if (aob.O00000oo()) {
                    aob.O0000Oo();
                    O000000o2 = akd.O000000o(O000000o2);
                }
            } else if (aob.O00000oO()) {
                aob.O0000Oo0();
                O000000o2 = akd.O00000o0(O000000o2);
            } else if (aob.O0000O0o()) {
                O000000o2 = akd.O00000o(O000000o2);
            } else if (aob.O00000oo()) {
                aob.O0000Oo();
                O000000o2 = akd.O000000o(O000000o2);
            } else if (aob.O00000o()) {
                aob.O0000OOo();
                O000000o2 = akd.O00000Oo(O000000o2);
            }
            if (!O000000o2.equals(aob.O000000o())) {
                aob = aob.O000000o(O000000o2);
            }
            aob aob2 = this.O0000OOo.get(O000000o2);
            if (aob2 == null) {
                this.O0000OOo.put(O000000o2, aob);
            } else {
                aob2.O000000o(aob);
            }
        }
    }

    private void O00000Oo(String str) {
        throw new IllegalArgumentException("Problem with definition of " + this.O00000o + ": " + str);
    }

    private aob O00000o0(String str) {
        aob aob = this.O0000OOo.get(str);
        if (aob != null) {
            return aob;
        }
        aob aob2 = new aob(str, this.O00000oo, this.O00000Oo);
        this.O0000OOo.put(str, aob2);
        return aob2;
    }
}

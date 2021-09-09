package _m_j;

import _m_j.aih;
import _m_j.ajr;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class apw extends apr {
    public static final apw O00000oO = new apw();

    private apw() {
        super(null);
    }

    /* access modifiers changed from: protected */
    public final Iterable<aqg> O000000o() {
        return this.O00000o0.O00000o0();
    }

    public final ajz<Object> O000000o(akf akf, ajv ajv, ajr ajr) throws JsonMappingException {
        boolean z;
        ajv ajv2 = ajv;
        ake O000000o2 = akf.O000000o();
        ajq O00000Oo = O000000o2.O00000Oo(ajv2);
        ajz<Object> O000000o3 = O000000o(akf, O00000Oo.O00000o0());
        if (O000000o3 != null) {
            return O000000o3;
        }
        ajv O000000o4 = O000000o(O000000o2, O00000Oo.O00000o0(), ajv2);
        boolean z2 = false;
        if (O000000o4 == ajv2) {
            z = false;
        } else {
            if (O000000o4.O00000Oo() != ajv.O00000Oo()) {
                O00000Oo = O000000o2.O00000Oo(O000000o4);
            }
            z = true;
        }
        for (aqg O000000o5 : this.O00000o0.O00000o0()) {
            ajz<?> O000000o6 = O000000o5.O000000o();
            if (O000000o6 != null) {
                return O000000o6;
            }
        }
        ajz<?> O000000o7 = O000000o(akf, O000000o4, O00000Oo);
        if (O000000o7 != null) {
            return O000000o7;
        }
        ajz<Object> ajz = null;
        if (ajv.O0000OoO()) {
            if (!z) {
                z = O000000o(O000000o2, O00000Oo, null, ajr);
            }
            return O000000o(akf, O000000o4, O00000Oo, ajr, z);
        }
        ajz<?> O000000o8 = O000000o(O000000o4);
        if (O000000o8 != null) {
            return O000000o8;
        }
        ajz<?> O000000o9 = O000000o(akf, O000000o4);
        if (O000000o9 != null) {
            return O000000o9;
        }
        Class<?> O00000Oo2 = O000000o4.O00000Oo();
        if (asw.O000000o(O00000Oo2) == null && !asw.O00000o(O00000Oo2)) {
            z2 = true;
        }
        if (z2) {
            if (O00000Oo.O00000Oo() != Object.class) {
                ake O000000o10 = akf.O000000o();
                apv apv = new apv(O00000Oo);
                List O000000o11 = O000000o(akf, O00000Oo, apv);
                if (O000000o11 == null) {
                    O000000o11 = new ArrayList();
                }
                if (this.O00000o0.O00000Oo()) {
                    Iterator<apx> it = this.O00000o0.O00000oO().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                List<apt> O000000o12 = O000000o(O000000o10, O00000Oo, O000000o11);
                if (this.O00000o0.O00000Oo()) {
                    Iterator<apx> it2 = this.O00000o0.O00000oO().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                apv.O000000o(O000000o(akf, O00000Oo, O000000o12));
                apv.O000000o(O000000o12);
                apv.O000000o(O000000o10.O000000o().O00000o(O00000Oo.O00000o0()));
                anm O0000o0 = O00000Oo.O0000o0();
                if (O0000o0 != null) {
                    if (O000000o10.O0000OOo()) {
                        asw.O000000o(O0000o0.O0000OoO());
                    }
                    ajv O000000o13 = O0000o0.O000000o(O00000Oo.O00000oo());
                    boolean O000000o14 = O000000o10.O000000o(MapperFeature.USE_STATIC_TYPING);
                    ajv O0000o0o = O000000o13.O0000o0o();
                    apv.O000000o(new apq(new ajr.O000000o(O0000o0.O00000Oo(), O0000o0o, O00000Oo.O0000O0o(), O0000o0), O0000o0, arm.O000000o(null, O000000o13, O000000o14, O00000Oo(O000000o10, O0000o0o), null, null)));
                }
                O000000o(O000000o10, apv);
                if (this.O00000o0.O00000Oo()) {
                    Iterator<apx> it3 = this.O00000o0.O00000oO().iterator();
                    while (it3.hasNext()) {
                        it3.next();
                    }
                }
                ajz<Object> O00000oo = apv.O00000oo();
                if (O00000oo == null && O00000Oo.O00000oO()) {
                    O00000oo = apv.O0000O0o();
                }
                ajz = O00000oo;
                if (this.O00000o0.O00000Oo()) {
                    Iterator<apx> it4 = this.O00000o0.O00000oO().iterator();
                    while (it4.hasNext()) {
                        it4.next();
                    }
                }
            } else {
                throw new IllegalArgumentException("Can not create bean serializer for Object.class");
            }
        }
        ajz<Object> ajz2 = ajz;
        if (ajz2 == null) {
            return O000000o(O000000o2, O000000o4, O00000Oo);
        }
        return ajz2;
    }

    private aoi O000000o(ajv ajv, ake ake, anm anm) throws JsonMappingException {
        AnnotationIntrospector O000000o2 = ake.O000000o();
        aoh<?> O000000o3 = O000000o2.O000000o(ake, anm, ajv);
        if (O000000o3 == null) {
            return O00000Oo(ake, ajv);
        }
        return O000000o3.O000000o(ake, ajv, ake.O0000oO0().O000000o(anm, ake, O000000o2));
    }

    private aoi O00000Oo(ajv ajv, ake ake, anm anm) throws JsonMappingException {
        ajv O0000o0o = ajv.O0000o0o();
        AnnotationIntrospector O000000o2 = ake.O000000o();
        aoh<?> O00000Oo = O000000o2.O00000Oo(ake, anm, ajv);
        if (O00000Oo == null) {
            return O00000Oo(ake, O0000o0o);
        }
        return O00000Oo.O000000o(ake, O0000o0o, ake.O0000oO0().O000000o(anm, ake, O000000o2));
    }

    private static aqn O000000o(akf akf, ajq ajq, List<apt> list) throws JsonMappingException {
        anz O00000o = ajq.O00000o();
        if (O00000o == null) {
            return null;
        }
        Class<? extends aig<?>> O00000o0 = O00000o.O00000o0();
        if (O00000o0 == aih.O00000o0.class) {
            String O000000o2 = O00000o.O000000o();
            int size = list.size();
            for (int i = 0; i != size; i++) {
                apt apt = list.get(i);
                if (O000000o2.equals(apt.O00000o0())) {
                    if (i > 0) {
                        list.remove(i);
                        list.add(0, apt);
                    }
                    return aqn.O000000o(apt.O000000o(), null, new aqo(O00000o, apt));
                }
            }
            throw new IllegalArgumentException("Invalid Object Id definition for " + ajq.O00000Oo().getName() + ": can not find property with name '" + O000000o2 + "'");
        }
        return aqn.O000000o(akf.O0000OOo().O00000Oo(akf.O000000o((Type) O00000o0), aig.class)[0], O00000o.O000000o(), akf.O000000o(O00000o));
    }

    private List<apt> O000000o(akf akf, ajq ajq, apv apv) throws JsonMappingException {
        List<anu> O0000OOo = ajq.O0000OOo();
        ake O000000o2 = akf.O000000o();
        AnnotationIntrospector O000000o3 = O000000o2.O000000o();
        HashMap hashMap = new HashMap();
        Iterator<anu> it = O0000OOo.iterator();
        while (it.hasNext()) {
            anm O0000OoO = it.next().O0000OoO();
            if (O0000OoO == null) {
                it.remove();
            } else {
                Class<?> O00000o = O0000OoO.O00000o();
                Boolean bool = (Boolean) hashMap.get(O00000o);
                if (bool == null) {
                    bool = O000000o3.O00000o0(O000000o2.O00000o0(O00000o).O00000o0());
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(O00000o, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
        if (O000000o2.O000000o(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            O000000o(O0000OOo);
        }
        if (O0000OOo.isEmpty()) {
            return null;
        }
        boolean O000000o4 = O000000o(O000000o2, ajq, null, null);
        aqc aqc = new aqc(O000000o2, ajq);
        ArrayList arrayList = new ArrayList(O0000OOo.size());
        asp O00000oo = ajq.O00000oo();
        for (anu next : O0000OOo) {
            anm O0000OoO2 = next.O0000OoO();
            if (!next.O0000o0O()) {
                AnnotationIntrospector.ReferenceProperty O0000o0 = next.O0000o0();
                if (O0000o0 == null || !O0000o0.O00000Oo()) {
                    if (O0000OoO2 instanceof ann) {
                        arrayList.add(O000000o(akf, next, O00000oo, aqc, O000000o4, (ann) O0000OoO2));
                    } else {
                        arrayList.add(O000000o(akf, next, O00000oo, aqc, O000000o4, (anl) O0000OoO2));
                    }
                }
            } else if (O0000OoO2 != null) {
                if (O000000o2.O0000OOo()) {
                    asw.O000000o(O0000OoO2.O0000OoO());
                }
                apv.O000000o(O0000OoO2);
            }
        }
        return arrayList;
    }

    private static List<apt> O000000o(ake ake, ajq ajq, List<apt> list) {
        String[] O00000Oo = ake.O000000o().O00000Oo((ani) ajq.O00000o0());
        if (O00000Oo != null && O00000Oo.length > 0) {
            HashSet O000000o2 = asu.O000000o(O00000Oo);
            Iterator<apt> it = list.iterator();
            while (it.hasNext()) {
                if (O000000o2.contains(it.next().O00000o0())) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private static void O000000o(ake ake, apv apv) {
        List<apt> O000000o2 = apv.O000000o();
        boolean O000000o3 = ake.O000000o(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int size = O000000o2.size();
        apt[] aptArr = new apt[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            apt apt = O000000o2.get(i2);
            Class<?>[] O0000Oo0 = apt.O0000Oo0();
            if (O0000Oo0 != null) {
                i++;
                aptArr[i2] = aqi.O000000o(apt, O0000Oo0);
            } else if (O000000o3) {
                aptArr[i2] = apt;
            }
        }
        if (!O000000o3 || i != 0) {
            apv.O000000o(aptArr);
        }
    }

    private static void O000000o(List<anu> list) {
        Iterator<anu> it = list.iterator();
        while (it.hasNext()) {
            anu next = it.next();
            if (!next.O00000o0() && !next.O00000Oo()) {
                it.remove();
            }
        }
    }

    private apt O000000o(akf akf, anu anu, asp asp, aqc aqc, boolean z, anm anm) throws JsonMappingException {
        String O000000o2 = anu.O000000o();
        if (akf.O00000Oo()) {
            asw.O000000o(anm.O0000OoO());
        }
        ajv O000000o3 = anm.O000000o(asp);
        ajr.O000000o o000000o = new ajr.O000000o(O000000o2, O000000o3, aqc.O000000o(), anm);
        ajz<?> O000000o4 = O000000o(akf, anm);
        if (O000000o4 instanceof aqd) {
            ((aqd) O000000o4).O000000o(akf);
        }
        if (O000000o4 instanceof apz) {
            O000000o4 = ((apz) O000000o4).O000000o(akf, o000000o);
        }
        ajz<?> ajz = O000000o4;
        aoi aoi = null;
        if (asw.O00000oO(O000000o3.O00000Oo())) {
            aoi = O00000Oo(O000000o3, akf.O000000o(), anm);
        }
        aoi aoi2 = aoi;
        return aqc.O000000o(anu, O000000o3, ajz, O000000o(O000000o3, akf.O000000o(), anm), aoi2, anm, z);
    }
}

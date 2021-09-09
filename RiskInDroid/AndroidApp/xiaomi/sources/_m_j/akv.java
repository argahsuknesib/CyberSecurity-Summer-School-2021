package _m_j;

import _m_j.ajr;
import _m_j.amm;
import _m_j.amr;
import _m_j.ams;
import _m_j.amv;
import _m_j.amz;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class akv extends alh {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final HashMap<ash, ajw<Object>> f12425O000000o = new HashMap<>();
    protected static final HashMap<ajv, ajw<Object>> O00000Oo = amx.O000000o();
    static final HashMap<String, Class<? extends Map>> O00000o;
    protected static final HashMap<ajv, aka> O00000o0 = ana.O000000o();
    static final HashMap<String, Class<? extends Collection>> O00000oO;
    protected anh O00000oo = anh.f12481O000000o;
    protected final akp O0000O0o;

    static {
        O000000o(f12425O000000o, Object.class, new ang());
        ane ane = new ane();
        O000000o(f12425O000000o, String.class, ane);
        O000000o(f12425O000000o, CharSequence.class, ane);
        O000000o(f12425O000000o, new amy[]{new amv.O00000o0(Boolean.class, null), new amv.O00000o(Byte.class, null), new amv.O00oOooO(Short.class, null), new amv.O0000O0o(Character.class, null), new amv.O0000Oo(Integer.class, null), new amv.O0000o00(Long.class, null), new amv.O0000Oo0(Float.class, null), new amv.O0000OOo(Double.class, null), new amv.O00000o0(Boolean.TYPE, Boolean.FALSE), new amv.O00000o(Byte.TYPE, (byte) 0), new amv.O00oOooO(Short.TYPE, 0), new amv.O0000O0o(Character.TYPE, 0), new amv.O0000Oo(Integer.TYPE, 0), new amv.O0000o00(Long.TYPE, 0L), new amv.O0000Oo0(Float.TYPE, Float.valueOf(0.0f)), new amv.O0000OOo(Double.TYPE, Double.valueOf(0.0d)), new amv.O0000o0(), new amv.O000000o(), new amv.O00000Oo()});
        O000000o(f12425O000000o, new amy[]{new amm.O000000o(), new amm.O00000o0(), new amm.O000000o(GregorianCalendar.class), new amm.O00000o(), new amm.O0000OOo(), new amm.O0000O0o()});
        O000000o(f12425O000000o, new amy[]{new ams.O0000o00(), new ams.O00oOooO(), new ams.O0000o(), new ams.O0000o0(), new ams.O00000o(), new ams.O0000Oo0(), new ams.O0000OOo(), new ams.O0000O0o(), new ams.O00000o0(), new ams.O000000o(), new amj(), new ams.O0000Oo()});
        O000000o(f12425O000000o, new amy[]{new amr.O000000o(), new amr.O00000o0()});
        HashMap<String, Class<? extends Map>> hashMap = new HashMap<>();
        O00000o = hashMap;
        hashMap.put(Map.class.getName(), LinkedHashMap.class);
        O00000o.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        O00000o.put(SortedMap.class.getName(), TreeMap.class);
        O00000o.put("java.util.NavigableMap", TreeMap.class);
        try {
            Class<?> cls = Class.forName("java.util.ConcurrentNavigableMap");
            O00000o.put(cls.getName(), Class.forName("java.util.ConcurrentSkipListMap"));
        } catch (ClassNotFoundException unused) {
        }
        HashMap<String, Class<? extends Collection>> hashMap2 = new HashMap<>();
        O00000oO = hashMap2;
        hashMap2.put(Collection.class.getName(), ArrayList.class);
        O00000oO.put(List.class.getName(), ArrayList.class);
        O00000oO.put(Set.class.getName(), HashSet.class);
        O00000oO.put(SortedSet.class.getName(), TreeSet.class);
        O00000oO.put(Queue.class.getName(), LinkedList.class);
        O00000oO.put("java.util.Deque", LinkedList.class);
        O00000oO.put("java.util.NavigableSet", TreeSet.class);
    }

    private static void O000000o(Map<ash, ajw<Object>> map, amy<?>[] amyArr) {
        for (amy<?> amy : amyArr) {
            O000000o(map, amy.O00000oO(), amy);
        }
    }

    private static void O000000o(Map<ash, ajw<Object>> map, Class<?> cls, amy<?> amy) {
        map.put(new ash(cls), amy);
    }

    protected akv(akp akp) {
        this.O0000O0o = akp;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e1  */
    public final aln O000000o(ajt ajt, ajq ajq) throws JsonMappingException {
        aln aln;
        ank O0000o00;
        ajs O000000o2 = ajt.O000000o();
        Object O0000OOo = ajt.O00000Oo().O0000OOo(ajq.O00000o0());
        amr.O00000Oo o00000Oo = null;
        if (!(O0000OOo == null || O0000OOo == null)) {
            if (O0000OOo instanceof Class) {
                Class<akm> cls = (Class) O0000OOo;
                if (cls != akm.class) {
                    if (!aln.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
                    } else if (O000000o2.O0000Ooo() == null) {
                        aln = (aln) asw.O000000o(cls, O000000o2.O0000OOo());
                        if (aln == null) {
                            if (ajq.O00000Oo() == JsonLocation.class) {
                                o00000Oo = new amr.O00000Oo();
                            }
                            aln = o00000Oo;
                            if (aln == null) {
                                boolean O00000oO2 = ajt.O00000oO();
                                alq alq = new alq(ajq, O00000oO2);
                                AnnotationIntrospector O00000Oo2 = ajt.O00000Oo();
                                if (ajq.O000000o().O00000o() && (O0000o00 = ajq.O0000o00()) != null) {
                                    if (O00000oO2) {
                                        asw.O000000o((Member) O0000o00.O00000oo());
                                    }
                                    alq.O000000o(O0000o00);
                                }
                                ajs O000000o3 = ajt.O000000o();
                                ajt ajt2 = ajt;
                                ajq ajq2 = ajq;
                                aoc<?> O000000o4 = O000000o3.O000000o().O000000o(ajq.O00000o0(), O000000o3.O00000o0());
                                AnnotationIntrospector annotationIntrospector = O00000Oo2;
                                alq alq2 = alq;
                                O00000Oo(ajt2, ajq2, O000000o4, annotationIntrospector, alq2);
                                O000000o(ajt2, ajq2, O000000o4, annotationIntrospector, alq2);
                                aln = alq.O000000o(O000000o3);
                            }
                        }
                        if (this.O0000O0o.O00000o()) {
                            for (alo next : this.O0000O0o.O0000Oo0()) {
                                aln = next.O000000o();
                                if (aln == null) {
                                    throw new JsonMappingException("Broken registered ValueInstantiators (of type " + next.getClass().getName() + "): returned null ValueInstantiator");
                                }
                            }
                        }
                        return aln;
                    }
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + O0000OOo.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
        }
        aln = null;
        if (aln == null) {
        }
        if (this.O0000O0o.O00000o()) {
        }
        return aln;
    }

    private void O000000o(ajt ajt, ajq ajq, aoc<?> aoc, AnnotationIntrospector annotationIntrospector, alq alq) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        alq alq2 = alq;
        for (ank next : ajq.O0000OoO()) {
            int O0000O0o2 = next.O0000O0o();
            if (O0000O0o2 > 0) {
                boolean O0000oO0 = annotationIntrospector2.O0000oO0(next);
                boolean O000000o2 = aoc.O000000o(next);
                if (O0000O0o2 == 1) {
                    anp O00000Oo2 = next.O00000Oo(0);
                    String O000000o3 = annotationIntrospector2.O000000o(O00000Oo2);
                    Object O00000o2 = annotationIntrospector2.O00000o((anm) O00000Oo2);
                    if (O00000o2 != null || (O000000o3 != null && O000000o3.length() > 0)) {
                        alq2.O00000Oo(next, new ale[]{O000000o(ajt, ajq, O000000o3, 0, O00000Oo2, O00000o2)});
                    } else {
                        Class<?> O0000OOo = next.O0000OOo();
                        if (O0000OOo == String.class) {
                            if (O0000oO0 || O000000o2) {
                                alq2.O000000o((anq) next);
                            }
                        } else if (O0000OOo == Integer.TYPE || O0000OOo == Integer.class) {
                            if (O0000oO0 || O000000o2) {
                                alq2.O00000Oo(next);
                            }
                        } else if (O0000OOo == Long.TYPE || O0000OOo == Long.class) {
                            if (O0000oO0 || O000000o2) {
                                alq2.O00000o0(next);
                            }
                        } else if (O0000OOo == Double.TYPE || O0000OOo == Double.class) {
                            if (O0000oO0 || O000000o2) {
                                alq2.O00000o(next);
                            }
                        } else if (O0000oO0) {
                            alq2.O000000o(next, null);
                        }
                    }
                } else if (O0000oO0 || O000000o2) {
                    ale[] aleArr = new ale[O0000O0o2];
                    anp anp = null;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < O0000O0o2; i3++) {
                        anp O00000Oo3 = next.O00000Oo(i3);
                        String O000000o4 = annotationIntrospector2.O000000o(O00000Oo3);
                        Object O00000o3 = annotationIntrospector2.O00000o((anm) O00000Oo3);
                        if (O000000o4 != null && O000000o4.length() > 0) {
                            i++;
                            aleArr[i3] = O000000o(ajt, ajq, O000000o4, i3, O00000Oo3, O00000o3);
                        } else if (O00000o3 != null) {
                            i2++;
                            aleArr[i3] = O000000o(ajt, ajq, O000000o4, i3, O00000Oo3, O00000o3);
                        } else if (anp == null) {
                            anp = O00000Oo3;
                        }
                    }
                    if (O0000oO0 || i > 0 || i2 > 0) {
                        if (i + i2 == O0000O0o2) {
                            alq2.O00000Oo(next, aleArr);
                        } else if (i == 0 && i2 + 1 == O0000O0o2) {
                            alq2.O000000o(next, aleArr);
                        } else {
                            throw new IllegalArgumentException("Argument #" + anp.O0000OOo() + " of constructor " + next + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                        }
                    }
                }
            }
        }
    }

    private void O00000Oo(ajt ajt, ajq ajq, aoc<?> aoc, AnnotationIntrospector annotationIntrospector, alq alq) throws JsonMappingException {
        aoc<?> aoc2 = aoc;
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        alq alq2 = alq;
        for (ann next : ajq.O0000Ooo()) {
            int O0000OOo = next.O0000OOo();
            if (O0000OOo > 0) {
                boolean O0000oO0 = annotationIntrospector2.O0000oO0(next);
                if (O0000OOo == 1) {
                    anp O00000Oo2 = next.O00000Oo(0);
                    String O000000o2 = annotationIntrospector2.O000000o(O00000Oo2);
                    if (annotationIntrospector2.O00000o((anm) O00000Oo2) == null && (O000000o2 == null || O000000o2.length() == 0)) {
                        Class<?> O0000o0 = next.O0000o0();
                        if (O0000o0 == String.class) {
                            if (O0000oO0 || aoc2.O000000o((anm) next)) {
                                alq2.O000000o(next);
                            }
                        } else if (O0000o0 == Integer.TYPE || O0000o0 == Integer.class) {
                            if (O0000oO0 || aoc2.O000000o((anm) next)) {
                                alq2.O00000Oo(next);
                            }
                        } else if (O0000o0 == Long.TYPE || O0000o0 == Long.class) {
                            if (O0000oO0 || aoc2.O000000o((anm) next)) {
                                alq2.O00000o0(next);
                            }
                        } else if (O0000o0 == Double.TYPE || O0000o0 == Double.class) {
                            if (O0000oO0 || aoc2.O000000o((anm) next)) {
                                alq2.O00000o(next);
                            }
                        } else if (O0000o0 == Boolean.TYPE || O0000o0 == Boolean.class) {
                            if (O0000oO0 || aoc2.O000000o((anm) next)) {
                                alq2.O00000oO(next);
                            }
                        } else if (annotationIntrospector2.O0000oO0(next)) {
                            alq2.O000000o(next, null);
                        }
                    }
                } else if (!annotationIntrospector2.O0000oO0(next)) {
                    continue;
                }
                ale[] aleArr = new ale[O0000OOo];
                anp anp = null;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < O0000OOo; i3++) {
                    anp O00000Oo3 = next.O00000Oo(i3);
                    String O000000o3 = annotationIntrospector2.O000000o(O00000Oo3);
                    Object O00000o2 = annotationIntrospector2.O00000o((anm) O00000Oo3);
                    if (O000000o3 != null && O000000o3.length() > 0) {
                        i++;
                        aleArr[i3] = O000000o(ajt, ajq, O000000o3, i3, O00000Oo3, O00000o2);
                    } else if (O00000o2 != null) {
                        i2++;
                        aleArr[i3] = O000000o(ajt, ajq, O000000o3, i3, O00000Oo3, O00000o2);
                    } else if (anp == null) {
                        anp = O00000Oo3;
                    }
                }
                if (O0000oO0 || i > 0 || i2 > 0) {
                    if (i + i2 == O0000OOo) {
                        alq2.O00000Oo(next, aleArr);
                    } else if (i == 0 && i2 + 1 == O0000OOo) {
                        alq2.O000000o(next, aleArr);
                    } else {
                        throw new IllegalArgumentException("Argument #" + anp.O0000OOo() + " of factory method " + next + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                    }
                }
            }
        }
    }

    private ale O000000o(ajt ajt, ajq ajq, String str, int i, anp anp, Object obj) throws JsonMappingException {
        anp anp2 = anp;
        ajs O000000o2 = ajt.O000000o();
        ajv O000000o3 = O000000o2.O0000o0().O000000o(anp.O00000oo(), ajq.O00000oo());
        ajr.O000000o o000000o = new ajr.O000000o(str, O000000o3, ajq.O0000O0o(), anp2);
        ajv O000000o4 = O000000o(ajt, O000000o3, anp2);
        if (O000000o4 != O000000o3) {
            o000000o.O000000o(O000000o4);
        }
        ajw<Object> O000000o5 = O000000o(ajt, anp2);
        ajv O000000o6 = O000000o(ajt, anp2, O000000o4);
        aof aof = (aof) O000000o6.O0000oO();
        if (aof == null) {
            aof = O00000Oo(O000000o2, O000000o6);
        }
        ale ale = new ale(str, O000000o6, aof, ajq.O0000O0o(), anp, i, obj);
        return O000000o5 != null ? ale.O00000Oo(O000000o5) : ale;
    }

    public final ajw<?> O000000o(ajt ajt, asg asg, ajq ajq) throws JsonMappingException {
        ajv O0000o0o = asg.O0000o0o();
        ajw ajw = (ajw) O0000o0o.O0000oO0();
        if (ajw == null) {
            ajw<?> ajw2 = O00000Oo.get(O0000o0o);
            if (ajw2 != null) {
                ajw<?> O000000o2 = O000000o();
                return O000000o2 != null ? O000000o2 : ajw2;
            } else if (O0000o0o.O0000Oo0()) {
                throw new IllegalArgumentException("Internal error: primitive type (" + asg + ") passed, no array deserializer found");
            }
        }
        aof aof = (aof) O0000o0o.O0000oO();
        if (aof == null) {
            aof = O00000Oo(ajt.O000000o(), O0000o0o);
        }
        ajw<?> O000000o3 = O000000o();
        if (O000000o3 != null) {
            return O000000o3;
        }
        return new amw(asg, ajw, aof);
    }

    private ajw<?> O000000o() throws JsonMappingException {
        for (ali O000000o2 : this.O0000O0o.O00000oO()) {
            ajw<?> O000000o3 = O000000o2.O000000o();
            if (O000000o3 != null) {
                return O000000o3;
            }
        }
        return null;
    }

    public final ajw<?> O000000o(ajt ajt, asj asj, ajq ajq) throws JsonMappingException {
        ajw<?> ajw;
        ajv O0000o0o = asj.O0000o0o();
        ajw ajw2 = (ajw) O0000o0o.O0000oO0();
        aof aof = (aof) O0000o0o.O0000oO();
        if (aof == null) {
            aof = O00000Oo(ajt.O000000o(), O0000o0o);
        }
        Iterator<ali> it = this.O0000O0o.O00000oO().iterator();
        while (true) {
            if (!it.hasNext()) {
                ajw = null;
                break;
            }
            ajw = it.next().O00000Oo();
            if (ajw != null) {
                break;
            }
        }
        if (ajw != null) {
            return ajw;
        }
        Class<?> O00000Oo2 = asj.O00000Oo();
        if (ajw2 == null && EnumSet.class.isAssignableFrom(O00000Oo2)) {
            return new amp(O0000o0o, null);
        }
        if (asj.O0000OOo() || asj.O00000o0()) {
            Class cls = O00000oO.get(O00000Oo2.getName());
            if (cls != null) {
                asj = (asj) ajt.O000000o().O000000o(asj, cls);
                ajq = ajt.O000000o().O00000o0(asj);
            } else {
                throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type ".concat(String.valueOf(asj)));
            }
        }
        aln O000000o2 = O000000o(ajt, ajq);
        if (O0000o0o.O00000Oo() == String.class) {
            return new and(asj, ajw2, O000000o2);
        }
        return new amk(asj, ajw2, aof, O000000o2);
    }

    public final ajw<?> O000000o(ajt ajt, asi asi, ajq ajq) throws JsonMappingException {
        ajv O0000o0o = asi.O0000o0o();
        if (((aof) O0000o0o.O0000oO()) == null) {
            O00000Oo(ajt.O000000o(), O0000o0o);
        }
        for (ali O00000o02 : this.O0000O0o.O00000oO()) {
            ajw<?> O00000o03 = O00000o02.O00000o0();
            if (O00000o03 != null) {
                return O00000o03;
            }
        }
        return null;
    }

    public final ajw<?> O000000o(ajt ajt, asm asm, ajq ajq) throws JsonMappingException {
        aof aof;
        ajw<?> ajw;
        ajs O000000o2 = ajt.O000000o();
        ajv O0000o0O = asm.O0000o0O();
        ajv O0000o0o = asm.O0000o0o();
        ajw ajw2 = (ajw) O0000o0o.O0000oO0();
        aka aka = (aka) O0000o0O.O0000oO0();
        aof aof2 = (aof) O0000o0o.O0000oO();
        if (aof2 == null) {
            aof = O00000Oo(O000000o2, O0000o0o);
        } else {
            aof = aof2;
        }
        Iterator<ali> it = this.O0000O0o.O00000oO().iterator();
        while (true) {
            if (!it.hasNext()) {
                ajw = null;
                break;
            }
            ajw = it.next().O00000oO();
            if (ajw != null) {
                break;
            }
        }
        if (ajw != null) {
            return ajw;
        }
        Class<?> O00000Oo2 = asm.O00000Oo();
        if (EnumMap.class.isAssignableFrom(O00000Oo2)) {
            Class<?> O00000Oo3 = O0000o0O.O00000Oo();
            if (O00000Oo3 != null && O00000Oo3.isEnum()) {
                return new amo(asm, null, ajw2);
            }
            throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
        }
        if (asm.O0000OOo() || asm.O00000o0()) {
            Class cls = O00000o.get(O00000Oo2.getName());
            if (cls != null) {
                asm = (asm) O000000o2.O000000o(asm, cls);
                ajq = O000000o2.O00000o0(asm);
            } else {
                throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type ".concat(String.valueOf(asm)));
            }
        }
        amu amu = new amu(asm, O000000o(ajt, ajq), aka, ajw2, aof);
        amu.O000000o(O000000o2.O000000o().O00000Oo((ani) ajq.O00000o0()));
        return amu;
    }

    public final ajw<?> O000000o(ajt ajt, asl asl, ajq ajq) throws JsonMappingException {
        ajv O0000o0o = asl.O0000o0o();
        if (((aof) O0000o0o.O0000oO()) == null) {
            O00000Oo(ajt.O000000o(), O0000o0o);
        }
        for (ali O00000oo2 : this.O0000O0o.O00000oO()) {
            ajw<?> O00000oo3 = O00000oo2.O00000oo();
            if (O00000oo3 != null) {
                return O00000oo3;
            }
        }
        return null;
    }

    public final ajw<?> O000000o(ajt ajt, ajv ajv, ajq ajq) throws JsonMappingException {
        Class<?> O00000Oo2 = ajv.O00000Oo();
        ajw<?> O00000Oo3 = O00000Oo();
        if (O00000Oo3 != null) {
            return O00000Oo3;
        }
        for (ann next : ajq.O0000Ooo()) {
            if (ajt.O00000Oo().O0000oO0(next)) {
                if (next.O0000OOo() == 1 && next.O0000o0O().isAssignableFrom(O00000Oo2)) {
                    return amn.O000000o(ajt.O000000o(), O00000Oo2, next);
                }
                throw new IllegalArgumentException("Unsuitable method (" + next + ") decorated with @JsonCreator (for Enum type " + O00000Oo2.getName() + ")");
            }
        }
        return new amn(O000000o(O00000Oo2, ajt.O000000o(), ajq.O0000o0o()));
    }

    private ajw<?> O00000Oo() throws JsonMappingException {
        for (ali O00000o2 : this.O0000O0o.O00000oO()) {
            ajw<?> O00000o3 = O00000o2.O00000o();
            if (O00000o3 != null) {
                return O00000o3;
            }
        }
        return null;
    }

    public final ajw<?> O000000o(ajs ajs, ajv ajv, ajq ajq) throws JsonMappingException {
        ajw<?> ajw;
        Class<?> O00000Oo2 = ajv.O00000Oo();
        Iterator<ali> it = this.O0000O0o.O00000oO().iterator();
        while (true) {
            if (!it.hasNext()) {
                ajw = null;
                break;
            }
            ajw = it.next().O0000O0o();
            if (ajw != null) {
                break;
            }
        }
        return ajw != null ? ajw : amt.O000000o(O00000Oo2);
    }

    public final aof O00000Oo(ajs ajs, ajv ajv) throws JsonMappingException {
        ajv O000000o2;
        anj O00000o02 = ajs.O00000o0(ajv.O00000Oo()).O00000o0();
        AnnotationIntrospector O000000o3 = ajs.O000000o();
        aoh O000000o4 = O000000o3.O000000o(ajs, O00000o02, ajv);
        Collection<aod> collection = null;
        if (O000000o4 == null) {
            O000000o4 = ajs.O0000o00();
            if (O000000o4 == null) {
                return null;
            }
        } else {
            collection = ajs.O0000oO0().O000000o(O00000o02, ajs, O000000o3);
        }
        if (O000000o4.O000000o() == null && ajv.O00000o0() && (O000000o2 = O000000o(ajs, ajv)) != null && O000000o2.O00000Oo() != ajv.O00000Oo()) {
            O000000o4 = O000000o4.O000000o(O000000o2.O00000Oo());
        }
        return O000000o4.O000000o(ajs, ajv, collection);
    }

    public final aka O000000o(ajt ajt, ajv ajv) throws JsonMappingException {
        ajs O000000o2 = ajt.O000000o();
        if (this.O0000O0o.O000000o()) {
            O000000o2.O00000o0(ajv.O00000Oo());
            for (alj O000000o3 : this.O0000O0o.O00000oo()) {
                aka O000000o4 = O000000o3.O000000o();
                if (O000000o4 != null) {
                    return O000000o4;
                }
            }
        }
        Class<?> O00000Oo2 = ajv.O00000Oo();
        if (O00000Oo2 == String.class || O00000Oo2 == Object.class) {
            return amz.O000O0o.O000000o(ajv.O00000Oo());
        }
        aka aka = O00000o0.get(ajv);
        if (aka != null) {
            return aka;
        }
        if (ajv.O0000O0o()) {
            ajs O000000o5 = ajt.O000000o();
            ajq O00000Oo3 = O000000o5.O00000Oo(ajv);
            ajw<Object> O000000o6 = O000000o(ajt, O00000Oo3.O00000o0());
            if (O000000o6 != null) {
                return ana.O000000o(ajv, O000000o6);
            }
            Class<?> O00000Oo4 = ajv.O00000Oo();
            if (O00000Oo() != null) {
                return ana.O000000o(ajv, O000000o6);
            }
            asy<?> O000000o7 = O000000o(O00000Oo4, O000000o5, O00000Oo3.O0000o0o());
            for (ann next : O00000Oo3.O0000Ooo()) {
                if (O000000o5.O000000o().O0000oO0(next)) {
                    if (next.O0000OOo() != 1 || !next.O0000o0O().isAssignableFrom(O00000Oo4)) {
                        throw new IllegalArgumentException("Unsuitable method (" + next + ") decorated with @JsonCreator (for Enum type " + O00000Oo4.getName() + ")");
                    } else if (next.O000000o(0) == String.class) {
                        if (O000000o5.O0000OOo()) {
                            asw.O000000o((Member) next.O0000O0o());
                        }
                        return ana.O000000o(O000000o7, next);
                    } else {
                        throw new IllegalArgumentException("Parameter #0 type for factory method (" + next + ") not suitable, must be java.lang.String");
                    }
                }
            }
            return ana.O000000o(O000000o7);
        }
        ajq O00000Oo5 = O000000o2.O00000Oo(ajv);
        Constructor<?> O000000o8 = O00000Oo5.O000000o(String.class);
        if (O000000o8 != null) {
            if (O000000o2.O0000OOo()) {
                asw.O000000o((Member) O000000o8);
            }
            return new amz.O000O0OO(O000000o8);
        }
        Method O00000Oo6 = O00000Oo5.O00000Oo(String.class);
        if (O00000Oo6 == null) {
            return null;
        }
        if (O000000o2.O0000OOo()) {
            asw.O000000o((Member) O00000Oo6);
        }
        return new amz.O000O0o0(O00000Oo6);
    }

    private aof O000000o(ajs ajs, ajv ajv, anm anm) throws JsonMappingException {
        AnnotationIntrospector O000000o2 = ajs.O000000o();
        aoh<?> O000000o3 = O000000o2.O000000o(ajs, anm, ajv);
        if (O000000o3 == null) {
            return O00000Oo(ajs, ajv);
        }
        return O000000o3.O000000o(ajs, ajv, ajs.O0000oO0().O000000o(anm, ajs, O000000o2));
    }

    private aof O00000Oo(ajs ajs, ajv ajv, anm anm) throws JsonMappingException {
        AnnotationIntrospector O000000o2 = ajs.O000000o();
        aoh<?> O00000Oo2 = O000000o2.O00000Oo(ajs, anm, ajv);
        ajv O0000o0o = ajv.O0000o0o();
        if (O00000Oo2 == null) {
            return O00000Oo(ajs, O0000o0o);
        }
        return O00000Oo2.O000000o(ajs, O0000o0o, ajs.O0000oO0().O000000o(anm, ajs, O000000o2));
    }

    protected static ajw<Object> O000000o(ajt ajt, ani ani) throws JsonMappingException {
        Object O0000Ooo = ajt.O00000Oo().O0000Ooo(ani);
        if (O0000Ooo == null) {
            return null;
        }
        return ajt.O00000Oo(O0000Ooo);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    protected static <T extends _m_j.ajv> T O000000o(_m_j.ajt r5, _m_j.ani r6, T r7) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r5.O00000Oo()
            java.lang.Class r1 = r0.O0000o0O(r6)
            r2 = 0
            if (r1 == 0) goto L_0x0049
            _m_j.ajv r7 = r7.O000000o(r1)     // Catch:{ IllegalArgumentException -> 0x0010 }
            goto L_0x0049
        L_0x0010:
            r5 = move-exception
            com.fasterxml.jackson.databind.JsonMappingException r0 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to narrow type "
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r7 = " with concrete-type annotation (value "
            r3.append(r7)
            java.lang.String r7 = r1.getName()
            r3.append(r7)
            java.lang.String r7 = "), method '"
            r3.append(r7)
            java.lang.String r6 = r6.O00000Oo()
            r3.append(r6)
            java.lang.String r6 = "': "
            r3.append(r6)
            java.lang.String r6 = r5.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r0.<init>(r6, r2, r5)
            throw r0
        L_0x0049:
            boolean r1 = r7.O0000OoO()
            if (r1 == 0) goto L_0x0111
            java.lang.Class r1 = r0.O0000o0o(r6)
            java.lang.String r3 = "): "
            if (r1 == 0) goto L_0x00a7
            boolean r4 = r7 instanceof _m_j.asl
            if (r4 == 0) goto L_0x008e
            r4 = r7
            _m_j.asl r4 = (_m_j.asl) r4     // Catch:{ IllegalArgumentException -> 0x0063 }
            _m_j.ajv r7 = r4.O0000O0o(r1)     // Catch:{ IllegalArgumentException -> 0x0063 }
            goto L_0x00a7
        L_0x0063:
            r5 = move-exception
            com.fasterxml.jackson.databind.JsonMappingException r6 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to narrow key type "
            r0.<init>(r4)
            r0.append(r7)
            java.lang.String r7 = " with key-type annotation ("
            r0.append(r7)
            java.lang.String r7 = r1.getName()
            r0.append(r7)
            r0.append(r3)
            java.lang.String r7 = r5.getMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7, r2, r5)
            throw r6
        L_0x008e:
            com.fasterxml.jackson.databind.JsonMappingException r5 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Illegal key-type annotation: type "
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r7 = " is not a Map(-like) type"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x00a7:
            _m_j.ajv r1 = r7.O0000o0O()
            if (r1 == 0) goto L_0x00c3
            java.lang.Object r1 = r1.O0000oO0()
            if (r1 != 0) goto L_0x00c3
            java.lang.Object r1 = r0.O0000o00(r6)
            _m_j.aka r1 = r5.O00000o0(r1)
            if (r1 == 0) goto L_0x00c3
            _m_j.asl r7 = (_m_j.asl) r7
            _m_j.asl r7 = r7.O0000Oo0(r1)
        L_0x00c3:
            java.lang.Class r1 = r0.O0000o(r6)
            if (r1 == 0) goto L_0x00f9
            _m_j.ajv r7 = r7.O00000oO(r1)     // Catch:{ IllegalArgumentException -> 0x00ce }
            goto L_0x00f9
        L_0x00ce:
            r5 = move-exception
            com.fasterxml.jackson.databind.JsonMappingException r6 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to narrow content type "
            r0.<init>(r4)
            r0.append(r7)
            java.lang.String r7 = " with content-type annotation ("
            r0.append(r7)
            java.lang.String r7 = r1.getName()
            r0.append(r7)
            r0.append(r3)
            java.lang.String r7 = r5.getMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7, r2, r5)
            throw r6
        L_0x00f9:
            _m_j.ajv r1 = r7.O0000o0o()
            java.lang.Object r1 = r1.O0000oO0()
            if (r1 != 0) goto L_0x0111
            java.lang.Object r6 = r0.O0000o0(r6)
            _m_j.ajw r5 = r5.O00000Oo(r6)
            if (r5 == 0) goto L_0x0111
            _m_j.ajv r7 = r7.O00000o(r5)
        L_0x0111:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.akv.O000000o(_m_j.ajt, _m_j.ani, _m_j.ajv):_m_j.ajv");
    }

    /* access modifiers changed from: protected */
    public final ajv O000000o(ajt ajt, ajv ajv, anm anm) throws JsonMappingException {
        aof aof;
        aof O00000Oo2;
        aka O00000o02;
        if (ajv.O0000OoO()) {
            AnnotationIntrospector O00000Oo3 = ajt.O00000Oo();
            if (!(ajv.O0000o0O() == null || (O00000o02 = ajt.O00000o0(O00000Oo3.O0000o00(anm))) == null)) {
                ajv = ((asl) ajv).O0000Oo0(O00000o02);
            }
            ajw<Object> O00000Oo4 = ajt.O00000Oo(O00000Oo3.O0000o0(anm));
            if (O00000Oo4 != null) {
                ajv = ajv.O00000o(O00000Oo4);
            }
            if ((anm instanceof anm) && (O00000Oo2 = O00000Oo(ajt.O000000o(), ajv, anm)) != null) {
                ajv = ajv.O00000Oo(O00000Oo2);
            }
        }
        if (anm instanceof anm) {
            aof = O000000o(ajt.O000000o(), ajv, anm);
        } else {
            aof = O00000Oo(ajt.O000000o(), ajv);
        }
        return aof != null ? ajv.O000000o(aof) : ajv;
    }

    private static asy<?> O000000o(Class<?> cls, ajs ajs, ann ann) {
        if (ann != null) {
            Method O00000oo2 = ann.O00000oo();
            if (ajs.O0000OOo()) {
                asw.O000000o((Member) O00000oo2);
            }
            return asy.O000000o(cls, O00000oo2);
        } else if (ajs.O00000o0(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
            return asy.O000000o(cls);
        } else {
            return asy.O000000o(cls, ajs.O000000o());
        }
    }

    public final ajv O000000o(ajs ajs, ajv ajv) throws JsonMappingException {
        if (this.O0000O0o.O00000o0()) {
            Iterator<ajp> it = this.O0000O0o.O0000OOo().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        return ajv;
    }
}

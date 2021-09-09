package _m_j;

import _m_j.aih;
import _m_j.ajr;
import _m_j.aki;
import _m_j.ams;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class akz extends akv {
    public static final akz O0000OOo = new akz(new akp());
    private static final Class<?>[] O0000Oo = {Throwable.class};
    private static final Class<?>[] O0000OoO = new Class[0];

    private akz(akp akp) {
        super(akp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0180  */
    public final ajw<Object> O00000Oo(ajt ajt, ajv ajv, ajq ajq) throws JsonMappingException {
        ajw ajw;
        ajw<?> ajw2;
        ajw ajw3;
        ajv ajv2;
        alm O000000o2;
        ajs O000000o3 = ajt.O000000o();
        Iterator<ali> it = this.O0000O0o.O00000oO().iterator();
        while (true) {
            ajw = null;
            if (!it.hasNext()) {
                ajw2 = null;
                break;
            }
            ajw2 = it.next().O0000OOo();
            if (ajw2 != null) {
                break;
            }
        }
        if (ajw2 != null) {
            return ajw2;
        }
        if (ajv.O00000oO()) {
            aky O00000Oo = O00000Oo(ajt, ajq);
            O00000Oo.O000000o(O000000o(ajt, ajq));
            O00000Oo(ajt, ajq, O00000Oo);
            ann O000000o4 = ajq.O000000o("initCause", O0000Oo);
            if (!(O000000o4 == null || (O000000o2 = O000000o(ajt, ajq, new atg(O000000o4, "cause"), O000000o4.O000000o(0))) == null)) {
                O00000Oo.O000000o(O000000o2);
            }
            O00000Oo.O000000o("localizedMessage");
            O00000Oo.O000000o("suppressed");
            O00000Oo.O000000o("message");
            if (this.O0000O0o.O00000Oo()) {
                Iterator<ala> it2 = this.O0000O0o.O0000O0o().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            anf anf = new anf(O00000Oo.O00000oo());
            if (this.O0000O0o.O00000Oo()) {
                Iterator<ala> it3 = this.O0000O0o.O0000O0o().iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
            }
            return anf;
        }
        if (ajv.O00000o0()) {
            Iterator<ajp> it4 = this.O0000O0o.O0000OOo().iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        Class<?> O00000Oo2 = ajv.O00000Oo();
        ajw ajw4 = (ajw) f12425O000000o.get(new ash(O00000Oo2));
        if (ajw4 != null) {
            ajw = ajw4;
        } else if (AtomicReference.class.isAssignableFrom(O00000Oo2)) {
            ajv[] O00000Oo3 = O000000o3.O0000o0().O00000Oo(ajv, AtomicReference.class);
            if (O00000Oo3 == null || O00000Oo3.length <= 0) {
                ajv2 = asq.O00000Oo();
            } else {
                ajv2 = O00000Oo3[0];
            }
            ajw = new ams.O00000Oo(ajv2);
        } else {
            anh anh = this.O00000oo;
            Class<?> O00000Oo4 = ajv.O00000Oo();
            if (O00000Oo4.getName().startsWith("javax.xml.") || anh.O00000Oo(O00000Oo4, "javax.xml.")) {
                Object O000000o5 = anh.O000000o("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers");
                if (O000000o5 != null) {
                    Collection O000000o6 = ((ate) O000000o5).O000000o();
                    Iterator it5 = O000000o6.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            Iterator it6 = O000000o6.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                amy amy = (amy) it6.next();
                                if (amy.O00000oO().isAssignableFrom(O00000Oo4)) {
                                    ajw3 = amy;
                                    break;
                                }
                            }
                        } else {
                            amy amy2 = (amy) it5.next();
                            if (O00000Oo4 == amy2.O00000oO()) {
                                ajw3 = amy2;
                                break;
                            }
                        }
                    }
                    if (ajw3 != null) {
                        ajw = ajw3;
                    }
                }
            } else {
                if (anh.O000000o(O00000Oo4, "org.w3c.dom.Node")) {
                    ajw3 = (ajw) anh.O000000o("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer");
                } else if (anh.O000000o(O00000Oo4, "org.w3c.dom.Node")) {
                    ajw3 = (ajw) anh.O000000o("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer");
                }
                if (ajw3 != null) {
                }
            }
            ajw3 = null;
            if (ajw3 != null) {
            }
        }
        if (ajw != null) {
            return ajw;
        }
        Class<?> O00000Oo5 = ajv.O00000Oo();
        String O000000o7 = asw.O000000o(O00000Oo5);
        if (O000000o7 != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + O00000Oo5.getName() + " (of type " + O000000o7 + ") as a Bean");
        } else if (!asw.O00000o(O00000Oo5)) {
            String O00000Oo6 = asw.O00000Oo(O00000Oo5);
            if (O00000Oo6 == null) {
                return O00000o0(ajt, ajv, ajq);
            }
            throw new IllegalArgumentException("Can not deserialize Class " + O00000Oo5.getName() + " (of type " + O00000Oo6 + ") as a Bean");
        } else {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + O00000Oo5.getName() + " as a Bean");
        }
    }

    public final ajw<Object> O000000o(ajt ajt, ajv ajv, Class<?> cls) throws JsonMappingException {
        String str;
        ajv O000000o2 = ajt.O000000o(cls);
        ajs O000000o3 = ajt.O000000o();
        ajq O00000Oo = O000000o3.O0000Oo().O00000Oo(O000000o3, O000000o2, O000000o3);
        aln O000000o4 = O000000o(ajt, O00000Oo);
        ajs O000000o5 = ajt.O000000o();
        aky O00000Oo2 = O00000Oo(ajt, O00000Oo);
        O00000Oo2.O000000o(O000000o4);
        O00000Oo(ajt, O00000Oo, O00000Oo2);
        O000000o(ajt, O00000Oo, O00000Oo2);
        O00000o0(ajt, O00000Oo, O00000Oo2);
        O00000o(ajt, O00000Oo, O00000Oo2);
        aki.O000000o O0000oO = O00000Oo.O0000oO();
        if (O0000oO == null) {
            str = "build";
        } else {
            str = O0000oO.f12418O000000o;
        }
        ann O000000o6 = O00000Oo.O000000o(str, null);
        if (O000000o6 != null && O000000o5.O0000OOo()) {
            asw.O000000o((Member) O000000o6.O0000O0o());
        }
        O00000Oo2.O000000o(O000000o6, O0000oO);
        if (this.O0000O0o.O00000Oo()) {
            Iterator<ala> it = this.O0000O0o.O0000O0o().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        ajw<?> O000000o7 = O00000Oo2.O000000o(ajv, str);
        if (this.O0000O0o.O00000Oo()) {
            Iterator<ala> it2 = this.O0000O0o.O0000O0o().iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        return O000000o7;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    private ajw<Object> O00000o0(ajt ajt, ajv ajv, ajq ajq) throws JsonMappingException {
        ajw<Object> ajw;
        aln O000000o2 = O000000o(ajt, ajq);
        aky O00000Oo = O00000Oo(ajt, ajq);
        O00000Oo.O000000o(O000000o2);
        O00000Oo(ajt, ajq, O00000Oo);
        O000000o(ajt, ajq, O00000Oo);
        O00000o0(ajt, ajq, O00000Oo);
        O00000o(ajt, ajq, O00000Oo);
        if (this.O0000O0o.O00000Oo()) {
            Iterator<ala> it = this.O0000O0o.O0000O0o().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (ajv.O00000o0()) {
            if (!(O000000o2.O0000O0o() || O000000o2.O0000OOo() || O000000o2.O0000Oo0() || O000000o2.O00000Oo() || O000000o2.O00000o0() || O000000o2.O00000o() || O000000o2.O00000oO() || O000000o2.O00000oo())) {
                ajw = O00000Oo.O0000O0o();
                if (this.O0000O0o.O00000Oo()) {
                    Iterator<ala> it2 = this.O0000O0o.O0000O0o().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                return ajw;
            }
        }
        ajw = O00000Oo.O00000oo();
        if (this.O0000O0o.O00000Oo()) {
        }
        return ajw;
    }

    private static void O000000o(ajt ajt, ajq ajq, aky aky) throws JsonMappingException {
        ajv ajv;
        alm alm;
        aig aig;
        anz O00000o = ajq.O00000o();
        if (O00000o != null) {
            Class<? extends aig<?>> O00000o0 = O00000o.O00000o0();
            if (O00000o0 == aih.O00000o0.class) {
                String O000000o2 = O00000o.O000000o();
                alm = aky.O00000Oo(O000000o2);
                if (alm != null) {
                    ajv = alm.O000000o();
                    aig = new ama(O00000o.O00000Oo());
                } else {
                    throw new IllegalArgumentException("Invalid Object Id definition for " + ajq.O00000Oo().getName() + ": can not find property with name '" + O000000o2 + "'");
                }
            } else {
                ajv = ajt.O0000O0o().O00000Oo(ajt.O000000o((Class<?>) O00000o0), aig.class)[0];
                alm = null;
                aig = ajt.O000000o(O00000o);
            }
            aky.O000000o(alx.O000000o(ajv, O00000o.O000000o(), aig, ajt.O000000o(ajv), alm));
        }
    }

    private static aky O00000Oo(ajt ajt, ajq ajq) {
        return new aky(ajq, ajt.O000000o());
    }

    private void O00000Oo(ajt ajt, ajq ajq, aky aky) throws JsonMappingException {
        Set<String> O0000Oo2;
        AnnotationIntrospector O00000Oo = ajt.O00000Oo();
        Boolean O00000Oo2 = O00000Oo.O00000Oo(ajq.O00000o0());
        if (O00000Oo2 != null) {
            aky.O000000o(O00000Oo2.booleanValue());
        }
        HashSet<String> O000000o2 = asu.O000000o(O00000Oo.O00000Oo((ani) ajq.O00000o0()));
        for (String O000000o3 : O000000o2) {
            aky.O000000o(O000000o3);
        }
        ann O0000o0O = ajq.O0000o0O();
        if (O0000o0O != null) {
            aky.O000000o(O000000o(ajt, ajq, O0000o0O));
        }
        if (O0000o0O == null && (O0000Oo2 = ajq.O0000Oo()) != null) {
            for (String O000000o4 : O0000Oo2) {
                aky.O000000o(O000000o4);
            }
        }
        boolean z = ajt.O000000o(MapperFeature.USE_GETTERS_AS_SETTERS) && ajt.O000000o(MapperFeature.AUTO_DETECT_GETTERS);
        List<anu> O000000o5 = O000000o(ajt, aky, ajq.O0000OOo(), O000000o2);
        if (this.O0000O0o.O00000Oo()) {
            Iterator<ala> it = this.O0000O0o.O0000O0o().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        for (anu next : O000000o5) {
            if (!next.O0000O0o()) {
                alm alm = null;
                if (next.O00000oO()) {
                    alm = O000000o(ajt, ajq, next, next.O0000Oo0().O000000o(0));
                } else if (next.O00000oo()) {
                    alm = O000000o(ajt, ajq, next, next.O0000Oo().O00000o0());
                } else if (z && next.O00000o()) {
                    Class<?> O00000o = next.O0000OOo().O00000o();
                    if (Collection.class.isAssignableFrom(O00000o) || Map.class.isAssignableFrom(O00000o)) {
                        alm = O000000o(ajt, ajq, next);
                    }
                }
                if (alm != null) {
                    Class<?>[] O0000o00 = next.O0000o00();
                    if (O0000o00 == null && !ajt.O000000o(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                        O0000o00 = O0000OoO;
                    }
                    alm.O000000o(O0000o00);
                    aky.O00000Oo(alm);
                }
            }
        }
    }

    private static List<anu> O000000o(ajt ajt, aky aky, List<anu> list, Set<String> set) throws JsonMappingException {
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap hashMap = new HashMap();
        for (anu next : list) {
            String O000000o2 = next.O000000o();
            if (!set.contains(O000000o2)) {
                if (!next.O0000O0o()) {
                    Class<?> cls = null;
                    if (next.O00000oO()) {
                        cls = next.O0000Oo0().O0000o0();
                    } else if (next.O00000oo()) {
                        cls = next.O0000Oo().O00000o();
                    }
                    if (cls != null && O000000o(ajt.O000000o(), cls, hashMap)) {
                        aky.O000000o(O000000o2);
                    }
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private void O00000o0(ajt ajt, ajq ajq, aky aky) throws JsonMappingException {
        Type type;
        Map<String, anm> O0000Oo0 = ajq.O0000Oo0();
        if (O0000Oo0 != null) {
            for (Map.Entry next : O0000Oo0.entrySet()) {
                String str = (String) next.getKey();
                anm anm = (anm) next.getValue();
                if (anm instanceof ann) {
                    type = ((ann) anm).O000000o(0);
                } else {
                    type = anm.O00000o();
                }
                aky.O000000o(str, O000000o(ajt, ajq, new atg(anm), type));
            }
        }
    }

    private static void O00000o(ajt ajt, ajq ajq, aky aky) throws JsonMappingException {
        Map<Object, anm> O0000o = ajq.O0000o();
        if (O0000o != null) {
            boolean O00000oO = ajt.O00000oO();
            for (Map.Entry next : O0000o.entrySet()) {
                anm anm = (anm) next.getValue();
                if (O00000oO) {
                    asw.O000000o(anm.O0000OoO());
                }
                aky.O000000o(anm.O00000Oo(), ajq.O000000o(anm.O00000o0()), ajq.O0000O0o(), anm, next.getKey());
            }
        }
    }

    private all O000000o(ajt ajt, ajq ajq, ann ann) throws JsonMappingException {
        if (ajt.O00000oO()) {
            asw.O000000o(ann.O0000OoO());
        }
        ajv O000000o2 = ajq.O00000oo().O000000o(ann.O000000o(1));
        ajr.O000000o o000000o = new ajr.O000000o(ann.O00000Oo(), O000000o2, ajq.O0000O0o(), ann);
        ajv O000000o3 = O000000o(ajt, O000000o2, ann);
        ajw<Object> O000000o4 = O000000o(ajt, ann);
        if (O000000o4 != null) {
            return new all(o000000o, ann, O000000o3, O000000o4);
        }
        return new all(o000000o, ann, O000000o(ajt, ann, O000000o3), (ajw<Object>) null);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:10:0x005b */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r10v3, types: [_m_j.alm] */
    /* JADX WARN: Type inference failed for: r10v4, types: [_m_j.alm] */
    /* JADX WARN: Type inference failed for: r3v3, types: [_m_j.als] */
    /* JADX WARN: Type inference failed for: r3v4, types: [_m_j.alv] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
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
    /* JADX WARNING: Multi-variable type inference failed */
    private _m_j.alm O000000o(_m_j.ajt r10, _m_j.ajq r11, _m_j.anu r12, java.lang.reflect.Type r13) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r9 = this;
            _m_j.anm r0 = r12.O0000Ooo()
            boolean r1 = r10.O00000oO()
            if (r1 == 0) goto L_0x0011
            java.lang.reflect.Member r1 = r0.O0000OoO()
            _m_j.asw.O000000o(r1)
        L_0x0011:
            _m_j.ajv r13 = r11.O000000o(r13)
            _m_j.ajr$O000000o r1 = new _m_j.ajr$O000000o
            java.lang.String r2 = r12.O000000o()
            _m_j.ast r3 = r11.O0000O0o()
            r1.<init>(r2, r13, r3, r0)
            _m_j.ajv r2 = r9.O000000o(r10, r13, r0)
            if (r2 == r13) goto L_0x002b
            r1.O000000o(r2)
        L_0x002b:
            _m_j.ajw r13 = O000000o(r10, r0)
            _m_j.ajv r5 = O000000o(r10, r0, r2)
            java.lang.Object r10 = r5.O0000oO()
            r6 = r10
            _m_j.aof r6 = (_m_j.aof) r6
            boolean r10 = r0 instanceof _m_j.ann
            if (r10 == 0) goto L_0x004d
            _m_j.alv r10 = new _m_j.alv
            _m_j.ast r7 = r11.O0000O0o()
            r8 = r0
            _m_j.ann r8 = (_m_j.ann) r8
            r3 = r10
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x005b
        L_0x004d:
            _m_j.als r10 = new _m_j.als
            _m_j.ast r7 = r11.O0000O0o()
            r8 = r0
            _m_j.anl r8 = (_m_j.anl) r8
            r3 = r10
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x005b:
            if (r13 == 0) goto L_0x0061
            _m_j.alm r10 = r10.O00000Oo(r13)
        L_0x0061:
            com.fasterxml.jackson.databind.AnnotationIntrospector$ReferenceProperty r11 = r12.O0000o0()
            if (r11 == 0) goto L_0x0072
            boolean r12 = r11.O000000o()
            if (r12 == 0) goto L_0x0072
            java.lang.String r11 = r11.f3600O000000o
            r10.O00000Oo(r11)
        L_0x0072:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.akz.O000000o(_m_j.ajt, _m_j.ajq, _m_j.anu, java.lang.reflect.Type):_m_j.alm");
    }

    private static alm O000000o(ajt ajt, ajq ajq, anu anu) throws JsonMappingException {
        ann O0000OOo2 = anu.O0000OOo();
        if (ajt.O00000oO()) {
            asw.O000000o(O0000OOo2.O0000OoO());
        }
        ajv O000000o2 = O0000OOo2.O000000o(ajq.O00000oo());
        ajw<Object> O000000o3 = O000000o(ajt, O0000OOo2);
        ajv O000000o4 = O000000o(ajt, O0000OOo2, O000000o2);
        ame ame = new ame(anu, O000000o4, (aof) O000000o4.O0000oO(), ajq.O0000O0o(), O0000OOo2);
        return O000000o3 != null ? ame.O00000Oo(O000000o3) : ame;
    }

    private static boolean O000000o(ajs ajs, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = map.get(cls);
        if (bool == null) {
            bool = ajs.O000000o().O00000o0(ajs.O00000o0(cls).O00000o0());
            if (bool == null) {
                bool = Boolean.FALSE;
            }
        }
        return bool.booleanValue();
    }
}

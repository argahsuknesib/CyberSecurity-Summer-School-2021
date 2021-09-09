package _m_j;

import _m_j.arp;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.TimeZone;

public abstract class apr extends aqf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final HashMap<String, ajz<?>> f12515O000000o = new HashMap<>();
    protected static final HashMap<String, Class<? extends ajz<?>>> O00000Oo = new HashMap<>();
    protected anh O00000o = anh.f12481O000000o;
    protected final akt O00000o0 = new akt();

    /* access modifiers changed from: protected */
    public abstract Iterable<aqg> O000000o();

    static {
        f12515O000000o.put(String.class.getName(), new asc());
        ase ase = ase.f12568O000000o;
        f12515O000000o.put(StringBuffer.class.getName(), ase);
        f12515O000000o.put(StringBuilder.class.getName(), ase);
        f12515O000000o.put(Character.class.getName(), ase);
        f12515O000000o.put(Character.TYPE.getName(), ase);
        HashMap<String, ajz<?>> hashMap = f12515O000000o;
        arp.O00000o o00000o = new arp.O00000o();
        hashMap.put(Integer.class.getName(), o00000o);
        hashMap.put(Integer.TYPE.getName(), o00000o);
        hashMap.put(Long.class.getName(), arp.O0000O0o.f12553O000000o);
        hashMap.put(Long.TYPE.getName(), arp.O0000O0o.f12553O000000o);
        hashMap.put(Byte.class.getName(), arp.O00000o0.f12552O000000o);
        hashMap.put(Byte.TYPE.getName(), arp.O00000o0.f12552O000000o);
        hashMap.put(Short.class.getName(), arp.O00000o0.f12552O000000o);
        hashMap.put(Short.TYPE.getName(), arp.O00000o0.f12552O000000o);
        hashMap.put(Float.class.getName(), arp.O00000Oo.f12551O000000o);
        hashMap.put(Float.TYPE.getName(), arp.O00000Oo.f12551O000000o);
        hashMap.put(Double.class.getName(), arp.O000000o.f12550O000000o);
        hashMap.put(Double.TYPE.getName(), arp.O000000o.f12550O000000o);
        f12515O000000o.put(Boolean.TYPE.getName(), new arb(true));
        f12515O000000o.put(Boolean.class.getName(), new arb(false));
        arp.O0000OOo o0000OOo = new arp.O0000OOo();
        f12515O000000o.put(BigInteger.class.getName(), o0000OOo);
        f12515O000000o.put(BigDecimal.class.getName(), o0000OOo);
        f12515O000000o.put(Calendar.class.getName(), arc.f12542O000000o);
        are are = are.f12543O000000o;
        f12515O000000o.put(Date.class.getName(), are);
        f12515O000000o.put(Timestamp.class.getName(), are);
        f12515O000000o.put(java.sql.Date.class.getName(), new art());
        f12515O000000o.put(Time.class.getName(), new aru());
        for (Map.Entry next : new arx().O000000o()) {
            Object value = next.getValue();
            if (value instanceof ajz) {
                f12515O000000o.put(((Class) next.getKey()).getName(), (ajz) value);
            } else if (value instanceof Class) {
                O00000Oo.put(((Class) next.getKey()).getName(), (Class) value);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + next.getClass().getName());
            }
        }
        O00000Oo.put(ath.class.getName(), asf.class);
    }

    protected apr(akt akt) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0021  */
    public final ajz<Object> O000000o(ake ake, ajv ajv) {
        ajz<?> ajz = null;
        if (!this.O00000o0.O000000o()) {
            return null;
        }
        ake.O00000o0(ajv.O00000Oo());
        Iterator<aqg> it = this.O00000o0.O00000o().iterator();
        while (it.hasNext() && (ajz = it.next().O000000o()) == null) {
            while (it.hasNext()) {
                while (it.hasNext()) {
                }
            }
        }
        return ajz;
    }

    public final aoi O00000Oo(ake ake, ajv ajv) {
        Collection<aod> collection;
        anj O00000o02 = ake.O00000o0(ajv.O00000Oo()).O00000o0();
        AnnotationIntrospector O000000o2 = ake.O000000o();
        aoh<?> O000000o3 = O000000o2.O000000o(ake, O00000o02, ajv);
        if (O000000o3 == null) {
            O000000o3 = ake.O0000o00();
            collection = null;
        } else {
            collection = ake.O0000oO0().O000000o(O00000o02, ake, O000000o2);
        }
        if (O000000o3 == null) {
            return null;
        }
        return O000000o3.O000000o(ake, ajv, collection);
    }

    protected static ajz<?> O000000o(ajv ajv) {
        String name = ajv.O00000Oo().getName();
        ajz<?> ajz = f12515O000000o.get(name);
        if (ajz != null) {
            return ajz;
        }
        Class cls = O00000Oo.get(name);
        if (cls == null) {
            return null;
        }
        try {
            return (ajz) cls.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate standard serializer (of type " + cls.getName() + "): " + e.getMessage(), e);
        }
    }

    protected static ajz<?> O000000o(akf akf, ajv ajv, ajq ajq) throws JsonMappingException {
        if (ajy.class.isAssignableFrom(ajv.O00000Oo())) {
            return ars.f12556O000000o;
        }
        ann O0000o0o = ajq.O0000o0o();
        if (O0000o0o == null) {
            return null;
        }
        Method O00000oo = O0000o0o.O00000oo();
        if (akf.O00000Oo()) {
            asw.O000000o((Member) O00000oo);
        }
        return new arl(O00000oo, O000000o(akf, O0000o0o));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
    public final ajz<?> O000000o(akf akf, ajv ajv) throws JsonMappingException {
        ajz<?> ajz;
        Class<?> O00000Oo2 = ajv.O00000Oo();
        if (InetAddress.class.isAssignableFrom(O00000Oo2)) {
            return arj.f12546O000000o;
        }
        if (TimeZone.class.isAssignableFrom(O00000Oo2)) {
            return asd.f12567O000000o;
        }
        if (Charset.class.isAssignableFrom(O00000Oo2)) {
            return ase.f12568O000000o;
        }
        anh anh = this.O00000o;
        Class<?> O00000Oo3 = ajv.O00000Oo();
        if (O00000Oo3.getName().startsWith("javax.xml.") || anh.O00000Oo(O00000Oo3, "javax.xml.")) {
            Object O000000o2 = anh.O000000o("com.fasterxml.jackson.databind.ext.CoreXMLSerializers");
            if (O000000o2 != null) {
                Collection O000000o3 = ((ate) O000000o2).O000000o();
                Iterator it = O000000o3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator it2 = O000000o3.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it2.next();
                            if (((Class) entry.getKey()).isAssignableFrom(O00000Oo3)) {
                                ajz = (ajz) entry.getValue();
                                break;
                            }
                        }
                    } else {
                        Map.Entry entry2 = (Map.Entry) it.next();
                        if (O00000Oo3 == entry2.getKey()) {
                            ajz = (ajz) entry2.getValue();
                            break;
                        }
                    }
                }
                if (ajz != null) {
                    return ajz;
                }
                if (Number.class.isAssignableFrom(O00000Oo2)) {
                    return arp.O0000OOo.f12554O000000o;
                }
                if (Enum.class.isAssignableFrom(O00000Oo2)) {
                    return arh.O000000o(O00000Oo2, akf.O000000o());
                }
                if (Calendar.class.isAssignableFrom(O00000Oo2)) {
                    return arc.f12542O000000o;
                }
                if (Date.class.isAssignableFrom(O00000Oo2)) {
                    return are.f12543O000000o;
                }
                return null;
            }
        } else if (anh.O000000o(O00000Oo3, "org.w3c.dom.Node")) {
            ajz = (ajz) anh.O000000o("com.fasterxml.jackson.databind.ext.DOMSerializer");
            if (ajz != null) {
            }
        }
        ajz = null;
        if (ajz != null) {
        }
    }

    /* access modifiers changed from: protected */
    public final ajz<?> O000000o(ake ake, ajv ajv, ajq ajq) throws JsonMappingException {
        Class<?> O00000Oo2 = ajv.O00000Oo();
        if (Iterator.class.isAssignableFrom(O00000Oo2)) {
            ajv O000000o2 = ajv.O000000o(0);
            if (O000000o2 == null) {
                O000000o2 = asq.O00000Oo();
            }
            aoi O00000Oo3 = O00000Oo(ake, O000000o2);
            return new aql(O000000o2, O000000o(ake, ajq, O00000Oo3, null), O00000Oo3, null);
        } else if (Iterable.class.isAssignableFrom(O00000Oo2)) {
            ajv O000000o3 = ajv.O000000o(0);
            if (O000000o3 == null) {
                O000000o3 = asq.O00000Oo();
            }
            aoi O00000Oo4 = O00000Oo(ake, O000000o3);
            return new ark(O000000o3, O000000o(ake, ajq, O00000Oo4, null), O00000Oo4, null);
        } else if (CharSequence.class.isAssignableFrom(O00000Oo2)) {
            return ase.f12568O000000o;
        } else {
            return null;
        }
    }

    protected static ajz<Object> O000000o(akf akf, ani ani) throws JsonMappingException {
        Object O00000oO = akf.O00000o0().O00000oO(ani);
        if (O00000oO == null) {
            return null;
        }
        return akf.O000000o(O00000oO);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ef  */
    public final ajz<?> O000000o(akf akf, ajv ajv, ajq ajq, ajr ajr, boolean z) throws JsonMappingException {
        ajz<Object> ajz;
        ajz<Object> ajz2;
        asz asz;
        ajz<Object> ajz3;
        anm O00000Oo2;
        Object O00000oo;
        ajz<Object> ajz4;
        anm O00000Oo3;
        Object O0000O0o;
        ake O000000o2 = akf.O000000o();
        aoi O00000Oo4 = O00000Oo(O000000o2, ajv.O0000o0o());
        boolean z2 = O00000Oo4 != null ? false : z;
        anj O00000o02 = ajq.O00000o0();
        AnnotationIntrospector O00000o03 = akf.O00000o0();
        if (ajr == null || (O00000Oo3 = ajr.O00000Oo()) == null || (O0000O0o = O00000o03.O0000O0o(O00000Oo3)) == null) {
            Object O0000O0o2 = O00000o03.O0000O0o((ani) O00000o02);
            if (O0000O0o2 != null) {
                ajz4 = akf.O000000o(O0000O0o2);
            } else {
                ajz = null;
                if (!ajv.O0000o00()) {
                    asl asl = (asl) ajv;
                    anj O00000o04 = ajq.O00000o0();
                    AnnotationIntrospector O00000o05 = akf.O00000o0();
                    if (ajr == null || (O00000Oo2 = ajr.O00000Oo()) == null || (O00000oo = O00000o05.O00000oo((ani) O00000Oo2)) == null) {
                        Object O00000oo2 = O00000o05.O00000oo((ani) O00000o04);
                        if (O00000oo2 != null) {
                            ajz3 = akf.O000000o(O00000oo2);
                        } else {
                            ajz2 = null;
                            if (!asl.O0000oOo()) {
                                asm asm = (asm) asl;
                                for (aqg O00000o2 : O000000o()) {
                                    ajz<?> O00000o3 = O00000o2.O00000o();
                                    if (O00000o3 != null) {
                                        return O00000o3;
                                    }
                                }
                                if (!EnumMap.class.isAssignableFrom(asm.O00000Oo())) {
                                    return arm.O000000o(O000000o2.O000000o().O00000Oo((ani) ajq.O00000o0()), asm, z2, O00000Oo4, ajz2, ajz);
                                }
                                ajv O0000o0O = asm.O0000o0O();
                                if (O0000o0O.O0000O0o()) {
                                    asz = asz.O000000o(O0000o0O.O00000Oo(), O000000o2.O000000o());
                                } else {
                                    asz = null;
                                }
                                return new arg(asm.O0000o0o(), z2, asz, O00000Oo4, ajz);
                            }
                            for (aqg O00000oO : O000000o()) {
                                ajz<?> O00000oO2 = O00000oO.O00000oO();
                                if (O00000oO2 != null) {
                                    return O00000oO2;
                                }
                            }
                            return null;
                        }
                    } else {
                        ajz3 = akf.O000000o(O00000oo);
                    }
                    ajz2 = ajz3;
                    if (!asl.O0000oOo()) {
                    }
                } else if (ajv.O0000Ooo()) {
                    asi asi = (asi) ajv;
                    if (asi.O0000oOo()) {
                        asj asj = (asj) asi;
                        for (aqg O00000Oo5 : O000000o()) {
                            ajz<?> O00000Oo6 = O00000Oo5.O00000Oo();
                            if (O00000Oo6 != null) {
                                return O00000Oo6;
                            }
                        }
                        Class<?> O00000Oo7 = asj.O00000Oo();
                        if (EnumSet.class.isAssignableFrom(O00000Oo7)) {
                            ajv O0000o0o = asj.O0000o0o();
                            if (!O0000o0o.O0000O0o()) {
                                O0000o0o = null;
                            }
                            return new ari(O0000o0o);
                        }
                        Class<?> O00000Oo8 = asj.O0000o0o().O00000Oo();
                        if (RandomAccess.class.isAssignableFrom(O00000Oo7)) {
                            if (O00000Oo8 != String.class || (ajz != null && !asw.O000000o(ajz))) {
                                return new aqj(asj.O0000o0o(), z2, O00000Oo4, null, ajz);
                            }
                            return aqk.f12524O000000o;
                        } else if (O00000Oo8 != String.class || (ajz != null && !asw.O000000o(ajz))) {
                            return new ard(asj.O0000o0o(), z2, O00000Oo4, null, ajz);
                        } else {
                            return aqs.f12536O000000o;
                        }
                    } else {
                        for (aqg O00000o06 : O000000o()) {
                            ajz<?> O00000o07 = O00000o06.O00000o0();
                            if (O00000o07 != null) {
                                return O00000o07;
                            }
                        }
                        return null;
                    }
                } else if (!ajv.O00000oo()) {
                    return null;
                } else {
                    asg asg = (asg) ajv;
                    Class<?> O00000Oo9 = asg.O00000Oo();
                    if (ajz == null || asw.O000000o(ajz)) {
                        if (String[].class == O00000Oo9) {
                            return aqr.f12535O000000o;
                        }
                        ajz<?> O000000o3 = arw.O000000o(O00000Oo9);
                        if (O000000o3 != null) {
                            return O000000o3;
                        }
                    }
                    return new arq(asg.O0000o0o(), z2, O00000Oo4, ajz);
                }
            }
        } else {
            ajz4 = akf.O000000o(O0000O0o);
        }
        ajz = ajz4;
        if (!ajv.O0000o00()) {
        }
    }

    protected static <T extends ajv> T O000000o(ake ake, ani ani, ajv ajv) {
        Class<?> O0000OOo = ake.O000000o().O0000OOo(ani);
        if (O0000OOo != null) {
            try {
                ajv = ajv.O00000o0(O0000OOo);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to widen type " + ajv + " with concrete-type annotation (value " + O0000OOo.getName() + "), method '" + ani.O00000Oo() + "': " + e.getMessage());
            }
        }
        return O00000Oo(ake, ani, ajv);
    }

    protected static <T extends ajv> T O00000Oo(ake ake, ani ani, ajv ajv) {
        AnnotationIntrospector O000000o2 = ake.O000000o();
        if (!ajv.O0000OoO()) {
            return ajv;
        }
        Class<?> O0000Oo0 = O000000o2.O0000Oo0(ani);
        if (O0000Oo0 != null) {
            if (ajv instanceof asm) {
                try {
                    ajv = ((asm) ajv).O0000OOo(O0000Oo0);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Failed to narrow key type " + ajv + " with key-type annotation (" + O0000Oo0.getName() + "): " + e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("Illegal key-type annotation: type " + ajv + " is not a Map type");
            }
        }
        Class<?> O0000Oo = O000000o2.O0000Oo(ani);
        if (O0000Oo == null) {
            return ajv;
        }
        try {
            return ajv.O00000oo(O0000Oo);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Failed to narrow content type " + ajv + " with content-type annotation (" + O0000Oo.getName() + "): " + e2.getMessage());
        }
    }

    protected static boolean O000000o(ake ake, ajq ajq, aoi aoi, ajr ajr) {
        if (aoi != null) {
            return false;
        }
        AnnotationIntrospector O000000o2 = ake.O000000o();
        JsonSerialize.Typing O0000OoO = O000000o2.O0000OoO(ajq.O00000o0());
        if (O0000OoO != null) {
            if (O0000OoO == JsonSerialize.Typing.STATIC) {
                return true;
            }
        } else if (ake.O000000o(MapperFeature.USE_STATIC_TYPING)) {
            return true;
        }
        if (ajr != null) {
            ajv O000000o3 = ajr.O000000o();
            if (O000000o3.O0000OoO()) {
                if (O000000o2.O0000Oo(ajr.O00000Oo()) != null) {
                    return true;
                }
                if (!(O000000o3 instanceof asm) || O000000o2.O0000Oo0(ajr.O00000Oo()) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}

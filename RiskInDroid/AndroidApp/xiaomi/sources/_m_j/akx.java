package _m_j;

import _m_j.aih;
import _m_j.ajr;
import _m_j.alr;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class akx extends amy<Object> implements alc, alk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ast f12427O000000o;
    protected final ajv O00000Oo;
    protected ajw<Object> O00000o;
    protected final aln O00000o0;
    protected alz O00000oO;
    protected boolean O00000oo;
    protected boolean O0000O0o;
    protected final alp O0000OOo;
    protected all O0000Oo;
    protected final amh[] O0000Oo0;
    protected final HashSet<String> O0000OoO;
    protected final boolean O0000Ooo;
    protected alr O0000o;
    protected final Map<String, alm> O0000o0;
    protected final boolean O0000o00;
    protected HashMap<ash, ajw<Object>> O0000o0O;
    protected amg O0000o0o;
    protected final alx O0000oO0;

    public abstract akx O000000o(alx alx);

    public abstract akx O000000o(HashSet<String> hashSet);

    public final boolean O00000o0() {
        return true;
    }

    protected akx(aky aky, ajq ajq, alp alp, Map<String, alm> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(ajq.O000000o());
        this.f12427O000000o = ajq.O00000o0().O0000O0o();
        this.O00000Oo = ajq.O000000o();
        this.O00000o0 = aky.O00000Oo();
        this.O0000OOo = alp;
        this.O0000o0 = map;
        this.O0000OoO = hashSet;
        this.O0000Ooo = z;
        this.O0000Oo = aky.O000000o();
        List<amh> O00000o02 = aky.O00000o0();
        this.O0000Oo0 = (O00000o02 == null || O00000o02.isEmpty()) ? null : (amh[]) O00000o02.toArray(new amh[O00000o02.size()]);
        this.O0000oO0 = aky.O00000o();
        boolean z3 = false;
        this.O00000oo = this.O0000o0o != null || this.O00000o0.O0000OOo() || this.O00000o0.O0000Oo0() || !this.O00000o0.O0000O0o();
        this.O0000o00 = z2;
        if (!this.O00000oo && this.O0000Oo0 == null && !this.O0000o00 && this.O0000oO0 != null) {
            z3 = true;
        }
        this.O0000O0o = z3;
    }

    protected akx(akx akx, boolean z) {
        super(akx.O00000Oo);
        this.f12427O000000o = akx.f12427O000000o;
        this.O00000Oo = akx.O00000Oo;
        this.O00000o0 = akx.O00000o0;
        this.O00000o = akx.O00000o;
        this.O00000oO = akx.O00000oO;
        this.O0000OOo = akx.O0000OOo;
        this.O0000o0 = akx.O0000o0;
        this.O0000OoO = akx.O0000OoO;
        this.O0000Ooo = z;
        this.O0000Oo = akx.O0000Oo;
        this.O0000Oo0 = akx.O0000Oo0;
        this.O0000oO0 = akx.O0000oO0;
        this.O00000oo = akx.O00000oo;
        this.O0000o0o = akx.O0000o0o;
        this.O0000o00 = akx.O0000o00;
        this.O0000O0o = akx.O0000O0o;
    }

    protected akx(akx akx, atb atb) {
        super(akx.O00000Oo);
        ajw<Object> O000000o2;
        this.f12427O000000o = akx.f12427O000000o;
        this.O00000Oo = akx.O00000Oo;
        this.O00000o0 = akx.O00000o0;
        this.O00000o = akx.O00000o;
        this.O00000oO = akx.O00000oO;
        this.O0000o0 = akx.O0000o0;
        this.O0000OoO = akx.O0000OoO;
        this.O0000Ooo = atb != null || akx.O0000Ooo;
        this.O0000Oo = akx.O0000Oo;
        this.O0000Oo0 = akx.O0000Oo0;
        this.O0000oO0 = akx.O0000oO0;
        this.O00000oo = akx.O00000oo;
        this.O0000o0o = akx.O0000o0o;
        if (atb != null) {
            amg amg = this.O0000o0o;
            if (amg != null) {
                amg.O000000o(atb);
            }
            alp alp = akx.O0000OOo;
            if (!(atb == null || atb == atb.f12582O000000o)) {
                Iterator<alm> it = alp.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    alm next = it.next();
                    alm O000000o3 = next.O000000o(atb.O000000o(next.O00000o()));
                    ajw<Object> O0000OOo2 = O000000o3.O0000OOo();
                    if (!(O0000OOo2 == null || (O000000o2 = O0000OOo2.O000000o(atb)) == O0000OOo2)) {
                        O000000o3 = O000000o3.O00000Oo(O000000o2);
                    }
                    arrayList.add(O000000o3);
                }
                alp = new alp(arrayList);
            }
            this.O0000OOo = alp;
        } else {
            this.O0000OOo = akx.O0000OOo;
        }
        this.O0000o00 = akx.O0000o00;
        this.O0000O0o = false;
    }

    public akx(akx akx, alx alx) {
        super(akx.O00000Oo);
        this.f12427O000000o = akx.f12427O000000o;
        this.O00000Oo = akx.O00000Oo;
        this.O00000o0 = akx.O00000o0;
        this.O00000o = akx.O00000o;
        this.O00000oO = akx.O00000oO;
        this.O0000o0 = akx.O0000o0;
        this.O0000OoO = akx.O0000OoO;
        this.O0000Ooo = akx.O0000Ooo;
        this.O0000Oo = akx.O0000Oo;
        this.O0000Oo0 = akx.O0000Oo0;
        this.O00000oo = akx.O00000oo;
        this.O0000o0o = akx.O0000o0o;
        this.O0000o00 = akx.O0000o00;
        this.O0000O0o = akx.O0000O0o;
        this.O0000oO0 = alx;
        if (alx == null) {
            this.O0000OOo = akx.O0000OOo;
        } else {
            this.O0000OOo = akx.O0000OOo.O000000o(new aly(alx));
        }
    }

    public akx(akx akx, HashSet<String> hashSet) {
        super(akx.O00000Oo);
        this.f12427O000000o = akx.f12427O000000o;
        this.O00000Oo = akx.O00000Oo;
        this.O00000o0 = akx.O00000o0;
        this.O00000o = akx.O00000o;
        this.O00000oO = akx.O00000oO;
        this.O0000o0 = akx.O0000o0;
        this.O0000OoO = hashSet;
        this.O0000Ooo = akx.O0000Ooo;
        this.O0000Oo = akx.O0000Oo;
        this.O0000Oo0 = akx.O0000Oo0;
        this.O00000oo = akx.O00000oo;
        this.O0000o0o = akx.O0000o0o;
        this.O0000o00 = akx.O0000o00;
        this.O0000O0o = akx.O0000O0o;
        this.O0000oO0 = akx.O0000oO0;
        this.O0000OOo = akx.O0000OOo;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: _m_j.alm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: _m_j.alu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: _m_j.alu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: _m_j.alm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: _m_j.alm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: _m_j.alu} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.akx.O000000o(_m_j.ajt, _m_j.alm):_m_j.alm
     arg types: [_m_j.ajt, _m_j.alu]
     candidates:
      _m_j.akx.O000000o(_m_j.ajt, _m_j.ajr):_m_j.ajw<?>
      _m_j.akx.O000000o(_m_j.ajt, java.lang.Object):void
      _m_j.akx.O000000o(java.lang.Throwable, _m_j.ajt):void
      _m_j.ajw.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajt):T
      _m_j.alc.O000000o(_m_j.ajt, _m_j.ajr):_m_j.ajw<?>
      _m_j.akx.O000000o(_m_j.ajt, _m_j.alm):_m_j.alm */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014e  */
    public final void O000000o(ajt ajt) throws JsonMappingException {
        alr.O000000o o000000o;
        alm alm;
        String O00000oO2;
        alu alu;
        anm O00000Oo2;
        alm alm2;
        atb O00000Oo3;
        ajw<Object> O0000OOo2;
        ajw<Object> O000000o2;
        boolean z;
        alm alm3;
        String str;
        ajw<?> O000000o3;
        alm O00000Oo4;
        ajt ajt2 = ajt;
        if (this.O00000o0.O0000Oo0()) {
            this.O00000oO = alz.O000000o(ajt2, this.O00000o0, this.O00000o0.O000000o(ajt.O000000o()));
            o000000o = null;
            for (alm next : this.O00000oO.O000000o()) {
                if (next.O0000O0o()) {
                    aof O0000Oo02 = next.O0000Oo0();
                    if (O0000Oo02.O000000o() == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                        if (o000000o == null) {
                            o000000o = new alr.O000000o();
                        }
                        o000000o.O000000o(next, O0000Oo02.O00000Oo());
                    }
                }
            }
        } else {
            o000000o = null;
        }
        Iterator<alm> it = this.O0000OOo.iterator();
        amg amg = null;
        while (true) {
            boolean z2 = false;
            if (it.hasNext()) {
                alm next2 = it.next();
                if (!next2.O00000oo()) {
                    O00000Oo4 = next2.O00000Oo(ajt2.O000000o(next2.O000000o(), next2));
                } else {
                    ajw<?> O0000OOo3 = next2.O0000OOo();
                    if (!(O0000OOo3 instanceof alc) || (O000000o3 = ((alc) O0000OOo3).O000000o(ajt2, next2)) == O0000OOo3) {
                        alm = next2;
                        O00000oO2 = alm.O00000oO();
                        if (O00000oO2 != null) {
                            alu = alm;
                        } else {
                            ajw<Object> O0000OOo4 = alm.O0000OOo();
                            if (O0000OOo4 instanceof akx) {
                                alm3 = ((akx) O0000OOo4).O000000o(O00000oO2);
                            } else if (O0000OOo4 instanceof aml) {
                                ajw<Object> O00000o2 = ((aml) O0000OOo4).O00000o();
                                if (!(O00000o2 instanceof akx)) {
                                    if (O00000o2 == null) {
                                        str = "NULL";
                                    } else {
                                        str = O00000o2.getClass().getName();
                                    }
                                    throw new IllegalArgumentException("Can not handle managed/back reference '" + O00000oO2 + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer  (instead it's of type " + str + ")");
                                }
                                alm3 = ((akx) O00000o2).O000000o(O00000oO2);
                                z = true;
                                if (alm3 == null) {
                                    ajv ajv = this.O00000Oo;
                                    ajv O000000o4 = alm3.O000000o();
                                    if (O000000o4.O00000Oo().isAssignableFrom(ajv.O00000Oo())) {
                                        alu = new alu(alm, O00000oO2, alm3, this.f12427O000000o, z);
                                    } else {
                                        throw new IllegalArgumentException("Can not handle managed/back reference '" + O00000oO2 + "': back reference type (" + O000000o4.O00000Oo().getName() + ") not compatible with managed type (" + ajv.O00000Oo().getName() + ")");
                                    }
                                } else {
                                    throw new IllegalArgumentException("Can not handle managed/back reference '" + O00000oO2 + "': no back reference property found from type " + alm.O000000o());
                                }
                            } else if (O0000OOo4 instanceof aku) {
                                alm3 = ((aku) O0000OOo4).O000000o(O00000oO2);
                            } else {
                                throw new IllegalArgumentException("Can not handle managed/back reference '" + O00000oO2 + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + O0000OOo4.getClass().getName());
                            }
                            z = false;
                            if (alm3 == null) {
                            }
                        }
                        O00000Oo2 = alu.O00000Oo();
                        if (O00000Oo2 != null || (O00000Oo3 = ajt.O00000Oo().O00000Oo(O00000Oo2)) == null || (O000000o2 = (O0000OOo2 = alu.O0000OOo()).O000000o(O00000Oo3)) == O0000OOo2) {
                            alm2 = null;
                        } else {
                            alm2 = alu.O00000Oo(O000000o2);
                        }
                        if (alm2 == null) {
                            if (amg == null) {
                                amg = new amg();
                            }
                            amg.O000000o(alm2);
                        } else {
                            alm O000000o5 = O000000o(ajt2, (alm) alu);
                            if (O000000o5 != next2) {
                                this.O0000OOo.O00000Oo(O000000o5);
                            }
                            if (O000000o5.O0000O0o()) {
                                aof O0000Oo03 = O000000o5.O0000Oo0();
                                if (O0000Oo03.O000000o() == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                                    if (o000000o == null) {
                                        o000000o = new alr.O000000o();
                                    }
                                    o000000o.O000000o(O000000o5, O0000Oo03.O00000Oo());
                                    this.O0000OOo.O00000o0(O000000o5);
                                }
                            }
                        }
                    } else {
                        O00000Oo4 = next2.O00000Oo(O000000o3);
                    }
                }
                alm = O00000Oo4;
                O00000oO2 = alm.O00000oO();
                if (O00000oO2 != null) {
                }
                O00000Oo2 = alu.O00000Oo();
                if (O00000Oo2 != null) {
                }
                alm2 = null;
                if (alm2 == null) {
                }
            } else {
                all all = this.O0000Oo;
                if (all != null && !all.O00000Oo()) {
                    all all2 = this.O0000Oo;
                    this.O0000Oo = all2.O000000o(ajt2.O000000o(all2.O00000o0(), this.O0000Oo.O000000o()));
                }
                if (this.O00000o0.O0000OOo()) {
                    ajv O0000Oo2 = this.O00000o0.O0000Oo();
                    if (O0000Oo2 != null) {
                        this.O00000o = ajt2.O000000o(O0000Oo2, new ajr.O000000o(null, O0000Oo2, this.f12427O000000o, this.O00000o0.O0000o00()));
                    } else {
                        throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.O00000Oo + ": value instantiator (" + this.O00000o0.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
                    }
                }
                if (o000000o != null) {
                    this.O0000o = o000000o.O000000o();
                    this.O00000oo = true;
                }
                this.O0000o0o = amg;
                if (amg != null) {
                    this.O00000oo = true;
                }
                if (this.O0000O0o && !this.O00000oo) {
                    z2 = true;
                }
                this.O0000O0o = z2;
                return;
            }
        }
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        String[] strArr;
        aig aig;
        ajv ajv;
        alz alz;
        alx alx = this.O0000oO0;
        AnnotationIntrospector O00000Oo2 = ajt.O00000Oo();
        alm alm = null;
        if (ajr == null || O00000Oo2 == null) {
            strArr = null;
        } else {
            anm O00000Oo3 = ajr.O00000Oo();
            strArr = O00000Oo2.O00000Oo((ani) O00000Oo3);
            anz O000000o2 = O00000Oo2.O000000o((ani) O00000Oo3);
            if (O000000o2 != null) {
                Class<? extends aig<?>> O00000o02 = O000000o2.O00000o0();
                if (O00000o02 == aih.O00000o0.class) {
                    String O000000o3 = O000000o2.O000000o();
                    alp alp = this.O0000OOo;
                    if (alp != null) {
                        alm = alp.O000000o(O000000o3);
                    }
                    if (alm == null && (alz = this.O00000oO) != null) {
                        alm = alz.O000000o(O000000o3);
                    }
                    if (alm != null) {
                        ajv = alm.O000000o();
                        aig = new ama(O000000o2.O00000Oo());
                    } else {
                        throw new IllegalArgumentException("Invalid Object Id definition for " + this.O00000Oo.O00000Oo().getName() + ": can not find property with name '" + O000000o3 + "'");
                    }
                } else {
                    ajv = ajt.O0000O0o().O00000Oo(ajt.O000000o((Class<?>) O00000o02), aig.class)[0];
                    aig = ajt.O000000o(O000000o2);
                }
                alx = alx.O000000o(ajv, O000000o2.O000000o(), aig, ajt.O000000o(ajv), alm);
            }
        }
        akx O000000o4 = (alx == null || alx == this.O0000oO0) ? this : O000000o(alx);
        return (strArr == null || strArr.length == 0) ? O000000o4 : O000000o4.O000000o(asu.O000000o(O000000o4.O0000OoO, strArr));
    }

    private alm O000000o(ajt ajt, alm alm) {
        Class<?> O00000Oo2;
        Class<?> O00000o02;
        ajw<Object> O0000OOo2 = alm.O0000OOo();
        if ((O0000OOo2 instanceof akx) && !((akx) O0000OOo2).O00000o0.O0000O0o() && (O00000o02 = asw.O00000o0((O00000Oo2 = alm.O000000o().O00000Oo()))) != null && O00000o02 == this.O00000Oo.O00000Oo()) {
            for (Constructor<?> constructor : O00000Oo2.getConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == O00000o02) {
                    if (ajt.O000000o().O0000OOo()) {
                        asw.O000000o((Member) constructor);
                    }
                    return new alt(alm, constructor);
                }
            }
        }
        return alm;
    }

    public final Collection<Object> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        Iterator<alm> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().O00000o());
        }
        return arrayList;
    }

    public final Class<?> O00000o() {
        return this.O00000Oo.O00000Oo();
    }

    private alm O000000o(String str) {
        Map<String, alm> map = this.O0000o0;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        JsonToken O00000oO2;
        if (this.O0000oO0 == null || (O00000oO2 = jsonParser.O00000oO()) == null || !O00000oO2.isScalarValue()) {
            return aof.O000000o(jsonParser, ajt);
        }
        return O00000o(jsonParser, ajt);
    }

    /* access modifiers changed from: protected */
    public final Object O00000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        Object O000000o2 = this.O0000oO0.O00000o.O000000o(jsonParser, ajt);
        Object obj = ajt.O000000o(O000000o2, this.O0000oO0.O00000o0).O00000Oo;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Could not resolve Object Id [" + O000000o2 + "] -- unresolved forward-reference?");
    }

    /* access modifiers changed from: protected */
    public final void O000000o(ajt ajt, Object obj) throws IOException, JsonProcessingException {
        for (amh O000000o2 : this.O0000Oo0) {
            O000000o2.O000000o(ajt, obj);
        }
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj, String str) throws IOException, JsonProcessingException {
        HashSet<String> hashSet;
        if (this.O0000Ooo || ((hashSet = this.O0000OoO) != null && hashSet.contains(str))) {
            jsonParser.O00000o();
        } else {
            super.O000000o(jsonParser, ajt, obj, str);
        }
    }

    /* access modifiers changed from: protected */
    public final Object O000000o(ajt ajt, Object obj, ath ath) throws IOException, JsonProcessingException {
        ath.O00000oO();
        JsonParser O0000OOo2 = ath.O0000OOo();
        while (O0000OOo2.O00000Oo() != JsonToken.END_OBJECT) {
            String O00000oo2 = O0000OOo2.O00000oo();
            O0000OOo2.O00000Oo();
            O000000o(O0000OOo2, ajt, obj, O00000oo2);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public final ajw<Object> O00000Oo(ajt ajt, Object obj) throws IOException, JsonProcessingException {
        ajw<Object> ajw;
        synchronized (this) {
            ajw = this.O0000o0O == null ? null : this.O0000o0O.get(new ash(obj.getClass()));
        }
        if (ajw != null) {
            return ajw;
        }
        ajw<Object> O000000o2 = ajt.O000000o(ajt.O000000o(obj.getClass()));
        if (O000000o2 != null) {
            synchronized (this) {
                if (this.O0000o0O == null) {
                    this.O0000o0O = new HashMap<>();
                }
                this.O0000o0O.put(new ash(obj.getClass()), O000000o2);
            }
        }
        return O000000o2;
    }

    public static void O000000o(Throwable th, Object obj, String str, ajt ajt) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = ajt == null || ajt.O000000o(DeserializationFeature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                if (!z || !(th instanceof JsonMappingException)) {
                    throw ((IOException) th);
                }
            } else if (!z && (th instanceof RuntimeException)) {
                throw ((RuntimeException) th);
            }
            throw JsonMappingException.wrapWithPath(th, obj, str);
        }
        throw ((Error) th);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Throwable th, ajt ajt) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (!(th instanceof Error)) {
            boolean z = ajt == null || ajt.O000000o(DeserializationFeature.WRAP_EXCEPTIONS);
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (z || !(th instanceof RuntimeException)) {
                throw ajt.O000000o(this.O00000Oo.O00000Oo(), th);
            } else {
                throw ((RuntimeException) th);
            }
        } else {
            throw ((Error) th);
        }
    }
}

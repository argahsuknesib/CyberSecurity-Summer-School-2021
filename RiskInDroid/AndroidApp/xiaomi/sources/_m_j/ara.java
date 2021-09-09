package _m_j;

import _m_j.aih;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class ara extends asb<Object> implements apz, aqd {
    public static final apt[] O00000Oo = new apt[0];
    protected final apt[] O00000o;
    protected final apt[] O00000o0;
    protected final apq O00000oO;
    protected final Object O00000oo;
    protected final anm O0000O0o;
    protected final aqn O0000OOo;

    /* access modifiers changed from: protected */
    public abstract ara O000000o(aqn aqn);

    /* access modifiers changed from: protected */
    public abstract ara O000000o(String[] strArr);

    protected ara(ajv ajv, apv apv, apt[] aptArr, apt[] aptArr2) {
        super(ajv);
        this.O00000o0 = aptArr;
        this.O00000o = aptArr2;
        if (apv == null) {
            this.O0000O0o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000OOo = null;
            return;
        }
        this.O0000O0o = apv.O00000o();
        this.O00000oO = apv.O00000Oo();
        this.O00000oo = apv.O00000o0();
        this.O0000OOo = apv.O00000oO();
    }

    private ara(ara ara, apt[] aptArr, apt[] aptArr2) {
        super(ara.O0000OoO);
        this.O00000o0 = aptArr;
        this.O00000o = aptArr2;
        this.O0000O0o = ara.O0000O0o;
        this.O00000oO = ara.O00000oO;
        this.O0000OOo = ara.O0000OOo;
        this.O00000oo = ara.O00000oo;
    }

    protected ara(ara ara, aqn aqn) {
        super(ara.O0000OoO);
        this.O00000o0 = ara.O00000o0;
        this.O00000o = ara.O00000o;
        this.O0000O0o = ara.O0000O0o;
        this.O00000oO = ara.O00000oO;
        this.O0000OOo = aqn;
        this.O00000oo = ara.O00000oo;
    }

    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    protected ara(ara ara, String[] strArr) {
        super(ara.O0000OoO);
        ArrayList arrayList;
        HashSet O000000o2 = asu.O000000o(strArr);
        apt[] aptArr = ara.O00000o0;
        apt[] aptArr2 = ara.O00000o;
        int length = aptArr.length;
        ArrayList arrayList2 = new ArrayList(length);
        apt[] aptArr3 = null;
        if (aptArr2 == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(length);
        }
        for (int i = 0; i < length; i++) {
            apt apt = aptArr[i];
            if (!O000000o2.contains(apt.O00000o0())) {
                arrayList2.add(apt);
                if (aptArr2 != null) {
                    arrayList.add(aptArr2[i]);
                }
            }
        }
        this.O00000o0 = (apt[]) arrayList2.toArray(new apt[arrayList2.size()]);
        this.O00000o = arrayList != null ? arrayList.toArray(new apt[arrayList.size()]) : aptArr3;
        this.O0000O0o = ara.O0000O0o;
        this.O00000oO = ara.O00000oO;
        this.O0000OOo = ara.O0000OOo;
        this.O00000oo = ara.O00000oo;
    }

    protected ara(ara ara, atb atb) {
        this(ara, O000000o(ara.O00000o0, atb), O000000o(ara.O00000o, atb));
    }

    private static final apt[] O000000o(apt[] aptArr, atb atb) {
        if (aptArr == null || aptArr.length == 0 || atb == null || atb == atb.f12582O000000o) {
            return aptArr;
        }
        int length = aptArr.length;
        apt[] aptArr2 = new apt[length];
        for (int i = 0; i < length; i++) {
            apt apt = aptArr[i];
            if (apt != null) {
                aptArr2[i] = apt.O000000o(atb);
            }
        }
        return aptArr2;
    }

    public final void O000000o(akf akf) throws JsonMappingException {
        apt apt;
        aoi aoi;
        ajz<Object> O0000OoO;
        apt apt2;
        apt[] aptArr = this.O00000o;
        int length = aptArr == null ? 0 : aptArr.length;
        int length2 = this.O00000o0.length;
        for (int i = 0; i < length2; i++) {
            apt apt3 = this.O00000o0[i];
            if (!apt3.O00000oo() && !apt3.O00000oO() && (O0000OoO = akf.O0000OoO()) != null) {
                apt3.O00000Oo(O0000OoO);
                if (i < length && (apt2 = this.O00000o[i]) != null) {
                    apt2.O00000Oo(O0000OoO);
                }
            }
            if (!apt3.O00000o()) {
                ajv O0000O0o2 = apt3.O0000O0o();
                if (O0000O0o2 == null) {
                    O0000O0o2 = akf.O000000o(apt3.O0000OOo());
                    if (!O0000O0o2.O0000Oo()) {
                        if (O0000O0o2.O0000OoO() || O0000O0o2.O0000o() > 0) {
                            apt3.O000000o(O0000O0o2);
                        }
                    }
                }
                ajz O000000o2 = akf.O000000o(O0000O0o2, apt3);
                if (O0000O0o2.O0000OoO() && (aoi = (aoi) O0000O0o2.O0000o0o().O0000oO()) != null && (O000000o2 instanceof apy)) {
                    O000000o2 = ((apy) O000000o2).O000000o(aoi);
                }
                apt3.O000000o((ajz<Object>) O000000o2);
                if (i < length && (apt = this.O00000o[i]) != null) {
                    apt.O000000o((ajz<Object>) O000000o2);
                }
            }
        }
        apq apq = this.O00000oO;
        if (apq != null) {
            apq.O000000o(akf);
        }
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        String[] strArr;
        aqn aqn;
        aqn aqn2 = this.O0000OOo;
        AnnotationIntrospector O00000o02 = akf.O00000o0();
        if (ajr == null || O00000o02 == null) {
            strArr = null;
        } else {
            anm O00000Oo2 = ajr.O00000Oo();
            strArr = O00000o02.O00000Oo((ani) O00000Oo2);
            anz O000000o2 = O00000o02.O000000o((ani) O00000Oo2);
            if (O000000o2 != null) {
                Class<? extends aig<?>> O00000o03 = O000000o2.O00000o0();
                ajv ajv = akf.O0000OOo().O00000Oo(akf.O000000o((Type) O00000o03), aig.class)[0];
                if (O00000o03 == aih.O00000o0.class) {
                    String O000000o3 = O000000o2.O000000o();
                    int length = this.O00000o0.length;
                    int i = 0;
                    while (i != length) {
                        apt apt = this.O00000o0[i];
                        if (O000000o3.equals(apt.O00000o0())) {
                            if (i > 0) {
                                apt[] aptArr = this.O00000o0;
                                System.arraycopy(aptArr, 0, aptArr, 1, i);
                                this.O00000o0[0] = apt;
                                apt[] aptArr2 = this.O00000o;
                                if (aptArr2 != null) {
                                    apt apt2 = aptArr2[i];
                                    System.arraycopy(aptArr2, 0, aptArr2, 1, i);
                                    this.O00000o[0] = apt2;
                                }
                            }
                            aqn2 = aqn.O000000o(apt.O000000o(), null, new aqo(O000000o2, apt));
                        } else {
                            i++;
                        }
                    }
                    throw new IllegalArgumentException("Invalid Object Id definition for " + this.O0000OoO.getName() + ": can not find property with name '" + O000000o3 + "'");
                }
                aqn2 = aqn.O000000o(ajv, O000000o2.O000000o(), akf.O000000o(O000000o2));
            }
        }
        ara O000000o4 = (aqn2 == null || (aqn = new aqn(aqn2.f12527O000000o, aqn2.O00000Oo, aqn2.O00000o0, akf.O000000o(aqn2.f12527O000000o, ajr))) == this.O0000OOo) ? this : O000000o(aqn);
        return (strArr == null || strArr.length == 0) ? O000000o4 : O000000o4.O000000o(strArr);
    }

    public final boolean O00000o0() {
        return this.O0000OOo != null;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        aqn aqn = this.O0000OOo;
        String str = null;
        if (aqn != null) {
            aqx O000000o2 = akf.O000000o(obj, aqn.O00000o0);
            Object obj2 = O000000o2.O00000o0;
            if (obj2 != null) {
                O000000o2.O00000Oo.O000000o(obj2, jsonGenerator, akf);
                return;
            }
            O000000o2.O00000Oo = aqn.O00000o;
            Object O00000Oo2 = O000000o2.f12539O000000o.O00000Oo(obj);
            O000000o2.O00000o0 = O00000Oo2;
            if (this.O0000O0o != null) {
                str = O00000Oo(obj);
            }
            if (str == null) {
                aoi.O00000Oo(obj, jsonGenerator);
            } else {
                aoi.O000000o(jsonGenerator, str);
            }
            aja aja = aqn.O00000Oo;
            if (aja != null) {
                jsonGenerator.O000000o((ain) aja);
                aqn.O00000o.O000000o(O00000Oo2, jsonGenerator, akf);
            }
            if (this.O00000oo != null) {
                O00000o0(obj, jsonGenerator, akf);
            } else {
                O00000Oo(obj, jsonGenerator, akf);
            }
            if (str == null) {
                aoi.O00000oO(obj, jsonGenerator);
            } else {
                aoi.O000000o(obj, jsonGenerator, str);
            }
        } else {
            if (this.O0000O0o != null) {
                str = O00000Oo(obj);
            }
            if (str == null) {
                aoi.O00000Oo(obj, jsonGenerator);
            } else {
                aoi.O000000o(jsonGenerator, str);
            }
            if (this.O00000oo != null) {
                O00000o0(obj, jsonGenerator, akf);
            } else {
                O00000Oo(obj, jsonGenerator, akf);
            }
            if (str == null) {
                aoi.O00000oO(obj, jsonGenerator);
            } else {
                aoi.O000000o(obj, jsonGenerator, str);
            }
        }
    }

    private final String O00000Oo(Object obj) {
        Object O00000Oo2 = this.O0000O0o.O00000Oo(obj);
        if (O00000Oo2 == null) {
            return "";
        }
        return O00000Oo2 instanceof String ? (String) O00000Oo2 : O00000Oo2.toString();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        apt[] aptArr;
        String str = "[anySetter]";
        if (this.O00000o == null || akf.O00000o() == null) {
            aptArr = this.O00000o0;
        } else {
            aptArr = this.O00000o;
        }
        try {
            for (apt apt : aptArr) {
                if (apt != null) {
                    apt.O000000o(obj, jsonGenerator, akf);
                }
            }
            if (this.O00000oO != null) {
                this.O00000oO.O000000o(obj, jsonGenerator, akf);
            }
        } catch (Exception e) {
            if (0 != aptArr.length) {
                str = aptArr[0].O00000o0();
            }
            O000000o(akf, e, obj, str);
        } catch (StackOverflowError unused) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)");
            if (0 != aptArr.length) {
                str = aptArr[0].O00000o0();
            }
            jsonMappingException.prependPath(new JsonMappingException.Reference(obj, str));
            throw jsonMappingException;
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        apt[] aptArr;
        String str = "[anySetter]";
        if (this.O00000o == null || akf.O00000o() == null) {
            aptArr = this.O00000o0;
        } else {
            aptArr = this.O00000o;
        }
        if (O00000Oo(akf) == null) {
            O00000Oo(obj, jsonGenerator, akf);
            return;
        }
        try {
            for (int i = 0; i < aptArr.length; i++) {
            }
            if (this.O00000oO != null) {
                this.O00000oO.O000000o(obj, jsonGenerator, akf);
            }
        } catch (Exception e) {
            if (0 != aptArr.length) {
                str = aptArr[0].O00000o0();
            }
            O000000o(akf, e, obj, str);
        } catch (StackOverflowError unused) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)");
            if (0 != aptArr.length) {
                str = aptArr[0].O00000o0();
            }
            jsonMappingException.prependPath(new JsonMappingException.Reference(obj, str));
            throw jsonMappingException;
        }
    }

    private aps O00000Oo(akf akf) throws JsonMappingException {
        Object obj = this.O00000oo;
        aqb O00000oO2 = akf.O00000oO();
        if (O00000oO2 != null) {
            return O00000oO2.O000000o();
        }
        throw new JsonMappingException("Can not resolve BeanPropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }
}

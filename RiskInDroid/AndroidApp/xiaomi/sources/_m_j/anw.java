package _m_j;

import _m_j.aia;
import _m_j.aih;
import _m_j.ajw;
import _m_j.ajz;
import _m_j.aka;
import _m_j.aki;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public final class anw extends AnnotationIntrospector {
    public final boolean O000000o(Annotation annotation) {
        return annotation.annotationType().getAnnotation(ahi.class) != null;
    }

    public final String O000000o(Enum<?> enumR) {
        return enumR.name();
    }

    public final String O000000o(anj anj) {
        ahy ahy = (ahy) anj.O000000o(ahy.class);
        if (ahy == null) {
            return null;
        }
        return ahy.O000000o();
    }

    public final String[] O00000Oo(ani ani) {
        ahs ahs = (ahs) ani.O000000o(ahs.class);
        if (ahs == null) {
            return null;
        }
        return ahs.O000000o();
    }

    public final Boolean O00000Oo(anj anj) {
        ahs ahs = (ahs) anj.O000000o(ahs.class);
        if (ahs == null) {
            return null;
        }
        return Boolean.valueOf(ahs.O00000Oo());
    }

    public final Boolean O00000o0(anj anj) {
        aht aht = (aht) anj.O000000o(aht.class);
        if (aht == null) {
            return null;
        }
        return Boolean.valueOf(aht.O000000o());
    }

    public final Object O00000o(anj anj) {
        aho aho = (aho) anj.O000000o(aho.class);
        if (aho == null) {
            return null;
        }
        String O000000o2 = aho.O000000o();
        if (O000000o2.length() > 0) {
            return O000000o2;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [_m_j.aoc<?>, _m_j.aoc] */
    public final aoc<?> O000000o(anj anj, aoc<?> aoc) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) anj.O000000o(JsonAutoDetect.class);
        if (jsonAutoDetect == null) {
            return aoc;
        }
        return aoc.O000000o(jsonAutoDetect);
    }

    public final AnnotationIntrospector.ReferenceProperty O000000o(anm anm) {
        ahu ahu = (ahu) anm.O000000o(ahu.class);
        if (ahu != null) {
            return new AnnotationIntrospector.ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.MANAGED_REFERENCE, ahu.O000000o());
        }
        ahm ahm = (ahm) anm.O000000o(ahm.class);
        if (ahm == null) {
            return null;
        }
        return new AnnotationIntrospector.ReferenceProperty(AnnotationIntrospector.ReferenceProperty.Type.BACK_REFERENCE, ahm.O000000o());
    }

    public final atb O00000Oo(anm anm) {
        aid aid = (aid) anm.O000000o(aid.class);
        if (aid == null || !aid.O000000o()) {
            return null;
        }
        return atb.O000000o(aid.O00000Oo(), aid.O00000o0());
    }

    public final Object O00000o(anm anm) {
        ahj ahj = (ahj) anm.O000000o(ahj.class);
        if (ahj == null) {
            return null;
        }
        String O000000o2 = ahj.O000000o();
        if (O000000o2.length() != 0) {
            return O000000o2;
        }
        if (!(anm instanceof ann)) {
            return anm.O00000o().getName();
        }
        ann ann = (ann) anm;
        if (ann.O0000OOo() == 0) {
            return anm.O00000o().getName();
        }
        return ann.O0000o0().getName();
    }

    public final aoh<?> O000000o(akr<?> akr, anj anj, ajv ajv) {
        return O000000o(akr, anj);
    }

    public final aoh<?> O000000o(akr<?> akr, anm anm, ajv ajv) {
        if (ajv.O0000OoO()) {
            return null;
        }
        return O000000o(akr, anm);
    }

    public final aoh<?> O00000Oo(akr<?> akr, anm anm, ajv ajv) {
        if (ajv.O0000OoO()) {
            return O000000o(akr, anm);
        }
        throw new IllegalArgumentException("Must call method with a container type (got " + ajv + ")");
    }

    public final List<aod> O00000o0(ani ani) {
        aia aia = (aia) ani.O000000o(aia.class);
        if (aia == null) {
            return null;
        }
        aia.O000000o[] O000000o2 = aia.O000000o();
        ArrayList arrayList = new ArrayList(O000000o2.length);
        for (aia.O000000o o000000o : O000000o2) {
            arrayList.add(new aod(o000000o.O000000o(), o000000o.O00000Oo()));
        }
        return arrayList;
    }

    public final String O00000oO(anj anj) {
        aic aic = (aic) anj.O000000o(aic.class);
        if (aic == null) {
            return null;
        }
        return aic.O000000o();
    }

    public final Object O00000oO(ani ani) {
        Class<? extends ajz<?>> O000000o2;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize != null && (O000000o2 = jsonSerialize.O000000o()) != ajz.O000000o.class) {
            return O000000o2;
        }
        ahx ahx = (ahx) ani.O000000o(ahx.class);
        if (ahx == null || !ahx.O000000o()) {
            return null;
        }
        return new arr(ani.O00000o());
    }

    public final JsonInclude.Include O000000o(ani ani, JsonInclude.Include include) {
        JsonInclude jsonInclude = (JsonInclude) ani.O000000o(JsonInclude.class);
        if (jsonInclude != null) {
            return jsonInclude.O000000o();
        }
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize != null) {
            int i = AnonymousClass1.f12490O000000o[jsonSerialize.O0000OOo().ordinal()];
            if (i == 1) {
                return JsonInclude.Include.ALWAYS;
            }
            if (i == 2) {
                return JsonInclude.Include.NON_NULL;
            }
            if (i == 3) {
                return JsonInclude.Include.NON_DEFAULT;
            }
            if (i == 4) {
                return JsonInclude.Include.NON_EMPTY;
            }
        }
        return include;
    }

    /* renamed from: _m_j.anw$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12490O000000o = new int[JsonSerialize.Inclusion.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f12490O000000o[JsonSerialize.Inclusion.ALWAYS.ordinal()] = 1;
            f12490O000000o[JsonSerialize.Inclusion.NON_NULL.ordinal()] = 2;
            f12490O000000o[JsonSerialize.Inclusion.NON_DEFAULT.ordinal()] = 3;
            try {
                f12490O000000o[JsonSerialize.Inclusion.NON_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final Class<?> O0000OOo(ani ani) {
        Class<?> O00000o;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null || (O00000o = jsonSerialize.O00000o()) == akm.class) {
            return null;
        }
        return O00000o;
    }

    public final Class<?> O0000Oo0(ani ani) {
        Class<?> O00000oO;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null || (O00000oO = jsonSerialize.O00000oO()) == akm.class) {
            return null;
        }
        return O00000oO;
    }

    public final Class<?> O0000Oo(ani ani) {
        Class<?> O00000oo;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null || (O00000oo = jsonSerialize.O00000oo()) == akm.class) {
            return null;
        }
        return O00000oo;
    }

    public final JsonSerialize.Typing O0000OoO(ani ani) {
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.O0000O0o();
    }

    public final Class<?>[] O00000o(ani ani) {
        aif aif = (aif) ani.O000000o(aif.class);
        if (aif == null) {
            return null;
        }
        return aif.O000000o();
    }

    public final Boolean O00000oo(anm anm) {
        return Boolean.valueOf(anm.O00000Oo(aib.class));
    }

    public final anz O000000o(ani ani) {
        ahq ahq = (ahq) ani.O000000o(ahq.class);
        if (ahq == null || ahq.O00000Oo() == aih.O00000Oo.class) {
            return null;
        }
        return new anz(ahq.O000000o(), ahq.O00000o0(), ahq.O00000Oo());
    }

    public final JsonFormat.O000000o O00000oO(anm anm) {
        JsonFormat jsonFormat = (JsonFormat) anm.O000000o(JsonFormat.class);
        if (jsonFormat == null) {
            return null;
        }
        return new JsonFormat.O000000o(jsonFormat);
    }

    public final String[] O00000oo(anj anj) {
        ahw ahw = (ahw) anj.O000000o(ahw.class);
        if (ahw == null) {
            return null;
        }
        return ahw.O000000o();
    }

    public final Boolean O0000O0o(anj anj) {
        ahw ahw = (ahw) anj.O000000o(ahw.class);
        if (ahw == null) {
            return null;
        }
        return Boolean.valueOf(ahw.O00000Oo());
    }

    public final String O000000o(ann ann) {
        ahp ahp = (ahp) ann.O000000o(ahp.class);
        if (ahp != null) {
            return ahp.O000000o();
        }
        ahv ahv = (ahv) ann.O000000o(ahv.class);
        if (ahv != null) {
            return ahv.O000000o();
        }
        if (ann.O00000Oo(JsonSerialize.class) || ann.O00000Oo(aif.class)) {
            return "";
        }
        return null;
    }

    public final boolean O00000Oo(ann ann) {
        aie aie = (aie) ann.O000000o(aie.class);
        return aie != null && aie.O000000o();
    }

    public final String O000000o(anl anl) {
        ahv ahv = (ahv) anl.O000000o(ahv.class);
        if (ahv != null) {
            return ahv.O000000o();
        }
        if (anl.O00000Oo(JsonSerialize.class) || anl.O00000Oo(aif.class)) {
            return "";
        }
        return null;
    }

    public final Class<?> O0000o0O(ani ani) {
        Class<?> O00000oO;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O00000oO = akh.O00000oO()) == akm.class) {
            return null;
        }
        return O00000oO;
    }

    public final Class<?> O0000o0o(ani ani) {
        Class<?> O00000oo;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O00000oo = akh.O00000oo()) == akm.class) {
            return null;
        }
        return O00000oo;
    }

    public final Class<?> O0000o(ani ani) {
        Class<?> O0000O0o;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O0000O0o = akh.O0000O0o()) == akm.class) {
            return null;
        }
        return O0000O0o;
    }

    public final Object O0000OOo(anj anj) {
        akl akl = (akl) anj.O000000o(akl.class);
        if (akl == null) {
            return null;
        }
        return akl.O000000o();
    }

    public final Class<?> O0000Oo0(anj anj) {
        akh akh = (akh) anj.O000000o(akh.class);
        if (akh == null || akh.O00000o() == akm.class) {
            return null;
        }
        return akh.O00000o();
    }

    public final aki.O000000o O0000Oo(anj anj) {
        aki aki = (aki) anj.O000000o(aki.class);
        if (aki == null) {
            return null;
        }
        return new aki.O000000o(aki);
    }

    public final String O00000o0(ann ann) {
        ahz ahz = (ahz) ann.O000000o(ahz.class);
        if (ahz != null) {
            return ahz.O000000o();
        }
        ahv ahv = (ahv) ann.O000000o(ahv.class);
        if (ahv != null) {
            return ahv.O000000o();
        }
        if (ann.O00000Oo(akh.class) || ann.O00000Oo(aif.class) || ann.O00000Oo(ahm.class) || ann.O00000Oo(ahu.class)) {
            return "";
        }
        return null;
    }

    public final boolean O00000o(ann ann) {
        return ann.O00000Oo(ahl.class);
    }

    public final boolean O00000oO(ann ann) {
        return ann.O00000Oo(ahk.class);
    }

    public final boolean O0000oO0(ani ani) {
        return ani.O00000Oo(ahn.class);
    }

    public final String O00000Oo(anl anl) {
        ahv ahv = (ahv) anl.O000000o(ahv.class);
        if (ahv != null) {
            return ahv.O000000o();
        }
        if (anl.O00000Oo(akh.class) || anl.O00000Oo(aif.class) || anl.O00000Oo(ahm.class) || anl.O00000Oo(ahu.class)) {
            return "";
        }
        return null;
    }

    public final String O000000o(anp anp) {
        ahv ahv;
        if (anp == null || (ahv = (ahv) anp.O000000o(ahv.class)) == null) {
            return null;
        }
        return ahv.O000000o();
    }

    private static aoh<?> O000000o(akr<?> akr, ani ani) {
        aoh aoh;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) ani.O000000o(JsonTypeInfo.class);
        akk akk = (akk) ani.O000000o(akk.class);
        aog aog = null;
        if (akk != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            aoh = akr.O00000o(akk.O000000o());
        } else if (jsonTypeInfo == null) {
            return null;
        } else {
            if (jsonTypeInfo.O000000o() == JsonTypeInfo.Id.NONE) {
                return aou.O00000Oo();
            }
            aoh = new aou();
        }
        akj akj = (akj) ani.O000000o(akj.class);
        if (akj != null) {
            aog = akr.O00000oO(akj.O000000o());
        }
        aoh O000000o2 = aoh.O000000o(jsonTypeInfo.O000000o(), aog);
        JsonTypeInfo.As O00000Oo = jsonTypeInfo.O00000Oo();
        if (O00000Oo == JsonTypeInfo.As.EXTERNAL_PROPERTY && (ani instanceof anj)) {
            O00000Oo = JsonTypeInfo.As.PROPERTY;
        }
        aoh O000000o3 = O000000o2.O000000o(O00000Oo).O000000o(jsonTypeInfo.O00000o0());
        Class<?> O00000o = jsonTypeInfo.O00000o();
        if (O00000o != JsonTypeInfo.O000000o.class) {
            O000000o3 = O000000o3.O000000o(O00000o);
        }
        return O000000o3.O000000o(jsonTypeInfo.O00000oO());
    }

    public final boolean O00000o0(anm anm) {
        ahr ahr = (ahr) anm.O000000o(ahr.class);
        return ahr != null && ahr.O000000o();
    }

    public final /* synthetic */ Object O0000o0(ani ani) {
        Class<? extends ajw<?>> O00000Oo;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O00000Oo = akh.O00000Oo()) == ajw.O000000o.class) {
            return null;
        }
        return O00000Oo;
    }

    public final /* synthetic */ Object O0000o00(ani ani) {
        Class<? extends aka> O00000o0;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O00000o0 = akh.O00000o0()) == aka.O000000o.class) {
            return null;
        }
        return O00000o0;
    }

    public final /* synthetic */ Object O0000Ooo(ani ani) {
        Class<? extends ajw<?>> O000000o2;
        akh akh = (akh) ani.O000000o(akh.class);
        if (akh == null || (O000000o2 = akh.O000000o()) == ajw.O000000o.class) {
            return null;
        }
        return O000000o2;
    }

    public final /* synthetic */ Object O0000O0o(ani ani) {
        Class<? extends ajz<?>> O00000Oo;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null || (O00000Oo = jsonSerialize.O00000Oo()) == ajz.O000000o.class) {
            return null;
        }
        return O00000Oo;
    }

    public final /* synthetic */ Object O00000oo(ani ani) {
        Class<? extends ajz<?>> O00000o0;
        JsonSerialize jsonSerialize = (JsonSerialize) ani.O000000o(JsonSerialize.class);
        if (jsonSerialize == null || (O00000o0 = jsonSerialize.O00000o0()) == ajz.O000000o.class) {
            return null;
        }
        return O00000o0;
    }
}

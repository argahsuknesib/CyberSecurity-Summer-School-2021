package _m_j;

import _m_j.akr;
import _m_j.anv;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.MapperFeature;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class akr<T extends akr<T>> implements anv.O000000o {
    protected final int O00000o;
    protected final akn O00000oO;

    public abstract ajq O000000o(ajv ajv);

    protected akr(akn akn, int i) {
        this.O00000oO = akn;
        this.O00000o = i;
    }

    public static <F extends Enum<F> & ako> int O000000o(Class<F> cls) {
        int i = 0;
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            ako ako = (ako) enumR;
            if (ako.enabledByDefault()) {
                i |= ako.getMask();
            }
        }
        return i;
    }

    public final boolean O000000o(MapperFeature mapperFeature) {
        return (mapperFeature.getMask() & this.O00000o) != 0;
    }

    public final boolean O0000O0o() {
        return O000000o(MapperFeature.USE_ANNOTATIONS);
    }

    public final boolean O0000OOo() {
        return O000000o(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final boolean O0000Oo0() {
        return O000000o(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public final anv O0000Oo() {
        return this.O00000oO.O000000o();
    }

    public AnnotationIntrospector O000000o() {
        return this.O00000oO.O00000Oo();
    }

    public aoc<?> O00000o0() {
        return this.O00000oO.O00000o0();
    }

    public final akd O0000OoO() {
        return this.O00000oO.O00000o();
    }

    public final akq O0000Ooo() {
        return this.O00000oO.O0000OOo();
    }

    public final aoh<?> O0000o00() {
        return this.O00000oO.O00000oo();
    }

    public final asq O0000o0() {
        return this.O00000oO.O00000oO();
    }

    public final ajq O00000o0(Class<?> cls) {
        return O000000o(O00000Oo(cls));
    }

    public final DateFormat O0000o0O() {
        return this.O00000oO.O0000O0o();
    }

    public final Locale O0000o0o() {
        return this.O00000oO.O0000Oo0();
    }

    public final TimeZone O0000o() {
        return this.O00000oO.O0000Oo();
    }

    public final ajv O00000Oo(Class<?> cls) {
        return this.O00000oO.O00000oO().O000000o(cls, (asp) null);
    }

    public final ajv O000000o(ajv ajv, Class<?> cls) {
        return this.O00000oO.O00000oO().O000000o(ajv, cls);
    }

    public final aoh<?> O00000o(Class<? extends aoh<?>> cls) {
        aoh<?> O00000o2;
        akq O0000OOo = this.O00000oO.O0000OOo();
        if (O0000OOo == null || (O00000o2 = O0000OOo.O00000o()) == null) {
            return (aoh) asw.O000000o(cls, O000000o(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        return O00000o2;
    }

    public final aog O00000oO(Class<? extends aog> cls) {
        aog O00000oO2;
        akq O0000OOo = this.O00000oO.O0000OOo();
        if (O0000OOo == null || (O00000oO2 = O0000OOo.O00000oO()) == null) {
            return (aog) asw.O000000o(cls, O000000o(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        return O00000oO2;
    }
}

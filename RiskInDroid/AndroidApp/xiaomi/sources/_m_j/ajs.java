package _m_j;

import _m_j.anv;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import java.util.Map;

public final class ajs extends aks<DeserializationFeature, ajs> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final int f12410O000000o;
    protected final ata<Object> O00000Oo;
    protected final api O00000o0;

    public ajs(akn akn, aoe aoe, Map<ash, Class<?>> map) {
        super(akn, aoe, map);
        this.f12410O000000o = O000000o(DeserializationFeature.class);
        this.O00000o0 = api.f12513O000000o;
        this.O00000Oo = null;
    }

    private ajs(ajs ajs, int i, int i2) {
        super(ajs, i);
        this.f12410O000000o = i2;
        this.O00000o0 = ajs.O00000o0;
        this.O00000Oo = ajs.O00000Oo;
    }

    public final ajs O000000o(DeserializationFeature deserializationFeature) {
        int mask = deserializationFeature.getMask() | this.f12410O000000o;
        return mask == this.f12410O000000o ? this : new ajs(this, this.O00000o, mask);
    }

    public final ajs O00000Oo(DeserializationFeature deserializationFeature) {
        int mask = (deserializationFeature.getMask() ^ -1) & this.f12410O000000o;
        return mask == this.f12410O000000o ? this : new ajs(this, this.O00000o, mask);
    }

    public final AnnotationIntrospector O000000o() {
        if (O000000o(MapperFeature.USE_ANNOTATIONS)) {
            return super.O000000o();
        }
        return any.f12492O000000o;
    }

    public final boolean O00000Oo() {
        if (this.O0000OOo != null) {
            return this.O0000OOo.length() > 0;
        }
        return O00000o0(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }

    public final ajq O000000o(ajv ajv) {
        return O0000Oo().O000000o((akr<?>) this, ajv, this);
    }

    public final aoc<?> O00000o0() {
        aoc O00000o02 = super.O00000o0();
        if (!O000000o(MapperFeature.AUTO_DETECT_SETTERS)) {
            O00000o02 = O00000o02.O00000o0(JsonAutoDetect.Visibility.NONE);
        }
        if (!O000000o(MapperFeature.AUTO_DETECT_CREATORS)) {
            O00000o02 = O00000o02.O00000o(JsonAutoDetect.Visibility.NONE);
        }
        return !O000000o(MapperFeature.AUTO_DETECT_FIELDS) ? O00000o02.O00000oO(JsonAutoDetect.Visibility.NONE) : O00000o02;
    }

    public final boolean O00000o0(DeserializationFeature deserializationFeature) {
        return (deserializationFeature.getMask() & this.f12410O000000o) != 0;
    }

    public final int O00000o() {
        return this.f12410O000000o;
    }

    public static aii O00000oO() {
        return aij.O000000o();
    }

    public final api O00000oo() {
        return this.O00000o0;
    }

    public final <T extends ajq> T O00000Oo(ajv ajv) {
        return O0000Oo().O00000o0(this, ajv, this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anv.O000000o(_m_j.ajs, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
     arg types: [_m_j.ajs, _m_j.ajv, _m_j.ajs]
     candidates:
      _m_j.anv.O000000o(_m_j.ake, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
      _m_j.anv.O000000o(_m_j.akr<?>, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
      _m_j.anv.O000000o(_m_j.ajs, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq */
    public final <T extends ajq> T O00000o0(ajv ajv) {
        return O0000Oo().O000000o(this, ajv, (anv.O000000o) this);
    }
}

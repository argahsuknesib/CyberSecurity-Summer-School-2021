package _m_j;

import _m_j.anv;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Map;

public final class ake extends aks<SerializationFeature, ake> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final int f12416O000000o = O000000o(SerializationFeature.class);
    protected JsonInclude.Include O00000Oo = null;
    protected final aqb O00000o0 = null;

    public ake(akn akn, aoe aoe, Map<ash, Class<?>> map) {
        super(akn, aoe, map);
    }

    public final AnnotationIntrospector O000000o() {
        if (O000000o(MapperFeature.USE_ANNOTATIONS)) {
            return super.O000000o();
        }
        return any.f12492O000000o;
    }

    public final ajq O000000o(ajv ajv) {
        return O0000Oo().O000000o((akr<?>) this, ajv, this);
    }

    public final aoc<?> O00000o0() {
        aoc O00000o02 = super.O00000o0();
        if (!O000000o(MapperFeature.AUTO_DETECT_GETTERS)) {
            O00000o02 = O00000o02.O000000o(JsonAutoDetect.Visibility.NONE);
        }
        if (!O000000o(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
            O00000o02 = O00000o02.O00000Oo(JsonAutoDetect.Visibility.NONE);
        }
        return !O000000o(MapperFeature.AUTO_DETECT_FIELDS) ? O00000o02.O00000oO(JsonAutoDetect.Visibility.NONE) : O00000o02;
    }

    public final boolean O000000o(SerializationFeature serializationFeature) {
        return (serializationFeature.getMask() & this.f12416O000000o) != 0;
    }

    public final JsonInclude.Include O00000Oo() {
        JsonInclude.Include include = this.O00000Oo;
        if (include != null) {
            return include;
        }
        return JsonInclude.Include.ALWAYS;
    }

    public final aqb O00000o() {
        return this.O00000o0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anv.O000000o(_m_j.ake, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
     arg types: [_m_j.ake, _m_j.ajv, _m_j.ake]
     candidates:
      _m_j.anv.O000000o(_m_j.ajs, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
      _m_j.anv.O000000o(_m_j.akr<?>, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq
      _m_j.anv.O000000o(_m_j.ake, _m_j.ajv, _m_j.anv$O000000o):_m_j.ajq */
    public final <T extends ajq> T O00000Oo(ajv ajv) {
        return O0000Oo().O000000o(this, ajv, (anv.O000000o) this);
    }

    public final String toString() {
        return "[SerializationConfig: flags=0x" + Integer.toHexString(this.f12416O000000o) + "]";
    }
}

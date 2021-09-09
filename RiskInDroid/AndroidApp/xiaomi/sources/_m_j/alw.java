package _m_j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;

public final class alw {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f12445O000000o;
    private final boolean O00000Oo;
    private final Class<?> O00000o0;

    public alw(ajv ajv, Object obj) {
        this.f12445O000000o = obj;
        this.O00000Oo = ajv.O0000Oo0();
        this.O00000o0 = ajv.O00000Oo();
    }

    public final Object O000000o(ajt ajt) throws JsonProcessingException {
        if (!this.O00000Oo || !ajt.O000000o(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            return this.f12445O000000o;
        }
        throw ajt.O00000Oo("Can not map JSON null into type " + this.O00000o0.getName() + " (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
    }
}

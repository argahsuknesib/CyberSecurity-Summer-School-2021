package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Map;

public final class apq {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajr f12514O000000o;
    protected final anm O00000Oo;
    protected arm O00000o0;

    public apq(ajr ajr, anm anm, arm arm) {
        this.O00000Oo = anm;
        this.f12514O000000o = ajr;
        this.O00000o0 = arm;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws Exception {
        Object O00000Oo2 = this.O00000Oo.O00000Oo(obj);
        if (O00000Oo2 != null) {
            if (O00000Oo2 instanceof Map) {
                this.O00000o0.O000000o((Map<?, ?>) ((Map) O00000Oo2), jsonGenerator, akf);
                return;
            }
            throw new JsonMappingException("Value returned by 'any-getter' (" + this.O00000Oo.O00000Oo() + "()) not java.util.Map but " + O00000Oo2.getClass().getName());
        }
    }

    public final void O000000o(akf akf) throws JsonMappingException {
        this.O00000o0 = (arm) this.O00000o0.O000000o(akf, this.f12514O000000o);
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public final class aqw extends ara {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final atb f12538O000000o;

    public final boolean O000000o() {
        return true;
    }

    public aqw(ara ara, atb atb) {
        super(ara, atb);
        this.f12538O000000o = atb;
    }

    private aqw(aqw aqw, aqn aqn) {
        super(aqw, aqn);
        this.f12538O000000o = aqw.f12538O000000o;
    }

    private aqw(aqw aqw, String[] strArr) {
        super(aqw, strArr);
        this.f12538O000000o = aqw.f12538O000000o;
    }

    public final ajz<Object> O000000o(atb atb) {
        return new aqw(this, atb);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        if (this.O0000OOo != null) {
            aqn aqn = this.O0000OOo;
            aqx O000000o2 = akf.O000000o(obj, aqn.O00000o0);
            Object obj2 = O000000o2.O00000o0;
            if (obj2 != null) {
                O000000o2.O00000Oo.O000000o(obj2, jsonGenerator, akf);
                return;
            }
            O000000o2.O00000Oo = aqn.O00000o;
            Object O00000Oo = O000000o2.f12539O000000o.O00000Oo(obj);
            O000000o2.O00000o0 = O00000Oo;
            jsonGenerator.O00000o();
            aja aja = aqn.O00000Oo;
            if (aja != null) {
                jsonGenerator.O000000o((ain) aja);
                aqn.O00000o.O000000o(O00000Oo, jsonGenerator, akf);
            }
            if (this.O00000oo != null) {
                O00000o0(obj, jsonGenerator, akf);
            } else {
                O00000Oo(obj, jsonGenerator, akf);
            }
            jsonGenerator.O00000oO();
        } else if (this.O00000oo != null) {
            O00000o0(obj, jsonGenerator, akf);
        } else {
            O00000Oo(obj, jsonGenerator, akf);
        }
    }

    public final String toString() {
        return "UnwrappingBeanSerializer for " + O00000Oo().getName();
    }

    public final /* synthetic */ ara O000000o(String[] strArr) {
        return new aqw(this, strArr);
    }

    public final /* synthetic */ ara O000000o(aqn aqn) {
        return new aqw(this, aqn);
    }
}

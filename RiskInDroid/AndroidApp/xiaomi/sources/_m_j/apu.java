package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public final class apu extends ara {
    public apu(ajv ajv, apv apv, apt[] aptArr, apt[] aptArr2) {
        super(ajv, apv, aptArr, aptArr2);
    }

    private apu(ara ara, aqn aqn) {
        super(ara, aqn);
    }

    private apu(ara ara, String[] strArr) {
        super(ara, strArr);
    }

    public static apu O000000o(ajv ajv) {
        return new apu(ajv, null, O00000Oo, null);
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
            return;
        }
        jsonGenerator.O00000o();
        if (this.O00000oo != null) {
            O00000o0(obj, jsonGenerator, akf);
        } else {
            O00000Oo(obj, jsonGenerator, akf);
        }
        jsonGenerator.O00000oO();
    }

    public final String toString() {
        return "BeanSerializer for " + O00000Oo().getName();
    }

    public final /* synthetic */ ara O000000o(String[] strArr) {
        return new apu(this, strArr);
    }

    public final /* synthetic */ ara O000000o(aqn aqn) {
        return new apu(this, aqn);
    }
}

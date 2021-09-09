package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;

public final class aqv extends apt {
    protected final atb O0000oO0;

    public aqv(apt apt, atb atb) {
        super(apt);
        this.O0000oO0 = atb;
    }

    private aqv(aqv aqv, atb atb, aja aja) {
        super(aqv, aja);
        this.O0000oO0 = atb;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws Exception {
        Object O000000o2 = O000000o(obj);
        if (O000000o2 != null) {
            ajz<Object> ajz = this.O0000Oo;
            if (ajz == null) {
                Class<?> cls = O000000o2.getClass();
                aqp aqp = this.O0000Ooo;
                ajz<Object> O000000o3 = aqp.O000000o(cls);
                ajz = O000000o3 == null ? O000000o(aqp, cls, akf) : O000000o3;
            }
            if (this.O0000o0 != null) {
                if (f12516O000000o == this.O0000o0) {
                    if (ajz.O000000o(O000000o2)) {
                        return;
                    }
                } else if (this.O0000o0.equals(O000000o2)) {
                    return;
                }
            }
            if (O000000o2 == obj) {
                O00000o0(ajz);
            }
            if (!ajz.O000000o()) {
                jsonGenerator.O000000o((ain) this.O0000OOo);
            }
            if (this.O0000o0o == null) {
                ajz.O000000o(O000000o2, jsonGenerator, akf);
            } else {
                ajz.O000000o(O000000o2, jsonGenerator, akf, this.O0000o0o);
            }
        }
    }

    public final void O000000o(ajz<Object> ajz) {
        super.O000000o(ajz);
        if (this.O0000Oo != null) {
            atb atb = this.O0000oO0;
            if (this.O0000Oo.O000000o()) {
                atb = atb.O000000o(atb, ((aqw) this.O0000Oo).f12538O000000o);
            }
            this.O0000Oo = this.O0000Oo.O000000o(atb);
        }
    }

    public final ajz<Object> O000000o(aqp aqp, Class<?> cls, akf akf) throws JsonMappingException {
        ajz<Object> ajz;
        if (this.O0000o != null) {
            ajz = akf.O000000o(akf.O000000o(this.O0000o, cls), this);
        } else {
            ajz = akf.O000000o(cls, this);
        }
        atb atb = this.O0000oO0;
        if (ajz.O000000o()) {
            atb = atb.O000000o(atb, ((aqw) ajz).f12538O000000o);
        }
        ajz<Object> O000000o2 = ajz.O000000o(atb);
        this.O0000Ooo = this.O0000Ooo.O000000o(cls, O000000o2);
        return O000000o2;
    }

    public final /* synthetic */ apt O000000o(atb atb) {
        return new aqv(this, atb.O000000o(atb, this.O0000oO0), new aja(atb.O000000o(this.O0000OOo.O000000o())));
    }
}

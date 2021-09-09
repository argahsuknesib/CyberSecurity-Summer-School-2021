package _m_j;

import _m_j.aqp;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public abstract class aqz<T> extends apy<T> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final boolean f12540O000000o;
    protected final ajv O00000Oo;
    protected final ajz<Object> O00000o;
    protected final aoi O00000o0;
    protected final ajr O00000oO;
    protected aqp O00000oo;

    public abstract aqz<T> O000000o(ajr ajr, aoi aoi, ajz<?> ajz);

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(T t, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected aqz(Class<?> cls, ajv ajv, boolean z, aoi aoi, ajr ajr, ajz<Object> ajz) {
        super(cls, (byte) 0);
        boolean z2 = false;
        this.O00000Oo = ajv;
        if (z || (ajv != null && ajv.O0000Oo())) {
            z2 = true;
        }
        this.f12540O000000o = z2;
        this.O00000o0 = aoi;
        this.O00000oO = ajr;
        this.O00000o = ajz;
        this.O00000oo = aqp.O000000o();
    }

    protected aqz(aqz<?> aqz, aoi aoi, ajz<?> ajz) {
        super(aqz);
        this.O00000Oo = aqz.O00000Oo;
        this.f12540O000000o = aqz.f12540O000000o;
        this.O00000o0 = aoi;
        this.O00000oO = aqz.O00000oO;
        this.O00000o = ajz;
        this.O00000oo = aqz.O00000oo;
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        ajv ajv;
        aoi aoi = this.O00000o0;
        if (aoi != null) {
            aoi = aoi.O000000o(ajr);
        }
        ajz<?> ajz = this.O00000o;
        if (ajz == null) {
            if (this.f12540O000000o && (ajv = this.O00000Oo) != null) {
                ajz = akf.O000000o(ajv, ajr);
            }
        } else if (ajz instanceof apz) {
            ajz = ((apz) ajz).O000000o(akf, ajr);
        }
        if (ajz == this.O00000o && ajr == this.O00000oO && this.O00000o0 == aoi) {
            return this;
        }
        return O000000o(ajr, aoi, ajz);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        if (!akf.O000000o(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) || !O00000Oo(obj)) {
            jsonGenerator.O00000Oo();
            O00000Oo(obj, jsonGenerator, akf);
            jsonGenerator.O00000o0();
            return;
        }
        O00000Oo(obj, jsonGenerator, akf);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        aoi.O00000o0(obj, jsonGenerator);
        O00000Oo(obj, jsonGenerator, akf);
        aoi.O00000oo(obj, jsonGenerator);
    }

    /* access modifiers changed from: protected */
    public final ajz<Object> O000000o(aqp aqp, Class<?> cls, akf akf) throws JsonMappingException {
        aqp.O00000o O000000o2 = aqp.O000000o(cls, akf, this.O00000oO);
        if (aqp != O000000o2.O00000Oo) {
            this.O00000oo = O000000o2.O00000Oo;
        }
        return O000000o2.f12530O000000o;
    }

    /* access modifiers changed from: protected */
    public final ajz<Object> O000000o(aqp aqp, ajv ajv, akf akf) throws JsonMappingException {
        aqp.O00000o O000000o2 = aqp.O000000o(ajv, akf, this.O00000oO);
        if (aqp != O000000o2.O00000Oo) {
            this.O00000oo = O000000o2.O00000Oo;
        }
        return O000000o2.f12530O000000o;
    }
}

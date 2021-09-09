package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public abstract class aso extends ajv implements ajy {
    volatile String O0000O0o;

    /* access modifiers changed from: protected */
    public abstract String O0000oOO();

    protected aso(Class<?> cls, int i, Object obj, Object obj2) {
        super(cls, i, obj, obj2);
    }

    public final String O000000o() {
        String str = this.O0000O0o;
        return str == null ? O0000oOO() : str;
    }

    public final <T> T O0000oO0() {
        return this.O00000o0;
    }

    public final <T> T O0000oO() {
        return this.O00000o;
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        aoi.O000000o(this, jsonGenerator);
        O000000o(jsonGenerator, akf);
        aoi.O00000o(this, jsonGenerator);
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O00000Oo(O000000o());
    }
}

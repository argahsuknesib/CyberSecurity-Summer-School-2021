package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aom extends aoy {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12502O000000o;

    public aom(aog aog, ajr ajr, String str) {
        super(aog, ajr);
        this.f12502O000000o = str;
    }

    public final void O00000oO(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        O00000Oo(jsonGenerator, O000000o(obj));
    }

    public final void O00000oo(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        O00000Oo(jsonGenerator, O000000o(obj));
    }

    public final void O00000o(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        O00000Oo(jsonGenerator, O000000o(obj));
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        O00000Oo(jsonGenerator, str);
    }

    private void O00000Oo(JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        jsonGenerator.O00000oO();
        jsonGenerator.O000000o(this.f12502O000000o, str);
    }

    public final void O00000Oo(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
    }

    public final void O00000o0(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
    }

    public final void O000000o(JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
    }

    public final /* synthetic */ aoi O000000o(ajr ajr) {
        if (this.O00000o0 == ajr) {
            return this;
        }
        return new aom(this.O00000Oo, ajr, this.f12502O000000o);
    }
}

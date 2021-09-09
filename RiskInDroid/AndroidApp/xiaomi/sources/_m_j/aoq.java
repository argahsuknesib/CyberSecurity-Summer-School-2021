package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aoq extends aoy {
    public aoq(aog aog, ajr ajr) {
        super(aog, ajr);
    }

    public final void O00000Oo(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O00000oo(O000000o(obj));
    }

    public final void O00000o0(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O000000o(O000000o(obj));
        jsonGenerator.O00000Oo();
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O000000o(O000000o(obj));
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O000000o(O000000o(obj, cls));
    }

    public final void O00000oO(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000oO();
        jsonGenerator.O00000oO();
    }

    public final void O00000oo(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o0();
        jsonGenerator.O00000oO();
    }

    public final void O00000o(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000oO();
    }

    public final void O000000o(JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O00000oo(str);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        O00000oO(obj, jsonGenerator);
    }

    public final /* synthetic */ aoi O000000o(ajr ajr) {
        if (this.O00000o0 == ajr) {
            return this;
        }
        return new aoq(this.O00000Oo, ajr);
    }
}

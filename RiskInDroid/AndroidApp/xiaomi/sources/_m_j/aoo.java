package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aoo extends aok {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12504O000000o;

    public aoo(aog aog, ajr ajr, String str) {
        super(aog, ajr);
        this.f12504O000000o = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public aoo O00000Oo(ajr ajr) {
        if (this.O00000o0 == ajr) {
            return this;
        }
        return new aoo(this.O00000Oo, ajr, this.f12504O000000o);
    }

    public final void O00000Oo(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O000000o(this.f12504O000000o, O000000o(obj));
    }

    public final void O00000oO(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.O00000oO();
    }

    public final void O000000o(JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        jsonGenerator.O000000o(this.f12504O000000o, str);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, String str) throws IOException, JsonProcessingException {
        jsonGenerator.O00000oO();
    }
}

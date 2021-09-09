package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public abstract class aqy<T> extends apy<T> {
    protected final ajr O00000o0;

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(T t, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException;

    protected aqy(Class<T> cls) {
        super(cls);
        this.O00000o0 = null;
    }

    protected aqy(Class cls, byte b) {
        super(cls);
        this.O00000o0 = null;
    }

    protected aqy(aqy<?> aqy, ajr ajr) {
        super(aqy.O0000OoO, (byte) 0);
        this.O00000o0 = ajr;
    }

    public final void O000000o(T t, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        if (!akf.O000000o(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) || !O00000Oo((Object) t)) {
            jsonGenerator.O00000Oo();
            O00000Oo(t, jsonGenerator, akf);
            jsonGenerator.O00000o0();
            return;
        }
        O00000Oo(t, jsonGenerator, akf);
    }

    public final void O000000o(T t, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        aoi.O00000o0(t, jsonGenerator);
        O00000Oo(t, jsonGenerator, akf);
        aoi.O00000oo(t, jsonGenerator);
    }
}

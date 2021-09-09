package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public abstract class asa<T> extends asb<T> {
    protected asa(Class<T> cls) {
        super(cls);
    }

    protected asa(Class<?> cls, byte b) {
        super(cls);
    }

    public void O000000o(T t, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        aoi.O000000o(t, jsonGenerator);
        O000000o(t, jsonGenerator, akf);
        aoi.O00000o(t, jsonGenerator);
    }
}

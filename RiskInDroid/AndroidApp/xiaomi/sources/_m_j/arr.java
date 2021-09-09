package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

@akg
public final class arr<T> extends asb<T> {
    public arr(Class<?> cls) {
        super(cls, (byte) 0);
    }

    public final void O000000o(T t, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O00000o(t.toString());
    }

    public final void O000000o(T t, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        aoi.O000000o(t, jsonGenerator);
        O000000o(t, jsonGenerator, akf);
        aoi.O00000o(t, jsonGenerator);
    }
}

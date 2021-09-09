package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public final class aqu extends asb<Object> {
    public aqu() {
        super(Object.class);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonMappingException {
        if (akf.O000000o(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            O00000Oo(obj);
        }
        jsonGenerator.O00000o();
        jsonGenerator.O00000oO();
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        if (akf.O000000o(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            O00000Oo(obj);
        }
        aoi.O00000Oo(obj, jsonGenerator);
        aoi.O00000oO(obj, jsonGenerator);
    }

    private static void O00000Oo(Object obj) throws JsonMappingException {
        throw new JsonMappingException("No serializer found for class " + obj.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.SerializationFeature.FAIL_ON_EMPTY_BEANS) )");
    }
}

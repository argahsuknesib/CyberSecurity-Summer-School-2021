package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

@akg
public final class ase extends asb<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ase f12568O000000o = new ase();

    public ase() {
        super(Object.class);
    }

    public final boolean O000000o(Object obj) {
        String obj2;
        if (obj == null || (obj2 = obj.toString()) == null || obj2.length() == 0) {
            return true;
        }
        return false;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        jsonGenerator.O00000Oo(obj.toString());
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonGenerationException {
        aoi.O000000o(obj, jsonGenerator);
        O000000o(obj, jsonGenerator, akf);
        aoi.O00000o(obj, jsonGenerator);
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Date;

public final class ary extends asb<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    static final ary f12562O000000o = new ary();

    public ary() {
        super(Object.class);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        if (obj instanceof Date) {
            akf.O00000Oo((Date) obj, jsonGenerator);
        } else {
            jsonGenerator.O000000o(obj.toString());
        }
    }
}

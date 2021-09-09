package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aqt extends ajz<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final aoi f12537O000000o;
    protected final ajz<Object> O00000Oo;

    public aqt(aoi aoi, ajz<?> ajz) {
        this.f12537O000000o = aoi;
        this.O00000Oo = ajz;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        this.O00000Oo.O000000o(obj, jsonGenerator, akf, this.f12537O000000o);
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        this.O00000Oo.O000000o(obj, jsonGenerator, akf, aoi);
    }

    public final Class<Object> O00000Oo() {
        return Object.class;
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class amf extends ajw<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    final aof f12454O000000o;
    final ajw<Object> O00000Oo;

    public amf(aof aof, ajw<Object> ajw) {
        this.f12454O000000o = aof;
        this.O00000Oo = ajw;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return this.O00000Oo.O000000o(jsonParser, ajt, this.f12454O000000o);
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }
}

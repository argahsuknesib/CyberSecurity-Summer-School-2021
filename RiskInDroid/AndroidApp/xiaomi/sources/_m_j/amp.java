package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.EnumSet;

public final class amp extends amy<EnumSet<?>> implements alc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12462O000000o;
    protected final Class<Enum> O00000Oo;
    protected ajw<Enum<?>> O00000o0;

    public final boolean O00000o0() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [_m_j.ajw<?>, _m_j.ajw<java.lang.Enum<?>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public amp(ajv ajv, ajw<?> r3) {
        super(EnumSet.class);
        this.f12462O000000o = ajv;
        this.O00000Oo = ajv.O00000Oo();
        this.O00000o0 = r3;
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        ajw ajw = this.O00000o0;
        if (ajw == null) {
            ajw = ajt.O000000o(this.f12462O000000o, ajr);
        } else if (ajw instanceof alc) {
            ajw = ((alc) ajw).O000000o(ajt, ajr);
        }
        if (this.O00000o0 == ajw) {
            return this;
        }
        return new amp(this.f12462O000000o, ajw);
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000Oo(jsonParser, ajt);
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O0000Oo0()) {
            EnumSet noneOf = EnumSet.noneOf(this.O00000Oo);
            while (true) {
                JsonToken O00000Oo2 = jsonParser.O00000Oo();
                if (O00000Oo2 == JsonToken.END_ARRAY) {
                    return noneOf;
                }
                if (O00000Oo2 != JsonToken.VALUE_NULL) {
                    Enum O000000o2 = this.O00000o0.O000000o(jsonParser, ajt);
                    if (O000000o2 != null) {
                        noneOf.add(O000000o2);
                    }
                } else {
                    throw ajt.O00000Oo((Class<?>) this.O00000Oo);
                }
            }
        } else {
            throw ajt.O00000Oo((Class<?>) EnumSet.class);
        }
    }
}

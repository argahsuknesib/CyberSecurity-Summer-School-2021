package _m_j;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public class aoj extends aov {
    public aoj(ajv ajv, aog aog, String str, boolean z, Class<?> cls) {
        super(ajv, aog, str, z, cls);
    }

    public aoj(aoj aoj, ajr ajr) {
        super(aoj, ajr);
    }

    public aof O000000o(ajr ajr) {
        if (ajr == this.O00000o0) {
            return this;
        }
        return new aoj(this, ajr);
    }

    public JsonTypeInfo.As O000000o() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public final Object O00000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public Object O00000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    private final Object O00000oO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        boolean O0000Oo0 = jsonParser.O0000Oo0();
        String O000000o2 = O000000o(jsonParser);
        ajw<Object> O000000o3 = O000000o(ajt, O000000o2);
        if (this.O00000oo && jsonParser.O00000oO() == JsonToken.START_OBJECT) {
            ath ath = new ath(null);
            ath.O00000o();
            ath.O000000o(this.O00000oO);
            ath.O00000Oo(O000000o2);
            jsonParser = ajn.O000000o(ath.O000000o(jsonParser), jsonParser);
            jsonParser.O00000Oo();
        }
        Object O000000o4 = O000000o3.O000000o(jsonParser, ajt);
        if (!O0000Oo0 || jsonParser.O00000Oo() == JsonToken.END_ARRAY) {
            return O000000o4;
        }
        throw ajt.O000000o(jsonParser, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }

    private String O000000o(JsonParser jsonParser) throws IOException, JsonProcessingException {
        if (!jsonParser.O0000Oo0()) {
            if (this.O00000o != null) {
                return this.f12509O000000o.O000000o();
            }
            JsonToken jsonToken = JsonToken.START_ARRAY;
            throw ajt.O000000o(jsonParser, jsonToken, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + O00000o0());
        } else if (jsonParser.O00000Oo() == JsonToken.VALUE_STRING) {
            String O0000OoO = jsonParser.O0000OoO();
            jsonParser.O00000Oo();
            return O0000OoO;
        } else if (this.O00000o != null) {
            return this.f12509O000000o.O000000o();
        } else {
            JsonToken jsonToken2 = JsonToken.VALUE_STRING;
            throw ajt.O000000o(jsonParser, jsonToken2, "need JSON String that contains type id (for subtype of " + O00000o0() + ")");
        }
    }
}

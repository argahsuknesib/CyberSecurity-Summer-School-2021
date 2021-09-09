package _m_j;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public final class aop extends aov {
    public aop(ajv ajv, aog aog, String str, boolean z) {
        super(ajv, aog, str, z, null);
    }

    private aop(aop aop, ajr ajr) {
        super(aop, ajr);
    }

    public final aof O000000o(ajr ajr) {
        if (ajr == this.O00000o0) {
            return this;
        }
        return new aop(this, ajr);
    }

    public final JsonTypeInfo.As O000000o() {
        return JsonTypeInfo.As.WRAPPER_OBJECT;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public final Object O00000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    public final Object O00000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        return O00000oO(jsonParser, ajt);
    }

    private final Object O00000oO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() != JsonToken.START_OBJECT) {
            JsonToken jsonToken = JsonToken.START_OBJECT;
            throw ajt.O000000o(jsonParser, jsonToken, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + O00000o0());
        } else if (jsonParser.O00000Oo() == JsonToken.FIELD_NAME) {
            String O0000OoO = jsonParser.O0000OoO();
            ajw<Object> O000000o2 = O000000o(ajt, O0000OoO);
            jsonParser.O00000Oo();
            if (this.O00000oo && jsonParser.O00000oO() == JsonToken.START_OBJECT) {
                ath ath = new ath(null);
                ath.O00000o();
                ath.O000000o(this.O00000oO);
                ath.O00000Oo(O0000OoO);
                jsonParser = ajn.O000000o(ath.O000000o(jsonParser), jsonParser);
                jsonParser.O00000Oo();
            }
            Object O000000o3 = O000000o2.O000000o(jsonParser, ajt);
            if (jsonParser.O00000Oo() == JsonToken.END_OBJECT) {
                return O000000o3;
            }
            throw ajt.O000000o(jsonParser, JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value");
        } else {
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            throw ajt.O000000o(jsonParser, jsonToken2, "need JSON String that contains type id (for subtype of " + O00000o0() + ")");
        }
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

@akg
public final class ane extends anb<String> {
    public ane() {
        super(String.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public String O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_STRING) {
            return jsonParser.O0000OoO();
        }
        if (O00000oO == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object O00oOooO = jsonParser.O00oOooO();
            if (O00oOooO == null) {
                return null;
            }
            if (O00oOooO instanceof byte[]) {
                return aij.O000000o().O000000o((byte[]) O00oOooO, false);
            }
            return O00oOooO.toString();
        } else if (O00000oO.isScalarValue()) {
            return jsonParser.O0000OoO();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return O000000o(jsonParser, ajt);
    }
}

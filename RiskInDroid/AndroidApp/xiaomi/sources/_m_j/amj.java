package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

@akg
public final class amj extends anb<Class<?>> {
    public amj() {
        super(Class.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public Class<?> O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_STRING) {
            try {
                return asw.O000000o(jsonParser.O0000OoO().trim());
            } catch (Exception e) {
                throw ajt.O000000o(this.O0000oOO, asw.O000000o((Throwable) e));
            }
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }
}

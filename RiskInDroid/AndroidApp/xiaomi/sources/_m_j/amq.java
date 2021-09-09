package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public abstract class amq<T> extends anb<T> {
    /* access modifiers changed from: protected */
    public abstract T O000000o(String str) throws IOException, JsonProcessingException;

    protected amq(Class<?> cls) {
        super(cls);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.amq.O000000o(java.lang.Object, _m_j.ajt):T
     arg types: [T, _m_j.ajt]
     candidates:
      _m_j.amq.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajt):T
      _m_j.ajw.O000000o(com.fasterxml.jackson.core.JsonParser, _m_j.ajt):T
      _m_j.amq.O000000o(java.lang.Object, _m_j.ajt):T */
    public final T O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                T O000000o2 = O000000o(trim);
                if (O000000o2 != null) {
                    return O000000o2;
                }
            } catch (IllegalArgumentException unused) {
            }
            throw ajt.O00000Oo(this.O0000oOO, "not a valid textual representation");
        } else if (jsonParser.O00000oO() == JsonToken.VALUE_EMBEDDED_OBJECT) {
            T O00oOooO = jsonParser.O00oOooO();
            if (O00oOooO == null) {
                return null;
            }
            if (this.O0000oOO.isAssignableFrom(O00oOooO.getClass())) {
                return O00oOooO;
            }
            return O000000o((Object) O00oOooO, ajt);
        } else {
            throw ajt.O00000Oo((Class<?>) this.O0000oOO);
        }
    }

    /* access modifiers changed from: protected */
    public T O000000o(Object obj, ajt ajt) throws IOException, JsonProcessingException {
        throw ajt.O00000Oo("Don't know how to convert embedded Object of type " + obj.getClass().getName() + " into " + this.O0000oOO.getName());
    }
}

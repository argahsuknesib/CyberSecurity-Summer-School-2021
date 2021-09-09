package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class apn extends app {
    protected final Object O00000o0;

    public apn(Object obj) {
        this.O00000o0 = obj;
    }

    public final String O000000o() {
        Object obj = this.O00000o0;
        return obj == null ? "null" : obj.toString();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        Object obj = this.O00000o0;
        if (obj == null) {
            jsonGenerator.O00000oo();
        } else {
            jsonGenerator.O000000o(obj);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        apn apn = (apn) obj;
        Object obj2 = this.O00000o0;
        if (obj2 == null) {
            return apn.O00000o0 == null;
        }
        return obj2.equals(apn.O00000o0);
    }

    public final int hashCode() {
        return this.O00000o0.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.O00000o0);
    }
}

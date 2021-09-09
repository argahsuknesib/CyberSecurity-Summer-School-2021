package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aph extends apl {
    private static final aph[] O00000o = new aph[12];
    final int O00000o0;

    static {
        for (int i = 0; i < 12; i++) {
            O00000o[i] = new aph(i - 1);
        }
    }

    private aph(int i) {
        this.O00000o0 = i;
    }

    public static aph O000000o(int i) {
        if (i > 10 || i < -1) {
            return new aph(i);
        }
        return O00000o[i - -1];
    }

    public final String O000000o() {
        return aix.O000000o(this.O00000o0);
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O000000o(this.O00000o0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == getClass() && ((aph) obj).O00000o0 == this.O00000o0;
    }

    public final int hashCode() {
        return this.O00000o0;
    }
}

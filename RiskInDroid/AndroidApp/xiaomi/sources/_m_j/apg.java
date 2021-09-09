package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class apg extends apl {
    protected final double O00000o0;

    private apg(double d) {
        this.O00000o0 = d;
    }

    public static apg O000000o(double d) {
        return new apg(d);
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
        return obj != null && obj.getClass() == getClass() && ((apg) obj).O00000o0 == this.O00000o0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.O00000o0);
        return ((int) doubleToLongBits) ^ ((int) (doubleToLongBits >> 32));
    }
}

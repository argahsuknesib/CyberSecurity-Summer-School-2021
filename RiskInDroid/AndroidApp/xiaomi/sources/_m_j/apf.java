package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.math.BigDecimal;

public final class apf extends apl {
    private static final BigDecimal O00000o = BigDecimal.valueOf(-2147483648L);
    private static final BigDecimal O00000oO = BigDecimal.valueOf(2147483647L);
    private static final BigDecimal O00000oo = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final BigDecimal O0000O0o = BigDecimal.valueOf(Long.MAX_VALUE);
    protected final BigDecimal O00000o0;

    private apf(BigDecimal bigDecimal) {
        this.O00000o0 = bigDecimal;
    }

    public static apf O000000o(BigDecimal bigDecimal) {
        return new apf(bigDecimal);
    }

    public final String O000000o() {
        return this.O00000o0.toString();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O000000o(this.O00000o0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return ((apf) obj).O00000o0.equals(this.O00000o0);
        }
        return false;
    }

    public final int hashCode() {
        return this.O00000o0.hashCode();
    }
}

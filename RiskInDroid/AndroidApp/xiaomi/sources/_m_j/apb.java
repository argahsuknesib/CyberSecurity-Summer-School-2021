package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.math.BigInteger;

public final class apb extends apl {
    private static final BigInteger O00000o = BigInteger.valueOf(-2147483648L);
    private static final BigInteger O00000oO = BigInteger.valueOf(2147483647L);
    private static final BigInteger O00000oo = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger O0000O0o = BigInteger.valueOf(Long.MAX_VALUE);
    protected final BigInteger O00000o0;

    private apb(BigInteger bigInteger) {
        this.O00000o0 = bigInteger;
    }

    public static apb O000000o(BigInteger bigInteger) {
        return new apb(bigInteger);
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
            return ((apb) obj).O00000o0.equals(this.O00000o0);
        }
        return false;
    }

    public final int hashCode() {
        return this.O00000o0.hashCode();
    }
}

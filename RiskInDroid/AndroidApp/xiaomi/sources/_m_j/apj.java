package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class apj extends apl {
    final long O00000o0;

    private apj(long j) {
        this.O00000o0 = j;
    }

    public static apj O000000o(long j) {
        return new apj(j);
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
        return obj != null && obj.getClass() == getClass() && ((apj) obj).O00000o0 == this.O00000o0;
    }

    public final int hashCode() {
        long j = this.O00000o0;
        return ((int) j) ^ ((int) (j >> 32));
    }
}

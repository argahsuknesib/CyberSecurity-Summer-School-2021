package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class aio extends JsonGenerator {
    protected ail O00000Oo;
    protected boolean O00000o;
    protected int O00000o0;
    protected ajc O00000oO = ajc.O0000O0o();
    protected boolean O00000oo;

    /* access modifiers changed from: protected */
    public abstract void O0000O0o(String str) throws IOException, JsonGenerationException;

    protected aio(int i, ail ail) {
        this.O00000o0 = i;
        this.O00000Oo = ail;
        this.O00000o = O000000o(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
    }

    public final boolean O000000o(JsonGenerator.Feature feature) {
        return (feature.getMask() & this.O00000o0) != 0;
    }

    public final JsonGenerator O000000o() {
        return O000000o((aim) new ajl());
    }

    public final ajc O0000OOo() {
        return this.O00000oO;
    }

    public void O000000o(ain ain) throws IOException, JsonGenerationException {
        O000000o(ain.O000000o());
    }

    public void O00000Oo(ain ain) throws IOException, JsonGenerationException {
        O00000Oo(ain.O000000o());
    }

    public final void O00000o(String str) throws IOException, JsonGenerationException {
        O0000O0o("write raw value");
        O00000o0(str);
    }

    public final void O000000o(Object obj) throws IOException, JsonProcessingException {
        if (obj == null) {
            O00000oo();
            return;
        }
        ail ail = this.O00000Oo;
        if (ail != null) {
            ail.O000000o(this, obj);
        } else if (obj == null) {
            O00000oo();
        } else if (obj instanceof String) {
            O00000Oo((String) obj);
        } else {
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    O000000o(number.intValue());
                    return;
                } else if (number instanceof Long) {
                    O000000o(number.longValue());
                    return;
                } else if (number instanceof Double) {
                    O000000o(number.doubleValue());
                    return;
                } else if (number instanceof Float) {
                    O000000o(number.floatValue());
                    return;
                } else if (number instanceof Short) {
                    O000000o((int) number.shortValue());
                    return;
                } else if (number instanceof Byte) {
                    O000000o((int) number.byteValue());
                    return;
                } else if (number instanceof BigInteger) {
                    O000000o((BigInteger) number);
                    return;
                } else if (number instanceof BigDecimal) {
                    O000000o((BigDecimal) number);
                    return;
                } else if (number instanceof AtomicInteger) {
                    O000000o(((AtomicInteger) number).get());
                    return;
                } else if (number instanceof AtomicLong) {
                    O000000o(((AtomicLong) number).get());
                    return;
                }
            } else if (obj instanceof byte[]) {
                O000000o((byte[]) obj);
                return;
            } else if (obj instanceof Boolean) {
                O000000o(((Boolean) obj).booleanValue());
                return;
            } else if (obj instanceof AtomicBoolean) {
                O000000o(((AtomicBoolean) obj).get());
                return;
            }
            throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
        }
    }

    public void close() throws IOException {
        this.O00000oo = true;
    }

    protected static void O0000OOo(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    protected static void O0000Oo0() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }
}

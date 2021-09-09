package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class arp {

    @akg
    public static final class O00000o extends arn<Integer> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((Integer) obj).intValue());
        }

        public O00000o() {
            super(Integer.class);
        }
    }

    @akg
    public static final class O00000o0 extends asa<Number> {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000o0 f12552O000000o = new O00000o0();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((Number) obj).intValue());
        }

        public O00000o0() {
            super(Number.class);
        }
    }

    @akg
    public static final class O0000O0o extends asa<Long> {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O0000O0o f12553O000000o = new O0000O0o();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((Long) obj).longValue());
        }

        public O0000O0o() {
            super(Long.class);
        }
    }

    @akg
    public static final class O00000Oo extends asa<Float> {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000Oo f12551O000000o = new O00000Oo();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((Float) obj).floatValue());
        }

        public O00000Oo() {
            super(Float.class);
        }
    }

    @akg
    public static final class O000000o extends arn<Double> {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f12550O000000o = new O000000o();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(((Double) obj).doubleValue());
        }

        public O000000o() {
            super(Double.class);
        }
    }

    @akg
    public static final class O0000OOo extends asa<Number> {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O0000OOo f12554O000000o = new O0000OOo();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            Number number = (Number) obj;
            if (number instanceof BigDecimal) {
                jsonGenerator.O000000o((BigDecimal) number);
            } else if (number instanceof BigInteger) {
                jsonGenerator.O000000o((BigInteger) number);
            } else if (number instanceof Integer) {
                jsonGenerator.O000000o(number.intValue());
            } else if (number instanceof Long) {
                jsonGenerator.O000000o(number.longValue());
            } else if (number instanceof Double) {
                jsonGenerator.O000000o(number.doubleValue());
            } else if (number instanceof Float) {
                jsonGenerator.O000000o(number.floatValue());
            } else if ((number instanceof Byte) || (number instanceof Short)) {
                jsonGenerator.O000000o(number.intValue());
            } else {
                jsonGenerator.O00000oO(number.toString());
            }
        }

        public O0000OOo() {
            super(Number.class);
        }
    }
}

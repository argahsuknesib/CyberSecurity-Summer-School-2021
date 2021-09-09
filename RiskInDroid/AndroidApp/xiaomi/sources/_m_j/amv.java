package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class amv {

    public static abstract class O0000o<T> extends anb<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final T f12470O000000o;

        protected O0000o(Class<T> cls, T t) {
            super(cls);
            this.f12470O000000o = t;
        }

        public final T O000000o() {
            return this.f12470O000000o;
        }
    }

    @akg
    public static final class O00000o0 extends O0000o<Boolean> {
        public O00000o0(Class<Boolean> cls, Boolean bool) {
            super(cls, bool);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            return O00000oo(jsonParser, ajt);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O00000oo(jsonParser, ajt);
        }
    }

    @akg
    public static final class O00000o extends O0000o<Byte> {
        public O00000o(Class<Byte> cls, Byte b) {
            super(cls, b);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000O0o(jsonParser, ajt);
        }
    }

    @akg
    public static final class O00oOooO extends O0000o<Short> {
        public O00oOooO(Class<Short> cls, Short sh) {
            super(cls, sh);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000OOo(jsonParser, ajt);
        }
    }

    @akg
    public static final class O0000O0o extends O0000o<Character> {
        public O0000O0o(Class<Character> cls, Character ch) {
            super(cls, ch);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
                int O0000oOO = jsonParser.O0000oOO();
                if (O0000oOO >= 0 && O0000oOO <= 65535) {
                    return Character.valueOf((char) O0000oOO);
                }
            } else if (O00000oO == JsonToken.VALUE_STRING) {
                String O0000OoO = jsonParser.O0000OoO();
                if (O0000OoO.length() == 1) {
                    return Character.valueOf(O0000OoO.charAt(0));
                }
                if (O0000OoO.length() == 0) {
                    return (Character) O000000o();
                }
            }
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    @akg
    public static final class O0000Oo extends O0000o<Integer> {
        public O0000Oo(Class<Integer> cls, Integer num) {
            super(cls, num);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            return O0000OoO(jsonParser, ajt);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000OoO(jsonParser, ajt);
        }
    }

    @akg
    public static final class O0000o00 extends O0000o<Long> {
        public O0000o00(Class<Long> cls, Long l) {
            super(cls, l);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000Ooo(jsonParser, ajt);
        }
    }

    @akg
    public static final class O0000Oo0 extends O0000o<Float> {
        public O0000Oo0(Class<Float> cls, Float f) {
            super(cls, f);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000o0(jsonParser, ajt);
        }
    }

    @akg
    public static final class O0000OOo extends O0000o<Double> {
        public O0000OOo(Class<Double> cls, Double d) {
            super(cls, d);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            return O0000o0o(jsonParser, ajt);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return O0000o0o(jsonParser, ajt);
        }
    }

    @akg
    public static final class O0000o0 extends anb<Number> {
        public O0000o0() {
            super(Number.class);
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public Number O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
                if (ajt.O000000o(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.O0000oo0();
                }
                return jsonParser.O0000o0o();
            } else if (O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
                if (ajt.O000000o(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.O0000ooo();
                }
                return Double.valueOf(jsonParser.O0000ooO());
            } else if (O00000oO == JsonToken.VALUE_STRING) {
                String trim = jsonParser.O0000OoO().trim();
                try {
                    if (trim.indexOf(46) >= 0) {
                        if (ajt.O000000o(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return new BigDecimal(trim);
                        }
                        return new Double(trim);
                    } else if (ajt.O000000o(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                        return new BigInteger(trim);
                    } else {
                        long parseLong = Long.parseLong(trim);
                        if (parseLong > 2147483647L || parseLong < -2147483648L) {
                            return Long.valueOf(parseLong);
                        }
                        return Integer.valueOf((int) parseLong);
                    }
                } catch (IllegalArgumentException unused) {
                    throw ajt.O00000Oo(this.O0000oOO, "not a valid number");
                }
            } else {
                throw ajt.O000000o(this.O0000oOO, O00000oO);
            }
        }

        public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            int i = AnonymousClass1.f12469O000000o[jsonParser.O00000oO().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return O000000o(jsonParser, ajt);
            }
            return aof.O00000o0(jsonParser, ajt);
        }
    }

    @akg
    public static class O00000Oo extends anb<BigInteger> {
        public O00000Oo() {
            super(BigInteger.class);
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public BigInteger O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
                int i = AnonymousClass1.O00000Oo[jsonParser.O0000o().ordinal()];
                if (i == 1 || i == 2) {
                    return BigInteger.valueOf(jsonParser.O0000oOo());
                }
            } else if (O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.O0000ooo().toBigInteger();
            } else {
                if (O00000oO != JsonToken.VALUE_STRING) {
                    throw ajt.O000000o(this.O0000oOO, O00000oO);
                }
            }
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid representation");
            }
        }
    }

    /* renamed from: _m_j.amv$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12469O000000o = new int[JsonToken.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|5|6|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        static {
            try {
                O00000Oo[JsonParser.NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[JsonParser.NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12469O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 1;
            f12469O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 2;
            try {
                f12469O000000o[JsonToken.VALUE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @akg
    public static class O000000o extends anb<BigDecimal> {
        public O000000o() {
            super(BigDecimal.class);
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public BigDecimal O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.O0000ooo();
            }
            if (O00000oO == JsonToken.VALUE_STRING) {
                String trim = jsonParser.O0000OoO().trim();
                if (trim.length() == 0) {
                    return null;
                }
                try {
                    return new BigDecimal(trim);
                } catch (IllegalArgumentException unused) {
                    throw ajt.O00000Oo(this.O0000oOO, "not a valid representation");
                }
            } else {
                throw ajt.O000000o(this.O0000oOO, O00000oO);
            }
        }
    }
}

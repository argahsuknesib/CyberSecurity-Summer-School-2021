package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ath extends JsonGenerator {
    protected static final int O00000Oo = JsonParser.Feature.collectDefaults();
    protected int O00000o = O00000Oo;
    protected ail O00000o0;
    protected boolean O00000oO;
    protected O00000Oo O00000oo;
    protected O00000Oo O0000O0o;
    protected int O0000OOo;
    protected ajc O0000Oo0 = ajc.O0000O0o();

    public final JsonGenerator O000000o() {
        return this;
    }

    public final void O0000O0o() throws IOException {
    }

    public ath(ail ail) {
        this.O00000o0 = ail;
        O00000Oo o00000Oo = new O00000Oo();
        this.O0000O0o = o00000Oo;
        this.O00000oo = o00000Oo;
        this.O0000OOo = 0;
    }

    public final JsonParser O0000OOo() {
        return new O000000o(this.O00000oo, this.O00000o0);
    }

    public final JsonParser O000000o(JsonParser jsonParser) {
        O000000o o000000o = new O000000o(this.O00000oo, jsonParser.O000000o());
        o000000o.O000000o(jsonParser.O0000O0o());
        return o000000o;
    }

    public final ath O000000o(ath ath) throws IOException, JsonGenerationException {
        JsonParser O0000OOo2 = ath.O0000OOo();
        while (O0000OOo2.O00000Oo() != null) {
            O00000o0(O0000OOo2);
        }
        return this;
    }

    public final void O000000o(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        O00000Oo o00000Oo = this.O00000oo;
        int i = -1;
        while (true) {
            i++;
            if (i >= 16) {
                o00000Oo = o00000Oo.O000000o();
                if (o00000Oo != null) {
                    i = 0;
                } else {
                    return;
                }
            }
            JsonToken O000000o2 = o00000Oo.O000000o(i);
            if (O000000o2 != null) {
                switch (AnonymousClass1.f12589O000000o[O000000o2.ordinal()]) {
                    case 1:
                        jsonGenerator.O00000o();
                        break;
                    case 2:
                        jsonGenerator.O00000oO();
                        break;
                    case 3:
                        jsonGenerator.O00000Oo();
                        break;
                    case 4:
                        jsonGenerator.O00000o0();
                        break;
                    case 5:
                        Object O00000Oo2 = o00000Oo.O00000Oo(i);
                        if (!(O00000Oo2 instanceof ain)) {
                            jsonGenerator.O000000o((String) O00000Oo2);
                            break;
                        } else {
                            jsonGenerator.O000000o((ain) O00000Oo2);
                            break;
                        }
                    case 6:
                        Object O00000Oo3 = o00000Oo.O00000Oo(i);
                        if (!(O00000Oo3 instanceof ain)) {
                            jsonGenerator.O00000Oo((String) O00000Oo3);
                            break;
                        } else {
                            jsonGenerator.O00000Oo((ain) O00000Oo3);
                            break;
                        }
                    case 7:
                        Number number = (Number) o00000Oo.O00000Oo(i);
                        if (!(number instanceof BigInteger)) {
                            if (!(number instanceof Long)) {
                                jsonGenerator.O000000o(number.intValue());
                                break;
                            } else {
                                jsonGenerator.O000000o(number.longValue());
                                break;
                            }
                        } else {
                            jsonGenerator.O000000o((BigInteger) number);
                            break;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        Object O00000Oo4 = o00000Oo.O00000Oo(i);
                        if (O00000Oo4 instanceof BigDecimal) {
                            jsonGenerator.O000000o((BigDecimal) O00000Oo4);
                            break;
                        } else if (O00000Oo4 instanceof Float) {
                            jsonGenerator.O000000o(((Float) O00000Oo4).floatValue());
                            break;
                        } else if (O00000Oo4 instanceof Double) {
                            jsonGenerator.O000000o(((Double) O00000Oo4).doubleValue());
                            break;
                        } else if (O00000Oo4 == null) {
                            jsonGenerator.O00000oo();
                            break;
                        } else if (O00000Oo4 instanceof String) {
                            jsonGenerator.O00000oO((String) O00000Oo4);
                            break;
                        } else {
                            throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + O00000Oo4.getClass().getName() + ", can not serialize");
                        }
                    case 9:
                        jsonGenerator.O000000o(true);
                        break;
                    case 10:
                        jsonGenerator.O000000o(false);
                        break;
                    case 11:
                        jsonGenerator.O00000oo();
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        jsonGenerator.O000000o(o00000Oo.O00000Oo(i));
                        break;
                    default:
                        throw new RuntimeException("Internal error: should never end up through this code path");
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        JsonParser O0000OOo2 = O0000OOo();
        int i = 0;
        while (true) {
            try {
                JsonToken O00000Oo2 = O0000OOo2.O00000Oo();
                if (O00000Oo2 == null) {
                    break;
                }
                if (i < 100) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(O00000Oo2.toString());
                    if (O00000Oo2 == JsonToken.FIELD_NAME) {
                        sb.append('(');
                        sb.append(O0000OOo2.O00000oo());
                        sb.append(')');
                    }
                }
                i++;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (i >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    public void close() throws IOException {
        this.O00000oO = true;
    }

    public final void O00000Oo() throws IOException, JsonGenerationException {
        O000000o(JsonToken.START_ARRAY);
        this.O0000Oo0 = this.O0000Oo0.O0000OOo();
    }

    public final void O00000o0() throws IOException, JsonGenerationException {
        O000000o(JsonToken.END_ARRAY);
        ajc O0000Oo = this.O0000Oo0.O0000Oo();
        if (O0000Oo != null) {
            this.O0000Oo0 = O0000Oo;
        }
    }

    public final void O00000o() throws IOException, JsonGenerationException {
        O000000o(JsonToken.START_OBJECT);
        this.O0000Oo0 = this.O0000Oo0.O0000Oo0();
    }

    public final void O00000oO() throws IOException, JsonGenerationException {
        O000000o(JsonToken.END_OBJECT);
        ajc O0000Oo = this.O0000Oo0.O0000Oo();
        if (O0000Oo != null) {
            this.O0000Oo0 = O0000Oo;
        }
    }

    public final void O000000o(String str) throws IOException, JsonGenerationException {
        O000000o(JsonToken.FIELD_NAME, str);
        this.O0000Oo0.O000000o(str);
    }

    public final void O000000o(ain ain) throws IOException, JsonGenerationException {
        O000000o(JsonToken.FIELD_NAME, ain);
        this.O0000Oo0.O000000o(ain.O000000o());
    }

    public final void O000000o(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        O00000Oo(new String(cArr, i, i2));
    }

    public final void O00000o0(String str) throws IOException, JsonGenerationException {
        O0000Oo0();
    }

    public final void O000000o(char[] cArr, int i) throws IOException, JsonGenerationException {
        O0000Oo0();
    }

    public final void O000000o(char c) throws IOException, JsonGenerationException {
        O0000Oo0();
    }

    public final void O00000o(String str) throws IOException, JsonGenerationException {
        O0000Oo0();
    }

    public final void O000000o(int i) throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    public final void O000000o(long j) throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    public final void O000000o(double d) throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public final void O000000o(float f) throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    public final void O00000oO(String str) throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public final void O000000o(boolean z) throws IOException, JsonGenerationException {
        O000000o(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    public final void O00000oo() throws IOException, JsonGenerationException {
        O000000o(JsonToken.VALUE_NULL);
    }

    public final void O000000o(Object obj) throws IOException, JsonProcessingException {
        O000000o(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    public final void O000000o(aii aii, byte[] bArr, int i) throws IOException, JsonGenerationException {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        O000000o((Object) bArr2);
    }

    private void O00000o0(JsonParser jsonParser) throws IOException, JsonProcessingException {
        switch (AnonymousClass1.f12589O000000o[jsonParser.O00000oO().ordinal()]) {
            case 1:
                O00000o();
                return;
            case 2:
                O00000oO();
                return;
            case 3:
                O00000Oo();
                return;
            case 4:
                O00000o0();
                return;
            case 5:
                O000000o(jsonParser.O00000oo());
                return;
            case 6:
                if (jsonParser.O0000o0O()) {
                    O000000o(jsonParser.O0000Ooo(), jsonParser.O0000o0(), jsonParser.O0000o00());
                    return;
                } else {
                    O00000Oo(jsonParser.O0000OoO());
                    return;
                }
            case 7:
                int i = AnonymousClass1.O00000Oo[jsonParser.O0000o().ordinal()];
                if (i == 1) {
                    O000000o(jsonParser.O0000oOO());
                    return;
                } else if (i != 2) {
                    O000000o(jsonParser.O0000oOo());
                    return;
                } else {
                    O000000o(jsonParser.O0000oo0());
                    return;
                }
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                int i2 = AnonymousClass1.O00000Oo[jsonParser.O0000o().ordinal()];
                if (i2 == 3) {
                    O000000o(jsonParser.O0000ooo());
                    return;
                } else if (i2 != 4) {
                    O000000o(jsonParser.O0000ooO());
                    return;
                } else {
                    O000000o(jsonParser.O0000oo());
                    return;
                }
            case 9:
                O000000o(true);
                return;
            case 10:
                O000000o(false);
                return;
            case 11:
                O000000o(JsonToken.VALUE_NULL);
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                O000000o(jsonParser.O00oOooO());
                return;
            default:
                throw new RuntimeException("Internal error: should never end up through this code path");
        }
    }

    /* renamed from: _m_j.ath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12589O000000o = new int[JsonToken.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c1 */
        static {
            try {
                O00000Oo[JsonParser.NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[JsonParser.NumberType.BIG_INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[JsonParser.NumberType.BIG_DECIMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[JsonParser.NumberType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[JsonParser.NumberType.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f12589O000000o[JsonToken.START_OBJECT.ordinal()] = 1;
            f12589O000000o[JsonToken.END_OBJECT.ordinal()] = 2;
            f12589O000000o[JsonToken.START_ARRAY.ordinal()] = 3;
            f12589O000000o[JsonToken.END_ARRAY.ordinal()] = 4;
            f12589O000000o[JsonToken.FIELD_NAME.ordinal()] = 5;
            f12589O000000o[JsonToken.VALUE_STRING.ordinal()] = 6;
            f12589O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            f12589O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            f12589O000000o[JsonToken.VALUE_TRUE.ordinal()] = 9;
            f12589O000000o[JsonToken.VALUE_FALSE.ordinal()] = 10;
            f12589O000000o[JsonToken.VALUE_NULL.ordinal()] = 11;
            f12589O000000o[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 12;
        }
    }

    public final void O00000Oo(JsonParser jsonParser) throws IOException, JsonProcessingException {
        JsonToken O00000oO2 = jsonParser.O00000oO();
        if (O00000oO2 == JsonToken.FIELD_NAME) {
            O000000o(jsonParser.O00000oo());
            O00000oO2 = jsonParser.O00000Oo();
        }
        int i = AnonymousClass1.f12589O000000o[O00000oO2.ordinal()];
        if (i == 1) {
            O00000o();
            while (jsonParser.O00000Oo() != JsonToken.END_OBJECT) {
                O00000Oo(jsonParser);
            }
            O00000oO();
        } else if (i != 3) {
            O00000o0(jsonParser);
        } else {
            O00000Oo();
            while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                O00000Oo(jsonParser);
            }
            O00000o0();
        }
    }

    private void O000000o(JsonToken jsonToken) {
        O00000Oo O000000o2 = this.O0000O0o.O000000o(this.O0000OOo, jsonToken);
        if (O000000o2 == null) {
            this.O0000OOo++;
            return;
        }
        this.O0000O0o = O000000o2;
        this.O0000OOo = 1;
    }

    private void O000000o(JsonToken jsonToken, Object obj) {
        O00000Oo O000000o2 = this.O0000O0o.O000000o(this.O0000OOo, jsonToken, obj);
        if (O000000o2 == null) {
            this.O0000OOo++;
            return;
        }
        this.O0000O0o = O000000o2;
        this.O0000OOo = 1;
    }

    private static void O0000Oo0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    public static final class O000000o extends aiq {
        protected ail O00000Oo;
        protected int O00000o;
        protected O00000Oo O00000o0;
        protected ajb O00000oO;
        protected boolean O00000oo;
        protected transient ajk O0000O0o;
        protected JsonLocation O0000OOo = null;

        public final int O0000o0() {
            return 0;
        }

        public final boolean O0000o0O() {
            return false;
        }

        public O000000o(O00000Oo o00000Oo, ail ail) {
            super((byte) 0);
            this.O00000o0 = o00000Oo;
            this.O00000o = -1;
            this.O00000Oo = ail;
            this.O00000oO = ajb.O0000O0o();
        }

        public final void O000000o(JsonLocation jsonLocation) {
            this.O0000OOo = jsonLocation;
        }

        public final ail O000000o() {
            return this.O00000Oo;
        }

        public final void close() throws IOException {
            if (!this.O00000oo) {
                this.O00000oo = true;
            }
        }

        public final JsonToken O00000Oo() throws IOException, JsonParseException {
            O00000Oo o00000Oo;
            if (this.O00000oo || (o00000Oo = this.O00000o0) == null) {
                return null;
            }
            int i = this.O00000o + 1;
            this.O00000o = i;
            if (i >= 16) {
                this.O00000o = 0;
                this.O00000o0 = o00000Oo.O000000o();
                if (this.O00000o0 == null) {
                    return null;
                }
            }
            this.O000OO0o = this.O00000o0.O000000o(this.O00000o);
            if (this.O000OO0o == JsonToken.FIELD_NAME) {
                Object O000O0OO = O000O0OO();
                this.O00000oO.O000000o(O000O0OO instanceof String ? (String) O000O0OO : O000O0OO.toString());
            } else if (this.O000OO0o == JsonToken.START_OBJECT) {
                this.O00000oO = this.O00000oO.O00000Oo(-1, -1);
            } else if (this.O000OO0o == JsonToken.START_ARRAY) {
                this.O00000oO = this.O00000oO.O000000o(-1, -1);
            } else if (this.O000OO0o == JsonToken.END_OBJECT || this.O000OO0o == JsonToken.END_ARRAY) {
                this.O00000oO = this.O00000oO.O0000Oo0();
                if (this.O00000oO == null) {
                    this.O00000oO = ajb.O0000O0o();
                }
            }
            return this.O000OO0o;
        }

        public final JsonLocation O0000O0o() {
            return O0000OOo();
        }

        public final JsonLocation O0000OOo() {
            JsonLocation jsonLocation = this.O0000OOo;
            return jsonLocation == null ? JsonLocation.f3596O000000o : jsonLocation;
        }

        public final String O00000oo() {
            return this.O00000oO.O0000OOo();
        }

        public final String O0000OoO() {
            if (this.O000OO0o == JsonToken.VALUE_STRING || this.O000OO0o == JsonToken.FIELD_NAME) {
                Object O000O0OO = O000O0OO();
                if (O000O0OO instanceof String) {
                    return (String) O000O0OO;
                }
                if (O000O0OO == null) {
                    return null;
                }
                return O000O0OO.toString();
            } else if (this.O000OO0o == null) {
                return null;
            } else {
                int i = AnonymousClass1.f12589O000000o[this.O000OO0o.ordinal()];
                if (i != 7 && i != 8) {
                    return this.O000OO0o.asString();
                }
                Object O000O0OO2 = O000O0OO();
                if (O000O0OO2 == null) {
                    return null;
                }
                return O000O0OO2.toString();
            }
        }

        public final char[] O0000Ooo() {
            String O0000OoO = O0000OoO();
            if (O0000OoO == null) {
                return null;
            }
            return O0000OoO.toCharArray();
        }

        public final int O0000o00() {
            String O0000OoO = O0000OoO();
            if (O0000OoO == null) {
                return 0;
            }
            return O0000OoO.length();
        }

        public final BigInteger O0000oo0() throws IOException, JsonParseException {
            Number O0000o0o = O0000o0o();
            if (O0000o0o instanceof BigInteger) {
                return (BigInteger) O0000o0o;
            }
            if (AnonymousClass1.O00000Oo[O0000o().ordinal()] != 3) {
                return BigInteger.valueOf(O0000o0o.longValue());
            }
            return ((BigDecimal) O0000o0o).toBigInteger();
        }

        public final BigDecimal O0000ooo() throws IOException, JsonParseException {
            Number O0000o0o = O0000o0o();
            if (O0000o0o instanceof BigDecimal) {
                return (BigDecimal) O0000o0o;
            }
            int i = AnonymousClass1.O00000Oo[O0000o().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new BigDecimal((BigInteger) O0000o0o);
                }
                if (i != 5) {
                    return BigDecimal.valueOf(O0000o0o.doubleValue());
                }
            }
            return BigDecimal.valueOf(O0000o0o.longValue());
        }

        public final double O0000ooO() throws IOException, JsonParseException {
            return O0000o0o().doubleValue();
        }

        public final float O0000oo() throws IOException, JsonParseException {
            return O0000o0o().floatValue();
        }

        public final int O0000oOO() throws IOException, JsonParseException {
            if (this.O000OO0o == JsonToken.VALUE_NUMBER_INT) {
                return ((Number) O000O0OO()).intValue();
            }
            return O0000o0o().intValue();
        }

        public final long O0000oOo() throws IOException, JsonParseException {
            return O0000o0o().longValue();
        }

        public final JsonParser.NumberType O0000o() throws IOException, JsonParseException {
            Number O0000o0o = O0000o0o();
            if (O0000o0o instanceof Integer) {
                return JsonParser.NumberType.INT;
            }
            if (O0000o0o instanceof Long) {
                return JsonParser.NumberType.LONG;
            }
            if (O0000o0o instanceof Double) {
                return JsonParser.NumberType.DOUBLE;
            }
            if (O0000o0o instanceof BigDecimal) {
                return JsonParser.NumberType.BIG_DECIMAL;
            }
            if (O0000o0o instanceof Float) {
                return JsonParser.NumberType.FLOAT;
            }
            if (O0000o0o instanceof BigInteger) {
                return JsonParser.NumberType.BIG_INTEGER;
            }
            return null;
        }

        public final Number O0000o0o() throws IOException, JsonParseException {
            O000O0Oo();
            return (Number) O000O0OO();
        }

        public final Object O00oOooO() {
            if (this.O000OO0o == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return O000O0OO();
            }
            return null;
        }

        public final byte[] O000000o(aii aii) throws IOException, JsonParseException {
            if (this.O000OO0o == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object O000O0OO = O000O0OO();
                if (O000O0OO instanceof byte[]) {
                    return (byte[]) O000O0OO;
                }
            }
            if (this.O000OO0o == JsonToken.VALUE_STRING) {
                String O0000OoO = O0000OoO();
                if (O0000OoO == null) {
                    return null;
                }
                ajk ajk = this.O0000O0o;
                if (ajk == null) {
                    ajk = new ajk(0);
                    this.O0000O0o = ajk;
                } else {
                    ajk.O000000o();
                }
                O000000o(O0000OoO, ajk, aii);
                return ajk.O00000Oo();
            }
            throw O000000o("Current token (" + this.O000OO0o + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
        }

        private Object O000O0OO() {
            return this.O00000o0.O00000Oo(this.O00000o);
        }

        private void O000O0Oo() throws JsonParseException {
            if (this.O000OO0o == null || !this.O000OO0o.isNumeric()) {
                throw O000000o("Current token (" + this.O000OO0o + ") not numeric, can not use numeric value accessors");
            }
        }

        public final void O000O0o() throws JsonParseException {
            O000OO();
        }
    }

    public static final class O00000Oo {
        private static final JsonToken[] O00000o = new JsonToken[16];

        /* renamed from: O000000o  reason: collision with root package name */
        protected O00000Oo f12590O000000o;
        protected long O00000Oo;
        protected final Object[] O00000o0 = new Object[16];

        static {
            JsonToken[] values = JsonToken.values();
            System.arraycopy(values, 1, O00000o, 1, Math.min(15, values.length - 1));
        }

        public final JsonToken O000000o(int i) {
            long j = this.O00000Oo;
            if (i > 0) {
                j >>= i << 2;
            }
            return O00000o[((int) j) & 15];
        }

        public final Object O00000Oo(int i) {
            return this.O00000o0[i];
        }

        public final O00000Oo O000000o() {
            return this.f12590O000000o;
        }

        public final O00000Oo O000000o(int i, JsonToken jsonToken) {
            if (i < 16) {
                O00000Oo(i, jsonToken);
                return null;
            }
            this.f12590O000000o = new O00000Oo();
            this.f12590O000000o.O00000Oo(0, jsonToken);
            return this.f12590O000000o;
        }

        public final O00000Oo O000000o(int i, JsonToken jsonToken, Object obj) {
            if (i < 16) {
                O00000Oo(i, jsonToken, obj);
                return null;
            }
            this.f12590O000000o = new O00000Oo();
            this.f12590O000000o.O00000Oo(0, jsonToken, obj);
            return this.f12590O000000o;
        }

        private void O00000Oo(int i, JsonToken jsonToken) {
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.O00000Oo |= ordinal;
        }

        private void O00000Oo(int i, JsonToken jsonToken, Object obj) {
            this.O00000o0[i] = obj;
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this.O00000Oo = ordinal | this.O00000Oo;
        }
    }

    public final void O00000Oo(String str) throws IOException, JsonGenerationException {
        if (str == null) {
            O000000o(JsonToken.VALUE_NULL);
        } else {
            O000000o(JsonToken.VALUE_STRING, str);
        }
    }

    public final void O00000Oo(ain ain) throws IOException, JsonGenerationException {
        if (ain == null) {
            O000000o(JsonToken.VALUE_NULL);
        } else {
            O000000o(JsonToken.VALUE_STRING, ain);
        }
    }

    public final void O000000o(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        if (bigDecimal == null) {
            O000000o(JsonToken.VALUE_NULL);
        } else {
            O000000o(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    public final void O000000o(BigInteger bigInteger) throws IOException, JsonGenerationException {
        if (bigInteger == null) {
            O000000o(JsonToken.VALUE_NULL);
        } else {
            O000000o(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }
}

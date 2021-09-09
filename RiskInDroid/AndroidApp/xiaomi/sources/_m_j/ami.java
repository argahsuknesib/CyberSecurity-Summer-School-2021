package _m_j;

import _m_j.ajx;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.android.exoplayer2.C;
import java.io.IOException;

abstract class ami<N extends ajx> extends amy<N> {
    public ami(Class<N> cls) {
        super((Class<?>) cls);
    }

    public Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000o(jsonParser, ajt);
    }

    /* renamed from: _m_j.ami$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12456O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12456O000000o[JsonToken.START_OBJECT.ordinal()] = 1;
            f12456O000000o[JsonToken.START_ARRAY.ordinal()] = 2;
            f12456O000000o[JsonToken.VALUE_STRING.ordinal()] = 3;
            f12456O000000o[JsonToken.END_ARRAY.ordinal()] = 4;
            f12456O000000o[JsonToken.FIELD_NAME.ordinal()] = 5;
            f12456O000000o[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 6;
            f12456O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            f12456O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            f12456O000000o[JsonToken.VALUE_TRUE.ordinal()] = 9;
            f12456O000000o[JsonToken.VALUE_FALSE.ordinal()] = 10;
            try {
                f12456O000000o[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final aoz O00000Oo(JsonParser jsonParser, ajt ajt, api api) throws IOException, JsonProcessingException {
        aoz O00000Oo = api.O00000Oo();
        while (true) {
            JsonToken O00000Oo2 = jsonParser.O00000Oo();
            if (O00000Oo2 != null) {
                int i = AnonymousClass1.f12456O000000o[O00000Oo2.ordinal()];
                if (i == 1) {
                    O00000Oo.O000000o(O000000o(jsonParser, ajt, api));
                } else if (i == 2) {
                    O00000Oo.O000000o(O00000Oo(jsonParser, ajt, api));
                } else if (i == 3) {
                    O00000Oo.O000000o(api.O000000o(jsonParser.O0000OoO()));
                } else if (i == 4) {
                    return O00000Oo;
                } else {
                    O00000Oo.O000000o(O00000o0(jsonParser, ajt, api));
                }
            } else {
                throw ajt.O00000Oo("Unexpected end-of-input when binding data into ArrayNode");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final ajx O00000o0(JsonParser jsonParser, ajt ajt, api api) throws IOException, JsonProcessingException {
        switch (AnonymousClass1.f12456O000000o[jsonParser.O00000oO().ordinal()]) {
            case 1:
                return O000000o(jsonParser, ajt, api);
            case 2:
                return O00000Oo(jsonParser, ajt, api);
            case 3:
                return api.O000000o(jsonParser.O0000OoO());
            case 4:
            default:
                throw ajt.O00000Oo(O00000oO());
            case 5:
                return O000000o(jsonParser, ajt, api);
            case 6:
                Object O00oOooO = jsonParser.O00oOooO();
                if (O00oOooO == null) {
                    return api.O000000o();
                }
                if (O00oOooO.getClass() == byte[].class) {
                    return api.O000000o((byte[]) O00oOooO);
                }
                return api.O000000o(O00oOooO);
            case 7:
                JsonParser.NumberType O0000o = jsonParser.O0000o();
                if (O0000o == JsonParser.NumberType.BIG_INTEGER || ajt.O000000o(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return api.O000000o(jsonParser.O0000oo0());
                }
                if (O0000o == JsonParser.NumberType.INT) {
                    return api.O000000o(jsonParser.O0000oOO());
                }
                return api.O000000o(jsonParser.O0000oOo());
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (jsonParser.O0000o() == JsonParser.NumberType.BIG_DECIMAL || ajt.O000000o(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return api.O000000o(jsonParser.O0000ooo());
                }
                return api.O000000o(jsonParser.O0000ooO());
            case 9:
                return api.O000000o(true);
            case 10:
                return api.O000000o(false);
            case 11:
                return api.O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public final apm O000000o(JsonParser jsonParser, ajt ajt, api api) throws IOException, JsonProcessingException {
        ajx ajx;
        apm apm = new apm(api);
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            O00000oO = jsonParser.O00000Oo();
        }
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            int i = AnonymousClass1.f12456O000000o[jsonParser.O00000Oo().ordinal()];
            if (i == 1) {
                ajx = O000000o(jsonParser, ajt, api);
            } else if (i == 2) {
                ajx = O00000Oo(jsonParser, ajt, api);
            } else if (i != 3) {
                ajx = O00000o0(jsonParser, ajt, api);
            } else {
                ajx = api.O000000o(jsonParser.O0000OoO());
            }
            if (ajx == null) {
                ajx = api.O000000o();
            }
            apm.O000000o(O00000oo, ajx);
            O00000oO = jsonParser.O00000Oo();
        }
        return apm;
    }
}

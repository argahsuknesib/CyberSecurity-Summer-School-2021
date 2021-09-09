package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@akg
public final class ang extends amy<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object[] f12479O000000o = new Object[0];

    public ang() {
        super(Object.class);
    }

    /* renamed from: _m_j.ang$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12480O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12480O000000o[JsonToken.START_OBJECT.ordinal()] = 1;
            f12480O000000o[JsonToken.END_OBJECT.ordinal()] = 2;
            f12480O000000o[JsonToken.START_ARRAY.ordinal()] = 3;
            f12480O000000o[JsonToken.END_ARRAY.ordinal()] = 4;
            f12480O000000o[JsonToken.FIELD_NAME.ordinal()] = 5;
            f12480O000000o[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 6;
            f12480O000000o[JsonToken.VALUE_STRING.ordinal()] = 7;
            f12480O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 8;
            f12480O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            f12480O000000o[JsonToken.VALUE_TRUE.ordinal()] = 10;
            f12480O000000o[JsonToken.VALUE_FALSE.ordinal()] = 11;
            try {
                f12480O000000o[JsonToken.VALUE_NULL.ordinal()] = 12;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        switch (AnonymousClass1.f12480O000000o[jsonParser.O00000oO().ordinal()]) {
            case 1:
                return O00000o0(jsonParser, ajt);
            case 2:
            case 4:
            default:
                throw ajt.O00000Oo((Class<?>) Object.class);
            case 3:
                if (ajt.O000000o(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    if (jsonParser.O00000Oo() == JsonToken.END_ARRAY) {
                        return f12479O000000o;
                    }
                    atc O0000Oo = ajt.O0000Oo();
                    Object[] O000000o2 = O0000Oo.O000000o();
                    int i = 0;
                    while (true) {
                        Object O000000o3 = O000000o(jsonParser, ajt);
                        if (i >= O000000o2.length) {
                            O000000o2 = O0000Oo.O000000o(O000000o2);
                            i = 0;
                        }
                        int i2 = i + 1;
                        O000000o2[i] = O000000o3;
                        if (jsonParser.O00000Oo() == JsonToken.END_ARRAY) {
                            return O0000Oo.O000000o(O000000o2, i2);
                        }
                        i = i2;
                    }
                } else if (jsonParser.O00000Oo() == JsonToken.END_ARRAY) {
                    return new ArrayList(4);
                } else {
                    atc O0000Oo2 = ajt.O0000Oo();
                    Object[] O000000o4 = O0000Oo2.O000000o();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        Object O000000o5 = O000000o(jsonParser, ajt);
                        i3++;
                        if (i4 >= O000000o4.length) {
                            O000000o4 = O0000Oo2.O000000o(O000000o4);
                            i4 = 0;
                        }
                        int i5 = i4 + 1;
                        O000000o4[i4] = O000000o5;
                        if (jsonParser.O00000Oo() == JsonToken.END_ARRAY) {
                            ArrayList arrayList = new ArrayList(i3 + (i3 >> 3) + 1);
                            O0000Oo2.O000000o(O000000o4, i5, arrayList);
                            return arrayList;
                        }
                        i4 = i5;
                    }
                }
            case 5:
                return O00000o0(jsonParser, ajt);
            case 6:
                return jsonParser.O00oOooO();
            case 7:
                return jsonParser.O0000OoO();
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (ajt.O000000o(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.O0000oo0();
                }
                return jsonParser.O0000o0o();
            case 9:
                if (ajt.O000000o(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.O0000ooo();
                }
                return Double.valueOf(jsonParser.O0000ooO());
            case 10:
                return Boolean.TRUE;
            case 11:
                return Boolean.FALSE;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return null;
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        int i = AnonymousClass1.f12480O000000o[jsonParser.O00000oO().ordinal()];
        if (!(i == 1 || i == 3)) {
            switch (i) {
                case 5:
                    break;
                case 6:
                    return jsonParser.O00oOooO();
                case 7:
                    return jsonParser.O0000OoO();
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (ajt.O000000o(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                        return jsonParser.O0000oo0();
                    }
                    return Integer.valueOf(jsonParser.O0000oOO());
                case 9:
                    if (ajt.O000000o(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return jsonParser.O0000ooo();
                    }
                    return Double.valueOf(jsonParser.O0000ooO());
                case 10:
                    return Boolean.TRUE;
                case 11:
                    return Boolean.FALSE;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return null;
                default:
                    throw ajt.O00000Oo((Class<?>) Object.class);
            }
        }
        return aof.O00000o(jsonParser, ajt);
    }

    private Object O00000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            O00000oO = jsonParser.O00000Oo();
        }
        if (O00000oO != JsonToken.FIELD_NAME) {
            return new LinkedHashMap(4);
        }
        String O0000OoO = jsonParser.O0000OoO();
        jsonParser.O00000Oo();
        Object O000000o2 = O000000o(jsonParser, ajt);
        if (jsonParser.O00000Oo() != JsonToken.FIELD_NAME) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(4);
            linkedHashMap.put(O0000OoO, O000000o2);
            return linkedHashMap;
        }
        String O0000OoO2 = jsonParser.O0000OoO();
        jsonParser.O00000Oo();
        Object O000000o3 = O000000o(jsonParser, ajt);
        if (jsonParser.O00000Oo() != JsonToken.FIELD_NAME) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
            linkedHashMap2.put(O0000OoO, O000000o2);
            linkedHashMap2.put(O0000OoO2, O000000o3);
            return linkedHashMap2;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(O0000OoO, O000000o2);
        linkedHashMap3.put(O0000OoO2, O000000o3);
        do {
            String O0000OoO3 = jsonParser.O0000OoO();
            jsonParser.O00000Oo();
            linkedHashMap3.put(O0000OoO3, O000000o(jsonParser, ajt));
        } while (jsonParser.O00000Oo() != JsonToken.END_OBJECT);
        return linkedHashMap3;
    }
}

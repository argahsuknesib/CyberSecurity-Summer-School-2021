package _m_j;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public final class aon extends aoj {
    public aon(ajv ajv, aog aog, String str, boolean z, Class<?> cls) {
        super(ajv, aog, str, z, cls);
    }

    private aon(aon aon, ajr ajr) {
        super(aon, ajr);
    }

    public final aof O000000o(ajr ajr) {
        if (ajr == this.O00000o0) {
            return this;
        }
        return new aon(this, ajr);
    }

    public final JsonTypeInfo.As O000000o() {
        return JsonTypeInfo.As.PROPERTY;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            O00000oO = jsonParser.O00000Oo();
        } else if (O00000oO == JsonToken.START_ARRAY) {
            return O000000o(jsonParser, ajt, null);
        } else {
            if (O00000oO != JsonToken.FIELD_NAME) {
                return O000000o(jsonParser, ajt, null);
            }
        }
        ath ath = null;
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            if (this.O00000oO.equals(O00000oo)) {
                String O0000OoO = jsonParser.O0000OoO();
                ajw<Object> O000000o2 = O000000o(ajt, O0000OoO);
                if (this.O00000oo) {
                    if (ath == null) {
                        ath = new ath(null);
                    }
                    ath.O000000o(jsonParser.O00000oo());
                    ath.O00000Oo(O0000OoO);
                }
                if (ath != null) {
                    jsonParser = ajn.O000000o(ath.O000000o(jsonParser), jsonParser);
                }
                jsonParser.O00000Oo();
                return O000000o2.O000000o(jsonParser, ajt);
            }
            if (ath == null) {
                ath = new ath(null);
            }
            ath.O000000o(O00000oo);
            ath.O00000Oo(jsonParser);
            O00000oO = jsonParser.O00000Oo();
        }
        return O000000o(jsonParser, ajt, ath);
    }

    private Object O000000o(JsonParser jsonParser, ajt ajt, ath ath) throws IOException, JsonProcessingException {
        if (this.O00000o != null) {
            ajw<Object> O000000o2 = O000000o(ajt);
            if (ath != null) {
                ath.O00000oO();
                jsonParser = ath.O000000o(jsonParser);
                jsonParser.O00000Oo();
            }
            return O000000o2.O000000o(jsonParser, ajt);
        }
        Object O000000o3 = O000000o(jsonParser);
        if (O000000o3 != null) {
            return O000000o3;
        }
        if (jsonParser.O00000oO() == JsonToken.START_ARRAY) {
            return super.O00000o(jsonParser, ajt);
        }
        JsonToken jsonToken = JsonToken.FIELD_NAME;
        throw ajt.O000000o(jsonParser, jsonToken, "missing property '" + this.O00000oO + "' that is to contain type id  (for class " + O00000o0() + ")");
    }

    public final Object O00000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() == JsonToken.START_ARRAY) {
            return super.O00000Oo(jsonParser, ajt);
        }
        return O000000o(jsonParser, ajt);
    }

    /* renamed from: _m_j.aon$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12503O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12503O000000o[JsonToken.VALUE_STRING.ordinal()] = 1;
            f12503O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            f12503O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            f12503O000000o[JsonToken.VALUE_TRUE.ordinal()] = 4;
            f12503O000000o[JsonToken.VALUE_FALSE.ordinal()] = 5;
        }
    }

    private Object O000000o(JsonParser jsonParser) throws IOException, JsonProcessingException {
        int i = AnonymousClass1.f12503O000000o[jsonParser.O00000oO().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5 && this.O00000Oo.O00000Oo().isAssignableFrom(Boolean.class)) {
                            return Boolean.FALSE;
                        }
                        return null;
                    } else if (this.O00000Oo.O00000Oo().isAssignableFrom(Boolean.class)) {
                        return Boolean.TRUE;
                    } else {
                        return null;
                    }
                } else if (this.O00000Oo.O00000Oo().isAssignableFrom(Double.class)) {
                    return Double.valueOf(jsonParser.O0000ooO());
                } else {
                    return null;
                }
            } else if (this.O00000Oo.O00000Oo().isAssignableFrom(Integer.class)) {
                return Integer.valueOf(jsonParser.O0000oOO());
            } else {
                return null;
            }
        } else if (this.O00000Oo.O00000Oo().isAssignableFrom(String.class)) {
            return jsonParser.O0000OoO();
        } else {
            return null;
        }
    }
}

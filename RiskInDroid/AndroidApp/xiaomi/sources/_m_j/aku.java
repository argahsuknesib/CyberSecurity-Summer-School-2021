package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Map;

public final class aku extends ajw<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12423O000000o;
    protected final alx O00000Oo;
    protected final boolean O00000o;
    protected final Map<String, alm> O00000o0;
    protected final boolean O00000oO;
    protected final boolean O00000oo;
    protected final boolean O0000O0o;

    public final boolean O00000o0() {
        return true;
    }

    public aku(aky aky, ajq ajq, Map<String, alm> map) {
        this.f12423O000000o = ajq.O000000o();
        this.O00000Oo = aky.O00000o();
        this.O00000o0 = map;
        Class<?> O00000Oo2 = this.f12423O000000o.O00000Oo();
        this.O00000o = O00000Oo2.isAssignableFrom(String.class);
        boolean z = false;
        this.O00000oO = O00000Oo2 == Boolean.TYPE || O00000Oo2.isAssignableFrom(Boolean.class);
        this.O00000oo = O00000Oo2 == Integer.TYPE || O00000Oo2.isAssignableFrom(Integer.class);
        this.O0000O0o = (O00000Oo2 == Double.TYPE || O00000Oo2.isAssignableFrom(Double.class)) ? true : z;
    }

    public final alm O000000o(String str) {
        Map<String, alm> map = this.O00000o0;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        Object obj;
        JsonToken O00000oO2;
        if (this.O00000Oo == null || (O00000oO2 = jsonParser.O00000oO()) == null || !O00000oO2.isScalarValue()) {
            int i = AnonymousClass1.f12424O000000o[jsonParser.O00000oO().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && this.O00000oO) {
                                obj = Boolean.FALSE;
                                return obj == null ? obj : aof.O000000o(jsonParser, ajt);
                            }
                        } else if (this.O00000oO) {
                            obj = Boolean.TRUE;
                            if (obj == null) {
                            }
                        }
                    } else if (this.O0000O0o) {
                        obj = Double.valueOf(jsonParser.O0000ooO());
                        if (obj == null) {
                        }
                    }
                } else if (this.O00000oo) {
                    obj = Integer.valueOf(jsonParser.O0000oOO());
                    if (obj == null) {
                    }
                }
            } else if (this.O00000o) {
                obj = jsonParser.O0000OoO();
                if (obj == null) {
                }
            }
            obj = null;
            if (obj == null) {
            }
        } else {
            Object O000000o2 = this.O00000Oo.O00000o.O000000o(jsonParser, ajt);
            Object obj2 = ajt.O000000o(O000000o2, this.O00000Oo.O00000o0).O00000Oo;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalStateException("Could not resolve Object Id [" + O000000o2 + "] -- unresolved forward-reference?");
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        throw ajt.O000000o(this.f12423O000000o.O00000Oo(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
    }

    /* renamed from: _m_j.aku$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12424O000000o = new int[JsonToken.values().length];

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
            f12424O000000o[JsonToken.VALUE_STRING.ordinal()] = 1;
            f12424O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            f12424O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            f12424O000000o[JsonToken.VALUE_TRUE.ordinal()] = 4;
            f12424O000000o[JsonToken.VALUE_FALSE.ordinal()] = 5;
        }
    }
}

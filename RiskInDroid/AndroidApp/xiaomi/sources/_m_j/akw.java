package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public class akw extends akx {
    public akw(aky aky, ajq ajq, alp alp, Map<String, alm> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(aky, ajq, alp, map, hashSet, z, z2);
    }

    protected akw(akx akx) {
        super(akx, akx.O0000Ooo);
    }

    protected akw(akx akx, atb atb) {
        super(akx, atb);
    }

    private akw(akx akx, alx alx) {
        super(akx, alx);
    }

    private akw(akx akx, HashSet<String> hashSet) {
        super(akx, hashSet);
    }

    public ajw<Object> O000000o(atb atb) {
        if (getClass() != akw.class) {
            return this;
        }
        return new akw(this, atb);
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            jsonParser.O00000Oo();
            if (this.O0000O0o) {
                return O0000oO0(jsonParser, ajt);
            }
            if (this.O0000oO0 != null) {
                return O0000oO(jsonParser, ajt);
            }
            return a_(jsonParser, ajt);
        }
        boolean z = true;
        switch (AnonymousClass1.f12426O000000o[O00000oO.ordinal()]) {
            case 1:
                if (this.O0000oO0 != null) {
                    return O00000o(jsonParser, ajt);
                }
                if (this.O00000o == null || this.O00000o0.O00000Oo()) {
                    return this.O00000o0.O000000o(ajt, jsonParser.O0000OoO());
                }
                Object O000000o2 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                if (this.O0000Oo0 != null) {
                    O000000o(ajt, O000000o2);
                }
                return O000000o2;
            case 2:
                if (this.O0000oO0 != null) {
                    return O00000o(jsonParser, ajt);
                }
                int i = AnonymousClass1.O00000Oo[jsonParser.O0000o().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (this.O00000o != null) {
                            Object O000000o3 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                            if (this.O0000Oo0 != null) {
                                O000000o(ajt, O000000o3);
                            }
                            return O000000o3;
                        }
                        throw ajt.O000000o(O00000o(), "no suitable creator method found to deserialize from JSON integer number");
                    } else if (this.O00000o == null || this.O00000o0.O00000o0()) {
                        return this.O00000o0.O000000o(jsonParser.O0000oOo());
                    } else {
                        Object O000000o4 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                        if (this.O0000Oo0 != null) {
                            O000000o(ajt, O000000o4);
                        }
                        return O000000o4;
                    }
                } else if (this.O00000o == null || this.O00000o0.O00000o0()) {
                    return this.O00000o0.O000000o(jsonParser.O0000oOO());
                } else {
                    Object O000000o5 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                    if (this.O0000Oo0 != null) {
                        O000000o(ajt, O000000o5);
                    }
                    return O000000o5;
                }
            case 3:
                int i2 = AnonymousClass1.O00000Oo[jsonParser.O0000o().ordinal()];
                if (i2 == 3 || i2 == 4) {
                    if (this.O00000o == null || this.O00000o0.O00000oO()) {
                        return this.O00000o0.O000000o(jsonParser.O0000ooO());
                    }
                    Object O000000o6 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                    if (this.O0000Oo0 != null) {
                        O000000o(ajt, O000000o6);
                    }
                    return O000000o6;
                } else if (this.O00000o != null) {
                    return this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                } else {
                    throw ajt.O000000o(O00000o(), "no suitable creator method found to deserialize from JSON floating-point number");
                }
            case 4:
                return jsonParser.O00oOooO();
            case 5:
            case 6:
                if (this.O00000o == null || this.O00000o0.O00000oo()) {
                    if (jsonParser.O00000oO() != JsonToken.VALUE_TRUE) {
                        z = false;
                    }
                    return this.O00000o0.O000000o(z);
                }
                Object O000000o7 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                if (this.O0000Oo0 != null) {
                    O000000o(ajt, O000000o7);
                }
                return O000000o7;
            case 7:
                return O0000oOO(jsonParser, ajt);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                if (this.O0000O0o) {
                    return O0000oO0(jsonParser, ajt);
                }
                if (this.O0000oO0 != null) {
                    return O0000oO(jsonParser, ajt);
                }
                return a_(jsonParser, ajt);
            default:
                throw ajt.O00000Oo(O00000o());
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        Class<?> O00000o;
        if (this.O0000Oo0 != null) {
            O000000o(ajt, obj);
        }
        if (this.O0000o0o != null) {
            return O00000Oo(jsonParser, ajt, obj);
        }
        if (this.O0000o != null) {
            return O00000o0(jsonParser, ajt, obj);
        }
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            O00000oO = jsonParser.O00000Oo();
        }
        if (this.O0000o00 && (O00000o = ajt.O00000o()) != null) {
            return O000000o(jsonParser, ajt, obj, O00000o);
        }
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
            if (O000000o2 != null) {
                try {
                    O000000o2.O000000o(jsonParser, ajt, obj);
                } catch (Exception e) {
                    O000000o(e, obj, O00000oo, ajt);
                }
            } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                jsonParser.O00000o();
            } else if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(jsonParser, ajt, obj, O00000oo);
            } else {
                O000000o(jsonParser, ajt, obj, O00000oo);
            }
            O00000oO = jsonParser.O00000Oo();
        }
        return obj;
    }

    private final Object O0000oO0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        Object O0000OoO = this.O00000o0.O0000OoO();
        while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
            if (O000000o2 != null) {
                try {
                    O000000o2.O000000o(jsonParser, ajt, O0000OoO);
                } catch (Exception e) {
                    O000000o(e, O0000OoO, O00000oo, ajt);
                }
            } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                jsonParser.O00000o();
            } else if (this.O0000Oo != null) {
                try {
                    this.O0000Oo.O000000o(jsonParser, ajt, O0000OoO, O00000oo);
                } catch (Exception e2) {
                    O000000o(e2, O0000OoO, O00000oo, ajt);
                }
            } else {
                O000000o(jsonParser, ajt, O0000OoO, O00000oo);
            }
            jsonParser.O00000Oo();
        }
        return O0000OoO;
    }

    public Object a_(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        Class<?> O00000o;
        if (!this.O00000oo) {
            Object O0000OoO = this.O00000o0.O0000OoO();
            if (this.O0000Oo0 != null) {
                O000000o(ajt, O0000OoO);
            }
            if (this.O0000o00 && (O00000o = ajt.O00000o()) != null) {
                return O000000o(jsonParser, ajt, O0000OoO, O00000o);
            }
            while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
                String O00000oo = jsonParser.O00000oo();
                jsonParser.O00000Oo();
                alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
                if (O000000o2 != null) {
                    try {
                        O000000o2.O000000o(jsonParser, ajt, O0000OoO);
                    } catch (Exception e) {
                        O000000o(e, O0000OoO, O00000oo, ajt);
                    }
                } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                    jsonParser.O00000o();
                } else if (this.O0000Oo != null) {
                    try {
                        this.O0000Oo.O000000o(jsonParser, ajt, O0000OoO, O00000oo);
                    } catch (Exception e2) {
                        O000000o(e2, O0000OoO, O00000oo, ajt);
                    }
                } else {
                    O000000o(jsonParser, ajt, O0000OoO, O00000oo);
                }
                jsonParser.O00000Oo();
            }
            return O0000OoO;
        } else if (this.O0000o0o != null) {
            return O0000oOo(jsonParser, ajt);
        } else {
            if (this.O0000o != null) {
                if (this.O00000oO != null) {
                    return O0000oo(jsonParser, ajt);
                }
                return O00000o0(jsonParser, ajt, this.O00000o0.O0000OoO());
            } else if (this.O00000o != null) {
                return this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
            } else {
                if (this.O00000oO != null) {
                    return O00000o0(jsonParser, ajt);
                }
                if (this.O00000Oo.O00000o0()) {
                    throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this.O00000Oo + " (need to add/enable type information?)");
                }
                throw JsonMappingException.from(jsonParser, "No suitable constructor found for type " + this.O00000Oo + ": can not instantiate from JSON object (need to add/enable type information?)");
            }
        }
    }

    private Object O0000oO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        String str = this.O0000oO0.O00000Oo;
        if (str.equals(jsonParser.O00000oo())) {
            return a_(jsonParser, ajt);
        }
        ath ath = new ath(jsonParser.O000000o());
        ath ath2 = null;
        while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
            String O00000oo = jsonParser.O00000oo();
            if (ath2 != null) {
                ath2.O000000o(O00000oo);
                jsonParser.O00000Oo();
                ath2.O00000Oo(jsonParser);
            } else if (str.equals(O00000oo)) {
                ath2 = new ath(jsonParser.O000000o());
                ath2.O000000o(O00000oo);
                jsonParser.O00000Oo();
                ath2.O00000Oo(jsonParser);
                ath2.O000000o(ath);
                ath = null;
            } else {
                ath.O000000o(O00000oo);
                jsonParser.O00000Oo();
                ath.O00000Oo(jsonParser);
            }
            jsonParser.O00000Oo();
        }
        if (ath2 == null) {
            ath2 = ath;
        }
        ath2.O00000oO();
        JsonParser O0000OOo = ath2.O0000OOo();
        O0000OOo.O00000Oo();
        return a_(O0000OOo, ajt);
    }

    /* renamed from: _m_j.akw$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12426O000000o = new int[JsonToken.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            try {
                O00000Oo[JsonParser.NumberType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[JsonParser.NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[JsonParser.NumberType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[JsonParser.NumberType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12426O000000o[JsonToken.VALUE_STRING.ordinal()] = 1;
            f12426O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            f12426O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            f12426O000000o[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
            f12426O000000o[JsonToken.VALUE_TRUE.ordinal()] = 5;
            f12426O000000o[JsonToken.VALUE_FALSE.ordinal()] = 6;
            f12426O000000o[JsonToken.START_ARRAY.ordinal()] = 7;
            f12426O000000o[JsonToken.FIELD_NAME.ordinal()] = 8;
            try {
                f12426O000000o[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Object O0000oOO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (this.O00000o != null) {
            try {
                Object O000000o2 = this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
                if (this.O0000Oo0 != null) {
                    O000000o(ajt, O000000o2);
                }
                return O000000o2;
            } catch (Exception e) {
                O000000o(e, ajt);
            }
        }
        throw ajt.O00000Oo(O00000o());
    }

    /* access modifiers changed from: protected */
    public final Object O00000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        alz alz = this.O00000oO;
        amc O000000o2 = alz.O000000o(jsonParser, ajt);
        JsonToken O00000oO = jsonParser.O00000oO();
        ath ath = null;
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o3 = alz.O000000o(O00000oo);
            if (O000000o3 != null) {
                if (O000000o2.O000000o(O000000o3.O0000OoO(), O000000o3.O000000o(jsonParser, ajt))) {
                    jsonParser.O00000Oo();
                    try {
                        Object O000000o4 = alz.O000000o(O000000o2);
                        if (O000000o4.getClass() != this.O00000Oo.O00000Oo()) {
                            return O000000o(jsonParser, ajt, O000000o4, ath);
                        }
                        if (ath != null) {
                            O000000o4 = O000000o(ajt, O000000o4, ath);
                        }
                        return O000000o(jsonParser, ajt, O000000o4);
                    } catch (Exception e) {
                        O000000o(e, this.O00000Oo.O00000Oo(), O00000oo, ajt);
                    }
                } else {
                    continue;
                }
            } else {
                alm O000000o5 = this.O0000OOo.O000000o(O00000oo);
                if (O000000o5 != null) {
                    O000000o2.O000000o(O000000o5, O000000o5.O000000o(jsonParser, ajt));
                } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                    jsonParser.O00000o();
                } else if (this.O0000Oo != null) {
                    O000000o2.O000000o(this.O0000Oo, O00000oo, this.O0000Oo.O000000o(jsonParser, ajt));
                } else {
                    if (ath == null) {
                        ath = new ath(jsonParser.O000000o());
                    }
                    ath.O000000o(O00000oo);
                    ath.O00000Oo(jsonParser);
                }
            }
            O00000oO = jsonParser.O00000Oo();
        }
        try {
            Object O000000o6 = alz.O000000o(O000000o2);
            if (ath == null) {
                return O000000o6;
            }
            if (O000000o6.getClass() != this.O00000Oo.O00000Oo()) {
                return O000000o((JsonParser) null, ajt, O000000o6, ath);
            }
            return O000000o(ajt, O000000o6, ath);
        } catch (Exception e2) {
            O000000o(e2, ajt);
            return null;
        }
    }

    private Object O000000o(JsonParser jsonParser, ajt ajt, Object obj, ath ath) throws IOException, JsonProcessingException {
        ajw<Object> O00000Oo = O00000Oo(ajt, obj);
        if (O00000Oo != null) {
            if (ath != null) {
                ath.O00000oO();
                JsonParser O0000OOo = ath.O0000OOo();
                O0000OOo.O00000Oo();
                obj = O00000Oo.O000000o(O0000OOo, ajt, obj);
            }
            return jsonParser != null ? O00000Oo.O000000o(jsonParser, ajt, obj) : obj;
        }
        if (ath != null) {
            obj = O000000o(ajt, obj, ath);
        }
        return jsonParser != null ? O000000o(jsonParser, ajt, obj) : obj;
    }

    private Object O000000o(JsonParser jsonParser, ajt ajt, Object obj, Class<?> cls) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
            if (O000000o2 != null) {
                if (!O000000o2.O000000o(cls)) {
                    jsonParser.O00000o();
                } else {
                    try {
                        O000000o2.O000000o(jsonParser, ajt, obj);
                    } catch (Exception e) {
                        O000000o(e, obj, O00000oo, ajt);
                    }
                }
            } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                jsonParser.O00000o();
            } else if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(jsonParser, ajt, obj, O00000oo);
            } else {
                O000000o(jsonParser, ajt, obj, O00000oo);
            }
            O00000oO = jsonParser.O00000Oo();
        }
        return obj;
    }

    private Object O0000oOo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (this.O00000o != null) {
            return this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
        }
        if (this.O00000oO != null) {
            return O0000oo0(jsonParser, ajt);
        }
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000o();
        Object O0000OoO = this.O00000o0.O0000OoO();
        if (this.O0000Oo0 != null) {
            O000000o(ajt, O0000OoO);
        }
        Class<?> O00000o = this.O0000o00 ? ajt.O00000o() : null;
        while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
            if (O000000o2 != null) {
                if (O00000o == null || O000000o2.O000000o(O00000o)) {
                    try {
                        O000000o2.O000000o(jsonParser, ajt, O0000OoO);
                    } catch (Exception e) {
                        O000000o(e, O0000OoO, O00000oo, ajt);
                    }
                } else {
                    jsonParser.O00000o();
                }
            } else if (this.O0000OoO == null || !this.O0000OoO.contains(O00000oo)) {
                ath.O000000o(O00000oo);
                ath.O00000Oo(jsonParser);
                if (this.O0000Oo != null) {
                    try {
                        this.O0000Oo.O000000o(jsonParser, ajt, O0000OoO, O00000oo);
                    } catch (Exception e2) {
                        O000000o(e2, O0000OoO, O00000oo, ajt);
                    }
                }
            } else {
                jsonParser.O00000o();
            }
            jsonParser.O00000Oo();
        }
        ath.O00000oO();
        this.O0000o0o.O000000o(ajt, O0000OoO, ath);
        return O0000OoO;
    }

    private Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.START_OBJECT) {
            O00000oO = jsonParser.O00000Oo();
        }
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000o();
        Class<?> O00000o = this.O0000o00 ? ajt.O00000o() : null;
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
            jsonParser.O00000Oo();
            if (O000000o2 != null) {
                if (O00000o == null || O000000o2.O000000o(O00000o)) {
                    try {
                        O000000o2.O000000o(jsonParser, ajt, obj);
                    } catch (Exception e) {
                        O000000o(e, obj, O00000oo, ajt);
                    }
                } else {
                    jsonParser.O00000o();
                }
            } else if (this.O0000OoO == null || !this.O0000OoO.contains(O00000oo)) {
                ath.O000000o(O00000oo);
                ath.O00000Oo(jsonParser);
                if (this.O0000Oo != null) {
                    this.O0000Oo.O000000o(jsonParser, ajt, obj, O00000oo);
                }
            } else {
                jsonParser.O00000o();
            }
            O00000oO = jsonParser.O00000Oo();
        }
        ath.O00000oO();
        this.O0000o0o.O000000o(ajt, obj, ath);
        return obj;
    }

    private Object O0000oo0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        alz alz = this.O00000oO;
        amc O000000o2 = alz.O000000o(jsonParser, ajt);
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000o();
        JsonToken O00000oO = jsonParser.O00000oO();
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o3 = alz.O000000o(O00000oo);
            if (O000000o3 != null) {
                if (O000000o2.O000000o(O000000o3.O0000OoO(), O000000o3.O000000o(jsonParser, ajt))) {
                    JsonToken O00000Oo = jsonParser.O00000Oo();
                    try {
                        Object O000000o4 = alz.O000000o(O000000o2);
                        while (O00000Oo == JsonToken.FIELD_NAME) {
                            jsonParser.O00000Oo();
                            ath.O00000Oo(jsonParser);
                            O00000Oo = jsonParser.O00000Oo();
                        }
                        ath.O00000oO();
                        if (O000000o4.getClass() == this.O00000Oo.O00000Oo()) {
                            return this.O0000o0o.O000000o(ajt, O000000o4, ath);
                        }
                        throw ajt.O00000Oo("Can not create polymorphic instances with unwrapped values");
                    } catch (Exception e) {
                        O000000o(e, this.O00000Oo.O00000Oo(), O00000oo, ajt);
                    }
                } else {
                    continue;
                }
            } else {
                alm O000000o5 = this.O0000OOo.O000000o(O00000oo);
                if (O000000o5 != null) {
                    O000000o2.O000000o(O000000o5, O000000o5.O000000o(jsonParser, ajt));
                } else if (this.O0000OoO == null || !this.O0000OoO.contains(O00000oo)) {
                    ath.O000000o(O00000oo);
                    ath.O00000Oo(jsonParser);
                    if (this.O0000Oo != null) {
                        O000000o2.O000000o(this.O0000Oo, O00000oo, this.O0000Oo.O000000o(jsonParser, ajt));
                    }
                } else {
                    jsonParser.O00000o();
                }
            }
            O00000oO = jsonParser.O00000Oo();
        }
        try {
            return this.O0000o0o.O000000o(ajt, alz.O000000o(O000000o2), ath);
        } catch (Exception e2) {
            O000000o(e2, ajt);
            return null;
        }
    }

    private Object O00000o0(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        Integer num;
        Class<?> O00000o = this.O0000o00 ? ajt.O00000o() : null;
        alr O000000o2 = this.O0000o.O000000o();
        while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o3 = this.O0000OOo.O000000o(O00000oo);
            if (O000000o3 != null) {
                if (jsonParser.O00000oO().isScalarValue() && (num = O000000o2.O00000Oo.get(O00000oo)) != null) {
                    int intValue = num.intValue();
                    if (O000000o2.f12438O000000o[intValue].O000000o(O00000oo)) {
                        O000000o2.O00000o0[intValue] = jsonParser.O0000OoO();
                        if ((obj == null || O000000o2.O00000o[intValue] == null) ? false : true) {
                            O000000o2.O000000o(jsonParser, ajt, obj, intValue);
                            O000000o2.O00000o0[intValue] = null;
                            O000000o2.O00000o[intValue] = null;
                        }
                    }
                }
                if (O00000o == null || O000000o3.O000000o(O00000o)) {
                    try {
                        O000000o3.O000000o(jsonParser, ajt, obj);
                    } catch (Exception e) {
                        O000000o(e, obj, O00000oo, ajt);
                    }
                } else {
                    jsonParser.O00000o();
                }
            } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                jsonParser.O00000o();
            } else if (!O000000o2.O000000o(jsonParser, ajt, O00000oo, obj)) {
                if (this.O0000Oo != null) {
                    try {
                        this.O0000Oo.O000000o(jsonParser, ajt, obj, O00000oo);
                    } catch (Exception e2) {
                        O000000o(e2, obj, O00000oo, ajt);
                    }
                } else {
                    O000000o(jsonParser, ajt, obj, O00000oo);
                }
            }
            jsonParser.O00000Oo();
        }
        return O000000o2.O000000o(jsonParser, ajt, obj);
    }

    private Object O0000oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        alr O000000o2 = this.O0000o.O000000o();
        alz alz = this.O00000oO;
        amc O000000o3 = alz.O000000o(jsonParser, ajt);
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000o();
        JsonToken O00000oO = jsonParser.O00000oO();
        while (O00000oO == JsonToken.FIELD_NAME) {
            String O00000oo = jsonParser.O00000oo();
            jsonParser.O00000Oo();
            alm O000000o4 = alz.O000000o(O00000oo);
            if (O000000o4 == null) {
                alm O000000o5 = this.O0000OOo.O000000o(O00000oo);
                if (O000000o5 != null) {
                    O000000o3.O000000o(O000000o5, O000000o5.O000000o(jsonParser, ajt));
                } else if (!O000000o2.O000000o(jsonParser, ajt, O00000oo, (Object) null)) {
                    if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                        jsonParser.O00000o();
                    } else if (this.O0000Oo != null) {
                        O000000o3.O000000o(this.O0000Oo, O00000oo, this.O0000Oo.O000000o(jsonParser, ajt));
                    }
                }
            } else if (!O000000o2.O000000o(jsonParser, ajt, O00000oo, O000000o3)) {
                if (O000000o3.O000000o(O000000o4.O0000OoO(), O000000o4.O000000o(jsonParser, ajt))) {
                    JsonToken O00000Oo = jsonParser.O00000Oo();
                    try {
                        Object O000000o6 = alz.O000000o(O000000o3);
                        while (O00000Oo == JsonToken.FIELD_NAME) {
                            jsonParser.O00000Oo();
                            ath.O00000Oo(jsonParser);
                            O00000Oo = jsonParser.O00000Oo();
                        }
                        if (O000000o6.getClass() == this.O00000Oo.O00000Oo()) {
                            return O000000o2.O000000o(jsonParser, ajt, O000000o6);
                        }
                        throw ajt.O00000Oo("Can not create polymorphic instances with unwrapped values");
                    } catch (Exception e) {
                        O000000o(e, this.O00000Oo.O00000Oo(), O00000oo, ajt);
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
            O00000oO = jsonParser.O00000Oo();
        }
        try {
            int length = O000000o2.f12438O000000o.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                if (O000000o2.O00000o0[i] == null) {
                    if (O000000o2.O00000o[i] != null) {
                        throw ajt.O00000Oo("Missing external type id property '" + O000000o2.f12438O000000o[i].O00000Oo);
                    }
                } else if (O000000o2.O00000o[i] != null) {
                    ath ath2 = new ath(jsonParser.O000000o());
                    ath2.O00000Oo();
                    ath2.O00000Oo(O000000o2.O00000o0[i]);
                    JsonParser O000000o7 = O000000o2.O00000o[i].O000000o(jsonParser);
                    O000000o7.O00000Oo();
                    ath2.O00000Oo(O000000o7);
                    ath2.O00000o0();
                    JsonParser O000000o8 = ath2.O000000o(jsonParser);
                    O000000o8.O00000Oo();
                    objArr[i] = O000000o2.f12438O000000o[i].f12440O000000o.O000000o(O000000o8, ajt);
                } else {
                    alm alm = O000000o2.f12438O000000o[i].f12440O000000o;
                    throw ajt.O00000Oo("Missing property '" + alm.O00000o() + "' for external type id '" + O000000o2.f12438O000000o[i].O00000Oo);
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                alm alm2 = O000000o2.f12438O000000o[i2].f12440O000000o;
                if (alz.O000000o(alm2.O00000o()) != null) {
                    O000000o3.O000000o(alm2.O0000OoO(), objArr[i2]);
                }
            }
            Object O000000o9 = alz.O000000o(O000000o3);
            for (int i3 = 0; i3 < length; i3++) {
                alm alm3 = O000000o2.f12438O000000o[i3].f12440O000000o;
                if (alz.O000000o(alm3.O00000o()) == null) {
                    alm3.O000000o(O000000o9, objArr[i3]);
                }
            }
            return O000000o9;
        } catch (Exception e2) {
            O000000o(e2, ajt);
            return null;
        }
    }

    public final /* synthetic */ akx O000000o(HashSet hashSet) {
        return new akw(this, hashSet);
    }

    public final /* synthetic */ akx O000000o(alx alx) {
        return new akw(this, alx);
    }
}

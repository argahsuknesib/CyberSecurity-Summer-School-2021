package _m_j;

import _m_j.alf;
import _m_j.aoc;
import _m_j.aqa;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class akc extends ail {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final anv f12414O000000o = ant.O00000oO;
    protected static final AnnotationIntrospector O00000Oo = new anw();
    protected static final akn O00000o = new akn(f12414O000000o, O00000Oo, O00000o0, asq.O000000o(), StdDateFormat.O00000oo, Locale.getDefault(), TimeZone.getTimeZone("GMT"));
    protected static final aoc<?> O00000o0 = aoc.O000000o.O000000o();
    private static final ajv O0000o = asn.O0000O0o((Class<?>) ajx.class);
    protected final JsonFactory O00000oO;
    protected asq O00000oo;
    protected aju O0000O0o;
    protected aoe O0000OOo;
    protected final HashMap<ash, Class<?>> O0000Oo;
    protected final atf O0000Oo0;
    protected ake O0000OoO;
    protected aqa O0000Ooo;
    protected ajs O0000o0;
    protected aqf O0000o00;
    protected alf O0000o0O;
    protected final ConcurrentHashMap<ajv, ajw<Object>> O0000o0o;

    public akc() {
        this(null, (byte) 0);
    }

    public akc(JsonFactory jsonFactory) {
        this(jsonFactory, (byte) 0);
    }

    private akc(JsonFactory jsonFactory, byte b) {
        this.O0000Oo = new HashMap<>();
        this.O0000o0o = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (jsonFactory == null) {
            this.O00000oO = new akb(this);
        } else {
            this.O00000oO = jsonFactory;
            if (jsonFactory.O000000o() == null) {
                this.O00000oO.O000000o(this);
            }
        }
        this.O0000OOo = new aot();
        this.O0000Oo0 = new atf();
        this.O00000oo = asq.O000000o();
        this.O0000OoO = new ake(O00000o, this.O0000OOo, this.O0000Oo);
        this.O0000o0 = new ajs(O00000o, this.O0000OOo, this.O0000Oo);
        this.O0000Ooo = new aqa.O000000o();
        this.O0000o0O = new alf.O000000o(akz.O0000OOo);
        this.O0000o00 = apw.O00000oO;
    }

    public final akc O000000o(DeserializationFeature deserializationFeature) {
        this.O0000o0 = this.O0000o0.O000000o(deserializationFeature);
        return this;
    }

    public final akc O00000Oo(DeserializationFeature deserializationFeature) {
        this.O0000o0 = this.O0000o0.O00000Oo(deserializationFeature);
        return this;
    }

    public final <T> T O000000o(String str, Class cls) throws IOException, JsonParseException, JsonMappingException {
        return O000000o(this.O00000oO.O000000o(str), this.O00000oo.O000000o((Type) cls));
    }

    public final <T> T O000000o(String str, ajj ajj) throws IOException, JsonParseException, JsonMappingException {
        return O000000o(this.O00000oO.O000000o(str), this.O00000oo.O00000Oo(ajj.getType(), (asp) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC, Splitter:B:20:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[SYNTHETIC, Splitter:B:24:0x004b] */
    public final String O000000o(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        aiz aiz = new aiz(JsonFactory.O00000Oo());
        JsonGenerator O000000o2 = this.O00000oO.O000000o(aiz);
        ake ake = this.O0000OoO;
        if (ake.O000000o(SerializationFeature.INDENT_OUTPUT)) {
            O000000o2.O000000o();
        }
        if (!ake.O000000o(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            boolean z = false;
            try {
                O000000o(ake).O000000o(O000000o2, obj);
                z = true;
                O000000o2.close();
            } catch (Throwable th) {
                if (!z) {
                    try {
                        O000000o2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } else {
            Closeable closeable = (Closeable) obj;
            try {
                O000000o(ake).O000000o(O000000o2, obj);
                try {
                    O000000o2.close();
                    try {
                        closeable.close();
                    } catch (Throwable th2) {
                        th = th2;
                        O000000o2 = null;
                        closeable = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    O000000o2 = null;
                    if (O000000o2 != null) {
                    }
                    if (closeable != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (O000000o2 != null) {
                    try {
                        O000000o2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        return aiz.O000000o();
    }

    private aqa O000000o(ake ake) {
        return this.O0000Ooo.O000000o(ake, this.O0000o00);
    }

    private alf O000000o(JsonParser jsonParser, ajs ajs) {
        return this.O0000o0O.O000000o(ajs, jsonParser, this.O0000O0o);
    }

    private ajw<Object> O000000o(ajt ajt, ajv ajv) throws JsonMappingException {
        ajw<Object> ajw = this.O0000o0o.get(ajv);
        if (ajw != null) {
            return ajw;
        }
        ajw<Object> O000000o2 = ajt.O000000o(ajv);
        if (O000000o2 != null) {
            this.O0000o0o.put(ajv, O000000o2);
            return O000000o2;
        }
        throw new JsonMappingException("Can not find a deserializer for type ".concat(String.valueOf(ajv)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[SYNTHETIC, Splitter:B:17:0x002f] */
    public final void O000000o(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        ake ake = this.O0000OoO;
        if (!ake.O000000o(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            O000000o(ake).O000000o(jsonGenerator, obj);
            if (ake.O000000o(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.O0000O0o();
                return;
            }
            return;
        }
        Closeable closeable = (Closeable) obj;
        try {
            O000000o(ake).O000000o(jsonGenerator, obj);
            if (ake.O000000o(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.O0000O0o();
            }
            try {
                closeable.close();
            } catch (Throwable th) {
                closeable = null;
                th = th;
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (closeable != null) {
            }
            throw th;
        }
    }

    private Object O000000o(JsonParser jsonParser, ajv ajv) throws IOException, JsonParseException, JsonMappingException {
        Object obj;
        try {
            JsonToken O00000oO2 = jsonParser.O00000oO();
            if (O00000oO2 == null) {
                O00000oO2 = jsonParser.O00000Oo();
                if (O00000oO2 == null) {
                    throw JsonMappingException.from(jsonParser, "No content to map due to end-of-input");
                }
            }
            if (O00000oO2 == JsonToken.VALUE_NULL) {
                obj = O000000o(O000000o(jsonParser, this.O0000o0), ajv).O000000o();
            } else {
                if (O00000oO2 != JsonToken.END_ARRAY) {
                    if (O00000oO2 != JsonToken.END_OBJECT) {
                        ajs ajs = this.O0000o0;
                        alf O000000o2 = O000000o(jsonParser, ajs);
                        ajw<Object> O000000o3 = O000000o(O000000o2, ajv);
                        if (ajs.O00000Oo()) {
                            String O0000oO = ajs.O0000oO();
                            if (O0000oO == null) {
                                O0000oO = this.O0000Oo0.O000000o(ajv.O00000Oo(), ajs).O000000o();
                            }
                            if (jsonParser.O00000oO() != JsonToken.START_OBJECT) {
                                throw JsonMappingException.from(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + O0000oO + "'), but " + jsonParser.O00000oO());
                            } else if (jsonParser.O00000Oo() == JsonToken.FIELD_NAME) {
                                String O00000oo2 = jsonParser.O00000oo();
                                if (O0000oO.equals(O00000oo2)) {
                                    jsonParser.O00000Oo();
                                    obj = O000000o3.O000000o(jsonParser, O000000o2);
                                    if (jsonParser.O00000Oo() != JsonToken.END_OBJECT) {
                                        throw JsonMappingException.from(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + O0000oO + "'), but " + jsonParser.O00000oO());
                                    }
                                } else {
                                    throw JsonMappingException.from(jsonParser, "Root name '" + O00000oo2 + "' does not match expected ('" + O0000oO + "') for type " + ajv);
                                }
                            } else {
                                throw JsonMappingException.from(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + O0000oO + "'), but " + jsonParser.O00000oO());
                            }
                        } else {
                            obj = O000000o3.O000000o(jsonParser, O000000o2);
                        }
                    }
                }
                obj = null;
            }
            jsonParser.O0000Oo();
            return obj;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException unused) {
            }
        }
    }
}

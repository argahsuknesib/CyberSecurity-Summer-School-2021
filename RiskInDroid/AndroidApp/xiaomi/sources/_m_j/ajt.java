package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class ajt {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final alg f12411O000000o;
    protected final alh O00000Oo;
    protected final int O00000o;
    protected final ajs O00000o0;
    protected final Class<?> O00000oO;
    protected JsonParser O00000oo;
    protected final aju O0000O0o;
    protected asu O0000OOo;
    protected DateFormat O0000Oo;
    protected atc O0000Oo0;

    public abstract aig<?> O000000o(anz anz) throws JsonMappingException;

    public abstract amd O000000o(Object obj, aig<?> aig);

    public abstract ajw<Object> O00000Oo(Object obj) throws JsonMappingException;

    public abstract aka O00000o0(Object obj) throws JsonMappingException;

    protected ajt(alh alh, alg alg) {
        if (alh != null) {
            this.O00000Oo = alh;
            this.f12411O000000o = new alg();
            this.O00000o = 0;
            this.O00000o0 = null;
            this.O0000O0o = null;
            this.O00000oO = null;
            return;
        }
        throw new IllegalArgumentException("Can not pass null DeserializerFactory");
    }

    protected ajt(ajt ajt, ajs ajs, JsonParser jsonParser, aju aju) {
        this.f12411O000000o = ajt.f12411O000000o;
        this.O00000Oo = ajt.O00000Oo;
        this.O00000o0 = ajs;
        this.O00000o = ajs.O00000o();
        this.O00000oO = ajs.O0000oOO();
        this.O00000oo = jsonParser;
        this.O0000O0o = aju;
    }

    public final ajs O000000o() {
        return this.O00000o0;
    }

    public final boolean O000000o(DeserializationFeature deserializationFeature) {
        return (deserializationFeature.getMask() & this.O00000o) != 0;
    }

    public final boolean O000000o(MapperFeature mapperFeature) {
        return this.O00000o0.O000000o(mapperFeature);
    }

    public final AnnotationIntrospector O00000Oo() {
        return this.O00000o0.O000000o();
    }

    public final JsonParser O00000o0() {
        return this.O00000oo;
    }

    public final Object O000000o(Object obj) {
        aju aju = this.O0000O0o;
        if (aju != null) {
            return aju.O000000o();
        }
        throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + obj + "]");
    }

    public final Class<?> O00000o() {
        return this.O00000oO;
    }

    public final boolean O00000oO() {
        return this.O00000o0.O0000OOo();
    }

    public final api O00000oo() {
        return this.O00000o0.O00000oo();
    }

    public final asq O0000O0o() {
        return this.O00000o0.O0000o0();
    }

    public final Locale O0000OOo() {
        return this.O00000o0.O0000o0o();
    }

    public final TimeZone O0000Oo0() {
        return this.O00000o0.O0000o();
    }

    public final ajw<Object> O000000o(ajv ajv, ajr ajr) throws JsonMappingException {
        ajw<Object> O000000o2 = this.f12411O000000o.O000000o(this, this.O00000Oo, ajv);
        return (O000000o2 == null || !(O000000o2 instanceof alc)) ? O000000o2 : ((alc) O000000o2).O000000o(this, ajr);
    }

    public final ajw<Object> O000000o(ajv ajv) throws JsonMappingException {
        ajw<?> O000000o2 = this.f12411O000000o.O000000o(this, this.O00000Oo, ajv);
        if (O000000o2 == null) {
            return null;
        }
        if (O000000o2 instanceof alc) {
            O000000o2 = ((alc) O000000o2).O000000o(this, null);
        }
        aof O00000Oo2 = this.O00000Oo.O00000Oo(this.O00000o0, ajv);
        return O00000Oo2 != null ? new amf(O00000Oo2.O000000o(null), O000000o2) : O000000o2;
    }

    public final aka O00000Oo(ajv ajv) throws JsonMappingException {
        aka O000000o2 = this.O00000Oo.O000000o(this, ajv);
        if (O000000o2 != null) {
            if (O000000o2 instanceof alk) {
                ((alk) O000000o2).O000000o(this);
            }
            return O000000o2 instanceof ald ? ((ald) O000000o2).O000000o() : O000000o2;
        }
        throw new JsonMappingException("Can not find a (Map) Key deserializer for type ".concat(String.valueOf(ajv)));
    }

    public final ajv O000000o(Class<?> cls) {
        return this.O00000o0.O00000Oo(cls);
    }

    public final atc O0000Oo() {
        atc atc = this.O0000Oo0;
        if (atc == null) {
            return new atc();
        }
        this.O0000Oo0 = null;
        return atc;
    }

    public final void O000000o(atc atc) {
        if (this.O0000Oo0 == null || atc.O00000Oo() >= this.O0000Oo0.O00000Oo()) {
            this.O0000Oo0 = atc;
        }
    }

    public final asu O0000OoO() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new asu();
        }
        return this.O0000OOo;
    }

    public final void O000000o(Object obj, String str, ajw<?> ajw) throws JsonMappingException {
        if (O000000o(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.from(this.O00000oo, obj, str, ajw.O00000Oo());
        }
    }

    public final JsonMappingException O00000Oo(Class<?> cls) {
        return O000000o(cls, this.O00000oo.O00000oO());
    }

    public final JsonMappingException O000000o(Class<?> cls, JsonToken jsonToken) {
        String O00000o02 = O00000o0(cls);
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not deserialize instance of " + O00000o02 + " out of " + jsonToken + " token");
    }

    public final JsonMappingException O000000o(Class<?> cls, Throwable th) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + ", problem: " + th.getMessage(), th);
    }

    public final JsonMappingException O000000o(Class<?> cls, String str) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + ", problem: " + str);
    }

    public final JsonMappingException O00000Oo(Class<?> cls, String str) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + " from String value '" + O0000Ooo() + "': " + str);
    }

    public final JsonMappingException O00000o0(Class<?> cls, String str) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + " from number value (" + O0000Ooo() + "): " + str);
    }

    public final JsonMappingException O000000o(Class<?> cls, String str, String str2) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Can not construct Map key of type " + cls.getName() + " from String \"" + O00000o0(str) + "\": " + str2);
    }

    public static JsonMappingException O000000o(JsonParser jsonParser, JsonToken jsonToken, String str) {
        return JsonMappingException.from(jsonParser, "Unexpected token (" + jsonParser.O00000oO() + "), expected " + jsonToken + ": " + str);
    }

    public final JsonMappingException O000000o(ajv ajv, String str) {
        JsonParser jsonParser = this.O00000oo;
        return JsonMappingException.from(jsonParser, "Could not resolve type id '" + str + "' into a subtype of " + ajv);
    }

    private String O00000o0(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        return O00000o0(cls.getComponentType()) + "[]";
    }

    private String O0000Ooo() {
        try {
            return O00000o0(this.O00000oo.O0000OoO());
        } catch (Exception unused) {
            return "[N/A]";
        }
    }

    private static String O00000o0(String str) {
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }

    public final Date O000000o(String str) throws IllegalArgumentException {
        DateFormat dateFormat;
        try {
            if (this.O0000Oo != null) {
                dateFormat = this.O0000Oo;
            } else {
                dateFormat = (DateFormat) this.O00000o0.O0000o0O().clone();
                this.O0000Oo = dateFormat;
            }
            return dateFormat.parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse Date value '" + str + "': " + e.getMessage());
        }
    }

    public final Calendar O000000o(Date date) {
        Calendar instance = Calendar.getInstance(this.O00000o0.O0000o());
        instance.setTime(date);
        return instance;
    }

    public final JsonMappingException O00000Oo(String str) {
        return JsonMappingException.from(this.O00000oo, str);
    }
}

package _m_j;

import _m_j.aqe;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class akf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final ajv f12417O000000o = asq.O000000o((Class<?>) Object.class);
    public static final ajz<Object> O00000Oo = new aqh("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final ajz<Object> O00000o0 = new aqu();
    protected final ake O00000o;
    protected final Class<?> O00000oO;
    protected final aqf O00000oo;
    protected final aqe O0000O0o;
    protected final atf O0000OOo;
    protected ajz<Object> O0000Oo;
    protected ajz<Object> O0000Oo0;
    protected ajz<Object> O0000OoO;
    protected ajz<Object> O0000Ooo;
    protected DateFormat O0000o0;
    protected final aqq O0000o00;

    public abstract aig<?> O000000o(anz anz) throws JsonMappingException;

    public abstract ajz<Object> O000000o(Object obj) throws JsonMappingException;

    public abstract aqx O000000o(Object obj, aig<?> aig);

    static {
        asq.O000000o();
    }

    public akf() {
        this.O0000Oo0 = O00000o0;
        this.O0000OoO = aro.f12549O000000o;
        this.O0000Ooo = O00000Oo;
        this.O00000o = null;
        this.O00000oo = null;
        this.O0000O0o = new aqe();
        this.O0000o00 = null;
        this.O0000OOo = new atf();
        this.O00000oO = null;
    }

    protected akf(akf akf, ake ake, aqf aqf) {
        this.O0000Oo0 = O00000o0;
        this.O0000OoO = aro.f12549O000000o;
        this.O0000Ooo = O00000Oo;
        if (ake != null) {
            this.O00000oo = aqf;
            this.O00000o = ake;
            this.O0000O0o = akf.O0000O0o;
            this.O0000Oo0 = akf.O0000Oo0;
            this.O0000Oo = akf.O0000Oo;
            this.O0000OoO = akf.O0000OoO;
            this.O0000Ooo = akf.O0000Ooo;
            this.O0000OOo = akf.O0000OOo;
            this.O0000o00 = this.O0000O0o.O000000o();
            this.O00000oO = ake.O0000oOO();
            return;
        }
        throw new NullPointerException();
    }

    public final ake O000000o() {
        return this.O00000o;
    }

    public final boolean O000000o(MapperFeature mapperFeature) {
        return this.O00000o.O000000o(mapperFeature);
    }

    public final boolean O000000o(SerializationFeature serializationFeature) {
        return this.O00000o.O000000o(serializationFeature);
    }

    public final boolean O00000Oo() {
        return this.O00000o.O0000OOo();
    }

    public final AnnotationIntrospector O00000o0() {
        return this.O00000o.O000000o();
    }

    public final Class<?> O00000o() {
        return this.O00000oO;
    }

    public final aqb O00000oO() {
        return this.O00000o.O00000o();
    }

    public final Locale O00000oo() {
        return this.O00000o.O0000o0o();
    }

    public final TimeZone O0000O0o() {
        return this.O00000o.O0000o();
    }

    public final ajv O000000o(Type type) {
        return this.O00000o.O0000o0().O000000o(type);
    }

    public final ajv O000000o(ajv ajv, Class<?> cls) {
        return this.O00000o.O000000o(ajv, cls);
    }

    public final asq O0000OOo() {
        return this.O00000o.O0000o0();
    }

    public final ajz<Object> O000000o(Class<?> cls, ajr ajr) throws JsonMappingException {
        ajz<Object> O00000Oo2 = this.O0000o00.O00000Oo(cls);
        if (O00000Oo2 == null && (O00000Oo2 = this.O0000O0o.O000000o(cls)) == null && (O00000Oo2 = this.O0000O0o.O000000o(this.O00000o.O00000Oo(cls))) == null && (O00000Oo2 = O00000o0(cls, ajr)) == null) {
            return this.O0000Oo0;
        }
        return O000000o(O00000Oo2, ajr);
    }

    public final ajz<Object> O000000o(ajv ajv, ajr ajr) throws JsonMappingException {
        ajz<Object> O00000Oo2 = this.O0000o00.O00000Oo(ajv);
        if (O00000Oo2 == null && (O00000Oo2 = this.O0000O0o.O000000o(ajv)) == null && (O00000Oo2 = O00000o(ajv, ajr)) == null) {
            return this.O0000Oo0;
        }
        return O000000o(O00000Oo2, ajr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
     arg types: [java.lang.Class<?>, int]
     candidates:
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void */
    public final ajz<Object> O00000Oo(Class<?> cls, ajr ajr) throws JsonMappingException {
        ajz<Object> O000000o2 = this.O0000o00.O000000o(cls);
        if (O000000o2 != null) {
            return O000000o2;
        }
        ajz<Object> O00000Oo2 = this.O0000O0o.O00000Oo(cls);
        if (O00000Oo2 != null) {
            return O00000Oo2;
        }
        ajz<Object> O000000o3 = O000000o(cls, ajr);
        aqf aqf = this.O00000oo;
        ake ake = this.O00000o;
        aoi O00000Oo3 = aqf.O00000Oo(ake, ake.O00000Oo(cls));
        if (O00000Oo3 != null) {
            O000000o3 = new aqt(O00000Oo3.O000000o(ajr), O000000o3);
        }
        aqe aqe = this.O0000O0o;
        synchronized (aqe) {
            if (aqe.f12521O000000o.put(new aqe.O000000o(cls, true), O000000o3) == null) {
                aqe.O00000Oo = null;
            }
        }
        return O000000o3;
    }

    public final ajz<Object> O00000Oo(ajv ajv, ajr ajr) throws JsonMappingException {
        ajz<Object> O000000o2 = this.O0000o00.O000000o(ajv);
        if (O000000o2 != null) {
            return O000000o2;
        }
        ajz<Object> O00000Oo2 = this.O0000O0o.O00000Oo(ajv);
        if (O00000Oo2 != null) {
            return O00000Oo2;
        }
        ajz<Object> O000000o3 = O000000o(ajv, ajr);
        aoi O00000Oo3 = this.O00000oo.O00000Oo(this.O00000o, ajv);
        return O00000Oo3 != null ? new aqt(O00000Oo3.O000000o(ajr), O000000o3) : O000000o3;
    }

    public final ajz<Object> O00000o0(ajv ajv, ajr ajr) throws JsonMappingException {
        ajz<Object> O000000o2 = this.O00000oo.O000000o(this.O00000o, ajv);
        if (O000000o2 == null && (O000000o2 = this.O0000Oo) == null) {
            O000000o2 = arz.O000000o(ajv);
        }
        if (O000000o2 instanceof aqd) {
            ((aqd) O000000o2).O000000o(this);
        }
        return O000000o(O000000o2, ajr);
    }

    public final ajz<Object> O0000Oo0() {
        return this.O0000OoO;
    }

    public final void O000000o(Date date, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (O000000o(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.O000000o(date.getTime());
        } else {
            jsonGenerator.O00000Oo(O0000Ooo().format(date));
        }
    }

    public final void O000000o(long j, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (O000000o(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.O000000o(String.valueOf(j));
        } else {
            jsonGenerator.O000000o(O0000Ooo().format(new Date(j)));
        }
    }

    public final void O00000Oo(Date date, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (O000000o(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.O000000o(String.valueOf(date.getTime()));
        } else {
            jsonGenerator.O000000o(O0000Ooo().format(date));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
     arg types: [java.lang.Class<?>, int]
     candidates:
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void */
    private ajz<Object> O00000o0(Class<?> cls, ajr ajr) throws JsonMappingException {
        try {
            ajz<Object> O00000oO2 = O00000oO(this.O00000o.O00000Oo(cls), ajr);
            if (O00000oO2 != null) {
                aqe aqe = this.O0000O0o;
                synchronized (aqe) {
                    if (aqe.f12521O000000o.put(new aqe.O000000o(cls, false), O00000oO2) == null) {
                        aqe.O00000Oo = null;
                    }
                    if (O00000oO2 instanceof aqd) {
                        ((aqd) O00000oO2).O000000o(this);
                    }
                }
            }
            return O00000oO2;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
     arg types: [_m_j.ajv, int]
     candidates:
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void */
    private ajz<Object> O00000o(ajv ajv, ajr ajr) throws JsonMappingException {
        try {
            ajz<Object> O00000oO2 = O00000oO(ajv, ajr);
            if (O00000oO2 != null) {
                aqe aqe = this.O0000O0o;
                synchronized (aqe) {
                    if (aqe.f12521O000000o.put(new aqe.O000000o(ajv, false), O00000oO2) == null) {
                        aqe.O00000Oo = null;
                    }
                    if (O00000oO2 instanceof aqd) {
                        ((aqd) O00000oO2).O000000o(this);
                    }
                }
            }
            return O00000oO2;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    private ajz<Object> O00000oO(ajv ajv, ajr ajr) throws JsonMappingException {
        return this.O00000oo.O000000o(this, ajv, ajr);
    }

    private ajz<Object> O000000o(ajz<?> ajz, ajr ajr) throws JsonMappingException {
        return ajz instanceof apz ? ((apz) ajz).O000000o(this, ajr) : ajz;
    }

    private DateFormat O0000Ooo() {
        DateFormat dateFormat = this.O0000o0;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.O00000o.O0000o0O().clone();
        this.O0000o0 = dateFormat2;
        return dateFormat2;
    }

    public final ajz<Object> O0000Oo() throws JsonMappingException {
        return this.O0000Ooo;
    }

    public final ajz<Object> O0000OoO() throws JsonMappingException {
        return this.O0000OoO;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        if (obj == null) {
            this.O0000OoO.O000000o(null, jsonGenerator, this);
        } else {
            O00000Oo(obj.getClass(), (ajr) null).O000000o(obj, jsonGenerator, this);
        }
    }

    public final void O000000o(JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        this.O0000OoO.O000000o(null, jsonGenerator, this);
    }
}

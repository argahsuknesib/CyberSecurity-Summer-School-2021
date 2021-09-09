package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public final class amn extends anb<Enum<?>> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final asy<?> f12459O000000o;

    public final boolean O00000o0() {
        return true;
    }

    public amn(asy<?> asy) {
        super(Enum.class);
        this.f12459O000000o = asy;
    }

    public static ajw<?> O000000o(ajs ajs, Class<?> cls, ann ann) {
        Class cls2;
        Class<?> O0000o0 = ann.O0000o0();
        if (O0000o0 == String.class) {
            cls2 = null;
        } else if (O0000o0 == Integer.TYPE || O0000o0 == Integer.class) {
            cls2 = Integer.class;
        } else if (O0000o0 == Long.TYPE || O0000o0 == Long.class) {
            cls2 = Long.class;
        } else {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + ann + ") not suitable, must be java.lang.String or int/Integer/long/Long");
        }
        if (ajs.O0000OOo()) {
            asw.O000000o((Member) ann.O0000O0o());
        }
        return new O000000o(cls, ann, cls2);
    }

    public static class O000000o extends anb<Object> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final Class<?> f12460O000000o;
        protected final Class<?> O00000Oo;
        protected final Method O00000o0;

        public O000000o(Class<?> cls, ann ann, Class<?> cls2) {
            super(Enum.class);
            this.f12460O000000o = cls;
            this.O00000o0 = ann.O00000oo();
            this.O00000Oo = cls2;
        }

        public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            Object obj;
            Class<?> cls = this.O00000Oo;
            if (cls == null) {
                obj = jsonParser.O0000OoO();
            } else if (cls == Integer.class) {
                obj = Integer.valueOf(jsonParser.O00oOooo());
            } else if (cls == Long.class) {
                obj = Long.valueOf(jsonParser.O000O00o());
            } else {
                throw ajt.O00000Oo(this.f12460O000000o);
            }
            try {
                return this.O00000o0.invoke(this.f12460O000000o, obj);
            } catch (Exception e) {
                asw.O00000Oo(asw.O000000o((Throwable) e));
                return null;
            }
        }
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_STRING || O00000oO == JsonToken.FIELD_NAME) {
            Object O000000o2 = this.f12459O000000o.O000000o(jsonParser.O0000OoO());
            if (O000000o2 != null || ajt.O000000o(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return O000000o2;
            }
            throw ajt.O00000Oo(this.f12459O000000o.O000000o(), "value not one of declared Enum instance names");
        } else if (O00000oO != JsonToken.VALUE_NUMBER_INT) {
            throw ajt.O00000Oo(this.f12459O000000o.O000000o());
        } else if (!ajt.O000000o(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
            Object O000000o3 = this.f12459O000000o.O000000o(jsonParser.O0000oOO());
            if (O000000o3 != null || ajt.O000000o(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return O000000o3;
            }
            Class<?> O000000o4 = this.f12459O000000o.O000000o();
            throw ajt.O00000o0(O000000o4, "index value outside legal index range [0.." + this.f12459O000000o.O00000Oo() + "]");
        } else {
            throw ajt.O00000Oo("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
        }
    }
}

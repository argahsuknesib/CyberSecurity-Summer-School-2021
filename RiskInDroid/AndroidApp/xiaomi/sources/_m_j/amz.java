package _m_j;

import _m_j.ams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public abstract class amz extends aka {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<?> f12473O000000o;

    /* access modifiers changed from: protected */
    public abstract Object O00000Oo(String str, ajt ajt) throws Exception;

    protected amz(Class<?> cls) {
        this.f12473O000000o = cls;
    }

    public final Object O000000o(String str, ajt ajt) throws IOException, JsonProcessingException {
        if (str == null) {
            return null;
        }
        try {
            Object O00000Oo2 = O00000Oo(str, ajt);
            if (O00000Oo2 != null) {
                return O00000Oo2;
            }
            if (this.f12473O000000o.isEnum() && ajt.O000000o().O00000o0(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            throw ajt.O000000o(this.f12473O000000o, str, "not a valid representation");
        } catch (Exception e) {
            Class<?> cls = this.f12473O000000o;
            throw ajt.O000000o(cls, str, "not a valid representation: " + e.getMessage());
        }
    }

    public final Class<?> O000000o() {
        return this.f12473O000000o;
    }

    @akg
    public static final class O000O0o extends amz {
        private static final O000O0o O00000Oo = new O000O0o(String.class);
        private static final O000O0o O00000o0 = new O000O0o(Object.class);

        public final /* bridge */ /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            return str;
        }

        private O000O0o(Class<?> cls) {
            super(cls);
        }

        public static O000O0o O000000o(Class<?> cls) {
            if (cls == String.class) {
                return O00000Oo;
            }
            if (cls == Object.class) {
                return O00000o0;
            }
            return new O000O0o(cls);
        }
    }

    @akg
    static final class O000000o extends amz {
        O000000o() {
            super(Boolean.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw ajt.O000000o(this.f12473O000000o, str, "value not 'true' or 'false'");
        }
    }

    @akg
    static final class O00000Oo extends amz {
        O00000Oo() {
            super(Byte.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= -128 && parseInt <= 255) {
                return Byte.valueOf((byte) parseInt);
            }
            throw ajt.O000000o(this.f12473O000000o, str, "overflow, value can not be represented as 8-bit value");
        }
    }

    @akg
    static final class O000O00o extends amz {
        O000O00o() {
            super(Integer.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= -32768 && parseInt <= 32767) {
                return Short.valueOf((short) parseInt);
            }
            throw ajt.O000000o(this.f12473O000000o, str, "overflow, value can not be represented as 16-bit value");
        }
    }

    @akg
    static final class O00000o extends amz {
        O00000o() {
            super(Character.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw ajt.O000000o(this.f12473O000000o, str, "can only convert 1-character Strings");
        }
    }

    @akg
    static final class O0000o0 extends amz {
        O0000o0() {
            super(Integer.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            return Integer.valueOf(Integer.parseInt(str));
        }
    }

    @akg
    static final class O00oOooO extends amz {
        O00oOooO() {
            super(Long.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            return Long.valueOf(Long.parseLong(str));
        }
    }

    @akg
    static final class O0000Oo0 extends amz {
        O0000Oo0() {
            super(Double.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            return Double.valueOf(aiw.O00000o(str));
        }
    }

    @akg
    static final class O0000o00 extends amz {
        O0000o00() {
            super(Float.class);
        }

        public final /* synthetic */ Object O00000Oo(String str, ajt ajt) throws Exception {
            return Float.valueOf((float) aiw.O00000o(str));
        }
    }

    @akg
    static final class O0000o extends amz {
        protected ams.O0000OOo O00000Oo = new ams.O0000OOo();

        O0000o() {
            super(Locale.class);
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public Locale O00000Oo(String str, ajt ajt) throws JsonMappingException {
            try {
                return ams.O0000OOo.O00000Oo(str);
            } catch (IOException unused) {
                throw ajt.O000000o(this.f12473O000000o, str, "unable to parse key as locale");
            }
        }
    }

    static final class O0000OOo extends aka {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final Class<?> f12474O000000o;
        protected final ajw<?> O00000Oo;

        protected O0000OOo(Class<?> cls, ajw<?> ajw) {
            this.f12474O000000o = cls;
            this.O00000Oo = ajw;
        }

        public final Object O000000o(String str, ajt ajt) throws IOException, JsonProcessingException {
            if (str == null) {
                return null;
            }
            try {
                Object O000000o2 = this.O00000Oo.O000000o(ajt.O00000o0(), ajt);
                if (O000000o2 != null) {
                    return O000000o2;
                }
                throw ajt.O000000o(this.f12474O000000o, str, "not a valid representation");
            } catch (Exception e) {
                Class<?> cls = this.f12474O000000o;
                throw ajt.O000000o(cls, str, "not a valid representation: " + e.getMessage());
            }
        }
    }

    @akg
    static final class O0000Oo extends amz {
        protected final asy<?> O00000Oo;
        protected final ann O00000o0;

        protected O0000Oo(asy<?> asy, ann ann) {
            super(asy.O000000o());
            this.O00000Oo = asy;
            this.O00000o0 = ann;
        }

        public final Object O00000Oo(String str, ajt ajt) throws JsonMappingException {
            ann ann = this.O00000o0;
            if (ann != null) {
                try {
                    return ann.O000000o(str);
                } catch (Exception e) {
                    asw.O00000Oo(asw.O000000o((Throwable) e));
                }
            }
            Object O000000o2 = this.O00000Oo.O000000o(str);
            if (O000000o2 != null || ajt.O000000o().O00000o0(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return O000000o2;
            }
            throw ajt.O000000o(this.f12473O000000o, str, "not one of values for Enum class");
        }
    }

    public static final class O000O0OO extends amz {
        protected final Constructor<?> O00000Oo;

        public O000O0OO(Constructor<?> constructor) {
            super(constructor.getDeclaringClass());
            this.O00000Oo = constructor;
        }

        public final Object O00000Oo(String str, ajt ajt) throws Exception {
            return this.O00000Oo.newInstance(str);
        }
    }

    public static final class O000O0o0 extends amz {
        final Method O00000Oo;

        public O000O0o0(Method method) {
            super(method.getDeclaringClass());
            this.O00000Oo = method;
        }

        public final Object O00000Oo(String str, ajt ajt) throws Exception {
            return this.O00000Oo.invoke(null, str);
        }
    }

    @akg
    static final class O0000O0o extends amz {
        protected O0000O0o() {
            super(Date.class);
        }

        public final Object O00000Oo(String str, ajt ajt) throws IllegalArgumentException, JsonMappingException {
            return ajt.O000000o(str);
        }
    }

    @akg
    static final class O00000o0 extends amz {
        protected O00000o0() {
            super(Calendar.class);
        }

        public final Object O00000Oo(String str, ajt ajt) throws IllegalArgumentException, JsonMappingException {
            Date O000000o2 = ajt.O000000o(str);
            if (O000000o2 == null) {
                return null;
            }
            return ajt.O000000o(O000000o2);
        }
    }

    @akg
    static final class O000OO00 extends amz {
        protected O000OO00() {
            super(UUID.class);
        }

        public final Object O00000Oo(String str, ajt ajt) throws IllegalArgumentException, JsonMappingException {
            return UUID.fromString(str);
        }
    }
}

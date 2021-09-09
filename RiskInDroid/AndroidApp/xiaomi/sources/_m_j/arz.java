package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public final class arz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final ajz<Object> f12563O000000o = new ary();
    protected static final ajz<Object> O00000Oo = new O00000o0();

    public static ajz<Object> O000000o(ajv ajv) {
        if (ajv == null) {
            return f12563O000000o;
        }
        Class<?> O00000Oo2 = ajv.O00000Oo();
        if (O00000Oo2 == String.class) {
            return O00000Oo;
        }
        if (O00000Oo2 == Object.class) {
            return f12563O000000o;
        }
        if (Date.class.isAssignableFrom(O00000Oo2)) {
            return O00000Oo.f12565O000000o;
        }
        if (Calendar.class.isAssignableFrom(O00000Oo2)) {
            return O000000o.f12564O000000o;
        }
        return f12563O000000o;
    }

    public static class O00000o0 extends asb<String> {
        public final /* bridge */ /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o((String) obj);
        }

        public O00000o0() {
            super(String.class);
        }
    }

    public static class O00000Oo extends asb<Date> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final ajz<?> f12565O000000o = new O00000Oo();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            akf.O00000Oo((Date) obj, jsonGenerator);
        }

        public O00000Oo() {
            super(Date.class);
        }
    }

    public static class O000000o extends asb<Calendar> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final ajz<?> f12564O000000o = new O000000o();

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            akf.O000000o(((Calendar) obj).getTimeInMillis(), jsonGenerator);
        }

        public O000000o() {
            super(Calendar.class);
        }
    }
}

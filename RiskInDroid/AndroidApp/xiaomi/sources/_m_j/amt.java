package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public final class amt extends ami<ajx> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final amt f12464O000000o = new amt();

    public final /* bridge */ /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return super.O000000o(jsonParser, ajt, aof);
    }

    protected amt() {
        super(ajx.class);
    }

    public static ajw<? extends ajx> O000000o(Class<?> cls) {
        if (cls == apm.class) {
            return O00000Oo.O00000o();
        }
        if (cls == aoz.class) {
            return O000000o.O00000o();
        }
        return f12464O000000o;
    }

    /* renamed from: _m_j.amt$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12465O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f12465O000000o[JsonToken.START_OBJECT.ordinal()] = 1;
            f12465O000000o[JsonToken.START_ARRAY.ordinal()] = 2;
        }
    }

    static final class O00000Oo extends ami<apm> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final O00000Oo f12467O000000o = new O00000Oo();

        protected O00000Oo() {
            super(apm.class);
        }

        public static O00000Oo O00000o() {
            return f12467O000000o;
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O00000oO() == JsonToken.START_OBJECT) {
                jsonParser.O00000Oo();
                return O000000o(jsonParser, ajt, ajt.O00000oo());
            } else if (jsonParser.O00000oO() == JsonToken.FIELD_NAME) {
                return O000000o(jsonParser, ajt, ajt.O00000oo());
            } else {
                throw ajt.O00000Oo((Class<?>) apm.class);
            }
        }
    }

    static final class O000000o extends ami<aoz> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final O000000o f12466O000000o = new O000000o();

        protected O000000o() {
            super(aoz.class);
        }

        public static O000000o O00000o() {
            return f12466O000000o;
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                return O00000Oo(jsonParser, ajt, ajt.O00000oo());
            }
            throw ajt.O00000Oo((Class<?>) aoz.class);
        }
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        int i = AnonymousClass1.f12465O000000o[jsonParser.O00000oO().ordinal()];
        if (i == 1) {
            return O000000o(jsonParser, ajt, ajt.O00000oo());
        }
        if (i != 2) {
            return O00000o0(jsonParser, ajt, ajt.O00000oo());
        }
        return O00000Oo(jsonParser, ajt, ajt.O00000oo());
    }
}

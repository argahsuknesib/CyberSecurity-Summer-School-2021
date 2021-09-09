package _m_j;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Map;

public abstract class amb {

    /* renamed from: O000000o  reason: collision with root package name */
    public final amb f12450O000000o;
    public final Object O00000Oo;

    public abstract void O000000o(Object obj) throws IOException, JsonProcessingException;

    protected amb(amb amb, Object obj) {
        this.f12450O000000o = amb;
        this.O00000Oo = obj;
    }

    static final class O00000o0 extends amb {
        final alm O00000o0;

        public O00000o0(amb amb, Object obj, alm alm) {
            super(amb, obj);
            this.O00000o0 = alm;
        }

        public final void O000000o(Object obj) throws IOException, JsonProcessingException {
            this.O00000o0.O000000o(obj, this.O00000Oo);
        }
    }

    static final class O000000o extends amb {
        final String O00000o;
        final all O00000o0;

        public O000000o(amb amb, Object obj, all all, String str) {
            super(amb, obj);
            this.O00000o0 = all;
            this.O00000o = str;
        }

        public final void O000000o(Object obj) throws IOException, JsonProcessingException {
            this.O00000o0.O000000o(obj, this.O00000o, this.O00000Oo);
        }
    }

    public static final class O00000Oo extends amb {
        final Object O00000o0;

        public O00000Oo(amb amb, Object obj, Object obj2) {
            super(amb, obj);
            this.O00000o0 = obj2;
        }

        public final void O000000o(Object obj) throws IOException, JsonProcessingException {
            ((Map) obj).put(this.O00000o0, this.O00000Oo);
        }
    }
}

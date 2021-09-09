package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.reflect.Constructor;

public final class alt extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final alm f12442O000000o;
    protected final Constructor<?> O00000Oo;

    public alt(alm alm, Constructor<?> constructor) {
        super(alm);
        this.f12442O000000o = alm;
        this.O00000Oo = constructor;
    }

    private alt(alt alt, ajw<?> ajw) {
        super(alt, ajw);
        this.f12442O000000o = alt.f12442O000000o.O00000Oo(ajw);
        this.O00000Oo = alt.O00000Oo;
    }

    private alt(alt alt, String str) {
        super(alt, str);
        this.f12442O000000o = alt.f12442O000000o.O000000o(str);
        this.O00000Oo = alt.O00000Oo;
    }

    public final anm O00000Oo() {
        return this.f12442O000000o.O00000Oo();
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        Object obj2 = null;
        if (jsonParser.O00000oO() == JsonToken.VALUE_NULL) {
            if (this.O0000OOo != null) {
                obj2 = this.O0000OOo.O000000o(ajt);
            }
        } else if (this.O0000O0o != null) {
            obj2 = this.O00000oo.O000000o(jsonParser, ajt, this.O0000O0o);
        } else {
            try {
                obj2 = this.O00000Oo.newInstance(obj);
            } catch (Exception e) {
                asw.O000000o(e, "Failed to instantiate class " + this.O00000Oo.getDeclaringClass().getName() + ", problem: " + e.getMessage());
            }
            this.O00000oo.O000000o(jsonParser, ajt, obj2);
        }
        O000000o(obj, obj2);
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O00000Oo(obj, O000000o(jsonParser, ajt));
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        this.f12442O000000o.O000000o(obj, obj2);
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        return this.f12442O000000o.O00000Oo(obj, obj2);
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new alt(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new alt(this, ajw);
    }
}

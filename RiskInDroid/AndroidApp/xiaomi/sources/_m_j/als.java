package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.lang.reflect.Field;

public final class als extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final anl f12441O000000o;
    protected final Field O00000Oo;

    public als(anu anu, ajv ajv, aof aof, ast ast, anl anl) {
        super(anu, ajv, aof, ast);
        this.f12441O000000o = anl;
        this.O00000Oo = anl.O00000oo();
    }

    private als(als als, ajw<?> ajw) {
        super(als, ajw);
        this.f12441O000000o = als.f12441O000000o;
        this.O00000Oo = als.O00000Oo;
    }

    private als(als als, String str) {
        super(als, str);
        this.f12441O000000o = als.f12441O000000o;
        this.O00000Oo = als.O00000Oo;
    }

    public final anm O00000Oo() {
        return this.f12441O000000o;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O000000o(obj, O000000o(jsonParser, ajt));
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O00000Oo(obj, O000000o(jsonParser, ajt));
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        try {
            this.O00000Oo.set(obj, obj2);
        } catch (Exception e) {
            O000000o(e, obj2);
        }
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        try {
            this.O00000Oo.set(obj, obj2);
        } catch (Exception e) {
            O000000o(e, obj2);
        }
        return obj;
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new als(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new als(this, ajw);
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class ale extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final anp f12431O000000o;
    protected final Object O00000Oo;

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        return obj;
    }

    public ale(String str, ajv ajv, aof aof, ast ast, anp anp, int i, Object obj) {
        super(str, ajv, aof, ast);
        this.f12431O000000o = anp;
        this.O0000OoO = i;
        this.O00000Oo = obj;
    }

    private ale(ale ale, String str) {
        super(ale, str);
        this.f12431O000000o = ale.f12431O000000o;
        this.O00000Oo = ale.O00000Oo;
    }

    private ale(ale ale, ajw<?> ajw) {
        super(ale, ajw);
        this.f12431O000000o = ale.f12431O000000o;
        this.O00000Oo = ale.O00000Oo;
    }

    /* renamed from: O000000o */
    public final ale O00000Oo(ajw<?> ajw) {
        return new ale(this, ajw);
    }

    public final anm O00000Oo() {
        return this.f12431O000000o;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O000000o(obj, O000000o(jsonParser, ajt));
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O00000Oo(obj, O000000o(jsonParser, ajt));
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        throw new IllegalStateException("Method should never be called on a " + getClass().getName());
    }

    public final Object O00000o0() {
        return this.O00000Oo;
    }

    public final String toString() {
        return "[creator property, name '" + O00000o() + "'; inject id '" + this.O00000Oo + "']";
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new ale(this, str);
    }
}

package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.lang.reflect.Method;

public final class alv extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ann f12444O000000o;
    protected final Method O00000Oo;

    public alv(anu anu, ajv ajv, aof aof, ast ast, ann ann) {
        super(anu, ajv, aof, ast);
        this.f12444O000000o = ann;
        this.O00000Oo = ann.O00000oo();
    }

    private alv(alv alv, ajw<?> ajw) {
        super(alv, ajw);
        this.f12444O000000o = alv.f12444O000000o;
        this.O00000Oo = alv.O00000Oo;
    }

    private alv(alv alv, String str) {
        super(alv, str);
        this.f12444O000000o = alv.f12444O000000o;
        this.O00000Oo = alv.O00000Oo;
    }

    public final anm O00000Oo() {
        return this.f12444O000000o;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O000000o(obj, O000000o(jsonParser, ajt));
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O00000Oo(obj, O000000o(jsonParser, ajt));
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        try {
            this.O00000Oo.invoke(obj, obj2);
        } catch (Exception e) {
            O000000o(e, obj2);
        }
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        try {
            Object invoke = this.O00000Oo.invoke(obj, obj2);
            return invoke == null ? obj : invoke;
        } catch (Exception e) {
            O000000o(e, obj2);
            return null;
        }
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new alv(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new alv(this, ajw);
    }
}

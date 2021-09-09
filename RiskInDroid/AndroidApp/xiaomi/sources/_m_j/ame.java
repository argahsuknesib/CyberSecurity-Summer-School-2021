package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Method;

public final class ame extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ann f12453O000000o;
    protected final Method O00000Oo;

    public ame(anu anu, ajv ajv, aof aof, ast ast, ann ann) {
        super(anu, ajv, aof, ast);
        this.f12453O000000o = ann;
        this.O00000Oo = ann.O00000oo();
    }

    private ame(ame ame, ajw<?> ajw) {
        super(ame, ajw);
        this.f12453O000000o = ame.f12453O000000o;
        this.O00000Oo = ame.O00000Oo;
    }

    private ame(ame ame, String str) {
        super(ame, str);
        this.f12453O000000o = ame.f12453O000000o;
        this.O00000Oo = ame.O00000Oo;
    }

    public final anm O00000Oo() {
        return this.f12453O000000o;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() != JsonToken.VALUE_NULL) {
            try {
                Object invoke = this.O00000Oo.invoke(obj, new Object[0]);
                if (invoke != null) {
                    this.O00000oo.O000000o(jsonParser, ajt, invoke);
                    return;
                }
                throw new JsonMappingException("Problem deserializing 'setterless' property '" + O00000o() + "': get method returned null");
            } catch (Exception e) {
                O000000o(e);
            }
        }
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O000000o(jsonParser, ajt, obj);
        return obj;
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        throw new UnsupportedOperationException("Should never call 'set' on setterless property");
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        O000000o(obj, obj2);
        return null;
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new ame(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new ame(this, ajw);
    }
}

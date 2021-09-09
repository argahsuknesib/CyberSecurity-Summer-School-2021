package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class aly extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final alx f12447O000000o;

    public final anm O00000Oo() {
        return null;
    }

    public aly(alx alx) {
        super(alx.O00000Oo, alx.f12446O000000o, (aof) null, (ast) null);
        this.f12447O000000o = alx;
        this.O00000oo = alx.O00000o;
    }

    private aly(aly aly, ajw<?> ajw) {
        super(aly, ajw);
        this.f12447O000000o = aly.f12447O000000o;
    }

    private aly(aly aly, String str) {
        super(aly, str);
        this.f12447O000000o = aly.f12447O000000o;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O00000Oo(jsonParser, ajt, obj);
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        Object O000000o2 = this.O00000oo.O000000o(jsonParser, ajt);
        ajt.O000000o(O000000o2, this.f12447O000000o.O00000o0).O000000o(obj);
        alm alm = this.f12447O000000o.O00000oO;
        return alm != null ? alm.O00000Oo(obj, O000000o2) : obj;
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        O00000Oo(obj, obj2);
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        alm alm = this.f12447O000000o.O00000oO;
        if (alm != null) {
            return alm.O00000Oo(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new aly(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new aly(this, ajw);
    }
}

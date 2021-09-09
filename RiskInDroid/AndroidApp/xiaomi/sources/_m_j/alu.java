package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public final class alu extends alm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12443O000000o;
    protected final boolean O00000Oo;
    protected final alm O0000Ooo;
    protected final alm O0000o00;

    public alu(alm alm, String str, alm alm2, ast ast, boolean z) {
        super(alm.O00000o(), alm.O000000o(), alm.O0000Oo0(), ast);
        this.f12443O000000o = str;
        this.O0000Ooo = alm;
        this.O0000o00 = alm2;
        this.O00000Oo = z;
    }

    private alu(alu alu, ajw<?> ajw) {
        super(alu, ajw);
        this.f12443O000000o = alu.f12443O000000o;
        this.O00000Oo = alu.O00000Oo;
        this.O0000Ooo = alu.O0000Ooo;
        this.O0000o00 = alu.O0000o00;
    }

    private alu(alu alu, String str) {
        super(alu, str);
        this.f12443O000000o = alu.f12443O000000o;
        this.O00000Oo = alu.O00000Oo;
        this.O0000Ooo = alu.O0000Ooo;
        this.O0000o00 = alu.O0000o00;
    }

    public final anm O00000Oo() {
        return this.O0000Ooo.O00000Oo();
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        O00000Oo(obj, this.O0000Ooo.O000000o(jsonParser, ajt));
    }

    public final Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O00000Oo(obj, O000000o(jsonParser, ajt));
    }

    public final void O000000o(Object obj, Object obj2) throws IOException {
        O00000Oo(obj, obj2);
    }

    public final Object O00000Oo(Object obj, Object obj2) throws IOException {
        Object O00000Oo2 = this.O0000Ooo.O00000Oo(obj, obj2);
        if (obj2 != null) {
            if (!this.O00000Oo) {
                this.O0000o00.O000000o(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        this.O0000o00.O000000o(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object next : (Collection) obj2) {
                    if (next != null) {
                        this.O0000o00.O000000o(next, obj);
                    }
                }
            } else if (obj2 instanceof Map) {
                for (Object next2 : ((Map) obj2).values()) {
                    if (next2 != null) {
                        this.O0000o00.O000000o(next2, obj);
                    }
                }
            } else {
                throw new IllegalStateException("Unsupported container type (" + obj2.getClass().getName() + ") when resolving reference '" + this.f12443O000000o + "'");
            }
        }
        return O00000Oo2;
    }

    public final /* synthetic */ alm O000000o(String str) {
        return new alu(this, str);
    }

    public final /* synthetic */ alm O00000Oo(ajw ajw) {
        return new alu(this, ajw);
    }
}

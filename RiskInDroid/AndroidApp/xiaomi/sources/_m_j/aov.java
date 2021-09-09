package _m_j;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.HashMap;

public abstract class aov extends aof {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final aog f12509O000000o;
    protected final ajv O00000Oo;
    protected final ajv O00000o;
    protected final ajr O00000o0;
    protected final String O00000oO;
    protected final boolean O00000oo;
    protected final HashMap<String, ajw<Object>> O0000O0o;
    protected ajw<Object> O0000OOo;

    protected aov(ajv ajv, aog aog, String str, boolean z, Class<?> cls) {
        this.O00000Oo = ajv;
        this.f12509O000000o = aog;
        this.O00000oO = str;
        this.O00000oo = z;
        this.O0000O0o = new HashMap<>();
        if (cls == null) {
            this.O00000o = null;
        } else {
            this.O00000o = ajv.O00000Oo(cls);
        }
        this.O00000o0 = null;
    }

    protected aov(aov aov, ajr ajr) {
        this.O00000Oo = aov.O00000Oo;
        this.f12509O000000o = aov.f12509O000000o;
        this.O00000oO = aov.O00000oO;
        this.O00000oo = aov.O00000oo;
        this.O0000O0o = aov.O0000O0o;
        this.O00000o = aov.O00000o;
        this.O0000OOo = aov.O0000OOo;
        this.O00000o0 = ajr;
    }

    public final String O00000o0() {
        return this.O00000Oo.O00000Oo().getName();
    }

    public final String O00000Oo() {
        return this.O00000oO;
    }

    public String toString() {
        return '[' + getClass().getName() + "; base-type:" + this.O00000Oo + "; id-resolver: " + this.f12509O000000o + ']';
    }

    /* access modifiers changed from: protected */
    public final ajw<Object> O000000o(ajt ajt, String str) throws IOException, JsonProcessingException {
        ajw<Object> ajw;
        ajw<Object> O000000o2;
        synchronized (this.O0000O0o) {
            ajw = this.O0000O0o.get(str);
            if (ajw == null) {
                ajv O000000o3 = this.f12509O000000o.O000000o(str);
                if (O000000o3 != null) {
                    if (this.O00000Oo != null && this.O00000Oo.getClass() == O000000o3.getClass()) {
                        O000000o3 = this.O00000Oo.O000000o(O000000o3.O00000Oo());
                    }
                    O000000o2 = ajt.O000000o(O000000o3, this.O00000o0);
                } else if (this.O00000o != null) {
                    O000000o2 = O000000o(ajt);
                } else {
                    throw ajt.O000000o(this.O00000Oo, str);
                }
                ajw = O000000o2;
                this.O0000O0o.put(str, ajw);
            }
        }
        return ajw;
    }

    /* access modifiers changed from: protected */
    public final ajw<Object> O000000o(ajt ajt) throws IOException, JsonProcessingException {
        ajw<Object> ajw;
        ajv ajv = this.O00000o;
        if (ajv == null) {
            return null;
        }
        synchronized (ajv) {
            if (this.O0000OOo == null) {
                this.O0000OOo = ajt.O000000o(this.O00000o, this.O00000o0);
            }
            ajw = this.O0000OOo;
        }
        return ajw;
    }
}

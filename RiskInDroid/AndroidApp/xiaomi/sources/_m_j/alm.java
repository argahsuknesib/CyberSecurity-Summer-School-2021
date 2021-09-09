package _m_j;

import _m_j.ati;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public abstract class alm implements ajr {
    protected final ajv O00000o;
    protected final String O00000o0;
    protected final ast O00000oO;
    protected ajw<Object> O00000oo;
    protected aof O0000O0o;
    protected alw O0000OOo;
    protected ati O0000Oo;
    protected String O0000Oo0;
    protected int O0000OoO;

    public abstract alm O000000o(String str);

    public abstract void O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException;

    public abstract void O000000o(Object obj, Object obj2) throws IOException;

    public abstract alm O00000Oo(ajw<?> ajw);

    public abstract anm O00000Oo();

    public abstract Object O00000Oo(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException;

    public abstract Object O00000Oo(Object obj, Object obj2) throws IOException;

    public Object O00000o0() {
        return null;
    }

    protected alm(anu anu, ajv ajv, aof aof, ast ast) {
        this(anu.O000000o(), ajv, aof, ast);
    }

    protected alm(String str, ajv ajv, aof aof, ast ast) {
        this.O0000OoO = -1;
        if (str == null || str.length() == 0) {
            this.O00000o0 = "";
        } else {
            this.O00000o0 = InternCache.f3599O000000o.O000000o(str);
        }
        this.O00000o = ajv;
        this.O00000oO = ast;
        this.O0000Oo = null;
        this.O0000O0o = aof != null ? aof.O000000o(this) : aof;
    }

    protected alm(alm alm) {
        this.O0000OoO = -1;
        this.O00000o0 = alm.O00000o0;
        this.O00000o = alm.O00000o;
        this.O00000oO = alm.O00000oO;
        this.O00000oo = alm.O00000oo;
        this.O0000O0o = alm.O0000O0o;
        this.O0000OOo = alm.O0000OOo;
        this.O0000Oo0 = alm.O0000Oo0;
        this.O0000OoO = alm.O0000OoO;
        this.O0000Oo = alm.O0000Oo;
    }

    protected alm(alm alm, ajw<?> ajw) {
        Object O000000o2;
        this.O0000OoO = -1;
        this.O00000o0 = alm.O00000o0;
        this.O00000o = alm.O00000o;
        this.O00000oO = alm.O00000oO;
        this.O0000O0o = alm.O0000O0o;
        this.O0000Oo0 = alm.O0000Oo0;
        this.O0000OoO = alm.O0000OoO;
        this.O00000oo = ajw;
        alw alw = null;
        if (!(ajw == null || (O000000o2 = ajw.O000000o()) == null)) {
            alw = new alw(this.O00000o, O000000o2);
        }
        this.O0000OOo = alw;
        this.O0000Oo = alm.O0000Oo;
    }

    protected alm(alm alm, String str) {
        this.O0000OoO = -1;
        this.O00000o0 = str;
        this.O00000o = alm.O00000o;
        this.O00000oO = alm.O00000oO;
        this.O00000oo = alm.O00000oo;
        this.O0000O0o = alm.O0000O0o;
        this.O0000OOo = alm.O0000OOo;
        this.O0000Oo0 = alm.O0000Oo0;
        this.O0000OoO = alm.O0000OoO;
        this.O0000Oo = alm.O0000Oo;
    }

    public final void O00000Oo(String str) {
        this.O0000Oo0 = str;
    }

    public final void O000000o(int i) {
        if (this.O0000OoO == -1) {
            this.O0000OoO = i;
            return;
        }
        throw new IllegalStateException("Property '" + this.O00000o0 + "' already had index (" + this.O0000OoO + "), trying to assign " + i);
    }

    public final String O00000o() {
        return this.O00000o0;
    }

    public final ajv O000000o() {
        return this.O00000o;
    }

    public final String O00000oO() {
        return this.O0000Oo0;
    }

    public final boolean O00000oo() {
        return this.O00000oo != null;
    }

    public final boolean O0000O0o() {
        return this.O0000O0o != null;
    }

    public final ajw<Object> O0000OOo() {
        return this.O00000oo;
    }

    public final aof O0000Oo0() {
        return this.O0000O0o;
    }

    public final boolean O000000o(Class<?> cls) {
        ati ati = this.O0000Oo;
        return ati == null || ati.O000000o(cls);
    }

    public final boolean O0000Oo() {
        return this.O0000Oo != null;
    }

    public final int O0000OoO() {
        return this.O0000OoO;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() == JsonToken.VALUE_NULL) {
            alw alw = this.O0000OOo;
            if (alw == null) {
                return null;
            }
            return alw.O000000o(ajt);
        }
        aof aof = this.O0000O0o;
        if (aof != null) {
            return this.O00000oo.O000000o(jsonParser, ajt, aof);
        }
        return this.O00000oo.O000000o(jsonParser, ajt);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Exception exc, Object obj) throws IOException {
        String str;
        if (exc instanceof IllegalArgumentException) {
            if (obj == null) {
                str = "[NULL]";
            } else {
                str = obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder("Problem deserializing property '");
            sb.append(this.O00000o0);
            sb.append("' (expected type: ");
            sb.append(this.O00000o);
            sb.append("; actual type: ");
            sb.append(str);
            sb.append(")");
            String message = exc.getMessage();
            if (message != null) {
                sb.append(", problem: ");
                sb.append(message);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new JsonMappingException(sb.toString(), null, exc);
        }
        O000000o(exc);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    protected static IOException O000000o(Exception exc) throws IOException {
        if (!(exc instanceof IOException)) {
            boolean z = exc instanceof RuntimeException;
            Throwable th = exc;
            if (!z) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                throw new JsonMappingException(th.getMessage(), null, th);
            }
            throw ((RuntimeException) exc);
        }
        throw ((IOException) exc);
    }

    public String toString() {
        return "[property '" + this.O00000o0 + "']";
    }

    public final void O000000o(Class<?>[] clsArr) {
        ati ati;
        ati o00000o0;
        if (clsArr == null) {
            ati = null;
        } else if (clsArr == null) {
            ati = ati.O000000o.f12591O000000o;
        } else {
            int length = clsArr.length;
            if (length != 0) {
                if (length != 1) {
                    o00000o0 = new ati.O00000Oo(clsArr);
                } else {
                    o00000o0 = new ati.O00000o0(clsArr[0]);
                }
                ati = o00000o0;
            } else {
                ati = ati.O000000o.f12591O000000o;
            }
        }
        this.O0000Oo = ati;
    }
}

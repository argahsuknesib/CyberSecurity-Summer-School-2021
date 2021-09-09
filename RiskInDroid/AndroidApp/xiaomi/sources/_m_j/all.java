package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Method;

public final class all {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajr f12433O000000o;
    protected final Method O00000Oo;
    protected ajw<Object> O00000o;
    protected final ajv O00000o0;

    public all(ajr ajr, ann ann, ajv ajv, ajw<Object> ajw) {
        this(ajr, ann.O00000oo(), ajv, ajw);
    }

    private all(ajr ajr, Method method, ajv ajv, ajw<Object> ajw) {
        this.f12433O000000o = ajr;
        this.O00000o0 = ajv;
        this.O00000Oo = method;
        this.O00000o = ajw;
    }

    public final all O000000o(ajw<Object> ajw) {
        return new all(this.f12433O000000o, this.O00000Oo, this.O00000o0, ajw);
    }

    public final ajr O000000o() {
        return this.f12433O000000o;
    }

    public final boolean O00000Oo() {
        return this.O00000o != null;
    }

    public final ajv O00000o0() {
        return this.O00000o0;
    }

    public final void O000000o(JsonParser jsonParser, ajt ajt, Object obj, String str) throws IOException, JsonProcessingException {
        O000000o(obj, str, O000000o(jsonParser, ajt));
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() == JsonToken.VALUE_NULL) {
            return null;
        }
        return this.O00000o.O000000o(jsonParser, ajt);
    }

    public final void O000000o(Object obj, String str, Object obj2) throws IOException {
        try {
            this.O00000Oo.invoke(obj, str, obj2);
        } catch (Exception e) {
            O000000o(e, str, obj2);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    private void O000000o(Exception exc, String str, Object obj) throws IOException {
        String str2;
        if (exc instanceof IllegalArgumentException) {
            if (obj == null) {
                str2 = "[NULL]";
            } else {
                str2 = obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder("Problem deserializing \"any\" property '");
            sb.append(str);
            sb.append("' of class " + O00000o() + " (expected type: ");
            sb.append(this.O00000o0);
            sb.append("; actual type: ");
            sb.append(str2);
            sb.append(")");
            String message = exc.getMessage();
            if (message != null) {
                sb.append(", problem: ");
                sb.append(message);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new JsonMappingException(sb.toString(), null, exc);
        } else if (!(exc instanceof IOException)) {
            boolean z = exc instanceof RuntimeException;
            Throwable th = exc;
            if (!z) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                throw new JsonMappingException(th.getMessage(), null, th);
            }
            throw ((RuntimeException) exc);
        } else {
            throw ((IOException) exc);
        }
    }

    private String O00000o() {
        return this.O00000Oo.getDeclaringClass().getName();
    }

    public final String toString() {
        return "[any property on class " + O00000o() + "]";
    }
}

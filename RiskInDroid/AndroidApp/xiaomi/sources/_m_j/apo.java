package _m_j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public final class apo extends app {
    static final apo O00000o0 = new apo("");
    final String O00000o;

    private apo(String str) {
        this.O00000o = str;
    }

    public static apo O000000o(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return O00000o0;
        }
        return new apo(str);
    }

    public final String O000000o() {
        return this.O00000o;
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        String str = this.O00000o;
        if (str == null) {
            jsonGenerator.O00000oo();
        } else {
            jsonGenerator.O00000Oo(str);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return ((apo) obj).O00000o.equals(this.O00000o);
        }
        return false;
    }

    public final int hashCode() {
        return this.O00000o.hashCode();
    }

    public final String toString() {
        int length = this.O00000o.length();
        StringBuilder sb = new StringBuilder(length + 2 + (length >> 4));
        O000000o(sb, this.O00000o);
        return sb.toString();
    }

    protected static void O000000o(StringBuilder sb, String str) {
        sb.append('\"');
        air.O000000o(sb, str);
        sb.append('\"');
    }
}

package _m_j;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

public final class aol extends aoj {
    public aol(ajv ajv, aog aog, String str, boolean z, Class<?> cls) {
        super(ajv, aog, str, z, cls);
    }

    private aol(aol aol, ajr ajr) {
        super(aol, ajr);
    }

    public final aof O000000o(ajr ajr) {
        if (ajr == this.O00000o0) {
            return this;
        }
        return new aol(this, ajr);
    }

    public final JsonTypeInfo.As O000000o() {
        return JsonTypeInfo.As.EXTERNAL_PROPERTY;
    }
}

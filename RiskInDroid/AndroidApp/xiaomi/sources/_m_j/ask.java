package _m_j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class ask {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Type f12570O000000o;
    protected final Class<?> O00000Oo;
    protected ask O00000o;
    protected final ParameterizedType O00000o0;
    protected ask O00000oO;

    public ask(Type type) {
        this.f12570O000000o = type;
        if (type instanceof Class) {
            this.O00000Oo = (Class) type;
            this.O00000o0 = null;
        } else if (type instanceof ParameterizedType) {
            this.O00000o0 = (ParameterizedType) type;
            this.O00000Oo = (Class) this.O00000o0.getRawType();
        } else {
            throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
        }
    }

    private ask(Type type, Class<?> cls, ParameterizedType parameterizedType, ask ask) {
        this.f12570O000000o = type;
        this.O00000Oo = cls;
        this.O00000o0 = parameterizedType;
        this.O00000o = ask;
        this.O00000oO = null;
    }

    public final ask O000000o() {
        ask ask = this.O00000o;
        ask O000000o2 = ask == null ? null : ask.O000000o();
        ask ask2 = new ask(this.f12570O000000o, this.O00000Oo, this.O00000o0, O000000o2);
        if (O000000o2 != null) {
            O000000o2.O00000oO = ask2;
        }
        return ask2;
    }

    public final void O000000o(ask ask) {
        this.O00000o = ask;
    }

    public final ask O00000Oo() {
        return this.O00000o;
    }

    public final void O00000Oo(ask ask) {
        this.O00000oO = ask;
    }

    public final boolean O00000o0() {
        return this.O00000o0 != null;
    }

    public final ParameterizedType O00000o() {
        return this.O00000o0;
    }

    public final Class<?> O00000oO() {
        return this.O00000Oo;
    }

    public final String toString() {
        ParameterizedType parameterizedType = this.O00000o0;
        if (parameterizedType != null) {
            return parameterizedType.toString();
        }
        return this.O00000Oo.getName();
    }
}

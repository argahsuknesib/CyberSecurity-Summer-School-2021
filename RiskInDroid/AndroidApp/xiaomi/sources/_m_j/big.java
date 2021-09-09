package _m_j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class big implements ParameterizedType {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Type[] f12993O000000o;
    private final Type O00000Oo;
    private final Type O00000o0;

    public big(Type[] typeArr, Type type, Type type2) {
        this.f12993O000000o = typeArr;
        this.O00000Oo = type;
        this.O00000o0 = type2;
    }

    public final Type[] getActualTypeArguments() {
        return this.f12993O000000o;
    }

    public final Type getOwnerType() {
        return this.O00000Oo;
    }

    public final Type getRawType() {
        return this.O00000o0;
    }
}

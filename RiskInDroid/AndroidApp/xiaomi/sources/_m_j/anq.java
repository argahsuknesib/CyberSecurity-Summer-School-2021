package _m_j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class anq extends anm {
    protected final anr[] O00000o;

    public abstract Object O000000o(Object obj) throws Exception;

    public abstract Object O000000o(Object[] objArr) throws Exception;

    public abstract Type O000000o(int i);

    public abstract Object O0000Oo0() throws Exception;

    protected anq(anr anr, anr[] anrArr) {
        super(anr);
        this.O00000o = anrArr;
    }

    public final void O000000o(int i, Annotation annotation) {
        anr anr = this.O00000o[i];
        if (anr == null) {
            anr = new anr();
            this.O00000o[i] = anr;
        }
        anr.O00000Oo(annotation);
    }

    /* access modifiers changed from: protected */
    public final anp O000000o(int i, anr anr) {
        this.O00000o[i] = anr;
        return O00000Oo(i);
    }

    /* access modifiers changed from: protected */
    public final ajv O000000o(asp asp, TypeVariable<?>[] typeVariableArr) {
        if (typeVariableArr != null && typeVariableArr.length > 0) {
            asp = asp.O000000o();
            for (TypeVariable<?> typeVariable : typeVariableArr) {
                asp.O00000Oo(typeVariable.getName());
                Type type = typeVariable.getBounds()[0];
                asp.O000000o(typeVariable.getName(), type == null ? asq.O00000Oo() : asp.O000000o(type));
            }
        }
        return asp.O000000o(O00000o0());
    }

    public final <A extends Annotation> A O000000o(Class cls) {
        return this.O00000Oo.O000000o(cls);
    }

    private anr O00000o0(int i) {
        anr[] anrArr = this.O00000o;
        if (anrArr == null || i < 0 || i > anrArr.length) {
            return null;
        }
        return anrArr[i];
    }

    public final anp O00000Oo(int i) {
        return new anp(this, O000000o(i), O00000o0(i), i);
    }
}

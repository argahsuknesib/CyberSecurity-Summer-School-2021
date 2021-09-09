package _m_j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public abstract class anm extends ani {
    protected final anr O00000Oo;

    public abstract void O000000o(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract Object O00000Oo(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract Class<?> O0000Oo();

    public abstract Member O0000OoO();

    protected anm(anr anr) {
        this.O00000Oo = anr;
    }

    /* access modifiers changed from: protected */
    public final anr O00000oO() {
        return this.O00000Oo;
    }

    public final void O000000o(Annotation annotation) {
        this.O00000Oo.O00000Oo(annotation);
    }

    public final void O00000Oo(Annotation annotation) {
        this.O00000Oo.O000000o(annotation);
    }
}

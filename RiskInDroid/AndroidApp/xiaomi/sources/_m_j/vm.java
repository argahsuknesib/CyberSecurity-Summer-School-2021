package _m_j;

import android.view.View;

public abstract class vm<T extends View, Z> implements vl {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final T f2549O000000o;

    public vm(T t) {
        if (t != null) {
            this.f2549O000000o = (View) t;
            return;
        }
        throw new NullPointerException("Argument must not be null");
    }
}

package _m_j;

import com.lidroid.xutils.task.Priority;

public final class brh<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public bri<?> f13217O000000o;
    public brh<T> O00000Oo;
    private boolean O00000o0 = false;

    public brh(T t) {
        O000000o(t);
    }

    public final T O000000o() {
        T t = this.f13217O000000o;
        if (t == null) {
            return null;
        }
        if (this.O00000o0) {
            return t;
        }
        return t.O00000Oo;
    }

    public final void O000000o(T t) {
        if (t == null) {
            this.f13217O000000o = null;
        } else if (t instanceof bri) {
            this.f13217O000000o = (bri) t;
            this.O00000o0 = true;
        } else {
            this.f13217O000000o = new bri<>(Priority.DEFAULT, t);
        }
    }
}

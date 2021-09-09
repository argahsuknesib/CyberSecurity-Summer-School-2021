package _m_j;

public abstract class gzc<T> extends fsm<T, fso> {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f18611O000000o = false;

    public abstract void O000000o(fso fso);

    public abstract void O000000o(T t);

    public final void onSuccess(T t) {
        if (!this.f18611O000000o) {
            this.f18611O000000o = true;
            O000000o((Object) t);
        }
    }

    public final void onFailure(fso fso) {
        if (!this.f18611O000000o) {
            this.f18611O000000o = true;
            O000000o(fso);
        }
    }
}

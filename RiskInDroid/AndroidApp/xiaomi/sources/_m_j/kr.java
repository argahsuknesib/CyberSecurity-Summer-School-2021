package _m_j;

public class kr<TResult> {
    public final kq<TResult> O00000Oo = new kq<>();

    private boolean O00000Oo(TResult tresult) {
        return this.O00000Oo.O00000Oo((Object) tresult);
    }

    private boolean O00000Oo(Exception exc) {
        return this.O00000Oo.O00000Oo(exc);
    }

    public final void O000000o(Object obj) {
        if (!O00000Oo(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final void O000000o(Exception exc) {
        if (!O00000Oo(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public final void O000000o() {
        if (!this.O00000Oo.O0000OOo()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }
}

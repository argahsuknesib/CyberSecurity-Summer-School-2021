package _m_j;

import androidx.lifecycle.Lifecycle;

public final class em implements fa {

    /* renamed from: O000000o  reason: collision with root package name */
    public fb f15620O000000o = null;

    public final void O000000o() {
        if (this.f15620O000000o == null) {
            this.f15620O000000o = new fb(this);
        }
    }

    public final Lifecycle getLifecycle() {
        O000000o();
        return this.f15620O000000o;
    }

    public final void O000000o(Lifecycle.Event event) {
        this.f15620O000000o.O000000o(event);
    }
}

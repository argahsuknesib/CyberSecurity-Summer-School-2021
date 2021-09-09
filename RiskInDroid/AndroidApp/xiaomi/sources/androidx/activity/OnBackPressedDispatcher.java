package androidx.activity;

import _m_j.O0Oo0;
import _m_j.O0Oo00;
import _m_j.ey;
import _m_j.fa;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: O000000o  reason: collision with root package name */
    final ArrayDeque<O0Oo0> f2630O000000o;
    private final Runnable O00000Oo;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f2630O000000o = new ArrayDeque<>();
        this.O00000Oo = runnable;
    }

    public final void O000000o(fa faVar, O0Oo0 o0Oo0) {
        Lifecycle lifecycle = faVar.getLifecycle();
        if (lifecycle.O000000o() != Lifecycle.State.DESTROYED) {
            o0Oo0.O000000o(new LifecycleOnBackPressedCancellable(lifecycle, o0Oo0));
        }
    }

    public final void O000000o() {
        Iterator<O0Oo0> descendingIterator = this.f2630O000000o.descendingIterator();
        while (descendingIterator.hasNext()) {
            O0Oo0 next = descendingIterator.next();
            if (next.f6677O000000o) {
                next.O00000Oo();
                return;
            }
        }
        Runnable runnable = this.O00000Oo;
        if (runnable != null) {
            runnable.run();
        }
    }

    class O000000o implements O0Oo00 {
        private final O0Oo0 O00000Oo;

        O000000o(O0Oo0 o0Oo0) {
            this.O00000Oo = o0Oo0;
        }

        public final void O000000o() {
            OnBackPressedDispatcher.this.f2630O000000o.remove(this.O00000Oo);
            this.O00000Oo.O00000Oo(this);
        }
    }

    class LifecycleOnBackPressedCancellable implements O0Oo00, ey {
        private final Lifecycle O00000Oo;
        private O0Oo00 O00000o;
        private final O0Oo0 O00000o0;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, O0Oo0 o0Oo0) {
            this.O00000Oo = lifecycle;
            this.O00000o0 = o0Oo0;
            lifecycle.O000000o(this);
        }

        public final void O000000o(fa faVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                O0Oo0 o0Oo0 = this.O00000o0;
                onBackPressedDispatcher.f2630O000000o.add(o0Oo0);
                O000000o o000000o = new O000000o(o0Oo0);
                o0Oo0.O000000o(o000000o);
                this.O00000o = o000000o;
            } else if (event == Lifecycle.Event.ON_STOP) {
                O0Oo00 o0Oo00 = this.O00000o;
                if (o0Oo00 != null) {
                    o0Oo00.O000000o();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                O000000o();
            }
        }

        public final void O000000o() {
            this.O00000Oo.O00000Oo(this);
            this.O00000o0.O00000Oo(this);
            O0Oo00 o0Oo00 = this.O00000o;
            if (o0Oo00 != null) {
                o0Oo00.O000000o();
                this.O00000o = null;
            }
        }
    }
}

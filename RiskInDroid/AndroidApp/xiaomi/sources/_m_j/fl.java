package _m_j;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public final class fl {

    /* renamed from: O000000o  reason: collision with root package name */
    public final fb f16558O000000o;
    private final Handler O00000Oo = new Handler();
    private O000000o O00000o0;

    public fl(fa faVar) {
        this.f16558O000000o = new fb(faVar);
    }

    public final void O000000o(Lifecycle.Event event) {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            o000000o.run();
        }
        this.O00000o0 = new O000000o(this.f16558O000000o, event);
        this.O00000Oo.postAtFrontOfQueue(this.O00000o0);
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final Lifecycle.Event f16559O000000o;
        private final fb O00000Oo;
        private boolean O00000o0 = false;

        O000000o(fb fbVar, Lifecycle.Event event) {
            this.O00000Oo = fbVar;
            this.f16559O000000o = event;
        }

        public final void run() {
            if (!this.O00000o0) {
                this.O00000Oo.O000000o(this.f16559O000000o);
                this.O00000o0 = true;
            }
        }
    }
}

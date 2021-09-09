package _m_j;

import android.util.Log;

final class jgb implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jgh f1812O000000o = new jgh();
    private final jgc O00000Oo;
    private volatile boolean O00000o0;

    jgb(jgc jgc) {
        this.O00000Oo = jgc;
    }

    public final void O000000o(jgm jgm, Object obj) {
        jgg O000000o2 = jgg.O000000o(jgm, obj);
        synchronized (this) {
            this.f1812O000000o.O000000o(O000000o2);
            if (!this.O00000o0) {
                this.O00000o0 = true;
                this.O00000Oo.O00000o0.execute(this);
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                jgg O00000Oo2 = this.f1812O000000o.O00000Oo();
                if (O00000Oo2 == null) {
                    synchronized (this) {
                        O00000Oo2 = this.f1812O000000o.O000000o();
                        if (O00000Oo2 == null) {
                            this.O00000o0 = false;
                            this.O00000o0 = false;
                            return;
                        }
                    }
                }
                this.O00000Oo.O000000o(O00000Oo2);
            } catch (InterruptedException e) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.O00000o0 = false;
                }
            }
        }
    }
}

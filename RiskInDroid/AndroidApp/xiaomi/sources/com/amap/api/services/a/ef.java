package com.amap.api.services.a;

public abstract class ef implements Runnable {
    a d;

    interface a {
        void a(ef efVar);

        void b(ef efVar);
    }

    public abstract void a();

    public final void run() {
        try {
            if (this.d != null) {
                this.d.a(this);
            }
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && this.d != null) {
                    this.d.b(this);
                }
            }
        } catch (Throwable th) {
            cl.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}

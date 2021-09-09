package com.xiaomi.onetrack.f;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f6141a;

    i(h hVar) {
        this.f6141a = hVar;
    }

    public void run() {
        if (this.f6141a.f6140a.c.get()) {
            this.f6141a.f6140a.a();
        }
        this.f6141a.f6140a.c.set(true);
    }
}

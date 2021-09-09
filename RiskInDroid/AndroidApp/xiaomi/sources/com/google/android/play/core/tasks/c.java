package com.google.android.play.core.tasks;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Task f3846a;
    final /* synthetic */ d b;

    c(d dVar, Task task) {
        this.b = dVar;
        this.f3846a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onFailure(this.f3846a.getException());
            }
        }
    }
}

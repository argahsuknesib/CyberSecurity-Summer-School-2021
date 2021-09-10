package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class f<ResultT> implements g<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3849a;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public final OnSuccessListener<? super ResultT> c;

    public f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f3849a = executor;
        this.c = onSuccessListener;
    }

    public final void a(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.f3849a.execute(new e(this, task));
                }
            }
        }
    }
}

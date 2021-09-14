package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class b<ResultT> implements g<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3845a;
    /* access modifiers changed from: private */
    public final Object b = new Object();
    /* access modifiers changed from: private */
    public final OnCompleteListener<ResultT> c;

    public b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f3845a = executor;
        this.c = onCompleteListener;
    }

    public final void a(Task<ResultT> task) {
        synchronized (this.b) {
            if (this.c != null) {
                this.f3845a.execute(new a(this, task));
            }
        }
    }
}

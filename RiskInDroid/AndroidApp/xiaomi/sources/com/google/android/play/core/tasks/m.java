package com.google.android.play.core.tasks;

import com.google.android.play.core.splitcompat.q;
import java.util.concurrent.Executor;

final class m<ResultT> extends Task<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3853a = new Object();
    private final h<ResultT> b = new h<>();
    private boolean c;
    private ResultT d;
    private Exception e;

    m() {
    }

    private final void a() {
        q.a(this.c, "Task is not yet complete");
    }

    private final void b() {
        q.a(!this.c, "Task is already complete");
    }

    private final void c() {
        synchronized (this.f3853a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }

    public final void a(Exception exc) {
        q.a(exc, "Exception must not be null");
        synchronized (this.f3853a) {
            b();
            this.c = true;
            this.e = exc;
        }
        this.b.a(this);
    }

    public final void a(Object obj) {
        synchronized (this.f3853a) {
            b();
            this.c = true;
            this.d = obj;
        }
        this.b.a(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a(new b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        c();
        return this;
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a(new b(executor, onCompleteListener));
        c();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.b.a(new d(executor, onFailureListener));
        c();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.b.a(new f(executor, onSuccessListener));
        c();
        return this;
    }

    public final boolean b(Exception exc) {
        q.a(exc, "Exception must not be null");
        synchronized (this.f3853a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean b(Object obj) {
        synchronized (this.f3853a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = obj;
            this.b.a(this);
            return true;
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f3853a) {
            exc = this.e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f3853a) {
            a();
            Exception exc = this.e;
            if (exc == null) {
                resultt = this.d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.f3853a) {
            a();
            if (!cls.isInstance(this.e)) {
                Exception exc = this.e;
                if (exc == null) {
                    resultt = this.d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.e));
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f3853a) {
            z = this.c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f3853a) {
            z = false;
            if (this.c && this.e == null) {
                z = true;
            }
        }
        return z;
    }
}

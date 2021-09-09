package com.lidroid.xutils.task;

import _m_j.brj;
import _m_j.brm;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PriorityAsyncTask<Params, Progress, Result> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O00000Oo f4512O000000o = new O00000Oo((byte) 0);
    public static final Executor O00000o0 = new PriorityExecutor();
    private final WorkerRunnable<Params, Result> O00000Oo = new WorkerRunnable<Params, Result>() {
        /* class com.lidroid.xutils.task.PriorityAsyncTask.AnonymousClass1 */

        public Result call() throws Exception {
            PriorityAsyncTask.this.O00000oO.set(true);
            Process.setThreadPriority(10);
            PriorityAsyncTask priorityAsyncTask = PriorityAsyncTask.this;
            return priorityAsyncTask.O00000o0(priorityAsyncTask.O000000o(this.mParams));
        }
    };
    protected final AtomicBoolean O00000o = new AtomicBoolean();
    public final AtomicBoolean O00000oO = new AtomicBoolean();
    public Priority O00000oo;
    private final FutureTask<Result> O0000O0o = new FutureTask<Result>(this.O00000Oo) {
        /* class com.lidroid.xutils.task.PriorityAsyncTask.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public void done() {
            try {
                PriorityAsyncTask.this.O00000Oo(get());
            } catch (InterruptedException e) {
                brm.O000000o(e.getMessage());
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                PriorityAsyncTask.this.O00000Oo((Object) null);
            }
        }
    };
    private volatile boolean O0000OOo = false;

    /* access modifiers changed from: protected */
    public abstract Result O000000o(Object... objArr);

    /* access modifiers changed from: protected */
    public void O000000o(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Progress... progressArr) {
    }

    public final void O00000Oo(Result result) {
        if (!this.O00000oO.get()) {
            O00000o0(result);
        }
    }

    public final Result O00000o0(Object obj) {
        f4512O000000o.obtainMessage(1, new O000000o(this, obj)).sendToTarget();
        return obj;
    }

    public final PriorityAsyncTask<Params, Progress, Result> O00000o0(Object... objArr) {
        return O000000o(O00000o0, objArr);
    }

    public final PriorityAsyncTask<Params, Progress, Result> O000000o(Executor executor, Params... paramsArr) {
        if (!this.O0000OOo) {
            this.O0000OOo = true;
            this.O00000Oo.mParams = paramsArr;
            executor.execute(new brj(this.O00000oo, this.O0000O0o));
            return this;
        }
        throw new IllegalStateException("Cannot execute task: the task is already executed.");
    }

    static class O00000Oo extends Handler {
        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        private O00000Oo() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            O000000o o000000o = (O000000o) message.obj;
            int i = message.what;
            if (i == 1) {
                o000000o.f4513O000000o.O00000o(o000000o.O00000Oo[0]);
            } else if (i == 2) {
                o000000o.f4513O000000o.O00000Oo((Object[]) o000000o.O00000Oo);
            }
        }
    }

    static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }

        /* synthetic */ WorkerRunnable(WorkerRunnable workerRunnable) {
            this();
        }
    }

    static class O000000o<Data> {

        /* renamed from: O000000o  reason: collision with root package name */
        final PriorityAsyncTask f4513O000000o;
        final Data[] O00000Oo;

        O000000o(PriorityAsyncTask priorityAsyncTask, Data... dataArr) {
            this.f4513O000000o = priorityAsyncTask;
            this.O00000Oo = dataArr;
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o(Object... objArr) {
        if (!this.O00000o.get()) {
            f4512O000000o.obtainMessage(2, new O000000o(this, objArr)).sendToTarget();
        }
    }

    public final void O00000o(Object obj) {
        if (!this.O00000o.get()) {
            O000000o(obj);
        }
    }
}

package _m_j;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public abstract class gqe extends AsyncTask<Void, Void, Void> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile Handler f18145O000000o;

    public abstract void O000000o();

    private static Handler O00000Oo() {
        if (f18145O000000o == null) {
            synchronized (gqe.class) {
                if (f18145O000000o == null) {
                    f18145O000000o = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f18145O000000o;
    }

    public static void O000000o(final FutureTask futureTask, final Executor executor) {
        if (executor != null) {
            O00000Oo().postDelayed(new Runnable() {
                /* class _m_j.gqe.AnonymousClass2 */

                public final void run() {
                    executor.execute(futureTask);
                }
            }, 500);
        }
    }

    public static void O000000o(gqe gqe, final Executor executor) {
        O00000Oo().post(new Runnable() {
            /* class _m_j.gqe.AnonymousClass1 */

            public final void run() {
                gqe gqe = gqe.this;
                Executor executor = executor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                gqe.executeOnExecutor(executor, new Void[0]);
            }
        });
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        O000000o();
        return null;
    }
}

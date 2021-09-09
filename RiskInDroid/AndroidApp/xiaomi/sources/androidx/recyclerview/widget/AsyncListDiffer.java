package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class AsyncListDiffer<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Executor f2929O000000o = new MainThreadExecutor();

    static class MainThreadExecutor implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }
}

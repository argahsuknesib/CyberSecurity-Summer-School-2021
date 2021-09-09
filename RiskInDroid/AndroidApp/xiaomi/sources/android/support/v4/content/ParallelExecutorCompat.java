package android.support.v4.content;

import android.os.Build;
import java.util.concurrent.Executor;

public final class ParallelExecutorCompat {
    public static Executor getParallelExecutor() {
        if (Build.VERSION.SDK_INT >= 11) {
            return ExecutorCompatHoneycomb.getParallelExecutor();
        }
        return ModernAsyncTask.THREAD_POOL_EXECUTOR;
    }

    private ParallelExecutorCompat() {
    }
}

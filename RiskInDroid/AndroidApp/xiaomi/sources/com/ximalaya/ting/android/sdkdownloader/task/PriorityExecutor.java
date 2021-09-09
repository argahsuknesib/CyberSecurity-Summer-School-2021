package com.ximalaya.ting.android.sdkdownloader.task;

import _m_j.imx;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityExecutor implements Executor {
    private static final Comparator<Runnable> FIFO_CMP = new Comparator<Runnable>() {
        /* class com.ximalaya.ting.android.sdkdownloader.task.PriorityExecutor.AnonymousClass2 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Runnable runnable = (Runnable) obj;
            Runnable runnable2 = (Runnable) obj2;
            if (!(runnable instanceof imx) || !(runnable2 instanceof imx)) {
                return 0;
            }
            imx imx = (imx) runnable;
            imx imx2 = (imx) runnable2;
            int ordinal = imx.O00000Oo.ordinal() - imx2.O00000Oo.ordinal();
            return ordinal == 0 ? (int) (imx.f1486O000000o - imx2.f1486O000000o) : ordinal;
        }
    };
    private static final Comparator<Runnable> FILO_CMP = new Comparator<Runnable>() {
        /* class com.ximalaya.ting.android.sdkdownloader.task.PriorityExecutor.AnonymousClass3 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Runnable runnable = (Runnable) obj;
            Runnable runnable2 = (Runnable) obj2;
            if (!(runnable instanceof imx) || !(runnable2 instanceof imx)) {
                return 0;
            }
            imx imx = (imx) runnable;
            imx imx2 = (imx) runnable2;
            int ordinal = imx.O00000Oo.ordinal() - imx2.O00000Oo.ordinal();
            return ordinal == 0 ? (int) (imx2.f1486O000000o - imx.f1486O000000o) : ordinal;
        }
    };
    private static final AtomicLong SEQ_SEED = new AtomicLong(Long.MAX_VALUE);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        /* class com.ximalaya.ting.android.sdkdownloader.task.PriorityExecutor.AnonymousClass1 */
        private final AtomicInteger mCount = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "xTID#" + this.mCount.getAndIncrement());
        }
    };
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public PriorityExecutor(boolean z) {
        this(3, z);
    }

    public PriorityExecutor(int i, boolean z) {
        this.mThreadPoolExecutor = new ThreadPoolExecutor(i, 500, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(50, z ? FIFO_CMP : FILO_CMP), sThreadFactory);
    }

    public int getPoolSize() {
        return this.mThreadPoolExecutor.getCorePoolSize();
    }

    public void setPoolSize(int i) {
        if (i > 0) {
            this.mThreadPoolExecutor.setCorePoolSize(i);
        }
    }

    public void clean() {
        ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
        }
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isBusy() {
        return this.mThreadPoolExecutor.getActiveCount() >= this.mThreadPoolExecutor.getCorePoolSize();
    }

    public void execute(Runnable runnable) {
        if (runnable instanceof imx) {
            ((imx) runnable).f1486O000000o = SEQ_SEED.getAndDecrement();
        }
        this.mThreadPoolExecutor.execute(runnable);
    }

    public boolean remove(Runnable runnable) {
        return this.mThreadPoolExecutor.remove(runnable);
    }
}

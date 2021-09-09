package com.xiaomi.mico.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadsImplementation {
    public final TracingThreadPool COMPUTATION_TRACING_THREAD_POOL = new TracingThreadPool(UtilsConfig.getIoThreadsCount(), TimeUnit.SECONDS.toMillis(2), this.THREAD_FACTORY_COMPUTATION, this.REJECTED_EXECUTION_HANDLER);
    private final AtomicReference<Handler> HEAVY_WORK_HANDLER = new AtomicReference<>(null);
    public final TracingThreadPool IO_TRACING_THREAD_POOL = new TracingThreadPool(UtilsConfig.getComputationThreadsCount(), TimeUnit.SECONDS.toMillis(10), this.THREAD_FACTORY_IO, this.REJECTED_EXECUTION_HANDLER);
    private final AtomicReference<Handler> LIGHT_WORK_HANDLER = new AtomicReference<>(null);
    private final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private final RejectedExecutionHandler REJECTED_EXECUTION_HANDLER = new RejectedExecutionHandler() {
        /* class com.xiaomi.mico.utils.ThreadsImplementation.AnonymousClass1 */

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            ThreadsImplementation.this.getLightWorkHandler().post(runnable);
        }
    };
    private final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = new ScheduledThreadPoolExecutor(1, new MyThreadFactory(), this.REJECTED_EXECUTION_HANDLER);
    private final MyThreadFactory THREAD_FACTORY_COMPUTATION = new MyThreadFactory(1);
    private final MyThreadFactory THREAD_FACTORY_IO = new MyThreadFactory(0);
    private final String THREAD_POOL_NAME_PREFIX = "mico-thread-pool";
    private final Object WORKHANDLER_LOCK = new Object();
    private final String WORK_HANDLER_THREAD_NAME = "mico_work_handler_thread";
    private Map<Object, TimeAndType> tracedTasks = Collections.synchronizedMap(new IdentityHashMap());

    static class TimeAndType {
        long enterTimeMillis;
        long maxDuration;

        TimeAndType() {
        }
    }

    ThreadsImplementation() {
        getScheduledExecutorService().scheduleWithFixedDelay(new Runnable() {
            /* class com.xiaomi.mico.utils.ThreadsImplementation.AnonymousClass2 */

            public void run() {
                ThreadsImplementation.this.checkTracedTasks();
            }
        }, 0, (Math.min(UtilsConfig.getHeavyWorkMaxDuration(), UtilsConfig.getLightWorkMaxDuration()) / 2) + 1, TimeUnit.MILLISECONDS);
    }

    public ExecutorService getIoThreadPool() {
        return this.IO_TRACING_THREAD_POOL;
    }

    public int getMaxThreadsOfIoThreadPool() {
        return UtilsConfig.getIoThreadsCount();
    }

    public ExecutorService getComputationThreadPool() {
        return this.COMPUTATION_TRACING_THREAD_POOL;
    }

    public int getMaxThreadsOfComputationThreadPool() {
        return UtilsConfig.getComputationThreadsCount();
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.SCHEDULED_EXECUTOR_SERVICE;
    }

    private Handler peekLightWorkHandler() {
        return this.LIGHT_WORK_HANDLER.get();
    }

    public Handler getLightWorkHandler() {
        return createWorkHandlerIfNeed(this.LIGHT_WORK_HANDLER, UtilsConfig.getLightWorkMaxDuration());
    }

    private Handler peekHeavyWorkHandler() {
        return this.HEAVY_WORK_HANDLER.get();
    }

    public Handler getHeavyWorkHandler() {
        return createWorkHandlerIfNeed(this.HEAVY_WORK_HANDLER, UtilsConfig.getHeavyWorkMaxDuration());
    }

    private Handler createWorkHandlerIfNeed(AtomicReference<Handler> atomicReference, final long j) {
        Handler handler = atomicReference.get();
        if (handler != null) {
            return handler;
        }
        synchronized (this.WORKHANDLER_LOCK) {
            Handler handler2 = atomicReference.get();
            if (handler2 != null) {
                return handler2;
            }
            HandlerThread handlerThread = new HandlerThread("mico_work_handler_thread", 10);
            handlerThread.start();
            AnonymousClass3 r2 = new Handler(handlerThread.getLooper()) {
                /* class com.xiaomi.mico.utils.ThreadsImplementation.AnonymousClass3 */

                public void dispatchMessage(Message message) {
                    Runnable callback = message.getCallback();
                    if (callback != null) {
                        ThreadsImplementation.this.addTraceTask(callback, j);
                    }
                    super.dispatchMessage(message);
                    if (callback != null) {
                        ThreadsImplementation.this.removeTraceTask(callback);
                    }
                }
            };
            atomicReference.set(r2);
            return r2;
        }
    }

    public void removeCallbacksInLightWorkThread(Runnable runnable) {
        Handler peekLightWorkHandler = peekLightWorkHandler();
        if (peekLightWorkHandler != null) {
            peekLightWorkHandler.removeCallbacks(runnable);
        }
    }

    public void removeCallbacksInHeavyWorkThread(Runnable runnable) {
        Handler peekHeavyWorkHandler = peekHeavyWorkHandler();
        if (peekHeavyWorkHandler != null) {
            peekHeavyWorkHandler.removeCallbacks(runnable);
        }
    }

    public void postInMainThread(Runnable runnable) {
        this.MAIN_HANDLER.post(runnable);
    }

    public void postDelayedInMainThread(Runnable runnable, long j) {
        this.MAIN_HANDLER.postDelayed(runnable, j);
    }

    public void removeCallbacksInMainThread(Runnable runnable) {
        this.MAIN_HANDLER.removeCallbacks(runnable);
    }

    public void verifyThread() {
        if (!isThread()) {
            if (!UtilsConfig.isCrashOnBugDetected()) {
                LogCallback logCallback = getLogCallback();
                if (logCallback != null) {
                    logCallback.e("Unexpectedly in main thread", new Object[0]);
                }
                DebugUtil.printStackTrace("BlockMainThreadError");
                return;
            }
            throw new IllegalStateException("Unexpectedly in main thread");
        }
    }

    public void verifyMainThread() {
        if (!isMainThread()) {
            if (!UtilsConfig.isCrashOnBugDetected()) {
                Thread currentThread = Thread.currentThread();
                LogCallback logCallback = getLogCallback();
                if (logCallback != null) {
                    logCallback.e("Not main thread %s %s", currentThread.getName(), Long.valueOf(currentThread.getId()));
                }
                DebugUtil.printStackTrace("NotMainThreadError");
                return;
            }
            throw new IllegalStateException("Non main thread");
        }
    }

    public boolean isThread() {
        return Looper.getMainLooper() != Looper.myLooper();
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public LogCallback getLogCallback() {
        return UtilsConfig.getLogCallback();
    }

    public void addTraceTask(Object obj, long j) {
        TimeAndType timeAndType = new TimeAndType();
        timeAndType.enterTimeMillis = time();
        timeAndType.maxDuration = j;
        this.tracedTasks.put(obj, timeAndType);
    }

    public void checkTracedTasks() {
        LogCallback logCallback = getLogCallback();
        Set<Map.Entry<Object, TimeAndType>> entrySet = this.tracedTasks.entrySet();
        this.tracedTasks.size();
        for (Map.Entry next : entrySet) {
            if (time() - ((TimeAndType) next.getValue()).enterTimeMillis >= ((TimeAndType) next.getValue()).maxDuration) {
                logCallback.w("Task %s running duration exceeds threshold %s", next.getKey(), Long.valueOf(((TimeAndType) next.getValue()).maxDuration));
            }
        }
    }

    public void removeTraceTask(Object obj) {
        this.tracedTasks.remove(obj);
    }

    public long time() {
        return SystemClock.uptimeMillis();
    }

    public static class SameThreadChecker {
        private final int IMPOSSIBLE_THREAD_ID = Integer.MIN_VALUE;
        private final String name;
        private volatile long threadId;

        public static SameThreadChecker get(String str) {
            return new SameThreadChecker(str);
        }

        private SameThreadChecker(String str) {
            this.name = str;
        }

        public void setupThread() {
            Thread currentThread = Thread.currentThread();
            this.threadId = currentThread.getId();
            UtilsConfig.getLogCallback().i("%s Initial thread %s %s", this.name, currentThread.getName(), Long.valueOf(currentThread.getId()));
        }

        public void check() {
            if (notSameThread()) {
                if (!UtilsConfig.isCrashOnBugDetected()) {
                    Thread currentThread = Thread.currentThread();
                    UtilsConfig.getLogCallback().e("Not same thread %s %s", currentThread.getName(), Long.valueOf(currentThread.getId()));
                    return;
                }
                throw new IllegalStateException("Not same thread");
            }
        }

        public boolean notSameThread() {
            long id = Thread.currentThread().getId();
            return (id == -2147483648L || id == this.threadId) ? false : true;
        }
    }

    class TracingThreadPool extends ThreadPoolExecutor {
        private long maxDurationForWarning;
        private Set<Object> tasks = new CopyOnWriteArraySet();
        private AtomicInteger tasksCount = new AtomicInteger(0);

        TracingThreadPool(int i, long j, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(1, i, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
            this.maxDurationForWarning = j;
        }

        public Future<?> submit(Runnable runnable) {
            return super.submit(wrapRunnable(runnable));
        }

        public <T> Future<T> submit(Runnable runnable, T t) {
            ThreadsImplementation.this.getLogCallback().i("submit task %s", runnable);
            return super.submit(wrapRunnable(runnable), t);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return super.submit(wrapCallable(callable));
        }

        public void execute(Runnable runnable) {
            super.execute(wrapRunnable(runnable));
        }

        public Runnable wrapRunnable(final Runnable runnable) {
            return new Runnable() {
                /* class com.xiaomi.mico.utils.ThreadsImplementation.TracingThreadPool.AnonymousClass1 */

                public void run() {
                    Process.setThreadPriority(UtilsConfig.getThreadPriority());
                    long addTask = TracingThreadPool.this.addTask(runnable);
                    runnable.run();
                    TracingThreadPool.this.removeTask(addTask, runnable);
                }

                public String toString() {
                    return runnable.toString();
                }
            };
        }

        private <T> Callable<T> wrapCallable(final Callable<T> callable) {
            return new Callable<T>() {
                /* class com.xiaomi.mico.utils.ThreadsImplementation.TracingThreadPool.AnonymousClass2 */

                public T call() throws Exception {
                    Process.setThreadPriority(UtilsConfig.getThreadPriority());
                    try {
                        long addTask = TracingThreadPool.this.addTask(callable);
                        T call = callable.call();
                        TracingThreadPool.this.removeTask(addTask, callable);
                        return call;
                    } catch (Exception e) {
                        ThreadsImplementation.this.getLogCallback().e("PossibleFC %s", e);
                        throw e;
                    } catch (Throwable th) {
                        TracingThreadPool.this.removeTask(0, callable);
                        throw th;
                    }
                }
            };
        }

        private void dumpTasks() {
            for (Object next : this.tasks) {
                ThreadsImplementation.this.getLogCallback().i("task %s", next);
            }
        }

        public long addTask(Object obj) {
            this.tasks.add(obj);
            this.tasksCount.incrementAndGet();
            ThreadsImplementation.this.addTraceTask(obj, this.maxDurationForWarning);
            return ThreadsImplementation.this.time();
        }

        public void removeTask(long j, Object obj) {
            this.tasks.remove(obj);
            ThreadsImplementation.this.removeTraceTask(obj);
            int decrementAndGet = this.tasksCount.decrementAndGet();
            int maximumPoolSize = getMaximumPoolSize();
            if (decrementAndGet >= maximumPoolSize - 1) {
                ThreadsImplementation.this.getLogCallback().e("heavy thread pool load, max thread pool size %s, pending tasks %s", Integer.valueOf(maximumPoolSize), Integer.valueOf(decrementAndGet));
                dumpTasks();
            }
            long time = ThreadsImplementation.this.time() - j;
            if (time > this.maxDurationForWarning) {
                ThreadsImplementation.this.getLogCallback().i("task %s run time costs %s millis", obj, Long.valueOf(time));
            }
        }
    }

    class MyThreadFactory implements ThreadFactory {
        private AtomicInteger counter;
        private final int type;

        MyThreadFactory(int i) {
            this.counter = new AtomicInteger(0);
            this.type = i;
        }

        MyThreadFactory() {
            this.counter = new AtomicInteger(0);
            this.type = 2;
        }

        public Thread newThread(Runnable runnable) {
            int i = this.type;
            if (i == 0 || i == 1) {
                runnable = (this.type == 0 ? ThreadsImplementation.this.IO_TRACING_THREAD_POOL : ThreadsImplementation.this.COMPUTATION_TRACING_THREAD_POOL).wrapRunnable(runnable);
            }
            Thread thread = new Thread(runnable, "mico-thread-pool" + this.counter.incrementAndGet());
            thread.setPriority(5);
            return thread;
        }
    }
}

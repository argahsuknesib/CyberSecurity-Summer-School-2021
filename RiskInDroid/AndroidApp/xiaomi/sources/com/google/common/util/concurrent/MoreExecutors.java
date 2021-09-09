package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible(emulated = true)
public final class MoreExecutors {
    private MoreExecutors() {
    }

    @GwtIncompatible
    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(threadPoolExecutor, j, timeUnit);
    }

    @GwtIncompatible
    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return new Application().getExitingExecutorService(threadPoolExecutor);
    }

    @GwtIncompatible
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, j, timeUnit);
    }

    @GwtIncompatible
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }

    @GwtIncompatible
    @Beta
    public static void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(executorService, j, timeUnit);
    }

    @GwtIncompatible
    @VisibleForTesting
    static class Application {
        Application() {
        }

        /* access modifiers changed from: package-private */
        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            addDelayedShutdownHook(threadPoolExecutor, j, timeUnit);
            return unconfigurableExecutorService;
        }

        /* access modifiers changed from: package-private */
        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
            return getExitingExecutorService(threadPoolExecutor, 120, TimeUnit.SECONDS);
        }

        /* access modifiers changed from: package-private */
        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(scheduledThreadPoolExecutor);
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            addDelayedShutdownHook(scheduledThreadPoolExecutor, j, timeUnit);
            return unconfigurableScheduledExecutorService;
        }

        /* access modifiers changed from: package-private */
        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120, TimeUnit.SECONDS);
        }

        /* access modifiers changed from: package-private */
        public final void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(executorService);
            Preconditions.checkNotNull(timeUnit);
            final ExecutorService executorService2 = executorService;
            final long j2 = j;
            final TimeUnit timeUnit2 = timeUnit;
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-".concat(String.valueOf(executorService)), new Runnable() {
                /* class com.google.common.util.concurrent.MoreExecutors.Application.AnonymousClass1 */

                public void run() {
                    try {
                        executorService2.shutdown();
                        executorService2.awaitTermination(j2, timeUnit2);
                    } catch (InterruptedException unused) {
                    }
                }
            }));
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void addShutdownHook(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }
    }

    @GwtIncompatible
    public static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @GwtIncompatible
    static final class DirectExecutorService extends AbstractListeningExecutorService {
        private final Object lock;
        @GuardedBy("lock")
        private int runningTasks;
        @GuardedBy("lock")
        private boolean shutdown;

        private DirectExecutorService() {
            this.lock = new Object();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        public final void execute(Runnable runnable) {
            startTask();
            try {
                runnable.run();
            } finally {
                endTask();
            }
        }

        public final boolean isShutdown() {
            boolean z;
            synchronized (this.lock) {
                z = this.shutdown;
            }
            return z;
        }

        public final void shutdown() {
            synchronized (this.lock) {
                this.shutdown = true;
                if (this.runningTasks == 0) {
                    this.lock.notifyAll();
                }
            }
        }

        public final List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public final boolean isTerminated() {
            boolean z;
            synchronized (this.lock) {
                z = this.shutdown && this.runningTasks == 0;
            }
            return z;
        }

        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j);
            synchronized (this.lock) {
                while (true) {
                    if (this.shutdown && this.runningTasks == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.lock, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                }
            }
        }

        private void startTask() {
            synchronized (this.lock) {
                if (!this.shutdown) {
                    this.runningTasks++;
                } else {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
            }
        }

        private void endTask() {
            synchronized (this.lock) {
                int i = this.runningTasks - 1;
                this.runningTasks = i;
                if (i == 0) {
                    this.lock.notifyAll();
                }
            }
        }
    }

    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService();
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible
    @Beta
    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new ScheduledListeningDecorator(scheduledExecutorService);
    }

    @GwtIncompatible
    static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        ListeningDecorator(ExecutorService executorService) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(executorService);
        }

        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j, timeUnit);
        }

        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        public final void shutdown() {
            this.delegate.shutdown();
        }

        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        public final void execute(Runnable runnable) {
            this.delegate.execute(runnable);
        }
    }

    @GwtIncompatible
    static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        public final ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
            return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
        }

        public final <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask<V> create = TrustedListenableFutureTask.create(callable);
            return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
        }

        public final ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        public final ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledFuture;
            }

            public final boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.scheduledDelegate.cancel(z);
                }
                return cancel;
            }

            public final long getDelay(TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }

            public final int compareTo(Delayed delayed) {
                return this.scheduledDelegate.compareTo(delayed);
            }
        }

        @GwtIncompatible
        static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) Preconditions.checkNotNull(runnable);
            }

            public final void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    throw Throwables.propagate(th);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A[SYNTHETIC] */
    @GwtIncompatible
    static <T> T invokeAnyImpl(ListeningExecutorService listeningExecutorService, Collection<? extends Callable<T>> collection, boolean z, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        long j2;
        long j3;
        ListeningExecutorService listeningExecutorService2 = listeningExecutorService;
        Preconditions.checkNotNull(listeningExecutorService);
        Preconditions.checkNotNull(timeUnit);
        int size = collection.size();
        Preconditions.checkArgument(size > 0);
        ArrayList<Future> newArrayListWithCapacity = Lists.newArrayListWithCapacity(size);
        LinkedBlockingQueue newLinkedBlockingQueue = Queues.newLinkedBlockingQueue();
        long nanos = timeUnit.toNanos(j);
        if (z) {
            try {
                j2 = System.nanoTime();
            } catch (ExecutionException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = new ExecutionException(e2);
            } catch (Throwable th) {
                for (Future cancel : newArrayListWithCapacity) {
                    cancel.cancel(true);
                }
                throw th;
            }
        } else {
            j2 = 0;
        }
        Iterator<? extends Callable<T>> it = collection.iterator();
        newArrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService2, (Callable) it.next(), newLinkedBlockingQueue));
        int i = size - 1;
        long j4 = j2;
        long j5 = nanos;
        ExecutionException executionException = null;
        int i2 = 1;
        while (true) {
            Future future = (Future) newLinkedBlockingQueue.poll();
            if (future == null) {
                if (i > 0) {
                    i--;
                    newArrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService2, (Callable) it.next(), newLinkedBlockingQueue));
                    i2++;
                } else if (i2 == 0) {
                    if (executionException == null) {
                        executionException = new ExecutionException((Throwable) null);
                    }
                    throw executionException;
                } else if (z) {
                    future = (Future) newLinkedBlockingQueue.poll(j5, TimeUnit.NANOSECONDS);
                    if (future != null) {
                        j3 = System.nanoTime();
                        j5 -= j3 - j4;
                        int i3 = i;
                        if (future == null) {
                            i2--;
                            T t = future.get();
                            for (Future cancel2 : newArrayListWithCapacity) {
                                cancel2.cancel(true);
                            }
                            return t;
                        }
                        i = i3;
                        j4 = j3;
                    } else {
                        throw new TimeoutException();
                    }
                } else {
                    future = (Future) newLinkedBlockingQueue.take();
                }
            }
            j3 = j4;
            int i32 = i;
            if (future == null) {
            }
            i = i32;
            j4 = j3;
        }
        executionException = e;
        i = i32;
        j4 = j3;
    }

    @GwtIncompatible
    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService listeningExecutorService, Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> submit = listeningExecutorService.submit((Callable) callable);
        submit.addListener(new Runnable() {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass1 */

            public final void run() {
                blockingQueue.add(submit);
            }
        }, directExecutor());
        return submit;
    }

    @GwtIncompatible
    @Beta
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (InvocationTargetException e2) {
            throw Throwables.propagate(e2.getCause());
        }
    }

    @GwtIncompatible
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    @GwtIncompatible
    static Thread newThread(String str, Runnable runnable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(runnable);
        Thread newThread = platformThreadFactory().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @GwtIncompatible
    static Executor renamingDecorator(final Executor executor, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executor;
        }
        return new Executor() {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass2 */

            public final void execute(Runnable runnable) {
                executor.execute(Callables.threadRenaming(runnable, supplier));
            }
        };
    }

    @GwtIncompatible
    static ExecutorService renamingDecorator(ExecutorService executorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executorService;
        }
        return new WrappingExecutorService(executorService) {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }

            /* access modifiers changed from: protected */
            public final Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
        };
    }

    @GwtIncompatible
    static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return scheduledExecutorService;
        }
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }

            /* access modifiers changed from: protected */
            public final Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
        };
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    static Executor rejectionPropagatingExecutor(final Executor executor, final AbstractFuture<?> abstractFuture) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(abstractFuture);
        if (executor == directExecutor()) {
            return executor;
        }
        return new Executor() {
            /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass5 */
            boolean thrownFromDelegate = true;

            public final void execute(final Runnable runnable) {
                try {
                    executor.execute(new Runnable() {
                        /* class com.google.common.util.concurrent.MoreExecutors.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            AnonymousClass5.this.thrownFromDelegate = false;
                            runnable.run();
                        }
                    });
                } catch (RejectedExecutionException e) {
                    if (this.thrownFromDelegate) {
                        abstractFuture.setException(e);
                    }
                }
            }
        };
    }
}

package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
final class ListenerCallQueue<L> {
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(Object obj);
    }

    ListenerCallQueue() {
    }

    public final void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(l, executor));
    }

    public final void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public final void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> add : this.listeners) {
                add.add(event, obj);
            }
        }
    }

    public final void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        @GuardedBy("this")
        boolean isThreadScheduled;
        @GuardedBy("this")
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        final L listener;
        @GuardedBy("this")
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor2) {
            this.listener = Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.lang.RuntimeException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* access modifiers changed from: package-private */
        public final void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger logger = ListenerCallQueue.logger;
                        Level level = Level.SEVERE;
                        logger.log(level, "Exception while running callbacks for " + ((Object) this.listener) + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.lang.RuntimeException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2.call(r8.listener);
         */
        public final void run() {
            Object poll;
            while (true) {
                boolean z = true;
                try {
                    synchronized (this) {
                        try {
                            Preconditions.checkState(this.isThreadScheduled);
                            Event poll2 = this.waitQueue.poll();
                            poll = this.labelQueue.poll();
                            if (poll2 == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (RuntimeException e) {
                    Logger logger = ListenerCallQueue.logger;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing callback: " + ((Object) this.listener) + " " + poll, (Throwable) e);
                } catch (Throwable th3) {
                    if (z) {
                        synchronized (this) {
                            this.isThreadScheduled = false;
                        }
                    }
                    throw th3;
                }
            }
        }
    }
}

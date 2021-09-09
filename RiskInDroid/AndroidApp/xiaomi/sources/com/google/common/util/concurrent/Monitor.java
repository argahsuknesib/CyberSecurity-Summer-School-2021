package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;

@GwtIncompatible
@Beta
public final class Monitor {
    @GuardedBy("lock")
    private Guard activeGuards;
    private final boolean fair;
    public final ReentrantLock lock;

    @Beta
    public static abstract class Guard {
        final Condition condition;
        @Weak
        final Monitor monitor;
        @GuardedBy("monitor.lock")
        Guard next;
        @GuardedBy("monitor.lock")
        int waiterCount = 0;

        public abstract boolean isSatisfied();

        protected Guard(Monitor monitor2) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor2, "monitor");
            this.condition = monitor2.lock.newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    public final Guard newGuard(final BooleanSupplier booleanSupplier) {
        Preconditions.checkNotNull(booleanSupplier, "isSatisfied");
        return new Guard(this) {
            /* class com.google.common.util.concurrent.Monitor.AnonymousClass1 */

            public boolean isSatisfied() {
                return booleanSupplier.getAsBoolean();
            }
        };
    }

    public final void enter() {
        this.lock.lock();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4 = remainingNanos(java.lang.System.nanoTime(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    public final boolean enter(long j, TimeUnit timeUnit) {
        boolean tryLock;
        long safeNanos = toSafeNanos(j, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long j2 = safeNanos;
            while (true) {
                tryLock = reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS);
                interrupted = true;
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (Throwable th) {
            th = th;
            if (interrupted) {
            }
            throw th;
        }
    }

    public final void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public final boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j, timeUnit);
    }

    public final boolean tryEnter() {
        return this.lock.tryLock();
    }

    public final void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.isSatisfied()) {
                    await(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (awaitNanos(r11, r0, r3) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[Catch:{ all -> 0x0051, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[DONT_GENERATE] */
    public final boolean enterWhen(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long j2;
        long safeNanos = toSafeNanos(j, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean z = false;
            if (!this.fair) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                } else if (reentrantLock.tryLock()) {
                    j2 = 0;
                    if (!guard.isSatisfied()) {
                        if (j2 != 0) {
                            safeNanos = remainingNanos(j2, safeNanos);
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    return z;
                }
            }
            j2 = initNanoTime(safeNanos);
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                if (!guard.isSatisfied()) {
                }
                z = true;
                if (!z) {
                }
                return z;
            } catch (Throwable th) {
                if (!isHeldByCurrentThread) {
                    signalNextWaiter();
                }
                throw th;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.isSatisfied()) {
                    awaitUninterruptibly(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r9 = remainingNanos(r7, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0071, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0076  */
    public final boolean enterWhenUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        long j2;
        long j3;
        long safeNanos = toSafeNanos(j, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean interrupted = Thread.interrupted();
            boolean z = true;
            try {
                if (!this.fair) {
                    if (reentrantLock.tryLock()) {
                        j2 = 0;
                        while (true) {
                            break;
                        }
                        if (guard.isSatisfied()) {
                            if (j2 == 0) {
                                long initNanoTime = initNanoTime(safeNanos);
                                j3 = safeNanos;
                            } else {
                                j3 = remainingNanos(j2, safeNanos);
                            }
                            z = awaitNanos(guard, j3, isHeldByCurrentThread);
                        }
                        if (!z) {
                            reentrantLock.unlock();
                        }
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return z;
                    }
                }
                j2 = initNanoTime(safeNanos);
                long j4 = safeNanos;
                while (true) {
                    interrupted = true;
                }
                if (!reentrantLock.tryLock(j4, TimeUnit.NANOSECONDS)) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                while (true) {
                    break;
                    break;
                }
                if (guard.isSatisfied()) {
                }
                if (!z) {
                }
                if (interrupted) {
                }
                return z;
            } catch (InterruptedException unused) {
                isHeldByCurrentThread = false;
                interrupted = true;
            } catch (Throwable th) {
                th = th;
                if (interrupted) {
                }
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final boolean enterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(j, timeUnit)) {
            return false;
        } else {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public final boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final boolean tryEnterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public final void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            await(guard, true);
        }
    }

    public final boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j, timeUnit);
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return awaitNanos(guard, safeNanos, true);
            }
            throw new InterruptedException();
        }
    }

    public final void waitForUninterruptibly(Guard guard) {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            awaitUninterruptibly(guard, true);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    public final boolean waitForUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        long safeNanos;
        long initNanoTime;
        long j2;
        boolean interrupted;
        boolean z;
        safeNanos = toSafeNanos(j, timeUnit);
        boolean z2 = true;
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            initNanoTime = initNanoTime(safeNanos);
            j2 = safeNanos;
            interrupted = Thread.interrupted();
            z = true;
            while (true) {
                try {
                    boolean awaitNanos = awaitNanos(guard, j2, z);
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return awaitNanos;
                } catch (InterruptedException ) {
                    try {
                        if (guard.isSatisfied()) {
                            Thread.currentThread().interrupt();
                            return true;
                        }
                        j2 = remainingNanos(initNanoTime, safeNanos);
                        z = false;
                        interrupted = true;
                    } catch (Throwable th) {
                        th = th;
                        if (z2) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = interrupted;
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
                z = false;
                interrupted = true;
            }
        }
    }

    public final void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFair() {
        return this.fair;
    }

    public final boolean isOccupied() {
        return this.lock.isLocked();
    }

    public final boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public final int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public final int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public final boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public final boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public final int getWaitQueueLength(Guard guard) {
        if (guard.monitor == this) {
            this.lock.lock();
            try {
                return guard.waiterCount;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    private static long toSafeNanos(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (nanos <= 0) {
            return 0;
        }
        if (nanos > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        return nanos;
    }

    private static long initNanoTime(long j) {
        if (j <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    private static long remainingNanos(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 - (System.nanoTime() - j);
    }

    @GuardedBy("lock")
    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    @GuardedBy("lock")
    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable th) {
            signalAllWaiters();
            throw th;
        }
    }

    @GuardedBy("lock")
    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    @GuardedBy("lock")
    private void beginWaitingFor(Guard guard) {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    @GuardedBy("lock")
    private void endWaitingFor(Guard guard) {
        int i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    @GuardedBy("lock")
    private void await(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private void awaitUninterruptibly(Guard guard, boolean z) {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    private boolean awaitNanos(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        signalNextWaiter();
                    } catch (Throwable th) {
                        if (!z2) {
                            endWaitingFor(guard);
                        }
                        throw th;
                    }
                }
                beginWaitingFor(guard);
                z2 = false;
            }
            j = guard.condition.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        if (!z2) {
            endWaitingFor(guard);
        }
        return false;
    }
}

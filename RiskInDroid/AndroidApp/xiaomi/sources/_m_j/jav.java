package _m_j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class jav extends jbo {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    static jav head;
    private boolean inQueue;
    private jav next;
    private long timeoutAt;

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void scheduleTimeout(jav jav, long j, boolean z) {
        synchronized (jav.class) {
            if (head == null) {
                head = new jav();
                new O000000o().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                jav.timeoutAt = Math.min(j, jav.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                jav.timeoutAt = j + nanoTime;
            } else if (z) {
                jav.timeoutAt = jav.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = jav.remainingNanos(nanoTime);
            jav jav2 = head;
            while (true) {
                if (jav2.next == null) {
                    break;
                } else if (remainingNanos < jav2.next.remainingNanos(nanoTime)) {
                    break;
                } else {
                    jav2 = jav2.next;
                }
            }
            jav.next = jav2.next;
            jav2.next = jav;
            if (jav2 == head) {
                jav.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(jav jav) {
        synchronized (jav.class) {
            for (jav jav2 = head; jav2 != null; jav2 = jav2.next) {
                if (jav2.next == jav) {
                    jav2.next = jav.next;
                    jav.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final jbm sink(final jbm jbm) {
        return new jbm() {
            /* class _m_j.jav.AnonymousClass1 */

            public final void write(jax jax, long j) throws IOException {
                jbp.O000000o(jax.O00000Oo, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        jbk jbk = jax.f1718O000000o;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += (long) (jbk.O00000o0 - jbk.O00000Oo);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            jbk = jbk.O00000oo;
                        }
                        jav.this.enter();
                        try {
                            jbm.write(jax, j2);
                            j -= j2;
                            jav.this.exit(true);
                        } catch (IOException e) {
                            throw jav.this.exit(e);
                        } catch (Throwable th) {
                            jav.this.exit(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public final void flush() throws IOException {
                jav.this.enter();
                try {
                    jbm.flush();
                    jav.this.exit(true);
                } catch (IOException e) {
                    throw jav.this.exit(e);
                } catch (Throwable th) {
                    jav.this.exit(false);
                    throw th;
                }
            }

            public final void close() throws IOException {
                jav.this.enter();
                try {
                    jbm.close();
                    jav.this.exit(true);
                } catch (IOException e) {
                    throw jav.this.exit(e);
                } catch (Throwable th) {
                    jav.this.exit(false);
                    throw th;
                }
            }

            public final jbo timeout() {
                return jav.this;
            }

            public final String toString() {
                return "AsyncTimeout.sink(" + jbm + ")";
            }
        };
    }

    public final jbn source(final jbn jbn) {
        return new jbn() {
            /* class _m_j.jav.AnonymousClass2 */

            public final long read(jax jax, long j) throws IOException {
                jav.this.enter();
                try {
                    long read = jbn.read(jax, j);
                    jav.this.exit(true);
                    return read;
                } catch (IOException e) {
                    throw jav.this.exit(e);
                } catch (Throwable th) {
                    jav.this.exit(false);
                    throw th;
                }
            }

            public final void close() throws IOException {
                try {
                    jbn.close();
                    jav.this.exit(true);
                } catch (IOException e) {
                    throw jav.this.exit(e);
                } catch (Throwable th) {
                    jav.this.exit(false);
                    throw th;
                }
            }

            public final jbo timeout() {
                return jav.this;
            }

            public final String toString() {
                return "AsyncTimeout.source(" + jbn + ")";
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static final class O000000o extends Thread {
        O000000o() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        public final void run() {
            while (true) {
                try {
                    synchronized (jav.class) {
                        jav awaitTimeout = jav.awaitTimeout();
                        if (awaitTimeout != null) {
                            if (awaitTimeout == jav.head) {
                                jav.head = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
            while (true) {
            }
        }
    }

    static jav awaitTimeout() throws InterruptedException {
        jav jav = head.next;
        if (jav == null) {
            long nanoTime = System.nanoTime();
            jav.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = jav.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            jav.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = jav.next;
        jav.next = null;
        return jav;
    }
}

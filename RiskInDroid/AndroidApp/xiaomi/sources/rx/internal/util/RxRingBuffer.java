package rx.internal.util;

import android.support.v4.app.NotificationCompat;
import java.io.PrintStream;
import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer implements Subscription {
    public static final int SIZE;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        int i = PlatformDependent.isAndroid() ? 16 : NotificationCompat.FLAG_HIGH_PRIORITY;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: rx.internal.util.RxRingBuffer.<init>(boolean, int):void
     arg types: [int, int]
     candidates:
      rx.internal.util.RxRingBuffer.<init>(java.util.Queue<java.lang.Object>, int):void
      rx.internal.util.RxRingBuffer.<init>(boolean, int):void */
    public static RxRingBuffer getSpscInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(false, SIZE);
        }
        return new RxRingBuffer();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: rx.internal.util.RxRingBuffer.<init>(boolean, int):void
     arg types: [int, int]
     candidates:
      rx.internal.util.RxRingBuffer.<init>(java.util.Queue<java.lang.Object>, int):void
      rx.internal.util.RxRingBuffer.<init>(boolean, int):void */
    public static RxRingBuffer getSpmcInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(true, SIZE);
        }
        return new RxRingBuffer();
    }

    private RxRingBuffer(Queue<Object> queue2, int i) {
        this.queue = queue2;
        this.size = i;
    }

    private RxRingBuffer(boolean z, int i) {
        this.queue = z ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
        this.size = i;
    }

    public synchronized void release() {
    }

    public void unsubscribe() {
        release();
    }

    RxRingBuffer() {
        this(new SpscAtomicArrayQueue(SIZE), SIZE);
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            z = true;
            if (queue2 != null) {
                z2 = !queue2.offer(NotificationLite.next(obj));
                z = false;
            } else {
                z2 = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.completed();
        }
    }

    public void onError(Throwable th) {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.error(th);
        }
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> queue2 = this.queue;
        if (queue2 == null) {
            return 0;
        }
        return queue2.size();
    }

    public boolean isEmpty() {
        Queue<Object> queue2 = this.queue;
        return queue2 == null || queue2.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return r2;
     */
    public Object poll() {
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            if (queue2 == null) {
                return null;
            }
            Object poll = queue2.poll();
            Object obj = this.terminalState;
            if (poll == null && obj != null && queue2.peek() == null) {
                this.terminalState = null;
                poll = obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return r1;
     */
    public Object peek() {
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            if (queue2 == null) {
                return null;
            }
            Object peek = queue2.peek();
            Object obj = this.terminalState;
            if (peek == null && obj != null && queue2.peek() == null) {
                peek = obj;
            }
        }
    }

    public boolean isCompleted(Object obj) {
        return NotificationLite.isCompleted(obj);
    }

    public boolean isError(Object obj) {
        return NotificationLite.isError(obj);
    }

    public Object getValue(Object obj) {
        return NotificationLite.getValue(obj);
    }

    public boolean accept(Object obj, Observer observer) {
        return NotificationLite.accept(observer, obj);
    }

    public Throwable asError(Object obj) {
        return NotificationLite.getError(obj);
    }

    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}

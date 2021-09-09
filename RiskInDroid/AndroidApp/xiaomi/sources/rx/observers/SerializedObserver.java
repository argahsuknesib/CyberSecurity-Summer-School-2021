package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;
    private FastList queue;
    private volatile boolean terminated;

    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public final void add(Object obj) {
            int i = this.size;
            Object[] objArr = this.array;
            if (objArr == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.array = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.size = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.actual = observer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6.actual.onNext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1 = r6.queue;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0031, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0037, code lost:
        r6.queue = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003b, code lost:
        r1 = r1.array;
        r3 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003e, code lost:
        if (r2 >= r3) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0040, code lost:
        r4 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0042, code lost:
        if (r4 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004a, code lost:
        if (rx.internal.operators.NotificationLite.accept(r6.actual, r4) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x004c, code lost:
        r6.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004f, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0053, code lost:
        r6.terminated = true;
        rx.exceptions.Exceptions.throwIfFatal(r1);
        r6.actual.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0065, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0066, code lost:
        r6.terminated = true;
        rx.exceptions.Exceptions.throwOrReport(r1, r6.actual, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006d, code lost:
        return;
     */
    public void onNext(T t) {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    if (this.emitting) {
                        FastList fastList = this.queue;
                        if (fastList == null) {
                            fastList = new FastList();
                            this.queue = fastList;
                        }
                        fastList.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                }
            }
        }
    }

    public void onError(Throwable th) {
        Exceptions.throwIfFatal(th);
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList fastList = this.queue;
                        if (fastList == null) {
                            fastList = new FastList();
                            this.queue = fastList;
                        }
                        fastList.add(NotificationLite.error(th));
                        return;
                    }
                    this.emitting = true;
                    this.actual.onError(th);
                }
            }
        }
    }

    public void onCompleted() {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList fastList = this.queue;
                        if (fastList == null) {
                            fastList = new FastList();
                            this.queue = fastList;
                        }
                        fastList.add(NotificationLite.completed());
                        return;
                    }
                    this.emitting = true;
                    this.actual.onCompleted();
                }
            }
        }
    }
}

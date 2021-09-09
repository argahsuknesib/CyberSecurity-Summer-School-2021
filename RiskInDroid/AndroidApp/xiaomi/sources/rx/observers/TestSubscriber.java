package rx.observers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;

public class TestSubscriber<T> extends Subscriber<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        /* class rx.observers.TestSubscriber.AnonymousClass1 */

        public final void onCompleted() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }
    };
    private int completions;
    private final Observer<T> delegate;
    private final List<Throwable> errors;
    private volatile Thread lastSeenThread;
    private final CountDownLatch latch;
    private volatile int valueCount;
    private final List<T> values;

    public TestSubscriber(long j) {
        this(INERT, j);
    }

    public TestSubscriber(Observer<T> observer, long j) {
        this.latch = new CountDownLatch(1);
        if (observer != null) {
            this.delegate = observer;
            if (j >= 0) {
                request(j);
            }
            this.values = new ArrayList();
            this.errors = new ArrayList();
            return;
        }
        throw new NullPointerException();
    }

    public TestSubscriber(Subscriber subscriber) {
        this(subscriber, -1);
    }

    public TestSubscriber(Observer observer) {
        this(observer, -1);
    }

    public TestSubscriber() {
        this(-1);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public static <T> TestSubscriber<T> create(long j) {
        return new TestSubscriber<>(j);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer, long j) {
        return new TestSubscriber<>(observer, j);
    }

    public static <T> TestSubscriber<T> create(Subscriber<T> subscriber) {
        return new TestSubscriber<>((Subscriber) subscriber);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer) {
        return new TestSubscriber<>(observer);
    }

    public void onCompleted() {
        try {
            this.completions++;
            this.lastSeenThread = Thread.currentThread();
            this.delegate.onCompleted();
        } finally {
            this.latch.countDown();
        }
    }

    @Deprecated
    public List<Notification<T>> getOnCompletedEvents() {
        int i = this.completions;
        ArrayList arrayList = new ArrayList(i != 0 ? i : 1);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Notification.createOnCompleted());
        }
        return arrayList;
    }

    public final int getCompletions() {
        return this.completions;
    }

    public void onError(Throwable th) {
        try {
            this.lastSeenThread = Thread.currentThread();
            this.errors.add(th);
            this.delegate.onError(th);
        } finally {
            this.latch.countDown();
        }
    }

    public List<Throwable> getOnErrorEvents() {
        return this.errors;
    }

    public void onNext(T t) {
        this.lastSeenThread = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.delegate.onNext(t);
    }

    public final int getValueCount() {
        return this.valueCount;
    }

    public void requestMore(long j) {
        request(j);
    }

    public List<T> getOnNextEvents() {
        return this.values;
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.values.size() != list.size()) {
            assertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.values.size() + ".\nProvided values: " + list + "\nActual values: " + this.values + "\n");
        }
        for (int i = 0; i < list.size(); i++) {
            assertItem(list.get(i), i);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private void assertItem(T r4, int r5) {
        /*
            r3 = this;
            java.util.List<T> r0 = r3.values
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r1 = "Value at index: "
            if (r4 != 0) goto L_0x0029
            if (r0 == 0) goto L_0x0076
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            r4.append(r5)
            java.lang.String r5 = " expected: [null] but was: ["
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = "]\n"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.assertionError(r4)
            return
        L_0x0029:
            boolean r2 = r4.equals(r0)
            if (r2 != 0) goto L_0x0076
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r5)
            java.lang.String r5 = " expected: ["
            r2.append(r5)
            r2.append(r4)
            java.lang.String r5 = "] ("
            r2.append(r5)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r2.append(r4)
            java.lang.String r4 = ") but was: ["
            r2.append(r4)
            r2.append(r0)
            r2.append(r5)
            if (r0 == 0) goto L_0x0065
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getSimpleName()
            goto L_0x0067
        L_0x0065:
            java.lang.String r4 = "null"
        L_0x0067:
            r2.append(r4)
            java.lang.String r4 = ")\n"
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r3.assertionError(r4)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.TestSubscriber.assertItem(java.lang.Object, int):void");
    }

    public final boolean awaitValueCount(int i, long j, TimeUnit timeUnit) {
        while (j != 0 && this.valueCount < i) {
            try {
                timeUnit.sleep(1);
                j--;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interrupted", e);
            }
        }
        return this.valueCount >= i;
    }

    public void assertTerminalEvent() {
        if (this.errors.size() > 1) {
            assertionError("Too many onError events: " + this.errors.size());
        }
        if (this.completions > 1) {
            assertionError("Too many onCompleted events: " + this.completions);
        }
        if (this.completions == 1 && this.errors.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.completions == 0 && this.errors.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    public void assertUnsubscribed() {
        if (!isUnsubscribed()) {
            assertionError("Not unsubscribed.");
        }
    }

    public void assertNoErrors() {
        if (!getOnErrorEvents().isEmpty()) {
            assertionError("Unexpected onError events");
        }
    }

    public void awaitTerminalEvent() {
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    public void awaitTerminalEvent(long j, TimeUnit timeUnit) {
        try {
            this.latch.await(j, timeUnit);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    public void awaitTerminalEventAndUnsubscribeOnTimeout(long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                unsubscribe();
            }
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    public Thread getLastSeenThread() {
        return this.lastSeenThread;
    }

    public void assertCompleted() {
        int i = this.completions;
        if (i == 0) {
            assertionError("Not completed!");
        } else if (i > 1) {
            assertionError("Completed multiple times: ".concat(String.valueOf(i)));
        }
    }

    public void assertNotCompleted() {
        int i = this.completions;
        if (i == 1) {
            assertionError("Completed!");
        } else if (i > 1) {
            assertionError("Completed multiple times: ".concat(String.valueOf(i)));
        }
    }

    public void assertError(Class<? extends Throwable> cls) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + list.size());
            assertionError.initCause(new CompositeException(list));
            throw assertionError;
        } else if (!cls.isInstance(list.get(0))) {
            AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + list.get(0));
            assertionError2.initCause(list.get(0));
            throw assertionError2;
        }
    }

    public void assertError(Throwable th) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            assertionError("Multiple errors");
        } else if (!th.equals(list.get(0))) {
            assertionError("Exceptions differ; expected: " + th + ", actual: " + list.get(0));
        }
    }

    public void assertNoTerminalEvent() {
        List<Throwable> list = this.errors;
        int i = this.completions;
        if (list.isEmpty() && i <= 0) {
            return;
        }
        if (list.isEmpty()) {
            assertionError("Found " + list.size() + " errors and " + i + " completion events instead of none");
        } else if (list.size() == 1) {
            assertionError("Found " + list.size() + " errors and " + i + " completion events instead of none");
        } else {
            assertionError("Found " + list.size() + " errors and " + i + " completion events instead of none");
        }
    }

    public void assertNoValues() {
        int size = this.values.size();
        if (size != 0) {
            assertionError("No onNext events expected yet some received: ".concat(String.valueOf(size)));
        }
    }

    public void assertValueCount(int i) {
        int size = this.values.size();
        if (size != i) {
            assertionError("Number of onNext events differ; expected: " + i + ", actual: " + size);
        }
    }

    public void assertValues(T... tArr) {
        assertReceivedOnNext(Arrays.asList(tArr));
    }

    public void assertValue(T t) {
        assertReceivedOnNext(Collections.singletonList(t));
    }

    /* access modifiers changed from: package-private */
    public final void assertionError(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int i = this.completions;
        sb.append(i);
        sb.append(" completion");
        if (i != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.errors.isEmpty()) {
            int size = this.errors.size();
            sb.append(" (+");
            sb.append(size);
            sb.append(" error");
            if (size != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        throw assertionError;
    }

    public final void assertValuesAndClear(T t, T... tArr) {
        assertValueCount(tArr.length + 1);
        assertItem(t, 0);
        int i = 0;
        while (i < tArr.length) {
            T t2 = tArr[i];
            i++;
            assertItem(t2, i);
        }
        this.values.clear();
        this.valueCount = 0;
    }
}

package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
import rx.exceptions.CompositeException;

@Deprecated
public class TestObserver<T> implements Observer<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        /* class rx.observers.TestObserver.AnonymousClass1 */

        public final void onCompleted() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }
    };
    private final Observer<T> delegate;
    private final List<Notification<T>> onCompletedEvents;
    private final List<Throwable> onErrorEvents;
    private final List<T> onNextEvents;

    public TestObserver(Observer<T> observer) {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = observer;
    }

    public TestObserver() {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = INERT;
    }

    public void onCompleted() {
        this.onCompletedEvents.add(Notification.createOnCompleted());
        this.delegate.onCompleted();
    }

    public List<Notification<T>> getOnCompletedEvents() {
        return Collections.unmodifiableList(this.onCompletedEvents);
    }

    public void onError(Throwable th) {
        this.onErrorEvents.add(th);
        this.delegate.onError(th);
    }

    public List<Throwable> getOnErrorEvents() {
        return Collections.unmodifiableList(this.onErrorEvents);
    }

    public void onNext(T t) {
        this.onNextEvents.add(t);
        this.delegate.onNext(t);
    }

    public List<T> getOnNextEvents() {
        return Collections.unmodifiableList(this.onNextEvents);
    }

    public List<Object> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.onNextEvents);
        arrayList.add(this.onErrorEvents);
        arrayList.add(this.onCompletedEvents);
        return Collections.unmodifiableList(arrayList);
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
    public void assertReceivedOnNext(java.util.List<T> r6) {
        /*
            r5 = this;
            java.util.List<T> r0 = r5.onNextEvents
            int r0 = r0.size()
            int r1 = r6.size()
            if (r0 == r1) goto L_0x0046
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Number of items does not match. Provided: "
            r0.<init>(r1)
            int r1 = r6.size()
            r0.append(r1)
            java.lang.String r1 = "  Actual: "
            r0.append(r1)
            java.util.List<T> r1 = r5.onNextEvents
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = ".\nProvided values: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = "\nActual values: "
            r0.append(r1)
            java.util.List<T> r1 = r5.onNextEvents
            r0.append(r1)
            java.lang.String r1 = "\n"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.assertionError(r0)
        L_0x0046:
            r0 = 0
        L_0x0047:
            int r1 = r6.size()
            if (r0 >= r1) goto L_0x00cb
            java.lang.Object r1 = r6.get(r0)
            java.util.List<T> r2 = r5.onNextEvents
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r3 = "Value at index: "
            if (r1 != 0) goto L_0x007a
            if (r2 == 0) goto L_0x00c7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r3 = " expected to be [null] but was: ["
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = "]\n"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.assertionError(r1)
            goto L_0x00c7
        L_0x007a:
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L_0x00c7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r0)
            java.lang.String r3 = " expected to be ["
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = "] ("
            r4.append(r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r4.append(r1)
            java.lang.String r1 = ") but was: ["
            r4.append(r1)
            r4.append(r2)
            r4.append(r3)
            if (r2 == 0) goto L_0x00b6
            java.lang.Class r1 = r2.getClass()
            java.lang.String r1 = r1.getSimpleName()
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r1 = "null"
        L_0x00b8:
            r4.append(r1)
            java.lang.String r1 = ")\n"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r5.assertionError(r1)
        L_0x00c7:
            int r0 = r0 + 1
            goto L_0x0047
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.TestObserver.assertReceivedOnNext(java.util.List):void");
    }

    public void assertTerminalEvent() {
        if (this.onErrorEvents.size() > 1) {
            assertionError("Too many onError events: " + this.onErrorEvents.size());
        }
        if (this.onCompletedEvents.size() > 1) {
            assertionError("Too many onCompleted events: " + this.onCompletedEvents.size());
        }
        if (this.onCompletedEvents.size() == 1 && this.onErrorEvents.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.onCompletedEvents.isEmpty() && this.onErrorEvents.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void assertionError(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int size = this.onCompletedEvents.size();
        sb.append(size);
        sb.append(" completion");
        if (size != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.onErrorEvents.isEmpty()) {
            int size2 = this.onErrorEvents.size();
            sb.append(" (+");
            sb.append(size2);
            sb.append(" error");
            if (size2 != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.onErrorEvents.isEmpty()) {
            if (this.onErrorEvents.size() == 1) {
                assertionError.initCause(this.onErrorEvents.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.onErrorEvents));
            }
        }
        throw assertionError;
    }
}

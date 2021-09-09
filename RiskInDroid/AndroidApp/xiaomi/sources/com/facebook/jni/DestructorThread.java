package com.facebook.jni;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

public class DestructorThread {
    public static DestructorList sDestructorList = new DestructorList();
    public static DestructorStack sDestructorStack = new DestructorStack();
    public static ReferenceQueue sReferenceQueue = new ReferenceQueue();
    private static Thread sThread;

    public static abstract class Destructor extends PhantomReference<Object> {
        public Destructor next;
        public Destructor previous;

        /* access modifiers changed from: protected */
        public abstract void destruct();

        public Destructor(Object obj) {
            super(obj, DestructorThread.sReferenceQueue);
            DestructorThread.sDestructorStack.push(this);
        }

        private Destructor() {
            super(null, DestructorThread.sReferenceQueue);
        }
    }

    static {
        AnonymousClass1 r0 = new Thread("HybridData DestructorThread") {
            /* class com.facebook.jni.DestructorThread.AnonymousClass1 */

            /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:3|5)(1:6)|4) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
            /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:4:0x0014, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
            public final void run() {
                while (true) {
                    Destructor destructor = (Destructor) DestructorThread.sReferenceQueue.remove();
                    destructor.destruct();
                    if (destructor.previous == null) {
                        DestructorThread.sDestructorStack.transferAllToList();
                    }
                    DestructorList.drop(destructor);
                }
            }
        };
        sThread = r0;
        r0.start();
    }

    static class Terminus extends Destructor {
        private Terminus() {
            super();
        }

        /* access modifiers changed from: protected */
        public void destruct() {
            throw new IllegalStateException("Cannot destroy Terminus Destructor.");
        }
    }

    static class DestructorStack {
        private AtomicReference<Destructor> mHead;

        private DestructorStack() {
            this.mHead = new AtomicReference<>();
        }

        public void push(Destructor destructor) {
            Destructor destructor2;
            do {
                destructor2 = this.mHead.get();
                destructor.next = destructor2;
            } while (!this.mHead.compareAndSet(destructor2, destructor));
        }

        public void transferAllToList() {
            Destructor andSet = this.mHead.getAndSet(null);
            while (andSet != null) {
                Destructor destructor = andSet.next;
                DestructorThread.sDestructorList.enqueue(andSet);
                andSet = destructor;
            }
        }
    }

    static class DestructorList {
        private Destructor mHead = new Terminus();

        public DestructorList() {
            this.mHead.next = new Terminus();
            this.mHead.next.previous = this.mHead;
        }

        public void enqueue(Destructor destructor) {
            destructor.next = this.mHead.next;
            this.mHead.next = destructor;
            destructor.next.previous = destructor;
            destructor.previous = this.mHead;
        }

        public static void drop(Destructor destructor) {
            destructor.next.previous = destructor.previous;
            destructor.previous.next = destructor.next;
        }
    }
}

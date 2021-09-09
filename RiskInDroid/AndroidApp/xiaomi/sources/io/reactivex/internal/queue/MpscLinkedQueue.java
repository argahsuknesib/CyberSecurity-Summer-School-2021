package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> consumerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> producerNode = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    public final boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
            xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public final T poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode lpConsumerNode = lpConsumerNode();
        LinkedQueueNode lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            spConsumerNode(lvNext2);
            return andNullValue;
        } else if (lpConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            spConsumerNode(lvNext);
            return andNullValue2;
        }
    }

    public final boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    /* access modifiers changed from: package-private */
    public final LinkedQueueNode<T> lvProducerNode() {
        return this.producerNode.get();
    }

    /* access modifiers changed from: package-private */
    public final LinkedQueueNode<T> xchgProducerNode(LinkedQueueNode<T> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public final LinkedQueueNode<T> lvConsumerNode() {
        return this.consumerNode.get();
    }

    /* access modifiers changed from: package-private */
    public final LinkedQueueNode<T> lpConsumerNode() {
        return this.consumerNode.get();
    }

    /* access modifiers changed from: package-private */
    public final void spConsumerNode(LinkedQueueNode<T> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }

        public final E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public final E lpValue() {
            return this.value;
        }

        public final void spValue(E e) {
            this.value = e;
        }

        public final void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public final LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }
    }
}

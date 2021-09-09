package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        spProducerNode(new LinkedQueueNode());
        spConsumerNode(this.producerNode);
        this.consumerNode.soNext(null);
    }

    public final boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e);
            this.producerNode.soNext(linkedQueueNode);
            this.producerNode = linkedQueueNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public final E poll() {
        LinkedQueueNode lvNext = this.consumerNode.lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        this.consumerNode = lvNext;
        return andNullValue;
    }

    public final E peek() {
        LinkedQueueNode lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }
}

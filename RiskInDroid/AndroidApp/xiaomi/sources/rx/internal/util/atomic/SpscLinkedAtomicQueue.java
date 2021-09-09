package rx.internal.util.atomic;

public final class SpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public SpscLinkedAtomicQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        spProducerNode(linkedQueueNode);
        spConsumerNode(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    public final boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e);
            lpProducerNode().soNext(linkedQueueNode);
            spProducerNode(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public final E poll() {
        LinkedQueueNode lvNext = lpConsumerNode().lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        spConsumerNode(lvNext);
        return andNullValue;
    }

    public final E peek() {
        LinkedQueueNode lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }
}

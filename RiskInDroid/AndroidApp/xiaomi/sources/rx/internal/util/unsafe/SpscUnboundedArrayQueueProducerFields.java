package rx.internal.util.unsafe;

import java.util.AbstractQueue;

abstract class SpscUnboundedArrayQueueProducerFields<E> extends AbstractQueue<E> {
    protected long producerIndex;

    SpscUnboundedArrayQueueProducerFields() {
    }
}

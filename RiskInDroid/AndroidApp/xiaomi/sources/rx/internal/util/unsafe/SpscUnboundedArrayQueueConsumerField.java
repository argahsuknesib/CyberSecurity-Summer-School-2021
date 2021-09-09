package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueConsumerField<E> extends SpscUnboundedArrayQueueConsumerColdField<E> {
    protected long consumerIndex;

    SpscUnboundedArrayQueueConsumerField() {
    }
}

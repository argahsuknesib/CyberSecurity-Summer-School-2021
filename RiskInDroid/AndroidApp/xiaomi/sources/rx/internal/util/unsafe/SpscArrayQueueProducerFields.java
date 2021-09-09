package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
abstract class SpscArrayQueueProducerFields<E> extends SpscArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueProducerFields.class, "producerIndex");
    protected long producerIndex;
    protected long producerLookAhead;

    public SpscArrayQueueProducerFields(int i) {
        super(i);
    }
}

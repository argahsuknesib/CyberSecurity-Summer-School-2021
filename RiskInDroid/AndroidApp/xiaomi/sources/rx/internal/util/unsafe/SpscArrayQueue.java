package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i) {
        super(i);
    }

    public final boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.buffer;
            long j = this.producerIndex;
            long calcElementOffset = calcElementOffset(j);
            if (lvElement(objArr, calcElementOffset) != null) {
                return false;
            }
            soElement(objArr, calcElementOffset, e);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public final E poll() {
        long j = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j);
        Object[] objArr = this.buffer;
        E lvElement = lvElement(objArr, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(objArr, calcElementOffset, null);
        soConsumerIndex(j + 1);
        return lvElement;
    }

    public final E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
    }

    public final int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    public final boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void soProducerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }

    private void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }
}

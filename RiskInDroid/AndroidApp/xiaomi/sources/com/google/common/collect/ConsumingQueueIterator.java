package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> queue;

    ConsumingQueueIterator(Object... objArr) {
        this.queue = new ArrayDeque(objArr.length);
        Collections.addAll(this.queue, objArr);
    }

    ConsumingQueueIterator(Queue queue2) {
        this.queue = (Queue) Preconditions.checkNotNull(queue2);
    }

    public T computeNext() {
        return this.queue.isEmpty() ? endOfData() : this.queue.remove();
    }
}

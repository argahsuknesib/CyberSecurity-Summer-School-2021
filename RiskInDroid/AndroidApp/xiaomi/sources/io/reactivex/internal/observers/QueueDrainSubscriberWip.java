package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}

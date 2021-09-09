package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}

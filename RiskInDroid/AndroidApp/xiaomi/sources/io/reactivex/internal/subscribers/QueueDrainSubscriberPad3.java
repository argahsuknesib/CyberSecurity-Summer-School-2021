package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}

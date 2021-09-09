package io.reactivex.internal.fuseable;

public interface QueueFuseable<T> extends SimpleQueue<T> {
    int requestFusion(int i);
}

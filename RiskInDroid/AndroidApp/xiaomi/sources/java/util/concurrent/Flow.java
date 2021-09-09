package java.util.concurrent;

import android.annotation.SuppressLint;

@SuppressLint({"NewApi"})
public final class Flow {

    public interface Processor<T, R> extends Publisher<R>, Subscriber<T> {
    }

    @FunctionalInterface
    public interface Publisher<T> {
        void subscribe(Subscriber<? super T> subscriber);
    }

    public interface Subscriber<T> {
        void onComplete();

        void onError(Throwable th);

        void onNext(Object obj);

        void onSubscribe(Subscription subscription);
    }

    public interface Subscription {
        void cancel();

        void request(long j);
    }

    private Flow() {
        throw new RuntimeException("Stub!");
    }

    public static int defaultBufferSize() {
        throw new RuntimeException("Stub!");
    }
}

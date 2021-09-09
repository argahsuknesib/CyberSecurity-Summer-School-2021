package rx;

public interface Observer<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(Object obj);
}

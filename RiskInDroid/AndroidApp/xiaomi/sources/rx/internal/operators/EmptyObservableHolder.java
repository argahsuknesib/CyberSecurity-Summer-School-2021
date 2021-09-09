package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class EmptyObservableHolder extends Enum<EmptyObservableHolder> implements Observable.OnSubscribe<Object> {
    private static final /* synthetic */ EmptyObservableHolder[] $VALUES;
    static final Observable<Object> EMPTY;
    public static final EmptyObservableHolder INSTANCE = new EmptyObservableHolder("INSTANCE", 0);

    private EmptyObservableHolder(String str, int i) {
    }

    public static EmptyObservableHolder valueOf(String str) {
        return (EmptyObservableHolder) Enum.valueOf(EmptyObservableHolder.class, str);
    }

    public static EmptyObservableHolder[] values() {
        return (EmptyObservableHolder[]) $VALUES.clone();
    }

    public final /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber<? super Object>) ((Subscriber) obj));
    }

    static {
        EmptyObservableHolder emptyObservableHolder = INSTANCE;
        $VALUES = new EmptyObservableHolder[]{emptyObservableHolder};
        EMPTY = Observable.unsafeCreate(emptyObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return EMPTY;
    }

    public final void call(Subscriber<? super Object> subscriber) {
        subscriber.onCompleted();
    }
}

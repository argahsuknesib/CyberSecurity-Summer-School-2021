package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class NeverObservableHolder extends Enum<NeverObservableHolder> implements Observable.OnSubscribe<Object> {
    private static final /* synthetic */ NeverObservableHolder[] $VALUES;
    public static final NeverObservableHolder INSTANCE = new NeverObservableHolder("INSTANCE", 0);
    static final Observable<Object> NEVER;

    public final void call(Subscriber<? super Object> subscriber) {
    }

    private NeverObservableHolder(String str, int i) {
    }

    public static NeverObservableHolder valueOf(String str) {
        return (NeverObservableHolder) Enum.valueOf(NeverObservableHolder.class, str);
    }

    public static NeverObservableHolder[] values() {
        return (NeverObservableHolder[]) $VALUES.clone();
    }

    public final /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber<? super Object>) ((Subscriber) obj));
    }

    static {
        NeverObservableHolder neverObservableHolder = INSTANCE;
        $VALUES = new NeverObservableHolder[]{neverObservableHolder};
        NEVER = Observable.unsafeCreate(neverObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return NEVER;
    }
}

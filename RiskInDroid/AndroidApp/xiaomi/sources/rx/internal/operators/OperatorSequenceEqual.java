package rx.internal.operators;

import rx.Observable;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual {
    static final Object LOCAL_ON_COMPLETED = new Object();

    private OperatorSequenceEqual() {
        throw new IllegalStateException("No instances!");
    }

    static <T> Observable<Object> materializeLite(Observable<T> observable) {
        return Observable.concat(observable, Observable.just(LOCAL_ON_COMPLETED));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2, final Func2<? super T, ? super T, Boolean> func2) {
        return Observable.zip(materializeLite(observable), materializeLite(observable2), new Func2<Object, Object, Boolean>() {
            /* class rx.internal.operators.OperatorSequenceEqual.AnonymousClass1 */

            public final Boolean call(Object obj, Object obj2) {
                boolean z = true;
                boolean z2 = obj == OperatorSequenceEqual.LOCAL_ON_COMPLETED;
                if (obj2 != OperatorSequenceEqual.LOCAL_ON_COMPLETED) {
                    z = false;
                }
                if (z2 && z) {
                    return Boolean.TRUE;
                }
                if (z2 || z) {
                    return Boolean.FALSE;
                }
                return (Boolean) func2.call(obj, obj2);
            }
        }).all(UtilityFunctions.identity());
    }
}

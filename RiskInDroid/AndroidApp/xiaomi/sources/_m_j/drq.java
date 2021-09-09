package _m_j;

import com.trello.rxlifecycle.OutsideLifecycleException;
import java.util.concurrent.CancellationException;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

final class drq {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Func1<Throwable, Boolean> f14880O000000o = new Func1<Throwable, Boolean>() {
        /* class _m_j.drq.AnonymousClass1 */

        public final /* synthetic */ Object call(Object obj) {
            Throwable th = (Throwable) obj;
            if (th instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            Exceptions.propagate(th);
            return Boolean.FALSE;
        }
    };
    static final Func1<Boolean, Boolean> O00000Oo = new Func1<Boolean, Boolean>() {
        /* class _m_j.drq.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return (Boolean) obj;
        }
    };
    static final Func1<Object, Observable<Object>> O00000o0 = new Func1<Object, Observable<Object>>() {
        /* class _m_j.drq.AnonymousClass3 */

        public final /* synthetic */ Object call(Object obj) {
            return Observable.error(new CancellationException());
        }
    };
}

package com.xiaomi.mico.common.realmrx;

import _m_j.irn;
import _m_j.irs;
import _m_j.iru;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public final class RealmObservable {
    public static <T extends irs> Observable<T> object(final Func1<irn, T> func1, boolean z) {
        return Observable.create(new OnSubscribeRealm<T>(z) {
            /* class com.xiaomi.mico.common.realmrx.RealmObservable.AnonymousClass1 */

            public final T get(irn irn) {
                return (irs) func1.call(irn);
            }
        });
    }

    public static <T extends irs> Observable<List<T>> list(final Func1<irn, List<T>> func1, boolean z) {
        return Observable.create(new OnSubscribeRealm<List<T>>(z) {
            /* class com.xiaomi.mico.common.realmrx.RealmObservable.AnonymousClass2 */

            public final List<T> get(irn irn) {
                return (List) func1.call(irn);
            }
        });
    }

    public static <T extends irs> Observable<iru<T>> results(final Func1<irn, iru<T>> func1, boolean z) {
        return Observable.create(new OnSubscribeRealm<iru<T>>(z) {
            /* class com.xiaomi.mico.common.realmrx.RealmObservable.AnonymousClass3 */

            public final iru<T> get(irn irn) {
                return (iru) func1.call(irn);
            }
        });
    }
}

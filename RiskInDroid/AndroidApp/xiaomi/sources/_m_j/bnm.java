package _m_j;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

public final class bnm implements Observable.OnSubscribe<Void> {

    /* renamed from: O000000o  reason: collision with root package name */
    final View f13139O000000o;
    final Func0<Boolean> O00000Oo;

    public final /* synthetic */ void call(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        bni.O000000o();
        this.f13139O000000o.setOnLongClickListener(new View.OnLongClickListener() {
            /* class _m_j.bnm.AnonymousClass1 */

            public final boolean onLongClick(View view) {
                if (!bnm.this.O00000Oo.call().booleanValue()) {
                    return false;
                }
                if (subscriber.isUnsubscribed()) {
                    return true;
                }
                subscriber.onNext(null);
                return true;
            }
        });
        subscriber.add(new MainThreadSubscription() {
            /* class _m_j.bnm.AnonymousClass2 */

            public final void onUnsubscribe() {
                bnm.this.f13139O000000o.setOnLongClickListener(null);
            }
        });
    }

    public bnm(View view, Func0<Boolean> func0) {
        this.f13139O000000o = view;
        this.O00000Oo = func0;
    }
}

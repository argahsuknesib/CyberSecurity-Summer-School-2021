package _m_j;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

final class bnk implements Observable.OnSubscribe<Void> {

    /* renamed from: O000000o  reason: collision with root package name */
    final View f13135O000000o;

    public final /* synthetic */ void call(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        bni.O000000o();
        this.f13135O000000o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.bnk.AnonymousClass1 */

            public final void onClick(View view) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(null);
                }
            }
        });
        subscriber.add(new MainThreadSubscription() {
            /* class _m_j.bnk.AnonymousClass2 */

            public final void onUnsubscribe() {
                bnk.this.f13135O000000o.setOnClickListener(null);
            }
        });
    }

    bnk(View view) {
        this.f13135O000000o = view;
    }
}

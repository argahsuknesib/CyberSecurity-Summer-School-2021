package _m_j;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

public final class bno implements Observable.OnSubscribe<bnn> {

    /* renamed from: O000000o  reason: collision with root package name */
    final TextView f13142O000000o;

    public final /* synthetic */ void call(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        bni.O000000o();
        final AnonymousClass1 r0 = new TextWatcher() {
            /* class _m_j.bno.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(bnn.O000000o(bno.this.f13142O000000o, editable));
                }
            }
        };
        this.f13142O000000o.addTextChangedListener(r0);
        subscriber.add(new MainThreadSubscription() {
            /* class _m_j.bno.AnonymousClass2 */

            public final void onUnsubscribe() {
                bno.this.f13142O000000o.removeTextChangedListener(r0);
            }
        });
        TextView textView = this.f13142O000000o;
        subscriber.onNext(bnn.O000000o(textView, textView.getEditableText()));
    }

    public bno(TextView textView) {
        this.f13142O000000o = textView;
    }
}

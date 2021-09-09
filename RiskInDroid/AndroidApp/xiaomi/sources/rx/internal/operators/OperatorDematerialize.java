package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

public final class OperatorDematerialize<T> implements Observable.Operator<T, Notification<T>> {

    static final class Holder {
        static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize<>();

        Holder() {
        }
    }

    public static OperatorDematerialize instance() {
        return Holder.INSTANCE;
    }

    OperatorDematerialize() {
    }

    public final Subscriber<? super Notification<T>> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<Notification<T>>(subscriber) {
            /* class rx.internal.operators.OperatorDematerialize.AnonymousClass1 */
            boolean terminated;

            public void onNext(Notification<T> notification) {
                int i = AnonymousClass2.$SwitchMap$rx$Notification$Kind[notification.getKind().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        onError(notification.getThrowable());
                    } else if (i != 3) {
                        onError(new IllegalArgumentException("Unsupported notification type: ".concat(String.valueOf(notification))));
                    } else {
                        onCompleted();
                    }
                } else if (!this.terminated) {
                    subscriber.onNext(notification.getValue());
                }
            }

            public void onError(Throwable th) {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onError(th);
                }
            }

            public void onCompleted() {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onCompleted();
                }
            }
        };
    }

    /* renamed from: rx.internal.operators.OperatorDematerialize$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$rx$Notification$Kind = new int[Notification.Kind.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$rx$Notification$Kind[Notification.Kind.OnNext.ordinal()] = 1;
            $SwitchMap$rx$Notification$Kind[Notification.Kind.OnError.ordinal()] = 2;
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}

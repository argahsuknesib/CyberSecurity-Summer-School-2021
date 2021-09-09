package _m_j;

import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class csi implements Observable.OnSubscribe {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f14302O000000o;

    private csi(Object obj) {
        this.f14302O000000o = obj;
    }

    public static Observable.OnSubscribe O000000o(Object obj) {
        return new csi(obj);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        ((Subscriber) obj).onNext(this.f14302O000000o);
    }
}

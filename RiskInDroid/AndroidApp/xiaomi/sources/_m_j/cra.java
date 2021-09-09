package _m_j;

import _m_j.cqv;
import java.lang.invoke.LambdaForm;
import rx.functions.Action0;

public final /* synthetic */ class cra implements Action0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cqx f14269O000000o;

    private cra(cqx cqx) {
        this.f14269O000000o = cqx;
    }

    public static Action0 O000000o(cqx cqx) {
        return new cra(cqx);
    }

    @LambdaForm.Hidden
    public final void call() {
        cqx cqx = this.f14269O000000o;
        cqx.O00000o0.onNext(cqv.O00000Oo.O00000o0);
        cqx.O00000o.set(false);
    }
}

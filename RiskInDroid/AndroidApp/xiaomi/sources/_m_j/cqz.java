package _m_j;

import _m_j.cqv;
import java.lang.invoke.LambdaForm;
import rx.functions.Action1;

public final /* synthetic */ class cqz implements Action1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cqx f14265O000000o;

    private cqz(cqx cqx) {
        this.f14265O000000o = cqx;
    }

    public static Action1 O000000o(cqx cqx) {
        return new cqz(cqx);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        this.f14265O000000o.O00000o0.onNext(cqv.O00000Oo.O00000Oo);
    }
}

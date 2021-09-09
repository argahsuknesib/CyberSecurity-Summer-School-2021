package _m_j;

import java.lang.invoke.LambdaForm;
import rx.functions.Action0;
import rx.subjects.BehaviorSubject;

final /* synthetic */ class crv implements Action0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final BehaviorSubject f14289O000000o;

    private crv(BehaviorSubject behaviorSubject) {
        this.f14289O000000o = behaviorSubject;
    }

    public static Action0 O000000o(BehaviorSubject behaviorSubject) {
        return new crv(behaviorSubject);
    }

    @LambdaForm.Hidden
    public final void call() {
        this.f14289O000000o.onCompleted();
    }
}

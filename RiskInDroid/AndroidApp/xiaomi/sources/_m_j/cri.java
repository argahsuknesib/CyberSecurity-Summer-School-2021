package _m_j;

import _m_j.crj;
import java.lang.invoke.LambdaForm;
import rx.functions.Action0;

public final /* synthetic */ class cri implements Action0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cre f14277O000000o;
    private final crj.O000000o O00000Oo;

    private cri(cre cre, crj.O000000o o000000o) {
        this.f14277O000000o = cre;
        this.O00000Oo = o000000o;
    }

    public static Action0 O000000o(cre cre, crj.O000000o o000000o) {
        return new cri(cre, o000000o);
    }

    @LambdaForm.Hidden
    public final void call() {
        this.f14277O000000o.O00000o0.O000000o().subscribe(crf.O000000o(), crg.O000000o());
    }
}

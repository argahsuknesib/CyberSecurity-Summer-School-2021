package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class crh implements Func1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cre f14276O000000o;
    private final crn O00000Oo;

    private crh(cre cre, crn crn) {
        this.f14276O000000o = cre;
        this.O00000Oo = crn;
    }

    public static Func1 O000000o(cre cre, crn crn) {
        return new crh(cre, crn);
    }

    @LambdaForm.Hidden
    public final Object call(Object obj) {
        return Observable.create(csi.O000000o(new crm(this.f14276O000000o.O00000o0, this.O00000Oo, (BluetoothGatt) obj))).cast(cqv.class);
    }
}

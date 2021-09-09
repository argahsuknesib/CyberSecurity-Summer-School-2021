package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.functions.Action1;

final /* synthetic */ class crw implements Action1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cro f14290O000000o;

    private crw(cro cro) {
        this.f14290O000000o = cro;
    }

    public static Action1 O000000o(cro cro) {
        return new crw(cro);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        this.f14290O000000o.O00000o0.onNext((BluetoothGatt) obj);
    }
}

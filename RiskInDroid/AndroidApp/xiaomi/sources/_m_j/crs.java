package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.functions.Action1;

final /* synthetic */ class crs implements Action1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cro f14286O000000o;
    private final Runnable O00000Oo;

    private crs(cro cro, Runnable runnable) {
        this.f14286O000000o = cro;
        this.O00000Oo = runnable;
    }

    public static Action1 O000000o(cro cro, Runnable runnable) {
        return new crs(cro, runnable);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        this.f14286O000000o.O000000o(this.O00000Oo, (BluetoothGatt) obj);
    }
}

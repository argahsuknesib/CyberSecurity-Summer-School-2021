package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.functions.Action1;

final /* synthetic */ class cse implements Action1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final cse f14298O000000o = new cse();

    private cse() {
    }

    public static Action1 O000000o() {
        return f14298O000000o;
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        ((BluetoothGatt) obj).close();
    }
}

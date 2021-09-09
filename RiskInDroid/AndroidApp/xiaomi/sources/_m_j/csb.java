package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.functions.Func1;

final /* synthetic */ class csb implements Func1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final BluetoothGatt f14295O000000o;

    private csb(BluetoothGatt bluetoothGatt) {
        this.f14295O000000o = bluetoothGatt;
    }

    public static Func1 O000000o(BluetoothGatt bluetoothGatt) {
        return new csb(bluetoothGatt);
    }

    @LambdaForm.Hidden
    public final Object call(Object obj) {
        return cry.O000000o(this.f14295O000000o);
    }
}

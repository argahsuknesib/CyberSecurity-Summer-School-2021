package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.functions.Func1;

final /* synthetic */ class csc implements Func1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cry f14296O000000o;

    private csc(cry cry) {
        this.f14296O000000o = cry;
    }

    public static Func1 O000000o(cry cry) {
        return new csc(cry);
    }

    @LambdaForm.Hidden
    public final Object call(Object obj) {
        cry cry = this.f14296O000000o;
        BluetoothGatt bluetoothGatt = (BluetoothGatt) obj;
        if (cry.O00000o.getConnectionState(bluetoothGatt.getDevice(), 7) == 0) {
            return Observable.just(bluetoothGatt);
        }
        return Observable.create(csh.O000000o(cry, bluetoothGatt));
    }
}

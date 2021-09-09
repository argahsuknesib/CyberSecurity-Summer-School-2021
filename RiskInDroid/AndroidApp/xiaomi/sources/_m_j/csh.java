package _m_j;

import _m_j.cqv;
import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

final /* synthetic */ class csh implements Observable.OnSubscribe {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cry f14301O000000o;
    private final BluetoothGatt O00000Oo;

    private csh(cry cry, BluetoothGatt bluetoothGatt) {
        this.f14301O000000o = cry;
        this.O00000Oo = bluetoothGatt;
    }

    public static Observable.OnSubscribe O000000o(cry cry, BluetoothGatt bluetoothGatt) {
        return new csh(cry, bluetoothGatt);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        cry cry = this.f14301O000000o;
        BluetoothGatt bluetoothGatt = this.O00000Oo;
        cry.O00000o0.O000000o().timeout(10, TimeUnit.SECONDS, Observable.just(cqv.O00000Oo.O00000o0)).filter(csa.O000000o()).take(1).map(csb.O000000o(bluetoothGatt)).subscribe((Subscriber) obj);
        bluetoothGatt.disconnect();
    }
}

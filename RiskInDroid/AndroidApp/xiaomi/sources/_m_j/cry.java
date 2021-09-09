package _m_j;

import _m_j.cqv;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public final class cry extends crd<Void> {
    final BluetoothManager O00000o;
    final crn O00000o0;
    private final AtomicReference<BluetoothGatt> O00000oO;

    public static /* synthetic */ BluetoothGatt O000000o(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt;
    }

    public cry(crn crn, AtomicReference<BluetoothGatt> atomicReference, BluetoothManager bluetoothManager) {
        this.O00000o0 = crn;
        this.O00000oO = atomicReference;
        this.O00000o = bluetoothManager;
    }

    public final void run() {
        Observable.just(this.O00000oO.get()).filter(crz.O000000o()).flatMap(csc.O000000o(this)).doOnTerminate(csd.O000000o(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(cse.O000000o(), csf.O000000o(this), csg.O000000o(this));
    }

    public static /* synthetic */ Boolean O00000o0(BluetoothGatt bluetoothGatt) {
        return Boolean.valueOf(bluetoothGatt != null);
    }

    public final /* synthetic */ void O00000Oo(Throwable th) {
        O000000o(th);
    }

    public static /* synthetic */ Boolean O000000o(cqv.O00000Oo o00000Oo) {
        return Boolean.valueOf(o00000Oo == cqv.O00000Oo.O00000o0);
    }

    public final /* synthetic */ void O000000o() {
        this.f14271O000000o.onCompleted();
    }

    public final /* synthetic */ void O00000Oo() {
        this.O00000Oo.release();
    }
}

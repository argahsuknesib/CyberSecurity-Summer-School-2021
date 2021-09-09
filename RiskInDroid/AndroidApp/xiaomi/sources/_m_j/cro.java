package _m_j;

import _m_j.cqv;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble.internal.util.BleConnectionCompat;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

public final class cro extends crd<BluetoothGatt> {
    private final BluetoothDevice O00000o;
    public BehaviorSubject<BluetoothGatt> O00000o0 = BehaviorSubject.create();
    private final crn O00000oO;
    private final BleConnectionCompat O00000oo;
    private final boolean O0000O0o;
    private Subscription O0000OOo;
    private final Runnable O0000Oo = crr.O000000o();
    private final Runnable O0000Oo0 = new crp(this);

    public static /* synthetic */ BluetoothGatt O000000o(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt;
    }

    public static /* synthetic */ void O00000Oo() {
    }

    public cro(BluetoothDevice bluetoothDevice, crn crn, BleConnectionCompat bleConnectionCompat, boolean z) {
        this.O00000o = bluetoothDevice;
        this.O00000oO = crn;
        this.O00000oo = bleConnectionCompat;
        this.O0000O0o = z;
    }

    public final void run() {
        Runnable runnable = this.O0000O0o ? this.O0000Oo : this.O0000Oo0;
        Runnable runnable2 = this.O0000O0o ? this.O0000Oo0 : this.O0000Oo;
        Observable.combineLatest(this.O00000oO.O000000o().filter(crq.O000000o()), this.O00000o0, crx.O000000o()).mergeWith(this.O00000oO.O00000o0).first().subscribe(crs.O000000o(this, runnable), crt.O000000o(this), cru.O000000o(this));
        Observable<BluetoothGatt> startWith = this.O00000oO.f14282O000000o.startWith(this.O00000oo.O000000o(this.O00000o, this.O0000O0o, this.O00000oO.O00000o));
        BehaviorSubject<BluetoothGatt> behaviorSubject = this.O00000o0;
        behaviorSubject.getClass();
        this.O0000OOo = startWith.doOnUnsubscribe(crv.O000000o(behaviorSubject)).subscribe(crw.O000000o(this));
        runnable2.run();
    }

    public final /* synthetic */ void O00000Oo(Throwable th) {
        O000000o(th);
    }

    public static /* synthetic */ Boolean O000000o(cqv.O00000Oo o00000Oo) {
        return Boolean.valueOf(o00000Oo == cqv.O00000Oo.O00000Oo);
    }

    public final /* synthetic */ void O000000o() {
        this.f14271O000000o.onCompleted();
    }

    public final /* synthetic */ void O000000o(Runnable runnable, BluetoothGatt bluetoothGatt) {
        this.f14271O000000o.onNext(bluetoothGatt);
        runnable.run();
    }

    public final /* synthetic */ void O00000o0() {
        this.O00000Oo.release();
    }
}

package _m_j;

import _m_j.cqv;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

public final class crn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final BehaviorSubject<BluetoothGatt> f14282O000000o;
    public final PublishSubject<cqv.O00000Oo> O00000Oo;
    public BluetoothGattCallback O00000o;
    public final Observable O00000o0;
    private final BehaviorSubject<Void> O00000oO;

    public interface O000000o {
        crn O000000o();
    }

    public final Observable<cqv.O00000Oo> O000000o() {
        return Observable.merge(this.O00000oO.asObservable(), this.O00000Oo);
    }
}

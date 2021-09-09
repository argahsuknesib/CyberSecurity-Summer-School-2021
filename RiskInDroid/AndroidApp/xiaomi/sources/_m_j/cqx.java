package _m_j;

import _m_j.cqv;
import android.bluetooth.BluetoothDevice;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.subjects.BehaviorSubject;

public final class cqx {

    /* renamed from: O000000o  reason: collision with root package name */
    public final BluetoothDevice f14263O000000o;
    public final cqv.O000000o O00000Oo;
    public AtomicBoolean O00000o;
    final BehaviorSubject<cqv.O00000Oo> O00000o0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cqx)) {
            return false;
        }
        return this.f14263O000000o.equals(((cqx) obj).f14263O000000o);
    }

    public final int hashCode() {
        return this.f14263O000000o.hashCode();
    }

    public final String toString() {
        return "RxBleDeviceImpl{bluetoothDevice=" + this.f14263O000000o.getName() + '(' + this.f14263O000000o.getAddress() + ')' + '}';
    }
}

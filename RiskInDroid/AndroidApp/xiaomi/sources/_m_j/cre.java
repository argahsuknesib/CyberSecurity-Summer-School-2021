package _m_j;

import _m_j.cqv;
import _m_j.crn;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.polidea.rxandroidble.internal.connection.RxBleConnectionConnectorImpl$$Lambda$1;
import com.polidea.rxandroidble.internal.util.BleConnectionCompat;
import rx.Observable;

public final class cre implements cqv.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final BluetoothDevice f14273O000000o;
    public final crn.O000000o O00000Oo;
    public final BleConnectionCompat O00000o;
    public final crc O00000o0;

    public final Observable<cqv> O000000o(Context context, boolean z) {
        return Observable.defer(RxBleConnectionConnectorImpl$$Lambda$1.lambdaFactory$(this, context, z));
    }
}

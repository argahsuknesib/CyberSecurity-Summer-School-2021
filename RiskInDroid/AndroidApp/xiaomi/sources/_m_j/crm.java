package _m_j;

import android.bluetooth.BluetoothGatt;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;

public final class crm implements cqv {

    /* renamed from: O000000o  reason: collision with root package name */
    static final UUID f14281O000000o = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private final crc O00000Oo;
    private final BluetoothGatt O00000o;
    private final crn O00000o0;
    private final AtomicReference<Observable<Object>> O00000oO = new AtomicReference<>();
    private final HashMap<UUID, Observable<Observable<byte[]>>> O00000oo = new HashMap<>();

    public crm(crc crc, crn crn, BluetoothGatt bluetoothGatt) {
        this.O00000Oo = crc;
        this.O00000o0 = crn;
        this.O00000o = bluetoothGatt;
    }
}

package _m_j;

import _m_j.jak;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

class jal extends jak {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<jat, jak.O000000o> f1701O000000o = new HashMap();
    public Handler O00000Oo;
    public long O00000o;
    public long O00000o0;
    public final Runnable O00000oO = new Runnable() {
        /* class _m_j.jal.AnonymousClass1 */

        public final void run() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && jal.this.O00000o0 > 0 && jal.this.O00000o > 0) {
                defaultAdapter.stopLeScan(jal.this.O0000O0o);
                jal.this.O00000Oo.postDelayed(jal.this.O00000oo, jal.this.O00000o0);
            }
        }
    };
    public final Runnable O00000oo = new Runnable() {
        /* class _m_j.jal.AnonymousClass2 */

        public final void run() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && jal.this.O00000o0 > 0 && jal.this.O00000o > 0) {
                defaultAdapter.startLeScan(jal.this.O0000O0o);
                jal.this.O00000Oo.postDelayed(jal.this.O00000oO, jal.this.O00000o);
            }
        }
    };
    public final BluetoothAdapter.LeScanCallback O0000O0o = new BluetoothAdapter.LeScanCallback() {
        /* class _m_j.jal.AnonymousClass3 */

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            final ScanResult scanResult = new ScanResult(bluetoothDevice, jau.O000000o(bArr), i, SystemClock.elapsedRealtimeNanos());
            synchronized (jal.this.f1701O000000o) {
                for (final jak.O000000o next : jal.this.f1701O000000o.values()) {
                    next.O0000O0o.post(new Runnable() {
                        /* class _m_j.jal.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            next.O000000o(1, scanResult);
                        }
                    });
                }
            }
        }
    };
    private HandlerThread O0000OOo;

    jal() {
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<ScanFilter> list, ScanSettings scanSettings, jat jat, Handler handler) {
        boolean isEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        jap.O000000o(defaultAdapter);
        synchronized (this.f1701O000000o) {
            if (!this.f1701O000000o.containsKey(jat)) {
                jak.O000000o o000000o = new jak.O000000o(false, false, list, scanSettings, jat, handler);
                isEmpty = this.f1701O000000o.isEmpty();
                this.f1701O000000o.put(jat, o000000o);
            } else {
                throw new IllegalArgumentException("scanner already started with given scanCallback");
            }
        }
        if (this.O0000OOo == null) {
            this.O0000OOo = new HandlerThread(jal.class.getName());
            this.O0000OOo.start();
            this.O00000Oo = new Handler(this.O0000OOo.getLooper());
        }
        O00000Oo();
        if (isEmpty) {
            defaultAdapter.startLeScan(this.O0000O0o);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(jat jat) {
        jak.O000000o remove;
        boolean isEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        jap.O000000o(defaultAdapter);
        synchronized (this.f1701O000000o) {
            remove = this.f1701O000000o.remove(jat);
            isEmpty = this.f1701O000000o.isEmpty();
        }
        if (remove != null) {
            remove.O000000o();
            O00000Oo();
            if (isEmpty) {
                defaultAdapter.stopLeScan(this.O0000O0o);
                Handler handler = this.O00000Oo;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                HandlerThread handlerThread = this.O0000OOo;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.O0000OOo = null;
                }
            }
        }
    }

    private void O00000Oo() {
        long j;
        long j2;
        synchronized (this.f1701O000000o) {
            j = Long.MAX_VALUE;
            j2 = Long.MAX_VALUE;
            for (jak.O000000o o000000o : this.f1701O000000o.values()) {
                ScanSettings scanSettings = o000000o.O00000oO;
                if (scanSettings.O000000o()) {
                    if (j > scanSettings.O00000Oo) {
                        j = scanSettings.O00000Oo;
                    }
                    if (j2 > scanSettings.f15417O000000o) {
                        j2 = scanSettings.f15417O000000o;
                    }
                }
            }
        }
        if (j >= Long.MAX_VALUE || j2 >= Long.MAX_VALUE) {
            this.O00000o = 0;
            this.O00000o0 = 0;
            Handler handler = this.O00000Oo;
            if (handler != null) {
                handler.removeCallbacks(this.O00000oo);
                this.O00000Oo.removeCallbacks(this.O00000oO);
                return;
            }
            return;
        }
        this.O00000o0 = j;
        this.O00000o = j2;
        Handler handler2 = this.O00000Oo;
        if (handler2 != null) {
            handler2.removeCallbacks(this.O00000oo);
            this.O00000Oo.removeCallbacks(this.O00000oO);
            this.O00000Oo.postDelayed(this.O00000oO, this.O00000o);
        }
    }
}

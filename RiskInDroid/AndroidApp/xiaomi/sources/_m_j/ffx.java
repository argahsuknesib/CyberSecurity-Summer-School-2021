package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class ffx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ffz[] f16249O000000o = {new fft(), new ffu(), ffv.O000000o()};
    private static ffx O00000o;
    public Handler O00000Oo = new Handler(Looper.getMainLooper());
    private final Executor O00000o0 = Executors.newScheduledThreadPool(1);

    private ffx() {
    }

    public static ffx O000000o() {
        if (O00000o == null) {
            O00000o = new ffx();
        }
        return O00000o;
    }

    public final void O000000o(BluetoothSearchResult bluetoothSearchResult, ffy ffy) {
        gqe.O000000o(new O000000o(bluetoothSearchResult, ffy), this.O00000o0);
    }

    public final ffw O000000o(BluetoothSearchResult bluetoothSearchResult, int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ffw ffw = new ffw();
        O000000o(bluetoothSearchResult, new ffy() {
            /* class _m_j.ffx.AnonymousClass1 */

            public final void O000000o(ffw ffw) {
                if (ffw != null) {
                    ffw ffw2 = ffw;
                    ffw2.f16248O000000o = ffw.f16248O000000o;
                    ffw2.O00000o0 = ffw.O00000o0;
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await((long) i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return ffw;
    }

    class O000000o extends gqe {

        /* renamed from: O000000o  reason: collision with root package name */
        BluetoothSearchResult f16251O000000o;
        ffy O00000Oo;

        O000000o(BluetoothSearchResult bluetoothSearchResult, ffy ffy) {
            this.f16251O000000o = bluetoothSearchResult;
            this.O00000Oo = ffy;
        }

        public final void O000000o() {
            ffw ffw = new ffw();
            ffz[] ffzArr = ffx.f16249O000000o;
            int length = ffzArr.length;
            final ffw ffw2 = ffw;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ffw2 = ffzArr[i].O000000o(this.f16251O000000o);
                if (ffw2 != null && !TextUtils.isEmpty(ffw2.f16248O000000o)) {
                    if ("xiaomi.ble.v1".equalsIgnoreCase(ffw2.f16248O000000o)) {
                        ffw2.f16248O000000o = "";
                        break;
                    } else if (!TextUtils.isEmpty(ffw2.f16248O000000o)) {
                        ffr.O0000O0o(this.f16251O000000o.O000000o(), ffw2.f16248O000000o);
                        if (!fec.O00000o0().O00000oO(ffw2.f16248O000000o)) {
                            gnk.O00000Oo(String.format("Model %s is not plugin", ffw2.f16248O000000o));
                        }
                    }
                }
                i++;
            }
            ffx.this.O00000Oo.post(new Runnable() {
                /* class _m_j.ffx.O000000o.AnonymousClass1 */

                public final void run() {
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.O000000o(ffw2);
                    }
                }
            });
        }
    }
}

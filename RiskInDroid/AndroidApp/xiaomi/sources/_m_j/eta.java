package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.qrcode.CaptureActivityHandler;
import java.util.concurrent.CountDownLatch;

public final class eta extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private final CaptureActivityHandler f15785O000000o;
    private Handler O00000Oo;
    private final CountDownLatch O00000o0 = new CountDownLatch(1);

    public eta(CaptureActivityHandler captureActivityHandler) {
        this.f15785O000000o = captureActivityHandler;
    }

    public final Handler O000000o() {
        try {
            this.O00000o0.await();
        } catch (InterruptedException unused) {
        }
        return this.O00000Oo;
    }

    public final void run() {
        Looper.prepare();
        this.O00000Oo = new esz(this.f15785O000000o);
        this.O00000o0.countDown();
        Looper.loop();
    }
}

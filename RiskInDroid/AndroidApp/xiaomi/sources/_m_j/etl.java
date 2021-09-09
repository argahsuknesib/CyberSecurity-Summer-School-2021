package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class etl extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ScanBarcodeActivity f15798O000000o;
    private final Map<DecodeHintType, Object> O00000Oo = new EnumMap(DecodeHintType.class);
    private final CountDownLatch O00000o = new CountDownLatch(1);
    private Handler O00000o0;

    public etl(ScanBarcodeActivity scanBarcodeActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, idh idh) {
        this.f15798O000000o = scanBarcodeActivity;
        this.O00000Oo.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        this.O00000Oo.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, idh);
        Log.i("DecodeThread", "Hints: " + this.O00000Oo);
    }

    public final Handler O000000o() {
        try {
            this.O00000o.await();
        } catch (InterruptedException unused) {
        }
        return this.O00000o0;
    }

    public final void run() {
        Looper.prepare();
        this.O00000o0 = new etk(this.f15798O000000o, this.O00000Oo);
        this.O00000o.countDown();
        Looper.loop();
    }
}

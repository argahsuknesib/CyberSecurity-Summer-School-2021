package _m_j;

import _m_j.dxr;
import android.os.Handler;
import android.os.HandlerThread;

public class dyi extends dyo {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f15068O000000o;
    public Runnable O00000Oo = new Runnable() {
        /* class _m_j.dyi.AnonymousClass1 */

        public final void run() {
            if (dyi.this.O00000o0()) {
                dxq.O0000Oo0();
                if (dyi.this.f15068O000000o != null) {
                    dyi.this.f15068O000000o.postDelayed(dyi.this.O00000Oo, 180000);
                }
            }
        }
    };
    private HandlerThread O00000o0 = new HandlerThread("netThread");

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        super.O000000o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r5.O00000o0.getLooper() == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r5.O00000o0.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r5.O00000o0.getLooper() == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5.f15068O000000o = new android.os.Handler(r5.O00000o0.getLooper());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        r5.f15068O000000o.postDelayed(r5.O00000Oo, 180000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003b */
    public final void O000000o() {
        synchronized (dyi.class) {
            super.O000000o();
            if (!this.O00000o0.isAlive()) {
                this.O00000o0.start();
                this.f15068O000000o = new Handler(this.O00000o0.getLooper());
            }
            if (dxr.O000000o.f15041O000000o.O000000o().O0000Oo && this.f15068O000000o != null) {
                this.f15068O000000o.postDelayed(this.O00000Oo, 180000);
            }
        }
    }
}

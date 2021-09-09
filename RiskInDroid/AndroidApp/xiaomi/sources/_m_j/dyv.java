package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import com.xiaomi.miot.support.monitor.leak.Retryable;

public final class dyv implements dzc {

    /* renamed from: O000000o  reason: collision with root package name */
    final Handler f15083O000000o;
    final long O00000Oo;
    final long O00000o0;
    private final Handler O00000oO = new Handler(Looper.getMainLooper());

    public dyv(long j) {
        HandlerThread handlerThread = new HandlerThread("Miot-Leak-check");
        handlerThread.start();
        this.f15083O000000o = new Handler(handlerThread.getLooper());
        this.O00000Oo = j;
        this.O00000o0 = Long.MAX_VALUE / j;
    }

    public final void O000000o(Retryable retryable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            O00000Oo(retryable, 0);
        } else {
            O000000o(retryable, 0);
        }
    }

    public final void O000000o(final Retryable retryable, final int i) {
        this.O00000oO.post(new Runnable() {
            /* class _m_j.dyv.AnonymousClass1 */

            public final void run() {
                dyv.this.O00000Oo(retryable, i);
            }
        });
    }

    public final void O00000Oo(final Retryable retryable, final int i) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class _m_j.dyv.AnonymousClass2 */

            public final boolean queueIdle() {
                dyv dyv = dyv.this;
                Retryable retryable = retryable;
                int i = i;
                dyv.f15083O000000o.postDelayed(new Runnable(retryable, i) {
                    /* class _m_j.dyv.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Retryable f15086O000000o;
                    final /* synthetic */ int O00000Oo;

                    {
                        this.f15086O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        if (this.f15086O000000o.O000000o() == Retryable.Result.RETRY) {
                            dyv.this.O000000o(this.f15086O000000o, this.O00000Oo + 1);
                        }
                    }
                }, dyv.O00000Oo * ((long) Math.min(Math.pow(2.0d, (double) i), (double) dyv.O00000o0)));
                return false;
            }
        });
    }
}

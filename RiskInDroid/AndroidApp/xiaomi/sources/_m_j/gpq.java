package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class gpq extends HandlerThread {
    public Handler O00000Oo;

    public gpq(String str) {
        super(str);
    }

    public synchronized void start() {
        super.start();
        this.O00000Oo = new Handler(getLooper()) {
            /* class _m_j.gpq.AnonymousClass1 */

            public final void handleMessage(Message message) {
                gpq.this.O00000Oo.sendEmptyMessageDelayed(1, 7200000);
            }
        };
        this.O00000Oo.sendEmptyMessageDelayed(1, 7200000);
    }

    public void run() {
        try {
            if (Looper.myLooper() != null) {
                gsy.O000000o(3, "MessageHandlerThread", "looper is not when run start");
            } else {
                super.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(getName(), e);
        }
    }
}

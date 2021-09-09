package _m_j;

import android.os.HandlerThread;
import android.os.Process;

public final class img extends HandlerThread {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f1463O000000o = -16;

    public img(String str) {
        super(str);
    }

    public final void run() {
        Process.setThreadPriority(this.f1463O000000o);
        super.run();
    }
}

package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectDispatcher;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectWorker;
import com.xiaomi.smarthome.library.bluetooth.connect.RuntimeChecker;
import com.xiaomi.smarthome.library.bluetooth.connect.request.IFastSchedule;
import java.util.LinkedList;
import java.util.List;

public final class glv implements Handler.Callback, IBleConnectDispatcher, RuntimeChecker {

    /* renamed from: O000000o  reason: collision with root package name */
    List<gmj> f17997O000000o = new LinkedList();
    gmj O00000Oo;
    private String O00000o;
    IBleConnectWorker O00000o0;
    private Handler O00000oO;

    public static glv O000000o(String str) {
        return new glv(str);
    }

    private glv(String str) {
        this.O00000o = str;
        this.O00000o0 = new glz(str, this);
        this.O00000oO = new Handler(Looper.myLooper(), this);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(gmj gmj) {
        checkRuntime();
        if (this.f17997O000000o.size() < 100) {
            gmj.O0000o0 = this;
            gmj.O000000o(this.O00000o);
            gmj.O000000o(this.O00000o0);
            this.f17997O000000o.add(gmj);
        } else {
            gmj.O000000o(-11);
        }
        O000000o(10);
    }

    public final void onRequestCompleted(gmj gmj) {
        checkRuntime();
        if (gmj == this.O00000Oo) {
            this.O00000Oo = null;
            O000000o(10);
            return;
        }
        throw new IllegalStateException("request not match");
    }

    private void O000000o(long j) {
        if (this.f17997O000000o.size() > 0 && (this.f17997O000000o.get(0) instanceof IFastSchedule)) {
            j = 0;
        }
        this.O00000oO.sendEmptyMessageDelayed(18, j);
    }

    public final void checkRuntime() {
        if (Thread.currentThread() != this.O00000oO.getLooper().getThread()) {
            throw new IllegalStateException("Thread Context Illegal");
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 18 || this.O00000Oo != null || gpn.O000000o(this.f17997O000000o)) {
            return true;
        }
        this.O00000Oo = this.f17997O000000o.remove(0);
        this.O00000Oo.process(this);
        return true;
    }
}

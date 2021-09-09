package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;

final class ece extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Throwable f15161O000000o;
    final /* synthetic */ Thread O00000Oo;
    final /* synthetic */ ebt O00000o0;

    ece(ebt ebt, Throwable th, Thread thread) {
        this.O00000o0 = ebt;
        this.f15161O000000o = th;
        this.O00000Oo = thread;
    }

    public final void run() {
        super.run();
        Looper.prepare();
        String unused = this.O00000o0.O00000o = ebt.O000000o(this.f15161O000000o);
        ProtoMsg$StatsMsg.CrashMsg O000000o2 = ebv.O000000o(this.O00000o0.f15155O000000o, this.O00000o0.O00000o);
        if (!ecd.O000000o(this.O00000o0.O00000o) && O000000o2 != null) {
            ebt ebt = this.O00000o0;
            if (!ebt.O00000Oo(ecd.O00000Oo(ebt.O00000o))) {
                ebp.O000000o(this.O00000o0.f15155O000000o, "crash", O000000o2.toByteArray());
            }
        }
        if (this.O00000o0.O00000Oo != null) {
            this.O00000o0.O00000Oo.uncaughtException(this.O00000Oo, this.f15161O000000o);
        } else {
            new Handler().postDelayed(new ecf(this), 300);
        }
        Looper.loop();
    }
}

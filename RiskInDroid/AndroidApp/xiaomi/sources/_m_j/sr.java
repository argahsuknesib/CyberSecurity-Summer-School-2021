package _m_j;

import _m_j.sq;
import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

public final class sr implements sq.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<O000000o> f2479O000000o = new ArrayList();
    private ss O00000Oo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Handler f2480O000000o;
    }

    public sr(Context context, ss ssVar) {
        this.O00000Oo = ssVar;
        this.O00000Oo.O000000o(context, this);
    }

    public final void O000000o() {
        synchronized (this.f2479O000000o) {
            for (O000000o o000000o : this.f2479O000000o) {
                o000000o.f2480O000000o.sendEmptyMessage(0);
            }
        }
    }
}

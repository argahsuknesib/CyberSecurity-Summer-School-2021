package _m_j;

import _m_j.oh;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public class tw {
    private static final String O0000o00 = "tw";

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2516O000000o;
    public oh.O00000Oo O00000Oo;
    public uc O00000o;
    public Handler O00000o0;
    public ts O00000oO;
    public sh O00000oo;
    public long O0000O0o;
    public Location O0000OOo;
    public List<ug> O0000Oo = new ArrayList();
    public long O0000Oo0;
    public List<sg> O0000OoO;
    public ud O0000Ooo = new ud();
    private final Object O0000o0 = new Object();

    public tw(Context context, uc ucVar, oh.O00000Oo o00000Oo, Looper looper) {
        this.f2516O000000o = context;
        this.O00000Oo = o00000Oo;
        this.O00000o = ucVar;
        this.O00000o0 = new Handler(looper);
        this.O00000oO = new ts();
    }

    public final void O000000o() {
        try {
            se.O000000o(this.f2516O000000o).O000000o(this.O00000oo);
        } catch (Exception | SecurityException unused) {
        }
        synchronized (this.O0000o0) {
            this.O00000o0.removeCallbacksAndMessages(null);
            this.O00000o0 = null;
        }
    }
}

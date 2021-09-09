package _m_j;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;

public class tv {
    private static final String O0000Ooo = "tv";

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2514O000000o;
    public Handler O00000Oo;
    public tu O00000o;
    public uc O00000o0;
    public tx O00000oO;
    public sf O00000oo;
    public long O0000O0o;
    public long O0000OOo;
    public tq O0000Oo;
    public Location O0000Oo0;
    public ud O0000OoO = new ud();

    public tv(Context context, uc ucVar, Looper looper) {
        this.f2514O000000o = context;
        this.O00000o0 = ucVar;
        this.O00000Oo = new Handler(looper);
        this.O00000o = new tu(this.f2514O000000o, looper);
        this.O00000oO = new tx(this.f2514O000000o, looper);
        this.O0000Oo = new tq();
    }
}

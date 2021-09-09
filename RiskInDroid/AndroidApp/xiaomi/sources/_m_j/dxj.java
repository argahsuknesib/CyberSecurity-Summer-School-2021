package _m_j;

import android.text.TextUtils;
import com.xiaomi.mijialog.LoganModel;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

class dxj {
    private static volatile dxj O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    ConcurrentLinkedQueue<LoganModel> f15030O000000o = new ConcurrentLinkedQueue<>();
    String O00000Oo;
    dxm O00000o;
    long O00000o0;
    private String O00000oo;
    private long O0000O0o;
    private long O0000OOo;
    private String O0000Oo;
    private long O0000Oo0;
    private SimpleDateFormat O0000OoO = new SimpleDateFormat("yyyy-MM-dd");

    private dxj(dxi dxi) {
        if (!TextUtils.isEmpty(dxi.f15028O000000o) && !TextUtils.isEmpty(dxi.O00000Oo) && !TextUtils.isEmpty(dxi.O0000O0o)) {
            this.O00000Oo = dxi.O00000Oo;
            this.O00000oo = dxi.f15028O000000o;
            this.O0000O0o = dxi.O00000o;
            this.O0000Oo0 = dxi.O00000oo;
            this.O0000OOo = dxi.O00000o0;
            this.O00000o0 = dxi.O00000oO;
            this.O0000Oo = dxi.O0000O0o;
            if (this.O00000o == null) {
                this.O00000o = new dxm(this.f15030O000000o, this.O00000oo, this.O00000Oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
                this.O00000o.setName("logan-thread");
                this.O00000o.start();
                return;
            }
            return;
        }
        throw new NullPointerException("config's param is invalid");
    }

    static dxj O000000o(dxi dxi) {
        if (O00000oO == null) {
            synchronized (dxj.class) {
                if (O00000oO == null) {
                    O00000oO = new dxj(dxi);
                }
            }
        }
        return O00000oO;
    }
}

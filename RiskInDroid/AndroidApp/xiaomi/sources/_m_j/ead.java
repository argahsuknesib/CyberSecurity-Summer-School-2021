package _m_j;

import _m_j.dzz;
import com.xiaomi.push.ht;
import java.util.concurrent.TimeUnit;

final class ead implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ht f15118O000000o;
    final /* synthetic */ dzz.O000000o.C0101O000000o O00000Oo;

    ead(dzz.O000000o.C0101O000000o o000000o, ht htVar) {
        this.O00000Oo = o000000o;
        this.f15118O000000o = htVar;
    }

    public final void run() {
        this.O00000Oo.O00000Oo.add(this.f15118O000000o);
        dzz.O000000o.C0101O000000o o000000o = this.O00000Oo;
        if (o000000o.O00000o0 == null) {
            o000000o.O00000o0 = o000000o.f15112O000000o.scheduleAtFixedRate(o000000o.O00000o, 1000, 1000, TimeUnit.MILLISECONDS);
        }
    }
}

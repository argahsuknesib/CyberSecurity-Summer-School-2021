package _m_j;

import _m_j.dzz;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.bs;
import java.util.Arrays;

final class eae implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ dzz.O000000o.C0101O000000o f15119O000000o;

    eae(dzz.O000000o.C0101O000000o o000000o) {
        this.f15119O000000o = o000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    public final void run() {
        if (this.f15119O000000o.O00000Oo.size() != 0) {
            dzz.O000000o.C0101O000000o o000000o = this.f15119O000000o;
            ht remove = o000000o.O00000Oo.remove(0);
            for (io ioVar : bs.a(Arrays.asList(remove), dzz.O000000o.this.O00000Oo.getPackageName(), b.O000000o(dzz.O000000o.this.O00000Oo).O00000Oo.f6054O000000o, 30720)) {
                duv.O00000o0("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.f);
                eao.O000000o(dzz.O000000o.this.O00000Oo).O000000o((ja) ioVar, hp.i, true, (ic) null);
            }
        } else if (this.f15119O000000o.O00000o0 != null) {
            this.f15119O000000o.O00000o0.cancel(false);
            this.f15119O000000o.O00000o0 = null;
        }
    }
}

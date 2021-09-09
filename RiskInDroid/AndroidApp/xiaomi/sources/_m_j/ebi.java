package _m_j;

import _m_j.elo;
import android.content.Context;
import com.xiaomi.push.hp;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.aw;

final class ebi extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ io f15146O000000o;
    final /* synthetic */ Context O00000Oo;

    ebi(io ioVar, Context context) {
        this.f15146O000000o = ioVar;
        this.O00000Oo = context;
    }

    public final String a() {
        return "22";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, int]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void */
    public final void run() {
        io ioVar = this.f15146O000000o;
        if (ioVar != null) {
            ioVar.b = aw.a();
            eao.O000000o(this.O00000Oo.getApplicationContext()).O000000o((ja) this.f15146O000000o, hp.i, true, true);
        }
    }
}

package _m_j;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.aw;
import java.util.HashMap;

final class dzv implements Runnable {
    dzv() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    public final void run() {
        if (esl.O00000oo()) {
            return;
        }
        if (erv.O00000o(dzs.f15105O000000o) != null || elz.O000000o(dzs.f15105O000000o).O000000o()) {
            io ioVar = new io();
            ioVar.c = b.O000000o(dzs.f15105O000000o).O00000Oo.f6054O000000o;
            ioVar.d = hz.g.f70a;
            ioVar.b = aw.a();
            ioVar.f133a = new HashMap();
            String str = "";
            String O00000o = erv.O00000o(dzs.f15105O000000o);
            if (!TextUtils.isEmpty(O00000o)) {
                str = str + eml.O000000o(O00000o);
            }
            String O00000oo = erv.O00000oo(dzs.f15105O000000o);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(O00000oo)) {
                str = str + "," + O00000oo;
            }
            if (!TextUtils.isEmpty(str)) {
                ioVar.f133a.put("imei_md5", str);
            }
            elz.O000000o(dzs.f15105O000000o).O000000o(ioVar.f133a);
            erv.O000000o(dzs.f15105O000000o, ioVar.f133a);
            int O000000o2 = erv.O000000o();
            if (O000000o2 >= 0) {
                ioVar.f133a.put("space_id", Integer.toString(O000000o2));
            }
            eao.O000000o(dzs.f15105O000000o).O000000o((ja) ioVar, hp.i, false, (ic) null);
        }
    }
}

package _m_j;

import _m_j.eov;
import android.text.TextUtils;
import com.xiaomi.push.service.az;
import java.io.IOException;

final class epy extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ epx f15715O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    epy(epx epx, String str) {
        super(str);
        this.f15715O000000o = epx;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    public final void run() {
        eps O000000o2;
        epx epx;
        String str;
        try {
            O000000o2 = this.f15715O000000o.O00oOooO;
            boolean z = false;
            O000000o2.O00000o0 = false;
            epq O000000o3 = O000000o2.O000000o();
            if ("CONN".equals(O000000o3.f15708O000000o.O00000oo)) {
                eov.O0000OOo o0000OOo = (eov.O0000OOo) new eov.O0000OOo().O000000o(O000000o3.O00000o0());
                if (o0000OOo.f15689O000000o) {
                    O000000o2.O00000Oo.O000000o(o0000OOo.O00000Oo);
                    z = true;
                }
                if (o0000OOo.O00000o) {
                    eov.O00000Oo o00000Oo = o0000OOo.O00000oO;
                    epq epq = new epq();
                    epq.O000000o("SYNC", "CONF");
                    epq.O000000o(o00000Oo.O00000o0(), (String) null);
                    O000000o2.O00000Oo.O000000o(epq);
                }
                duv.O000000o("[Slim] CONN: host = " + o0000OOo.O00000o0);
            }
            if (z) {
                O000000o2.O00000o = O000000o2.O00000Oo.O000000o();
                while (!O000000o2.O00000o0) {
                    epq O000000o4 = O000000o2.O000000o();
                    O000000o2.O00000Oo.O0000Ooo();
                    short s = O000000o4.O00000Oo;
                    if (s != 1) {
                        if (s != 2) {
                            if (s != 3) {
                                str = "[Slim] unknow blob type " + ((int) O000000o4.O00000Oo);
                            } else {
                                try {
                                    O000000o2.O00000Oo.O00000Oo(O000000o2.f15710O000000o.O000000o(O000000o4.O00000o0(), O000000o2.O00000Oo));
                                } catch (Exception e) {
                                    str = "[Slim] Parse packet from Blob chid=" + O000000o4.f15708O000000o.f15684O000000o + "; Id=" + O000000o4.O000000o() + " failure:" + e.getMessage();
                                }
                            }
                        } else if (!"SECMSG".equals(O000000o4.f15708O000000o.O00000oo) || (!(O000000o4.f15708O000000o.f15684O000000o == 2 || O000000o4.f15708O000000o.f15684O000000o == 3) || !TextUtils.isEmpty(O000000o4.f15708O000000o.O0000OOo))) {
                            epx = O000000o2.O00000Oo;
                        } else {
                            try {
                                O000000o2.O00000Oo.O00000Oo(O000000o2.f15710O000000o.O000000o(O000000o4.O00000o0(az.a().a(Integer.valueOf(O000000o4.f15708O000000o.f15684O000000o).toString(), O000000o4.O00000Oo()).h), O000000o2.O00000Oo));
                            } catch (Exception e2) {
                                str = "[Slim] Parse packet from Blob chid=" + O000000o4.f15708O000000o.f15684O000000o + "; Id=" + O000000o4.O000000o() + " failure:" + e2.getMessage();
                            }
                        }
                        duv.O000000o(str);
                    } else {
                        epx = O000000o2.O00000Oo;
                    }
                    epx.O000000o(O000000o4);
                }
                return;
            }
            duv.O000000o("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        } catch (IOException e3) {
            if (!O000000o2.O00000o0) {
                throw e3;
            }
        } catch (Exception e4) {
            this.f15715O000000o.O00000o0(9, e4);
        }
    }
}

package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.enl;
import _m_j.enp;
import _m_j.eoe;
import _m_j.eof;
import _m_j.eov;
import _m_j.epq;
import _m_j.eqc;
import _m_j.eqo;
import _m_j.eqp;
import _m_j.eqq;
import _m_j.eqr;
import _m_j.erf;
import _m_j.ero;
import android.text.TextUtils;
import com.xiaomi.push.fg;
import com.xiaomi.push.service.az;
import java.util.Date;

public class ax {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f6510a;

    ax(XMPushService xMPushService) {
        this.f6510a = xMPushService;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.enp.a(java.lang.String, boolean):_m_j.enl
     arg types: [java.lang.String, int]
     candidates:
      _m_j.enp.a(java.lang.String, java.lang.String):void
      _m_j.enp.a(java.lang.String, _m_j.enl):void
      _m_j.enp.a(java.lang.String, boolean):_m_j.enl */
    private void a(eqo eqo) {
        String O000000o2 = eqo.O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            String[] split = O000000o2.split(";");
            enl a2 = enp.a().a(eqc.a(), false);
            if (a2 != null && split.length > 0) {
                a2.O000000o(split);
                this.f6510a.a(20, (Exception) null);
                this.f6510a.a(true);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void */
    public void a(eqr eqr) {
        if (!"5".equals(eqr.O0000oOO)) {
            b(eqr);
        }
        String str = eqr.O0000oOO;
        if (TextUtils.isEmpty(str)) {
            str = "1";
            eqr.O0000oOO = str;
        }
        if (str.equals("0")) {
            duv.O000000o("Received wrong packet with chid = 0 : " + eqr.O00000Oo());
        }
        if (eqr instanceof eqp) {
            eqo O000000o2 = eqr.O000000o("kick");
            if (O000000o2 != null) {
                String str2 = eqr.O0000oO0;
                String O000000o3 = O000000o2.O000000o("type");
                String O000000o4 = O000000o2.O000000o("reason");
                duv.O000000o("kicked by server, chid=" + str + " res=" + az.b.a(str2) + " type=" + O000000o3 + " reason=" + O000000o4);
                if ("wait".equals(O000000o3)) {
                    az.b a2 = az.a().a(str, str2);
                    if (a2 != null) {
                        this.f6510a.a(a2);
                        a2.a(az.c.f6516a, 3, 0, O000000o4, O000000o3);
                        return;
                    }
                    return;
                }
                this.f6510a.a(str, str2, 3, O000000o4, O000000o3);
                az.a().m181a(str, str2);
                return;
            }
        } else if (eqr instanceof eqq) {
            eqq eqq = (eqq) eqr;
            if ("redir".equals(eqq.f15730O000000o)) {
                eqo O000000o5 = eqq.O000000o("hosts");
                if (O000000o5 != null) {
                    a(O000000o5);
                    return;
                }
                return;
            }
        }
        this.f6510a.m124b().a(this.f6510a, str, eqr);
    }

    public void a(epq epq) {
        if (5 != epq.f15708O000000o.f15684O000000o) {
            c(epq);
        }
        try {
            b(epq);
        } catch (Exception e) {
            duv.O000000o("handle Blob chid = " + epq.f15708O000000o.f15684O000000o + " cmd = " + epq.f15708O000000o.O00000oo + " packetid = " + epq.O000000o() + " failure ", e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void */
    public void b(epq epq) {
        String str = epq.f15708O000000o.O00000oo;
        if (epq.f15708O000000o.f15684O000000o != 0) {
            String num = Integer.toString(epq.f15708O000000o.f15684O000000o);
            if ("SECMSG".equals(epq.f15708O000000o.O00000oo)) {
                if (!epq.f15708O000000o.O0000Ooo) {
                    this.f6510a.m124b().a(this.f6510a, num, epq);
                    return;
                }
                duv.O000000o("Recv SECMSG errCode = " + epq.f15708O000000o.O0000o00 + " errStr = " + epq.f15708O000000o.O0000o0);
            } else if ("BIND".equals(str)) {
                eov.O00000o o00000o = (eov.O00000o) new eov.O00000o().O000000o(epq.O00000o0());
                String O00000Oo = epq.O00000Oo();
                az.b a2 = az.a().a(num, O00000Oo);
                if (a2 != null) {
                    if (o00000o.f15686O000000o) {
                        duv.O000000o("SMACK: channel bind succeeded, chid=" + epq.f15708O000000o.f15684O000000o);
                        a2.a(az.c.c, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String str2 = o00000o.O00000Oo;
                    if ("auth".equals(str2)) {
                        if ("invalid-sig".equals(o00000o.O00000o0)) {
                            duv.O000000o("SMACK: bind error invalid-sig token = " + a2.c + " sec = " + a2.h);
                            ero.O000000o(fg.T.a(), 1, null, 0);
                        }
                        a2.a(az.c.f6516a, 1, 5, o00000o.O00000o0, str2);
                        az.a().m181a(num, O00000Oo);
                    } else if ("cancel".equals(str2)) {
                        a2.a(az.c.f6516a, 1, 7, o00000o.O00000o0, str2);
                        az.a().m181a(num, O00000Oo);
                    } else if ("wait".equals(str2)) {
                        this.f6510a.a(a2);
                        a2.a(az.c.f6516a, 1, 7, o00000o.O00000o0, str2);
                    }
                    duv.O000000o("SMACK: channel bind failed, chid=" + num + " reason=" + o00000o.O00000o0);
                }
            } else if ("KICK".equals(str)) {
                eov.O0000Oo0 o0000Oo0 = (eov.O0000Oo0) new eov.O0000Oo0().O000000o(epq.O00000o0());
                String O00000Oo2 = epq.O00000Oo();
                String str3 = o0000Oo0.f15691O000000o;
                String str4 = o0000Oo0.O00000Oo;
                duv.O000000o("kicked by server, chid=" + num + " res= " + az.b.a(O00000Oo2) + " type=" + str3 + " reason=" + str4);
                if ("wait".equals(str3)) {
                    az.b a3 = az.a().a(num, O00000Oo2);
                    if (a3 != null) {
                        this.f6510a.a(a3);
                        a3.a(az.c.f6516a, 3, 0, str4, str3);
                        return;
                    }
                    return;
                }
                this.f6510a.a(num, O00000Oo2, 3, str4, str3);
                az.a().m181a(num, O00000Oo2);
            }
        } else if ("PING".equals(str)) {
            byte[] O00000o0 = epq.O00000o0();
            if (O00000o0 != null && O00000o0.length > 0) {
                eov.O0000o0 o0000o0 = (eov.O0000o0) new eov.O0000o0().O000000o(O00000o0);
                if (o0000o0.f15693O000000o) {
                    bo.a().a(o0000o0.O00000Oo);
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f6510a.getPackageName())) {
                this.f6510a.m121a();
            }
            if ("1".equals(epq.O000000o())) {
                duv.O000000o("received a server ping");
            } else {
                ero.O00000Oo();
            }
            this.f6510a.m125b();
        } else if ("SYNC".equals(str)) {
            if ("CONF".equals(epq.f15708O000000o.O0000OOo)) {
                bo.a().a(eov.O00000Oo.O00000Oo(epq.O00000o0()));
            } else if (TextUtils.equals("U", epq.f15708O000000o.O0000OOo)) {
                eov.O0000o o0000o = (eov.O0000o) new eov.O0000o().O000000o(epq.O00000o0());
                eoe O000000o2 = eoe.O000000o(this.f6510a);
                String str5 = o0000o.f15692O000000o;
                String str6 = o0000o.O00000Oo;
                eoe eoe = O000000o2;
                O000000o2.f15669O000000o.add(new eof(eoe, o0000o.O00000oo * 1024, new Date(o0000o.O00000o0), new Date(o0000o.O00000o), str5, str6, o0000o.O00000oO));
                O000000o2.O000000o(0);
                epq epq2 = new epq();
                epq2.O000000o(0);
                epq2.O000000o(epq.f15708O000000o.O00000oo, "UCA");
                epq2.O000000o(epq.O000000o());
                XMPushService xMPushService = this.f6510a;
                xMPushService.a(new bm(xMPushService, epq2));
            } else if (TextUtils.equals("P", epq.f15708O000000o.O0000OOo)) {
                eov.O0000o00 o0000o00 = (eov.O0000o00) new eov.O0000o00().O000000o(epq.O00000o0());
                epq epq3 = new epq();
                epq3.O000000o(0);
                epq3.O000000o(epq.f15708O000000o.O00000oo, "PCA");
                epq3.O000000o(epq.O000000o());
                eov.O0000o00 o0000o002 = new eov.O0000o00();
                if (o0000o00.f15694O000000o) {
                    o0000o002.O000000o(o0000o00.O00000Oo);
                }
                epq3.O000000o(o0000o002.O00000o0(), (String) null);
                XMPushService xMPushService2 = this.f6510a;
                xMPushService2.a(new bm(xMPushService2, epq3));
                duv.O000000o("ACK msgP: id = " + epq.O000000o());
            }
        } else if ("NOTIFY".equals(epq.f15708O000000o.O00000oo)) {
            eov.O0000Oo o0000Oo = (eov.O0000Oo) new eov.O0000Oo().O000000o(epq.O00000o0());
            duv.O000000o("notify by server err = " + o0000Oo.f15690O000000o + " desc = " + o0000Oo.O00000Oo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private void b(eqr eqr) {
        az.b a2;
        String str = eqr.O0000oO0;
        String str2 = eqr.O0000oOO;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = az.a().a(str2, str)) != null) {
            erf.O000000o(this.f6510a, a2.f274a, (long) erf.O00000Oo(eqr.O00000Oo()), true, true, System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private void c(epq epq) {
        az.b a2;
        String O00000Oo = epq.O00000Oo();
        String num = Integer.toString(epq.f15708O000000o.f15684O000000o);
        if (!TextUtils.isEmpty(O00000Oo) && !TextUtils.isEmpty(num) && (a2 = az.a().a(num, O00000Oo)) != null) {
            erf.O000000o(this.f6510a, a2.f274a, (long) epq.O00000o(), true, true, System.currentTimeMillis());
        }
    }
}

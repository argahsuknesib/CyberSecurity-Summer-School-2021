package _m_j;

import _m_j.eov;
import _m_j.eqb;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.bo;
import java.util.HashMap;
import java.util.Locale;

public final class epx extends eqi {
    private Thread O0000ooo;
    private byte[] O000O00o;
    /* access modifiers changed from: private */
    public eps O00oOooO;
    private ept O00oOooo;

    public epx(XMPushService xMPushService, eqc eqc) {
        super(xMPushService, eqc);
    }

    @Deprecated
    public final void O000000o(eqr eqr) {
        O00000Oo(epq.O000000o(eqr, (String) null));
    }

    public final void O000000o(epq[] epqArr) {
        for (epq O00000Oo : epqArr) {
            O00000Oo(O00000Oo);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized byte[] O000000o() {
        if (this.O000O00o == null && !TextUtils.isEmpty(this.O0000OoO)) {
            String a2 = bo.m191a();
            this.O000O00o = bi.a(this.O0000OoO.getBytes(), (this.O0000OoO.substring(this.O0000OoO.length() / 2) + a2.substring(a2.length() / 2)).getBytes());
        }
        return this.O000O00o;
    }

    public final boolean O00000Oo() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        if (this.O00oOooo != null) {
            epw epw = new epw();
            if (z) {
                epw.O000000o("1");
            }
            byte[] O00000o0 = ero.O00000o0();
            if (O00000o0 != null) {
                eov.O0000o0 o0000o0 = new eov.O0000o0();
                o0000o0.O000000o(elb.O000000o(O00000o0));
                epw.O000000o(o0000o0.O00000o0(), (String) null);
            }
            duv.O000000o("[Slim] SND ping id=" + epw.O000000o());
            O00000Oo(epw);
            O0000o0O();
            return;
        }
        throw new gg("The BlobWriter is null.");
    }

    public final synchronized void O000000o(az.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String O0000o00 = O0000o00();
        eov.O00000o0 o00000o0 = new eov.O00000o0();
        if (!TextUtils.isEmpty(bVar.c)) {
            o00000o0.O000000o(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            o00000o0.O00000o(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            o00000o0.O00000oO(bVar.f);
        }
        o00000o0.O00000Oo(bVar.f276a ? "1" : "0");
        o00000o0.O00000o0(!TextUtils.isEmpty(bVar.d) ? bVar.d : "XIAOMI-SASL");
        epq epq = new epq();
        epq.O00000Oo(bVar.f277b);
        epq.O000000o(Integer.parseInt(bVar.g));
        epq.O00000o0 = bVar.f274a;
        epq.O000000o("BIND", (String) null);
        epq.O000000o(epq.O000000o());
        duv.O000000o("[Slim]: bind id=" + epq.O000000o());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", O0000o00);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f277b);
        hashMap.put("id", epq.O000000o());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f276a) {
            str = "kick";
            str2 = "1";
        } else {
            str = "kick";
            str2 = "0";
        }
        hashMap.put(str, str2);
        if (!TextUtils.isEmpty(bVar.e)) {
            str3 = "client_attrs";
            str4 = bVar.e;
        } else {
            str3 = "client_attrs";
            str4 = "";
        }
        hashMap.put(str3, str4);
        if (!TextUtils.isEmpty(bVar.f)) {
            str5 = "cloud_attrs";
            str6 = bVar.f;
        } else {
            str5 = "cloud_attrs";
            str6 = "";
        }
        hashMap.put(str5, str6);
        if (!bVar.d.equals("XIAOMI-PASS")) {
            if (!bVar.d.equals("XMPUSH-PASS")) {
                bVar.d.equals("XIAOMI-SASL");
                str7 = null;
                o00000o0.O00000oo(str7);
                epq.O000000o(o00000o0.O00000o0(), (String) null);
                O00000Oo(epq);
            }
        }
        str7 = emj.O000000o(bVar.d, hashMap, bVar.h);
        o00000o0.O00000oo(str7);
        epq.O000000o(o00000o0.O00000o0(), (String) null);
        O00000Oo(epq);
    }

    public final synchronized void O000000o(String str, String str2) {
        epq epq = new epq();
        epq.O00000Oo(str2);
        epq.O000000o(Integer.parseInt(str));
        epq.O000000o("UBND", (String) null);
        O00000Oo(epq);
    }

    /* access modifiers changed from: protected */
    public final synchronized void O000000o(int i, Exception exc) {
        if (this.O00oOooO != null) {
            this.O00oOooO.O00000o0 = true;
            this.O00oOooO = null;
        }
        if (this.O00oOooo != null) {
            try {
                ept ept = this.O00oOooo;
                epq epq = new epq();
                epq.O000000o("CLOSE", (String) null);
                ept.O000000o(epq);
                ept.O00000o0.close();
            } catch (Exception e) {
                duv.O000000o(e);
            }
            this.O00oOooo = null;
        }
        this.O000O00o = null;
        super.O000000o(i, exc);
    }

    /* access modifiers changed from: protected */
    public final synchronized void O00000o0() {
        try {
            this.O00oOooO = new eps(this.O0000oO.getInputStream(), this);
            this.O00oOooo = new ept(this.O0000oO.getOutputStream(), this);
            this.O0000ooo = new epy(this, "Blob Reader (" + this.O0000o0 + ")");
            this.O0000ooo.start();
            ept ept = this.O00oOooo;
            eov.O0000O0o o0000O0o = new eov.O0000O0o();
            o0000O0o.O000000o(106);
            o0000O0o.O000000o(Build.MODEL);
            o0000O0o.O00000Oo(esu.O00000oO());
            o0000O0o.O00000o0(bo.m191a());
            o0000O0o.O00000Oo(47);
            o0000O0o.O00000o(ept.O00000Oo.O00000oo());
            o0000O0o.O00000oO(ept.O00000Oo.O00000oO());
            o0000O0o.O00000oo(Locale.getDefault().toString());
            o0000O0o.O00000o0(Build.VERSION.SDK_INT);
            byte[] a2 = ept.O00000Oo.O00000o().m606a();
            if (a2 != null) {
                o0000O0o.O000000o(eov.O00000Oo.O00000Oo(a2));
            }
            epq epq = new epq();
            epq.O000000o(0);
            epq.O000000o("CONN", (String) null);
            epq.O000000o(0, "xiaomi.com", null);
            epq.O000000o(o0000O0o.O00000o0(), (String) null);
            ept.O000000o(epq);
            duv.O000000o("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=47 tz=" + ept.O00000o + ":" + ept.O00000oO + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        } catch (Exception e) {
            throw new gg("Error to init reader and writer", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(eqr eqr) {
        if (eqr != null) {
            for (eqb.O000000o o000000o : this.O0000OOo.values()) {
                if (o000000o.O00000Oo == null || o000000o.O00000Oo.a(eqr)) {
                    o000000o.f15721O000000o.a(eqr);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(epq epq) {
        if (epq != null) {
            if (epq.f15708O000000o.O0000Ooo) {
                duv.O000000o("[Slim] RCV blob chid=" + epq.f15708O000000o.f15684O000000o + "; id=" + epq.O000000o() + "; errCode=" + epq.f15708O000000o.O0000o00 + "; err=" + epq.f15708O000000o.O0000o0);
            }
            if (epq.f15708O000000o.f15684O000000o == 0) {
                if ("PING".equals(epq.f15708O000000o.O00000oo)) {
                    duv.O000000o("[Slim] RCV ping id=" + epq.O000000o());
                    O0000o0o();
                } else if ("CLOSE".equals(epq.f15708O000000o.O00000oo)) {
                    O00000o0(13, null);
                }
            }
            for (eqb.O000000o O000000o2 : this.O0000OOo.values()) {
                O000000o2.O000000o(epq);
            }
        }
    }

    public final void O00000Oo(epq epq) {
        if (elk.f15608O000000o) {
            esl.O00000Oo(this.O0000oOo);
        }
        ept ept = this.O00oOooo;
        if (ept != null) {
            try {
                int O000000o2 = ept.O000000o(epq);
                this.O0000o = SystemClock.elapsedRealtime();
                String str = epq.O00000o0;
                if (!TextUtils.isEmpty(str)) {
                    erf.O000000o(this.O0000o0o, str, (long) O000000o2, false, true, System.currentTimeMillis());
                }
                for (eqb.O000000o O000000o3 : this.O0000Oo0.values()) {
                    O000000o3.O000000o(epq);
                }
            } catch (Exception e) {
                throw new gg(e);
            }
        } else {
            throw new gg("the writer is null.");
        }
    }
}

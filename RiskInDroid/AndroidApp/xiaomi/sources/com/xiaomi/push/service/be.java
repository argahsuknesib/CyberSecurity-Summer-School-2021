package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emf;
import _m_j.enl;
import _m_j.eno;
import _m_j.enp;
import _m_j.eou;
import _m_j.eov;
import _m_j.eqb;
import _m_j.erb;
import _m_j.erm;
import _m_j.ero;
import _m_j.esu;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.fg;
import com.xiaomi.push.service.bo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class be extends bo.a implements enp.O000000o {

    /* renamed from: a  reason: collision with root package name */
    private long f6522a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f285a;

    static class a implements enp.O00000Oo {
        a() {
        }

        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", "47");
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", erb.O000000o(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(esu.O00000Oo()));
            String builder = buildUpon.toString();
            duv.O00000o0("fetch bucket from : ".concat(String.valueOf(builder)));
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String O000000o2 = emf.O000000o(esu.O000000o(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ero.O000000o(url.getHost() + ":" + port, (int) currentTimeMillis2, (Exception) null);
                return O000000o2;
            } catch (IOException e) {
                ero.O000000o(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    be(XMPushService xMPushService) {
        this.f285a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        be beVar = new be(xMPushService);
        bo.a().a(beVar);
        synchronized (enp.class) {
            enp.a(beVar);
            enp.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    public enp a(Context context, eno eno, enp.O00000Oo o00000Oo, String str) {
        return new b(context, eno, o00000Oo, str);
    }

    public void a(eou.O000000o o000000o) {
    }

    static class b extends enp {
        protected b(Context context, eno eno, enp.O00000Oo o00000Oo, String str) {
            super(context, eno, o00000Oo, str);
        }

        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (erm.O000000o.f15749O000000o.f15748O000000o) {
                    str2 = bo.m191a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                ero.O000000o(fg.u.a(), 1, null, emf.O00000Oo(f361a) ? 1 : 0);
                throw e;
            }
        }
    }

    public void a(eov.O00000Oo o00000Oo) {
        enl b2;
        if (o00000Oo.f15685O000000o && o00000Oo.O00000Oo && System.currentTimeMillis() - this.f6522a > 3600000) {
            duv.O000000o("fetch bucket :" + o00000Oo.O00000Oo);
            this.f6522a = System.currentTimeMillis();
            enp a2 = enp.a();
            a2.m596a();
            a2.m599b();
            eqb a3 = this.f285a.m119a();
            if (a3 != null && (b2 = a2.b(a3.O00000o().c())) != null) {
                ArrayList<String> O00000Oo = b2.O00000Oo();
                boolean z = true;
                Iterator<String> it = O00000Oo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(a3.O00000oO())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !O00000Oo.isEmpty()) {
                    duv.O000000o("bucket changed, force reconnect");
                    this.f285a.a(0, (Exception) null);
                    this.f285a.a(false);
                }
            }
        }
    }
}

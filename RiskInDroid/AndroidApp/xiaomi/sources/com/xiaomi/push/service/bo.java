package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import _m_j.elr;
import _m_j.elx;
import _m_j.eou;
import _m_j.eov;
import _m_j.erc;
import _m_j.erv;
import _m_j.esu;
import android.content.SharedPreferences;
import com.xiaomi.push.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class bo {

    /* renamed from: a  reason: collision with root package name */
    private static bo f6530a = new bo();

    /* renamed from: a  reason: collision with other field name */
    private static String f293a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public elr.O00000Oo f294a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public eou.O000000o f295a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f296a = new ArrayList();

    public static abstract class a {
        public void a(eou.O000000o o000000o) {
        }

        public void a(eov.O00000Oo o00000Oo) {
        }
    }

    private bo() {
    }

    public static bo a() {
        return f6530a;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      _m_j.erv.O000000o(android.content.Context, java.lang.String):void
      _m_j.erv.O000000o(android.content.Context, java.util.Map<java.lang.String, java.lang.String>):void
      _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String */
    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m191a() {
        String str;
        synchronized (bo.class) {
            if (f293a == null) {
                SharedPreferences sharedPreferences = esu.O000000o().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f293a = string;
                if (string == null) {
                    String O000000o2 = erv.O000000o(esu.O000000o(), false);
                    f293a = O000000o2;
                    if (O000000o2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f293a).commit();
                    }
                }
            }
            str = f293a;
        }
        return str;
    }

    private void b() {
        if (this.f295a == null) {
            d();
        }
    }

    private void c() {
        if (this.f294a == null) {
            this.f294a = new bp(this);
            erc.O000000o(this.f294a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public eou.O000000o m193a() {
        b();
        return this.f295a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m194a() {
        this.f296a.clear();
    }

    public synchronized void a(a aVar) {
        this.f296a.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m192a() {
        b();
        eou.O000000o o000000o = this.f295a;
        if (o000000o != null) {
            return o000000o.f15683O000000o;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(eov.O00000Oo o00000Oo) {
        a[] aVarArr;
        if (o00000Oo.O00000o0 && o00000Oo.O00000o > m192a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f296a.toArray(new a[this.f296a.size()]);
        }
        for (a a2 : aVarArr) {
            a2.a(o00000Oo);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    private void d() {
        BufferedInputStream bufferedInputStream;
        Exception e;
        try {
            bufferedInputStream = new BufferedInputStream(esu.O000000o().openFileInput("XMCloudCfg"));
            try {
                this.f295a = eou.O000000o.O00000Oo(new elx(bufferedInputStream));
                bufferedInputStream.close();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
            try {
                duv.O000000o("load config failure: " + e.getMessage());
                ele.O000000o(bufferedInputStream);
                if (this.f295a != null) {
                }
            } catch (Throwable th) {
                th = th;
                ele.O000000o(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            bufferedInputStream = null;
            th = th2;
            ele.O000000o(bufferedInputStream);
            throw th;
        }
        ele.O000000o(bufferedInputStream);
        if (this.f295a != null) {
            this.f295a = new eou.O000000o();
        }
    }

    private void e() {
        try {
            if (this.f295a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(esu.O000000o().openFileOutput("XMCloudCfg", 0));
                c cVar = new c(bufferedOutputStream, new byte[4096]);
                this.f295a.O000000o(cVar);
                if (cVar.f6372O000000o != null) {
                    cVar.O000000o();
                }
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            duv.O000000o("save config failure: " + e.getMessage());
        }
    }
}

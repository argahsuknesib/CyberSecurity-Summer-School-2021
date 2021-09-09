package com.xiaomi.push.service;

import _m_j.duu;
import _m_j.duv;
import _m_j.duw;
import _m_j.elh;
import _m_j.elo;
import _m_j.elu;
import _m_j.emf;
import _m_j.emk;
import _m_j.emn;
import _m_j.enp;
import _m_j.eny;
import _m_j.eoe;
import _m_j.eox;
import _m_j.epb;
import _m_j.epc;
import _m_j.epi;
import _m_j.epj;
import _m_j.epp;
import _m_j.epq;
import _m_j.epx;
import _m_j.eqb;
import _m_j.eqc;
import _m_j.eqe;
import _m_j.eqg;
import _m_j.eqh;
import _m_j.eqp;
import _m_j.eqq;
import _m_j.eqr;
import _m_j.erf;
import _m_j.erm;
import _m_j.ero;
import _m_j.err;
import _m_j.eru;
import _m_j.erv;
import _m_j.esl;
import _m_j.esu;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.push.gg;
import com.xiaomi.push.go;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.jf;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements eqe {
    private static boolean b = false;

    /* renamed from: a  reason: collision with root package name */
    private int f6465a = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f192a = 0;

    /* renamed from: a  reason: collision with other field name */
    private epx f193a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public eqb f194a;

    /* renamed from: a  reason: collision with other field name */
    private eqc f195a;

    /* renamed from: a  reason: collision with other field name */
    private eqg f196a = new bz(this);

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f197a;

    /* renamed from: a  reason: collision with other field name */
    Messenger f198a = null;

    /* renamed from: a  reason: collision with other field name */
    private a f199a;

    /* renamed from: a  reason: collision with other field name */
    private f f200a;

    /* renamed from: a  reason: collision with other field name */
    private k f201a;

    /* renamed from: a  reason: collision with other field name */
    private r f202a;

    /* renamed from: a  reason: collision with other field name */
    private t f203a;

    /* renamed from: a  reason: collision with other field name */
    private ax f204a = null;

    /* renamed from: a  reason: collision with other field name */
    private bj f205a;

    /* renamed from: a  reason: collision with other field name */
    private f f206a;

    /* renamed from: a  reason: collision with other field name */
    private j f207a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Class f208a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private String f209a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<n> f210a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private Collection<al> f211a = Collections.synchronizedCollection(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f212a = false;

    /* renamed from: b  reason: collision with other field name */
    private int f213b = 0;

    /* renamed from: b  reason: collision with other field name */
    private ContentObserver f214b;

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f215a;

        private a() {
            this.f215a = new Object();
        }

        /* synthetic */ a(XMPushService xMPushService, bz bzVar) {
            this();
        }

        /* access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                duv.O00000o("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f215a) {
                try {
                    this.f215a.notifyAll();
                } catch (Exception e) {
                    duv.O000000o("[Alarm] notify lock. ".concat(String.valueOf(e)));
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                duv.O00000o("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f215a) {
                try {
                    this.f215a.wait(j);
                } catch (InterruptedException e) {
                    duv.O000000o("[Alarm] interrupt from waiting state. ".concat(String.valueOf(e)));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            duv.O00000o0("[Alarm] heartbeat alarm has been triggered.");
            if (!bd.o.equals(intent.getAction())) {
                duv.O000000o("[Alarm] cancel the old ping timer");
                epp.O000000o();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                duv.O00000o0("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000);
                    duv.O000000o("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    class b extends j {

        /* renamed from: a  reason: collision with other field name */
        az.b f216a = null;

        public b(az.b bVar) {
            super(9);
            this.f216a = bVar;
        }

        public String a() {
            return "bind the client. " + this.f216a.g;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
         arg types: [java.lang.String, java.lang.String]
         candidates:
          com.xiaomi.push.service.az.a(android.content.Context, int):void
          com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
          com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
        /* renamed from: a  reason: collision with other method in class */
        public void m129a() {
            try {
                if (!XMPushService.this.m127c()) {
                    duv.O00000o("trying bind while the connection is not created, quit!");
                    return;
                }
                az.b a2 = az.a().a(this.f216a.g, this.f216a.f277b);
                if (a2 == null) {
                    duv.O000000o("ignore bind because the channel " + this.f216a.g + " is removed ");
                } else if (a2.f272a == az.c.f6516a) {
                    a2.a(az.c.b, 0, 0, (String) null, (String) null);
                    XMPushService.a(XMPushService.this).O000000o(a2);
                    ero.O000000o(XMPushService.this, a2);
                } else {
                    duv.O000000o("trying duplicate bind, ingore! " + a2.f272a);
                }
            } catch (Exception e) {
                duv.O00000o("Meet error when trying to bind. ".concat(String.valueOf(e)));
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        private final az.b f6468a;

        public c(az.b bVar) {
            super(12);
            this.f6468a = bVar;
        }

        public String a() {
            return "bind time out. chid=" + this.f6468a.g;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m130a() {
            this.f6468a.a(az.c.f6516a, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).f6468a.g, this.f6468a.g);
        }

        public int hashCode() {
            return this.f6468a.g.hashCode();
        }
    }

    class d extends j {

        /* renamed from: a  reason: collision with root package name */
        private epq f6469a = null;

        public d(epq epq) {
            super(8);
            this.f6469a = epq;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m131a() {
            XMPushService.a(XMPushService.this).a(this.f6469a);
        }
    }

    public class e extends j {
        e() {
            super(1);
        }

        public String a() {
            return "do reconnect..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m132a() {
            if (XMPushService.this.m122a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.c(XMPushService.this);
                    return;
                }
            }
            duv.O000000o("should not connect. quit the job.");
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        public void onReceive(Context context, Intent intent) {
            duv.O000000o("network changed, " + esl.O000000o(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f218a;
        public int b;

        g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f218a = exc;
        }

        public String a() {
            return "disconnect the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m133a() {
            XMPushService.this.a(this.b, this.f218a);
        }
    }

    class h extends j {
        h() {
            super(65535);
        }

        public String a() {
            return "Init Job";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m134a() {
            XMPushService.b(XMPushService.this);
        }
    }

    class i extends j {

        /* renamed from: a  reason: collision with root package name */
        private Intent f6474a = null;

        public i(Intent intent) {
            super(15);
            this.f6474a = intent;
        }

        public String a() {
            return "Handle intent action = " + this.f6474a.getAction();
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m135a() {
            XMPushService.this.d(this.f6474a);
        }
    }

    public static abstract class j extends j.b {
        public j(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m136a();

        public void run() {
            if (!(this.f6563a == 4 || this.f6563a == 8)) {
                duv.O000000o(duu.f14958O000000o, a());
            }
            m136a();
        }
    }

    class k extends BroadcastReceiver {
        k() {
        }

        public void onReceive(Context context, Intent intent) {
            duv.O000000o("[HB] hold short heartbeat, " + esl.O000000o(intent));
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    class l extends j {
        public l() {
            super(5);
        }

        public String a() {
            return "ask the job queue to quit";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m137a() {
            XMPushService.a(XMPushService.this).m211a();
        }
    }

    class m extends j {

        /* renamed from: a  reason: collision with root package name */
        private eqr f6477a = null;

        public m(eqr eqr) {
            super(8);
            this.f6477a = eqr;
        }

        public String a() {
            return "receive a message.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m138a() {
            XMPushService.a(XMPushService.this).a(this.f6477a);
        }
    }

    public interface n {
        void a();
    }

    class o extends j {

        /* renamed from: a  reason: collision with other field name */
        boolean f221a;

        public o(boolean z) {
            super(4);
            this.f221a = z;
        }

        public String a() {
            return "send ping..";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m139a() {
            if (XMPushService.this.m127c()) {
                try {
                    if (!this.f221a) {
                        ero.O000000o();
                    }
                    XMPushService.a(XMPushService.this).O00000Oo(this.f221a);
                } catch (gg e) {
                    duv.O000000o(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    class p extends j {

        /* renamed from: a  reason: collision with other field name */
        az.b f222a = null;

        public p(az.b bVar) {
            super(4);
            this.f222a = bVar;
        }

        public String a() {
            return "rebind the client. " + this.f222a.g;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m140a() {
            try {
                this.f222a.a(az.c.f6516a, 1, 16, (String) null, (String) null);
                XMPushService.a(XMPushService.this).O000000o(this.f222a.g, this.f222a.f277b);
                XMPushService.this.a(new b(this.f222a), 300);
            } catch (gg e) {
                duv.O000000o(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    class q extends j {
        q() {
            super(3);
        }

        public String a() {
            return "reset the connection.";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m141a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m122a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.c(XMPushService.this);
                }
            }
        }
    }

    class r extends BroadcastReceiver {
        r() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    class s extends j {

        /* renamed from: a  reason: collision with other field name */
        az.b f223a = null;

        /* renamed from: a  reason: collision with other field name */
        String f224a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f225b;

        public s(az.b bVar, int i, String str, String str2) {
            super(9);
            this.f223a = bVar;
            this.b = i;
            this.f224a = str;
            this.f225b = str2;
        }

        public String a() {
            return "unbind the channel. " + this.f223a.g;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m142a() {
            if (!(this.f223a.f272a == az.c.f6516a || XMPushService.a(XMPushService.this) == null)) {
                try {
                    XMPushService.a(XMPushService.this).O000000o(this.f223a.g, this.f223a.f277b);
                } catch (gg e) {
                    duv.O000000o(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f223a.a(az.c.f6516a, this.b, 0, this.f225b, this.f224a);
        }
    }

    class t extends BroadcastReceiver {
        t() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean
         arg types: [com.xiaomi.push.service.XMPushService, int]
         candidates:
          com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, _m_j.eqb):_m_j.eqb
          com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):com.xiaomi.push.service.az$b
          com.xiaomi.push.service.XMPushService.a(android.content.Intent, int):void
          com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Intent):void
          com.xiaomi.push.service.XMPushService.a(java.lang.String, int):void
          com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Context):boolean
          com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):boolean
          com.xiaomi.push.service.XMPushService.a(int, java.lang.Exception):void
          com.xiaomi.push.service.XMPushService.a(_m_j.eqb, java.lang.Exception):void
          com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService$j, long):void
          com.xiaomi.push.service.XMPushService.a(byte[], java.lang.String):void
          _m_j.eqe.a(_m_j.eqb, java.lang.Exception):void
          com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean */
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.c(XMPushService.this)) {
                boolean unused = XMPushService.this.f212a = true;
            }
            duv.O000000o("[HB] wifi changed, " + esl.O000000o(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private az.b a(String str, Intent intent) {
        az.b a2 = az.a().a(str, intent.getStringExtra(bd.p));
        if (a2 == null) {
            a2 = new az.b(this);
        }
        a2.g = intent.getStringExtra(bd.s);
        a2.f277b = intent.getStringExtra(bd.p);
        a2.c = intent.getStringExtra(bd.u);
        a2.f274a = intent.getStringExtra(bd.A);
        a2.e = intent.getStringExtra(bd.y);
        a2.f = intent.getStringExtra(bd.z);
        a2.f276a = intent.getBooleanExtra(bd.x, false);
        a2.h = intent.getStringExtra(bd.w);
        a2.i = intent.getStringExtra(bd.E);
        a2.d = intent.getStringExtra(bd.v);
        a2.f273a = this.f206a;
        a2.a((Messenger) intent.getParcelableExtra(bd.I));
        a2.f266a = getApplicationContext();
        az.a().a(a2);
        return a2;
    }

    private String a() {
        String O000000o2 = esl.O000000o("ro.miui.region");
        return TextUtils.isEmpty(O000000o2) ? esl.O000000o("ro.product.locale.region") : O000000o2;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                duv.O000000o(e2);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            i.a(getApplicationContext()).m207a(extras.getString("digest"));
        }
    }

    private void a(a aVar) {
        if (aVar == null || !TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a())) {
            duv.O00000Oo("no need to check country code");
            return;
        }
        String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : esl.O00000oO();
        if (!TextUtils.isEmpty(a2)) {
            String name = esl.O00000Oo(a2).name();
            if (TextUtils.equals(name, aVar.a())) {
                aVar.b(a2);
                duv.O000000o("update country code");
                return;
            }
            duv.O000000o("not update country code, because not equals ".concat(String.valueOf(name)));
            return;
        }
        duv.O00000Oo("check no country code");
    }

    private static void a(String str) {
        if (com.xiaomi.push.r.f6460a.name().equals(str)) {
            enp.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            enp.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            enp.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            enp.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            enp.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            enp.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            enp.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        } else if (com.xiaomi.push.r.b.name().equals(str)) {
            enp.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
        } else if (com.xiaomi.push.r.c.name().equals(str)) {
            enp.a("fr.app.chat.global.xiaomi.net", "fr.app.chat.global.xiaomi.net");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
        } else if (com.xiaomi.push.r.d.name().equals(str)) {
            enp.a("ru.app.chat.global.xiaomi.net", "ru.app.chat.global.xiaomi.net");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
        } else if (com.xiaomi.push.r.e.name().equals(str)) {
            enp.a("ru.app.chat.global.xiaomi.net", "idmb.app.chat.global.xiaomi.net");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            enp.a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
        }
    }

    private void a(String str, int i2) {
        Collection<az.b> a2 = az.a().m177a(str);
        if (a2 != null) {
            for (az.b next : a2) {
                if (next != null) {
                    a(new s(next, i2, null, null));
                }
            }
        }
        az.a().m180a(str);
    }

    /* access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            elu.O000000o();
            for (int i2 = 100; i2 > 0; i2--) {
                if (emf.O00000Oo(context)) {
                    duv.O000000o("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* renamed from: a  reason: collision with other method in class */
    private boolean m112a(String str, Intent intent) {
        az.b a2 = az.a().a(str, intent.getStringExtra(bd.p));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bd.E);
        String stringExtra2 = intent.getStringExtra(bd.w);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            duv.O000000o("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        duv.O000000o("security changed. chid = " + str + " sechash = " + emk.O000000o(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m113a() {
        String[] split;
        String a2 = at.a(getApplicationContext()).a(hu.aN.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                    return null;
                }
                return iArr;
            } catch (NumberFormatException e2) {
                duv.O00000o("parse falldown time range failure: ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    private String b() {
        String str;
        elu.O000000o();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str2 = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bg a2 = bg.a(this);
            str = null;
            while (true) {
                if (!TextUtils.isEmpty(str) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = a();
                }
                try {
                    synchronized (obj) {
                        obj.wait(100);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            str = esl.O00000oO();
        }
        if (!TextUtils.isEmpty(str)) {
            a.a(getApplicationContext()).b(str);
            str2 = esl.O00000Oo(str).name();
        }
        duv.O000000o("wait region :" + str2 + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str2;
    }

    private void b(boolean z) {
        this.f192a = SystemClock.elapsedRealtime();
        if (!m127c()) {
            a(true);
        } else if (emf.O000000o(this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private void c() {
        String str;
        a a2 = a.a(getApplicationContext());
        String a3 = a2.a();
        duv.O000000o("region of cache is ".concat(String.valueOf(a3)));
        if (TextUtils.isEmpty(a3)) {
            a3 = b();
        } else {
            a(a2);
        }
        if (!TextUtils.isEmpty(a3)) {
            this.f209a = a3;
            a2.a(a3);
            if (com.xiaomi.push.r.b.name().equals(this.f209a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.r.c.name().equals(this.f209a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.r.d.name().equals(this.f209a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.r.e.name().equals(this.f209a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            eqc.a(str);
        } else {
            this.f209a = com.xiaomi.push.r.f6460a.name();
        }
        if (com.xiaomi.push.r.f6460a.name().equals(this.f209a)) {
            eqc.a("cn.app.chat.xiaomi.net");
        }
        a(this.f209a);
        if (m118i()) {
            cl clVar = new cl(this, 11);
            a(clVar);
            o.a(new cm(this, clVar));
        }
        try {
            if (esu.O00000o0()) {
                this.f206a.a(this);
            }
        } catch (Exception e2) {
            duv.O000000o(e2);
        }
    }

    private void c(j jVar) {
        this.f207a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (!esu.O00000o0()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (al a2 : (al[]) this.f211a.toArray(new al[0])) {
                    a2.a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e2) {
            duv.O000000o(e2);
        }
    }

    private void e() {
        if (!m122a()) {
            epp.O000000o();
        } else if (!epp.O00000Oo()) {
            epp.O000000o(true);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m114e() {
        return b;
    }

    private void f() {
        String str;
        eqb eqb = this.f194a;
        if (eqb == null || !eqb.O0000Oo0()) {
            eqb eqb2 = this.f194a;
            if (eqb2 == null || !eqb2.O0000Oo()) {
                this.f195a.b(emf.O0000Oo0(this));
                g();
                if (this.f194a == null) {
                    az.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        duv.O00000o(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m115f() {
        if (SystemClock.elapsedRealtime() - this.f192a < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            return false;
        }
        return emf.O00000o0(this);
    }

    private void g() {
        try {
            this.f193a.O000000o(this.f196a, new cd(this));
            this.f193a.O0000o0();
            this.f194a = this.f193a;
        } catch (gg e2) {
            duv.O000000o("fail to create Slim connection", e2);
            this.f193a.O00000Oo(3, e2);
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m116g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m117h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void i() {
        synchronized (this.f210a) {
            this.f210a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m118i() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !p.a(this).m226b(getPackageName());
    }

    private boolean j() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && k() && !erv.O0000Ooo(this) && !erv.O0000OoO(getApplicationContext());
    }

    private boolean k() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f6465a;
        int i3 = this.f213b;
        if (i2 <= i3) {
            return i2 < i3 && intValue >= i2 && intValue < i3;
        }
        if (intValue >= i2 || intValue < i3) {
            return true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    private boolean l() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return at.a(this).a(hu.H.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public eqb m119a() {
        return this.f194a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public f m120a() {
        return new f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m121a() {
        if (SystemClock.elapsedRealtime() - this.f192a >= ((long) eqh.O00000Oo()) && emf.O00000o0(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f207a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        eqb eqb = this.f194a;
        sb.append(eqb == null ? null : Integer.valueOf(eqb.hashCode()));
        duv.O000000o(sb.toString());
        eqb eqb2 = this.f194a;
        if (eqb2 != null) {
            eqb2.O00000Oo(i2, exc);
            this.f194a = null;
        }
        a(7);
        a(4);
        az.a().a(this, i2);
    }

    public void a(epq epq) {
        eqb eqb = this.f194a;
        if (eqb != null) {
            eqb.O00000Oo(epq);
            return;
        }
        throw new gg("try send msg while connection is null.");
    }

    public void a(eqb eqb) {
        duv.O00000o0("begin to connect...");
        erm.O000000o().a(eqb);
    }

    public void a(eqb eqb, int i2, Exception exc) {
        erm.O000000o().a(eqb, i2, exc);
        if (!j()) {
            a(false);
        }
    }

    public void a(eqb eqb, Exception exc) {
        erm.O000000o().a(eqb, exc);
        c(false);
        if (!j()) {
            a(false);
        }
    }

    public void a(j jVar) {
        a(jVar, 0);
    }

    public void a(j jVar, long j2) {
        try {
            this.f207a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            duv.O000000o("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.f210a) {
            this.f210a.add(nVar);
        }
    }

    public void a(az.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            duv.O000000o("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
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
    public void a(String str, String str2, int i2, String str3, String str4) {
        az.b a2 = az.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        az.a().m181a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<az.b> a2 = az.a().m177a("5");
        if (a2.isEmpty()) {
            if (z) {
                r.b(str, bArr);
            }
        } else if (a2.iterator().next().f272a == az.c.c) {
            a(new cb(this, 4, str, bArr));
        } else if (z) {
            r.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f205a.a(z);
    }

    public void a(epq[] epqArr) {
        eqb eqb = this.f194a;
        if (eqb != null) {
            eqb.O000000o(epqArr);
            return;
        }
        throw new gg("try send msg while connection is null.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m122a() {
        boolean O000000o2 = emf.O000000o(this);
        boolean z = az.a().m175a() > 0;
        boolean z2 = !m126b();
        boolean i2 = m118i();
        boolean z3 = !m117h();
        boolean z4 = !m116g();
        boolean z5 = O000000o2 && z && z2 && i2 && z3 && z4;
        if (!z5) {
            duv.O00000oo(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;!eps=%s", Boolean.valueOf(O000000o2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(i2), Boolean.valueOf(z3), Boolean.valueOf(z4)));
        }
        return z5;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m123a(int i2) {
        return this.f207a.m213a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public f m124b() {
        return this.f206a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m125b() {
        i.a(getApplicationContext()).m210d();
        Iterator it = new ArrayList(this.f210a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
    }

    public void b(j jVar) {
        this.f207a.a(jVar.f6563a, jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m126b() {
        try {
            Class<?> O000000o2 = esu.O000000o(this, "miui.os.Build");
            return O000000o2.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || O000000o2.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null) || O000000o2.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m127c() {
        eqb eqb = this.f194a;
        return eqb != null && eqb.O0000Oo();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m128d() {
        eqb eqb = this.f194a;
        return eqb != null && eqb.O0000Oo0();
    }

    public IBinder onBind(Intent intent) {
        return this.f198a.getBinder();
    }

    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            duv.O00000o("onStart() with intent NULL");
        } else {
            duv.O000000o(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bd.s), intent.getStringExtra(bd.A), intent.getStringExtra("mipush_app_package")));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f207a.m212a()) {
                    duv.O00000o("ERROR, the job controller is blocked.");
                    az.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                iVar = new i(intent);
            }
            a(iVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            duv.O00000o0("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }

    public void onCreate() {
        String[] split;
        super.onCreate();
        duv.O000000o(getApplicationContext());
        esu.O000000o(this);
        n a2 = o.m222a((Context) this);
        if (a2 != null) {
            elh.O000000o(a2.f6569a);
        }
        if (esl.O000000o(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f199a = new a(this, null);
            registerReceiver(this.f199a, new IntentFilter(bd.o), null, handler);
            b = true;
            handler.post(new cf(this));
        }
        this.f198a = new Messenger(new cg(this));
        be.a(this);
        this.f195a = new ch(this, null, 5222, "xiaomi.com", null);
        this.f195a.a(true);
        this.f193a = new epx(this, this.f195a);
        this.f206a = m120a();
        epp.O000000o(this);
        epx epx = this.f193a;
        if (!epx.O0000O0o.contains(this)) {
            epx.O0000O0o.add(this);
        }
        this.f204a = new ax(this);
        this.f205a = new bj(this);
        new g().a();
        erm.O000000o.f15749O000000o.O000000o(this);
        this.f207a = new j("Connection Controller Thread");
        az a3 = az.a();
        a3.b();
        a3.a(new ci(this));
        if (l()) {
            h();
        }
        err O000000o2 = err.O000000o(this);
        l lVar = new l(this);
        if (TextUtils.isEmpty("UPLOADER_PUSH_CHANNEL")) {
            duv.O00000o("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            O000000o2.O00000Oo.put("UPLOADER_PUSH_CHANNEL", lVar);
        }
        a(new hk(this));
        a(new bx(this));
        if (esl.O000000o(this)) {
            a(new ay());
        }
        a(new h());
        this.f211a.add(bq.a(this));
        if (m118i()) {
            this.f200a = new f();
            registerReceiver(this.f200a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (esl.O000000o(getApplicationContext())) {
            this.f203a = new t();
            registerReceiver(this.f203a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            this.f201a = new k();
            registerReceiver(this.f201a, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        i.a(getApplicationContext()).m206a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f197a = new cj(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f197a);
                } catch (Throwable th) {
                    duv.O000000o("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f214b = new ck(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f214b);
                } catch (Throwable th2) {
                    duv.O00000o("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] a4 = m113a();
            if (a4 != null) {
                this.f202a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f202a, intentFilter);
                this.f6465a = a4[0];
                this.f213b = a4[1];
                duv.O000000o("falldown initialized: " + this.f6465a + "," + this.f213b);
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.f341a) && (split = a2.f341a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        eny.O000000o(this);
        duv.O00000oo("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.O00000Oo(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            duv.O000000o(e2);
            networkInfo = null;
        }
        i.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder("network changed,");
            sb.append("[" + "type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            duv.O000000o(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            duv.O000000o("network changed, no active network");
        }
        if (erm.O000000o() != null) {
            erm.O000000o().O000000o();
        }
        erf.O000000o(this);
        epx epx = this.f193a;
        synchronized (epx.O00000oo) {
            epx.O00000oo.clear();
        }
        if (emf.O000000o(this)) {
            if (m127c() && m115f()) {
                b(false);
            }
            if (!m127c() && !m128d()) {
                this.f207a.a(1);
                a(new e());
            }
            eoe.O000000o(this).O000000o();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private void b(Intent intent) {
        long j2;
        String stringExtra = intent.getStringExtra(bd.A);
        String stringExtra2 = intent.getStringExtra(bd.E);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        az a2 = az.a();
        epq epq = null;
        if (bundleExtra != null) {
            eqq eqq = (eqq) a(new eqq(bundleExtra), stringExtra, stringExtra2);
            if (eqq != null) {
                epq = epq.O000000o(eqq, a2.a(eqq.O0000oOO, eqq.O0000oO).h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bd.p));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bd.q);
                String stringExtra4 = intent.getStringExtra(bd.r);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                az.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    epq epq2 = new epq();
                    try {
                        epq2.O000000o(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    epq2.O000000o("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    epq2.O000000o(j2, stringExtra3, stringExtra4);
                    epq2.O000000o(intent.getStringExtra("ext_pkt_id"));
                    epq2.O000000o(byteArrayExtra, a3.h);
                    duv.O000000o("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    epq = epq2;
                }
            }
        }
        if (epq != null) {
            c(new bm(this, epq));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bd.A);
        String stringExtra2 = intent.getStringExtra(bd.E);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        eqq[] eqqArr = new eqq[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i2 = 0;
        while (i2 < parcelableArrayExtra.length) {
            eqqArr[i2] = new eqq((Bundle) parcelableArrayExtra[i2]);
            eqqArr[i2] = (eqq) a(eqqArr[i2], stringExtra, stringExtra2);
            if (eqqArr[i2] != null) {
                i2++;
            } else {
                return;
            }
        }
        az a2 = az.a();
        epq[] epqArr = new epq[eqqArr.length];
        for (int i3 = 0; i3 < eqqArr.length; i3++) {
            eqq eqq = eqqArr[i3];
            epqArr[i3] = epq.O000000o(eqq, a2.a(eqq.O0000oOO, eqq.O0000oO).h);
        }
        c(new c(this, epqArr));
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v51, resolved type: com.xiaomi.push.service.az$b} */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
     arg types: [com.xiaomi.push.service.XMPushService, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
     arg types: [com.xiaomi.push.service.XMPushService, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):void
     arg types: [com.xiaomi.push.service.XMPushService, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, int):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, int):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.util.LinkedList<? extends java.lang.Object>):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.a(java.lang.String, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.ic):java.lang.String[]
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):void
     arg types: [com.xiaomi.push.service.XMPushService, java.lang.String]
     candidates:
      com.xiaomi.push.service.an.a(java.lang.String, android.app.NotificationChannel):android.app.NotificationChannel
      com.xiaomi.push.service.an.a(android.content.Context, java.util.List<java.lang.String>):void
      com.xiaomi.push.service.an.a(com.xiaomi.push.service.ar, android.app.NotificationChannel):void
      com.xiaomi.push.service.an.a(android.app.NotificationChannel, android.app.NotificationChannel):boolean
      com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):boolean
     arg types: [java.lang.String, android.content.Intent]
     candidates:
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, _m_j.eqb):_m_j.eqb
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):com.xiaomi.push.service.az$b
      com.xiaomi.push.service.XMPushService.a(android.content.Intent, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Intent):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Context):boolean
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean
      com.xiaomi.push.service.XMPushService.a(int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService$j, long):void
      com.xiaomi.push.service.XMPushService.a(byte[], java.lang.String):void
      _m_j.eqe.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, android.content.Intent]
     candidates:
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, _m_j.eqb):_m_j.eqb
      com.xiaomi.push.service.XMPushService.a(android.content.Intent, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Intent):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, int):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, android.content.Context):boolean
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService, boolean):boolean
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):boolean
      com.xiaomi.push.service.XMPushService.a(int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService$j, long):void
      com.xiaomi.push.service.XMPushService.a(byte[], java.lang.String):void
      _m_j.eqe.a(_m_j.eqb, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, android.content.Intent):com.xiaomi.push.service.az$b */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:373:? A[RETURN, SYNTHETIC] */
    public void d(Intent intent) {
        int i2;
        int i3;
        String str;
        SharedPreferences sharedPreferences;
        az a2 = az.a();
        boolean z = true;
        if (bd.d.equalsIgnoreCase(intent.getAction()) || bd.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(bd.s);
            if (TextUtils.isEmpty(intent.getStringExtra(bd.w))) {
                duv.O000000o("security is empty. ignore.");
            } else if (!TextUtils.isEmpty(stringExtra)) {
                boolean a3 = m112a(stringExtra, intent);
                az.b a4 = a(stringExtra, intent);
                if (!emf.O00000Oo(this)) {
                    this.f206a.a(this, a4, false, 2, null);
                } else if (!m127c()) {
                    a(true);
                } else if (a4.f272a == az.c.f6516a) {
                    c(new b(a4));
                } else if (a3) {
                    c(new p(a4));
                } else if (a4.f272a == az.c.b) {
                    duv.O000000o(String.format("the client is binding. %1$s %2$s.", a4.g, az.b.a(a4.f277b)));
                } else if (a4.f272a == az.c.c) {
                    this.f206a.a(this, a4, true, 0, null);
                }
            } else {
                duv.O00000o("channel id is empty, do nothing!");
            }
        } else if (bd.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(bd.A);
            String stringExtra3 = intent.getStringExtra(bd.s);
            String stringExtra4 = intent.getStringExtra(bd.p);
            duv.O000000o("Service called close channel chid = " + stringExtra3 + " res = " + az.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String a5 : a2.m178a(stringExtra2)) {
                    a(a5, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (bd.e.equalsIgnoreCase(intent.getAction())) {
            b(intent);
        } else if (bd.g.equalsIgnoreCase(intent.getAction())) {
            c(intent);
        } else if (bd.f.equalsIgnoreCase(intent.getAction())) {
            eqr a6 = a(new eqp(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bd.A), intent.getStringExtra(bd.E));
            if (a6 != null) {
                c(new bm(this, epq.O000000o(a6, a2.a(a6.O0000oOO, a6.O0000oO).h)));
            }
        } else if (bd.h.equalsIgnoreCase(intent.getAction())) {
            eqr a7 = a(new go(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bd.A), intent.getStringExtra(bd.E));
            if (a7 != null) {
                c(new bm(this, epq.O000000o(a7, a2.a(a7.O0000oOO, a7.O0000oO).h)));
            }
        } else if (bd.k.equals(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(bd.s);
            String stringExtra6 = intent.getStringExtra(bd.p);
            if (stringExtra5 != null) {
                duv.O000000o("request reset connection from chid = ".concat(String.valueOf(stringExtra5)));
                az.b a8 = az.a().a(stringExtra5, stringExtra6);
                if (a8 != null && a8.h.equals(intent.getStringExtra(bd.w)) && a8.f272a == az.c.c) {
                    eqb a9 = m119a();
                    if (a9 == null || !a9.O000000o(SystemClock.elapsedRealtime() - 15000)) {
                        c(new q());
                    }
                }
            }
        } else {
            ? r2 = 0;
            if (bd.l.equals(intent.getAction())) {
                String stringExtra7 = intent.getStringExtra(bd.A);
                List<String> a10 = a2.m178a(stringExtra7);
                if (a10.isEmpty()) {
                    duv.O000000o("open channel should be called first before update info, pkg=".concat(String.valueOf(stringExtra7)));
                    return;
                }
                String stringExtra8 = intent.getStringExtra(bd.s);
                String stringExtra9 = intent.getStringExtra(bd.p);
                if (TextUtils.isEmpty(stringExtra8)) {
                    stringExtra8 = a10.get(0);
                }
                if (TextUtils.isEmpty(stringExtra9)) {
                    Collection<az.b> a11 = a2.m177a(stringExtra8);
                    if (a11 != null && !a11.isEmpty()) {
                        r2 = a11.iterator().next();
                    }
                } else {
                    r2 = a2.a(stringExtra8, stringExtra9);
                }
                if (r2 != 0) {
                    if (intent.hasExtra(bd.y)) {
                        r2.e = intent.getStringExtra(bd.y);
                    }
                    if (intent.hasExtra(bd.z)) {
                        r2.f = intent.getStringExtra(bd.z);
                    }
                }
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                    if (!j()) {
                        duv.O000000o("exit falldown mode, activate alarm.");
                        e();
                        if (!m127c() && !m128d()) {
                            a(true);
                        }
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && j() && epp.O00000Oo()) {
                    duv.O000000o("enter falldown mode, stop alarm.");
                    epp.O000000o();
                }
            } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                if (!bg.a(getApplicationContext()).m187a() || bg.a(getApplicationContext()).a() != 0) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra10 = intent.getStringExtra("mipush_app_package");
                    boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                    int intExtra = intent.getIntExtra("mipush_env_type", 1);
                    p.a(this).d(stringExtra10);
                    if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                        a(byteArrayExtra, stringExtra10);
                    } else {
                        c(new ca(this, 14, intExtra, byteArrayExtra, stringExtra10));
                    }
                } else {
                    duv.O000000o("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                }
            } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                String stringExtra11 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    p.a(this).a(stringExtra11);
                    if (esl.O000000o(getApplicationContext())) {
                        aa.a(stringExtra11);
                    }
                }
                a(stringExtra11, byteArrayExtra2, booleanExtra2);
            } else if (bh.f6524a.equals(intent.getAction())) {
                String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
                if (stringExtra12 != null && !TextUtils.isEmpty(stringExtra12.trim())) {
                    try {
                        PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra12, 0);
                        if (packageInfo == null || packageInfo.applicationInfo == null || !erv.O000000o(packageInfo.applicationInfo.uid)) {
                            z = false;
                        } else {
                            duv.O000000o("xspace's app fake uninstalled ".concat(String.valueOf(stringExtra12)));
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (!"com.xiaomi.channel".equals(stringExtra12) || az.a().m177a("1").isEmpty() || !z) {
                        SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                        String string = sharedPreferences2.getString(stringExtra12, null);
                        if (!TextUtils.isEmpty(string) && z) {
                            SharedPreferences.Editor edit = sharedPreferences2.edit();
                            edit.remove(stringExtra12);
                            edit.commit();
                            if (af.m152b((Context) this, stringExtra12)) {
                                af.m151b((Context) this, stringExtra12);
                            }
                            af.m147a((Context) this, stringExtra12);
                            if (m127c() && string != null) {
                                try {
                                    ab.a(this, ab.a(stringExtra12, string));
                                    duv.O000000o("uninstall " + stringExtra12 + " msg sent");
                                } catch (gg e2) {
                                    duv.O00000o("Fail to send Message: " + e2.getMessage());
                                    a(10, e2);
                                }
                            }
                        }
                    } else {
                        a("1", 0);
                        duv.O000000o("close the miliao channel as the app is uninstalled.");
                    }
                }
            } else if (bh.b.equals(intent.getAction())) {
                String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
                if (!TextUtils.isEmpty(stringExtra13)) {
                    try {
                        sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                        if (sharedPreferences != null) {
                            try {
                                r2 = sharedPreferences.getString(stringExtra13, null);
                            } catch (Throwable th) {
                                th = th;
                                duv.O000000o("Fail to get sp or appId : ".concat(String.valueOf(th)));
                                if (!TextUtils.isEmpty(r2)) {
                                }
                                an.a((Context) this, stringExtra13);
                                if (esl.O000000o(getApplicationContext())) {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sharedPreferences = null;
                        duv.O000000o("Fail to get sp or appId : ".concat(String.valueOf(th)));
                        if (!TextUtils.isEmpty(r2)) {
                        }
                        an.a((Context) this, stringExtra13);
                        if (esl.O000000o(getApplicationContext())) {
                        }
                    }
                    if (!TextUtils.isEmpty(r2)) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.remove(stringExtra13);
                        edit2.commit();
                        if (af.m152b((Context) this, stringExtra13)) {
                            af.m151b((Context) this, stringExtra13);
                        }
                        af.m147a((Context) this, stringExtra13);
                        if (m127c()) {
                            try {
                                ab.a(this, ab.b(stringExtra13, r2));
                                duv.O000000o("send app data cleared Message pkgName is : ".concat(String.valueOf(stringExtra13)));
                            } catch (gg e3) {
                                duv.O00000o("Fail to send Message: ".concat(String.valueOf(e3)));
                                a(10, e3);
                            }
                        }
                    }
                    an.a((Context) this, stringExtra13);
                    if (esl.O000000o(getApplicationContext())) {
                        aa.a(stringExtra13);
                    }
                }
            } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                String stringExtra14 = intent.getStringExtra(bd.A);
                int intExtra2 = intent.getIntExtra(bd.B, -2);
                if (TextUtils.isEmpty(stringExtra14)) {
                    return;
                }
                if (intExtra2 >= -1) {
                    af.a(this, stringExtra14, intExtra2, intent.getIntExtra(bd.C, -1));
                } else {
                    af.a(this, stringExtra14, intent.getStringExtra(bd.G), intent.getStringExtra(bd.H));
                }
            } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                String stringExtra15 = intent.getStringExtra(bd.A);
                String stringExtra16 = intent.getStringExtra(bd.F);
                if (intent.hasExtra(bd.D)) {
                    i3 = intent.getIntExtra(bd.D, 0);
                    str = emk.O00000Oo(stringExtra15 + i3);
                    z = false;
                } else {
                    str = emk.O00000Oo(stringExtra15);
                    i3 = 0;
                }
                if (TextUtils.isEmpty(stringExtra15) || !TextUtils.equals(stringExtra16, str)) {
                    duv.O00000o("invalid notification for ".concat(String.valueOf(stringExtra15)));
                } else if (z) {
                    af.m151b((Context) this, stringExtra15);
                } else {
                    af.b(this, stringExtra15, i3);
                }
            } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                String stringExtra17 = intent.getStringExtra("mipush_app_package");
                if (!TextUtils.isEmpty(stringExtra17)) {
                    p.a(this).b(stringExtra17);
                }
                if (!"com.xiaomi.xmsf".equals(getPackageName())) {
                    a(19, (Exception) null);
                    e();
                    stopSelf();
                }
            } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                String stringExtra18 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                String stringExtra19 = intent.getStringExtra("mipush_app_id");
                String stringExtra20 = intent.getStringExtra("mipush_app_token");
                if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                    p.a(this).c(stringExtra18);
                }
                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                    p.a(this).e(stringExtra18);
                    p.a(this).f(stringExtra18);
                }
                if (byteArrayExtra3 == null) {
                    r.a(this, stringExtra18, byteArrayExtra3, 70000003, "null payload");
                    return;
                }
                r.b(stringExtra18, byteArrayExtra3);
                a(new q(this, stringExtra18, stringExtra19, stringExtra20, byteArrayExtra3));
                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f200a == null) {
                    this.f200a = new f();
                    registerReceiver(this.f200a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                String stringExtra21 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                ht htVar = new ht();
                try {
                    eru.O000000o(htVar, byteArrayExtra4);
                    err.O000000o(this).O000000o(htVar, stringExtra21);
                } catch (jf e4) {
                    duv.O000000o(e4);
                }
            } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                duv.O000000o("[Alarm] Service called on timer");
                if (!j()) {
                    epp.O000000o(false);
                    if (m115f()) {
                        b(false);
                    }
                } else if (epp.O00000Oo()) {
                    duv.O000000o("enter falldown mode, stop alarm");
                    epp.O000000o();
                }
                a aVar = this.f199a;
                if (aVar != null) {
                    aVar.a();
                }
            } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                duv.O000000o("Service called on check alive.");
                if (m115f()) {
                    b(false);
                }
            } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                duv.O000000o("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                epp.O000000o(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                d();
            } else if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                a(intent);
            } else if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                if (intent.getExtras() != null && (i2 = intent.getExtras().getInt("effectivePeriod", 0)) > 0 && i2 <= 604800) {
                    i.a(getApplicationContext()).a(i2);
                }
            } else if ("action_cr_config".equals(intent.getAction())) {
                boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400);
                boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400);
                boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576);
                duw.O000000o O00000Oo = new duw.O000000o().O00000Oo(booleanExtra3);
                O00000Oo.O00000oo = longExtra;
                duw.O000000o O00000o0 = O00000Oo.O00000o0(booleanExtra4);
                O00000o0.O0000O0o = longExtra2;
                O00000o0.O00000o = emn.O000000o(getApplicationContext());
                duw.O000000o O000000o2 = O00000o0.O000000o(booleanExtra5);
                O000000o2.O00000oO = longExtra3;
                duw O000000o3 = O000000o2.O000000o(getApplicationContext());
                if (!"com.xiaomi.xmsf".equals(getPackageName()) && longExtra > 0 && longExtra2 > 0 && longExtra3 > 0) {
                    epi.O000000o(getApplicationContext(), O000000o3);
                }
            } else if ("action_help_ping".equals(intent.getAction())) {
                boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                int intExtra3 = intent.getIntExtra("extra_help_ping_frequency", 0);
                if (intExtra3 >= 0 && intExtra3 < 30) {
                    duv.O00000o0("aw_ping: frquency need > 30s.");
                    intExtra3 = 30;
                }
                if (intExtra3 < 0) {
                    booleanExtra6 = false;
                }
                duv.O000000o("aw_ping: receive a aw_ping message. switch: " + booleanExtra6 + " frequency: " + intExtra3);
                if (booleanExtra6 && intExtra3 > 0 && !"com.xiaomi.xmsf".equals(getPackageName())) {
                    a(intent, intExtra3);
                }
            } else if ("action_aw_app_logic".equals(intent.getAction())) {
                e(intent);
            }
        }
    }

    private void e(Intent intent) {
        int i2;
        try {
            epb.O000000o(getApplicationContext()).O00000oO = new bf();
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra != null) {
                io ioVar = new io();
                eru.O000000o(ioVar, byteArrayExtra);
                String str = ioVar.c;
                Map<String, String> map = ioVar.f133a;
                if (map != null) {
                    String str2 = map.get("extra_help_aw_info");
                    String str3 = map.get("extra_aw_app_online_cmd");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            i2 = Integer.parseInt(str3);
                        } catch (NumberFormatException unused) {
                            i2 = 0;
                        }
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            epb O000000o2 = epb.O000000o(getApplicationContext());
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(stringExtra)) {
                                if (!TextUtils.isEmpty(str)) {
                                    O000000o2.O00000o = i2;
                                    elo.O000000o(O000000o2.f15698O000000o).O000000o(new epc(O000000o2, str2, this, stringExtra, str), 0);
                                    return;
                                }
                            }
                            eox.O000000o(this, String.valueOf(str2), 1008, "A receive a incorrect message");
                        }
                    }
                }
            }
        } catch (jf e2) {
            duv.O00000o("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        io ioVar = new io();
        try {
            eru.O000000o(ioVar, byteArrayExtra);
            elo.O000000o(getApplicationContext()).O000000o(new b(ioVar, new WeakReference(this), booleanExtra), i2, 0);
        } catch (jf unused) {
            duv.O00000o("aw_ping : send help app ping  error");
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            r.a(this, str, bArr, 70000003, "null payload");
            duv.O000000o("register request without payload");
            return;
        }
        il ilVar = new il();
        try {
            eru.O000000o(ilVar, bArr);
            if (ilVar.f6426a == hp.f6389a) {
                ip ipVar = new ip();
                try {
                    eru.O000000o(ipVar, ilVar.O000000o());
                    r.a(ilVar.b, bArr);
                    a(new q(this, ilVar.b, ipVar.f146c, ipVar.f, bArr));
                    epj.O000000o(getApplicationContext()).O000000o(ilVar.b, "E100003", ipVar.f144b, 6002, null);
                } catch (jf e2) {
                    duv.O00000o("app register error. ".concat(String.valueOf(e2)));
                    r.a(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                r.a(this, str, bArr, 70000003, " registration action required.");
                duv.O000000o("register request with invalid payload");
            }
        } catch (jf e3) {
            duv.O00000o("app register fail. ".concat(String.valueOf(e3)));
            r.a(this, str, bArr, 70000003, " data container error.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    private eqr a(eqr eqr, String str, String str2) {
        String valueOf;
        String str3;
        az a2 = az.a();
        List<String> a3 = a2.m178a(str);
        if (a3.isEmpty()) {
            duv.O000000o("open channel should be called first before sending a packet, pkg=".concat(String.valueOf(str)));
            return null;
        }
        eqr.O0000oOo = str;
        String str4 = eqr.O0000oOO;
        if (TextUtils.isEmpty(str4)) {
            str4 = a3.get(0);
            eqr.O0000oOO = str4;
        }
        az.b a4 = a2.a(str4, eqr.O0000oO);
        if (!m127c()) {
            valueOf = String.valueOf(str4);
            str3 = "drop a packet as the channel is not connected, chid=";
        } else if (a4 == null || a4.f272a != az.c.c) {
            valueOf = String.valueOf(str4);
            str3 = "drop a packet as the channel is not opened, chid=";
        } else if (TextUtils.equals(str2, a4.i)) {
            return eqr;
        } else {
            valueOf = String.valueOf(str2);
            str3 = "invalid session. ";
        }
        duv.O000000o(str3.concat(valueOf));
        return null;
    }

    public void onDestroy() {
        f fVar = this.f200a;
        if (fVar != null) {
            a(fVar);
            this.f200a = null;
        }
        t tVar = this.f203a;
        if (tVar != null) {
            a(tVar);
            this.f203a = null;
        }
        k kVar = this.f201a;
        if (kVar != null) {
            a(kVar);
            this.f201a = null;
        }
        r rVar = this.f202a;
        if (rVar != null) {
            a(rVar);
            this.f202a = null;
        }
        a aVar = this.f199a;
        if (aVar != null) {
            a(aVar);
            this.f199a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f197a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f197a);
            } catch (Throwable th) {
                duv.O000000o("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f214b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f214b);
            } catch (Throwable th2) {
                duv.O00000o("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f211a.clear();
        this.f207a.m214b();
        a(new cc(this, 2));
        a(new l());
        az.a().b();
        az.a().a(this, 15);
        az.a().m179a();
        this.f193a.O0000O0o.remove(this);
        bo.a().m194a();
        epp.O000000o();
        i();
        super.onDestroy();
        duv.O000000o("Service destroyed");
    }

    public void b(eqb eqb) {
        erm.O000000o().b(eqb);
        c(true);
        this.f205a.m189a();
        if (!epp.O00000Oo() && !j()) {
            duv.O000000o("reconnection successful, reactivate alarm.");
            epp.O000000o(true);
        }
        Iterator<az.b> it = az.a().m176a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (!this.f212a && esl.O000000o(getApplicationContext())) {
            elo.O000000o(getApplicationContext()).O000000o(new ce(this), 0);
        }
    }
}

package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class az {

    /* renamed from: a  reason: collision with root package name */
    private static az f6512a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f264a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f265a = new ConcurrentHashMap<>();

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f6513a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Context f266a;

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f267a = null;

        /* renamed from: a  reason: collision with other field name */
        Messenger f268a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.c f269a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f270a;

        /* renamed from: a  reason: collision with other field name */
        final C0061b f271a = new C0061b();

        /* renamed from: a  reason: collision with other field name */
        c f272a = c.f6516a;

        /* renamed from: a  reason: collision with other field name */
        public f f273a;

        /* renamed from: a  reason: collision with other field name */
        public String f274a;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f275a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        public boolean f276a;
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        public String f277b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f278b = false;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.az$b$b  reason: collision with other inner class name */
        class C0061b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            String f279a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f280b;
            int c;

            public C0061b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f280b = str2;
                this.f279a = str;
                return this;
            }

            public String a() {
                return "notify job";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m183a() {
                if (b.this.a(this.b, this.c, this.f280b)) {
                    b.this.a(this.b, this.c, this.f279a, this.f280b);
                    return;
                }
                duv.O00000Oo(" ignore notify client :" + b.this.g);
            }
        }

        class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f6515a;

            /* renamed from: a  reason: collision with other field name */
            final b f281a;

            c(b bVar, Messenger messenger) {
                this.f281a = bVar;
                this.f6515a = messenger;
            }

            public void binderDied() {
                duv.O00000Oo("peer died, chid = " + this.f281a.g);
                b.a(b.this).a(new bb(this, 0), 0);
                if ("9".equals(this.f281a.g) && "com.xiaomi.xmsf".equals(b.a(b.this).getPackageName())) {
                    b.a(b.this).a(new bc(this, 0), 60000);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f270a = xMPushService;
            a(new ba(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) != -1) ? str.substring(lastIndexOf + 1) : "";
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f272a;
            this.b = cVar;
            if (i2 == 2) {
                this.f273a.a(this.f266a, this, i3);
            } else if (i2 == 3) {
                this.f273a.a(this.f266a, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.c;
                if (!z && "wait".equals(str2)) {
                    this.f6513a++;
                } else if (z) {
                    this.f6513a = 0;
                    if (this.f268a != null) {
                        try {
                            this.f268a.send(Message.obtain(null, 16, this.f270a.f198a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f273a.a(this.f270a, this, z, i3, str);
            }
        }

        /* access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            c cVar = this.b;
            if (cVar == null || !(z = this.f278b)) {
                return true;
            }
            if (cVar == this.f272a) {
                sb = new StringBuilder(" status recovered, don't notify client:");
            } else if (this.f268a == null || !z) {
                sb = new StringBuilder("peer died, ignore notify ");
            } else {
                duv.O00000Oo("Peer alive notify status to client:" + this.g);
                return true;
            }
            sb.append(this.g);
            duv.O00000Oo(sb.toString());
            return false;
        }

        private boolean b(int i2, int i3, String str) {
            return i2 != 1 ? i2 != 2 ? i2 == 3 && !"wait".equals(str) : this.f270a.m127c() : this.f272a != c.c && this.f270a.m127c() && i3 != 21 && (i3 != 7 || !"wait".equals(str));
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f6513a + 1) * 15))) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a  reason: collision with other method in class */
        public void m182a() {
            try {
                Messenger messenger = this.f268a;
                if (!(messenger == null || this.f267a == null)) {
                    messenger.getBinder().unlinkToDeath(this.f267a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m182a();
            if (messenger != null) {
                try {
                    this.f268a = messenger;
                    this.f278b = true;
                    this.f267a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f267a, 0);
                } catch (Exception e2) {
                    duv.O00000Oo("peer linkToDeath err: " + e2.getMessage());
                    this.f268a = null;
                    this.f278b = false;
                }
            } else {
                duv.O00000Oo("peer linked with old sdk chid = " + this.g);
            }
        }

        public void a(a aVar) {
            synchronized (this.f275a) {
                this.f275a.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.f275a) {
                for (a a2 : this.f275a) {
                    a2.a(this.f272a, cVar, i3);
                }
            }
            c cVar2 = this.f272a;
            int i4 = 0;
            if (cVar2 != cVar) {
                duv.O000000o(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), bd.a(i3), str, str2, this.g));
                this.f272a = cVar;
            }
            if (this.f273a == null) {
                duv.O00000o("status changed while the client dispatcher is missing");
            } else if (cVar != c.b) {
                if (this.b != null && (z = this.f278b)) {
                    i4 = (this.f268a == null || !z) ? 10100 : 1000;
                }
                this.f270a.b(this.f271a);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.f270a.a(this.f271a.a(i2, i3, str, str2), (long) i4);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f275a) {
                this.f275a.remove(aVar);
            }
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class c extends Enum<c> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f6516a = new c("unbind", 0);

        /* renamed from: a  reason: collision with other field name */
        private static final /* synthetic */ c[] f282a = a();
        public static final c b = new c("binding", 1);
        public static final c c = new c("binded", 2);

        private c(String str, int i) {
        }

        private static /* synthetic */ c[] a() {
            return new c[]{f6516a, b, c};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f282a.clone();
        }
    }

    private az() {
    }

    public static synchronized az a() {
        az azVar;
        synchronized (az.class) {
            if (f6512a == null) {
                f6512a = new az();
            }
            azVar = f6512a;
        }
        return azVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m175a() {
        return this.f265a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap hashMap = this.f265a.get(str);
        if (hashMap == null) {
            return null;
        }
        return (b) hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m176a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> values : this.f265a.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m177a(String str) {
        if (!this.f265a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f265a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m178a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> values : this.f265a.values()) {
            for (b bVar : values.values()) {
                if (str.equals(bVar.f274a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m179a() {
        Iterator<b> it = m176a().iterator();
        while (it.hasNext()) {
            it.next().m182a();
        }
        this.f265a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> values : this.f265a.values()) {
            for (b a2 : values.values()) {
                a2.a(c.f6516a, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> values : this.f265a.values()) {
            for (b a2 : values.values()) {
                a2.a(c.f6516a, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f264a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap hashMap = this.f265a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f265a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f277b), bVar);
        for (a a2 : this.f264a) {
            a2.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m180a(String str) {
        HashMap hashMap = this.f265a.get(str);
        if (hashMap != null) {
            for (b a2 : hashMap.values()) {
                a2.m182a();
            }
            hashMap.clear();
            this.f265a.remove(str);
        }
        for (a a3 : this.f264a) {
            a3.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m181a(String str, String str2) {
        HashMap hashMap = this.f265a.get(str);
        if (hashMap != null) {
            b bVar = (b) hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m182a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f265a.remove(str);
            }
        }
        for (a a2 : this.f264a) {
            a2.a();
        }
    }

    public synchronized void b() {
        this.f264a.clear();
    }
}

package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.packet.impl.e;
import com.alipay.sdk.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

public class a {

    static final class c {
        c() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        static synchronized long a(Context context) {
            long j;
            synchronized (c.class) {
                long j2 = 0;
                String b = h.b(null, context, "alipay_cashier_statistic_v", null);
                if (!TextUtils.isEmpty(b)) {
                    j2 = Long.parseLong(b);
                }
                j = j2 + 1;
                try {
                    h.a(null, context, "alipay_cashier_statistic_v", Long.toString(j));
                } catch (Throwable unused) {
                }
            }
            return j;
        }
    }

    /* renamed from: com.alipay.sdk.app.statistic.a$a  reason: collision with other inner class name */
    static final class C0015a {
        private C0015a() {
        }

        static synchronized String a(Context context, String str, String str2) {
            synchronized (C0015a.class) {
                com.alipay.sdk.util.c.a("RecordPref", "stat append " + str2 + " , " + str);
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C0016a b = b(context);
                        if (b.f3183a.size() > 20) {
                            b.f3183a.clear();
                        }
                        b.f3183a.put(str2, str);
                        a(context, b);
                        return str2;
                    }
                }
                return null;
            }
        }

        static synchronized String a(Context context) {
            synchronized (C0015a.class) {
                com.alipay.sdk.util.c.a("RecordPref", "stat peek");
                if (context == null) {
                    return null;
                }
                C0016a b = b(context);
                if (b.f3183a.isEmpty()) {
                    return null;
                }
                try {
                    String str = (String) b.f3183a.entrySet().iterator().next().getValue();
                    return str;
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return null;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
            return 0;
         */
        static synchronized int a(Context context, String str) {
            synchronized (C0015a.class) {
                com.alipay.sdk.util.c.a("RecordPref", "stat remove ".concat(String.valueOf(str)));
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0016a b = b(context);
                        if (b.f3183a.isEmpty()) {
                            return 0;
                        }
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (Map.Entry next : b.f3183a.entrySet()) {
                                if (str.equals(next.getValue())) {
                                    arrayList.add(next.getKey());
                                }
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                b.f3183a.remove((String) it.next());
                            }
                            a(context, b);
                            int size = arrayList.size();
                            return size;
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                            int size2 = b.f3183a.size();
                            a(context, new C0016a());
                            return size2;
                        }
                    }
                }
            }
        }

        private static synchronized C0016a b(Context context) {
            synchronized (C0015a.class) {
                try {
                    String b = h.b(null, context, "alipay_cashier_statistic_record", null);
                    if (TextUtils.isEmpty(b)) {
                        C0016a aVar = new C0016a();
                        return aVar;
                    }
                    C0016a aVar2 = new C0016a(b);
                    return aVar2;
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return new C0016a();
                }
            }
        }

        private static synchronized void a(Context context, C0016a aVar) {
            synchronized (C0015a.class) {
                if (aVar == null) {
                    try {
                        aVar = new C0016a();
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        return;
                    }
                }
                h.a(null, context, "alipay_cashier_statistic_record", aVar.a());
            }
        }

        /* renamed from: com.alipay.sdk.app.statistic.a$a$a  reason: collision with other inner class name */
        static final class C0016a {

            /* renamed from: a  reason: collision with root package name */
            final LinkedHashMap<String, String> f3183a = new LinkedHashMap<>();

            C0016a() {
            }

            C0016a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.f3183a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }

            /* access modifiers changed from: package-private */
            public final String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next : this.f3183a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(next.getKey()).put(next.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return new JSONArray().toString();
                }
            }
        }
    }

    static final class b {
        private b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
            return;
         */
        static synchronized void a(Context context, b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context != null && bVar != null && str != null) {
                    a(context, bVar.a(str), str2);
                }
            }
        }

        static synchronized void a(Context context) {
            synchronized (b.class) {
                a(context, null, null);
            }
        }

        private static synchronized void a(final Context context, final String str, String str2) {
            synchronized (b.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0015a.a(context, str, str2);
                    }
                    new Thread(new Runnable() {
                        /* class com.alipay.sdk.app.statistic.a.b.AnonymousClass1 */

                        public final void run() {
                            if (TextUtils.isEmpty(str) || b.b(context, str)) {
                                int i = 0;
                                while (i < 4) {
                                    String a2 = C0015a.a(context);
                                    if (!TextUtils.isEmpty(a2) && b.b(context, a2)) {
                                        i++;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                    }).start();
                }
            }
        }

        /* access modifiers changed from: private */
        public static synchronized boolean b(Context context, String str) {
            synchronized (b.class) {
                com.alipay.sdk.util.c.a("mspl", "stat sub ".concat(String.valueOf(str)));
                try {
                    if ((com.alipay.sdk.data.a.s().g() ? new d() : new e()).a((com.alipay.sdk.sys.a) null, context, str) == null) {
                        return false;
                    }
                    C0015a.a(context, str);
                    return true;
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return false;
                }
            }
        }
    }

    private a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        return;
     */
    public static synchronized void a(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                try {
                    C0015a.a(context, aVar.u.a(str), str2);
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        return;
     */
    public static synchronized void b(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                b.a(context, aVar.u, str, str2);
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, Throwable th) {
        if (aVar != null && th != null && th.getClass() != null) {
            aVar.u.a(str, th.getClass().getSimpleName(), th);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar != null) {
            aVar.u.a(str, str2, th, str3);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th) {
        if (aVar != null) {
            aVar.u.a(str, str2, th);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.u.a(str, str2, str3);
        }
    }

    public static void b(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.u.b(str, str2, str3);
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2) {
        if (aVar != null) {
            aVar.u.a(str, str2);
        }
    }
}

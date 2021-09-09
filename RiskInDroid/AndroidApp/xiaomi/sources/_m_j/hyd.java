package _m_j;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.stat.report.StatLogCache;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class hyd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile Boolean f970O000000o;
    private static volatile hyd O00000Oo;
    private static String O00000o0;
    private boolean O00000o = false;
    private final ExecutorService O00000oO = Executors.newSingleThreadExecutor();
    private O000000o O00000oo = new O000000o(this, (byte) 0);

    public static final void O000000o() {
        if (f970O000000o == null) {
            synchronized ("~#INITIALIZE#~") {
                if (f970O000000o == null) {
                    f970O000000o = Boolean.FALSE;
                    O00000o0();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.flu.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.flu.O000000o(long, long):java.lang.String
      _m_j.flu.O000000o(java.lang.String, boolean):boolean */
    private static final boolean O00000o0() {
        if (f970O000000o == null) {
            return true;
        }
        if (!f970O000000o.booleanValue()) {
            synchronized ("~#INITIALIZE#~") {
                if (!f970O000000o.booleanValue()) {
                    flu O00000oO2 = flu.O00000oO();
                    if (O00000oO2.O00000o() && O00000oO2.O000000o("~#INITIALIZE#~", false)) {
                        f970O000000o = Boolean.TRUE;
                    }
                }
            }
        }
        return f970O000000o.booleanValue();
    }

    private hyd() {
    }

    public static final hyd O00000Oo() {
        if (O00000Oo == null) {
            synchronized (hyd.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hyd();
                }
            }
        }
        return O00000Oo;
    }

    private static String O00000o() {
        return StatLogCache.O000000o(CommonApplication.getAppContext()) + "lac";
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010a A[SYNTHETIC, Splitter:B:61:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0122 A[SYNTHETIC, Splitter:B:68:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012b A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012d A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0138 A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0139 A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0168 A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016a A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x017a A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017c A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x018a A[Catch:{ Exception -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018b A[Catch:{ Exception -> 0x01c4 }] */
    private static String O000000o(flu flu, String str, String str2, String str3, JSONObject jSONObject, String str4, long j) {
        Long l;
        Long l2;
        long j2;
        long j3;
        FileOutputStream fileOutputStream;
        String str5 = str;
        String str6 = str3;
        JSONObject jSONObject2 = jSONObject;
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        FileOutputStream fileOutputStream2 = null;
        if (O00000Oo2 == null || O00000Oo2.isEmpty() || O00000Oo2.equals("0")) {
            if (O00000o0 == null) {
                String O00000o2 = O00000o();
                if (new File(O00000o2).canRead()) {
                    O00000o0 = ftd.O000000o(O00000o2);
                }
            }
            String str7 = O00000o0;
            if (str7 == null || str7.isEmpty()) {
                O00000o0 = "0";
            }
            O00000Oo2 = O00000o0;
        } else if (O00000Oo2 != null && !O00000Oo2.equals(O00000o0)) {
            O00000o0 = O00000Oo2;
            String O00000o3 = O00000o();
            try {
                ftd.O00000o0(O00000o3);
                fileOutputStream = new FileOutputStream(O00000o3);
                try {
                    fileOutputStream.write(O00000Oo2.getBytes());
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    gpg.O000000o(fileOutputStream2);
                    throw th;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                gpg.O000000o(fileOutputStream2);
                throw th;
            }
            gpg.O000000o(fileOutputStream);
        }
        String str8 = "";
        String str9 = ftn.O0000O0o(CommonApplication.getAppContext()) ? str8 : O00000Oo2;
        String O000000o2 = hyi.O000000o(flu);
        if (O000000o2 == null || !O000000o2.startsWith("\\\"session\\\":")) {
            hye.O000000o("STAT-ERROR", "not found session for " + str5 + ":" + str6);
            l2 = null;
            l = null;
        } else {
            String substring = O000000o2.substring(12);
            int indexOf = substring.indexOf(",\\\"order\\\":");
            try {
                l = Long.valueOf(Long.parseLong(substring.substring(0, indexOf)));
                try {
                    l2 = Long.valueOf(Long.parseLong(substring.substring(indexOf + 11)));
                } catch (Exception unused3) {
                    hye.O000000o("STAT-ERROR", "invalid session for " + str5 + ":" + str6);
                    l2 = null;
                    long j4 = -1;
                    if (l == null) {
                    }
                    jSONObject2.put("stay_time", j3);
                    JSONStringer jSONStringer = new JSONStringer();
                    if (jSONObject2 == null) {
                    }
                    if (l == null) {
                    }
                    jSONObject2.put("session", j2);
                    if (l2 != null) {
                    }
                    jSONObject2.put("order", j4);
                    JSONStringer key = jSONStringer.object().key("type").value((Object) str5).key("key").value((Object) hyb.O000000o().O000000o(str5, str6)).key("value").value((Object) (jSONObject2 == null ? str8 : jSONObject2.toString())).key("extra").value((Object) (str4 == null ? str8 : str4)).key("am");
                    if (str2 != null) {
                    }
                    return key.value((Object) str8).key("uid").value((Object) str9).key("isForeground").value(CommonApplication.getApplication().isAppForeground()).key("time").value(j / 1000).endObject().toString();
                }
            } catch (Exception unused4) {
                l = null;
                hye.O000000o("STAT-ERROR", "invalid session for " + str5 + ":" + str6);
                l2 = null;
                long j42 = -1;
                if (l == null) {
                }
                jSONObject2.put("stay_time", j3);
                JSONStringer jSONStringer2 = new JSONStringer();
                if (jSONObject2 == null) {
                }
                if (l == null) {
                }
                jSONObject2.put("session", j2);
                if (l2 != null) {
                }
                jSONObject2.put("order", j42);
                JSONStringer key2 = jSONStringer2.object().key("type").value((Object) str5).key("key").value((Object) hyb.O000000o().O000000o(str5, str6)).key("value").value((Object) (jSONObject2 == null ? str8 : jSONObject2.toString())).key("extra").value((Object) (str4 == null ? str8 : str4)).key("am");
                if (str2 != null) {
                }
                return key2.value((Object) str8).key("uid").value((Object) str9).key("isForeground").value(CommonApplication.getApplication().isAppForeground()).key("time").value(j / 1000).endObject().toString();
            }
        }
        long j422 = -1;
        if ("app".equals(str5) && "switch_to_backstage".equals(str6)) {
            if (l == null) {
                j3 = -1;
            } else {
                try {
                    j3 = (j - l.longValue()) / 100;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            jSONObject2.put("stay_time", j3);
        }
        JSONStringer jSONStringer22 = new JSONStringer();
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        if (l == null) {
            j2 = -1;
        } else {
            j2 = l.longValue();
        }
        jSONObject2.put("session", j2);
        if (l2 != null) {
            j422 = l2.longValue();
        }
        jSONObject2.put("order", j422);
        JSONStringer key22 = jSONStringer22.object().key("type").value((Object) str5).key("key").value((Object) hyb.O000000o().O000000o(str5, str6)).key("value").value((Object) (jSONObject2 == null ? str8 : jSONObject2.toString())).key("extra").value((Object) (str4 == null ? str8 : str4)).key("am");
        if (str2 != null) {
            str8 = str2;
        }
        return key22.value((Object) str8).key("uid").value((Object) str9).key("isForeground").value(CommonApplication.getApplication().isAppForeground()).key("time").value(j / 1000).endObject().toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.hyd.O000000o(android.app.Activity, java.lang.String, com.xiaomi.plugin.core.XmPluginPackage):long
      _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long */
    public final long O000000o(Activity activity, String str, XmPluginPackage xmPluginPackage) {
        if (xmPluginPackage != null) {
            return O000000o(str, hxw.O000000o(xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId()), false);
        }
        return O000000o(str, hyg.O000000o(activity), true);
    }

    public final long O000000o(String str, String str2, boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = z ? "page" : "plugin";
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        return O000000o("app", "mihome", str, hyg.O000000o(objArr), "", z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.flu.O000000o(java.lang.String, boolean):boolean
     arg types: [?[OBJECT, ARRAY], int]
     candidates:
      _m_j.flu.O000000o(long, long):java.lang.String
      _m_j.flu.O000000o(java.lang.String, boolean):boolean */
    private long O000000o(flu flu, long j) {
        if (!this.O00000o && flu.O00000o()) {
            flu.O000000o((String) null, true);
            this.O00000o = true;
        }
        return j;
    }

    public final long O000000o(String str, String str2, String str3, JSONObject jSONObject, String str4, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final JSONObject jSONObject2 = jSONObject;
        final String str8 = str4;
        final boolean z2 = z;
        final long j = currentTimeMillis;
        this.O00000oO.execute(new Runnable() {
            /* class _m_j.hyd.AnonymousClass1 */

            public final void run() {
                hyd.this.O000000o(str5, str6, str7, jSONObject2, str8, z2, j);
            }
        });
        return currentTimeMillis;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.flu.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.flu.O000000o(long, long):java.lang.String
      _m_j.flu.O000000o(java.lang.String, boolean):boolean */
    public final long O000000o(String str, String str2, String str3, JSONObject jSONObject, String str4, boolean z, long j) {
        JSONObject jSONObject2;
        String str5 = str;
        String str6 = str3;
        boolean z2 = z;
        long j2 = j;
        flu O00000oO2 = flu.O00000oO();
        if (!hyg.O000000o(str5, str6)) {
            return O000000o(O00000oO2, j2);
        }
        if ("app".equals(str5) && "switch_to_app".equals(str6) && !hyi.O000000o(O00000oO2, z2, true)) {
            return O000000o(O00000oO2, j2);
        }
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (Exception unused) {
                jSONObject2 = jSONObject;
            }
        } else {
            jSONObject2 = jSONObject;
        }
        try {
            jSONObject2.put("key_name", str6);
        } catch (Exception unused2) {
        }
        String O000000o2 = O000000o(O00000oO2, str, str2, str3, jSONObject2, str4, j);
        if ("app".equals(str5) && "switch_to_backstage".equals(str6) && !hyi.O000000o(O00000oO2, z2, false)) {
            return O000000o(O00000oO2, j2);
        }
        if (O000000o2 == null) {
            return O000000o(O00000oO2, j2);
        }
        hye.O000000o("STAT-REPORT", O000000o2.replace(",\"value\":\"{", ",\"value\":\r\n\"{").replace(",\"uid\":\"", ",\r\nuid:\"").replace(jdn.f1779O000000o, "").replace("\\", "").replace("\t", ""));
        if (!O00000o0() || !fdc.O000000o().O0000Ooo() || !flu.O00000oO().O000000o(O000000o2, false)) {
            this.O00000oo.O000000o(O000000o2);
        } else {
            this.O00000o = true;
            O000000o o000000o = this.O00000oo;
            o000000o.f972O000000o.execute(new Runnable() {
                /* class _m_j.hyd.O000000o.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.flu.O000000o(java.lang.String, boolean):boolean
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.flu.O000000o(long, long):java.lang.String
                  _m_j.flu.O000000o(java.lang.String, boolean):boolean */
                public final void run() {
                    while (true) {
                        if (!O000000o.this.O00000Oo.isEmpty()) {
                            String poll = O000000o.this.O00000Oo.poll();
                            if (poll != null && !flu.O00000oO().O000000o(poll, false)) {
                                O000000o.this.O00000Oo.add(poll);
                                O000000o.this.O000000o();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    LinkedList<String> O00000o0 = StatLogCache.O00000o0();
                    if (O00000o0 != null && !O00000o0.isEmpty()) {
                        while (!O00000o0.isEmpty()) {
                            String pop = O00000o0.pop();
                            if (pop != null) {
                                flu.O00000oO().O000000o(pop, false);
                            }
                        }
                    }
                }
            });
        }
        return j2;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Executor f972O000000o;
        public ConcurrentLinkedQueue<String> O00000Oo;

        private O000000o() {
            this.f972O000000o = Executors.newSingleThreadExecutor();
            this.O00000Oo = new ConcurrentLinkedQueue<>();
        }

        /* synthetic */ O000000o(hyd hyd, byte b) {
            this();
        }

        public final void O000000o() {
            ConcurrentLinkedQueue<String> concurrentLinkedQueue = this.O00000Oo;
            if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                Context appContext = CommonApplication.getAppContext();
                while (!this.O00000Oo.isEmpty()) {
                    String poll = this.O00000Oo.poll();
                    if (poll != null && !StatLogCache.O000000o(appContext, poll)) {
                        O000000o(poll);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(final String str) {
            this.f972O000000o.execute(new Runnable() {
                /* class _m_j.hyd.O000000o.AnonymousClass2 */

                public final void run() {
                    O000000o.this.O00000Oo.offer(str);
                    O000000o.this.O000000o();
                }
            });
        }
    }
}

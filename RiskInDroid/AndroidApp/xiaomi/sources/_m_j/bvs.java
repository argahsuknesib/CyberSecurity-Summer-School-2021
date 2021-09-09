package _m_j;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

public final class bvs {
    private static bvs O0000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    Context f13319O000000o = null;
    ExecutorService O00000Oo = null;
    boolean O00000o = true;
    boolean O00000o0 = false;
    bvv O00000oO = null;
    String O00000oo = "";
    String O0000O0o = "";
    String[] O0000OOo = null;
    int O0000Oo0 = 0;
    private Object O0000OoO = null;
    private final int O0000Ooo = 2;
    private final int O0000o0 = 2;
    private final int O0000o00 = 5;

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        bvv f13320O000000o = null;

        O000000o(bvv bvv) {
            this.f13320O000000o = bvv;
        }

        public final void run() {
            bvs.this.O0000Oo0++;
            bvs.this.O000000o(this.f13320O000000o);
            bvs bvs = bvs.this;
            bvs.O0000Oo0--;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c A[SYNTHETIC, Splitter:B:17:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    private bvs(Context context) {
        boolean z;
        int O00000Oo2;
        int O00000Oo3;
        this.f13319O000000o = context;
        Context context2 = this.f13319O000000o;
        new Object[1][0] = "DnsManager ==> init ";
        bwi.O000000o();
        if (bwg.O00000Oo(context2, "pref", "dnab", true)) {
            int i = Build.VERSION.SDK_INT;
            int i2 = 8;
            if (context2 != null && (O00000Oo3 = bwg.O00000Oo(context2, "pref", "dnmi", 8)) > 8) {
                i2 = O00000Oo3;
            }
            if (i >= i2) {
                int i3 = Build.VERSION.SDK_INT;
                int i4 = 22;
                if (context2 != null && (O00000Oo2 = bwg.O00000Oo(context2, "pref", "dnma", 22)) < 28) {
                    i4 = O00000Oo2;
                }
                if (i3 <= i4) {
                    z = true;
                    if (!z) {
                        try {
                            if (this.O0000OoO == null) {
                                int O00000Oo4 = bwg.O00000Oo(context2, "pref", "ok6", 0);
                                long O00000Oo5 = bwg.O00000Oo(context2, "pref", "ok8", 0L);
                                if (O00000Oo4 == 0 || O00000Oo5 == 0 || System.currentTimeMillis() - O00000Oo5 >= 259200000) {
                                    bwg.O000000o(context2, "pref", "ok6", O00000Oo4 + 1);
                                    bwg.O000000o(context2, "pref", "ok8", System.currentTimeMillis());
                                    new Object[1][0] = "DnsManager ==> initForJar ";
                                    bwi.O000000o();
                                    this.O0000OoO = Class.forName("com.autonavi.httpdns.HttpDnsManager").getConstructor(Context.class).newInstance(context2);
                                    bwg.O000000o(context2, "pref", "ok6", 0);
                                    bwg.O000000o(context2, "pref", "ok8", 0L);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            bvz.O000000o(th, "APSCoManager", "init");
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        z = false;
        if (!z) {
        }
    }

    public static bvs O000000o(Context context) {
        if (O0000Oo == null) {
            O0000Oo = new bvs(context);
        }
        return O0000Oo;
    }

    private static boolean O000000o(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 == null) {
            return false;
        }
        if (strArr == null && strArr2 != null) {
            return false;
        }
        if (strArr == null && strArr2 == null) {
            return true;
        }
        try {
            if (strArr.length != strArr2.length) {
                return false;
            }
            ArrayList arrayList = new ArrayList(12);
            ArrayList arrayList2 = new ArrayList(12);
            arrayList.addAll(Arrays.asList(strArr));
            arrayList2.addAll(Arrays.asList(strArr2));
            Collections.sort(arrayList);
            Collections.sort(arrayList2);
            for (int i = 0; i < arrayList.size(); i++) {
                if (!((String) arrayList.get(i)).equals(arrayList2.get(i))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void O00000Oo() {
        O0000Oo = null;
    }

    private boolean O00000o0() {
        int i;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                i = Integer.parseInt(property);
            } else {
                str = Proxy.getHost(this.f13319O000000o);
                i = Proxy.getPort(this.f13319O000000o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            i = -1;
        }
        return (str == null || i == -1) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(String str) {
        int i;
        String str2;
        String str3 = null;
        if (O000000o()) {
            try {
                String[] strArr = (String[]) bwd.O000000o(this.O0000OoO, "getIpsByHostAsync", str);
                if (strArr != null && strArr.length > 0) {
                    if (this.O0000OOo == null) {
                        this.O0000OOo = strArr;
                        str2 = strArr[0];
                    } else if (O000000o(strArr, this.O0000OOo)) {
                        str2 = this.O0000OOo[0];
                    } else {
                        this.O0000OOo = strArr;
                        str3 = strArr[0];
                    }
                    str3 = str2;
                }
                i = 1;
            } catch (Throwable unused) {
                i = 0;
            }
            bwf.O000000o(this.f13319O000000o, "HttpDns", i);
        }
        new Object[1][0] = "DnsManager ==> getIpAsync  host ： " + str + " ， ip ： " + str3;
        bwi.O000000o();
        return str3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        _m_j.bwg.O000000o(r7.f13319O000000o, "pref", "dns_faile_count_total", 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
    public final synchronized void O000000o(bvv bvv) {
        bvv.O0000OOo = bvz.O000000o();
        long O00000Oo2 = bwg.O00000Oo(this.f13319O000000o, "pref", "dns_faile_count_total", 0L);
        if (O00000Oo2 < 2) {
            bsw.O000000o();
            bsw.O000000o(bvv, false);
            bwg.O000000o(this.f13319O000000o, "pref", "dns_faile_count_total", O00000Oo2 + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return this.O0000OoO != null && !O00000o0() && bwg.O00000Oo(this.f13319O000000o, "pref", "dns_faile_count_total", 0) < 2;
    }
}

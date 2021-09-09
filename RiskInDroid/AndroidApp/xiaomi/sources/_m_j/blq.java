package _m_j;

import _m_j.blp;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ishumei.smantifraud.SmAntiFraud;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class blq {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, String> f13067O000000o;
    private AtomicBoolean O00000Oo;
    private Runnable O00000o0;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final blq f13069O000000o = new blq((byte) 0);
    }

    private blq() {
        this.O00000o0 = new Runnable() {
            /* class _m_j.blq.AnonymousClass1 */

            public final void run() {
                bmz.O00000Oo("IpCacheManager", "refreshAllCache start...", new Object[0]);
                try {
                    SmAntiFraud.O000000o o000000o = SmAntiFraud.f4498O000000o;
                    String str = o000000o.O00000oO;
                    String str2 = o000000o.O0000O0o;
                    String str3 = o000000o.O00000oo;
                    String str4 = o000000o.O0000OOo;
                    blq blq = blq.this;
                    String[] strArr = {str, str2, str3, str4};
                    HashSet<String> hashSet = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        String O0000OOo = bne.O0000OOo(strArr[i]);
                        if (!TextUtils.isEmpty(O0000OOo) && !bne.O0000Oo0(O0000OOo)) {
                            hashSet.add(O0000OOo);
                        }
                    }
                    if (blq.f13067O000000o != null && blq.f13067O000000o.size() > 0) {
                        hashSet.addAll(blq.f13067O000000o.keySet());
                    }
                    for (String str5 : hashSet) {
                        try {
                            String O000000o2 = blq.O000000o(str5);
                            bmz.O00000Oo("IpCacheManager", "refreshAllCache lookup: %s, ip: %s", str5, O000000o2);
                            if (!TextUtils.isEmpty(O000000o2)) {
                                blq.this.O000000o(str5, O000000o2);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    bmz.O00000Oo("IpCacheManager", "refreshAllCache end...", new Object[0]);
                } catch (Throwable unused2) {
                }
            }
        };
        this.f13067O000000o = new ConcurrentHashMap();
        this.O00000Oo = new AtomicBoolean(false);
    }

    /* synthetic */ blq(byte b) {
        this();
    }

    static String O000000o(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName != null) {
                String hostAddress = byName.getHostAddress();
                bmz.O00000Oo("IpCacheManager", "lookup host: %s, ip: %s", str, hostAddress);
                if (TextUtils.isEmpty(hostAddress)) {
                    return null;
                }
                return hostAddress;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final Map<String, String> O000000o() {
        return new HashMap(this.f13067O000000o);
    }

    public final String O000000o(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
        if (O000000o2 == null || !O000000o2.O0000oOO) {
            bmz.O00000Oo("IpCacheManager", "IP cache disable, return null.", new Object[0]);
            return null;
        }
        if (!this.O00000Oo.get() && this.O00000Oo.compareAndSet(false, true)) {
            HashMap hashMap = new HashMap();
            Context context = blw.f13081O000000o;
            if (context == null) {
                bmz.O00000o("IpCacheManager", "Context is null, can't load from sp.", new Object[0]);
            } else {
                HashSet<String> hashSet = new HashSet<>();
                for (Map.Entry next : context.getSharedPreferences(blo.f13057O000000o, 0).getAll().entrySet()) {
                    String str2 = (String) next.getKey();
                    Object value = next.getValue();
                    if (!str2.equals(blo.O00000Oo)) {
                        if (str2.endsWith("_SUFFIX_TIME")) {
                            if ((value instanceof Long) && System.currentTimeMillis() - ((Long) value).longValue() > 604800000) {
                                hashSet.add(str2.substring(0, str2.indexOf("_SUFFIX_TIME")));
                            }
                        } else if (value instanceof String) {
                            hashMap.put(str2, (String) value);
                        }
                    }
                }
                for (String remove : hashSet) {
                    hashMap.remove(remove);
                }
            }
            this.f13067O000000o.putAll(hashMap);
            bmf.O00000Oo().O000000o(this.O00000o0, 1);
        }
        if (bne.O0000Oo0(str)) {
            return null;
        }
        if (z) {
            return O000000o(str);
        }
        String str3 = this.f13067O000000o.get(str);
        return TextUtils.isEmpty(str3) ? O000000o(str) : str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (!bne.O0000Oo0(str)) {
                    this.f13067O000000o.put(str, str2);
                    Context context = blw.f13081O000000o;
                    if (context == null) {
                        bmz.O00000o("IpCacheManager", "Context is null, can't save to sp.", new Object[0]);
                        return;
                    }
                    SharedPreferences.Editor edit = context.getSharedPreferences(blo.f13057O000000o, 0).edit();
                    edit.putString(str, str2);
                    edit.putLong(str + "_SUFFIX_TIME", System.currentTimeMillis());
                    edit.apply();
                }
            }
        }
    }
}

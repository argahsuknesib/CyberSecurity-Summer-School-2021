package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class dgs {
    private static dgs O000o0O0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f14615O000000o;
    public String O00000Oo;
    public final byte O00000o;
    public final long O00000o0 = System.currentTimeMillis();
    public String O00000oO;
    public final String O00000oo;
    public boolean O0000O0o = true;
    public final String O0000OOo;
    public final String O0000Oo;
    public final String O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo = "unknown";
    public String O0000o = null;
    public String O0000o0 = null;
    public long O0000o00;
    public String O0000o0O = null;
    public String O0000o0o = null;
    public String O0000oO = null;
    public String O0000oO0 = null;
    public List<String> O0000oOO = null;
    public int O0000oOo = -1;
    public boolean O0000oo;
    public Map<String, String> O0000oo0 = new HashMap();
    public String O0000ooO = "unknown";
    public long O0000ooo = 0;
    public long O000O00o = 0;
    public boolean O000O0OO = false;
    public String O000O0Oo = null;
    public boolean O000O0o = false;
    public String O000O0o0 = null;
    public boolean O000O0oO = false;
    public HashMap<String, String> O000O0oo = new HashMap<>();
    public dgo O000OO = null;
    public boolean O000OO00 = true;
    public List<String> O000OO0o = new ArrayList();
    public SharedPreferences O000OOOo;
    public final Object O000OOo = new Object();
    public final Object O000OOo0 = new Object();
    public final Object O000OOoO = new Object();
    private String O000OOoo = "unknown";
    private String O000Oo0 = null;
    private String O000Oo00 = "";
    private String O000Oo0O = null;
    private String O000Oo0o = null;
    private long O000OoO = -1;
    private String O000OoO0 = null;
    private long O000OoOO = -1;
    private String O000OoOo = null;
    private Map<String, PlugInBean> O000Ooo = null;
    private String O000Ooo0 = null;
    private boolean O000OooO = true;
    private String O000Oooo = null;
    private String O000o = null;
    private Map<String, PlugInBean> O000o0 = null;
    private String O000o00 = null;
    private Boolean O000o000 = null;
    private String O000o00O = null;
    private String O000o00o = null;
    private int O000o0O = -1;
    private Map<String, String> O000o0OO = new HashMap();
    private Map<String, String> O000o0Oo = new HashMap();
    private String O000o0o = null;
    private String O000o0o0 = null;
    private String O000o0oo = null;
    private final Object O000oO = new Object();
    private final Object O000oO0 = new Object();
    private String O000oO00 = null;
    private final Object O000oO0O = new Object();
    private final Object O000oO0o = new Object();
    private long O00O0Oo = -1;
    public String O00oOoOo = null;
    public long O00oOooO = 0;
    public long O00oOooo = 0;

    private dgs(Context context) {
        this.f14615O000000o = dif.O000000o(context);
        this.O00000o = 1;
        PackageInfo O00000Oo2 = dgr.O00000Oo(context);
        if (O00000Oo2 != null) {
            try {
                this.O0000o0 = O00000Oo2.versionName;
                this.O000O0Oo = this.O0000o0;
                this.O00oOoOo = Integer.toString(O00000Oo2.versionCode);
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.O00000oO = dgr.O000000o(context);
        this.O00000oo = dgr.O000000o(Process.myPid());
        this.O0000OOo = dgt.O0000Ooo();
        this.O0000Oo0 = dgt.O000000o();
        this.O0000o0O = dgr.O00000o0(context);
        this.O0000Oo = "Android " + dgt.O00000Oo() + ",level " + dgt.O00000o0();
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000Oo0);
        sb.append(";");
        sb.append(this.O0000Oo);
        Map<String, String> O00000o2 = dgr.O00000o(context);
        if (O00000o2 != null) {
            try {
                this.O0000oOO = dgr.O000000o(O00000o2);
                String str = O00000o2.get("BUGLY_APPID");
                if (str != null) {
                    this.O0000o0o = str;
                }
                String str2 = O00000o2.get("BUGLY_APP_VERSION");
                if (str2 != null) {
                    this.O0000o0 = str2;
                }
                String str3 = O00000o2.get("BUGLY_APP_CHANNEL");
                if (str3 != null) {
                    this.O0000o = str3;
                }
                String str4 = O00000o2.get("BUGLY_ENABLE_DEBUG");
                if (str4 != null) {
                    this.O000O0OO = str4.equalsIgnoreCase("true");
                }
                String str5 = O00000o2.get("com.tencent.rdm.uuid");
                if (str5 != null) {
                    this.O000O0o0 = str5;
                }
            } catch (Throwable th2) {
                if (!did.O000000o(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.O000O0oO = true;
                did.O00000o0("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (dgm.O00000o0) {
                th3.printStackTrace();
            }
        }
        this.O000OOOo = dif.O000000o("BUGLY_COMMON_VALUES", context);
        did.O00000o0("com info create end", new Object[0]);
    }

    public final void O000000o(boolean z) {
        this.O0000oo = z;
        dgo dgo = this.O000OO;
        if (dgo != null) {
            dgo.O000000o(z);
        }
    }

    public static synchronized dgs O000000o(Context context) {
        dgs dgs;
        synchronized (dgs.class) {
            if (O000o0O0 == null) {
                O000o0O0 = new dgs(context);
            }
            dgs = O000o0O0;
        }
        return dgs;
    }

    public static synchronized dgs O000000o() {
        dgs dgs;
        synchronized (dgs.class) {
            dgs = O000o0O0;
        }
        return dgs;
    }

    public final String O00000Oo() {
        if (this.O00000Oo == null) {
            synchronized (this.O000OOo0) {
                if (this.O00000Oo == null) {
                    this.O00000Oo = UUID.randomUUID().toString();
                }
            }
        }
        return this.O00000Oo;
    }

    public final String O00000o0() {
        if (!dif.O000000o((String) null)) {
            return null;
        }
        return this.O0000o0o;
    }

    public final String O00000o() {
        String str;
        synchronized (this.O000OOo) {
            str = this.O0000Ooo;
        }
        return str;
    }

    public final String O00000oO() {
        String str = this.O0000OoO;
        if (str != null) {
            return str;
        }
        this.O0000OoO = O0000OOo() + "|" + O0000Oo() + "|" + O0000OoO();
        return this.O0000OoO;
    }

    public final synchronized String O00000oo() {
        return this.O000OOoo;
    }

    public final synchronized void O000000o(String str) {
        this.O000OOoo = String.valueOf(str);
    }

    public final synchronized String O0000O0o() {
        return this.O000Oo00;
    }

    public final synchronized void O00000Oo(String str) {
        this.O000Oo00 = String.valueOf(str);
    }

    public final String O0000OOo() {
        if (!this.O000OooO) {
            return "";
        }
        if (this.O000Oo0 == null) {
            this.O000Oo0 = dgt.O000000o(this.f14615O000000o);
        }
        return this.O000Oo0;
    }

    public final String O0000Oo0() {
        if (!this.O000OooO) {
            return "";
        }
        String str = this.O000Oo0O;
        if (str == null || !str.contains(":")) {
            this.O000Oo0O = dgt.O00000o(this.f14615O000000o);
        }
        return this.O000Oo0O;
    }

    public final String O0000Oo() {
        if (!this.O000OooO) {
            return "";
        }
        if (this.O000Oo0o == null) {
            this.O000Oo0o = dgt.O00000Oo(this.f14615O000000o);
        }
        return this.O000Oo0o;
    }

    public final String O0000OoO() {
        if (!this.O000OooO) {
            return "";
        }
        if (this.O000OoO0 == null) {
            this.O000OoO0 = dgt.O00000o0(this.f14615O000000o);
        }
        return this.O000OoO0;
    }

    public final long O0000Ooo() {
        if (this.O00O0Oo <= 0) {
            this.O00O0Oo = dgt.O00000oO();
        }
        return this.O00O0Oo;
    }

    public final long O0000o00() {
        if (this.O000OoO <= 0) {
            this.O000OoO = dgt.O0000O0o();
        }
        return this.O000OoO;
    }

    public final long O0000o0() {
        if (this.O000OoOO <= 0) {
            this.O000OoOO = dgt.O0000Oo0();
        }
        return this.O000OoOO;
    }

    public final String O0000o0O() {
        if (this.O000OoOo == null) {
            this.O000OoOo = dgt.O000000o(true);
        }
        return this.O000OoOo;
    }

    public final String O0000o0o() {
        if (this.O000Ooo0 == null) {
            this.O000Ooo0 = dgt.O0000OOo(this.f14615O000000o);
        }
        return this.O000Ooo0;
    }

    public final String O0000o() {
        try {
            Map<String, ?> all = this.f14615O000000o.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.O000oO0) {
                    for (Map.Entry next : all.entrySet()) {
                        try {
                            this.O000O0oo.put(next.getKey(), next.getValue().toString());
                        } catch (Throwable th) {
                            did.O000000o(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            did.O000000o(th2);
        }
        if (this.O000O0oo.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next2 : this.O000O0oo.entrySet()) {
            sb.append("[");
            sb.append((String) next2.getKey());
            sb.append(",");
            sb.append((String) next2.getValue());
            sb.append("] ");
        }
        String sb2 = sb.toString();
        if (dif.O000000o("SDK_INFO") || dif.O000000o(sb2)) {
            did.O00000o("server key&value should not be empty %s %s", "SDK_INFO", String.valueOf(sb2));
        } else {
            synchronized (this.O000oO0o) {
                this.O000o0Oo.put("SDK_INFO", sb2);
            }
        }
        return sb.toString();
    }

    public final String O0000oO0() {
        if (this.O000oO00 == null) {
            this.O000oO00 = dgr.O00000oO(this.f14615O000000o);
        }
        return this.O000oO00;
    }

    public final synchronized Map<String, PlugInBean> O0000oO() {
        return null;
    }

    public final String O0000oOO() {
        if (this.O000Oooo == null) {
            this.O000Oooo = dgt.O0000OoO();
        }
        return this.O000Oooo;
    }

    public final Boolean O0000oOo() {
        if (this.O000o000 == null) {
            this.O000o000 = Boolean.valueOf(dgt.O0000Oo0(this.f14615O000000o));
        }
        return this.O000o000;
    }

    public final String O0000oo0() {
        if (this.O000o00 == null) {
            this.O000o00 = dgt.O0000O0o(this.f14615O000000o);
            did.O000000o("ROM ID: %s", this.O000o00);
        }
        return this.O000o00;
    }

    public final String O0000oo() {
        if (this.O000o00O == null) {
            this.O000o00O = dgt.O00000oO(this.f14615O000000o);
            did.O000000o("SIM serial number: %s", this.O000o00O);
        }
        return this.O000o00O;
    }

    public final String O0000ooO() {
        if (this.O000o00o == null) {
            this.O000o00o = dgt.O00000o();
            did.O000000o("Hardware serial number: %s", this.O000o00o);
        }
        return this.O000o00o;
    }

    public final Map<String, String> O0000ooo() {
        synchronized (this.O000oO0O) {
            if (this.O000o0OO.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.O000o0OO);
            return hashMap;
        }
    }

    public final void O00oOooO() {
        synchronized (this.O000oO0O) {
            this.O000o0OO.clear();
        }
    }

    public final void O000000o(String str, String str2) {
        if (dif.O000000o(str) || dif.O000000o(str2)) {
            did.O00000o("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.O000oO0O) {
            this.O000o0OO.put(str, str2);
        }
    }

    public final int O00oOooo() {
        int size;
        synchronized (this.O000oO0O) {
            size = this.O000o0OO.size();
        }
        return size;
    }

    public final Set<String> O000O00o() {
        Set<String> keySet;
        synchronized (this.O000oO0O) {
            keySet = this.O000o0OO.keySet();
        }
        return keySet;
    }

    public final Map<String, String> O000O0OO() {
        synchronized (this.O000OOoO) {
            if (this.O0000oo0.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.O0000oo0);
            return hashMap;
        }
    }

    public final Map<String, String> O000O0Oo() {
        synchronized (this.O000oO0o) {
            if (this.O000o0Oo.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.O000o0Oo);
            return hashMap;
        }
    }

    public final int O00oOoOo() {
        int i;
        synchronized (this.O000oO) {
            i = this.O000o0O;
        }
        return i;
    }

    public final synchronized Map<String, PlugInBean> O000O0o0() {
        return null;
    }

    public static int O000O0o() {
        return dgt.O00000o0();
    }

    public final String O000O0oO() {
        if (this.O000o0o0 == null) {
            this.O000o0o0 = dgt.O0000o00();
        }
        return this.O000o0o0;
    }

    public final String O000O0oo() {
        if (this.O000o0o == null) {
            this.O000o0o = dgt.O0000Oo(this.f14615O000000o);
        }
        return this.O000o0o;
    }

    public final String O000OO00() {
        if (this.O000o0oo == null) {
            this.O000o0oo = dgt.O0000OoO(this.f14615O000000o);
        }
        return this.O000o0oo;
    }

    public static String O000OO0o() {
        return dgt.O0000o0();
    }

    public final String O000OO() {
        if (this.O000o == null) {
            this.O000o = dgt.O0000Ooo(this.f14615O000000o);
        }
        return this.O000o;
    }

    public static long O000OOOo() {
        return dgt.O0000o0O();
    }
}

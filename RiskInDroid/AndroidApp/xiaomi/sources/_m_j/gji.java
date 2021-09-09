package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class gji extends fdc {
    volatile Boolean O00000Oo;
    private final ServerBean O00000o = new ServerBean("cn", "CN", "");
    private volatile SharedPreferences O00000o0;
    private final ServerBean O00000oO = new ServerBean("sg", "TW", "");
    private final ServerBean O00000oo = new ServerBean("sg", "HK", "");
    private final ServerBean O0000O0o = new ServerBean("sg", "SG", "");
    private final ServerBean O0000OOo = new ServerBean("i2", "IN", "");
    private final ServerBean O0000Oo = new ServerBean("de", "DE", "");
    private final ServerBean O0000Oo0 = new ServerBean("us", "US", "");
    private final ServerBean O0000OoO = new ServerBean("sg", "KR", "");
    private final ServerBean O0000Ooo = new ServerBean("ru", "RU", "");
    private final Map<String, ServerBean> O0000o;
    private final List<ServerBean> O0000o0 = Arrays.asList(this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000Ooo, this.O0000o00);
    private final ServerBean O0000o00 = new ServerBean("st", "st", "");
    private final Map<String, Pair<String, String>> O0000o0O = new o0O0OOO0();
    private final Map<String, String> O0000o0o;
    private AtomicReference<ServerBean> O0000oO0;

    public gji() {
        this.O0000o0O.put("in", Pair.create("SG", "sg"));
        this.O0000o0O.put("us", Pair.create("SG", "sg"));
        this.O0000o0O.put("de", Pair.create("DE", "de"));
        this.O0000o0O.put("tr", Pair.create("SG", "sg"));
        this.O0000o0O.put("cn", Pair.create("CN", "cn"));
        this.O0000o0O.put("tw", Pair.create("TW", "sg"));
        this.O0000o0O.put("hk", Pair.create("HK", "sg"));
        this.O0000o0O.put("sg", Pair.create("SG", "sg"));
        this.O0000o0O.put("i2", Pair.create("IN", "i2"));
        Object obj = "US";
        this.O0000o0O.put("us_true", Pair.create(obj, "us"));
        this.O0000o0O.put("kr", Pair.create("KR", "sg"));
        this.O0000o0O.put("ru", Pair.create("RU", "ru"));
        Object obj2 = "st";
        this.O0000o0O.put(obj2, Pair.create(obj2, obj2));
        this.O0000o0o = new o0O0OOO0();
        this.O0000o0o.put("CN", "cn");
        this.O0000o0o.put("TW", "tw");
        this.O0000o0o.put("HK", "hk");
        this.O0000o0o.put("SG", "sg");
        this.O0000o0o.put("IN", "i2");
        this.O0000o0o.put(obj, "us_true");
        this.O0000o0o.put("DE", "de");
        this.O0000o0o.put("KR", "kr");
        this.O0000o0o.put("RU", "ru");
        this.O0000o0o.put(obj2, obj2);
        this.O0000o = new o0O0OOO0();
        this.O0000o.put("IR", this.O0000O0o);
        this.O0000o.put("CU", this.O0000Oo0);
        this.O0000o.put("KP", this.O0000O0o);
        this.O0000o.put("SY", this.O0000O0o);
        this.O0000o.put("SD", this.O0000O0o);
        this.O0000o.put("VE", this.O0000Oo0);
        this.O0000oO0 = new AtomicReference<>();
        this.O00000Oo = null;
    }

    private SharedPreferences O0000o0o(Context context) {
        SharedPreferences sharedPreferences;
        if (this.O00000o0 == null) {
            synchronized (gji.class) {
                if (this.O00000o0 == null) {
                    try {
                        sharedPreferences = MMKV.O000000o("globaldynamicsetting");
                    } catch (Exception e) {
                        gsy.O00000Oo(LogType.LOG_INTERNAL, "ServerApiImpl", Log.getStackTraceString(e));
                        sharedPreferences = context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
                    }
                    this.O00000o0 = sharedPreferences;
                    return sharedPreferences;
                }
            }
        }
        return this.O00000o0;
    }

    public final ServerBean O000000o(Context context) {
        if (O0000oO0(context)) {
            ServerBean serverBean = this.O0000oO0.get();
            if (serverBean != null) {
                gsy.O00000Oo("ServerApiImpl", "get server from cache: " + serverBean.O00000Oo());
                return serverBean;
            }
            ServerBean O00000Oo2 = O00000Oo(context);
            if (O00000Oo2 != null) {
                this.O0000oO0.compareAndSet(null, O00000Oo2);
            }
            return O00000Oo2;
        } else if (CoreApi.O000000o().O0000O0o()) {
            return CoreApi.O000000o().O0000ooO();
        } else {
            return O00000Oo(context);
        }
    }

    public final String O000000o(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            if (str.equals(this.O0000o00.O00000Oo)) {
                return context.getString(R.string.inter_sub_domain_st);
            }
            try {
                for (ServerBean next : O000000o(O00000o0(context), context)) {
                    if (TextUtils.equals(next.O00000Oo, str)) {
                        return next.O00000o0;
                    }
                }
            } catch (Exception e) {
                if (gfr.f17662O000000o) {
                    e.printStackTrace();
                }
            }
            return "";
        }
    }

    public final List<ServerBean> O000000o(Locale locale, Context context) {
        ArrayList arrayList = new ArrayList();
        if (locale == null) {
            return arrayList;
        }
        String O000000o2 = gsc.O000000o(context, "server_config" + File.separator + flk.O000000o(locale).toLowerCase() + ".json");
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = gsc.O000000o(context, "server_config" + File.separator + fto.O000000o(locale.getLanguage().toLowerCase()) + ".json");
            if (TextUtils.isEmpty(O000000o2)) {
                String lowerCase = flk.O000000o(locale).toLowerCase();
                O000000o2 = gsc.O00000o0(context.getCacheDir().getPath() + File.separator + "server_config" + File.separator + lowerCase.toLowerCase());
            }
        }
        if (TextUtils.isEmpty(O000000o2)) {
            return arrayList;
        }
        try {
            return ServerBean.O000000o(new JSONObject(O000000o2));
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    public final String O000000o(ServerBean serverBean) {
        return serverBean == null ? "" : this.O0000o0o.get(serverBean.O00000Oo);
    }

    public final ServerBean O00000Oo(Context context) {
        String string = O0000o0o(context).getString("server_json", null);
        gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromMMKV: new ".concat(String.valueOf(string)));
        try {
            if (TextUtils.isEmpty(string)) {
                ServerBean O0000o2 = O0000o(context);
                if (O0000oO0(context)) {
                    O000000o(context, O0000o2);
                }
                return O0000o2;
            }
            ServerBean O00000Oo2 = ServerBean.O00000Oo(new JSONObject(string));
            gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromMMKV: new server: ".concat(String.valueOf(O00000Oo2)));
            return O00000Oo2;
        } catch (Exception unused) {
            return O0000o(context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|(1:19)|20|(1:22)|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = r8.O0000o0O.get(r4);
        r2 = com.xiaomi.smarthome.frame.server_compact.ServerBean.O000000o((java.lang.String) r2.first, (java.lang.String) r2.second);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009c, code lost:
        if (O0000oO0(r9) != false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        O000000o(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        if (_m_j.gfr.f17662O000000o != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a5, code lost:
        _m_j.gsy.O00000Oo("ServerApiImpl", java.lang.String.format("原来服务器是： %s,静默迁移到： %s", r4, r2.O00000Oo));
        _m_j.gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromSpfs: old " + r2.O00000Oo());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cd, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ce, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d1, code lost:
        if (_m_j.gfr.f17662O000000o != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d3, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d6, code lost:
        _m_j.gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromSpfs: null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00db, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0084 */
    @Deprecated
    private ServerBean O0000o(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
        String string = sharedPreferences.getString("server_new", "");
        if (TextUtils.isEmpty(string)) {
            string = sharedPreferences.getString("server", "");
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ServerBean O00000Oo2 = ServerBean.O00000Oo(new JSONObject(string));
        gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromSpfs: new " + O00000Oo2.O00000Oo());
        ServerBean serverBean = this.O0000o.get(O00000Oo2.O00000Oo);
        if (serverBean == null) {
            return O00000Oo2;
        }
        if (gfr.f17662O000000o) {
            gsy.O00000Oo("ServerApiImpl", "parseCurrentServerFromSpfs: map banned server: " + O00000Oo2.O00000Oo() + " ;to: " + serverBean.O00000Oo());
        }
        if (O0000oO0(context)) {
            O000000o(context, serverBean);
        }
        return (ServerBean) serverBean.clone();
    }

    public final Locale O00000o0(Context context) {
        Locale O00000o2 = O00000o(context);
        if (O00000o2 != null) {
            return O00000o2;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Resources.getSystem().getConfiguration().getLocales().get(0);
        }
        return Locale.getDefault();
    }

    public final Locale O00000o(Context context) {
        if (CoreApi.O000OO00() && CoreApi.O000000o().O0000O0o()) {
            return CoreApi.O000000o().O00oOooo();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
        String O00000Oo2 = gpy.O00000Oo(sharedPreferences, "locale_language", "");
        String O00000Oo3 = gpy.O00000Oo(sharedPreferences, "locale_country", "");
        if (TextUtils.isEmpty(O00000Oo2) || TextUtils.isEmpty(O00000Oo3)) {
            return null;
        }
        return new Locale(O00000Oo2, O00000Oo3);
    }

    public final ServerBean O00000Oo(Context context, String str) {
        if (context != null) {
            try {
                for (ServerBean next : O000000o(O00000o0(context), context)) {
                    if (next.O00000Oo.equalsIgnoreCase(str)) {
                        return next;
                    }
                }
                return null;
            } catch (Exception e) {
                if (!gfr.f17662O000000o) {
                    return null;
                }
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("context is null");
        }
    }

    public final boolean O0000Ooo() {
        return CoreApi.O000000o().O0000O0o();
    }

    public final String O0000o00() {
        return CoreApi.O000000o().O00oOooO();
    }

    public final ServerBean O0000o0O() {
        return CoreApi.O000000o().O0000ooO();
    }

    public final fsn O000000o(Locale locale, fsm<Void, fso> fsm) {
        return CoreApi.O000000o().O000000o(locale, fsm);
    }

    public final boolean O00000oO(Context context) {
        return O00000Oo(O000000o(context));
    }

    public final boolean O00000o0(ServerBean serverBean) {
        return O000000o(serverBean, "CN");
    }

    public final boolean O00000oo(Context context) {
        return O000000o(O000000o(context), "CN");
    }

    public final boolean O0000O0o(Context context) {
        ServerBean O000000o2 = O000000o(context);
        return O000000o2 != null && TextUtils.equals(O000000o2.f7546O000000o, "de");
    }

    public final boolean O00000o(ServerBean serverBean) {
        return serverBean != null && TextUtils.equals(serverBean.f7546O000000o, "de");
    }

    public final boolean O0000OOo(Context context) {
        return O000000o(O000000o(context), "KR");
    }

    public final boolean O00000oO(ServerBean serverBean) {
        return O000000o(serverBean, "KR");
    }

    public final boolean O00000oo(ServerBean serverBean) {
        return O000000o(serverBean, "TW");
    }

    public final boolean O0000Oo0(Context context) {
        return O000000o(O000000o(context), "TW");
    }

    public final boolean O0000O0o(ServerBean serverBean) {
        return O000000o(serverBean, "IN");
    }

    public final boolean O0000Oo(Context context) {
        return O000000o(O000000o(context), "IN");
    }

    public final boolean O0000OoO(Context context) {
        return O000000o(O000000o(context), "GB");
    }

    public final boolean O0000OOo(ServerBean serverBean) {
        return O000000o(serverBean, "US");
    }

    public final boolean O0000Ooo(Context context) {
        return O000000o(O000000o(context), "US");
    }

    public final boolean O0000Oo0(ServerBean serverBean) {
        return O000000o(serverBean, "RU");
    }

    public final boolean O0000o00(Context context) {
        return O000000o(O000000o(context), "RU");
    }

    public final boolean O0000Oo(ServerBean serverBean) {
        return O000000o(serverBean, "SG");
    }

    public final boolean O0000o0(Context context) {
        return O000000o(O000000o(context), "SG");
    }

    public final boolean O0000OoO(ServerBean serverBean) {
        return O000000o(serverBean, "st");
    }

    public final boolean O0000o0O(Context context) {
        return O000000o(O000000o(context), "st");
    }

    private static boolean O000000o(ServerBean serverBean, String str) {
        return serverBean != null && str.equalsIgnoreCase(serverBean.O00000Oo);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void O000000o(Context context, ServerBean serverBean) {
        String str;
        if (O0000oO0(context)) {
            ServerBean serverBean2 = this.O0000oO0.get();
            if (serverBean2 != null) {
                this.O0000oO0.compareAndSet(serverBean2, serverBean);
            }
            if (serverBean == null) {
                str = "";
            } else {
                try {
                    str = serverBean.O000000o();
                } catch (Exception e) {
                    if (gfr.f17662O000000o) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            O0000o0o(context).edit().putString("server_json", str).apply();
            context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0).edit().putString("server_new", str).commit();
            StringBuilder sb = new StringBuilder("saveServer: ");
            sb.append(serverBean != null ? serverBean.O00000Oo() : null);
            gsy.O00000Oo("ServerApiImpl", sb.toString());
        }
    }

    public final boolean O0000o0() {
        return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
    }

    public final ServerBean O00000Oo() {
        return (ServerBean) this.O00000o.clone();
    }

    public final ServerBean O00000o0() {
        return (ServerBean) this.O00000oO.clone();
    }

    public final ServerBean O00000o() {
        return (ServerBean) this.O00000oo.clone();
    }

    public final ServerBean O00000oO() {
        return (ServerBean) this.O0000O0o.clone();
    }

    public final ServerBean O00000oo() {
        return (ServerBean) this.O0000OOo.clone();
    }

    public final ServerBean O0000O0o() {
        return (ServerBean) this.O0000Oo0.clone();
    }

    public final ServerBean O0000OOo() {
        return (ServerBean) this.O0000Oo.clone();
    }

    public final ServerBean O0000Oo0() {
        return (ServerBean) this.O0000OoO.clone();
    }

    public final ServerBean O0000Oo() {
        return (ServerBean) this.O0000Ooo.clone();
    }

    public final ServerBean O0000OoO() {
        return (ServerBean) this.O0000o00.clone();
    }

    private boolean O0000oO0(Context context) {
        if (this.O00000Oo == null) {
            synchronized (ftn.class) {
                if (this.O00000Oo == null) {
                    this.O00000Oo = Boolean.valueOf(ftm.O00000o(context));
                    boolean booleanValue = this.O00000Oo.booleanValue();
                    return booleanValue;
                }
            }
        }
        return this.O00000Oo.booleanValue();
    }

    public final boolean O00000Oo(ServerBean serverBean) {
        return serverBean != null && !O000000o(serverBean, "CN");
    }
}

package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class fju {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fju f16502O000000o;
    private static Object O00000Oo = new Object();
    private SharedPreferences O00000o;
    private boolean O00000o0 = false;
    private SharedPreferences O00000oO;
    private Context O00000oo = CommonApplication.getAppContext();
    private boolean O0000O0o;
    private boolean O0000OOo;
    private ServerBean O0000Oo;
    private boolean O0000Oo0;
    private String O0000OoO;
    private Locale O0000Ooo;
    private final List<fjv> O0000o0 = new ArrayList();
    private final Map<String, String> O0000o00 = new o0O0OOO0();

    /* access modifiers changed from: private */
    public static /* synthetic */ Object O000000o(Object obj) throws RuntimeException {
        return obj;
    }

    private fju() {
        boolean z;
        synchronized (O00000Oo) {
            z = this.O00000o0;
            if (!this.O00000o0) {
                this.O00000o0 = true;
            }
        }
        if (!z) {
            this.O00000oO = this.O00000oo.getSharedPreferences("prefs_disclaim", 0);
            this.O0000O0o = this.O00000oO.getBoolean("pref_key_smarthome_show_disclaim", true);
            this.O0000OOo = this.O00000oO.getBoolean("pref_key_smarthome_disclaim_confirmed", false);
            this.O00000o = this.O00000oo.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
            this.O0000Oo = ftn.O00000Oo(this.O00000oo);
            if (gfr.O0000Oo0) {
                this.O0000OoO = "release";
            } else {
                this.O0000OoO = this.O00000o.getString("server_env", "release");
            }
            String string = this.O00000o.getString("locale_language", "");
            String string2 = this.O00000o.getString("locale_country", "");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                O0000Oo0();
            } else {
                this.O0000Ooo = new Locale(string, string2);
            }
            gqb.O000000o(this.O00000o.getString("unit", ""), this.O0000o00);
        }
    }

    public static fju O000000o() {
        if (f16502O000000o == null) {
            synchronized (O00000Oo) {
                if (f16502O000000o == null) {
                    f16502O000000o = new fju();
                }
            }
        }
        return f16502O000000o;
    }

    public final synchronized boolean O00000Oo() {
        return this.O0000O0o;
    }

    public final synchronized boolean O00000o0() {
        return this.O0000OOo;
    }

    public final synchronized void O000000o(boolean z, boolean z2) {
        this.O0000O0o = z;
        this.O0000OOo = z2;
        O0000Oo();
    }

    private synchronized void O0000Oo() {
        gpy.O000000o(this.O00000oO, "pref_key_smarthome_show_disclaim", this.O0000O0o);
        gpy.O000000o(this.O00000oO, "pref_key_smarthome_show_disclaim_new", this.O0000O0o);
        gpy.O000000o(this.O00000oO, "pref_key_smarthome_disclaim_confirmed", this.O0000OOo);
    }

    public final synchronized ServerBean O00000o() {
        return this.O0000Oo;
    }

    public final synchronized void O000000o(ServerBean serverBean) {
        this.O0000Oo = serverBean;
        O0000OoO();
    }

    public final synchronized boolean O00000oO() {
        return ftn.O00000Oo(this.O0000Oo);
    }

    private synchronized void O0000OoO() {
        ftn.O000000o(this.O00000oo, this.O0000Oo);
    }

    public final synchronized String O00000oo() {
        return this.O0000OoO;
    }

    private synchronized void O0000Ooo() {
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            gpy.O000000o(this.O00000o, "server_env", this.O0000OoO);
        }
    }

    public final synchronized Locale O0000O0o() {
        return this.O0000Ooo;
    }

    public final synchronized void O000000o(Locale locale) {
        if (locale != null) {
            this.O0000Ooo = locale;
            O0000o00();
        }
    }

    public final synchronized void O000000o(boolean z) {
        this.O0000Oo0 = z;
    }

    public final synchronized boolean O0000OOo() {
        return this.O0000Oo0;
    }

    public final Pair<String, fkv<Object, Object>> O00000Oo(String str) {
        String str2 = this.O0000o00.get(str);
        if (str2 == null) {
            str2 = O00000o0(str);
        }
        Map map = fjw.O00000Oo.get(str);
        if (map != null && map.get(str2) != null) {
            return new Pair<>(str2, map.get(str2));
        }
        LogType logType = LogType.DEVICE_CONTROL;
        gsy.O00000o0(logType, "GlobalDynamicSettingManager", "unit:" + str + " target:" + str2);
        return new Pair<>(str2, $$Lambda$fju$JVLH2UNnyaqhYeokCyiZNR6w9g.INSTANCE);
    }

    public final String O00000o0(String str) {
        String str2;
        if ("℃".equals(str)) {
            ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
            if (O000000o2 == null) {
                str2 = "";
            } else {
                str2 = O000000o2.O00000Oo;
            }
            if ("US".equals(str2) || "PR".equals(str2) || "GU".equals(str2) || "VI".equals(str2) || "BS".equals(str2) || "BZ".equals(str2) || "KY".equals(str2) || "PW".equals(str2)) {
                return "°F";
            }
            return "℃";
        } else if (!"°C".equals(str)) {
            return str;
        } else {
            String str3 = this.O0000o00.get("℃");
            return str3 == null ? O00000o0("℃") : str3;
        }
    }

    public final void O000000o(fjv fjv) {
        if (fjv != null && !this.O0000o0.contains(fjv)) {
            this.O0000o0.add(fjv);
        }
    }

    public final void O00000Oo(fjv fjv) {
        this.O0000o0.remove(fjv);
    }

    public final synchronized void O000000o(String str, String str2) {
        String put = this.O0000o00.put(str, str2);
        if (!TextUtils.equals(put, str2)) {
            for (int size = this.O0000o0.size() - 1; size >= 0; size--) {
                this.O0000o0.get(size).onUnitChange(str, put, str2);
            }
        }
        O0000o00();
    }

    private synchronized void O0000o00() {
        if (this.O0000Ooo != null) {
            String language = this.O0000Ooo.getLanguage();
            String country = this.O0000Ooo.getCountry();
            gpy.O000000o(this.O00000o, "locale_language", language);
            gpy.O000000o(this.O00000o, "locale_country", country);
        }
        gpy.O000000o(this.O00000o, "unit", gqb.O000000o(this.O0000o00));
    }

    public final synchronized void O0000Oo0() {
        SharedPreferences.Editor edit = this.O00000o.edit();
        edit.remove("locale_language");
        edit.remove("locale_country");
        edit.apply();
        this.O0000Ooo = null;
    }

    public final synchronized void O000000o(String str) {
        if (!TextUtils.isEmpty(str) && (str.equalsIgnoreCase("release") || str.equalsIgnoreCase("preview"))) {
            this.O0000OoO = str;
            O0000Ooo();
        }
    }
}

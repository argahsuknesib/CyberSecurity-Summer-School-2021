package _m_j;

import android.content.Context;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class dkg {
    private static dkg O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    List<String> f14740O000000o = null;
    volatile int O00000Oo = 2;
    volatile HttpHost O00000o = null;
    public volatile String O00000o0 = "";
    int O00000oO = 0;
    Context O00000oo = null;
    /* access modifiers changed from: private */
    public dlp O0000O0o = null;
    private dlm O0000Oo0 = null;

    public static dkg O000000o(Context context) {
        if (O0000OOo == null) {
            synchronized (dkg.class) {
                if (O0000OOo == null) {
                    O0000OOo = new dkg(context);
                }
            }
        }
        return O0000OOo;
    }

    private static boolean O00000Oo(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private String O00000o() {
        try {
            return !O00000Oo("pingma.qq.com") ? InetAddress.getByName("pingma.qq.com").getHostAddress() : "";
        } catch (Exception e) {
            this.O0000Oo0.O00000Oo((Throwable) e);
            return "";
        }
    }

    private void O00000oO() {
        String O00000o2 = O00000o();
        if (dkd.O00000Oo()) {
            this.O0000Oo0.O000000o("remoteIp ip is ".concat(String.valueOf(O00000o2)));
        }
        if (dlv.O00000o0(O00000o2)) {
            if (!this.f14740O000000o.contains(O00000o2)) {
                String str = this.f14740O000000o.get(this.O00000oO);
                if (dkd.O00000Oo()) {
                    dlm dlm = this.O0000Oo0;
                    dlm.O00000o0(O00000o2 + " not in ip list, change to:" + str);
                }
                O00000o2 = str;
            }
            dkd.O00000o0("http://" + O00000o2 + ":80/mstat/report");
        }
    }

    private void O00000oo() {
        this.O00000Oo = 0;
        this.O00000o = null;
        this.O00000o0 = null;
    }

    public final void O000000o(String str) {
        if (dkd.O00000Oo()) {
            this.O0000Oo0.O000000o("updateIpList ".concat(String.valueOf(str)));
        }
        try {
            if (dlv.O00000o0(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString(keys.next());
                        if (dlv.O00000o0(string)) {
                            for (String str2 : string.split(";")) {
                                if (dlv.O00000o0(str2)) {
                                    String[] split = str2.split(":");
                                    if (split.length > 1) {
                                        String str3 = split[0];
                                        if (O00000Oo(str3) && !this.f14740O000000o.contains(str3)) {
                                            if (dkd.O00000Oo()) {
                                                this.O0000Oo0.O000000o("add new ip:".concat(String.valueOf(str3)));
                                            }
                                            this.f14740O000000o.add(str3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.O0000Oo0.O00000Oo((Throwable) e);
        }
        this.O00000oO = new Random().nextInt(this.f14740O000000o.size());
    }

    public final boolean O000000o() {
        return this.O00000Oo == 1;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != 0;
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        if (dmb.O00000oO(this.O00000oo)) {
            if (dkd.O0000O0o) {
                O00000oO();
            }
            this.O00000o0 = dlv.O0000OoO(this.O00000oo);
            if (dkd.O00000Oo()) {
                dlm dlm = this.O0000Oo0;
                dlm.O000000o("NETWORK name:" + this.O00000o0);
            }
            if (dlv.O00000o0(this.O00000o0)) {
                this.O00000Oo = "WIFI".equalsIgnoreCase(this.O00000o0) ? 1 : 2;
                this.O00000o = dlv.O000000o(this.O00000oo);
            }
            if (dke.O000000o()) {
                dke.O00000o0(this.O00000oo);
                return;
            }
            return;
        }
        if (dkd.O00000Oo()) {
            this.O0000Oo0.O000000o("NETWORK TYPE: network is close.");
        }
        O00000oo();
    }

    private dkg(Context context) {
        this.O00000oo = context.getApplicationContext();
        this.O0000O0o = new dlp();
        dmi.O000000o(context);
        this.O0000Oo0 = dlv.O00000o0();
        O00000oo();
        this.f14740O000000o = new ArrayList(10);
        this.f14740O000000o.add("117.135.169.101");
        this.f14740O000000o.add("140.207.54.125");
        this.f14740O000000o.add("180.153.8.53");
        this.f14740O000000o.add("120.198.203.175");
        this.f14740O000000o.add("14.17.43.18");
        this.f14740O000000o.add("163.177.71.186");
        this.f14740O000000o.add("111.30.131.31");
        this.f14740O000000o.add("123.126.121.167");
        this.f14740O000000o.add("123.151.152.111");
        this.f14740O000000o.add("113.142.45.79");
        this.f14740O000000o.add("123.138.162.90");
        this.f14740O000000o.add("103.7.30.94");
        O00000o0();
    }
}

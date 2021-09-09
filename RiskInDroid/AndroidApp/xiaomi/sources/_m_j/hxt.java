package _m_j;

import org.json.JSONObject;

public abstract class hxt {

    /* renamed from: O000000o  reason: collision with root package name */
    public hyg f960O000000o = new hyg("result");
    public hxb O00000Oo;

    public static String O000000o() {
        return !fdc.O000000o().O0000o0() ? fcn.O000000o().O00000Oo() : "";
    }

    public static boolean O000000o(String str) {
        return "xiaomi.repeater.v1".equals(str) || "xiaomi.repeater.v2".equals(str) || "xiaomi.repeater.v3".equals(str);
    }

    public final void O000000o(String str, long j) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            String O000000o2 = O000000o();
            hxb O00000Oo2 = hxi.O0000Oo.O00000Oo();
            this.f960O000000o.O000000o("add_fail_device", "model", str, "time", Long.valueOf(j), "add_device_session", Long.valueOf(O00000Oo2.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo2.O00000Oo.incrementAndGet()), "uid", O000000o2);
        }
    }

    public final void O000000o(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        if (flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O000000o(3, "StatPageV2", String.format("adddevice_system_success model=%s, miuiversion =%s,category=%d, routerLevel=%d,extra =%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
            return;
        }
        String O000000o2 = O000000o();
        int O000000o3 = hxw.O000000o(str);
        String O000000o4 = hxy.O000000o(str5);
        hxb O00000Oo2 = hxi.O0000Oo.O00000Oo();
        this.f960O000000o.O000000o("adddevice_system_success", "model", str, "miui_version", str2, "category", Integer.valueOf(i), "add_device_session", Long.valueOf(O00000Oo2.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo2.O00000Oo.incrementAndGet()), "uid", O000000o2, "router_level", Integer.valueOf(i2), "sc_type", Integer.valueOf(O000000o3), "extra", str3, "real_model", str4, "did", O000000o4);
    }

    public final void O00000Oo(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        if (flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O000000o(3, "StatPageV2", String.format("adddevice_app_succrss model=%s, miuiversion =%s,category=%d, routerLevel=%d,extra =%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
            return;
        }
        int O000000o2 = hxw.O000000o(str);
        String O000000o3 = O000000o();
        String O000000o4 = hxy.O000000o(str5);
        hxb O00000Oo2 = hxi.O0000Oo.O00000Oo();
        this.f960O000000o.O000000o("adddevice_app_succrss", "model", str, "miui_version", str2, "category", Integer.valueOf(i), "add_device_session", Long.valueOf(O00000Oo2.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo2.O00000Oo.incrementAndGet()), "uid", O000000o3, "router_level", Integer.valueOf(i2), "sc_type", Integer.valueOf(O000000o2), "extra", str3, "real_model", str4, "did", O000000o4);
    }

    public final void O000000o(String str, int i) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            String O000000o2 = O000000o();
            this.f960O000000o.O000000o("adddevice_link_time_30min.AP", "model", str, "success", Integer.valueOf(i), "uid", O000000o2);
        }
    }

    public final void O00000Oo(String str, int i) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            String O000000o2 = O000000o();
            this.f960O000000o.O000000o("adddevice_link_startlink", "model", str, "time", Integer.valueOf(i), "uid", O000000o2);
        }
    }

    public final void O000000o(String str, String str2, String str3) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o && !flu.O00000oO().O00000o0(str)) {
            String O000000o2 = O000000o();
            String O000000o3 = hxy.O000000o(str3);
            this.f960O000000o.O000000o("add_bluetooth_success", "model", str, "type", str2, "uid", O000000o2, "mac", O000000o3);
        }
    }

    public final void O000000o(String str, String str2, int i, String str3, String str4, String str5) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o && !flu.O00000oO().O00000o0(str)) {
            String O000000o2 = O000000o();
            String O000000o3 = hxy.O000000o(str5);
            this.f960O000000o.O000000o("add_bluetooth_fail", "model", str, "type", str2, "failcode", Integer.valueOf(i), "uid", O000000o2, "firversion", str3, "authtype", str4, "mac", O000000o3);
        }
    }

    public final void O000000o(int i) {
        hxi.O0000Oo.O00000Oo();
        this.f960O000000o.O000000o("check_plugin", "type", Integer.valueOf(i));
    }

    public final void O000000o(String str, String str2, String str3, boolean z) {
        hxi.O0000Oo.O00000Oo();
        this.f960O000000o.O000000o("plg_tfid_set", "model", str, "dtype", str2, "uid", str3, "status", Boolean.valueOf(z), "time", Long.valueOf(System.currentTimeMillis()));
    }

    public final void O000000o(int i, String str) {
        this.f960O000000o.O000000o("plugin_download_error", "code", Integer.valueOf(i), "value", str);
    }

    public final void O000000o(int i, JSONObject jSONObject) {
        this.f960O000000o.O000000o("app_common_log", "type", Integer.valueOf(i), "value", jSONObject);
    }

    public final void O000000o(long j, String str) {
        this.f960O000000o.O000000o("plugin_download_time", "time", Long.valueOf(j), "model", str);
    }

    public final void O000000o(long j, String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (O000000o(str) || flu.O00000oO().O00000o0() || gfr.f17662O000000o) {
            return;
        }
        if (i == 0 || hxw.O000000o()) {
            if (j >= 60000) {
                j = -1;
            }
            this.f960O000000o.O000000o("rpc_remote_result", "time", Long.valueOf(j), "errorcode", Integer.valueOf(i), "model", str, "did", str2, "extra", str3, "payload", str4, "accounttype", str5, "pluginversion", Integer.valueOf(i2));
        }
    }

    public final void O000000o(long j, String str, int i, String str2, String str3, String str4, int i2) {
        if (!O000000o(str) && !flu.O00000oO().O00000o0() && !gfr.f17662O000000o) {
            if (j >= 60000) {
                j = -1;
            }
            this.f960O000000o.O000000o("rpc_local_result", "time", Long.valueOf(j), "errorcode", Integer.valueOf(i), "model", str, "did", str2, "extra", str3, "payload", str4, "pluginversion", Integer.valueOf(i2));
        }
    }

    public static boolean O00000Oo(String str) {
        if (!O000000o(str) && !flu.O00000oO().O00000o0() && !gfr.f17662O000000o && !flu.O00000oO().O00000o0(str)) {
            return true;
        }
        return false;
    }

    public final void O000000o(String str, String str2, boolean z, int i, int i2) {
        if (O00000Oo(str)) {
            this.f960O000000o.O000000o("scan_ble_result", "model", str, "uid", str2, "findDevice", Integer.valueOf(z ? 1 : 0), "scanDuration", Integer.valueOf(i), "scanRepeat", Integer.valueOf(i2));
            return;
        }
        gsy.O00000Oo("scan_ble_result", String.format("model=%s,uid=%s,scanSuccess=%s,scanDuration=%d,scanRepeat=%d", str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public final hxb O00000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new hxb();
        }
        return this.O00000Oo;
    }

    public final void O00000o0(String str, int i) {
        if (!O000000o(str) && !flu.O00000oO().O00000o0() && !gfr.f17662O000000o) {
            this.f960O000000o.O000000o("ble_update_result", "model", str, "errorcode", Integer.valueOf(i));
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        if (jSONObject != null && !flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            this.f960O000000o.O000000o("connect_device_step_spending", jSONObject);
        }
    }

    public final void O000000o(String str, boolean z, boolean z2, int i, String str2) {
        hyg hyg = this.f960O000000o;
        Object[] objArr = new Object[10];
        objArr[0] = "device_model";
        objArr[1] = str;
        int i2 = 2;
        objArr[2] = "source";
        if (!z) {
            i2 = 1;
        }
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = "online_status";
        objArr[5] = Integer.valueOf(z2 ? 1 : 0);
        objArr[6] = "pid";
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "did";
        objArr[9] = str2;
        hyg.O000000o("offline_enter_stat", objArr);
    }
}

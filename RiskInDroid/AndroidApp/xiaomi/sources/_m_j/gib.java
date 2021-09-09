package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;

@RouterService
public class gib implements hve {
    public void adddevice_connect_fail_show(String str, int i) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_connect_fail_show", "model", str, "type", Integer.valueOf(i));
    }

    public void adddevice_connecting_show(String str) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_connecting_show", "model", str);
    }

    public long page_AP_step_success(String str, long j, int i, int i2) {
        String str2;
        hxp hxp = hxi.O00000o0;
        if (flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O000000o(3, "StatPageV2", String.format("page device success ,model =%s,step = %d, step duration =%d ", str, Integer.valueOf(i), Integer.valueOf(i2)));
            return -1;
        }
        if (!fdc.O000000o().O0000o0()) {
            str2 = fcn.O000000o().O00000Oo();
        } else {
            str2 = "";
            j = 0;
        }
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return hxp.f957O000000o.O000000o("page_device_success", "model", str, "add_device_session", Long.valueOf(O00000Oo.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo.O00000Oo.incrementAndGet()), "step", Integer.valueOf(i), "uid", str2, "did", Long.valueOf(j), "step_duration", Integer.valueOf(i2));
    }

    public long page_mobile_device(String str, long j) {
        return hxi.O00000o0.O000000o(str, j);
    }

    public long pageDeviceFail(hxy hxy) {
        if (hxy != null) {
            hxy.O0000OOo = htr.O000000o().O00000Oo();
        }
        return hxi.O00000o0.O000000o(hxy);
    }

    public long page_device_fail4Combo(long j, String str, int i, int i2, String str2, String str3, String str4, String str5) {
        String O00000Oo = htr.O000000o().O00000Oo();
        hxp hxp = hxi.O00000o0;
        if (flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O00000Oo("pageDeviceFail4Combo", String.format("model =%s, bindKey=%s", str, str5));
            return -1;
        }
        String O000000o2 = hxy.O000000o(Long.valueOf(j));
        String O00000Oo2 = !fdc.O000000o().O0000o0() ? fcn.O000000o().O00000Oo() : "";
        int O000000o3 = hxw.O000000o(str);
        hxb O00000Oo3 = hxi.O0000Oo.O00000Oo();
        return hxp.f957O000000o.O000000o("page_device_fail", "model", str, "add_device_session", Long.valueOf(O00000Oo3.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo3.O00000Oo.incrementAndGet()), "step", Integer.valueOf(i), "ble", Integer.valueOf(i2), "uid", O00000Oo2, "did", O000000o2, "router_ssid", O00000Oo, "ssid", str2, "mac", str3, "firversion", str4, "sc_type", Integer.valueOf(O000000o3), "bind_key", str5);
    }

    public long page_addcamerareset(long j) {
        hxp hxp = hxi.O00000o0;
        if (j > 0) {
            return hxp.f957O000000o.O000000o("page_addcamerareset", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
        }
        return hxp.f957O000000o.O000000o("page_addcamerareset", "page", 1);
    }

    public long page_wlan(String str, long j) {
        hxp hxp = hxi.O00000o0;
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return hxp.O000000o("page_wlan", O00000Oo.f939O000000o, O00000Oo.O00000Oo.incrementAndGet(), str, j);
    }

    public long page_router(String str, long j) {
        hxp hxp = hxi.O00000o0;
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return hxp.O000000o("page_router", O00000Oo.f939O000000o, O00000Oo.O00000Oo.incrementAndGet(), str, j);
    }

    public void adddevice_wifi_show(String str, int i) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_wifi_show", "model", str, "from", Integer.valueOf(i));
    }

    public void adddevice_connect_success_show(String str) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_connect_success_show", "model", str);
    }

    public long page_failovertime(String str, long j) {
        hxp hxp = hxi.O00000o0;
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return hxp.O000000o("page_failovertime", O00000Oo.f939O000000o, O00000Oo.O00000Oo.incrementAndGet(), str, j);
    }

    public long page_failtm(String str, long j) {
        hxp hxp = hxi.O00000o0;
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return hxp.O000000o("page_failtm", O00000Oo.f939O000000o, O00000Oo.O00000Oo.incrementAndGet(), str, j);
    }

    public void adddevice_QR_show(String str) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_QR_show", "model", str);
    }

    public void adddevice_scanning_fail_show(String str) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_scanning_fail_show", "model", str);
    }

    public void adddevice_scanning_show(String str) {
        hxi.O00000o0.f957O000000o.O000000o("adddevice_scanning_show", "model", str);
    }

    public long page_scan_device(long j, String str) {
        hxp hxp = hxi.O00000o0;
        if (j == 0) {
            return hxp.f957O000000o.O000000o("page_scan_device", "page", 1, "model", str);
        }
        return hxp.f957O000000o.O000000o("page_scan_device", "page", 2, "model", str, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public long page_use_miui_wifi_pwd(String str) {
        hxp hxp = hxi.O00000o0;
        if (flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O000000o(3, "StatPageV2", String.format("use miui wifi pwd, model = %s", str));
            return -1;
        }
        String O00000Oo = !fdc.O000000o().O0000o0() ? fcn.O000000o().O00000Oo() : "";
        hxi.O0000Oo.O00000Oo();
        return hxp.f957O000000o.O000000o("page_use_miui_wifi_pwd", "model", str, "uid", O00000Oo);
    }

    public void reportKuailianOldResult(String str, String str2, String str3) {
        hxi.O00000o0.f957O000000o.O000000o("kuailian_result_old_logic", "ssid", str, "className", str2, "methodName", str3);
    }
}

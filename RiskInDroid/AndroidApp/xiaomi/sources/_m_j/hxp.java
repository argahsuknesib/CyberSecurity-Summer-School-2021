package _m_j;

public abstract class hxp {

    /* renamed from: O000000o  reason: collision with root package name */
    public hyg f957O000000o = new hyg("pgv2");

    private long O000000o(String str, long j, int i, String str2) {
        return this.f957O000000o.O000000o(str, "add_device_session", Long.valueOf(j), "add_device_order", Integer.valueOf(i), "model", str2, "page", 1);
    }

    private long O00000Oo(String str, long j, int i, String str2, long j2) {
        return this.f957O000000o.O000000o(str, "add_device_session", Long.valueOf(j), "add_device_order", Integer.valueOf(i), "model", str2, "time", Long.valueOf((System.currentTimeMillis() - j2) / 1000), "page", 2);
    }

    public final long O000000o(String str, long j, int i, String str2, long j2) {
        return j2 > 0 ? O00000Oo(str, j, i, str2, j2) : O000000o(str, j, i, str2);
    }

    public final long O000000o(String str, long j) {
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        return O000000o("page_mobile_device", O00000Oo.f939O000000o, O00000Oo.O00000Oo.incrementAndGet(), str, j);
    }

    public final long O000000o(hxy hxy) {
        if (hxy == null || flu.O00000oO().O00000Oo() || gfr.f17662O000000o) {
            gsy.O00000Oo("pageDeviceFail", hxy != null ? hxy.toString() : "empty stat info");
            return -1;
        }
        String O00000Oo = !fdc.O000000o().O0000o0() ? fcn.O000000o().O00000Oo() : "";
        int O000000o2 = hxw.O000000o(hxy.O00000Oo);
        hxb O00000Oo2 = hxi.O0000Oo.O00000Oo();
        return this.f957O000000o.O000000o("page_device_fail", "model", hxy.O00000Oo, "add_device_session", Long.valueOf(O00000Oo2.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo2.O00000Oo.incrementAndGet()), "step", Integer.valueOf(hxy.O00000o0), "uid", O00000Oo, "did", hxy.f964O000000o, "firversion", hxy.O00000o, "router_ssid", hxy.O0000OOo, "router_level", Integer.valueOf(hxy.O00000oo), "device_wifi_level", Integer.valueOf(hxy.O0000O0o), "ssid", hxy.O0000Oo0, "extra", hxy.O0000Oo, "sc_type", Integer.valueOf(O000000o2), "bind_key", hxy.O0000OoO);
    }

    public final long O000000o(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_home", "page", 1);
        }
        return this.f957O000000o.O000000o("page_home", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O00000Oo(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("auto_fav_stay", "page", 1);
        }
        return this.f957O000000o.O000000o("auto_fav_stay", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O00000o0(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_mycanter", "page", 1);
        }
        return this.f957O000000o.O000000o("page_mycanter", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O000000o(long j, int i, int i2, int i3, int i4) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_family", "page", 1, "home_number", Integer.valueOf(i), "sharehome_number", Integer.valueOf(i2), "invite_number", Integer.valueOf(i3), "from", Integer.valueOf(i4));
        }
        return this.f957O000000o.O000000o("page_family", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O00000o(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_roomadmin", "page", 1);
        }
        return this.f957O000000o.O000000o("page_roomadmin", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O00000oO(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_roomadjust", "page", 1);
        }
        return this.f957O000000o.O000000o("page_roomadjust", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O00000oo(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_roomset", "page", 1);
        }
        return this.f957O000000o.O000000o("page_roomset", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final long O0000O0o(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("page_share", "page", 1);
        }
        return this.f957O000000o.O000000o("page_share", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final void O000000o(int i) {
        this.f957O000000o.O000000o("mine_myminiprograms_show", "shareable_devices", Integer.valueOf(i));
    }

    public final long O0000OOo(long j) {
        if (j == 0) {
            return this.f957O000000o.O000000o("room_room_detail_show", "page", 1);
        }
        return this.f957O000000o.O000000o("room_room_detail_show", "page", 2, "time", Float.valueOf(((float) (System.currentTimeMillis() - j)) / 1000.0f));
    }

    public final void O00000Oo(int i) {
        this.f957O000000o.O000000o("room_device_edit_show", "from", Integer.valueOf(i));
    }

    public final void O000000o(String str) {
        this.f957O000000o.O000000o("adddevice_reset_show", "model", str);
    }

    public final void O000000o(String str, int i) {
        this.f957O000000o.O000000o("adddevice_BLE_deviceconfirm_show", "model", str, "from", Integer.valueOf(i));
    }

    public final void O00000Oo(String str, int i) {
        this.f957O000000o.O000000o("adddevice_BLE_androidconnectfail_show", "model", str, "type", Integer.valueOf(i));
    }

    public final void O00000Oo(String str) {
        this.f957O000000o.O000000o("adddevice_BLE_androidconnectsuccess_show", "model", str);
    }

    public final void O00000o0(String str, int i) {
        this.f957O000000o.O000000o("alert_app_p0p", "model", str, "number", Integer.valueOf(i));
    }

    public final void O00000o0(int i) {
        this.f957O000000o.O000000o(i != 1 ? i != 2 ? i != 3 ? "" : "content_child_detail_page" : "content_qqdetail_page" : "content_me_page", new Object[0]);
    }

    public final void O000000o() {
        this.f957O000000o.O000000o("allcamera_entry_show", new Object[0]);
    }

    public final void O000000o(int i, long j) {
        this.f957O000000o.O000000o("remove_popup", "click", Integer.valueOf(i), "used_time", Long.valueOf(j));
    }

    public final void O00000Oo() {
        this.f957O000000o.O000000o("favoritecamera_setting_show", new Object[0]);
    }

    public final void O00000o(int i) {
        this.f957O000000o.O000000o("favortiedevice_setting_show", "type", Integer.valueOf(i));
    }

    public final void O000000o(int i, String str) {
        this.f957O000000o.O000000o("card_edit_show", "from", Integer.valueOf(i), "type", str);
    }

    public final void O000000o(int i, String str, String str2) {
        this.f957O000000o.O000000o("ble_connect_error_code_show", "type", Integer.valueOf(i), "did", str, "model", str2);
    }

    public final void O000000o(int i, int i2) {
        this.f957O000000o.O000000o("location_auth_show", "type", Integer.valueOf(i), "from", Integer.valueOf(i2));
    }

    public final void O00000oO(int i) {
        this.f957O000000o.O000000o("home_scan_QRCode_jp", "type", Integer.valueOf(i));
    }

    public final void O00000o0() {
        this.f957O000000o.O000000o("uwb_mico_recommend_view", new Object[0]);
    }

    public final void O00000o() {
        this.f957O000000o.O000000o("uwb_view_mitv_card_player", new Object[0]);
    }

    public final void O00000oO() {
        this.f957O000000o.O000000o("uwb_view_mitv_card_history", new Object[0]);
    }

    public final void O00000oo(int i) {
        this.f957O000000o.O000000o("uwb_view_mitv_card", "user_auth", Integer.valueOf(i), "uwbdevice_type", 0, "device_model_0", null, "wait", null);
    }

    public final void O0000O0o(int i) {
        this.f957O000000o.O000000o("home_scan_failed_show", "type", Integer.valueOf(i));
    }
}

package _m_j;

import org.json.JSONObject;

public abstract class hxk {

    /* renamed from: O000000o  reason: collision with root package name */
    public hyg f952O000000o = new hyg("click");

    public final void O000000o() {
        this.f952O000000o.O000000o("ctoc_add_device", new Object[0]);
    }

    public final void O000000o(String str) {
        hyg hyg = this.f952O000000o;
        Object[] objArr = new Object[2];
        objArr[0] = "name";
        if (str == null) {
            str = "null";
        }
        objArr[1] = str;
        hyg.O000000o("ctoc_binding_enter", objArr);
    }

    public final void O00000Oo() {
        this.f952O000000o.O000000o("add_near_notfind", new Object[0]);
    }

    public final void O00000o0() {
        this.f952O000000o.O000000o("add_near_turnbluetooth", new Object[0]);
    }

    public final void O00000Oo(String str) {
        hxb O00000Oo = hxi.O0000Oo.O00000Oo();
        this.f952O000000o.O000000o("add_wait_next", "model", str, "add_device_session", Long.valueOf(O00000Oo.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo.O00000Oo.incrementAndGet()));
    }

    public final void O000000o(String str, long j) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            hxb O00000Oo = hxi.O0000Oo.O00000Oo();
            this.f952O000000o.O000000o("add_complete_click", "model", str, "time", Long.valueOf(j), "add_device_session", Long.valueOf(O00000Oo.f939O000000o), "add_device_order", Integer.valueOf(O00000Oo.O00000Oo.incrementAndGet()));
        }
    }

    public final void O00000o() {
        this.f952O000000o.O000000o("app_popup_cancel", new Object[0]);
    }

    public final void O000000o(String str, int i, String str2) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            int O000000o2 = hxw.O000000o(str);
            this.f952O000000o.O000000o("adddevice_selectdevice", "model", str, "source", Integer.valueOf(i), "unique", str2, "timestamp", Long.valueOf(System.currentTimeMillis() / 1000), "sctype", Integer.valueOf(O000000o2));
        }
    }

    public final void O00000Oo(String str, int i, String str2) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            int O000000o2 = hxw.O000000o(str);
            this.f952O000000o.O000000o("adddevice_connectdevice", "model", str, "source", Integer.valueOf(i), "unique", str2, "timestamp", Long.valueOf(System.currentTimeMillis() / 1000), "sctype", Integer.valueOf(O000000o2));
        }
    }

    public final void O000000o(String str, boolean z, int i, String str2, int i2, int i3, String str3, String str4) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            int O000000o2 = hxw.O000000o(str);
            this.f952O000000o.O000000o("adddevice_finishconnect", "model", str, "type", Integer.valueOf(z ? 1 : 0), "source", Integer.valueOf(i), "unique", str2, "failure", Integer.valueOf(i2), "retry", Integer.valueOf(i3), "did", str3, "encrypt_mac_did", str4, "timestamp", Long.valueOf(System.currentTimeMillis() / 1000), "sctype", Integer.valueOf(O000000o2));
        }
    }

    public final void O000000o(String str, int i) {
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            this.f952O000000o.O000000o("adddevice_ble_match", "model", str, "result", Integer.valueOf(i));
        }
    }

    public final void O00000o0(String str) {
        hyg hyg = this.f952O000000o;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        hyg.O000000o("miui_card_quick", objArr);
    }

    public final void O00000oO() {
        this.f952O000000o.O000000o("page_roomadjust_cancel", new Object[0]);
    }

    public final void O00000oo() {
        this.f952O000000o.O000000o("page_room_longclick", new Object[0]);
    }

    public final void O0000O0o() {
        this.f952O000000o.O000000o("page_family_entry", new Object[0]);
    }

    public final void O0000OOo() {
        this.f952O000000o.O000000o("page_family_add", new Object[0]);
    }

    public final void O00000Oo(String str, int i) {
        this.f952O000000o.O000000o("home_card_edit", "type", str, "from", Integer.valueOf(i));
    }

    public final void O00000o(String str) {
        this.f952O000000o.O000000o("home_room_switch", "room", str);
    }

    public final void O0000Oo0() {
        this.f952O000000o.O000000o("home_move_cancel", new Object[0]);
    }

    public final void O0000Oo() {
        this.f952O000000o.O000000o("home_move_confirm", new Object[0]);
    }

    public final void O00000oO(String str) {
        this.f952O000000o.O000000o("home_rename_cancel", "model", str);
    }

    public final void O00000oo(String str) {
        this.f952O000000o.O000000o("home_nodevice_ad_click", "url", str);
    }

    public final void O000000o(boolean z) {
        hyg hyg = this.f952O000000o;
        int i = 2;
        Object[] objArr = new Object[2];
        objArr[0] = "type";
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hyg.O000000o("miui_card_click", objArr);
    }

    public final void O000000o(String str, String str2) {
        this.f952O000000o.O000000o("set_server_click", "old", str, "new", str2);
    }

    public final void O000000o(String str, String str2, boolean z) {
        hyg hyg = this.f952O000000o;
        Object[] objArr = new Object[6];
        objArr[0] = "model";
        objArr[1] = str;
        int i = 2;
        objArr[2] = "room";
        objArr[3] = str2;
        objArr[4] = "share";
        if (!z) {
            i = 1;
        }
        objArr[5] = Integer.valueOf(i);
        hyg.O000000o("home_device_quick", objArr);
    }

    public final void O0000OoO() {
        this.f952O000000o.O000000o("Monitoring_DailyStory_ClickNum", new Object[0]);
    }

    public final void O000000o(int i) {
        this.f952O000000o.O000000o("notification_switch", "type", Integer.valueOf(i));
    }

    public final void O0000O0o(String str) {
        this.f952O000000o.O000000o("infrared_click", "title", str);
    }

    public final void O000000o(boolean z, String str) {
        this.f952O000000o.O000000o("plugin_deviceshare_mi_confirm", "result", Integer.valueOf(z ? 1 : 0), "account", str);
    }

    public final void O000000o(String str, boolean z) {
        this.f952O000000o.O000000o("mine_myminiprograms_share", "model", str, "result", Boolean.valueOf(z));
    }

    public final void O00000Oo(int i) {
        this.f952O000000o.O000000o("home_navigation_dropdown", "type", Integer.valueOf(i));
    }

    public final void O00000o0(int i) {
        this.f952O000000o.O000000o("home_navigation_dropdown_category", "room_id", Integer.valueOf(i));
    }

    public final void O0000OOo(String str) {
        this.f952O000000o.O000000o("general_countdown_use", "model", str);
    }

    public final void O00000o(int i) {
        this.f952O000000o.O000000o("room_device_edit_all", "type", Integer.valueOf(i));
    }

    public final void O00000Oo(String str, String str2) {
        this.f952O000000o.O000000o("rec_auto_activetime", "model", str, "sr_id", str2);
    }

    public final void O000000o(String str, String str2, String str3) {
        this.f952O000000o.O000000o("rec_choose_recdevice", "model", str, "sr_id", str2, "model2", str3);
    }

    public final void O00000Oo(String str, String str2, String str3) {
        this.f952O000000o.O000000o("rec_choose_recmoredevice", "model", str, "sr_id", str2, "model2", str3);
    }

    public final void O00000o0(String str, String str2, String str3) {
        this.f952O000000o.O000000o("rec_choose_recble", "model", str, "sr_id", str2, "model2", str3);
    }

    public final void O00000o0(String str, String str2) {
        this.f952O000000o.O000000o("rec_auto_activate", "model", str, "sr_id", str2);
    }

    public final void O00000oO(int i) {
        this.f952O000000o.O000000o("homeshare_acceptsuccess_switch", "from", Integer.valueOf(i), "type", 1);
    }

    public final void O0000Ooo() {
        this.f952O000000o.O000000o("homeshare_acceptsuccess_cancel", new Object[0]);
    }

    public final void O00000oo(int i) {
        this.f952O000000o.O000000o("home_management_delete", "from", Integer.valueOf(i));
    }

    public final void O0000Oo0(String str) {
        this.f952O000000o.O000000o("home_management_numberdetail_delete", "type", str);
    }

    public final void O0000o00() {
        this.f952O000000o.O000000o("homeshare_acceptalert_accept", new Object[0]);
    }

    public final void O0000O0o(int i) {
        this.f952O000000o.O000000o("adddevice_nearby_help_click", "nearby-device", Integer.valueOf(i));
    }

    public final void O000000o(int i, long j, String str) {
        this.f952O000000o.O000000o("adddevice_scan_result", "type", Integer.valueOf(i), "time", Long.valueOf(j), "model", str);
    }

    public final void O0000Oo(String str) {
        this.f952O000000o.O000000o("adddevice_selecthome_click", "type", str);
    }

    public final void O0000OoO(String str) {
        this.f952O000000o.O000000o("adddevice_rename_suggestname", "name", str);
    }

    public final void O0000Ooo(String str) {
        this.f952O000000o.O000000o("mi_push_click", "value", str);
    }

    public final void O0000o00(String str) {
        this.f952O000000o.O000000o("adddevice_reset_confirm", "model", str);
    }

    public final void O0000o0(String str) {
        this.f952O000000o.O000000o("adddevice_reset_next", "model", str);
    }

    public final void O0000o0() {
        this.f952O000000o.O000000o("oversea_ecom_agree", new Object[0]);
    }

    public final void O0000o0O(String str) {
        this.f952O000000o.O000000o("lightgroup_mesh_upgrade_click", "model", str);
    }

    public final void O00000o0(String str, int i) {
        this.f952O000000o.O000000o("adddevice_devicelist_more", "type", str, "number", Integer.valueOf(i));
    }

    public final void O0000o0o(String str) {
        this.f952O000000o.O000000o("adddevice_reset_details", "model", str);
    }

    public final void O0000o(String str) {
        this.f952O000000o.O000000o("alert_app_p0c", "model", str);
    }

    public final void O0000oO0(String str) {
        this.f952O000000o.O000000o("alert_app_p2c", "model", str);
    }

    public final void O000000o(String str, JSONObject jSONObject) {
        this.f952O000000o.O000000o(str, jSONObject);
    }

    public final void O000000o(String str, String str2, long j) {
        this.f952O000000o.O000000o("miui_push_receive", "type", str, "msgid", str2, "time", Long.valueOf(j));
    }

    public final void O0000OOo(int i) {
        this.f952O000000o.O000000o("notification_familydevicenotification_familyswitching_click", "switch", Integer.valueOf(i));
    }

    public final void O0000Oo0(int i) {
        this.f952O000000o.O000000o("room_movedevice_newroom_pop", "type", Integer.valueOf(i));
    }

    public final void O000000o(int i, String str, String str2) {
        this.f952O000000o.O000000o("content_intelligence_goods", "position", Integer.valueOf(i), "type", str, "name", str2);
    }

    public final void O00000Oo(int i, String str, String str2) {
        this.f952O000000o.O000000o("content_intelligence_qa", "position", Integer.valueOf(i), "type", str, "name", str2);
    }

    public final void O000000o(int i, String str, String str2, int i2) {
        String str3;
        switch (i2) {
            case 1:
                str3 = "content_recommend_position";
                break;
            case 2:
                str3 = "content_recommend_music";
                break;
            case 3:
                str3 = "content_recommend_list";
                break;
            case 4:
                str3 = "content_recommend_children";
                break;
            case 5:
                str3 = "content_recommend_sound";
                break;
            case 6:
                str3 = "content_recommend_obtain";
                break;
            default:
                str3 = "";
                break;
        }
        this.f952O000000o.O000000o(str3, "position", Integer.valueOf(i), "type", str, "name", str2);
    }

    public final void O0000o0O() {
        this.f952O000000o.O000000o("NFC_recom_click", new Object[0]);
    }

    public final void O0000Oo(int i) {
        this.f952O000000o.O000000o("content_sound_account", "type", Integer.valueOf(i));
    }

    public final void O000000o(int i, long j, int i2, int i3, int i4) {
        this.f952O000000o.O000000o("scene_create_sucess", "from_type", Integer.valueOf(i), "time_millis", Long.valueOf(j), "condition_count", Integer.valueOf(i2), "action_count", Integer.valueOf(i3), "auth_device_count", Integer.valueOf(i4));
    }

    public final void O00000Oo(String str, long j) {
        this.f952O000000o.O000000o("scene_condition_action_create", "which", str, "time_millis", Long.valueOf(j));
    }

    public final void O0000oO(String str) {
        this.f952O000000o.O000000o("alert.doublecheck.clk", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo(), "type", str);
    }

    public final void O0000OoO(int i) {
        this.f952O000000o.O000000o("sethomeaddress_click", "location", Integer.valueOf(i));
    }

    public final void O000000o(int i, int i2) {
        this.f952O000000o.O000000o("favorite_edit_add", "show", Integer.valueOf(i), "clk", Integer.valueOf(i2));
    }

    public final void O0000Ooo(int i) {
        this.f952O000000o.O000000o("favorite_page_add", "clk", Integer.valueOf(i));
    }

    public final void O000000o(String str, int i, boolean z, String str2) {
        if (z) {
            this.f952O000000o.O000000o("room_background_choose", "name", str, "style", Integer.valueOf(i), "clk", str2);
            return;
        }
        this.f952O000000o.O000000o("room_background_choose", "name", str, "style", Integer.valueOf(i), "slide", str2);
    }

    public final void O000000o(String str, boolean z, String str2) {
        if (z) {
            this.f952O000000o.O000000o("room_background_check", "name", str, "back", str2);
            return;
        }
        this.f952O000000o.O000000o("room_background_check", "name", str, "clk", str2);
    }

    public final void O0000oOO(String str) {
        this.f952O000000o.O000000o("h2m_background_check", "clk", str);
    }

    public final void O0000oOo(String str) {
        this.f952O000000o.O000000o("h2m_background_check_doublecheck", "clk", str);
    }

    public final void O0000oo0(String str) {
        this.f952O000000o.O000000o("new_room_create_new", "clk", str);
    }

    public final void O0000oo(String str) {
        this.f952O000000o.O000000o("room_management", "clk", str);
    }

    public final void O000000o(Integer num) {
        if (num == null) {
            this.f952O000000o.O000000o("old.passcode.window.show-up", new Object[0]);
            return;
        }
        this.f952O000000o.O000000o("old.passcode.window.click", "type", num);
    }

    public final void O00000Oo(Integer num) {
        if (num == null) {
            this.f952O000000o.O000000o("old.passcode.check.delete.show-up", new Object[0]);
            return;
        }
        this.f952O000000o.O000000o("old.passcode.check.delete.click", "type", num);
    }

    public final void O00000o0(Integer num) {
        this.f952O000000o.O000000o("safety_filter_click", "type", num);
    }

    public final void O0000o00(int i) {
        this.f952O000000o.O000000o("speaker_choose_click", "type", Integer.valueOf(i));
    }

    public final void O0000o0(int i) {
        this.f952O000000o.O000000o("speaker_filter_click", "type", Integer.valueOf(i));
    }

    public final void O0000o0O(int i) {
        this.f952O000000o.O000000o("Camera_PreConnectFail_Type", "errorCode", Integer.valueOf(i));
    }

    public final void O0000o0o(int i) {
        this.f952O000000o.O000000o("camera_play_click", "type", Integer.valueOf(i), "from", 1);
    }

    public final void O0000o(int i) {
        this.f952O000000o.O000000o("camera_playon_click", "from", Integer.valueOf(i));
    }

    public final void O00000Oo(int i, int i2) {
        this.f952O000000o.O000000o("camera_mute_click", "type", Integer.valueOf(i), "from", Integer.valueOf(i2));
    }

    public final void O0000oO0(int i) {
        this.f952O000000o.O000000o("camera_gotoplugin_click", "from", Integer.valueOf(i));
    }

    public final void O0000o0o() {
        this.f952O000000o.O000000o("favoritecamera_setting_click", new Object[0]);
    }

    public final void O0000oO(int i) {
        this.f952O000000o.O000000o("favortiedevice_setting_click", "type", Integer.valueOf(i));
    }

    public final void O0000oOO(int i) {
        this.f952O000000o.O000000o("camera_play_click_sim_three", "from", Integer.valueOf(i));
    }

    public final void O0000oOo(int i) {
        this.f952O000000o.O000000o("camera_play_click_sim_two", "from", Integer.valueOf(i));
    }

    public final void O00000o(String str, String str2) {
        this.f952O000000o.O000000o("TimeSlider_AllVedio_ClickNum", "model", str, "source", str2);
    }

    public final void O0000oo0(int i) {
        this.f952O000000o.O000000o("location_auth_click", "type", Integer.valueOf(i));
    }

    public final void O0000oo(int i) {
        this.f952O000000o.O000000o("location_auth_success", "type", Integer.valueOf(i));
    }

    public final void O0000ooO(int i) {
        this.f952O000000o.O000000o("uwb_mico_recommend_click", "element_position", Integer.valueOf(i));
    }

    public final void O0000ooo(int i) {
        this.f952O000000o.O000000o("uwb_mico_relay_click", "UWB_distanceplay", Integer.valueOf(i));
    }

    public final void O00oOooO(int i) {
        this.f952O000000o.O000000o("uwb_mico_prev_next_click", "playbacknext", Integer.valueOf(i));
    }

    public final void O000000o(long j) {
        this.f952O000000o.O000000o("home_adddevice_out_time", "time", Long.valueOf(j));
    }

    public final void O00000o0(int i, int i2) {
        this.f952O000000o.O000000o("home_adddevic_catelog_ck", "categoryid", Integer.valueOf(i), "subcategoryid", Integer.valueOf(i2));
    }

    public final void O0000o() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_login", new Object[0]);
    }

    public final void O0000oO0() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_more", new Object[0]);
    }

    public final void O00oOooo(int i) {
        this.f952O000000o.O000000o("uwb_click_mitv_card_volume", "volume", Integer.valueOf(i));
    }

    public final void O0000oO() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_menu", new Object[0]);
    }

    public final void O0000oOO() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_back", new Object[0]);
    }

    public final void O0000oOo() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_home", new Object[0]);
    }

    public final void O0000oo0() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_ok", new Object[0]);
    }

    public final void O000O00o(int i) {
        this.f952O000000o.O000000o("uwb_click_mitv_card_pad", "updownleftright", Integer.valueOf(i));
    }

    public final void O0000oo() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_ai", new Object[0]);
    }

    public final void O0000ooO() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_miracast", new Object[0]);
    }

    public final void O0000ooo() {
        this.f952O000000o.O000000o("uwb_click_mitv_card_hdmi", new Object[0]);
    }

    public final void O000O0OO(int i) {
        this.f952O000000o.O000000o("uwb_click_mitv_card_power", "device_onoff", Integer.valueOf(i));
    }

    public final void O00oOooO() {
        this.f952O000000o.O000000o("uwb_click_video_progress", new Object[0]);
    }

    public final void O000O0Oo(int i) {
        this.f952O000000o.O000000o("uwb_click_history_item", "element_position", Integer.valueOf(i));
    }

    public final void O00oOoOo(int i) {
        this.f952O000000o.O000000o("home_scan_failed_click", "type", Integer.valueOf(i));
    }
}

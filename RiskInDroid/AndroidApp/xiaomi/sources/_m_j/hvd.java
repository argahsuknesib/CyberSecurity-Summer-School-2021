package _m_j;

import org.json.JSONObject;

public interface hvd {
    void add_complete_click(String str, long j);

    void add_fail1st_manualadd(String str);

    void add_fail1st_retry(String str);

    void add_fail1st_wifi(String str);

    void add_fail2nd_blue(String str);

    void add_fail2nd_lbblue(String str);

    void add_fail2nd_retry(String str);

    void add_fail2nd_solution(String str);

    void add_fail2nd_yellow(String str);

    void add_fail3nd_blue(String str);

    void add_fail3nd_lbblue(String str);

    void add_fail3nd_refresh(String str);

    void add_fail3nd_solution(String str);

    void add_near_wlan(String str);

    void add_wlan_click();

    void add_wlan_editor(String str);

    void adddevice_QR_next(String str);

    void adddevice_QR_novoice(String str);

    void adddevice_connect_confirm(String str);

    void adddevice_connectdevice(String str, int i, String str2);

    void adddevice_finishconnect(String str, boolean z, int i, String str2, int i2, int i3, String str3, String str4);

    void adddevice_iot_log(JSONObject jSONObject);

    void adddevice_network_wifi_AP(String str, String str2);

    void adddevice_process_success_AP(String str, String str2, int i);

    void adddevice_reset_details(String str);

    void adddevice_scanning_connectbyself(String str);

    void adddevice_scanning_fail_goon(String str);

    void adddevice_selectdevice(String str, int i, String str2);

    void adddevice_wifi_changepassword(String str);

    void adddevice_wifi_delete(String str);

    void adddevice_wifi_next(String str);

    void adddevice_wifi_selectothers(String str);

    void adddevice_wlan_next_AP(String str, int i, int i2);

    void kuaiLianClick(String str, String str2);

    void miui_push_click(String str);
}

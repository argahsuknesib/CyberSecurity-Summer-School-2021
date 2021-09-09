package _m_j;

public interface hve {
    void adddevice_QR_show(String str);

    void adddevice_connect_fail_show(String str, int i);

    void adddevice_connect_success_show(String str);

    void adddevice_connecting_show(String str);

    void adddevice_scanning_fail_show(String str);

    void adddevice_scanning_show(String str);

    void adddevice_wifi_show(String str, int i);

    long pageDeviceFail(hxy hxy);

    long page_AP_step_success(String str, long j, int i, int i2);

    long page_addcamerareset(long j);

    long page_device_fail4Combo(long j, String str, int i, int i2, String str2, String str3, String str4, String str5);

    long page_failovertime(String str, long j);

    long page_failtm(String str, long j);

    long page_mobile_device(String str, long j);

    long page_router(String str, long j);

    long page_scan_device(long j, String str);

    long page_use_miui_wifi_pwd(String str);

    long page_wlan(String str, long j);

    void reportKuailianOldResult(String str, String str2, String str3);
}

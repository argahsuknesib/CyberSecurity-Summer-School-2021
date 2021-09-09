package _m_j;

import com.sankuai.waimai.router.annotation.RouterService;

@RouterService
public class gic implements hvf {
    public void adddevice_link_time_AP(String str, long j) {
        hxi.O0000Oo.f960O000000o.O000000o("adddevice_link_time.AP", "model", str, "time", Long.valueOf((System.currentTimeMillis() - j) / 1000));
    }

    public void add_fail_device(String str, long j) {
        hxi.O0000Oo.O000000o(str, j);
    }

    public void adddevice_system_success(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        hxi.O0000Oo.O000000o(str, str2, i, i2, str3, str4, str5);
    }

    public void adddevice_app_succrss(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        hxi.O0000Oo.O00000Oo(str, str2, i, i2, str3, str4, str5);
    }

    public void wifi_pwd_length(int i) {
        hxi.O0000Oo.f960O000000o.O000000o("wifi_pwd_length", "password_length", Integer.valueOf(i));
    }

    public void app_stat_plugin_downTime(long j, String str) {
        hxi.O0000Oo.O000000o(j, str);
    }

    public void pollWifiDevice(long j, long j2, String str, String str2, String str3, String str4) {
        hxi.O0000Oo.f960O000000o.O000000o("poll_wifi_device", "startTime", Long.valueOf(j), "endTime", Long.valueOf(j2), "model", str, "uid", str2, "did", str3, "bindKey", str4);
    }

    public void initDeviceConnectCounter() {
        hxi.O0000Oo.O00000Oo = new hxb();
    }

    public void scanWifiResult(String str, boolean z, int i, int i2, int i3, int i4) {
        hxt hxt = hxi.O0000Oo;
        if (hxt.O00000Oo(str)) {
            hxt.f960O000000o.O000000o("scan_wifi_result", "model", str, "findDevice", Integer.valueOf(z ? 1 : 0), "scanDuration", Integer.valueOf(i), "scanMode", Integer.valueOf(i2), "scanRepeat", Integer.valueOf(i3), "error", Integer.valueOf(i4));
            return;
        }
        gsy.O00000Oo("scanWifiResult", String.format("model=%s,scanSuccess=%s,scanDuration=%d,scanMode=%s,scanRepeat=%d,errorCode=%d", str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public void get_bind_key_result(boolean z, String str, String str2) {
        hxi.O0000Oo.f960O000000o.O000000o("get_bind_key_result", "result", Integer.valueOf(z ? 1 : 0), "scene", str, "model", str2);
    }

    public void combo_kuailian_result(String str, String str2, boolean z, boolean z2, boolean z3) {
        hxt hxt = hxi.O0000Oo;
        boolean O00000Oo = gnl.O00000Oo();
        hyg hyg = hxt.f960O000000o;
        Object[] objArr = new Object[14];
        objArr[0] = "model";
        objArr[1] = str;
        int i = 2;
        objArr[2] = "bleOpen";
        objArr[3] = Integer.valueOf(O00000Oo ? 1 : 0);
        objArr[4] = "configType";
        if (z) {
            i = 1;
        }
        objArr[5] = Integer.valueOf(i);
        objArr[6] = "did";
        objArr[7] = str2;
        objArr[8] = "platform";
        objArr[9] = 1;
        objArr[10] = "bleFail";
        objArr[11] = Integer.valueOf(z2 ? 1 : 0);
        objArr[12] = "userCancel";
        objArr[13] = Boolean.valueOf(z3);
        hyg.O000000o("combo_kuailian_result", objArr);
    }
}

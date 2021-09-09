package _m_j;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import java.util.List;
import org.json.JSONObject;

public final class fda implements gjm {
    public final int O0000o0o() {
        return R.string.ble_new_auth_step_failed;
    }

    public final void O000000o(String str, String str2) {
        gsy.O00000o0(LogType.KUAILIAN, str, str2);
    }

    public final void O000000o(String str, String str2, hua<JSONObject, hud> hua) {
        hty.O000000o().getBindKey4DynamicDid(str, str2, hua);
    }

    public final void O000000o(hua<String, hud> hua) {
        hty.O000000o().getBindKey(hua);
    }

    public final Context O000000o() {
        return CommonApplication.getAppContext();
    }

    public final String O00000Oo() {
        return SmartConfigRouterFactory.getCoreApiManager().getMiId();
    }

    public final void O00000o0() {
        hty.O000000o().startConnectWifi();
    }

    public final void O000000o(String str, String str2, String str3, String str4) {
        SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord((StatType) StatType.valueOf(StatType.class, str), str2, str3, str4, false);
    }

    public final void O000000o(Device device) {
        gwe.O000000o().O000000o(device);
    }

    public final void O00000Oo(Device device) {
        fno.O000000o().O000000o(device);
    }

    public final void O00000o() {
        fno.O000000o().O0000OOo();
    }

    public final void O00000oO() {
        hty.O000000o().startWifiDeviceFinder();
    }

    public final void O000000o(ScanResult scanResult) {
        hty.O000000o().removeScanResult(scanResult);
    }

    public final void O000000o(String str) {
        fno.O000000o().O0000Oo0(str);
    }

    public final void O00000oo() {
        fno.O000000o().f16707O000000o.setCurrentScanDid(null);
    }

    public final String O0000O0o() {
        return fno.O000000o().O0000o0o();
    }

    public final void O0000OOo() {
        fno.O000000o().f16707O000000o.cleanScrollToDid();
    }

    public final void O000000o(List<String> list) {
        hsl.O00000Oo().updateDeviceProps(list);
    }

    public final void O00000Oo(List<Device> list) {
        hsl.O00000Oo().updateDevicePropsByDevice(list);
    }

    public final void O0000Oo0() {
        fno.O000000o().O0000o0O();
    }

    public final String O0000Oo() {
        return htr.O000000o().O00000Oo();
    }

    public final String O0000OoO() {
        htr O000000o2 = htr.O000000o();
        if (O000000o2.O000000o("mi_router_info") != null) {
            return ((WifiInfo) O000000o2.O000000o("mi_router_info")).O00000o;
        }
        if (O000000o2.O000000o("selected_ap") != null) {
            return ((ScanResult) O000000o2.O000000o("selected_ap")).BSSID;
        }
        return null;
    }

    public final boolean O00000Oo(String str) {
        return eyr.O00000Oo().O00000o(str);
    }

    public final boolean O00000o0(String str) {
        return eyr.O00000Oo().O0000O0o(str);
    }

    public final boolean O0000Ooo() {
        eyr.O00000Oo();
        return true;
    }

    public final boolean O00000o(String str) {
        return eyr.O000000o(str, true, 100, eyr.O00000Oo().O0000oO);
    }

    public final void O000000o(String str, hua<List<Device>, hud> hua) {
        SmartConfigRouterFactory.getSmartConfigManager().getLocalDeviceListAll(str, hua);
    }

    public final void O000000o(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua) {
        hty.O000000o().getNewDevice(context, str, z, str2, str3, str4, str5, str6, hua);
    }

    public final void O000000o(long j, long j2, String str, String str2, String str3, String str4) {
        SmartConfigRouterFactory.getStatResultManager().pollWifiDevice(j, j2, str, str2, str3, str4);
    }

    public final void O00000Oo(String str, hua<String, hud> hua) {
        hty.O000000o().fetchTokenByIp(str, hua);
    }

    public final void O000000o(Device device, hua<Integer, hud> hua) {
        hty.O000000o().bindDeviceWithCheck(device, hua);
    }

    public final boolean O00000o0(Device device) {
        return device instanceof CameraDevice;
    }

    public final Device O00000Oo(ScanResult scanResult) {
        return DeviceFactory.O0000o0O(DeviceFactory.O00000Oo(scanResult));
    }

    public final String O0000o00() {
        return SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.smart_config_toast_connect_failed);
    }

    public final String O0000o0() {
        return SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.smart_config_toast_connect_success);
    }

    public final String O0000o0O() {
        return SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.have_bind_by_other);
    }

    public final void O000000o(String str, Object obj) {
        htr.O000000o().O00000Oo(str, obj);
    }

    public final void O00000Oo(final hua<Pair<String, String>, hud> hua) {
        SmartConfigRouterFactory.getSmartConfigManager().getLoginInfo(new hua<huv, hud>() {
            /* class _m_j.fda.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                huv huv = (huv) obj;
                hua hua = hua;
                if (hua != null) {
                    hua.O000000o(new Pair(huv.O00000o0, huv.O00000Oo));
                }
            }

            public final void O000000o(hud hud) {
                hua hua = hua;
                if (hua != null) {
                    hua.O000000o(hud);
                }
            }
        });
    }

    public final boolean O0000o() {
        return SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn();
    }
}

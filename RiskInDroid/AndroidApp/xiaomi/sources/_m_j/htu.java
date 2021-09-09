package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class htu implements htx {
    public final void bindDeviceWithCheck(Device device, hua<Integer, hud> hua) {
    }

    public final void fetchTokenByIp(String str, hua<String, hud> hua) {
    }

    public final void getBindKey(hua<String, hud> hua) {
    }

    public final void getBindKey4DynamicDid(String str, String str2, hua<JSONObject, hud> hua) {
    }

    public final Class<?> getConfigRouterStationActivity() {
        return null;
    }

    public final Class<?> getConfigRouterSubDeviceActivity() {
        return null;
    }

    public final int getDevicePlusType() {
        return 0;
    }

    public final int getDeviceSource() {
        return 0;
    }

    public final void getNewDevice(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua) {
    }

    public final Intent getSmartConfigIntent(Context context, ScanResult scanResult, String str, String str2, String str3) {
        return null;
    }

    public final fbt getSmartConfigRequest(Context context, ScanResult scanResult, String str, String str2, String str3) {
        return null;
    }

    public final void isRouterBound(Context context, String str, String str2, huc huc) {
    }

    public final void isRouterInited(String str, Callback<String> callback) {
    }

    public final void onScanResultAvailable(ScanResult scanResult) {
    }

    public final void openConnectSucceedPage(Activity activity, String str, String str2) {
    }

    public final void openCurtainGroupNamePage(Activity activity, String str, String str2, String str3) {
    }

    public final void removeScanResult(ScanResult scanResult) {
    }

    public final void setDevicePlusType(int i) {
    }

    public final void setDeviceSource(int i) {
    }

    public final fbt setMitvStep(fbt fbt) {
        return null;
    }

    public final fbt setQrStep(fbt fbt, int i) {
        return null;
    }

    public final void smartConfigLog(String str, String str2, Object... objArr) {
    }

    public final void startConnectWifi() {
    }

    public final void startWifiDeviceFinder() {
    }

    public final void stopScanNewDevice() {
    }

    public final ArrayList<ScanResult> getScanResult() {
        return new ArrayList<>();
    }
}

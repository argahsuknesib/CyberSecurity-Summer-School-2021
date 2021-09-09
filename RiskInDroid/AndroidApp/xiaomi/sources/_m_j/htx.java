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

public interface htx {
    void bindDeviceWithCheck(Device device, hua<Integer, hud> hua);

    void fetchTokenByIp(String str, hua<String, hud> hua);

    void getBindKey(hua<String, hud> hua);

    void getBindKey4DynamicDid(String str, String str2, hua<JSONObject, hud> hua);

    Class<?> getConfigRouterStationActivity();

    Class<?> getConfigRouterSubDeviceActivity();

    int getDevicePlusType();

    int getDeviceSource();

    void getNewDevice(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua);

    ArrayList<ScanResult> getScanResult();

    Intent getSmartConfigIntent(Context context, ScanResult scanResult, String str, String str2, String str3);

    fbt getSmartConfigRequest(Context context, ScanResult scanResult, String str, String str2, String str3);

    void isRouterBound(Context context, String str, String str2, huc huc);

    void isRouterInited(String str, Callback<String> callback);

    void onScanResultAvailable(ScanResult scanResult);

    void openConnectSucceedPage(Activity activity, String str, String str2);

    void openCurtainGroupNamePage(Activity activity, String str, String str2, String str3);

    void removeScanResult(ScanResult scanResult);

    void setDevicePlusType(int i);

    void setDeviceSource(int i);

    fbt setMitvStep(fbt fbt);

    fbt setQrStep(fbt fbt, int i);

    void smartConfigLog(String str, String str2, Object... objArr);

    void startConnectWifi();

    void startWifiDeviceFinder();

    void stopScanNewDevice();
}

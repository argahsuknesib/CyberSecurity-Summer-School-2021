package _m_j;

import _m_j.iae;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Message;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.ConfigRouterStationActivity;
import com.xiaomi.smarthome.device.ConfigRouterSubDeviceActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.miio.WifiSetting;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@RouterService
public class huy implements htx {
    public void setDeviceSource(int i) {
        SmartConfigMainActivity.DEVICE_FROM = i;
    }

    public int getDeviceSource() {
        return SmartConfigMainActivity.DEVICE_FROM;
    }

    public int getDevicePlusType() {
        return SmartConfigMainActivity.DEVICE_FROM_APP_PLUS_TYPE;
    }

    public void setDevicePlusType(int i) {
        SmartConfigMainActivity.DEVICE_FROM_APP_PLUS_TYPE = i;
    }

    public void stopScanNewDevice() {
        fmw.O000000o().O00000Oo();
    }

    public Intent getSmartConfigIntent(Context context, ScanResult scanResult, String str, String str2, String str3) {
        return hvp.O000000o(context, scanResult, str, str2, str3);
    }

    public fbt getSmartConfigRequest(Context context, ScanResult scanResult, String str, String str2, String str3) {
        return hvp.O00000Oo(context, scanResult, str, str2, str3);
    }

    public void smartConfigLog(String str, String str2, Object... objArr) {
        hts.O000000o(str, str2, objArr);
    }

    public void initWifiDeviceFinder(Context context) {
        if (iae.O000000o().O0000OOo == null) {
            iae.O000000o().O0000OOo = context;
            iae.O000000o().O00000Oo();
        }
    }

    public void onScanResultAvailable() {
        iae.O000000o().O00000o0();
    }

    public void onScanResultAvailable(ScanResult scanResult) {
        iae O000000o2 = iae.O000000o();
        if (O000000o2.O0000Oo == null) {
            O000000o2.O0000Oo = new gpq("WifiDeviceFinder");
            O000000o2.O0000Oo.start();
            O000000o2.O0000OoO = new iae.O00000Oo(O000000o2.O0000Oo.getLooper());
        }
        O000000o2.O0000OoO.sendMessage(Message.obtain(O000000o2.O0000OoO, 2, scanResult));
    }

    public ArrayList<ScanResult> getScanResult() {
        return iae.O00000o0;
    }

    public byte[] encode(byte[] bArr) {
        return iaa.O000000o(bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    public fbt setQrStep(fbt fbt, int i) {
        if (i == 4) {
            return fbt.O000000o("step", (Serializable) SmartConfigStep.Step.STEP_QR_CAMERA);
        }
        return fbt.O000000o("step", (Serializable) SmartConfigStep.Step.STEP_COMBO_BLE_WAY_CONFIG);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    public fbt setMitvStep(fbt fbt) {
        return fbt.O000000o("step", (Serializable) SmartConfigStep.Step.STEP_BLE_MITV);
    }

    public void isRouterInited(String str, Callback<String> callback) {
        hnc.O000000o(str, callback);
    }

    public void isRouterBound(Context context, String str, String str2, huc huc) {
        hnc.O000000o(str, str2, huc);
    }

    public Class<?> getConfigRouterStationActivity() {
        return ConfigRouterStationActivity.class;
    }

    public Class<?> getConfigRouterSubDeviceActivity() {
        return ConfigRouterSubDeviceActivity.class;
    }

    public void openConnectSucceedPage(Activity activity, String str, String str2) {
        if (activity != null) {
            Intent intent = new Intent(activity, InitDeviceRoomActivity.class);
            intent.putExtra("device_id", str2);
            activity.startActivity(intent);
        }
    }

    public void openCurtainGroupNamePage(final Activity activity, final String str, String str2, String str3) {
        if (activity != null) {
            Intent intent = new Intent(activity, InitDeviceRoomActivity.class);
            intent.putExtra("device_id", str);
            intent.putExtra("type", "group.curtain");
            intent.putExtra("device_id_left", str2);
            intent.putExtra("device_id_right", str3);
            activity.startActivity(intent);
            CommonApplication.getAppContext().registerReceiver(new BroadcastReceiver() {
                /* class _m_j.huy.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getStringExtra("device_id"), str)) {
                        if (intent.getBooleanExtra("type", true)) {
                            activity.finish();
                        }
                        CommonApplication.getAppContext().unregisterReceiver(this);
                    }
                }
            }, new IntentFilter("smarthome_init_device_finish"));
        }
    }

    public void getBindKey4DynamicDid(String str, String str2, hua<JSONObject, hud> hua) {
        htq.O000000o().O00000o0(str, str2, hua);
    }

    public void getBindKey(hua<String, hud> hua) {
        htq.O000000o().O000000o(hua);
    }

    public void startConnectWifi() {
        if (fnn.O000000o().O00000o() != -1) {
            WifiSetting.startConnectWifi();
        }
    }

    public void startWifiDeviceFinder() {
        if (iae.O000000o().O0000OOo == null) {
            iae.O000000o().O0000OOo = SmartConfigRouterFactory.getSmartConfigManager().getAppContext();
            iae.O000000o().O00000Oo();
        }
    }

    public void removeScanResult(ScanResult scanResult) {
        iae.O000000o(scanResult);
    }

    public void getNewDevice(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua) {
        htq.O000000o().O000000o(context, str, z, str2, str3, str4, str5, str6, hua);
    }

    public void fetchTokenByIp(String str, hua<String, hud> hua) {
        htq.O000000o().O00000Oo(str, hua);
    }

    public void bindDeviceWithCheck(Device device, hua<Integer, hud> hua) {
        htq.O000000o().O00000Oo(device, hua);
    }
}

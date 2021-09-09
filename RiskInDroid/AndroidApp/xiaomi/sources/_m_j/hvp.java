package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.wificonfig.WifiSettingNormal;
import java.util.HashMap;
import java.util.List;

public final class hvp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<Integer, hvq> f705O000000o = new HashMap<>();

    static {
        hvq hvq = new hvq();
        hvq.f706O000000o = true;
        hvq.O00000Oo = true;
        hvq.O00000o = SmartConfigStep.Step.STEP_AP_CONFIG_STEP;
        f705O000000o.put(2, hvq);
        hvq hvq2 = new hvq();
        hvq2.f706O000000o = true;
        hvq2.O00000Oo = false;
        hvq2.O00000o = SmartConfigStep.Step.STEP_QR_CONFIG;
        f705O000000o.put(3, hvq2);
        hvq hvq3 = new hvq();
        hvq3.f706O000000o = false;
        hvq3.O00000Oo = false;
        hvq3.O00000o0 = SmartConfigStep.Step.STEP_PREPARE_SCAN_QR;
        hvq3.O00000o = SmartConfigStep.Step.STEP_SCAN_QR;
        f705O000000o.put(5, hvq3);
        hvq hvq4 = new hvq();
        hvq4.f706O000000o = true;
        hvq4.O00000Oo = false;
        hvq4.O00000o = SmartConfigStep.Step.STEP_BLE_COMBO_CONFIG;
        f705O000000o.put(4, hvq4);
        hvq hvq5 = new hvq();
        hvq5.f706O000000o = false;
        hvq5.O00000Oo = false;
        hvq5.O00000o0 = SmartConfigStep.Step.STEP_AP_DEVICE_CONFIG_PASSWD_CHOOSER;
        hvq5.O00000o = SmartConfigStep.Step.STEP_AP_DEVICE_CONFIG_STEP;
        f705O000000o.put(6, hvq5);
        hvq hvq6 = new hvq();
        hvq6.f706O000000o = false;
        hvq6.O00000Oo = false;
        hvq6.O00000o0 = SmartConfigStep.Step.STEP_XIAOFANG_RESET;
        hvq6.O00000o = SmartConfigStep.Step.STEP_QR_CONFIG;
        f705O000000o.put(9, hvq6);
        hvq hvq7 = new hvq();
        hvq7.f706O000000o = false;
        hvq7.O00000Oo = false;
        hvq7.O00000o0 = SmartConfigStep.Step.STEP_AP_INPUT_SSID_PASSWD_CONFIG;
        hvq7.O00000o = SmartConfigStep.Step.STEP_BIND_KEY;
        f705O000000o.put(8, hvq7);
        hvq hvq8 = new hvq();
        hvq8.f706O000000o = false;
        hvq8.O00000Oo = false;
        hvq8.O00000o0 = SmartConfigStep.Step.STEP_CAMERA_RESET;
        hvq8.O00000o = SmartConfigStep.Step.STEP_QR_CAMERA;
        f705O000000o.put(9, hvq8);
        hvq hvq9 = new hvq();
        hvq9.f706O000000o = false;
        hvq9.O00000Oo = false;
        hvq9.O00000o0 = null;
        hvq9.O00000o = SmartConfigStep.Step.STEP_BIND_DEVICE_FROM_THIRD_APP;
        f705O000000o.put(10, hvq9);
        hvq hvq10 = new hvq();
        hvq10.f706O000000o = false;
        hvq10.O00000Oo = false;
        hvq10.O00000o0 = SmartConfigStep.Step.STEP_CAMERA_RESET;
        hvq10.O00000o = SmartConfigStep.Step.STEP_SW_CAMERA;
        f705O000000o.put(11, hvq10);
        hvq hvq11 = new hvq();
        hvq11.f706O000000o = false;
        hvq11.O00000Oo = false;
        hvq11.O00000o = SmartConfigStep.Step.STEP_NBIOT;
        f705O000000o.put(12, hvq11);
        hvq hvq12 = new hvq();
        hvq12.f706O000000o = true;
        hvq12.O00000Oo = false;
        hvq12.O00000o = SmartConfigStep.Step.STEP_COMBO_BLE_WAY_CONFIG;
        f705O000000o.put(13, hvq12);
        hvq hvq13 = new hvq();
        hvq13.f706O000000o = false;
        hvq13.O00000Oo = false;
        hvq13.O00000o = SmartConfigStep.Step.STEP_GATEWAY_SUBDEVICE;
        f705O000000o.put(14, hvq13);
        hvq hvq14 = new hvq();
        hvq14.f706O000000o = false;
        hvq14.O00000Oo = false;
        hvq14.O00000o = SmartConfigStep.Step.STEP_PUSH_NEWDEVICE;
        f705O000000o.put(16, hvq14);
        hvq hvq15 = new hvq();
        hvq15.f706O000000o = true;
        hvq15.O00000Oo = true;
        hvq15.O00000o = SmartConfigStep.Step.STEP_APSECURE_CONFIG_STEP;
        f705O000000o.put(15, hvq15);
        hvq hvq16 = new hvq();
        hvq16.f706O000000o = false;
        hvq16.O00000Oo = false;
        hvq16.O00000o = SmartConfigStep.Step.STEP_CHECK_AIOT_DEVICE_STATUS;
        f705O000000o.put(17, hvq16);
        hvq hvq17 = new hvq();
        hvq17.f706O000000o = true;
        hvq17.O00000Oo = true;
        hvq17.O00000o = SmartConfigStep.Step.STEP_LOCK_WIFI_CONFIG;
        f705O000000o.put(18, hvq17);
        hvq hvq18 = new hvq();
        hvq18.f706O000000o = true;
        hvq18.O00000Oo = false;
        hvq18.O00000o = SmartConfigStep.Step.STEP_BLE_MITV;
        f705O000000o.put(19, hvq18);
        hvq hvq19 = new hvq();
        hvq19.f706O000000o = true;
        hvq19.O00000Oo = true;
        hvq19.O00000o = SmartConfigStep.Step.STEP_APSECURE_CONFIG_STEP;
        f705O000000o.put(20, hvq19);
        hvq hvq20 = new hvq();
        hvq20.f706O000000o = true;
        hvq20.O00000Oo = true;
        hvq20.O00000o = SmartConfigStep.Step.STEP_APSECURE_CONFIG_STEP;
        f705O000000o.put(21, hvq20);
    }

    public static boolean O000000o(int i) {
        return f705O000000o.get(Integer.valueOf(i)).f706O000000o;
    }

    public static SmartConfigStep.Step O00000Oo(int i) {
        if (f705O000000o.get(Integer.valueOf(i)) == null) {
            return null;
        }
        return f705O000000o.get(Integer.valueOf(i)).O00000o0;
    }

    public static SmartConfigStep.Step O000000o(String str, int i) {
        if (f705O000000o.get(Integer.valueOf(i)) == null) {
            return null;
        }
        SmartConfigStep.Step step = f705O000000o.get(Integer.valueOf(i)).O00000o;
        if (step == SmartConfigStep.Step.STEP_AP_CONFIG_STEP) {
            eyr O00000Oo = eyr.O00000Oo();
            if (eyr.O000000o(str, O00000Oo.O000O0oo, O00000Oo.O000OO00, O00000Oo.O000O0oO)) {
                return SmartConfigStep.Step.STEP_AP_CONFIG_STEP_V2;
            }
        } else if (step == SmartConfigStep.Step.STEP_APSECURE_CONFIG_STEP) {
            eyr O00000Oo2 = eyr.O00000Oo();
            if (eyr.O000000o(str, O00000Oo2.O000OO, O00000Oo2.O000OOOo, O00000Oo2.O000OO0o)) {
                return SmartConfigStep.Step.STEP_SECURITY_AP_CONFIG_V2;
            }
        } else if (step == SmartConfigStep.Step.STEP_COMBO_BLE_WAY_CONFIG) {
            eyr O00000Oo3 = eyr.O00000Oo();
            if (eyr.O000000o(str, O00000Oo3.O000OOo, O00000Oo3.O000OOoO, O00000Oo3.O000OOo0)) {
                return SmartConfigStep.Step.STEP_COMBO_ONLY_BLE_CONFIG_V2;
            }
        } else if (step == SmartConfigStep.Step.STEP_BLE_COMBO_CONFIG) {
            eyr O00000Oo4 = eyr.O00000Oo();
            if (eyr.O000000o(str, O00000Oo4.O000Oo00, O00000Oo4.O000Oo0, O00000Oo4.O000OOoo)) {
                return SmartConfigStep.Step.STEP_COMBO_MIX_CONFIG_V2;
            }
        }
        return step;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static Intent O000000o(Context context, ScanResult scanResult, String str, String str2, String str3) {
        PluginDeviceInfo pluginInfo;
        Intent intent;
        Intent intent2;
        if (context == null || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str)) == null) {
            return null;
        }
        int O0000OOo = pluginInfo.O0000OOo();
        grr.O000000o();
        if (O0000OOo > grr.O00000o0(context)) {
            izb.O000000o(context, context.getString(R.string.device_not_support_now), 0).show();
            return null;
        } else if (!pluginInfo.O000000o()) {
            izb.O000000o(context, context.getString(R.string.device_not_support_now), 0).show();
            return null;
        } else {
            if (scanResult == null) {
                intent = new Intent(context, WifiSettingNormal.class);
            } else if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIIO) {
                intent = new Intent(context, WifiSettingNormal.class);
            } else if (DeviceFactory.O00000o0(scanResult) == DeviceFactory.AP_TYPE.AP_MIDEVICE) {
                intent = new Intent(context, SmartConfigMainActivity.class);
                intent.putExtra("strategy_id", 6);
            } else {
                if (pluginInfo.O00000o() == 4) {
                    List<Integer> O0000O0o = pluginInfo.O0000O0o();
                    intent2 = new Intent(context, SmartConfigMainActivity.class);
                    if (O0000O0o != null && O0000O0o.contains(1) && gnl.O000000o()) {
                        intent2.putExtra("strategy_id", 4);
                        fol.O000000o(scanResult);
                    } else if (O0000O0o == null || !O0000O0o.contains(0)) {
                        intent2.putExtra("strategy_id", 9);
                        intent2.putExtra("use_reset_page", false);
                    } else {
                        intent2.putExtra("strategy_id", 2);
                    }
                } else if (pluginInfo.O00000o() == 12) {
                    intent = new Intent(context, SmartConfigMainActivity.class);
                    intent.putExtra("strategy_id", 11);
                    intent.putExtra("use_reset_page", false);
                } else if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIBAP) {
                    intent = new Intent(context, SmartConfigMainActivity.class);
                    if (gnl.O000000o()) {
                        intent.putExtra("strategy_id", 4);
                        fol.O000000o(scanResult);
                    } else {
                        intent.putExtra("strategy_id", 2);
                    }
                } else {
                    intent2 = new Intent(context, SmartConfigMainActivity.class);
                    String O00000Oo = DeviceFactory.O00000Oo(scanResult);
                    if (O00000Oo.equalsIgnoreCase("xiaomi.plc.v1")) {
                        intent2.putExtra("strategy_id", 8);
                    } else if (pluginInfo.O00000o() == 16 || "chuangmi.camera.ipc020".equals(str) || htt.O000000o(str)) {
                        if (htt.O000000o(str)) {
                            intent2.putExtra("strategy_id", 20);
                        } else {
                            intent2.putExtra("strategy_id", 15);
                        }
                    } else if (htt.O00000Oo(str)) {
                        intent2.putExtra("strategy_id", 21);
                        O000000o(intent2, "mo_xiang_station_did");
                        O000000o(intent2, "mo_xiang_station_ssid");
                        O000000o(intent2, "mo_xiang_station_passwd");
                        O000000o(intent2, "mo_xiang_static_key");
                        O000000o(intent2, "mo_xiang_key_num");
                    } else {
                        intent2.putExtra("strategy_id", 2);
                    }
                    intent2.putExtra("model", O00000Oo);
                }
                intent = intent2;
            }
            intent.putExtra("model", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("bssid", str2);
                intent.putExtra("password", str3);
            }
            if (scanResult != null) {
                intent.putExtra("scanResult", scanResult);
            }
            return intent;
        }
    }

    private static void O000000o(Intent intent, String str) {
        String str2 = (String) htr.O000000o().O000000o(str, "");
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(str, str2);
        }
    }

    private static void O000000o(fbt fbt, String str) {
        String str2 = (String) htr.O000000o().O000000o(str, "");
        if (!TextUtils.isEmpty(str2)) {
            fbt.O000000o(str, str2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.net.wifi.ScanResult]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public static fbt O00000Oo(Context context, ScanResult scanResult, String str, String str2, String str3) {
        PluginDeviceInfo pluginInfo;
        fbt fbt;
        fbt fbt2;
        if (context == null || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str)) == null) {
            return null;
        }
        int O0000OOo = pluginInfo.O0000OOo();
        grr.O000000o();
        if (O0000OOo > grr.O00000o0(context)) {
            izb.O000000o(context, context.getString(R.string.device_not_support_now), 0).show();
            return null;
        } else if (!pluginInfo.O000000o()) {
            izb.O000000o(context, context.getString(R.string.device_not_support_now), 0).show();
            return null;
        } else {
            if (scanResult == null) {
                fbt = new fbt(context, "WifiSettingNormal");
            } else if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIIO) {
                fbt = new fbt(context, "WifiSettingNormal");
            } else if (DeviceFactory.O00000o0(scanResult) == DeviceFactory.AP_TYPE.AP_MIDEVICE) {
                fbt = new fbt(context, "SmartConfigMainActivity");
                fbt.O000000o("strategy_id", 6);
            } else {
                if (pluginInfo.O00000o() == 4) {
                    List<Integer> O0000O0o = pluginInfo.O0000O0o();
                    fbt2 = new fbt(context, "SmartConfigMainActivity");
                    if (O0000O0o != null && O0000O0o.contains(1) && gnl.O000000o()) {
                        fbt2.O000000o("strategy_id", 4);
                        fol.O000000o(scanResult);
                    } else if (O0000O0o == null || !O0000O0o.contains(0)) {
                        fbt2.O000000o("strategy_id", 9);
                        fbt2.O000000o("use_reset_page", false);
                    } else {
                        fbt2.O000000o("strategy_id", 2);
                    }
                } else if (pluginInfo.O00000o() == 12) {
                    fbt = new fbt(context, "SmartConfigMainActivity");
                    fbt.O000000o("strategy_id", 11);
                    fbt.O000000o("use_reset_page", false);
                } else if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIBAP) {
                    fbt = new fbt(context, "SmartConfigMainActivity");
                    if (gnl.O000000o()) {
                        fbt.O000000o("strategy_id", 4);
                        fol.O000000o(scanResult);
                    } else {
                        fbt.O000000o("strategy_id", 2);
                    }
                } else {
                    fbt2 = new fbt(context, "SmartConfigMainActivity");
                    String O00000Oo = DeviceFactory.O00000Oo(scanResult);
                    if (O00000Oo.equalsIgnoreCase("xiaomi.plc.v1")) {
                        fbt2.O000000o("strategy_id", 8);
                    } else if (pluginInfo.O00000o() == 16 || "chuangmi.camera.ipc020".equals(str) || htt.O000000o(str)) {
                        if (htt.O000000o(str)) {
                            fbt2.O000000o("strategy_id", 20);
                        } else {
                            fbt2.O000000o("strategy_id", 15);
                        }
                    } else if (htt.O00000Oo(str)) {
                        fbt2.O000000o("strategy_id", 21);
                        O000000o(fbt2, "mo_xiang_station_did");
                        O000000o(fbt2, "mo_xiang_station_ssid");
                        O000000o(fbt2, "mo_xiang_station_passwd");
                        O000000o(fbt2, "mo_xiang_static_key");
                        O000000o(fbt2, "mo_xiang_key_num");
                    } else {
                        fbt2.O000000o("strategy_id", 2);
                    }
                    fbt2.O000000o("model", O00000Oo);
                }
                fbt = fbt2;
            }
            fbt.O000000o("model", str);
            if (!TextUtils.isEmpty(str2)) {
                fbt.O000000o("bssid", str2);
                fbt.O000000o("password", str3);
            }
            if (scanResult != null) {
                fbt.O000000o("scanResult", (Parcelable) scanResult);
            }
            return fbt;
        }
    }
}

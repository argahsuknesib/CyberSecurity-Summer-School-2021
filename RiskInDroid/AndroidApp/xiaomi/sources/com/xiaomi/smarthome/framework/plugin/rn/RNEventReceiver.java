package com.xiaomi.smarthome.framework.plugin.rn;

import _m_j.fwz;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.gat;
import _m_j.gbu;
import _m_j.glb;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RNEventReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f8166O000000o = -1;
    private Map<String, Integer> O00000Oo = new HashMap();

    public void onReceive(Context context, Intent intent) {
        ReactContext currentReactContext;
        Intent intent2 = intent;
        WritableMap createMap = Arguments.createMap();
        ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
        DeviceStat deviceStat = fwz.O000000o().O00000Oo().O0000o00;
        if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null && intent2 != null) {
            String str = "bluetoothConnectionStatusChanged_36621";
            String str2 = "";
            if ("action.more.rename.notify".equals(intent.getAction())) {
                createMap.putString("newName", intent2.getStringExtra("extra.name"));
                createMap.putString("result", intent2.getStringExtra("extra.result"));
                if (deviceStat != null) {
                    str2 = deviceStat.did;
                }
                createMap.putString("did", str2);
                str = "deviceNameChanged_36621";
            } else {
                boolean z = false;
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                    if (deviceStat != null) {
                        str2 = deviceStat.mac;
                    }
                    createMap.putString("mac", str2);
                    if (((Boolean) gat.O000000o("bleStatusChangedJustOnOff", Boolean.TRUE)).booleanValue()) {
                        int intExtra = intent2.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                        if (intExtra == 12 || intExtra == 10) {
                            if (intExtra == 12) {
                                z = true;
                            }
                            createMap.putBoolean("isEnabled", z);
                        } else {
                            fyc.O00000Oo("RNEventReceiver", "onReceive, bluetoothStatusChanged: bleState=".concat(String.valueOf(intExtra)));
                            return;
                        }
                    } else {
                        if (12 == intent2.getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                            z = true;
                        }
                        long j = this.f8166O000000o;
                        long j2 = z ? 1 : 0;
                        if (j != j2) {
                            this.f8166O000000o = j2;
                            createMap.putBoolean("isEnabled", z);
                        } else {
                            return;
                        }
                    }
                    str = "bluetoothStatusChanged_36621";
                } else if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equals(intent.getAction())) {
                    if (16 == intent2.getIntExtra("key_connect_status", 0)) {
                        z = true;
                    }
                    String stringExtra = intent2.getStringExtra("key_device_address");
                    createMap.putString("mac", stringExtra);
                    if (!O000000o(stringExtra, z)) {
                        createMap.putBoolean("isConnected", z);
                    } else {
                        return;
                    }
                } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction())) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent2.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice != null) {
                        str2 = bluetoothDevice.getAddress();
                    }
                    createMap.putString("mac", str2);
                    if (!O000000o(str2, false)) {
                        createMap.putBoolean("isConnected", false);
                    } else {
                        return;
                    }
                } else {
                    int i = -1;
                    if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
                        if (intent2.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1) == 12) {
                            z = true;
                        }
                        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent2.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        if (bluetoothDevice2 != null) {
                            str2 = bluetoothDevice2.getAddress();
                        }
                        createMap.putString("mac", str2);
                        if (!O000000o(str2, z)) {
                            createMap.putBoolean("isConnected", z);
                        } else {
                            return;
                        }
                    } else if ("startscan_callback".equals(intent.getAction())) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            createMap.merge(Arguments.fromBundle(extras));
                        }
                        str = "bluetoothDeviceDiscovered_36621";
                    } else if ("discoverservices_callback".equals(intent.getAction())) {
                        createMap.putString("mac", intent2.getStringExtra("emit_mac"));
                        createMap.putArray("foundUUIDs", Arguments.fromArray(intent2.getStringArrayExtra("emit_uuid")));
                        str = "bluetoothSeviceDiscovered_36621";
                    } else if ("discovercharacteristics_callback".equals(intent.getAction())) {
                        createMap.putString("mac", intent2.getStringExtra("emit_mac"));
                        createMap.putString("serviceUUID", intent2.getStringExtra("emit_serviceid"));
                        createMap.putArray("foundUUIDs", Arguments.fromArray(intent2.getStringArrayExtra("emit_uuid")));
                        str = "bluetoothCharacteristicDiscovered_36621";
                    } else if ("com.xiaomi.smarthome.bluetooth.character_changed".equals(intent.getAction())) {
                        createMap.putString("mac", intent2.getStringExtra("key_device_address"));
                        createMap.putString("serviceUUID", intent2.getSerializableExtra("key_service_uuid").toString());
                        UUID uuid = (UUID) intent2.getSerializableExtra("key_character_uuid");
                        if (!glb.O0000oO.equals(uuid)) {
                            createMap.putString("characteristicUUID", uuid.toString());
                            createMap.putString("value", fyf.O000000o(intent2.getByteArrayExtra("key_character_value")));
                            str = "bluetoothCharacteristicValueChanged_36621";
                        } else {
                            return;
                        }
                    } else if ("devicestatuschanged".equals(intent.getAction())) {
                        createMap.putString("subcribeId", intent2.getStringExtra("emit_subid"));
                        createMap.putString("did", intent2.getStringExtra("emit_did"));
                        createMap.putString("data", intent2.getStringExtra("emit_data"));
                        str = "deviceRecievedMessages_36621";
                    } else if ("push_action_plugin".equals(intent.getAction())) {
                        if ("ScenePush".equals(intent2.getStringExtra("type"))) {
                            createMap.putString("did", intent2.getStringExtra("did"));
                            createMap.putString("event", intent2.getStringExtra("event"));
                            createMap.putString("extra", intent2.getStringExtra("extra"));
                            createMap.putBoolean("isNotified", intent2.getBooleanExtra("isNotified", false));
                            createMap.putDouble("time", (double) intent2.getLongExtra("time", 0));
                        }
                        str = "packageReceivedInformation_36621";
                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        NetworkInfo networkInfo = null;
                        if (intent.getExtras() != null) {
                            try {
                                networkInfo = (NetworkInfo) intent.getExtras().get("networkInfo");
                            } catch (Exception unused) {
                            }
                        }
                        if (networkInfo != null) {
                            if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                                i = 0;
                            } else if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED && "MOBILE".equals(networkInfo.getTypeName())) {
                                i = 1;
                            } else if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED && "WIFI".equals(networkInfo.getTypeName())) {
                                i = 2;
                            }
                        }
                        createMap.putInt("networkState", i);
                        str = "cellPhoneNetworkStateChanged_36621";
                    } else if ("com.xiaomi.deviceStatusChanged".equals(intent.getAction())) {
                        String stringExtra2 = intent2.getStringExtra("did");
                        createMap.putMap("newStatus", Arguments.fromBundle(intent2.getBundleExtra("deviceStatus")));
                        createMap.putString("did", stringExtra2);
                        gbu.O00000o0("device status changed");
                        str = "deviceStatusChanged_36621";
                    } else if ("device_pincode_switch_changed".equals(intent.getAction())) {
                        String stringExtra3 = intent2.getStringExtra("did");
                        Bundle bundleExtra = intent2.getBundleExtra("switchStatus");
                        if (bundleExtra != null) {
                            WritableMap fromBundle = Arguments.fromBundle(bundleExtra);
                            createMap.putString("did", stringExtra3);
                            createMap.putMap("switchStatus", fromBundle);
                            gbu.O00000o0("device pincode switch changed");
                        }
                        str = "pinCodeSwitchChanged_36621";
                    } else if ("com.xiaomi.iot.firmware.new_version".equals(intent.getAction())) {
                        createMap.putString("currentVersion", intent2.getStringExtra("current_version"));
                        createMap.putString("latestVersion", intent2.getStringExtra("latest_version"));
                        createMap.putString("did", intent2.getStringExtra("did"));
                        createMap.putString("mcu_version", intent2.getStringExtra("mcu_version"));
                        str = "bleDeviceFirmwareNeedUpgrade_36621";
                    } else if ("com.xiaomi.smarthome.ble.spec.notify".equals(intent.getAction())) {
                        createMap.putString("result", intent2.getStringExtra("json"));
                        str = "BLESpecNotifyActionEvent_36621";
                    } else if ("NETWORK.CONNECTION.CHANGED".equals(intent.getAction())) {
                        createMap.putString("ssid", intent2.getStringExtra("ssid"));
                        createMap.putBoolean("connected", intent2.getBooleanExtra("connected", false));
                        str = "networkConnectionChanged_36621";
                    } else {
                        str = str2;
                    }
                }
            }
            createMap.putString("eventName", str);
            if (fwz.O000000o().O00000Oo().O00000o0()) {
                gbu.O000000o("eventName: " + str + "  action: " + intent.getAction() + " data: " + createMap.toString());
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, createMap);
            }
        }
    }

    private boolean O000000o(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Integer num = this.O00000Oo.get(str);
        if (num != null && num.intValue() == z) {
            return true;
        }
        this.O00000Oo.put(str, Integer.valueOf(z ? 1 : 0));
        return false;
    }
}

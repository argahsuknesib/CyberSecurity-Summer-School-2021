package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;

public class hwh extends ConfigStep implements fot {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f852O000000o = true;
    public int O00000Oo;
    public String O00000o = "";
    public String O00000o0;
    public String O00000oO;
    public String O00000oo = null;
    public String O0000O0o = null;
    public Cfor O0000OOo;
    public int O0000Oo;
    public String O0000Oo0;
    public boolean O0000OoO = false;
    public hua<String, hud> O0000Ooo = new hua<String, hud>() {
        /* class _m_j.hwh.AnonymousClass4 */

        public final /* synthetic */ void O000000o(Object obj) {
            hwh hwh = hwh.this;
            hwh.O00000o = (String) obj;
            if (hwh.O00000o == null) {
                hwh.this.O00000o = "";
            }
            if (hwh.this.f852O000000o) {
                hwh.this.O0000o();
            }
        }

        public final void O000000o(hud hud) {
            fte.O00000Oo("BleMiTVStep getBindKey failed");
            hwh hwh = hwh.this;
            hwh.O00000o = "";
            if (hwh.f852O000000o) {
                hwh.this.O0000o();
            }
        }
    };
    private Handler O0000o;
    private String O0000o0;
    private int O0000o00 = 0;
    private String O0000o0O = "";
    private String O0000o0o;
    private boolean O000OooO = false;
    private boolean O000Oooo = false;
    private htl O000o00 = new htm() {
        /* class _m_j.hwh.AnonymousClass2 */

        public final void onDeviceConnectionFailure(int i) {
            fte.O00000Oo("BleMiTVStep DeviceFinderCallback.onDeviceConnectionFailure " + i + "currentIndex = " + hwh.this.O00000Oo);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwh.this.O00000o0, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            if (hwh.this.O00000Oo == 2) {
                hwh hwh = hwh.this;
                hwh.O000OoOo = "3000.2.5";
                hwh.O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                return;
            }
            if (i == -6) {
                hwh.this.O00000Oo(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                if (!hwh.this.O000OOoO) {
                    fte.O00000Oo("BleMiTVStep.DeviceFinder already bind!");
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwh.this.O00000o0, 3);
                }
            }
            fob.O000000o(hwh.this.O00000o0, hwh.this.O00000oO);
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            fte.O00000Oo("BleMiTVStep DeviceFinderCallback.onDeviceConnectionSuccess currentIndex = " + hwh.this.O00000Oo);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwh.this.O00000o0, BindStep.STEP_CHECK_BIND);
            if (hwh.this.O00000Oo == 2) {
                hwh.this.e_(2);
            }
            hwh hwh = hwh.this;
            hwh.O00000Oo = 3;
            hwh.O000OOo = false;
            hwh.O000OoO0 = true;
            hwh.e_(3);
            fob.O000000o(hwh.this.O00000o0, hwh.this.O00000oO);
        }

        public final void onDeviceConnectionFailure() {
            fte.O00000Oo("BleMiTVStep DeviceFinderCallback.onDeviceConnectionFailure currentIndex = " + hwh.this.O00000Oo);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwh.this.O00000o0, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            if (hwh.this.O00000Oo == 2) {
                hwh hwh = hwh.this;
                hwh.O000OoOo = "3000.2.5";
                hwh.O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                return;
            }
            fob.O000000o(hwh.this.O00000o0, hwh.this.O00000oO);
        }
    };
    private BroadcastReceiver O000o000 = new BroadcastReceiver() {
        /* class _m_j.hwh.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 5);
                if (TextUtils.equals(stringExtra, hwh.this.O0000Oo0)) {
                    fte.O00000Oo("BleMiTVStep bluetooth connect status = ".concat(String.valueOf(intExtra)));
                }
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action) && TextUtils.equals(stringExtra, hwh.this.O0000Oo0) && intExtra == 32) {
                    fte.O00000Oo("BleMiTVStep disconnect mac = " + fte.O000000o(hwh.this.O0000Oo0));
                    hwh hwh = hwh.this;
                    hwh.O0000OoO = true;
                    hwh.x_().removeMessages(127);
                    if (!hwh.this.O0000oO0()) {
                        hwh.this.C_();
                        hwh.this.O0000oO();
                    } else {
                        hwh.this.O0000o0o();
                    }
                    fob.O000000o(hwh.this.O00000o0, hwh.this.O0000Oo0);
                }
            }
        }
    };

    public final SmartConfigStep.Step A_() {
        return null;
    }

    private String O00000Oo(String str) {
        if (TextUtils.isEmpty(this.O0000o0) || this.O0000o0.length() != 4) {
            return null;
        }
        try {
            return str.substring(0, 12) + this.O0000o0.substring(0, 2) + ":" + this.O0000o0.substring(2, 4);
        } catch (Exception unused) {
            return "";
        }
    }

    public final void O000000o(Context context) {
        this.O0000o = new Handler(Looper.getMainLooper());
        this.O00000o0 = (String) htr.O000000o().O000000o("device_model");
        this.O00000oO = (String) htr.O000000o().O000000o("combo_ble_mac");
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O00000oO);
        this.O0000o0 = (String) htr.O000000o().O000000o("combo_ble_key");
        this.O0000o0O = (String) htr.O000000o().O000000o("mitv_did");
        this.O0000o0o = (String) htr.O000000o().O000000o("mitv_action");
        fte.O00000Oo("BleMiTVStep model = " + this.O00000o0 + ", combokey = " + this.O0000o0);
        htr.O000000o().O00000Oo("combo_strategy", 13);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O00000o0);
        if (!gnl.O00000Oo()) {
            this.O000OOo = false;
        }
        if (!O0000oO0()) {
            this.O00oOooo.setText(this.O000O0oo.getString(R.string.kuailian_config_wifi));
        }
    }

    public final void O0000o0o() {
        if (x_() != null) {
            x_().sendEmptyMessageDelayed(112, 0);
        }
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 112) {
            fte.O00000Oo("BleMiTVStep.handleMessage MSG_UPDATE_DEVICE_STATE");
            if (x_() != null) {
                x_().removeMessages(112);
                x_().removeMessages(114);
            }
            if (this.O00000Oo == 1) {
                O000OO0o();
                e_(1);
                O000O0oo();
            }
        } else if (i == 115) {
            fte.O00000Oo("BleMiTVStep.handleMessage MSG_DISCONNECT_TIME_OUT");
            O000OO0o();
        } else if (i == 125) {
            fte.O00000Oo("BleMiTVStep.handleMessage MSG_CONNECT_BLE_TIME_OUT");
            this.O000OoOo = "3000.2.2";
            SmartConfigRouterFactory.getCoreApiManager().stopSearchBluetoothDevice();
            try {
                SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
            } catch (Exception unused) {
            }
            this.O0000OOo.O00000o();
            fob.O000000o(this.O00000o0, this.O00000oO);
            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 1);
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o(2501), 1, "", this.O00000oO, this.O000Oo00, this.O00000o);
                }
            }
            if (this.O000Oo0o && this.O000Oo0O.isEmpty()) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(2501), this.O000Oo00, this.O000OOo));
            }
            if (this.O000OooO) {
                O00000Oo(SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR);
            } else {
                O00000Oo(SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR);
            }
        } else if (i != 127) {
            super.O000000o(message);
        } else {
            fte.O00000Oo("BleMiTVStep.handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O0000Oo);
            x_().removeMessages(127);
            this.O000Oooo = true;
            if (this.O00000Oo == 2) {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                return;
            }
            try {
                SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
            } catch (Exception unused2) {
            }
            this.O0000OOo.O00000o();
            if (!O0000oO0()) {
                C_();
                O0000oO();
                return;
            }
            O0000o0o();
        }
    }

    public final void z_() {
        this.O00000Oo = 0;
        this.f852O000000o = true;
    }

    public final int O00000Oo() {
        int i = this.O00000Oo;
        if (i != 0) {
            return i;
        }
        fte.O00000Oo("BleMiTVStep.getCurrentStageIndex mCurrentIndex = CONNECT_INDEX, mUseBleConfig = " + this.f852O000000o);
        if (this.f852O000000o) {
        }
        return 0;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        int i2 = i;
        this.O000OOoo = true;
        fob.O000000o(this.O00000o0, this.O00000oO);
        if (i2 == 0) {
            fte.O00000Oo("BleMiTVStep.onStageTimeOut CONNECT_INDEX, mUseBleConfig = " + this.f852O000000o);
            this.O000OoOo = "3000.2.2";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG, "ble connect failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o(2101), this.f852O000000o ? 1 : 0, "", "", this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 1);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(2101), this.O000Oo00, this.O000OOo));
            }
            if (TextUtils.isEmpty(this.O00000o)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            if (this.f852O000000o) {
                return SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR;
            }
            x_().removeMessages(123);
            return SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR;
        } else if (i2 == 1) {
            fte.O00000Oo("BleMiTVStep.onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f852O000000o);
            if (TextUtils.isEmpty(this.O00000o)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            this.O000OoOo = "3000.2.3";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    hve statPageV2Manager = SmartConfigRouterFactory.getStatPageV2Manager();
                    String str = this.O00000o0;
                    int O0000O0o2 = O0000O0o(2401);
                    boolean z = this.f852O000000o;
                    statPageV2Manager.page_device_fail4Combo(0, str, O0000O0o2, z ? 1 : 0, "", "", this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 2);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(2401), this.O000Oo00, this.O000OOo));
            }
            if (this.f852O000000o) {
                int i3 = this.O0000Oo;
                if (i3 == 0) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                }
                if (i3 == 1) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i3 == 2) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i3 == 5) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_AUTHENTICATION_ERROR");
                    this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
                    Resources resources = this.O000O0o0.getResources();
                    ddg ddg = this.O000O0o0;
                    ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
                    return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
                } else if (i3 == 4) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_UNKNONW_ERROR");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i3 == 3) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else {
                    fte.O00000Oo(String.format(">>> Unknown notifyStatus = %d", Integer.valueOf(i3)));
                    return null;
                }
            } else if (this.O0000o00 == 1) {
                return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
            } else {
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O00000o0);
                if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                }
                return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR;
            }
        } else if (i2 != 3) {
            return null;
        } else {
            fte.O00000Oo("BleMiTVStep.onStageTimeOut GET_NEW_DEVICE_INDEX，mUseBleConfig = " + this.f852O000000o);
            this.O000OoOo = "3000.2.4";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_CHECK_BIND, "get new device failed");
            O00oOooO();
            if (!hze.O000000o(this.O000O0oo)) {
                this.O000OOo = false;
            }
            int O0000O0o3 = O0000O0o(gon.O000000o(true, this.O0000OoO, this.O0000Oo));
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i4 = this.O0000Oo == 3 ? 2 : 1;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o3, i4, "", this.O00000oO, this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 3);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o3, this.O000Oo00, this.O000OOo));
            }
            if (this.f852O000000o) {
                return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
            }
            htk.O000000o().O00000Oo();
            PluginDeviceInfo pluginInfo2 = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O00000o0);
            if (pluginInfo2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(pluginInfo2.O0000ooO());
                gsy.O000000o(6, "AoConfigStep", sb.toString());
            }
            if (pluginInfo2 == null || pluginInfo2.O0000ooO() == 0) {
                return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
            }
            return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR;
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        Resources resources = this.O000O0o0.getResources();
        int i = this.O00000Oo;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_connect_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o((int) R.string.ble_combo_transfer_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            if (O0000oO0()) {
                this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.ble_combo_connect_title_loading);
            }
        } else if (i != 2) {
            if (i == 3 && O0000oO0()) {
                this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_device_connect_network_step_success, (int) R.string.ble_combo_network_title_loading);
            }
        } else if (O0000oO0()) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_combo_connect_title_loading);
            ddg ddg = this.O000O0o0;
            ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
            this.O000O0o0.O000000o(3);
        }
    }

    public final void s_() {
        int i = this.O00000Oo;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(1);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_combo_transfer_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(2);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_new_bind_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            Resources resources = this.O000O0o0.getResources();
            ddg ddg = this.O000O0o0;
            BaseBindView.StepStatus stepStatus = BaseBindView.StepStatus.LOADING;
            ddg.O000000o(stepStatus, resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), R.string.ble_combo_network_title_loading, false);
            this.O000O0o0.O000000o(3);
        }
    }

    public final void O000000o(final hua<String, hud> hua) {
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hwh.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                hua.O000000o((String) obj);
            }

            public final void O000000o(hud hud) {
                hua.O000000o(hud);
            }
        });
    }

    public final Handler x_() {
        Handler x_ = super.x_();
        if (x_ != null) {
            return x_;
        }
        return this.O0000o;
    }

    public final void O000000o(String str) {
        BleDevice bleDevice;
        boolean z;
        int i;
        fte.O00000Oo(String.format("BleMiTVStep.onSearchComboAddress, mac = %s", fte.O000000o(str)));
        if (!TextUtils.isEmpty(str)) {
            this.O0000Oo0 = str;
            if (this.O000Ooo0) {
                BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) htr.O000000o().O000000o("bluetooth_search_result");
                MiotBleAdvPacket O000000o2 = dda.O000000o(bluetoothSearchResult.O00000o0);
                BtDevice btDevice = new BtDevice(bluetoothSearchResult);
                btDevice.setModel(this.O00000o0);
                btDevice.O000000o(O000000o2);
                bleDevice = BleDevice.O000000o(btDevice);
            } else {
                bleDevice = fob.O00000o0(str);
            }
            if (bleDevice == null || bleDevice.O00000Oo() == null || bleDevice.O00000Oo().f6871O000000o == null) {
                i = 0;
                z = true;
            } else {
                i = bleDevice.O00000Oo().f6871O000000o.O0000OOo;
                z = fea.O000000o(bleDevice.O00000Oo().f6871O000000o.O0000Oo0);
                gsy.O00000Oo("BleMiTVStep", "authMode = ".concat(String.valueOf(i)));
                gsy.O00000Oo("BleMiTVStep", "frameControl version = " + bleDevice.O00000Oo().f6871O000000o.O0000Oo0);
            }
            if ((i == 0 || i == 2) && z) {
                this.O0000Oo0 = str;
                SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(true ^ TextUtils.isEmpty(this.O00000o), "BleMiTVStep", this.O00000o0);
                this.O0000OOo.O000000o(false, this.O00000o, this.O0000oo0.type, this.O0000O0o);
                return;
            }
            fte.O00000Oo("don't support authMode = ".concat(String.valueOf(i)));
            this.O000OooO = true;
            if (x_().hasMessages(125)) {
                x_().removeMessages(125);
                x_().sendEmptyMessage(125);
                return;
            }
            return;
        }
        if (!this.O000OOoO && this.O000OOo) {
            this.O000OOoO = true;
            if (!this.O000Oo0o) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o(2701), 1, "", this.O00000oO, this.O000Oo00, this.O00000o);
            }
        }
        if (this.O000Oo0o) {
            this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(2701), this.O000Oo00, this.O000OOo));
        }
        if (x_().hasMessages(125)) {
            x_().removeMessages(125);
            x_().sendEmptyMessage(125);
        }
    }

    public final void O000000o(int i, String str, String str2) {
        fte.O00000Oo("BleMiTVStep.onSendSSIDAndPassWd code = " + i + ", firmwareVersion = " + str + ", deviceDid = " + str2);
        this.O000Oo00 = str;
        if (i != 0) {
            if (i == -37) {
                this.O000OooO = true;
            }
            if (x_().hasMessages(125)) {
                x_().removeMessages(125);
                int O0000O0o2 = O0000O0o(29000 - i);
                if (!this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o2, 1, "", this.O00000oO, this.O000Oo00, this.O00000o);
                    }
                }
                if (this.O000Oo0o) {
                    this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o2, this.O000Oo00, this.O000OOo));
                }
                if (i == -6) {
                    SmartConfigRouterFactory.getSmartConfigManager().bleDisconnect(this.O00000oO);
                    x_().sendEmptyMessageDelayed(125, 2000);
                    return;
                }
                x_().sendEmptyMessage(125);
            }
        } else if (this.f852O000000o && !this.O000OO00) {
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().registerReceiver(this.O000o000, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
            x_().removeMessages(125);
            this.O0000OOo.O000000o();
            this.O000Oooo = false;
            e_(this.O00000Oo);
            O00000o0(1);
            x_().sendEmptyMessageDelayed(127, 50000);
        }
    }

    private void O000O0oo() {
        fte.O00000Oo("BleMiTVStep.onScDeviceBindToPassport isScComboWithLogin = " + O0000oO0());
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
        if (O0000oO0()) {
            this.O00000Oo = 2;
            O000OO00();
            return;
        }
        this.O00000Oo = 3;
        O000OO();
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
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
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent} */
    private void O000OO00() {
        Boolean isMiAccountSystem = SmartConfigRouterFactory.getSmartConfigManager().isMiAccountSystem(this.O000O0oo);
        if (isMiAccountSystem != null) {
            if (isMiAccountSystem.booleanValue()) {
                fte.O00000Oo("BleMiTVStep.startPassportAuth Use System Account");
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName("com.xiaomi.account", "com.xiaomi.account.ui.AccountWebActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(this.O00000oo));
                if (this.O000Ooo0) {
                    intent.putExtra("style", "dialog");
                    intent.putExtra("show_title", true);
                    intent.putExtra("height_ratio", 0.7d);
                    dcp.O000000o().O000000o(true);
                }
                List<ResolveInfo> queryIntentActivities = this.O000O0oo.getPackageManager().queryIntentActivities(intent, 1);
                if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                    fte.O00000Oo("BleMiTVStep.startPassportAuth No Acctivity Found!");
                    this.O000OoOo = "3000.2.5";
                    O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                    return;
                }
                ((Activity) this.O000O0oo).startActivityForResult(intent, 101);
                return;
            }
            fte.O00000Oo("BleMiTVStep.startPassportAuth Use Local Account");
            fbt fbt = new fbt(this.O000O0oo, "ScDeviceLocalAccountWebAuthActivity");
            if (this.O000Ooo0) {
                fbt.O000000o("height_ratio");
            }
            fbt.O000000o("login_url", this.O00000oo).O000000o(100);
            fbs.O000000o(fbt);
        }
    }

    public final boolean O0000oO0() {
        return "init".equals(this.O0000o0o);
    }

    private static String O00000Oo(int i) {
        if (i == 0) {
            return "NOTIFY_START";
        }
        if (i == 1) {
            return "connecting router";
        }
        if (i == 2) {
            return "router connected";
        }
        if (i == 3) {
            return "server connected";
        }
        if (i != 4) {
            return i != 5 ? "unknown ".concat(String.valueOf(i)) : "pwd error";
        }
        return "unknown error";
    }

    public final void d_(int i) {
        this.O0000Oo = i;
        fte.O00000Oo("onNotifyStatus " + O00000Oo(i));
        if (this.f852O000000o && x_().hasMessages(127)) {
            switch (i) {
                case 0:
                case 1:
                default:
                    return;
                case 2:
                    if (O0000oO0() && this.O00000Oo == 1) {
                        e_(1);
                        this.O00000Oo = 2;
                        O000OO00();
                    }
                    if (!O0000oO0()) {
                        try {
                            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
                        } catch (Exception unused) {
                        }
                        this.O0000OOo.O00000o();
                        x_().removeMessages(127);
                        C_();
                        O0000oO();
                        return;
                    }
                    return;
                case 3:
                    try {
                        SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
                    } catch (Exception unused2) {
                    }
                    if (this.O00000Oo == 2) {
                        e_(2);
                    }
                    this.O0000OOo.O00000o();
                    x_().removeMessages(127);
                    O0000o0o();
                    return;
                case 4:
                case 5:
                    try {
                        SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
                    } catch (Exception unused3) {
                    }
                    x_().removeMessages(127);
                    O00000Oo(SmartConfigStep.Step.STEP_BLE_PWD_ERROR);
                    return;
                case 6:
                    if (this.O00000Oo == 2) {
                        e_(2);
                        this.O00000Oo = 3;
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
                        O000OO();
                        return;
                    }
                    return;
            }
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        try {
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o000);
        } catch (Exception unused) {
        }
        this.O0000o.removeCallbacksAndMessages(null);
        fpo.O00000Oo();
        boolean booleanValue = ((Boolean) htr.O000000o().O000000o("restore_wifi", Boolean.FALSE)).booleanValue();
        fte.O00000Oo(String.format("wifi restore ? -> %b", Boolean.valueOf(booleanValue)));
        Cfor forR = this.O0000OOo;
        if (forR == null) {
            return;
        }
        if (booleanValue) {
            forR.O000000o(new fou() {
                /* class _m_j.hwh.AnonymousClass6 */

                public final void O000000o() {
                    hwh.this.O0000OOo.O00000o();
                }
            });
        } else {
            forR.O00000o();
        }
    }

    private void O000OO() {
        String O00000Oo2 = O00000Oo(this.O00000oO);
        fte.O00000Oo("BleMiTVStep.scanNewDevice bssid = " + O00000Oo2 + ", mDeviceDid = " + this.O0000o0O + ", mBindKey = " + this.O00000o);
        htk.O000000o().O000000o(this.O000o00, O00000Oo2, this.O0000o0O, this.O00000o, this.O00000o0, 60000);
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O00000o0, BindStep.STEP_CHECK_BIND);
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwh.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WifiManager wifiManager = (WifiManager) hwh.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                    if (wifiManager != null) {
                        wifiManager.getConnectionInfo();
                    }
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    if (hwh.this.O00000Oo == 3 && ((hwh.this.O0000Oo == 0 && !hwh.this.O0000OoO) || !(hwh.this.O0000Oo == 0 || hwh.this.O0000Oo == 3))) {
                        hwh.this.O000OOo = false;
                    }
                    if (!hwh.this.O000OOoO && hwh.this.O000OOo && !hwh.this.O000OOoo) {
                        hwh hwh = hwh.this;
                        hwh.O000OOoO = true;
                        int O0000O0o = hwh.O0000O0o(gon.O000000o(hwh.O00000Oo));
                        if (!hwh.this.O000Oo0o) {
                            hxy hxy = new hxy(0L, hwh.this.O00000o0, O0000O0o, hwh.this.O000Oo00, true);
                            hxy.O0000OoO = hwh.this.O00000o;
                            SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                        } else if (hwh.this.O000Oo0O.isEmpty()) {
                            hxy hxy2 = new hxy(0L, hwh.this.O00000o0, O0000O0o, hwh.this.O000Oo00, true);
                            hxy2.O0000OoO = hwh.this.O00000o;
                            hwh.this.O000Oo0O.push(hxy2);
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwh.this.O00000o0, 4);
                    }
                    hwh.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == 100 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("login_result", false);
            fte.O00000Oo("BleMiTVStep.onActivityResult login_result = ".concat(String.valueOf(booleanExtra)));
            if (!booleanExtra) {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                return;
            } else if (this.O00000Oo == 2) {
                e_(2);
                this.O00000Oo = 3;
            } else {
                return;
            }
        } else if (i == 101) {
            if (this.O000Ooo0) {
                dcp.O000000o().O000000o(false);
            }
            if (!this.O000Oooo) {
                return;
            }
            if (this.O00000Oo == 2) {
                this.O00000Oo = 2;
            }
        } else {
            return;
        }
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
        O000OO();
    }

    public final ArrayList<gke> O0000Oo0() {
        fte.O00000Oo("BleMiTVStep.getAllConfigStages");
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 90000;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 60000;
        arrayList.add(gke2);
        if (O0000oO0()) {
            gke gke3 = new gke();
            gke3.f17943O000000o = 2;
            gke3.O00000Oo = 20000;
            arrayList.add(gke3);
            gke gke4 = new gke();
            gke4.f17943O000000o = 3;
            gke4.O00000Oo = 60000;
            arrayList.add(gke4);
        }
        return arrayList;
    }

    public final void O00000o0(int i) {
        if (i == 0) {
            fte.O00000Oo("BleMiTVStep.startConnection CONNECT_INDEX, mUseBleConfig = " + this.f852O000000o);
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
            if (O0000oO0()) {
                SmartConfigRouterFactory.getSmartConfigManager().getLoginInfo(new hua<huv, hud>() {
                    /* class _m_j.hwh.AnonymousClass3 */

                    public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                        huv huv = (huv) obj;
                        hwh.this.O00000oo = huv.O00000o0;
                        hwh.this.O0000O0o = huv.O00000Oo;
                        hwh hwh = hwh.this;
                        hwh.O000000o(hwh.O0000Ooo);
                    }

                    public final void O000000o(hud hud) {
                        hwh.this.O00000Oo(SmartConfigStep.Step.STEP_BLE_SEND_ERROR);
                    }
                });
            } else {
                O000000o(this.O0000Ooo);
            }
        } else if (i == 1) {
            fte.O00000Oo("BleMiTVStep.startConnection SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f852O000000o);
            if (this.f852O000000o) {
                fte.O00000Oo("BleMiTVStep >>> current mNotifyStatus = " + O00000Oo(this.O0000Oo));
                int i2 = this.O0000Oo;
                if (i2 == 0) {
                    this.O00000Oo = 1;
                } else if (i2 == 4) {
                    fte.O00000Oo("BleMiTVStep.retryComboConnect");
                    this.O0000Oo = 0;
                    this.f852O000000o = true;
                    this.O0000OOo.O00000o0();
                    x_().removeMessages(125);
                    x_().removeMessages(127);
                    this.O0000OOo.O000000o();
                    x_().sendEmptyMessageDelayed(127, 50000);
                } else if (i2 == 3) {
                    this.f852O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Oo);
                } else if (gnl.O00000o0(this.O0000Oo0)) {
                    this.f852O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Oo);
                } else {
                    x_().removeMessages(127);
                    O0000o0o();
                }
            }
        } else if (i == 2) {
            this.O00000oo = (String) htr.O000000o().O000000o("sc_ble_login_url");
            if (!TextUtils.isEmpty(this.O00000oo)) {
                O000O0oo();
                return;
            }
            this.O000OoOo = "3000.2.5";
            O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
        } else if (i == 3) {
            fte.O00000Oo("BleMiTVStep.startConnection GET_NEW_DEVICE_INDEX");
            fte.O00000Oo(">>> current mNotifyStatus = " + O00000Oo(this.O0000Oo));
            O000OO0o();
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
            this.O00000Oo = 3;
            O000OO();
        }
    }

    public final void O0000o() {
        fte.O00000Oo("BleMiTVStep.startConnectToBle");
        this.O00000Oo = 0;
        if (TextUtils.isEmpty(this.O00000o)) {
            O0000oOO();
            return;
        }
        if (this.O0000OOo == null) {
            this.O0000OOo = new fos(this);
        }
        String str = this.O00000oO;
        if (str != null) {
            this.O0000OOo.O000000o(str);
        } else {
            b_(true);
        }
        x_().sendEmptyMessageDelayed(125, 62000);
    }

    public final void O0000oO() {
        if (this.O000Ooo0) {
            x_().removeMessages(110);
            x_().postDelayed(new Runnable() {
                /* class _m_j.hwh.AnonymousClass7 */

                public final void run() {
                    fbt fbt = new fbt(hwh.this.O000O0oo, "SmartConfigMainActivity");
                    fbt.O00000Oo(268435456);
                    fbs.O000000o(fbt);
                    ((Activity) hwh.this.O000O0oo).finish();
                    dcp.O000000o().O000000o((Activity) hwh.this.O000O0oo);
                }
            }, 3000);
            return;
        }
        this.O000O0o0.O00000oO();
        this.O000O0o0.setCommonBtnVisibility(0);
        this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
            /* class _m_j.hwh.AnonymousClass8 */

            public final void onClick(View view) {
                hwh.this.b_(true);
            }
        });
    }

    private void O000OO0o() {
        fte.O00000Oo("BleMiTVStep.onStopConnection");
        x_().removeMessages(112);
        x_().removeMessages(114);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000ooo.bindProcessToNetwork(null);
        }
    }
}

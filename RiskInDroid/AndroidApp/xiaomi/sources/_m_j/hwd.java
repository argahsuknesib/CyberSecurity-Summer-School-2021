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
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class hwd extends ConfigStep implements fot {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f818O000000o = true;
    public int O00000Oo;
    public String O00000o = "";
    public String O00000o0;
    public String O00000oO;
    public long O00000oo;
    public String O0000O0o;
    public String O0000OOo = null;
    public Cfor O0000Oo;
    public String O0000Oo0 = null;
    public String O0000OoO;
    public int O0000Ooo;
    private int O0000o = 0;
    public boolean O0000o0 = false;
    public boolean O0000o00 = false;
    public hua<String, hud> O0000o0O = new hua<String, hud>() {
        /* class _m_j.hwd.AnonymousClass4 */

        public final /* synthetic */ void O000000o(Object obj) {
            hwd hwd = hwd.this;
            hwd.O00000o = (String) obj;
            if (hwd.O00000o == null) {
                hwd.this.O00000o = "";
            }
            if (hwd.this.f818O000000o) {
                hwd.this.O0000o0o();
            }
        }

        public final void O000000o(hud hud) {
            hwd.this.O000000o("BleComboBleWayStep getBindKey failed", new Object[0]);
            hwd hwd = hwd.this;
            hwd.O00000o = "";
            if (hwd.f818O000000o) {
                hwd.this.O0000o0o();
            }
        }
    };
    public boolean O0000o0o = false;
    private String O000OooO;
    private String O000Oooo = "";
    private htl O000o0 = new htm() {
        /* class _m_j.hwd.AnonymousClass2 */

        public final void onDeviceConnectionFailure(int i) {
            hwd hwd = hwd.this;
            hwd.O000000o("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionFailure " + i + "currentIndex = " + hwd.this.O00000Oo, new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwd.this.O00000o0, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (hwd.this.O00000Oo == 2) {
                hwd hwd2 = hwd.this;
                hwd2.O000OoOo = "3000.2.5";
                hwd2.O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                return;
            }
            if (i == -6) {
                hwd.this.O00000Oo(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                if (!hwd.this.O000OOoO) {
                    hwd.this.O000000o("BleComboBleWayStep DeviceFinder already bind!", new Object[0]);
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwd.this.O00000o0, 3);
                }
            }
            fob.O000000o(hwd.this.O00000o0, hwd.this.O00000oO);
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hwd hwd = hwd.this;
            hwd.O000000o("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionSuccess currentIndex = " + hwd.this.O00000Oo, new Object[0]);
            fte.O00000Oo("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionSuccess currentIndex = " + hwd.this.O00000Oo);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwd.this.O00000o0, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            if (hwd.this.O00000Oo == 2) {
                hwd.this.e_(2);
            }
            hwd hwd2 = hwd.this;
            hwd2.O00000Oo = 3;
            hwd2.O000OOo = false;
            hwd2.O000OoO0 = true;
            hwd2.e_(3);
            fob.O000000o(hwd.this.O00000o0, hwd.this.O00000oO);
        }

        public final void onDeviceConnectionFailure() {
            hwd hwd = hwd.this;
            hwd.O000000o("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionFailure currentIndex = " + hwd.this.O00000Oo, new Object[0]);
            fte.O00000Oo("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionFailure currentIndex = " + hwd.this.O00000Oo);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwd.this.O00000o0, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (hwd.this.O00000Oo == 2) {
                hwd hwd2 = hwd.this;
                hwd2.O000OoOo = "3000.2.5";
                hwd2.O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                return;
            }
            fob.O000000o(hwd.this.O00000o0, hwd.this.O00000oO);
        }
    };
    private boolean O000o00 = false;
    private Handler O000o000;
    private boolean O000o00O = false;
    private BroadcastReceiver O000o00o = new BroadcastReceiver() {
        /* class _m_j.hwd.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 5);
                if (TextUtils.equals(stringExtra, hwd.this.O0000OoO)) {
                    fte.O00000Oo("BleComboBleWayStep bluetooth connect status = ".concat(String.valueOf(intExtra)));
                }
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action) && TextUtils.equals(stringExtra, hwd.this.O0000OoO) && intExtra == 32) {
                    hwd hwd = hwd.this;
                    hwd.O000000o("BleComboBleWayStep disconnect mac = " + fte.O000000o(hwd.this.O0000OoO), new Object[0]);
                    hwd hwd2 = hwd.this;
                    hwd2.O0000o00 = true;
                    hwd2.x_().removeMessages(127);
                    hwd.this.O0000o0O();
                    hwd hwd3 = hwd.this;
                    hwd3.O0000o0 = true;
                    fob.O000000o(hwd3.O00000o0, hwd.this.O0000OoO);
                }
            }
        }
    };
    private hto O000o0O = null;
    private long O000o0O0 = 60000;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    private String O00000Oo(String str) {
        if (TextUtils.isEmpty(this.O000OooO) || this.O000OooO.length() != 4) {
            return null;
        }
        try {
            return str.substring(0, 12) + this.O000OooO.substring(0, 2) + ":" + this.O000OooO.substring(2, 4);
        } catch (Exception unused) {
            return "";
        }
    }

    public final void O000000o(Context context) {
        this.O000o000 = new Handler(Looper.getMainLooper());
        this.O00000o0 = (String) htr.O000000o().O000000o("device_model");
        this.O00000oO = (String) htr.O000000o().O000000o("combo_ble_mac");
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O00000oO);
        this.O000OooO = (String) htr.O000000o().O000000o("combo_ble_key");
        O000000o("BleComboBleWayStep onCreateStep model = " + this.O00000o0 + ", combokey = " + this.O000OooO, new Object[0]);
        htr.O000000o().O00000Oo("combo_strategy", 13);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O00000o0);
        if (!gnl.O00000Oo()) {
            this.O000OOo = false;
        }
    }

    public final void O0000o0O() {
        if (x_() != null) {
            x_().sendEmptyMessageDelayed(112, 0);
        }
    }

    public final void O000000o(Message message) {
        int i;
        int i2 = message.what;
        if (i2 == 112) {
            O000000o("BleComboBleWayStep handleMessage MSG_UPDATE_DEVICE_STATE", new Object[0]);
            if (x_() != null) {
                x_().removeMessages(112);
                x_().removeMessages(114);
            }
            if (this.O00000Oo == 1) {
                O000O0oo();
                e_(1);
                O0000o();
            }
        } else if (i2 == 115) {
            O000000o("BleComboBleWayStep handleMessage MSG_DISCONNECT_TIME_OUT", new Object[0]);
            O000O0oo();
        } else if (i2 == 125) {
            O000000o("BleComboBleWayStep handleMessage MSG_CONNECT_BLE_TIME_OUT", new Object[0]);
            this.O000OoOo = "3000.2.2";
            SmartConfigRouterFactory.getCoreApiManager().stopSearchBluetoothDevice();
            try {
                SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o00o);
            } catch (Exception unused) {
            }
            this.O0000Oo.O00000o();
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(62000);
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
            if (this.O000o00) {
                O00000Oo(SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR);
            } else {
                O00000Oo(SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR);
            }
        } else if (i2 != 127) {
            super.O000000o(message);
        } else {
            O000000o("BleComboBleWayStep handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O0000Ooo, new Object[0]);
            x_().removeMessages(127);
            this.O000o00O = true;
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2401);
            if (this.O00000Oo == 2) {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
            } else if (!DeviceFactory.O00000o0(this.O00000o0) || !((i = this.O0000Ooo) == 1 || i == 5)) {
                try {
                    SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o00o);
                } catch (Exception unused2) {
                }
                this.O0000o0 = true;
                this.O0000Oo.O00000o();
                O0000o0O();
            } else {
                O000000o(SmartConfigStep.Step.STEP_BLE_PWD_ERROR);
            }
        }
    }

    public final void z_() {
        this.O00000Oo = 0;
        this.f818O000000o = true;
    }

    public final int O00000Oo() {
        int i = this.O00000Oo;
        if (i != 0) {
            return i;
        }
        if (this.f818O000000o) {
        }
        return 0;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        int i2 = i;
        this.O000OOoo = true;
        fob.O000000o(this.O00000o0, this.O00000oO);
        if (i2 == 0) {
            O000000o("BleComboBleWayStep onStageTimeOut CONNECT_INDEX, mUseBleConfig = " + this.f818O000000o, new Object[0]);
            this.O000OoOo = "3000.2.2";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG, "ble connect failed");
            int i3 = 2101;
            eyr.O00000Oo();
            if (TextUtils.isEmpty(this.O00000o)) {
                i3 = 2102;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o(i3), this.f818O000000o ? 1 : 0, "", "", this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 1);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(i3), this.O000Oo00, this.O000OOo));
            }
            if (TextUtils.isEmpty(this.O00000o)) {
                this.O000OoOo = "3000.2.1";
                if (this.f818O000000o) {
                    x_().removeMessages(125);
                } else {
                    x_().removeMessages(123);
                }
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            } else if (this.f818O000000o) {
                return SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR;
            } else {
                x_().removeMessages(123);
                return SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR;
            }
        } else if (i2 == 1) {
            O000000o("BleComboBleWayStep onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f818O000000o, new Object[0]);
            this.O000OoOo = "3000.2.3";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    hve statPageV2Manager = SmartConfigRouterFactory.getStatPageV2Manager();
                    String str = this.O00000o0;
                    int O0000O0o2 = O0000O0o(2401);
                    boolean z = this.f818O000000o;
                    statPageV2Manager.page_device_fail4Combo(0, str, O0000O0o2, z ? 1 : 0, "", "", this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 2);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o(2401), this.O000Oo00, this.O000OOo));
            }
            if (this.f818O000000o) {
                int i4 = this.O0000Ooo;
                if (i4 == 0) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                }
                if (i4 == 1) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i4 == 2) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i4 == 5) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_AUTHENTICATION_ERROR");
                    this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
                    Resources resources = this.O000O0o0.getResources();
                    ddg ddg = this.O000O0o0;
                    ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
                    return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
                } else if (i4 == 4) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_UNKNONW_ERROR");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i4 == 3) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else {
                    fte.O00000Oo(String.format(">>> Unknown notifyStatus = %d", Integer.valueOf(i4)));
                    return null;
                }
            } else if (this.O0000o == 1) {
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
            O000000o("BleComboBleWayStep onStageTimeOut GET_NEW_DEVICE_INDEX，mUseBleConfig = " + this.f818O000000o, new Object[0]);
            this.O000OoOo = "3000.2.4";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_CHECK_BIND, "get new device failed");
            O00oOooO();
            if (!hze.O000000o(this.O000O0oo)) {
                this.O000OOo = false;
            }
            int O0000O0o3 = O0000O0o(gon.O000000o(true, this.O0000o00, this.O0000Ooo));
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i5 = this.O0000Ooo == 3 ? 2 : 1;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.O00000o0, O0000O0o3, i5, "", this.O00000oO, this.O000Oo00, this.O00000o);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O00000o0, 3);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.O00000o0, O0000O0o3, this.O000Oo00, this.O000OOo));
            }
            if (this.f818O000000o) {
                return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
            }
            if (this.O000o0O == null) {
                htk.O000000o().O00000Oo();
            } else {
                htk.O000000o().O000000o(this.O000o0O);
            }
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
            if (O0000oO()) {
                this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.ble_combo_connect_title_loading);
            } else {
                ddg ddg = this.O000O0o0;
                ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
            }
            this.O000O0o0.O000000o(3);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_combo_connect_title_loading);
            ddg ddg2 = this.O000O0o0;
            ddg2.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_device_connect_network_step_success, (int) R.string.ble_combo_network_title_loading);
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

    public final void O00000o0(int i) {
        if (i == 0) {
            O000000o("BleComboBleWayStep startConnection CONNECT_INDEX, mUseBleConfig = " + this.f818O000000o, new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
            if (O0000oO()) {
                SmartConfigRouterFactory.getSmartConfigManager().getLoginInfo(new hua<huv, hud>() {
                    /* class _m_j.hwd.AnonymousClass3 */

                    public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                        huv huv = (huv) obj;
                        hwd.this.O0000OOo = huv.O00000o0;
                        hwd.this.O0000Oo0 = huv.O00000Oo;
                        hwd hwd = hwd.this;
                        hwd.O000000o(hwd.O0000o0O);
                    }

                    public final void O000000o(hud hud) {
                        hwd.this.O00000Oo(SmartConfigStep.Step.STEP_BLE_SEND_ERROR);
                    }
                });
            } else {
                O000000o(this.O0000o0O);
            }
        } else if (i == 1) {
            O000000o("BleComboBleWayStep startConnection SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f818O000000o, new Object[0]);
            if (this.f818O000000o) {
                O000000o("BleComboBleWayStep startConnection SEND_SSID_AND_PASSWD_INDEX  >>> current mNotifyStatus = " + O00000Oo(this.O0000Ooo), new Object[0]);
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(213);
                int i2 = this.O0000Ooo;
                if (i2 == 0) {
                    this.O00000Oo = 1;
                } else if (i2 == 4) {
                    O000000o("BleComboBleWayStep retryComboConnect", new Object[0]);
                    this.O0000Ooo = 0;
                    this.f818O000000o = true;
                    this.O0000Oo.O00000o0();
                    x_().removeMessages(125);
                    x_().removeMessages(127);
                    this.O0000Oo.O000000o();
                    x_().sendEmptyMessageDelayed(127, 50000);
                } else if (i2 == 3) {
                    this.f818O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Ooo);
                } else if (gnl.O00000o0(this.O0000OoO)) {
                    this.f818O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Ooo);
                } else {
                    x_().removeMessages(127);
                    O0000o0O();
                }
            }
        } else if (i == 2) {
            this.O0000OOo = (String) htr.O000000o().O000000o("sc_ble_login_url");
            O000000o("BleComboBleWayStep startConnection SC_BIND_PASSPORT_INDEX mLoginUrl = " + this.O0000OOo, new Object[0]);
            if (!TextUtils.isEmpty(this.O0000OOo)) {
                O0000o();
                return;
            }
            this.O000OoOo = "3000.2.5";
            O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
        } else if (i == 3) {
            O000000o("BleComboBleWayStep startConnection GET_NEW_DEVICE_INDEX >>> current mNotifyStatus = " + O00000Oo(this.O0000Ooo), new Object[0]);
            O000O0oo();
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
            this.O00000Oo = 3;
            O000OO00();
        }
    }

    public final void O000000o(final hua<String, hud> hua) {
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
        htq.O000000o().O00000o0(this.O00000o0, SmartConfigRouterFactory.getCoreApiManager().getMiId(), new hua<JSONObject, hud>() {
            /* class _m_j.hwd.AnonymousClass5 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                hwd.this.O000000o(" getBindKeyX onSuccess ".concat(String.valueOf(jSONObject)), new Object[0]);
                if (jSONObject == null || jSONObject.length() == 0) {
                    O000000o((hud) null);
                    return;
                }
                hwd.this.O00000oo = jSONObject.optLong("timestamp");
                String optString = jSONObject.optString("bindKey");
                String optString2 = jSONObject.optString("bindKeyIndex");
                hwd hwd = hwd.this;
                if ("0".equals(optString2)) {
                    optString2 = null;
                }
                hwd.O0000O0o = optString2;
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey_new", optString);
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                hua.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                hwd.this.O000000o(" getBindKeyX onFailure ".concat(String.valueOf(hud)), new Object[0]);
                if (hwd.this.O000O0o) {
                    hwd.this.O000000o(new hua<String, hud>() {
                        /* class _m_j.hwd.AnonymousClass5.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            hwd.this.O00000oo = 0;
                            hwd.this.O0000O0o = null;
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey", str);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                            hua.O000000o(str);
                        }

                        public final void O000000o(hud hud) {
                            if (hud != null) {
                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", hud.O000000o());
                            }
                            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2801);
                            hua.O000000o(hud);
                        }
                    }, 2);
                }
            }
        });
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hwd.AnonymousClass6 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                hwd.this.O000000o("getBindKey onSuccess,key =".concat(String.valueOf(str)), new Object[0]);
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                hwd.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                int i = i;
                if (i == 0) {
                    Object O000000o2 = htr.O000000o().O000000o("wifi_bind_key");
                    if (O000000o2 != null) {
                        String str = (String) O000000o2;
                        if (!TextUtils.isEmpty(str)) {
                            hwd.this.O000000o("getBindKey from local", new Object[0]);
                            hua.O000000o(str);
                            return;
                        }
                    }
                    hwd.this.O0000oOO();
                    return;
                }
                hwd.this.O000000o(hua, i - 1);
            }
        });
    }

    public final Handler x_() {
        Handler x_ = super.x_();
        if (x_ != null) {
            return x_;
        }
        return this.O000o000;
    }

    public final void O0000o0o() {
        O000000o("BleComboBleWayStep startConnectToBle", new Object[0]);
        this.O00000Oo = 0;
        if (TextUtils.isEmpty(this.O00000o)) {
            O0000oOO();
            return;
        }
        if (this.O0000Oo == null) {
            this.O0000Oo = new fos(this);
        }
        if (this.O00000oO != null) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(202);
            this.O0000Oo.O000000o(this.O00000oO);
        } else {
            b_(true);
        }
        x_().sendEmptyMessageDelayed(125, 62000);
    }

    public final void O000000o(String str) {
        BleDevice bleDevice;
        boolean z;
        int i;
        String str2 = str;
        O000000o("BleComboBleWayStep onSearchComboAddress, mac = " + fte.O000000o(str), new Object[0]);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("mac", fte.O000000o(str));
        if (!TextUtils.isEmpty(str)) {
            this.O0000OoO = str2;
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
                O000000o("BleComboBleWayStep authMode = ".concat(String.valueOf(i)), new Object[0]);
                O000000o("BleComboBleWayStep frameControl version = " + bleDevice.O00000Oo().f6871O000000o.O0000Oo0, new Object[0]);
            }
            if ((i == 0 || i == 2) && z) {
                this.O0000OoO = str2;
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(204);
                SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O00000o), "BleComboBleWayStep", this.O00000o0);
                if (O0000oO()) {
                    this.O0000Oo.O000000o(false, this.O00000o, this.O00000oo, this.O0000O0o, this.O0000oo0.type, this.O0000Oo0);
                    return;
                }
                this.O0000Oo.O000000o(i == 0, this.O00000o, this.O00000oo, this.O0000O0o, this.O0000oo0.type, "");
                return;
            }
            O000000o("BleComboBleWayStep don't support authMode = ".concat(String.valueOf(i)), new Object[0]);
            this.O000o00 = true;
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
        O000000o("BleComboBleWayStep onSendSSIDAndPassWd code = " + i + ", firmwareVersion = " + str + ", deviceDid = " + str2, new Object[0]);
        this.O000Oo00 = str;
        this.O000Oooo = str2;
        htr.O000000o().O00000Oo("bind_device_did", this.O000Oooo);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
        if (i != 0) {
            if (i == -37) {
                this.O000o00 = true;
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
        } else if (this.f818O000000o && !this.O000OO00) {
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().registerReceiver(this.O000o00o, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
            x_().removeMessages(125);
            this.O0000Oo.O000000o();
            this.O000o00O = false;
            e_(this.O00000Oo);
            O00000o0(1);
            x_().sendEmptyMessageDelayed(127, 50000);
        }
    }

    private void O0000o() {
        O000000o("BleComboBleWayStep onScDeviceBindToPassport isScComboWithLogin = " + O0000oO(), new Object[0]);
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
        if (O0000oO()) {
            this.O00000Oo = 2;
            O0000oO0();
            return;
        }
        this.O00000Oo = 3;
        O000OO00();
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
    private void O0000oO0() {
        Boolean isMiAccountSystem = SmartConfigRouterFactory.getSmartConfigManager().isMiAccountSystem(this.O000O0oo);
        if (isMiAccountSystem != null) {
            if (isMiAccountSystem.booleanValue()) {
                O000000o("BleComboBleWayStep startPassportAuth Use System Account", new Object[0]);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName("com.xiaomi.account", "com.xiaomi.account.ui.AccountWebActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(this.O0000OOo));
                if (this.O000Ooo0) {
                    intent.putExtra("style", "dialog");
                    intent.putExtra("show_title", true);
                    intent.putExtra("height_ratio", 0.7d);
                    dcp.O000000o().O000000o(true);
                }
                List<ResolveInfo> queryIntentActivities = this.O000O0oo.getPackageManager().queryIntentActivities(intent, 1);
                if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                    O000000o("BleComboBleWayStep startPassportAuth No Acctivity Found!", new Object[0]);
                    this.O000OoOo = "3000.2.5";
                    O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                    return;
                }
                ((Activity) this.O000O0oo).startActivityForResult(intent, 101);
                return;
            }
            O000000o("BleComboBleWayStep startPassportAuth Use Local Account", new Object[0]);
            fbt fbt = new fbt(this.O000O0oo, "ScDeviceLocalAccountWebAuthActivity");
            if (this.O000Ooo0) {
                fbt.O000000o("height_ratio");
            }
            fbt.O000000o("login_url", this.O0000OOo).O000000o(100);
            fbs.O000000o(fbt);
        }
    }

    private boolean O0000oO() {
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O00000o0);
        return pluginInfo != null && pluginInfo.O00000o() == 20;
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
        this.O0000Ooo = i;
        O000000o("BleComboBleWayStep onNotifyStatus " + O00000Oo(i), new Object[0]);
        if (this.f818O000000o && x_().hasMessages(127)) {
            switch (i) {
                case 0:
                case 1:
                    hvo O000000o2 = hvg.O000000o(CommonApplication.getAppContext());
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    O000000o2.O000000o("w1", sb.toString());
                    return;
                case 2:
                    hvo O000000o3 = hvg.O000000o(CommonApplication.getAppContext());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    O000000o3.O000000o("w2", sb2.toString());
                    if (O0000oO() && this.O00000Oo == 1) {
                        e_(1);
                        this.O00000Oo = 2;
                        O0000oO0();
                        return;
                    }
                    return;
                case 3:
                    hvo O000000o4 = hvg.O000000o(CommonApplication.getAppContext());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(System.currentTimeMillis());
                    O000000o4.O000000o("w3", sb3.toString());
                    try {
                        SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o00o);
                    } catch (Exception unused) {
                    }
                    if (this.O00000Oo == 2) {
                        e_(2);
                    }
                    this.O0000Oo.O00000o();
                    this.O0000o0 = true;
                    x_().removeMessages(127);
                    O0000o0O();
                    return;
                case 4:
                case 5:
                    try {
                        SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o00o);
                    } catch (Exception unused2) {
                    }
                    x_().removeMessages(127);
                    if (DeviceFactory.O00000o0(this.O00000o0)) {
                        O000000o(SmartConfigStep.Step.STEP_BLE_PWD_ERROR);
                        return;
                    } else {
                        O00000Oo(SmartConfigStep.Step.STEP_BLE_PWD_ERROR);
                        return;
                    }
                case 6:
                    if (this.O00000Oo == 2) {
                        e_(2);
                        this.O00000Oo = 3;
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
                        O000OO00();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        try {
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o00o);
        } catch (Exception unused) {
        }
        SmartConfigRouterFactory.getStatResultManager().combo_kuailian_result(this.O00000o0, this.O000Oooo, true, !this.O0000o0, this.O0000o0o);
        this.O000o000.removeCallbacksAndMessages(null);
        fpo.O00000Oo();
        boolean booleanValue = ((Boolean) htr.O000000o().O000000o("restore_wifi", Boolean.FALSE)).booleanValue();
        O000000o("BleComboBleWayStep" + String.format("wifi restore ? -> %b", Boolean.valueOf(booleanValue)), new Object[0]);
        Cfor forR = this.O0000Oo;
        if (forR == null) {
            return;
        }
        if (booleanValue) {
            forR.O000000o(new fou() {
                /* class _m_j.hwd.AnonymousClass7 */

                public final void O000000o() {
                    hwd.this.O0000Oo.O00000o();
                }
            });
        } else {
            forR.O00000o();
        }
    }

    private void O000O0oo() {
        O000000o("BleComboBleWayStep onStopConnection", new Object[0]);
        x_().removeMessages(112);
        x_().removeMessages(114);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000ooo.bindProcessToNetwork(null);
        }
    }

    private void O000OO00() {
        String O00000Oo2 = O00000Oo(this.O00000oO);
        O000000o("BleComboBleWayStep scanNewDevice bssid = " + O00000Oo2 + ", mDeviceDid = " + this.O000Oooo + ", mBindKey = " + this.O00000o, new Object[0]);
        hto hto = this.O000o0O;
        if (hto == null) {
            this.O000o0O = new hto(O00000Oo2, this.O000Oooo, this.O00000o, this.O00000o0);
        } else {
            hto.O000000o(O00000Oo2, this.O000Oooo, this.O00000o, this.O00000o0);
        }
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
        htk.O000000o().O000000o(this.O000o0O, this.O000o0O0, this.O000o0);
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O00000o0, BindStep.STEP_CHECK_BIND);
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwd.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WifiManager wifiManager = (WifiManager) hwd.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                    if (wifiManager != null) {
                        wifiManager.getConnectionInfo();
                    }
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    if (hwd.this.O00000Oo == 3 && ((hwd.this.O0000Ooo == 0 && !hwd.this.O0000o00) || !(hwd.this.O0000Ooo == 0 || hwd.this.O0000Ooo == 3))) {
                        hwd.this.O000OOo = false;
                    }
                    if (!hwd.this.O000OOoO && hwd.this.O000OOo && !hwd.this.O000OOoo) {
                        hwd hwd = hwd.this;
                        hwd.O000OOoO = true;
                        int O0000O0o = hwd.O0000O0o(gon.O000000o(hwd.O00000Oo));
                        if (!hwd.this.O000Oo0o) {
                            hxy hxy = new hxy(0L, hwd.this.O00000o0, O0000O0o, hwd.this.O000Oo00, true);
                            hxy.O0000OoO = hwd.this.O00000o;
                            SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                        } else if (hwd.this.O000Oo0O.isEmpty()) {
                            hwd.this.O000Oo0O.push(new hxy(0L, hwd.this.O00000o0, O0000O0o, hwd.this.O000Oo00, true));
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwd.this.O00000o0, 4);
                    }
                    hwd hwd2 = hwd.this;
                    hwd2.O0000o0o = true;
                    hwd2.b_(false);
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
            O000000o("BleComboBleWayStep onActivityResult login_result = ".concat(String.valueOf(booleanExtra)), new Object[0]);
            if (booleanExtra) {
                if (this.O00000Oo == 2) {
                    e_(2);
                }
                this.O00000Oo = 3;
            } else {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                return;
            }
        } else if (i == 101) {
            O000000o("BleComboBleWayStep onActivityResult REQUEST_CODE_SYSTEM_ACCOUNT", new Object[0]);
            if (this.O000Ooo0) {
                dcp.O000000o().O000000o(false);
            }
            if (!this.O000o00O) {
                return;
            }
            if (this.O00000Oo == 2) {
                this.O00000Oo = 2;
            }
        } else {
            return;
        }
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O00000o0, BindStep.STEP_TRANSFER_CONFIG);
        O000OO00();
    }

    public final ArrayList<gke> O0000Oo0() {
        fte.O00000Oo("BleComboBleWayStep.getAllConfigStages");
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 90000;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 60000;
        arrayList.add(gke2);
        if (O0000oO()) {
            gke gke3 = new gke();
            gke3.f17943O000000o = 2;
            gke3.O00000Oo = 20000;
            arrayList.add(gke3);
        }
        this.O000o0O0 = (long) (eyr.O00000Oo().O0000Oo0(this.O00000o0) + 60000);
        gke gke4 = new gke();
        gke4.f17943O000000o = 3;
        gke4.O00000Oo = this.O000o0O0;
        arrayList.add(gke4);
        return arrayList;
    }
}

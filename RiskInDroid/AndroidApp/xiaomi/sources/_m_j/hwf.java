package _m_j;

import _m_j.hwf;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hwf extends ConfigStep implements fot {
    private static final String[] O0000o0O = {"hannto.printer.honey", "hannto.printer.honey1s"};

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f831O000000o = true;
    public int O00000Oo;
    public String O00000o;
    public long O00000o0;
    public int O00000oO = 0;
    public String O00000oo;
    public fov O0000O0o;
    public String O0000OOo;
    public long[] O0000Oo = new long[4];
    public int O0000Oo0;
    public boolean O0000OoO = false;
    public boolean O0000Ooo = false;
    private Handler O0000o;
    public boolean O0000o0 = false;
    public boolean O0000o00 = false;
    private int O0000o0o = 60000;
    private MiioLocalAPI.O000000o O000OooO;
    private int O000Oooo;
    private BroadcastReceiver O000o0 = new BroadcastReceiver() {
        /* class _m_j.hwf.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 5);
                if (TextUtils.equals(stringExtra, hwf.this.O0000OOo)) {
                    hwf.this.O000000o("  bluetooth connect status = ".concat(String.valueOf(intExtra)), new Object[0]);
                }
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action) && TextUtils.equals(stringExtra, hwf.this.O0000OOo) && intExtra == 32) {
                    hwf hwf = hwf.this;
                    hwf.O000000o("  disconnect mac = " + fte.O000000o(hwf.this.O0000OOo), new Object[0]);
                    hwf hwf2 = hwf.this;
                    hwf2.f831O000000o = false;
                    hwf2.O0000Ooo = true;
                    hwf2.x_().removeMessages(127);
                    hwf hwf3 = hwf.this;
                    hwf3.O0000o00 = true;
                    hwf3.O00000Oo(0L);
                    fob.O000000o(hwf.this.O000OOOo, hwf.this.O0000OOo);
                    iae.O000000o(hwf.this.O000Oo0);
                }
            }
        }
    };
    private long O000o00 = -1;
    private boolean O000o000 = true;
    private long[] O000o00O = new long[4];
    private boolean O000o00o = false;
    private boolean O000o0O = false;
    private htl O000o0O0 = new htm() {
        /* class _m_j.hwf.AnonymousClass5 */

        public final void onDeviceConnectionFailure(int i) {
            hwf.this.O000000o("onDeviceConnectionFailure code %d", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwf.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (i == -6) {
                hwf.this.O00000Oo(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
            }
            iae.O000000o(hwf.this.O000Oo0);
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hwf.this.O000000o("  DeviceFinderCallback.onDeviceConnectionSuccess", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwf.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hwf hwf = hwf.this;
            hwf.O00000Oo = 2;
            hwf.O000OOo = false;
            hwf.O000OoO0 = true;
            hwf.e_(2);
            iae.O000000o(hwf.this.O000Oo0);
        }

        public final void onDeviceConnectionFailure() {
            hwf.this.O000000o("  DeviceFinderCallback.onDeviceConnectionFailure", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwf.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            iae.O000000o(hwf.this.O000Oo0);
        }
    };
    private hto O000o0OO = null;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    hwf() {
        this.O000Ooo = "COMBO:BleComboStep";
    }

    public final void O000000o(Context context) {
        O000000o("createStep", new Object[0]);
        this.O0000o = new Handler(Looper.getMainLooper());
        htr.O000000o().O00000Oo("combo_strategy", 4);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
        if (!gnl.O00000Oo()) {
            this.O000OOo = false;
        }
    }

    public final void O00000Oo(long j) {
        if (x_() != null) {
            x_().sendEmptyMessageDelayed(112, j);
        }
    }

    public final ArrayList<gke> O0000Oo0() {
        O000000o(" .getAllConfigStages", new Object[0]);
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 90000;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 60000;
        arrayList.add(gke2);
        this.O0000o0o = eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 60000;
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = (long) this.O0000o0o;
        arrayList.add(gke3);
        return arrayList;
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 101) {
            O000000o(" .handleMessage NETWORK_STATE_CHANGED", new Object[0]);
            if (this.O0000oo && !this.f831O000000o) {
                NetworkInfo networkInfo = (NetworkInfo) message.obj;
                NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
                WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
                this.O000Oo0 = y_();
                if (this.O00000Oo == 1 && networkInfo.getState() == NetworkInfo.State.DISCONNECTED && !this.O000OO0o) {
                    if (connectionInfo == null || this.O000Oo0 == null || !iag.O000000o(connectionInfo.getSSID(), this.O000Oo0.SSID)) {
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("wifi_disconnect_by_device", "true");
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        x_().sendEmptyMessage(112);
                        return;
                    }
                    O000000o("wifi ssid not equal scanResult ssid", new Object[0]);
                }
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()) || connectionInfo.getSSID().contains("<unknown ssid>")) {
                    O000000o("handle message network changed.error unknown wifiInfo:", new Object[0]);
                    return;
                }
                if (this.O000Oooo > 0) {
                    hvg.O000000o(CommonApplication.getAppContext()).O000000o(this.O000Oooo, "ssid", connectionInfo.getSSID());
                }
                if (detailedState != NetworkInfo.DetailedState.CONNECTED || !networkInfo.isConnected()) {
                    O000000o("error otherstate state:".concat(String.valueOf(detailedState)), new Object[0]);
                } else if (this.O000Oo0 == null || !iag.O000000o(connectionInfo.getSSID(), this.O000Oo0.SSID) || this.O00000Oo != 0 || this.O000OO0o) {
                    O000000o(" wifi state connected,but wifi ssid not equal scanResult ssid", new Object[0]);
                } else if (x_() != null) {
                    x_().postDelayed(new Runnable() {
                        /* class _m_j.hwf.AnonymousClass12 */

                        public final void run() {
                            if (hwf.this.O00000Oo == 0 && hwf.this.O000O00o()) {
                                hwf hwf = hwf.this;
                                hwf.e_(hwf.O00000Oo);
                                hwf.this.x_().removeMessages(123);
                                hwf.this.O0000oO0();
                                hwf hwf2 = hwf.this;
                                hwf2.O00000Oo = 1;
                                hwf2.O00000oO++;
                            }
                        }
                    }, 2000);
                }
            }
        } else if (i == 112) {
            O000000o(" .handleMessage MSG_UPDATE_DEVICE_STATE", new Object[0]);
            if (x_() != null) {
                x_().removeMessages(112);
                x_().removeMessages(114);
            }
            this.f831O000000o = false;
            if (this.O00000Oo == 1) {
                O000O0oo();
                e_(1);
                this.O00000Oo = 2;
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                O000OO00();
            }
        } else if (i == 123) {
            O000000o(" .handleMessage MSG_RECONNECT_DEVICE_AP", new Object[0]);
            O0000o();
            this.f831O000000o = false;
        } else if (i == 125) {
            O000000o(" .handleMessage MSG_CONNECT_BLE_TIME_OUT", new Object[0]);
            this.f831O000000o = false;
            this.O000OoOo = "3000.2.2";
            gsy.O000000o(4, "stopScan", "BComboS stop");
            SmartConfigRouterFactory.getCoreApiManager().stopSearchBluetoothDevice();
            try {
                SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o0);
            } catch (Exception unused) {
            }
            this.O0000O0o.O00000o();
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(62000);
            if (this.O000o00o) {
                O00000Oo(SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR);
            } else if (O0000oO()) {
                if (!this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o(2501), 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000OOo, this.O000Oo00, this.O0000oO0);
                    }
                }
                if (this.O000Oo0o && this.O000Oo0O.isEmpty()) {
                    this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(2501), this.O000Oo00, this.O000OOo));
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
                O00000Oo(SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR);
            } else {
                O0000o();
            }
        } else if (i == 127) {
            O000000o(" .handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O0000Oo0, new Object[0]);
            x_().removeMessages(127);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2401);
            this.f831O000000o = false;
            try {
                SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o0);
            } catch (Exception unused2) {
            }
            this.O0000O0o.O00000o();
            this.O0000o00 = true;
            O00000Oo(0L);
        } else if (i == 114) {
            O000000o(" .handleMessage MSG_SEND_DEVICE_MSG", new Object[0]);
            if (this.O00000Oo == 1) {
                O0000oO0();
            }
        } else if (i != 115) {
            super.O000000o(message);
        } else {
            O000000o(" .handleMessage MSG_DISCONNECT_TIME_OUT", new Object[0]);
            O000O0oo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(long[], long):void}
     arg types: [long[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(long[], long):void} */
    public final void z_() {
        O000000o("  resetCurrentStageIndex", new Object[0]);
        this.O00000Oo = 0;
        this.f831O000000o = true;
        this.O000o00 = System.currentTimeMillis();
        Arrays.fill(this.O0000Oo, 0L);
        this.O0000Oo[this.O00000Oo] = System.currentTimeMillis();
    }

    public final int O00000Oo() {
        int i = this.O00000Oo;
        if (i != 0) {
            if (i == 1) {
                O000000o(" .getCurrentStageIndex mCurrentIndex = SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
                if (!this.f831O000000o) {
                    String str = this.O000Oo0.SSID;
                    WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
                    if (connectionInfo == null || !iag.O000000o(str, connectionInfo.getSSID())) {
                        this.O00000Oo = 0;
                        return 0;
                    } else if (((Boolean) htr.O000000o().O000000o("send_passwd_success", Boolean.FALSE)).booleanValue()) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }
            return this.O00000Oo;
        }
        O000000o(" .getCurrentStageIndex mCurrentIndex = CONNECT_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
        if (this.f831O000000o) {
        }
        return 0;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        int i2 = i;
        this.O000OOoo = true;
        if (i2 != 0) {
            if (i2 == 1) {
                O000000o(" .onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
                this.O000OoOo = "3000.2.3";
                hvc statBindManager = SmartConfigRouterFactory.getStatBindManager();
                String str = this.O000OOOo;
                BindStep bindStep = BindStep.STEP_TRANSFER_CONFIG;
                statBindManager.endBindStep(str, bindStep, "transfer info failed, mUseBleConfig = " + this.f831O000000o);
                if (!this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o(2401), this.f831O000000o ? 1 : 0, "", "", this.O000Oo00, this.O0000oO0);
                    }
                }
                if (this.O000Oo0o) {
                    this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(2401), this.O000Oo00, this.O000OOo));
                }
                if (TextUtils.isEmpty(this.O0000oO0)) {
                    return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
                }
                if (this.f831O000000o) {
                    int i3 = this.O0000Oo0;
                    if (i3 == 0) {
                        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                    }
                    if (i3 == 1) {
                        O000000o(" >>> current notifyStatus == NOTIFY_CONNECTING_ROUTER", new Object[0]);
                        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                    } else if (i3 == 2) {
                        O000000o(" >>> current notifyStatus == NOTIFY_CONNECTING_ROUTER", new Object[0]);
                        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                    } else if (i3 == 5) {
                        O000000o(" >>> current notifyStatus == NOTIFY_AUTHENTICATION_ERROR", new Object[0]);
                        this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
                        Resources resources = this.O000O0o0.getResources();
                        ddg ddg = this.O000O0o0;
                        StringBuilder sb = new StringBuilder();
                        sb.append(resources.getString(R.string.ble_combo_device_connect_network_step_loading));
                        sb.append(resources.getString(this.O000o000 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
                        ddg.O000000o(sb.toString(), resources.getString(R.string.ble_combo_network_title_loading));
                        return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
                    } else if (i3 == 4) {
                        O000000o(" >>> current notifyStatus == NOTIFY_UNKNONW_ERROR", new Object[0]);
                        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                    } else if (i3 == 3) {
                        return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                    } else {
                        O000000o(" >>> Unknown notifyStatus = %d", Integer.valueOf(i3));
                    }
                } else if (this.O00000oO == 1) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                } else {
                    PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
                    if (pluginInfo != null && pluginInfo.O0000ooO() != 0) {
                        return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR;
                    }
                    iae.O000000o(this.O000Oo0);
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                }
            } else if (i2 == 2) {
                O000000o(" .onStageTimeOut GET_NEW_DEVICE_INDEX，mUseBleConfig = " + this.f831O000000o, new Object[0]);
                this.O000OoOo = "3000.2.3";
                hvc statBindManager2 = SmartConfigRouterFactory.getStatBindManager();
                String str2 = this.O000OOOo;
                BindStep bindStep2 = BindStep.STEP_CHECK_BIND;
                statBindManager2.endBindStep(str2, bindStep2, "get new device failed, mUseBleConfig = " + this.f831O000000o);
                O00oOooO();
                int O0000O0o2 = O0000O0o(gon.O000000o(this.O0000OoO, this.O0000Ooo, this.O0000Oo0));
                if (!hze.O000000o(this.O000O0oo) || (!this.f831O000000o && !O00oOooo())) {
                    this.O000OOo = false;
                }
                if (!this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    int i4 = this.O0000Oo0 == 3 ? 2 : this.O0000OoO;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o2, i4, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000OOo, this.O000Oo00, this.O0000oO0);
                    }
                }
                if (this.O000Oo0o) {
                    this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o2, this.O000Oo00, this.O000OOo));
                }
                if (!this.f831O000000o) {
                    if (this.O000o0OO == null) {
                        htk.O000000o().O00000Oo();
                    } else {
                        htk.O000000o().O000000o(this.O000o0OO);
                    }
                    PluginDeviceInfo pluginInfo2 = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
                    if (pluginInfo2 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(pluginInfo2.O0000ooO());
                        gsy.O000000o(6, "AoConfigStep", sb2.toString());
                    }
                    if (pluginInfo2 != null && pluginInfo2.O0000ooO() != 0) {
                        return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR;
                    }
                    iae.O000000o(this.O000Oo0);
                    return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
                }
            }
            return null;
        }
        O000000o(" .onStageTimeOut CONNECT_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
        this.O000OoOo = "3000.2.2";
        hvc statBindManager3 = SmartConfigRouterFactory.getStatBindManager();
        String str3 = this.O000OOOo;
        BindStep bindStep3 = BindStep.STEP_TRANSFER_CONFIG;
        statBindManager3.endBindStep(str3, bindStep3, "connect failed, mUseBleConfig = " + this.f831O000000o);
        int i5 = 2101;
        eyr.O00000Oo();
        if (TextUtils.isEmpty(this.O0000oO0)) {
            i5 = 2102;
        }
        if (!this.O000OOoO && this.O000OOo) {
            this.O000OOoO = true;
            if (!this.O000Oo0o) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o(i5), this.f831O000000o ? 1 : 0, "", "", this.O000Oo00, this.O0000oO0);
            }
        }
        if (this.O000Oo0o) {
            this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(i5), this.O000Oo00, this.O000OOo));
        }
        if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
            this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
            this.O00oOooO.O00000o0 = null;
            this.O00oOooO = null;
        }
        if (TextUtils.isEmpty(this.O0000oO0)) {
            this.O000OoOo = "3000.2.1";
            if (this.f831O000000o) {
                x_().removeMessages(125);
            } else {
                x_().removeMessages(123);
                iae.O000000o(this.O000Oo0);
            }
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (this.f831O000000o) {
            return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
        } else {
            x_().removeMessages(123);
            iae.O000000o(this.O000Oo0);
            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
            return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        int i = this.O00000Oo;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_connect_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o((int) R.string.ble_combo_transfer_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            Resources resources = this.O000O0o0.getResources();
            ddg ddg = this.O000O0o0;
            StringBuilder sb = new StringBuilder();
            sb.append(resources.getString(R.string.ble_combo_device_connect_network_step_loading));
            sb.append(resources.getString(this.O000o000 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
            ddg.O000000o(sb.toString(), resources.getString(R.string.ble_combo_network_title_loading));
            this.O000O0o0.O000000o(3);
        } else if (i == 2) {
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
            Resources resources = this.O000O0o0.getResources();
            ddg ddg = this.O000O0o0;
            BaseBindView.StepStatus stepStatus = BaseBindView.StepStatus.LOADING;
            StringBuilder sb = new StringBuilder();
            sb.append(resources.getString(R.string.ble_combo_device_connect_network_step_loading));
            sb.append(resources.getString(this.O000o000 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
            ddg.O000000o(stepStatus, sb.toString(), R.string.ble_combo_network_title_loading, false);
            this.O000O0o0.O000000o(3);
        }
    }

    /* renamed from: O00000o0 */
    public final void O00000oO(int i) {
        if (y_() == null) {
            Handler x_ = x_();
            O000000o("COMBO:BleComboStep", "startConnection mScanResult is null", new Object[0]);
            if (x_ != null && this.O000O0o) {
                x_.postDelayed(new Runnable(i) {
                    /* class _m_j.$$Lambda$hwf$vhLIMxZsx2Aj3lzCjVRLWow2e_g */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hwf.this.O00000oO(this.f$1);
                    }
                }, 2000);
            }
        } else if (i == 0) {
            O000000o(" .startConnection CONNECT_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.O000o00 <= 0) {
                this.O000o00 = currentTimeMillis;
            }
            long[] jArr = this.O0000Oo;
            if (jArr[i] == 0) {
                jArr[i] = currentTimeMillis;
            }
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
            O000000o("start getBindkey", new Object[0]);
            if (TextUtils.isEmpty(this.O0000oO0)) {
                final AnonymousClass6 r10 = new hua<String, hud>() {
                    /* class _m_j.hwf.AnonymousClass6 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        hwf.this.O000000o("COMBO:BleComboStep", "getBindKey  onSuccess", new Object[0]);
                        hwf hwf = hwf.this;
                        hwf.O0000oO0 = (String) obj;
                        if (hwf.O0000oO0 == null) {
                            hwf.this.O0000oO0 = "";
                        }
                        if (hwf.this.f831O000000o) {
                            hwf.this.O0000o0o();
                        } else {
                            hwf.this.O0000o();
                        }
                    }

                    public final void O000000o(hud hud) {
                        hwf.this.O000000o("COMBO:BleComboStep getBindKey failed", new Object[0]);
                        hwf hwf = hwf.this;
                        hwf.O0000oO0 = "";
                        if (hwf.f831O000000o) {
                            hwf.this.O0000o0o();
                        } else {
                            hwf.this.O0000o();
                        }
                    }
                };
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
                htq.O000000o().O00000o0(this.O000OOOo, SmartConfigRouterFactory.getCoreApiManager().getMiId(), new hua<JSONObject, hud>() {
                    /* class _m_j.hwf.AnonymousClass7 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        hwf.this.O000000o(" getBindKeyX onSuccess %s", jSONObject);
                        if (jSONObject == null || jSONObject.length() == 0) {
                            O000000o((hud) null);
                            return;
                        }
                        hwf.this.O0000oO = jSONObject.optLong("timestamp");
                        String optString = jSONObject.optString("bindKey");
                        String optString2 = jSONObject.optString("bindKeyIndex");
                        hwf hwf = hwf.this;
                        if ("0".equals(optString2)) {
                            optString2 = null;
                        }
                        hwf.O0000oOO = optString2;
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey_new", optString);
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        r10.O000000o(optString);
                    }

                    public final void O000000o(hud hud) {
                        hwf.this.O000000o(" getBindKeyX onFailure onSuccess %s", hud);
                        if (hwf.this.O000O0o && hwf.this.O00000Oo == 0) {
                            hwf.this.O000000o(new hua<String, hud>() {
                                /* class _m_j.hwf.AnonymousClass7.AnonymousClass1 */

                                public final /* synthetic */ void O000000o(Object obj) {
                                    String str = (String) obj;
                                    hwf.this.O0000oO = 0;
                                    hwf.this.O0000oOO = null;
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey", str);
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                                    r10.O000000o(str);
                                }

                                public final void O000000o(hud hud) {
                                    if (hud != null) {
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", hud.O000000o());
                                    }
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2801);
                                    r10.O000000o(hud);
                                }
                            }, 2);
                        }
                    }
                });
            } else if (this.f831O000000o) {
                O0000o0o();
            } else {
                O0000o();
            }
        } else if (i == 1) {
            O000000o(" .startConnection SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.f831O000000o, new Object[0]);
            if (this.f831O000000o) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(213);
                O000000o(" >>> current mNotifyStatus = " + O00000Oo(this.O0000Oo0), new Object[0]);
                int i2 = this.O0000Oo0;
                if (i2 == 0) {
                    this.O00000Oo = 1;
                } else if (i2 == 4) {
                    O000000o(" .retryComboConnect", new Object[0]);
                    this.O0000Oo0 = 0;
                    this.f831O000000o = true;
                    this.O0000O0o.O00000o0();
                    x_().removeMessages(125);
                    x_().removeMessages(127);
                    this.O0000O0o.O000000o();
                    x_().sendEmptyMessageDelayed(127, 50000);
                } else if (i2 == 3) {
                    this.f831O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Oo0);
                } else if (gnl.O00000o0(this.O0000OOo)) {
                    this.f831O000000o = true;
                    x_().sendEmptyMessageDelayed(127, 50000);
                    d_(this.O0000Oo0);
                } else {
                    this.f831O000000o = false;
                    x_().removeMessages(127);
                    O00000Oo(0L);
                }
            } else {
                O0000oO0();
                this.O00000oO++;
            }
        } else if (i == 2) {
            O000000o(" .startConnection GET_NEW_DEVICE_INDEX", new Object[0]);
            O000000o(" >>> current mNotifyStatus = " + O00000Oo(this.O0000Oo0), new Object[0]);
            O000O0oo();
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
            O000OO00();
        }
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hwf.AnonymousClass8 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                hwf.this.O000000o("getBindKey onSuccess,key =".concat(String.valueOf(str)), new Object[0]);
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                hwf.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                int i = i;
                if (i == 0) {
                    Object O000000o2 = htr.O000000o().O000000o("wifi_bind_key");
                    if (O000000o2 != null) {
                        String str = (String) O000000o2;
                        if (!TextUtils.isEmpty(str)) {
                            hwf.this.O000000o("getBindKey from local", new Object[0]);
                            hua.O000000o(str);
                            return;
                        }
                    }
                    hwf.this.O0000oOO();
                    return;
                }
                hwf.this.O000000o(hua, i - 1);
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

    public final void O0000o0o() {
        O000000o(" .startConnectToBle", new Object[0]);
        this.O000o000 = true;
        this.O00000Oo = 0;
        if (TextUtils.isEmpty(this.O0000oO0)) {
            O0000oOO();
            return;
        }
        this.O000o00O[this.O00000Oo] = System.currentTimeMillis();
        long[] jArr = this.O0000Oo;
        int i = this.O00000Oo;
        if (jArr[i] == 0) {
            jArr[i] = System.currentTimeMillis();
        }
        if (this.O0000O0o == null) {
            this.O0000O0o = new fos(this);
        }
        if (this.O000Oo0 != null) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(202);
            this.O0000O0o.O000000o(this.O000Oo0);
        } else {
            b_(true);
        }
        x_().sendEmptyMessageDelayed(125, 62000);
    }

    public final void O000000o(String str) {
        int i;
        boolean z;
        O000000o(" .onSearchComboAddress,if mac empty,will try ap connect", new Object[0]);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("mac", fte.O000000o(str));
        if (!TextUtils.isEmpty(str)) {
            htr.O000000o().O00000Oo("key_report_hash_mac", str);
            BleDevice O00000o02 = fob.O00000o0(str);
            if (O00000o02 == null || O00000o02.O00000Oo() == null || O00000o02.O00000Oo().f6871O000000o == null) {
                z = true;
                i = 0;
            } else {
                i = O00000o02.O00000Oo().f6871O000000o.O0000OOo;
                z = fea.O000000o(O00000o02.O00000Oo().f6871O000000o.O0000Oo0);
            }
            if ((i == 0 || i == 2) && z) {
                this.O0000OOo = str;
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(204);
                boolean z2 = i == 0;
                SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "BleComboStep", this.O000OOOo);
                this.O0000O0o.O000000o(z2, this.O0000oO0, this.O0000oO, this.O0000oOO, this.O0000oo0.type, "");
                return;
            }
            O000000o("don't support authMode = ".concat(String.valueOf(i)), new Object[0]);
            this.O000o00o = true;
            if (x_().hasMessages(125)) {
                x_().removeMessages(125);
                x_().sendEmptyMessage(125);
                return;
            }
            return;
        }
        if (O0000oO() && !this.O000OOoO && this.O000OOo) {
            this.O000OOoO = true;
            if (!this.O000Oo0o) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o(2701), 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000OOo, this.O000Oo00, this.O0000oO0);
            } else {
                this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(2701), this.O000Oo00, this.O000OOo));
            }
        }
        if (x_().hasMessages(125)) {
            x_().removeMessages(125);
            x_().sendEmptyMessage(125);
        }
    }

    public final void O000000o(int i, String str, String str2) {
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        O000000o("BleComboStep.onSendSSIDAndPassWd code = " + i2 + ", firmwareVersion = " + str3 + ", deviceDid = " + str4, new Object[0]);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
        this.O000Oo00 = str3;
        this.O00000oo = str4;
        htr.O000000o().O00000Oo("bind_device_did", this.O00000oo);
        if (i2 != 0) {
            if (i2 == -37) {
                this.O000o00o = true;
            }
            if (x_().hasMessages(125)) {
                x_().removeMessages(125);
                int O0000O0o2 = O0000O0o(29000 - i2);
                if (O0000oO() && !this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.O00000o0, this.O000OOOo, O0000O0o2, 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000OOo, this.O000Oo00, this.O0000oO0);
                    }
                }
                if (O0000oO() && this.O000Oo0o) {
                    this.O000Oo0O.push(new hxy(0L, this.O000OOOo, O0000O0o2, this.O000Oo00, this.O000OOo));
                }
                if (i2 == -6) {
                    SmartConfigRouterFactory.getSmartConfigManager().bleDisconnect(this.O0000OOo);
                    x_().sendEmptyMessageDelayed(125, 2000);
                    return;
                }
                x_().sendEmptyMessage(125);
            }
        } else if (this.f831O000000o && !this.O000OO00) {
            this.O0000OoO = true;
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().registerReceiver(this.O000o0, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
            x_().removeMessages(125);
            this.O0000O0o.O000000o();
            e_(this.O00000Oo);
            this.O000o00O[1] = System.currentTimeMillis();
            O00000oO(1);
            long[] jArr = this.O0000Oo;
            if (jArr[1] == 0) {
                jArr[1] = System.currentTimeMillis();
            }
            x_().sendEmptyMessageDelayed(127, 50000);
        }
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
        this.O0000Oo0 = i;
        O000000o("  onNotifyStatus " + O00000Oo(i), new Object[0]);
        if (this.f831O000000o && x_().hasMessages(127)) {
            if (i == 0 || i == 1) {
                hvo O000000o2 = hvg.O000000o(CommonApplication.getAppContext());
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                O000000o2.O000000o("w1", sb.toString());
            } else if (i == 2) {
                hvo O000000o3 = hvg.O000000o(CommonApplication.getAppContext());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                O000000o3.O000000o("w2", sb2.toString());
            } else if (i == 3) {
                hvo O000000o4 = hvg.O000000o(CommonApplication.getAppContext());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(System.currentTimeMillis());
                O000000o4.O000000o("w3", sb3.toString());
                try {
                    SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o0);
                } catch (Exception unused) {
                }
                this.O0000O0o.O00000o();
                this.O0000o00 = true;
                x_().removeMessages(127);
                O00000Oo(0L);
            } else if (i == 4 || i == 5) {
                try {
                    SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o0);
                } catch (Exception unused2) {
                }
                x_().removeMessages(127);
                O0000oOO();
            }
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        O000000o("onFinishStep", new Object[0]);
        MiioLocalAPI.O000000o o000000o = this.O000OooO;
        if (o000000o != null) {
            o000000o.f6027O000000o = true;
        }
        if (this.O000o0O) {
            hvf statResultManager = SmartConfigRouterFactory.getStatResultManager();
            String str = this.O000OOOo;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O00000o0);
            statResultManager.combo_kuailian_result(str, sb.toString(), false, true, this.O0000o0);
            this.O000o0O = false;
        } else {
            SmartConfigRouterFactory.getStatResultManager().combo_kuailian_result(this.O000OOOo, this.O00000oo, true, !this.O0000o00, this.O0000o0);
        }
        try {
            SmartConfigRouterFactory.getSmartConfigManager().getAppContext().unregisterReceiver(this.O000o0);
        } catch (Exception unused) {
        }
        this.O0000o.removeCallbacksAndMessages(null);
        gsy.O000000o(4, "stopScan", "BComboS finish stop");
        fpo.O00000Oo();
        boolean booleanValue = ((Boolean) htr.O000000o().O000000o("restore_wifi", Boolean.FALSE)).booleanValue();
        O000000o(String.format("wifi restore ? -> %b", Boolean.valueOf(booleanValue)), new Object[0]);
        fov fov = this.O0000O0o;
        if (fov == null) {
            return;
        }
        if (booleanValue) {
            fov.O000000o(new fou() {
                /* class _m_j.hwf.AnonymousClass9 */

                public final void O000000o() {
                    hwf.this.O0000O0o.O00000o();
                }
            });
        } else {
            fov.O00000o();
        }
    }

    public final void O0000o() {
        O000000o(" .startConnectToDeviceAp", new Object[0]);
        this.O000o000 = false;
        this.O000o0O = true;
        DeviceFactory.O0000Ooo(this.O000Oo0.SSID);
        this.O00000Oo = 0;
        this.O000o00O[this.O00000Oo] = System.currentTimeMillis();
        String O00000o02 = gog.O00000o0(this.O000O0oo);
        WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(206);
        if (TextUtils.isEmpty(O00000o02) || !O00000o02.equals(this.O000Oo0.SSID) || connectionInfo == null || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
            DeviceFactory.AP_TYPE O00000oO2 = DeviceFactory.O00000oO(this.O000Oo0);
            String str = (O00000oO2 == DeviceFactory.AP_TYPE.AP_MIDEA || O00000oO2 == DeviceFactory.AP_TYPE.AP_MIDEA_AC) ? "12345678" : "";
            if (this.O00oOooO == null || this.O00oOooO.O00000o0 == null) {
                this.O00oOooO = new iad() {
                    /* class _m_j.hwf.AnonymousClass11 */

                    public final void O000000o(Network network) {
                        super.O000000o(network);
                        hwf hwf = hwf.this;
                        hwf.O000000o("connectToAP ok: " + hwf.this.O000Oo0.SSID, new Object[0]);
                    }

                    public final void O000000o() {
                        super.O000000o();
                        hwf.this.O000000o("connectToAP onUnavailable!", new Object[0]);
                        if (hwf.this.O00000Oo == 0) {
                            hwf.this.x_().post(new Runnable() {
                                /* class _m_j.$$Lambda$hwf$11$1EvmyHlWOnGXIk4ElP3QvYbcIE */

                                public final void run() {
                                    hwf.AnonymousClass11.this.O00000o0();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000o0() {
                        hwf.this.O0000oOO();
                    }

                    public final void O00000Oo(Network network) {
                        super.O00000Oo(network);
                        hwf.this.O000000o("connecttoAp onLost ", new Object[0]);
                        if (hwf.this.O00000Oo == 0) {
                            hwf.this.x_().post(new Runnable() {
                                /* class _m_j.$$Lambda$hwf$11$fNlCDLwp2We7Ia1Ex6_FQQ_S0A8 */

                                public final void run() {
                                    hwf.AnonymousClass11.this.O00000Oo();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000Oo() {
                        hwf.this.O0000oOO();
                    }
                };
                iag.O000000o(this.O0000ooo, O0000ooO, this.O000Oo0.SSID, str, this.O000Oo0.BSSID, this.O000Oo0.capabilities, this.O00oOooO, true, false);
                x_().sendEmptyMessageDelayed(123, 15000);
            }
        } else if (x_() != null) {
            x_().post(new Runnable() {
                /* class _m_j.hwf.AnonymousClass10 */

                public final void run() {
                    if (hwf.this.O00000Oo != 1) {
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
                        hwf hwf = hwf.this;
                        hwf.e_(hwf.O00000Oo);
                        hwf.this.O0000oO0();
                        hwf hwf2 = hwf.this;
                        hwf2.O00000Oo = 1;
                        hwf2.O00000oO++;
                    }
                }
            });
        }
    }

    public final void O0000oO0() {
        if (TextUtils.isEmpty(this.O0000oO0)) {
            O0000oOO();
            return;
        }
        O000000o(" .startConnectionAsso", new Object[0]);
        iae.O00000oo.clear();
        this.O00000Oo = 1;
        long[] jArr = this.O0000Oo;
        int i = this.O00000Oo;
        if (jArr[i] == 0) {
            jArr[i] = System.currentTimeMillis();
        }
        this.O000o00O[this.O00000Oo] = System.currentTimeMillis();
        if (gnn.O00000oO) {
            Network network = null;
            Network[] allNetworks = this.O0000ooo.getAllNetworks();
            int i2 = 0;
            while (true) {
                if (i2 < allNetworks.length) {
                    NetworkInfo networkInfo = this.O0000ooo.getNetworkInfo(allNetworks[i2]);
                    if (networkInfo != null && networkInfo.getType() == 1) {
                        network = allNetworks[i2];
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (network == null) {
                gsy.O000000o(6, "ERROR", "Get Network ERROR");
            }
            this.O0000ooo.bindProcessToNetwork(network);
        }
        String O00000Oo2 = htr.O000000o().O00000Oo();
        String O00000o02 = htr.O000000o().O00000o0();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        O000000o("start setMiioRouter  id %d, clazz name %s", Integer.valueOf(currentTimeMillis), "null");
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            O000000o("setMiioRouter,but user not login", new Object[0]);
            b_(true);
        } else {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", currentTimeMillis);
                jSONObject.put("method", "miIO.config_router");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ssid", O00000Oo2);
                if (O00000o02 == null) {
                    O00000o02 = "";
                }
                jSONObject2.put("passwd", O00000o02);
                jSONObject2.put("uid", Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()));
                jSONObject2.put("bind_key", this.O0000oO0);
                if (!TextUtils.isEmpty(this.O0000oOO) && this.O0000oO > 0) {
                    jSONObject2.put("bind_index", this.O0000oOO);
                    jSONObject2.put("bind_ts", this.O0000oO);
                }
                jSONObject2.put("config_type", this.O0000oo0.type);
                String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
                if (!TextUtils.isEmpty(countryDomain)) {
                    jSONObject2.put("country_domain", countryDomain);
                }
                JSONObject jSONObject3 = new JSONObject();
                String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
                if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                    countryCode = "CN";
                }
                jSONObject3.put("cc", countryCode);
                jSONObject2.put("wifi_config", jSONObject3);
                gsy.O00000Oo("COMBO:BleComboStep", "WifiConfigJson : " + jSONObject3.toString());
                jSONObject2.put("gmt_offset", (Integer) htr.O000000o().O000000o("gmt_offset", 28800));
                jSONObject2.put("tz", htr.O000000o().O000000o("gmt_tz", ""));
                jSONObject.put("params", jSONObject2);
            } catch (JSONException e) {
                O000000o("setMiioRouter json error:" + Log.getStackTraceString(e), new Object[0]);
            }
            MiioLocalAPI.O000000o o000000o = this.O000OooO;
            if (o000000o != null) {
                o000000o.f6027O000000o = true;
            }
            O000000o("setMiioRouter, rpc getToken", new Object[0]);
            String O0000o02 = O0000o0();
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(O0000o02));
            SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "BleComboStep", this.O000OOOo);
            this.O000OooO = MiioLocalAPI.O000000o(O0000o02, new dxe() {
                /* class _m_j.hwf.AnonymousClass2 */

                public final void onResponse(final String str) {
                    hwf.this.O000000o("RPC getToken onResponse ", new Object[0]);
                    if (hwf.this.x_() != null) {
                        hwf.this.x_().post(new Runnable() {
                            /* class _m_j.hwf.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                JSONObject O00000o0 = hwf.this.O00000o0(str);
                                if (O00000o0 == null) {
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2302);
                                    if (hwf.this.x_() != null) {
                                        hwf.this.x_().sendEmptyMessageDelayed(114, 1000);
                                        return;
                                    }
                                    return;
                                }
                                hwf.this.O00000o0 = Long.valueOf(O00000o0.optString("did")).longValue();
                                hwf.this.O00000o = O00000o0.optString("token");
                                if (TextUtils.isEmpty(hwf.this.O00000oo)) {
                                    htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(hwf.this.O00000o0));
                                }
                                htk.O000000o().O000000o(String.valueOf(hwf.this.O00000o0), hwf.this.O00000o);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                                    jSONObject.put("method", "miIO.info");
                                    jSONObject.put("params", new JSONObject());
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(214);
                                    MiioLocalAPI.O000000o(hwf.this.O0000o0(), jSONObject.toString(), hwf.this.O00000o0, hwf.this.O00000o, new dxe() {
                                        /* class _m_j.hwf.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                        public final void onResponse(String str) {
                                            JSONObject O00000o0 = gjo.O00000o0(str);
                                            if (O00000o0 != null) {
                                                String optString = O00000o0.optString("fw_ver");
                                                if (!TextUtils.isEmpty(optString)) {
                                                    hwf.this.O000Oo00 = optString;
                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("fwversion", hwf.this.O000Oo00);
                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                                                } else {
                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2303);
                                                }
                                            }
                                            hwf hwf = hwf.this;
                                            hwf.O000000o("async_rpc info version: " + hwf.this.O000Oo00 + ", data = " + str, new Object[0]);
                                            String jSONObject = jSONObject.toString();
                                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(208);
                                            hwf.this.O000000o(" async rpc config wifi", new Object[0]);
                                            MiioLocalAPI.O000000o(hwf.this.O0000o0(), jSONObject, hwf.this.O00000o0, hwf.this.O00000o, new dxe() {
                                                /* class _m_j.hwf.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void onResponse(String str) {
                                                    hwf.this.O000000o("async_rpc device return data: ".concat(String.valueOf(str)), new Object[0]);
                                                    if (hwf.this.O00000o0(str) == null) {
                                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                                                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1402);
                                                        if (hwf.this.x_() != null) {
                                                            hwf.this.x_().sendEmptyMessageDelayed(114, 1000);
                                                        }
                                                    } else {
                                                        iae.O000000o(hwf.this.O000Oo0);
                                                    }
                                                    if (hwf.this.x_() != null) {
                                                        hwf.this.O00000Oo(1000L);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }, 5);
        }
        this.O00000Oo = 1;
    }

    private boolean O0000oO() {
        String O0000Ooo2 = DeviceFactory.O0000Ooo(this.O000Oo0.SSID);
        O000000o("check isHanntoPrinter, current model is %s", O0000Ooo2 != null ? O0000Ooo2 : "null", new Object[0]);
        for (String equals : O0000o0O) {
            if (TextUtils.equals(O0000Ooo2, equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        for (String equals : O0000o0O) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    private void O000O0oo() {
        O000000o(" .onStopConnection", new Object[0]);
        x_().removeMessages(112);
        x_().removeMessages(114);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000ooo.bindProcessToNetwork(null);
        }
        String O00000Oo2 = htr.O000000o().O00000Oo();
        String O00000o02 = htr.O000000o().O00000o0();
        String O00000o2 = htr.O000000o().O00000o();
        if (!O0000oO()) {
            String O00000o03 = gog.O00000o0(this.O000O0oo);
            if (!this.O000o000 || TextUtils.equals(O00000o03, this.O000Oo0.SSID)) {
                this.O000Oooo = hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(209);
                if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                    this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                    this.O00oOooO.O00000o0 = null;
                    this.O00oOooO = null;
                }
                iag.O000000o(this.O0000ooo, O0000ooO, O00000Oo2, O00000o02, null, O00000o2, null, false, true);
            }
        }
    }

    private void O000OO00() {
        long j = this.O00000o0;
        String str = null;
        String valueOf = j == 0 ? null : String.valueOf(j);
        if (TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(this.O00000oo)) {
            valueOf = this.O00000oo;
        }
        O000000o("BleComboStep.scanNewDevice mDid = " + fte.O000000o(valueOf), new Object[0]);
        this.O00000Oo = 2;
        long[] jArr = this.O0000Oo;
        int i = this.O00000Oo;
        if (jArr[i] == 0) {
            jArr[i] = System.currentTimeMillis();
        }
        this.O000o00O[this.O00000Oo] = System.currentTimeMillis();
        if (O0000oO()) {
            String O0000Oo2 = DeviceFactory.O0000Oo(this.O000Oo0.SSID);
            String str2 = this.O0000OOo;
            if (!(str2 == null || str2.length() != 17 || O0000Oo2 == null || O0000Oo2.length() != 4 || this.O000Oo0 == null)) {
                char[] charArray = this.O0000OOo.toCharArray();
                charArray[12] = O0000Oo2.charAt(0);
                charArray[13] = O0000Oo2.charAt(1);
                charArray[15] = O0000Oo2.charAt(2);
                charArray[16] = O0000Oo2.charAt(3);
                String replaceAll = Arrays.toString(charArray).replaceAll("[\\[\\]\\s,]", "");
                O000000o(" .scanNewDevice change deviceMac: " + fte.O000000o(replaceAll), new Object[0]);
                this.O000Oo0.BSSID = replaceAll;
            }
        }
        hto hto = this.O000o0OO;
        if (hto == null) {
            if (this.O000Oo0 != null) {
                str = this.O000Oo0.BSSID;
            }
            this.O000o0OO = new hto(str, valueOf, this.O0000oO0, this.O000OOOo);
        } else {
            if (this.O000Oo0 != null) {
                str = this.O000Oo0.BSSID;
            }
            hto.O000000o(str, valueOf, this.O0000oO0, this.O000OOOo);
        }
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
        htk.O000000o().O000000o(this.O000o0OO, (long) this.O0000o0o, this.O000o0O0);
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
    }

    public final JSONObject O00000o0(String str) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (AnonymousClass4.f841O000000o[ErrorCode.valueof(jSONObject.optInt("code")).ordinal()] != 1) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("result", optJSONArray);
            }
            return optJSONObject == null ? jSONObject : optJSONObject;
        } catch (JSONException e) {
            O000000o("parseRpcResponse error: " + Log.getStackTraceString(e), new Object[0]);
            return null;
        }
    }

    /* renamed from: _m_j.hwf$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f841O000000o = new int[ErrorCode.values().length];

        static {
            try {
                f841O000000o[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final boolean G_() {
        try {
            O000000o("onBackPressed", new Object[0]);
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwf.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (hwf.this.O000O0oo != null) {
                        hwf.this.O000000o("onBackPressed,user click ok to stop binding.", new Object[0]);
                        WifiManager wifiManager = (WifiManager) hwf.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                        WifiInfo wifiInfo = null;
                        if (wifiManager != null) {
                            wifiInfo = wifiManager.getConnectionInfo();
                        }
                        if (!(hwf.this.O000Oo0 == null || wifiInfo == null || !hwf.this.O000Oo0.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                            iag.O000000o(hwf.this.O0000ooo, ConfigStep.O0000ooO, hwf.this.O000Oo0.SSID, hwf.this.O00oOooO);
                        }
                        if (htk.O000000o().O00000o) {
                            htk.O000000o().O00000Oo();
                        }
                        hwf hwf = hwf.this;
                        int O0000O0o = hwf.O0000O0o(gon.O000000o(hwf.O00000Oo));
                        if (!gon.O000000o((int) ((System.currentTimeMillis() - hwf.this.O0000Oo[hwf.this.O00000Oo]) / 1000), hwf.this.O00000Oo)) {
                            hwf.this.O000OOo = false;
                        }
                        if (hwf.this.O00000Oo == 2 && hwf.this.O0000OoO && ((hwf.this.O0000Oo0 == 0 && !hwf.this.O0000Ooo) || !(hwf.this.O0000Oo0 == 0 || hwf.this.O0000Oo0 == 3))) {
                            hwf.this.O000OOo = false;
                        }
                        if (!hwf.this.O000OOoO && hwf.this.O000OOo && !hwf.this.O000OOoo && (hwf.this.f831O000000o || hwf.this.O00000Oo != 2 || (ConfigStep.O00oOooo() && hze.O000000o(hwf.this.O000O0oo)))) {
                            hwf hwf2 = hwf.this;
                            hwf2.O000OOoO = true;
                            if (!hwf2.O000Oo0o) {
                                hxy hxy = new hxy(Long.valueOf(hwf.this.O00000o0), hwf.this.O000OOOo, O0000O0o, hwf.this.O000Oo00, true);
                                hxy.O0000OoO = hwf.this.O0000oO0;
                                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                            } else if (hwf.this.O000Oo0O.isEmpty()) {
                                hwf.this.O000Oo0O.push(new hxy(Long.valueOf(hwf.this.O00000o0), hwf.this.O000OOOo, O0000O0o, hwf.this.O000Oo00, hwf.this.O000OOo));
                            }
                            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwf.this.O000OOOo, 4);
                        }
                        hwf hwf3 = hwf.this;
                        hwf3.O0000o0 = true;
                        hwf3.b_(false);
                    }
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void e_(int i) {
        SmartConfigRouterFactory.getStatPageV2Manager().page_AP_step_success(this.O000OOOo, this.O00000o0, O0000O0o(gon.O000000o(i)), (int) ((System.currentTimeMillis() - this.O000o00O[i]) / 1000));
        this.O000o00O[this.O00000Oo] = 0;
        super.e_(i);
    }
}

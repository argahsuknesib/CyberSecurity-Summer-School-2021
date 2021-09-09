package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hwg extends ConfigStep implements gkg {
    private static final String[] O0000OOo = {"hannto.printer.honey", "hannto.printer.honey1s"};

    /* renamed from: O000000o  reason: collision with root package name */
    public long f848O000000o;
    public int O00000Oo;
    public long[] O00000o = new long[4];
    public int O00000o0;
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    private int O0000Oo = 0;
    private int O0000Oo0 = 60000;
    private String O0000OoO;
    private String O0000Ooo;
    private boolean O0000o = false;
    private boolean O0000o0 = true;
    private Handler O0000o00;
    private long O0000o0O = -1;
    private long[] O0000o0o = new long[4];
    private boolean O000OooO = false;
    private gjs O000Oooo;
    private int O000o00 = -1;
    private htl O000o000 = new htm() {
        /* class _m_j.hwg.AnonymousClass1 */

        public final void onDeviceConnectionFailure(int i) {
            hwg.this.O000000o("onDeviceConnectionFailure code %d", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwg.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (i == -6) {
                hwg.this.O00000Oo(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
            }
            iae.O000000o(hwg.this.O000Oo0);
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hwg.this.O000000o("  DeviceFinderCallback.onDeviceConnectionSuccess", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwg.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hwg.this.O0000o0o().O00000o0 = 2;
            hwg hwg = hwg.this;
            hwg.O000OOo = false;
            hwg.O000OoO0 = true;
            hwg.e_(2);
            iae.O000000o(hwg.this.O000Oo0);
        }

        public final void onDeviceConnectionFailure() {
            hwg.this.O000000o("  DeviceFinderCallback.onDeviceConnectionFailure", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwg.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            iae.O000000o(hwg.this.O000Oo0);
        }
    };
    private boolean O000o00O = false;
    private hto O000o00o = null;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    hwg() {
        this.O000Ooo = "COMBO:BleComboV2Step";
    }

    public final htl O0000Ooo() {
        return this.O000o000;
    }

    public final boolean O0000o00() {
        return this.O000O0o;
    }

    public final void O000000o(Context context) {
        O000000o("createStep", new Object[0]);
        this.O0000o00 = new Handler(Looper.getMainLooper());
        htr.O000000o().O00000Oo("combo_strategy", 4);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
        if (!gnl.O00000Oo()) {
            this.O000OOo = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final gjs O0000o0o() {
        if (this.O000Oooo == null) {
            this.O000Oooo = new gjs(this);
            gjs gjs = this.O000Oooo;
            Context context = this.O000O0oo;
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            String O00000o2 = htr.O000000o().O00000o();
            long longValue = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
            String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
            String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
            if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                countryCode = "CN";
            }
            int intValue = ((Integer) htr.O000000o().O000000o("gmt_offset", 28800)).intValue();
            gkd gkd = new gkd();
            gjs gjs2 = gjs;
            gkd.f17942O000000o = this.O000O0oo;
            gkd.O00000o = O00000Oo2;
            gkd.O00000oO = O00000o02;
            gkd.O00000oo = O00000o2;
            gkd.O00000o0 = longValue;
            gkd.O00000Oo = this.O000OOOo;
            gkd.O0000O0o = this.O0000oo0.type;
            gkd.O0000OOo = countryDomain;
            gkd.O0000Oo0 = countryCode;
            gkd.O0000Oo = intValue;
            gkd.O0000OoO = (String) htr.O000000o().O000000o("gmt_tz", "");
            gkd.O0000Ooo = (String) htr.O000000o().O000000o("wifi_bind_key");
            gkd O00000Oo3 = gkd.O000000o().O00000Oo();
            O00000Oo3.O0000o = (long) (eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 60000);
            gjs2.O000000o(context, O00000Oo3);
            this.O000Oooo.O0000Oo = new O000000o();
        }
        return this.O000Oooo;
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
        this.O0000Oo0 = eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 60000;
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = (long) this.O0000Oo0;
        arrayList.add(gke3);
        return arrayList;
    }

    public final boolean O00000o0() {
        return this.O000OO0o;
    }

    public final boolean O00000o() {
        return !this.O0000oo;
    }

    public final void a_(Message message) {
        int i = message.what;
        if (i != 112) {
            if (i == 115) {
                O000000o(" .handleMessage MSG_DISCONNECT_TIME_OUT", new Object[0]);
                O0000o();
            } else if (i == 125) {
                this.O000OoOo = "3000.2.2";
                gsy.O000000o(4, "stopScan", "BComboS stop");
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(62000);
                if (this.O0000o) {
                    O00000Oo(SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR);
                } else if (O00000oo()) {
                    if (!this.O000OOoO && this.O000OOo) {
                        this.O000OOoO = true;
                        if (!this.O000Oo0o) {
                            SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, O0000O0o(2501), 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000Ooo, this.O000Oo00, this.O0000oO0);
                        }
                    }
                    if (this.O000Oo0o && this.O000Oo0O.isEmpty()) {
                        this.O000Oo0O.push(new hxy(Long.valueOf(this.f848O000000o), this.O000OOOo, O0000O0o(2501), this.O000Oo00, this.O000OOo));
                    }
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
                    O00000Oo(SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR);
                }
            } else if (i == 127) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2401);
                this.O000OooO = true;
            }
        } else if (O0000o0o().O00000o0 == 1) {
            O0000o();
            e_(1);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
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
        O0000o0o().O00000o0 = 0;
        O0000o0o().O0000Ooo = true;
        this.O0000o0O = System.currentTimeMillis();
        Arrays.fill(this.O00000o, 0L);
        this.O00000o[O0000o0o().O00000o0] = System.currentTimeMillis();
    }

    public final int O00000Oo() {
        int i = O0000o0o().O00000o0;
        if (i != 0) {
            if (i == 1) {
                O000000o(" .getCurrentStageIndex mCurrentIndex = SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + O0000o0o().O0000Ooo, new Object[0]);
                if (!O0000o0o().O0000Ooo) {
                    String str = this.O000Oo0.SSID;
                    WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
                    if (connectionInfo == null || !iag.O000000o(str, connectionInfo.getSSID())) {
                        O0000o0o().O00000o0 = 0;
                        return 0;
                    } else if (((Boolean) htr.O000000o().O000000o("send_passwd_success", Boolean.FALSE)).booleanValue()) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }
            return O0000o0o().O00000o0;
        }
        O000000o(" .getCurrentStageIndex mCurrentIndex = CONNECT_INDEX, mUseBleConfig = " + O0000o0o().O0000Ooo, new Object[0]);
        if (O0000o0o().O0000Ooo) {
        }
        return 0;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        int i2;
        int i3 = i;
        this.O000OOoo = true;
        O0000o0o().O000000o(i3);
        if (i3 == 0) {
            O000000o(" .onStageTimeOut CONNECT_INDEX, mUseBleConfig = " + O0000o0o().O0000Ooo, new Object[0]);
            this.O000OoOo = "3000.2.2";
            hvc statBindManager = SmartConfigRouterFactory.getStatBindManager();
            String str = this.O000OOOo;
            BindStep bindStep = BindStep.STEP_TRANSFER_CONFIG;
            statBindManager.endBindStep(str, bindStep, "connect failed, mUseBleConfig = " + O0000o0o().O0000Ooo);
            int i4 = 2101;
            if (TextUtils.isEmpty(this.O0000oO0)) {
                i4 = 2102;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, O0000O0o(i4), O0000o0o().O0000Ooo ? 1 : 0, "", "", this.O000Oo00, this.O0000oO0);
                }
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(Long.valueOf(this.f848O000000o), this.O000OOOo, O0000O0o(i4), this.O000Oo00, this.O000OOo));
            }
            if (TextUtils.isEmpty(this.O0000oO0)) {
                this.O000OoOo = "3000.2.1";
                if (!O0000o0o().O0000Ooo) {
                    iae.O000000o(this.O000Oo0);
                }
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            } else if (O0000o0o().O0000Ooo) {
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            } else {
                iae.O000000o(this.O000Oo0);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            }
        } else if (i3 == 1) {
            O000000o(" .onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + O0000o0o().O0000Ooo, new Object[0]);
            this.O000OoOo = "3000.2.3";
            hvc statBindManager2 = SmartConfigRouterFactory.getStatBindManager();
            String str2 = this.O000OOOo;
            BindStep bindStep2 = BindStep.STEP_TRANSFER_CONFIG;
            statBindManager2.endBindStep(str2, bindStep2, "transfer info failed, mUseBleConfig = " + O0000o0o().O0000Ooo);
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, O0000O0o(2401), O0000o0o().O0000Ooo ? 1 : 0, "", "", this.O000Oo00, this.O0000oO0);
                }
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(Long.valueOf(this.f848O000000o), this.O000OOOo, O0000O0o(2401), this.O000Oo00, this.O000OOo));
            }
            if (TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            if (!O0000o0o().O0000Ooo) {
                if (this.O0000Oo == 1) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                }
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
                if (pluginInfo != null && pluginInfo.O0000ooO() != 0) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR;
                }
                iae.O000000o(this.O000Oo0);
                return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
            } else if (this.O000o00 > 0) {
                hxi.O00000o0.O000000o(this.O000o00, this.O0000OoO, this.O000OOOo);
                int i5 = this.O000o00;
                if (i5 == 5) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_AUTHENTICATION_ERROR");
                    this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
                    Resources resources = this.O000O0o0.getResources();
                    ddg ddg = this.O000O0o0;
                    StringBuilder sb = new StringBuilder();
                    sb.append(resources.getString(R.string.ble_combo_device_connect_network_step_loading));
                    sb.append(resources.getString(this.O0000o0 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
                    ddg.O000000o(sb.toString(), resources.getString(R.string.ble_combo_network_title_loading));
                    return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
                } else if (i5 == 4) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_UNKNONW_ERROR");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i5 == 9) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_AUTH_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_AUTH_FAIL_09;
                } else if (i5 == 12) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_CONNECT_NETWORK_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_NETWORK_0C;
                } else if (i5 == 8) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_FIND_ROUTER_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_CANNOT_FIND_ROUTER_08;
                } else if (i5 == 10) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_WEAK_WIFI");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_WEAK_NETWORK_0A;
                } else if (i5 != 11) {
                    return null;
                } else {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_DHCP_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_DHCP_FAIL_0B;
                }
            } else {
                hxi.O00000o0.O000000o(this.O00000Oo, this.O0000OoO, this.O000OOOo);
                int i6 = this.O00000Oo;
                if (i6 == 0) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                }
                if (i6 == 1) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i6 == 2) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i6 == 3) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else {
                    return null;
                }
            }
        } else if (i3 != 2) {
            return null;
        } else {
            boolean z = O0000o0o().O0000Ooo;
            this.O000OoOo = "3000.2.3";
            hvc statBindManager3 = SmartConfigRouterFactory.getStatBindManager();
            String str3 = this.O000OOOo;
            BindStep bindStep3 = BindStep.STEP_CHECK_BIND;
            statBindManager3.endBindStep(str3, bindStep3, "get new device failed, mUseBleConfig = " + O0000o0o().O0000Ooo);
            O00oOooO();
            int i7 = this.O000o00;
            if (i7 > 0) {
                i2 = O0000O0o(gon.O000000o(this.O00000oO, this.O00000oo, i7));
            } else {
                i2 = O0000O0o(gon.O000000o(this.O00000oO, this.O00000oo, this.O00000Oo));
            }
            if (!hze.O000000o(this.O000O0oo) || (!z && !O00oOooo())) {
                this.O000OOo = false;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i8 = this.O00000Oo == 3 ? 2 : this.O00000oO;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, i2, i8, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000Ooo, this.O000Oo00, this.O0000oO0);
                }
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(Long.valueOf(this.f848O000000o), this.O000OOOo, i2, this.O000Oo00, this.O000OOo));
            }
            if (z) {
                return null;
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

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        int i = O0000o0o().O00000o0;
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
            sb.append(resources.getString(this.O0000o0 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
            ddg.O000000o(sb.toString(), resources.getString(R.string.ble_combo_network_title_loading));
            this.O000O0o0.O000000o(3);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_device_connect_network_step_success, (int) R.string.ble_combo_network_title_loading);
        }
    }

    public final void s_() {
        int i = O0000o0o().O00000o0;
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
            sb.append(resources.getString(this.O0000o0 ? R.string.kuailian_connect_ble : R.string.kuailian_connect_ap));
            ddg.O000000o(stepStatus, sb.toString(), R.string.ble_combo_network_title_loading, false);
            this.O000O0o0.O000000o(3);
        }
    }

    public final void O00000o0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        O0000o0o().O000000o(bundle);
        if (i == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.O0000o0O <= 0) {
                this.O0000o0O = currentTimeMillis;
            }
            long[] jArr = this.O00000o;
            if (jArr[i] == 0) {
                jArr[i] = currentTimeMillis;
            }
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
        } else if (i != 1) {
            if (i == 2) {
                O0000o();
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
            }
        } else if (O0000o0o().O0000Ooo) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(213);
        } else {
            this.O0000Oo++;
        }
    }

    public final Handler x_() {
        Handler x_ = super.x_();
        if (x_ != null) {
            return x_;
        }
        return this.O0000o00;
    }

    public final ScanResult O000000o() {
        return y_();
    }

    public final void O000000o(String str) {
        this.O0000oO0 = str;
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey_new", str);
        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
    }

    public final void O000000o(int i, Object obj) {
        if (i != 3) {
            if (i != 4) {
                switch (i) {
                    case 7:
                        int intValue = ((Integer) obj).intValue();
                        int O0000O0o2 = O0000O0o(29000 - intValue);
                        if (O00000oo() && !this.O000OOoO && this.O000OOo) {
                            this.O000OOoO = true;
                            if (!this.O000Oo0o) {
                                SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, O0000O0o2, 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000Ooo, this.O000Oo00, this.O0000oO0);
                            }
                        }
                        if (O00000oo() && this.O000Oo0o) {
                            this.O000Oo0O.push(new hxy(0L, this.O000OOOo, O0000O0o2, this.O000Oo00, this.O000OOo));
                        }
                        if (intValue == -6) {
                            SmartConfigRouterFactory.getSmartConfigManager().bleDisconnect(this.O0000Ooo);
                            return;
                        }
                        return;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    case 9:
                    case 11:
                        break;
                    case 10:
                        break;
                    default:
                        return;
                }
            }
            b_(true);
            return;
        }
        O0000oOO();
    }

    public final boolean t_() {
        int i = this.O000o00;
        if (i != 9 && i != 12 && i != 8 && i != 10 && i != 11 && i != 5) {
            return super.t_();
        }
        O0000oo0();
        return true;
    }

    public final void D_() {
        this.O0000o0 = true;
        this.O0000o0o[O0000o0o().O00000o0] = System.currentTimeMillis();
        if (this.O00000o[O0000o0o().O00000o0] == 0) {
            this.O00000o[O0000o0o().O00000o0] = System.currentTimeMillis();
        }
        if (this.O000Oo0 != null) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(202);
        }
    }

    public final void O000000o(String str, boolean z) {
        this.O0000Ooo = str;
        if (z) {
            foc.O0000o(str);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(204);
            SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "BleComboStep", this.O000OOOo);
            return;
        }
        this.O0000o = true;
    }

    public final void O00000Oo(String str) {
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("mac", fte.O000000o(str));
        if (!TextUtils.isEmpty(str)) {
            htr.O000000o().O00000Oo("key_report_hash_mac", str);
        } else if (O00000oo() && !this.O000OOoO && this.O000OOo) {
            this.O000OOoO = true;
            if (!this.O000Oo0o) {
                SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(this.f848O000000o, this.O000OOOo, O0000O0o(2701), 1, this.O000Oo0 == null ? "" : this.O000Oo0.SSID, this.O0000Ooo, this.O000Oo00, this.O0000oO0);
            } else {
                this.O000Oo0O.push(new hxy(Long.valueOf(this.f848O000000o), this.O000OOOo, O0000O0o(2701), this.O000Oo00, this.O000OOo));
            }
        }
    }

    public final void O00000o(String str) {
        this.O00000oo = true;
        fob.O000000o(this.O000OOOo, str);
        iae.O000000o(this.O000Oo0);
        this.O000OooO = true;
    }

    public final MiotBleAdvPacket O00000o0(String str) {
        BleDevice O00000o02 = fob.O00000o0(str);
        if (O00000o02 != null) {
            return O00000o02.O00000Oo();
        }
        return null;
    }

    public final void O000000o(int i, String str, String str2) {
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
        this.O000Oo00 = str;
        this.O0000OoO = str2;
        htr.O000000o().O00000Oo("bind_device_did", this.O0000OoO);
        this.O000o00 = -1;
        if (i == 0) {
            if (O0000o0o().O0000Ooo && !this.O000OO00) {
                e_(O0000o0o().O00000o0);
                this.O0000o0o[1] = System.currentTimeMillis();
                long[] jArr = this.O00000o;
                if (jArr[1] == 0) {
                    jArr[1] = System.currentTimeMillis();
                }
            }
        } else if (i == -37) {
            this.O0000o = true;
        }
    }

    public final void O000000o(int i) {
        if ((i < 0 || i > 3) && i != 6) {
            this.O000o00 = i;
        } else {
            this.O00000Oo = i;
        }
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
            this.O000OooO = true;
        } else if (i == 4 || i == 5) {
            O0000oOO();
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        O000000o("onFinishStep", new Object[0]);
        if (this.O000o00O) {
            hvf statResultManager = SmartConfigRouterFactory.getStatResultManager();
            String str = this.O000OOOo;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f848O000000o);
            statResultManager.combo_kuailian_result(str, sb.toString(), false, true, this.O0000O0o);
            this.O000o00O = false;
        } else {
            SmartConfigRouterFactory.getStatResultManager().combo_kuailian_result(this.O000OOOo, this.O0000OoO, true, !this.O000OooO, this.O0000O0o);
        }
        this.O0000o00.removeCallbacksAndMessages(null);
        O0000o0o().O00000Oo(((Boolean) htr.O000000o().O000000o("restore_wifi", Boolean.FALSE)).booleanValue());
    }

    public final String O0000OOo() {
        DeviceFactory.AP_TYPE O00000oO2 = DeviceFactory.O00000oO(this.O000Oo0);
        return (O00000oO2 == DeviceFactory.AP_TYPE.AP_MIDEA || O00000oO2 == DeviceFactory.AP_TYPE.AP_MIDEA_AC) ? "12345678" : "";
    }

    public final void a_(long j) {
        this.f848O000000o = j;
        htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(j));
    }

    public final void E_() {
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
        e_(O0000o0o().O00000o0);
        this.O0000Oo++;
    }

    public final void F_() {
        O000000o(" .startConnectToDeviceAp", new Object[0]);
        this.O0000o0 = false;
        this.O000o00O = true;
        this.O0000o0o[O0000o0o().O00000o0] = System.currentTimeMillis();
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(206);
    }

    public final void O00000oO() {
        e_(0);
        this.O0000Oo++;
    }

    public final void O0000Oo() {
        iae.O00000oo.clear();
        if (this.O00000o[O0000o0o().O00000o0] == 0) {
            this.O00000o[O0000o0o().O00000o0] = System.currentTimeMillis();
        }
        this.O0000o0o[O0000o0o().O00000o0] = System.currentTimeMillis();
    }

    public final boolean O00000oo() {
        String O0000Ooo2 = DeviceFactory.O0000Ooo(this.O000Oo0.SSID);
        O000000o("check isHanntoPrinter, current model is %s", O0000Ooo2 != null ? O0000Ooo2 : "null", new Object[0]);
        for (String equals : O0000OOo) {
            if (TextUtils.equals(O0000Ooo2, equals)) {
                return true;
            }
        }
        return false;
    }

    private void O0000o() {
        boolean z;
        if (!O00000oo()) {
            String O00000o02 = gog.O00000o0(this.O000O0oo);
            if (!this.O0000o0 || TextUtils.equals(O00000o02, this.O000Oo0.SSID)) {
                z = true;
                this.O00000o0 = hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(209);
                O0000o0o().O000000o(z);
            }
        }
        z = false;
        O0000o0o().O000000o(z);
    }

    public final void O0000OoO() {
        if (this.O00000o[O0000o0o().O00000o0] == 0) {
            this.O00000o[O0000o0o().O00000o0] = System.currentTimeMillis();
        }
        this.O0000o0o[O0000o0o().O00000o0] = System.currentTimeMillis();
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
    }

    public final boolean G_() {
        try {
            O000000o("onBackPressed", new Object[0]);
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwg.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (hwg.this.O000O0oo != null) {
                        hwg.this.O000000o("onBackPressed,user click ok to stop binding.", new Object[0]);
                        WifiManager wifiManager = (WifiManager) hwg.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                        WifiInfo wifiInfo = null;
                        if (wifiManager != null) {
                            wifiInfo = wifiManager.getConnectionInfo();
                        }
                        if (!(hwg.this.O000Oo0 == null || wifiInfo == null || !hwg.this.O000Oo0.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                            iag.O000000o(hwg.this.O0000ooo, ConfigStep.O0000ooO, hwg.this.O000Oo0.SSID, hwg.this.O00oOooO);
                        }
                        if (htk.O000000o().O00000o) {
                            htk.O000000o().O00000Oo();
                        }
                        hwg hwg = hwg.this;
                        int O0000O0o = hwg.O0000O0o(gon.O000000o(hwg.O0000o0o().O00000o0));
                        if (!gon.O000000o((int) ((System.currentTimeMillis() - hwg.this.O00000o[hwg.this.O0000o0o().O00000o0]) / 1000), hwg.this.O0000o0o().O00000o0)) {
                            hwg.this.O000OOo = false;
                        }
                        if (hwg.this.O0000o0o().O00000o0 == 2 && hwg.this.O00000oO && ((hwg.this.O00000Oo == 0 && !hwg.this.O00000oo) || !(hwg.this.O00000Oo == 0 || hwg.this.O00000Oo == 3))) {
                            hwg.this.O000OOo = false;
                        }
                        if (!hwg.this.O000OOoO && hwg.this.O000OOo && !hwg.this.O000OOoo && (hwg.this.O0000o0o().O0000Ooo || hwg.this.O0000o0o().O00000o0 != 2 || (ConfigStep.O00oOooo() && hze.O000000o(hwg.this.O000O0oo)))) {
                            hwg hwg2 = hwg.this;
                            hwg2.O000OOoO = true;
                            if (!hwg2.O000Oo0o) {
                                hxy hxy = new hxy(Long.valueOf(hwg.this.f848O000000o), hwg.this.O000OOOo, O0000O0o, hwg.this.O000Oo00, true);
                                hxy.O0000OoO = hwg.this.O0000oO0;
                                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                            } else if (hwg.this.O000Oo0O.isEmpty()) {
                                hwg.this.O000Oo0O.push(new hxy(Long.valueOf(hwg.this.f848O000000o), hwg.this.O000OOOo, O0000O0o, hwg.this.O000Oo00, hwg.this.O000OOo));
                            }
                            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwg.this.O000OOOo, 4);
                        }
                        hwg hwg3 = hwg.this;
                        hwg3.O0000O0o = true;
                        hwg3.b_(false);
                    }
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    class O000000o implements gkj {
        O000000o() {
        }

        public final void O000000o(String str) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(str));
            SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(hwg.this.O0000oO0), "BleComboStep", hwg.this.O000OOOo);
        }

        public final void O00000Oo(String str) {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2302);
        }

        public final void O000000o() {
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(214);
        }

        public final void O000000o(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                hwg.this.O000Oo00 = str;
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("fwversion", hwg.this.O000Oo00);
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            } else {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str2);
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2303);
            }
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(208);
        }

        public final void O000000o(String str, boolean z) {
            if (z) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1402);
                return;
            }
            iae.O000000o(hwg.this.O000Oo0);
        }

        public final void O000000o(boolean z, String str) {
            if (z) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("wifi_disconnect_by_device", "true");
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            } else if (hwg.this.O00000o0 > 0) {
                hvg.O000000o(CommonApplication.getAppContext()).O000000o(hwg.this.O00000o0, "ssid", str);
            }
        }
    }

    public final void e_(int i) {
        SmartConfigRouterFactory.getStatPageV2Manager().page_AP_step_success(this.O000OOOo, this.f848O000000o, O0000O0o(gon.O000000o(i)), (int) ((System.currentTimeMillis() - this.O0000o0o[i]) / 1000));
        this.O0000o0o[O0000o0o().O00000o0] = 0;
        super.e_(i);
    }
}

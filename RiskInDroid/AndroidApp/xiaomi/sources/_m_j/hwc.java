package _m_j;

import _m_j.hwc;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hwc extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public ScanResult f806O000000o;
    public int O00000Oo;
    public String O00000o;
    public long O00000o0;
    public int O00000oO;
    boolean O00000oo = false;
    public long O0000O0o;
    private ArrayList<gke> O0000OOo = new ArrayList<>();
    private int O0000Oo = 0;
    private int O0000Oo0;
    private int O0000OoO = 0;
    private long O0000Ooo;
    private Handler O0000o0;
    private volatile boolean O0000o00;
    private MiioLocalAPI.O000000o O0000o0O;

    public final ArrayList<gke> O0000Oo0() {
        this.O0000OOo.clear();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 50000;
        this.O0000OOo.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 50000;
        this.O0000OOo.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.O0000OOo.add(gke3);
        return this.O0000OOo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        if (i == 0) {
            O000000o(String.format("onStageTimeOut CONNECT_TO_AP_INDEX", new Object[0]), new Object[0]);
            this.O000OoOo = "3000.5.2";
            x_().removeMessages(123);
            x_().removeMessages(263);
            if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            O000OOOo();
            O000000o(true, (int) R.string.switch_router_manually, SmartConfigStep.Step.STEP_CONNECT_AP_ERROR);
            return null;
        } else if (i == 1) {
            O000000o(String.format("onStageTimeOut SEND_SSID_AND_PASSWD_INDEX", new Object[0]), new Object[0]);
            this.O00000oo = true;
            return null;
        } else if (i != 2) {
            return null;
        } else {
            O000000o(String.format("onStageTimeOut GET_NEW_DEVICE_INDEX", new Object[0]), new Object[0]);
            this.O000OoOo = "3000.5.4";
            htk.O000000o().O00000Oo();
            this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(1201), this.O000Oo00, this.O000OOo));
            O000OOOo();
            if (x_() != null) {
                x_().removeMessages(122);
            }
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.f806O000000o));
            if (pluginInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(pluginInfo.O0000ooO());
                gsy.O000000o(6, "AoConfigStep", sb.toString());
            }
            if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                O000000o(true, 0, (SmartConfigStep.Step) null);
                return null;
            }
            O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR);
            return null;
        }
    }

    public final Handler x_() {
        Handler x_ = super.x_();
        if (x_ != null) {
            return x_;
        }
        return this.O0000o0;
    }

    public final void z_() {
        this.O00000Oo = 0;
    }

    public final int O00000Oo() {
        O000000o(String.format("getCurrentStageIndex bindKey = %s", this.O0000oO0), new Object[0]);
        if (TextUtils.isEmpty(this.O0000oO0)) {
            return 0;
        }
        return this.O00000Oo;
    }

    public final SmartConfigStep.Step A_() {
        O000000o(String.format("getStep called", new Object[0]), new Object[0]);
        return SmartConfigStep.Step.STEP_AP_CONFIG_STEP;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 101) {
            O000000o(String.format("handleMessage NETWORK_STATE_CHANGED", new Object[0]), new Object[0]);
            NetworkInfo networkInfo = (NetworkInfo) message.obj;
            NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>")) {
                O000000o(String.format(">>> wifiInfo = %s, state = %s", connectionInfo, detailedState), new Object[0]);
                if (detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && iag.O000000o(connectionInfo.getSSID(), ((ScanResult) htr.O000000o().O000000o("device_ap")).SSID) && this.O00000Oo == 0 && !this.O000OO0o) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(detailedState.toString());
                    sb.append(", ");
                    String str = "";
                    sb.append(connectionInfo.getSSID() != null ? connectionInfo.getSSID() : str);
                    sb.append(", ");
                    sb.append(networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo() : str);
                    sb.append(", ");
                    if (networkInfo.getReason() != null) {
                        str = networkInfo.getReason();
                    }
                    sb.append(str);
                    gsy.O000000o(6, "WifiStateConfig", sb.toString());
                    x_().removeMessages(123);
                    if (!this.O0000o00) {
                        O0000oO();
                    }
                }
            }
        } else if (i == 112) {
            O000000o(String.format("handleMessage MSG_UPDATE_DEVICE_STATE", new Object[0]), new Object[0]);
            if (x_() != null) {
                x_().removeMessages(112);
                x_().removeMessages(114);
            }
            if (this.O00000Oo == 1) {
                e_(1);
                this.O00000Oo = 2;
                O000OO0o();
            }
        } else if (i == 263) {
            this.O00000oO++;
            O0000o0O();
        } else if (i == 114) {
            O000000o(String.format("handleMessage MSG_SEND_DEVICE_MSG", new Object[0]), new Object[0]);
            if (this.O00000oo) {
                this.O000OoOo = "3000.5.3";
                O000OOOo();
                this.O000Oo0O.push(new hxy(Long.valueOf(this.O00000o0), this.O000OOOo, O0000O0o(1401), this.O000Oo00, this.O000OOo));
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.f806O000000o));
                if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    this.O00000oo = false;
                    return;
                }
                O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR);
                return;
            }
            O000O0oo();
        } else if (i == 115) {
            O000000o(String.format("handleMessage MSG_DISCONNECT_TIME_OUT", new Object[0]), new Object[0]);
            O000OO0o();
        } else if (i == 122) {
            O000000o(String.format("handleMessage MSG_UPDATE_CHECKOUT", new Object[0]), new Object[0]);
            O000OO();
        } else if (i != 123) {
            super.O000000o(message);
        } else {
            O000000o(String.format("handleMessage MSG_RECONNECT_DEVICE_AP", new Object[0]), new Object[0]);
            O0000oO0();
        }
    }

    public final void O000000o(Context context) {
        this.O000Ooo = "BindKeyStep";
        super.O000000o(context);
        this.O0000o0 = new Handler(Looper.getMainLooper());
    }

    public final String O000000o(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public final String O0000o0() {
        return O000000o((long) ((WifiManager) this.O000O0oo.getSystemService("wifi")).getDhcpInfo().gateway);
    }

    public final void O00000o0(int i) {
        this.f806O000000o = (ScanResult) htr.O000000o().O000000o("device_ap");
        if (i == 0) {
            O000000o(String.format("startConnection CONNECT_TO_AP_INDEX", new Object[0]), new Object[0]);
            O0000oO0();
        } else if (i == 1) {
            O000000o(String.format("startConnection SEND_SSID_AND_PASSWD_INDEX", new Object[0]), new Object[0]);
            this.O0000O0o = System.currentTimeMillis();
            O000O0oo();
        } else if (i == 2) {
            O000000o(String.format("startConnection GET_NEW_DEVICE_INDEX", new Object[0]), new Object[0]);
            O000OO0o();
        }
    }

    private void O0000oO0() {
        O000000o(String.format("startConnectToDeviceAp", new Object[0]), new Object[0]);
        this.O00000Oo = 0;
        this.O0000o00 = false;
        this.O00000oO = 0;
        String O00000o02 = gog.O00000o0(this.O000O0oo);
        WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
        if (!TextUtils.isEmpty(O00000o02) && O00000o02.equals(this.f806O000000o.SSID) && connectionInfo != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
            O000000o(String.format(">>>@ info = %s, ssid = %s", connectionInfo, O00000o02), new Object[0]);
            O0000oO();
        } else if (this.O00oOooO == null || this.O00oOooO.O00000o0 == null) {
            this.O00oOooO = new iad() {
                /* class _m_j.hwc.AnonymousClass1 */

                public final void O000000o(Network network) {
                    super.O000000o(network);
                    hwc hwc = hwc.this;
                    hwc.O000000o("connectToAP ok: " + hwc.this.f806O000000o.SSID, new Object[0]);
                }

                public final void O000000o() {
                    super.O000000o();
                    hwc.this.O000000o("connectToAP onUnavailable!", new Object[0]);
                    if (hwc.this.O00000Oo == 0) {
                        hwc.this.x_().post(new Runnable() {
                            /* class _m_j.$$Lambda$hwc$1$g4UKL5cmjXT1YZYdTe6JnkY3O0Q */

                            public final void run() {
                                hwc.AnonymousClass1.this.O00000o0();
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o0() {
                    hwc.this.O0000oOO();
                }

                public final void O00000Oo(Network network) {
                    super.O00000Oo(network);
                    hwc.this.O000000o("connecttoAp onLost ", new Object[0]);
                    if (hwc.this.O00000Oo == 0) {
                        hwc.this.x_().post(new Runnable() {
                            /* class _m_j.$$Lambda$hwc$1$GxMoDXhgzdU1SO77MOOBpCvraGc */

                            public final void run() {
                                hwc.AnonymousClass1.this.O00000Oo();
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    hwc.this.O0000oOO();
                }
            };
            iag.O000000o(this.O0000ooo, O0000ooO, this.f806O000000o.SSID, "", this.f806O000000o.BSSID, this.f806O000000o.capabilities, this.O00oOooO, true, false);
            x_().sendEmptyMessageDelayed(123, 15000);
        }
    }

    private void O0000oO() {
        O000000o(String.format("onConnectToApSuccess", new Object[0]), new Object[0]);
        this.O0000o00 = true;
        if (x_() != null) {
            x_().postDelayed(new Runnable() {
                /* class _m_j.hwc.AnonymousClass3 */

                public final void run() {
                    if (hwc.this.O00000Oo == 0 && hwc.this.O000O00o()) {
                        hwc.this.O0000o0O();
                    }
                }
            }, 2000);
        }
    }

    public final void O0000o0O() {
        O000000o(String.format("getBindKey, retrys = %d", Integer.valueOf(this.O00000oO)), new Object[0]);
        if (!TextUtils.isEmpty(this.O0000oO0)) {
            this.O00000oO = 0;
            e_(this.O00000Oo);
            this.O00000Oo = 1;
            O00000o0(this.O00000Oo);
            return;
        }
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hwc.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                hwc.this.O000000o(String.format("onSuccess ".concat(String.valueOf(str)), new Object[0]), new Object[0]);
                hwc hwc = hwc.this;
                hwc.O00000oO = 0;
                hwc.e_(hwc.O00000Oo);
                hwc hwc2 = hwc.this;
                hwc2.O00000Oo = 1;
                hwc2.O0000oO0 = str;
                hwc2.O00000o0(hwc2.O00000Oo);
            }

            public final void O000000o(hud hud) {
                hwc.this.O000000o(String.format("onFailure ".concat(String.valueOf(hud)), new Object[0]), new Object[0]);
                if (hwc.this.O00000oO < 3) {
                    hwc.this.x_().sendEmptyMessageDelayed(263, 5000);
                    return;
                }
                hwc.this.O000Oo0O.push(new hxy(Long.valueOf(hwc.this.O00000o0), hwc.this.O000OOOo, hwc.this.O0000O0o(1501), hwc.this.O000Oo00, hwc.this.O000OOo));
                hwc.this.O0000oOO();
            }
        });
    }

    private void O000O0oo() {
        int i = 0;
        O000000o(String.format("startConnectionAsso ", new Object[0]), new Object[0]);
        iae.O00000oo.clear();
        this.O0000Oo0 = (int) (System.currentTimeMillis() / 1000);
        this.O00000Oo = 1;
        if (gnn.O00000oO) {
            Network network = null;
            Network[] allNetworks = this.O0000ooo.getAllNetworks();
            while (true) {
                if (i < allNetworks.length) {
                    NetworkInfo networkInfo = this.O0000ooo.getNetworkInfo(allNetworks[i]);
                    if (networkInfo != null && networkInfo.getType() == 1) {
                        network = allNetworks[i];
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (network == null) {
                gsy.O000000o(6, "ERROR", "Get Network ERROR");
            }
            this.O0000ooo.bindProcessToNetwork(network);
        }
        O000OO00();
        this.O00000Oo = 1;
    }

    public final void O0000o0o() {
        String str = (String) htr.O000000o().O000000o("selected_ap_ssid");
        String O00000o02 = htr.O000000o().O00000o0();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.O0000Oo0);
            jSONObject.put("method", "set_bind_key");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bind_key", this.O0000oO0);
            jSONObject2.put("ssid", str);
            jSONObject2.put("pswd", O00000o02);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O00000o0, this.O00000o, new dxe() {
            /* class _m_j.hwc.AnonymousClass5 */

            public final void onResponse(String str) {
                hwc.this.O000000o(String.format("async_rpc onResponse: %s", str), new Object[0]);
                hwc.this.O000000o(String.format(">>> obj = %s", hwc.O00000Oo(str)), new Object[0]);
                if (hwc.this.x_() != null) {
                    long currentTimeMillis = (50000 - (System.currentTimeMillis() - hwc.this.O0000O0o)) - 1000;
                    if (currentTimeMillis < 0) {
                        currentTimeMillis = 0;
                    }
                    hwc.this.O000000o(String.format("Delay %ds", Long.valueOf(currentTimeMillis / 1000)), new Object[0]);
                    hwc.this.x_().removeMessages(114);
                    if (gnn.O00000oO) {
                        hwc.this.O0000ooo.bindProcessToNetwork(null);
                    }
                    hwc.this.x_().sendEmptyMessageDelayed(112, currentTimeMillis);
                }
            }
        });
    }

    private void O000OO00() {
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            b_(true);
        } else if (!TextUtils.isEmpty(this.O00000o)) {
            O0000o0o();
        } else {
            MiioLocalAPI.O000000o o000000o = this.O0000o0O;
            if (o000000o != null) {
                o000000o.f6027O000000o = true;
            }
            this.O0000o0O = MiioLocalAPI.O000000o(O0000o0(), new dxe() {
                /* class _m_j.hwc.AnonymousClass6 */

                public final void onResponse(final String str) {
                    hwc.this.O000000o(String.format("async_get_token onResponse: %s", gnj.O000000o(str)), new Object[0]);
                    if (hwc.this.x_() != null) {
                        hwc.this.x_().post(new Runnable() {
                            /* class _m_j.hwc.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                JSONObject O00000Oo2 = hwc.O00000Oo(str);
                                hwc.this.O000000o(String.format(">>> async_get_token content = %s", gnj.O000000o(str)), new Object[0]);
                                if (O00000Oo2 != null) {
                                    hwc.this.O00000o0 = Long.valueOf(O00000Oo2.optString("did")).longValue();
                                    hwc.this.O00000o = O00000Oo2.optString("token");
                                    htk.O000000o().O000000o(String.valueOf(hwc.this.O00000o0), hwc.this.O00000o);
                                    hwc.this.O0000o0o();
                                } else if (hwc.this.x_() != null) {
                                    hwc.this.x_().sendEmptyMessageDelayed(114, 1000);
                                }
                            }
                        });
                    }
                }
            }, 5);
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        MiioLocalAPI.O000000o o000000o = this.O0000o0O;
        if (o000000o != null) {
            o000000o.f6027O000000o = true;
        }
        this.O0000o0.removeCallbacksAndMessages(null);
    }

    private void O000OO0o() {
        O000000o(String.format("onStopConnection", new Object[0]), new Object[0]);
        x_().removeMessages(112);
        x_().removeMessages(114);
        if (gnn.O00000oO) {
            this.O0000ooo.bindProcessToNetwork(null);
        }
        if (!hze.O000000o(this.O000O0oo)) {
            gsy.O000000o(6, "WifiSettingUap", "connect wifi");
            String str = (String) htr.O000000o().O000000o("selected_ap_ssid");
            String str2 = (String) htr.O000000o().O000000o("selected_ap_passwd");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(209);
            if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                iag.O000000o(this.O0000ooo, O0000ooO, str, str2, null, null, null, false, true);
            }
        }
        this.O0000Ooo = System.currentTimeMillis();
        O000OO();
    }

    private void O000OO() {
        O000000o(String.format("checkBindKey (%s)", this.O0000oO0), new Object[0]);
        htq.O000000o().O000000o(this.O0000oO0, new hua<JSONObject, hud>() {
            /* class _m_j.hwc.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                hwc.this.O000000o(String.format("checkBindKey onSuccess ".concat(String.valueOf(jSONObject)), new Object[0]), new Object[0]);
                int optInt = jSONObject.optInt("ret");
                if (optInt == 0) {
                    int optInt2 = jSONObject.optInt("check_after");
                    if (optInt2 > 0) {
                        hwc.this.x_().removeMessages(122);
                        hwc.this.x_().sendEmptyMessageDelayed(122, (long) (optInt2 * 1000));
                        return;
                    }
                    hwc.this.x_().removeMessages(122);
                    hwc.this.x_().sendEmptyMessageDelayed(122, 2000);
                } else if (optInt == 1) {
                    String optString = jSONObject.optString("bind_did");
                    hwc hwc = hwc.this;
                    hwc.O000OoO0 = true;
                    hwc.O000000o(optString);
                } else if (optInt == -2 || optInt == -3) {
                    hwc.this.O0000oO0 = "";
                }
            }

            public final void O000000o(hud hud) {
                hwc.this.O000000o(String.format("checkBindKey onFailure ".concat(String.valueOf(hud)), new Object[0]), new Object[0]);
                if (hwc.this.x_() != null) {
                    hwc.this.x_().removeMessages(122);
                    hwc.this.x_().sendEmptyMessageDelayed(122, 2000);
                }
            }
        });
    }

    public final void O0000o() {
        System.currentTimeMillis();
        x_().postDelayed(new Runnable() {
            /* class _m_j.hwc.AnonymousClass8 */

            public final void run() {
                hwc.this.O000000o(String.format("onGetDeviceInfoOver", new Object[0]), new Object[0]);
                if (iae.O000000o().O0000OOo == null && hwc.this.O000O0oo != null) {
                    iae.O000000o().O0000OOo = hwc.this.O000O0oo.getApplicationContext();
                    iae.O000000o().O00000Oo();
                }
                iae.O000000o(hwc.this.f806O000000o);
                hwc hwc = hwc.this;
                hwc.e_(hwc.O00000Oo);
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str) {
        O000000o(String.format("getDeviceInfo did = %s", gnj.O000000o(str)), new Object[0]);
        htq.O000000o().O000000o(this.O000O0oo, new String[]{str}, new hua<List<Device>, hud>() {
            /* class _m_j.hwc.AnonymousClass9 */

            public final /* synthetic */ void O000000o(Object obj) {
                List<Device> list = (List) obj;
                if (list.size() > 0) {
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        fno.O000000o().O00000Oo(O000000o2);
                    }
                    for (Device device : list) {
                        if (str.equals(device.did)) {
                            O000000o2 = device;
                        }
                    }
                    if (O000000o2 != null) {
                        hwc.this.O000000o(String.format("onSuccess, name = %s", O000000o2.name), new Object[0]);
                    }
                    fno.O000000o().O000000o(O000000o2);
                    htk.O000000o();
                    htk.O00000Oo(str);
                    htr.O000000o().O00000Oo("connected_device", O000000o2);
                    hwc.this.O0000o();
                }
            }

            public final void O000000o(hud hud) {
                gnk.O00000Oo(String.format("onFailure %s", hud));
                hwc.this.O0000o();
            }
        });
    }

    public static JSONObject O00000Oo(String str) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (AnonymousClass2.f809O000000o[ErrorCode.valueof(jSONObject.optInt("code")).ordinal()] != 1) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("result", optJSONArray);
            }
            return optJSONObject == null ? jSONObject : optJSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: _m_j.hwc$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f809O000000o = new int[ErrorCode.values().length];

        static {
            try {
                f809O000000o[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        int i = this.O00000Oo;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_connect_device_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
        }
    }

    public final void s_() {
        int i = this.O00000Oo;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(1);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        }
    }

    private void O000OOOo() {
        int i = this.O00000Oo;
        if (i == 0) {
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 1) {
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 2) {
            if (!hze.O000000o(this.O000O0oo)) {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_app_connect_network_failed);
            } else {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.make_device_near_router, (int) R.drawable.common_bind_device_connect_network_failed);
            }
        }
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwc.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WifiManager wifiManager = (WifiManager) hwc.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                    if (!(hwc.this.f806O000000o == null || connectionInfo == null || !hwc.this.f806O000000o.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                        iag.O000000o(hwc.this.O0000ooo, ConfigStep.O0000ooO, hwc.this.f806O000000o.SSID, hwc.this.O00oOooO);
                    }
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    hwc.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}

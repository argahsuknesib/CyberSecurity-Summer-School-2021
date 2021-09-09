package _m_j;

import _m_j.dxe;
import _m_j.hvx;
import _m_j.hwb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.tencent.mmkv.MMKV;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.ECCurve;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hvx extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<gke> f766O000000o = new ArrayList<>();
    private boolean O00000Oo = false;
    private boolean O00000o = false;
    private long O00000o0 = 50000;
    private hto O00000oO = null;
    private htl O00000oo = new htm() {
        /* class _m_j.hvx.AnonymousClass1 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hvx.this.O000000o("DeviceFinderCallback onDeviceConnectionSuccess", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvx.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            hvx hvx = hvx.this;
            hvx.O000OOo = false;
            hvx.O0000o = true;
            hvx.e_(3);
        }

        public final void onDeviceConnectionFailure() {
            hvx.this.O000000o("DeviceFinderCallback onDeviceConnectionFailure", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvx.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
        }

        public final void onDeviceConnectionFailure(int i) {
            hvx.this.O000000o("DeviceFinderCallback onDeviceConnectionFailure code %d=", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvx.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (i == -6) {
                hvx.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
            }
        }
    };
    public ScanResult O0000Oo;
    public int O0000OoO;
    protected long O0000Ooo;
    public boolean O0000o = false;
    public MiioLocalAPI.O000000o O0000o0;
    protected String O0000o00;
    public boolean O0000o0O;
    public hwb O0000o0o = null;

    hvx() {
        htk.O000000o();
        if (htk.O00000oO() != null) {
            htk.O000000o();
            this.O0000Ooo = Long.valueOf(htk.O00000oO()).longValue();
        }
        this.O000Ooo = "AP_CONFIG:ApSecureConfigStep";
    }

    public void O000000o(Context context) {
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
        O000000o("create step", new Object[0]);
    }

    public final ArrayList<gke> O0000Oo0() {
        this.f766O000000o.clear();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000o0 = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        if (iag.O00000Oo(this.O000O0oo)) {
            gke.O00000Oo = 50000;
        }
        this.f766O000000o.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 20000;
        this.f766O000000o.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = 20000;
        this.f766O000000o.add(gke3);
        gke gke4 = new gke();
        gke4.f17943O000000o = 3;
        gke4.O00000Oo = (long) (eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 50000);
        if (htk.O000000o().O00000o) {
            long j = htk.O000000o().O0000OOo;
            long currentTimeMillis = System.currentTimeMillis();
            double d = (double) ((((currentTimeMillis - j) * 50) / 50000) + 50);
            Double.isNaN(d);
            gke4.O00000o0 = (int) (d * 0.9d);
            gke4.O00000Oo = (j + 50000) - currentTimeMillis;
            this.O0000OoO = 3;
        }
        this.O00000Oo = ((Boolean) htr.O000000o().O000000o("goto_error_page", Boolean.FALSE)).booleanValue();
        if (this.O00000Oo) {
            htr.O000000o().O00000Oo("goto_error_page", Boolean.FALSE);
            this.O0000OoO = 3;
            gke4.O00000Oo = 0;
        }
        this.O00000o0 = gke4.O00000Oo;
        this.f766O000000o.add(gke4);
        return this.f766O000000o;
    }

    public final void O00000Oo(int i) {
        hxy hxy = new hxy(Long.valueOf(this.O0000Ooo), this.O000OOOo, O0000O0o(i), this.O000Oo00, true);
        hxy.O0000OoO = this.O0000oO0;
        SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      _m_j.hvx.O000000o(int, int, android.content.Intent):void
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
      _m_j.hvx.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        int i2;
        this.O0000o0O = true;
        this.O000OOoo = true;
        if (i == 0) {
            O000000o("connect ap timeout", new Object[0]);
            this.O000OoOo = "3000.1.2";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "connect ap failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i3 = 1101;
                eyr.O00000Oo();
                if (TextUtils.isEmpty(this.O0000oO0)) {
                    i3 = 1102;
                }
                O00000Oo(i3);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
            }
            if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            x_().removeMessages(123);
            if (!TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            }
            this.O000OoOo = "3000.1.1";
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (i == 1 || i == 2) {
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            O000000o("config ap timeout", new Object[0]);
            this.O000OoOo = "3000.1.3";
            O0000oO();
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                O00000Oo(1401);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 2);
            }
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(y_()));
            if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                O000000o(false, 0, (SmartConfigStep.Step) null);
            } else {
                O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR);
            }
            return null;
        } else if (i != 3) {
            return null;
        } else {
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND, "get new device failed");
            O000000o("search ap device timeout", new Object[0]);
            this.O000OoOo = "3000.1.4";
            O00oOooO();
            O0000oO();
            if (!this.O000OOoO && this.O000OOo && hze.O000000o(this.O000O0oo) && O00oOooo()) {
                this.O000OOoO = true;
                ScanResult y_ = y_();
                if (y_ == null || (i2 = htk.O000000o().O000000o(y_.BSSID)) <= 0) {
                    i2 = 1201;
                }
                O00000Oo(i2);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 3);
            }
            if (this.O00000oO != null) {
                htk.O000000o().O000000o(this.O00000oO);
            } else {
                htk.O000000o().O00000Oo();
            }
            PluginDeviceInfo pluginInfo2 = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(y_()));
            if (pluginInfo2 == null || pluginInfo2.O0000ooO() == 0) {
                O000000o(false, 0, (SmartConfigStep.Step) null);
                return null;
            }
            O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR);
            return null;
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        int i = this.O0000OoO;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_connect_device_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O00000oo();
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.kuailian_phone_connect_device_des);
            Resources resources = this.O000O0o0.getResources();
            this.O000O0o0.O000000o(resources.getString(R.string.kuailian_device_connect_wifi), resources.getString(R.string.make_device_near_router));
            this.O000O0o0.O00000oo();
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
        }
    }

    public final void a_(SmartConfigStep.Step step) {
        if (step != null) {
            O000000o("user click retry, step is %s", step.name(), new Object[0]);
        }
    }

    public final void s_() {
        int i = this.O0000OoO;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O00000oo();
            this.O000O0o0.O000000o(1);
        } else if (i == 1 || i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O00000oo();
            this.O000O0o0.O000000o(2);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, this.O000O0o0.getResources().getString(R.string.kuailian_device_connect_wifi), (int) R.string.make_device_near_router);
            this.O000O0o0.O00000oo();
            this.O000O0o0.O000000o(3);
        }
    }

    private void O0000oO() {
        int i = this.O0000OoO;
        if (i == 0) {
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 1 || i == 2) {
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 3) {
            if (!hze.O000000o(this.O000O0oo)) {
                O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.phone_wifi_error, R.drawable.common_bind_app_connect_network_failed);
            } else {
                O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.make_device_near_router, R.drawable.common_bind_device_connect_network_failed);
            }
        }
    }

    public final void z_() {
        this.O0000Ooo = 0;
        this.O0000o00 = null;
        this.O0000OoO = 0;
    }

    public int O00000Oo() {
        int i = this.O0000OoO;
        if (i != 0) {
            if (i == 1) {
                if (y_() != null) {
                    String str = y_().SSID;
                    WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
                    if (connectionInfo == null || !iag.O000000o(str, connectionInfo.getSSID())) {
                        z_();
                        return 0;
                    }
                }
                return 1;
            } else if (i != 2) {
                return i;
            } else {
                return 2;
            }
        } else if (y_() != null) {
            return 0;
        } else {
            b_(false);
            return -1;
        }
    }

    public final ScanResult y_() {
        if (this.O0000Oo == null) {
            this.O0000Oo = (ScanResult) htr.O000000o().O000000o("device_ap");
        }
        if (this.O0000Oo != null) {
            O000000o("getScanResult: not empty", new Object[0]);
        } else {
            O000000o("getScanResult is null", new Object[0]);
        }
        return this.O0000Oo;
    }

    public SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_AP_CONFIG_STEP;
    }

    public void O000000o(Message message) {
        if (x_() != null) {
            x_().removeMessages(message.what);
        }
        int i = message.what;
        if (i == 101) {
            O000000o("handleMessage:  NETWORK_STATE_CHANGED", new Object[0]);
            O00000Oo(true);
        } else if (i == 112) {
            O000000o("handle message update device state", new Object[0]);
            int i2 = this.O0000OoO;
            if (i2 == 2) {
                e_(2);
                this.O0000OoO = 3;
                O000OOOo();
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                O000OO();
            } else if (i2 == 3) {
                O000OOOo();
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                O000OO();
            }
        } else if (i == 115) {
            O000000o("handle message disconnect timeout", new Object[0]);
            O000OOOo();
            O0000oO0();
        } else if (i == 123) {
            O000000o("handleMessage:  MSG_RECONNECT_DEVICE_AP ", new Object[0]);
            DeviceFactory.O0000Ooo(y_().SSID);
            O000000o("handle message connect ap", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(206);
            if (this.O00oOooO == null || this.O00oOooO.O00000o0 == null) {
                this.O00oOooO = new iad() {
                    /* class _m_j.hvx.AnonymousClass7 */

                    public final void O000000o(Network network) {
                        super.O000000o(network);
                        hvx hvx = hvx.this;
                        hvx.O000000o("connectToAP ok: " + hvx.this.O0000Oo.SSID, new Object[0]);
                    }

                    public final void O000000o() {
                        super.O000000o();
                        hvx.this.O000000o("connectToAP onUnavailable!", new Object[0]);
                        if (hvx.this.O0000OoO == 0) {
                            hvx.this.x_().post(new Runnable() {
                                /* class _m_j.$$Lambda$hvx$7$GQLCx8ZLsRbQJeAuphG3FgH3o7w */

                                public final void run() {
                                    hvx.AnonymousClass7.this.O00000o0();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000o0() {
                        hvx.this.O0000oOO();
                    }

                    public final void O00000Oo(Network network) {
                        super.O00000Oo(network);
                        hvx.this.O000000o("connecttoAp onLost ", new Object[0]);
                        if (hvx.this.O0000OoO == 0) {
                            hvx.this.x_().post(new Runnable() {
                                /* class _m_j.$$Lambda$hvx$7$_lFDaiYG_fmEOcpg61Okvj5Dg */

                                public final void run() {
                                    hvx.AnonymousClass7.this.O00000Oo();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000Oo() {
                        hvx.this.O0000oOO();
                    }
                };
                iag.O000000o(this.O0000ooo, O0000ooO, y_().SSID, (DeviceFactory.O00000oO(y_()) == DeviceFactory.AP_TYPE.AP_MIDEA || DeviceFactory.O00000oO(y_()) == DeviceFactory.AP_TYPE.AP_MIDEA_AC) ? "12345678" : "", y_().BSSID, y_().capabilities, this.O00oOooO, true, false);
            }
        } else if (i != 132) {
            switch (i) {
                case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
                    O000000o("handle message getToken", new Object[0]);
                    O0000o0O();
                    return;
                case 129:
                    O000000o("handle message check support ECDH", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                        jSONObject.put("method", "miIO.info");
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(231);
                        MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                            /* class _m_j.hvx.AnonymousClass12 */

                            public final void O000000o(JSONObject jSONObject) {
                                if (!hvx.this.O0000o0O) {
                                    hvx.this.O000000o("checkSupportECDH onSuccess:".concat(String.valueOf(jSONObject)), new Object[0]);
                                    String optString = jSONObject.optString("miio_ver");
                                    if (!TextUtils.isEmpty(optString)) {
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("miio_ver", optString);
                                        String[] split = optString.split("\\.");
                                        if (split.length < 3) {
                                            return;
                                        }
                                        if (Integer.valueOf(split[2]).intValue() >= 2 || Integer.valueOf(split[1]).intValue() > 0 || Integer.valueOf(split[0]).intValue() > 0) {
                                            hvx.this.x_().sendEmptyMessage(130);
                                            return;
                                        }
                                        return;
                                    }
                                    hvx.this.x_().sendEmptyMessageDelayed(132, 1000);
                                }
                            }

                            public final void O000000o(int i, String str, Throwable th) {
                                hvx hvx = hvx.this;
                                StringBuilder sb = new StringBuilder("checkSupportECDH onFail:");
                                if (str == null) {
                                    str = Log.getStackTraceString(th);
                                }
                                sb.append(str);
                                hvx.O000000o(sb.toString(), new Object[0]);
                                if (!hvx.this.O000OO00 && !hvx.this.O000OO0o && hvx.this.x_() != null) {
                                    hvx.this.x_().sendEmptyMessageDelayed(132, 1000);
                                }
                            }
                        });
                        return;
                    } catch (Exception e) {
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000Oo(logType, "ApSecureConfigStep", "checkSupportECDH onFail:" + Log.getStackTraceString(e));
                        x_().sendEmptyMessageDelayed(132, 1000);
                        return;
                    }
                case 130:
                    O000000o("handle message choose ecdh0", new Object[0]);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                        jSONObject2.put("method", "miIO.handshake");
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", 1);
                        jSONObject2.put("params", jSONObject3);
                        String jSONObject4 = jSONObject2.toString();
                        O000000o("chooseECDH0:".concat(String.valueOf(jSONObject4)), new Object[0]);
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(232);
                        MiioLocalAPI.O000000o(O0000o0(), jSONObject4, this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                            /* class _m_j.hvx.AnonymousClass13 */

                            public final void O000000o(JSONObject jSONObject) {
                                int[] iArr;
                                int[] iArr2;
                                if (!hvx.this.O0000o0O) {
                                    hvx.this.O000000o("chooseECDH0 onSuccess", new Object[0]);
                                    JSONObject optJSONObject = jSONObject.optJSONObject("ecdh");
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("curve_suites");
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("sign_suites");
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("curve_suites", optJSONArray.toString());
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("sign_suites", optJSONArray2.toString());
                                    ECCurve eCCurve = null;
                                    int i = 0;
                                    while (i < optJSONArray.length() && (eCCurve = ECCurve.search(optJSONArray.optInt(i))) == null) {
                                        i++;
                                    }
                                    int i2 = 0;
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        i2 = optJSONArray2.optInt(i3);
                                        if (ECCurve.SignType.index(i2) != null) {
                                            break;
                                        }
                                    }
                                    if (eCCurve == null || i2 == 0) {
                                        izb.O000000o(SmartConfigRouterFactory.getSmartConfigManager().getAppContext(), (int) R.string.ble_new_auth_step_failed, 0).show();
                                        return;
                                    }
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("oob");
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_support_oob", String.valueOf(optJSONObject2 != null));
                                    if (optJSONObject2 != null) {
                                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("modes");
                                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray("extents");
                                        if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                            iArr = new int[]{optJSONObject2.optInt("modes")};
                                        } else {
                                            iArr = new int[optJSONArray3.length()];
                                            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                                iArr[i4] = optJSONArray3.optInt(i4);
                                            }
                                        }
                                        if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                                            iArr2 = new int[]{optJSONObject2.optInt("extents")};
                                        } else {
                                            iArr2 = new int[optJSONArray4.length()];
                                            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                                                iArr2[i5] = optJSONArray4.optInt(i5);
                                            }
                                        }
                                        hvx.this.O000000o(eCCurve, i2, iArr, iArr2);
                                        return;
                                    }
                                    hvx.this.O000000o(eCCurve, i2, (int[]) null, (int[]) null);
                                }
                            }

                            public final void O000000o(int i, String str, Throwable th) {
                                hvx hvx = hvx.this;
                                StringBuilder sb = new StringBuilder("chooseECDH0 onFail:");
                                if (str == null) {
                                    str = Log.getStackTraceString(th);
                                }
                                sb.append(str);
                                hvx.O000000o(sb.toString(), new Object[0]);
                                if (!hvx.this.O000OO00 && !hvx.this.O000OO0o && !hvx.this.O0000o0O) {
                                    hvx.this.O0000o();
                                }
                            }
                        });
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                default:
                    super.O000000o(message);
                    return;
            }
        } else {
            O000000o("handle message send wifi", new Object[0]);
            if (!this.O0000o0O) {
                e_(1);
                this.O0000OoO = 2;
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                    jSONObject5.put("method", "miIO.config_router");
                    jSONObject5.put("params", O000OO0o());
                } catch (JSONException e3) {
                    O000000o("makeNormalWifiJson error:" + Log.getStackTraceString(e3), new Object[0]);
                }
                String jSONObject6 = jSONObject5.toString();
                O000000o("Enter Normal wifi config(sendWifi)", new Object[0]);
                SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "ApSecureConfigStep", this.O000OOOo);
                MiioLocalAPI.O000000o(O0000o0(), jSONObject6, this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                    /* class _m_j.hvx.AnonymousClass2 */

                    public final void O000000o(JSONObject jSONObject) {
                        hvx.this.O000000o("sendWifi, onSuccess", new Object[0]);
                        if (hvx.this.x_() != null) {
                            hvx.this.x_().sendEmptyMessageDelayed(112, 1000);
                        }
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        hvx.this.O000000o("sendWifi, onFail:".concat(String.valueOf(str)), new Object[0]);
                        if (!hvx.this.O000OO00 && !hvx.this.O000OO0o && !hvx.this.O0000o0O) {
                            hvx.this.O0000oOO();
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    public final void O00000o0(int i) {
        boolean z;
        boolean z2 = true;
        O000000o("startConnection index %d", Integer.valueOf(i));
        if (i == 0) {
            z_();
            List<ScanResult> scanResults = O0000ooO.getScanResults();
            if (scanResults != null) {
                Iterator<ScanResult> it = scanResults.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (iag.O000000o(it.next().SSID, this.O0000Oo.SSID)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z || !this.O000OOo) {
                    z2 = false;
                }
                this.O000OOo = z2;
                SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                if (TextUtils.isEmpty(this.O0000oO0)) {
                    O00000Oo(false);
                    return;
                }
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
                O000000o(new hua<String, hud>() {
                    /* class _m_j.hvx.AnonymousClass8 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        String str = (String) obj;
                        hvx.this.O000000o("getBindKey onSuccess,key =".concat(String.valueOf(str)), new Object[0]);
                        hvx hvx = hvx.this;
                        hvx.O0000oO0 = str;
                        hvx.O00000Oo(false);
                    }

                    public final void O000000o(hud hud) {
                        if (hud != null) {
                            hvx.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", hud.O000000o());
                        }
                        fte.O00000Oo("BleComboStep getBindKey failed");
                        hvx.this.O0000oO0 = "";
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(-1);
                        hvx.this.O00000Oo(false);
                    }
                }, 2);
                return;
            }
            z = false;
            z2 = false;
            this.O000OOo = z2;
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
            if (TextUtils.isEmpty(this.O0000oO0)) {
            }
        } else if (i == 1 || i == 2) {
            O000OO00();
            this.O0000OoO = 1;
            if (x_() == null || (this.O0000Ooo != 0 && !TextUtils.isEmpty(this.O0000o00))) {
                O0000o0o();
            } else {
                x_().sendEmptyMessage(NotificationCompat.FLAG_HIGH_PRIORITY);
            }
        } else if (i == 3) {
            x_().sendEmptyMessage(112);
        }
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        htq.O000000o().O00000o0(this.O000OOOo, SmartConfigRouterFactory.getCoreApiManager().getMiId(), new hua<JSONObject, hud>() {
            /* class _m_j.hvx.AnonymousClass9 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                hvx.this.O000000o(" getBindKeyX onSuccess %s", jSONObject);
                if (jSONObject == null || jSONObject.length() == 0) {
                    O000000o((hud) null);
                    return;
                }
                hvx.this.O0000oO = jSONObject.optLong("timestamp");
                String optString = jSONObject.optString("bindKey");
                String optString2 = jSONObject.optString("bindKeyIndex");
                hvx hvx = hvx.this;
                if ("0".equals(optString2)) {
                    optString2 = null;
                }
                hvx.O0000oOO = optString2;
                hua.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                hvx.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                if (hvx.this.O000O0o && hvx.this.O0000OoO == 0) {
                    htq.O000000o().O000000o(new hua<String, hud>() {
                        /* class _m_j.hvx.AnonymousClass9.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            hvx.this.O000000o("getBindKey onSuccess,key =".concat(String.valueOf(str)), new Object[0]);
                            hua.O000000o(str);
                            hvx.this.O0000oO = 0;
                            hvx.this.O0000oOO = null;
                        }

                        public final void O000000o(hud hud) {
                            hvx.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                            hvx.this.O000000o("getBindKey retry count %d", Integer.valueOf(i));
                            if (i == 0) {
                                Object O000000o2 = htr.O000000o().O000000o("wifi_bind_key");
                                if (O000000o2 != null) {
                                    String str = (String) O000000o2;
                                    if (!TextUtils.isEmpty(str)) {
                                        hvx.this.O000000o("getBindKey from local", new Object[0]);
                                        hua.O000000o(str);
                                        return;
                                    }
                                }
                                hvx.this.O0000oOO();
                                return;
                            }
                            hvx.this.O000000o(hua, i - 1);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public final void O00000Oo(boolean z) {
        x_().removeMessages(123);
        ScanResult y_ = y_();
        if (y_ != null && !this.O000OO0o && this.O0000OoO != 3 && !this.O0000o0O) {
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            StringBuilder sb = new StringBuilder("checkConnectDeviceAp getConnectionInfo: ");
            sb.append(connectionInfo == null ? "null" : connectionInfo.getSSID());
            O000000o(sb.toString(), new Object[0]);
            if (connectionInfo == null || !iag.O000000o(connectionInfo.getSSID(), y_.SSID)) {
                O000000o("checkConnectDeviceAp false ", new Object[0]);
                if (!this.O00000o || this.O0000OoO != 2) {
                    x_().sendEmptyMessageDelayed(123, z ? 5000 : 0);
                    return;
                }
                O000000o("handle message network changed, decide config router success", new Object[0]);
                x_().sendEmptyMessage(112);
                return;
            }
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
            if (x_() != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                O000000o("checkConnectDeviceAp true", new Object[0]);
                boolean O000OO00 = O000OO00();
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_wifi_connected", String.valueOf(O000OO00));
                if (O000OO00) {
                    this.O00000o = false;
                    O000O0oo();
                    return;
                }
                O000000o("checkConnectDeviceAp false,try 1 second late", new Object[0]);
                x_().postDelayed(new Runnable(z) {
                    /* class _m_j.$$Lambda$hvx$aKNNTL9ZnUvrk1FS5Fd1ASSoHLw */
                    private final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hvx.this.O00000Oo(this.f$1);
                    }
                }, 1000);
            }
        }
    }

    private void O000O0oo() {
        O000000o("onApConnected", new Object[0]);
        x_().postDelayed(new Runnable() {
            /* class _m_j.hvx.AnonymousClass10 */

            public final void run() {
                if (hvx.this.O0000OoO == 0 && hvx.this.O000O00o()) {
                    hvx.this.e_(0);
                    hvx hvx = hvx.this;
                    hvx.O0000OoO = 1;
                    if (hvx.x_() == null) {
                        return;
                    }
                    if (hvx.this.O0000Ooo == 0 || TextUtils.isEmpty(hvx.this.O0000o00)) {
                        hvx.this.x_().sendEmptyMessage(NotificationCompat.FLAG_HIGH_PRIORITY);
                    }
                }
            }
        }, (long) ((this.O000O0oo == null || !iag.O00000Oo(this.O000O0oo) || Settings.canDrawOverlays(this.O000O0oo)) ? 10 : 2000));
    }

    private boolean O000OO00() {
        if (this.O0000ooo == null) {
            return false;
        }
        O000000o("startConnectionAsso mCurrentIndex:%d=", Integer.valueOf(this.O0000OoO));
        iae.O00000oo.clear();
        if (!gnn.O00000oO) {
            return true;
        }
        Network network = null;
        Network[] allNetworks = this.O0000ooo.getAllNetworks();
        int i = 0;
        while (true) {
            try {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (network != null) {
            return this.O0000ooo.bindProcessToNetwork(network);
        }
        O000000o(" startConnectionAsso Get Network ERROR", new Object[0]);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r3 == 1) goto L_0x0027;
     */
    private JSONObject O000OO0o() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z = true;
            if (htt.O000000o(this.O000OOOo)) {
                int O00000Oo2 = MMKV.O000000o().O00000Oo("moxiang_connection_mode", -1);
                MMKV.O000000o().remove("moxiang_connection_mode");
            }
            z = false;
            if (z) {
                str2 = "mijia_camera_wire_mode";
                str = "Camera_Default_dJNvr51z";
            } else if (htt.O00000Oo(this.O000OOOo)) {
                str2 = (String) htr.O000000o().O000000o("mo_xiang_station_ssid", "");
                str = (String) htr.O000000o().O000000o("mo_xiang_station_passwd", "");
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    O000000o("[makeNormalWifiParams] Moxiang Device But get empty ssid(" + str2 + ")or password(" + str + ")", new Object[0]);
                }
            } else {
                str2 = htr.O000000o().O00000Oo();
                str = htr.O000000o().O00000o0();
            }
            jSONObject.put("bind_key", this.O0000oO0);
            if (!TextUtils.isEmpty(this.O0000oOO) && this.O0000oO > 0) {
                jSONObject.put("bind_index", this.O0000oOO);
                jSONObject.put("bind_ts", this.O0000oO);
                O000000o("bind_ts: " + this.O0000oO + "bindkey_index:" + this.O0000oOO, new Object[0]);
            }
            jSONObject.put("config_type", this.O0000oo0.type);
            String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
            if (!TextUtils.isEmpty(countryDomain)) {
                jSONObject.put("country_domain", countryDomain);
            }
            String str3 = (String) htr.O000000o().O000000o("mo_xiang_static_key", "");
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("static_key", str3);
            }
            String str4 = (String) htr.O000000o().O000000o("mo_xiang_key_num", "");
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject.put("static_key_number", Integer.parseInt(str4));
                } catch (NumberFormatException e) {
                    O000000o("[makeNormalWifiParams] + convert " + str4 + " to int failed", e);
                }
            }
            jSONObject.put("gmt_offset", (Integer) htr.O000000o().O000000o("gmt_offset", 28800));
            if (str == null) {
                str = "";
            }
            jSONObject.put("passwd", str);
            jSONObject.put("ssid", str2);
            jSONObject.put("tz", htr.O000000o().O000000o("gmt_tz", ""));
            jSONObject.put("uid", Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()));
            JSONObject jSONObject2 = new JSONObject();
            String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
            if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                countryCode = "CN";
            }
            jSONObject2.put("cc", countryCode);
            jSONObject.put("wifi_config", jSONObject2);
            gsy.O00000Oo("ApSecureConfigStep", "WifiConfigJson : " + jSONObject2.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void O0000o0O() {
        if (TextUtils.isEmpty(this.O0000oO0)) {
            O0000oOO();
        } else if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            O000000o("getToken ,but user not login", new Object[0]);
            b_(true);
        } else {
            O000000o("start getToken", new Object[0]);
            if (this.O0000o0 == null && !this.O0000o0O) {
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
                this.O0000o0 = MiioLocalAPI.O000000o(O0000o0(), new dxe.O000000o() {
                    /* class _m_j.hvx.AnonymousClass11 */

                    public final void O000000o(JSONObject jSONObject) {
                        hvx hvx = hvx.this;
                        hvx.O0000o0 = null;
                        hvx.O000000o("getToken onSuccess", new Object[0]);
                        if (hvx.this.O0000Ooo == 0 || TextUtils.isEmpty(hvx.this.O0000o00)) {
                            hvx.this.O0000Ooo = jSONObject.optLong("did");
                            hvx.this.O0000o00 = jSONObject.optString("token");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                                jSONObject2.put("method", "miIO.info");
                                jSONObject2.put("params", new JSONObject());
                                hvx.this.O000000o("after getToken success,do rpc method : miIO.info ,can get firmware version", new Object[0]);
                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(214);
                                MiioLocalAPI.O000000o(hvx.this.O0000o0(), jSONObject2.toString(), hvx.this.O0000Ooo, hvx.this.O0000o00, new dxe() {
                                    /* class _m_j.hvx.AnonymousClass11.AnonymousClass1 */

                                    public final void onResponse(String str) {
                                        JSONObject O000000o2 = hvu.O000000o(str);
                                        if (O000000o2 != null) {
                                            hvx.this.O000Oo00 = O000000o2.optString("fw_ver");
                                        }
                                        hvx hvx = hvx.this;
                                        hvx.O000000o("async_rpc info version: " + hvx.this.O000Oo00 + ", data = " + str, new Object[0]);
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("fwversion", hvx.this.O000Oo00);
                                        hvx.this.O0000o0o();
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        hvx hvx = hvx.this;
                        hvx.O0000o0 = null;
                        StringBuilder sb = new StringBuilder("getToken onFail:");
                        sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                        hvx.O000000o(sb.toString(), new Object[0]);
                        if (!hvx.this.O000OO00 && !hvx.this.O000OO0o) {
                            hvx.this.O0000o0O();
                        }
                    }
                }, 3);
            }
        }
    }

    public final void O0000o0o() {
        O000000o("process token FORCE_ECDH =%s", "true", new Object[0]);
        htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(this.O0000Ooo));
        htr.O000000o().O00000Oo("bind_device_token", this.O0000o00);
        htk.O000000o().O000000o(String.valueOf(this.O0000Ooo), this.O0000o00);
        x_().sendEmptyMessage(130);
    }

    public final void O0000o() {
        O000000o("FORCE_ECDH=%s", "true", new Object[0]);
        x_().sendEmptyMessageDelayed(130, 1000);
    }

    public final void O000000o(ECCurve eCCurve, int i, int[] iArr, int[] iArr2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("curve_suite", eCCurve.getIndex());
            jSONObject3.put("sign_suite", i);
            jSONObject3.put("public_key", Base64.encodeToString(fio.O000000o((ECPublicKey) eCCurve.generateKeyPair().getPublic()), 2));
            jSONObject2.put("ecdh", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            O000000o("start chooseECDH", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(233);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("curve_suite", String.valueOf(eCCurve.getIndex()));
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("sign_suite", String.valueOf(i));
            final ECCurve eCCurve2 = eCCurve;
            final int i2 = i;
            final int[] iArr3 = iArr;
            final int[] iArr4 = iArr2;
            MiioLocalAPI.O00000Oo(O0000o0(), jSONObject4, this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                /* class _m_j.hvx.AnonymousClass14 */

                public final void O000000o(final JSONObject jSONObject) {
                    hvx.this.x_().post(new Runnable() {
                        /* class _m_j.hvx.AnonymousClass14.AnonymousClass1 */

                        public final void run() {
                            String str;
                            if (hvx.this.O0000o0O) {
                                hvx.this.O000000o("chooseECDH onSuccess ,but timeout ", new Object[0]);
                                return;
                            }
                            hvx.this.O000000o("chooseECDH onSuccess", new Object[0]);
                            JSONObject optJSONObject = jSONObject.optJSONObject("ecdh");
                            String str2 = "";
                            if (optJSONObject != null) {
                                str2 = optJSONObject.optString("public_key");
                                str = optJSONObject.optString("sign");
                            } else {
                                str = str2;
                            }
                            final byte[] verify = eCCurve2.verify(ECCurve.SignType.index(i2), hvx.this.O0000o00, Base64.decode(str2, 2), Base64.decode(str, 2));
                            if (verify == null) {
                                hvx.this.O000000o("chooseECDH ,verify fail, retry", new Object[0]);
                                hvx.this.O0000o();
                            } else if (iArr3 == null || iArr3.length <= 0 || iArr4 == null || iArr4.length <= 0) {
                                hvx.this.O000000o(verify, (String) null);
                            } else {
                                int i = 0;
                                boolean z = false;
                                boolean z2 = false;
                                int i2 = 0;
                                while (i < iArr3.length && i < iArr4.length) {
                                    if (iArr3[i] == 2) {
                                        i2 = iArr4[i];
                                        z = true;
                                    } else if (iArr3[i] == 3) {
                                        z2 = true;
                                    }
                                    i++;
                                }
                                htr.O000000o().O00000Oo("sign", verify);
                                htr.O000000o().O00000Oo("length", Integer.valueOf(i2));
                                int i3 = iArr3[0];
                                if (z2) {
                                    i3 = 3;
                                } else if (z) {
                                    i3 = 2;
                                }
                                hvx.this.O000000o("chooseECDH, verify mode(1:keyboard;2:pincode;3:QRcode;4:digital display)=%d", Integer.valueOf(i3));
                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("oob_mode", String.valueOf(i3));
                                if (i3 == 1) {
                                    return;
                                }
                                if (i3 == 2) {
                                    hvx.this.O000000o("chooseECDH, verify mode is :OOB_MODE_VOICE,and then create pin step", new Object[0]);
                                    hvx.this.O00000o(SmartConfigStep.Step.STEP_APSECURE_PIN_STEP);
                                } else if (i3 == 3) {
                                    hvx.this.O000000o("chooseECDH, verify mode is :OOB_MODE_QRCODE", new Object[0]);
                                    String str3 = (String) htr.O000000o().O000000o("camera_qrcode_oob");
                                    hvx hvx = hvx.this;
                                    hvx.O000000o("chooseECDH, did :" + hvx.this.O0000Ooo + ", oob : " + foc.O0000o00(String.valueOf(hvx.this.O0000Ooo)), new Object[0]);
                                    if (TextUtils.isEmpty(str3)) {
                                        str3 = foc.O0000o00(hvx.this.O0000Oo.BSSID);
                                    }
                                    if (TextUtils.isEmpty(str3)) {
                                        hvx.this.O000000o("chooseECDH, verify mode is :OOB_MODE_QRCODE, but camera QR OOB is empty,so should jump ScanBarcodeActivity get oob", new Object[0]);
                                        hvx.this.x_().removeMessages(110);
                                        SmartConfigRouterFactory.getSmartConfigManager().checkPassedForCamera((Activity) hvx.this.O000O0oo, true, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x018f: INVOKE  
                                              (wrap: _m_j.hvb : 0x017e: INVOKE  (r0v44 _m_j.hvb) =  type: STATIC call: com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory.getSmartConfigManager():_m_j.hvb)
                                              (wrap: android.app.Activity : 0x0188: CHECK_CAST  (r1v15 android.app.Activity) = (android.app.Activity) (wrap: android.content.Context : 0x0186: IGET  (r1v14 android.content.Context) = 
                                              (wrap: _m_j.hvx : 0x0184: IGET  (r1v13 _m_j.hvx) = 
                                              (wrap: _m_j.hvx$14 : 0x0182: IGET  (r1v12 _m_j.hvx$14) = (r14v0 'this' _m_j.hvx$14$1 A[THIS]) _m_j.hvx.14.1.O00000Oo _m_j.hvx$14)
                                             _m_j.hvx.14.O00000oO _m_j.hvx)
                                             _m_j.hvx.O000O0oo android.content.Context))
                                              true
                                              (wrap: _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo : 0x018c: CONSTRUCTOR  (r2v25 _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo) = (r14v0 'this' _m_j.hvx$14$1 A[THIS]), (r3v5 'z' boolean) call: _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo.<init>(_m_j.hvx$14$1, boolean):void type: CONSTRUCTOR)
                                             type: INTERFACE call: _m_j.hvb.checkPassedForCamera(android.app.Activity, boolean, _m_j.huf):boolean in method: _m_j.hvx.14.1.run():void, dex: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x018c: CONSTRUCTOR  (r2v25 _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo) = (r14v0 'this' _m_j.hvx$14$1 A[THIS]), (r3v5 'z' boolean) call: _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo.<init>(_m_j.hvx$14$1, boolean):void type: CONSTRUCTOR in method: _m_j.hvx.14.1.run():void, dex: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 129 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 135 more
                                            */
                                        /*
                                            this = this;
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            boolean r0 = r0.O0000o0O
                                            r1 = 0
                                            if (r0 == 0) goto L_0x0015
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r1 = new java.lang.Object[r1]
                                            java.lang.String r2 = "chooseECDH onSuccess ,but timeout "
                                            r0.O000000o(r2, r1)
                                            return
                                        L_0x0015:
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r2 = new java.lang.Object[r1]
                                            java.lang.String r3 = "chooseECDH onSuccess"
                                            r0.O000000o(r3, r2)
                                            org.json.JSONObject r0 = r3
                                            java.lang.String r2 = "ecdh"
                                            org.json.JSONObject r0 = r0.optJSONObject(r2)
                                            java.lang.String r2 = "sign"
                                            java.lang.String r3 = ""
                                            if (r0 == 0) goto L_0x0039
                                            java.lang.String r3 = "public_key"
                                            java.lang.String r3 = r0.optString(r3)
                                            java.lang.String r0 = r0.optString(r2)
                                            goto L_0x003a
                                        L_0x0039:
                                            r0 = r3
                                        L_0x003a:
                                            _m_j.hvx$14 r4 = _m_j.hvx.AnonymousClass14.this
                                            com.xiaomi.smarthome.smartconfig.step.ECCurve r4 = r3
                                            _m_j.hvx$14 r5 = _m_j.hvx.AnonymousClass14.this
                                            int r5 = r4
                                            com.xiaomi.smarthome.smartconfig.step.ECCurve$SignType r5 = com.xiaomi.smarthome.smartconfig.step.ECCurve.SignType.index(r5)
                                            _m_j.hvx$14 r6 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r6 = _m_j.hvx.this
                                            java.lang.String r6 = r6.O0000o00
                                            r7 = 2
                                            byte[] r3 = android.util.Base64.decode(r3, r7)
                                            byte[] r0 = android.util.Base64.decode(r0, r7)
                                            byte[] r12 = r4.verify(r5, r6, r3, r0)
                                            if (r12 != 0) goto L_0x006e
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r1 = new java.lang.Object[r1]
                                            java.lang.String r2 = "chooseECDH ,verify fail, retry"
                                            r0.O000000o(r2, r1)
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            r0.O0000o()
                                            return
                                        L_0x006e:
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            int[] r0 = r5
                                            if (r0 == 0) goto L_0x01eb
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            int[] r0 = r5
                                            int r0 = r0.length
                                            if (r0 <= 0) goto L_0x01eb
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            int[] r0 = r6
                                            if (r0 == 0) goto L_0x01eb
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            int[] r0 = r6
                                            int r0 = r0.length
                                            if (r0 <= 0) goto L_0x01eb
                                            r0 = 0
                                            r3 = 0
                                            r4 = 0
                                            r5 = 0
                                        L_0x008c:
                                            _m_j.hvx$14 r6 = _m_j.hvx.AnonymousClass14.this
                                            int[] r6 = r5
                                            int r6 = r6.length
                                            r8 = 3
                                            r9 = 1
                                            if (r0 >= r6) goto L_0x00b9
                                            _m_j.hvx$14 r6 = _m_j.hvx.AnonymousClass14.this
                                            int[] r6 = r6
                                            int r6 = r6.length
                                            if (r0 >= r6) goto L_0x00b9
                                            _m_j.hvx$14 r6 = _m_j.hvx.AnonymousClass14.this
                                            int[] r6 = r5
                                            r6 = r6[r0]
                                            if (r6 != r7) goto L_0x00ad
                                            _m_j.hvx$14 r3 = _m_j.hvx.AnonymousClass14.this
                                            int[] r3 = r6
                                            r3 = r3[r0]
                                            r5 = r3
                                            r3 = 1
                                            goto L_0x00b6
                                        L_0x00ad:
                                            _m_j.hvx$14 r6 = _m_j.hvx.AnonymousClass14.this
                                            int[] r6 = r5
                                            r6 = r6[r0]
                                            if (r6 != r8) goto L_0x00b6
                                            r4 = 1
                                        L_0x00b6:
                                            int r0 = r0 + 1
                                            goto L_0x008c
                                        L_0x00b9:
                                            _m_j.htr r0 = _m_j.htr.O000000o()
                                            r0.O00000Oo(r2, r12)
                                            _m_j.htr r0 = _m_j.htr.O000000o()
                                            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                                            java.lang.String r5 = "length"
                                            r0.O00000Oo(r5, r2)
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            int[] r0 = r5
                                            r0 = r0[r1]
                                            if (r4 == 0) goto L_0x00d7
                                            r0 = 3
                                            goto L_0x00da
                                        L_0x00d7:
                                            if (r3 == 0) goto L_0x00da
                                            r0 = 2
                                        L_0x00da:
                                            _m_j.hvx$14 r2 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r2 = _m_j.hvx.this
                                            java.lang.Object[] r4 = new java.lang.Object[r9]
                                            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
                                            r4[r1] = r5
                                            java.lang.String r5 = "chooseECDH, verify mode(1:keyboard;2:pincode;3:QRcode;4:digital display)=%d"
                                            r2.O000000o(r5, r4)
                                            android.content.Context r2 = com.xiaomi.smarthome.application.CommonApplication.getAppContext()
                                            _m_j.hvo r2 = _m_j.hvg.O000000o(r2)
                                            java.lang.String r4 = java.lang.String.valueOf(r0)
                                            java.lang.String r5 = "oob_mode"
                                            r2.O00000Oo(r5, r4)
                                            if (r0 == r9) goto L_0x01ea
                                            if (r0 == r7) goto L_0x01d6
                                            if (r0 == r8) goto L_0x0104
                                            goto L_0x01d5
                                        L_0x0104:
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r2 = new java.lang.Object[r1]
                                            java.lang.String r4 = "chooseECDH, verify mode is :OOB_MODE_QRCODE"
                                            r0.O000000o(r4, r2)
                                            _m_j.htr r0 = _m_j.htr.O000000o()
                                            java.lang.String r2 = "camera_qrcode_oob"
                                            java.lang.Object r0 = r0.O000000o(r2)
                                            java.lang.String r0 = (java.lang.String) r0
                                            _m_j.hvx$14 r2 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r2 = _m_j.hvx.this
                                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                            java.lang.String r5 = "chooseECDH, did :"
                                            r4.<init>(r5)
                                            _m_j.hvx$14 r5 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r5 = _m_j.hvx.this
                                            long r5 = r5.O0000Ooo
                                            r4.append(r5)
                                            java.lang.String r5 = ", oob : "
                                            r4.append(r5)
                                            _m_j.hvx$14 r5 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r5 = _m_j.hvx.this
                                            long r5 = r5.O0000Ooo
                                            java.lang.String r5 = java.lang.String.valueOf(r5)
                                            java.lang.String r5 = _m_j.foc.O0000o00(r5)
                                            r4.append(r5)
                                            java.lang.String r4 = r4.toString()
                                            java.lang.Object[] r5 = new java.lang.Object[r1]
                                            r2.O000000o(r4, r5)
                                            boolean r2 = android.text.TextUtils.isEmpty(r0)
                                            if (r2 == 0) goto L_0x0160
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            android.net.wifi.ScanResult r0 = r0.O0000Oo
                                            java.lang.String r0 = r0.BSSID
                                            java.lang.String r0 = _m_j.foc.O0000o00(r0)
                                        L_0x0160:
                                            boolean r2 = android.text.TextUtils.isEmpty(r0)
                                            if (r2 == 0) goto L_0x0193
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r1 = new java.lang.Object[r1]
                                            java.lang.String r2 = "chooseECDH, verify mode is :OOB_MODE_QRCODE, but camera QR OOB is empty,so should jump ScanBarcodeActivity get oob"
                                            r0.O000000o(r2, r1)
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            android.os.Handler r0 = r0.x_()
                                            r1 = 110(0x6e, float:1.54E-43)
                                            r0.removeMessages(r1)
                                            _m_j.hvb r0 = com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory.getSmartConfigManager()
                                            _m_j.hvx$14 r1 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r1 = _m_j.hvx.this
                                            android.content.Context r1 = r1.O000O0oo
                                            android.app.Activity r1 = (android.app.Activity) r1
                                            _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo r2 = new _m_j.-$$Lambda$hvx$14$1$74Sa2KGM6SBKpQHSVO_opM87eWo
                                            r2.<init>(r14, r3)
                                            r0.checkPassedForCamera(r1, r9, r2)
                                            return
                                        L_0x0193:
                                            _m_j.hvx$14 r2 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r2 = _m_j.hvx.this
                                            _m_j.hwb r2 = r2.O0000o0o
                                            if (r2 == 0) goto L_0x01a4
                                            _m_j.hvx$14 r2 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r2 = _m_j.hvx.this
                                            _m_j.hwb r2 = r2.O0000o0o
                                            r2.O000000o()
                                        L_0x01a4:
                                            _m_j.hvx$14 r2 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r2 = _m_j.hvx.this
                                            java.lang.Object[] r1 = new java.lang.Object[r1]
                                            java.lang.String r3 = "chooseECDH, verify mode is :OOB_MODE_QRCODE, camera QR OOB exist, start bind"
                                            r2.O000000o(r3, r1)
                                            _m_j.hvx$14 r1 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r1 = _m_j.hvx.this
                                            _m_j.hwb r2 = new _m_j.hwb
                                            _m_j.hvx$14 r3 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r3 = _m_j.hvx.this
                                            long r9 = r3.O0000Ooo
                                            _m_j.hvx$14 r3 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r3 = _m_j.hvx.this
                                            java.lang.String r11 = r3.O0000o00
                                            _m_j.hvx$14$1$1 r13 = new _m_j.hvx$14$1$1
                                            r13.<init>(r12)
                                            r8 = r2
                                            r8.<init>(r9, r11, r12, r13)
                                            r1.O0000o0o = r2
                                            _m_j.hvx$14 r1 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r1 = _m_j.hvx.this
                                            _m_j.hwb r1 = r1.O0000o0o
                                            r1.O000000o(r0)
                                        L_0x01d5:
                                            return
                                        L_0x01d6:
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            java.lang.Object[] r1 = new java.lang.Object[r1]
                                            java.lang.String r2 = "chooseECDH, verify mode is :OOB_MODE_VOICE,and then create pin step"
                                            r0.O000000o(r2, r1)
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step r1 = com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.Step.STEP_APSECURE_PIN_STEP
                                            r0.O00000o(r1)
                                        L_0x01ea:
                                            return
                                        L_0x01eb:
                                            _m_j.hvx$14 r0 = _m_j.hvx.AnonymousClass14.this
                                            _m_j.hvx r0 = _m_j.hvx.this
                                            r1 = 0
                                            r0.O000000o(r12, r1)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: _m_j.hvx.AnonymousClass14.AnonymousClass1.run():void");
                                    }

                                    /* access modifiers changed from: private */
                                    public /* synthetic */ void O000000o(boolean z, String str) {
                                        fbs.O000000o(new fbt(hvx.this.O000O0oo, ScanBarcodeActivity.TAG).O000000o("show_add_manully", z).O000000o("from", 500).O000000o(1000));
                                    }
                                });
                            }

                            public final void O000000o(int i, String str, Throwable th) {
                                hvx hvx = hvx.this;
                                hvx.O000000o("chooseECDH rpc, onFail code=" + i + ",result=" + str + ",throwable=" + Log.getStackTraceString(th), new Object[0]);
                                if (!hvx.this.O000OO00 && !hvx.this.O000OO0o && !hvx.this.O0000o0O) {
                                    hvx.this.O0000o();
                                }
                            }
                        });
                    } catch (Exception e) {
                        gsy.O00000Oo(LogType.KUAILIAN, "ApSecureConfigStep", Log.getStackTraceString(e));
                    }
                }

                public void H_() {
                    this.O0000o0O = false;
                    String str = (String) htr.O000000o().O000000o("ticket");
                    byte[] bArr = (byte[]) htr.O000000o().O000000o("sign");
                    O000000o("onResumeStep mCurrentIndex:" + this.O0000OoO, new Object[0]);
                    if (this.O0000OoO != 1 || bArr == null) {
                        super.H_();
                        return;
                    }
                    htr.O000000o().O00000Oo("sign");
                    if (TextUtils.isEmpty(str)) {
                        O0000oO0();
                        O0000oOO();
                        this.O0000OoO = 1;
                        return;
                    }
                    O000000o(bArr, str);
                }

                public final void O000000o(byte[] bArr, String str) {
                    if (!this.O0000o0O) {
                        e_(1);
                        this.O0000OoO = 2;
                        boolean z = false;
                        O000000o("sharekey after decode = " + gru.O000000o(bArr), new Object[0]);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            byte[] bArr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                            if (!TextUtils.isEmpty(str)) {
                                bArr2 = Base64.decode(str, 2);
                            }
                            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                            instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                            byte[] doFinal = instance.doFinal(O000OO0o().toString().getBytes());
                            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                            jSONObject.put("method", "miIO.config_router_safe");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("data", Base64.encodeToString(doFinal, 2));
                            jSONObject2.put("sign", Base64.encodeToString(fir.O000000o(bArr, doFinal), 2));
                            jSONObject.put("params", jSONObject2);
                            O000000o("start sendECDHWifi", new Object[0]);
                            hvf statResultManager = SmartConfigRouterFactory.getStatResultManager();
                            if (!TextUtils.isEmpty(this.O0000oO0)) {
                                z = true;
                            }
                            statResultManager.get_bind_key_result(z, "ApSecureConfigStep", this.O000OOOo);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(236);
                            MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                                /* class _m_j.hvx.AnonymousClass3 */

                                public final void O000000o(JSONObject jSONObject) {
                                    hvx.this.O000000o("sendECDHWifi, onSuccess", new Object[0]);
                                    if (hvx.this.x_() != null) {
                                        hvx.this.x_().sendEmptyMessageDelayed(112, 1000);
                                    }
                                }

                                public final void O000000o(int i, String str, Throwable th) {
                                    hvx.this.O000000o("sendECDHWifi, onFail:".concat(String.valueOf(str)), new Object[0]);
                                    if (!hvx.this.O000OO00 && !hvx.this.O000OO0o && !hvx.this.O0000o0O) {
                                        hvx.this.O0000oOO();
                                    }
                                }
                            }, 5000);
                            this.O00000o = true;
                        } catch (Exception e) {
                            gsy.O00000Oo(LogType.KUAILIAN, "ApSecureConfigStep", Log.getStackTraceString(e));
                        }
                    }
                }

                private boolean O000OO() {
                    if (htk.O000000o().O00000o) {
                        O000000o("startSearchNewDevice but isFindingNew ,then return", new Object[0]);
                        htk.O000000o().O00000oo = this.O00000oo;
                        return true;
                    } else if (y_() == null) {
                        O000000o("startSearchNewDevice getScanResult is null ,return", new Object[0]);
                        return false;
                    } else {
                        this.O00000Oo = false;
                        O000000o("startSearchNewDevice", new Object[0]);
                        hto hto = this.O00000oO;
                        String str = null;
                        if (hto == null) {
                            String str2 = y_() != null ? y_().BSSID : null;
                            long j = this.O0000Ooo;
                            if (j != 0) {
                                str = String.valueOf(j);
                            }
                            this.O00000oO = new hto(str2, str, this.O0000oO0, this.O000OOOo);
                        } else {
                            String str3 = y_() != null ? y_().BSSID : null;
                            long j2 = this.O0000Ooo;
                            if (j2 != 0) {
                                str = String.valueOf(j2);
                            }
                            hto.O000000o(str3, str, this.O0000oO0, this.O000OOOo);
                        }
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
                        htk.O000000o().O000000o(this.O00000oO, this.O00000o0, this.O00000oo);
                        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
                        return false;
                    }
                }

                public void O0000O0o() {
                    super.O0000O0o();
                    O000000o("onFinishStep", new Object[0]);
                    MiioLocalAPI.O000000o o000000o = this.O0000o0;
                    if (o000000o != null) {
                        o000000o.f6027O000000o = true;
                    }
                    hwb hwb = this.O0000o0o;
                    if (hwb != null) {
                        hwb.O000000o();
                        this.O0000o0o = null;
                    }
                    htk.O000000o().O00000oo = null;
                    if (!this.O0000o && this.O00O0Oo) {
                        O00oOooO();
                    }
                    htr.O000000o().O00000Oo("wifi_bind_key");
                }

                private void O000OOOo() {
                    String str;
                    String str2;
                    String str3;
                    O000000o("onStopConnection", new Object[0]);
                    x_().removeMessages(112);
                    if (gnn.O00000oO) {
                        gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
                        this.O0000ooo.bindProcessToNetwork(null);
                    }
                    if (!htk.O000000o().O00000o) {
                        String O00000Oo2 = htr.O000000o().O00000Oo();
                        String O00000o02 = htr.O000000o().O00000o0();
                        String O00000o2 = htr.O000000o().O00000o();
                        if (htt.O000000o(this.O000OOOo)) {
                            O000000o(String.valueOf(this.O0000Ooo), O00000Oo2, O00000o02, O00000o2);
                            O000000o("saveStationRouterInfo0:" + this.O0000Ooo + ", " + O00000Oo2 + ", " + O00000o2, new Object[0]);
                        }
                        if (!TextUtils.isEmpty(O00000Oo2) && htt.O00000Oo(this.O000OOOo)) {
                            String str4 = (String) htr.O000000o().O000000o("mo_xiang_station_did");
                            O000000o(str4, O00000Oo2, O00000o02, O00000o2);
                            O000000o("saveStationRouterInfo1:" + str4 + ", " + O00000Oo2 + ", " + O00000o2, new Object[0]);
                        }
                        if (!TextUtils.isEmpty(O00000Oo2) || !htt.O00000Oo(this.O000OOOo)) {
                            str3 = O00000Oo2;
                            str2 = O00000o02;
                            str = O00000o2;
                        } else {
                            String str5 = (String) htr.O000000o().O000000o("mo_xiang_station_did");
                            String O0000O0o = foc.O0000O0o("moxiang_net", "ssid".concat(String.valueOf(str5)));
                            String O0000O0o2 = foc.O0000O0o("moxiang_net", "passwd".concat(String.valueOf(str5)));
                            String O0000O0o3 = foc.O0000O0o("moxiang_net", "capabilities".concat(String.valueOf(str5)));
                            O000000o("get StationRouterInfo0:" + str5 + ", " + O0000O0o + ", " + O0000O0o3, new Object[0]);
                            str3 = O0000O0o;
                            str = O0000O0o3;
                            str2 = O0000O0o2;
                        }
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(209);
                        if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                            this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                            this.O00oOooO.O00000o0 = null;
                            this.O00oOooO = null;
                        }
                        iag.O000000o(this.O0000ooo, O0000ooO, str3, str2, null, str, null, false, true);
                    }
                }

                private static void O000000o(String str, String str2, String str3, String str4) {
                    foc.O000000o("moxiang_net", "ssid".concat(String.valueOf(str)), str2);
                    foc.O000000o("moxiang_net", "passwd".concat(String.valueOf(str)), str3);
                    foc.O000000o("moxiang_net", "capabilities".concat(String.valueOf(str)), str4);
                }

                public final void O0000oO0() {
                    O000000o("stopConnection", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                        jSONObject.put("method", "miIO.stop_diag_mode");
                        jSONObject.put("params", "");
                    } catch (JSONException unused) {
                    }
                    MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe() {
                        /* class _m_j.hvx.AnonymousClass4 */

                        public final void onResponse(String str) {
                        }
                    });
                }

                public boolean G_() {
                    O000000o("onBackPressed", new Object[0]);
                    try {
                        new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                            /* class _m_j.hvx.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (hvx.this.O000O0oo != null) {
                                    hvx.this.O000000o("onBackPressed ,user click dialog's Ok, and then stop binding.", new Object[0]);
                                    WifiManager wifiManager = (WifiManager) hvx.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                                    if (!(hvx.this.y_() == null || connectionInfo == null || !hvx.this.y_().BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                                        iag.O000000o(hvx.this.O0000ooo, ConfigStep.O0000ooO, hvx.this.O0000Oo.SSID, hvx.this.O00oOooO);
                                    }
                                    if ((hvx.this.O0000OoO == 2 || hvx.this.O0000OoO == 1) && gnn.O00000oO && hvx.this.O0000ooo != null) {
                                        hvx.this.O000000o("Bind Network to NULL", new Object[0]);
                                        hvx.this.O0000ooo.bindProcessToNetwork(null);
                                    }
                                    if (htk.O000000o().O00000o) {
                                        htk.O000000o().O00000Oo();
                                    }
                                    hvx.this.b_(false);
                                    if (!hvx.this.O000OOoO && hvx.this.O000OOo && !hvx.this.O000OOoo) {
                                        if (hvx.this.O0000OoO == 0 || (hvx.this.O0000OoO == 3 && ConfigStep.O00oOooo() && hze.O000000o(hvx.this.O000O0oo))) {
                                            hvx hvx = hvx.this;
                                            hvx.O000OOoO = true;
                                            hvx.this.O00000Oo(goj.O000000o(hvx.O0000OoO));
                                        }
                                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hvx.this.O000OOOo, 4);
                                    }
                                    SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(hvx.this.O000OOOo, hvx.this.O000OO);
                                }
                            }
                        }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }

                public final void O000000o(int i, int i2, Intent intent) {
                    if (i == 1000) {
                        O000000o("onActivityResult, request scan code come back", new Object[0]);
                        if (i2 == -1) {
                            String stringExtra = intent.getStringExtra("key_qrcode_oob");
                            if (TextUtils.isEmpty(stringExtra)) {
                                O000000o("onActivityResult, request scan code come back,but oob still empty!!", new Object[0]);
                            } else {
                                x_().sendEmptyMessageDelayed(110, 20000);
                                final byte[] bArr = (byte[]) htr.O000000o().O000000o("sign");
                                hwb hwb = this.O0000o0o;
                                if (hwb != null) {
                                    hwb.O000000o();
                                }
                                this.O0000o0o = new hwb(this.O0000Ooo, this.O0000o00, bArr, new hwb.O000000o() {
                                    /* class _m_j.hvx.AnonymousClass6 */

                                    public final void O000000o(final String str) {
                                        hvx.this.x_().post(new Runnable() {
                                            /* class _m_j.hvx.AnonymousClass6.AnonymousClass1 */

                                            public final void run() {
                                                hvx.this.O000000o(bArr, str);
                                            }
                                        });
                                    }

                                    public final void O000000o() {
                                        hvx.this.x_().post(new Runnable() {
                                            /* class _m_j.hvx.AnonymousClass6.AnonymousClass2 */

                                            public final void run() {
                                                hvx.this.O0000oO0();
                                                hvx.this.O0000oOO();
                                                hvx.this.O0000OoO = 1;
                                            }
                                        });
                                    }
                                });
                                O000000o("onActivityResult, request scan code come back,start bind", new Object[0]);
                                this.O0000o0o.O000000o(stringExtra);
                                return;
                            }
                        } else if (i2 == -3) {
                            O00000o(SmartConfigStep.Step.STEP_APSECURE_PIN_STEP);
                            return;
                        }
                        O0000oO0();
                        O000O0o();
                    }
                }
            }

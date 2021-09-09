package _m_j;

import _m_j.hvu;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hvu extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f737O000000o;
    public long O00000Oo;
    public int O00000o = 0;
    public String O00000o0;
    public long O00000oO = -1;
    public long[] O00000oo = new long[4];
    boolean O0000O0o = false;
    public String O0000OOo;
    private long O0000Oo = 50000;
    public String O0000Oo0;
    private ArrayList<gke> O0000OoO = new ArrayList<>();
    private int O0000Ooo;
    private StringBuffer O0000o = null;
    private boolean O0000o0 = false;
    private int O0000o00 = 0;
    private long[] O0000o0O = new long[4];
    private MiioLocalAPI.O000000o O0000o0o;
    private int O000OooO = 0;
    private hto O000Oooo = null;
    private htl O000o00 = new htm() {
        /* class _m_j.hvu.AnonymousClass1 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hvu.this.O000000o("step3: onDeviceConnectionSuccess :[search device success]", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvu.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            hvu hvu = hvu.this;
            hvu.O000OOo = false;
            hvu.O000OoO0 = true;
            hvu.O00000o0();
            hvu.this.O00000Oo(60);
            hvu.this.e_(3);
            iae.O000000o(hvu.this.O000Oo0);
        }

        public final void onDeviceConnectionFailure() {
            hvu.this.O000000o("step3: onDeviceConnectionFailure :[search device fail]", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvu.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            iae.O000000o(hvu.this.O000Oo0);
            hvu.this.O00000o0();
        }

        public final void onDeviceConnectionFailure(int i) {
            hvu.this.O000000o("step3: onDeviceConnectionFailure :[search device fail],error code %d", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvu.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "check failed");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            hvu.this.O00000o0();
            if (i == -6) {
                hvu.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                if (!hvu.this.O000OOoO && hvu.this.O000OOo) {
                    gsy.O000000o(6, "ApConfigStep", "DeviceFinder already bind!");
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hvu.this.O000OOOo, 3);
                }
            }
            iae.O000000o(hvu.this.O000Oo0);
        }
    };
    private int O000o000;

    public final void O00000Oo(int i) {
        if (this.O0000o == null) {
            this.O0000o = new StringBuffer(32);
            this.O0000o.append("AP");
        }
        StringBuffer stringBuffer = this.O0000o;
        stringBuffer.append("#");
        stringBuffer.append(i);
    }

    hvu() {
        this.O000Ooo = "AP_CONFIG:APConfigStep";
        htk.O000000o();
        if (htk.O00000oO() != null) {
            htk.O000000o();
            this.O00000Oo = hze.O000000o((Object) htk.O00000oO());
        }
        this.O0000o00 = ((Integer) htr.O000000o().O000000o("find_device_time", 0)).intValue();
    }

    public final void O00000o0() {
        StringBuffer stringBuffer;
        String O000000o2 = gok.O000000o(this.O00000Oo);
        if (!TextUtils.isEmpty(O000000o2) && (stringBuffer = this.O0000o) != null) {
            stringBuffer.append(O000000o2);
        }
    }

    public final void O000000o(Context context) {
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
        O000000o("createStep", new Object[0]);
    }

    public final ArrayList<gke> O0000Oo0() {
        this.O0000OoO.clear();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        if (iag.O00000Oo(this.O000O0oo)) {
            gke.O00000Oo = 50000;
        }
        this.O0000OoO.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 20000;
        this.O0000OoO.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 3;
        long O0000Oo02 = (long) (eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 50000);
        if (this.O000OOOo.startsWith("xiaomi.repeater")) {
            O0000Oo02 = "xiaomi.repeater.v6".equals(this.O000OOOo) ? 120000 : 80000;
        }
        this.O0000Oo = O0000Oo02;
        gke3.O00000Oo = O0000Oo02;
        if (htk.O000000o().O00000o) {
            long j = htk.O000000o().O0000OOo;
            long currentTimeMillis = System.currentTimeMillis();
            double d = (double) ((((currentTimeMillis - j) * 50) / O0000Oo02) + 50);
            Double.isNaN(d);
            gke3.O00000o0 = (int) (d * 0.9d);
            gke3.O00000Oo = (O0000Oo02 + j) - currentTimeMillis;
            this.f737O000000o = 3;
        }
        this.O0000o0 = ((Boolean) htr.O000000o().O000000o("goto_error_page", Boolean.FALSE)).booleanValue();
        if (this.O0000o0) {
            htr.O000000o().O00000Oo("goto_error_page", Boolean.FALSE);
            this.f737O000000o = 3;
            gke3.O00000Oo = 0;
        }
        this.O0000OoO.add(gke3);
        return this.O0000OoO;
    }

    public final hxy O00000oO(int i) {
        String str;
        hxy hxy = new hxy(Long.valueOf(this.O00000Oo), this.O000OOOo, O0000O0o(i), this.O000Oo00, this.O000OOo);
        int intValue = ((Integer) htr.O000000o().O000000o("selected_ap_level", 999)).intValue();
        ScanResult y_ = y_();
        if (y_ != null) {
            hxy.O0000O0o = y_.level;
        }
        O00000o0();
        StringBuffer stringBuffer = this.O0000o;
        String str2 = "NONE";
        if (stringBuffer != null) {
            str = stringBuffer.toString();
        } else {
            str = str2;
        }
        hxy.O00000oo = intValue;
        hxy.O0000Oo = str;
        if (this.O000Oo0 != null) {
            str2 = this.O000Oo0.SSID;
        }
        hxy.O0000Oo0 = str2;
        return hxy;
    }

    public final void O00000oo(int i) {
        hxy O00000oO2 = O00000oO(i);
        O00000oO2.O0000OoO = this.O0000oO0;
        hxi.O00000o0.O000000o(O00000oO2);
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
        this.O000OOoo = true;
        iae.O000000o(this.O000Oo0);
        if (i == 0) {
            O000000o("Step1: connect ap timeout", new Object[0]);
            this.O000OoOo = "3000.1.2";
            O00000Oo(1);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "connect ap failed");
            if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            int i2 = 1101;
            eyr.O00000Oo();
            if (TextUtils.isEmpty(this.O0000oO0)) {
                i2 = 1102;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    O00000oo(i2);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(O00000oO(i2));
            }
            x_().removeMessages(123);
            if (!TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            }
            this.O000OoOo = "3000.1.1";
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (i == 1) {
            O000000o("Step2:config router timeout", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            this.O0000O0o = true;
            O00000Oo(87);
            return null;
        } else if (i == 2) {
            O000000o("CONNECT_TO_SELECT_AP_INDEX timeout ", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "connect_mobile_network_timeout");
            return null;
        } else if (i != 3) {
            return null;
        } else {
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND, "get new device failed");
            O000000o("step3: search device timeout ", new Object[0]);
            this.O000OoOo = "3000.1.4";
            O00oOooO();
            O0000o();
            O00000Oo(57);
            if (!hze.O000000o(this.O000O0oo) || !O00oOooo()) {
                this.O000OOo = false;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    O00000oo(O0000o0o());
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 3);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(O00000oO(O0000o0o()));
            }
            if (this.O000Oooo != null) {
                htk.O000000o().O000000o(this.O000Oooo);
            } else {
                htk.O000000o().O00000Oo();
            }
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
            if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                O000000o(false, 0, (SmartConfigStep.Step) null);
                return null;
            }
            O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR);
            return null;
        }
    }

    private int O0000o0o() {
        int O000000o2;
        ScanResult y_ = y_();
        if (y_ == null || (O000000o2 = htk.O000000o().O000000o(y_.BSSID)) <= 0) {
            return 1201;
        }
        return O000000o2;
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        int i = this.f737O000000o;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_connect_device_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.kuailian_phone_connect_device_des);
            Resources resources = this.O000O0o0.getResources();
            this.O000O0o0.O000000o(resources.getString(R.string.kuailian_device_connect_wifi), resources.getString(R.string.make_device_near_router));
            this.O000O0o0.O000000o(3);
        } else if (i != 2 && i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
        }
    }

    public final void s_() {
        int i = this.f737O000000o;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(1);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, this.O000O0o0.getResources().getString(R.string.kuailian_device_connect_wifi), (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        }
    }

    private void O0000o() {
        int i = this.f737O000000o;
        if (i == 0) {
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 1) {
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 3) {
            if (!hze.O000000o(this.O000O0oo)) {
                O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.phone_wifi_error, R.drawable.common_bind_app_connect_network_failed);
            } else {
                O00000Oo(R.string.kuailian_device_connect_wifi_fail, R.string.make_device_near_router, R.drawable.common_bind_device_connect_network_failed);
            }
        }
    }

    public final void a_(SmartConfigStep.Step step) {
        if (step == SmartConfigStep.Step.STEP_CONNECT_AP_ERROR) {
            O000000o("user click retry, step1：retry connect ap", new Object[0]);
            O00000Oo(14);
        } else if (step == SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR) {
            O000000o("user click retry，step 2: retry config router", new Object[0]);
            O00000Oo(90);
        } else if (step == SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR) {
            O000000o("user click retry, step3: retry search device", new Object[0]);
            O00000Oo(68);
        }
    }

    public final void z_() {
        O000000o("reset state index to 1(connect ap)", new Object[0]);
        this.f737O000000o = 0;
        this.O00000oO = System.currentTimeMillis();
        fij.O000000o(this.O00000oo);
        this.O00000oo[this.f737O000000o] = System.currentTimeMillis();
    }

    public final int O00000Oo() {
        int i = this.f737O000000o;
        if (i != 0) {
            if (i == 1) {
                String str = ((ScanResult) htr.O000000o().O000000o("device_ap")).SSID;
                WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
                if (connectionInfo != null && iag.O000000o(str, connectionInfo.getSSID())) {
                    return ((Boolean) htr.O000000o().O000000o("send_passwd_success", Boolean.FALSE)).booleanValue() ? 3 : 1;
                }
                this.f737O000000o = 0;
            } else if (i != 2) {
                return i;
            } else {
                String O00000Oo2 = htr.O000000o().O00000Oo();
                WifiInfo connectionInfo2 = O0000ooO.getConnectionInfo();
                return (connectionInfo2 == null || !connectionInfo2.getSSID().equals(O00000Oo2)) ? 2 : 3;
            }
        }
        return 0;
    }

    public final SmartConfigStep.Step A_() {
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
        if (i != 101) {
            if (i == 112) {
                O000000o("handle message update device state", new Object[0]);
                if (x_() != null) {
                    x_().removeMessages(112);
                    x_().removeMessages(114);
                }
                if (this.f737O000000o == 1) {
                    e_(1);
                    this.f737O000000o = 3;
                    O000O0oo();
                    SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                    O0000oO();
                }
            } else if (i == 123) {
                O000000o("handle message reconnect ap", new Object[0]);
                v_();
            } else if (i == 114) {
                O000000o("handle message send MSG_SEND_DEVICE_MSG isAssoTimetout=%s", String.valueOf(this.O0000O0o), new Object[0]);
                if (this.O0000O0o) {
                    O0000o();
                    this.O000OoOo = "3000.1.3";
                    if (!this.O000OOoO && this.O000OOo) {
                        this.O000OOoO = true;
                        if (!this.O000Oo0o) {
                            O00000oo(1401);
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 2);
                    }
                    if (this.O000Oo0o) {
                        this.O000Oo0O.push(O00000oO(1401));
                    }
                    PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
                    if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                        O000000o(false, 0, (SmartConfigStep.Step) null);
                    } else {
                        O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR);
                    }
                    this.O0000O0o = false;
                } else if (this.f737O000000o == 1) {
                    w_();
                }
            } else if (i != 115) {
                super.O000000o(message);
            } else {
                O000000o("handle message disconnect timeout", new Object[0]);
                O000O0oo();
                O0000o0O();
            }
        } else if (this.O0000oo) {
            NetworkInfo networkInfo = (NetworkInfo) message.obj;
            NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            if (connectionInfo == null) {
                O000000o("handle message network changed, wifiInfo is null,then return", new Object[0]);
                return;
            }
            O000000o("handle message network changed: current Index(0:connect ap; 1:config router; 3:search device)=%d, wifi state(CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN)=%s, wifi ssid =%s", Integer.valueOf(this.f737O000000o), networkInfo.getState().name(), connectionInfo.getSSID());
            ScanResult scanResult = (ScanResult) htr.O000000o().O000000o("device_ap");
            if (scanResult == null) {
                O000000o("handle message network changed, ERROR: cache ScanResult is null, config route cloud not success", new Object[0]);
            } else {
                O000000o("handle message network changed: cache scanResult not empty", new Object[0]);
            }
            LogType logType = LogType.KUAILIAN;
            StringBuilder sb = new StringBuilder();
            sb.append(detailedState.toString());
            sb.append(", ");
            sb.append(connectionInfo);
            sb.append(", ");
            String str = "";
            sb.append(networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo() : str);
            sb.append(", ");
            if (networkInfo.getReason() != null) {
                str = networkInfo.getReason();
            }
            sb.append(str);
            gsy.O00000Oo(logType, "ApConfigStep", sb.toString());
            if (this.f737O000000o == 1 && networkInfo.getState() == NetworkInfo.State.DISCONNECTED && !this.O000OO0o && (connectionInfo == null || scanResult == null || !iag.O000000o(connectionInfo.getSSID(), scanResult.SSID))) {
                O000000o("handle message network changed, decide config router success", new Object[0]);
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("wifi_disconnect_by_device", "true");
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                x_().sendEmptyMessage(112);
            } else if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>")) {
                if (this.O000o000 > 0) {
                    hvg.O000000o(CommonApplication.getAppContext()).O000000o(this.O000o000, "ssid", connectionInfo.getSSID());
                }
                if (detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && scanResult != null && iag.O000000o(connectionInfo.getSSID(), scanResult.SSID) && this.f737O000000o == 0 && !this.O000OO0o) {
                    O000000o("handle message network changed, decide connect ap success", new Object[0]);
                    if (x_() != null) {
                        x_().postDelayed(new Runnable() {
                            /* class _m_j.hvu.AnonymousClass9 */

                            public final void run() {
                                if (hvu.this.f737O000000o == 0 && hvu.this.O000O00o()) {
                                    hvu hvu = hvu.this;
                                    hvu.e_(hvu.f737O000000o);
                                    hvu.this.x_().removeMessages(123);
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                                    hvu.this.w_();
                                    hvu hvu2 = hvu.this;
                                    hvu2.f737O000000o = 1;
                                    hvu2.O00000o++;
                                }
                            }
                        }, 2000);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* renamed from: O00000o0 */
    public final void O0000Oo0(int i) {
        boolean z;
        if (y_() == null) {
            O000000o("startConnection, but cache scanResult is null", new Object[0]);
            this.O000OOo = false;
            Handler x_ = x_();
            if (x_ != null && this.O000O0o) {
                x_.postDelayed(new Runnable(i) {
                    /* class _m_j.$$Lambda$hvu$G2NYUKHn8i5t1P3vW5BjXLGYV7s */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hvu.this.O0000Oo0(this.f$1);
                    }
                }, 2000);
                return;
            }
            return;
        }
        List<ScanResult> scanResults = O0000ooO.getScanResults();
        if (scanResults != null) {
            Iterator<ScanResult> it = scanResults.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (iag.O000000o(it.next().SSID, this.O000Oo0.SSID)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            htr.O000000o().O00000Oo("key_report_hash_mac", this.O000Oo0.BSSID);
            this.O000OOo = !z && this.O000OOo;
            if (i != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.O00000oO <= 0) {
                    this.O00000oO = currentTimeMillis;
                }
                long[] jArr = this.O00000oo;
                if (jArr[i] == 0) {
                    jArr[i] = currentTimeMillis;
                }
                O00000Oo(2);
                O000000o("start request bind key", new Object[0]);
                SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                String miId = SmartConfigRouterFactory.getCoreApiManager().getMiId();
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
                if (!TextUtils.isEmpty(this.O0000oO0)) {
                    v_();
                    return;
                } else {
                    htq.O000000o().O00000o0(this.O000OOOo, miId, new hua<JSONObject, hud>() {
                        /* class _m_j.hvu.AnonymousClass5 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            hvu.this.O000000o(" getBindKeyX onSuccess %s", jSONObject);
                            if (jSONObject == null || jSONObject.length() == 0) {
                                O000000o((hud) null);
                                return;
                            }
                            hvu.this.O0000oO = jSONObject.optLong("timestamp");
                            hvu.this.O0000oO0 = jSONObject.optString("bindKey");
                            String optString = jSONObject.optString("bindKeyIndex");
                            hvu hvu = hvu.this;
                            if ("0".equals(optString)) {
                                optString = null;
                            }
                            hvu.O0000oOO = optString;
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey_new", hvu.this.O0000oO0);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                            O000000o(4);
                        }

                        public final void O000000o(hud hud) {
                            hvu.this.O000000o(" getBindKeyX onFailure onSuccess %s", hud);
                            if (hvu.this.O000O0o && hvu.this.f737O000000o == 0) {
                                hvu.this.O000000o(new hua<String, hud>() {
                                    /* class _m_j.hvu.AnonymousClass5.AnonymousClass1 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        String str = (String) obj;
                                        hvu.this.O000000o(" getBindKey onSuccess %s", str, new Object[0]);
                                        hvu.this.O0000oO0 = str;
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey", hvu.this.O0000oO0);
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                                        AnonymousClass5.this.O000000o(4);
                                    }

                                    public final void O000000o(hud hud) {
                                        if (hud != null) {
                                            hvu.this.O000000o(" getBindKey failed,error code %d, msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", hud.O000000o());
                                        } else {
                                            hvu.this.O000000o("getBindKey failed, and error is null", new Object[0]);
                                        }
                                        hvu.this.O0000oO0 = "";
                                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1501);
                                        AnonymousClass5.this.O000000o(6);
                                    }
                                }, 2);
                            }
                        }

                        public final void O000000o(int i) {
                            hvu.this.O00000Oo(i);
                            hvu.this.v_();
                        }
                    });
                    return;
                }
            } else if (i == 1) {
                w_();
                this.O00000o++;
                return;
            } else if (i == 2) {
                O000O0oo();
                return;
            } else if (i == 3) {
                O000O0oo();
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                O0000oO();
                return;
            } else {
                return;
            }
        }
        z = false;
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O000Oo0.BSSID);
        this.O000OOo = !z && this.O000OOo;
        if (i != 0) {
        }
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hvu.AnonymousClass6 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                hvu.this.O000000o("getBindKey onSuccess,key =".concat(String.valueOf(str)), new Object[0]);
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                hvu.this.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                int i = i;
                if (i == 0) {
                    Object O000000o2 = htr.O000000o().O000000o("wifi_bind_key");
                    if (O000000o2 != null) {
                        String str = (String) O000000o2;
                        if (!TextUtils.isEmpty(str)) {
                            hvu.this.O000000o("getBindKey from local", new Object[0]);
                            hua.O000000o(str);
                            return;
                        }
                    }
                    hvu.this.O0000oOO();
                    return;
                }
                hvu.this.O000000o(hua, i - 1);
            }
        });
    }

    public final void e_(int i) {
        O0000OOo(i);
        super.e_(i);
    }

    private void O0000OOo(int i) {
        SmartConfigRouterFactory.getStatPageV2Manager().page_AP_step_success(this.O000OOOo, this.O00000Oo, goj.O000000o(i), (int) ((System.currentTimeMillis() - this.O0000o0O[i]) / 1000));
        this.O0000o0O[this.f737O000000o] = 0;
    }

    public final void v_() {
        if (this.O000Oo0 == null) {
            O000000o("startConnectToDeviceAp but scanResult is null", new Object[0]);
        } else {
            O000000o("startConnectToDeviceAp, scanResult not empty", new Object[0]);
        }
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(206);
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "ApConfigStep", "startConnectToDeviceAp:" + this.O000Oo0);
        O00000Oo(8);
        if (this.O000Oo0 != null) {
            this.O000OOOo = DeviceFactory.O0000Ooo(this.O000Oo0.SSID);
            this.O000Oo0o = eyr.O00000Oo().O000000o(this.O000OOOo);
            this.O00O0Oo = eyr.O00000Oo().O00000Oo(this.O000OOOo);
            this.f737O000000o = 0;
            String O00000o02 = gog.O00000o0(this.O000O0oo);
            this.O0000o0O[this.f737O000000o] = System.currentTimeMillis();
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            if (TextUtils.isEmpty(O00000o02) || !O00000o02.equals(this.O000Oo0.SSID) || connectionInfo == null || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                O000000o("startConnectToDeviceAp: wifi.ssid not equal scanResult.ssid, try to connect ap,current Index(expect 0)=%d", Integer.valueOf(this.f737O000000o));
                O00000Oo(12);
                if (this.O00oOooO == null || this.O00oOooO.O00000o0 == null) {
                    this.O00oOooO = new iad() {
                        /* class _m_j.hvu.AnonymousClass8 */

                        public final void O000000o(Network network) {
                            super.O000000o(network);
                            hvu hvu = hvu.this;
                            hvu.O000000o("connectToAP ok: " + hvu.this.O000Oo0.SSID, new Object[0]);
                        }

                        public final void O000000o() {
                            super.O000000o();
                            hvu.this.O000000o("connectToAP onUnavailable!", new Object[0]);
                            if (hvu.this.f737O000000o == 0) {
                                hvu.this.x_().post(new Runnable() {
                                    /* class _m_j.$$Lambda$hvu$8$ed5zRQCOK851sJHbVykjg04FrDA */

                                    public final void run() {
                                        hvu.AnonymousClass8.this.O00000o0();
                                    }
                                });
                            }
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void O00000o0() {
                            hvu.this.O0000oOO();
                        }

                        public final void O00000Oo(Network network) {
                            super.O00000Oo(network);
                            hvu.this.O000000o("connecttoAp onLost ", new Object[0]);
                            if (hvu.this.f737O000000o == 0) {
                                hvu.this.x_().post(new Runnable() {
                                    /* class _m_j.$$Lambda$hvu$8$h8w1I5OweXXUbPfULHC3cE3ypM */

                                    public final void run() {
                                        hvu.AnonymousClass8.this.O00000Oo();
                                    }
                                });
                            }
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void O00000Oo() {
                            hvu.this.O0000oOO();
                        }
                    };
                    iag.O000000o(this.O0000ooo, O0000ooO, this.O000Oo0.SSID, (DeviceFactory.O00000oO(this.O000Oo0) == DeviceFactory.AP_TYPE.AP_MIDEA || DeviceFactory.O00000oO(this.O000Oo0) == DeviceFactory.AP_TYPE.AP_MIDEA_AC) ? "12345678" : "", this.O000Oo0.BSSID, this.O000Oo0.capabilities, this.O00oOooO, true, false);
                    x_().sendEmptyMessageDelayed(123, 15000);
                    return;
                }
                return;
            }
            O000000o("startConnectToDeviceAp: wifi.ssid = scanResult.ssid, current Index(expect 0)=%d", Integer.valueOf(this.f737O000000o));
            if (x_() != null) {
                x_().post(new Runnable() {
                    /* class _m_j.hvu.AnonymousClass7 */

                    public final void run() {
                        if (hvu.this.f737O000000o != 1) {
                            hvu.this.O00000Oo(10);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
                            hvu hvu = hvu.this;
                            hvu.e_(hvu.f737O000000o);
                            hvu.this.w_();
                            hvu.this.O00000o++;
                        }
                    }
                });
                return;
            }
            return;
        }
        O00000Oo(43);
    }

    public final void w_() {
        if (TextUtils.isEmpty(this.O0000oO0)) {
            O0000oOO();
            return;
        }
        O00000Oo(80);
        gsy.O00000Oo(LogType.KUAILIAN, "ApConfigStep", "startConnectionAsso:");
        iae.O00000oo.clear();
        this.O0000Ooo = (int) (System.currentTimeMillis() / 1000);
        this.f737O000000o = 1;
        long[] jArr = this.O00000oo;
        int i = this.f737O000000o;
        if (jArr[i] == 0) {
            jArr[i] = System.currentTimeMillis();
        }
        this.O0000o0O[this.f737O000000o] = System.currentTimeMillis();
        if (gnn.O00000oO) {
            Network network = null;
            Network[] allNetworks = this.O0000ooo.getAllNetworks();
            int i2 = 0;
            while (true) {
                try {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (network == null) {
                gsy.O000000o(6, "ERROR", "Get Network ERROR");
            }
            this.O0000ooo.bindProcessToNetwork(network);
        }
        this.O0000OOo = htr.O000000o().O00000Oo();
        this.O0000Oo0 = htr.O000000o().O00000o0();
        MiioLocalAPI.O000000o o000000o = this.O0000o0o;
        if (o000000o != null) {
            o000000o.f6027O000000o = true;
        }
        if (TextUtils.isEmpty(this.O00000o0) || !eyr.O00000Oo().O00000o(this.O000OOOo)) {
            O0000oO0();
        } else if (this.O000OooO <= 4) {
            O000000o(this.O0000OOo, this.O0000Oo0);
        } else if (x_() != null) {
            x_().sendEmptyMessageDelayed(112, 1000);
        }
    }

    private void O0000oO0() {
        O000000o("start getToken", new Object[0]);
        O00000Oo(82);
        String O0000o02 = O0000o0();
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(O0000o02));
        this.O0000o0o = MiioLocalAPI.O000000o(O0000o02, new dxe() {
            /* class _m_j.hvu.AnonymousClass10 */

            public final void onResponse(final String str) {
                hvu.this.O000000o("getToken  onResponse", new Object[0]);
                if (hvu.this.x_() != null) {
                    hvu.this.x_().post(new Runnable() {
                        /* class _m_j.hvu.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            JSONObject O000000o2 = hvu.O000000o(str);
                            if (O000000o2 == null) {
                                hvu.this.O00000Oo(83);
                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1302);
                                if (hvu.this.x_() != null) {
                                    hvu.this.x_().sendEmptyMessageDelayed(114, 1000);
                                    return;
                                }
                                return;
                            }
                            hvu.this.O00000Oo = Long.valueOf(O000000o2.optString("did")).longValue();
                            hvu.this.O00000o0 = O000000o2.optString("token");
                            htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(hvu.this.O00000Oo));
                            htk.O000000o().O000000o(String.valueOf(hvu.this.O00000Oo), hvu.this.O00000o0);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("did", gnj.O000000o(String.valueOf(hvu.this.O00000Oo)));
                            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                            if (eyr.O00000Oo().O0000O0o(hvu.this.O000OOOo)) {
                                hvu hvu = hvu.this;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                                    jSONObject.put("method", "miIO.info");
                                    jSONObject.put("params", new JSONObject());
                                    hvu.O00000Oo(84);
                                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(214);
                                    MiioLocalAPI.O000000o(hvu.O0000o0(), jSONObject.toString(), hvu.O00000Oo, hvu.O00000o0, new dxe() {
                                        /* class _m_j.hvu.AnonymousClass11 */

                                        public final void onResponse(String str) {
                                            JSONObject O000000o2 = hvu.O000000o(str);
                                            if (O000000o2 != null) {
                                                hvu.this.O000Oo00 = O000000o2.optString("fw_ver");
                                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("fwversion", hvu.this.O000Oo00);
                                                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                                            } else {
                                                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                                                hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1303);
                                            }
                                            hvu.this.O000000o("async_rpc info version onResponse: ".concat(String.valueOf(str)), new Object[0]);
                                            hvu hvu = hvu.this;
                                            hvu.O000000o(hvu.O0000OOo, hvu.this.O0000Oo0);
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                hvu.this.O000000o(hvu.this.O0000OOo, hvu.this.O0000Oo0);
                            }
                        }
                    });
                }
            }
        }, 5);
    }

    public final void O000000o(String str, String str2) {
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            O000000o("setMiioRouter: but not login", new Object[0]);
            O00000Oo(81);
            b_(true);
            return;
        }
        this.O000OooO++;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.O0000Ooo);
            jSONObject.put("method", "miIO.config_router");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ssid", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject2.put("passwd", str2);
            jSONObject2.put("uid", Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()));
            jSONObject2.put("bind_key", this.O0000oO0);
            if (!TextUtils.isEmpty(this.O0000oOO) && this.O0000oO > 0) {
                jSONObject2.put("bind_index", this.O0000oOO);
                jSONObject2.put("bind_ts", this.O0000oO);
                O000000o("bind_ts: " + this.O0000oO + "bindkey_index:" + this.O0000oOO, new Object[0]);
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
            gsy.O00000Oo("ApConfigStep", "WifiConfigJson : " + jSONObject3.toString());
            jSONObject2.put("gmt_offset", (Integer) htr.O000000o().O000000o("gmt_offset", 28800));
            jSONObject2.put("tz", htr.O000000o().O000000o("gmt_tz", ""));
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, "ApConfigStep", "setMiioRouter json error:" + Log.getStackTraceString(e));
        }
        String jSONObject4 = jSONObject.toString();
        O000000o("start config router, ssid: ".concat(String.valueOf(str)), new Object[0]);
        O00000Oo(86);
        String O0000o02 = O0000o0();
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(208);
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(O0000o02));
        SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "ApConfigStep", this.O000OOOo);
        MiioLocalAPI.O000000o(O0000o02, jSONObject4, this.O00000Oo, this.O00000o0, new dxe() {
            /* class _m_j.hvu.AnonymousClass12 */

            public final void onResponse(String str) {
                hvu.this.O000000o("async_rpc device return data: ".concat(String.valueOf(str)), new Object[0]);
                if (hvu.O000000o(str) == null) {
                    hvu.this.O00000Oo(85);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", str);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1402);
                    if (hvu.this.x_() != null) {
                        hvu.this.x_().sendEmptyMessageDelayed(114, 1000);
                        return;
                    }
                } else {
                    hvu.this.O0000o0O();
                    iae.O000000o(hvu.this.O000Oo0);
                }
                hvu.this.O00000Oo(88);
                if (hvu.this.x_() != null) {
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                    hvu.this.x_().sendEmptyMessageDelayed(112, 1000);
                }
            }
        });
    }

    private boolean O0000oO() {
        O000000o("startSearchNewDevice", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        this.f737O000000o = 3;
        long[] jArr = this.O00000oo;
        int i = this.f737O000000o;
        if (jArr[i] == 0) {
            jArr[i] = currentTimeMillis;
        }
        this.O0000o0O[this.f737O000000o] = currentTimeMillis;
        O00000Oo(40);
        if (htk.O000000o().O00000o) {
            O000000o("startSearchNewDevice: isFinding device,then return", new Object[0]);
            htk.O000000o().O00000oo = this.O000o00;
            O00000Oo(41);
            return true;
        } else if (this.O000Oo0 == null) {
            O00000Oo(43);
            O000000o("startSearchNewDevice: scanResult is null,then return!!!", new Object[0]);
            return false;
        } else {
            this.O0000o0 = false;
            hto hto = this.O000Oooo;
            String str = null;
            if (hto == null) {
                String str2 = this.O000Oo0 != null ? this.O000Oo0.BSSID : null;
                long j = this.O00000Oo;
                if (j != 0) {
                    str = String.valueOf(j);
                }
                this.O000Oooo = new hto(str2, str, this.O0000oO0, this.O000OOOo);
            } else {
                String str3 = this.O000Oo0 != null ? this.O000Oo0.BSSID : null;
                long j2 = this.O00000Oo;
                if (j2 != 0) {
                    str = String.valueOf(j2);
                }
                hto.O000000o(str3, str, this.O0000oO0, this.O000OOOo);
            }
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
            htk.O000000o().O000000o(this.O000Oooo, this.O0000Oo, this.O000o00);
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
            this.O0000o00++;
            return false;
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        MiioLocalAPI.O000000o o000000o = this.O0000o0o;
        if (o000000o != null) {
            o000000o.f6027O000000o = true;
        }
        O000000o("onFinishStep", new Object[0]);
        htk.O000000o().O00000oo = null;
        if (!this.O000OoO0 && this.O00O0Oo) {
            O00oOooO();
        }
        htr.O000000o().O00000Oo("wifi_bind_key");
    }

    private void O000O0oo() {
        x_().removeMessages(112);
        x_().removeMessages(114);
        O000000o("onStopConnection", new Object[0]);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000ooo.bindProcessToNetwork(null);
        }
        if (!htk.O000000o().O00000o) {
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            String O00000o2 = htr.O000000o().O00000o();
            this.O000o000 = hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(209);
            if (Build.VERSION.SDK_INT >= 29 && iag.O000000o(this.O000O0oo) && this.O00oOooO != null && this.O00oOooO.O00000o0 != null) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            iag.O000000o(this.O0000ooo, O0000ooO, O00000Oo2, O00000o02, null, O00000o2, null, false, true);
        }
    }

    public static JSONObject O000000o(String str) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (AnonymousClass4.f745O000000o[ErrorCode.valueof(jSONObject.optInt("code")).ordinal()] != 1) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("result", optJSONArray);
            }
            return optJSONObject == null ? jSONObject : optJSONObject;
        } catch (JSONException e) {
            LogType logType = LogType.KUAILIAN;
            gsy.O00000Oo(logType, "ApConfigStep", "parseRpcResponse: " + Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: _m_j.hvu$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f745O000000o = new int[ErrorCode.values().length];

        static {
            try {
                f745O000000o[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O0000o0O() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.O0000Ooo);
            jSONObject.put("method", "miIO.stop_diag_mode");
            jSONObject.put("params", "");
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O00000Oo, this.O00000o0, new dxe() {
            /* class _m_j.hvu.AnonymousClass2 */

            public final void onResponse(String str) {
            }
        });
    }

    public final boolean G_() {
        O000000o("onBackPressed", new Object[0]);
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hvu.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (hvu.this.O000O0oo != null) {
                        hvu.this.O000000o("onBackPressed show dialog,user click btn ok to stop config ap", new Object[0]);
                        WifiManager wifiManager = (WifiManager) hvu.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                        WifiInfo wifiInfo = null;
                        if (wifiManager != null) {
                            wifiInfo = wifiManager.getConnectionInfo();
                        }
                        if (!(hvu.this.O000Oo0 == null || wifiInfo == null || !hvu.this.O000Oo0.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                            iag.O000000o(hvu.this.O0000ooo, ConfigStep.O0000ooO, hvu.this.O000Oo0.SSID, hvu.this.O00oOooO);
                        }
                        iae.O000000o(hvu.this.O000Oo0);
                        if (htk.O000000o().O00000o) {
                            htk.O000000o().O00000Oo();
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(hvu.this.O000OOOo, hvu.this.O000OO);
                        int O000000o2 = goj.O000000o(hvu.this.f737O000000o);
                        if (!goj.O000000o((int) ((System.currentTimeMillis() - hvu.this.O00000oo[hvu.this.f737O000000o]) / 1000), hvu.this.f737O000000o)) {
                            hvu.this.O000OOo = false;
                        }
                        if (hvu.this.f737O000000o == 3 && (!ConfigStep.O00oOooo() || !hze.O000000o(hvu.this.O000O0oo))) {
                            hvu.this.O000OOo = false;
                        }
                        if (!hvu.this.O000OOoO && hvu.this.O000OOo && !hvu.this.O000OOoo) {
                            hvu hvu = hvu.this;
                            hvu.O000OOoO = true;
                            if (!hvu.O000Oo0o) {
                                hvu.this.O00000oo(O000000o2);
                            }
                        }
                        if (hvu.this.O000Oo0o && hvu.this.O000Oo0O.isEmpty()) {
                            hvu.this.O000Oo0O.push(hvu.this.O00000oO(O000000o2));
                        }
                        hvu.this.b_(false);
                    }
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}

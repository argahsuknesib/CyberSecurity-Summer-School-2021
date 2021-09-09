package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
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
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hvv extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f752O000000o;
    public long[] O00000Oo = new long[4];
    private long O00000o = 50000;
    private long O00000o0 = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    private ArrayList<gke> O00000oO = new ArrayList<>();
    private long O00000oo;
    private String O0000O0o;
    private boolean O0000OOo = false;
    private long[] O0000Oo = new long[4];
    private long O0000Oo0 = -1;
    private gjo O0000OoO;
    private htm O0000Ooo = new htm() {
        /* class _m_j.hvv.AnonymousClass1 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hvv.this.O000000o("step3: onDeviceConnectionSuccess :[search device success]", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvv.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            hvv hvv = hvv.this;
            hvv.O000OOo = false;
            hvv.O000OoO0 = true;
            hvv.e_(3);
            iae.O000000o(hvv.this.O000Oo0);
        }

        public final void onDeviceConnectionFailure() {
            hvv.this.O000000o("step3: onDeviceConnectionFailure :[search device fail]", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvv.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            iae.O000000o(hvv.this.O000Oo0);
        }

        public final void onDeviceConnectionFailure(int i) {
            hvv.this.O000000o("step3: onDeviceConnectionFailure :[search device fail],error code %d", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvv.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "check failed");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (i == -6) {
                hvv.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                if (!hvv.this.O000OOoO && hvv.this.O000OOo) {
                    gsy.O000000o(6, "ApConfigV2Step", "DeviceFinder already bind!");
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hvv.this.O000OOOo, 3);
                }
            }
            iae.O000000o(hvv.this.O000Oo0);
        }
    };

    hvv() {
        this.O000Ooo = "ApConfigV2Step";
        htk.O000000o();
        if (htk.O00000oO() != null) {
            htk.O000000o();
            this.O00000oo = hze.O000000o((Object) htk.O00000oO());
        }
    }

    public final void O000000o(Context context) {
        O000000o("createStep", new Object[0]);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
    }

    public final ArrayList<gke> O0000Oo0() {
        this.O00000oO.clear();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        if (iag.O00000Oo(this.O000O0oo)) {
            gke.O00000Oo = 50000;
        }
        this.O00000o0 = gke.O00000Oo;
        this.O00000oO.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 20000;
        this.O00000oO.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 3;
        this.O00000o = (long) (eyr.O00000Oo().O0000Oo0(this.O000OOOo) + 50000);
        if (this.O000OOOo.startsWith("xiaomi.repeater")) {
            if ("xiaomi.repeater.v6".equals(this.O000OOOo)) {
                this.O00000o = 120000;
            } else {
                this.O00000o = 80000;
            }
        }
        gke3.O00000Oo = this.O00000o;
        if (htk.O000000o().O00000o) {
            long j = htk.O000000o().O0000OOo;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.O00000o;
            double d = (double) ((((currentTimeMillis - j) * 50) / j2) + 50);
            Double.isNaN(d);
            gke3.O00000o0 = (int) (d * 0.9d);
            gke3.O00000Oo = (j2 + j) - currentTimeMillis;
            this.f752O000000o = 3;
        }
        this.O0000OOo = ((Boolean) htr.O000000o().O000000o("goto_error_page", Boolean.FALSE)).booleanValue();
        if (this.O0000OOo) {
            htr.O000000o().O00000Oo("goto_error_page", Boolean.FALSE);
            this.f752O000000o = 3;
            gke3.O00000Oo = 0;
        }
        this.O00000oO.add(gke3);
        return this.O00000oO;
    }

    public final hxy O00000Oo(int i) {
        hxy hxy = new hxy(Long.valueOf(this.O00000oo), this.O000OOOo, O0000O0o(i), this.O000Oo00, this.O000OOo);
        int intValue = ((Integer) htr.O000000o().O000000o("selected_ap_level", 999)).intValue();
        ScanResult y_ = y_();
        if (y_ != null) {
            hxy.O0000O0o = y_.level;
        }
        hxy.O00000oo = intValue;
        hxy.O0000Oo0 = this.O000Oo0 == null ? "NONE" : this.O000Oo0.SSID;
        return hxy;
    }

    public final void O00000oO(int i) {
        hxy O00000Oo2 = O00000Oo(i);
        O00000Oo2.O0000OoO = this.O0000oO0;
        hxi.O00000o0.O000000o(O00000Oo2);
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
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "connect ap failed");
            int i2 = 1101;
            if (TextUtils.isEmpty(this.O0000oO0)) {
                i2 = 1102;
                if (!TextUtils.isEmpty((String) htr.O000000o().O000000o("wifi_bind_key"))) {
                    i2 = 1103;
                }
            } else if (System.currentTimeMillis() - this.O0000oOo < this.O00000o0) {
                i2 = 1104;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    O00000oO(i2);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(O00000Oo(i2));
            }
            eyr.O00000Oo();
            if (!TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            }
            this.O000OoOo = "3000.1.1";
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (i == 1) {
            O000000o("Step2:config router timeout", new Object[0]);
            if (TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            O0000o();
            this.O000OoOo = "3000.1.3";
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    O00000oO(1401);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 2);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(O00000Oo(1401));
            }
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
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
            O000000o("step3: search device timeout ", new Object[0]);
            this.O000OoOo = "3000.1.4";
            O00oOooO();
            O0000o();
            if (!hze.O000000o(this.O000O0oo) || !O00oOooo()) {
                this.O000OOo = false;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    O00000oO(O0000o0o());
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 3);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(O00000Oo(O0000o0o()));
            }
            PluginDeviceInfo pluginInfo2 = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(DeviceFactory.O00000Oo(this.O000Oo0));
            if (pluginInfo2 == null || pluginInfo2.O0000ooO() == 0) {
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
        int i = this.f752O000000o;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_connect_device_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.kuailian_phone_connect_device_des);
            Resources resources = this.O000O0o0.getResources();
            this.O000O0o0.O000000o(resources.getString(R.string.kuailian_device_connect_wifi), resources.getString(R.string.make_device_near_router));
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
        }
    }

    public final void s_() {
        int i = this.f752O000000o;
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
        int i = this.f752O000000o;
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
        } else if (step == SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR) {
            O000000o("user click retry，step 2: retry config router", new Object[0]);
        } else if (step == SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR) {
            O000000o("user click retry, step3: retry search device", new Object[0]);
        }
    }

    public final void z_() {
        O000000o("reset state index to 1(connect ap)", new Object[0]);
        this.f752O000000o = 0;
        this.O0000Oo0 = System.currentTimeMillis();
        fij.O000000o(this.O00000Oo);
        this.O00000Oo[this.f752O000000o] = System.currentTimeMillis();
    }

    public final int O00000Oo() {
        int i = this.f752O000000o;
        if (i != 0) {
            if (i != 1) {
                return i;
            }
            String str = ((ScanResult) htr.O000000o().O000000o("device_ap")).SSID;
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            if (connectionInfo == null || !iag.O000000o(str, connectionInfo.getSSID())) {
                this.f752O000000o = 0;
            } else if (((Boolean) htr.O000000o().O000000o("send_passwd_success", Boolean.FALSE)).booleanValue()) {
                return 3;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_AP_CONFIG_STEP_V2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x012b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0131  */
    /* renamed from: O00000o0 */
    public final void O00000oo(int i) {
        boolean z;
        int i2 = i;
        if (y_() == null) {
            O000000o("startConnection, but cache scanResult is null", new Object[0]);
            this.O000OOo = false;
            Handler x_ = x_();
            if (x_ != null && this.O000O0o) {
                x_.postDelayed(new Runnable(i2) {
                    /* class _m_j.$$Lambda$hvv$IDm59CPPwtAeHtUGhYiquHwRXrk */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        hvv.this.O00000oo(this.f$1);
                    }
                }, 2000);
                return;
            }
            return;
        }
        if (this.O0000OoO == null) {
            this.O0000OoO = new gjo();
            gjo gjo = this.O0000OoO;
            Context context = this.O000O0oo;
            ArrayList<gke> arrayList = this.O00000oO;
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            long longValue = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
            String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
            String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
            if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                countryCode = "CN";
            }
            int intValue = ((Integer) htr.O000000o().O000000o("gmt_offset", 28800)).intValue();
            gkd gkd = new gkd();
            gkd.f17942O000000o = this.O000O0oo;
            gkd.O00000o = O00000Oo2;
            gkd.O00000oO = O00000o02;
            gkd.O00000oo = htr.O000000o().O00000o();
            gkd.O00000o0 = longValue;
            gkd.O00000Oo = this.O000OOOo;
            gkd.O0000O0o = this.O0000oo0.type;
            gkd.O0000OOo = countryDomain;
            gkd.O0000Oo0 = countryCode;
            gkd.O0000Oo = intValue;
            gkd.O0000OoO = (String) htr.O000000o().O000000o("gmt_tz", "");
            gkd.O0000Ooo = (String) htr.O000000o().O000000o("wifi_bind_key");
            gkd.O0000o00 = this.O000Oo0;
            gkd.O0000o0 = this.O0000Ooo;
            gjo.O000000o(context, arrayList, gkd);
            this.O0000OoO.O000000o(this);
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
            if (i2 != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.O0000Oo0 <= 0) {
                    this.O0000Oo0 = currentTimeMillis;
                }
                long[] jArr = this.O00000Oo;
                if (jArr[i2] == 0) {
                    jArr[i2] = currentTimeMillis;
                }
                O000000o("start request bind key", new Object[0]);
                SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
            } else if (!(i2 == 1 || i2 == 3)) {
                return;
            }
            this.O0000OoO.O000000o(0, (Bundle) null);
        }
        z = false;
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O000Oo0.BSSID);
        this.O000OOo = !z && this.O000OOo;
        if (i2 != 0) {
        }
        this.O0000OoO.O000000o(0, (Bundle) null);
    }

    public final void O0000O0o() {
        super.O0000O0o();
        O000000o("onFinishStep", new Object[0]);
        gjo gjo = this.O0000OoO;
        if (gjo != null) {
            gjo.O00000oO();
        }
        if (!this.O000OoO0 && this.O00O0Oo) {
            O00oOooO();
        }
        htr.O000000o().O00000Oo("wifi_bind_key");
    }

    public final boolean G_() {
        O000000o("onBackPressed", new Object[0]);
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hvv.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (hvv.this.O000O0oo != null) {
                        hvv.this.O000000o("onBackPressed show dialog,user click btn ok to stop config ap", new Object[0]);
                        iae.O000000o(hvv.this.O000Oo0);
                        SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(hvv.this.O000OOOo, hvv.this.O000OO);
                        int O000000o2 = goj.O000000o(hvv.this.f752O000000o);
                        if (!goj.O000000o((int) ((System.currentTimeMillis() - hvv.this.O00000Oo[hvv.this.f752O000000o]) / 1000), hvv.this.f752O000000o)) {
                            hvv.this.O000OOo = false;
                        }
                        if (hvv.this.f752O000000o == 3 && (!ConfigStep.O00oOooo() || !hze.O000000o(hvv.this.O000O0oo))) {
                            hvv.this.O000OOo = false;
                        }
                        if (!hvv.this.O000OOoO && hvv.this.O000OOo && !hvv.this.O000OOoo) {
                            hvv hvv = hvv.this;
                            hvv.O000OOoO = true;
                            if (!hvv.O000Oo0o) {
                                hvv.this.O00000oO(O000000o2);
                            }
                        }
                        if (hvv.this.O000Oo0o && hvv.this.O000Oo0O.isEmpty()) {
                            hvv.this.O000Oo0O.push(hvv.this.O00000Oo(O000000o2));
                        }
                        hvv.this.b_(false);
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
        SmartConfigRouterFactory.getStatPageV2Manager().page_AP_step_success(this.O000OOOo, this.O00000oo, goj.O000000o(i), (int) ((System.currentTimeMillis() - this.O0000Oo[i]) / 1000));
        this.O0000Oo[this.f752O000000o] = 0;
        super.e_(i);
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i != 1000) {
            switch (i) {
                case 100:
                    return;
                case 101:
                    if (bundle != null) {
                        this.O0000oO0 = bundle.getString("bindkey");
                        if (bundle.getInt("error_code") == 0) {
                            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("bindkey", this.O0000oO0);
                            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                            return;
                        }
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1501);
                        return;
                    }
                    return;
                case 102:
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(206);
                    LogType logType = LogType.KUAILIAN;
                    gsy.O00000Oo(logType, "ApConfigV2Step", "startConnectToDeviceAp:" + this.O000Oo0);
                    if (this.O000Oo0 != null) {
                        this.O000OOOo = DeviceFactory.O0000Ooo(this.O000Oo0.SSID);
                        this.O000Oo0o = eyr.O00000Oo().O000000o(this.O000OOOo);
                        this.O00O0Oo = eyr.O00000Oo().O00000Oo(this.O000OOOo);
                        this.f752O000000o = 0;
                        gog.O00000o0(this.O000O0oo);
                        this.O0000Oo[this.f752O000000o] = System.currentTimeMillis();
                        return;
                    }
                    return;
                case 103:
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                    e_(this.f752O000000o);
                    this.f752O000000o = 1;
                    return;
                case 104:
                    iae.O00000oo.clear();
                    this.f752O000000o = 1;
                    long[] jArr = this.O00000Oo;
                    int i2 = this.f752O000000o;
                    if (jArr[i2] == 0) {
                        jArr[i2] = System.currentTimeMillis();
                    }
                    this.O0000Oo[this.f752O000000o] = System.currentTimeMillis();
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
                    return;
                case 105:
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt("error_code") == 0) {
                        this.O00000oo = Long.valueOf(bundle.getString("did")).longValue();
                        this.O0000O0o = bundle.getString("token");
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("did", gnj.O000000o(String.valueOf(this.O00000oo)));
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        return;
                    }
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1302);
                    return;
                case 106:
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(214);
                    return;
                case 107:
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt("error_code") == 0) {
                        this.O000Oo00 = bundle.getString("fw_ver");
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("fwversion", this.O000Oo00);
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        return;
                    }
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1303);
                    return;
                case 108:
                    String O0000o0 = O0000o0();
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(208);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(O0000o0));
                    SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "ApConfigV2Step", this.O000OOOo);
                    return;
                case 109:
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt("error_code") == 0) {
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        return;
                    }
                    iae.O000000o(this.O000Oo0);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1402);
                    return;
                case 110:
                    O000000o("startSearchNewDevice", new Object[0]);
                    if (this.f752O000000o == 1) {
                        e_(1);
                        this.f752O000000o = 3;
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f752O000000o = 3;
                    long[] jArr2 = this.O00000Oo;
                    int i3 = this.f752O000000o;
                    if (jArr2[i3] == 0) {
                        jArr2[i3] = currentTimeMillis;
                    }
                    this.O0000Oo[this.f752O000000o] = currentTimeMillis;
                    if (!htk.O000000o().O00000o) {
                        this.O0000OOo = false;
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
                        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            O0000oOO();
        }
    }
}

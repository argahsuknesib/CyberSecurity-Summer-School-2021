package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.tencent.mmkv.MMKV;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hvy extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f789O000000o;
    protected long O00000Oo;
    public boolean O00000o = false;
    protected String O00000o0;
    private ScanResult O00000oO;
    private ArrayList<gke> O00000oo = new ArrayList<>();
    private long O0000O0o = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    private long O0000OOo = 50000;
    private gjp O0000Oo;
    private boolean O0000Oo0 = false;
    private boolean O0000OoO;
    private hto O0000Ooo = null;
    private htm O0000o00 = new htm() {
        /* class _m_j.hvy.AnonymousClass1 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hvy.this.O000000o("DeviceFinderCallback onDeviceConnectionSuccess", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvy.this.O000OOOo, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            hvy hvy = hvy.this;
            hvy.O000OOo = false;
            hvy.O00000o = true;
            hvy.e_(3);
        }

        public final void onDeviceConnectionFailure() {
            hvy.this.O000000o("DeviceFinderCallback onDeviceConnectionFailure", new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvy.this.O000OOOo, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
        }

        public final void onDeviceConnectionFailure(int i) {
            hvy.this.O000000o("DeviceFinderCallback onDeviceConnectionFailure code %d=", Integer.valueOf(i));
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hvy.this.O000OOOo, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (i == -6) {
                hvy.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
            }
        }
    };

    hvy() {
        htk.O000000o();
        if (htk.O00000oO() != null) {
            htk.O000000o();
            this.O00000Oo = Long.valueOf(htk.O00000oO()).longValue();
        }
        this.O000Ooo = "ApSecureConfigV2Step";
    }

    public final void O000000o(Context context) {
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.O000OOOo);
        O000000o("create step", new Object[0]);
    }

    public final ArrayList<gke> O0000Oo0() {
        this.O00000oo.clear();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000o0 = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        if (iag.O00000Oo(this.O000O0oo)) {
            gke.O00000Oo = 50000;
        }
        this.O0000O0o = gke.O00000Oo;
        this.O00000oo.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 20000;
        this.O00000oo.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = 20000;
        this.O00000oo.add(gke3);
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
            this.f789O000000o = 3;
        }
        this.O0000Oo0 = ((Boolean) htr.O000000o().O000000o("goto_error_page", Boolean.FALSE)).booleanValue();
        if (this.O0000Oo0) {
            htr.O000000o().O00000Oo("goto_error_page", Boolean.FALSE);
            this.f789O000000o = 3;
            gke4.O00000Oo = 0;
        }
        this.O0000OOo = gke4.O00000Oo;
        this.O00000oo.add(gke4);
        return this.O00000oo;
    }

    public final void O00000Oo(int i) {
        hxy hxy = new hxy(Long.valueOf(this.O00000Oo), this.O000OOOo, O0000O0o(i), this.O000Oo00, true);
        hxy.O0000OoO = this.O0000oO0;
        SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
     candidates:
      _m_j.hvy.O000000o(int, int, android.content.Intent):void
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
      _m_j.hvy.O000000o(int, int, android.content.Intent):void
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
        this.O0000OoO = true;
        this.O000OOoo = true;
        if (i == 0) {
            O000000o("connect ap timeout", new Object[0]);
            this.O000OoOo = "3000.1.2";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "connect ap failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i3 = 1101;
                if (TextUtils.isEmpty(this.O0000oO0)) {
                    i3 = 1102;
                    if (!TextUtils.isEmpty((String) htr.O000000o().O000000o("wifi_bind_key"))) {
                        i3 = 1103;
                    }
                } else if (System.currentTimeMillis() - this.O0000oOo < this.O0000O0o) {
                    i3 = 1104;
                }
                O00000Oo(i3);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 1);
            }
            eyr.O00000Oo();
            if (!TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_CONNECT_AP_ERROR;
            }
            this.O000OoOo = "3000.1.1";
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (i == 1 || i == 2) {
            if (TextUtils.isEmpty(this.O0000oO0)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            O000000o("config ap timeout", new Object[0]);
            this.O000OoOo = "3000.1.3";
            O0000o0o();
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
            O0000o0o();
            if (!this.O000OOoO && this.O000OOo && hze.O000000o(this.O000O0oo) && O00oOooo()) {
                this.O000OOoO = true;
                ScanResult y_ = y_();
                if (y_ == null || (i2 = htk.O000000o().O000000o(y_.BSSID)) <= 0) {
                    i2 = 1201;
                }
                O00000Oo(i2);
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.O000OOOo, 3);
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
        int i = this.f789O000000o;
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
        int i = this.f789O000000o;
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

    private void O0000o0o() {
        int i = this.f789O000000o;
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
        this.O00000Oo = 0;
        this.O00000o0 = null;
        this.f789O000000o = 0;
    }

    public final int O00000Oo() {
        int i = this.f789O000000o;
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
        if (this.O00000oO == null) {
            this.O00000oO = (ScanResult) htr.O000000o().O000000o("device_ap");
        }
        if (this.O00000oO != null) {
            O000000o("getScanResult: not empty", new Object[0]);
        } else {
            O000000o("getScanResult is null", new Object[0]);
        }
        return this.O00000oO;
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_SECURITY_AP_CONFIG_V2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    public final void O00000o0(int i) {
        boolean z;
        boolean z2;
        String str;
        String str2;
        String countryCode;
        int i2 = i;
        O000000o("startConnection index %d", Integer.valueOf(i));
        if (i2 == 0) {
            z_();
            if (this.O0000Oo == null) {
                this.O0000Oo = new gjp();
                gjp gjp = this.O0000Oo;
                Context context = this.O000O0oo;
                ArrayList<gke> arrayList = this.O00000oo;
                if (htt.O000000o(this.O000OOOo)) {
                    int O00000Oo2 = MMKV.O000000o().O00000Oo("moxiang_connection_mode", -1);
                    MMKV.O000000o().remove("moxiang_connection_mode");
                    if (O00000Oo2 == 1) {
                        z2 = true;
                        if (!z2) {
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
                        long longValue = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
                        String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
                        countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
                        if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
                            countryCode = "CN";
                        }
                        int intValue = ((Integer) htr.O000000o().O000000o("gmt_offset", 28800)).intValue();
                        gkd gkd = new gkd();
                        gkd.f17942O000000o = this.O000O0oo;
                        gkd.O00000o = str2;
                        gkd.O00000oO = str;
                        gkd.O00000oo = htr.O000000o().O00000o();
                        gkd.O00000o0 = longValue;
                        gkd.O00000Oo = this.O000OOOo;
                        gkd.O0000O0o = this.O0000oo0.type;
                        gkd.O0000OOo = countryDomain;
                        gkd.O0000Oo0 = countryCode;
                        gkd.O0000Oo = intValue;
                        gkd.O0000OoO = (String) htr.O000000o().O000000o("gmt_tz", "");
                        gkd.O0000Ooo = (String) htr.O000000o().O000000o("wifi_bind_key");
                        gkd.O0000o00 = this.O00000oO;
                        gkd.O0000o0 = this.O0000o00;
                        gkd.O0000oO0 = (String) htr.O000000o().O000000o("mo_xiang_static_key", "");
                        gkd.O0000oO = (String) htr.O000000o().O000000o("mo_xiang_key_num", "");
                        gjp.O000000o(context, arrayList, gkd);
                        this.O0000Oo.O000000o(this);
                    }
                }
                z2 = false;
                if (!z2) {
                }
                long longValue2 = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
                String countryDomain2 = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
                countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
                countryCode = "CN";
                int intValue2 = ((Integer) htr.O000000o().O000000o("gmt_offset", 28800)).intValue();
                gkd gkd2 = new gkd();
                gkd2.f17942O000000o = this.O000O0oo;
                gkd2.O00000o = str2;
                gkd2.O00000oO = str;
                gkd2.O00000oo = htr.O000000o().O00000o();
                gkd2.O00000o0 = longValue2;
                gkd2.O00000Oo = this.O000OOOo;
                gkd2.O0000O0o = this.O0000oo0.type;
                gkd2.O0000OOo = countryDomain2;
                gkd2.O0000Oo0 = countryCode;
                gkd2.O0000Oo = intValue2;
                gkd2.O0000OoO = (String) htr.O000000o().O000000o("gmt_tz", "");
                gkd2.O0000Ooo = (String) htr.O000000o().O000000o("wifi_bind_key");
                gkd2.O0000o00 = this.O00000oO;
                gkd2.O0000o0 = this.O0000o00;
                gkd2.O0000oO0 = (String) htr.O000000o().O000000o("mo_xiang_static_key", "");
                gkd2.O0000oO = (String) htr.O000000o().O000000o("mo_xiang_key_num", "");
                gjp.O000000o(context, arrayList, gkd2);
                this.O0000Oo.O000000o(this);
            }
            List<ScanResult> scanResults = O0000ooO.getScanResults();
            if (scanResults != null) {
                Iterator<ScanResult> it = scanResults.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (iag.O000000o(it.next().SSID, this.O00000oO.SSID)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.O000OOo = !z && this.O000OOo;
                SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
            }
            z = false;
            this.O000OOo = !z && this.O000OOo;
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
        } else if (!(i2 == 1 || i2 == 2 || i2 == 3)) {
            return;
        }
        this.O0000Oo.O000000o(0, (Bundle) null);
    }

    public final void H_() {
        this.O0000OoO = false;
        O000000o("onResumeStep mCurrentIndex:" + this.f789O000000o, new Object[0]);
        byte[] bArr = (byte[]) htr.O000000o().O000000o("sign");
        if (this.f789O000000o != 1 || bArr == null) {
            super.H_();
        } else {
            this.O0000Oo.O00000oo();
        }
    }

    public final void O0000O0o() {
        super.O0000O0o();
        gjp gjp = this.O0000Oo;
        if (gjp != null) {
            gjp.O00000oO();
        }
        O000000o("onFinishStep", new Object[0]);
        if (!this.O00000o && this.O00O0Oo) {
            O00oOooO();
        }
        htr.O000000o().O00000Oo("wifi_bind_key");
    }

    private static void O000000o(String str, String str2, String str3, String str4) {
        foc.O000000o("moxiang_net", "ssid".concat(String.valueOf(str)), str2);
        foc.O000000o("moxiang_net", "passwd".concat(String.valueOf(str)), str3);
        foc.O000000o("moxiang_net", "capabilities".concat(String.valueOf(str)), str4);
    }

    public final void O000000o(int i, Bundle bundle) {
        O000000o("onMessageArrived: " + i + ", mCurrentIndex: " + this.f789O000000o, new Object[0]);
        if (i != 1000) {
            switch (i) {
                case 100:
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(203);
                    return;
                case 101:
                    if (bundle != null) {
                        String string = bundle.getString("bindkey");
                        if (!TextUtils.isEmpty(string)) {
                            this.O0000oO0 = string;
                        }
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
                    return;
                case 103:
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("is_already_connected", "true");
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                    e_(this.f789O000000o);
                    this.f789O000000o = 1;
                    return;
                case 104:
                    if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
                        O000000o("getToken ,but user not login", new Object[0]);
                        b_(true);
                        return;
                    }
                    this.f789O000000o = 1;
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(207);
                    return;
                case 105:
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt("error_code") == 0) {
                        this.O00000Oo = Long.valueOf(bundle.getString("did")).longValue();
                        this.O00000o0 = bundle.getString("token");
                        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("did", gnj.O000000o(String.valueOf(this.O00000Oo)));
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
                    this.f789O000000o = 1;
                    e_(1);
                    this.f789O000000o = 2;
                    String O0000o0 = O0000o0();
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(208);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("ip_address", gnj.O000000o(O0000o0));
                    SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O0000oO0), "ApSecureConfigV2Step", this.O000OOOo);
                    return;
                case 109:
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt("error_code") == 0) {
                        hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
                        return;
                    }
                    iae.O000000o(this.O00000oO);
                    hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1402);
                    return;
                case 110:
                    if (this.f789O000000o == 2) {
                        e_(2);
                    }
                    this.f789O000000o = 3;
                    SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                    this.O0000Oo0 = false;
                    hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
                    SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_CHECK_BIND);
                    String O00000Oo2 = htr.O000000o().O00000Oo();
                    String O00000o02 = htr.O000000o().O00000o0();
                    String O00000o2 = htr.O000000o().O00000o();
                    if (htt.O000000o(this.O000OOOo)) {
                        O000000o(String.valueOf(this.O00000Oo), O00000Oo2, O00000o02, O00000o2);
                        O000000o("saveStationRouterInfo0:" + this.O00000Oo + ", " + O00000Oo2 + ", " + O00000o2, new Object[0]);
                    }
                    if (!TextUtils.isEmpty(O00000Oo2) && htt.O00000Oo(this.O000OOOo)) {
                        String str = (String) htr.O000000o().O000000o("mo_xiang_station_did");
                        O000000o(str, O00000Oo2, O00000o02, O00000o2);
                        O000000o("saveStationRouterInfo1:" + str + ", " + O00000Oo2 + ", " + O00000o2, new Object[0]);
                        return;
                    }
                    return;
                case 111:
                    O00000o(SmartConfigStep.Step.STEP_APSECURE_PIN_STEP_V2);
                    return;
                case 112:
                    SmartConfigRouterFactory.getSmartConfigManager().checkPassedForCamera((Activity) this.O000O0oo, true, new huf(bundle.getBoolean("hasVoiceOob")) {
                        /* class _m_j.$$Lambda$hvy$6DxyvAIuFbdhtmG937LV2Ez4SA */
                        private final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void accept(String str) {
                            hvy.this.O000000o(this.f$1, str);
                        }
                    });
                    return;
                default:
                    return;
            }
        } else {
            O0000oOO();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(boolean z, String str) {
        fbs.O000000o(new fbt(this.O000O0oo, ScanBarcodeActivity.TAG).O000000o("show_add_manully", z).O000000o("from", 500).O000000o(1000));
    }

    public final boolean G_() {
        O000000o("onBackPressed", new Object[0]);
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hvy.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (hvy.this.O000O0oo != null) {
                        hvy.this.O000000o("onBackPressed ,user click dialog's Ok, and then stop binding.", new Object[0]);
                        hvy.this.b_(false);
                        if (!hvy.this.O000OOoO && hvy.this.O000OOo && !hvy.this.O000OOoo) {
                            if (hvy.this.f789O000000o == 0 || (hvy.this.f789O000000o == 3 && ConfigStep.O00oOooo() && hze.O000000o(hvy.this.O000O0oo))) {
                                hvy hvy = hvy.this;
                                hvy.O000OOoO = true;
                                hvy.this.O00000Oo(goj.O000000o(hvy.f789O000000o));
                            }
                            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hvy.this.O000OOOo, 4);
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(hvy.this.O000OOOo, hvy.this.O000OO);
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
                    Bundle bundle = new Bundle();
                    bundle.putString("oob", stringExtra);
                    this.O0000Oo.O000000o(6, bundle);
                    return;
                }
            } else if (i2 == -3) {
                O00000o(SmartConfigStep.Step.STEP_APSECURE_PIN_STEP_V2);
                return;
            }
            O000O0o();
        }
    }
}

package com.xiaomi.smarthome.smartconfig.step;

import _m_j.cub;
import _m_j.cuh;
import _m_j.ddg;
import _m_j.ddk;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fqy;
import _m_j.gfq;
import _m_j.gke;
import _m_j.gkh;
import _m_j.gnj;
import _m_j.gpf;
import _m_j.gpy;
import _m_j.grr;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.htq;
import _m_j.htr;
import _m_j.htt;
import _m_j.hua;
import _m_j.hud;
import _m_j.huh;
import _m_j.hul;
import _m_j.huw;
import _m_j.hvg;
import _m_j.hvt;
import _m_j.hvu;
import _m_j.hvx;
import _m_j.hwd;
import _m_j.hwe;
import _m_j.hwf;
import _m_j.hwg;
import _m_j.hwp;
import _m_j.hwr;
import _m_j.hxy;
import _m_j.iad;
import _m_j.iag;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.smarthome.connect.view.BaseBindView;
import com.smarthome.connect.view.CommonBindView;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONObject;

public abstract class ConfigStep extends SmartConfigStep implements gkh {
    public static WifiManager O0000ooO;

    /* renamed from: O000000o  reason: collision with root package name */
    private Queue<gke> f11731O000000o = new LinkedList();
    private Queue<O000000o> O00000Oo = new LinkedList();
    private List<O00000Oo> O00000o = new CopyOnWriteArrayList();
    private O00000Oo O00000o0;
    public long O0000oO;
    public String O0000oO0;
    public String O0000oOO;
    protected long O0000oOo = -1;
    protected boolean O0000oo = true;
    public ConnectType O0000oo0 = ConnectType.APP;
    public ConnectivityManager O0000ooo;
    View O000O00o;
    View O000O0OO;
    protected TextView O000O0Oo;
    public boolean O000O0o;
    protected ddg O000O0o0;
    FrameLayout O00oOoOo;
    public iad O00oOooO;
    protected TextView O00oOooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f11744O000000o;
        int O00000Oo;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        O000000o f11745O000000o;
        int O00000Oo;
        boolean O00000o = false;
        long O00000o0;
    }

    public void B_() {
    }

    public void C_() {
    }

    public void O000000o(int i, Bundle bundle) {
    }

    public abstract int O00000Oo();

    public abstract SmartConfigStep.Step O00000o(int i);

    public void O00000o0(int i) {
    }

    public abstract ArrayList<gke> O0000Oo0();

    /* access modifiers changed from: protected */
    public void a_(SmartConfigStep.Step step) {
    }

    public void s_() {
    }

    /* access modifiers changed from: protected */
    public boolean t_() {
        return false;
    }

    public abstract void z_();

    public enum ConnectType {
        APP("app"),
        MIUI("miui"),
        SPEAKER("speaker"),
        MINET("minet");
        
        public String type;

        private ConnectType(String str) {
            this.type = str;
        }
    }

    public void e_(int i) {
        gsy.O00000Oo("ConfigStep", "onCurrentIndexSuccess index".concat(String.valueOf(i)));
        if (this.O00000Oo.size() == 0) {
            O0000ooO();
        } else if (!this.O000OO00) {
            C_();
            x_().sendEmptyMessage(111);
            x_().removeMessages(110);
        }
    }

    public void O000000o(Message message) {
        int i;
        int i2 = message.what;
        if (i2 == 110) {
            this.O000O0o = false;
            SmartConfigStep.Step O00000o2 = O00000o(this.f11731O000000o.element().f17943O000000o);
            if (O00000o2 != null) {
                O00000Oo(O00000o2);
            }
        } else if (i2 == 111) {
            if (!this.O00000Oo.isEmpty()) {
                this.O00000Oo.poll();
                this.f11731O000000o.poll();
            }
            gsy.O00000Oo(LogType.KUAILIAN, "ConfigStep", "MSG_CONFIG_STAGE_SUCCESS mConfigStepList:" + this.f11731O000000o.size());
            if (this.O00000Oo.size() == 0) {
                String str = (String) htr.O000000o().O000000o("device_model");
                ScanResult y_ = y_();
                if (str == null) {
                    str = DeviceFactory.O00000Oo(y_);
                }
                PushBindEntity pushBindEntity = (PushBindEntity) htr.O000000o().O000000o("aiot_wifi");
                Device device = (Device) htr.O000000o().O000000o("connected_device");
                if (pushBindEntity != null) {
                    SmartConfigRouterFactory.getSmartConfigManager().bind(pushBindEntity.O00000o);
                }
                if (y_ != null) {
                    SmartConfigRouterFactory.getSmartConfigManager().bind(y_.BSSID);
                }
                if (device != null) {
                    SmartConfigRouterFactory.getSmartConfigManager().bind(device.bssid);
                }
                if (str != null) {
                    int intValue = ((Integer) htr.O000000o().O000000o("key_strategy_index", -1)).intValue();
                    if (intValue == 6 || intValue == 18) {
                        O0000ooO();
                        return;
                    }
                    this.O000O0o0.O000000o((int) R.string.kuailian_init_plugin, (int) R.string.keep_phone_wifi_connect);
                    gsy.O00000Oo("ConfigStep", "startDownloadPlugin model");
                    if (this.O000O0oo != null) {
                        huw installInfo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(str);
                        y_();
                        this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_init_plugin, (int) R.string.keep_phone_wifi_connect);
                        this.O000O0o0.O000000o(4);
                        if (installInfo != null) {
                            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_init_plugin_success, (int) R.string.keep_phone_wifi_connect);
                            O0000ooO();
                            return;
                        }
                        x_().removeMessages(4097);
                        x_().sendEmptyMessageDelayed(118, 5000);
                        O000000o o000000o = new O000000o();
                        o000000o.f11744O000000o = 80;
                        o000000o.O00000Oo = 100;
                        O000000o(o000000o.f11744O000000o, o000000o, 5000);
                        SmartConfigRouterFactory.getCoreApiManager().downloadPlugin(str, new huh() {
                            /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass6 */
                            private long O00000Oo = 0;

                            public final void O000000o(float f) {
                            }

                            public final void O000000o() {
                                this.O00000Oo = System.currentTimeMillis();
                            }

                            public final void O000000o(String str) {
                                if (this.O00000Oo > 0 && !TextUtils.isEmpty(str)) {
                                    SmartConfigRouterFactory.getStatResultManager().app_stat_plugin_downTime(System.currentTimeMillis() - this.O00000Oo, str);
                                }
                                if (!ConfigStep.this.O000OO00) {
                                    ConfigStep.this.x_().removeMessages(4097);
                                    ConfigStep.this.x_().removeMessages(118);
                                    ConfigStep.this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_init_plugin_success, (int) R.string.keep_phone_wifi_connect);
                                    ConfigStep.this.O0000ooO();
                                }
                            }

                            public final void O00000Oo() {
                                if (!ConfigStep.this.O000OO00) {
                                    ConfigStep.this.x_().removeMessages(4097);
                                    ConfigStep.this.x_().removeMessages(118);
                                    ConfigStep.this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_init_plugin_success, (int) R.string.keep_phone_wifi_connect);
                                    ConfigStep.this.O0000ooO();
                                }
                            }

                            public final void O00000o0() {
                                if (!ConfigStep.this.O000OO00) {
                                    ConfigStep.this.x_().removeMessages(4097);
                                    ConfigStep.this.x_().removeMessages(118);
                                    ConfigStep.this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_init_plugin_success, (int) R.string.keep_phone_wifi_connect);
                                    ConfigStep.this.O0000ooO();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                O0000ooO();
                return;
            }
            gke peek = this.f11731O000000o.peek();
            if (peek.O00000o0 != -1) {
                i = peek.O00000o0;
            } else {
                i = this.O00000Oo.peek().f11744O000000o;
            }
            long j = peek.O00000Oo;
            O000000o(i, this.O00000Oo.peek(), j);
            if (j > 0) {
                x_().sendEmptyMessageDelayed(110, j);
            }
        } else if (i2 == 118) {
            x_().removeMessages(4097);
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_init_plugin_timeout, (int) R.string.phone_wifi_error);
            O0000ooO();
        } else if (i2 == 4097) {
            O00000Oo o00000Oo = this.O00000o0;
            if (o00000Oo == null || o00000Oo.O00000o0 == 0 || this.O00000o0.f11745O000000o == null) {
                this.O000O0o0.setProgress(0);
                return;
            }
            if (this.O00000o0.O00000o) {
                this.O00000o0.O00000Oo += 2;
            } else {
                this.O00000o0.O00000Oo++;
            }
            if (this.O00000o0.O00000Oo > this.O00000o0.f11745O000000o.O00000Oo) {
                O00000Oo o00000Oo2 = this.O00000o0;
                o00000Oo2.O00000Oo = o00000Oo2.f11745O000000o.O00000Oo;
            }
            int i3 = ((this.O00000o0.O00000Oo - this.O00000o0.f11745O000000o.f11744O000000o) * 100) / (this.O00000o0.f11745O000000o.O00000Oo - this.O00000o0.f11745O000000o.f11744O000000o);
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= 100) {
                i3 = 100;
            }
            this.O000O0o0.setProgress(i3);
            if (this.O00000o.size() <= 0) {
                x_().sendEmptyMessageDelayed(4097, this.O00000o0.O00000o0 / ((long) (this.O00000o0.f11745O000000o.O00000Oo - this.O00000o0.f11745O000000o.f11744O000000o)));
            } else if (this.O00000o0.O00000Oo >= this.O00000o0.f11745O000000o.O00000Oo) {
                this.O00000o0 = this.O00000o.remove(0);
                x_().sendEmptyMessage(4097);
            } else {
                O00000Oo o00000Oo3 = this.O00000o0;
                o00000Oo3.O00000o0 = 1000;
                o00000Oo3.O00000o = true;
                x_().sendEmptyMessageDelayed(4097, o00000Oo3.O00000o0 / ((long) (this.O00000o0.f11745O000000o.O00000Oo - this.O00000o0.f11745O000000o.f11744O000000o)));
            }
        }
    }

    public final void O0000oOO() {
        this.O000O0o = false;
        x_().removeMessages(110);
        O00000Oo(!this.f11731O000000o.isEmpty() ? O00000o(this.f11731O000000o.element().f17943O000000o) : null);
    }

    /* renamed from: com.xiaomi.smarthome.smartconfig.step.ConfigStep$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f11739O000000o = new int[SmartConfigStep.Step.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f11739O000000o[SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR.ordinal()] = 1;
            f11739O000000o[SmartConfigStep.Step.STEP_CONNECT_AP_ERROR.ordinal()] = 2;
            f11739O000000o[SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR.ordinal()] = 3;
            f11739O000000o[SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR.ordinal()] = 4;
            f11739O000000o[SmartConfigStep.Step.STEP_BLE_SEND_ERROR.ordinal()] = 5;
            f11739O000000o[SmartConfigStep.Step.STEP_BLE_PWD_ERROR.ordinal()] = 6;
            f11739O000000o[SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_AUTH_FAIL_09.ordinal()] = 7;
            f11739O000000o[SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_NETWORK_0C.ordinal()] = 8;
            f11739O000000o[SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_CANNOT_FIND_ROUTER_08.ordinal()] = 9;
            f11739O000000o[SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_WEAK_NETWORK_0A.ordinal()] = 10;
            f11739O000000o[SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_DHCP_FAIL_0B.ordinal()] = 11;
            f11739O000000o[SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED.ordinal()] = 12;
            f11739O000000o[SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR.ordinal()] = 13;
            f11739O000000o[SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR.ordinal()] = 14;
            f11739O000000o[SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR.ordinal()] = 15;
            f11739O000000o[SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED.ordinal()] = 16;
            f11739O000000o[SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED.ordinal()] = 17;
            try {
                f11739O000000o[SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR.ordinal()] = 18;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, ?[OBJECT, ARRAY]]
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
    public final void O00000Oo(SmartConfigStep.Step step) {
        if (step != null) {
            switch (AnonymousClass5.f11739O000000o[step.ordinal()]) {
                case 1:
                    O000000o((int) R.string.ble_new_connect_step_failed, (int) R.string.ble_new_connect_loading_title, (int) R.drawable.common_bind_app_connect_device_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 2:
                    O00000o(SmartConfigStep.Step.STEP_CONNECT_AP_ERROR);
                    z_();
                    return;
                case 3:
                    O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 4:
                    O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
                    O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR);
                    z_();
                    return;
                case 5:
                    O000000o((int) R.string.ble_combo_transfer_device_step_failed, (int) R.string.ble_combo_connect_title_error, (int) R.drawable.common_bind_app_connect_device_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 6:
                    O00000Oo(R.string.ble_combo_device_connect_network_step_failed, R.string.ble_combo_password_title_error, R.drawable.common_bind_app_connect_device_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 7:
                    O000000o((int) R.string.combo_ble_error_connect_network_fail, (int) R.string.combo_ble_error_auth_fail_tips, (int) R.drawable.common_bind_app_connect_network_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    O000000o((int) R.string.combo_ble_error_connect_network_fail, (int) R.string.combo_ble_error_connect_network_fail_tips, (int) R.drawable.common_bind_app_connect_network_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 9:
                    O000000o((int) R.string.combo_ble_error_search_wifi_fail, (int) R.string.combo_ble_error_search_wfif_fail_tips, (int) R.drawable.common_bind_app_connect_network_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case 10:
                case 11:
                    O000000o((int) R.string.combo_ble_error_connect_wifi_fail, (int) R.string.combo_ble_error_search_wfif_fail_tips, (int) R.drawable.common_bind_app_connect_network_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    O00000Oo(R.string.ble_combo_device_connect_network_step_failed, R.string.ble_combo_device_title_error, R.drawable.common_bind_device_connect_network_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    return;
                case 13:
                    O00000Oo(R.string.ble_combo_device_connect_network_step_failed, R.string.ble_combo_device_title_error, R.drawable.common_bind_device_connect_network_failed);
                    O000000o(true, (int) R.string.connect_fail_tips, SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR);
                    return;
                case 14:
                    O000000o((int) R.string.ble_new_bind_step_failed, (int) R.string.ble_new_device_has_been_bind, (int) R.drawable.common_bind_device_has_binded_failed);
                    O0000oO0();
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    O000000o((int) R.string.ble_new_connect_step_failed, (int) R.string.device_not_support_now, (int) R.drawable.common_bind_app_connect_device_failed);
                    O0000oO0();
                    return;
                case 16:
                    O000000o((int) R.string.ble_new_bind_step_failed, (int) R.string.ble_combo_sc_device_bind_passport_step_title_failed, (int) R.drawable.common_bind_device_connect_network_failed);
                    O000000o(true, (int) R.string.sc_bind_passport_fail_scan_tips, SmartConfigStep.Step.STEP_BLE_SC_SCAN);
                    return;
                case 17:
                    O000000o((int) R.string.ble_new_bind_step_failed, (int) R.string.ble_combo_sc_device_bind_passport_step_title_failed, (int) R.drawable.common_bind_device_connect_network_failed);
                    O000000o(false, (int) R.string.sc_bind_passport_fail_scan_tips, (SmartConfigStep.Step) null);
                    return;
                case 18:
                    O000000o((int) R.string.request_bind_key_fail, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_app_connect_device_failed);
                    O000000o(false, 0, (SmartConfigStep.Step) null);
                    z_();
                    return;
                default:
                    O00000o(step);
                    return;
            }
        }
    }

    public void O000000o(Context context) {
        if (this.O000O0oo != null) {
            Object O000000o2 = htr.O000000o().O000000o("wifi_bind_key");
            if (O000000o2 != null) {
                this.O0000oO0 = (String) O000000o2;
            }
            Object O000000o3 = htr.O000000o().O000000o("bind_index_key");
            if (O000000o3 != null) {
                this.O0000oOO = (String) O000000o3;
            }
            Object O000000o4 = htr.O000000o().O000000o("bind_timestamp_key");
            if (O000000o4 != null) {
                this.O0000oO = ((Long) O000000o4).longValue();
            }
            this.O0000oOo = System.currentTimeMillis();
            if (this.O000Ooo0) {
                O000000o(context, (int) R.layout.miconnect_base_config_step_layout);
                this.O00oOooo = (TextView) this.O000O0oO.findViewById(R.id.common_tile_tv);
                this.O000O0Oo = (TextView) this.O000O0oO.findViewById(R.id.tv_bind_wifi);
                this.O00oOooo.setText((int) R.string.miconnect_adding_device);
                this.O000O0Oo.setText(String.format(this.O000O0oo.getResources().getString(R.string.miconnect_bind_to_wifi), (String) htr.O000000o().O000000o("selected_ap_ssid")));
                this.O00oOoOo = (FrameLayout) this.O000O0oO.findViewById(R.id.common_bind_view);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                this.O000O0o0 = new CommonBindView(this.O000O0oo);
                this.O00oOoOo.addView((CommonBindView) this.O000O0o0, layoutParams);
            } else {
                O000000o(context, (int) R.layout.smart_config_start_config_ui);
                this.O000O00o = this.O000O0oO.findViewById(R.id.title_bar);
                this.O000O0OO = this.O000O0oO.findViewById(R.id.module_a_3_return_btn);
                this.O00oOooo = (TextView) this.O000O0oO.findViewById(R.id.module_a_3_return_title);
                this.O00oOoOo = (FrameLayout) this.O000O0oO.findViewById(R.id.common_bind_view);
                gwg.O000000o(this.O000O00o);
                O000O0OO();
                SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(this.O000OOOo, 0);
                gwg.O00000Oo(((Activity) context).getWindow());
                this.O000O0OO.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass1 */

                    public final void onClick(View view) {
                        ConfigStep.this.G_();
                    }
                });
                this.O00oOooo.setText(this.O000O0oo.getString(R.string.kuailian_connect_device));
                this.O000O0o0 = new com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView(this.O000O0oo);
                this.O00oOoOo.addView((com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView) this.O000O0o0, new FrameLayout.LayoutParams(-1, -1));
            }
            O0000ooO = (WifiManager) this.O000O0oo.getApplicationContext().getSystemService("wifi");
            this.O0000ooo = (ConnectivityManager) this.O000O0oo.getSystemService("connectivity");
            SmartConfigRouterFactory.getSmartConfigManager().initHomeManager();
            if (((Boolean) htr.O000000o().O000000o("from_miui", Boolean.FALSE)).booleanValue()) {
                this.O0000oo0 = ConnectType.MIUI;
            } else {
                this.O0000oo0 = ConnectType.APP;
            }
            O0000o0o();
        }
    }

    public void H_() {
        O0000o0o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void O0000o0o() {
        this.O000O0o = true;
        this.f11731O000000o.clear();
        this.O00000Oo.clear();
        this.O00000o.clear();
        ArrayList<gke> O0000Oo0 = O0000Oo0();
        this.f11731O000000o.addAll(O0000Oo0);
        long j = 0;
        for (gke gke : O0000Oo0) {
            j += Math.max(gke.O00000Oo, 0L);
        }
        int i = 0;
        O000000o o000000o = null;
        int i2 = 0;
        for (gke gke2 : O0000Oo0) {
            i2 = (int) (((long) i2) + Math.max(gke2.O00000Oo, 0L));
            O000000o o000000o2 = new O000000o();
            if (o000000o == null) {
                o000000o2.f11744O000000o = 0;
            } else {
                o000000o2.f11744O000000o = o000000o.O00000Oo;
            }
            o000000o2.O00000Oo = (int) (((long) (i2 * 90)) / j);
            if (o000000o2.f11744O000000o == o000000o2.O00000Oo) {
                o000000o2.O00000Oo++;
            }
            this.O00000Oo.add(o000000o2);
            o000000o = o000000o2;
        }
        int O00000Oo2 = O00000Oo();
        if (O00000Oo2 != -1) {
            while (!this.f11731O000000o.isEmpty() && this.f11731O000000o.peek().f17943O000000o != O00000Oo2) {
                this.f11731O000000o.poll();
                i = this.O00000Oo.poll().O00000Oo;
            }
            gke peek = this.f11731O000000o.peek();
            if (peek.O00000o0 != -1) {
                i = peek.O00000o0;
            }
            if (O00000Oo2 == 0) {
                this.O000O0o0.O000000o();
                B_();
            } else {
                this.O000O0o0.O00000Oo();
                s_();
            }
            long j2 = peek.O00000Oo;
            O000000o(i, this.O00000Oo.peek(), j2);
            if (j2 > 0) {
                x_().sendEmptyMessageDelayed(110, j2);
            }
            O00000o0(O00000Oo2);
        }
    }

    private void O000000o(int i, O000000o o000000o, long j) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f11745O000000o = o000000o;
        o00000Oo.O00000Oo = i;
        o00000Oo.O00000o0 = j;
        O00000Oo o00000Oo2 = this.O00000o0;
        if (o00000Oo2 == null || o00000Oo2.O00000Oo >= this.O00000o0.f11745O000000o.O00000Oo) {
            this.O00000o0 = o00000Oo;
            x_().sendEmptyMessage(4097);
            return;
        }
        x_().removeMessages(4097);
        this.O00000o.add(o00000Oo);
        O00000Oo o00000Oo3 = this.O00000o0;
        o00000Oo3.O00000o0 = 1000;
        o00000Oo3.O00000o = true;
        x_().sendEmptyMessage(4097);
    }

    public void I_() {
        x_().removeMessages(110);
        x_().removeMessages(111);
        x_().removeMessages(118);
        x_().removeMessages(4097);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
     arg types: [java.lang.String, int, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void */
    public void O0000O0o() {
        iad iad;
        if (this.O0000ooo != null) {
            if (!(Build.VERSION.SDK_INT < 29 || (iad = this.O00oOooO) == null || iad.O00000o0 == null)) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                O000000o("bindProcessToNetwork null", new Object[0]);
                this.O0000ooo.bindProcessToNetwork(null);
            }
        }
        if (!this.O000OoO0 && !this.O000Oo0O.isEmpty()) {
            hxy hxy = (hxy) this.O000Oo0O.pop();
            if (hxy != null && hxy.O00000oO) {
                hxy.O0000OoO = this.O0000oO0;
                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
            }
            this.O000Oo0O.clear();
        }
        if (!this.O000OoO0 && this.O000OOo && ((this instanceof hvu) || (this instanceof hwf) || (this instanceof hwg) || (this instanceof hwd) || (this instanceof hwr) || (this instanceof hwp) || (this instanceof hvx) || (this instanceof hvt) || (this instanceof hwe))) {
            O000000o(this.O000OOOo, this.O000OoOO, false);
        }
        if (!this.O000OoO0) {
            O0000o();
        }
        x_().removeMessages(110);
        x_().removeMessages(111);
        x_().removeMessages(118);
        x_().removeMessages(4097);
    }

    private void O000000o(String str, int i, boolean z) {
        Intent intent = ((Activity) this.O000O0oo).getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("connect_source", 0);
            String stringExtra = intent.getStringExtra("connect_unique");
            Object O000000o2 = htr.O000000o().O000000o("key_report_hash_mac");
            Object O000000o3 = htr.O000000o().O000000o("bind_device_did");
            String str2 = str;
            boolean z2 = z;
            int i2 = i;
            SmartConfigRouterFactory.getStatClickManager().adddevice_finishconnect(str2, z2, intExtra, stringExtra, i2, this.O000OoO, hxy.O000000o(O000000o2), gnj.O000000o(O000000o2 + "_" + O000000o3));
        }
    }

    private void O0000o() {
        Intent intent = ((Activity) this.O000O0oo).getIntent();
        if (intent != null) {
            hvg.O000000o(CommonApplication.getAppContext()).O000000o("4", String.valueOf(intent.getIntExtra("connect_source", 0)));
        }
        Long l = (Long) htr.O000000o().O000000o("key_time_start");
        if (!(l == null || l.longValue() == 0)) {
            hvg.O000000o(CommonApplication.getAppContext()).O000000o("2", String.valueOf(System.currentTimeMillis() - l.longValue()));
        }
        String O000000o2 = hvg.O000000o(CommonApplication.getAppContext()).O000000o(this.O000OoOO);
        O000000o(this.O000OoOo, O000000o2);
        if (!TextUtils.isEmpty(O000000o2)) {
            O000000o("IOTLogRecordManager log: ".concat(String.valueOf(O000000o2)), new Object[0]);
            try {
                SmartConfigRouterFactory.getStatClickManager().adddevice_iot_log(new JSONObject(O000000o2));
            } catch (Exception unused) {
                O000000o("IOTLogRecordManager upload failed!", new Object[0]);
            }
        }
    }

    private static void O000000o(String str, String str2) {
        gsy.O00000Oo(3000, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2, int i3) {
        if (this.O000O0oo != null) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.FAILED, this.O000O0oo.getString(i), i2, true);
            this.O000O0o0.setBindFailed(i3);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i, int i2, int i3) {
        if (this.O000O0oo != null) {
            String string = this.O000O0o0.getResources().getString(i);
            String string2 = this.O000O0o0.getResources().getString(R.string.kuailian_connect_fail_reason);
            SpannableString spannableString = new SpannableString(string + " " + string2);
            spannableString.setSpan(new ForegroundColorSpan(-16737793), string.length(), spannableString.length(), 17);
            spannableString.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass7 */

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }

                public final void onClick(View view) {
                    if (ConfigStep.this.O000Ooo0) {
                        ConfigStep.this.O0000oOo();
                    } else {
                        ConfigStep.this.O00000o(SmartConfigStep.Step.STEP_CONNECT_AP_ERROR2);
                    }
                }
            }, string.length(), spannableString.length(), 17);
            this.O000O0o0.O000000o(BaseBindView.StepStatus.FAILED, spannableString, i2, true);
            this.O000O0o0.setBindFailed(i3);
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000oOo() {
        final ddk ddk = new ddk();
        ddk.O00000Oo = this.O000OOOo;
        ddk.f14498O000000o = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass8 */

            public final void onClick(View view) {
                ddk.dismiss();
                ConfigStep.this.H_();
            }
        };
        ddk.show(((FragmentActivity) this.O000O0oo).getSupportFragmentManager(), "Check Region Dialog");
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z, int i, final SmartConfigStep.Step step) {
        if (this.O000O0oo != null) {
            I_();
            this.O000O0o0.setConnectFailedTipsVisibility(z ? 0 : 8);
            if (z && i != 0) {
                this.O000O0o0.setConnectFailedTipsText(this.O000O0oo.getString(i));
            }
            if (z && step != null) {
                this.O000O0o0.setConnectFailedTipsListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass9 */

                    public final void onClick(View view) {
                        ConfigStep.this.O00000o(step);
                    }
                });
            }
            this.O000O0o0.setCommonBtnVisibility(0);
            this.O000O0o0.setCommonBtnText(this.O000O0oo.getString(R.string.mj_retry));
            this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass10 */

                public final void onClick(View view) {
                    if (!ConfigStep.this.t_()) {
                        ConfigStep.this.H_();
                        ConfigStep.this.O000O0oO();
                        ConfigStep.this.a_(step);
                        if (step == SmartConfigStep.Step.STEP_CONNECT_AP_ERROR) {
                            SmartConfigRouterFactory.getStatClickManager().add_fail1st_retry(ConfigStep.this.O000OOOo);
                        } else if (step == SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR) {
                            SmartConfigRouterFactory.getStatClickManager().add_fail2nd_retry(ConfigStep.this.O000OOOo);
                        } else if (step == SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED_ERROR) {
                            SmartConfigRouterFactory.getStatClickManager().add_fail3nd_refresh(ConfigStep.this.O000OOOo);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000oo0() {
        htr.O000000o().O00000Oo("send_passwd_success", Boolean.FALSE);
        Intent intent = new Intent(this.O000O0oo, SmartConfigMainActivity.class);
        fqy.O000000o(intent, this.O000O0oo);
        intent.putExtra("strategy_id", ((Integer) htr.O000000o().O000000o("combo_strategy")).intValue());
        intent.putExtra("model", (String) htr.O000000o().O000000o("device_model"));
        intent.putExtra("scanResult", (ScanResult) htr.O000000o().O000000o("device_ap"));
        intent.putExtra("bssid", (String) htr.O000000o().O000000o("target_bssid"));
        intent.putExtra("password", (String) htr.O000000o().O000000o("target_passwd"));
        intent.putExtra("combo_ble_mac", (String) htr.O000000o().O000000o("combo_ble_mac"));
        this.O000O0oo.startActivity(intent);
        b_(true);
    }

    private void O0000oO0() {
        if (this.O000O0oo != null) {
            I_();
            this.O000O0o0.setConnectFailedTipsVisibility(8);
            this.O000O0o0.setCommonBtnVisibility(0);
            this.O000O0o0.setCommonBtnText(this.O000O0oo.getString(R.string.exit));
            this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass11 */

                public final void onClick(View view) {
                    ConfigStep.this.b_(true);
                }
            });
        }
    }

    public final void O0000oo() {
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        cuh cuh = new cuh(this.O000O0oo, "ConfigRouterSubDeviceActivity");
        cuh.O000000o("station_model", device.model);
        cuh.O000000o("station_did", device.did);
        cuh.O000000o("station_device_name", device.getName());
        cuh.O000000o();
        cub.O000000o(cuh);
        b_(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
     arg types: [java.lang.String, int, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void */
    private void O000000o(String str, String str2, String str3) {
        String str4;
        try {
            if (!grr.O00000oO()) {
                str4 = "not_miui";
            } else {
                str4 = grr.O00000Oo();
            }
            String str5 = str4;
            if (((Boolean) htr.O000000o().O000000o("from_miui")).booleanValue()) {
                SmartConfigRouterFactory.getStatResultManager().adddevice_system_success(str, str5, SmartConfigMainActivity.DEVICE_FROM, O0000oO(), "", str2, str3);
            } else if (SmartConfigMainActivity.DEVICE_FROM == 1) {
                SmartConfigRouterFactory.getStatResultManager().adddevice_system_success(str, str5, 1, O0000oO(), "", str2, str3);
            } else {
                SmartConfigRouterFactory.getStatResultManager().adddevice_app_succrss(str, str5, SmartConfigMainActivity.DEVICE_FROM, O0000oO(), "", str2, str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((this instanceof hvu) || (this instanceof hwf) || (this instanceof hwg) || (this instanceof hwd) || (this instanceof hwr) || (this instanceof hwp) || (this instanceof hvx) || (this instanceof hvt) || (this instanceof hwe)) {
            O000000o(str, 0, true);
            O0000o();
        }
    }

    private static int O0000oO() {
        return ((Integer) htr.O000000o().O000000o("selected_ap_level", 999)).intValue();
    }

    public final void O0000ooo() {
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        boolean booleanValue = ((Boolean) htr.O000000o().O000000o("from_miui", Boolean.FALSE)).booleanValue();
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "ConfigStep", "startChooseRoom device:" + device + " fromMiui:" + booleanValue);
        if (booleanValue) {
            gsy.O00000Oo(LogType.KUAILIAN, "ConfigStep", "startChooseRoom device:".concat(String.valueOf(device)));
            gpf.O000000o(this.O000O0oo, new Runnable() {
                /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$ConfigStep$sNDHSTEae5v3EDsPtrLNW5024 */

                public final void run() {
                    ConfigStep.this.O000OO00();
                }
            });
        } else if (device == null) {
            b_(true);
        } else {
            String str = device.did;
            if (htt.O00000Oo(this.O000OOOo)) {
                str = (String) htr.O000000o().O000000o("mo_xiang_station_did");
                Device O000000o2 = fno.O000000o().O000000o(str);
                List<Device> O00000oO = fno.O000000o().O00000oO(str);
                if (O00000oO != null && O00000oO.size() >= 2) {
                    SmartConfigRouterFactory.getSmartConfigManager().enterPlugin(O000000o2, (SmartConfigMainActivity) this.O000O0oo, new hul() {
                        /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass4 */

                        public final void O000000o(int i) {
                        }

                        public final void O00000Oo(int i) {
                        }

                        public final void O000000o(Object obj) {
                            ConfigStep.this.b_(true);
                        }
                    });
                    return;
                }
            }
            fbs.O000000o(new fbt(SmartConfigRouterFactory.getSmartConfigManager().getAppContext(), "initDeviceRoomActivity").O000000o("device_id", str).O00000Oo(268435456));
            b_(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000OO00() {
        b_(true);
    }

    public void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i != 100) {
            return;
        }
        if (i2 == 200) {
            this.O0000oo = true;
        } else if (i2 == 300) {
            htr.O000000o().O00000Oo("key_strategy_index", 9);
            O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
        }
    }

    private static void O000O0oo() {
        SmartConfigRouterFactory.getSmartConfigManager().bindDeviceToHome((Device) htr.O000000o().O000000o("connected_device"), null);
    }

    protected static void O00oOooO() {
        Object O000000o2 = htr.O000000o().O000000o("selected_ap");
        if (O000000o2 != null) {
            gfq.O000000o().O00000Oo(((ScanResult) O000000o2).BSSID);
        }
    }

    public String O0000o0() {
        DhcpInfo dhcpInfo;
        Context context = this.O000O0oo;
        if (context == null || (dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo()) == null) {
            return "";
        }
        return O000000o((long) dhcpInfo.gateway);
    }

    public static boolean O00oOooo() {
        WifiManager wifiManager = O0000ooO;
        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
        if (connectionInfo == null) {
            return false;
        }
        String O00000Oo2 = htr.O000000o().O00000Oo();
        String ssid = connectionInfo.getSSID();
        return TextUtils.equals(O00000Oo2, ssid) || TextUtils.equals(ssid, iag.O000000o(O00000Oo2));
    }

    public final boolean O000O00o() {
        WifiInfo connectionInfo;
        ScanResult y_;
        WifiManager wifiManager = O0000ooO;
        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && (y_ = y_()) != null && iag.O000000o(connectionInfo.getSSID(), y_.SSID)) {
            return true;
        }
        return false;
    }

    public final void O000000o(Configuration configuration) {
        ddg ddg;
        if (!this.O000Ooo0 && (ddg = this.O000O0o0) != null) {
            ((com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView) ddg).onConfigurationChanged(configuration);
        }
    }

    public final void O0000ooO() {
        if (this.O000Ooo0) {
            b_(true);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("mj_kuailian_config_success");
            CommonApplication.getApplication().sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (htt.O000000o(this.O000OOOo)) {
            Device device = (Device) htr.O000000o().O000000o("connected_device");
            String str = (String) htr.O000000o().O000000o("camera_qrcode_oob");
            O000000o("Write oob(" + str + ") to " + device.did, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                MMKV.O000000o().O00000Oo("qr_code", str);
            }
            gpy.O00000Oo(this.O000O0oo, "sp_moxiang_config", device.did, "");
            this.O000O0o0.O00000o();
            this.O000O0o0.setCommonBtnText(this.O000O0oo.getString(R.string.mx_goon_add_camera));
        } else {
            this.O000O0o0.O00000o0();
        }
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_success_show(this.O000OOOo);
        this.O000O0o0.setCommonBtnVisibility(0);
        this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass12 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().adddevice_connect_confirm(ConfigStep.this.O000OOOo);
                if (!htt.O000000o(ConfigStep.this.O000OOOo)) {
                    ConfigStep.this.O0000ooo();
                } else if (view != null) {
                    ConfigStep.this.O0000oo();
                }
            }
        });
        O000O0oo();
        Device device2 = (Device) htr.O000000o().O000000o("connected_device");
        if (device2 != null) {
            String str2 = device2.model;
            if ("chuangmi.camera.ipc009".equals(this.O000OOOo)) {
                str2 = "chuangmi.camera.ipc009";
            }
            SmartConfigRouterFactory.getSmartConfigManager().endConnect(this.O000O0oo, device2.model, device2.mac);
            SmartConfigRouterFactory.getStatBindManager().uploadBindStep(this.O000OOOo);
            Long l = (Long) htr.O000000o().O000000o("key_time_start");
            if (l == null || l.longValue() == 0) {
                SmartConfigRouterFactory.getStatClickManager().add_complete_click(str2, -1);
            } else {
                SmartConfigRouterFactory.getStatClickManager().add_complete_click(str2, System.currentTimeMillis() - l.longValue());
            }
            hvg.O000000o(CommonApplication.getAppContext()).O000000o("3", str2);
            SmartConfigRouterFactory.getStatPageV2Manager().page_mobile_device(this.O000OOOo, this.O000OO);
            htr.O000000o().O00000Oo("connect_result", "success");
            O000000o(str2, device2.model, device2.did);
            boolean booleanValue = ((Boolean) htr.O000000o().O000000o("from_miui", Boolean.FALSE)).booleanValue();
            htq.O000000o().O000000o(device2.did, booleanValue ? "miui" : "mijia", new hua<JSONObject, hud>() {
                /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass2 */

                public final /* synthetic */ void O000000o(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && jSONObject.optInt("code", -1) == 0) {
                        gsy.O000000o(3, "wangyh", "onSuccess: " + jSONObject.toString());
                    }
                }

                public final void O000000o(hud hud) {
                    gsy.O000000o(3, "wangyh", "onFailure: " + hud.toString());
                }
            });
            htq.O000000o().O00000Oo(device2.did, (String) htr.O000000o().O000000o("gmt_tz", ""), new hua<JSONObject, hud>() {
                /* class com.xiaomi.smarthome.smartconfig.step.ConfigStep.AnonymousClass3 */

                public final void O000000o(hud hud) {
                    gsy.O000000o(3, "timezone", "upload failed! Error = " + hud.toString());
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    gsy.O000000o(3, "timezone", "upload successfully!");
                }
            });
            if (booleanValue) {
                SmartConfigRouterFactory.getSmartConfigManager().refreshDevice(device2.did);
            }
            SmartConfigRouterFactory.getSmartConfigManager().forcePinCodeSettingForKorean(device2);
            try {
                gsy.O000000o(3, "ConfigStep", "ConfigStep success model = " + this.O000OOOo);
                if (!TextUtils.isEmpty(this.O000OOOo) && this.O000OOOo.contains("camera")) {
                    Intent intent2 = new Intent();
                    intent2.setAction("com.xiaomi.smarthome.camera.DEVICE_BINDED_RECEIVER");
                    intent2.setPackage(this.O000O0oo.getPackageName());
                    gsy.O000000o(3, "ConfigStep", "mContext.getPackageName() = " + this.O000O0oo.getPackageName());
                    intent2.putExtra("extra_device_did", device2.did);
                    intent2.putExtra("extra_device_model", this.O000OOOo);
                    this.O000O0oo.sendBroadcast(intent2);
                }
            } catch (Exception e2) {
                gsy.O00000o0(LogType.CAMERA, "ConfigStep", e2.toString());
            }
        } else {
            gsy.O00000Oo("ConfigStep", "finishStep device is null");
        }
    }
}

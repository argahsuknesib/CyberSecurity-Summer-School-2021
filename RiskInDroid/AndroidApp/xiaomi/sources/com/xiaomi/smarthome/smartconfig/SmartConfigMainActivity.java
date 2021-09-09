package com.xiaomi.smarthome.smartconfig;

import _m_j.eyr;
import _m_j.foc;
import _m_j.gsy;
import _m_j.gty;
import _m_j.htk;
import _m_j.htr;
import _m_j.htt;
import _m_j.hvp;
import _m_j.hws;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hze;
import _m_j.iaf;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.sdk.SyncConfigCallback;
import com.xiaomi.smarthome.smartconfig.step.CameraResetStep;
import com.xiaomi.smarthome.smartconfig.step.ChooseWifiStep;
import com.xiaomi.smarthome.smartconfig.step.ChooseWifiStepV2;
import com.xiaomi.smarthome.smartconfig.step.DeviceInfoStep;
import com.xiaomi.smarthome.smartconfig.step.QRCameraStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.smartconfig.step.XiaofangResetStep;
import java.util.GregorianCalendar;
import java.util.Stack;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class SmartConfigMainActivity extends BaseActivity {
    public static int DEVICE_FROM = 0;
    public static int DEVICE_FROM_APP_PLUS_TYPE = 6;

    /* renamed from: O000000o  reason: collision with root package name */
    FrameLayout f11468O000000o;
    SmartConfigStep.O000000o O00000Oo = new SmartConfigStep.O000000o() {
        /* class com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity.AnonymousClass1 */

        public final void O000000o() {
            if (!SmartConfigMainActivity.this.mStepStack.isEmpty()) {
                SmartConfigMainActivity.this.mStepStack.pop();
            }
            if (SmartConfigMainActivity.this.mStepStack.empty()) {
                SmartConfigMainActivity smartConfigMainActivity = SmartConfigMainActivity.this;
                smartConfigMainActivity.O000000o(smartConfigMainActivity.mConfigStep);
                SmartConfigMainActivity.this.mConfigStep = null;
                return;
            }
            SmartConfigMainActivity smartConfigMainActivity2 = SmartConfigMainActivity.this;
            SmartConfigStep peek = smartConfigMainActivity2.mStepStack.peek();
            smartConfigMainActivity2.f11468O000000o.removeAllViews();
            peek.O00oOoOo();
            if (peek.O000O0Oo() != null) {
                smartConfigMainActivity2.f11468O000000o.addView(peek.O000O0Oo());
            }
        }

        public final Handler O00000Oo() {
            return SmartConfigMainActivity.this.mHandler;
        }

        public final void O000000o(SmartConfigStep.Step step) {
            if (!SmartConfigMainActivity.this.mStepStack.isEmpty()) {
                SmartConfigMainActivity.this.mStepStack.pop();
            }
            SmartConfigMainActivity.this.O000000o(step);
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
            SmartConfigMainActivity.this.O000000o(step);
        }

        public final void O000000o(boolean z) {
            if (SmartConfigMainActivity.this.mStepStack.size() > 0) {
                SmartConfigStep peek = SmartConfigMainActivity.this.mStepStack.peek();
                if (!peek.O000OOo || (peek instanceof ChooseWifiStep) || (peek instanceof ChooseWifiStepV2) || (peek instanceof CameraResetStep) || (peek instanceof QRCameraStep) || (peek instanceof XiaofangResetStep)) {
                    SmartConfigMainActivity.this.mNeedReportFailure = false;
                }
            }
            if (!SmartConfigMainActivity.this.mStepStack.isEmpty()) {
                SmartConfigMainActivity.this.mStepStack.pop();
            }
            Intent intent = new Intent();
            intent.putExtra("finish", z);
            SmartConfigMainActivity.this.setResult(-1, intent);
            SmartConfigMainActivity.this.finish();
        }
    };
    private boolean O00000o = false;
    private int O00000o0;
    private long O00000oO;
    private boolean O00000oo = true;
    private Dialog O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private String O0000OoO;
    private boolean O0000Ooo;
    private BroadcastReceiver O0000o0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                SmartConfigMainActivity.this.mHandler.sendEmptyMessage(100);
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    Message obtainMessage = SmartConfigMainActivity.this.mHandler.obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.obj = (NetworkInfo) parcelableExtra;
                    SmartConfigMainActivity.this.mHandler.sendMessage(obtainMessage);
                }
            } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                SmartConfigMainActivity.this.mHandler.sendEmptyMessage(102);
            }
        }
    };
    private long O0000o00 = System.currentTimeMillis();
    public SmartConfigStep.Step mConfigStep;
    public boolean mNeedReportFailure = true;
    public Stack<SmartConfigStep> mStepStack = new Stack<>();

    public void handleMessage(Message message) {
        if (!this.mStepStack.empty()) {
            this.mStepStack.peek().O000000o(message);
        }
    }

    public void onResume() {
        super.onResume();
        int i = 1;
        if (!SmartConfigRouterFactory.getSmartConfigManager().isMiLoggedIn()) {
            Dialog dialog = this.O0000O0o;
            if (dialog == null) {
                this.O0000O0o = gty.O000000o().showLoginDialog(this, true);
                this.O0000O0o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        SmartConfigMainActivity smartConfigMainActivity = SmartConfigMainActivity.this;
                        smartConfigMainActivity.mNeedReportFailure = false;
                        smartConfigMainActivity.finish();
                    }
                });
                this.O0000O0o.setCanceledOnTouchOutside(false);
            } else if (!dialog.isShowing()) {
                this.O0000O0o.show();
            }
        }
        int i2 = this.O00000o0;
        if (i2 == 16 || i2 == 17) {
            iaf.O000000o().O00000Oo();
        }
        if (CameraResetStep.O00000Oo) {
            CameraResetStep.O00000Oo = false;
            boolean checkScanWifiLocationPermission = SmartConfigRouterFactory.getSmartConfigManager().checkScanWifiLocationPermission(this, false, 0);
            hxk hxk = hxi.O00000o;
            if (!checkScanWifiLocationPermission) {
                i = 2;
            }
            hxk.O0000oo(i);
        }
    }

    public void onPause() {
        super.onPause();
        int i = this.O00000o0;
        if (i == 16 || i == 17) {
            SmartConfigRouterFactory.getCoreApiManager().stopScan();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(SmartConfigStep.Step step) {
        if (step == null) {
            this.mNeedReportFailure = false;
            finish();
            return;
        }
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "bindDevice", "SmartConfigMainActivity.switchToStep step:" + step + "  mStrategyIndex:" + this.O00000o0);
        this.f11468O000000o.removeAllViews();
        SmartConfigStep O00000o02 = SmartConfigStep.O00000o0(step);
        O00000o02.O000Ooo0 = false;
        if ((O00000o02 instanceof CameraResetStep) || (O00000o02 instanceof ChooseWifiStep) || (O00000o02 instanceof DeviceInfoStep) || (O00000o02 instanceof hws) || (O00000o02 instanceof XiaofangResetStep)) {
            this.O0000Ooo = false;
        } else if (!this.O0000Ooo) {
            htr O000000o2 = htr.O000000o();
            long currentTimeMillis = System.currentTimeMillis();
            this.O0000o00 = currentTimeMillis;
            O000000o2.O00000Oo("key_time_start", Long.valueOf(currentTimeMillis));
            this.O0000Ooo = true;
        }
        if (O00000o02 != null) {
            O00000o02.O000OOo0 = this.O00000Oo;
            O00000o02.O00000o0(this);
            if (O00000o02.O000O0Oo() != null) {
                this.f11468O000000o.addView(O00000o02.O000O0Oo());
                this.mStepStack.push(O00000o02);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0390  */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        boolean z = true;
        htr.f689O000000o = true;
        this.O00000oO = System.currentTimeMillis();
        setContentView((int) R.layout.smart_config_main_layout);
        SmartConfigRouterFactory.getStatResultManager().initDeviceConnectCounter();
        eyr.O00000Oo().O000000o((SyncConfigCallback.Stub) null);
        this.f11468O000000o = (FrameLayout) findViewById(R.id.main_container);
        SmartConfigRouterFactory.getSmartConfigManager().onStartSmartConfig(null);
        Intent intent = getIntent();
        if (intent != null) {
            this.O0000OOo = intent.getIntExtra("connect_source", 0);
            this.O0000OoO = intent.getStringExtra("connect_unique");
            this.O00000o = intent.getBooleanExtra("resume_strategy", false);
            htr.O000000o().O00000Oo("goto_error_page", Boolean.valueOf(intent.getBooleanExtra("goto_error_page", false)));
            this.O00000o0 = intent.getIntExtra("strategy_id", -1);
            this.O00000oo = intent.getBooleanExtra("use_reset_page", true);
            if (!this.O00000o) {
                String stringExtra = intent.getStringExtra("wifi_bind_key");
                String stringExtra2 = intent.getStringExtra("model");
                String stringExtra3 = intent.getStringExtra("bssid");
                ScanResult scanResult = (ScanResult) intent.getParcelableExtra("scanResult");
                htr.O000000o().O00000Oo.clear();
                htr.O000000o().O00000Oo("wifi_bind_key", stringExtra);
                htr.O000000o().O00000Oo("key_strategy_index", Integer.valueOf(this.O00000o0));
                htr.O000000o().O00000Oo("key_time_start", Long.valueOf(this.O0000o00));
                htr.O000000o().O00000Oo("device_ap", scanResult);
                htr.O000000o().O00000Oo("device_model", stringExtra2);
                htr.O000000o().O00000Oo("target_bssid", stringExtra3);
                htr.O000000o().O00000Oo("target_passwd", intent.getStringExtra("password"));
                htr.O000000o().O00000Oo("wifi_ssid", intent.getStringExtra("ssid"));
                htr.O000000o().O00000Oo("bind_device_did", intent.getStringExtra("did"));
                htr.O000000o().O00000Oo("bind_device_token", intent.getStringExtra("token"));
                htr.O000000o().O00000Oo("bind_device_sn", intent.getStringExtra("sn"));
                htr.O000000o().O00000Oo("bind_device_timestamp", Long.valueOf(intent.getLongExtra("timestamp", 0)));
                htr.O000000o().O00000Oo("bind_device_key", intent.getStringExtra("bind_key"));
                htr.O000000o().O00000Oo("scan_qr_code", intent.getStringExtra("scan_qr_code"));
                htr.O000000o().O00000Oo("gateway_did", intent.getStringExtra("gateway_did"));
                htr.O000000o().O00000Oo("aiot_wifi", intent.getParcelableExtra("aiot_wifi"));
                htr.O000000o().O00000Oo("combo_ble_mac", intent.getStringExtra("combo_ble_mac"));
                htr.O000000o().O00000Oo("combo_ble_key", intent.getStringExtra("combo_ble_key"));
                htr.O000000o().O00000Oo("mi_router_info", intent.getParcelableExtra("mi_router_info"));
                htr.O000000o().O00000Oo("camera_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                htr.O000000o().O00000Oo("key_lock_wifi_device_mac", intent.getStringExtra("key_lock_wifi_device_mac"));
                htr.O000000o().O00000Oo("key_lock_wifi_from_plugin", Boolean.valueOf(intent.getBooleanExtra("key_lock_wifi_from_plugin", false)));
                htr.O000000o().O00000Oo("key_lock_wifi_device_token", intent.getStringExtra("key_lock_wifi_device_token"));
                htr.O000000o().O00000Oo("mo_xiang_station_did", intent.getStringExtra("mo_xiang_station_did"));
                htr.O000000o().O00000Oo("mo_xiang_station_ssid", intent.getStringExtra("mo_xiang_station_ssid"));
                htr.O000000o().O00000Oo("mo_xiang_station_passwd", intent.getStringExtra("mo_xiang_station_passwd"));
                htr.O000000o().O00000Oo("mo_xiang_static_key", intent.getStringExtra("mo_xiang_static_key"));
                htr.O000000o().O00000Oo("mo_xiang_key_num", intent.getStringExtra("mo_xiang_key_num"));
                if (stringExtra2 == null && scanResult != null) {
                    stringExtra2 = DeviceFactory.O00000Oo(scanResult);
                    if (!stringExtra2.equals("none")) {
                        htr.O000000o().O00000Oo("device_model", intent.getStringExtra("model"));
                    }
                }
                if (stringExtra3 == null && scanResult != null) {
                    stringExtra3 = scanResult.BSSID;
                }
                SmartConfigRouterFactory.getSmartConfigManager().startConnect(this, stringExtra2, stringExtra3);
                int intExtra = intent.getIntExtra("category", 0);
                if (intExtra > 0) {
                    if (intExtra == 1) {
                        SmartConfigRouterFactory.getStatClickManager().miui_push_click(stringExtra2);
                    }
                    DEVICE_FROM = intExtra;
                }
                htr.O000000o().O00000Oo("selected_ap", intent.getParcelableExtra("select_scan_result"));
                htr.O000000o().O00000Oo("selected_ap_ssid", intent.getStringExtra("select_ssid"));
                htr.O000000o().O00000Oo("selected_ap_passwd", intent.getStringExtra("select_password"));
                htr.O000000o().O00000Oo("from_miui", Boolean.valueOf(intent.getBooleanExtra("from_miui", false)));
                if (this.O00000o0 != -1) {
                    htr.O000000o().O00000Oo("gmt_offset", Integer.valueOf((int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS)));
                    htr.O000000o().O00000Oo("gmt_tz", TimeZone.getDefault().getID());
                    SmartConfigRouterFactory.getStatClickManager().adddevice_connectdevice(stringExtra2, this.O0000OOo, this.O0000OoO);
                    if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
                        ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
                        if (globalSettingServer == null) {
                            str = "";
                        } else {
                            str = globalSettingServer.f7546O000000o;
                        }
                        MiioLocalAPI.O000000o(str);
                    }
                    String stringExtra4 = intent.getStringExtra("mitv_did");
                    htr.O000000o().O00000Oo("mitv_action", intent.getStringExtra("mitv_atype"));
                    htr.O000000o().O00000Oo("mitv_did", stringExtra4);
                    htr.O000000o().O00000Oo("scan_qr_model", intent.getStringExtra("scan_device_model"));
                    if ("yunyi.camera.v1".equals(stringExtra2) || "yunyi.camera.v2".equals(stringExtra2)) {
                        htr.O000000o().O00000Oo("user_qr_code", Boolean.TRUE);
                    }
                }
            }
            registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
            String stringExtra5 = getIntent().getStringExtra("model");
            if (!this.O00000o) {
                O000000o(hvp.O000000o(stringExtra5, this.O00000o0));
            } else {
                this.mConfigStep = hvp.O000000o(stringExtra5, this.O00000o0);
                if (this.mConfigStep != null) {
                    htk.O000000o().O00000o();
                    PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(stringExtra5);
                    boolean booleanExtra = getIntent().getBooleanExtra("isChooseWifi", false);
                    if (pluginInfo != null && pluginInfo.O00000o() == 4 && htr.O000000o().O000000o("selected_ap") != null && htr.O000000o().O000000o("selected_ap_ssid") != null && htr.O000000o().O000000o("selected_ap_passwd") != null && htr.O000000o().O000000o("device_ap") != null) {
                        O000000o(SmartConfigStep.Step.STEP_AP_CONFIG_STEP);
                    } else if (hvp.O000000o(this.O00000o0) || booleanExtra || (pluginInfo != null && pluginInfo.O00000o() == 4 && !this.O00000oo)) {
                        if (((Boolean) htr.O000000o().O000000o("user_qr_code", Boolean.FALSE)).booleanValue()) {
                            O000000o(SmartConfigStep.Step.STEP_DEVICE_INFO);
                        } else if (((Boolean) htr.O000000o().O000000o("mi_router_in_device_list", Boolean.FALSE)).booleanValue()) {
                            O000000o(SmartConfigStep.Step.STEP_GET_ROUTER_INFO);
                        } else {
                            if (htr.O000000o().O000000o("mi_router_info") == null) {
                                if (!htt.O00000Oo(stringExtra5) || TextUtils.isEmpty(foc.O0000O0o("moxiang_net", "ssid".concat(String.valueOf((String) htr.O000000o().O000000o("mo_xiang_station_did")))))) {
                                    z = false;
                                }
                                if (!z) {
                                    O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
                                }
                            }
                            O000000o(this.mConfigStep);
                            this.mConfigStep = null;
                        }
                    } else if (hvp.O00000Oo(this.O00000o0) != null && this.O00000oo) {
                        O000000o(hvp.O00000Oo(this.O00000o0));
                    } else if (hvp.O000000o(stringExtra5, this.O00000o0) != null) {
                        O000000o(this.mConfigStep);
                        this.mConfigStep = null;
                    }
                }
                this.mNeedReportFailure = false;
                finish();
            }
            SmartConfigRouterFactory.getSmartConfigManager().pushActivity(this);
        }
        this.mNeedReportFailure = false;
        finish();
        registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        registerReceiver(this.O0000o0, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        String stringExtra52 = getIntent().getStringExtra("model");
        if (!this.O00000o) {
        }
        SmartConfigRouterFactory.getSmartConfigManager().pushActivity(this);
    }

    public void onBackPressed() {
        if (!(!this.mStepStack.isEmpty() ? this.mStepStack.peek().G_() : false)) {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        htr.f689O000000o = false;
        unregisterReceiver(this.O0000o0);
        if (this.mStepStack.size() > 0) {
            SmartConfigStep peek = this.mStepStack.peek();
            if (!peek.O000OOo || (peek instanceof ChooseWifiStep) || (peek instanceof ChooseWifiStepV2) || (peek instanceof CameraResetStep) || (peek instanceof QRCameraStep) || (peek instanceof XiaofangResetStep)) {
                this.mNeedReportFailure = false;
            }
        }
        while (!this.mStepStack.isEmpty()) {
            this.mStepStack.pop().O000O0o0();
        }
        SmartConfigRouterFactory.getSmartConfigManager().onFinishSmartConfig(null, true);
        SmartConfigRouterFactory.getSmartConfigManager().popActivity(this);
        String str = (String) htr.O000000o().O000000o("device_model");
        if (!TextUtils.isEmpty(str) || this.O0000Ooo) {
            SmartConfigRouterFactory.getStatResultManager().adddevice_link_time_AP(str, this.O00000oO);
            if (!"fail".equalsIgnoreCase((String) htr.O000000o().O000000o("connect_result", "fail"))) {
                String O00000o02 = htr.O000000o().O00000o0();
                if (!TextUtils.isEmpty(O00000o02)) {
                    SmartConfigRouterFactory.getStatResultManager().wifi_pwd_length(O00000o02.getBytes().length);
                }
            } else if (this.mNeedReportFailure && hze.O000000o((Context) this)) {
                SmartConfigRouterFactory.getStatResultManager().add_fail_device(str, System.currentTimeMillis() - this.O0000o00);
            }
        }
        DEVICE_FROM = 0;
        DEVICE_FROM_APP_PLUS_TYPE = 6;
        SmartConfigRouterFactory.getStatBindManager().clearBindStep(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.mStepStack.isEmpty()) {
            this.mStepStack.peek().O000000o(i, i2, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.mStepStack.isEmpty()) {
            this.mStepStack.peek().O000000o(configuration);
        }
    }

    public void onError(int i) {
        this.O0000Oo0 = i;
    }

    public void onRetry() {
        this.O0000Oo++;
    }
}

package com.xiaomi.smarthome.wificonfig;

import _m_j.eyr;
import _m_j.fea;
import _m_j.fob;
import _m_j.fon;
import _m_j.fqy;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fwq;
import _m_j.gnl;
import _m_j.gof;
import _m_j.gsy;
import _m_j.htq;
import _m_j.htr;
import _m_j.htt;
import _m_j.hua;
import _m_j.hud;
import _m_j.hvp;
import _m_j.iae;
import _m_j.iaf;
import _m_j.iag;
import _m_j.inc;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ApConnectFailedStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.wificonfig.RescanWifiActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RescanWifiActivity extends BaseActivity implements ScanDeviceProgressBar.O000000o {
    public static final String TAG = "RescanWifiActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private String f11994O000000o;
    private ScanDeviceProgressBar O00000Oo;
    private List<String> O00000o = new ArrayList();
    private TextView O00000o0;
    private int O00000oO = 30000;
    private long O00000oo = -1;
    private int O0000O0o = -1;
    private boolean O0000OOo = false;
    private Runnable O0000Oo = new Runnable() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass1 */

        public final void run() {
            if (RescanWifiActivity.this.mScanResult == null && RescanWifiActivity.this.mComboBleDevice != null) {
                gsy.O00000o0(LogType.KUAILIAN, RescanWifiActivity.TAG, "connect ble combo");
                RescanWifiActivity rescanWifiActivity = RescanWifiActivity.this;
                rescanWifiActivity.configComDeviceConnection(rescanWifiActivity.mComboBleDevice);
            }
        }
    };
    private int O0000Oo0 = 0;
    private BroadcastReceiver O0000OoO = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", false);
            gsy.O00000o0(LogType.KUAILIAN, RescanWifiActivity.TAG, "onReceive wifiScan Receiver ".concat(String.valueOf(booleanExtra)));
            if (!booleanExtra) {
                return;
            }
            if (!RescanWifiActivity.this.mIsPaused) {
                RescanWifiActivity.this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.wificonfig.$$Lambda$RescanWifiActivity$2$sWXRfavbnDbKWnVcLnKkY7E4VPs */

                    public final void run() {
                        RescanWifiActivity.AnonymousClass2.this.O000000o();
                    }
                }, 1000);
            } else if (RescanWifiActivity.this.mConnectFailedStep != null) {
                RescanWifiActivity.this.checkScanResult();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            if (!"midr.cardvr.v1".equalsIgnoreCase(RescanWifiActivity.this.mModel) || !iag.O00000Oo(RescanWifiActivity.this.getContext())) {
                RescanWifiActivity.this.mConnectTips.setVisibility(0);
            }
        }
    };
    private BroadcastReceiver O0000Ooo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("wifi_scan_result_broadcast".equals(action)) {
                if (RescanWifiActivity.this.findApDevice()) {
                    RescanWifiActivity rescanWifiActivity = RescanWifiActivity.this;
                    rescanWifiActivity.findWifiDevice = true;
                    rescanWifiActivity.O000000o();
                }
            } else if (fob.f16735O000000o.equals(action)) {
                RescanWifiActivity.this.findBleDevice();
            } else {
                RescanWifiActivity.this.findApDirectDevice();
            }
        }
    };
    private BroadcastReceiver O0000o0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass6 */

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
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("mj_kuailian_config_success")) {
                Intent intent2 = new Intent();
                intent2.putExtra("finish", true);
                RescanWifiActivity.this.setResult(-1, intent2);
                RescanWifiActivity.this.finish();
            }
        }
    };
    private SmartConfigStep.O000000o O0000o00 = new SmartConfigStep.O000000o() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass4 */

        public final void O000000o(SmartConfigStep.Step step) {
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
        }

        public final void O000000o() {
            RescanWifiActivity rescanWifiActivity = RescanWifiActivity.this;
            rescanWifiActivity.doConnectByHand = false;
            rescanWifiActivity.onBackPressed();
        }

        public final Handler O00000Oo() {
            return RescanWifiActivity.this.mHandler;
        }

        public final void O000000o(boolean z) {
            RescanWifiActivity rescanWifiActivity = RescanWifiActivity.this;
            rescanWifiActivity.doConnectByHand = false;
            rescanWifiActivity.onBackPressed();
        }
    };
    public boolean doConnectByHand = false;
    public boolean findWifiDevice = false;
    public BleDevice mComboBleDevice;
    public ApConnectFailedStep mConnectFailedStep;
    public View mConnectTips;
    public String mModel;
    public ScanResult mScanResult;

    public void handleMessage(Message message) {
        if (message.what != 89) {
            super.handleMessage(message);
        } else if (!"midr.cardvr.v1".equalsIgnoreCase(this.mModel) || !iag.O00000Oo(getContext())) {
            this.mConnectTips.setVisibility(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab  */
    public void onTimeOut() {
        boolean z;
        String[] split;
        List<ScanResult> scanResults;
        if (isValid()) {
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !TextUtils.isEmpty(this.mModel) && (split = this.mModel.split("\\.")) != null && split.length > 2) {
                String str = split[1];
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (scanResults = wifiManager.getScanResults()) != null) {
                    Iterator<ScanResult> it = scanResults.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ScanResult next = it.next();
                        String O0000o002 = DeviceFactory.O0000o00(next.SSID);
                        if (!TextUtils.isEmpty(O0000o002) && O0000o002.contains(str)) {
                            String[] split2 = O0000o002.split("\\.");
                            if (split2.length > 2 && split2[1].equals(str) && CoreApi.O000000o().O00000oO(O0000o002) == null) {
                                LogType logType = LogType.KUAILIAN;
                                String str2 = TAG;
                                gsy.O00000o0(logType, str2, "checkNearByDevice ssid=" + next.SSID);
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        this.O00000o0.setVisibility(0);
                    } else {
                        this.O00000o0.setVisibility(4);
                    }
                    if (this.mConnectFailedStep != null) {
                        if (this.mComboBleDevice != null) {
                            this.mHandler.removeCallbacks(this.O0000Oo);
                            gsy.O00000o0(LogType.KUAILIAN, TAG, "onTimeOut connect ble combo");
                            if (configComDeviceConnection(this.mComboBleDevice)) {
                                return;
                            }
                        }
                        gsy.O00000Oo(3000, "3000.0.2", "");
                        this.O0000OOo = true;
                        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE, "scan timeout");
                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_scanning_fail_show(this.mModel);
                        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.scan_timeout_tips).O000000o((int) R.string.restart_scan, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$RescanWifiActivity$8rwDCqr9Zzm6AaLnqpwMXi_N8k */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                RescanWifiActivity.this.O00000Oo(dialogInterface, i);
                            }
                        }).O00000Oo((int) R.string.scan_connect_by_hand, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$RescanWifiActivity$ePe2ZwEjGg7yU_kp1r8F8GogoFk */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                RescanWifiActivity.this.O000000o(dialogInterface, i);
                            }
                        }).O000000o(false).O00000o().show();
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (this.mConnectFailedStep != null) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        SmartConfigRouterFactory.getStatClickManager().adddevice_scanning_fail_goon(this.mModel);
        if (O00000o0()) {
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(5000, this.O00000oO / 5000).O000000o(), (fon) null);
        }
        this.O00000Oo.O00000o0();
        this.O00000Oo.O000000o();
        if (!"midr.cardvr.v1".equalsIgnoreCase(this.mModel) || !iag.O00000Oo(getContext())) {
            this.mConnectTips.setVisibility(0);
        }
        this.O0000Oo0++;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        O00000Oo();
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.rescan_wifi_layout);
        Intent intent = getIntent();
        if (!(intent == null || intent.getParcelableExtra("scanResult") == null)) {
            this.mScanResult = (ScanResult) intent.getParcelableExtra("scanResult");
        }
        this.O00000oo = System.currentTimeMillis();
        if (intent != null) {
            this.mModel = intent.getStringExtra("model");
            this.f11994O000000o = intent.getStringExtra("mac");
            LogType logType = LogType.KUAILIAN;
            String str = TAG;
            gsy.O00000o0(logType, str, " Has model = " + this.mModel);
            String uuid = UUID.randomUUID().toString();
            intent.putExtra("connect_unique", uuid);
            SmartConfigRouterFactory.getStatClickManager().adddevice_selectdevice(this.mModel, intent.getIntExtra("connect_source", 0), uuid);
            O00000o();
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass5 */

            public final void onClick(View view) {
                RescanWifiActivity.this.onBackPressed();
            }
        });
        registerReceiver(this.O0000OoO, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.scan_device));
        this.O00000Oo = (ScanDeviceProgressBar) findViewById(R.id.progress_bar);
        this.mConnectTips = findViewById(R.id.connect_failed_tips);
        this.O00000o0 = (TextView) findViewById(R.id.connect_area_not_support_nearby_device);
        this.O00000Oo.O00000o0 = this;
        this.mConnectTips.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$RescanWifiActivity$HTwV5mpq9a9of4nD0oKHs73u1Pk */

            public final void onClick(View view) {
                RescanWifiActivity.this.O000000o(view);
            }
        });
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiActivity.AnonymousClass7 */

            public final void O000000o(hud hud) {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    gsy.O00000Oo("AP_CONFIG", "scan wifi,request bindKey success");
                    htr.O000000o().O00000Oo("wifi_bind_key", str);
                }
            }
        });
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_scanning_show(this.mModel);
        this.mHandler.sendEmptyMessageDelayed(89, 15000);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("mj_kuailian_config_success");
            CommonApplication.getApplication().registerReceiver(this.O0000o0, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O00000Oo();
    }

    private void O00000Oo() {
        O000000o("用户点击：手动连接", new Object[0]);
        SmartConfigRouterFactory.getStatClickManager().adddevice_scanning_connectbyself(this.mModel);
        if (this.mConnectFailedStep == null) {
            this.doConnectByHand = true;
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.top_view);
            if (this.mScanResult == null) {
                htr.O000000o().O00000Oo("device_ap");
            } else {
                htr.O000000o().O00000Oo("device_ap", this.mScanResult);
            }
            htr O000000o2 = htr.O000000o();
            ScanResult scanResult = this.mScanResult;
            O000000o2.O00000Oo("wifi_ssid", scanResult != null ? scanResult.SSID : DeviceFactory.O000000o(this.mModel, "xxxx"));
            this.mConnectFailedStep = new ApConnectFailedStep();
            ApConnectFailedStep apConnectFailedStep = this.mConnectFailedStep;
            apConnectFailedStep.O000OOo0 = this.O0000o00;
            apConnectFailedStep.O00000o0(this);
            viewGroup.addView(this.mConnectFailedStep.O000O0Oo());
            this.O00000Oo.O00000Oo();
            SmartConfigRouterFactory.getCoreApiManager().stopScan();
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        }
    }

    private boolean O00000o0() {
        PluginDeviceInfo pluginInfo;
        if (TextUtils.isEmpty(this.mModel) || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.mModel)) == null) {
            return false;
        }
        if (pluginInfo.O00000o() == 3 || pluginInfo.O00000o() == 20 || pluginInfo.O00000o() == 18) {
            return true;
        }
        return false;
    }

    private void O00000o() {
        if (!TextUtils.isEmpty(this.mModel)) {
            Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
            ArrayList<PluginDeviceInfo> arrayList = new ArrayList<>();
            if (pluginInfoMap != null && pluginInfoMap.size() > 0) {
                for (Map.Entry<String, PluginDeviceInfo> value : pluginInfoMap.entrySet()) {
                    arrayList.add((PluginDeviceInfo) value.getValue());
                }
            }
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.mModel);
            for (PluginDeviceInfo pluginDeviceInfo : arrayList) {
                if (!(pluginInfo == null || pluginDeviceInfo.O000O0o0 == 0 || pluginDeviceInfo.O000O0o0 != pluginInfo.O00000o0())) {
                    this.O00000o.add(pluginDeviceInfo.O00000Oo());
                }
            }
            this.O00000o.add(this.mModel);
        }
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
    public void onBackPressed() {
        View O000O0Oo;
        ApConnectFailedStep apConnectFailedStep = this.mConnectFailedStep;
        if (apConnectFailedStep == null || (O000O0Oo = apConnectFailedStep.O000O0Oo()) == null) {
            Intent intent = new Intent();
            intent.putExtra("finish", false);
            setResult(-1, intent);
            finish();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) O000O0Oo.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(O000O0Oo);
        }
        this.mConnectFailedStep.G_();
        htr.O000000o().O00000Oo("device_ap");
        htr.O000000o().O00000Oo("wifi_ssid");
        this.mConnectFailedStep = null;
        this.O00000Oo.O00000o0();
        this.O00000Oo.O000000o();
        iaf.O000000o().O000000o(this.mModel);
        if (O00000o0()) {
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(5000, this.O00000oO / 5000).O000000o(), (fon) null);
        }
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
    }

    private static void O000000o(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.KUAILIAN, TAG, str);
    }

    public void onResume() {
        super.onResume();
        int i = 2;
        O000000o("onResume, WLAN 打开 = %s, 地理位置权限打开 = %s", Boolean.valueOf(gof.O00000Oo()), Boolean.valueOf(fwq.O00000Oo() && fwq.O000000o()));
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        if (this.mConnectFailedStep == null) {
            boolean findApDevice = findApDevice();
            if (findApDevice) {
                i = 1;
            }
            this.O0000O0o = i;
            if (findApDevice) {
                this.findWifiDevice = true;
                O000000o();
            }
            if (!findApDevice && !findApDirectDevice()) {
                IntentFilter intentFilter = new IntentFilter("wifi_scan_result_broadcast");
                intentFilter.addAction("ap_device_msg");
                if (O00000o0()) {
                    intentFilter.addAction(fob.f16735O000000o);
                }
                ft.O000000o(this).O000000o(this.O0000Ooo, intentFilter);
                SmartConfigRouterFactory.getCoreApiManager().setScanTimePeriod(2000);
                iaf.O000000o().O000000o(this.mModel);
                if (O00000o0()) {
                    fob.O000000o(new SearchRequest.O000000o().O000000o(5000, this.O00000oO / 5000).O000000o(), (fon) null);
                }
                this.O00000Oo.O00000o0();
                if (eyr.O00000Oo().O00000oO(this.mModel)) {
                    this.O00000oO = 40000;
                } else {
                    this.O00000oO = 30000;
                }
                this.O00000Oo.setTime(this.O00000oO);
                this.O00000Oo.O000000o();
            }
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_scan_device(0, this.mModel);
    }

    public void onPause() {
        super.onPause();
        this.O00000Oo.O00000Oo();
        ft.O000000o(this).O000000o(this.O0000Ooo);
        SmartConfigRouterFactory.getCoreApiManager().setScanTimePeriod(C.MSG_CUSTOM_BASE);
        SmartConfigRouterFactory.getCoreApiManager().stopScan();
        if (O00000o0()) {
            fob.O00000o0();
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_scan_device(this.mEnterTime, this.mModel);
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE, "pause scan");
    }

    public void onStop() {
        super.onStop();
        gsy.O00000Oo(TAG, "onStop");
        if (!this.findWifiDevice && this.O0000OOo && !this.doConnectByHand) {
            O000000o();
            this.O0000OOo = false;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.O0000Oo);
        unregisterReceiver(this.O0000OoO);
        try {
            CommonApplication.getApplication().unregisterReceiver(this.O0000o0);
        } catch (Exception unused) {
        }
    }

    public void findBleDevice() {
        if (this.mComboBleDevice == null && this.mScanResult == null) {
            List<BleDeviceGroup> O000000o2 = fob.O000000o();
            if (this.mModel != null) {
                for (BleDeviceGroup next : O000000o2) {
                    if (!(this.f11994O000000o == null || next.mac == null)) {
                        next.mac.replace(":", "");
                        LogType logType = LogType.KUAILIAN;
                        String str = TAG;
                        gsy.O00000o0(logType, str, "RescanWifiActivity search device : " + next.toString());
                        if (!(next.O00000Oo() == null || next.O00000Oo().O00000oo == null)) {
                            LogType logType2 = LogType.KUAILIAN;
                            String str2 = TAG;
                            gsy.O00000o0(logType2, str2, "RescanWifiActivity search ble combo key : " + next.O00000Oo().O00000oo);
                        }
                        String str3 = this.f11994O000000o;
                        String substring = str3.substring(str3.length() - 4);
                        gsy.O00000o0(LogType.KUAILIAN, TAG, "mMacLast4 : ".concat(String.valueOf(substring)));
                        if (!(next.O00000Oo() == null || next.O00000Oo().f6871O000000o == null || next.O00000Oo().O00000oo == null || !substring.equalsIgnoreCase(next.O00000Oo().O00000oo))) {
                            LogType logType3 = LogType.KUAILIAN;
                            String str4 = TAG;
                            gsy.O00000o0(logType3, str4, "RescanWifiActivity find ble device mac = " + this.f11994O000000o);
                            this.mComboBleDevice = next;
                            this.mHandler.postDelayed(this.O0000Oo, 5000);
                            return;
                        }
                    }
                }
                for (BleDeviceGroup next2 : O000000o2) {
                    Iterator<String> it = this.O00000o.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (next2.O00000oO(it.next()) && next2.O00000Oo() != null && next2.O00000Oo().f6871O000000o != null && next2.O00000Oo().O00000oo != null) {
                                gsy.O00000o0(LogType.KUAILIAN, "ScanResult", "RescanWifiActivity find ble combo device");
                                this.mComboBleDevice = next2;
                                this.mHandler.postDelayed(this.O0000Oo, 5000);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean findApDevice() {
        gsy.O00000Oo("RescanWifi", "findApDevice " + iae.O00000o0);
        if (iae.O00000o0 == null) {
            return false;
        }
        Iterator<ScanResult> it = iae.O00000o0.iterator();
        while (it.hasNext()) {
            ScanResult next = it.next();
            if (this.mScanResult == null || DeviceFactory.O00000oO(next) != DeviceFactory.AP_TYPE.AP_MIAP || !DeviceFactory.O0000Oo(this.mScanResult).equals(DeviceFactory.O0000Oo(next))) {
                String str = this.f11994O000000o;
                if (str != null) {
                    if (DeviceFactory.O00000oO(next) == DeviceFactory.AP_TYPE.AP_MIAP && DeviceFactory.O00000o0(this.f11994O000000o, (String) null).equalsIgnoreCase(DeviceFactory.O0000Oo(next))) {
                        this.mScanResult = next;
                        O000000o(next);
                        this.O00000Oo.O00000Oo();
                        gsy.O00000Oo("RescanWifi", "find device use mac " + this.f11994O000000o);
                        return true;
                    }
                } else if ((this.mScanResult == null && str == null) || (!htt.O000000o(this.mModel) && !htt.O00000Oo(this.mModel))) {
                    for (String next2 : this.O00000o) {
                        if (next2 != null && DeviceFactory.O00000oO(DeviceFactory.O00000Oo(next), next2)) {
                            O000000o(next);
                            this.O00000Oo.O00000Oo();
                            gsy.O00000Oo("RescanWifi", "find device use mSearchModels ");
                            return true;
                        }
                    }
                    continue;
                }
            } else {
                this.mScanResult = next;
                O000000o(next);
                this.O00000Oo.O00000Oo();
                return true;
            }
        }
        return false;
    }

    public boolean findApDirectDevice() {
        if (DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice() == null || DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice().size() <= 0) {
            return false;
        }
        for (ScanResult next : DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice()) {
            if (this.mScanResult == null || DeviceFactory.O00000o0(next) != DeviceFactory.AP_TYPE.AP_MIDEVICE || !DeviceFactory.O0000Oo(this.mScanResult).equals(DeviceFactory.O0000Oo(next))) {
                Iterator<String> it = this.O00000o.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next2 = it.next();
                        if (next2 != null && DeviceFactory.O00000oO(DeviceFactory.O00000o(next), next2)) {
                            O000000o(next);
                            this.O00000Oo.O00000Oo();
                            return true;
                        }
                    }
                }
            } else {
                this.mScanResult = next;
                O000000o(next);
                this.O00000Oo.O00000Oo();
                return true;
            }
        }
        return false;
    }

    private boolean O000000o(ScanResult scanResult) {
        Intent O000000o2 = hvp.O000000o(this, scanResult, DeviceFactory.O00000Oo(scanResult), null, null);
        if (O000000o2 == null) {
            return false;
        }
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        fqy.O000000o(O000000o2, this);
        O000000o2.putExtra("select_scan_result", getIntent().getParcelableExtra("select_scan_result"));
        O000000o2.putExtra("select_ssid", getIntent().getStringExtra("select_ssid"));
        O000000o2.putExtra("select_password", getIntent().getStringExtra("select_password"));
        if (getIntent() != null) {
            O000000o2.putExtra("from_miui", getIntent().getBooleanExtra("from_miui", false));
        }
        if (getIntent() != null && getIntent().hasExtra("key_qrcode_oob")) {
            O000000o2.putExtra("key_qrcode_oob", getIntent().getStringExtra("key_qrcode_oob"));
        }
        Object O000000o3 = htr.O000000o().O000000o("wifi_bind_key");
        if (O000000o3 != null) {
            gsy.O00000Oo("AP_CONFIG", "check exist bindKey");
            O000000o2.putExtra("wifi_bind_key", (String) O000000o3);
        }
        startActivityForResult(O000000o2, 100);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    public boolean configComDeviceConnection(BleDevice bleDevice) {
        boolean z;
        int i;
        gsy.O000000o(4, TAG, "Config Comb device BEGIN.");
        if (bleDevice == null) {
            return false;
        }
        if (bleDevice.O00000Oo() == null || bleDevice.O00000Oo().f6871O000000o == null) {
            i = 0;
        } else {
            i = bleDevice.O00000Oo().f6871O000000o.O0000OOo;
            if (!fea.O000000o(bleDevice.O00000Oo().f6871O000000o.O0000Oo0)) {
                z = false;
                if ((i != 0 || i == 2) && z) {
                    SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
                    Intent intent = new Intent(this, SmartConfigMainActivity.class);
                    intent.putExtra("strategy_id", 13);
                    intent.putExtra("model", bleDevice.model);
                    intent.putExtra("combo_ble_mac", bleDevice.mac);
                    if (bleDevice.O00000Oo() != null) {
                        intent.putExtra("combo_ble_key", bleDevice.O00000Oo().O00000oo);
                    }
                    this.findWifiDevice = true;
                    O000000o();
                    startActivityForResult(intent, 100);
                    return true;
                }
                gsy.O000000o(6, TAG, "don't support authMode: ".concat(String.valueOf(i)));
                return false;
            }
        }
        z = true;
        if (i != 0) {
        }
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        Intent intent2 = new Intent(this, SmartConfigMainActivity.class);
        intent2.putExtra("strategy_id", 13);
        intent2.putExtra("model", bleDevice.model);
        intent2.putExtra("combo_ble_mac", bleDevice.mac);
        if (bleDevice.O00000Oo() != null) {
        }
        this.findWifiDevice = true;
        O000000o();
        startActivityForResult(intent2, 100);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwq.O000000o(android.app.Activity, boolean, _m_j.inc, java.lang.String):boolean
     arg types: [com.xiaomi.smarthome.wificonfig.RescanWifiActivity, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
     candidates:
      _m_j.fwq.O000000o(android.app.Activity, java.lang.String, java.lang.String, java.util.List<java.lang.String>):void
      _m_j.fwq.O000000o(android.app.Activity, boolean, _m_j.inc, java.lang.String):boolean */
    public boolean checkScanResult() {
        String str;
        ScanResult scanResult;
        List<ScanResult> list = null;
        if (!fwq.O000000o((Activity) this, false, (inc) null, (String) null)) {
            O000000o("checkScanResult ,no location permission ,then return !", new Object[0]);
            return false;
        }
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            try {
                list = wifiManager.getScanResults();
            } catch (Exception unused) {
                O000000o("checkScanResult: getScanResult fail", new Object[0]);
            }
        }
        if (list == null || this.findWifiDevice) {
            LogType logType = LogType.KUAILIAN;
            StringBuilder sb = new StringBuilder("RescanWifiActivity ");
            if (wifiManager == null) {
                str = "manager is null";
            } else {
                str = wifiManager.getConnectionInfo() + " " + wifiManager.getScanResults();
            }
            sb.append(str);
            gsy.O00000o0(logType, "scanResult", sb.toString());
        } else {
            for (ScanResult next : list) {
                if (next != null) {
                    gsy.O00000o0(LogType.KUAILIAN, "checkScanResult", "RescanWifiActivity " + next.SSID);
                    if (DeviceFactory.O00000oO(DeviceFactory.O00000Oo(next), this.mModel) || ((scanResult = this.mScanResult) != null && DeviceFactory.O0000Oo(scanResult).equals(DeviceFactory.O0000Oo(next)))) {
                        this.findWifiDevice = true;
                        O000000o();
                        if (this.mIsPaused && this.mConnectFailedStep != null) {
                            finishActivity(102);
                        }
                        return O000000o(next);
                    }
                }
            }
        }
        return false;
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
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        gsy.O000000o(3, str, "onActivityResult requestCode=" + i + ":102,resultCode=" + i2);
        super.onActivityResult(i, i2, intent);
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("finish", true) : false;
        if (i != 102 || this.mConnectFailedStep == null) {
            if (booleanExtra) {
                Intent intent2 = new Intent();
                intent2.putExtra("finish", true);
                setResult(-1, intent2);
            }
            finish();
        } else if (!checkScanResult()) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.O00000oo;
        SmartConfigRouterFactory.getStatResultManager().scanWifiResult(this.mModel, this.findWifiDevice, j > 0 ? (int) ((currentTimeMillis - j) / 1000) : 0, this.O0000O0o, this.O0000Oo0, !this.findWifiDevice ? O00000oO() : 0);
    }

    private static int O00000oO() {
        if (!fwq.O00000Oo(CommonApplication.getAppContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            return 1;
        }
        if (!gof.O00000Oo()) {
            return 2;
        }
        return !gnl.O00000Oo() ? 3 : 50;
    }
}

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
import _m_j.iac;
import _m_j.iae;
import _m_j.iaf;
import _m_j.iag;
import _m_j.inc;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.widget.ListAdapter;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ApConnectFailedStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class RescanWifiV2Activity extends BaseActivity implements ScanDeviceProgressBar.O000000o {
    public static final String TAG = "RescanWifiV2Activity";

    /* renamed from: O000000o  reason: collision with root package name */
    private String f12002O000000o;
    private View O00000Oo;
    private iac O00000o;
    private FixHeightGridView O00000o0;
    private FixHeightGridView O00000oO;
    private iac O00000oo;
    private List<String> O0000O0o = new ArrayList();
    private List<ScanResult> O0000OOo = new ArrayList();
    private long O0000Oo = -1;
    private List<BleDeviceGroup> O0000Oo0 = new ArrayList();
    private int O0000OoO = -1;
    private boolean O0000Ooo = false;
    private SmartConfigStep.O000000o O0000o = new SmartConfigStep.O000000o() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass7 */

        public final void O000000o(SmartConfigStep.Step step) {
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
        }

        public final void O000000o() {
            RescanWifiV2Activity rescanWifiV2Activity = RescanWifiV2Activity.this;
            rescanWifiV2Activity.doConnectByHand = false;
            rescanWifiV2Activity.onBackPressed();
        }

        public final Handler O00000Oo() {
            return RescanWifiV2Activity.this.mHandler;
        }

        public final void O000000o(boolean z) {
            RescanWifiV2Activity rescanWifiV2Activity = RescanWifiV2Activity.this;
            rescanWifiV2Activity.doConnectByHand = false;
            rescanWifiV2Activity.onBackPressed();
        }
    };
    private Runnable O0000o0 = new Runnable() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass1 */

        public final void run() {
            if (RescanWifiV2Activity.this.mScanResult == null && RescanWifiV2Activity.this.mComboBleDevice != null) {
                gsy.O00000o0(LogType.KUAILIAN, RescanWifiV2Activity.TAG, "connect ble combo");
                RescanWifiV2Activity rescanWifiV2Activity = RescanWifiV2Activity.this;
                rescanWifiV2Activity.configComDeviceConnection(rescanWifiV2Activity.mComboBleDevice);
            }
        }
    };
    private boolean O0000o00 = false;
    private BroadcastReceiver O0000o0O = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass5 */

        public final void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", false);
            gsy.O00000o0(LogType.KUAILIAN, RescanWifiV2Activity.TAG, "onReceive wifiScan Receiver ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra && RescanWifiV2Activity.this.mIsPaused && RescanWifiV2Activity.this.mConnectFailedStep != null) {
                RescanWifiV2Activity.this.checkScanResult();
            }
        }
    };
    private BroadcastReceiver O0000o0o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass6 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("wifi_scan_result_broadcast".equals(action)) {
                if (RescanWifiV2Activity.this.findApDevice()) {
                    RescanWifiV2Activity rescanWifiV2Activity = RescanWifiV2Activity.this;
                    rescanWifiV2Activity.findWifiDevice = true;
                    rescanWifiV2Activity.O000000o();
                }
            } else if (fob.f16735O000000o.equals(action)) {
                RescanWifiV2Activity.this.findBleDevice();
            } else {
                RescanWifiV2Activity.this.findApDirectDevice();
            }
        }
    };
    private BroadcastReceiver O0000oO0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass8 */

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
                RescanWifiV2Activity.this.setResult(-1, intent2);
                RescanWifiV2Activity.this.finish();
            }
        }
    };
    public boolean doConnectByHand = false;
    public boolean findWifiDevice = false;
    public View mBottomTimeoutLayout;
    public BleDevice mComboBleDevice;
    public ApConnectFailedStep mConnectFailedStep;
    public View mConnectTips;
    public String mModel;
    public View mOtherAllContent;
    public ScanDeviceProgressBar mProgressbar;
    public TextView mScanDesTv;
    public LottieAnimationView mScanLottie;
    public View mScanNoDeviceImg;
    public ScanResult mScanResult;
    public TextView mScanTitle;
    public int mTimeout = 30000;
    public TextView mTxtAreaNotSupportNearBYDevices;
    public int scanRepeat = 0;

    public void handleMessage(Message message) {
        if (message.what == 89) {
            if (!"midr.cardvr.v1".equalsIgnoreCase(this.mModel) || !iag.O00000Oo(getContext())) {
                this.mConnectTips.setVisibility(0);
            }
            this.O0000o00 = true;
            return;
        }
        super.handleMessage(message);
    }

    public void onTimeOut() {
        boolean z;
        String[] split;
        List<ScanResult> scanResults;
        if (isValid() && this.mOtherAllContent.getVisibility() != 0) {
            this.mScanTitle.setText((int) R.string.qr_cannot_find_device);
            this.mScanDesTv.setText((int) R.string.scan_timeout_tips);
            this.mConnectTips.setVisibility(8);
            this.O00000Oo.setVisibility(8);
            this.mBottomTimeoutLayout.setVisibility(0);
            this.mScanLottie.setVisibility(8);
            this.mScanNoDeviceImg.setVisibility(0);
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
                }
            }
            z = false;
            if (z) {
                this.mTxtAreaNotSupportNearBYDevices.setVisibility(0);
            } else {
                this.mTxtAreaNotSupportNearBYDevices.setVisibility(4);
            }
            if (this.mConnectFailedStep == null) {
                if (this.mComboBleDevice != null) {
                    this.mHandler.removeCallbacks(this.O0000o0);
                    gsy.O00000o0(LogType.KUAILIAN, TAG, "onTimeOut connect ble combo");
                    if (configComDeviceConnection(this.mComboBleDevice)) {
                        return;
                    }
                }
                gsy.O00000Oo(3000, "3000.0.2", "");
                this.O0000Ooo = true;
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE, "scan timeout");
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_scanning_fail_show(this.mModel);
            }
        }
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
        PluginDeviceInfo O00000oO2;
        super.onCreate(bundle);
        setContentView((int) R.layout.rescan_wifi_v2_layout);
        Intent intent = getIntent();
        if (!(intent == null || intent.getParcelableExtra("scanResult") == null)) {
            this.mScanResult = (ScanResult) intent.getParcelableExtra("scanResult");
        }
        this.O0000Oo = System.currentTimeMillis();
        if (intent != null) {
            this.mModel = intent.getStringExtra("model");
            this.f12002O000000o = intent.getStringExtra("mac");
            LogType logType = LogType.KUAILIAN;
            String str = TAG;
            gsy.O00000o0(logType, str, " model = " + this.mModel);
            String uuid = UUID.randomUUID().toString();
            intent.putExtra("connect_unique", uuid);
            SmartConfigRouterFactory.getStatClickManager().adddevice_selectdevice(this.mModel, intent.getIntExtra("connect_source", 0), uuid);
            O00000o0();
        }
        if (!TextUtils.isEmpty(this.mModel) && (O00000oO2 = CoreApi.O000000o().O00000oO(this.mModel)) != null) {
            ((TextView) findViewById(R.id.device_name_tv)).setText(O00000oO2.O0000Oo0());
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass9 */

            public final void onClick(View view) {
                RescanWifiV2Activity.this.onBackPressed();
            }
        });
        this.mScanTitle = (TextView) findViewById(R.id.scan_title);
        this.mScanDesTv = (TextView) findViewById(R.id.scan_des);
        this.mScanLottie = (LottieAnimationView) findViewById(R.id.scan_lottie);
        this.mScanNoDeviceImg = findViewById(R.id.scan_no_device_img);
        this.mProgressbar = (ScanDeviceProgressBar) findViewById(R.id.progress_bar);
        this.mConnectTips = findViewById(R.id.connect_failed_tips);
        this.mTxtAreaNotSupportNearBYDevices = (TextView) findViewById(R.id.connect_area_not_support_nearby_device);
        this.mProgressbar.O00000o0 = this;
        this.mConnectTips.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$RescanWifiV2Activity$GjpwcXqJ26KapZnEGOK2QQfXMVU */

            public final void onClick(View view) {
                RescanWifiV2Activity.this.O000000o(view);
            }
        });
        findViewById(R.id.rescan_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass10 */

            public final void onClick(View view) {
                SmartConfigRouterFactory.getStatClickManager().adddevice_scanning_fail_goon(RescanWifiV2Activity.this.mModel);
                if (RescanWifiV2Activity.this.isComboDevice()) {
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(5000, RescanWifiV2Activity.this.mTimeout / 5000).O000000o(), (fon) null);
                }
                RescanWifiV2Activity.this.mScanTitle.setText((int) R.string.miui_earphone_scanning);
                RescanWifiV2Activity.this.mScanDesTv.setText((int) R.string.scanning_device_please_wait);
                RescanWifiV2Activity.this.mTxtAreaNotSupportNearBYDevices.setVisibility(4);
                RescanWifiV2Activity.this.mConnectTips.setVisibility(8);
                RescanWifiV2Activity.this.mBottomTimeoutLayout.setVisibility(8);
                RescanWifiV2Activity.this.mScanLottie.setVisibility(0);
                RescanWifiV2Activity.this.mScanNoDeviceImg.setVisibility(8);
                RescanWifiV2Activity.this.mProgressbar.O00000o0();
                RescanWifiV2Activity.this.mProgressbar.O000000o();
                if (!"midr.cardvr.v1".equalsIgnoreCase(RescanWifiV2Activity.this.mModel) || !iag.O00000Oo(RescanWifiV2Activity.this.getContext())) {
                    RescanWifiV2Activity.this.mConnectTips.setVisibility(0);
                }
                RescanWifiV2Activity.this.scanRepeat++;
            }
        });
        findViewById(R.id.mannual_connect_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass11 */

            public final void onClick(View view) {
                RescanWifiV2Activity.this.connectByHand();
            }
        });
        registerReceiver(this.O0000o0O, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass4 */

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
        this.mHandler.sendEmptyMessageDelayed(89, 10000);
        this.O00000Oo = findViewById(R.id.other_result_content);
        this.O00000o0 = (FixHeightGridView) findViewById(R.id.other_list_view);
        this.O00000o = new iac(this, new iac.O000000o() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass12 */

            public final void O000000o(Object obj) {
                if (obj instanceof ScanResult) {
                    RescanWifiV2Activity.this.O000000o((ScanResult) obj);
                } else if (obj instanceof BleDeviceGroup) {
                    RescanWifiV2Activity.this.configComDeviceConnection((BleDeviceGroup) obj);
                }
            }
        });
        iac iac = this.O00000o;
        iac.O00000o0 = 2;
        iac.O00000Oo = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass2 */

            public final void onClick(View view) {
                RescanWifiV2Activity.this.pause();
                RescanWifiV2Activity.this.mOtherAllContent.setVisibility(0);
            }
        };
        this.O00000o0.setAdapter((ListAdapter) this.O00000o);
        this.mBottomTimeoutLayout = findViewById(R.id.bottom_timeout_layout);
        this.mOtherAllContent = findViewById(R.id.all_other_result_content);
        this.O00000oO = (FixHeightGridView) findViewById(R.id.all_other_list_view);
        this.O00000oo = new iac(this, new iac.O000000o() {
            /* class com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity.AnonymousClass3 */

            public final void O000000o(Object obj) {
                if (obj instanceof ScanResult) {
                    RescanWifiV2Activity.this.O000000o((ScanResult) obj);
                } else if (obj instanceof BleDeviceGroup) {
                    RescanWifiV2Activity.this.configComDeviceConnection((BleDeviceGroup) obj);
                }
            }
        });
        this.O00000oO.setAdapter((ListAdapter) this.O00000oo);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("mj_kuailian_config_success");
            CommonApplication.getApplication().registerReceiver(this.O0000oO0, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        connectByHand();
    }

    private void O00000Oo() {
        if (this.mBottomTimeoutLayout.getVisibility() != 0 && this.O0000o00) {
            ArrayList arrayList = new ArrayList();
            O000000o(this.O0000OOo, this.O0000Oo0);
            arrayList.addAll(this.O0000OOo);
            arrayList.addAll(this.O0000Oo0);
            if (arrayList.size() > 0) {
                this.O00000Oo.setVisibility(0);
            } else {
                this.O00000Oo.setVisibility(4);
            }
            this.O00000o.O000000o(arrayList);
            this.O00000oo.O000000o(arrayList);
        }
    }

    private static void O000000o(List<ScanResult> list, List<BleDeviceGroup> list2) {
        HashMap hashMap = new HashMap();
        for (int size = list.size() - 1; size >= 0; size--) {
            ScanResult scanResult = list.get(size);
            String O00000o02 = DeviceFactory.O00000o0(scanResult.BSSID, scanResult.SSID);
            if (O00000o02 != null) {
                hashMap.put(O00000o02.toUpperCase(Locale.ENGLISH), scanResult);
            }
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            BleDevice bleDevice = list2.get(size2);
            MiotBleAdvPacket O00000Oo2 = bleDevice.O00000Oo();
            if (DeviceFactory.O00000Oo(bleDevice) && O00000Oo2 != null && O00000Oo2.O00000oo != null && hashMap.containsKey(O00000Oo2.O00000oo.toUpperCase(Locale.ENGLISH))) {
                list2.remove(size2);
            }
        }
    }

    public void connectByHand() {
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
            apConnectFailedStep.O000OOo0 = this.O0000o;
            apConnectFailedStep.O00000o0(this);
            viewGroup.addView(this.mConnectFailedStep.O000O0Oo());
            this.mProgressbar.O00000Oo();
            SmartConfigRouterFactory.getCoreApiManager().stopScan();
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        }
    }

    public boolean isComboDevice() {
        PluginDeviceInfo pluginInfo;
        if (TextUtils.isEmpty(this.mModel) || (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.mModel)) == null) {
            return false;
        }
        if (pluginInfo.O00000o() == 3 || pluginInfo.O00000o() == 20 || pluginInfo.O00000o() == 18) {
            return true;
        }
        return false;
    }

    private void O00000o0() {
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
                    this.O0000O0o.add(pluginDeviceInfo.O00000Oo());
                }
            }
            this.O0000O0o.add(this.mModel);
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
        if (this.mOtherAllContent.getVisibility() == 0) {
            O00000o();
            this.mOtherAllContent.setVisibility(8);
            return;
        }
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
        this.mProgressbar.O00000o0();
        this.mScanTitle.setText((int) R.string.miui_earphone_scanning);
        this.mScanDesTv.setText((int) R.string.scanning_device_please_wait);
        this.mTxtAreaNotSupportNearBYDevices.setVisibility(4);
        this.mConnectTips.setVisibility(8);
        this.mBottomTimeoutLayout.setVisibility(8);
        this.mScanLottie.setVisibility(0);
        this.mScanNoDeviceImg.setVisibility(8);
        this.mProgressbar.O000000o();
        iaf.O000000o().O000000o(this.mModel);
        if (isComboDevice()) {
            fob.O000000o(new SearchRequest.O000000o().O00000Oo(5000, this.mTimeout / 5000).O000000o(), (fon) null);
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
        O00000o();
    }

    private void O00000o() {
        int i = 2;
        O000000o("onResume, WLAN 打开 = %s, 地理位置权限打开 = %s", Boolean.valueOf(gof.O00000Oo()), Boolean.valueOf(fwq.O00000Oo() && fwq.O000000o()));
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE);
        if (this.mConnectFailedStep == null) {
            boolean findApDevice = findApDevice();
            if (findApDevice) {
                i = 1;
            }
            this.O0000OoO = i;
            if (findApDevice) {
                this.findWifiDevice = true;
                O000000o();
            }
            if (!findApDevice && !findApDirectDevice()) {
                IntentFilter intentFilter = new IntentFilter("wifi_scan_result_broadcast");
                intentFilter.addAction("ap_device_msg");
                if (isComboDevice()) {
                    intentFilter.addAction(fob.f16735O000000o);
                }
                ft.O000000o(this).O000000o(this.O0000o0o, intentFilter);
                SmartConfigRouterFactory.getCoreApiManager().setScanTimePeriod(2000);
                iaf.O000000o().O000000o(this.mModel);
                if (isComboDevice()) {
                    fob.O000000o(new SearchRequest.O000000o().O000000o(5000, this.mTimeout / 5000).O000000o(), (fon) null);
                }
                this.mProgressbar.O00000o0();
                this.mScanTitle.setText((int) R.string.miui_earphone_scanning);
                this.mScanDesTv.setText((int) R.string.scanning_device_please_wait);
                this.mTxtAreaNotSupportNearBYDevices.setVisibility(4);
                this.mConnectTips.setVisibility(8);
                this.mBottomTimeoutLayout.setVisibility(8);
                this.mScanLottie.setVisibility(0);
                this.mScanNoDeviceImg.setVisibility(8);
                if (eyr.O00000Oo().O00000oO(this.mModel)) {
                    this.mTimeout = 40000;
                } else {
                    this.mTimeout = 30000;
                }
                this.mProgressbar.setTime(this.mTimeout);
                this.mProgressbar.O000000o();
            }
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_scan_device(0, this.mModel);
    }

    public void onPause() {
        super.onPause();
        pause();
    }

    public void pause() {
        this.mProgressbar.O00000Oo();
        ft.O000000o(this).O000000o(this.O0000o0o);
        SmartConfigRouterFactory.getCoreApiManager().setScanTimePeriod(C.MSG_CUSTOM_BASE);
        SmartConfigRouterFactory.getCoreApiManager().stopScan();
        if (isComboDevice()) {
            fob.O00000o0();
        }
        SmartConfigRouterFactory.getStatPageV2Manager().page_scan_device(this.mEnterTime, this.mModel);
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.mModel, BindStep.STEP_SCAN_DEVICE, "pause scan");
    }

    public void onStop() {
        super.onStop();
        gsy.O00000Oo(TAG, "onStop");
        if (!this.findWifiDevice && this.O0000Ooo && !this.doConnectByHand) {
            O000000o();
            this.O0000Ooo = false;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.O0000o0);
        unregisterReceiver(this.O0000o0O);
        try {
            CommonApplication.getApplication().unregisterReceiver(this.O0000oO0);
        } catch (Exception unused) {
        }
    }

    public void findBleDevice() {
        if (this.mComboBleDevice == null && this.mScanResult == null) {
            List<BleDeviceGroup> O000000o2 = fob.O000000o();
            if (this.mModel != null) {
                this.O0000Oo0.clear();
                for (BleDeviceGroup next : O000000o2) {
                    if (!(this.f12002O000000o == null || next.mac == null)) {
                        next.mac.replace(":", "");
                        LogType logType = LogType.KUAILIAN;
                        String str = TAG;
                        gsy.O00000o0(logType, str, "RescanWifiV2Activity search device : " + next.toString());
                        if (!(next.O00000Oo() == null || next.O00000Oo().O00000oo == null)) {
                            LogType logType2 = LogType.KUAILIAN;
                            String str2 = TAG;
                            gsy.O00000o0(logType2, str2, "RescanWifiV2Activity search ble combo key : " + next.O00000Oo().O00000oo);
                        }
                        String str3 = this.f12002O000000o;
                        String substring = str3.substring(str3.length() - 4);
                        gsy.O00000o0(LogType.KUAILIAN, TAG, "mMacLast4 : ".concat(String.valueOf(substring)));
                        if (!(next.O00000Oo() == null || next.O00000Oo().f6871O000000o == null || next.O00000Oo().O00000oo == null || !substring.equalsIgnoreCase(next.O00000Oo().O00000oo))) {
                            LogType logType3 = LogType.KUAILIAN;
                            String str4 = TAG;
                            gsy.O00000o0(logType3, str4, "RescanWifiV2Activity find ble device mac = " + this.f12002O000000o);
                            this.mComboBleDevice = next;
                            this.mHandler.postDelayed(this.O0000o0, 5000);
                            return;
                        }
                    }
                }
                for (BleDeviceGroup next2 : O000000o2) {
                    Iterator<String> it = this.O0000O0o.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next3 = it.next();
                            if (!(next2.O00000Oo() == null || next2.O00000Oo().f6871O000000o == null || next2.O00000Oo().O00000oo == null)) {
                                if (next2.O00000oO(next3)) {
                                    gsy.O00000o0(LogType.KUAILIAN, "ScanResult", "RescanWifiV2Activity find ble combo device");
                                    this.mComboBleDevice = next2;
                                    this.mHandler.postDelayed(this.O0000o0, 5000);
                                    return;
                                } else if (DeviceFactory.O0000OOo(next3, next2.model)) {
                                    this.O0000Oo0.add(next2);
                                }
                            }
                        }
                    }
                }
                if (this.O0000Oo0.size() > 0) {
                    O00000Oo();
                }
            }
        }
    }

    public boolean findApDevice() {
        gsy.O00000Oo("RescanWifi", "findApDevice " + iae.O00000o0);
        this.O0000OOo.clear();
        if (iae.O00000o0 == null) {
            return false;
        }
        Iterator<ScanResult> it = iae.O00000o0.iterator();
        while (it.hasNext()) {
            ScanResult next = it.next();
            if (this.mScanResult == null || DeviceFactory.O00000oO(next) != DeviceFactory.AP_TYPE.AP_MIAP || !DeviceFactory.O0000Oo(this.mScanResult).equals(DeviceFactory.O0000Oo(next))) {
                String str = this.f12002O000000o;
                if (str != null) {
                    if (DeviceFactory.O00000oO(next) != DeviceFactory.AP_TYPE.AP_MIAP || !DeviceFactory.O00000o0(this.f12002O000000o, (String) null).equalsIgnoreCase(DeviceFactory.O0000Oo(next))) {
                        O00000Oo(next);
                    } else {
                        this.mScanResult = next;
                        O000000o(next);
                        this.mProgressbar.O00000Oo();
                        gsy.O00000Oo("RescanWifi", "find device use mac " + this.f12002O000000o);
                        return true;
                    }
                } else if (!(this.mScanResult == null && str == null) && (htt.O000000o(this.mModel) || htt.O00000Oo(this.mModel))) {
                    O00000Oo(next);
                } else {
                    for (String next2 : this.O0000O0o) {
                        if (next2 != null && DeviceFactory.O00000oO(DeviceFactory.O00000Oo(next), next2)) {
                            O000000o(next);
                            this.mProgressbar.O00000Oo();
                            gsy.O00000Oo("RescanWifi", "find device use mSearchModels ");
                            return true;
                        }
                    }
                    O00000Oo(next);
                }
            } else {
                this.mScanResult = next;
                O000000o(next);
                this.mProgressbar.O00000Oo();
                return true;
            }
        }
        if (this.O0000OOo.size() <= 0) {
            return false;
        }
        O00000Oo();
        return false;
    }

    private void O00000Oo(ScanResult scanResult) {
        if (scanResult != null && DeviceFactory.O0000OOo(DeviceFactory.O00000Oo(scanResult), this.mModel)) {
            this.O0000OOo.add(scanResult);
        }
    }

    public boolean findApDirectDevice() {
        if (DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice() == null || DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice().size() <= 0) {
            return false;
        }
        for (ScanResult next : DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice()) {
            if (this.mScanResult == null || DeviceFactory.O00000o0(next) != DeviceFactory.AP_TYPE.AP_MIDEVICE || !DeviceFactory.O0000Oo(this.mScanResult).equals(DeviceFactory.O0000Oo(next))) {
                Iterator<String> it = this.O0000O0o.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next2 = it.next();
                        if (next2 != null && DeviceFactory.O00000oO(DeviceFactory.O00000o(next), next2)) {
                            O000000o(next);
                            this.mProgressbar.O00000Oo();
                            return true;
                        }
                    }
                }
            } else {
                this.mScanResult = next;
                O000000o(next);
                this.mProgressbar.O00000Oo();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(ScanResult scanResult) {
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
     arg types: [com.xiaomi.smarthome.wificonfig.RescanWifiV2Activity, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
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
            StringBuilder sb = new StringBuilder("RescanWifiV2Activity ");
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
                    gsy.O00000o0(LogType.KUAILIAN, "checkScanResult", "RescanWifiV2Activity " + next.SSID);
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
        long j = this.O0000Oo;
        SmartConfigRouterFactory.getStatResultManager().scanWifiResult(this.mModel, this.findWifiDevice, j > 0 ? (int) ((currentTimeMillis - j) / 1000) : 0, this.O0000OoO, this.scanRepeat, !this.findWifiDevice ? O00000oO() : 0);
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

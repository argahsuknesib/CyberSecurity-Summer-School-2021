package com.xiaomi.miconnect;

import _m_j.dck;
import _m_j.dcn;
import _m_j.dco;
import _m_j.dcp;
import _m_j.dct;
import _m_j.dcv;
import _m_j.dcz;
import _m_j.ddm;
import _m_j.dwy;
import _m_j.ei;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fte;
import _m_j.gnl;
import _m_j.htr;
import _m_j.htz;
import _m_j.huk;
import _m_j.huw;
import _m_j.hwn;
import _m_j.jdn;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.miot.BinderParcel;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.Stack;

public class MiConnectConfigActivity extends BaseActivity implements dck {

    /* renamed from: O000000o  reason: collision with root package name */
    FrameLayout f5990O000000o;
    SmartConfigStep.O000000o O00000Oo = new SmartConfigStep.O000000o() {
        /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass1 */

        public final void O000000o() {
            dct.O00000oO("MiConnectConfigActivity onCurrentStepFinish");
            if (!MiConnectConfigActivity.this.mStepStack.isEmpty()) {
                MiConnectConfigActivity.this.mStepStack.pop();
            }
            if (MiConnectConfigActivity.this.mStepStack.empty()) {
                dct.O00000oO("MiConnectConfigActivity onCurrentStepFinish mConfigStep = " + MiConnectConfigActivity.this.mConfigStep.toString());
                MiConnectConfigActivity miConnectConfigActivity = MiConnectConfigActivity.this;
                miConnectConfigActivity.switchToStep(miConnectConfigActivity.mConfigStep);
                MiConnectConfigActivity.this.mConfigStep = null;
                return;
            }
            MiConnectConfigActivity miConnectConfigActivity2 = MiConnectConfigActivity.this;
            SmartConfigStep peek = miConnectConfigActivity2.mStepStack.peek();
            miConnectConfigActivity2.f5990O000000o.removeAllViews();
            peek.O00oOoOo();
            if (peek.O000O0Oo() != null) {
                miConnectConfigActivity2.f5990O000000o.addView(peek.O000O0Oo());
            }
        }

        public final void O000000o(SmartConfigStep.Step step) {
            if (step != null) {
                dct.O00000oO("MiConnectConfigActivity onCurrentStepFinish  nextStep = " + step.name());
            }
            if (!MiConnectConfigActivity.this.mStepStack.isEmpty()) {
                MiConnectConfigActivity.this.mStepStack.pop();
            }
            SmartConfigStep O00000o0 = SmartConfigStep.O00000o0(step);
            O00000o0.O000Ooo0 = true;
            MiConnectConfigActivity.this.switchToStep(O00000o0);
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
            if (step != null) {
                dct.O00000oO("MiConnectConfigActivity onCurrentStepPause  nextStep = " + step.name());
            }
            SmartConfigStep O00000o0 = SmartConfigStep.O00000o0(step);
            O00000o0.O000Ooo0 = true;
            MiConnectConfigActivity.this.switchToStep(O00000o0);
        }

        public final Handler O00000Oo() {
            return MiConnectConfigActivity.this.mHandler;
        }

        public final void O000000o(boolean z) {
            dct.O00000oO(" onConfigSuccess");
            Device device = (Device) htr.O000000o().O000000o("connected_device");
            if (device == null) {
                MiConnectConfigActivity.this.finishConnect();
                return;
            }
            dco.O000000o().O000000o(device);
            dcp.O000000o().O000000o(device.mac);
            if (MiConnectConfigActivity.this.mIsUwbDevice) {
                if (MiConnectConfigActivity.this.mBindParcel != null) {
                    IConfigCompletionHandler asInterface = IConfigCompletionHandler.Stub.asInterface(MiConnectConfigActivity.this.mBindParcel.f6030O000000o);
                    if (asInterface != null) {
                        try {
                            dct.O00000oO("handler onSucceed:".concat(String.valueOf(device)));
                            asInterface.onSucceed(device.did);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    dct.O00000o0("handler is null");
                }
                MiConnectConfigActivity.this.finishConnect();
                return;
            }
            MiConnectConfigActivity.this.getDeviceInfoAndShow();
        }
    };
    private final int O00000o = 1001;
    private String O00000o0;
    private int O00000oO;
    private String O00000oo;
    public boolean isSuccessViewShowing = false;
    public BinderParcel mBindParcel;
    public SmartConfigStep mConfigStep;
    public SmartConfigStep mCurrentStep;
    public boolean mIsUwbDevice = false;
    public Stack<SmartConfigStep> mStepStack = new Stack<>();

    public void getDeviceInfoAndShow() {
        final PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O00000o0);
        String str = dcp.O000000o().O00000Oo;
        if (TextUtils.isEmpty(str)) {
            str = pluginInfo.O0000o0();
        }
        this.isSuccessViewShowing = true;
        dcz dcz = new dcz(getContext(), str, new View.OnClickListener() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (MiConnectConfigActivity.this.isSuccessViewShowing) {
                    dcv.f14488O000000o.O000000o();
                    MiConnectConfigActivity.this.enterPlugin(pluginInfo);
                    MiConnectConfigActivity.this.isSuccessViewShowing = false;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f5990O000000o.addView(dcz.O000000o(), layoutParams);
    }

    public void enterPlugin(PluginDeviceInfo pluginDeviceInfo) {
        huw installInfo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(pluginDeviceInfo.O00000Oo());
        if (installInfo == null) {
            dct.O00000oO("enterPlugin pluginRecord null");
        } else {
            dct.O00000oO("enterPlugin pluginRecord " + installInfo.toString());
        }
        if (installInfo == null || (!installInfo.O000000o() && !installInfo.O00000Oo())) {
            fbt fbt = new fbt(this, "SmartHomeMainActivity");
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
            dct.O00000oO("isDownloaded false or isPluginDevice false");
            finishConnect();
            return;
        }
        dct.O00000oO("enterPlugin");
        SmartConfigRouterFactory.getSmartConfigManager().sendMessage(this, pluginDeviceInfo.O00000Oo(), 1, new Intent(), (Device) htr.O000000o().O000000o("connected_device"), false, new huk() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass5 */

            public final void O000000o() {
                dct.O00000oO("onDownloadStart");
            }

            public final void O00000Oo() {
                dct.O00000oO("onDownloadSuccess");
            }

            public final void O00000o0() {
                dct.O00000oO("onDownloadFailure");
            }

            public final void O00000o() {
                dct.O00000oO("onDownloadCancel");
            }

            public final void O00000oO() {
                MiConnectConfigActivity.this.finishConnect();
                dct.O00000oO("onSendSuccess");
            }

            public final void O00000oo() {
                MiConnectConfigActivity.this.finishConnect();
                dct.O00000oO("onSendCancel");
            }

            public final void O000000o(String str) {
                fbt fbt = new fbt(MiConnectConfigActivity.this, "SmartHomeMainActivity");
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
                MiConnectConfigActivity.this.finishConnect();
                dct.O00000oO("onSendFailure " + str.toString());
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getWindow().addFlags(524288);
        super.onCreate(bundle);
        setContentView((int) R.layout.miconnect_activity_config);
        this.f5990O000000o = (FrameLayout) findViewById(R.id.main_container);
        findViewById(R.id.blank_view).setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    MiConnectConfigActivity.this.showExitDialog();
                }
                return true;
            }
        });
        this.f5990O000000o.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.O00000o0 = getIntent().getStringExtra("model");
        this.mIsUwbDevice = getIntent().getBooleanExtra("is_uwb", false);
        if (this.mIsUwbDevice) {
            if (!dcp.O000000o().O00000Oo()) {
                dcp.O000000o().O000000o(getContext().getApplicationContext());
            }
            this.mBindParcel = (BinderParcel) getIntent().getParcelableExtra("handler");
            String stringExtra = getIntent().getStringExtra("mac_suffix");
            final dwy dwy = new dwy();
            dwy.O00000oO = stringExtra;
            dwy.O00000oo = new dwy.O000000o() {
                /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass8 */

                public final void O000000o(BleDevice bleDevice) {
                    ei O000000o2 = MiConnectConfigActivity.this.getSupportFragmentManager().O000000o();
                    O000000o2.O000000o(dwy);
                    O000000o2.O00000Oo();
                    htr.O000000o().O00000Oo("combo_ble_mac", bleDevice.mac);
                    htr.O000000o().O00000Oo("combo_ble_key", bleDevice.O00000Oo() != null ? bleDevice.O00000Oo().O00000oo : "");
                    htr.O000000o().O00000Oo("bluetooth_search_result", new BluetoothSearchResult(gnl.O00000Oo(bleDevice.mac), bleDevice.rssi, bleDevice.scanRecord));
                    MiConnectConfigActivity.this.checkRoomAndHome();
                }
            };
            ei O000000o2 = getSupportFragmentManager().O000000o();
            O000000o2.O000000o((int) R.id.main_container, dwy);
            O000000o2.O00000Oo();
            return;
        }
        String stringExtra2 = getIntent().getStringExtra("mitv_atype");
        if (TextUtils.isEmpty(stringExtra2) || stringExtra2.equals("init")) {
            checkRoomAndHome();
        } else {
            parseIntent();
        }
    }

    public void parseIntent() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("model");
        if (stringExtra != null) {
            htr.O000000o().O00000Oo("device_model", stringExtra);
            this.O00000oO = intent.getIntExtra("connect_source", 0);
            this.O00000oo = intent.getStringExtra("connect_unique");
            SmartConfigRouterFactory.getStatClickManager().adddevice_connectdevice(this.O00000o0, this.O00000oO, this.O00000oo);
        }
        if (!this.mIsUwbDevice) {
            String stringExtra2 = intent.getStringExtra("mac");
            if (stringExtra2 != null) {
                htr.O000000o().O00000Oo("combo_ble_mac", stringExtra2);
            }
            String stringExtra3 = intent.getStringExtra("combo_ble_key");
            if (stringExtra3 != null) {
                htr.O000000o().O00000Oo("combo_ble_key", stringExtra3);
            }
            BluetoothSearchResult bluetoothSearchResult = (BluetoothSearchResult) intent.getParcelableExtra("ble_result");
            if (bluetoothSearchResult != null) {
                htr.O000000o().O00000Oo("bluetooth_search_result", bluetoothSearchResult);
            }
        }
        String stringExtra4 = intent.getStringExtra("mitv_did");
        String stringExtra5 = intent.getStringExtra("mitv_atype");
        if (!TextUtils.isEmpty(stringExtra4)) {
            htr.O000000o().O00000Oo("mitv_did", stringExtra4);
        }
        if (!TextUtils.isEmpty(stringExtra5)) {
            htr.O000000o().O00000Oo("mitv_action", stringExtra5);
        }
        this.mConfigStep = SmartConfigStep.O00000o0((SmartConfigStep.Step) intent.getSerializableExtra("step"));
        this.mConfigStep.O000Ooo0 = true;
        if (SmartConfigRouterFactory.getSmartConfigManager().checkLocationGroupGranted()) {
            checkLocation();
            return;
        }
        dcp.O000000o().O000000o(true);
        SmartConfigRouterFactory.getSmartConfigManager().checkAndRequestCameraPermission(this, new htz() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass11 */

            public final void O00000o() {
            }

            public final void O000000o() {
                dcp.O000000o().O000000o(false);
                MiConnectConfigActivity.this.checkLocation();
            }

            public final void O00000Oo() {
                dcp.O000000o().O000000o(false);
                MiConnectConfigActivity.this.finishConnect();
            }

            public final void O00000o0() {
                dcp.O000000o().O000000o(false);
                MiConnectConfigActivity.this.finishConnect();
            }
        }, getString(R.string.permission_location_rational_desc_new));
    }

    private void O000000o() {
        String str;
        dcp.O000000o().O000000o(false);
        if (this.mIsUwbDevice) {
            try {
                WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    str = "";
                } else {
                    str = connectionInfo.getSSID();
                }
                if (TextUtils.isEmpty(str) || str.contains("unknown ssid")) {
                    str = BaseWifiSettingUtils.O000000o(this, wifiManager);
                }
                if (str.startsWith(jdn.f1779O000000o) && str.length() > 2) {
                    str = str.substring(1, str.length() - 1);
                }
                if (checkWifiCondition(this.O00000o0, connectionInfo, str)) {
                    String O00000o02 = dcp.O000000o().O00000o0(str);
                    htr.O000000o().O00000Oo("selected_ap_ssid", str);
                    htr.O000000o().O00000Oo("selected_ap_passwd", O00000o02);
                    dct.O00000o0("config ssid: " + str + ", pwd: " + fte.O000000o(O00000o02));
                    switchToStep(this.mConfigStep);
                    return;
                }
                dct.O00000o0("config ssid: " + str + ", 5G not support, select wifi mannually!");
                switchToStep(new hwn());
            } catch (Exception e) {
                dct.O00000o0("miui wifi passwd get failed: " + e.getMessage());
            }
        } else {
            switchToStep(new hwn());
        }
    }

    public static boolean checkWifiCondition(String str, WifiInfo wifiInfo, String str2) {
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str);
        if (pluginInfo == null) {
            pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getExtraPluginInfo(str);
        }
        if (wifiInfo == null || pluginInfo == null || Build.VERSION.SDK_INT < 21 || pluginInfo.O00000oo()) {
            return true;
        }
        return wifiInfo.getFrequency() <= 4900 && !DeviceFactory.O00000o(str2);
    }

    public void checkRoomAndHome() {
        if (dco.O000000o().O00000Oo() == null || dco.O000000o().O00000Oo().size() <= 0) {
            parseIntent();
            return;
        }
        final dcn O00000Oo2 = dcn.O00000Oo();
        O00000Oo2.O0000O0o = new dcn.O000000o() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass9 */

            public final void O000000o() {
                ei O000000o2 = MiConnectConfigActivity.this.getSupportFragmentManager().O000000o();
                O000000o2.O000000o(O00000Oo2);
                O000000o2.O00000Oo();
                MiConnectConfigActivity.this.parseIntent();
            }
        };
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O000000o((int) R.id.main_container, O00000Oo2);
        O000000o2.O00000Oo();
    }

    public void handleMessage(Message message) {
        if (!this.mStepStack.empty()) {
            this.mStepStack.peek().O000000o(message);
        }
    }

    public void switchToStep(SmartConfigStep smartConfigStep) {
        if (smartConfigStep == null) {
            dct.O00000o0("switchToStep but null");
            finishConnect();
            return;
        }
        this.f5990O000000o.removeAllViews();
        this.mCurrentStep = smartConfigStep;
        smartConfigStep.O000OOo0 = this.O00000Oo;
        smartConfigStep.O00000o0(this);
        if (smartConfigStep.O000O0Oo() != null) {
            this.f5990O000000o.addView(smartConfigStep.O000O0Oo());
            this.mStepStack.push(smartConfigStep);
        }
    }

    public void onBackPressed() {
        showExitDialog();
    }

    public void showExitDialog() {
        if (this.isSuccessViewShowing) {
            SmartConfigStep smartConfigStep = this.mCurrentStep;
            if (smartConfigStep != null) {
                smartConfigStep.O0000O0o();
            }
            finishConnect();
            return;
        }
        ddm ddm = new ddm();
        ddm.f14500O000000o = new Runnable() {
            /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass10 */

            public final void run() {
                if (MiConnectConfigActivity.this.mCurrentStep != null) {
                    MiConnectConfigActivity.this.mCurrentStep.O0000O0o();
                }
                MiConnectConfigActivity.this.finishConnect();
            }
        };
        dcv.O00000Oo.O00000Oo();
        ddm.show(getSupportFragmentManager(), "show exit dialog");
    }

    public void finishConnect() {
        BinderParcel binderParcel;
        IConfigCompletionHandler asInterface;
        dct.O00000o0(" MiConnectConfigActivity finishConnect");
        if (this.mIsUwbDevice && ((Device) htr.O000000o().O000000o("connected_device")) == null && (binderParcel = this.mBindParcel) != null && (asInterface = IConfigCompletionHandler.Stub.asInterface(binderParcel.f6030O000000o)) != null) {
            try {
                dct.O00000oO("config failed!");
                asInterface.onFailed(-1, "config failed!");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        finish();
        dcp.O000000o().O000000o((Activity) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            dct.O00000oO("MiConnectConfigActivity onActivityResult");
            if (SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
                dcp.O000000o().O000000o(false);
                O000000o();
                if (!this.mStepStack.isEmpty()) {
                    this.mStepStack.peek().O000000o(i, i2, intent);
                    return;
                }
                return;
            }
        } else {
            if (i == 4000) {
                dcp.O000000o().O000000o(false);
                if (SmartConfigRouterFactory.getSmartConfigManager().checkLocationGroupGranted()) {
                    checkLocation();
                }
            }
            if (!this.mStepStack.isEmpty()) {
            }
        }
        finishConnect();
        if (!this.mStepStack.isEmpty()) {
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void checkLocation() {
        if (!SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
            new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.open_location_permission1)).O000000o(false).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    MiConnectConfigActivity.this.finishConnect();
                    dcp.O000000o().O000000o(false);
                }
            }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.miconnect.MiConnectConfigActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dcp.O000000o().O000000o(true);
                    MiConnectConfigActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1001);
                }
            }).O00000o().show();
        } else {
            O000000o();
        }
    }
}

package com.xiaomi.smarthome.nfctag.ui;

import _m_j.exo;
import _m_j.ext;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fmd;
import _m_j.fno;
import _m_j.fob;
import _m_j.fon;
import _m_j.fso;
import _m_j.ftn;
import _m_j.fwq;
import _m_j.gge;
import _m_j.gnl;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hif;
import _m_j.hig;
import _m_j.hor;
import _m_j.hxi;
import _m_j.hxk;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.Iterator;
import java.util.Map;

public class NFCOpenDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f10427O000000o;
    private boolean O00000Oo;
    private final int O00000o = 1012;
    private final int O00000o0 = 1011;
    public int count = 0;
    public boolean isFindTarget;
    public View mLayoutLoading;
    public O000000o mListener;
    public String mMac;
    public String mModel;
    public fon mSearchResponse = new fon() {
        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass1 */

        public final /* synthetic */ void O000000o(Object obj) {
            BleDevice bleDevice = (BleDevice) obj;
            if (!NFCOpenDeviceActivity.this.isFindTarget) {
                String replace = bleDevice.mac.replace(":", "");
                if (!TextUtils.isEmpty(NFCOpenDeviceActivity.this.mMac) && NFCOpenDeviceActivity.this.mMac.equalsIgnoreCase(replace)) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "NFC_OpenDeviceActivity", "onReceive bleDevice " + bleDevice.toString());
                    NFCOpenDeviceActivity nFCOpenDeviceActivity = NFCOpenDeviceActivity.this;
                    nFCOpenDeviceActivity.isFindTarget = true;
                    nFCOpenDeviceActivity.mLayoutLoading.setVisibility(4);
                    if (NFCOpenDeviceActivity.this.mHandler.hasCallbacks(NFCOpenDeviceActivity.this.textAnimation)) {
                        NFCOpenDeviceActivity.this.mHandler.removeCallbacks(NFCOpenDeviceActivity.this.textAnimation);
                    }
                    NFCOpenDeviceActivity.this.showNFCConnectDialog(bleDevice, true);
                    if (!fob.O00000Oo()) {
                        fob.O00000o0();
                    }
                }
            }
        }

        public final void O000000o() {
            NFCOpenDeviceActivity.this.mLayoutLoading.setVisibility(0);
            if (NFCOpenDeviceActivity.this.mHandler.hasCallbacks(NFCOpenDeviceActivity.this.textAnimation)) {
                NFCOpenDeviceActivity.this.mHandler.removeCallbacks(NFCOpenDeviceActivity.this.textAnimation);
            }
            NFCOpenDeviceActivity.this.mHandler.post(NFCOpenDeviceActivity.this.textAnimation);
        }

        public final void O00000Oo() {
            NFCOpenDeviceActivity.this.mLayoutLoading.setVisibility(4);
            if (NFCOpenDeviceActivity.this.mHandler.hasCallbacks(NFCOpenDeviceActivity.this.textAnimation)) {
                NFCOpenDeviceActivity.this.mHandler.removeCallbacks(NFCOpenDeviceActivity.this.textAnimation);
            }
            if (!NFCOpenDeviceActivity.this.isFindTarget) {
                NFCOpenDeviceActivity.this.showNFCConnectDialog(null, false);
            }
        }

        public final void O00000o0() {
            NFCOpenDeviceActivity.this.mLayoutLoading.setVisibility(4);
            if (NFCOpenDeviceActivity.this.mHandler.hasCallbacks(NFCOpenDeviceActivity.this.textAnimation)) {
                NFCOpenDeviceActivity.this.mHandler.removeCallbacks(NFCOpenDeviceActivity.this.textAnimation);
            }
            if (!NFCOpenDeviceActivity.this.isFindTarget && NFCOpenDeviceActivity.this.isValid()) {
                NFCOpenDeviceActivity.this.finish();
            }
        }
    };
    public TextView mTxtLoading;
    public Runnable textAnimation = new Runnable() {
        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass6 */

        public final void run() {
            if (NFCOpenDeviceActivity.this.mTxtLoading != null) {
                if (NFCOpenDeviceActivity.this.count < 3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(NFCOpenDeviceActivity.this.getString(R.string.miconnect_loading));
                    for (int i = 0; i <= NFCOpenDeviceActivity.this.count; i++) {
                        sb.append(".");
                    }
                    NFCOpenDeviceActivity.this.mTxtLoading.setText(sb.toString());
                } else {
                    NFCOpenDeviceActivity nFCOpenDeviceActivity = NFCOpenDeviceActivity.this;
                    nFCOpenDeviceActivity.count = 0;
                    nFCOpenDeviceActivity.mTxtLoading.setText(NFCOpenDeviceActivity.this.getString(R.string.miconnect_loading));
                }
                NFCOpenDeviceActivity.this.count++;
                NFCOpenDeviceActivity.this.mHandler.postDelayed(NFCOpenDeviceActivity.this.textAnimation, 400);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = getIntent().getBooleanExtra("need_connect", false);
        LogType logType = LogType.GENERAL;
        gsy.O00000o0(logType, "NFC_OpenDeviceActivity", "needConnect" + this.O00000Oo);
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass7 */

            public final void O000000o() {
                NFCOpenDeviceActivity.this.finish();
            }

            public final void O00000Oo() {
                NFCOpenDeviceActivity.this.finish();
            }

            public final void O00000o0() {
                hif.O000000o();
                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                    gty.O000000o().startLogin(NFCOpenDeviceActivity.this, 1, new gtx.O000000o() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass7.AnonymousClass1 */

                        public final void O000000o() {
                            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                                gqg.O000000o((int) R.string.login_fail);
                                NFCOpenDeviceActivity.this.finish();
                                return;
                            }
                            NFCOpenDeviceActivity.this.doWork();
                        }
                    });
                } else {
                    NFCOpenDeviceActivity.this.doWork();
                }
            }
        });
    }

    public void doWork() {
        if (ftn.O00000oO(ServiceApplication.getAppContext()) || !hig.O00000oo()) {
            finish();
            return;
        }
        this.mMac = getIntent().getStringExtra("device_mac");
        this.f10427O000000o = getIntent().getStringExtra("device_id");
        this.mModel = getIntent().getStringExtra("user_model");
        LogType logType = LogType.GENERAL;
        gsy.O00000o0(logType, "NFC_OpenDeviceActivity", "did = " + this.f10427O000000o + " model = " + this.mModel + "mac = " + this.mMac);
        setContentView((int) R.layout.activity_nfc_open_device);
        findViewById(R.id.dialog_container).setVisibility(8);
        this.mTxtLoading = (TextView) findViewById(R.id.txt_loading);
        this.mLayoutLoading = findViewById(R.id.layout_loading);
        O000000o(true, true, "", this.f10427O000000o, "", getIntent());
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, boolean z2, String str, String str2, String str3, Intent intent) {
        if (TextUtils.isEmpty(str2)) {
            finish();
            return;
        }
        final String str4 = str2;
        final String str5 = str3;
        final Intent intent2 = intent;
        final boolean z3 = z2;
        final boolean z4 = z;
        final String str6 = str;
        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass8 */

            public final void onLoginSuccess() {
                Device device;
                Device O000000o2 = fno.O000000o().O000000o(str4);
                gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "openDevice=".concat(String.valueOf(O000000o2)));
                if (O000000o2 == null) {
                    Map<String, Device> O00000oO2 = fno.O000000o().O00000oO();
                    gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "getAllDevices()");
                    if (O00000oO2 != null) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000o0(logType, "NFC_OpenDeviceActivity", "onlineDevices=" + O00000oO2.size());
                        Iterator<Map.Entry<String, Device>> it = O00000oO2.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            device = (Device) it.next().getValue();
                            if ((TextUtils.isEmpty(str5) || !(device instanceof MiTVDevice) || !str5.equals(((MiTVDevice) device).active_mac)) && ((TextUtils.isEmpty(str5) || TextUtils.isEmpty(device.mac) || !str5.equals(device.mac.toLowerCase())) && (TextUtils.isEmpty(str4) || TextUtils.isEmpty(device.did) || !str4.equals(device.did)))) {
                            }
                        }
                        O000000o2 = device;
                    }
                }
                if (O000000o2 == null) {
                    Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
                    gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "getOnlineSubDevice()");
                    if (O00000Oo2 != null) {
                        LogType logType2 = LogType.GENERAL;
                        gsy.O00000o0(logType2, "NFC_OpenDeviceActivity", "subDevices=" + O00000Oo2.size());
                        Iterator<Map.Entry<String, Device>> it2 = O00000Oo2.entrySet().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Device device2 = (Device) it2.next().getValue();
                            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(device2.did) && str4.equals(device2.did)) {
                                O000000o2 = device2;
                                break;
                            }
                        }
                    }
                }
                gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "end openDevice=".concat(String.valueOf(O000000o2)));
                if (O000000o2 != null) {
                    hxk hxk = hxi.O00000o;
                    String str = NFCOpenDeviceActivity.this.mModel;
                    hxk.f952O000000o.O000000o("NFC_Open_plugin", "model", str);
                    NFCOpenDeviceActivity.this.doOpenAction(intent2, O000000o2, z3);
                } else if (z4) {
                    NFCOpenDeviceActivity nFCOpenDeviceActivity = NFCOpenDeviceActivity.this;
                    nFCOpenDeviceActivity.mListener = new O000000o(str4, str5, str6, intent2, z3);
                    fno.O000000o().O000000o(NFCOpenDeviceActivity.this.mListener);
                    fno.O000000o().O0000Oo0();
                } else {
                    NFCOpenDeviceActivity.this.scanDeviceOrShowTipsDialog();
                }
            }

            public final void onLoginFailed() {
                gge.O000000o().O00000Oo();
                fno.O000000o().O0000Oo();
                hor.O000000o().clearSceneManager();
                fno.O000000o().O0000Oo0();
                fbt fbt = new fbt(NFCOpenDeviceActivity.this, "com.xiaomi.smarthome.SmartHomeMainActivity");
                fbt.O000000o("user_id", str6);
                fbs.O000000o(fbt);
                NFCOpenDeviceActivity.this.finish();
            }
        });
    }

    public void doOpenAction(Intent intent, Device device, final boolean z) {
        if (!device.isBinded() && !device.canUseNotBind) {
            new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.open_device_not_bound_alert)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O000000o(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass9 */

                public final void beforeDismissCallBack() {
                }

                public final void afterDismissCallBack() {
                    NFCOpenDeviceActivity.this.finish();
                }
            }).O00000oo();
        } else if (CoreApi.O000000o().O00000o(device.model)) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtras(intent);
            }
            final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(this, getString(R.string.plugin_downloading) + O00000oO.O0000Oo0() + getString(R.string.plugin));
            PluginApi.getInstance().sendMessage(this, device.model, 1, intent2, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, new SendMessageCallback() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass11 */

                public final void onDownloadStart(final String str, final PluginDownloadTask pluginDownloadTask) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && NFCOpenDeviceActivity.this.isActivityValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.O000000o(true);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass11.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                            }
                        });
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && NFCOpenDeviceActivity.this.isActivityValid() && (xQProgressHorizontalDialog = O000000o2) != null && xQProgressHorizontalDialog.isShowing()) {
                        O000000o2.O000000o(100, (int) (f * 100.0f));
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && NFCOpenDeviceActivity.this.isActivityValid() && (xQProgressHorizontalDialog = O000000o2) != null && xQProgressHorizontalDialog.isShowing()) {
                        O000000o2.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && NFCOpenDeviceActivity.this.isActivityValid() && (xQProgressHorizontalDialog = O000000o2) != null && xQProgressHorizontalDialog.isShowing()) {
                        O000000o2.dismiss();
                    }
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (z && NFCOpenDeviceActivity.this.isActivityValid() && (xQProgressHorizontalDialog = O000000o2) != null && xQProgressHorizontalDialog.isShowing()) {
                        O000000o2.dismiss();
                    }
                }

                public final void onSendSuccess(Bundle bundle) {
                    NFCOpenDeviceActivity.this.finish();
                }

                public final void onSendCancel() {
                    NFCOpenDeviceActivity.this.finish();
                }

                public final void onSendFailure(fso fso) {
                    NFCOpenDeviceActivity.this.finish();
                }
            });
        } else {
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            Device device2 = device;
            Intent action = ext.O000000o(device).getAction(device2, getApplicationContext(), bundle, false, null);
            if (action != null) {
                try {
                    startActivity(action);
                } catch (Exception unused) {
                }
            }
            finish();
        }
    }

    public boolean isActivityValid() {
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            return true;
        }
        return false;
    }

    class O000000o implements fno.O00000o {
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private Intent O00000oO;
        private boolean O00000oo;

        O000000o(String str, String str2, String str3, Intent intent, boolean z) {
            this.O00000Oo = str;
            this.O00000o0 = str2;
            this.O00000o = str3;
            this.O00000oO = intent;
            this.O00000oo = z;
        }

        public final void onDeviceReady(Map<String, Device> map) {
            NFCOpenDeviceActivity.this.O000000o(false, this.O00000oo, this.O00000o, this.O00000Oo, this.O00000o0, this.O00000oO);
        }
    }

    public void showNFCConnectDialog(BleDevice bleDevice, boolean z) {
        if (NFCDeviceDialogActivity.sResumed) {
            gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "NFCDeviceDialogActivity is resumed ");
            finish();
            return;
        }
        gsy.O00000o0(LogType.GENERAL, "NFC_OpenDeviceActivity", "show  NFCDeviceDialogActivity");
        Intent intent = new Intent(this, NFCDeviceDialogActivity.class);
        intent.putExtra("mac", this.mMac);
        intent.putExtra("did", this.f10427O000000o);
        intent.putExtra("model", this.mModel);
        intent.putExtra("isFindTarget", z);
        if (bleDevice != null) {
            intent.putExtra("ble_device", bleDevice.O000000o());
        }
        startActivity(intent);
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1011) {
            if (SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
                scanDeviceOrShowTipsDialog();
                return;
            }
        } else if (i != 1012) {
            return;
        } else {
            if (fwq.O000000o(this, "android.permission.ACCESS_FINE_LOCATION")) {
                scanDeviceOrShowTipsDialog();
                return;
            }
        }
        finish();
    }

    public void scanDeviceOrShowTipsDialog() {
        boolean z = false;
        if (this.O00000Oo) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.mModel);
            if (O00000oO == null) {
                finish();
            } else if (O00000oO.O00000o() == 2 || O00000oO.O00000o() == 3) {
                if (!SmartConfigRouterFactory.getSmartConfigManager().isLocationEnabled()) {
                    new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.open_location_permission1)).O000000o(false).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            NFCOpenDeviceActivity.this.finish();
                        }
                    }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass12 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            NFCOpenDeviceActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1011);
                        }
                    }).O00000o().show();
                } else if (fwq.O000000o(this, "android.permission.ACCESS_FINE_LOCATION")) {
                    z = true;
                } else {
                    new MLAlertDialog.Builder(this).O00000Oo(getResources().getString(R.string.open_location_permission)).O000000o(false).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            NFCOpenDeviceActivity.this.finish();
                        }
                    }).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Intent intent = new Intent();
                            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.parse("package:" + NFCOpenDeviceActivity.this.getPackageName()));
                            NFCOpenDeviceActivity.this.startActivityForResult(intent, 1012);
                        }
                    }).O00000o().show();
                }
                if (z) {
                    if (!gnl.O00000Oo()) {
                        fmd.O000000o(new BleResponse() {
                            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass4 */

                            public final void onResponse(int i, Object obj) {
                                if (i != 0) {
                                    NFCOpenDeviceActivity.this.finish();
                                    return;
                                }
                                gsy.O00000o0(LogType.KUAILIAN, "NFC_OpenDeviceActivity", "start Scan open");
                                fob.O00000o0();
                                fob.O000000o(new SearchRequest.O000000o().O00000Oo(3000, 1).O000000o(), NFCOpenDeviceActivity.this.mSearchResponse);
                            }
                        });
                        return;
                    }
                    gsy.O00000o0(LogType.KUAILIAN, "NFC_OpenDeviceActivity", "start Scan");
                    fob.O00000o0();
                    fob.O000000o(new SearchRequest.O000000o().O00000Oo(3000, 1).O000000o(), this.mSearchResponse);
                }
            } else {
                finish();
            }
        } else {
            findViewById(R.id.dialog_container).setVisibility(0);
            findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    NFCOpenDeviceActivity.this.finish();
                }
            });
            hxi.O00000oO.f958O000000o.O000000o("NFC_recog_fail", new Object[0]);
        }
    }
}

package com.xiaomi.smarthome.device.bluetooth.connect;

import _m_j.dco;
import _m_j.ddb;
import _m_j.ddf;
import _m_j.ddh;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fea;
import _m_j.fno;
import _m_j.fob;
import _m_j.foc;
import _m_j.fok;
import _m_j.fop;
import _m_j.foq;
import _m_j.fow;
import _m_j.foy;
import _m_j.foz;
import _m_j.fpa;
import _m_j.fpb;
import _m_j.fpo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fte;
import _m_j.gle;
import _m_j.gnj;
import _m_j.gnl;
import _m_j.got;
import _m_j.gpf;
import _m_j.grs;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.ing;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.TimeZone;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONObject;

public class BleBindBaseActivity extends ConnectBaseActivity implements foq {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f7107O000000o;
    protected int O00000Oo;
    protected int O00000o;
    protected String O00000o0;
    private String O00000oO;
    private MLAlertDialog O00000oo;
    private fpb O0000O0o = new fpb();
    private BleComboWifiConfig O0000OOo;
    private final fpa O0000Oo = new fpa() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass2 */

        public final void O000000o(int i) {
            int i2;
            if (i >= 0 && i <= 100) {
                if (i <= 60) {
                    i2 = (i * 100) / 60;
                } else if (i <= 80) {
                    i2 = ((i - 60) * 100) / 20;
                } else if (i <= 90) {
                    i2 = ((i - 80) * 100) / 10;
                } else {
                    i2 = i <= 99 ? ((i - 90) * 100) / 9 : i;
                }
                BleBindBaseActivity.this.mCommonBindView.setProgress(i2);
            }
            if (i == 100) {
                BleBindBaseActivity.this.refreshUIByStatus(44);
            }
        }
    };
    private gle O0000Oo0 = new gle() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass1 */

        public final void O000000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("%s onConnectResponse: code = %d", BleBindBaseActivity.this.tag, Integer.valueOf(i)));
            BleBindBaseActivity bleBindBaseActivity = BleBindBaseActivity.this;
            bleBindBaseActivity.mConnectErrorCode = i;
            bleBindBaseActivity.processConnectResponse(i, bundle);
        }

        public final void O00000Oo(int i, Bundle bundle) {
            fte.O00000Oo(String.format("%s onAuthResponse: code = %d", BleBindBaseActivity.this.tag, Integer.valueOf(i)));
            BleBindBaseActivity bleBindBaseActivity = BleBindBaseActivity.this;
            bleBindBaseActivity.mConnectErrorCode = i;
            bleBindBaseActivity.processAuthResponse(i, bundle);
        }

        public final void O00000o0(int i, Bundle bundle) {
            fte.O00000Oo(String.format("%s onBindResponse: code = %d", BleBindBaseActivity.this.tag, Integer.valueOf(i)));
            BleBindBaseActivity bleBindBaseActivity = BleBindBaseActivity.this;
            bleBindBaseActivity.mConnectErrorCode = i;
            bleBindBaseActivity.processBindResponse(i, bundle);
        }

        public final void O00000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("%s onLastResponse: code = %d", BleBindBaseActivity.this.tag, Integer.valueOf(i)));
            BleBindBaseActivity bleBindBaseActivity = BleBindBaseActivity.this;
            bleBindBaseActivity.mConnectErrorCode = i;
            bleBindBaseActivity.processLastResponse(i, bundle);
        }
    };
    private PopupWindow.OnDismissListener O0000OoO = new PopupWindow.OnDismissListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass3 */

        public final void onDismiss() {
            BleBindBaseActivity bleBindBaseActivity = BleBindBaseActivity.this;
            bleBindBaseActivity.mBleBindPairView = null;
            bleBindBaseActivity.mPairPopupWindow = null;
        }
    };
    private ddh O0000Ooo = new ddh() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass4 */

        public final void O000000o() {
            BleBindBaseActivity.this.hidePaircodePopupWindow();
            BleBindBaseActivity.this.cancelDeviceBind();
            BleBindBaseActivity.this.quitBindingActivity();
        }

        public final void O00000Oo() {
            BleBindBaseActivity.this.hidePaircodePopupWindow();
            BleBindBaseActivity.this.startBindDevice(true);
        }
    };
    private final fow O0000o0 = new fow() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$s5pOIG6CJxMiQAyxzCihQome41E */

        public final void onBoostComplete() {
            BleBindBaseActivity.this.O00000oo();
        }
    };
    private fpb.O000000o O0000o00 = new fpb.O000000o() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass5 */

        public final void O000000o() {
            if (BleBindBaseActivity.this.isValid()) {
                BleBindBaseActivity.this.mIsFoundByScan = true;
                fte.O00000Oo(BleBindBaseActivity.this.tag + " DeviceFinder onFound");
                BleBindBaseActivity.this.startBindDeviceReal();
            }
        }

        public final void O00000Oo() {
            if (BleBindBaseActivity.this.isValid()) {
                BleBindBaseActivity.this.mIsFoundByScan = false;
                fte.O00000Oo(BleBindBaseActivity.this.tag + " DeviceFinder onTimeout");
                BleBindBaseActivity.this.startBindDeviceReal();
            }
        }
    };
    private final fow O0000o0O = new fow() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$BTC7J6TBUCwg8DzBpgkIHvH7Y */

        public final void onBoostComplete() {
            BleBindBaseActivity.this.O00000oO();
        }
    };
    private final fow O0000o0o = new fow() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$2Ln3PlBo5j3FbN434QylS9h0WhE */

        public final void onBoostComplete() {
            BleBindBaseActivity.this.O00000o();
        }
    };
    public boolean mBindComplete = false;
    public ddf mBleBindPairView;
    public Bundle mBundle = new Bundle();
    public View.OnClickListener mCancelListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$BdUjju3D54gb9Z3iYMDuhKZh0I */

        public final void onClick(View view) {
            BleBindBaseActivity.this.O000000o(view);
        }
    };
    public BaseBindView mCommonBindView;
    public final View.OnClickListener mCompleteListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$hCwfBuon5DoepJDnr9dhcdvQ6gs */

        public final void onClick(View view) {
            BleBindBaseActivity.this.O00000Oo(view);
        }
    };
    public int mConnectErrorCode = -9999;
    public int mCurrentStatus;
    public final View.OnClickListener mExitListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$skgwxcb8scbSB0yDI2f4j9UjeT8 */

        public final void onClick(View view) {
            BleBindBaseActivity.this.O00000o0(view);
        }
    };
    public boolean mHasReportedBindFailure = false;
    public boolean mIsFoundByScan = false;
    public PopupWindow mPairPopupWindow;
    public fop mPresenter;
    public foy mProgressCounter;
    public final View.OnClickListener mReopenBluetoothListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass8 */

        public final void onClick(View view) {
            BleBindBaseActivity.this.O00000o++;
            hxi.O00000o.f952O000000o.O000000o("adddevice_BLE_androidconnectfail_retry", "model", BleBindBaseActivity.this.mPresenter.O00000o.model);
            BleBindBaseActivity.this.reopenBluetooth();
        }
    };
    public final View.OnClickListener mRetryPluginListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass9 */

        public final void onClick(View view) {
            BleBindBaseActivity.this.mCommonBindView.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_new_download_plugin_step_loading, (int) R.string.ble_new_network_loading_title);
            BleBindBaseActivity.this.mCommonBindView.O000000o(4);
            BleBindBaseActivity.this.mProgressCounter.O000000o(90);
            BleBindBaseActivity.this.mProgressCounter.O000000o(99, 15000, null);
            BleBindBaseActivity.this.mHandler.sendEmptyMessageDelayed(8193, 15000);
            BleBindBaseActivity.this.mPresenter.O00000o();
        }
    };
    public View mTitleBar;
    public long startTime = System.currentTimeMillis();
    public String tag = "BleBindBaseActivity";

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o() {
    }

    /* access modifiers changed from: protected */
    public void addErrorText$552c4e01() {
    }

    /* access modifiers changed from: protected */
    public void cancelClick() {
    }

    public void checkAndRequestCameraPermission() {
    }

    /* access modifiers changed from: protected */
    public void completeBindClick() {
    }

    public void countConnectTime() {
    }

    /* access modifiers changed from: protected */
    public void gotoSecurePinPage() {
    }

    /* access modifiers changed from: protected */
    public void initBindPairView() {
    }

    /* access modifiers changed from: protected */
    public void initView() {
    }

    /* access modifiers changed from: protected */
    public void onPreDestroy() {
    }

    /* access modifiers changed from: protected */
    public void processLastResponse(int i, Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void refreshDownloadingSuccessStatus() {
    }

    /* access modifiers changed from: protected */
    public void refreshDownloadingTimeoutStatus() {
    }

    /* access modifiers changed from: protected */
    public void showCompleteButton() {
    }

    /* access modifiers changed from: protected */
    public void showErrorView(String str, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void showExitButton() {
    }

    /* access modifiers changed from: protected */
    public void showRetryConnectButton() {
    }

    /* access modifiers changed from: protected */
    public void showRetryDownloadPluginButton() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo() {
        refreshUIByStatus(30);
        refreshUIByStatus(33);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO() {
        refreshUIByStatus(36);
        refreshUIByStatus(40);
    }

    public void onCreate(Bundle bundle) {
        BleDevice O00000o02;
        MiotBleAdvPacket O00000Oo2;
        super.onCreate(bundle);
        this.mPresenter = new fop(this, this.tag);
        this.mPresenter.O00000Oo = this;
        Intent intent = getIntent();
        this.O00000oO = intent.getStringExtra("extra_from");
        this.O00000Oo = intent.getIntExtra("connect_source", 0);
        this.O00000o0 = intent.getStringExtra("connect_unique");
        this.mPresenter.O00000o = getMatchedDevice(this.O00000oO);
        this.O0000OOo = (BleComboWifiConfig) intent.getParcelableExtra("key_lock_wifi_config");
        if (!(this.mPresenter.O00000o != null)) {
            finish();
            return;
        }
        fob.O00000o0();
        this.mProgressCounter = new foz(this.O0000Oo);
        initView();
        if (gnl.O00000o(this.mPresenter.O00000o.mac)) {
            fte.O00000Oo(String.format("%s device has ConnectedOrBonded: %s", this.tag, fte.O000000o(this.mPresenter.O00000o.mac)));
        }
        fop fop = this.mPresenter;
        MiotBleAdvPacket O00000Oo3 = fop.O00000o.O00000Oo();
        boolean z = O00000Oo3 == null || O00000Oo3.f6871O000000o == null || fea.O000000o(O00000Oo3.f6871O000000o.O0000Oo0);
        if (!(!z || (O00000o02 = fob.O00000o0(fop.O00000o.mac)) == null || (O00000Oo2 = O00000o02.O00000Oo()) == null || O00000Oo2.f6871O000000o == null || fea.O000000o(O00000Oo2.f6871O000000o.O0000Oo0))) {
            z = false;
        }
        if (!z) {
            this.mProgressCounter.O000000o(0);
            refreshUIByStatus(29);
            return;
        }
        BleComboWifiConfig bleComboWifiConfig = this.O0000OOo;
        if (bleComboWifiConfig != null) {
            fop fop2 = this.mPresenter;
            fop2.O0000Oo0 = bleComboWifiConfig;
            fop2.O00000oO.O00000oo = bleComboWifiConfig;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("key_already_found", false);
        MiotBleAdvPacket O00000Oo4 = this.mPresenter.O00000o.O00000Oo();
        if ((O00000Oo4 == null || O00000Oo4.O0000O0o == null || O00000Oo4.O0000O0o.O00000Oo != 8) ? false : true) {
            String stringExtra = getIntent().getStringExtra("key_qrcode_oob");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (stringExtra.length() == 24) {
                    this.mPresenter.O000000o(got.O00000o0(grs.O000000o(stringExtra)));
                } else {
                    this.mPresenter.O000000o(stringExtra);
                }
                if (booleanExtra) {
                    this.mIsFoundByScan = true;
                    startBindDevice(false);
                    return;
                }
                startBindDevice(true);
                return;
            }
            checkAndRequestCameraPermission();
        } else if (booleanExtra) {
            this.mIsFoundByScan = true;
            startBindDevice(false);
        } else {
            startBindDevice(true);
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
    public void gotoScanBarcodePage() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.xiaomi.smarthome", "com.xiaomi.qrcode.ScanBarcodeActivity"));
        intent.putExtra("from", 500);
        fop fop = this.mPresenter;
        if (fop != null) {
            MiotBleAdvPacket O00000Oo2 = fop.O00000o.O00000Oo();
            if ((O00000Oo2 == null || O00000Oo2.O0000O0o == null || O00000Oo2.O0000O0o.f6875O000000o != 1) ? false : true) {
                intent.putExtra("show_add_manully", true);
            }
        }
        startActivityForResult(intent, 3000);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    /* access modifiers changed from: protected */
    public PopupWindow createPopupWindow() {
        return new PopupWindow((View) ((BleBindPairView) this.mBleBindPairView), -1, -1, true);
    }

    public void hidePaircodePopupWindow() {
        PopupWindow popupWindow = this.mPairPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPairPopupWindow.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        refreshUIByStatus(13);
        refreshUIByStatus(20);
    }

    public void startBindDevice(boolean z) {
        countConnectTime();
        this.mCommonBindView.O000000o();
        this.mProgressCounter.O000000o(0);
        this.mProgressCounter.O000000o(60, 30000, this.O0000o0o);
        refreshUIByStatus(10);
        BleDevice bleDevice = this.mPresenter.O00000o;
        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
        if (z || bleDevice.O00000Oo() == null) {
            this.O0000O0o.O000000o(bleDevice.mac, this.O0000o00);
        } else {
            startBindDeviceReal();
        }
    }

    public void startBindDeviceReal() {
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (bleDevice != null) {
            hvg.O000000o(this).O000000o("10", String.valueOf(bleDevice.rssi));
            hvg.O000000o(this).O000000o("11", gnj.O000000o(String.valueOf(bleDevice.mac)));
            hvg.O000000o(this).O000000o("12", gnj.O000000o(String.valueOf(bleDevice.did)));
            hvg.O000000o(this).O000000o("13", String.valueOf(gnl.O00000Oo()));
        }
        this.mPresenter.O000000o(this.mIsFoundByScan, this.O0000Oo0);
    }

    public void processConnectResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("%s BleBind Step 1/3 response: code = %s", this.tag, XmBluetoothManager.Code.toString(i)));
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (i != -55) {
            if (i != -32) {
                if (i != -7) {
                    if (!(i == -6 || i == -5)) {
                        if (i == -2) {
                            quitBindingActivity();
                            return;
                        } else if (i != -1) {
                            if (i != 0) {
                                this.mProgressCounter.O000000o(0);
                                refreshUIByStatus(11);
                                return;
                            }
                            this.mProgressCounter.O000000o(80, 5000, this.O0000o0);
                            fok.O000000o(bleDevice.mac, "bluetooth_connect_success");
                            return;
                        }
                    }
                }
            }
            this.mProgressCounter.O000000o(0);
            refreshUIByStatus(11);
            fok.O000000o(bleDevice.mac, bundle);
            return;
        }
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(12);
        fok.O000000o(bleDevice.mac, "bluetooth_connect_timeout");
    }

    public void processAuthResponse(int i, Bundle bundle) {
        hxc.O000000o o000000o;
        hxc.O00000Oo o00000Oo;
        fte.O00000Oo(String.format("%s BleBind Step 2/3 response: code = %s", this.tag, XmBluetoothManager.Code.toString(i)));
        if (bundle != null) {
            this.mBundle.putAll(bundle);
        }
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (i != -55) {
            if (i == -37) {
                this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
                    /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$i2Ba2c_CuPxdYk1v0F2MLKYrI4 */
                    private final /* synthetic */ BleDevice f$1;
                    private final /* synthetic */ Bundle f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        BleBindBaseActivity.this.O00000Oo(this.f$1, this.f$2);
                    }
                }, 2000);
                return;
            } else if (i == -14) {
                this.mHandler.postDelayed(new Runnable(bleDevice) {
                    /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$k8GTeMscJP03AFSX3y7njdUQ8wM */
                    private final /* synthetic */ BleDevice f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BleBindBaseActivity.this.O00000Oo(this.f$1);
                    }
                }, 2000);
                return;
            } else if (i == -10) {
                this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
                    /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$4TJACDL4lls1KzyOfu8FR1L6jcU */
                    private final /* synthetic */ BleDevice f$1;
                    private final /* synthetic */ Bundle f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        BleBindBaseActivity.this.O00000oO(this.f$1, this.f$2);
                    }
                }, 2000);
                return;
            } else if (!(i == -28 || i == -27)) {
                if (i == -17) {
                    this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
                        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$54ft8N2cicJAtpDLfz0QJ4INoU */
                        private final /* synthetic */ BleDevice f$1;
                        private final /* synthetic */ Bundle f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            BleBindBaseActivity.this.O00000o0(this.f$1, this.f$2);
                        }
                    }, 2000);
                    return;
                } else if (i == -16) {
                    this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
                        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$V_SEkoU9ALPG7IY7VJQBB8TSkRM */
                        private final /* synthetic */ BleDevice f$1;
                        private final /* synthetic */ Bundle f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            BleBindBaseActivity.this.O00000o(this.f$1, this.f$2);
                        }
                    }, 2000);
                    return;
                } else if (!(i == -7 || i == -6 || i == -5)) {
                    if (i == -2) {
                        quitBindingActivity();
                        return;
                    } else if (i != -1) {
                        if (i != 0) {
                            switch (i) {
                                case -35:
                                    this.mProgressCounter.O000000o(0);
                                    refreshUIByStatus(28);
                                    return;
                                case -34:
                                    this.mProgressCounter.O000000o(0);
                                    refreshUIByStatus(27);
                                    return;
                                case -33:
                                    String string = bundle.getString("extra.pair.code");
                                    if (!TextUtils.isEmpty(string)) {
                                        initBindPairView();
                                        this.mBleBindPairView.setPairCallback(this.O0000Ooo);
                                        this.mBleBindPairView.setPaircode(string);
                                        this.mPairPopupWindow = createPopupWindow();
                                        this.mPairPopupWindow.setAnimationStyle(R.style.BleBindPairWindowAnim);
                                        this.mPairPopupWindow.setFocusable(false);
                                        this.mPairPopupWindow.setOutsideTouchable(false);
                                        this.mPairPopupWindow.setOnDismissListener(this.O0000OoO);
                                        this.mPairPopupWindow.showAtLocation(this.mTitleBar, 0, 0, 0);
                                        hxc O000000o2 = hxc.O000000o();
                                        String str = bleDevice.model;
                                        BindStep bindStep = BindStep.STEP_TRANSFER_CONFIG;
                                        if (!(!hxc.O000000o(str) || (o000000o = O000000o2.f940O000000o.get(str)) == null || (o00000Oo = o000000o.O00000o.get(bindStep)) == null)) {
                                            o00000Oo.O00000oO = System.currentTimeMillis();
                                        }
                                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG);
                                        return;
                                    }
                                    return;
                                case -32:
                                    break;
                                default:
                                    this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
                                        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$vbJtAhTg6fcPYjMO5E66_KBxrP0 */
                                        private final /* synthetic */ BleDevice f$1;
                                        private final /* synthetic */ Bundle f$2;

                                        {
                                            this.f$1 = r2;
                                            this.f$2 = r3;
                                        }

                                        public final void run() {
                                            BleBindBaseActivity.this.O000000o(this.f$1, this.f$2);
                                        }
                                    }, 2000);
                                    return;
                            }
                        } else {
                            if (this.O0000OOo != null) {
                                this.mProgressCounter.O000000o(90, 30000, this.O0000o0O);
                            } else {
                                this.mProgressCounter.O000000o(90, C.MSG_CUSTOM_BASE, this.O0000o0O);
                            }
                            fok.O000000o(bleDevice.mac, "bluetooth_auth_success");
                            return;
                        }
                    }
                }
            }
        }
        this.mHandler.postDelayed(new Runnable(bleDevice, bundle) {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$xHSgIEatcU8whGCqA8_LNQbh_xo */
            private final /* synthetic */ BleDevice f$1;
            private final /* synthetic */ Bundle f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                BleBindBaseActivity.this.O00000oo(this.f$1, this.f$2);
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(21);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_failure");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(23);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_token_unmatch");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(24);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_failure");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(25);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_failure");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(BleDevice bleDevice) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(26);
        fok.O000000o(bleDevice.mac, "bluetooth_bind_denied");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(29);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_failure");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(BleDevice bleDevice, Bundle bundle) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(21);
        fok.O000000o(bleDevice.mac, "bluetooth_auth_failure");
    }

    public void processBindResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("%s BleBind Step 3/3 response: code = %s", this.tag, XmBluetoothManager.Code.toString(i)));
        if (bundle != null) {
            this.mBundle.putAll(bundle);
        }
        final BleDevice bleDevice = this.mPresenter.O00000o;
        if (this.mCurrentStatus != 36) {
            if (!(i == -30 || i == -26)) {
                if (i == -14) {
                    this.mHandler.postDelayed(new Runnable(bleDevice) {
                        /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$2uJmWPp1bP5G6S_CK_DMShnZIa8 */
                        private final /* synthetic */ BleDevice f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            BleBindBaseActivity.this.O000000o(this.f$1);
                        }
                    }, 2000);
                    return;
                } else if (i == -2) {
                    quitBindingActivity();
                    return;
                } else if (i != -1) {
                    if (i != 0) {
                        this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$nFIWVcSwaeeEsNeqLTLkTrZ4m44 */

                            public final void run() {
                                BleBindBaseActivity.this.O00000o0();
                            }
                        }, 2000);
                        return;
                    }
                    this.mProgressCounter.O000000o(99, 15000, null);
                    this.mHandler.sendEmptyMessageDelayed(8193, 15000);
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass6 */

                        public final void run() {
                            fop fop = BleBindBaseActivity.this.mPresenter;
                            String string = BleBindBaseActivity.this.mBundle.getString("key_version");
                            fop.O00000o.isOnline = true;
                            fop.O00000o.setDid(foc.O000000o(fop.O00000o.mac));
                            fop.O00000o.version = string;
                            fno.O000000o().O000000o(fop.O00000o);
                            BleDevice bleDevice = fop.O00000o;
                            if (bleDevice != null) {
                                dco O000000o2 = dco.O000000o();
                                if (O000000o2.f14476O000000o != null) {
                                    O000000o2.f14476O000000o.O000000o((Device) bleDevice);
                                }
                            }
                            dco O000000o3 = dco.O000000o();
                            BleDevice bleDevice2 = fop.O00000o;
                            if (O000000o3.f14476O000000o != null) {
                                O000000o3.f14476O000000o.O000000o(bleDevice2);
                            }
                            fop.O00000o();
                            fok.O000000o(fop.O00000o.mac, "bluetooth_bind_success");
                            String id = TimeZone.getDefault().getID();
                            fno.O000000o().O0000Oo0(fop.O00000o.did);
                            dco O000000o4 = dco.O000000o();
                            String str = fop.O00000o.did;
                            fop.AnonymousClass5 r4 = new fsm<JSONObject, fso>() {
                                /* class _m_j.fop.AnonymousClass5 */

                                public final void onFailure(fso fso) {
                                    gsy.O000000o(3, "timezone", "upload failed! Error = " + fso.toString());
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    gsy.O000000o(3, "timezone", "upload successfully!");
                                }
                            };
                            if (O000000o4.f14476O000000o != null) {
                                O000000o4.f14476O000000o.O000000o(str, id, (JSONObject) null, r4);
                            }
                        }
                    }, 2000);
                    return;
                }
            }
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity.AnonymousClass7 */

                public final void run() {
                    BleBindBaseActivity.this.mProgressCounter.O000000o(0);
                    BleBindBaseActivity.this.refreshUIByStatus(34);
                    fok.O000000o(bleDevice.mac, "bluetooth_bind_failure");
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(BleDevice bleDevice) {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(35);
        fok.O000000o(bleDevice.mac, "bluetooth_bind_denied");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(34);
    }

    public void refreshUIByStatus(int i) {
        if (!isFinishing()) {
            this.mCurrentStatus = i;
            if (!isFinishing()) {
                BleDevice bleDevice = this.mPresenter.O00000o;
                int i2 = R.string.ble_new_device_has_been_bind;
                switch (i) {
                    case 10:
                        this.mCommonBindView.O000000o((int) R.string.ble_new_connect_step_loading, (int) R.string.ble_new_connect_loading_title);
                        this.mCommonBindView.O000000o(1);
                        return;
                    case 11:
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        showErrorView(this.mPresenter.O000000o((int) R.string.ble_new_connect_step_failed, this.mConnectErrorCode), R.string.ble_new_connect_loading_title, R.drawable.common_bind_app_connect_device_failed);
                        showRetryConnectButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "connect failed");
                        return;
                    case 13:
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_connect_step_success, (int) R.string.ble_new_connect_loading_title);
                        return;
                    case 14:
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 31:
                    case 32:
                    case 37:
                    case 38:
                    case 39:
                    default:
                        return;
                    case 20:
                        BaseBindView baseBindView = this.mCommonBindView;
                        int i3 = this.mPresenter.O0000OOo;
                        baseBindView.O000000o(i3 != 1 ? i3 != 2 ? (i3 == 3 || i3 != 4) ? R.string.ble_new_auth_step_loading : R.string.ble_new_mesh_auth_step_loading : R.string.ble_new_standard_auth_step_loading : R.string.ble_new_normal_auth_step_loading, (int) R.string.ble_new_connect_loading_title);
                        this.mCommonBindView.O000000o(2);
                        return;
                    case 21:
                    case 22:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        if (this.mBleBindPairView != null) {
                            hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG, this.mConnectErrorCode, "pair code auth failed");
                            hxc.O000000o().O00000Oo(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                        }
                        hidePaircodePopupWindow();
                        fop fop = this.mPresenter;
                        showErrorView(fop.O000000o(fop.O00000o0(), this.mConnectErrorCode), R.string.ble_new_connect_failed_title, R.drawable.common_bind_app_connect_device_failed);
                        showRetryConnectButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "auth failed");
                        return;
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        if (this.mBleBindPairView != null) {
                            hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG, this.mConnectErrorCode, "pair code auth failed");
                            hxc.O000000o().O00000Oo(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                        }
                        hidePaircodePopupWindow();
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, this.mPresenter.O00000Oo(), (int) R.string.ble_new_connect_loading_title);
                        Resources resources = this.mCommonBindView.getResources();
                        this.mCommonBindView.O000000o(resources.getString(R.string.ble_new_bind_step_loading), resources.getString(R.string.ble_new_network_loading_title));
                        if (i == 25) {
                            i2 = R.string.ble_new_device_has_been_bind_reset_need;
                        }
                        showErrorView(this.mPresenter.O000000o(this.mBundle.getString("key_device_did"), this.mConnectErrorCode), i2, R.drawable.common_bind_device_has_binded_failed);
                        foc.O0000o(bleDevice.mac);
                        showExitButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "auth failed");
                        return;
                    case 27:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        showErrorView(this.mPresenter.O000000o((int) R.string.ble_auth_pair_code_failed, this.mConnectErrorCode), R.string.ble_new_connect_failed_title, R.drawable.common_bind_app_connect_device_failed);
                        showRetryConnectButton();
                        if (this.mBleBindPairView != null) {
                            hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG, this.mConnectErrorCode, "pair code auth failed");
                            hxc.O000000o().O00000Oo(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                            this.mBleBindPairView.O000000o();
                        }
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "auth failed");
                        return;
                    case 28:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        showErrorView(this.mPresenter.O000000o((int) R.string.ble_auth_pair_code_expired, this.mConnectErrorCode), R.string.ble_new_connect_failed_title, R.drawable.common_bind_app_connect_device_failed);
                        showRetryConnectButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG, this.mConnectErrorCode, "pair code auth expired");
                        hxc.O000000o().O00000Oo(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "pair code auth expired");
                        return;
                    case 29:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        fop fop2 = this.mPresenter;
                        showErrorView(fop2.O000000o(fop2.O00000o0(), this.mConnectErrorCode), R.string.device_not_support_now, R.drawable.common_bind_app_connect_device_failed);
                        showExitButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "auth failed unsupport");
                        return;
                    case 30:
                        if (this.mBleBindPairView != null) {
                            hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_INPUT_CONFIG, "pair code success");
                            hxc.O000000o().O00000Oo(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                        }
                        hidePaircodePopupWindow();
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, this.mPresenter.O00000Oo(), (int) R.string.ble_new_connect_loading_title);
                        return;
                    case 33:
                        Resources resources2 = this.mCommonBindView.getResources();
                        this.mCommonBindView.O000000o(resources2.getString(R.string.ble_new_bind_step_loading), resources2.getString(R.string.ble_new_network_loading_title));
                        this.mCommonBindView.O000000o(3);
                        return;
                    case 34:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        showErrorView(this.mPresenter.O000000o(this.mBundle.getString("key_device_did"), this.mConnectErrorCode), R.string.ble_new_network_failed_title, R.drawable.common_bind_app_connect_network_failed);
                        showRetryConnectButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "bind failed");
                        return;
                    case 35:
                        hxi.O00000o0.O00000Oo(bleDevice.model, this.mConnectErrorCode);
                        showErrorView(this.mPresenter.O000000o(this.mBundle.getString("key_device_did"), this.mConnectErrorCode), R.string.ble_new_device_has_been_bind, R.drawable.common_bind_device_has_binded_failed);
                        showExitButton();
                        hxc.O000000o().O000000o(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG, this.mConnectErrorCode, "bind denied");
                        getString(R.string.ble_new_device_has_been_bind);
                        addErrorText$552c4e01();
                        return;
                    case 36:
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_new_connect_loading_title);
                        hxc.O000000o().O00000o0(bleDevice.model, BindStep.STEP_TRANSFER_CONFIG);
                        return;
                    case 40:
                        this.mCommonBindView.O000000o((int) R.string.ble_new_download_plugin_step_loading, (int) R.string.ble_new_network_loading_title);
                        this.mCommonBindView.O000000o(4);
                        return;
                    case 41:
                        hxi.O00000o0.O00000Oo(bleDevice.model, 1);
                        showErrorView(getResources().getText(R.string.ble_new_download_plugin_step_failed).toString(), R.string.ble_new_network_failed_title, R.drawable.common_bind_app_connect_network_failed);
                        showRetryDownloadPluginButton();
                        return;
                    case 42:
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.LOADING, getResources().getText(R.string.ble_new_download_plugin_step_timeout).toString(), (int) R.string.ble_new_network_failed_title);
                        refreshDownloadingTimeoutStatus();
                        return;
                    case 43:
                        this.mCommonBindView.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_download_plugin_step_success, (int) R.string.ble_new_add_device_success_title);
                        refreshDownloadingSuccessStatus();
                        return;
                    case 44:
                        showCompleteButton();
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        completeBindClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        cancelClick();
    }

    public void cancelDeviceBind() {
        fte.O00000Oo(String.format("%s cancelDeviceBind", this.tag));
        fop fop = this.mPresenter;
        fte.O00000Oo(String.format("%s cancelDeviceBind", fop.f16770O000000o));
        if (fop.O00000oo != null) {
            try {
                fop.O00000oo.cancel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            fop.O00000oo = null;
        }
        this.mProgressCounter.O000000o(0);
    }

    public BleDevice getMatchedDevice(String str) {
        if ("from_match".equalsIgnoreCase(str)) {
            return BleMatchActivity.mMatchedDevice;
        }
        if (!"from_device_list".equalsIgnoreCase(str)) {
            return null;
        }
        return (BleDevice) fno.O000000o().O000000o(getIntent().getStringExtra("extra_did"));
    }

    public void quitBindingActivity() {
        fte.O00000Oo(String.format("%s quitBindingActivity", this.tag));
        this.mPresenter.O00000o.O00000oo();
        finish();
    }

    public void handleMessage(Message message) {
        if (message.what == 8193) {
            refreshUIByStatus(43);
        }
    }

    public void onStart() {
        super.onStart();
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$C5jNQyxT3YAsBsGrXY98MTA8hG4 */

            public final void run() {
                BleBindBaseActivity.this.O00000Oo();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() {
        if (this.mPresenter.O00000o != null) {
            fpo.O000000o(this.mPresenter.O00000o.mac);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        PopupWindow popupWindow = this.mPairPopupWindow;
        if (popupWindow == null || this.mBleBindPairView == null || !popupWindow.isShowing()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mBleBindPairView.O00000Oo();
        return false;
    }

    public void onBackPressed() {
        this.mCancelListener.onClick(null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.O00000Oo = null;
        onPreDestroy();
        this.O0000O0o.O000000o();
        this.mHandler.removeCallbacksAndMessages(null);
        PopupWindow popupWindow = this.mPairPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPairPopupWindow.dismiss();
        }
        this.mBleBindPairView = null;
        this.mPairPopupWindow = null;
        foy foy = this.mProgressCounter;
        if (foy != null) {
            foy.O000000o();
        }
        MLAlertDialog mLAlertDialog = this.O00000oo;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000oo.dismiss();
        }
        if (this.mPresenter.O00000o != null) {
            hxc.O000000o().O00000Oo(this.mPresenter.O00000o.model);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 3000) {
            String str = null;
            if (i2 == -3) {
                startBindDevice(false);
                return;
            }
            if (i2 == -1) {
                str = intent.getStringExtra("key_qrcode_oob");
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.length() == 24) {
                    this.mPresenter.O000000o(got.O00000o0(grs.O000000o(str)));
                } else {
                    this.mPresenter.O000000o(str);
                }
                startBindDevice(false);
                return;
            }
            finish();
        } else if (i == 4000) {
            if (fop.O000000o(ing.O000000o.O00000Oo)) {
                gotoScanBarcodePage();
                return;
            }
            ddb.O000000o(getResources().getString(R.string.permission_failure));
            finish();
        } else if (i != 5000) {
        } else {
            if (i2 == -1) {
                startBindDevice(false);
                return;
            }
            this.mPresenter.O00000o.O00000oo();
            finish();
        }
    }

    public void gotoPage() {
        this.mProgressCounter.O000000o(0);
        gotoSecurePinPage();
    }

    public void refreshUI(int i, int i2) {
        this.mConnectErrorCode = i;
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(i2);
    }

    public void onSuccess() {
        this.mHandler.removeMessages(8193);
        refreshUIByStatus(43);
        this.mProgressCounter.O000000o(101, 1000, null);
    }

    public void onFailed() {
        onSuccess();
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
    public void startChooseRoom() {
        if (getIntent().getBooleanExtra("from_miui", false)) {
            gpf.O000000o(this, $$Lambda$BleBindBaseActivity$sGmyMnLUPMvOWafG7iXbLqTmPwI.INSTANCE);
        } else {
            BleDevice bleDevice = this.mPresenter.O00000o;
            fbt fbt = new fbt(this, "initDeviceRoomActivity");
            fbt.O000000o("device_id", bleDevice.did);
            fbt.O000000o("device_mac", bleDevice.mac);
            fbs.O000000o(fbt);
        }
        setResult(-1, new Intent().putExtra("finish", true));
        finish();
    }

    public void reopenBluetooth() {
        if (this.O00000oo == null) {
            this.O00000oo = new XQProgressDialog(this);
            this.O00000oo.setMessage(getString(R.string.reopening_bluetooth));
            this.O00000oo.setCancelable(false);
        }
        if (!this.O00000oo.isShowing()) {
            this.O00000oo.show();
        }
        fop.O000000o(new BleResponse() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.$$Lambda$BleBindBaseActivity$NqzMewDv2H60FKFzW3mui1uui7M */

            public final void onResponse(int i, Object obj) {
                BleBindBaseActivity.this.O000000o(i, obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, Object obj) {
        MLAlertDialog mLAlertDialog = this.O00000oo;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000oo.dismiss();
        }
        startBindDevice(true);
    }
}

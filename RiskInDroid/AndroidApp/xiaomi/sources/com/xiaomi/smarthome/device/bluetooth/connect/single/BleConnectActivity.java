package com.xiaomi.smarthome.device.bluetooth.connect.single;

import _m_j.ext;
import _m_j.fmd;
import _m_j.fno;
import _m_j.fob;
import _m_j.foc;
import _m_j.fok;
import _m_j.fow;
import _m_j.foy;
import _m_j.foz;
import _m_j.fpa;
import _m_j.fpb;
import _m_j.fpo;
import _m_j.fte;
import _m_j.ftn;
import _m_j.glb;
import _m_j.gle;
import _m_j.gnl;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class BleConnectActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private EditText f7129O000000o;
    private TextView O00000Oo;
    private MLAlertDialog O00000o;
    private ImageView O00000o0;
    private fpb O00000oO = new fpb();
    private fpb.O000000o O00000oo = new fpb.O000000o() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass8 */

        public final void O000000o() {
            if (BleConnectActivity.this.isValid()) {
                BleConnectActivity.this.mIsFoundByScan = true;
                fte.O00000Oo("BleConnectActivity DeviceFinder onFound");
                BleConnectActivity.this.startConnectDeviceReal();
            }
        }

        public final void O00000Oo() {
            if (BleConnectActivity.this.isValid()) {
                BleConnectActivity.this.mIsFoundByScan = false;
                fte.O00000Oo("BleConnectActivity DeviceFinder onTimeout");
                BleConnectActivity.this.startConnectDeviceReal();
            }
        }
    };
    private BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass9 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.connect_status_changed")) {
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 0);
                if (!TextUtils.equals(stringExtra, BleConnectActivity.this.mDevice.mac)) {
                    return;
                }
                if (intExtra == 16 || intExtra == 32) {
                    fte.O00000Oo(String.format("BleBindActivityV2 bluetooth status change: %s, %s", fte.O000000o(stringExtra), String.valueOf(intExtra)));
                    BleConnectActivity.this.mHasLoginSuccess = false;
                }
            } else if (TextUtils.equals(action, "action.online.status.changed")) {
                String stringExtra2 = intent.getStringExtra("extra_mac");
                int intExtra2 = intent.getIntExtra("extra_online_status", 0);
                if (TextUtils.equals(stringExtra2, BleConnectActivity.this.mDevice.mac) && intExtra2 == 80) {
                    fte.O00000Oo(String.format("BleBindActivityV2 bluetooth login success: %s", fte.O000000o(stringExtra2)));
                    BleConnectActivity.this.mHasLoginSuccess = true;
                }
            }
        }
    };
    private final fpa O0000OOo = new fpa() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass10 */

        public final void O000000o(int i) {
            if (i >= 0 && i <= 100) {
                BleConnectActivity.this.mTvProgress.setText(String.format("%d%%", Integer.valueOf(i)));
                BleConnectActivity.this.mProgressBar.setPercent((float) i);
            }
            if (i == 100) {
                BleConnectActivity.this.refreshUIByStatus(44);
            }
        }
    };
    private final fow O0000Oo = new fow() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass15 */

        public final void onBoostComplete() {
            BleConnectActivity.this.refreshUIByStatus(44);
        }
    };
    private final fow O0000Oo0 = new fow() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass13 */

        public final void onBoostComplete() {
            BleConnectActivity.this.refreshUIByStatus(20);
        }
    };
    private final View.OnClickListener O0000OoO = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass3 */

        public final void onClick(View view) {
            BleConnectActivity.this.mBtnLeft.setEnabled(false);
            BleConnectActivity.this.mBtnRight.setEnabled(false);
            BleConnectActivity.this.cancelDeviceBind();
            BleConnectActivity.this.quitBindingActivity();
        }
    };
    private final View.OnClickListener O0000Ooo = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass4 */

        public final void onClick(View view) {
            BleConnectActivity.this.reopenBluetooth();
        }
    };
    public boolean isOpenningPlugin = false;
    public ISecureConnectHandler mBleSecurityLauncher;
    public Button mBtnLeft;
    public Button mBtnRight;
    public int mConnectErrorCode = -9999;
    public BleConnectOptions mConnectOptions;
    public gle mConnectResponse = new gle() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass14 */

        public final void O000000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onConnectResponse: code = %d", Integer.valueOf(i)));
            BleConnectActivity bleConnectActivity = BleConnectActivity.this;
            bleConnectActivity.mConnectErrorCode = i;
            bleConnectActivity.processConnectResponse(i, bundle);
            if (i != 0 && i != -2) {
                BluetoothInternationLogUtil.O000000o("BleConnectActivity onConnectResponse " + BleConnectActivity.this.getReportErrorLog(i));
            }
        }

        public final void O00000Oo(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onAuthResponse: code = %d", Integer.valueOf(i)));
            BleConnectActivity bleConnectActivity = BleConnectActivity.this;
            bleConnectActivity.mConnectErrorCode = i;
            bleConnectActivity.processAuthResponse(i, bundle);
            if (i != 0 && i != -2) {
                BluetoothInternationLogUtil.O000000o("BleConnectActivity onAuthResponse " + BleConnectActivity.this.getReportErrorLog(i));
            }
        }

        public final void O00000o0(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onBindResponse: code = %d", Integer.valueOf(i)));
            BleConnectActivity bleConnectActivity = BleConnectActivity.this;
            bleConnectActivity.mConnectErrorCode = i;
            bleConnectActivity.processBindResponse(i, bundle);
            if (i != 0 && i != -2) {
                BluetoothInternationLogUtil.O000000o("BleConnectActivity onBindResponse " + BleConnectActivity.this.getReportErrorLog(i));
            }
        }

        public final void O00000o(int i, Bundle bundle) {
            fte.O00000Oo(String.format("BleBindActivity onLastResponse: code = %d", Integer.valueOf(i)));
            BleConnectActivity bleConnectActivity = BleConnectActivity.this;
            bleConnectActivity.mConnectErrorCode = i;
            if (i == -12) {
                bleConnectActivity.refreshUIByStatus(11);
            } else if (i == -13) {
                bleConnectActivity.mOngoingWaitStartTime = System.currentTimeMillis();
                BleConnectActivity.this.mHandler.removeCallbacks(BleConnectActivity.this.mOngoingWaitRunnable);
                BleConnectActivity.this.mHandler.postDelayed(BleConnectActivity.this.mOngoingWaitRunnable, 1000);
                BleConnectActivity.this.mProgressCounter.O000000o(80, 50000, null);
                BleConnectActivity.this.refreshUIByStatus(10);
            } else if (i == 0) {
            } else {
                if (bleConnectActivity.mCurrentStatus == 10) {
                    BleConnectActivity.this.refreshUIByStatus(11);
                } else if (BleConnectActivity.this.mCurrentStatus == 20) {
                    BleConnectActivity.this.refreshUIByStatus(21);
                }
            }
        }
    };
    public int mCurrentAuthType;
    public int mCurrentStatus;
    public Device mDevice;
    public boolean mHasLoginSuccess = false;
    public boolean mIsFoundByScan = false;
    public Runnable mOngoingWaitRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass1 */

        public final void run() {
            if (gnl.O00000o(BleConnectActivity.this.mDevice.mac) && BleConnectActivity.this.mHasLoginSuccess) {
                BleConnectActivity.this.mProgressCounter.O000000o(0);
                BleConnectActivity.this.refreshUIByStatus(44);
            } else if (System.currentTimeMillis() - BleConnectActivity.this.mOngoingWaitStartTime < 50000) {
                BleConnectActivity.this.mHandler.postDelayed(BleConnectActivity.this.mOngoingWaitRunnable, 1000);
            } else {
                BleConnectActivity.this.mProgressCounter.O000000o(0);
                BleConnectActivity.this.refreshUIByStatus(11);
            }
        }
    };
    public long mOngoingWaitStartTime = 0;
    public PieProgressBar mProgressBar;
    public foy mProgressCounter;
    public TextView mTvProgress;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDevice = fno.O000000o().O000000o(getIntent().getStringExtra("extra_did"));
        if (!(this.mDevice != null)) {
            finish();
            return;
        }
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 31000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 15000;
        this.mConnectOptions = o000000o.O000000o();
        fob.O00000o0();
        this.mProgressCounter = new foz(this.O0000OOo);
        setContentView((int) R.layout.activity_ble_connect);
        this.f7129O000000o = (EditText) findViewById(R.id.title);
        this.O00000o0 = (ImageView) findViewById(R.id.icon);
        this.mProgressBar = (PieProgressBar) findViewById(R.id.progress_bar);
        this.O00000Oo = (TextView) findViewById(R.id.subtitle);
        this.mBtnLeft = (Button) findViewById(R.id.left_btn);
        this.mBtnRight = (Button) findViewById(R.id.right_btn);
        this.mTvProgress = (TextView) findViewById(R.id.progress_text);
        this.mBtnLeft.setOnClickListener(this.O0000OoO);
        this.mBtnRight.setOnClickListener(this.O0000Ooo);
        if (gnl.O00000o(this.mDevice.mac)) {
            fte.O00000Oo("BleConnectActivity device has ConnectedOrBonded: " + fte.O000000o(this.mDevice.mac));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
        intentFilter.addAction("action.online.status.changed");
        gnl.O000000o(this.O0000O0o, intentFilter);
        startConnectDevice();
    }

    public void startConnectDevice() {
        this.mProgressCounter.O000000o(0);
        this.mProgressCounter.O000000o(60, 30000, this.O0000Oo0);
        refreshUIByStatus(10);
        this.O00000oO.O000000o(this.mDevice.mac, this.O00000oo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r3.f6871O000000o.O0000OOo == 1) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    public void startConnectDeviceReal() {
        boolean z;
        if (!this.mDevice.isOwner() && !fno.O000000o().O0000OoO(this.mDevice.mac)) {
            this.mDevice.setOwner(true);
            Device device = this.mDevice;
            device.ownerId = "";
            device.ownerName = "";
            foc.O00000o(device.mac, "");
            foc.O00000Oo(this.mDevice.mac, "");
            foc.O0000Oo0(this.mDevice.mac);
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mDevice.model);
        boolean z2 = false;
        MiotBleAdvPacket miotBleAdvPacket = null;
        if (O00000oO2 == null || O00000oO2.O0000o() != Device.PID_BLE_MESH) {
            BleDevice O00000o02 = fob.O00000o0(this.mDevice.mac);
            MiotBleAdvPacket O00000Oo2 = O00000o02 != null ? O00000o02.O00000Oo() : null;
            if (O00000o02 == null || O00000Oo2 == null || O00000Oo2.f6871O000000o == null || !O00000Oo2.f6871O000000o.O00000oO) {
                z = false;
                if (!z) {
                    fte.O00000Oo("BleConnectActivity Start bleMeshConnect");
                    this.mCurrentAuthType = 4;
                    fpo.O000000o(this.mDevice.mac, this.mDevice.did, this.mDevice.token, this.mConnectOptions, this.mConnectResponse);
                    return;
                }
                PluginDeviceInfo O00000oO3 = CoreApi.O000000o().O00000oO(this.mDevice.model);
                if (O00000oO3 == null || O00000oO3.O000O00o() != 1) {
                    BleDevice O00000o03 = fob.O00000o0(this.mDevice.mac);
                    if (O00000o03 != null) {
                        miotBleAdvPacket = O00000o03.O00000Oo();
                    }
                    if (miotBleAdvPacket != null) {
                        if (miotBleAdvPacket.f6871O000000o != null) {
                        }
                    }
                    if (z2) {
                        fte.O00000Oo("BleConnectActivity Start Normal Connect");
                        BleDevice O00000o04 = fob.O00000o0(this.mDevice.mac);
                        if (O00000o04 == null || O00000o04.O00000Oo() == null || O00000o04.O00000Oo().f6871O000000o == null) {
                            connectDirect(new Response.BleConnectResponse() {
                                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass11 */

                                public final /* synthetic */ void onResponse(int i, Object obj) {
                                    if (!BleConnectActivity.this.isValid()) {
                                        return;
                                    }
                                    if (i == 0) {
                                        XmBluetoothManager.getInstance().isBleCharacterExist(BleConnectActivity.this.mDevice.mac, glb.f17954O000000o, glb.O0000o, new Response.BleResponse<Void>() {
                                            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass11.AnonymousClass1 */

                                            public final /* synthetic */ void onResponse(int i, Object obj) {
                                                if (i == 0) {
                                                    fte.O00000Oo("Start bleStandardAuthConnect after read character");
                                                    BleConnectActivity.this.mCurrentAuthType = 2;
                                                    BleConnectActivity.this.mBleSecurityLauncher = fpo.O00000oO(BleConnectActivity.this.mDevice.mac, BleConnectActivity.this.mConnectOptions, BleConnectActivity.this.mConnectResponse);
                                                    return;
                                                }
                                                fte.O00000Oo("Start secureConnect after read character");
                                                BleConnectActivity.this.mCurrentAuthType = 1;
                                                BleConnectActivity.this.mBleSecurityLauncher = fpo.O000000o(BleConnectActivity.this.mDevice.mac, BleConnectActivity.this.mConnectOptions, BleConnectActivity.this.mConnectResponse);
                                            }
                                        });
                                        return;
                                    }
                                    fte.O00000Oo("connect failed when read device character: ".concat(String.valueOf(i)));
                                    BleConnectActivity bleConnectActivity = BleConnectActivity.this;
                                    bleConnectActivity.mConnectErrorCode = i;
                                    bleConnectActivity.mProgressCounter.O000000o(0);
                                    BleConnectActivity.this.refreshUIByStatus(11);
                                }
                            }, 1);
                            return;
                        } else if (O00000o04.O00000Oo().f6871O000000o.O0000OOo == 2) {
                            fte.O00000Oo("BleConnectActivity Start bleStandardAuthConnect");
                            this.mCurrentAuthType = 2;
                            this.mBleSecurityLauncher = fpo.O00000oO(this.mDevice.mac, this.mConnectOptions, this.mConnectResponse);
                            return;
                        } else {
                            fte.O00000Oo("BleConnectActivity Start secureConnect");
                            this.mCurrentAuthType = 1;
                            this.mBleSecurityLauncher = fpo.O000000o(this.mDevice.mac, this.mConnectOptions, this.mConnectResponse);
                            return;
                        }
                    } else if (this.mDevice.isOwner()) {
                        fte.O00000Oo("BleConnectActivity Start securityChipConnect");
                        this.mCurrentAuthType = 3;
                        this.mBleSecurityLauncher = fpo.O00000o0(this.mDevice.mac, this.mConnectOptions, this.mConnectResponse);
                        return;
                    } else {
                        fte.O00000Oo("BleConnectActivity Start securityChipSharedDeviceConnect");
                        this.mCurrentAuthType = 3;
                        this.mBleSecurityLauncher = fpo.O00000Oo(this.mDevice.mac, this.mConnectOptions, this.mConnectResponse);
                        return;
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
        }
        z = true;
        if (!z) {
        }
    }

    public void connectDirect(final Response.BleConnectResponse bleConnectResponse, final int i) {
        if (isValid()) {
            XmBluetoothManager.getInstance().connect(this.mDevice.mac, new Response.BleConnectResponse() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass12 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Bundle bundle = (Bundle) obj;
                    if (i == 0 || i <= 0) {
                        bleConnectResponse.onResponse(i, bundle);
                    } else {
                        BleConnectActivity.this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass12.AnonymousClass1 */

                            public final void run() {
                                BleConnectActivity.this.connectDirect(bleConnectResponse, i - 1);
                            }
                        }, 2000);
                    }
                }
            });
        }
    }

    public String getReportErrorLog(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("error code = ".concat(String.valueOf(i)));
            sb.append(", isScanned = " + this.mIsFoundByScan);
            int i2 = 0;
            BleDevice O00000o02 = fob.O00000o0(this.mDevice.mac);
            if (O00000o02 != null) {
                i2 = O00000o02.rssi;
            }
            sb.append(", rssi = ".concat(String.valueOf(i2)));
            sb.append(", model = " + this.mDevice.model);
            sb.append(", defaultLocale = " + Locale.getDefault());
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            sb.append(", chooseLocale = ".concat(String.valueOf(O00oOooo)));
            ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
            StringBuilder sb2 = new StringBuilder(", server = ");
            if (O000000o2 == null) {
                str = null;
            } else {
                str = O000000o2.f7546O000000o + ":" + O000000o2.O00000Oo + ":" + O000000o2.O00000o0;
            }
            sb2.append(str);
            sb.append(sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void processConnectResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("BleBind Step 1/3 response: code = %s", XmBluetoothManager.Code.toString(i)));
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
                            this.mProgressCounter.O000000o(80, 5000, null);
                            fok.O000000o(this.mDevice.mac, "bluetooth_connect_success");
                            return;
                        }
                    }
                }
            }
            this.mProgressCounter.O000000o(0);
            refreshUIByStatus(11);
            fok.O000000o(this.mDevice.mac, bundle);
            return;
        }
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(12);
        fok.O000000o(this.mDevice.mac, "bluetooth_connect_timeout");
    }

    public void processAuthResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("BleBind Step 2/3 response: code = %s", XmBluetoothManager.Code.toString(i)));
        if (!(i == -55 || i == -32)) {
            if (i == -14) {
                this.mProgressCounter.O000000o(0);
                refreshUIByStatus(26);
                fok.O000000o(this.mDevice.mac, "bluetooth_bind_denied");
                return;
            } else if (i == -10) {
                this.mProgressCounter.O000000o(0);
                refreshUIByStatus(23);
                fok.O000000o(this.mDevice.mac, "bluetooth_auth_token_unmatch");
                return;
            } else if (!(i == -28 || i == -27)) {
                if (i == -17) {
                    this.mProgressCounter.O000000o(0);
                    refreshUIByStatus(25);
                    fok.O000000o(this.mDevice.mac, "bluetooth_auth_failure");
                    return;
                } else if (i == -16) {
                    this.mProgressCounter.O000000o(0);
                    refreshUIByStatus(24);
                    fok.O000000o(this.mDevice.mac, "bluetooth_auth_failure");
                    return;
                } else if (!(i == -7 || i == -6 || i == -5)) {
                    if (i == -2) {
                        quitBindingActivity();
                        return;
                    } else if (i != -1) {
                        if (i != 0) {
                            this.mProgressCounter.O000000o(0);
                            refreshUIByStatus(21);
                            return;
                        }
                        this.mProgressCounter.O000000o(99, C.MSG_CUSTOM_BASE, this.O0000Oo);
                        fok.O000000o(this.mDevice.mac, "bluetooth_auth_success");
                        return;
                    }
                }
            }
        }
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(21);
        fok.O000000o(this.mDevice.mac, "bluetooth_auth_failure");
    }

    public void processBindResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("BleBind Step 3/3 response: code = %s", XmBluetoothManager.Code.toString(i)));
        if (!(i == -30 || i == -26)) {
            if (i == -14) {
                this.mProgressCounter.O000000o(0);
                refreshUIByStatus(26);
                fok.O000000o(this.mDevice.mac, "bluetooth_bind_denied");
                return;
            } else if (i == -2) {
                quitBindingActivity();
                return;
            } else if (i != -1) {
                if (i != 0) {
                    this.mProgressCounter.O000000o(0);
                    refreshUIByStatus(21);
                    return;
                }
                this.mProgressCounter.O000000o(101, 1000, null);
                fok.O000000o(this.mDevice.mac, "bluetooth_bind_success");
                return;
            }
        }
        this.mProgressCounter.O000000o(0);
        refreshUIByStatus(21);
        fok.O000000o(this.mDevice.mac, "bluetooth_bind_failure");
    }

    private String O000000o(int i) {
        return ((Object) getResources().getText(i)) + " (" + this.mConnectErrorCode + ")";
    }

    public void refreshUIByStatus(int i) {
        this.mCurrentStatus = i;
        if (i != 44) {
            switch (i) {
                case 10:
                    O000000o(true);
                    O00000Oo(false);
                    this.f7129O000000o.setText((int) R.string.ble_new_connect_step_loading);
                    this.O00000Oo.setText((int) R.string.ble_new_connect_loading_title);
                    return;
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    O000000o(R.string.ble_new_connect_step_failed, R.string.ble_new_connect_failed_title, true);
                    return;
                default:
                    switch (i) {
                        case 20:
                            EditText editText = this.f7129O000000o;
                            int i2 = this.mCurrentAuthType;
                            int i3 = R.string.ble_new_auth_step_loading;
                            if (i2 == 1) {
                                i3 = R.string.ble_new_normal_auth_step_loading;
                            } else if (i2 == 2) {
                                i3 = R.string.ble_new_standard_auth_step_loading;
                            } else if (i2 != 3 && i2 == 4) {
                                i3 = R.string.ble_new_mesh_auth_step_loading;
                            }
                            editText.setText(i3);
                            this.O00000Oo.setText((int) R.string.ble_new_connect_loading_title);
                            return;
                        case 21:
                        case 22:
                            int i4 = this.mCurrentAuthType;
                            int i5 = R.string.ble_new_auth_step_failed;
                            if (i4 == 1) {
                                i5 = R.string.ble_new_normal_auth_step_failed;
                            } else if (i4 == 2) {
                                i5 = R.string.ble_new_standard_auth_step_failed;
                            } else if (i4 != 3 && i4 == 4) {
                                i5 = R.string.ble_new_mesh_auth_step_failed;
                            }
                            O000000o(i5, R.string.ble_new_connect_failed_title, true);
                            return;
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                            this.f7129O000000o.setGravity(3);
                            O000000o(R.string.ble_new_connect_has_bound_rich_text, 0, false);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            O000000o(false);
            this.O00000o0.setImageResource(R.drawable.kuailian_success_icon);
            this.f7129O000000o.setText((int) R.string.connecting_success);
            this.O00000Oo.setText("");
            this.mBtnLeft.setVisibility(8);
            this.mBtnRight.setVisibility(8);
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass2 */

                public final void run() {
                    if (!BleConnectActivity.this.isOpenningPlugin) {
                        BleConnectActivity.this.isOpenningPlugin = true;
                        BleConnectActivity.openDevice(CommonApplication.getAppContext(), BleConnectActivity.this.mDevice, new Intent());
                    }
                }
            }, 1000);
        }
    }

    public static void openDevice(Context context, Device device, Intent intent) {
        if (device != null) {
            if (CoreApi.O000000o().O00000o(device.model)) {
                PluginApi.getInstance().sendMessage(context, device.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, null);
                return;
            }
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            Intent action = ext.O000000o(device).getAction(device, context, bundle, false, null);
            if (action != null) {
                if (!(context instanceof Activity)) {
                    action.setFlags(268435456);
                }
                context.startActivity(action);
            }
        }
    }

    private void O000000o(int i, int i2, boolean z) {
        O000000o(false);
        this.O00000o0.setImageResource(R.drawable.kuailian_failed_icon);
        if (i == 0) {
            this.f7129O000000o.setText("");
        } else {
            this.f7129O000000o.setText(O000000o(i));
        }
        if (i2 == 0) {
            this.O00000Oo.setText("");
        } else {
            this.O00000Oo.setText(i2);
        }
        if (z) {
            O00000Oo(true);
        }
    }

    private void O000000o(boolean z) {
        if (z) {
            this.O00000o0.setVisibility(8);
            this.mTvProgress.setVisibility(0);
            this.mProgressBar.setVisibility(0);
            return;
        }
        this.O00000o0.setVisibility(0);
        this.mTvProgress.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    private void O00000Oo(boolean z) {
        if (z) {
            this.mBtnRight.setVisibility(0);
            this.mBtnLeft.setBackgroundResource(R.drawable.common_btn_left);
            return;
        }
        this.mBtnRight.setVisibility(8);
        this.mBtnLeft.setBackgroundResource(R.drawable.common_button);
    }

    public void cancelDeviceBind() {
        fte.O00000Oo(String.format("cancelDeviceBind", new Object[0]));
        ISecureConnectHandler iSecureConnectHandler = this.mBleSecurityLauncher;
        if (iSecureConnectHandler != null) {
            try {
                iSecureConnectHandler.cancel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.mBleSecurityLauncher = null;
        }
        this.mProgressCounter.O000000o();
    }

    public void dismissReopenBluetoothDialog() {
        MLAlertDialog mLAlertDialog = this.O00000o;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000o.dismiss();
        }
    }

    public void quitBindingActivity() {
        fte.O00000Oo(String.format("BleBindActivity quitBindingActivity", new Object[0]));
        XmBluetoothManager.getInstance().disconnect(this.mDevice.mac);
        finish();
    }

    public void onStart() {
        super.onStart();
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass7 */

            public final void run() {
                fpo.O000000o(BleConnectActivity.this.mDevice.mac);
            }
        }, 1000);
    }

    public void onBackPressed() {
        if (this.mCurrentStatus == 44) {
            super.onBackPressed();
        } else if (this.mBtnLeft.getVisibility() == 0 || this.mBtnLeft.isEnabled()) {
            this.mBtnLeft.performClick();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000oO.O000000o();
        this.mHandler.removeCallbacksAndMessages(null);
        foy foy = this.mProgressCounter;
        if (foy != null) {
            foy.O000000o();
        }
        MLAlertDialog mLAlertDialog = this.O00000o;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000o.dismiss();
        }
        gnl.O000000o(this.O0000O0o);
    }

    public void reopenBluetooth() {
        if (this.O00000o == null) {
            this.O00000o = new XQProgressDialog(this);
            this.O00000o.setMessage(getString(R.string.reopening_bluetooth));
            this.O00000o.setCancelable(false);
        }
        if (!this.O00000o.isShowing()) {
            this.O00000o.show();
        }
        if (gnl.O00000Oo()) {
            fmd.O00000Oo(new BleResponse() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass5 */

                public final void onResponse(int i, Object obj) {
                    fmd.O000000o(new BleResponse() {
                        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass5.AnonymousClass1 */

                        public final void onResponse(int i, Object obj) {
                            BleConnectActivity.this.dismissReopenBluetoothDialog();
                            BleConnectActivity.this.startConnectDevice();
                        }
                    });
                }
            });
        } else {
            fmd.O000000o(new BleResponse() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleConnectActivity.AnonymousClass6 */

                public final void onResponse(int i, Object obj) {
                    BleConnectActivity.this.dismissReopenBluetoothDialog();
                    BleConnectActivity.this.startConnectDevice();
                }
            });
        }
    }
}

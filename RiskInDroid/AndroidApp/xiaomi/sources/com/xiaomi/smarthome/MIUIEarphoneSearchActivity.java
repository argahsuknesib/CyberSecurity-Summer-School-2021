package com.xiaomi.smarthome;

import _m_j.exp;
import _m_j.eya;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fdb;
import _m_j.fno;
import _m_j.fob;
import _m_j.fod;
import _m_j.fon;
import _m_j.fqy;
import _m_j.fso;
import _m_j.fte;
import _m_j.ftn;
import _m_j.fux;
import _m_j.got;
import _m_j.gri;
import _m_j.gtx;
import _m_j.gty;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import java.util.Map;

public class MIUIEarphoneSearchActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SharedPreferences f4020O000000o;
    private Intent O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private ImageView O00000oo;
    private ImageView O0000O0o;
    private ImageView O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private double O0000o0;
    private int O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o = true;
    public String mLeftMac;
    public BleDevice mRightDevice;
    public String mRightMac;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fte.O00000Oo("MIUIEarphoneLog onCreate");
        this.f4020O000000o = getSharedPreferences("pref_earphone_pair_name", 0);
        O000000o(getIntent());
    }

    public synchronized void initView() {
        if (this.O00000oO == null) {
            setContentView((int) R.layout.miui_earphone_search_activity);
            findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    MIUIEarphoneSearchActivity.this.finish();
                }
            });
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.miui_earphone_more_setting);
            this.O00000o0 = findViewById(R.id.title_bar);
            this.O00000o = findViewById(R.id.container);
            this.O00000oO = findViewById(R.id.miui_earphone_layout);
            this.O00000oo = (ImageView) findViewById(R.id.miui_earphone_icon);
            this.O0000O0o = (ImageView) findViewById(R.id.miui_earphone_exception_icon);
            this.O0000OOo = (ImageView) findViewById(R.id.search_icon);
            this.O0000Oo0 = (TextView) findViewById(R.id.search_status);
            this.O0000Oo = (TextView) findViewById(R.id.retry_button);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        fte.O00000Oo("MIUIEarphoneLog onNewIntent");
        if (intent != null) {
            O000000o(intent);
        }
    }

    private void O000000o(Intent intent) {
        this.O00000Oo = intent;
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass2 */

            public final void O000000o() {
                MIUIEarphoneSearchActivity.this.finish();
            }

            public final void O00000Oo() {
                MIUIEarphoneSearchActivity.this.finish();
            }

            public final void O00000o0() {
                MIUIEarphoneSearchActivity.this.initView();
                MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4100);
                MIUIEarphoneSearchActivity.this.mHandler.sendEmptyMessageDelayed(4100, 100);
            }
        });
        eya.O000000o().f15942O000000o = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object
     arg types: [java.lang.String, android.bluetooth.BluetoothDevice, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object */
    private String O000000o(String str) {
        Object O000000o2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BluetoothDevice bluetoothDevice = null;
        if (Build.VERSION.SDK_INT >= 18) {
            bluetoothDevice = ((BluetoothManager) getSystemService("bluetooth")).getAdapter().getRemoteDevice(str);
        }
        if (bluetoothDevice == null || (O000000o2 = fdb.O000000o(bluetoothDevice.getClass().getName(), (Object) bluetoothDevice, "getTwsPlusPeerAddress", new Object[0])) == null) {
            return "";
        }
        return O000000o2.toString();
    }

    public void cachePairRelationship() {
        if (!TextUtils.isEmpty(this.mLeftMac) && !TextUtils.isEmpty(this.mRightMac)) {
            SharedPreferences.Editor edit = this.f4020O000000o.edit();
            edit.putString(this.mLeftMac, this.mRightMac);
            edit.apply();
        }
    }

    public String getBeaconAddressFromScanRecord(byte[] bArr) {
        if (bArr == null || bArr.length < 18) {
            return "";
        }
        return (String.format("%02x", Byte.valueOf(bArr[12])) + ":" + String.format("%02x", Byte.valueOf(bArr[11])) + ":" + String.format("%02x", Byte.valueOf(bArr[13])) + ":" + String.format("%02x", Byte.valueOf(bArr[16])) + ":" + String.format("%02x", Byte.valueOf(bArr[15])) + ":" + String.format("%02x", Byte.valueOf(bArr[14]))).toUpperCase();
    }

    public boolean isActivityValid() {
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            return true;
        }
        return false;
    }

    public void findRightDeviceFailed() {
        this.O0000o0O = false;
        this.mHandler.removeMessages(4104);
        this.O0000O0o.setVisibility(0);
        this.O0000OOo.setVisibility(4);
        this.O0000Oo0.setText((int) R.string.miui_earphone_scan_failed);
        this.O0000Oo.setVisibility(0);
        this.O0000Oo.setText((int) R.string.miui_earphone_try_again);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass8 */

            public final void onClick(View view) {
                MIUIEarphoneSearchActivity.this.parseIntent();
            }
        });
        Message message = new Message();
        message.what = 4104;
        message.arg1 = 2;
        message.arg2 = 1;
        this.mHandler.sendMessageDelayed(message, 500);
    }

    private void O000000o() {
        if (this.O0000o0O) {
            if (this.O00000oO.getWidth() == 0) {
                this.mHandler.sendEmptyMessageDelayed(4103, 100);
                return;
            }
            this.O0000OOo.setVisibility(0);
            int bottom = this.O00000oO.getBottom();
            this.O0000OoO = this.O00000oO.getRight() - (this.O00000oO.getWidth() / 2);
            this.O0000Ooo = bottom - (this.O00000oO.getHeight() / 2);
            this.O0000o00 = gri.O000000o(30.0f);
            this.O0000o0 = 270.0d;
            this.mHandler.sendEmptyMessage(4102);
        }
    }

    public void showUnsupportServer() {
        this.O0000o0O = false;
        this.O0000OOo.setVisibility(4);
        this.O0000O0o.setVisibility(8);
        this.O0000Oo0.setText((int) R.string.miui_earphone_unsupport_server);
        this.O0000Oo.setVisibility(0);
        this.O0000Oo.setText((int) R.string.i_know);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass9 */

            public final void onClick(View view) {
                MIUIEarphoneSearchActivity.this.finish();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        fte.O00000Oo("MIUIEarphoneLog onDestroy");
        this.O0000o0O = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 4097:
                searchRightEarphoneDevice();
                return;
            case 4098:
                fte.O00000Oo("MIUIEarphoneLog start scan timeout");
                XmBluetoothManager.getInstance().stopScan();
                findRightDeviceFailed();
                return;
            case 4099:
                fte.O00000Oo("MIUIEarphoneLog search device timeout");
                fob.O00000o0();
                findRightDeviceFailed();
                return;
            case 4100:
                parseIntent();
                return;
            case 4101:
                if (!CoreApi.O000000o().O0000Ooo()) {
                    fte.O00000Oo("MIUIEarphoneLog login callback failed");
                    fbt fbt = new fbt(this, "SmartHomeMainActivity");
                    fbt.O00000Oo(335544320);
                    fbs.O000000o(fbt);
                    finish();
                    return;
                } else if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                    showUnsupportServer();
                    return;
                } else {
                    checkDeviceReady();
                    return;
                }
            case 4102:
                if (this.O0000o0O && this.O0000OOo.getVisibility() == 0 && isActivityValid()) {
                    if (this.O0000o0 > 359.0d) {
                        this.O0000o0 = 0.0d;
                    }
                    double d = (double) this.O0000OoO;
                    double d2 = (double) this.O0000o00;
                    double cos = Math.cos((this.O0000o0 * 3.14d) / 180.0d);
                    Double.isNaN(d2);
                    Double.isNaN(d);
                    double d3 = d + (d2 * cos);
                    double d4 = (double) this.O0000Ooo;
                    double d5 = (double) this.O0000o00;
                    double sin = Math.sin((this.O0000o0 * 3.14d) / 180.0d);
                    Double.isNaN(d5);
                    Double.isNaN(d4);
                    double d6 = d4 + (d5 * sin);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000OOo.getLayoutParams();
                    double left = (double) this.O00000oO.getLeft();
                    Double.isNaN(left);
                    layoutParams.leftMargin = (int) (d3 - left);
                    double top = (double) this.O00000oO.getTop();
                    Double.isNaN(top);
                    layoutParams.topMargin = (int) (d6 - top);
                    this.O0000OOo.setLayoutParams(layoutParams);
                    this.O0000OOo.invalidate();
                    this.O0000o0 += 1.5d;
                    this.mHandler.sendEmptyMessageDelayed(4102, 10);
                    return;
                }
                return;
            case 4103:
                O000000o();
                return;
            case 4104:
                int i = message.arg1;
                int i2 = message.arg2;
                if (this.O0000o0O) {
                    return;
                }
                if (i2 < 5 || i != 2) {
                    Message message2 = new Message();
                    message2.what = 4104;
                    if (i == 1) {
                        this.O0000O0o.setVisibility(0);
                        message2.arg1 = 2;
                    } else {
                        this.O0000O0o.setVisibility(8);
                        message2.arg1 = 1;
                    }
                    message2.arg2 = i2 + 1;
                    this.mHandler.sendMessageDelayed(message2, 500);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void parseIntent() {
        fte.O00000Oo("MIUIEarphoneLog parseIntent");
        Intent intent = this.O00000Oo;
        if (intent == null) {
            fte.O00000Oo("MIUIEarphoneLog input intent is null");
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("ble_address");
        String stringExtra2 = this.O00000Oo.getStringExtra("classic_address");
        int intExtra = this.O00000Oo.getIntExtra("rssi", 0);
        byte[] byteArrayExtra = this.O00000Oo.getByteArrayExtra("scan_record");
        fte.O00000Oo("MIUIEarphoneLog bleAddress = " + stringExtra + ", classicAddress = " + fte.O000000o(stringExtra2) + ", rssi = " + intExtra);
        if (byteArrayExtra != null && byteArrayExtra.length > 0) {
            fte.O00000Oo("MIUIEarphoneLog scanRecord = " + got.O00000o0(byteArrayExtra));
        }
        if (TextUtils.isEmpty(stringExtra) || byteArrayExtra == null || byteArrayExtra.length < 18 || !(byteArrayExtra[0] == 88 || byteArrayExtra[0] == 77)) {
            fte.O00000Oo("MIUIEarphoneLog scan record format error");
            finish();
            return;
        }
        byte b = byteArrayExtra[3] & 1;
        this.O0000o0o = (byteArrayExtra[3] & 2) == 2;
        if (b == 1) {
            this.mLeftMac = stringExtra.toUpperCase();
            String O000000o2 = O000000o(this.mLeftMac);
            fte.O00000Oo("MIUIEarphoneLog right peer address: " + fte.O000000o(O000000o2));
            if (TextUtils.isEmpty(O000000o2)) {
                String beaconAddressFromScanRecord = getBeaconAddressFromScanRecord(byteArrayExtra);
                if (TextUtils.isEmpty(beaconAddressFromScanRecord) || TextUtils.equals(this.mLeftMac, beaconAddressFromScanRecord)) {
                    this.mRightMac = this.f4020O000000o.getString(this.mLeftMac, "");
                } else {
                    this.mRightMac = beaconAddressFromScanRecord.toUpperCase();
                    cachePairRelationship();
                }
            } else {
                this.mRightMac = O000000o2.toUpperCase();
                cachePairRelationship();
            }
        } else {
            this.mRightMac = stringExtra.toUpperCase();
            String O000000o3 = O000000o(this.mRightMac);
            fte.O00000Oo("MIUIEarphoneLog left peer address: " + fte.O000000o(O000000o3));
            if (TextUtils.isEmpty(O000000o3)) {
                String beaconAddressFromScanRecord2 = getBeaconAddressFromScanRecord(byteArrayExtra);
                if (!TextUtils.isEmpty(beaconAddressFromScanRecord2) && !TextUtils.equals(this.mRightMac, beaconAddressFromScanRecord2)) {
                    this.mLeftMac = beaconAddressFromScanRecord2.toUpperCase();
                    cachePairRelationship();
                }
            } else {
                this.mLeftMac = O000000o3.toUpperCase();
                cachePairRelationship();
            }
        }
        this.O00000o0.setVisibility(0);
        this.O00000o.setVisibility(0);
        if (this.O0000o0o) {
            this.O00000oo.setBackgroundResource(R.drawable.miui_earphone_normal_black_bg);
        } else {
            this.O00000oo.setBackgroundResource(R.drawable.miui_earphone_normal_white_bg);
        }
        this.O0000O0o.setVisibility(8);
        this.O0000Oo0.setText((int) R.string.miui_earphone_scanning);
        this.O0000Oo.setVisibility(8);
        this.O0000o0O = true;
        O000000o();
        fte.O00000Oo("MIUIEarphoneLog checkSmartHomeEnvironment");
        CoreApi.O000000o().O000000o(this, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass3 */

            public final void onCoreReady() {
                fte.O00000Oo("MIUIEarphoneLog core ready");
                if (CoreApi.O000000o().O0000Ooo()) {
                    fte.O00000Oo("MIUIEarphoneLog login success");
                    if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        MIUIEarphoneSearchActivity.this.showUnsupportServer();
                    } else {
                        MIUIEarphoneSearchActivity.this.checkDeviceReady();
                    }
                } else {
                    fte.O00000Oo("MIUIEarphoneLog login failed");
                    gty.O000000o().startLogin(MIUIEarphoneSearchActivity.this, 5, new gtx.O000000o() {
                        /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass3.AnonymousClass1 */

                        public final void O000000o() {
                            MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4101);
                            MIUIEarphoneSearchActivity.this.mHandler.sendEmptyMessageDelayed(4101, 100);
                        }
                    });
                }
            }
        });
    }

    public void checkDeviceReady() {
        fte.O00000Oo("MIUIEarphoneLog checkDeviceReady");
        fno.O000000o().O000000o(new fno.O00000o() {
            /* class com.xiaomi.smarthome.$$Lambda$MIUIEarphoneSearchActivity$P2O49fbluvE3ZWjrRtvC1E3qGK0 */

            public final void onDeviceReady(Map map) {
                MIUIEarphoneSearchActivity.this.O000000o(map);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
     arg types: [com.xiaomi.smarthome.MIUIEarphoneSearchActivity, int, ?]
     candidates:
      _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
      _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
    public void searchRightEarphoneDevice() {
        fte.O00000Oo("MIUIEarphoneLog searchRightEarphoneDevice");
        Device O00000o2 = fno.O000000o().O00000o(this.mRightMac);
        if (O00000o2 != null) {
            fte.O00000Oo("MIUIEarphoneLog openDevicePage");
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O00000o2.model);
            if (O00000oO2 == null) {
                fte.O00000Oo("MIUIEarphoneLog openDevicePage plugin record is null");
                return;
            }
            View view = this.O00000o0;
            if (view != null) {
                this.O0000o0O = false;
                view.setVisibility(8);
                this.O00000o.setVisibility(8);
                this.O0000OOo.setVisibility(4);
            }
            XQProgressDialog.O000000o(this, "", getString(R.string.loading), true, true, new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    this.finish();
                }
            }).show();
            Intent intent = new Intent();
            PluginApi.getInstance().sendMessage(this, O00000o2.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o2), null, false, new SendMessageCallback(true, XQProgressHorizontalDialog.O000000o(this, getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + getString(R.string.plugin)), this) {
                /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass7 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ boolean f4028O000000o = true;
                final /* synthetic */ XQProgressHorizontalDialog O00000Oo;
                final /* synthetic */ Activity O00000o0;

                {
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final void onDownloadStart(final String str, final PluginDownloadTask pluginDownloadTask) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (this.f4028O000000o && MIUIEarphoneSearchActivity.this.isActivityValid() && (xQProgressHorizontalDialog = this.O00000Oo) != null) {
                        xQProgressHorizontalDialog.O000000o(true);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = this.O00000Oo;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        this.O00000Oo.show();
                        this.O00000Oo.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass7.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                            }
                        });
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (this.f4028O000000o && MIUIEarphoneSearchActivity.this.isActivityValid() && (xQProgressHorizontalDialog = this.O00000Oo) != null && xQProgressHorizontalDialog.isShowing()) {
                        this.O00000Oo.O000000o(100, (int) (f * 100.0f));
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (this.f4028O000000o && MIUIEarphoneSearchActivity.this.isActivityValid() && (xQProgressHorizontalDialog = this.O00000Oo) != null && xQProgressHorizontalDialog.isShowing()) {
                        this.O00000Oo.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (this.f4028O000000o && MIUIEarphoneSearchActivity.this.isActivityValid() && (xQProgressHorizontalDialog = this.O00000Oo) != null && xQProgressHorizontalDialog.isShowing()) {
                        this.O00000Oo.dismiss();
                    }
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (this.f4028O000000o && MIUIEarphoneSearchActivity.this.isActivityValid() && (xQProgressHorizontalDialog = this.O00000Oo) != null && xQProgressHorizontalDialog.isShowing()) {
                        this.O00000Oo.dismiss();
                    }
                }

                public final void onSendSuccess(Bundle bundle) {
                    this.O00000o0.finish();
                }

                public final void onSendCancel() {
                    this.O00000o0.finish();
                }

                public final void onSendFailure(fso fso) {
                    this.O00000o0.finish();
                }
            });
        } else if (!fob.O00000Oo()) {
            fob.O00000o0();
            this.mHandler.sendEmptyMessageDelayed(4097, 1000);
        } else if (!fux.O000000o((Activity) this, true, (int) R.string.location_disable_hint)) {
            findRightDeviceFailed();
        } else {
            this.mHandler.sendEmptyMessageDelayed(4099, 5000);
            fob.O000000o(new SearchRequest.O000000o().O000000o(4000, 1).O000000o(), new fon() {
                /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    BleDevice bleDevice = (BleDevice) obj;
                    if (MIUIEarphoneSearchActivity.this.mRightDevice == null && MIUIEarphoneSearchActivity.this.mRightMac.equalsIgnoreCase(bleDevice.mac)) {
                        fte.O00000Oo("MIUIEarphoneLog right device found");
                        MIUIEarphoneSearchActivity.this.mRightDevice = bleDevice;
                        fob.O00000o0();
                        fob.O000000o();
                        BleDeviceGroup O000000o2 = fob.O000000o(bleDevice.model);
                        MIUIEarphoneSearchActivity mIUIEarphoneSearchActivity = MIUIEarphoneSearchActivity.this;
                        fod.O00000Oo(mIUIEarphoneSearchActivity, O000000o2, fqy.O000000o((Intent) null, mIUIEarphoneSearchActivity), null);
                        MIUIEarphoneSearchActivity.this.finish();
                    }
                }

                public final void O000000o() {
                    fte.O00000Oo("MIUIEarphoneLog search right device started");
                }

                public final void O00000Oo() {
                    fte.O00000Oo("MIUIEarphoneLog search right device stopped");
                    MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4099);
                    if (MIUIEarphoneSearchActivity.this.mRightDevice == null) {
                        MIUIEarphoneSearchActivity.this.findRightDeviceFailed();
                    }
                }

                public final void O00000o0() {
                    fte.O00000Oo("MIUIEarphoneLog search right device canceled");
                    MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4099);
                    if (MIUIEarphoneSearchActivity.this.mRightDevice == null) {
                        MIUIEarphoneSearchActivity.this.findRightDeviceFailed();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
     arg types: [com.xiaomi.smarthome.MIUIEarphoneSearchActivity, int, ?]
     candidates:
      _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
      _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Map map) {
        fte.O00000Oo("MIUIEarphoneLog device ready");
        if (TextUtils.isEmpty(this.mRightMac)) {
            fte.O00000Oo("MIUIEarphoneLog searchRightEarphoneMac");
            fux.O000000o((Activity) this, true, (int) R.string.location_disable_hint);
            XmBluetoothManager.getInstance().stopScan();
            this.mHandler.sendEmptyMessageDelayed(4098, 4000);
            XmBluetoothManager.getInstance().startScan(3000, 1, new XmBluetoothManager.BluetoothSearchResponse() {
                /* class com.xiaomi.smarthome.MIUIEarphoneSearchActivity.AnonymousClass4 */

                public final void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice) {
                    exp O000000o2;
                    if (TextUtils.isEmpty(MIUIEarphoneSearchActivity.this.mRightMac) && (O000000o2 = exp.O000000o(xmBluetoothDevice.scanRecord)) != null && O000000o2.O00000Oo != null && O000000o2.O00000Oo.size() > 0) {
                        boolean z = false;
                        byte[] valueAt = O000000o2.O00000Oo.valueAt(0);
                        if (valueAt != null && valueAt.length >= 18 && valueAt[0] == 88 && valueAt[1] == 77 && valueAt[2] == 8) {
                            if (valueAt[3] == 1) {
                                z = true;
                            }
                            String beaconAddressFromScanRecord = MIUIEarphoneSearchActivity.this.getBeaconAddressFromScanRecord(valueAt);
                            if (!z && MIUIEarphoneSearchActivity.this.mLeftMac.equalsIgnoreCase(beaconAddressFromScanRecord)) {
                                fte.O00000Oo("MIUIEarphoneLog right device mac found");
                                MIUIEarphoneSearchActivity.this.mRightMac = xmBluetoothDevice.getAddress().toUpperCase();
                                XmBluetoothManager.getInstance().stopScan();
                                MIUIEarphoneSearchActivity.this.cachePairRelationship();
                                MIUIEarphoneSearchActivity.this.searchRightEarphoneDevice();
                            }
                        }
                    }
                }

                public final void onSearchStarted() {
                    fte.O00000Oo("MIUIEarphoneLog search right mac started");
                }

                public final void onSearchStopped() {
                    fte.O00000Oo("MIUIEarphoneLog search right mac stopped");
                    MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4098);
                    if (TextUtils.isEmpty(MIUIEarphoneSearchActivity.this.mRightMac)) {
                        MIUIEarphoneSearchActivity.this.findRightDeviceFailed();
                    }
                }

                public final void onSearchCanceled() {
                    fte.O00000Oo("MIUIEarphoneLog search right mac canceled");
                    MIUIEarphoneSearchActivity.this.mHandler.removeMessages(4098);
                    if (TextUtils.isEmpty(MIUIEarphoneSearchActivity.this.mRightMac)) {
                        MIUIEarphoneSearchActivity.this.findRightDeviceFailed();
                    }
                }
            });
            return;
        }
        searchRightEarphoneDevice();
    }
}

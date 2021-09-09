package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fob;
import _m_j.fod;
import _m_j.fon;
import _m_j.fqr;
import _m_j.fqy;
import _m_j.ft;
import _m_j.ftn;
import _m_j.gnl;
import _m_j.gsy;
import _m_j.hna;
import _m_j.hsk;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ScanChooseBluetoothDevice extends BaseActivity implements ScanDeviceProgressBar.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f7036O000000o = -1;
    private int O00000Oo = 0;
    private final fon O00000o = new fon() {
        /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass5 */

        public final void O000000o() {
        }

        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
        }

        public final void O00000Oo() {
            if (!ScanChooseBluetoothDevice.this.isFindTarget) {
                ScanChooseBluetoothDevice scanChooseBluetoothDevice = ScanChooseBluetoothDevice.this;
                scanChooseBluetoothDevice.isHappenTimeout = true;
                scanChooseBluetoothDevice.scanFail();
            }
        }

        public final void O00000o0() {
            if (!ScanChooseBluetoothDevice.this.isFindTarget) {
                ScanChooseBluetoothDevice.this.scanFail();
            }
        }
    };
    private BroadcastReceiver O00000o0 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            if (!ScanChooseBluetoothDevice.this.isFindTarget && fob.f16735O000000o.equals(intent.getAction())) {
                List<BleDeviceGroup> O000000o2 = fob.O000000o();
                for (BleDeviceGroup next : O000000o2) {
                    if (!(ScanChooseBluetoothDevice.this.mMac == null || next.mac == null)) {
                        String replace = next.mac.replace(":", "");
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000o0(logType, "ScanChooseBluetoothDevice", "search device with mac: " + next.toString());
                        if (next.mac != null && ScanChooseBluetoothDevice.this.mMac.equalsIgnoreCase(replace)) {
                            ScanChooseBluetoothDevice.this.isFindTarget = true;
                            LogType logType2 = LogType.KUAILIAN;
                            gsy.O00000o0(logType2, "ScanChooseBluetoothDevice", "find ble device mac = " + ScanChooseBluetoothDevice.this.mMac);
                            ScanChooseBluetoothDevice.this.O000000o();
                            ScanChooseBluetoothDevice.this.finishThis(next);
                            return;
                        }
                    }
                }
                if (ScanChooseBluetoothDevice.this.mTargetModel != null) {
                    for (BleDeviceGroup next2 : O000000o2) {
                        LogType logType3 = LogType.KUAILIAN;
                        gsy.O00000o0(logType3, "ScanChooseBluetoothDevice", "search device : " + next2.toString());
                        Iterator<String> it = ScanChooseBluetoothDevice.this.mSearchModels.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (next2.O00000oO(it.next())) {
                                    ScanChooseBluetoothDevice scanChooseBluetoothDevice = ScanChooseBluetoothDevice.this;
                                    scanChooseBluetoothDevice.isFindTarget = true;
                                    scanChooseBluetoothDevice.O000000o();
                                    ScanChooseBluetoothDevice.this.finishThis(next2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    public boolean isFindTarget;
    public boolean isHappenTimeout = false;
    @BindView(5095)
    TextView mCannotFindDeviceTx;
    public String mMac;
    @BindView(5787)
    ScanDeviceProgressBar mProgressBar;
    @BindView(5892)
    Button mRescanBt;
    @BindView(5893)
    TextView mScanDescText;
    @BindView(5895)
    RelativeLayout mScanFailView;
    public ArrayList<String> mSearchModels = new ArrayList<>();
    public String mTargetModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scan_choose_bluetooth_device);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mTargetModel = intent.getStringExtra("model");
            this.mMac = intent.getStringExtra("mac");
            String uuid = UUID.randomUUID().toString();
            intent.putExtra("connect_unique", uuid);
            hxi.O00000o.O000000o(this.mTargetModel, intent.getIntExtra("connect_source", 0), uuid);
            if (!TextUtils.isEmpty(this.mTargetModel)) {
                Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.mTargetModel);
                for (Map.Entry<String, PluginDeviceInfo> value : pluginInfoMap.entrySet()) {
                    PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) value.getValue();
                    if (pluginDeviceInfo.O000O0o0 != 0 && pluginDeviceInfo.O000O0o0 == O00000oO.O00000o0()) {
                        this.mSearchModels.add(pluginDeviceInfo.O00000Oo());
                    }
                }
                this.mSearchModels.add(this.mTargetModel);
            }
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass1 */

            public final void onClick(View view) {
                ScanChooseBluetoothDevice.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.scan_device));
        this.mProgressBar.O00000o0 = this;
        this.mRescanBt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass2 */

            public final void onClick(View view) {
                hxk hxk = hxi.O00000o;
                String str = ScanChooseBluetoothDevice.this.mTargetModel;
                hxk.f952O000000o.O000000o("adddevice_BLE_scanfail_rescan", "model", str);
                ScanChooseBluetoothDevice.this.startScan();
            }
        });
        this.mCannotFindDeviceTx.getPaint().setFlags(9);
        this.mCannotFindDeviceTx.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass3 */

            public final void onClick(View view) {
                hxk hxk = hxi.O00000o;
                String str = ScanChooseBluetoothDevice.this.mTargetModel;
                hxk.f952O000000o.O000000o("adddevice_BLE_scanfail_cannotfind", "model", str);
                fbt fbt = new fbt(ScanChooseBluetoothDevice.this, "WebShellActivity");
                fbt.O000000o("url", ScanChooseBluetoothDevice.this.buildUrl());
                fbs.O000000o(fbt);
            }
        });
        hxp hxp = hxi.O00000o0;
        String str = this.mTargetModel;
        hxp.f957O000000o.O000000o("adddevice_BLE_scanning_show", "model", str);
    }

    public String buildUrl() {
        return hsk.O00000Oo(CommonApplication.getAppContext()) + "/views/faqDetail.html?question=" + getString(R.string.param_question_cannot_find_device);
    }

    public void startScan() {
        if (this.f7036O000000o < 0) {
            this.f7036O000000o = System.currentTimeMillis();
        } else {
            this.O00000Oo++;
        }
        fob.O000000o(this.O00000o);
        this.mScanFailView.setVisibility(8);
        this.mScanDescText.setVisibility(0);
        this.mProgressBar.setVisibility(0);
        this.mProgressBar.O00000o0();
        this.mProgressBar.setTime(25000);
        this.mProgressBar.O000000o();
        hvg.O000000o(this).O00000Oo(1);
        hxc.O000000o().O000000o(this.mTargetModel, BindStep.STEP_SCAN_DEVICE);
    }

    public void scanFail() {
        hxp hxp = hxi.O00000o0;
        String str = this.mTargetModel;
        hxp.f957O000000o.O000000o("adddevice_BLE_scanfail_show", "model", str);
        this.mProgressBar.O00000Oo();
        this.mScanDescText.setVisibility(8);
        this.mProgressBar.setVisibility(8);
        this.mScanFailView.setVisibility(0);
        hxc.O000000o().O000000o(this.mTargetModel, BindStep.STEP_SCAN_DEVICE, "scan failed");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fod.O000000o(android.content.Context, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void
     arg types: [com.xiaomi.smarthome.device.ScanChooseBluetoothDevice, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>]
     candidates:
      _m_j.fod.O000000o(android.app.Activity, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, int):void
      _m_j.fod.O000000o(android.app.Activity, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void
      _m_j.fod.O000000o(android.content.Context, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void */
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
    public void finishWrapper(BleDevice bleDevice) {
        if (!CoreApi.O000000o().O00000o(bleDevice.model)) {
            Intent actionByDeviceRenderer = hna.O00000Oo().getActionByDeviceRenderer(bleDevice, getContext(), null);
            if (actionByDeviceRenderer != null) {
                startActivity(actionByDeviceRenderer);
            }
        } else if (CoreApi.O000000o().O00000oO(bleDevice.model).O00000o() == 25) {
            fbt fbt = new fbt(getContext(), "SmartConfigMainActivity");
            if (getIntent() != null) {
                fbt.O000000o("connect_source", getIntent().getIntExtra("connect_source", 0));
                fbt.O000000o("connect_unique", getIntent().getStringExtra("connect_unique"));
            }
            fbt.O000000o("strategy_id", 13);
            fbt.O000000o("model", bleDevice.model);
            fbt.O000000o("combo_ble_mac", bleDevice.mac);
            if (bleDevice.O00000Oo() != null) {
                fbt.O000000o("combo_ble_key", bleDevice.O00000Oo().O00000oo);
            }
            fbs.O000000o(fbt);
        } else {
            Intent intent = new Intent();
            if (getIntent().hasExtra("key_qrcode_oob")) {
                intent.putExtra("key_qrcode_oob", getIntent().getStringExtra("key_qrcode_oob"));
            }
            fod.O000000o((Context) this, bleDevice, fqy.O000000o(intent, this), this.mSearchModels);
        }
        new Intent().putExtra("finish", false);
        setResult(-1);
        finish();
    }

    private SpannableStringBuilder O000000o(final BleDevice bleDevice) {
        String string = getString(R.string.license_content);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass9 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass9 */

            public final void onClick(View view) {
                fbt fbt = new fbt(ScanChooseBluetoothDevice.this, "GDPRLicenseActivity");
                fbt.O00000Oo(268435456);
                fbt.O000000o("key_model", bleDevice.model);
                fbs.O000000o(fbt);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#0099ff"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }

    public void onPause() {
        super.onPause();
        ft.O000000o(getApplicationContext()).O000000o(this.O00000o0);
        fob.O00000o0();
        this.mProgressBar.O00000Oo();
        hxc.O000000o().O000000o(this.mTargetModel, BindStep.STEP_SCAN_DEVICE, "pause scan");
    }

    public void onResume() {
        super.onResume();
        ft.O000000o(getApplicationContext()).O000000o(this.O00000o0, new IntentFilter(fob.f16735O000000o));
        if (!gnl.O00000Oo()) {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass6 */

                public final void onResponse(int i, Object obj) {
                    if (i == 0) {
                        ScanChooseBluetoothDevice.this.startScan();
                    } else {
                        ScanChooseBluetoothDevice.this.finishThis(null);
                    }
                }
            });
        } else {
            startScan();
        }
    }

    public void onBackPressed() {
        finishThis(null);
        this.mProgressBar.O00000Oo();
    }

    public void onTimeOut() {
        fob.O00000o0();
        this.isHappenTimeout = true;
        if (!this.isFindTarget) {
            scanFail();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.isFindTarget && this.isHappenTimeout) {
            O000000o();
            gsy.O00000Oo(3000, "3000.0.1", "");
            this.isHappenTimeout = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f7036O000000o;
        hxi.O0000Oo.O000000o(this.mTargetModel, CoreApi.O000000o().O0000o0(), this.isFindTarget, j > 0 ? (int) ((currentTimeMillis - j) / 1000) : 0, this.O00000Oo);
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
    public void finishThis(final BleDevice bleDevice) {
        if (bleDevice != null) {
            if (ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                new MLAlertDialog.Builder(this).O000000o(getString(R.string.license_title)).O000000o(O000000o(bleDevice)).O00000Oo(getString(R.string.license_negative_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ScanChooseBluetoothDevice.this.finishThis(null);
                    }
                }).O000000o(getString(R.string.license_positive_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.ScanChooseBluetoothDevice.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ScanChooseBluetoothDevice.this.finishWrapper(bleDevice);
                    }
                }).O00000oo();
            } else {
                finishWrapper(bleDevice);
            }
            hxc.O000000o().O00000o0(this.mTargetModel, BindStep.STEP_SCAN_DEVICE);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("finish", false);
        setResult(0, intent);
        finish();
    }
}

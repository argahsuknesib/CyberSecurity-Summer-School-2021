package com.xiaomi.miconnect;

import _m_j.dck;
import _m_j.dco;
import _m_j.dcp;
import _m_j.dct;
import _m_j.dcv;
import _m_j.dcw;
import _m_j.dcx;
import _m_j.dcz;
import _m_j.dde;
import _m_j.ddm;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.flm;
import _m_j.fno;
import _m_j.fop;
import _m_j.fte;
import _m_j.fwp;
import _m_j.gnj;
import _m_j.gof;
import _m_j.gol;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gwe;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxy;
import _m_j.ing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.smarthome.connect.bluetooth.MiConnectBleMatchActivity;
import com.smarthome.connect.bluetooth.MiconnectBleSecurePinActivity;
import com.smarthome.connect.view.BaseBindView;
import com.smarthome.connect.view.CommonBindView;
import com.smarthome.connect.view.MiconnectBleBindPairView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import java.util.Locale;

public class MiConnectBleBindActivity extends BleBindBaseActivity implements dck {
    private boolean O00000oO = false;
    private long O00000oo = 0;
    private boolean O0000O0o = true;
    private View O0000OOo;
    private CommonBindView O0000Oo;
    private FrameLayout O0000Oo0;
    private final View.OnClickListener O0000OoO = new View.OnClickListener() {
        /* class com.xiaomi.miconnect.$$Lambda$MiConnectBleBindActivity$14YsSCv8qV_CYOpYsp2NVyN4jww */

        public final void onClick(View view) {
            MiConnectBleBindActivity.this.O000000o(view);
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(View view, MotionEvent motionEvent) {
        return true;
    }

    public void onCreate(Bundle bundle) {
        this.O00000oo = System.currentTimeMillis();
        this.tag = "MiConnectBleBindActivity";
        super.onCreate(bundle);
        dcx dcx = dcv.O00000Oo;
        dcx.O000000o("closeto_connect_pop", dcx.O00000Oo);
    }

    public final void initView() {
        dde.O000000o(getWindow());
        setContentView((int) R.layout.activity_miconnect_ble_bind);
        findViewById(R.id.blank_view).setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.miconnect.$$Lambda$MiConnectBleBindActivity$Kqj_2NfBaQvA3q8FKXejdIV94ak */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MiConnectBleBindActivity.this.O00000Oo(view, motionEvent);
            }
        });
        findViewById(R.id.content_layout).setOnTouchListener($$Lambda$MiConnectBleBindActivity$l8SVLgNzDpNxK13BedR96GcJxjw.INSTANCE);
        this.O0000OOo = findViewById(R.id.layout_title);
        this.O0000Oo0 = (FrameLayout) findViewById(R.id.view_container);
        this.mTitleBar = findViewById(R.id.common_tile_tv);
        ((TextView) this.mTitleBar).setText((int) R.string.miconnect_adding_device);
        this.mCommonBindView = (BaseBindView) findViewById(R.id.common_bind_view);
        this.O0000Oo = (CommonBindView) this.mCommonBindView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O00000Oo(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mCancelListener.onClick(view);
        }
        return true;
    }

    public BleDevice getMatchedDevice(String str) {
        if ("from_match".equalsIgnoreCase(str)) {
            return MiConnectBleMatchActivity.mMatchedDevice;
        }
        if (!"from_device_list".equalsIgnoreCase(str)) {
            return null;
        }
        return (BleDevice) fno.O000000o().O000000o(getIntent().getStringExtra("extra_did"));
    }

    public void checkAndRequestCameraPermission() {
        fwp.O000000o(this, new fwp.O000000o() {
            /* class com.xiaomi.miconnect.MiConnectBleBindActivity.AnonymousClass1 */

            public final void O000000o() {
                MiConnectBleBindActivity.this.gotoScanBarcodePage();
            }

            public final void O00000Oo() {
                MiConnectBleBindActivity.this.finish();
            }

            public final void O00000o0() {
                gqg.O00000Oo(MiConnectBleBindActivity.this.getResources().getString(R.string.permission_failure));
                MiConnectBleBindActivity.this.finish();
            }

            public final void O00000o() {
                dcp.O000000o().O000000o(true);
            }
        }, getString(R.string.permission_camera_desc_new), ing.O000000o.O00000Oo);
    }

    public final void gotoSecurePinPage() {
        Intent intent = new Intent();
        intent.setClass(this, MiconnectBleSecurePinActivity.class);
        intent.putExtra("key_mac", this.mPresenter.O00000o.mac);
        startActivityForResult(intent, 5000);
    }

    public final void initBindPairView() {
        this.mBleBindPairView = new MiconnectBleBindPairView(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [com.smarthome.connect.view.MiconnectBleBindPairView, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    public final PopupWindow createPopupWindow() {
        return new PopupWindow((View) ((MiconnectBleBindPairView) this.mBleBindPairView), -1, -1, true);
    }

    public final void processLastResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("%s onLastResponse: code = %d", "MiConnectBleBindActivity", Integer.valueOf(i)));
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (i == 0) {
            if (bleDevice != null) {
                gwe.O000000o().O000000o(bleDevice);
            }
            hxi.O0000Oo.O000000o(bleDevice.model, bundle == null ? "" : bundle.getString("launcher_type_statis"), bleDevice.mac);
        } else if (!(i == -14 || i == -17 || i == -34 || i == -35 || !this.mIsFoundByScan || this.mHasReportedBindFailure || !gof.O00000o0())) {
            this.mHasReportedBindFailure = true;
        }
        if (i == -12 || i == -13) {
            refreshUIByStatus(11);
        } else if (i != 0) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.miconnect.MiConnectBleBindActivity.AnonymousClass2 */

                public final void run() {
                    if (MiConnectBleBindActivity.this.mCurrentStatus == 10) {
                        MiConnectBleBindActivity.this.refreshUIByStatus(11);
                    } else if (MiConnectBleBindActivity.this.mCurrentStatus == 20) {
                        MiConnectBleBindActivity.this.refreshUIByStatus(21);
                    } else if (MiConnectBleBindActivity.this.mCurrentStatus == 33) {
                        MiConnectBleBindActivity.this.refreshUIByStatus(34);
                    }
                }
            }, 2500);
        }
    }

    public final void refreshDownloadingSuccessStatus() {
        dco.O000000o().O000000o(this.mPresenter.O00000o);
        dcp.O000000o().O000000o(this.mPresenter.O00000o.mac);
        dcx dcx = dcv.O00000Oo;
        dcx.O000000o("closeto_suc_pop", dcx.O00000Oo);
        O000000o();
    }

    public final void refreshDownloadingTimeoutStatus() {
        O000000o();
    }

    public void countConnectTime() {
        if (this.f7107O000000o == 0) {
            hxi.O00000o.O00000Oo(this.mPresenter.O00000o.model, this.O00000Oo, this.O00000o0);
        }
        this.f7107O000000o++;
    }

    private void O000000o() {
        if (!this.O00000oO) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.O00000oo > 0) {
                dcv.O00000o0.O000000o(currentTimeMillis - this.O00000oo);
            }
            dcv.O00000o0.O000000o();
            O00000Oo();
        }
    }

    private void O00000Oo() {
        O000000o(PluginDeviceManager.instance.getPluginInfo(this.mPresenter.O00000o.model), dcp.O000000o().O00000Oo);
    }

    private void O000000o(PluginDeviceInfo pluginDeviceInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            str = pluginDeviceInfo.O0000o0();
        }
        this.O0000O0o = true;
        dcz dcz = new dcz(getContext(), str, new View.OnClickListener(pluginDeviceInfo) {
            /* class com.xiaomi.miconnect.$$Lambda$MiConnectBleBindActivity$89hd3CWtI1KXE2QcHIYZOjSN0Vc */
            private final /* synthetic */ PluginDeviceInfo f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                MiConnectBleBindActivity.this.O000000o(this.f$1, view);
            }
        });
        this.O0000OOo.setVisibility(8);
        this.mCommonBindView.setVisibility(8);
        this.O0000Oo0.addView(dcz.O000000o());
        this.O00000oO = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(PluginDeviceInfo pluginDeviceInfo, View view) {
        if (this.O0000O0o) {
            dcv.f14488O000000o.O000000o();
            fop fop = this.mPresenter;
            if (CoreApi.O000000o().O0000OoO(pluginDeviceInfo.O00000Oo()) == null && CoreApi.O000000o().O0000Oo(pluginDeviceInfo.O00000Oo()) == null) {
                dct.O00000oO("enterPlugin");
                PluginApi.getInstance().sendMessage(fop.O00000o0, pluginDeviceInfo.O00000Oo(), 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(fop.O00000o), null, false, new SendMessageCallback() {
                    /* class _m_j.fop.AnonymousClass6 */

                    public final void onDownloadProgress(String str, float f) {
                    }

                    public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    }

                    public final void onDownloadSuccess(String str) {
                        fte.O00000Oo(String.format("%s onDownloadSuccess", fop.this.f16770O000000o));
                    }

                    public final void onDownloadFailure(PluginError pluginError) {
                        fte.O00000Oo(String.format("%s onDownloadFailure", fop.this.f16770O000000o));
                        fop.this.O00000oO();
                    }

                    public final void onDownloadCancel() {
                        fte.O00000Oo(String.format("%s onDownloadCancel", fop.this.f16770O000000o));
                        fop.this.O00000oO();
                    }

                    public final void onSendSuccess(Bundle bundle) {
                        fop.this.O00000oO();
                        fte.O00000Oo(String.format("%s onSendSuccess", fop.this.f16770O000000o));
                    }

                    public final void onSendCancel() {
                        fop.this.O00000oO();
                        fte.O00000Oo(String.format("%s onSendCancel", fop.this.f16770O000000o));
                    }

                    public final void onSendFailure(fso fso) {
                        fbt fbt = new fbt(fop.this.O00000o0, "SmartHomeMainActivity");
                        fbt.O00000Oo(268435456);
                        fbs.O000000o(fbt);
                        fop.this.O00000oO();
                        fte.O00000Oo(String.format(Locale.getDefault(), "%s onSendFailure %d", fop.this.f16770O000000o, Integer.valueOf(fso.f17063O000000o)));
                    }
                });
                return;
            }
            fbt fbt = new fbt(fop.O00000o0, "SmartHomeMainActivity");
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
            fte.O00000Oo(String.format("%s isDownloaded false", fop.f16770O000000o));
            fop.O00000oO();
        }
    }

    public final void showErrorView(String str, int i, int i2) {
        fte.O00000Oo(String.format("%s showErrorView", "MiConnectBleBindActivity"));
        dcx dcx = dcv.O00000Oo;
        dcx.O000000o("closeto_fail_pop", dcx.O00000Oo);
        this.O0000Oo.O000000o(BaseBindView.StepStatus.FAILED, str);
        this.O0000Oo.setBindFailed(i2);
    }

    public final void showRetryConnectButton() {
        fte.O00000Oo(String.format("%s showRetryConnectButton", "MiConnectBleBindActivity"));
        this.O0000Oo.setCommonBtnVisibility(0);
        this.O0000Oo.setCommonBtnText(getResources().getString(R.string.ble_new_reopen_and_retry));
        this.O0000Oo.setCommonBtnListener(this.O0000OoO);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void addErrorText$552c4e01() {
        CommonBindView commonBindView = this.O0000Oo;
        String string = getString(R.string.ble_new_device_has_been_bind);
        LinearLayout linearLayout = (LinearLayout) commonBindView.f5632O000000o.inflate((int) R.layout.miconnect_common_error_text, (ViewGroup) commonBindView.O00000Oo, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = gpc.O000000o(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        commonBindView.O00000Oo.addView(linearLayout);
        ((TextView) linearLayout.findViewById(R.id.error_text)).setText(string);
    }

    public final void showExitButton() {
        fte.O00000Oo(String.format("%s showExitButton", "MiConnectBleBindActivity"));
        this.O0000Oo.setCommonBtnVisibility(0);
        this.O0000Oo.setCommonBtnText(getResources().getString(R.string.exit));
        this.O0000Oo.setCommonBtnListener(this.mExitListener);
    }

    public final void showCompleteButton() {
        this.mBindComplete = true;
        hxi.O00000o.O000000o(this.mPresenter.O00000o.model, System.currentTimeMillis() - this.startTime);
        hxi.O00000o0.O00000Oo(this.mPresenter.O00000o.model);
        hxc.O000000o().O00000o0(this.mPresenter.O00000o.model);
    }

    public final void showRetryDownloadPluginButton() {
        fte.O00000Oo(String.format("%s showRetryDownloadPluginButton", "MiConnectBleBindActivity"));
        this.O0000Oo.setCommonBtnVisibility(0);
        this.O0000Oo.setCommonBtnText(getResources().getString(R.string.mj_retry));
        this.O0000Oo.setCommonBtnListener(this.mRetryPluginListener);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        dcw dcw = dcv.f14488O000000o;
        dcw.O000000o("closeto_fail_retry", dcw.O00000Oo);
        reopenBluetooth();
    }

    public final void cancelClick() {
        if (!this.O00000oO) {
            ddm ddm = new ddm();
            ddm.f14500O000000o = new Runnable() {
                /* class com.xiaomi.miconnect.$$Lambda$MiConnectBleBindActivity$ctlBBJLWLeyIe0OrJWbo12rZ0c */

                public final void run() {
                    MiConnectBleBindActivity.this.O00000o0();
                }
            };
            dcv.O00000Oo.O00000Oo();
            ddm.show(getSupportFragmentManager(), "show exit dialog");
            return;
        }
        XmBluetoothManager.getInstance().disconnect(this.mPresenter.O00000o.mac, 15000);
        this.mPresenter.O00000oO();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        cancelDeviceBind();
        quitBindingActivity();
    }

    public void onStop() {
        super.onStop();
        if (!flm.O000000o(this) && !isFinishing()) {
            cancelDeviceBind();
            quitBindingActivity();
        }
    }

    public void onBackPressed() {
        this.mCancelListener.onClick(null);
    }

    public final void onPreDestroy() {
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (bleDevice != null) {
            if (!this.mBindComplete) {
                hxi.O0000Oo.O000000o(bleDevice.model, System.currentTimeMillis() - this.startTime);
            }
            if (this.f7107O000000o > 0 && gol.O000000o(this.mConnectErrorCode)) {
                hxi.O00000o.O000000o(bleDevice.model, this.mBindComplete, this.O00000Oo, this.O00000o0, this.mConnectErrorCode, this.f7107O000000o - 1, hxy.O000000o(bleDevice.mac), gnj.O000000o(bleDevice.mac + "_" + bleDevice.did));
            }
        }
        dcp.O000000o().O000000o((Activity) this);
    }
}

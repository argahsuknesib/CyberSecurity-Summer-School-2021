package com.xiaomi.smarthome.device.bluetooth.connect.single;

import _m_j.dco;
import _m_j.ddb;
import _m_j.fob;
import _m_j.fop;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fte;
import _m_j.gnj;
import _m_j.gof;
import _m_j.gol;
import _m_j.gwe;
import _m_j.htj;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxt;
import _m_j.hxy;
import _m_j.inc;
import _m_j.ind;
import _m_j.ing;
import _m_j.inh;
import _m_j.inj;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.bluetooth.connect.BleBindBaseActivity;
import com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

public class BleBindActivityV2 extends BleBindBaseActivity {
    private CommonBindView O00000oO;

    public interface O000000o {
        void O000000o();

        void O00000Oo();

        void O00000o0();
    }

    public final void initView() {
        setContentView((int) R.layout.activity_ble_bind_v2);
        this.mTitleBar = findViewById(R.id.title_bar);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.press_to_add_device1);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this.mCancelListener);
        this.mCommonBindView = (BaseBindView) findViewById(R.id.common_bind_view);
        this.O00000oO = (CommonBindView) this.mCommonBindView;
    }

    public final void initBindPairView() {
        this.mBleBindPairView = new BleBindPairView(this);
    }

    public void checkAndRequestCameraPermission() {
        checkAndRequestCameraPermission(this, new O000000o() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass1 */

            public final void O000000o() {
                BleBindActivityV2.this.gotoScanBarcodePage();
            }

            public final void O00000Oo() {
                BleBindActivityV2.this.finish();
            }

            public final void O00000o0() {
                ddb.O000000o(BleBindActivityV2.this.getResources().getString(R.string.permission_failure));
                BleBindActivityV2.this.finish();
            }
        });
    }

    public final void processLastResponse(int i, Bundle bundle) {
        fte.O00000Oo(String.format("%s onLastResponse: code = %d", "BleBindActivityV2", Integer.valueOf(i)));
        BleDevice bleDevice = this.mPresenter.O00000o;
        String O000000o2 = hvg.O000000o(this).O000000o(i);
        if (!TextUtils.isEmpty(O000000o2)) {
            fte.O00000Oo("BLE-SDK-BIND-RESULT=".concat(String.valueOf(O000000o2)));
            try {
                hxi.O00000o.O000000o("adddevice_iot_log", new JSONObject(O000000o2));
            } catch (Exception unused) {
                fte.O00000Oo("IOTLogRecordManager uploadIOTLog failed!");
            }
        }
        String str = "";
        if (i == 0) {
            hxt hxt = hxi.O0000Oo;
            String str2 = bleDevice.model;
            if (bundle != null) {
                str = bundle.getString("launcher_type_statis");
            }
            hxt.O000000o(str2, str, bleDevice.mac);
            if (bleDevice != null) {
                gwe.O000000o().O000000o(bleDevice);
            }
            if (this.mPresenter.O000000o()) {
                fob.O00000Oo((Device) bleDevice);
            }
        } else if (gol.O000000o(i) && this.mIsFoundByScan && !this.mHasReportedBindFailure && gof.O00000o0()) {
            this.mHasReportedBindFailure = true;
            String string = bundle != null ? bundle.getString("key_version") : str;
            hxt hxt2 = hxi.O0000Oo;
            String str3 = bleDevice.model;
            if (bundle != null) {
                str = bundle.getString("launcher_type_statis");
            }
            hxt2.O000000o(str3, str, i, string, "", bleDevice.mac);
        }
        this.mConnectErrorCode = i;
        if (i == -12 || i == -13) {
            refreshUIByStatus(11);
        } else if (i == 0) {
        } else {
            if (this.mCurrentStatus == 10 || this.mCurrentStatus == 20 || this.mCurrentStatus == 33) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass2 */

                    public final void run() {
                        if (BleBindActivityV2.this.mCurrentStatus == 10) {
                            BleBindActivityV2.this.refreshUIByStatus(11);
                        } else if (BleBindActivityV2.this.mCurrentStatus == 20) {
                            BleBindActivityV2.this.refreshUIByStatus(21);
                        } else if (BleBindActivityV2.this.mCurrentStatus == 33) {
                            BleBindActivityV2.this.refreshUIByStatus(34);
                        }
                    }
                }, 2500);
            }
        }
    }

    public final void gotoSecurePinPage() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.xiaomi.smarthome", "com.xiaomi.smarthome.device.bluetooth.connect.single.BleSecurePinActivity"));
        intent.putExtra("key_mac", this.mPresenter.O00000o.mac);
        startActivityForResult(intent, 5000);
    }

    public final void showErrorView(String str, int i, int i2) {
        this.O00000oO.O000000o(BaseBindView.StepStatus.FAILED, str, i, true);
        this.O00000oO.setBindFailed(i2);
    }

    public final void showRetryConnectButton() {
        this.O00000oO.setCommonBtnVisibility(0);
        this.O00000oO.setCommonBtnText(getString(R.string.ble_new_reopen_and_retry));
        this.O00000oO.setCommonBtnListener(this.mReopenBluetoothListener);
    }

    public final void showExitButton() {
        this.O00000oO.setCommonBtnVisibility(0);
        this.O00000oO.setCommonBtnText(getString(R.string.exit));
        this.O00000oO.setCommonBtnListener(this.mExitListener);
    }

    public final void showCompleteButton() {
        this.mBindComplete = true;
        BleDevice bleDevice = this.mPresenter.O00000o;
        hxi.O00000o.O000000o(bleDevice.model, System.currentTimeMillis() - this.startTime);
        hxi.O00000o0.O00000Oo(bleDevice.model);
        htj.O000000o(bleDevice.model, bleDevice.mac);
        hxc.O000000o().O00000o0(bleDevice.model);
        this.O00000oO.setCommonBtnVisibility(0);
        this.O00000oO.setCommonBtnListener(this.mCompleteListener);
        this.O00000oO.O00000o0();
    }

    public final void showRetryDownloadPluginButton() {
        this.O00000oO.setCommonBtnVisibility(0);
        this.O00000oO.setCommonBtnText(getString(R.string.mj_retry));
        this.O00000oO.setCommonBtnListener(this.mRetryPluginListener);
    }

    public final void refreshDownloadingTimeoutStatus() {
        showCompleteButton();
    }

    public final void completeBindClick() {
        fop fop = this.mPresenter;
        hxk hxk = hxi.O00000o;
        String str = fop.O00000o.model;
        hxk.f952O000000o.O000000o("adddevice_BLE_androidconnectsuccess_ok", "model", str);
        String[] strArr = {fop.O00000o.did};
        dco O000000o2 = dco.O000000o();
        Context appContext = CommonApplication.getAppContext();
        fop.AnonymousClass7 r4 = new fsm<List<Device>, fso>() {
            /* class _m_j.fop.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list != null && list.size() > 0 && TextUtils.equals(fop.this.O00000o.did, ((Device) list.get(0)).did)) {
                    fop.this.O00000o.name = ((Device) list.get(0)).name;
                    foc.O000000o(fop.this.O00000o.mac, ((Device) list.get(0)).name);
                }
                if (fop.this.O00000Oo != null) {
                    fop.this.O00000Oo.startChooseRoom();
                }
            }

            public final void onFailure(fso fso) {
                if (fop.this.O00000Oo != null) {
                    fop.this.O00000Oo.startChooseRoom();
                }
            }
        };
        if (O000000o2.f14476O000000o != null) {
            O000000o2.f14476O000000o.O000000o(appContext, strArr, r4);
        }
    }

    public final void cancelClick() {
        if (this.mCurrentStatus == 10 || this.mCurrentStatus == 20 || this.mCurrentStatus == 33) {
            new MLAlertDialog.Builder(this).O000000o((int) R.string.ble_new_cancel_dialog_title).O00000Oo((int) R.string.ble_new_cancel_dialog_message).O000000o((int) R.string.ble_new_cancel_dialog_ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BleBindActivityV2.this.cancelDeviceBind();
                    BleBindActivityV2.this.quitBindingActivity();
                }
            }).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
            return;
        }
        if (this.mCurrentStatus == 44) {
            XmBluetoothManager.getInstance().disconnect(this.mPresenter.O00000o.mac, 15000);
        }
        finish();
    }

    public final void onPreDestroy() {
        BleDevice bleDevice = this.mPresenter.O00000o;
        if (!(this.mBindComplete || bleDevice == null || this.mConnectErrorCode == -14 || this.mConnectErrorCode == -17 || this.mConnectErrorCode == -34 || this.mConnectErrorCode == -35 || this.mConnectErrorCode == -2 || this.mConnectErrorCode == -32 || this.mConnectErrorCode == -5 || this.mConnectErrorCode == -55 || !this.mIsFoundByScan || !gof.O00000o0())) {
            hxi.O0000Oo.O000000o(bleDevice.model, System.currentTimeMillis() - this.startTime);
        }
        if (bleDevice != null && gol.O000000o(this.mConnectErrorCode)) {
            hxi.O00000o.O000000o(bleDevice.model, this.mConnectErrorCode == 0, this.O00000Oo, this.O00000o0, this.mConnectErrorCode, this.O00000o, hxy.O000000o(bleDevice.mac), gnj.O000000o(bleDevice.mac + "_" + bleDevice.did));
        }
    }

    public boolean checkAndRequestCameraPermission(Activity activity, final O000000o o000000o) {
        if (fop.O000000o(ing.O000000o.O00000Oo)) {
            o000000o.O000000o();
            return true;
        }
        activity.getApplication().getResources().getString(R.string.permission_successfully);
        String string = activity.getApplication().getResources().getString(R.string.permission_failure);
        String string2 = activity.getApplication().getResources().getString(R.string.tips);
        String string3 = activity.getApplication().getResources().getString(R.string.permission_tips_camera_msg);
        String[] strArr = ing.O000000o.O00000Oo;
        WeakReference weakReference = new WeakReference(activity);
        ind.O00000Oo((Activity) weakReference.get()).O000000o(strArr).O000000o((inh) null).O000000o(new inc() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass5 */

            public final void onAction(List<String> list) {
                o000000o.O000000o();
            }
        }).O00000Oo(new inc(true, string, weakReference, string2, string3, o000000o) {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass4 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f7120O000000o = true;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ String O00000o;
            final /* synthetic */ WeakReference O00000o0;
            final /* synthetic */ String O00000oO;
            final /* synthetic */ O000000o O00000oo;

            {
                this.O00000Oo = r3;
                this.O00000o0 = r4;
                this.O00000o = r5;
                this.O00000oO = r6;
                this.O00000oo = r7;
            }

            public final void onAction(List<String> list) {
                if (!this.f7120O000000o) {
                    ddb.O000000o(this.O00000Oo);
                    return;
                }
                Activity activity = (Activity) this.O00000o0.get();
                if (activity != null && !activity.isFinishing() && Build.VERSION.SDK_INT >= 17 && !activity.isDestroyed()) {
                    if (ind.O000000o(activity, list)) {
                        BleBindActivityV2.this.showCameraDeniedSetting(activity, this.O00000o, this.O00000oO, list, this.O00000oo);
                        return;
                    }
                    ddb.O000000o(this.O00000Oo);
                    this.O00000oo.O00000Oo();
                }
            }
        }).O000000o();
        return false;
    }

    public void showCameraDeniedSetting(Activity activity, String str, String str2, List<String> list, final O000000o o000000o) {
        String format = String.format(str2, TextUtils.join("\n", ing.O000000o(activity, list)));
        final inj O000000o2 = ind.O000000o(activity);
        new MLAlertDialog.Builder(activity).O000000o(false).O000000o(str).O00000Oo(format).O000000o((int) R.string.setting, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                O000000o2.O00000Oo();
            }
        }).O00000Oo((int) R.string.sh_common_lib_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                o000000o.O00000o0();
            }
        }).O00000o().show();
    }

    public void onCreate(Bundle bundle) {
        this.tag = "BleBindActivityV2";
        super.onCreate(bundle);
        if (this.mPresenter.O00000o != null) {
            String str = this.mPresenter.O00000o.model;
            hxi.O00000o.O00000Oo(str, this.O00000Oo, this.O00000o0);
            hxi.O00000o0.f957O000000o.O000000o("adddevice_BLE_connecting_show", "model", str);
        }
    }
}

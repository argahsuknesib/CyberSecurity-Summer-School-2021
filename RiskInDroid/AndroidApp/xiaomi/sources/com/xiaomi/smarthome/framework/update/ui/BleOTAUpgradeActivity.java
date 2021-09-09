package com.xiaomi.smarthome.framework.update.ui;

import _m_j.ffr;
import _m_j.fno;
import _m_j.fpo;
import _m_j.fqr;
import _m_j.gfk;
import _m_j.gfl;
import _m_j.gfr;
import _m_j.gnl;
import _m_j.gof;
import _m_j.gsy;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.update.BleUpgradePresenter;
import com.xiaomi.smarthome.framework.update.OTAException;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;

public class BleOTAUpgradeActivity extends BaseActivity implements gfk {
    private static SparseIntArray O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    View.OnClickListener f8684O000000o = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass4 */

        public final void onClick(View view) {
            BleOTAUpgradeActivity.this.onBackPressed();
        }
    };
    View.OnClickListener O00000Oo = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass5 */

        public final void onClick(View view) {
            BleOTAUpgradeActivity.this.checkIfNeedUpdate();
        }
    };
    private String O00000o;
    View.OnClickListener O00000o0 = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass6 */

        public final void onClick(View view) {
            BleOTAUpgradeActivity.this.mPresenter.O000000o(BleOTAUpgradeActivity.this.mUpdateInfo);
        }
    };
    private String O00000oO;
    public Button mBtnBottom;
    public TextView mDebugTxt;
    public Device mDevice;
    public ImageView mImgStatusIcon;
    public gfl mPresenter;
    public TextView mTxtUpdateDesc;
    public TextView mTxtUpdateSubtitle;
    public TextView mTxtUpdateTitle;
    public BleMeshFirmwareUpdateInfo mUpdateInfo;

    enum OTAStatus {
        CHECKING,
        CHECKING_FAIL,
        READY_UPGRADE,
        FORBID_UPGRADE,
        NO_UPGRADE,
        UPGRADING,
        INSTALLING,
        OTA_SUCCESS,
        UPGRADE_FAIL
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O00000oo = sparseIntArray;
        sparseIntArray.put(-508, R.string.ble_ota_battery_low);
        O00000oo.put(3, R.string.api_tip_title);
    }

    /* renamed from: com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f8692O000000o = new int[OTAStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f8692O000000o[OTAStatus.CHECKING.ordinal()] = 1;
            f8692O000000o[OTAStatus.READY_UPGRADE.ordinal()] = 2;
            f8692O000000o[OTAStatus.UPGRADING.ordinal()] = 3;
            f8692O000000o[OTAStatus.INSTALLING.ordinal()] = 4;
            f8692O000000o[OTAStatus.NO_UPGRADE.ordinal()] = 5;
            f8692O000000o[OTAStatus.OTA_SUCCESS.ordinal()] = 6;
            f8692O000000o[OTAStatus.UPGRADE_FAIL.ordinal()] = 7;
            f8692O000000o[OTAStatus.CHECKING_FAIL.ordinal()] = 8;
            f8692O000000o[OTAStatus.FORBID_UPGRADE.ordinal()] = 9;
        }
    }

    public int getStatusIcon(OTAStatus oTAStatus) {
        switch (AnonymousClass8.f8692O000000o[oTAStatus.ordinal()]) {
            case 1:
                return R.drawable.icon_ota_checking;
            case 2:
                return R.drawable.icon_ota_ready_upgrade;
            case 3:
                return R.drawable.icon_ota_upgrading;
            case 4:
                return R.drawable.icon_ota_installing;
            case 5:
            case 6:
                return R.drawable.icon_ota_success;
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return R.drawable.icon_ota_fail;
            default:
                return 0;
        }
    }

    public View.OnClickListener getBtnClickListener(OTAStatus oTAStatus) {
        int i = AnonymousClass8.f8692O000000o[oTAStatus.ordinal()];
        if (i != 2) {
            switch (i) {
                case 5:
                case 6:
                case 9:
                    return this.f8684O000000o;
                case 7:
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return this.O00000Oo;
                default:
                    return null;
            }
        }
        return this.O00000o0;
    }

    public String getBtnText(OTAStatus oTAStatus) {
        int i = AnonymousClass8.f8692O000000o[oTAStatus.ordinal()];
        if (i == 2) {
            return getString(R.string.upgrade_new_version_upgrade);
        }
        switch (i) {
            case 5:
            case 6:
            case 9:
                return getString(R.string.confirm);
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return getString(R.string.mj_retry);
            default:
                return null;
        }
    }

    public static void invokeActivity(Context context, int i, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, BleOTAUpgradeActivity.class);
        intent.putExtra("arg_auth_type", i);
        intent.putExtra("arg_did", str2);
        intent.putExtra("arg_test_dfu_url", str);
        intent.putExtra("arg_test_version_name", str3);
        intent.putExtra("arg_test_file_md5", str4);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        setContentView((int) R.layout.ble_ota_upgrade_activity);
        this.mDebugTxt = (TextView) findViewById(R.id.txt_debug);
        this.mImgStatusIcon = (ImageView) findViewById(R.id.img_status_icon);
        this.mTxtUpdateTitle = (TextView) findViewById(R.id.txt_update_title);
        this.mTxtUpdateSubtitle = (TextView) findViewById(R.id.txt_update_subtitle);
        this.mTxtUpdateDesc = (TextView) findViewById(R.id.txt_update_desc);
        this.mBtnBottom = (Button) findViewById(R.id.btn_bottom);
        Intent intent = getIntent();
        this.O00000o = intent.getStringExtra("arg_did");
        int intExtra = intent.getIntExtra("arg_auth_type", -1);
        this.O00000oO = intent.getStringExtra("arg_test_dfu_url");
        String stringExtra = intent.getStringExtra("arg_test_file_md5");
        this.mDevice = fno.O000000o().O000000o(this.O00000o);
        String stringExtra2 = intent.getStringExtra("arg_test_version_name");
        boolean z = true;
        O000000o("init data, authType:%d, fileMd5: %s, test url: %s", Integer.valueOf(intExtra), stringExtra, this.O00000oO);
        if (this.mDevice == null || intExtra < 0) {
            finish();
            return;
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass1 */

            public final void onClick(View view) {
                BleOTAUpgradeActivity.this.onBackPressed();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        Device device = this.mDevice;
        if (device != null) {
            textView.setText(device.name);
        }
        this.mPresenter = new BleUpgradePresenter(this, this, intExtra, this.mDevice, this.O00000oO, stringExtra2, stringExtra);
        this.mUpdateInfo = ffr.O000O00o(this.mDevice.mac);
        StringBuilder sb = new StringBuilder("init data, cache update info =null is:");
        if (this.mUpdateInfo != null) {
            z = false;
        }
        sb.append(z);
        O000000o(sb.toString(), new Object[0]);
        String O00oOooo = ffr.O00oOooo(this.mDevice.mac);
        if (this.mUpdateInfo != null && !TextUtils.isEmpty(O00oOooo)) {
            O000000o("init data ,cache current version =".concat(String.valueOf(O00oOooo)), new Object[0]);
            if (this.mUpdateInfo.mcuUpdateInfo == null || !TextUtils.isEmpty(this.mUpdateInfo.mcuUpdateInfo.currentMcuVersion)) {
                O000000o(O00oOooo, this.mUpdateInfo);
                return;
            }
            O000000o("init data ,mcu version is empty, checkIfNeedUpdate ", new Object[0]);
            if (gnl.O00000Oo()) {
                checkIfNeedUpdate();
            }
        } else if (gnl.O00000Oo()) {
            checkIfNeedUpdate();
        }
    }

    private void O000000o(String str, BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo) {
        O000000o("checkUpdateInfo,currentVersion =%s, latestVersion =%s", str, bleMeshFirmwareUpdateInfo.version);
        if (this.mPresenter.O000000o() || fpo.O000000o(bleMeshFirmwareUpdateInfo.getLatestVersion(), bleMeshFirmwareUpdateInfo.getCurrentVersion(str)) > 0) {
            O000000o(OTAStatus.READY_UPGRADE, bleMeshFirmwareUpdateInfo.getCurrentVersion(str), bleMeshFirmwareUpdateInfo.getLatestVersion(), bleMeshFirmwareUpdateInfo.changeLog);
            return;
        }
        O000000o(OTAStatus.NO_UPGRADE, bleMeshFirmwareUpdateInfo.getCurrentVersion(str));
    }

    private void O000000o(final OTAStatus oTAStatus, final Object... objArr) {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass2 */

            public final void run() {
                View.OnClickListener btnClickListener = BleOTAUpgradeActivity.this.getBtnClickListener(oTAStatus);
                if (btnClickListener == null) {
                    BleOTAUpgradeActivity.this.mBtnBottom.setVisibility(4);
                    BleOTAUpgradeActivity.this.mBtnBottom.setOnClickListener(null);
                } else {
                    BleOTAUpgradeActivity.this.mBtnBottom.setVisibility(0);
                    BleOTAUpgradeActivity.this.mBtnBottom.setOnClickListener(btnClickListener);
                }
                String btnText = BleOTAUpgradeActivity.this.getBtnText(oTAStatus);
                if (!TextUtils.isEmpty(btnText)) {
                    BleOTAUpgradeActivity.this.mBtnBottom.setText(btnText);
                }
                BleOTAUpgradeActivity.this.mImgStatusIcon.setImageResource(BleOTAUpgradeActivity.this.getStatusIcon(oTAStatus));
                BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText("");
                BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText("");
                BleOTAUpgradeActivity.this.mTxtUpdateDesc.setText("");
                switch (AnonymousClass8.f8692O000000o[oTAStatus.ordinal()]) {
                    case 1:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_is_checking);
                        String O00oOooo = ffr.O00oOooo(BleOTAUpgradeActivity.this.mDevice.mac);
                        if (!TextUtils.isEmpty(O00oOooo)) {
                            TextView textView = BleOTAUpgradeActivity.this.mTxtUpdateSubtitle;
                            textView.setText(BleOTAUpgradeActivity.this.getString(R.string.app_curr_version) + O00oOooo);
                            return;
                        }
                        return;
                    case 2:
                        Object[] objArr = objArr;
                        if (objArr != null && objArr.length >= 3) {
                            String str = (String) objArr[2];
                            TextView textView2 = BleOTAUpgradeActivity.this.mTxtUpdateTitle;
                            textView2.setText(BleOTAUpgradeActivity.this.getString(R.string.list_item_latest_version) + ":" + ((String) objArr[1]));
                            TextView textView3 = BleOTAUpgradeActivity.this.mTxtUpdateSubtitle;
                            textView3.setText(BleOTAUpgradeActivity.this.getString(R.string.app_curr_version) + ((String) objArr[0]));
                            if (!TextUtils.isEmpty(str)) {
                                BleOTAUpgradeActivity.this.mTxtUpdateDesc.setText(str);
                                return;
                            }
                            return;
                        }
                        return;
                    case 3:
                        Object[] objArr2 = objArr;
                        if (objArr2 == null || objArr2.length <= 0) {
                            BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText(BleOTAUpgradeActivity.this.getString(R.string.ble_ota_upgrading));
                        } else {
                            int intValue = ((Integer) objArr2[0]).intValue();
                            TextView textView4 = BleOTAUpgradeActivity.this.mTxtUpdateTitle;
                            textView4.setText(BleOTAUpgradeActivity.this.getString(R.string.ble_ota_upgrading) + intValue + "%");
                        }
                        BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((int) R.string.ble_ota_tip1);
                        return;
                    case 4:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.update_installing);
                        BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((int) R.string.ble_ota_tip2);
                        return;
                    case 5:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_version_latest);
                        String O00oOooo2 = ffr.O00oOooo(BleOTAUpgradeActivity.this.mDevice.mac);
                        Object[] objArr3 = objArr;
                        if (objArr3 != null && objArr3.length > 0) {
                            O00oOooo2 = (String) objArr3[0];
                        }
                        if (!TextUtils.isEmpty(O00oOooo2)) {
                            TextView textView5 = BleOTAUpgradeActivity.this.mTxtUpdateSubtitle;
                            textView5.setText(BleOTAUpgradeActivity.this.getString(R.string.app_curr_version) + O00oOooo2);
                            return;
                        }
                        return;
                    case 6:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.update_success);
                        String latestVersion = BleOTAUpgradeActivity.this.mUpdateInfo != null ? BleOTAUpgradeActivity.this.mUpdateInfo.getLatestVersion() : ffr.O00oOooo(BleOTAUpgradeActivity.this.mDevice.mac);
                        if (!TextUtils.isEmpty(latestVersion)) {
                            TextView textView6 = BleOTAUpgradeActivity.this.mTxtUpdateSubtitle;
                            textView6.setText(BleOTAUpgradeActivity.this.getString(R.string.app_curr_version) + latestVersion);
                            return;
                        }
                        return;
                    case 7:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_upgrade_fail);
                        Object[] objArr4 = objArr;
                        if (objArr4 == null || objArr4.length <= 0) {
                            BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((int) R.string.update_failed_retry);
                            return;
                        } else {
                            BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((String) objArr4[0]);
                            return;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_check_fail);
                        Object[] objArr5 = objArr;
                        if (objArr5 == null || objArr5.length <= 0) {
                            BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((int) R.string.ble_ota_check_fail_tip);
                            return;
                        } else {
                            BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((String) objArr5[0]);
                            return;
                        }
                    case 9:
                        BleOTAUpgradeActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_upgrade_fail);
                        Object[] objArr6 = objArr;
                        if (objArr6 != null && objArr6.length > 0) {
                            BleOTAUpgradeActivity.this.mTxtUpdateSubtitle.setText((String) objArr6[0]);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (!gnl.O00000Oo()) {
            fqr.O000000o(this, new BleResponse() {
                /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass3 */

                public final void onResponse(int i, Object obj) {
                    if (i == 0) {
                        BleOTAUpgradeActivity.this.checkIfNeedUpdate();
                    } else {
                        BleOTAUpgradeActivity.this.finish();
                    }
                }
            });
        }
    }

    private static void O000000o(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.OTA, "Ble-OTA", str);
    }

    public void checkIfNeedUpdate() {
        O000000o(OTAStatus.CHECKING, new Object[0]);
        if (!gof.O000000o()) {
            onCheckFail(101010);
            return;
        }
        gfl gfl = this.mPresenter;
        if (gfl != null) {
            gfl.O00000Oo();
        }
    }

    public void checkBleUpdateInfo(String str, BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo) {
        if (bleMeshFirmwareUpdateInfo != null) {
            this.mUpdateInfo = bleMeshFirmwareUpdateInfo;
            O000000o(str, bleMeshFirmwareUpdateInfo);
        }
    }

    public void onUpgradeFail(int i) {
        O000000o("onUpgradeFail code=".concat(String.valueOf(i)), new Object[0]);
        if (O00000oo.get(i, -1) > 0) {
            O000000o(OTAStatus.FORBID_UPGRADE, getString(O00000oo.get(i)));
        } else if (i == 1) {
            O000000o(OTAStatus.NO_UPGRADE, new Object[0]);
        } else if (gfr.O0000Oo0) {
            O000000o(OTAStatus.UPGRADE_FAIL, new Object[0]);
        } else {
            OTAStatus oTAStatus = OTAStatus.UPGRADE_FAIL;
            O000000o(oTAStatus, getString(R.string.update_failed_retry) + ":" + OTAException.code2String(i));
        }
    }

    public void onCheckFail(int i) {
        O000000o("onCheckFail code".concat(String.valueOf(i)), new Object[0]);
        if (O00000oo.get(i, -1) > 0) {
            O000000o(OTAStatus.FORBID_UPGRADE, getString(O00000oo.get(i)));
        } else if (i == 1) {
            O000000o(OTAStatus.NO_UPGRADE, new Object[0]);
        } else if (i == 101010) {
            O000000o(OTAStatus.CHECKING_FAIL, getString(R.string.keep_phone_wifi_connect));
        } else if (gfr.O0000Oo0) {
            O000000o(OTAStatus.CHECKING_FAIL, getString(R.string.ble_combo_connect_title_loading));
        } else {
            OTAStatus oTAStatus = OTAStatus.CHECKING_FAIL;
            O000000o(oTAStatus, getString(R.string.ble_combo_connect_title_loading) + "\n" + OTAException.code2String(i));
        }
    }

    public void onUpgrading() {
        O000000o("onUpgrading", new Object[0]);
        O000000o(OTAStatus.UPGRADING, new Object[0]);
    }

    public void showProgress(int i) {
        O000000o(OTAStatus.UPGRADING, Integer.valueOf(i));
    }

    public void onInstalling() {
        O000000o("onInstalling", new Object[0]);
        O000000o(OTAStatus.INSTALLING, new Object[0]);
    }

    public void onSuccess() {
        O000000o(OTAStatus.OTA_SUCCESS, new Object[0]);
    }

    public void onBackPressed() {
        gfl gfl = this.mPresenter;
        if (gfl == null || !gfl.O0000OOo()) {
            super.onBackPressed();
        } else {
            new MLAlertDialog.Builder(this).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$BleOTAUpgradeActivity$3s8rudnymY503iiUUT9Eh_WhGZk */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BleOTAUpgradeActivity.this.O000000o(dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.ble_mesh_upgrade_cancel).O00000Oo(true).O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        finish();
    }

    public void showLog(final String str) {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.update.ui.BleOTAUpgradeActivity.AnonymousClass7 */

            public final void run() {
                if (BleOTAUpgradeActivity.this.mPresenter.O000000o()) {
                    BleOTAUpgradeActivity.this.mDebugTxt.setVisibility(0);
                    String charSequence = BleOTAUpgradeActivity.this.mDebugTxt.getText().toString();
                    TextView textView = BleOTAUpgradeActivity.this.mDebugTxt;
                    textView.setText(charSequence + "\n" + str);
                    return;
                }
                BleOTAUpgradeActivity.this.mDebugTxt.setVisibility(8);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        gfl gfl = this.mPresenter;
        if (gfl != null) {
            gfl.O0000O0o();
        }
    }
}

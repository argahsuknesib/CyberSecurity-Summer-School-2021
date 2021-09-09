package com.xiaomi.smarthome.camera.v4.utils;

import _m_j.cid;
import _m_j.fsp;
import _m_j.ftn;
import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.FirmwareUpdateResult;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class UpdateFirmwareHelper {
    public MLAlertDialog dialog;
    boolean isDialogShowing = false;
    boolean isShowed = false;
    boolean lastIsForce = false;
    boolean lastIsUpdating = false;
    boolean lastShouldUpdated = false;
    Activity mActivity;

    public UpdateFirmwareHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void fetchFirmwareUpdateInfo(final cid cid) {
        Activity activity;
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && cid != null && (activity = this.mActivity) != null) {
            cid.O000000o(activity.getApplicationContext(), new Callback<FirmwareUpdateResult>() {
                /* class com.xiaomi.smarthome.camera.v4.utils.UpdateFirmwareHelper.AnonymousClass1 */

                public void onFailure(int i, String str) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[ADDED_TO_REGION] */
                public void onSuccess(FirmwareUpdateResult firmwareUpdateResult) {
                    boolean z;
                    boolean z2;
                    if (UpdateFirmwareHelper.this.mActivity != null && !UpdateFirmwareHelper.this.mActivity.isFinishing()) {
                        boolean z3 = firmwareUpdateResult.force;
                        if (firmwareUpdateResult.rec || z3) {
                            String str = firmwareUpdateResult.latest;
                            if (firmwareUpdateResult.isLatest || firmwareUpdateResult.latest.equals(firmwareUpdateResult.curr) || firmwareUpdateResult.updating) {
                                if (TextUtils.equals(firmwareUpdateResult.ota_status, "downloading") || TextUtils.equals(firmwareUpdateResult.ota_status, "downloaded") || TextUtils.equals(firmwareUpdateResult.ota_status, "installing")) {
                                    z = false;
                                    z2 = true;
                                    if (System.currentTimeMillis() - cid.O00000oO().O00000o0.getLong("mh_firmware_last_op_time", 0) < 600000 || z3) {
                                        UpdateFirmwareHelper updateFirmwareHelper = UpdateFirmwareHelper.this;
                                        updateFirmwareHelper.isShowed = true;
                                        updateFirmwareHelper.handleUpgradeDialog(z, z2, z3, str, cid);
                                    }
                                    return;
                                }
                            } else if (!TextUtils.equals(firmwareUpdateResult.ota_status, "failed")) {
                                z = true;
                                z2 = false;
                                if (System.currentTimeMillis() - cid.O00000oO().O00000o0.getLong("mh_firmware_last_op_time", 0) < 600000) {
                                }
                                UpdateFirmwareHelper updateFirmwareHelper2 = UpdateFirmwareHelper.this;
                                updateFirmwareHelper2.isShowed = true;
                                updateFirmwareHelper2.handleUpgradeDialog(z, z2, z3, str, cid);
                            }
                            z = false;
                            z2 = false;
                            if (System.currentTimeMillis() - cid.O00000oO().O00000o0.getLong("mh_firmware_last_op_time", 0) < 600000) {
                            }
                            UpdateFirmwareHelper updateFirmwareHelper22 = UpdateFirmwareHelper.this;
                            updateFirmwareHelper22.isShowed = true;
                            updateFirmwareHelper22.handleUpgradeDialog(z, z2, z3, str, cid);
                        } else if (UpdateFirmwareHelper.this.dialog != null && UpdateFirmwareHelper.this.dialog.isShowing()) {
                            UpdateFirmwareHelper.this.dialog.dismiss();
                        }
                    }
                }
            });
        }
    }

    public void handleUpgradeDialog(boolean z, boolean z2, boolean z3, String str, final cid cid) {
        String str2;
        final boolean z4;
        String str3;
        String str4;
        if (z3) {
            if (z2) {
                String string = this.mActivity.getString(R.string.firmwareUpgradeForceUpdating);
                str3 = this.mActivity.getString(R.string.go_look_at);
                z4 = true;
                String str5 = string;
                str4 = this.mActivity.getString(R.string.quit);
                str2 = str5;
            } else if (z) {
                String string2 = this.mActivity.getString(R.string.firmwareUpgradeForceUpdate);
                z4 = true;
                String string3 = this.mActivity.getString(R.string.firmwareUpgradeUpdate);
                str4 = this.mActivity.getString(R.string.quit);
                str2 = string2;
                str3 = string3;
            } else {
                return;
            }
        } else if (!z2 && z && !TextUtils.isEmpty(str)) {
            str2 = this.mActivity.getString(R.string.firmwareUpgradeNew_pre) + str + this.mActivity.getString(R.string.firmwareUpgradeNew_sub);
            str3 = this.mActivity.getString(R.string.firmwareUpgradeUpdate);
            str4 = this.mActivity.getString(R.string.cs_cancel);
            z4 = false;
        } else {
            return;
        }
        MLAlertDialog mLAlertDialog = this.dialog;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            if (this.lastIsForce != z3 || this.lastIsUpdating != z2 || this.lastShouldUpdated != z) {
                MLAlertDialog mLAlertDialog2 = this.dialog;
                if (mLAlertDialog2 != null) {
                    mLAlertDialog2.dismiss();
                }
            } else {
                return;
            }
        }
        this.lastIsForce = z3;
        this.lastIsUpdating = z2;
        this.lastShouldUpdated = z;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this.mActivity);
        builder.O000000o(str2);
        builder.O00000Oo(str4, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.utils.UpdateFirmwareHelper.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (UpdateFirmwareHelper.this.mActivity != null && !UpdateFirmwareHelper.this.mActivity.isFinishing() && z4) {
                    UpdateFirmwareHelper.this.mActivity.finish();
                }
            }
        });
        builder.O000000o(str3, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.utils.UpdateFirmwareHelper.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (UpdateFirmwareHelper.this.mActivity != null && !UpdateFirmwareHelper.this.mActivity.isFinishing()) {
                    fsp.O000000o().O0000Oo.goUpdateActivity(UpdateFirmwareHelper.this.mActivity, cid.getDid());
                }
            }
        });
        builder.O000000o(!z3);
        this.dialog = builder.O00000o();
        this.dialog.show();
        cid.O00000oO().O00000o0.edit().putLong("mh_firmware_last_op_time", System.currentTimeMillis()).apply();
    }
}

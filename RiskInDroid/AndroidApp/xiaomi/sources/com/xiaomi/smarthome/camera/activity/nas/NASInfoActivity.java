package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.chr;
import _m_j.cin;
import _m_j.cit;
import _m_j.civ;
import _m_j.gqg;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Calendar;
import org.json.JSONArray;

public class NASInfoActivity extends CameraBaseActivity implements View.OnClickListener {
    private int REQUEST_NAS_DIR = 1002;
    private int REQUEST_NAS_EDIT = 1001;
    ImageView ivCameraStoreIcon;
    TextView latestLogInfoTv;
    public int mCycleTime = 0;
    SettingsItemView mCycleTimeItem;
    public int mLastCycleTime = 0;
    public int mLastSyncInterval = 0;
    public NASInfo mNASInfo = null;
    private SettingsItemView mNASName;
    SettingsItemView mSivVideoStorage;
    public int mSyncInterval = 0;
    SettingsItemView mUpdateTimeIntervalItem;
    public XQProgressDialog mXQProgressDialog;
    TextView pauseResumeTv;
    XQProgressDialog progressDialog;
    ImageView statusIconIv;
    ImageView titleBarReturn;
    TextView transferStatusTv;
    public int type;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_nas_info);
        findViewById(R.id.title_bar_more).setVisibility(8);
        initView();
        initProgressDialog();
        if (this.mCameraDevice.O0000oO0().O00000o != null) {
            this.mNASInfo = this.mCameraDevice.O0000oO0().O00000o;
            updateView();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("is_from_rn", false);
            NASInfo nASInfo = (NASInfo) intent.getParcelableExtra("nasInfo");
            if (booleanExtra && nASInfo != null) {
                this.mNASInfo = nASInfo;
            }
        }
        if (this.mNASInfo != null) {
            updateView();
        }
    }

    public void onResume() {
        super.onResume();
        loadNASServerInfo();
    }

    private void initView() {
        this.titleBarReturn = (ImageView) findViewById(R.id.title_bar_return);
        this.statusIconIv = (ImageView) findViewById(R.id.status_icon_iv);
        this.ivCameraStoreIcon = (ImageView) findViewById(R.id.iv_camera_store_icon);
        this.ivCameraStoreIcon.setImageResource(this.isV4 ? R.drawable.camera_v4_store_icon_camera_nor : R.drawable.camera_store_icon_camera_nor);
        this.transferStatusTv = (TextView) findViewById(R.id.transfer_status_tv);
        this.latestLogInfoTv = (TextView) findViewById(R.id.latest_log_info_tv);
        this.pauseResumeTv = (TextView) findViewById(R.id.pause_storage_rl);
        this.mSivVideoStorage = (SettingsItemView) findViewById(R.id.sivVideoStorage);
        this.mCycleTimeItem = (SettingsItemView) findViewById(R.id.setting_smb_time);
        this.mUpdateTimeIntervalItem = (SettingsItemView) findViewById(R.id.setting_nas_sync_interval);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setttings_route_backup_title);
        this.mSivVideoStorage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NASInfoActivity.this.toggleNASStorageStatus();
            }
        });
        this.mCycleTimeItem.setOnClickListener(this);
        this.mUpdateTimeIntervalItem.setOnClickListener(this);
        this.pauseResumeTv.setOnClickListener(this);
        this.titleBarReturn.setOnClickListener(this);
        this.mNASName = (SettingsItemView) findViewById(R.id.modify_setting_rl);
        findViewById(R.id.delete_storage_rl).setOnClickListener(this);
        this.mNASName.setOnClickListener(this);
        findViewById(R.id.clear_uploaded_rl).setOnClickListener(this);
        findViewById(R.id.browser_uploaded_video_rl).setOnClickListener(this);
    }

    public void loadNASServerInfo() {
        if (this.mHandler != null) {
            this.mXQProgressDialog.show();
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.nas.$$Lambda$NASInfoActivity$1Kpe4oXFsPDKeOvFZR8Jzx9PGlE */

                public final void run() {
                    NASInfoActivity.this.lambda$loadNASServerInfo$0$NASInfoActivity();
                }
            }, 500);
        }
    }

    public /* synthetic */ void lambda$loadNASServerInfo$0$NASInfoActivity() {
        this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass2 */

            public void onSuccess(NASInfo nASInfo) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                    nASInfoActivity.mNASInfo = nASInfoActivity.mCameraDevice.O0000oO0().O00000o;
                    if (NASInfoActivity.this.mXQProgressDialog.isShowing()) {
                        NASInfoActivity.this.mXQProgressDialog.dismiss();
                    }
                    NASInfoActivity.this.updateView();
                    if (nASInfo.O00000o == 0) {
                        NASInfoActivity nASInfoActivity2 = NASInfoActivity.this;
                        nASInfoActivity2.startActivity(new Intent(nASInfoActivity2, NASDiscoveryActivity.class));
                        NASInfoActivity.this.finish();
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!NASInfoActivity.this.isFinishing()) {
                    civ.O00000o0("CameraPlay", " loadNAS fail " + i + " : " + str);
                    if (NASInfoActivity.this.mXQProgressDialog.isShowing()) {
                        NASInfoActivity.this.mXQProgressDialog.dismiss();
                    }
                    NASInfoActivity.this.showRetryGetNASDialog();
                }
            }
        });
    }

    public void showRetryGetNASDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.get_smb_info_fail_title).O00000Oo((int) R.string.get_smb_info_fail_title).O00000Oo((int) R.string.get_smb_info_fail_neg_btn, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                NASInfoActivity.this.finish();
            }
        }).O000000o((int) R.string.get_smb_info_fail_pos_btn, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                NASInfoActivity.this.loadNASServerInfo();
            }
        });
        builder.O00000o().show();
    }

    public static String getReadableDateTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        String alignedDateTimeField = getAlignedDateTimeField(instance.get(2) + 1);
        String alignedDateTimeField2 = getAlignedDateTimeField(instance.get(5));
        return (i + "/" + alignedDateTimeField + "/" + alignedDateTimeField2) + " " + (getAlignedDateTimeField(instance.get(11)) + ":" + getAlignedDateTimeField(instance.get(12)));
    }

    private static String getAlignedDateTimeField(int i) {
        return i < 10 ? "0".concat(String.valueOf(i)) : String.valueOf(i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (this.REQUEST_NAS_EDIT == i) {
            updateTransferStatus();
        } else if (this.REQUEST_NAS_DIR == i) {
            updateTransferStatus();
            TextUtils.isEmpty(this.mCameraDevice.O0000oO0().O00000o.O000000o());
        }
    }

    public void updateView() {
        NASInfo nASInfo = this.mNASInfo;
        if (nASInfo != null) {
            if (nASInfo.O00000o0 == 0) {
                this.latestLogInfoTv.setVisibility(8);
            } else {
                this.latestLogInfoTv.setVisibility(0);
                this.latestLogInfoTv.setText(getString(R.string.smb_latest_write_time, new Object[]{getReadableDateTime(this.mNASInfo.O00000o0 * 1000)}));
            }
            if (this.mNASInfo.O00000o == 3 || this.mNASInfo.O00000o == 1) {
                this.mSivVideoStorage.setChecked(true);
            } else {
                this.mSivVideoStorage.setChecked(false);
            }
            this.mLastCycleTime = this.mNASInfo.O00000Oo;
            this.mCycleTimeItem.setInfo(cin.O00000Oo(getResources(), this.mLastCycleTime));
            if (this.mNASInfo.O00000oo != null) {
                this.mNASName.setInfo(this.mNASInfo.O00000oo.f5188O000000o);
            }
            this.mLastSyncInterval = this.mNASInfo.f5186O000000o;
            this.mUpdateTimeIntervalItem.setInfo(cin.O00000o0(getResources(), this.mLastSyncInterval));
            updateTransferStatus();
        }
    }

    private void updateTransferStatus() {
        NASInfo nASInfo = this.mNASInfo;
        if (nASInfo != null) {
            if (nASInfo.O00000oO == 0) {
                int i = this.mNASInfo.O00000o;
                if (i == 1) {
                    this.transferStatusTv.setText((int) R.string.nas_transfer_status_ready);
                    this.pauseResumeTv.setText((int) R.string.smb_transfer_op_pause);
                    return;
                } else if (i == 2) {
                    this.transferStatusTv.setText((int) R.string.smb_transfer_status_pause);
                    this.statusIconIv.setImageResource(R.drawable.camera_smb_animation_pause);
                    this.pauseResumeTv.setText((int) R.string.smb_transfer_op_resume);
                    return;
                } else if (i == 3) {
                    this.transferStatusTv.setText((int) R.string.smb_transfer_status_normal);
                    this.pauseResumeTv.setText((int) R.string.smb_transfer_op_pause);
                    this.statusIconIv.setImageResource(R.drawable.camera_anim_transfering);
                    ((AnimationDrawable) this.statusIconIv.getDrawable()).start();
                    return;
                } else if (i != 4) {
                    return;
                }
            }
            this.transferStatusTv.setText((int) R.string.smb_transfer_status_error);
            this.statusIconIv.setImageResource(R.drawable.camera_smb_animation_error);
            this.pauseResumeTv.setText((int) R.string.smb_transfer_op_pause);
        }
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.modify_setting_rl) {
            Intent intent = new Intent(this, NASSettingActivity.class);
            intent.putExtra("data", this.mNASInfo);
            startActivity(intent);
        } else if (id != R.id.browser_uploaded_video_rl && id != R.id.pause_storage_rl) {
            if (id == R.id.clear_uploaded_rl) {
                showClearStorageDirDialog();
            } else if (id == R.id.delete_storage_rl) {
                showDeleteNASDialog();
            } else if (id == R.id.setting_smb_time) {
                showSetTime();
            } else if (id == R.id.setting_nas_sync_interval) {
                showSyncIntervalDialog();
            }
        }
    }

    private void showSetTime() {
        int i;
        this.mCycleTime = this.mLastCycleTime;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        int i2 = this.mLastCycleTime;
        if (i2 != 86400) {
            if (i2 == 604800) {
                i = 0;
            } else if (i2 == 2592000) {
                i = 1;
            } else if (i2 != 7776000) {
                if (i2 == 15552000) {
                    i = 3;
                } else if (i2 == 31104000) {
                    i = 4;
                }
            }
            builder.O000000o(new String[]{getResources().getString(R.string.nas_recycle_week), getResources().getString(R.string.nas_recycle_month), getResources().getString(R.string.nas_recycle_3_months), getResources().getString(R.string.nas_recycle_6_months), getResources().getString(R.string.nas_recycle_12_months)}, i, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                    nASInfoActivity.type = i + 1;
                    if (i == 0) {
                        nASInfoActivity.mCycleTime = 604800;
                    } else if (i == 1) {
                        nASInfoActivity.mCycleTime = 2592000;
                    } else if (i == 2) {
                        nASInfoActivity.mCycleTime = 7776000;
                    } else if (i == 3) {
                        nASInfoActivity.mCycleTime = 15552000;
                    } else if (i == 4) {
                        nASInfoActivity.mCycleTime = 31104000;
                    }
                }
            });
            builder.O000000o((int) R.string.nas_setting_retention_time);
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass6 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (NASInfoActivity.this.progressDialog == null) {
                        NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                        nASInfoActivity.progressDialog = new XQProgressDialog(nASInfoActivity);
                    }
                    NASInfoActivity.this.progressDialog.show();
                    NASInfoActivity.this.mNASInfo.O00000Oo = NASInfoActivity.this.mCycleTime;
                    chr.O000000o("u5v.u1o.4k5.1m3", "type", Integer.valueOf(NASInfoActivity.this.type));
                    NASInfoActivity.this.mCameraDevice.O0000oO0().O000000o(NASInfoActivity.this.mNASInfo, new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass6.AnonymousClass1 */

                        public void onSuccess(Object obj) {
                            if (!NASInfoActivity.this.isFinishing()) {
                                NASInfoActivity.this.mLastCycleTime = NASInfoActivity.this.mCycleTime;
                                NASInfoActivity.this.mCycleTimeItem.setInfo(cin.O00000Oo(NASInfoActivity.this.getResources(), NASInfoActivity.this.mCycleTime));
                                NASInfoActivity.this.progressDialog.dismiss();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!NASInfoActivity.this.isFinishing()) {
                                gqg.O000000o((int) R.string.set_failed);
                                NASInfoActivity.this.progressDialog.dismiss();
                            }
                        }
                    });
                    dialogInterface.dismiss();
                }
            });
            builder.O00000oo();
        }
        i = 2;
        builder.O000000o(new String[]{getResources().getString(R.string.nas_recycle_week), getResources().getString(R.string.nas_recycle_month), getResources().getString(R.string.nas_recycle_3_months), getResources().getString(R.string.nas_recycle_6_months), getResources().getString(R.string.nas_recycle_12_months)}, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                nASInfoActivity.type = i + 1;
                if (i == 0) {
                    nASInfoActivity.mCycleTime = 604800;
                } else if (i == 1) {
                    nASInfoActivity.mCycleTime = 2592000;
                } else if (i == 2) {
                    nASInfoActivity.mCycleTime = 7776000;
                } else if (i == 3) {
                    nASInfoActivity.mCycleTime = 15552000;
                } else if (i == 4) {
                    nASInfoActivity.mCycleTime = 31104000;
                }
            }
        });
        builder.O000000o((int) R.string.nas_setting_retention_time);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (NASInfoActivity.this.progressDialog == null) {
                    NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                    nASInfoActivity.progressDialog = new XQProgressDialog(nASInfoActivity);
                }
                NASInfoActivity.this.progressDialog.show();
                NASInfoActivity.this.mNASInfo.O00000Oo = NASInfoActivity.this.mCycleTime;
                chr.O000000o("u5v.u1o.4k5.1m3", "type", Integer.valueOf(NASInfoActivity.this.type));
                NASInfoActivity.this.mCameraDevice.O0000oO0().O000000o(NASInfoActivity.this.mNASInfo, new Callback<Object>() {
                    /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass6.AnonymousClass1 */

                    public void onSuccess(Object obj) {
                        if (!NASInfoActivity.this.isFinishing()) {
                            NASInfoActivity.this.mLastCycleTime = NASInfoActivity.this.mCycleTime;
                            NASInfoActivity.this.mCycleTimeItem.setInfo(cin.O00000Oo(NASInfoActivity.this.getResources(), NASInfoActivity.this.mCycleTime));
                            NASInfoActivity.this.progressDialog.dismiss();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!NASInfoActivity.this.isFinishing()) {
                            gqg.O000000o((int) R.string.set_failed);
                            NASInfoActivity.this.progressDialog.dismiss();
                        }
                    }
                });
                dialogInterface.dismiss();
            }
        });
        builder.O00000oo();
    }

    private void showSyncIntervalDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        int i = this.mLastSyncInterval;
        builder.O000000o(new String[]{getResources().getString(R.string.nas_sync_interval_real_time), getResources().getString(R.string.nas_sync_interval_1_hour), getResources().getString(R.string.nas_sync_interval_1_day)}, i == 300 ? 0 : i == 3600 ? 1 : i == 86400 ? 2 : 3, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass7 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    NASInfoActivity.this.mSyncInterval = 300;
                } else if (i == 1) {
                    NASInfoActivity.this.mSyncInterval = 3600;
                } else if (i == 2) {
                    NASInfoActivity.this.mSyncInterval = 86400;
                } else if (i == 3) {
                    NASInfoActivity.this.mSyncInterval = 300;
                }
            }
        });
        builder.O000000o((int) R.string.smb_setting_nas_sync_interval);
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass8 */

            public void onClick(DialogInterface dialogInterface, int i) {
                if (NASInfoActivity.this.progressDialog == null) {
                    NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                    nASInfoActivity.progressDialog = new XQProgressDialog(nASInfoActivity);
                }
                NASInfoActivity.this.progressDialog.show();
                NASInfoActivity.this.mNASInfo.f5186O000000o = NASInfoActivity.this.mSyncInterval;
                NASInfoActivity.this.mCameraDevice.O0000oO0().O000000o(NASInfoActivity.this.mNASInfo, new Callback<Object>() {
                    /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass8.AnonymousClass1 */

                    public void onSuccess(Object obj) {
                        if (!NASInfoActivity.this.isFinishing()) {
                            NASInfoActivity.this.mLastSyncInterval = NASInfoActivity.this.mSyncInterval;
                            NASInfoActivity.this.mUpdateTimeIntervalItem.setInfo(cin.O00000o0(NASInfoActivity.this.getResources(), NASInfoActivity.this.mSyncInterval));
                            NASInfoActivity.this.progressDialog.dismiss();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!NASInfoActivity.this.isFinishing()) {
                            gqg.O000000o((int) R.string.set_failed);
                            NASInfoActivity.this.progressDialog.dismiss();
                        }
                    }
                });
                dialogInterface.dismiss();
            }
        });
        builder.O00000oo();
    }

    private void showDeleteNASDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.smb_dialog_delete_smb_title).O00000Oo((int) R.string.smb_dialog_delete_smb_msg).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass9 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                NASInfoActivity.this.deleteNAS();
            }
        });
        builder.O00000o().show();
    }

    public void deleteNAS() {
        this.mXQProgressDialog.show();
        cit O0000oO0 = this.mCameraDevice.O0000oO0();
        O0000oO0.O00000o0.O000000o("nas_reset", new JSONArray(), new Callback<Object>(new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass10 */

            public void onSuccess(Object obj) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.action_success);
                    NASInfoActivity.this.finish();
                }
            }

            public void onFailure(int i, String str) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.action_fail);
                }
            }
        }) {
            /* class _m_j.cit.AnonymousClass8 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f13925O000000o;

            {
                this.f13925O000000o = r2;
            }

            public final void onFailure(int i, String str) {
                Callback callback = this.f13925O000000o;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final void onSuccess(Object obj) {
                Callback callback = this.f13925O000000o;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        });
    }

    public void toggleNASStorageStatus() {
        civ.O000000o("NASInfoActivity", "toggleNASStorageStatus");
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass11 */

            public void onSuccess(NASInfo nASInfo) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity nASInfoActivity = NASInfoActivity.this;
                    nASInfoActivity.mNASInfo = nASInfoActivity.mCameraDevice.O0000oO0().O00000o;
                    final int i = nASInfo.O00000o;
                    if (i == 2) {
                        i = 3;
                    } else if (i == 3 || i == 1) {
                        i = 2;
                    }
                    nASInfo.O00000o = i;
                    NASInfoActivity.this.mCameraDevice.O0000oO0().O000000o(nASInfo, new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass11.AnonymousClass1 */

                        public void onSuccess(Object obj) {
                            if (!NASInfoActivity.this.isFinishing()) {
                                NASInfoActivity.this.mXQProgressDialog.dismiss();
                                NASInfoActivity.this.mNASInfo.O00000o = i;
                                NASInfoActivity.this.updateView();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!NASInfoActivity.this.isFinishing()) {
                                NASInfoActivity.this.mXQProgressDialog.dismiss();
                                gqg.O000000o((int) R.string.action_fail);
                            }
                        }
                    });
                }
            }

            public void onFailure(int i, String str) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.action_fail);
                }
            }
        });
    }

    private void showClearStorageDirDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.smb_dialog_clear_dir_title).O00000Oo((int) R.string.smb_dialog_clear_dir_msg).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass12 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                NASInfoActivity.this.clearNASVideo();
            }
        });
        builder.O00000o().show();
    }

    public void clearNASVideo() {
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O00000Oo(new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity.AnonymousClass13 */

            public void onSuccess(Object obj) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.action_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!NASInfoActivity.this.isFinishing()) {
                    NASInfoActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.action_fail);
                }
            }
        });
    }

    public void finish() {
        super.finish();
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mXQProgressDialog.dismiss();
        }
    }
}
